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

public class VerifyCancelEncounterSixForAllergy extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private AllergyPage allergyPage=null;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify cancel Encounter For Allergy: 10")
	@Parameters({"userAccount","webSite","browser"})

	public void verifyCancelEncounterSixForAllergy(String userAccount,String webSite,String browser) throws Exception 
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
		 * @param proData 
		 * @param 		patientData
		 * @param 		browser
		 * @param 		webSite
		 * @throws      Exception 
		 * @since  	    May 21, 2015
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
			//  Step-3: Create a new patient to check the Encounter template 	  //
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
			//  Step-5:Begin an Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Create Encounter Allergy");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			allergyPage=patientChartPage.goToEncounterAllergy(driver, encounterPage);
		    patientChartPage.createEncounterAllergyEndToEnd(driver,allergyData,userAccount,allergyPage, encounterPage);
		    patientChartPage.addAllergy(driver, allergyPage);
			logTitleMessage("Encounter Allergy creation successful");
			
			//--------------------------------------------------------------------//
			//  Step-6:Save the Encounter and Log out of application		 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Save the Encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Encounter saved and logged out successfully");

			//--------------------------------------------------------------------//
			//  Step-7:Edit Allergy from Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Allergy from Summary A -> B");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.nvigatetoSummaryallergy(driver);
			patientChartPage.clickEditAllergy(allergyPage);
			ChartPreVisitLib allergyData2 = new ChartPreVisitLib();
			allergyData2.workSheetName = "CreateAllergy";
			allergyData2.testCaseId = "TC_CAE_003";
			allergyData2.fetchChartPreVisitTestData();

		    patientChartPage.createSummaryAllergyEndToEnd(driver, allergyData2, userAccount, allergyPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
		    patientChartPage.saveAllergy(driver, allergyPage);
			logTitleMessage("Allergy edit successful");

			//--------------------------------------------------------------------//
			//  Step-8:Edit the Allergy again from Pending Encounter						 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Allergy in encounter : B -> C");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEncounterAllergy(driver, encounterPage);
			patientChartPage.clickEditAllergy(allergyPage);
			ChartPreVisitLib allergyData3 = new ChartPreVisitLib();
			allergyData3.workSheetName = "CreateAllergy";
			allergyData3.testCaseId = "TC_CAE_004";
			allergyData3.fetchChartPreVisitTestData();

		    patientChartPage.createEncounterAllergyEndToEnd(driver,allergyData3,userAccount,allergyPage, encounterPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
			logTitleMessage("Allergy edit in encounter successful");
			
			//--------------------------------------------------------------------//
			//  Step-9:Cancel the Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-10:Verify Allergy in Summary							  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Allergy in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyAllergyandMedicationinSummary(driver, allergyData2, userAccount);
			logTitleMessage("Verification successful");
			
		}
		catch(RuntimeException e)
			{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
			}
		
		return true;
	}
}
