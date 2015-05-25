package com.nexia.selenium.testscripts.section.chartprevisit.MergeCharts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchAfterMerging extends AbstractHomeTest {
	@Test(groups = {"Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying merge chart option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void verifySearchAfterMerging(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
		    patientData.testCaseId = "TC_NPC_141";
			patientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			verifySearchAfterMerging(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
		}
	/**
	 * verifyMergeChartsSearchPage
	 * function to verify merge chart data page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    November 07, 2014
	 */

	public boolean verifySearchAfterMerging(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws IOException
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
			//--------------------------------------------------------------------//
			//  Step-4: Create Patient with mandatory field with Socio Economic
			//--------------------------------------------------------------------//
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Unable to create Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patientId1=getText(selenium,lblPatientId);
			assertTrue(navigateToNewPatientRegistration(selenium),"Unable to navigate to Patient Registration page",selenium,ClassName,MethodName);
			//-------------------------------------------------------------------//
			//  Step-5: Create Patient With mandatory fields
			//-------------------------------------------------------------------//
			HomeLib patientData1 = new HomeLib();
			patientData1.workSheetName = "PatientData";
			patientData1.testCaseId = "TC_NPC_142";
			patientData1.fetchHomeTestData();
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Unable to create Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patientId2=getText(selenium,lblPatientId);
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Chart Management and search patients	      //
			//--------------------------------------------------------------------//
			assertTrue(navigateToMergeCharts(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId1,btnSearchBoxOnChart1),"Could not search", selenium, ClassName, MethodName);
			assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId2,btnSearchBoxOnChart2),"Could not search", selenium, ClassName, MethodName);
			//-------------------------------------------------------------------//
			//  Step-7: Merge of two charts
			//-------------------------------------------------------------------//
			assertTrue(click(selenium,btnMerge),"Could not click on merge button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(clickTheRadioButtonsInMergedChartsRight(selenium),"Fail to visible buttons list 1",selenium,ClassName,MethodName);
			assertTrue(verifyDisplayPage(selenium),"Page Verification failed with failure",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSave1),"Unable to click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnYesbutton),"Unable to click the ok button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//------------------------------------------------------------------//
			//  Step-8 : Search Patient
			//------------------------------------------------------------------//
			assertTrue(type(selenium,btnSearchBoxOnChart1,patientId2),"Could not type patient id", selenium, ClassName,MethodName);
			selenium.clickAt(btnSearchBoxOnChart1,"");
			selenium.focus(btnSearchBoxOnChart1);			
			selenium.fireEvent(btnSearchBoxOnChart1,"keypress");
			assertTrue(!isElementPresent(selenium,lblPatientResult),"Search Result Found",selenium,ClassName,MethodName);
		}catch(RuntimeException e)
		{
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return false;
		}
	return true;
	}
}
