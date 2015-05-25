package com.nexia.selenium.testscripts.section.chartprevisit.MergeCharts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyChartsWithSocioEconomicData extends AbstractHomeTest {
	@Test(groups = {"Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying merge chart option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void verifyPatientChartMergingWithSocioEconomic(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
		    patientData.testCaseId = "TC_NPC_141";
			patientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			verifyChartsWithSocioEconomicData(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
		}
	/**
	 * VerifyChartsWithSocioEconomicData
	 * function to verify Merge data in chart with socio Economic data
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    November 07, 2014
	 */
	public boolean verifyChartsWithSocioEconomicData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws IOException
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
			//  Step-s: Create Patient with mandatory field with Socio Economic
			//--------------------------------------------------------------------//
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Unable to create Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			String patientId1=getText(selenium,lblPatientId);
			HomeLib sEconomicData = new HomeLib();
			sEconomicData.workSheetName = "NewSocioEconomic";
			sEconomicData.testCaseId = "TC_SE_001";
			sEconomicData.fetchHomeTestData();
			assertTrue(navigateToSocioEconomicTab(selenium),"Unable to Navigate to socio Economic Page",selenium,ClassName,MethodName);
			assertTrue(createSocioEconomic(selenium,sEconomicData, userAccount),"Socio-Economic creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Create patient with Mandatory field with Socio Economic
			//--------------------------------------------------------------------//
			patientData.workSheetName = "PatientData";
		    patientData.testCaseId = "TC_NPC_142";
			patientData.fetchHomeTestData();
			assertTrue(navigateToNewPatientRegistration(selenium),"Unable to navigate to Patient Registration page",selenium,ClassName,MethodName);
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Unable to create Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			String patientId2=getText(selenium,lblPatientId);
			//----------------------------------------------------------------------//
			// Step-7: Create New Socio data for patient 2
			//----------------------------------------------------------------------//
			HomeLib sEconomicData1 = new HomeLib();
			sEconomicData1.workSheetName = "NewSocioEconomic";
			sEconomicData1.testCaseId = "TC_SE_002";
			sEconomicData1.fetchHomeTestData();
			assertTrue(navigateToSocioEconomicTab(selenium),"Unable to Navigate to socio Economic Page",selenium,ClassName,MethodName);
			assertTrue(createSocioEconomic(selenium,sEconomicData, userAccount),"Socio-Economic creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Chart Management and search patients	      //
			//--------------------------------------------------------------------//
			assertTrue(navigateToMergeCharts(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId1,btnSearchBoxOnChart1),"Could not search", selenium, ClassName, MethodName);
			assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId2,btnSearchBoxOnChart2),"Could not search", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-8: Click Merge Charts Button 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnMerge),"Could not click on merge button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//-------------------------------------------------------------------//
			//  Step-10: Merge Charts
			//-------------------------------------------------------------------//
			assertTrue(clickTheRadioButtonsInMergedChartsRight(selenium),"Fail to visible buttons list 1",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave1),"Unable to click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnYesbutton),"Unable to click the ok button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-11: Verify Socio Economic Data
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId1,btnSearchBoxOnChart1),"Could not search", selenium, ClassName, MethodName);
			assertTrue(verifyPatientChartAfterMergeTheDatawithSocioEconomic(selenium,sEconomicData),"data not matched",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}catch(RuntimeException e)
		{
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return false;
		}
		return true;
	}
}
