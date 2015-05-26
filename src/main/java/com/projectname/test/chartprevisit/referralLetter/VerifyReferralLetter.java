package com.projectname.test.chartprevisit.referralLetter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.genericutility.testDataLib.SystemSettingsLib;
import com.projectname.testutils.pages.CreateNewPracticePage;
import com.projectname.testutils.pages.CreateNewProviderPage;
import com.projectname.testutils.pages.DemographicsPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.OrganizationalStructurePage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.ReferralLetterPage;
import com.projectname.testutils.pages.ReferringProviderPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.pages.SystemSettingsPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyReferralLetter extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private SystemSettingsPage systemSettingsPage=null;
	private OrganizationalStructurePage organizationalStructurePage=null;
	private CreateNewProviderPage createNewProviderPage=null;
	private ReferralLetterPage referralLetterPage=null;
	private CreateNewPracticePage createNewPracticePage=null;
	private DemographicsPage demographicsPage=null;
	private ReferringProviderPage referringProviderPage=null;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify Referral letter in encounter")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyReferralLetter(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib referralData = new ChartPreVisitLib();
		referralData.workSheetName = "ImplementReferrals";
		referralData.testCaseId = "TC_IRL_001";
		referralData.fetchChartPreVisitTestData();
		verifyReferralLetter(userAccount, referralData, webSite, browser, seleniumHost, seleniumPort);
	}	
		/**
		 * verifyReferralLetter
		 * function to verify Referral Letter
		 * @param		userAccount
		 * @param 		referralData
		 * @param 		browser
		 * @param 		webSite
		 * @param 		seleniumHost
		 * @param		seleniumPort
		 * @throws      Exception 
		 * @since  	    Apr 24, 2015
		 */

	
private boolean verifyReferralLetter(String userAccount,ChartPreVisitLib referralData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
	try
	{
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		logTitleMessage("Login to application");
		LoginPage loginPage=new LoginPage();
		homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, referralData.userName, referralData.userPassword);
		logTitleMessage("Login Successful");	
		
		//--------------------------------------------------------------------//
		//  Step-2: Navigate to Organizational Structure page								 	  //
		//--------------------------------------------------------------------//
		logTitleMessage("Navigate to Organizational Structure page");
		sharedPage=homePage.navigateToSharedPage();
		systemSettingsPage= sharedPage.goToSystemSettings(driver);
		organizationalStructurePage= systemSettingsPage.goToOrganizationalStructure(driver);
		logTitleMessage("Navigated to Organizational Structure page successfully");

		//--------------------------------------------------------------------//
		//  Step-3: Create a new Provider								 	  //
		//--------------------------------------------------------------------//
		logTitleMessage("Create new provider 1");
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateProvider";
		providerData.testCaseId = "TC_PO_011";
		providerData.fetchSystemSettingTestData();

		sharedPage.scrollDownPage(driver);
		systemSettingsPage.deleteProvider(driver, providerData, organizationalStructurePage);
		createNewProviderPage= systemSettingsPage.clickAddNewProvider(driver, organizationalStructurePage);
		systemSettingsPage.createNewProvider(driver, providerData, createNewProviderPage, organizationalStructurePage);
		systemSettingsPage.saveNewProvider(driver, createNewProviderPage, organizationalStructurePage);
		logTitleMessage("Provider 1 created");
		
		logTitleMessage("Create new provider 2");
		sharedPage.scrollDownPage(driver);
		createNewProviderPage= systemSettingsPage.clickAddNewProvider(driver, organizationalStructurePage);
		systemSettingsPage.createNewProvider(driver, providerData, createNewProviderPage, organizationalStructurePage);
		systemSettingsPage.saveNewProvider(driver, createNewProviderPage, organizationalStructurePage);
		logTitleMessage("Provider 2 created");

		logTitleMessage("Create new provider 3");
		sharedPage.scrollDownPage(driver);
		createNewProviderPage= systemSettingsPage.clickAddNewProvider(driver, organizationalStructurePage);
		systemSettingsPage.createNewProvider(driver, providerData, createNewProviderPage, organizationalStructurePage);
		systemSettingsPage.saveNewProvider(driver, createNewProviderPage, organizationalStructurePage);
		logTitleMessage("Provider 3 created");

		logTitleMessage("Associate provider to a practice");
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_016";
		pracData.fetchSystemSettingTestData();

		createNewPracticePage= systemSettingsPage.goToAssociateProviderToPractice(driver, pracData, organizationalStructurePage);
		systemSettingsPage.associateProviderToPractice(driver, providerData, createNewPracticePage, organizationalStructurePage);
		sharedPage.clickNexiaLogo(driver);
		logTitleMessage("provider successfully associated to practice");

		logTitleMessage("Create new external provider with Practice Name only");
		SystemSettingsLib exproviderData = new SystemSettingsLib();
		exproviderData.workSheetName = "CreateExternalProviders";
		exproviderData.testCaseId = "TC_EP_005";
		exproviderData.fetchSystemSettingTestData();
		exproviderData.firstName = exproviderData.practiceName1;
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy HH:MM:SS");
		String uniqueName = dateFormat.format(cal.getTime());
		exproviderData.referringCode= exproviderData.referringCode+uniqueName;
		
		systemSettingsPage= sharedPage.goToSystemSettings(driver);
		referringProviderPage= systemSettingsPage.goToReferringProviderPage(driver);
		systemSettingsPage.deleteExternalProvider(driver, exproviderData.firstName, referringProviderPage);
		systemSettingsPage.clickAddNewExternalProvider(driver, referringProviderPage);
		systemSettingsPage.addNewReferringProvider(driver, exproviderData, referringProviderPage);
		systemSettingsPage.clickSaveReferralProvider(driver, referringProviderPage);
		logTitleMessage("Created successfully new external provider with Practice Name only");

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
		logTitleMessage("Begin encounter and Go to referrals");
		encounterPage = patientChartPage.clickbeginEncounter(driver);
		patientChartPage.beginEncounter(driver, encounterPage);
		referralLetterPage= patientChartPage.navigateToReferralLetterPage(driver, encounterPage);
		logTitleMessage("Navigated to referrals page");

		//--------------------------------------------------------------------//
		//  Step-7:Verify Referral Search Suggest box results			 	  //
		//--------------------------------------------------------------------//		
		logTitleMessage("Verify Referral Search Suggest box results");
		patientChartPage.verifyMultipleProviderNamesInReferralSuggestBox(driver, providerData, providerData.firstName, 3, referralLetterPage, encounterPage);
		patientChartPage.verifyMultipleProviderNamesInReferralSuggestBox(driver, providerData, providerData.lastName, 3, referralLetterPage, encounterPage);
		patientChartPage.verifyMultipleProviderNamesInReferralSuggestBox(driver, exproviderData, exproviderData.practiceName1, 1, referralLetterPage, encounterPage);
		patientChartPage.verifyPracticeInReferralSuggestBox(driver, pracData, providerData, referralLetterPage, encounterPage);
		logTitleMessage("Referral Search Suggest box results verified");
		
	}
	catch(RuntimeException e)
		{
		new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	
	return true;
}

}
