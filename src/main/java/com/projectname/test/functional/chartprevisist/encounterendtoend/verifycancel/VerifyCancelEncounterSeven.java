package com.projectname.test.functional.chartprevisist.encounterendtoend.verifycancel;

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
import com.projectname.testutils.pages.DemographicsPage;
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

public class VerifyCancelEncounterSeven extends TestBaseClass {

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private VitalsPage vitalsPage=null;
	private PracticeLibrary practiceLibrary=null;
	private ClinicalSettingPage clinicalSettingPage=null;
	private ManagedCareTemplatePage managedCareTemplatePage=null;
	private ImmunizationPage immunizationPage=null;
	private DemographicsPage demographicsPage =null;
	private ManagedCareTemplateOnPatientChartPage managedCareTemplateOnPatientChartPage=null;
	@Test(retryAnalyzer = RetryRule.class, groups = {"SingleThread", "Regression" }, description = "Test for Verify Cancel Encounter : 11")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifySaveEditandDeleteEncounterTwelve(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception {
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
     * To Verify function Cancel Encounter 
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
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy HH:MM:SS");
			String uniqueName = dateFormat.format(cal.getTime());
			logTitleMessage("Create New Managed Care template with flow sheet care elements");
			clinicalSettingPage.startNewManagedCareTemplate(managedCareTemplatePage,driver,mcTemplate,uniqueName);
			mcTemplate.templateName = mcTemplate.templateName+uniqueName;
			//--------------------------------------------------------------------//
			//  Step-7:Add a Managed care template in Clinical settings page       //
			//--------------------------------------------------------------------//		
			// Navigate to Flow sheets
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
			//  Step-9:Search newly created Patient							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-10: Navigate to Begin encounter page 						  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Begin encounter page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated into Begin encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-11: Add Vitals in encounter page 						  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Go to vitals page");
			patientChartPage.clickSummaryTab(driver);
			vitalsPage=patientChartPage.goToSummaryVitals(driver);
			logTitleMessage("Sucessfully Navigated into vitals page");
			
			ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		    vitalsData.workSheetName = "CreateVitals";
		    vitalsData.testCaseId = "TC_ECV_001";
		    vitalsData.fetchChartPreVisitTestData();
		    
		    logTitleMessage("Add Vitals in encounter page");
			patientChartPage.addEncounterVitals(driver,encounterPage,vitalsPage,vitalsData);
			logTitleMessage("Sucessfully Added Vitals in encounter page from Sumary");
			
			//--------------------------------------------------------------------//
			//  Step-13: Add Immunization in encounter page 					  // 
			//--------------------------------------------------------------------//	
			
			logTitleMessage("Go to Immunization page");
			patientChartPage.clickSummaryTab(driver);
			immunizationPage=patientChartPage.goToSummaryImmunization(driver);
			ChartPreVisitLib immData = new ChartPreVisitLib();
			immData.workSheetName = "CreateImmunization";
			immData.testCaseId = "TC_CIM_072";
			immData.fetchChartPreVisitTestData();

		    patientChartPage.createImmunization(driver,immData,userAccount,immunizationPage);
		    patientChartPage.addImmunization(driver, immunizationPage);
			logTitleMessage("Sucessfully Added Immunization in encounter page from Summary");
			
			//--------------------------------------------------------------------//
			//  Step-14:   Save the Encounter and Log out	  				            	  // 
			//--------------------------------------------------------------------//
			logTitleMessage("Save the encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter");

			logTitleMessage("Log out");
			sharedPage.logoutofApplication(driver);
			logTitleMessage("Log out successful");
			
			//--------------------------------------------------------------------//
			//  Step-15:Login into application as User B							 	  //
			//--------------------------------------------------------------------//	
		
			logTitleMessage("Login as different user");
			ChartPreVisitLib immData2 = new ChartPreVisitLib();
			immData2.workSheetName = "CreateImmunization";
			immData2.testCaseId = "TC_CIM_073";
			immData2.fetchChartPreVisitTestData();

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, immData2.userName, immData2.userPassword);
			logTitleMessage("Login successful");
			
			logTitleMessage("Search patient");
			demographicsPage=sharedPage.searchPatientNexiaForProviderHomePage(driver,patientData.lastName);
			demographicsPage.goToChart(driver);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-16:Edit Items from Summary					        	 	  //
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Edit Immnunization in Summary A -> B");
			patientChartPage.clickSummaryTab(driver);
			immunizationPage=patientChartPage.goToSummaryImmunization(driver);
			patientChartPage.clickEditImmnization(driver, immunizationPage);
		    patientChartPage.createImmunization(driver,immData2,userAccount,immunizationPage);
		    patientChartPage.saveImmunizationEdit(driver, immunizationPage);
		    patientChartPage.saveImmunization(driver, immunizationPage);
			logTitleMessage("Sucessfully edited Immunization in Summary");

			logTitleMessage("Log out");
			sharedPage.logoutofApplication(driver);
			logTitleMessage("Log out successful");
			
			//--------------------------------------------------------------------//
			//  Step-15:Login into application as User A							 	  //
			//--------------------------------------------------------------------//	
			logTitleMessage("Login as different user and search patient");
			ChartPreVisitLib immData3 = new ChartPreVisitLib();
			immData3.workSheetName = "CreateImmunization";
			immData3.testCaseId = "TC_CIM_074";
			immData3.fetchChartPreVisitTestData();

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, immData3.userName, immData3.userPassword);
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Login and search patient successful");

