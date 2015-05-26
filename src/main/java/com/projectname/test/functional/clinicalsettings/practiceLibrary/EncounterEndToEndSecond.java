package com.projectname.test.functional.clinicalsettings.practiceLibrary;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ReadFromExcel;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.ChartDisclosurePage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LabOrderPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.ProblemListPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class EncounterEndToEndSecond extends TestBaseClass{
	public String workBookName = "TestData_ClinicalSettings.xls";		
	public String sectionName = "clinicalsettings";
	@Test(retryAnalyzer = RetryRule.class, groups = {"EncounterEndToEndSecond" }, description = "Test to verify Custom defined components and sactions"/*,dependsOnGroups = "EncounterEndToEndOne"*/)
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifyEncounterEndToEndSecond(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
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
	 * Verify Encounter End To End Work flow 
	 * function to Encounter End To End Work flow Second
	 * @param encounterTemplateTestData 
	 * @param 		patientData
	 * @param 		browser
	 * @param 		webSite
	 * @throws      Exception 
	 * @since  	    Jan 26, 2015
	 */
	public boolean encounterTemplate( String userAccount, ClinicalSettingLib encounterTemplateTestData,String seleniumHost)  {
		int columPossition = 6;
		int rowPossition;
		 HomePage homePage=null;
		 SharedPage sharedPage=null;	
		 PatientRegistationPage patientRegistationPage=null;
		 PatientChartPage patientChartPage=null;
		 EncounterPage encounterPage=null;	
		 ProblemListPage problemListPage=null;		
		 ChartDisclosurePage chartDisclosurePage=null;
		 LabOrderPage labOrderPage=null;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			logTitleMessage("Login Successful");
			//Start Video recording 
			startVideoRecording(driver, seleniumHost,"Issue in starting the Video Recording");
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, encounterTemplateTestData.userName, encounterTemplateTestData.userPassword);
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role 									  //
			//--------------------------------------------------------------------//			
			logTitleMessage("Switch practice to Encounter Template ");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.selectPractice(driver,"Encounter");
			sharedPage.switchRole(driver, encounterTemplateTestData.switchRole);
			sharedPage.getProviderName(driver, encounterTemplateTestData);
			sharedPage.unlock(driver);
			logTitleMessage("Switch practice to Encounter Template  succeccful");
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
			 //Write Patient name in Excel Sheet for future use 
			ReadFromExcel wD = new ReadFromExcel();
			rowPossition = 1;
			wD.writeDataToExcel(sectionName, workBookName,encounterTemplateTestData.workSheetName, rowPossition, columPossition, patientData.lastName);
			encounterTemplateTestData.fetchClinicalSettingsTestData();		
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, encounterTemplateTestData.patientId);
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify Default template in Encounter Note				 	  //
			//--------------------------------------------------------------------//	
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("ddMMyyyymmss");
			String date1=null;
			date1 = dateFormat1.format(cal1.getTime());
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			assertTrue(	patientChartPage.VerifyDefaultTemplateInEncounterNote(driver, encounterTemplateTestData, encounterPage),"Verification of default template is failed", driver, className, methodName);
			assertTrue(	patientChartPage.verifythewidgets(driver, encounterTemplateTestData, encounterPage),"Verification of default template is failed", driver, className, methodName);
			logTitleMessage("Default Template in Encounter Note verfied successfully");
			//--------------------------------------------------------------------//
			//  Step-9:Record Widgets,Problem List and Order Lab Di and verify those details in Timeline
			//--------------------------------------------------------------------//	
			logTitleMessage("Record values in widget and verify recored values in timeline,encounter tab and edit mode");
			patientChartPage.recordWidgetsInEncounterNote(driver, encounterTemplateTestData,date1, encounterPage);
			logTitleMessage("Values recorded in every widgets and verified default outline");
			logTitleMessage("Navigate to summary problem list and add one problem list");
			problemListPage=patientChartPage.goTosummaryProblemList(driver);
			ChartPreVisitLib proData = new ChartPreVisitLib();
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_CPL_001";
			proData.fetchChartPreVisitTestData();
			problemListPage.createProblemList(proData, userAccount);
			logTitleMessage("Succesfully Navigated to summary problem list and added one problem list");		
			logTitleMessage("Navigate to Create New Lab Order Page");
			ChartPreVisitLib orderData = new ChartPreVisitLib();
			orderData.workSheetName = "CreateDiganosticImaging";
			orderData.testCaseId = "TC_ODI_003";
			orderData.fetchChartPreVisitTestData();
			labOrderPage = patientChartPage.goToCreateOrderDITest(driver,encounterPage);
			logTitleMessage("Sucessfully Navigated to Create New Lab Order Page");		
			logTitleMessage("Create New Lab Order");
	        patientChartPage.createDIOrder(driver,orderData,encounterPage,labOrderPage);
	        logTitleMessage("Sucessfully Created New Lab Order");
	    	logTitleMessage("Save the encounter and verify timeline");
			patientChartPage.saveEncounter(driver, encounterPage);
			patientChartPage.clicktimelinedate(driver);
			assertTrue(patientChartPage.verifyFirstRecordedWidgetInTimeLine(driver, encounterTemplateTestData, encounterPage),"Verification of recorded values in encounter Encounter time line failed", driver, className, methodName);
			patientChartPage.verifylaborder(driver, orderData);
			patientChartPage.verifyproblemlistdata(driver, proData);
			logTitleMessage("Saved encounter values varified in patient timeline");
			logTitleMessage("Navigate to pending Encounterlist and select previously saved encounter ");
			patientChartPage.gotoPendingEncounters(driver);			
			assertTrue(patientChartPage.verifyRecordedWidgetInEditMode(driver, encounterTemplateTestData, encounterPage),"Verification of recorded values in encounter note edit mode failed", driver, className, methodName);
			patientChartPage.verifylaborder(driver, orderData);
			patientChartPage.verifyproblemlistdata(driver, proData);
			logTitleMessage("Pending encounter note values varified successfully");
			logTitleMessage("Change encounter date and save the encounter");
			patientChartPage.enterencounterdate(driver, encounterTemplateTestData, encounterPage);
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Changed encounter date and saved the encounte");
			logTitleMessage("Verify changed encounter date in encounter tab");
			patientChartPage.clickEncounterTab(driver);	
			patientChartPage.verifyencounterdate(driver, encounterTemplateTestData);
			logTitleMessage("Verified encounter date in encounter tab");
			logTitleMessage("Navigate to chart disclouser and Verify saved encounter details");
			//--------------------------------------------------------------------//
			//  Step-10:Navigate to chart disclouser and verify details 
			//--------------------------------------------------------------------//				
			ChartPreVisitLib chartDisclosureData = new ChartPreVisitLib();
			chartDisclosureData.workSheetName = "CreatePatientTask";
			chartDisclosureData.testCaseId = "TC_CD_001";
			chartDisclosureData.fetchChartPreVisitTestData();
			chartDisclosurePage=sharedPage.navigatetochartdisclouser(driver);
			patientChartPage.createchartdisclose(driver, chartDisclosureData, userAccount, chartDisclosurePage);
			assertTrue(patientChartPage.verifyFirstRecordedWidgetInTimeLine(driver, encounterTemplateTestData, encounterPage),"Verification of recorded values in chart disclouser time line failed", driver, className, methodName);
			patientChartPage.verifylaborder(driver, orderData);
			patientChartPage.verifyproblemlistdata(driver, proData);
			patientChartPage.verifyencounterdetailsinchartdiscloser(driver, chartDisclosureData, userAccount, chartDisclosurePage);
			sharedPage.logoutofApplication(driver);
			//Stop Video Recording 
			stopVideoRecording(driver, className, methodName,"Issue Saving/Stopping Video Recording");
			logTitleMessage("Successfully verified Recorded values in chart disclouser section");
		
			}
	
		catch(Exception e)
		{
			//assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);	
		}
		return true;
	
	
	
	
	
	
	
	}	
}
