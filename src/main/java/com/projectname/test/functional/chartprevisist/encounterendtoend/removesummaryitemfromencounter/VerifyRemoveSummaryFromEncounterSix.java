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
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.ProblemListPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class VerifyRemoveSummaryFromEncounterSix extends TestBaseClass{

	private HomePage homePage;
	private SharedPage sharedPage;
	private PatientRegistationPage patientRegistationPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private ProblemListPage problemListPage;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Remove Summary Item From Encounter - Six")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	
	public void verifyRemoveSummaryFromEncounterSix(String userAccount,String website,String browser,String seleniumHost, String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ChartPreVisitLib problemListData = new ChartPreVisitLib();
	 problemListData.workSheetName = "CreateProblemList";
	 problemListData.testCaseId = "TC_DPLE_001";
	 problemListData.fetchChartPreVisitTestData(); 
	 VerifyRemoveSummaryFromEncounter(problemListData,userAccount);
}

	/**
     * VerifyRemoveSummaryFromEncounter
     * To Verify Remove Summary Item From Encounter - Six
     * @param problemListData
     * @param userAccount(Application Environment)
     * @since  Mar 23, 2015
     */

	public boolean VerifyRemoveSummaryFromEncounter(ChartPreVisitLib problemListData, String userAccount) throws Exception{
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
			//  Step-3: Create a new patient 	  								 //
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
			
			logTitleMessage("Navigate to  Problem List in encounter page");
			problemListPage = patientChartPage.goToEncounterProblemList(driver,encounterPage);
			logTitleMessage("Sucessfully Navigated to Problem List in encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-7:  Add  the Problem List in encounter page	     	      // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Add the Problem List in encounter page A");
			patientChartPage.createEncounterProblemListEndToEnd(driver, problemListData, userAccount, problemListPage,encounterPage);
			patientChartPage.addEncounterProblemList(driver, problemListPage);
			logTitleMessage("Sucessfully Added the Problem List in encounter page A");
			
			//------------------------------------------------------------------------//
			//  Step-8:  Remove the Problem List A in encounter page 				  // 
			//-----------------------------------------------------------------------//		
			
			logTitleMessage("Remove the Problem List A ");
			patientChartPage.removeEncounterProblemList(encounterPage);
			logTitleMessage("Sucessfully removed Problem List A");
			
			//--------------------------------------------------------------------//
			//  Step-9:Cancel the Encounter							 	          //
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");
			
			//--------------------------------------------------------------------//
			//  Step-10:Verify Problem List is blank in Summary Page        	 //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Problem List is blank in Summary Page");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyBlankProblemList(problemListData);
			logTitleMessage("Successfully verified the Problem List is blank in Summary Page");
			
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}

}
