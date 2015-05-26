package com.projectname.test.chartprevisit.referralLetter;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.DemographicsPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LetterTemplatePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.ProblemListPage;
import com.projectname.testutils.pages.ReferralLetterPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.pages.TemplateSettingsPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyReferralContents extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private ReferralLetterPage referralLetterPage=null;
	private DemographicsPage demographicsPage=null;
	private TemplateSettingsPage templateSettingsPage=null;
	private LetterTemplatePage letterTemplatePage=null;
	private ProblemListPage problemListPage=null;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify Referral letter contents")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyReferralLetterContents(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib referralData = new ChartPreVisitLib();
		referralData.workSheetName = "ImplementReferrals";
		referralData.testCaseId = "TC_IRL_001";
		referralData.fetchChartPreVisitTestData();
		verifyContents(userAccount, referralData, webSite, browser, seleniumHost, seleniumPort);
	}	
		/**
		 * verifyContents
		 * function to verify Referral Letter Contents
		 * @param		userAccount
		 * @param 		referralData
		 * @param 		browser
		 * @param 		webSite
		 * @param 		seleniumHost
		 * @param		seleniumPort
		 * @throws      Exception 
		 * @since  	    Apr 27, 2015
		 */

	
private boolean verifyContents(String userAccount,ChartPreVisitLib referralData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
	try
	{
		String defaultTemplateName="";
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		logTitleMessage("Login to application");
		LoginPage loginPage=new LoginPage();
		homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, referralData.userName, referralData.userPassword);
		logTitleMessage("Login Successful");	
		
		//--------------------------------------------------------------------//
		//  Step-2: Navigate to Letter Template and get Default Template Name //
		//--------------------------------------------------------------------//
		logTitleMessage("Navigate to Letter Template and get Default Template Name");
		sharedPage=homePage.navigateToSharedPage();
		templateSettingsPage= sharedPage.goToTemplateSettings(driver);
		letterTemplatePage=templateSettingsPage.goToLetterTemplate(driver);
		defaultTemplateName= templateSettingsPage.getDefaultTemplateName(driver, letterTemplatePage);
		referralData.letterTemplateName= defaultTemplateName;
		sharedPage.clickNexiaLogo(driver);
		logTitleMessage("Navigated to Letter Template and get Default Template Name successful");

		//--------------------------------------------------------------------//
		//  Step-4: Create a new patient								 	  //
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
		//  Step-5:Search newly created Patient							 	  //
		//--------------------------------------------------------------------//		
		logTitleMessage("Search patient");
		demographicsPage=sharedPage.searchPatientNexiaForProviderHomePage(driver, patientData.lastName);
		patientChartPage=demographicsPage.goToChart(driver);
		logTitleMessage("Search patient successful");

		//--------------------------------------------------------------------//
		//  Step-6:Begin an Encounter							 	          //
		//--------------------------------------------------------------------//		
		logTitleMessage("Begin encounter and add Problem List");
		encounterPage = patientChartPage.clickbeginEncounter(driver);
		patientChartPage.beginEncounter(driver, encounterPage);
		 ChartPreVisitLib encounterData = new ChartPreVisitLib();
		 encounterData.workSheetName = "Cosign";
		 encounterData.testCaseId = "TC_CO_018";
		 encounterData.fetchChartPreVisitTestData();
		patientChartPage.selectAssessment(encounterPage, encounterData.medicalCondition);

		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPLE_005";
		proData.fetchChartPreVisitTestData();		

		problemListPage= patientChartPage.goToEncounterProblemList(driver,encounterPage);
		patientChartPage.createEncounterProblemListEndToEnd(driver, proData, userAccount, problemListPage,encounterPage);
		patientChartPage.addEncounterProblemList(driver, problemListPage);
		logTitleMessage("Added Problem list in encounter successfully");
		
		//--------------------------------------------------------------------//
		//  Step-6:Add a referral  								 	          //
		//--------------------------------------------------------------------//		
		logTitleMessage("Add a referral");
		referralLetterPage= patientChartPage.navigateToReferralLetterPage(driver, encounterPage);
		patientChartPage.addNewReferralLetter(driver, referralData, referralLetterPage, encounterPage);
		logTitleMessage("Referral added successfully");
		
		logTitleMessage("Add another referral");
		referralLetterPage= patientChartPage.navigateToReferralLetterPage(driver, encounterPage);
		ChartPreVisitLib referralData2 = new ChartPreVisitLib();
		referralData2.workSheetName = "ImplementReferrals";
		referralData2.testCaseId = "TC_IRL_002";
		referralData2.fetchChartPreVisitTestData();

		logTitleMessage("Verify Head Icon");
		patientChartPage.verifyHeadIconInSearch(driver, referralData2, referralLetterPage, encounterPage);
		logTitleMessage("Head Icon is present");
		
		logTitleMessage("Verify default template and letter contents");
		patientChartPage.verifyLetterContents(driver, referralData2, defaultTemplateName, referralLetterPage, encounterPage);
		logTitleMessage("Default template and letter contents verified");

		logTitleMessage("Verify Assessment in letter");
		patientChartPage.verifyAssessmentInLetter(driver, proData, referralLetterPage, encounterPage);
		logTitleMessage("Assessment verified in letter successfully");

	}
	catch(RuntimeException e)
		{
		new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	
	return true;
}

}
