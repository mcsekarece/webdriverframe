package com.nexia.selenium.testscripts.section.chartprevisit.MergeCharts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMergeAndCancelOption extends AbstractHomeTest{
	@Test(groups = {"Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying merge chart option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMergeOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "PatientData";
		patientData.testCaseId = "TC_NPC_141";
		patientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyMergeOption(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying merge chart option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "PatientData";
		patientData.testCaseId = "TC_NPC_141";
		patientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyMergeOption(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying merge chart option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelOptionWithNo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "PatientData";
		patientData.testCaseId = "TC_NPC_143";
		patientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyMergeOption(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	/**
	 * verifyMergeOption
	 * function to verify search patient on chart 1&2 on merge charts page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    October 24, 2014
	 */
	public boolean verifyMergeOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws IOException{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Clear Custom Mandatory Fields
			//--------------------------------------------------------------------//
			assertTrue(navigateToMandatoryUserFields(selenium),"Unable to Naviage to user Mandatory fields",selenium,ClassName,MethodName);
			assertTrue(deleteAllMandatory(selenium), "Could not delete all mandatory fields", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Click New Patient Check-in   							  //
			//--------------------------------------------------------------------//				
			assertTrue(naviagateToHomePageFromAnyPlace(selenium),"Unable to Navigate to homepage",selenium,ClassName,MethodName);
			
			assertTrue(navigateToNewPatientRegistration(selenium),"Unable to navigate to Patient Registration page",selenium,ClassName,MethodName);
			
			assertTrue(createPatient(selenium,patientData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String patientId1=getText(selenium,lblPatientId);
			
			HomeLib patientData1 = new HomeLib();
			patientData1.workSheetName = "PatientData";
			patientData1.testCaseId = "TC_NPC_142";
			patientData1.fetchHomeTestData();
			
			assertTrue(navigateToNewPatientRegistration(selenium),"Unable to navigate to Patient Registration page",selenium,ClassName,MethodName);
			
			assertTrue(createPatient(selenium,patientData1,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			String patientId2=getText(selenium,lblPatientId);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Chart Management and search patients	      //
			//--------------------------------------------------------------------//
			
			assertTrue(navigateToMergeCharts(selenium),"Navigation Failed", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			
			assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId1,btnSearchBoxOnChart1),"Could not search", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId2,btnSearchBoxOnChart2),"Could not search", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Merge Button
			//--------------------------------------------------------------------//
				
			assertTrue(click(selenium,btnMerge),"Could not click on merge button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,btnCancel),"Could not find cancel button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(patientData.testCaseId.equals("TC_NPC_142")){
				assertTrue(click(selenium,btnCancel),"Could not find cancel button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnYesbutton),"Could not find yes button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,btnMerge),"Could not click on merge button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			if(patientData.testCaseId.equals("TC_NPC_143")){
				assertTrue(click(selenium,btnCancel),"Could not find cancel button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnNoButton),"Could not find yes button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!isElementPresent(selenium,btnMerge),"Could not click on merge button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,btnCancel),"Could not click on cacel button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return false;
		}
	}
	
}
