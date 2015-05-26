package com.projectname.test.functional.chartprevisist.encounterendtoend.verifycancel;

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
import com.projectname.testutils.pages.ProblemListPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyCancelEncounterSevenForProblemList extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private ProblemListPage problemListPage=null;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Cancel Encounter Problem List: 11")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterSevenForSocialHistory(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPLE_001";
		proData.fetchChartPreVisitTestData();		
	 verifyProblemList(proData,userAccount);
}

	/**
     * verifyProblemList
     * To Verify function Cancel Encounter 
     * @param socialHisData(Problem List details to be added)
     * @param userAccount(Application Environment)
     * @since  Mar 25, 2015
     */

	public boolean verifyProblemList(ChartPreVisitLib proData, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,proData.userName, proData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient 	 								  //
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
			//  Step-3:Search newly created Patient							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-4:Begin an Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Create Encounter Social History");
			logTitleMessage("Create Encounter Problem List");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			problemListPage=patientChartPage.goToProblemList(driver);
			patientChartPage.createEncounterProblemListEndToEnd(driver, proData, userAccount, problemListPage,encounterPage);
			patientChartPage.addProblemList(driver, problemListPage);
			logTitleMessage("Encounter Problem List creation successful");
			
			//--------------------------------------------------------------------//
			//  Step-5:   Save the Encounter and Log out	  				            	  // 
			//--------------------------------------------------------------------//
			logTitleMessage("Save the encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter");

			logTitleMessage("Log out");
			sharedPage.logoutofApplication(driver);
			logTitleMessage("Log out successful");
			
			//--------------------------------------------------------------------//
			//  Step-6:Login into application as User B							 	  //
			//--------------------------------------------------------------------//	
		
			logTitleMessage("Login as different user");
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
			//  Step-7:Edit Problem List from Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Problem List from Summary A -> B");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.goToProblemList(driver);
			patientChartPage.clickEditProblemList(problemListPage);

			patientChartPage.createEncounterProblemListEndToEnd(driver, proData2, userAccount, problemListPage,encounterPage);
			patientChartPage.clickSaveEditProblemList(driver, problemListPage);
			patientChartPage.clickSaveSummaryProblemList(driver, problemListPage);
			logTitleMessage("Problem list edit successful");

			logTitleMessage("Log out");
			sharedPage.logoutofApplication(driver);
			logTitleMessage("Log out successful");
			
			//--------------------------------------------------------------------//
			//  Step-8:Login into application as User A							 	  //
			//--------------------------------------------------------------------//	
			logTitleMessage("Login as different user and search patient");
			ChartPreVisitLib proData3 = new ChartPreVisitLib();
			proData3.workSheetName = "CreateProblemList";
			proData3.testCaseId = "TC_CPLE_004";
			proData3.fetchChartPreVisitTestData();		

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, proData3.userName, proData3.userPassword);
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Login and search patient successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit the Problem List again	from Pending Encounter						 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit problem list in encounter : B -> C");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEditProblemListFromEncounter(encounterPage,problemListPage);

			patientChartPage.createEncounterProblemListEndToEnd(driver, proData3, userAccount, problemListPage,encounterPage);
			patientChartPage.clickSaveEditProblemList(driver, problemListPage);
			logTitleMessage("Problem list edit in encounter successful");
		    
			//--------------------------------------------------------------------//
			//  Step-10:Cancel the Encounter							 	      //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-11:Verify Problem List in Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Problem List in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyProblemListInSummary(driver, proData, proData2,  userAccount );
			logTitleMessage("Verification successful");
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
		}
	return returnValue;
}
}
