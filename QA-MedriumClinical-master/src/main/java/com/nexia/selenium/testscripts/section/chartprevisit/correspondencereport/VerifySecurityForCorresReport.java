package com.nexia.selenium.testscripts.section.chartprevisit.correspondencereport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityForCorresReport extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","Regression","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "VerifySecurityOption";
		corresData.testCaseId = "TC_VSP_014";
		corresData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
    }

	@Test(groups = {"Regression","SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "VerifySecurityOption";
		corresData.testCaseId = "TC_VSP_015";
		corresData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	@Test(groups = {"SingleThread","Approved","Regression","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "VerifySecurityOption";
		corresData.testCaseId = "TC_VSP_016";
		corresData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	@Test(groups = {"SingleThread","Approved","Regression","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "VerifySecurityOption";
		corresData.testCaseId = "TC_VSP_017";
		corresData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-2: Switch role to full Access
		//--------------------------------------------------------------------//
		String switchRole="Full";
		assertTrue(switchRole(selenium,switchRole),"Could not change the switch role;More Details:"+corresData.toString(),selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		// No Access User
		
		if(corresData.testCaseId.equals("TC_VSP_016")){
			assertTrue(switchRole(selenium,corresData.switchRole),"Could not change the switch role;More Details:"+corresData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium); 
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			assertTrue(!isElementPresent(selenium, QueeCorrespondenace),"Correspondence queue should not be present for no access", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnErrorClose))
			{
				click(selenium,btnErrorClose);
			}
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search the patient"+corresData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium, lnkMore),"MOre tab should not be present for user", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);		
		return true;	
		}
		
		//--------------------------------------------------------------------//
		//  Step-3:Create correspondence report
		//--------------------------------------------------------------------//
		assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		ChartPreVisitLib CorresData1 = new ChartPreVisitLib();
		CorresData1.workSheetName = "CreateCorresReport";
		CorresData1.testCaseId = "TC_CCR_001";
		CorresData1.fetchChartPreVisitTestData();	
		CorresData1.patientId=corresData.patientId;
		System.out.println(	CorresData1.patientId);
		System.out.println(	corresData.patientId);
		assertTrue(CreateCorrespondenceReport(selenium,CorresData1,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
        waitForPageLoad(selenium);		
        assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);		
		
		//--------------------------------------------------------------------//
		//  Step-4: Verify security 
		//--------------------------------------------------------------------//
		assertTrue(verifySecurity(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
		
		

		return true;
	}

	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib corresData,String userAccount) throws IOException
	{
		if(corresData.testCaseId.equals("TC_VSP_014")){
			assertTrue(switchRole(selenium,corresData.switchRole),"Could not change the switch role;More Details:"+corresData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search the patient"+corresData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblFirstCorresReport),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementVisible(selenium, btncorressign),"System should not have sign button in limited access", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEncounterAction ),"Could not click Action button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium, btnDeleteCorres),"System should not have sign button in limited access", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);		
		return true;
	}
		
		if(corresData.testCaseId.equals("TC_VSP_015")){
			
			assertTrue(switchRole(selenium,corresData.switchRole),"Could not change the switch role;More Details:"+corresData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search the patient"+corresData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblFirstCorresReport),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementVisible(selenium,lnkEncounterAction ),"Action button should not be visible", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementVisible(selenium, btncorressign),"sign button should not be visible", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(!isElementVisible(selenium, elementReportCommentsIcon),"Add comment button should not be visible", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);			
			return true;
		}
		if(corresData.testCaseId.equals("TC_VSP_017")){
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search the patient"+corresData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblFirstCorresReport),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementVisible(selenium,lnkEncounterAction ),"Action button should not be visible", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementVisible(selenium, btncorressign),"sign button should not be visible", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(isElementVisible(selenium, elementReportCommentsIcon),"Add comment button should not be visible", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);			
			return true;
		}
		
		
		return true;
		}
}
