package com.projectname.test.functional.chartprevisist.encounterendtoend.deleteencountersummaryitem;

import java.text.SimpleDateFormat;
import java.util.Calendar;


import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.ClinicalSettingPage;

import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.ImmunizationPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.ManagedCareTemplateOnPatientChartPage;
import com.projectname.testutils.pages.ManagedCareTemplatePage;

import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.PracticeLibrary;

import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.pages.VitalsPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifySaveEditandDeleteEncounterTwelve extends TestBaseClass {

	private HomePage homePage;
	private SharedPage sharedPage;
	private PatientRegistationPage patientRegistationPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private VitalsPage vitalsPage;
	private PracticeLibrary practiceLibrary;
	private ClinicalSettingPage clinicalSettingPage;

	private	ImmunizationPage immunizationPage;
	private ManagedCareTemplateOnPatientChartPage managedCareTemplateOnPatientChartPage;
	private ManagedCareTemplatePage managedCareTemplatePage;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Save Edit and Delete Encounter Twelve")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifySaveEditandDeleteEncounterTwelve(String userAccount,String website,String browser,String seleniumHost,String seleniumPort)  throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
	 mcTemplate.workSheetName = "ManagedCaredTemplate";
	 mcTemplate.testCaseId = "TC_EMCT_002";
	 mcTemplate.fetchClinicalSettingsTestData();
	 verifySaveEditandDeleteEncounter(mcTemplate,userAccount);
}

	/**
     * VerifySaveEditandDeleteEncounterTwelve
     * To Verify function Save Edit and Delete Encounter Twelve
     * @param problemListData(Problem list details to be added)
     * @param userAccount(Application Environment)
     * @since  Mar 17, 2015
     */

	public boolean verifySaveEditandDeleteEncounter(ClinicalSettingLib mcTemplate, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,mcTemplate.userName, mcTemplate.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to Full Access                            // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, mcTemplate.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			//---------------------------------------------------------------------//
			//  Step-3: Navigate to clinical Settings                              // 
			//---------------------------------------------------------------------//
		
			logTitleMessage("Navigate to clinical Settings");
			clinicalSettingPage=sharedPage.navigateToClinicalSettings(driver);
			logTitleMessage("Successully navigated into clinical Settings");
			logTitleMessage("Successully navigated into clinical Settings");
			
			//---------------------------------------------------------------------//
			//  Step-4: Navigate to ManagedCare Template Page                      //
			//---------------------------------------------------------------------//
			
			logTitleMessage("Navigate to Clincal Settings and delete all Managed Care template already created");
			practiceLibrary=new PracticeLibrary();
			managedCareTemplatePage=clinicalSettingPage.navigateToManagedCareTemplate(driver,practiceLibrary);
			logTitleMessage("Successully navigated into ManagedCare Template");
			
			//---------------------------------------------------------------------//
			//  Step-5: Delete all Managed Care Template                           //
			//---------------------------------------------------------------------//
			
			logTitleMessage("Delete all Managed Care Template");
			clinicalSettingPage.deleteAllManagedCareTemplate(driver,managedCareTemplatePage);
			logTitleMessage("Already created Templates deleted successully");
		
			//---------------------------------------------------------------------//
			//  Step-6: Create New Managed Care Template
			//---------------------------------------------------------------------//
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy HH:MM:SS");
			String uniqueName = dateFormat.format(cal.getTime());
			logTitleMessage("Create New Managed Care template with flow sheet care elements");
			clinicalSettingPage.startNewManagedCareTemplate(managedCareTemplatePage,driver,mcTemplate,uniqueName);
			
			mcTemplate.templateName = mcTemplate.templateName+uniqueName;
			
			logTitleMessage("Sucessfully Created New Managed Care template with flow sheet care elements");
			
			//--------------------------------------------------------------------//
			//  Step-7:Add a Managed care template in Clinical settings page      //
			//--------------------------------------------------------------------//		
			
			// Navigate to Flow sheets
			
			logTitleMessage("Navigate to Flow sheets");
		    clinicalSettingPage.navigateToFlowSheets(driver,managedCareTemplatePage);
			logTitleMessage("Sucessfully Navigated into Flow sheets");
			
			// To add Immunization
		    
			logTitleMessage("Add Immunization");
			clinicalSettingPage.addImmunizationCareElement(driver, mcTemplate, uniqueName, userAccount, managedCareTemplatePage);
			clinicalSettingPage.saveCareElement(driver, managedCareTemplatePage);
			logTitleMessage("Sucessfully Added Immunization in Flow sheets");
			
			// To add Vitals
			
			ClinicalSettingLib mcTemplatesVital = new ClinicalSettingLib();
			mcTemplatesVital.workSheetName = "ManagedCaredTemplate";
			mcTemplatesVital.testCaseId = "TC_EMCT_004";
			mcTemplatesVital.fetchClinicalSettingsTestData();
			
			logTitleMessage("Add Vitals");
			clinicalSettingPage.addVitalsCareElement(driver,managedCareTemplatePage,mcTemplatesVital);
			logTitleMessage("Sucessfully Added Vitals");
			clinicalSettingPage.saveCareElement(driver, managedCareTemplatePage);
			logTitleMessage("Sucessfully Added Vitals in Flow sheets");

			clinicalSettingPage.saveTemplate(driver, managedCareTemplatePage);
			logTitleMessage("Sucessfully Added Managed care template");
			
			//--------------------------------------------------------------------//
			//  Step-8: Create a new patient 	 								  //
			//--------------------------------------------------------------------//

			logTitleMessage("Create a new patient");
			sharedPage=homePage.navigateToSharedPage();
			patientRegistationPage= sharedPage.goToPatientRegPage(driver);
			HomeLib patientData = new HomeLib();	
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();	
			patientRegistationPage.createNewPatientWithMandatory(driver, patientData, userAccount);
			logTitleMessage("Patient creation successful");
			
			//--------------------------------------------------------------------//
			//  Step-9: Search newly created Patient							  //
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-10: Add Immunizations  in summary page    	                  //
			//--------------------------------------------------------------------//		
			
			// Add Immunizations
			
			ChartPreVisitLib immData = new ChartPreVisitLib();
			immData.workSheetName = "CreateImmunization";
			immData.testCaseId = "TC_CIM_072";
			immData.fetchChartPreVisitTestData();
			
			logTitleMessage("Go to Immunizations page");
			immunizationPage=patientChartPage.goToSummaryImmunization(driver);
			logTitleMessage("Sucessfully Navigated into Immunizations page");
			
			logTitleMessage("Add Immunizations in summary page");
			patientChartPage.createImmunization(driver,immData,userAccount,immunizationPage);
		    patientChartPage.addImmunization(driver, immunizationPage);
		    patientChartPage.saveImmunization(driver, immunizationPage);
		    logTitleMessage("Sucessfully Added Immunizations in summary page");
			
			//--------------------------------------------------------------------//
			//  Step-11: Navigate to Begin encounter page 						  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Begin encounter page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
		    logTitleMessage("Sucessfully Navigated into Begin encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-12: Add Vitals in encounter page 						      // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Go to vitals page");
			vitalsPage = patientChartPage.goToencounterVitals(driver,encounterPage);
			logTitleMessage("Sucessfully Navigated into vitals page");
			
			// Add Vitals
			
			ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		    vitalsData.workSheetName = "CreateVitals";
		    vitalsData.testCaseId = "TC_ECV_001";
		    vitalsData.fetchChartPreVisitTestData();
		    
		    logTitleMessage("Add Vitals in encounter page");
			patientChartPage.addEncounterVitals(driver,encounterPage,vitalsPage,vitalsData);
			logTitleMessage("Sucessfully Added Vitals in encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-13: Edit Immunizations in encounter page 					  // 
			//--------------------------------------------------------------------//	
			
			ChartPreVisitLib immData2 = new ChartPreVisitLib();
			immData2.workSheetName = "CreateImmunization";
			immData2.testCaseId = "TC_CIM_073";
			immData2.fetchChartPreVisitTestData();
			
			logTitleMessage("Go to Immunizations page");
			immunizationPage=patientChartPage.goToEncounterImmunization(driver,encounterPage);
			logTitleMessage("Sucessfully Navigated into Immunizations page");
		
			patientChartPage.clickEditImmnization(driver, immunizationPage);
		    patientChartPage.createImmunization(driver,immData2,userAccount,immunizationPage);
		    patientChartPage.saveImmunizationEdit(driver, immunizationPage);
			logTitleMessage("Sucessfully edited Immunization in Summary A --> B");
			
			//---------------------------------------------------------------------------//
			//  Step-14: Delete Immunizations and Vitals in encounter page               // 
			//---------------------------------------------------------------------------//	

	     	// Delete Immunizations
			
			logTitleMessage("Delete Immunizations in encounter page");
		    patientChartPage.deleteEncounterImmunizations(driver,encounterPage);
			logTitleMessage("Sucessfully Deleted Immunizations in encounter page ");
			
			// Delete Vitals
			
			logTitleMessage("Delete Vitals in encounter page");
		    patientChartPage.goToencounterVitals(driver,encounterPage);
		    patientChartPage.removeEncounterVitals(driver,encounterPage,vitalsPage);
		    logTitleMessage("Sucessfully Deleted Vitals in encounter page ");
								
			//--------------------------------------------------------------------//
			//  Step-15:   Save and Delete the Encounter 	  					  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Save the encounter A");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter A");
			
			logTitleMessage("Delete the encounter A");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.deleteAllEncounters(driver);
			logTitleMessage("Sucessfully deleted the encounter A");
			
			//--------------------------------------------------------------------//
			//  Step-16: Verify the flow sheet values in summary 			      // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Go to Managed care page");
			managedCareTemplateOnPatientChartPage=patientChartPage.navigateToManagedCareOnPatientChart(driver);
			logTitleMessage("Sucessfully Navigated into Managed care  page");
			
			logTitleMessage("Associate Managed care template");
			patientChartPage.associateManagedCareTemplateOnPatientChartPage(managedCareTemplateOnPatientChartPage,driver,uniqueName,userAccount,mcTemplate);
			logTitleMessage("Sucessfully Associated Managed care template");
			
			logTitleMessage("Verify the flow sheet values in summary");
			patientChartPage.clickViewEdit(driver,managedCareTemplateOnPatientChartPage);
			
			// Verify the Immunizations and Vitals Values
			
			logTitleMessage("Verify Values in flow sheet");
			patientChartPage.verifyValuesInFlowSheet(driver,managedCareTemplateOnPatientChartPage,mcTemplate,immData,immData2,mcTemplatesVital,vitalsData);
			logTitleMessage("Successfully Vitals Values flow sheet");
									
			//----------------------------------------------------------------------------//
			//  Step-17: Verify Vitals, Medications and Immunizations List A in Summary	  //
			//----------------------------------------------------------------------------//	

			// Vitals
			
			logTitleMessage("Verify Vitals List  in Summary Page");
			patientChartPage.verifyBlankVitalsList(driver);
			logTitleMessage("Successfully verified the Vitals List  in Summary Page");
			
			// Immunizations
			
			logTitleMessage("Verify Immunizations List A in Summary");
			patientChartPage.verifyImmunizationsInSummary(driver, immData, userAccount);
			logTitleMessage("Successfully verified the Immunizations List A in Summary");
			
			
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
}
