package com.projectname.test.functional.clinicalSetting.visitSectionImageWidget;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.pages.ClinicalSettingPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PracticeLibrary;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyImageWidget extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private ClinicalSettingPage clinicalSettingPage=null;
	private PracticeLibrary practiceLibrary=null;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify Image Widget")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyImageWidgets(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib encounterTemplateData = new ClinicalSettingLib();
		encounterTemplateData.workSheetName = "CreateVisitSection";
		encounterTemplateData.testCaseId = "TC_VS_020";
		encounterTemplateData.fetchClinicalSettingsTestData();
		verifyImageWidget(userAccount, encounterTemplateData, webSite, browser, seleniumHost, seleniumPort);
	}	
		/**
		 * verifyImageWidget
		 * function to verify Image Widget
		 * @param		userAccount
		 * @param 		referralData
		 * @param 		browser
		 * @param 		webSite
		 * @param 		seleniumHost
		 * @param		seleniumPort
		 * @throws      Exception 
		 * @since  	    May 05, 2015
		 */

	
private boolean verifyImageWidget(String userAccount,ClinicalSettingLib encounterTemplateData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
	try
	{
		int count=2;
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		logTitleMessage("Login to application");
		LoginPage loginPage=new LoginPage();
		homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, encounterTemplateData.userName, encounterTemplateData.userPassword);
		logTitleMessage("Login Successful");	

		//--------------------------------------------------------------------//
		//  Step-2: Navigate to Clinical Settings -> Visit Section			  //
		//--------------------------------------------------------------------//			
		logTitleMessage("Navigate to Clinical Settings -> Visit Section");
		sharedPage=homePage.navigateToSharedPage();
		sharedPage.switchRole(driver, encounterTemplateData.switchRole);
		clinicalSettingPage = sharedPage.navigateToClinicalSettings1(driver);
		practiceLibrary=clinicalSettingPage.navigateToEncounterTemplate(driver);
		clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
		clinicalSettingPage.deleteAllCustomSection(driver, practiceLibrary);		
		logTitleMessage("Navigated to Clinical Settings -> Visit Section");

		//--------------------------------------------------------------------//
		//  Step-3: Create a Empty Image Widget for Visit Section			  //
		//--------------------------------------------------------------------//
		logTitleMessage("Create a Empty Image Widget");
		clinicalSettingPage.goToCreateNewVisitSection(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.clickCanvasSection(driver, count, practiceLibrary);
		clinicalSettingPage.clickAddImageWidget(driver, practiceLibrary);
		clinicalSettingPage.savecreatedImageWidget(driver, practiceLibrary);
		clinicalSettingPage.verifyEmptyImageWidget(driver, practiceLibrary);
		clinicalSettingPage.cancelCreatedImageWidget(driver, practiceLibrary);
		logTitleMessage("Empty Image Widget verified successfully");

		//--------------------------------------------------------------------//
		//  Step-4: Create a Image Widget for Visit Section				      //
		//--------------------------------------------------------------------//
		logTitleMessage("Create a Image Widget for Visit Section");
		count= clinicalSettingPage.clickCanvasSection(driver, count, practiceLibrary);
		clinicalSettingPage.clickAddImageWidget(driver, practiceLibrary);
		clinicalSettingPage.createImageWidget(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.savecreatedImageWidget(driver, practiceLibrary);
		logTitleMessage("Image Widget created successfully");
		
		//--------------------------------------------------------------------//
		//  Step-5: Create a Image Widget from already created Widget	      //
		//--------------------------------------------------------------------//
		logTitleMessage("Create a Image Widget from already created Widget");
		ClinicalSettingLib editData = new ClinicalSettingLib();
		editData.workSheetName = "CreateVisitSection";
		editData.testCaseId = "TC_VS_023";
		editData.fetchClinicalSettingsTestData();

		clinicalSettingPage.clickCanvasSection(driver, count, practiceLibrary);
		clinicalSettingPage.clickImageWidgetCollapse(driver, practiceLibrary);	
		clinicalSettingPage.clickEditImageWidgetInCollapseView(driver, practiceLibrary);
		clinicalSettingPage.verifyEditCreatedImageWidget(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.createImageWidget(driver, editData, practiceLibrary);
		clinicalSettingPage.saveEditedImageWidget(driver, editData, practiceLibrary);
		clinicalSettingPage.clickSaveEditedImageWidget(driver, practiceLibrary);
		clinicalSettingPage.verifyCreatedImageWidget(driver, editData, practiceLibrary);
		logTitleMessage("Created a Image Widget from already created Widget successfully");

		//--------------------------------------------------------------------//
		//  Step-6: Create a Image Widget from already created Widget and Cancel //
		//--------------------------------------------------------------------//
		logTitleMessage("Create a Image Widget from already created Widget and Cancel");
		ClinicalSettingLib secondEditData = new ClinicalSettingLib();
		secondEditData.workSheetName = "CreateVisitSection";
		secondEditData.testCaseId = "TC_VS_022";
		secondEditData.fetchClinicalSettingsTestData();

		clinicalSettingPage.clickCanvasSection(driver, count, practiceLibrary);
		clinicalSettingPage.clickImageWidgetCollapse(driver, practiceLibrary);	
		clinicalSettingPage.clickEditImageWidgetInCollapseView(driver, practiceLibrary);
		clinicalSettingPage.createImageWidget(driver, secondEditData, practiceLibrary);
		clinicalSettingPage.cancelCreatedImageWidget(driver, practiceLibrary);
		clinicalSettingPage.verifyCreatedImageWidget(driver, editData, practiceLibrary);
		logTitleMessage("Cancel Image Widget Successful");

		//--------------------------------------------------------------------//
		//  Step-7: Add a Image Widget from already created Widget			  //
		//--------------------------------------------------------------------//
		logTitleMessage("Add a Image Widget from already created Widget");
		clinicalSettingPage.clickCanvasSection(driver, count, practiceLibrary);
		clinicalSettingPage.clickImageWidgetCollapse(driver, practiceLibrary);	
		clinicalSettingPage.clickAddImageWidgetInCollapseView(driver, practiceLibrary);
		logTitleMessage("Added Image Widget Successful");
		
		clinicalSettingPage.deleteAllImageWidgets(driver, practiceLibrary);
		
		
	}
	catch(RuntimeException e)
		{
		new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	
	return true;
	}
	
}
