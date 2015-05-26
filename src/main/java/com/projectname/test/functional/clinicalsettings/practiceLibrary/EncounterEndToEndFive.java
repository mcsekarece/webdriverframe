package com.projectname.test.functional.clinicalsettings.practiceLibrary;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.pages.AllergyPage;
import com.projectname.testutils.pages.ChartDisclosurePage;
import com.projectname.testutils.pages.ClinicalSettingPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LabOrderPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.PracticeLibrary;
import com.projectname.testutils.pages.PrescribeMedicationPage;
import com.projectname.testutils.pages.ProblemListPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class EncounterEndToEndFive extends TestBaseClass{

	
	@Test(retryAnalyzer = RetryRule.class, groups = {"Review"}, description = "Test to verify Custom defined components and Sections",dependsOnGroups = "EncounterEndToEndFour")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyEncounterEndToEndFive(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
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
	 * Verify Encounter End To End Work flow Fifth
	 * function to Encounter End To End Work flow Fifth
	 * Document Name : Encounter end to end.xls
	 * @param encounterTemplateTestData 
	 * @param 		patientData
	 * @param 		browser
	 * @param 		webSite
	 * @throws      Exception 
	 * @since  	    Jan 26, 2015
	 */
	public boolean encounterTemplate( String userAccount, ClinicalSettingLib encounterTemplateTestData, String seleniumHost)  {
			String date1=null;
		 HomePage homePage=null;
		 SharedPage sharedPage=null;
		 ClinicalSettingPage clinicalSettingPage=null;
		 PracticeLibrary practiceLibrary=null;		
		 PatientChartPage patientChartPage=null;
		 EncounterPage encounterPage=null;
		 AllergyPage allergyPage=null;
		 ProblemListPage problemListPage=null;
		 PrescribeMedicationPage prescribeMedicationPage=null;
		try{	
			//--------------------------------------------------------------------//
			//  Step-1: Log in to QA3 application
			//--------------------------------------------------------------------//	
			//Start Video recording 
			startVideoRecording(driver, seleniumHost,"Issue in starting the Video Recording");
			logTitleMessage("Login as First user and Switch practice to Encounter Template ");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, encounterTemplateTestData.userName, encounterTemplateTestData.userPassword);
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.selectPractice(driver,"Encounter");
			sharedPage.unlock(driver);
			logTitleMessage("Successfully Logged in adn switched practice");
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to visit section and create new visit section also edit previous visit section
			//--------------------------------------------------------------------//	
			logTitleMessage("Create New visit Section B  in Clinical setting ");
			clinicalSettingPage = sharedPage.navigateToClinicalSettings1(driver);	
			practiceLibrary=clinicalSettingPage.navigateToEncounterTemplate(driver);
			clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
			ClinicalSettingLib encounterEditTemplateTestData = new ClinicalSettingLib();
			encounterEditTemplateTestData.workSheetName = "CreateVisitSection";
			encounterEditTemplateTestData.testCaseId = "TC_VS_004";
			encounterEditTemplateTestData.fetchClinicalSettingsTestData();
			ClinicalSettingLib encounterTemplateTestData1 = new ClinicalSettingLib();
			encounterTemplateTestData1.workSheetName = "CreateVisitSection";
			encounterTemplateTestData1.testCaseId = "TC_VS_006";
			encounterTemplateTestData1.fetchClinicalSettingsTestData();
			clinicalSettingPage.createSecondVisitSection(driver, encounterEditTemplateTestData, practiceLibrary);	
			logTitleMessage("Successfully Created New visit Section in Clinical setting ");
			logTitleMessage("Edit previously created visit section");
			clinicalSettingPage.editpreviousvisitsection(driver, encounterTemplateTestData1, practiceLibrary);
			logTitleMessage("Successfully edited previously created visit section");
			//--------------------------------------------------------------------//
			//  Step-3: Add Second visit outline with default template 
			//--------------------------------------------------------------------//	
			logTitleMessage("Add new visit section with default visit outline");
			clinicalSettingPage.navigateToVisitoutline(driver, practiceLibrary);
			clinicalSettingPage.selectDefaultTemplate(driver, practiceLibrary);
			clinicalSettingPage.clickOnEncoEdit(driver, practiceLibrary);
			clinicalSettingPage.addSecondVisitSectionWithVisitOutline(driver, encounterEditTemplateTestData, practiceLibrary);
			logTitleMessage("Successfully added new visit section with default visit outline");
			//--------------------------------------------------------------------//
			//  Step-4: Search the previous patient and verify re use widgets 
			//--------------------------------------------------------------------//	
			logTitleMessage("Search patient, Begin encounter, verify template, record widget values and Save encounter");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, encounterTemplateTestData.patientId);
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);		
			//--------------------------------------------------------------------//
			//  Step-5: Verify reused widgets appear in encounter note
			//--------------------------------------------------------------------//	
			clinicalSettingPage.verifyReuseWidegt(driver,encounterEditTemplateTestData,encounterTemplateTestData,practiceLibrary);
			patientChartPage.recordVlaueInReuseWidgetsInEncounterNote(driver, date1,encounterEditTemplateTestData, encounterPage);
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Recorded values in encounter note and saved the encounter");
			//--------------------------------------------------------------------//
			//  Step-6:Open pending encounter sign off and verify the recored values  
			//--------------------------------------------------------------------//	\
			logTitleMessage("Open saved encounter and add Allergy ,Prescribe medication and click print button");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.clickSecondPendingSignOffLabel(driver);
			problemListPage=patientChartPage.goTosummaryProblemList(driver);
			ChartPreVisitLib proData1 = new ChartPreVisitLib();
			proData1.workSheetName = "CreateProblemList";
			proData1.testCaseId = "TC_CPL_012";
			proData1.fetchChartPreVisitTestData();
			problemListPage.createProblemList(proData1, userAccount);
			allergyPage = patientChartPage.nvigatetoSummaryallergy(driver);
			ChartPreVisitLib allergyData1 = new ChartPreVisitLib();
			allergyData1.workSheetName = "CreateAllergy";
			allergyData1.testCaseId = "TC_CA_046";
			allergyData1.fetchChartPreVisitTestData();	
			patientChartPage.clickEditAllergy(driver, encounterPage);
			patientChartPage.createEncounterAllergy(driver, allergyData1, userAccount, encounterPage, allergyPage);
			logTitleMessage("Encounter allergy added successfully");
			//--------------------------------------------------------------------//
			//  Step-7:Create prescribe Medication in encounter note
			//--------------------------------------------------------------------//
			logTitleMessage("Prescribe Medication");
			ChartPreVisitLib prescribeData = new ChartPreVisitLib();
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_009";
			prescribeData.fetchChartPreVisitTestData();
			prescribeMedicationPage=patientChartPage.clickPresMedi(driver, encounterPage);
			patientChartPage.SearchPrescribeMed(driver, prescribeData, userAccount, encounterPage, prescribeMedicationPage);
			patientChartPage.addPrescribeMedication(driver, prescribeData, userAccount, encounterPage, prescribeMedicationPage);
			patientChartPage.clickOnPrintPrescribeMedication(driver, encounterPage, prescribeMedicationPage);
			logTitleMessage("Successfully added allergy and prescribe medication to the encounter ");
			//--------------------------------------------------------------------//
			//  Step-8:Go to lab and search for OLIS reports
			//--------------------------------------------------------------------//
			logTitleMessage("Click Lab Tab->Click Search For OLIS LAb -> Click encounter in progress button");
			patientChartPage.clickOnLab(driver);
			patientChartPage.clickSearchForOLISReportsLink(driver);
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			logTitleMessage("Successfully navigated to lab report page and again navigated to encounter note");
			//--------------------------------------------------------------------//
			//  Step-9:Verify all the recorded values in the Encounter note
			//--------------------------------------------------------------------//
			logTitleMessage("Verify all previously recorded values in each widget");
			assertTrue(patientChartPage.verifyAllRecordedValuesInEncounterNote(driver, prescribeData, allergyData1, userAccount,encounterEditTemplateTestData ,encounterPage),"Verification of recorded value sin encounter note failed", driver, className, methodName);
			patientChartPage.signEncounter(driver, encounterPage);
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.clickSecondencounterExpand();		
			assertTrue(	patientChartPage.verifythirdEncounterDetails(driver, prescribeData, allergyData1, userAccount, encounterEditTemplateTestData, encounterPage),"Verification of show mark page is failed", driver, className, methodName);
			assertTrue(patientChartPage.verifyproblemlistdata(driver, proData1),"Verification of show mark page is failed", driver, className, methodName);
			logTitleMessage("Successfully Verified all previously recorded values in each widget");
			logTitleMessage("Navigate to encounter tab and delete all encounter");
			patientChartPage.clickEncounterTab(driver);
			assertTrue(	patientChartPage.verifyShowMarkupInThirdSignedEncounter(driver, encounterEditTemplateTestData, encounterTemplateTestData1, allergyData1, date1, userAccount),"Verification of show mark page is failed", driver, className, methodName);
			assertTrue(	patientChartPage.verifythirdEncounterDetails(driver, prescribeData, allergyData1, userAccount, encounterEditTemplateTestData, encounterPage),"Verification of show mark page is failed", driver, className, methodName);
			//--------------------------------------------------------------------//
			//  Step-10:Cancel Encounter and Navigate to Encounter tab						 	  //
			//--------------------------------------------------------------------//
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.deleteAllEncounters(driver);
			logTitleMessage("successfully navigated to encounter tab and deleted all encounter");
			logTitleMessage("Verify patient summary -Summary should not have any problem list ,Allergy details");
			assertTrue(patientChartPage.verifyAllergyandMedicationinSummary(driver, allergyData1,userAccount),"Verification of summary page is failed", driver, className, methodName);
			assertTrue(!patientChartPage.verifyTextPresent(proData1.medicalCondition1),"Verification of summary page is failed", driver, className, methodName);
			ChartPreVisitLib proData = new ChartPreVisitLib();
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_CPL_001";
			proData.fetchChartPreVisitTestData();
			assertTrue(!patientChartPage.verifyTextPresent(proData.medicalCondition1),"Verification of summary page is failed", driver, className, methodName);
			//Stop Video Recording 
			stopVideoRecording(driver, className, methodName,"Issue Saving/Stopping Video Recording");
			logTitleMessage("Verified patient summary page");	
		}
		
	catch (Exception e)
	{
		
	}
		return true;
	
	
	
	
	}
}
