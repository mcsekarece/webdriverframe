package com.projectname.test.functional.clinicalsettings.practiceLibrary;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.AllergyPage;
import com.projectname.testutils.pages.ClinicalSettingPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.PracticeLibrary;
import com.projectname.testutils.pages.ProblemListPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class VerifyCancelEncounter extends TestBaseClass {
	
	
	@Test(retryAnalyzer = RetryRule.class, groups = {"SingleThread","Review"}, description = "Test for Verify Cancel Encounter")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifyCancelEncounter(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	 {className=this.getClass().getName().substring(39); 

	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
	 encounterTemplateTestData.workSheetName = "CreateVisitSection";
	 encounterTemplateTestData.testCaseId = "TC_VS_001";
	 encounterTemplateTestData.fetchClinicalSettingsTestData(); 
	 encounterTemplate(encounterTemplateTestData,userAccount);
	 }

	
	/**
	 * Verify Encounter End To End Cancel scenario 
	 * function to Encounter End To End Cancel scenario 
	 * Document Name : Encounter end to end.xls
	 * @param encounterTemplateTestData 
	 * @param 		patientData
	 * @param 		browser
	 * @param 		webSite
	 * @throws      Exception 
	 * @since  	    Feb 23, 2015
	 */

	public boolean encounterTemplate(ClinicalSettingLib encounterTemplateTestData,String userAccount) throws Exception{
		boolean returnValue=true;
		HomePage homePage=null;
		SharedPage sharedPage=null;
		ClinicalSettingPage clinicalSettingPage=null;
		PracticeLibrary practiceLibrary=null;
		PatientRegistationPage patientRegistationPage=null;
		PatientChartPage patientChartPage=null;
		EncounterPage encounterPage=null;
		AllergyPage allergyPage=null;
		ProblemListPage problemListPage=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, encounterTemplateTestData.userName, encounterTemplateTestData.userPassword);
			logTitleMessage("Login Successful");			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to Full Access                             // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch  practice and the role to FULL Access ");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.selectPractice(driver,"Encounter");
			sharedPage.switchRole(driver, encounterTemplateTestData.switchRole);
			sharedPage.getProviderName(driver, encounterTemplateTestData);
			sharedPage.switchRole(driver, encounterTemplateTestData.switchRole);
			sharedPage.unlock(driver);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter Template 							  //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to Encounter Template");
			clinicalSettingPage = sharedPage.navigateToClinicalSettings(driver);
			practiceLibrary=clinicalSettingPage.navigateToEncounterTemplate(driver);
			logTitleMessage("Sucessfuly Navigated into Encounter Template");
			
			//--------------------------------------------------------------------//
			//  Step-4: Create a Custom section with widget 					  //
			//--------------------------------------------------------------------//
			logTitleMessage("Navigate To Visit section & Create a visit section");
			clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
			clinicalSettingPage.deleteAllCustomSection(driver, practiceLibrary);	
			clinicalSettingPage.createVisitSectionWithWidget(driver, encounterTemplateTestData, practiceLibrary);		
			//--------------------------------------------------------------------//
			//  Step-5: Add Created section with Default visit outline			  //
			//--------------------------------------------------------------------//			
			logTitleMessage(" Add Created section with Default visit outline");
			clinicalSettingPage.navigateToVisitoutline(driver, practiceLibrary);
			clinicalSettingPage.selectDefaultTemplate(driver, practiceLibrary);
			clinicalSettingPage.clickOnEncoEdit(driver, practiceLibrary);
			clinicalSettingPage.deleteCustomComponenetInEditDefalutPage(driver, practiceLibrary);
			clinicalSettingPage.addVisitSectionWithVisitOutline(driver, encounterTemplateTestData, practiceLibrary);
			logTitleMessage("Sucessfuly Added Created section with Default visit outline");			
			//--------------------------------------------------------------------//
			//  Step-6: Create a new patient to check the Encounter template 	  //
			//--------------------------------------------------------------------//			
			logTitleMessage("Created A New Patient");		
			patientRegistationPage= sharedPage.goToPatientRegPage(driver);
			HomeLib patientData = new HomeLib();	
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();	
			logTitleMessage("Add Created section with Default visit outline");
			patientRegistationPage.createNewPatientWithMandatory(driver, patientData, userAccount);
			logTitleMessage("Sucessfuly Created A New Patient");			
			//--------------------------------------------------------------------//
			//  Step-7:Search newly created Patient							 	  //
			//--------------------------------------------------------------------//	
			logTitleMessage("Search newly created Patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Sucessfuly Search newly created Patient");
			//--------------------------------------------------------------------//
			//  Step-8:Verify Default template in Encounter Note				  //
			//--------------------------------------------------------------------//			
			logTitleMessage("Verify Default template in Encounter Note and Cancel the encounter and Verify cancelled encounter in encounter tab");
			patientChartPage.clickEncounterTab(driver);
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			patientChartPage.cancelEncounter(driver, encounterPage);
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.veifyCancelledEncounter(driver);
			logTitleMessage("Sucessfuly Verified cancellation of First encounter ");
			logTitleMessage("Begin an encounter and record values in widgets and save it ");
			patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			ChartPreVisitLib allergyData = new ChartPreVisitLib();
			allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CA_002";
			allergyData.fetchChartPreVisitTestData();
			allergyPage = patientChartPage.goToEncounterAllergy(driver, encounterPage);
			patientChartPage.createEncounterAllergy(driver, allergyData, userAccount, encounterPage, allergyPage);			
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat DateFormat1 = new SimpleDateFormat("ddMMyyyymm:ss");
			String date1=null;
			date1 = DateFormat1.format(cal1.getTime());
			//--------------------------------------------------------------------//
			//  Step-9:Record Values in Encounter Note Widgets 
			//--------------------------------------------------------------------//		
			patientChartPage.recordWidgetsInEncounterNote(driver, encounterTemplateTestData,date1, encounterPage);
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Successfully recorded data in encounter and  saved encounter ");
			logTitleMessage("Open saved encounter from pending encounter list and verify,add allergy and cancal current encounter");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.verifyShowMarkupforPendingEncounter(driver, encounterTemplateTestData);
			assertTrue(patientChartPage.verifyFirstRecordedWidgetInTimeLine(driver, encounterTemplateTestData, encounterPage),"Verification of recorded values in encounter Encounter time line failed", driver, className, methodName);
			assertTrue(patientChartPage.verfiyAllergyInShowMarkUp(driver, allergyData, userAccount),"Verification of recorded values in encounter Encounter time line failed", driver, className, methodName);
			logTitleMessage("Open tha saved encounter and record allergy and record different values in widgtes and cancel it");
			patientChartPage.clickbeginEncounter(driver);
			patientChartPage.clickPreviousencounter(driver, encounterPage);			
			ChartPreVisitLib allergyData1 = new ChartPreVisitLib();
			allergyData1.workSheetName = "CreateAllergy";
			allergyData1.testCaseId = "TC_CA_046";
			allergyData1.fetchChartPreVisitTestData();
			allergyPage = patientChartPage.goToEncounterAllergy(driver, encounterPage);
			patientChartPage.clickEditAllergy(driver, encounterPage);
			patientChartPage.createEncounterAllergy(driver, allergyData1, userAccount, encounterPage, allergyPage);	
			problemListPage=patientChartPage.goToEncounterProblemList(driver,encounterPage);
			ChartPreVisitLib proData = new ChartPreVisitLib();
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_CPL_001";
			proData.fetchChartPreVisitTestData();
			problemListPage.createProblemList(proData, userAccount);
			ClinicalSettingLib encountercancelData = new ClinicalSettingLib();
			encountercancelData.workSheetName = "CreateVisitSection";
			encountercancelData.testCaseId = "TC_VS_006";
			encountercancelData.fetchClinicalSettingsTestData(); 
			String date2=null;
			date2 = DateFormat1.format(cal1.getTime());
			encounterPage.recordWidgetsforcancelEncounter(driver, encountercancelData, date2);
			//--------------------------------------------------------------------//
			//  Step-9:Verify Cancelled encounter 
			//--------------------------------------------------------------------//	
			patientChartPage.cancelEncounter(driver, encounterPage);
			logTitleMessage("Verified saved encounter and added allergy finally cancelled encounter ");
			logTitleMessage("Open the saved encounter and confirm Edited values are not present but older version is");
			patientChartPage.clickEncounterTab(driver);			
			patientChartPage.gotoPendingEncounters(driver);
		
			//--------------------------------------------------------------------//
			//  Step-10:Verify the cancel function							 	  //
			//--------------------------------------------------------------------//		
		
			patientChartPage.verifyRecordedWidgetInEditMode(driver, encounterTemplateTestData, encounterPage);
			patientChartPage.verifyCancelledAllergy(driver, allergyData1,proData, userAccount, encounterPage);		
			logTitleMessage("Successfully verified cancelled version of previous  encounter ");
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
		}
	return returnValue;
}


}
