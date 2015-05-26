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
public class VerifyDuplicationOccurenceInDefaultType extends TestBaseClass{
	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private TemplateSettingsPage templateSettingsPage=null;
	private LetterTemplatePage letterTemplatePage=null;
	@Test(retryAnalyzer = RetryRule.class, groups = {"SingleThread", "Regression" ,"Review"}, description = "Test for verify end to end visit flow")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void DuplicationOcuurenceWithYesButton(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception {
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IRL_009";
		letterTemplateTestData.fetchChartPreVisitTestData();
		DuplicationOcuurence(userAccount, letterTemplateTestData, webSite, browser, seleniumHost, seleniumPort);
	}
	@Test(retryAnalyzer = RetryRule.class, groups = {"SingleThread", "Regression" ,"Review"}, description = "Test for verify end to end visit flow")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void DuplicationOcuurenceWithNoButton(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception {
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IRL_010";
		letterTemplateTestData.fetchChartPreVisitTestData();
		DuplicationOcuurence(userAccount, letterTemplateTestData, webSite, browser, seleniumHost, seleniumPort);
	}
	private boolean DuplicationOcuurence(String userAccount,ChartPreVisitLib letterTemplateTestData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
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
			//  Step-3: Delete Already created Referral letter   	              //
			//--------------------------------------------------------------------//
			templateSettingsPage.deleteAllLetterTemplate(driver,letterTemplatePage);
			//--------------------------------------------------------------------//
			//  Step-4: Save Practice as default template    					  //
			//--------------------------------------------------------------------//
			templateSettingsPage.addNewlLetterTemplate(driver,letterTemplatePage);
			templateSettingsPage.addNewReferralTemplate(driver,letterTemplatePage,letterTemplateTestData);
			String uniqueName=templateSettingsPage.verifyPraticeFieldTypesAddDelete(driver,letterTemplatePage,letterTemplateTestData);
			templateSettingsPage.searchWidgetAndDragIntoTemplatePage(driver,letterTemplatePage,uniqueName);
			templateSettingsPage.clickReferralLetterTemplateDefaultCheckBox(driver,letterTemplatePage);
			templateSettingsPage.clickSaveLetterTemplatesButton(driver,letterTemplatePage);
			//--------------------------------------------------------------------//
			//  Step-4: Save PatientPayers as default template    			      //
			//--------------------------------------------------------------------//
			ChartPreVisitLib letterTemplateTestData1 = new ChartPreVisitLib();
			if(letterTemplateTestData.testCaseId.equals("TC_IRL_009"))
			{
			letterTemplateTestData1.workSheetName = "ImplementReferrals";
			letterTemplateTestData1.testCaseId = "TC_IRL_010";
			letterTemplateTestData1.fetchChartPreVisitTestData();
			}
			else
			{
			letterTemplateTestData1.workSheetName = "ImplementReferrals";
			letterTemplateTestData1.testCaseId = "TC_IRL_009";
			letterTemplateTestData1.fetchChartPreVisitTestData();
			}
			templateSettingsPage.addNewlLetterTemplate(driver,letterTemplatePage);
			templateSettingsPage.addNewReferralTemplate(driver,letterTemplatePage,letterTemplateTestData1);
			String uniqueName2=templateSettingsPage.verifyPraticeFieldTypesAddDelete(driver,letterTemplatePage,letterTemplateTestData1);
			templateSettingsPage.searchWidgetAndDragIntoTemplatePage(driver,letterTemplatePage,uniqueName2);
			templateSettingsPage.clickReferralLetterTemplateDefaultCheckBox(driver,letterTemplatePage);
			templateSettingsPage.clickSaveLetterTemplatesButton(driver,letterTemplatePage);
			//---------------------------------------------------------------------------------//
			//  Step-4: Handling the duplication check boxes in over ridding default template  //
			//---------------------------------------------------------------------------------//
			if(letterTemplateTestData.testCaseId.equals("TC_IRL_009"))
			{
				templateSettingsPage.overrideWithYesButton(driver,letterTemplatePage,letterTemplateTestData1);
			}
			else
			{
				templateSettingsPage.overrideWithNoButton(driver,letterTemplatePage,letterTemplateTestData1);
			}
			//---------------------------------------------------------------------------------//
			//  Step-5: Verification Part of over ride                                         //
			//---------------------------------------------------------------------------------//
			if(letterTemplateTestData.testCaseId.equals("TC_IRL_009"))
			{
				templateSettingsPage.verifyTemplateOverride(driver,letterTemplatePage,letterTemplateTestData1);
			}
			else
			{
				templateSettingsPage.verifyTemplateOverride(driver,letterTemplatePage,letterTemplateTestData);
			}
		}catch(RuntimeException e)
		{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return true;
	}
}
