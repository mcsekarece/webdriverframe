package com.nexia.selenium.testscripts.section.chartprevisit.MergeCharts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyIncludeInActivePatientInCharts extends AbstractHomeTest{
	@Test(groups = {"Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying merge chart option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void verifyIncludeInActivePatientInCharts(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
		    patientData.testCaseId = "TC_NPC_146";
			patientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			verifyAddInActive(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
		}
	/**
	 * VerifyIncludeInActivePatientInCharts
	 * function to verify search patient on chart 1&2 on merge charts page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    November 07, 2014
	 */
	
	public boolean verifyAddInActive(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws IOException
	{
		
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
			//-------------------------------------------------------------------//
			//  Step-4: Create first patient
			//-------------------------------------------------------------------//
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patientID=getText(selenium,lblPatientId);
			//-------------------------------------------------------------------//
			//  Step-5: Navigate to Merged Charts
			//-------------------------------------------------------------------//
			assertTrue(navigateToMergeCharts(selenium),"Navigation Failed", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    //-------------------------------------------------------------------------------------//
		    // Step-6: Search using various keywords as patient First Name, Last Name,Patient ID
		    //-------------------------------------------------------------------------------------//
		    assertTrue(inActivePatientSearchInMergedCharts(selenium,patientID,btnSearchBoxOnChart1),"Fail in patient Search",selenium,ClassName,MethodName);
		    assertTrue(inActivePatientSearchInMergedCharts(selenium,patientData.firstName,btnSearchBoxOnChart1),"Fail in search patient",selenium,ClassName,MethodName);
		    assertTrue(inActivePatientSearchInMergedCharts(selenium,patientData.lastName,btnSearchBoxOnChart1),"Fail in search patient",selenium,ClassName,MethodName);
	  return true;
	}catch(RuntimeException e)
	 {
		 e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return false;
	 }
    }
}
