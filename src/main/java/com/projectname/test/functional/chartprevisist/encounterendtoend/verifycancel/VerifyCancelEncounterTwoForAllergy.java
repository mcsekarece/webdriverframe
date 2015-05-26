package com.projectname.test.functional.chartprevisist.encounterendtoend.verifycancel;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.AllergyPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyCancelEncounterTwoForAllergy extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private AllergyPage allergyPage=null;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify cancel Encounter Allergy: 4")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterTwoForAllergy(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CAE_002";
		allergyData.fetchChartPreVisitTestData();
		verifyCancel(userAccount, allergyData);
	}	
		/**
		 * verify Cancel Encounter
		 * function to verify Cancel Encounter
		 * @param 		allergyData 
		 * @param 		patientData
		 * @param 		browser
		 * @param 		webSite
		 * @throws      Exception 
		 * @since  	    Mar 13, 2015
		 */

	
	private boolean verifyCancel(String userAccount,ChartPreVisitLib allergyData) throws Exception {
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, allergyData.userName, allergyData.userPassword);
			logTitleMessage("Login Successful");			

			//--------------------------------------------------------------------//
			//  Step-3: Create a new patient 									  //
			//--------------------------------------------------------------------//
			logTitleMessage("Create a new patient");
			sharedPage=homePage.navigateToSharedPage();
			patientRegistationPage= sharedPage.goToPatientRegPage(driver);
			HomeLib patientData = new HomeLib();	
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();	
			patientRegistationPage.createNewPatientWithMandatory(driver, patientData, userAccount);
			logTitleMessage("Patient creation successful");
			//--------------------------------------------------------------------//
			//  Step-4:Search newly created Patient							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-5:Add Summary Allergy								 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Add Summary Allergy");
			patientChartPage.clickSummaryTab(driver);
			allergyPage= patientChartPage.nvigatetoSummaryallergy(driver);
			ChartPreVisitLib immData = new ChartPreVisitLib();
			immData.workSheetName = "CreateImmunization";
			immData.testCaseId = "TC_CIM_072";
			immData.fetchChartPreVisitTestData();

		    patientChartPage.createSummaryAllergyEndToEnd(driver, allergyData, userAccount, allergyPage);
		    patientChartPage.addAllergy(driver, allergyPage);
			logTitleMessage("Summary Allergy added successfully");

			//--------------------------------------------------------------------//
			//  Step-6:Begin an Encounter							 	  		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Allergy in encounter A -> B");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			allergyPage=patientChartPage.goToEncounterAllergy(driver, encounterPage);
			patientChartPage.clickEditAllergy(allergyPage);

			ChartPreVisitLib allergyData2 = new ChartPreVisitLib();
			allergyData2.workSheetName = "CreateAllergy";
			allergyData2.testCaseId = "TC_CAE_003";
			allergyData2.fetchChartPreVisitTestData();

		    patientChartPage.createEncounterAllergyEndToEnd(driver,allergyData2,userAccount,allergyPage, encounterPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
			logTitleMessage("Allergy edit in encounter successful");

			//--------------------------------------------------------------------//
			//  Step-7:Save the Encounter							 	  		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Save the Encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Encounter saved successfully");

			//--------------------------------------------------------------------//
			//  Step-8:Edit Allergy from Summary							  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Allergy from Summary B -> C");
			patientChartPage.clickSummaryTab(driver);
			allergyPage= patientChartPage.nvigatetoSummaryallergy(driver);
			patientChartPage.clickEditAllergy(allergyPage);
			ChartPreVisitLib allergyData3 = new ChartPreVisitLib();
			allergyData3.workSheetName = "CreateAllergy";
			allergyData3.testCaseId = "TC_CAE_004";
			allergyData3.fetchChartPreVisitTestData();

		    patientChartPage.createSummaryAllergyEndToEnd(driver, allergyData3, userAccount, allergyPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
		    patientChartPage.saveAllergy(driver, allergyPage);
			logTitleMessage("Allergy edit successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit the Allergy again from Pending Encounter	       	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Allergy in encounter : C -> D");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEncounterAllergy(driver, encounterPage);
			patientChartPage.clickEditAllergy(allergyPage);
			ChartPreVisitLib allergyData4 = new ChartPreVisitLib();
			allergyData4.workSheetName = "CreateAllergy";
			allergyData4.testCaseId = "TC_CAE_004";
			allergyData4.fetchChartPreVisitTestData();

		    patientChartPage.createEncounterAllergyEndToEnd(driver,allergyData4,userAccount,allergyPage, encounterPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
			logTitleMessage("Allergy edit in encounter successful");

			//--------------------------------------------------------------------//
			//  Step-10:Cancel the Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-11:Verify Allergy in Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Allergy Values in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyAllergyandMedicationinSummary(driver, allergyData3, userAccount);
			logTitleMessage("Successfully verified Allergy Values in Summary");

		}
		catch(RuntimeException e)
			{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
			}
		return true;
	}
}
