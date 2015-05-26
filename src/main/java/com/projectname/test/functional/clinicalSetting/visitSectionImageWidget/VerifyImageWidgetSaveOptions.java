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

public class VerifyImageWidgetSaveOptions extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private ClinicalSettingPage clinicalSettingPage=null;
	private PracticeLibrary practiceLibrary=null;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify Image Widget")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyImageWidgetSaveOptions(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib encounterTemplateData = new ClinicalSettingLib();
		encounterTemplateData.workSheetName = "CreateVisitSection";
		encounterTemplateData.testCaseId = "TC_VS_020";
		encounterTemplateData.fetchClinicalSettingsTestData();
		verifySaveOptions(userAccount, encounterTemplateData, webSite, browser, seleniumHost, seleniumPort);
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
		 * @since  	    May 08, 2015
		 */

	
private boolean verifySaveOptions(String userAccount,ClinicalSettingLib encounterTemplateData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
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
		//  Step-3: Create a Image Widget for Visit Section					  //
		//--------------------------------------------------------------------//
		logTitleMessage("Create a Image Widget for Visit Section");
		clinicalSettingPage.goToCreateNewVisitSection(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.clickCanvasSection(driver, count, practiceLibrary);
		clinicalSettingPage.clickAddImageWidget(driver, practiceLibrary);
		clinicalSettingPage.createImageWidget(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.savecreatedImageWidget(driver, practiceLibrary);
		clinicalSettingPage.placeMarkerOnImage(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.saveVisitSection(driver, practiceLibrary);
		logTitleMessage("Image Widget created successfully");

		//--------------------------------------------------------------------//
		//  Step-5: Verify 'Save as a new widget ' option    			      //
		//--------------------------------------------------------------------//
		logTitleMessage("Verify Save as a new widget");
		ClinicalSettingLib secondEditData = new ClinicalSettingLib();
		secondEditData.workSheetName = "CreateVisitSection";
		secondEditData.testCaseId = "TC_VS_024";
		secondEditData.fetchClinicalSettingsTestData();

		clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
		clinicalSettingPage.goToCreateNewVisitSection(driver, secondEditData, practiceLibrary);
		count=clinicalSettingPage.clickCanvasSection(driver, count, practiceLibrary);
		clinicalSettingPage.clickImageWidgetCollapse(driver, practiceLibrary);	
		clinicalSettingPage.clickEditImageWidgetInCollapseView(driver, practiceLibrary);
		clinicalSettingPage.createImageWidget(driver, secondEditData, practiceLibrary);
		clinicalSettingPage.saveEditedImageWidget(driver, secondEditData, practiceLibrary);
		clinicalSettingPage.clickSaveEditedImageWidget(driver, practiceLibrary);
		clinicalSettingPage.verifyCreatedImageWidget(driver, secondEditData, practiceLibrary);
		clinicalSettingPage.saveVisitSection(driver, practiceLibrary);

		clinicalSettingPage.selectVisitSection(driver,encounterTemplateData.SectionName, practiceLibrary);
		clinicalSettingPage.clickEditVisitSection(driver, practiceLibrary);
		clinicalSettingPage.verifyCreatedImageWidget(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.saveVisitSection(driver, practiceLibrary);
		logTitleMessage("Save as a new widget verified successfully");

		//--------------------------------------------------------------------//
		//  Step-4: Verify 'Save as same widget ' option    			      //
		//--------------------------------------------------------------------//
		logTitleMessage("Verify Save as a same widget");
		ClinicalSettingLib editData = new ClinicalSettingLib();
		editData.workSheetName = "CreateVisitSection";
		editData.testCaseId = "TC_VS_023";
		editData.fetchClinicalSettingsTestData();

		clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
		clinicalSettingPage.selectVisitSection(driver,secondEditData.SectionName, practiceLibrary);
		clinicalSettingPage.clickEditVisitSection(driver, practiceLibrary);
		clinicalSettingPage.clickCanvasSection(driver, count, practiceLibrary);
		clinicalSettingPage.clickImageWidgetCollapse(driver, practiceLibrary);	
		clinicalSettingPage.clickEditImageWidgetInCollapseView(driver, practiceLibrary);
		clinicalSettingPage.createImageWidget(driver, editData, practiceLibrary);
		clinicalSettingPage.saveEditedImageWidget(driver, editData, practiceLibrary);
		clinicalSettingPage.clickSaveEditedImageWidget(driver, practiceLibrary);
		clinicalSettingPage.verifyCreatedImageWidget(driver, editData, practiceLibrary);
		clinicalSettingPage.saveVisitSection(driver, practiceLibrary);

		clinicalSettingPage.selectVisitSection(driver,encounterTemplateData.SectionName, practiceLibrary);
		clinicalSettingPage.clickEditVisitSection(driver, practiceLibrary);
		clinicalSettingPage.verifyCreatedImageWidget(driver, editData, practiceLibrary);
		clinicalSettingPage.saveVisitSection(driver, practiceLibrary);
		logTitleMessage("Save as same widget verified successfully");


	}
	catch(RuntimeException e)
		{
		new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	
	return true;
}

}
