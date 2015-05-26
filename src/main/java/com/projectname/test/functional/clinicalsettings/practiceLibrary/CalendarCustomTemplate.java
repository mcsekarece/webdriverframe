package com.projectname.test.functional.clinicalsettings.practiceLibrary;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.genericutility.testDataLib.SchedulingTestLib;
import com.projectname.testutils.pages.CalendarPage;
import com.projectname.testutils.pages.ClinicalSettingPage;
import com.projectname.testutils.pages.DemographicsPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientPersonalInfoPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.PracticeLibrary;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class CalendarCustomTemplate extends TestBaseClass{
	@Test(retryAnalyzer = RetryRule.class, groups ={"SingleThread", "Review"}, description = "Test for verify end to end visit flow")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void calendarCustomTemplate(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort){
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib calendarTemplate = new SchedulingTestLib();
		calendarTemplate.workSheetName = "VisitsEndToEnd";
		calendarTemplate.testCaseId = "TC_ETE_013";
		calendarTemplate.fetchSchedulingTestData();
		calendarCustomTemplateEndToEnd(calendarTemplate,userAccount);
    }
	/*
	* @purpose EndToEnd-Encounter(EndToEnd-section J) 
	* @author AspireQA
	* @since January 26, 2015
	* @version 2.1
	*/
	public boolean calendarCustomTemplateEndToEnd(SchedulingTestLib calendarTemplate,String userAccount)
	{
		SharedPage sharedPage=null;
		PatientRegistationPage patientRegistrationPage=null;
		CalendarPage calendarPage=null;
		ClinicalSettingPage clinicalSettingPage=null;
		PracticeLibrary practiceLibrary=null;
		PatientPersonalInfoPage patientPersonalInfoPage=null;
		DemographicsPage demographicsPage=null;
		PatientChartPage patientChartPage=null;
		EncounterPage encounterPage=null;
		
		String uniqueName=null,date=null;
		try {
			//--------------------------------------------------------------------//
			//  Verify if the Time Zone is EST //
			//--------------------------------------------------------------------//
			TimeZone timeZone = Calendar.getInstance().getTimeZone(); 
			System.out.println(timeZone.getDisplayName(false, TimeZone.SHORT)); 
			String currentTimeZone=timeZone.getDisplayName(false, TimeZone.SHORT);
			logTitleMessage("Current Time Zone is:"+ currentTimeZone);
			assertTrue(currentTimeZone.equals("EST"),"This script has to be Executed only in EST Time Zone", driver, className, methodName);
			// --------------------------------------------------------------------//
			// Step-1: Login to the application                                    //
			// --------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage = new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,
					userAccount, calendarTemplate.userName,
					calendarTemplate.userPassword);
			logTitleMessage("Login Successful");
			//---------------------------------------------------------------------//
			//  Step-2: Switch to particular user Role                             // 
			//---------------------------------------------------------------------//
			sharedPage=homePage.navigateToSharedPage();
			logTitleMessage("Select FULL as a user role");
			sharedPage.switchRole(driver,calendarTemplate.switchRole);
			logTitleMessage("User Role FULL selected successfully");
			//--------------------------------------------------------------------//
			// Step-3: Create a patient                                           //
			//--------------------------------------------------------------------//
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
			//---------------------------------------------------------------------//
			//  Step-4: Navigate to Visit section and create a template            //
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
			//  Step-5: Navigate to Visit outline and create a template            //
			//---------------------------------------------------------------------//
			logTitleMessage("Naviage to visit outline and add a new visit outline with a custom widget and a visit type");
			logTitleMessage("Visit section template created successfully");
			ClinicalSettingLib encounterVisitOutline = new ClinicalSettingLib();
			encounterVisitOutline.workSheetName = "CreateVisitSection";
			encounterVisitOutline.testCaseId = "TC_VS_009";
			encounterVisitOutline.fetchClinicalSettingsTestData();
			clinicalSettingPage.navigateToVisitoutline(driver, practiceLibrary);
			clinicalSettingPage.deleteAllVisitOutline(driver,practiceLibrary);
			clinicalSettingPage.startNewVisitOutline(practiceLibrary,driver,encounterVisitOutline,uniqueName);
			clinicalSettingPage.addVisitSectionWithVisitOutline(driver, encounterVisitSection, practiceLibrary);
			logTitleMessage("Successfully naviage to visit outline and added a new visit outline with a custom widget with a visit type");
			//---------------------------------------------------------------------//
			//  Step-6: Search the provider in calendar page                       //
			//---------------------------------------------------------------------//
			logTitleMessage("Naviage to calendar and delete already created appointment");
			SchedulingTestLib resouceCalendar = new SchedulingTestLib();
			resouceCalendar.workSheetName = "CreateResourceCalender";
			resouceCalendar.testCaseId = "TC_CRC_001";
			resouceCalendar.fetchSchedulingTestData();
			logTitleMessage("Navigate to Provider Calendar Page and open a provider calendar");
		    calendarPage=sharedPage.navigateToCalendar(driver);
			calendarPage.openProvidersCalendar(resouceCalendar,driver);
			logTitleMessage("Successfully Navigate and open a resource calendar");
			//---------------------------------------------------------------------//
			//  Step-7: Delete all appointment 
			//---------------------------------------------------------------------//
			calendarPage.deleteAllAppointment(driver,calendarTemplate);
			logTitleMessage("Successfully Naviage to calendar and deleted already created appointment");
			//---------------------------------------------------------------------//
			//  Step-8: Create an Appointment                                      //
			//---------------------------------------------------------------------//
			logTitleMessage("Create Appointment");
			calendarPage.makeResourceAppointment(driver,calendarTemplate,"one",patientId);
			logTitleMessage("Appointment Created successfully");
			//---------------------------------------------------------------------//
			//  Step-9: Navigate to Nexia home then go to patient chart            //
			//---------------------------------------------------------------------//
			logTitleMessage("Naviage to patient chart page from homepage");
			sharedPage.navigateToHomePage(driver);
			patientChartPage=homePage.navigateToPatientChartPage(driver);
			logTitleMessage("Successfully Naviage to patient chart page from homepage");
			//---------------------------------------------------------------------//
			//  Step-10: Begin an encounter and then record value for widgets      //
			//---------------------------------------------------------------------//	
			logTitleMessage("Begin an encounter and record values in the widgets");
			encounterPage=patientChartPage.clickbeginEncounter(driver);
			encounterPage.beginEncounter(driver);
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("ddMMyyyymmss");
			date = dateFormat1.format(cal1.getTime());
			patientChartPage.recordValuesForWidgetsInEncounter(driver, encounterVisitSection,date, encounterPage);
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Successfully saved encounter and record values in the widgets");
			//-------------------------------------------------------------------------------------------------//
			//  Step-11: Navigate to pending encounters in timeline and verify the recorded widgets value      //
			//-------------------------------------------------------------------------------------------------//
			logTitleMessage("Verify the recorded values in timeline");
			patientChartPage.gotoPendingEncounters(driver);		
			patientChartPage.verifyRecordedWidgetValuesInTimeLine(driver, encounterVisitSection, encounterPage);
			logTitleMessage("Successfully Verified the recorded values in timeline");
		}catch(Exception e)
		{
			e.printStackTrace();
			assertTrue(false,
					"Failed Due to the Exception; \n\t*) ExceptionDetails :"
							+ e.getMessage() + "\n\t*)", driver, className,
					methodName);
		}
		return true;
	}
}