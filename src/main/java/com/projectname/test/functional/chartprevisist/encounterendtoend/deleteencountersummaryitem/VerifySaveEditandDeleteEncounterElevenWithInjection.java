package com.projectname.test.functional.chartprevisist.encounterendtoend.deleteencountersummaryitem;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.InjectionPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifySaveEditandDeleteEncounterElevenWithInjection extends TestBaseClass {

	private HomePage homePage;
	private SharedPage sharedPage;
	private PatientRegistationPage patientRegistationPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private InjectionPage injectionPage;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Save Edit and Delete Encounter Eleven with Injection")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	
	public void verifySaveEditandDeleteEncounterElevenWithInjection(String userAccount,String website,String browser,String seleniumHost,String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ChartPreVisitLib injectionData = new ChartPreVisitLib();
	 injectionData.workSheetName = "CreateInjection";
	 injectionData.testCaseId = "TC_CI_058";
	 injectionData.fetchChartPreVisitTestData();
	 verifySaveEditandDeleteEncounterElevenWithInjection(injectionData,userAccount);
}

	/**
     * VerifySaveEditandDeleteEncounterEleven
     * To Verify function Save Edit and Delete Encounter Eleven with Injections
     * @param injectionData(Injections details to be added )
     * @param userAccount(Application Environment)
     * @since  May 22, 2015
     */

	public boolean verifySaveEditandDeleteEncounterElevenWithInjection(ChartPreVisitLib injectionData, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{			
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,injectionData.userName, injectionData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to Full Access                            // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, injectionData.switchRole);
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
			//  Step-6: Navigate to  Injections  in encounter page	     	      // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to  Injections in encounter page");
			injectionPage = patientChartPage.goToEncounterInjection(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated to Injections in encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-7:  Add  the Injections in encounter page	     	          // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Add the Injections in encounter page A ");
			patientChartPage.createEncounterInjectionEndToEnd(driver, injectionData, userAccount, injectionPage, encounterPage);
			logTitleMessage("Sucessfully Added the Injections in encounter page A");
			
			//--------------------------------------------------------------------//
			//  Step-8:   Save the Encounter 	  								  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Save the encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter");
			
			//--------------------------------------------------------------------//
			//  Step-9:   Login as User B	  								      // 
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib injectionData1 = new ChartPreVisitLib();
			injectionData1.workSheetName = "CreateInjection";
			injectionData1.testCaseId = "TC_CI_060";
			injectionData1.fetchChartPreVisitTestData();
			
			logTitleMessage("Login as User B");
			sharedPage.logoutofApplication(driver);
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,injectionData1.userName, injectionData1.userPassword);
			logTitleMessage("Sucessfully Logged as User B");
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, injectionData1.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			

			//--------------------------------------------------------------------//
			//  Step-10: Navigate to Begin encounter page and Edit Injections   // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");
			
			logTitleMessage("Navigate to Begin encounter B page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated into Begin encounter B page");
			
			logTitleMessage("Navigate to Edit Injections  in encounter page");
			injectionPage=patientChartPage.goToEncounterInjection(driver, encounterPage);
			patientChartPage.clickEditInjection(driver, injectionPage);
			logTitleMessage("Sucessfully Navigated to Edit Injections in encounter page");
		
			logTitleMessage("Edit the Injections in encounter page A -> B");
			patientChartPage.createEncounterInjectionEndToEnd(driver, injectionData1, userAccount, injectionPage, encounterPage);
			patientChartPage.clickSaveEditInjection(driver, injectionPage);
			logTitleMessage("Sucessfully Edited the Injections in encounter page A -> B");
			

			//--------------------------------------------------------------------//
			//  Step-11:   Save the Encounter 	  								 // 
			//--------------------------------------------------------------------//
			logTitleMessage("Save the encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter");
			
			//----------------------------------------------------------------------------------------------------//
			//  Step-12:   Login as User A Again,Navigate to Begin encounter A page and Edit Injections       // 
			//----------------------------------------------------------------------------------------------------//
			
			logTitleMessage("Login as User A Again");
			sharedPage.logoutofApplication(driver);
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,injectionData.userName, injectionData.userPassword);
			logTitleMessage("Sucessfully Logged as User A");
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, injectionData.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			ChartPreVisitLib injectionData2 = new ChartPreVisitLib();
			injectionData2.workSheetName = "CreateInjection";
			injectionData2.testCaseId = "TC_CI_061";
			injectionData2.fetchChartPreVisitTestData();
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");
			
			logTitleMessage("Navigate to saved Encounter A");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.clickSavedEncounter(driver);
			logTitleMessage("Sucessfully navigated into the saved encounter A");
			
			logTitleMessage("Navigate to Edit Injections in encounter page");
			injectionPage=patientChartPage.goToEncounterInjection(driver, encounterPage);
			patientChartPage.clickEditInjection(driver, injectionPage);
			logTitleMessage("Sucessfully Navigated to Edit Injections in encounter page");
		
			logTitleMessage("Edit the Injections in encounter page B -> C");
			patientChartPage.createEncounterInjectionEndToEnd(driver, injectionData2, userAccount, injectionPage, encounterPage);
			patientChartPage.clickSaveEditInjection(driver, injectionPage);
			logTitleMessage("Sucessfully Edited the Injections in encounter page B -> C");
			
			logTitleMessage("Save the encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter");
			
			//--------------------------------------------------------------------//
			//  Step-13:   Delete the Encounter 	  							  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Delete the encounter");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.deleteAllEncounters(driver);
			logTitleMessage("Sucessfully deleted the encounter");
			
			//--------------------------------------------------------------------//
			//  Step-14:Verify Injections B in Summary							 //
			//--------------------------------------------------------------------//		
	
			logTitleMessage("Verify Injections B in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyInjectionInSummary(driver, injectionData1, userAccount);
			logTitleMessage("Successfully verified the Injections B in Summary");
			
			
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
}

