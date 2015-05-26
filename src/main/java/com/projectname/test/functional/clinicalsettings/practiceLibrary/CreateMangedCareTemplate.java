package com.projectname.test.functional.clinicalsettings.practiceLibrary;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.ClinicalSettingPage;
import com.projectname.testutils.pages.DemographicsPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.ManagedCareTemplateOnPatientChartPage;
import com.projectname.testutils.pages.ManagedCareTemplatePage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientPersonalInfoPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.PracticeLibrary;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class CreateMangedCareTemplate  extends TestBaseClass{
	@Test(retryAnalyzer = RetryRule.class, groups = {"SingleThread","Review"}, description = "Test for verify end to end visit flow")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void createManagedCareTemplate(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) {
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_020";
		mcTemplate.fetchClinicalSettingsTestData();
		addFlowSheetAndCareElements(mcTemplate,userAccount);
    }
	/*
	* @purpose EndToEnd-Encounter(EndToEnd-Managed care section) 
	* @author AspireQA
	* @since December 19, 2014
	* @version 2.1
	*/
	public boolean addFlowSheetAndCareElements(ClinicalSettingLib mcTemplate,String userAccount)
	{
		SharedPage sharedPage=null;
		LoginPage loginPage=null;
		PatientChartPage patientChartPage=null;
		ManagedCareTemplateOnPatientChartPage managedCareTemplate=null;
		EncounterPage encounterPage=null;
	    PatientRegistationPage patientRegistrationPage=null;
		PatientPersonalInfoPage patientPersonalInfoPage=null;
		PracticeLibrary practiceLibrary=null;
		ClinicalSettingPage clinicalSettingPage=null;
		DemographicsPage demographicsPage=null;
		ManagedCareTemplatePage managedCareTemplatePage=null;
		String uniqueName=null;
		try {
			// --------------------------------------------------------------------//
			// Step-1: Login to the application and search for the given patient   //
			// --------------------------------------------------------------------//
			logTitleMessage("Login to application");
			loginPage = new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,
					userAccount, mcTemplate.userName,
					mcTemplate.userPassword);
			logTitleMessage("Login Successful");
			//---------------------------------------------------------------------//
			//  Step-2: Navigate to clinical Settings                              // 
			//---------------------------------------------------------------------//
			sharedPage=homePage.navigateToSharedPage();
			logTitleMessage("Select FULL as a user role");
			sharedPage.switchRole(driver,mcTemplate.switchRole);
			logTitleMessage("User Role FULL selected successfully");
			sharedPage.selectPractice(driver,"ETEManaged");
			clinicalSettingPage=sharedPage.navigateToClinicalSettings(driver);
			practiceLibrary=new PracticeLibrary();
			//---------------------------------------------------------------------//
			//  Step-3: Navigate to Visit section and create a template            //
			//---------------------------------------------------------------------//
			logTitleMessage("Naviage to visit section and add a new custom section with some widgets");
			ClinicalSettingLib encounterVisitSection = new ClinicalSettingLib();
			encounterVisitSection.workSheetName = "CreateVisitSection";
			encounterVisitSection.testCaseId = "TC_VS_010";
			encounterVisitSection.fetchClinicalSettingsTestData();
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy HH:MM:SS");
			uniqueName = dateFormat.format(cal.getTime());
			logTitleMessage("Navigate to Clincal Settings and delete all Visit section template and create new one");
			clinicalSettingPage=sharedPage.navigateToClinicalSettings(driver);
			practiceLibrary=new PracticeLibrary();
			clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
			clinicalSettingPage.deleteAllCustomSection(driver, practiceLibrary);
			clinicalSettingPage.createVisitSectionWithWidget(driver, encounterVisitSection, practiceLibrary);
			logTitleMessage("Successfully Naviage to visit section and added a custom section with some widgets");    
			//---------------------------------------------------------------------//
			//  Step-4: Navigate to ManagedCare Template Page                      //
			//---------------------------------------------------------------------//
			logTitleMessage("Navigate to Clincal Settings and delete all Managed Care template already created");
			managedCareTemplatePage=clinicalSettingPage.navigateToManagedCareTemplate(driver,practiceLibrary);
			//---------------------------------------------------------------------//
			//  Step-5: Delete all Managed Care Template                           //
			//---------------------------------------------------------------------//
		    clinicalSettingPage.deleteAllManagedCareTemplate(driver,managedCareTemplatePage);
			logTitleMessage("Already created Templates deleted successully");
			//---------------------------------------------------------------------//
			//  Step-6: Create New Managed Care Template
			//---------------------------------------------------------------------//
			logTitleMessage("Create New Managed Care template with flow sheet care elements");
			clinicalSettingPage.startNewManagedCareTemplate(managedCareTemplatePage,driver,mcTemplate,uniqueName);
			//--------------------------------------------------------------------//
			//  Step-7: Add Care Element in flow sheets 
			//--------------------------------------------------------------------//
		    clinicalSettingPage.addCustomWidgetCareElement(managedCareTemplatePage,driver,mcTemplate,uniqueName,"firstTime");
			clinicalSettingPage.addCustomWidgetCareElement(managedCareTemplatePage,driver,mcTemplate,uniqueName,"numeric");
			clinicalSettingPage.addCustomWidgetCareElement(managedCareTemplatePage,driver,mcTemplate,uniqueName,"Question1");
			clinicalSettingPage.addCustomWidgetCareElement(managedCareTemplatePage,driver,mcTemplate,uniqueName,"Question2");
			clinicalSettingPage.addCustomWidgetCareElement(managedCareTemplatePage,driver,mcTemplate,uniqueName,"Question3");
			clinicalSettingPage.addCustomWidgetCareElement(managedCareTemplatePage,driver,mcTemplate,uniqueName,"Question4");
			clinicalSettingPage.SaveEntireManagedCareTemplate(managedCareTemplatePage,driver,mcTemplate);
			logTitleMessage("Managed care template with care elements created successfully");  
			//--------------------------------------------------------------------------//
			//  Step-8: Associate the created visit section with default visit outline 
			//--------------------------------------------------------------------------//
			logTitleMessage("Add visit section with default visit outline");
			clinicalSettingPage.navigateToVisitoutline(driver, practiceLibrary);
			clinicalSettingPage.selectDefaultTemplate(driver, practiceLibrary);
			clinicalSettingPage.clickOnEncoEdit(driver, practiceLibrary);
			clinicalSettingPage.deleteCustomComponenetInEditDefalutPage(driver, practiceLibrary);
			clinicalSettingPage.addVisitSectionWithVisitOutline(driver, encounterVisitSection, practiceLibrary);
			logTitleMessage("Successfully Added visit section with default visit outline");  
			//--------------------------------------------------------------------------//
			//  Step-9: Navigate to patient creation page and create a new patient
			//--------------------------------------------------------------------------//
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
			patientData.testCaseId = "TC_NPC_002";
			patientData.fetchHomeTestData();
			logTitleMessage("Navigate to patient Registration page and register a new patient with mandatory details");
			patientRegistrationPage=sharedPage.goToPatientRegPage(driver);
			patientPersonalInfoPage=patientRegistrationPage.createPatientWithMandatory(driver, patientData,userAccount);
			demographicsPage=new DemographicsPage();
			String patientId=demographicsPage.getPatientId(patientPersonalInfoPage,driver);
			logTitleMessage("Patient was created only with mandatory details");
			//--------------------------------------------------------------------------//
			//  Step-10: Navigate already created patient chart page
			//--------------------------------------------------------------------------//
			logTitleMessage("Naviage to patient chart page from homepage");
			sharedPage.navigateToHomePage(driver);
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientId);
			patientChartPage=homePage.navigateToPatientChartPage(driver);
			//-----------------------------------------------------------------------------//
			//  Step-10: Begin Encounter and record the value for default template widgets //
			//-----------------------------------------------------------------------------//
			logTitleMessage("Begin Encounter for newly created patient and record value in the encounter page for managed care template");
			encounterPage=new EncounterPage();
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("ddMMyyyymmss");
			String date1=null;
			encounterPage=patientChartPage.clickbeginEncounter(driver);
			encounterPage.beginEncounter(driver);
			date1 = dateFormat1.format(cal1.getTime());
			logTitleMessage("Record values in widget and verify recored values in timeline,encounter tab and edit mode");
			patientChartPage.recordValuesForWidgetsInEncounter(driver, encounterVisitSection,date1, encounterPage);
			patientChartPage.saveEncounter(driver, encounterPage);
			//-----------------------------------------------------------------------------//
			//  Step-11: Verify the recorded values in the managed care template           //
			//-----------------------------------------------------------------------------//
			managedCareTemplate=patientChartPage.navigateToManagedCareOnPatientChart(driver);
			patientChartPage.associateManagedCareTemplateOnPatientChartPage(managedCareTemplate,driver,uniqueName,userAccount,mcTemplate);
			patientChartPage.navigateToCareTemplateAlreadyOpen(driver,managedCareTemplate);
			patientChartPage.verifyDefaultVisitOutlineOnManagedCareTemplate(managedCareTemplate,driver,encounterVisitSection);
			sharedPage.navigateToHomePage(driver); 
			//------------------------------------------------------------------------------//
			//  Step-12: Edit The already created widgets                                   //
			//------------------------------------------------------------------------------//
			ClinicalSettingLib encounterTemplateTestData1 = new ClinicalSettingLib();
			encounterTemplateTestData1.workSheetName = "CreateVisitSection";
			encounterTemplateTestData1.testCaseId = "TC_VS_006";
			encounterTemplateTestData1.fetchClinicalSettingsTestData();
			//--------------------------------------------------------------------//
			//  Step-16:Goto Practice Library								 	  //
			//--------------------------------------------------------------------//	
			logTitleMessage("Edit the Visit Section and verfiy in Practice Library");
			clinicalSettingPage = sharedPage.navigateToClinicalSettings(driver);
			clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
			//--------------------------------------------------------------------//
			//  Step-17:Edit Visit Section									 	  //
			//--------------------------------------------------------------------//	
			clinicalSettingPage.goToEditVisitSection(driver, practiceLibrary);	
			clinicalSettingPage.editVisitSectionWithWidget(driver, encounterTemplateTestData1, practiceLibrary);
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientId);
			//-----------------------------------------------------------------------------//
			//  Step-12: Open already saved encounter in the patient chart page            //
			//-----------------------------------------------------------------------------//
			patientChartPage.gotoPendingEncounters(driver);	
			//-----------------------------------------------------------------------------//
			//  Step-13: Record data in the flow sheets care element                       //
			//-----------------------------------------------------------------------------//
			patientChartPage.navigateToManagedCareOnPatientChart(driver);
			patientChartPage.navigateToCareTemplateAlreadyOpen(driver,managedCareTemplate);
			ClinicalSettingLib encounterTemplateTestDataTwo = new ClinicalSettingLib();
			encounterTemplateTestDataTwo.workSheetName = "CreateVisitSection";
			encounterTemplateTestDataTwo.testCaseId = "TC_VS_011";
			encounterTemplateTestDataTwo.fetchClinicalSettingsTestData();
			patientChartPage.recordValueForEditedManagedCare(managedCareTemplate,driver);
			patientChartPage.recordValuesForWidgetsInEncounterEdit(driver, encounterTemplateTestDataTwo ,date1, encounterPage);
			patientChartPage.saveEncounter(driver, encounterPage);
			patientChartPage.clickEncounterTab(driver);		
			patientChartPage.showMarkupInUnSignedEncounter(driver);
			patientChartPage.verifyManagedCareShowMarkupFirst(driver,encounterVisitSection);
			patientChartPage.verifyManagedCareShowMarkupSecond(driver,encounterTemplateTestDataTwo);
			//-----------------------------------------------------------------------------//
			//  Step-14: Edit the visit section already created                            //
			//-----------------------------------------------------------------------------//
			patientChartPage.navigateToManagedCareOnPatientChart(driver);
			patientChartPage.navigateToCareTemplateAlreadyOpen(driver,managedCareTemplate);
			patientChartPage.verifyEditedManagedCareTemplate(managedCareTemplate,driver,encounterTemplateTestDataTwo);
			//-----------------------------------------------------------------------------//
			//  Step-14: Begin a new encounter with edited visit section                   //
			//-----------------------------------------------------------------------------//
			logTitleMessage("Successfully values are added with the template");
			logTitleMessage("Verify the saved widget values in the encounter timeline");
			sharedPage.navigateToHomePage(driver);
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientId);
			logTitleMessage("Successfully verified the saved widget values in the encounter timeline");
			ClinicalSettingLib encounterTemplateTestDataThree = new ClinicalSettingLib();
			encounterTemplateTestDataThree.workSheetName = "CreateVisitSection";
			encounterTemplateTestDataThree.testCaseId = "TC_VS_012";
			encounterTemplateTestDataThree.fetchClinicalSettingsTestData();
			encounterPage=patientChartPage.clickbeginEncounter(driver);
			encounterPage.beginEncounter(driver);
			patientChartPage.recordWidgetsInEditedEncounterNote(driver, encounterTemplateTestDataThree, date1, encounterPage);
			patientChartPage.saveEncounter(driver, encounterPage);
			patientChartPage.navigateToManagedCareOnPatientChart(driver);
			patientChartPage.navigateToCareTemplateAlreadyOpen(driver,managedCareTemplate);
			patientChartPage.verifyDefaultVisitOutlineOnManagedCareTemplate(managedCareTemplate,driver,encounterTemplateTestDataThree);
			//-----------------------------------------------------------------------------//
			//  Step-14:Record the values in the care elements                             //
			//-----------------------------------------------------------------------------//
			sharedPage.navigateToHomePage(driver);
			sharedPage.navigateToClinicalSettings(driver);
			clinicalSettingPage.navigateToManagedCareTemplate(driver,practiceLibrary);
			clinicalSettingPage.editManagedCareTemplatePage(driver,managedCareTemplatePage);
			clinicalSettingPage.addCustomWidgetCareElement(managedCareTemplatePage,driver,mcTemplate,uniqueName,"Question5");
			clinicalSettingPage.SaveEntireManagedCareTemplate(managedCareTemplatePage,driver,mcTemplate);
			sharedPage.navigateToHomePage(driver);
			ClinicalSettingLib encounterTemplateTestDataFour = new ClinicalSettingLib();
			encounterTemplateTestDataFour.workSheetName = "CreateVisitSection";
			encounterTemplateTestDataFour.testCaseId = "TC_VS_019";
			encounterTemplateTestDataFour.fetchClinicalSettingsTestData();
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientId);
			encounterPage=patientChartPage.clickbeginEncounter(driver);
			encounterPage.beginEncounter(driver);
			patientChartPage.recordWidgetsInEditedEncounterNote(driver, encounterTemplateTestDataFour,date1, encounterPage);
			patientChartPage.saveEncounter(driver, encounterPage);
			//-----------------------------------------------------------------------------//
			//  Step-14:Verify data in the flow sheet care elements                        //
			//-----------------------------------------------------------------------------//
			patientChartPage.navigateToManagedCareOnPatientChart(driver);
			patientChartPage.navigateToCareTemplateAlreadyOpen(driver,managedCareTemplate);
			patientChartPage.verifyDefaultVisitOutlineOnManagedCareTemplate(managedCareTemplate,driver,encounterTemplateTestDataFour);
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false,
					"Failed Due to the Exception; \n\t*) ExceptionDetails :"
							+ e.getMessage() + "\n\t*)", driver, className,
					methodName);
			}
		return true;
	}
}