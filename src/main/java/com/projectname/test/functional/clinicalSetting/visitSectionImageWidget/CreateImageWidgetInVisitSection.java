package com.projectname.test.functional.clinicalSetting.visitSectionImageWidget;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.pages.ClinicalSettingPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PracticeLibrary;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class CreateImageWidgetInVisitSection extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private ClinicalSettingPage clinicalSettingPage=null;
	private PracticeLibrary practiceLibrary=null;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify Image Widget")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void createImageWidgetInVisitSection(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
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
		clinicalSettingPage.clickCanvasSection(driver, 2, practiceLibrary);
		clinicalSettingPage.clickAddImageWidget(driver, practiceLibrary);
		clinicalSettingPage.createImageWidget(driver, encounterTemplateData, practiceLibrary);
		clinicalSettingPage.savecreatedImageWidget(driver, practiceLibrary);
		logTitleMessage("Image Widget created successfully");

		//--------------------------------------------------------------------//
		//  Step-4: Edit Image Widget for Visit Section					      //
		//--------------------------------------------------------------------//
		logTitleMessage("Cancel Edit Image Widget");
		clinicalSettingPage.verifyEditCreatedImageWidget(driver, encounterTemplateData, practiceLibrary);
		ClinicalSettingLib secondEditData = new ClinicalSettingLib();
		secondEditData.workSheetName = "CreateVisitSection";
		secondEditData.testCaseId = "TC_VS_022";
		secondEditData.fetchClinicalSettingsTestData();

		clinicalSettingPage.createImageWidget(driver, secondEditData, practiceLibrary);
		clinicalSettingPage.saveEditedImageWidget(driver, secondEditData, practiceLibrary);
		clinicalSettingPage.clickCancelEditedImageWidget(driver, practiceLibrary);
		clinicalSettingPage.cancelCreatedImageWidget(driver, practiceLibrary);
		clinicalSettingPage.verifyCreatedImageWidget(driver, encounterTemplateData, practiceLibrary);
		logTitleMessage("Edit Image Widget canceled successfully");

		logTitleMessage("Verify delete Image Widget");
		clinicalSettingPage.clickDeleteImageWidget(driver, practiceLibrary);
		clinicalSettingPage.clickNoDeleteImage(driver, practiceLibrary);
		clinicalSettingPage.verifyCreatedImageWidget(driver, encounterTemplateData, practiceLibrary);
		logTitleMessage("delete Image Widget verified");

		clinicalSettingPage.saveVisitSection(driver, practiceLibrary);
		//--------------------------------------------------------------------//
		//  Step-5: Add Created section with Default visit outline			  //
		//--------------------------------------------------------------------//
		logTitleMessage("Add visit section with default visit outline");
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "CreateVisitSection";
		encounterTemplateTestData.testCaseId = "TC_VS_001";
		encounterTemplateTestData.fetchClinicalSettingsTestData();	

		clinicalSettingPage.navigateToVisitoutline(driver, practiceLibrary);
		clinicalSettingPage.selectDefaultTemplate(driver, practiceLibrary);
		clinicalSettingPage.clickOnEncoEdit(driver, practiceLibrary);
		clinicalSettingPage.deleteCustomComponenetInEditDefalutPage(driver, practiceLibrary);
		clinicalSettingPage.addVisitSectionWithVisitOutline(driver, encounterTemplateTestData, practiceLibrary);
		logTitleMessage("Successfully Added visit section with default visit outline");	

		//--------------------------------------------------------------------//
		//  Step-6:Search Patient										 	  //
		//--------------------------------------------------------------------//		
		logTitleMessage("Search patient");
		patientChartPage=sharedPage.searchPatientForTestingtester(driver, encounterTemplateData.patientId);
		logTitleMessage("Search patient successful");
		
		//--------------------------------------------------------------------//
		//  Step-7:Begin an Encounter and Verify Image Widget   	          //
		//--------------------------------------------------------------------//		
		logTitleMessage("Begin an Encounter and Verify Image Widget");
		encounterPage = patientChartPage.clickbeginEncounter(driver);
		patientChartPage.beginEncounter(driver, encounterPage);
		patientChartPage.verifyImageWidgetInEncounter(driver, encounterTemplateData, encounterTemplateTestData, encounterPage);
		logTitleMessage("Image Widget verified in encounter successfully");

	}
	catch(RuntimeException e)
		{
		new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	
	return true;
}

}
