package com.projectname.test.chartprevisit.referrallettertemplate;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.SystemSettingsLib;
import com.projectname.testutils.pages.CreateNewPracticePage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LetterTemplatePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.OrganizationalStructurePage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.pages.SystemSettingsPage;
import com.projectname.testutils.pages.TemplateSettingsPage;
import com.projectname.testutils.retryAnalyser.RetryRule;


@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class VerifyDefaultPracticeOnEncounterReferralPage extends TestBaseClass{
	private SharedPage sharedPage=null;
	private TemplateSettingsPage templateSettingsPage=null;
	private LetterTemplatePage letterTemplatePage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private CreateNewPracticePage createNewPractice=null;
	private SystemSettingsPage systemSettingsPage=null;
	private OrganizationalStructurePage organizationalStructurePage=null;
	@Test(retryAnalyzer = RetryRule.class, groups = {"SingleThread", "Regression" ,"Review"}, description = "Test for verify end to end visit flow")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifyPracticeDetailsOnPatientChart(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception {
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IRL_009";
		letterTemplateTestData.fetchChartPreVisitTestData();
		verifyPracticeDetailsOnPatientChart(userAccount, letterTemplateTestData, webSite, browser, seleniumHost, seleniumPort);
	}
	private boolean verifyPracticeDetailsOnPatientChart(String userAccount,ChartPreVisitLib letterTemplateTestData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
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
			systemSettingsPage= sharedPage.goToSystemSettings(driver);
			organizationalStructurePage= systemSettingsPage.goToOrganizationalStructure(driver);
			SystemSettingsLib pracData = new SystemSettingsLib();
			pracData.workSheetName = "CreatePractice";
			pracData.testCaseId = "TC_CPR_016";
			pracData.fetchSystemSettingTestData();
			systemSettingsPage.goToAssociateProviderToPractice(driver, pracData, organizationalStructurePage);
			createNewPractice=new CreateNewPracticePage();
			organizationalStructurePage.editAlreadyOpenPractice(driver,createNewPractice);
			organizationalStructurePage.readValuesFromThePractice(driver,createNewPractice,letterTemplateTestData);
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
			String uniqueName=templateSettingsPage.verifyPraticeFieldTypesAddDelete(driver,letterTemplatePage,letterTemplateTestData);
			templateSettingsPage.searchWidgetAndDragIntoTemplatePage(driver,letterTemplatePage,uniqueName);
			templateSettingsPage.clickReferralLetterTemplateDefaultCheckBox(driver,letterTemplatePage);
			templateSettingsPage.clickSaveLetterTemplatesButton(driver,letterTemplatePage);
			sharedPage.navigateToHomePage(driver);
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, letterTemplateTestData.patientId);
			//--------------------------------------------------------------------//
			//  Step-2: Begin an Encounter                                        //
			//--------------------------------------------------------------------//
			encounterPage=new EncounterPage();
			encounterPage=patientChartPage.clickbeginEncounter(driver);
			encounterPage.beginEncounter(driver);
			patientChartPage.navigateToReferralLetterPage(driver, encounterPage);
			patientChartPage.selectProviderInReferralPage(driver,encounterPage,letterTemplateTestData);
			patientChartPage.verifyPracticeDetailsOnThePage(driver,encounterPage,letterTemplateTestData);
		}catch(RuntimeException e)
		{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return true;
	}

}
