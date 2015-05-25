package com.nexia.selenium.testscripts.section.chartprevisit.diagnostictestreport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForDIReport extends AbstractChartPreVisit{

	@Test(groups = {"AdvancedSmoke","SingleThread","Approved","Regression","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_020";
		diData.fetchChartPreVisitTestData();		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
    }

	@Test(groups = {"Regression","SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_022";
		diData.fetchChartPreVisitTestData();		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	
	@Test(groups = {"SingleThread","Approved","Regression","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_021";
		diData.fetchChartPreVisitTestData();		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	
	@Test(groups = {"SingleThread","Approved","Regression","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_019";
		diData.fetchChartPreVisitTestData();		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib diData) throws IOException{
				Selenium selenium=null;
				
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + diData.toString());
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, diData.userName, diData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-2: Switch role to full Access
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,diData.switchRole),"Could not change the switch role;More Details:"+diData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				// No Access User		
						if(diData.testCaseId.equals("TC_CDR_021")){
							
							assertTrue(switchRole(selenium,diData.switchRole),"Could not change the switch role;More Details:"+diData.toString(),selenium,ClassName,MethodName);
							waitForPageLoad(selenium);
							assertTrue(!isElementPresent(selenium, queDiagnosticReport),"Diagnostic Report queue should not be present for no access", selenium, ClassName,MethodName);
							waitForPageLoad(selenium);	
							if(isElementPresent(selenium, btnErrorClose))
								assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
							assertTrue(searchPatientNexiaForProviderHomePage(selenium,diData.patientId),"Could not search the patient"+diData.toString(),selenium,ClassName,MethodName);
							waitForPageLoad(selenium);
							assertTrue(!isElementPresent(selenium, lnkMore),"MOre tab should not be present for user", selenium, ClassName,MethodName);
							waitForPageLoad(selenium);	
							
							return true;
						}
				//--------------------------------------------------------------------//
				//  Step-3: Navigate to Diagnostic Report
				//--------------------------------------------------------------------//			
				
				assertTrue(navigateToCorresReport(selenium,diData),"Could not Navigate to File document",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				
				//--------------------------------------------------------------------//
				//  Step-4 :Diagnostic  Report for the  patient 
				//--------------------------------------------------------------------//
			
				assertTrue(CreateDiagnosticReport(selenium,diData,userAccount),"Creation of Diagnostic  Report failed ", selenium, ClassName,MethodName);  
		        waitForPageLoad(selenium);	
				
		        assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				//--------------------------------------------------------------------//
				//  Step-5 :Verify Various options Security 
				//--------------------------------------------------------------------//
			
				assertTrue(verifySecurity(selenium,diData,userAccount),"Verification failed ", selenium, ClassName,MethodName);  
				
				
	return true;
}
	
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib diData ,String userAccount) throws IOException
	{
		
		//Full
		if(diData.testCaseId.equals("TC_CDR_019")){
			
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,diData.patientId),"Search patient failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkDiagnosticReports),"Could not click Diagnostic link report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, elementLabReportEntry1),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementVisible(selenium,lnkEncounterAction ),"Action button should not be visible", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementVisible(selenium, btncorressign),"sign button should not be visible", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(isElementVisible(selenium, elementReportCommentsIcon),"Add comment button should not be visible", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);		
			
		}
		//Limited
		
if(diData.testCaseId.equals("TC_CDR_020")){
	ChartPreVisitLib corresData = new ChartPreVisitLib();	
	corresData.workSheetName = "VerifySecurityOption";
	corresData.testCaseId = "TC_VSP_001";
	corresData.fetchChartPreVisitTestData();
	assertTrue(switchRole(selenium,corresData.switchRole),"Could not change the switch role;More Details:"+diData.toString(),selenium,ClassName,MethodName);
	assertTrue(searchPatientNexiaForProviderHomePage(selenium,diData.patientId),"Search patient failed", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
	assertTrue(click(selenium,lnkDiagnosticReports),"Could not click Diagnostic link report", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	assertTrue(click(selenium, elementLabReportEntry1),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	assertTrue(!isElementVisible(selenium, btncorressign),"System should not have sign button in limited access", selenium, ClassName,MethodName);
	assertTrue(click(selenium,lnkEncounterAction ),"Could not click Action button", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	assertTrue(!isElementPresent(selenium, btnDeleteCorres),"System should not have sign button in limited access", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);	
		}	
	
	//view only
	if(diData.testCaseId.equals("TC_CDR_022")){
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "VerifySecurityOption";
		corresData.testCaseId = "TC_VSP_002";
		corresData.fetchChartPreVisitTestData();		
		assertTrue(switchRole(selenium,corresData.switchRole),"Could not change the switch role;More Details:"+diData.toString(),selenium,ClassName,MethodName);
		assertTrue(searchPatientNexiaForProviderHomePage(selenium,diData.patientId),"Search patient failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkDiagnosticReports),"Could not click Diagnostic link report", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, elementLabReportEntry1),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);		
		assertTrue(!isElementVisible(selenium,lnkEncounterAction ),"Action button should not be visible", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(!isElementVisible(selenium, btncorressign),"sign button should not be visible", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);			
		assertTrue(!isElementVisible(selenium, elementReportCommentsIcon),"Add comment button should not be visible", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);			
	}
		
	return true;
	
}
	
	
	
	
	
	
	
	
	
}