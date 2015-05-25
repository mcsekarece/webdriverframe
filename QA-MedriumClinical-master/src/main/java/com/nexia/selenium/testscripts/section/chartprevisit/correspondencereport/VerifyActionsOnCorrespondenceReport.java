package com.nexia.selenium.testscripts.section.chartprevisit.correspondencereport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyActionsOnCorrespondenceReport extends AbstractChartPreVisit{

	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteActionForSignedReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_001";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteActionForUnSignedReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_002";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyForwardAction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_003";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}

	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyForwardCancelAction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_004";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHIstoryAction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_005";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}

	
	
	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
	
		try
		{			
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
		//--------------------------------------------------------------------//
		//  Step-2: verify Correspondence Queue  Panel  //
		//--------------------------------------------------------------------//	
		assertTrue(goToRegisterPatient(selenium),"Could not navigated to register patient",selenium, ClassName, MethodName);	
		waitForPageLoad(selenium);
		ChartPreVisitLib patientData = new ChartPreVisitLib();
		patientData.workSheetName = "NewPatientCheckIn";
		patientData.testCaseId = "TC_NP_007";
		patientData.fetchChartPreVisitTestData();		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dateFormat=new SimpleDateFormat("MMMdd,yyyyHHmm:ss");
		String date=dateFormat.format(cal.getTime());
		patientData.lastName=patientData.lastName+date;
		corresData.patientId=patientData.lastName;	
		assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium, ClassName, MethodName);	
		waitForPageLoad(selenium);	
		assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);			
		//--------------------------------------------------------------------//
		//  Step-3:Correspondence  Report for A patient 
		//--------------------------------------------------------------------//
		assertTrue(CreateCorrespondenceReport(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
        waitForPageLoad(selenium);		
    	waitForPageLoad(selenium);	
        assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);	
		waitForPageLoad(selenium);	
		//--------------------------------------------------------------------//
		//  Step-4:search the aptient and delete Created corres report 
        //--------------------------------------------------------------------//
		assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not find patient", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, CorresTab),"Could not click corres tab", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblFirstCorresReport),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-5:Verify Various Actions
		//--------------------------------------------------------------------//
	
		assertTrue(verifyActionButtons(selenium,corresData,userAccount),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
	
			
		}
	
	catch(Exception e)
	{
		assertTrue(false,"Test for verifying Correspondenace report actions failed", selenium, ClassName, MethodName);	
	}
		return true;
		
	}
	
	
	public boolean verifyActionButtons(Selenium selenium, ChartPreVisitLib corresData, String userAccount) throws IOException
		
	{
		if(corresData.testCaseId.equals("TC_CCR_001"))
		{
			assertTrue(click(selenium, btncorressign),"Could not sign Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkEncounterAction),"Could not click Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnDeleteCorres),"Could not click delet Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			assertTrue(type(selenium, txtdeleteReason, "reason"),"Could not type reason for deletion",selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnDeleteReason),"Could not click Delete button;More Details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium, lnkEncounterAction),"Could not click Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);		
			return true;	
		}	
		if(corresData.testCaseId.equals("TC_CCR_002"))
		{
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkEncounterAction),"Could not click Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnDeleteCorres),"Could not click delet Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);	
			assertTrue(type(selenium, txtdeleteReason, "reason"),"Could not type reason for deletion",selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnDeleteReason),"Could not click Delete button;More Details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium, lnkEncounterAction),"not deleted", selenium, ClassName,MethodName);
			return true;	
		}
	
		if(corresData.testCaseId.equals("TC_CCR_005"))
		{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("MMM dd, yyyy");
			String date=dateFormat.format(cal.getTime());		
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkEncounterAction),"Could not click Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnHistory),"Could not click History Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium, "Correspondence History"),"Corres page not displayed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,corresData.DiagnosisName ),"Could not click delet Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,date),"Could not find signed date", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);		
			assertTrue(isElementPresent(selenium, btnCancelID),"Could not find the element cancel in history page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnCancelID),"Could not click cancel in history page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium, btnCancelID),"History page not cancelled corredtly", selenium, ClassName,MethodName);
			return true;
				
		}
			
		if(corresData.testCaseId.equals("TC_CCR_004"))
		{
			assertTrue(click(selenium, lnkEncounterAction),"Could not click Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnForward),"Could not click Forward Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, send),"Send button not present in forward page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnCancelID),"Send button not present in forward page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium, send),"Forward page nis present", selenium, ClassName,MethodName);
			return true;
		}
		return true;
		
	}
		
		
		
}
