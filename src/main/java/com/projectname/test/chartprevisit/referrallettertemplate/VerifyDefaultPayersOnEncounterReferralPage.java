package com.projectname.test.chartprevisit.referrallettertemplate;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.DemographicsPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.LetterTemplatePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientPayersPage;
import com.projectname.testutils.pages.PatientPersonalInfoPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.pages.TemplateSettingsPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class VerifyDefaultPayersOnEncounterReferralPage extends TestBaseClass {
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistrationPage=null;
    private PatientPersonalInfoPage patientPersonalInfoPage=null;
    DemographicsPage demographicsPage=null;
	private TemplateSettingsPage templateSettingsPage=null;
	private LetterTemplatePage letterTemplatePage=null;
	private PatientPayersPage patientPayersPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	@Test(retryAnalyzer = RetryRule.class, groups = {"SingleThread", "Regression" ,"Review"}, description = "Test for verify end to end visit flow")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifyPayersDetailsOnPatientChart(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception {
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IRL_009";
		letterTemplateTestData.fetchChartPreVisitTestData();
		verifyPayersDetailsOnPatientChart(userAccount, letterTemplateTestData, webSite, browser, seleniumHost, seleniumPort);
	}
	private boolean verifyPayersDetailsOnPatientChart(String userAccount,ChartPreVisitLib letterTemplateTestData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, letterTemplateTestData.userName, letterTemplateTestData.userPassword);
			logTitleMessage("Login Successful");
			//--------------------------------------------------------------------//
			//  Step-2: Search patient and navigate to patient chart              //
			//--------------------------------------------------------------------//
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.selectPractice(driver,letterTemplateTestData.practice);
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
			patientData.testCaseId = "TC_NPC_002";
			patientData.fetchHomeTestData();
			logTitleMessage("Navigate to patient Registration page and register a new patient with mandatory details");
			patientRegistrationPage=sharedPage.goToPatientRegPage(driver);
			patientPersonalInfoPage=patientRegistrationPage.createPatientWithMandatory(driver, patientData,userAccount);
			demographicsPage=new DemographicsPage();
			String patientId=demographicsPage.getPatientId(patientPersonalInfoPage,driver);
			patientPayersPage=demographicsPage.navigateToPayersPage(driver);
			demographicsPage.clickAddNewMedicalPayers(driver,patientPayersPage);
			HomeLib payerData = new HomeLib();
			payerData.workSheetName = "AddPayers";
			payerData.testCaseId = "TC_CP_001";
			payerData.fetchHomeTestData();
			demographicsPage.addNewMedicalPayerWithMandatoryFields(driver,patientPayersPage,payerData);
			demographicsPage.saveMedicalPayer(driver,patientPayersPage);
			sharedPage=homePage.navigateToSharedPage();
			templateSettingsPage= sharedPage.goToTemplateSettings(driver);
			letterTemplatePage=templateSettingsPage.goToLetterTemplate(driver);
			//--------------------------------------------------------------------//
			//  Step-3: Delete Already created Referral letter   	              //
			//--------------------------------------------------------------------//
			templateSettingsPage.deleteAllLetterTemplate(driver,letterTemplatePage);
			//--------------------------------------------------------------------//
			//  Step-4: Create Letter Template     								  //
			//--------------------------------------------------------------------//
			templateSettingsPage.addNewlLetterTemplate(driver,letterTemplatePage);
			templateSettingsPage.addNewReferralTemplate(driver,letterTemplatePage,letterTemplateTestData);
			String uniqueName=templateSettingsPage.verifyPatientPayersFieldTypesAddDelete(driver,letterTemplatePage,letterTemplateTestData);
			templateSettingsPage.searchWidgetAndDragIntoTemplatePage(driver,letterTemplatePage,uniqueName);
			templateSettingsPage.clickReferralLetterTemplateDefaultCheckBox(driver,letterTemplatePage);
			templateSettingsPage.clickSaveLetterTemplatesButton(driver,letterTemplatePage);
			sharedPage.navigateToHomePage(driver);
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientId);
			encounterPage=new EncounterPage();
			encounterPage=patientChartPage.clickbeginEncounter(driver);
			encounterPage.beginEncounter(driver);
			patientChartPage.navigateToReferralLetterPage(driver, encounterPage);
			patientChartPage.selectProviderInReferralPage(driver,encounterPage,letterTemplateTestData);
			patientChartPage.verifyPayersDetailsOnThePage(driver,encounterPage,payerData,patientData);
		}catch(RuntimeException e)
		{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return true;
	}
}
