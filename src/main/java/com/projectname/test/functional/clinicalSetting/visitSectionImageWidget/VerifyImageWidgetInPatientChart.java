package com.projectname.test.functional.clinicalSetting.visitSectionImageWidget;

import org.openqa.selenium.Dimension;
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

public class VerifyImageWidgetInPatientChart extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private ClinicalSettingPage clinicalSettingPage=null;
	private PracticeLibrary practiceLibrary=null;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify Upload Of Image In Encounter Note")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyImageWidgetInPatientChart(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib encounterTemplateData = new ClinicalSettingLib();
		encounterTemplateData.workSheetName = "CreateVisitSection";
		encounterTemplateData.testCaseId = "TC_VS_028";
		encounterTemplateData.fetchClinicalSettingsTestData();
		verifyUploadImageInEncounter(userAccount, encounterTemplateData, webSite, browser, seleniumHost, seleniumPort);
	}	
		/**
		 * verifyUploadImageInEncounter
		 * function to verify Image Widget In Patient Chart
		 * @param		userAccount
		 * @param 		referralData
		 * @param 		browser
		 * @param 		webSite
		 * @param 		seleniumHost
		 * @param		seleniumPort
		 * @throws      Exception 
		 * @since  	    May 18, 2015
		 */

	
private boolean verifyUploadImageInEncounter(String userAccount,ClinicalSettingLib encounterTemplateData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
	try
	{
		Dimension dimension1=null, dimension2=null, dimension3=null;
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
		clinicalSettingPage.saveVisitSection(driver, practiceLibrary);
		logTitleMessage("Image Widget created successfully");

		//--------------------------------------------------------------------//
		//  Step-4: Add Created section with Default visit outline			  //
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
		//  Step-5:Search Patient										 	  //
		//--------------------------------------------------------------------//		
		logTitleMessage("Search patient");
		patientChartPage=sharedPage.searchPatientForTestingtester(driver, encounterTemplateData.patientId);
		logTitleMessage("Search patient successful");
		
		//--------------------------------------------------------------------//
		//  Step-6:Begin an Encounter and Verify Image Widget   	          //
		//--------------------------------------------------------------------//		
		logTitleMessage("Begin an Encounter and Upload Image");
		encounterPage = patientChartPage.clickbeginEncounter(driver);
		patientChartPage.beginEncounter(driver, encounterPage);
		patientChartPage.uploadImageInEncounter(driver, encounterTemplateData, encounterPage);
		dimension1=patientChartPage.getImageDimension(driver, dimension1, encounterPage);
		logTitleMessage("Image is uploaded in encounter successfully");

		//--------------------------------------------------------------------//
		//  Step-7:Delete Uploaded Image and Upload a new Image   	          //
		//--------------------------------------------------------------------//		
		logTitleMessage("Delete Uploaded Image and Upload a new Image");
		ClinicalSettingLib encounterTemplateData2 = new ClinicalSettingLib();
		encounterTemplateData2.workSheetName = "CreateVisitSection";
		encounterTemplateData2.testCaseId = "TC_VS_029";
		encounterTemplateData2.fetchClinicalSettingsTestData();

		patientChartPage.deleteUploadedImageInEncounter(driver, encounterPage);
		patientChartPage.uploadImageInEncounter(driver, encounterTemplateData2, encounterPage);
		dimension2=patientChartPage.getImageDimension(driver, dimension2, encounterPage);
		patientChartPage.verifyNewlyUploadedImage(driver, dimension1, dimension2, encounterPage);
		logTitleMessage("Deletion and Updation of Image successful");

		//--------------------------------------------------------------------//
		//  Step-8:Delete Uploaded Image and Upload a new Image   	          //
		//--------------------------------------------------------------------//		
		logTitleMessage("Delete Uploaded Image and Upload a new Image");
		ClinicalSettingLib encounterTemplateData3 = new ClinicalSettingLib();
		encounterTemplateData3.workSheetName = "CreateVisitSection";
		encounterTemplateData3.testCaseId = "TC_VS_029";
		encounterTemplateData3.fetchClinicalSettingsTestData();

		patientChartPage.deleteUploadedImageInEncounter(driver, encounterPage);
		patientChartPage.uploadImageInEncounter(driver, encounterTemplateData3, encounterPage);
		dimension3=patientChartPage.getImageDimension(driver, dimension3, encounterPage);
		patientChartPage.verifyNewlyUploadedImage(driver, dimension2, dimension3, encounterPage);
		logTitleMessage("Deletion and Updation of Image successful");

	}
	catch(RuntimeException e)
		{
		new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	
	return true;
}

}
