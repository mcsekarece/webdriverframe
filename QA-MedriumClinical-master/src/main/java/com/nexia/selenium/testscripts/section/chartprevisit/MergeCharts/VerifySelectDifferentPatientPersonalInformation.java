package com.nexia.selenium.testscripts.section.chartprevisit.MergeCharts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectDifferentPatientPersonalInformation extends AbstractHomeTest{
	@Test(groups = {"AdvancedSmoke","Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying merge chart option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void verifyMergeOptionRightSideRadioButtons(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
		    patientData.testCaseId = "TC_NPC_141";
			patientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			verifySelectDifferentPatientPersonalInformation(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
		}
	@Test(groups = {"Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying merge chart option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMergeOptionLeftSideRadioButtons(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "PatientData";
		patientData.testCaseId = "TC_NPC_142";
		patientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySelectDifferentPatientPersonalInformation(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	/**
	 * VerifySelectDifferentPatientPersonalInformation
	 * function to verify search patient on chart 1&2 on merge charts page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    November 04, 2014
	 */
	 public boolean verifySelectDifferentPatientPersonalInformation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws IOException
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
					assertTrue(createPatient(selenium,patientData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
					waitForPageLoad(selenium);
					assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					String patientId1=getText(selenium,lblPatientId);
					//-------------------------------------------------------------------//
					//  Step-5: Create Second patient
					//-------------------------------------------------------------------//
					HomeLib patientData1 = new HomeLib();
					patientData1.workSheetName = "PatientData";
					
					if(patientData.testCaseId.equals("TC_NPC_141"))
					{
					    patientData1.testCaseId = "TC_NPC_142";
					}
					if(patientData.testCaseId.equals("TC_NPC_142"))
					{
						patientData1.testCaseId = "TC_NPC_141";
					}
					patientData1.fetchHomeTestData();
					assertTrue(navigateToNewPatientRegistration(selenium),"Unable to navigate to Patient Registration page",selenium,ClassName,MethodName);
					assertTrue(createPatient(selenium,patientData1,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
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
					//--------------------------------------------------------------------//
					// Step-7: verify the Merge chart page data
					//--------------------------------------------------------------------//
					assertTrue(verifyMergedChartPage(selenium,userAccount),"Not a valid Merged care patient search page",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					//-------------------------------------------------------------------//
					//  Step-8: Merge Details 
					//-------------------------------------------------------------------//
					assertTrue(click(selenium,btnMerge),"Could not click on merge button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					//-------------------------------------------------------------------//
					//  Step-9: Verify the conflict data only present
					//------------------------------------------------------------------//
					assertTrue(verifyMergedChartLoadConflictData(selenium),"NonConflict data also present",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					//-------------------------------------------------------------------//
					//  Step-10: Check all the buttons are visible
					//-------------------------------------------------------------------//
					if(patientData.testCaseId.equals("TC_NPC_141"))
					{
					assertTrue(clickTheRadioButtonsInMergedChartsRight(selenium),"Fail to visible buttons list 1",selenium,ClassName,MethodName);
					}
					if(patientData.testCaseId.equals("TC_NPC_142"))
					{
					assertTrue(clickTheRadioButtonsInMergedChartsLeft(selenium),"Fail to visible buttons list 2",selenium,ClassName,MethodName);
					}
					//------------------------------------------------------------------//
					//  Step-11: Verify the selected data is displayed in the center
					//------------------------------------------------------------------//
					if(patientData.testCaseId.equals("TC_NPC_141"))
					{
					assertTrue(verifyCenterTextAfterSelectRadioBtnRight(selenium),"Selected data is not getting loaded in the center",selenium,ClassName,MethodName);
					}
					if(patientData.testCaseId.equals("TC_NPC_142"))
					{
				    assertTrue(verifyCenterTextAfterSelectRadioBtnLeft(selenium),"Selected data is not getting loaded in the center",selenium,ClassName,MethodName);
					}
					waitForPageLoad(selenium);
					//------------------------------------------------------------------//
					// Step-12: Verify Last updated date
					//------------------------------------------------------------------//
					assertTrue(lastUpdateDateCheckInMergedChart(selenium,userAccount),"Last updated date mismatched",selenium,ClassName,MethodName);
					assertTrue(click(selenium,btnSave1),"Unable to click the save button",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					//-----------------------------------------------------------------//
					// Step-13: Verify Patient Details
					//-----------------------------------------------------------------//
					assertTrue(click(selenium,btnYesbutton),"Unable to click the ok button",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					if(patientData.testCaseId.equals("TC_NPC_141"))
					{
				    assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId1,btnSearchBoxOnChart1),"Could not search", selenium, ClassName, MethodName);
					assertTrue(verifyPatientChartAfterMergeTheData(selenium,patientData1),"Data not present",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					}
					if(patientData.testCaseId.equals("TC_NPC_142"))
					{
					assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId2,btnSearchBoxOnChart1),"Could not search", selenium, ClassName, MethodName);
					assertTrue(verifyPatientChartAfterMergeTheData(selenium,patientData),"Data not present",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					}
			 return true;
		 }catch(RuntimeException e)
		 {
			 e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
				return false;
		 }
	 }
	 
}
