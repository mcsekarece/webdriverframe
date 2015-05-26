package com.projectname.test.functional.chartprevisist.encounterendtoend.verifycancel;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.DemographicsPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.ProblemListPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;


import org.testng.annotations.Listeners;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyCancelEncounterThree extends TestBaseClass{
	
	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private ProblemListPage problemListPage=null;
	private EncounterPage encounterPage=null;
	private DemographicsPage demographicsPage=null;
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify cancel Encounter : 5")
	@Parameters({"userAccount","webSite","browser"})

	public void verifyCancelEncounterThree(String userAccount,String webSite,String browser) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPLE_001";
		proData.fetchChartPreVisitTestData();		
		verifyCancel(userAccount, proData);
	}	
		/**
		 * verify Cancel Encounter
		 * function to verify Cancel Encounter
		 * @param proData 
		 * @param 		patientData
		 * @param 		browser
		 * @param 		webSite
		 * @throws      Exception 
		 * @since  	    Mar 13, 2015
		 */

		
	private boolean verifyCancel(String userAccount,ChartPreVisitLib proData) throws Exception {
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, proData.userName, proData.userPassword);
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
			//  Step-5:Add Summary Problem list							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Add Summary Problem list");
			patientChartPage.clickSummaryTab(driver);
			problemListPage=patientChartPage.goToProblemList(driver);
			patientChartPage.createProblemListEndToEnd(driver, proData, userAccount, problemListPage);
			patientChartPage.saveSummaryProblemList(driver, problemListPage);
			logTitleMessage("Summary Problem list added successfully");

			//--------------------------------------------------------------------//
			//  Step-6:Begin an Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit problem list in encounter A -> B");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			patientChartPage.goToEncounterProblemList(driver,encounterPage);
			patientChartPage.clickEditProblemList(problemListPage);
			ChartPreVisitLib proData1 = new ChartPreVisitLib();
			proData1.workSheetName = "CreateProblemList";
			proData1.testCaseId = "TC_CPLE_002";
			proData1.fetchChartPreVisitTestData();		

			patientChartPage.createEncounterProblemListEndToEnd(driver, proData1, userAccount, problemListPage,encounterPage);
			patientChartPage.clickSaveEditProblemList(driver, problemListPage);
			logTitleMessage("Problem list edit in encounter successful");
			
			//--------------------------------------------------------------------//
			//  Step-7:Save the Encounter and Log out of application		 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Save the Encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			sharedPage.logoutofApplication(driver);
			logTitleMessage("Encounter saved and logged out successfully");

			//--------------------------------------------------------------------//
			//  Step-8:Login into application as different user							 	  //
			//--------------------------------------------------------------------//	
			logTitleMessage("Login as different user");
			ChartPreVisitLib proData2 = new ChartPreVisitLib();
			proData2.workSheetName = "CreateProblemList";
			proData2.testCaseId = "TC_CPLE_003";
			proData2.fetchChartPreVisitTestData();		

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, proData2.userName, proData2.userPassword);
			logTitleMessage("Login successful");
			
			logTitleMessage("Search patient");
			demographicsPage=sharedPage.searchPatientNexiaForProviderHomePage(driver,patientData.lastName);
			demographicsPage.goToChart(driver);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit Problem List from Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Problem List from Summary B -> C");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.goToProblemList(driver);
			patientChartPage.clickEditProblemList(problemListPage);

			patientChartPage.createEncounterProblemListEndToEnd(driver, proData2, userAccount, problemListPage,encounterPage);
			patientChartPage.clickSaveEditProblemList(driver, problemListPage);
			patientChartPage.clickSaveSummaryProblemList(driver, problemListPage);
			logTitleMessage("Problem list edit successful");

			//--------------------------------------------------------------------//
			//  Step-10:Edit the Problem List again	from Pending Encounter						 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit problem list in encounter : C -> D");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEditProblemListFromEncounter(encounterPage,problemListPage);
			ChartPreVisitLib proData3 = new ChartPreVisitLib();
			proData3.workSheetName = "CreateProblemList";
			proData3.testCaseId = "TC_CPLE_004";
			proData3.fetchChartPreVisitTestData();		

			patientChartPage.createEncounterProblemListEndToEnd(driver, proData3, userAccount, problemListPage,encounterPage);
			patientChartPage.clickSaveEditProblemList(driver, problemListPage);
			logTitleMessage("Problem list edit in encounter successful");

			//--------------------------------------------------------------------//
			//  Step-11:Cancel the Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-12:Verify Problem List in Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Problem List in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyProblemListInSummary(driver, proData, proData2,  userAccount );
			logTitleMessage("Verification successful");

		}
		catch(RuntimeException e)
			{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
			}
	
		
		return true;
	}

}
