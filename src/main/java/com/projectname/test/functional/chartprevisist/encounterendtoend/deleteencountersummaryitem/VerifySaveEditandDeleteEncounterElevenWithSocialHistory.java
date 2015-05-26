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
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.pages.SocialHistoryPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifySaveEditandDeleteEncounterElevenWithSocialHistory extends TestBaseClass {

	private HomePage homePage;
	private SharedPage sharedPage;
	private PatientRegistationPage patientRegistationPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private SocialHistoryPage socialHistoryPage;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Save Edit and Delete Encounter Eleven with social history")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	
	public void verifySaveEditandDeleteEncounterElevenWithSocialHistory(String userAccount,String website,String browser,String seleniumHost,String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ChartPreVisitLib socialHisData = new ChartPreVisitLib();
	 socialHisData.workSheetName = "CreateSocialHistory";
	 socialHisData.testCaseId = "TC_ESH_001";
	 socialHisData.fetchChartPreVisitTestData(); 
	 verifySaveEditandDeleteEncounterElevenWithSocialHistory(socialHisData,userAccount);
}

	/**
     * VerifySaveEditandDeleteEncounterEleven
     * To Verify function Save Edit and Delete Encounter Eleven with Social History
     * @param socialHisData(Social History details to be added )
     * @param userAccount(Application Environment)
     * @since  May 22, 2015
     */

	public boolean verifySaveEditandDeleteEncounterElevenWithSocialHistory(ChartPreVisitLib socialHisData, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,socialHisData.userName, socialHisData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to Full Access                            // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, socialHisData.switchRole);
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
		//	patientRegistationPage.createNewPatientWithMandatory(driver, patientData, userAccount);
			logTitleMessage("Patient creation successful");
			
			
			//--------------------------------------------------------------------//
			//  Step-4:Search newly created Patient							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, "PateintA");
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Begin encounter page 						  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Begin encounter page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated into Begin encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to  Social History  in encounter page	     	  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to  Problem List in encounter page");
			socialHistoryPage =	patientChartPage.goToEncounterSocialHistory(driver,encounterPage);
			logTitleMessage("Sucessfully Navigated to Problem List in encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-7:  Add  the Social History in encounter page	     	      // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Add the Social History in encounter page A ");
			patientChartPage.createEncounterSocialHistoryEndToEnd(driver, socialHisData,userAccount,socialHistoryPage,encounterPage);
			patientChartPage.addEncounterSocialHistory(driver, socialHistoryPage);
			logTitleMessage("Sucessfully Added the Social History in encounter page A");
			
			//--------------------------------------------------------------------//
			//  Step-8:   Save the Encounter 	  								  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Save the encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter");
			
			//--------------------------------------------------------------------//
			//  Step-9:   Login as User B	  								      // 
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib socialHisData1 = new ChartPreVisitLib();
			socialHisData1.workSheetName = "CreateSocialHistory";
			socialHisData1.testCaseId = "TC_ESH_002";
			socialHisData1.fetchChartPreVisitTestData(); 
			
			logTitleMessage("Login as User B");
			sharedPage.logoutofApplication(driver);
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,socialHisData1.userName, socialHisData1.userPassword);
			logTitleMessage("Sucessfully Logged as User B");
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, socialHisData1.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			

			//--------------------------------------------------------------------//
			//  Step-10: Navigate to Begin encounter page and Edit Problem List   // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, "PateintA");
			logTitleMessage("Search patient successful");
			
			logTitleMessage("Navigate to Begin encounter B page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated into Begin encounter B page");
			
			logTitleMessage("Navigate to Edit Social History  in encounter page");
			patientChartPage.goToEncounterSocialHistory(driver,encounterPage);
			patientChartPage.clickEditEncounterSocialHistory(driver,socialHistoryPage);
			logTitleMessage("Sucessfully Navigated to Edit Social History in encounter page");
		
			logTitleMessage("Edit the Social History in encounter page A -> B");
			patientChartPage.createEncounterSocialHistoryEndToEnd(driver, socialHisData1, userAccount,socialHistoryPage,encounterPage);
			patientChartPage.clickSaveEditSocialHistory(driver, socialHistoryPage);
			logTitleMessage("Sucessfully Edited the Social History in encounter page A -> B");
			

			//--------------------------------------------------------------------//
			//  Step-11:   Save the Encounter 	  								 // 
			//--------------------------------------------------------------------//
			logTitleMessage("Save the encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter");
			
			//----------------------------------------------------------------------------------------------------//
			//  Step-12:   Login as User A Again,Navigate to Begin encounter A page and Edit Social History       // 
			//----------------------------------------------------------------------------------------------------//
			
			logTitleMessage("Login as User A Again");
			sharedPage.logoutofApplication(driver);
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,socialHisData.userName, socialHisData.userPassword);
			logTitleMessage("Sucessfully Logged as User A");
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, socialHisData.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			 ChartPreVisitLib socialHisData2 = new ChartPreVisitLib();
			 socialHisData2.workSheetName = "CreateSocialHistory";
			 socialHisData2.testCaseId = "TC_ESH_003";
			 socialHisData2.fetchChartPreVisitTestData(); 
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, "PateintA");
			logTitleMessage("Search patient successful");
			
			logTitleMessage("Navigate to saved Encounter A");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.clickSavedEncounter(driver);
			logTitleMessage("Sucessfully navigated into the saved encounter A");
			
			logTitleMessage("Navigate to Edit Problem List in encounter page");
			patientChartPage.goToEncounterSocialHistory(driver,encounterPage);
			patientChartPage.clickEditEncounterSocialHistory(driver,socialHistoryPage);
			logTitleMessage("Sucessfully Navigated to Edit Problem List in encounter page");
		
			logTitleMessage("Edit the Problem List in encounter page B -> C");
			patientChartPage.createEncounterSocialHistoryEndToEnd(driver, socialHisData2, userAccount,socialHistoryPage,encounterPage);
			patientChartPage.clickSaveEditSocialHistory(driver, socialHistoryPage);
			logTitleMessage("Sucessfully Edited the Problem List in encounter page B -> C");
			
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
			//  Step-14:Verify Social History B in Summary							 //
			//--------------------------------------------------------------------//		
	
			logTitleMessage("Verify Social History B in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifySocialHistoryInSummary(driver,socialHisData,socialHisData1,userAccount );
			logTitleMessage("Successfully verified the Social History B in Summary");
			
			
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
}

