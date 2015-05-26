package com.projectname.test.functional.chartprevisist.encounterendtoend.verifycancel;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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


import org.testng.annotations.Listeners;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyCancelEncounterTwo extends TestBaseClass{
	
	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private PracticeLibrary practiceLibrary=null;
	private ClinicalSettingPage clinicalSettingPage=null;
	private ManagedCareTemplatePage managedCareTemplatePage=null;
	private ManagedCareTemplateOnPatientChartPage managedCareTemplateOnPatientChartPage=null;
	private ImmunizationPage immunizationPage=null;
	private VitalsPage vitalsPage=null;


	@Test(retryAnalyzer = RetryRule.class, groups = {"SingleThread", "Regression" }, description = "Test to verify cancel Encounter : 4")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterTwo(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPLE_001";
		proData.fetchChartPreVisitTestData();		
		verifyCancel(userAccount, proData);
	}	
		/**
		 * verify Cancel Encounter
		 * function to verify Cancel Encounter
		 * @param proData 
		 * @param 		patientData
		 * @param 		browser
		 * @param 		webSite
		 * @throws      Exception 
		 * @since  	    Mar 13, 2015
		 */

	
	private boolean verifyCancel(String userAccount,ChartPreVisitLib proData) throws Exception {
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, proData.userName, proData.userPassword);
			logTitleMessage("Login Successful");			
			
			//---------------------------------------------------------------------//
			//  Step-3: Navigate to clinical Settings                              // 
			//---------------------------------------------------------------------//
			logTitleMessage("Navigate to clinical Settings");
			sharedPage=homePage.navigateToSharedPage();
			clinicalSettingPage=sharedPage.navigateToClinicalSettings(driver);
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
			//  Step-6: Create New Managed Care Template                           //   							
			//---------------------------------------------------------------------//
			logTitleMessage("Create New Managed Care template with flow sheet care elements");
			ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
			 mcTemplate.workSheetName = "ManagedCaredTemplate";
			 mcTemplate.testCaseId = "TC_EMCT_002";
			 mcTemplate.fetchClinicalSettingsTestData();

			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy HH:MM:SS");
			String uniqueName = dateFormat.format(cal.getTime());
			clinicalSettingPage.startNewManagedCareTemplate(managedCareTemplatePage,driver,mcTemplate,uniqueName);
			mcTemplate.templateName = mcTemplate.templateName+uniqueName;
			//--------------------------------------------------------------------//
			//  Step-7:Add a Managed care template in Clinical settings page       //
			//--------------------------------------------------------------------//		
		    clinicalSettingPage.navigateToFlowSheets(driver,managedCareTemplatePage);
			logTitleMessage("Add Immunization");
			clinicalSettingPage.addImmunizationCareElement(driver, mcTemplate, uniqueName, userAccount, managedCareTemplatePage);
			clinicalSettingPage.saveCareElement(driver, managedCareTemplatePage);
			logTitleMessage("Sucessfully Added Immunization");
			
			 ClinicalSettingLib mcTemplatesVital = new ClinicalSettingLib();
			 mcTemplatesVital.workSheetName = "ManagedCaredTemplate";
			 mcTemplatesVital.testCaseId = "TC_EMCT_004";
			 mcTemplatesVital.fetchClinicalSettingsTestData();

			logTitleMessage("Add Vitals");
			clinicalSettingPage.addVitalsCareElement(driver,managedCareTemplatePage,mcTemplatesVital);
			clinicalSettingPage.saveCareElement(driver, managedCareTemplatePage);
			logTitleMessage("Sucessfully Added Vitals");

			clinicalSettingPage.saveTemplate(driver, managedCareTemplatePage);
			logTitleMessage("Sucessfully Created Managed Care template");
			//--------------------------------------------------------------------//
			//  Step-3: Create a new patient to check the Encounter template 	  //
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
			//  Step-4:Search newly created Patient							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-5:Add Summary immunization								 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Add Summary immunization");
			patientChartPage.clickSummaryTab(driver);
			immunizationPage=patientChartPage.goToSummaryImmunization(driver);
			ChartPreVisitLib immData = new ChartPreVisitLib();
			immData.workSheetName = "CreateImmunization";
			immData.testCaseId = "TC_CIM_072";
			immData.fetchChartPreVisitTestData();

		    patientChartPage.createImmunization(driver,immData,userAccount,immunizationPage);
		    patientChartPage.addImmunization(driver, immunizationPage);
			logTitleMessage("Summary immunization added successfully");

			//--------------------------------------------------------------------//
			//  Step-6:Begin an Encounter							 	  		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit immunization in encounter A -> B");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			patientChartPage.goToEncounterImmunization(driver, encounterPage);
			patientChartPage.clickEditImmnization(driver, immunizationPage);

			ChartPreVisitLib immData2 = new ChartPreVisitLib();
			immData2.workSheetName = "CreateImmunization";
			immData2.testCaseId = "TC_CIM_073";
			immData2.fetchChartPreVisitTestData();

			patientChartPage.createImmunization(driver,immData2,userAccount,immunizationPage);
		    patientChartPage.saveImmunizationEdit(driver, immunizationPage);
			logTitleMessage("Immunization edit in encounter successful");

			logTitleMessage("Add Encounter Vitals");
			vitalsPage=patientChartPage.goToEncounterVitals(driver, encounterPage);
			ChartPreVisitLib vitalsData1 = new ChartPreVisitLib();
		    vitalsData1.workSheetName = "CreateVitals";
		    vitalsData1.testCaseId = "TC_ECV_001";
		    vitalsData1.fetchChartPreVisitTestData();
		    
			patientChartPage.addEncounterVitals(driver,encounterPage,vitalsPage,vitalsData1);
			logTitleMessage("Sucessfully Added Vitals in encounter page");

			//--------------------------------------------------------------------//
			//  Step-7:Save the Encounter							 	  		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Save the Encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Encounter saved successfully");

			//--------------------------------------------------------------------//
			//  Step-8:Edit Problem List from Summary							  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Immunization from Summary B -> C");
			patientChartPage.clickSummaryTab(driver);
			immunizationPage=patientChartPage.goToSummaryImmunization(driver);
			patientChartPage.clickEditImmnization(driver, immunizationPage);
			ChartPreVisitLib immData3 = new ChartPreVisitLib();
			immData3.workSheetName = "CreateImmunization";
			immData3.testCaseId = "TC_CIM_074";
			immData3.fetchChartPreVisitTestData();

			patientChartPage.createImmunization(driver,immData3,userAccount,immunizationPage);
		    patientChartPage.saveImmunizationEdit(driver, immunizationPage);
		    patientChartPage.saveImmunization(driver, immunizationPage);
			logTitleMessage("Immunization edit successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit the Problem List again	from Pending Encounter		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Immunization in encounter : C -> D");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEncounterImmunization(driver, encounterPage);
			patientChartPage.clickEditImmnization(driver, immunizationPage);
			ChartPreVisitLib immData4 = new ChartPreVisitLib();
			immData4.workSheetName = "CreateImmunization";
			immData4.testCaseId = "TC_CIM_075";
			immData4.fetchChartPreVisitTestData();

			patientChartPage.createImmunization(driver,immData4,userAccount,immunizationPage);
		    patientChartPage.saveImmunizationEdit(driver, immunizationPage);
			logTitleMessage("Immunization edit in encounter successful");

			logTitleMessage("Add Encounter Vitals");
			vitalsPage=patientChartPage.goToEncounterVitals(driver, encounterPage);
			ChartPreVisitLib vitalsData2 = new ChartPreVisitLib();
		    vitalsData2.workSheetName = "CreateVitals";
		    vitalsData2.testCaseId = "TC_ECV_002";
		    vitalsData2.fetchChartPreVisitTestData();
		    
			patientChartPage.addEncounterVitals(driver,encounterPage,vitalsPage,vitalsData2);
			logTitleMessage("Sucessfully Added Vitals in encounter page");

			//--------------------------------------------------------------------//
			//  Step-10:Cancel the Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//-----------------------------------------------------------------------------//
			//  Step-11: Verify the recorded values in the managed care template           //
			//-----------------------------------------------------------------------------//
			logTitleMessage("Add Managed Care Template to patient and verfiy values");
			managedCareTemplateOnPatientChartPage=patientChartPage.navigateToManagedCareOnPatientChart(driver);
			patientChartPage.associateManagedCareTemplateOnPatientChartPage(managedCareTemplateOnPatientChartPage,driver,uniqueName,userAccount,mcTemplate);
			patientChartPage.clickViewEdit(driver, managedCareTemplateOnPatientChartPage);
			
			logTitleMessage("Verify Vitals Values in flow sheet");
			patientChartPage.verifyVitalsInFlowSheet(driver,managedCareTemplateOnPatientChartPage,mcTemplatesVital,vitalsData1);
			logTitleMessage("Successfully verified Vitals Values flow sheet");

			logTitleMessage("Verify Immunization Values in flow sheet");
			patientChartPage.verifyImmunizationInFlowSheet(driver, mcTemplate, immData3, managedCareTemplateOnPatientChartPage);
			logTitleMessage("Successfully verified Immunization Values in flow sheet");

			//--------------------------------------------------------------------//
			//  Step-11:Verify Problem List in Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Immunization Values in flow sheet");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyImmunizationsInSummary(driver, immData3, userAccount);
			logTitleMessage("Successfully verified Immunization Values in flow sheet");

			logTitleMessage("Verify Vitals List A in Summary");
			patientChartPage.verifyVitalsInSummary(driver, vitalsData1);
			logTitleMessage("Successfully verified the Vitals List A in Summary");

		}
		catch(RuntimeException e)
			{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
			}
	
		
		return true;
	}

}
