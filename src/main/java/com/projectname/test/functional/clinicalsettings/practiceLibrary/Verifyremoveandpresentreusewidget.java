package com.projectname.test.functional.clinicalsettings.practiceLibrary;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.AllergyPage;
import com.projectname.testutils.pages.ClinicalSettingPage;
import com.projectname.testutils.pages.DemographicsPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.PracticeLibrary;
import com.projectname.testutils.pages.PrescribeMedicationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class Verifyremoveandpresentreusewidget  extends TestBaseClass{
	HomePage homePage;
	SharedPage sharedPage;
	ClinicalSettingPage clinicalSettingPage;
	PracticeLibrary practiceLibrary;
	PatientRegistationPage patientRegistationPage;
	PatientChartPage patientChartPage;
	EncounterPage encounterPage;
	AllergyPage allergyPage;
	DemographicsPage demographicsPage;
	PrescribeMedicationPage prescribeMedicationPage;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "SingleThread","Review" }, description = "Test to verify Custom defined components and sactions")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifyremoveandpresentreusewidgets(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "CreateVisitSection";
		encounterTemplateTestData.testCaseId = "TC_VS_001";
		encounterTemplateTestData.fetchClinicalSettingsTestData();		
		verifyRemoveReuseofSection(userAccount, encounterTemplateTestData);
	}

	/**
	 * Verify Encounter End To End Delete and Reuse  scenario 
	 * Function to Encounter End To End Delete and Reuse  scenario  
	 * Document Name : Encounter end to end.xls
	 * @param encounterTemplateTestData 
	 * @param 		patientData
	 * @param 		browser
	 * @param 		webSite
	 * @throws      Exception 
	 * @since  	    Feb 23, 2015
	 */
	public boolean verifyRemoveReuseofSection( String userAccount, ClinicalSettingLib encounterTemplateTestData) throws Exception{
		try{
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		logTitleMessage("Login to application");
		LoginPage loginPage=new LoginPage();
		homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, encounterTemplateTestData.userName, encounterTemplateTestData.userPassword);
		logTitleMessage("Login Successful");

		//--------------------------------------------------------------------//
		//  Step-2: Change the switch role 									  //
		//--------------------------------------------------------------------//			
		logTitleMessage("Switch practice to Encounter Template ");
		SharedPage sharedPage=homePage.navigateToSharedPage();
		sharedPage.selectPractice(driver,"Encounter");
		sharedPage.switchRole(driver, encounterTemplateTestData.switchRole);
		sharedPage.getProviderName(driver, encounterTemplateTestData);
		sharedPage.unlock(driver);
		logTitleMessage("Switch practice to Encounter Template  succeccful");
		
		//--------------------------------------------------------------------//
		//  Step-3: Navigate to Encounter Template 							  //
		//--------------------------------------------------------------------//
		logTitleMessage("Navigate to practice libraray page and create visit section A and visit section B");
		clinicalSettingPage = sharedPage.navigateToClinicalSettings1(driver);
		practiceLibrary=clinicalSettingPage.navigateToEncounterTemplate(driver);
		
		//--------------------------------------------------------------------//
		//  Step-4: Create a two Custom section with widget 					  //
		//--------------------------------------------------------------------//
		clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
		clinicalSettingPage.deleteAllCustomSection(driver, practiceLibrary);
		clinicalSettingPage.createVisitSectionWithWidget(driver, encounterTemplateTestData, practiceLibrary);
		ClinicalSettingLib encounterEditTemplateTestData = new ClinicalSettingLib();
		encounterEditTemplateTestData.workSheetName = "CreateVisitSection";
		encounterEditTemplateTestData.testCaseId = "TC_VS_004";
		encounterEditTemplateTestData.fetchClinicalSettingsTestData();		
		clinicalSettingPage.createSecondVisitSection(driver, encounterEditTemplateTestData, practiceLibrary);	
		clinicalSettingPage.navigateToVisitoutline(driver, practiceLibrary);
		clinicalSettingPage.selectDefaultTemplate(driver, practiceLibrary);
		clinicalSettingPage.clickOnEncoEdit(driver, practiceLibrary);
		clinicalSettingPage.deleteCustomComponenetInEditDefalutPage(driver, practiceLibrary);
		clinicalSettingPage.addVisitSectionWithVisitOutline(driver, encounterTemplateTestData, practiceLibrary);
		logTitleMessage("Successfully Navigated to practice libraray page and created visit section A and visit section B");
		//--------------------------------------------------------------------//
		//  Step-6: Create a new patient to check the Encounter template 	  //
		//--------------------------------------------------------------------//
		logTitleMessage("Create a new patient");
		patientRegistationPage= sharedPage.goToPatientRegPage(driver);
		HomeLib patientData = new HomeLib();	
		patientData.workSheetName = "NewPatientCheckIn";
		patientData.testCaseId = "TC_NPC_001";
		patientData.fetchHomeTestData();	
		patientRegistationPage.createNewPatientWithMandatory(driver, patientData, userAccount);
		logTitleMessage("Patient creation successful");
		//--------------------------------------------------------------------//
		//  Step-7:Search newly created Patient							 	  //
		//--------------------------------------------------------------------//		
		logTitleMessage("Begin Encounter and Verify the Widgets added");
		patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);													
		//--------------------------------------------------------------------//
		//  Step-8:Verify Default template in Encounter Note				 	  //
		//--------------------------------------------------------------------//	
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat DateFormat1 = new SimpleDateFormat("ddMMyyyymmss");
		String date1=null;
		date1 = DateFormat1.format(cal1.getTime());
		patientChartPage.clickEncounterTab(driver);
		patientChartPage.deleteAllEncounters(driver);
		encounterPage = patientChartPage.clickbeginEncounter(driver);
		patientChartPage.beginEncounter(driver, encounterPage);
		patientChartPage.VerifyDefaultTemplateInEncounterNote(driver, encounterTemplateTestData, encounterPage);
		logTitleMessage("Default Template in Encounter Note verfied successfully");
		//--------------------------------------------------------------------//
		//  Step-9:Record Widgets in Encounter Note and Verify Values in Timeline				 	  //
		//--------------------------------------------------------------------//	
		logTitleMessage("Verify Recorded values in widgets");
		patientChartPage.recordWidgetsInEncounterNote(driver, encounterTemplateTestData,date1, encounterPage);
		patientChartPage.saveEncounter(driver, encounterPage);
		logTitleMessage("Successfully Verified Recorded values in widgets");
		logTitleMessage("Navigate to visit section page and delete reused widget");
		clinicalSettingPage = sharedPage.navigateToClinicalSettings1(driver);
		clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
		clinicalSettingPage.verifyDeletereusewidget(driver, encounterTemplateTestData, practiceLibrary);
		logTitleMessage("Successfully navigated to visit section page and deleted reused widget");
		logTitleMessage("Search same patient and verify previously saved encounter");
		patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
		patientChartPage.gotoPendingEncounters(driver);
		//--------------------------------------------------------------------//
		//Step-10: Verify recorded values in Encounter note after deleting some Widgets  
		//--------------------------------------------------------------------//	
		patientChartPage.verifyRecordedWidgetInEditMode(driver, encounterTemplateTestData, encounterPage);
		patientChartPage.recordWidgetsDeletedWidgetEncounterNote(driver, encounterPage);
		patientChartPage.saveEncounter(driver, encounterPage);
		logTitleMessage("Successfully verified previously saved encounter");
		logTitleMessage("Select previously saved encounter and record values in deleted widget and cancel encounter and verify ");
		patientChartPage.gotoPendingEncounters(driver);
		patientChartPage.verifyRecordedWidgetDeletedWidget(driver, encounterPage);
		encounterPage.cancelEncounter(driver);
		logTitleMessage("Successfully selected previously saved encounter and recorded values in deleted widget and canceled encounter and verifified values in deleted widgets ");
		//--------------------------------------------------------------------//
		//Step-11: Verify that deleted widgets is not present in encounter note   
		//--------------------------------------------------------------------//	
		logTitleMessage("Begin New encounter and verify the deleted widgets is not present ");
		patientChartPage.clickbeginEncounter(driver);
		encounterPage.beginEncounter(driver);
		encounterPage.scrollDown(driver);
		patientChartPage.verifyDeletedWidgetsInNote(driver, encounterTemplateTestData, encounterPage);	
		logTitleMessage("Begined New encounter and verified the deleted widgets is not present in new encounter  ");
		}
	catch(Exception e){
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	}
		return true;
	}
	
	
}
