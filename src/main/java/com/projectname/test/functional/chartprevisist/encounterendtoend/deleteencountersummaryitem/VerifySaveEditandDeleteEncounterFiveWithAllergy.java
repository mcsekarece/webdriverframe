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

public class VerifySaveEditandDeleteEncounterFiveWithAllergy extends TestBaseClass {

	private HomePage homePage;
	private SharedPage sharedPage;
	private PatientRegistationPage patientRegistationPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private AllergyPage allergyPage;

	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Save Edit and Delete Encounter Five with Allergy")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	
	public void verifySaveEditandDeleteEncounterFiveWithAllergy(String userAccount,String website,String browser,String seleniumHost,String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ChartPreVisitLib allergyData = new ChartPreVisitLib();
	 allergyData.workSheetName = "CreateAllergy";
	 allergyData.testCaseId = "TC_CAE_002";
	 allergyData.fetchChartPreVisitTestData();
	 verifySaveEditandDeleteEncounterFiveWithAllergy(allergyData,userAccount);
}

	/**
     * VerifySaveEditandDeleteEncounterFive
     * To Verify function Save Edit and Delete Encounter Five with Allergy
     * @param allergyData(Allergy details to be added )
     * @param userAccount(Application Environment)
     * @since  May 25, 2015
     */

	public boolean verifySaveEditandDeleteEncounterFiveWithAllergy(ChartPreVisitLib allergyData, String userAccount) throws Exception{
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
			//  Step-5: Navigate to Allergy  page	        					  //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to Social History page");
			allergyPage  = patientChartPage.nvigatetoSummaryallergy(driver);
			logTitleMessage("Sucessfully navigated to Social History page");
			
			//--------------------------------------------------------------------//
			//  Step-6: Allergy Details A in summary page 					      //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Add Allergy List in summary page");
			patientChartPage.createSummaryAllergyEndToEnd(driver, allergyData, userAccount, allergyPage);
			patientChartPage.addAllergy(driver, allergyPage);
		    patientChartPage.saveAllergy(driver, allergyPage);
			logTitleMessage("Sucessfully Added Allergy  in summary page");

			//--------------------------------------------------------------------//
			//  Step-7:Begin an Encounter							 	          //
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Edit Allergy in encounter A -> B");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			patientChartPage.goToEncounterAllergy(driver, encounterPage);
			patientChartPage.clickEditAllergy(allergyPage);
			
			ChartPreVisitLib allergyData1 = new ChartPreVisitLib();
			allergyData1.workSheetName = "CreateAllergy";
			allergyData1.testCaseId = "TC_CAE_003";
			allergyData1.fetchChartPreVisitTestData();

		    patientChartPage.createEncounterAllergyEndToEnd(driver,allergyData1,userAccount,allergyPage,encounterPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
		    
			logTitleMessage("Allergy edited  A-->B in encounter successfully");
			
			//--------------------------------------------------------------------//
			//  Step-8:   Save the Encounter A      							  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Save the encounter A ");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter A ");
			
		
			//--------------------------------------------------------------------//
			//  Step-9:   Login as User B	  								      // 
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib allergyData2 = new ChartPreVisitLib();
			allergyData2.workSheetName = "CreateAllergy";
			allergyData2.testCaseId = "TC_CAE_004";
			allergyData2.fetchChartPreVisitTestData();


			logTitleMessage("Login as User B");
			sharedPage.logoutofApplication(driver);
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,allergyData2.userName, allergyData2.userPassword);
			logTitleMessage("Sucessfully Logged as User B");
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, allergyData2.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver,patientData.lastName);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-10: Edit Allergy from B --> C in Summary				      //
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Edit Allergy from Summary B -> C");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.nvigatetoSummaryallergy(driver);
			patientChartPage.clickEditAllergy(allergyPage);

		    patientChartPage.createSummaryAllergyEndToEnd(driver, allergyData2, userAccount, allergyPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
		    patientChartPage.saveAllergy(driver, allergyPage);
			logTitleMessage("Allergy edited B-->C successfully");
			
			//--------------------------------------------------------------------//
			//  Step-11:   Navigate to saved Encounter 	 A  					  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to saved Encounter A");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.clickSavedEncounter(driver);
			logTitleMessage("Sucessfully navigated into the saved encounter A");
			
			//----------------------------------------------------------------------------//
			//  Step-11:  Edit the Allergy C in encounter page      					// 
			//---------------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Allergy C in Encounter Page");
			
			patientChartPage.goToEncounterAllergy(driver, encounterPage);
			patientChartPage.clickEditAllergy(allergyPage);
			
			logTitleMessage("Sucessfully Navigated into Allergy C in Encounter Page");
			
			ChartPreVisitLib allergyData3 = new ChartPreVisitLib();
			allergyData3.workSheetName = "CreateAllergy";
			allergyData3.testCaseId = "TC_CAE_005";
			allergyData3.fetchChartPreVisitTestData();
			
			logTitleMessage("Edit Allergy in encounter C -> D");
		    patientChartPage.createEncounterAllergyEndToEnd(driver,allergyData3,userAccount,allergyPage, encounterPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
			logTitleMessage("Allergy edited  C --> D in encounter successfully");
			
			//--------------------------------------------------------------------//
			//  Step-12:   Delete the Encounter 	  							  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Delete the encounter");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.deleteAllEncounters(driver);
			logTitleMessage("Sucessfully deleted the encounter");
			
			//--------------------------------------------------------------------//
			//  Step-13:Verify Allergy details C in Summary						  //
			//--------------------------------------------------------------------//		
		
			logTitleMessage("Verify Allergy details C in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyAllergyandMedicationinSummary(driver,allergyData2,userAccount);
			logTitleMessage("Successfully verified the Allergy details C in Summary");
			
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
}
