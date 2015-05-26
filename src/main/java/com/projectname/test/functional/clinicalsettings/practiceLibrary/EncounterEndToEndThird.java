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
public class EncounterEndToEndThird extends TestBaseClass{
	@Test(retryAnalyzer = RetryRule.class, groups = {"EncounterEndToEndThird" }, description = "Test to verify Custom defined components and sactions"/*,dependsOnGroups = "EncounterEndToEndSecond"*/)
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifyEncounterEndToEndThird(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
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
	 * Verify Encounter End To End Work flow Three
	 * function to Encounter End To End Work flow Three
	 * @param encounterTemplateTestData 
	 * @param 		patientData
	 * @param 		browser
	 * @param 		webSite
	 * @throws      Exception 
	 * @since  	    Jan 26, 2015
	 */
	public boolean encounterTemplate( String userAccount, ClinicalSettingLib encounterTemplateTestData,String seleniumHost)  {
		
		 HomePage homePage=null;
		 SharedPage sharedPage=null;
		 EncounterPage encounterPage=null;
		 AllergyPage allergyPage=null;
		 LabOrderPage labOrderPage=null;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1:Login into application as different user							 	  
			//--------------------------------------------------------------------//	
			//Start Video recording 
			startVideoRecording(driver, seleniumHost,"Issue in starting the Video Recording");
			LoginPage loginPage=new LoginPage();
			logTitleMessage("Login as different user and Switch practice to Encounter Template ");
			ClinicalSettingLib encounterTemplateTestData1 = new ClinicalSettingLib();
			encounterTemplateTestData1.workSheetName = "CreateVisitSection";
			encounterTemplateTestData1.testCaseId = "TC_VS_006";
			encounterTemplateTestData1.fetchClinicalSettingsTestData();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, encounterTemplateTestData1.userName, encounterTemplateTestData1.userPassword);
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.selectPractice(driver,"Encounter");
			sharedPage.switchRole(driver, encounterTemplateTestData1.switchRole);
			sharedPage.getProviderName(driver, encounterTemplateTestData1);
			sharedPage.unlock(driver);
			logTitleMessage("Switch practice to Encounter Template successful");
			//--------------------------------------------------------------------//
			//  Step-2:Search Patient							 	 
			//--------------------------------------------------------------------//		
			logTitleMessage("Search patient and add Allergy and Lab order in Pending Encounter ");
			sharedPage.searchPatientNexiaForProviderHomePage(driver,encounterTemplateTestData.patientId);
			PatientChartPage patientChartPage =new PatientChartPage();
			encounterPage=patientChartPage.gotoPendingEncounters(driver);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all Encounter Allergy							 	 
			//--------------------------------------------------------------------//		
			allergyPage = patientChartPage.goToEncounterAllergy(driver, encounterPage);
			ChartPreVisitLib allergyData = new ChartPreVisitLib();
			allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CA_001";
			allergyData.fetchChartPreVisitTestData();
			patientChartPage.deleteAllAllergy( allergyPage,driver, allergyData);
			
			//--------------------------------------------------------------------//
			//  Step-4:Create Encounter Allergy,Lab Order  and Sign the Encounter		 	  
			//--------------------------------------------------------------------//
			patientChartPage.createEncounterAllergy(driver, allergyData, userAccount, encounterPage, allergyPage);
			assertTrue(patientChartPage.VerifyDefaultTemplateInEncounterNote(driver, encounterTemplateTestData, encounterPage),"Verification of recorded values in encounter note edit mode for second user failed", driver, className, methodName);
			logTitleMessage("Navigate to Create New Lab Order Page");
			ChartPreVisitLib diData1 = new ChartPreVisitLib();
			diData1.workSheetName = "CreateLabOrder";
			diData1.testCaseId = "TC_NLO_004";
			diData1.fetchChartPreVisitTestData();
			ChartPreVisitLib diData = new ChartPreVisitLib();
			diData.workSheetName = "CreateLabOrder";
			diData.testCaseId = "TC_NLO_003";
			diData.fetchChartPreVisitTestData();
			labOrderPage = patientChartPage.goToCreateOrderLabTest(driver,encounterPage);			
			logTitleMessage("Sucessfully Navigated to Create New Lab Order Page");
			logTitleMessage("Create New Lab Order");
	        patientChartPage.createNewOrderLabTestwithoutprint(driver,diData1,encounterPage,labOrderPage);
	        logTitleMessage("Sucessfully Created New Lab Order");	        
	    	ChartPreVisitLib orderData = new ChartPreVisitLib();
			orderData.workSheetName = "CreateDiganosticImaging";
			orderData.testCaseId = "TC_ODI_004";  
			orderData.fetchChartPreVisitTestData();
			ChartPreVisitLib orderData1 = new ChartPreVisitLib();
			orderData1.workSheetName = "CreateDiganosticImaging";
			orderData1.testCaseId = "TC_ODI_003";  
			orderData1.fetchChartPreVisitTestData();
			labOrderPage = patientChartPage.editDIOrder(driver,encounterPage);
			logTitleMessage("Sucessfully Navigated to Create New Lab Order Page");		
			logTitleMessage("Create New Lab Order");
	        patientChartPage.createDIOrder(driver,orderData,encounterPage,labOrderPage);	        
			patientChartPage.signEncounter(driver, encounterPage);
			logTitleMessage("Allergy and laborder added to encounter and Signed the encounter  successfully");

			//--------------------------------------------------------------------//
			//  Step-5:Verify details in Encounter tab and in Show Mark up for the Signed Encounter		    	  
			//--------------------------------------------------------------------//
			logTitleMessage("Verify details in Signed encounter under encounter tab ");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.clickExpandAll();
			patientChartPage.verifyFirstRecordedWidgetInTimeLine(driver, encounterTemplateTestData, encounterPage);
			logTitleMessage("Verified signed encounter details successfully ");
			logTitleMessage("Navigate to signed encounter show markup and verify details");
			ChartPreVisitLib proData = new ChartPreVisitLib();
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_CPL_001";
			proData.fetchChartPreVisitTestData();
			String date1=null;
			assertTrue(	patientChartPage.verifyShowMarkupInSignedEncounter(driver,encounterTemplateTestData,encounterTemplateTestData1,allergyData, date1,userAccount),"Verification of recorded values in shpow mark up is failed ", driver, className, methodName);
			assertTrue(	patientChartPage.verifyFirstRecordedWidgetInTimeLine(driver, encounterTemplateTestData, encounterPage),"Verification of recorded values in shpow mark up is failed ", driver, className, methodName);
			patientChartPage.verifytext(driver,orderData.labTestName);
			patientChartPage.verifytext(driver,orderData1.labTestName);
			assertTrue(patientChartPage.verifylaborder(driver, diData1),"Verification of recorded values in shpow mark up is failed ", driver, className, methodName);
			assertTrue(	patientChartPage.verifyproblemlistdata(driver, proData),"Verification of recorded values in shpow mark up is failed ", driver, className, methodName);
			patientChartPage.clicksecondversion(driver);		
			sharedPage.logoutofApplication(driver);
			//Stop Video Recording 
			stopVideoRecording(driver, className, methodName,"Issue Saving/Stopping Video Recording");
			logTitleMessage("Navigated to signed encounter show markup and verified details successfully");

		}
	
		
		catch (Exception e)
		{
 			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
		}
		return true;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
}
