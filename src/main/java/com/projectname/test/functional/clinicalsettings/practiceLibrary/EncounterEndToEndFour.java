package com.projectname.test.functional.clinicalsettings.practiceLibrary;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.projectname.testutils.baseclass.TestBaseClass;
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
public class EncounterEndToEndFour extends TestBaseClass{
	@Test(retryAnalyzer = RetryRule.class, groups = { "EncounterEndToEndFour" }, description = "Test to verify Custom defined components and sactions",dependsOnGroups = "EncounterEndToEndThird")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyEncounterEndToEndFour(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)

	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "CreateVisitSection";
		encounterTemplateTestData.testCaseId = "TC_VS_001";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
	encounterTemplate(userAccount, encounterTemplateTestData,seleniumHost);
	}
	/**
	 * Verify Encounter End To End Work flow Fourth
	 * function to Encounter End To End Work flow Fourth
	 * @param encounterTemplateTestData 
	 * @param 		patientData
	 * @param 		browser
	 * @param 		webSite
	 * @throws      Exception 
	 * @since  	    Jan 26, 2015
	 */
	public boolean encounterTemplate( String userAccount, ClinicalSettingLib encounterTemplateTestData,String seleniumHost)  {
		String date1=null;
		 HomePage homePage=null;
		 SharedPage sharedPage=null;
		 ClinicalSettingPage clinicalSettingPage=null;
		 PracticeLibrary practiceLibrary=null;
		 PatientChartPage patientChartPage=null;
		 EncounterPage encounterPage=null;
	
		try{	
			//--------------------------------------------------------------------//
			//  Step-1:Login into application 				 
			//--------------------------------------------------------------------//
			//Start Video recording 
			startVideoRecording(driver, seleniumHost,"Issue in starting the Video Recording");
			logTitleMessage("Login as First user and Switch practice to Encounter Template ");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, encounterTemplateTestData.userName, encounterTemplateTestData.userPassword);
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.selectPractice(driver,"Encounter");;
			sharedPage.unlock(driver);
			logTitleMessage("Switch practice to Encounter Template successful");

			//--------------------------------------------------------------------//
			//  Step-2:Goto Practice Library								 	  
			//--------------------------------------------------------------------//	
			logTitleMessage("Edit the Visit Section and verfiy in Practice Library");
			clinicalSettingPage = sharedPage.navigateToClinicalSettings1(driver);
			practiceLibrary=clinicalSettingPage.navigateToEncounterTemplate(driver);
			clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
			//--------------------------------------------------------------------//
			//  Step-3:Edit Visit Section									 	  
			//--------------------------------------------------------------------//	
			clinicalSettingPage.goToEditVisitSection(driver, practiceLibrary);
			//--------------------------------------------------------------------//
			//  Step-4:Verify Edited Visit Section								  
			//--------------------------------------------------------------------//
			ClinicalSettingLib encounterTemplateTestData1 = new ClinicalSettingLib();
			encounterTemplateTestData1.workSheetName = "CreateVisitSection";
			encounterTemplateTestData1.testCaseId = "TC_VS_006";
			encounterTemplateTestData1.fetchClinicalSettingsTestData();
			clinicalSettingPage.editVisitSectionWithWidget(driver, encounterTemplateTestData1, practiceLibrary);
			logTitleMessage("successfully edited visit section and verified");
			//--------------------------------------------------------------------//
			//  Step-5:Verify Newly Edited visit section in default template with encounter note 
			//--------------------------------------------------------------------//	
			logTitleMessage("Search patient and verify edited widgets in Encounter note");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, encounterTemplateTestData.patientId);
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			assertTrue(	patientChartPage.VerifyEditedDefaultTemplateInEncounterNote(driver, encounterTemplateTestData1, encounterPage),"Verification of Edited visit section in encounter note failed", driver, className, methodName);
			logTitleMessage("Record values in Edited encounter widgets and save the encounter");
			patientChartPage.recordWidgetsInEditedEncounterNote(driver, encounterTemplateTestData1, date1, encounterPage);
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Recorded values in Edited encounter widgets and saved the encounter");
			logTitleMessage("Navigate to time line and verify the details");
			patientChartPage.clicktimelinedate(driver);
			patientChartPage.verifySecondRecordedWidgetInTimeLine(driver, encounterTemplateTestData1, encounterPage);
			logTitleMessage("Verified encounter details in encounter time line");

			//--------------------------------------------------------------------//
			//  Step-6:Verify Previous Encounter Note 
			//--------------------------------------------------------------------//	
			logTitleMessage("Verify previous encounter values in encounter note");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.editEncounter(driver);
			assertTrue(	patientChartPage.VerifyEditedDefaultTemplateInPrevouusEncounterNote(driver, encounterTemplateTestData, encounterPage),"Verification of Previous template is failed ", driver, className, methodName);	
			patientChartPage.signEncounter(driver, encounterPage);
			sharedPage.clickNexiaLogo(driver);
			//Stop Video Recording 
			stopVideoRecording(driver, className, methodName,"Issue Saving/Stopping Video Recording");
			logTitleMessage("Verification of widgets in previously signed Encounter note successful");
				}
		
		catch(Exception e)
		{
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

		}
		return true;
	
	}
}
