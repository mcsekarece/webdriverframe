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
import com.projectname.testutils.pages.ProblemListPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifySaveEditandDeleteEncounter extends TestBaseClass{

	private HomePage homePage;
	private SharedPage sharedPage;
	private PatientRegistationPage patientRegistationPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private ProblemListPage problemListPage;

	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Save Edit and Delete Encounter")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifySaveEditandDeleteEncounter(String userAccount,String website,String browser,String seleniumHost,String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ChartPreVisitLib problemListData = new ChartPreVisitLib();
	 problemListData.workSheetName = "CreateProblemList";
	 problemListData.testCaseId = "TC_DPLE_001";
	 problemListData.fetchChartPreVisitTestData(); 
	 verifySaveEditandDeleteEncounter(problemListData,userAccount);
}

	/**
     * VerifySaveEditandDeleteEncounter
     * To Verify Save Edit and Delete Encounter - one
     * @param problemListData
     * @param userAccount(Application Environment)
     * @since  Mar 11, 2015
     */

	public boolean verifySaveEditandDeleteEncounter(ChartPreVisitLib problemListData, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{			
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,problemListData.userName, problemListData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to Full Access                            // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, problemListData.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			//--------------------------------------------------------------------//
			//  Step-3: Create a new patient 	  //
			//--------------------------------------------------------------------//
			logTitleMessage("Create a new patient");
			sharedPage=homePage.navigateToSharedPage();
			patientRegistationPage= sharedPage.goToPatientRegPage(driver);
			HomeLib patientData = new HomeLib();	
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();	
			patientRegistationPage.createNewPatientWithMandatory(driver,patientData,userAccount);
			logTitleMessage("Patient creation successful");
			
			//--------------------------------------------------------------------//
			//  Step-4:Search newly created Patient							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-4 : Navigate to Problem list page						 	  //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to Problem list page");
			problemListPage = patientChartPage.goToProblemList(driver);
			logTitleMessage("Sucessfully navigated to Problem list page");
			
			//--------------------------------------------------------------------//
			//  Step-5 : Add Problem List in summary page 					 	  //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Add Problem List in summary page");
	        patientChartPage.createProblemListEndToEnd(driver,problemListData,userAccount,problemListPage);
	    	patientChartPage.saveSummaryProblemList(driver, problemListPage);
			logTitleMessage("Sucessfully Added Problem List in summary page");
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Begin encounter page 						  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Begin encounter page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated into Begin encounter page");
						
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Edit Problem List in encounter page	     	  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Edit Problem List in encounter page");
			patientChartPage.goToEncounterProblemList(driver,encounterPage);
			patientChartPage.clickEditProblemList(problemListPage);
			logTitleMessage("Sucessfully Navigated to Edit Problem List in encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-8:  Edit Problem List in encounter page	     	  		// 
			//--------------------------------------------------------------------//		
			
			ChartPreVisitLib problemListData1 = new ChartPreVisitLib();
			problemListData1.workSheetName = "CreateProblemList";
			problemListData1.testCaseId = "TC_DPLE_002";
			problemListData1.fetchChartPreVisitTestData(); 
			
			logTitleMessage("Edit the Problem List in encounter page A --> B");
			patientChartPage.createEncounterProblemListEndToEnd(driver, problemListData1, userAccount, problemListPage,encounterPage);
			patientChartPage.clickSaveEditProblemList(driver, problemListPage);
			logTitleMessage("Sucessfully Edited the Problem List in encounter page A --> B");
			
			//--------------------------------------------------------------------//
			//  Step-9:   Save the Encounter 	  								  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Save the encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter");
		
			//--------------------------------------------------------------------//
			//  Step-10:   Delete the Encounter 	  							  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Delete the encounter");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.deleteAllEncounters(driver);
			logTitleMessage("Sucessfully deleted the encounter");
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify Problem List in Summary							  //
			//--------------------------------------------------------------------//	
			
			ChartPreVisitLib problemListDataEdited = new ChartPreVisitLib();
			problemListDataEdited = problemListData;
			 
			logTitleMessage("Verify Problem List in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyProblemListInSummary(driver, problemListData,problemListDataEdited,userAccount);
			logTitleMessage("Successfully verified the Problem List in Summary");
		
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
}
