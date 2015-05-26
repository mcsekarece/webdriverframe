package com.projectname.test.functional.chartprevisist.encounterendtoend.verifycancel;

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
import com.projectname.testutils.pages.ProblemListPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;


import org.testng.annotations.Listeners;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyCancelEncounterEight extends TestBaseClass{
	
	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private ProblemListPage problemListPage=null;
	private EncounterPage encounterPage=null;
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify cancel Encounter : 12")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterEight(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPLE_001";
		proData.fetchChartPreVisitTestData();		
		verifyCancel(userAccount, proData, webSite, browser, seleniumHost, seleniumPort);
	}	
		/**
		 * verify Cancel Encounter Eight
		 * function to verify Cancel Encounter
		 * @param proData 
		 * @param 		patientData
		 * @param 		browser
		 * @param 		webSite
		 * @throws      Exception 
		 * @since  	    Mar 16, 2015
		 */

		
	private boolean verifyCancel(String userAccount,ChartPreVisitLib proData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
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
			//  Step-5:Begin an Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Begin Encounter");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			logTitleMessage("Begin Encounter successful");
			
			//--------------------------------------------------------------------//
			//  Step-6:Add Summary Problem list							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Add Summary Problem list");
			patientChartPage.clickSummaryTab(driver);
			problemListPage=patientChartPage.goToProblemList(driver);
			patientChartPage.createProblemListEndToEnd(driver, proData, userAccount, problemListPage);
			patientChartPage.addProblemList(driver, problemListPage);
			logTitleMessage("Summary Problem list added successfully");
			
			//--------------------------------------------------------------------//
			//  Step-7:Log out							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Log out");
			sharedPage.logoutofApplication(driver);
			driver.close();
			logTitleMessage("Log out successful");

			//--------------------------------------------------------------------//
			//  Step-8:Login into application as User B							 	  //
			//--------------------------------------------------------------------//	
			logTitleMessage("Login as different user");
			genericSetUp(webSite, browser, userAccount, seleniumHost, seleniumPort);
			ChartPreVisitLib proData2 = new ChartPreVisitLib();
			proData2.workSheetName = "CreateProblemList";
			proData2.testCaseId = "TC_CPLE_003";
			proData2.fetchChartPreVisitTestData();		

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, proData2.userName, proData2.userPassword);
			logTitleMessage("Login successful");

			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, proData2.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");

			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit Problem List from Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Problem List from Summary A -> B");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.goToProblemList(driver);
			patientChartPage.clickEditProblemList(problemListPage);
			patientChartPage.createEncounterProblemListEndToEnd(driver, proData2, userAccount, problemListPage,encounterPage);
			patientChartPage.clickSaveEditProblemList(driver, problemListPage);
			logTitleMessage("Problem list edit successful");
			
			//--------------------------------------------------------------------//
			//  Step-9:Log out							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Log out");
			sharedPage.logoutofApplication(driver);
			driver.close();
			logTitleMessage("Log out successful");

			//--------------------------------------------------------------------//
			//  Step-10:Log in as User A							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Log in as User A");
			genericSetUp(webSite, browser, userAccount, seleniumHost, seleniumPort);
			ChartPreVisitLib proData3 = new ChartPreVisitLib();
			proData3.workSheetName = "CreateProblemList";
			proData3.testCaseId = "TC_CPLE_004";
			proData3.fetchChartPreVisitTestData();		

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, proData3.userName, proData3.userPassword);
			logTitleMessage("Login successful");
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-11:Edit the Problem List again	from Pending Encounter						 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit problem list in encounter : B -> C");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEditProblemListFromEncounter(encounterPage,problemListPage);

			patientChartPage.createEncounterProblemListEndToEnd(driver, proData3, userAccount, problemListPage,encounterPage);
			patientChartPage.clickSaveEditProblemList(driver, problemListPage);
			logTitleMessage("Problem list edit in encounter successful");

			//--------------------------------------------------------------------//
			//  Step-12:Cancel the Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-13:Verify Problem List in Summary							 	  //
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
