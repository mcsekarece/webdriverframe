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
public class EncounterEndToEndSix extends TestBaseClass{
	@Test(retryAnalyzer = RetryRule.class, groups = {"SingleThread","Review"}, description = "Test to verify Custom defined components and sactions")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyEncounterEndToEndSix(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "CreateVisitSection";
		encounterTemplateTestData.testCaseId = "TC_VS_001";
		encounterTemplateTestData.fetchClinicalSettingsTestData();		
		encounterTemplate(userAccount, encounterTemplateTestData);
	}
	
	/**
	 * Verify Encounter End To End Work flow Six
	 * function to Encounter End To End Work flow Six
	 * Document Name : Encounter end to end.xls
	 * @param encounterTemplateTestData 
	 * @param 		patientData
	 * @param 		browser
	 * @param 		webSite
	 * @throws      Exception 
	 * @since  	    Jan 26, 2015
	 */
	
	public boolean encounterTemplate( String userAccount, ClinicalSettingLib encounterTemplateTestData)  {
		 PatientChartPage patientChartPage=null;
		 HomePage homePage=null;
		 SharedPage sharedPage=null;
		 ClinicalSettingPage clinicalSettingPage=null;
		 PracticeLibrary practiceLibrary=null;
		 EncounterPage encounterPage=null;	
				try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			logTitleMessage("Login Successful");
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, encounterTemplateTestData.userName, encounterTemplateTestData.userPassword);

			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role 									  //
			//--------------------------------------------------------------------//			
			logTitleMessage("Switch practice to Encounter Template ");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.selectPractice(driver,"Encounter");
			sharedPage.switchRole(driver, encounterTemplateTestData.switchRole);
			sharedPage.getProviderName(driver, encounterTemplateTestData);
			logTitleMessage("Switch practice to Encounter Template  succeccful");
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter Template 							  //
			//--------------------------------------------------------------------//
			logTitleMessage("Navigate to practice libraray page and create visit section");
			clinicalSettingPage = sharedPage.navigateToClinicalSettings1(driver);
			practiceLibrary=clinicalSettingPage.navigateToEncounterTemplate(driver);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create a Custom section with widget 					  //
			//--------------------------------------------------------------------//
			clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
			clinicalSettingPage.deleteAllCustomSection(driver, practiceLibrary);
			
			logTitleMessage("Create new Visit Sections C and D, and add them to Default template");
			sharedPage.navigateToClinicalSettings1(driver);
			clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
			
			ClinicalSettingLib sectionCdata = new ClinicalSettingLib();
			sectionCdata.workSheetName = "CreateVisitSection";
			sectionCdata.testCaseId = "TC_VS_007";
			sectionCdata.fetchClinicalSettingsTestData();
			clinicalSettingPage.createVisitSectionWithWidget(driver, sectionCdata, practiceLibrary);
			
			ClinicalSettingLib sectionDdata = new ClinicalSettingLib();
			sectionDdata.workSheetName = "CreateVisitSection";
			sectionDdata.testCaseId = "TC_VS_008";
			sectionDdata.fetchClinicalSettingsTestData();
			clinicalSettingPage.createVisitSectionWithWidget(driver, sectionDdata, practiceLibrary);
			
			//--------------------------------------------------------------------//
			//  Step-5:Add Sections C and D to Visit Outline : Default Template
			//--------------------------------------------------------------------//
			clinicalSettingPage.navigateToVisitoutline(driver, practiceLibrary);
			clinicalSettingPage.selectDefaultTemplate(driver, practiceLibrary);
			clinicalSettingPage.clickOnEncoEdit(driver, practiceLibrary);
			clinicalSettingPage.deleteCustomComponenetInEditDefalutPage(driver, practiceLibrary);
			clinicalSettingPage.addVisitSectionWithVisitOutline(driver, sectionCdata, practiceLibrary);
			
			clinicalSettingPage.navigateToVisitoutline(driver, practiceLibrary);
			clinicalSettingPage.selectDefaultTemplate(driver, practiceLibrary);
			clinicalSettingPage.clickOnEncoEdit(driver, practiceLibrary);
			clinicalSettingPage.addVisitSectionWithVisitOutline(driver, sectionDdata, practiceLibrary);
			logTitleMessage("successfully Created new Visit Sections C and D, and add them to Default template");
			
			//--------------------------------------------------------------------//
			//  Step-6:Search Patient							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Search patient and verify encounter note");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver,  encounterTemplateTestData.patientId);
			
			//--------------------------------------------------------------------//
			//  Step-7:Begin Encounter	and verify Visit Sections C and D in Encounter Note  //
			//--------------------------------------------------------------------//		
			encounterPage=	patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			patientChartPage.verifyNewlyCreatedWidgetsInEncounterNote(driver, sectionCdata, sectionDdata, encounterPage);
			
			//--------------------------------------------------------------------//
			//  Step-8:Cancel Encounter and Navigate to Visit Section						 	  //
			//--------------------------------------------------------------------//
			patientChartPage.cancelEncounter(driver, encounterPage);
			sharedPage.navigateToClinicalSettings1(driver);
			clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
			logTitleMessage("Encounter note verification successful");

			//--------------------------------------------------------------------//
			//  Step-9:Delete Visit Sections C and D from Practice Library						 	  //
			//--------------------------------------------------------------------//
			logTitleMessage("Delete Visit Sections C and D and verfiy in patient encounter note");
			clinicalSettingPage.deleteVisitSections(driver, sectionCdata, practiceLibrary);
			clinicalSettingPage.deleteVisitSections(driver, sectionDdata, practiceLibrary);
			
			//--------------------------------------------------------------------//
			//  Step-10:Search Patient							 	  //
			//--------------------------------------------------------------------//		
			patientChartPage=sharedPage.searchPatientForTestingtester(driver,  encounterTemplateTestData.patientId);

			//--------------------------------------------------------------------//
			//  Step-11:Begin Encounter	and verify Visit Sections C and D not present in Encounter Note  //
			//--------------------------------------------------------------------//		
			patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);			
			patientChartPage.verifyDeletedSectionsInEncounterNote(driver, sectionCdata, sectionDdata, encounterPage);
			logTitleMessage("Deletion of Visit Sections C and D successful");

			//--------------------------------------------------------------------//
			//  Step-12:Cancel Encounter and Navigate to Encounter tab						 	  //
			//--------------------------------------------------------------------//
			patientChartPage.cancelEncounter(driver, encounterPage);
			
			}
catch(Exception e)
{
	assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);	
}
				return true;
	}
	
	}
