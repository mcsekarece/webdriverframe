package com.projectname.test.chartprevisit.referrallettertemplate;

import org.testng.annotations.Listeners;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LetterTemplatePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.pages.TemplateSettingsPage;
import com.projectname.testutils.retryAnalyser.RetryRule;


@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class VerifyFieldTypePickList extends TestBaseClass{
	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private TemplateSettingsPage templateSettingsPage=null;
	private LetterTemplatePage letterTemplatePage=null;
@Test(retryAnalyzer = RetryRule.class, groups = {"SingleThread", "Regression" ,"Review"}, description = "Test for verify end to end visit flow")
@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
public void validateFieldTypePickListWithTheProperty(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception {
	className=this.getClass().getName().substring(39);	
	methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
	letterTemplateTestData.workSheetName = "ImplementReferrals";
	letterTemplateTestData.testCaseId = "TC_IRL_003";
	letterTemplateTestData.fetchChartPreVisitTestData();
	FieldTypePickListData(userAccount, letterTemplateTestData, webSite, browser, seleniumHost, seleniumPort);
}
private boolean FieldTypePickListData(String userAccount,ChartPreVisitLib letterTemplateTestData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
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
		//  Step-2: Navigate to Letter Template                               //
		//--------------------------------------------------------------------//
		logTitleMessage("Navigate to Letter Template and get Default Template Name");
		sharedPage=homePage.navigateToSharedPage();
		templateSettingsPage= sharedPage.goToTemplateSettings(driver);
		letterTemplatePage=templateSettingsPage.goToLetterTemplate(driver);
		//--------------------------------------------------------------------//
		//  Step-3: Verify Patient widgets    								 //
		//--------------------------------------------------------------------//
		templateSettingsPage.addNewlLetterTemplate(driver,letterTemplatePage);
		templateSettingsPage.verifyPracticeFieldTypes(driver,letterTemplatePage,letterTemplateTestData);
		//--------------------------------------------------------------------//
		//  Step-4: Verify Patient widgets    								 //
		//--------------------------------------------------------------------//
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IRL_004";
		letterTemplateTestData.fetchChartPreVisitTestData();
		templateSettingsPage.verifyPatientPayersFieldType(driver,letterTemplatePage,letterTemplateTestData);
	}catch(RuntimeException e)
	{
		new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
	}

return true;

}
}