			//--------------------------------------------------------------------//
			//  Step-15:Edit items from Pending Encounter						  //
			//--------------------------------------------------------------------//	
			logTitleMessage("Edit items from pending encounter");
			patientChartPage.gotoPendingEncounters(driver);
			
			ChartPreVisitLib vitalsData2 = new ChartPreVisitLib();
		    vitalsData2.workSheetName = "CreateVitals";
		    vitalsData2.testCaseId = "TC_ECV_002";
		    vitalsData2.fetchChartPreVisitTestData();
			patientChartPage.goToEncounterVitals(driver, encounterPage);
			patientChartPage.addEncounterVitals(driver,encounterPage,vitalsPage,vitalsData2);
			
			patientChartPage.goToEncounterImmunization(driver, encounterPage);
			patientChartPage.clickEditImmnization(driver, immunizationPage);
		    patientChartPage.createImmunization(driver,immData3,userAccount,immunizationPage);
		    patientChartPage.saveImmunizationEdit(driver, immunizationPage);
		    
			logTitleMessage("Edit items from pending encounter successful");
		    
			//--------------------------------------------------------------------//
			//  Step-11:Cancel the Encounter							 	      //
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
			patientChartPage.verifyVitalsInFlowSheet(driver,managedCareTemplateOnPatientChartPage,mcTemplatesVital,vitalsData);
			logTitleMessage("Successfully verified Vitals Values flow sheet");
			
			logTitleMessage("Verify Immunization Values in flow sheet");
			patientChartPage.verifyImmunizationInFlowSheet(driver, mcTemplate, immData2, managedCareTemplateOnPatientChartPage);
			logTitleMessage("Successfully verified Immunization Values in flow sheet");
			
			//--------------------------------------------------------------------//
			//  Step-17:Verify Medications and Immunizations List A in Summary	  //
			//--------------------------------------------------------------------//	
			patientChartPage.clickSummaryTab(driver);
			logTitleMessage("Managed Care Template added to patient and values verified successfully");

			logTitleMessage("Verify Immunizations List A in Summary");
			patientChartPage.verifyImmunizationsInSummary(driver, immData2, userAccount);
			logTitleMessage("Successfully verified the Immunizations List B in Summary");

			logTitleMessage("Verify Vitals List A in Summary");
			patientChartPage.verifyVitalsInSummary(driver, vitalsData);
			logTitleMessage("Successfully verified the Vitals List A in Summary");
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
		}
	return returnValue;
}
}
