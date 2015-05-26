package com.projectname.test.functional.chartprevisist.encounterendtoend.removesummaryitemfromencounter;

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
public class VerifyRemoveSummaryFromEncounterNineWithInjection extends TestBaseClass {
	private HomePage homePage;
	private SharedPage sharedPage;
	private PatientRegistationPage patientRegistationPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private InjectionPage injectionPage;
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Remove Summary Item From Encounter - Two")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	
	public void verifyRemoveSummaryFromEncounterNine(String userAccount,String website,String browser,String seleniumHost,String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ChartPreVisitLib injectionDataA = new ChartPreVisitLib();
		injectionDataA.workSheetName = "CreateInjection";
		injectionDataA.testCaseId = "TC_ETE_001";
		injectionDataA.fetchChartPreVisitTestData(); 
	 VerifyRemoveSummaryFromEncounter(injectionDataA,userAccount);
}
	
	/**
     * VerifyRemoveSummaryFromEncounter
     * To Verify Remove Summary Item From Encounter - Three
     * @param problemListData
     * @param userAccount(Application Environment)
     * @since  Mar 20, 2015
     */

	public boolean VerifyRemoveSummaryFromEncounter(ChartPreVisitLib injectionDataA, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,injectionDataA.userName, injectionDataA.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to Full Access                            // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, injectionDataA.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Create a new patient 	  								  //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Create a new patient");
			sharedPage=homePage.navigateToSharedPage();
			patientRegistationPage= sharedPage.goToPatientRegPage(driver);
			HomeLib patientData = new HomeLib();	
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();	
			patientRegistationPage.createNewPatientWithMandatory(driver,patientData, userAccount);
			logTitleMessage("Patient creation successful");
			
			//--------------------------------------------------------------------//
			//  Step-4:Search newly created Patient							 	  //
			//--------------------------------------------------------------------//		
		
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Begin encounter page 						  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Begin encounter page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated into Begin encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to  Problem List in encounter page	     	  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to Edit Injection in encounter page");
			patientChartPage.goToEncounterInjection(driver,encounterPage);
			patientChartPage.clickEditInjection(driver,injectionPage);
			logTitleMessage("Sucessfully Navigated to Edit Injection in encounter page");
			
			logTitleMessage("Edit the Problem List in encounter page");
			patientChartPage.createEncounterInjectionEndToEnd(driver, injectionDataA, userAccount, injectionPage,encounterPage);
			logTitleMessage("Sucessfully Edited the Injection in encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-8:   Save the Encounter 	  								 // 
			//--------------------------------------------------------------------//
			logTitleMessage("Save the encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter");
			
			//--------------------------------------------------------------------//
			//  Step-9:   Login as User B	  								      // 
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib injectionDataB = new ChartPreVisitLib();
			injectionDataB.workSheetName = "CreateInjection";
			injectionDataB.testCaseId = "TC_ETE_002";
			injectionDataB.fetchChartPreVisitTestData(); 
			
			logTitleMessage("Login as User B");
			sharedPage.logoutofApplication(driver);
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,injectionDataB.userName, injectionDataB.userPassword);
			logTitleMessage("Sucessfully Logged as User B");

			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, injectionDataB.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			//--------------------------------------------------------------------//
			//  Step-10:  Edit the Injection in summary page	     	          // 
			//--------------------------------------------------------------------//		
		
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");
			
			logTitleMessage("Navigate to Injection page");
			patientChartPage.clickSummaryTab(driver);
			injectionPage = patientChartPage.goToInjection(driver);
			patientChartPage.clickEditInjection(driver,injectionPage);
			logTitleMessage("Sucessfully navigated to Injection in summary page");
			
			logTitleMessage("Add Injection in summary page");
	        patientChartPage.createInjectionEndToEnd(driver,injectionDataA,userAccount,injectionPage);
			logTitleMessage("Sucessfully Added Injection in summary page");

			//--------------------------------------------------------------------//
			//  Step-11:   Login as User A	 Again								  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Login as User A Again");
			sharedPage.logoutofApplication(driver);
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,injectionDataB.userName, injectionDataB.userPassword);
			logTitleMessage("Sucessfully Logged as User A");
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, injectionDataB.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			//--------------------------------------------------------------------//
			//  Step-12: Navigate to Begin encounter page and Edit Injection      // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");
			
			logTitleMessage("Navigate to saved Encounter");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.clickSavedEncounter(driver);
			logTitleMessage("Sucessfully navigated into the saved encounter");
			
	
			logTitleMessage("Navigate to Edit Injection in encounter page");
			patientChartPage.goToEncounterInjection(driver,encounterPage);
			patientChartPage.clickEditInjection(driver,injectionPage);
			logTitleMessage("Sucessfully Navigated to Edit Injection in encounter page");
			
			ChartPreVisitLib injectionDataC = new ChartPreVisitLib();
			injectionDataC.workSheetName = "CreateInjection";
			injectionDataC.testCaseId = "TC_ETE_003";
			injectionDataC.fetchChartPreVisitTestData();
			
			logTitleMessage("Edit the Problem List in encounter page");
			patientChartPage.createEncounterInjectionEndToEnd(driver, injectionDataC, userAccount, injectionPage,encounterPage);
			logTitleMessage("Sucessfully Edited the Injection in encounter page");
			//------------------------------------------------------------------------//
			//  Step-13:  Remove the Problem List C in encounter page 				  // 
			//-----------------------------------------------------------------------//		
			
			logTitleMessage("Remove the Problem List c ");
			patientChartPage.removeEncounterInjection(driver,encounterPage);
			logTitleMessage("Sucessfully Removed Problem List C");
			
			//--------------------------------------------------------------------//
			//  Step-14:Cancel the Encounter							 	     //
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");
			
			//--------------------------------------------------------------------//
			//  Step-15:Verify Problem List in Summary							 //
			//--------------------------------------------------------------------//		
		
			logTitleMessage("Verify Problem List B in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyInjectionInSummary(driver, injectionDataB,userAccount );
			logTitleMessage("Successfully verified the Problem List B in Summary");
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
}
