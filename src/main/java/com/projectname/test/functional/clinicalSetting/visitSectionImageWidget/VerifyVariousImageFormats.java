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

public class VerifyVariousImageFormats extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private ClinicalSettingPage clinicalSettingPage=null;
	private PracticeLibrary practiceLibrary=null;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to Verify Various Image Formats that can be used in Image Widget")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyVariousImageFormats(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib encounterTemplateData = new ClinicalSettingLib();
		encounterTemplateData.workSheetName = "CreateVisitSection";
		encounterTemplateData.testCaseId = "TC_VS_025";
		encounterTemplateData.fetchClinicalSettingsTestData();
		verifyImageFormats(userAccount, encounterTemplateData, webSite, browser, seleniumHost, seleniumPort);
	}	
		/**
		 * verifyImageFormats
		 * function to verify Image Widget
		 * @param		userAccount
		 * @param 		referralData
		 * @param 		browser
		 * @param 		webSite
		 * @param 		seleniumHost
		 * @param		seleniumPort
		 * @throws      Exception 
		 * @since  	    May 11, 2015
		 */

	
private boolean verifyImageFormats(String userAccount,ClinicalSettingLib encounterTemplateData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
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
		//  Step-3: Create a Image Widget for Visit Section	with .png		  //
		//--------------------------------------------------------------------//
		logTitleMessage("Create a Image Widget for Visit Section with PNG Image");
		clinicalSettingPage.goToCreateNewVisitSection(driver, encounterTemplateData, practiceLibrary);
		count=clinicalSettingPage.clickCanvasSection(driver, count, practiceLibrary);
		clinicalSettingPage.clickAddImageWidget(driver, practiceLibrary);
		clinicalSettingPage.createImageWidget(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.savecreatedImageWidget(driver, practiceLibrary);
		clinicalSettingPage.verifyCreatedImageWidget(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.saveVisitSection(driver, practiceLibrary);
		logTitleMessage("Image Widget created successfully with PNG");
		
		//--------------------------------------------------------------------//
		//  Step-4: Create a Image Widget for Visit Section	with .bmp		  //
		//--------------------------------------------------------------------//
		logTitleMessage("Create a Image Widget for Visit Section with BMP Image");
		encounterTemplateData.workSheetName = "CreateVisitSection";
		encounterTemplateData.testCaseId = "TC_VS_026";
		encounterTemplateData.fetchClinicalSettingsTestData();

		clinicalSettingPage.goToCreateNewVisitSection(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.clickCanvasSection(driver, count, practiceLibrary);
		clinicalSettingPage.clickAddImageWidget(driver, practiceLibrary);
		clinicalSettingPage.createImageWidget(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.savecreatedImageWidget(driver, practiceLibrary);
		clinicalSettingPage.verifyCreatedImageWidget(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.saveVisitSection(driver, practiceLibrary);
		logTitleMessage("Image Widget created successfully with BMP");
		

		//--------------------------------------------------------------------//
		//  Step-5: Create a Image Widget for Visit Section	with .txt		  //
		//--------------------------------------------------------------------//
		logTitleMessage("Create a Image Widget for Visit Section with Non-Image file");
		encounterTemplateData.workSheetName = "CreateVisitSection";
		encounterTemplateData.testCaseId = "TC_VS_027";
		encounterTemplateData.fetchClinicalSettingsTestData();

		clinicalSettingPage.goToCreateNewVisitSection(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.clickCanvasSection(driver, count, practiceLibrary);
		clinicalSettingPage.clickAddImageWidget(driver, practiceLibrary);
		clinicalSettingPage.createImageWidget(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.savecreatedImageWidget(driver, practiceLibrary);
		clinicalSettingPage.verifyCreatedImageWidget(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.saveVisitSection(driver, practiceLibrary);
		logTitleMessage("Image Widget verified successfully with Non-Image file");

	}
	catch(RuntimeException e)
		{
		new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	
	return true;
}

}
