package com.projectname.test.functional.chartprevisist.encounterendtoend.deleteencountersummaryitem;

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

public class VerifySaveEditandDeleteEncounterElevenWithAllergy extends TestBaseClass {

	private HomePage homePage;
	private SharedPage sharedPage;
	private PatientRegistationPage patientRegistationPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private AllergyPage allergyPage;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Save Edit and Delete Encounter Eleven with Allergy")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	
	public void verifySaveEditandDeleteEncounterElevenWithAllergy(String userAccount,String website,String browser,String seleniumHost,String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ChartPreVisitLib allergyData = new ChartPreVisitLib();
	 allergyData.workSheetName = "CreateAllergy";
	 allergyData.testCaseId = "TC_CAE_002";
	 allergyData.fetchChartPreVisitTestData();
	 verifySaveEditandDeleteEncounterElevenWithAllergy(allergyData,userAccount);
}

	/**
     * VerifySaveEditandDeleteEncounterEleven
     * To Verify function Save Edit and Delete Encounter Eleven with Allergy
     * @param allergyData(Allergy details to be added )
     * @param userAccount(Application Environment)
     * @since  May 25, 2015
     */

	public boolean verifySaveEditandDeleteEncounterElevenWithAllergy(ChartPreVisitLib allergyData, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,allergyData.userName, allergyData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to Full Access                            // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, allergyData.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			

			//--------------------------------------------------------------------//
			//  Step-3: Create a new patient 	 								 //
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
			patientChartPage=sharedPage.searchPatientForTestingtester(driver,patientData.lastName);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Begin encounter page 						  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Begin encounter page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated into Begin encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Allergy in encounter page	     	 		  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Allergy in encounter page");
			allergyPage =patientChartPage.goToEncounterAllergy(driver,encounterPage);
			logTitleMessage("Sucessfully Navigated to Allergy in encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-7: Add Allergy A in Encounter page		     	 		      // 
			//--------------------------------------------------------------------//	
	
			logTitleMessage("Add  to  Allergy A in encounter page");
			patientChartPage.createEncounterAllergyEndToEnd(driver,allergyData,userAccount,allergyPage, encounterPage);
			patientChartPage.addAllergy(driver, allergyPage);
			logTitleMessage("Successfully Added the  Allergy A in encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-8:   Save the Encounter A      							  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Save the encounter A ");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter A ");
			
			//--------------------------------------------------------------------//
			//  Step-9:   Login as User B	  								      // 
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib allergyData1 = new ChartPreVisitLib();
			allergyData1.workSheetName = "CreateAllergy";
			allergyData1.testCaseId = "TC_CADE_001";
			allergyData1.fetchChartPreVisitTestData();


			logTitleMessage("Login as User B");
			sharedPage.logoutofApplication(driver);
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,allergyData1.userName, allergyData1.userPassword);
			logTitleMessage("Sucessfully Logged as User B");
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, allergyData1.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver,patientData.lastName);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-10: Edit Allergy from A --> B in Summary				      //
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Edit Allergy from Summary A -> B");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.nvigatetoSummaryallergy(driver);
			patientChartPage.clickEditAllergy(allergyPage);

		    patientChartPage.createSummaryAllergyEndToEnd(driver, allergyData1, userAccount, allergyPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
		    patientChartPage.saveAllergy(driver, allergyPage);
			logTitleMessage("Allergy edited A --> B successfully");
			
			//--------------------------------------------------------------------//
			//  Step-9:   Login as User A	  								      // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Login as User A");
			sharedPage.logoutofApplication(driver);
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,allergyData.userName, allergyData.userPassword);
			logTitleMessage("Sucessfully Logged as User a");
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, allergyData.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver,patientData.lastName);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-10:   Navigate to saved Encounter 	 A  					  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to saved Encounter A");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.clickSavedEncounter(driver);
			logTitleMessage("Sucessfully navigated into the saved encounter A");
			
			//----------------------------------------------------------------------------//
			//  Step-11:  Edit the Allergy B --> C in encounter page      				  // 
			//---------------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Allergy B in Encounter Page");
			
			patientChartPage.goToEncounterAllergy(driver, encounterPage);
			patientChartPage.clickEditAllergy(allergyPage);
			
			logTitleMessage("Sucessfully Navigated into Allergy B in Encounter Page");
			
			ChartPreVisitLib allergyData2 = new ChartPreVisitLib();
			allergyData2.workSheetName = "CreateAllergy";
			allergyData2.testCaseId = "TC_CAE_004";
			allergyData2.fetchChartPreVisitTestData();
			
			logTitleMessage("Edit Allergy in encounter B -> C");
		    patientChartPage.createEncounterAllergyEndToEnd(driver,allergyData2,userAccount,allergyPage, encounterPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
			logTitleMessage("Allergy edited  B --> C in encounter successfully");
			
			logTitleMessage("Save the encounter B");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter B");
			
			
			//--------------------------------------------------------------------//
			//  Step-12:   Delete the Encounter 	  							  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Delete the encounter");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.deleteAllEncounters(driver);
			logTitleMessage("Sucessfully deleted the encounter");
			
			//--------------------------------------------------------------------//
			//  Step-13:Verify Allergy details B in Summary						  //
			//--------------------------------------------------------------------//		
		
			logTitleMessage("Verify Allergy details B in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyAllergyandMedicationinSummary(driver,allergyData1,userAccount);
			logTitleMessage("Successfully verified the Allergy details B in Summary");
			
			
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
}

