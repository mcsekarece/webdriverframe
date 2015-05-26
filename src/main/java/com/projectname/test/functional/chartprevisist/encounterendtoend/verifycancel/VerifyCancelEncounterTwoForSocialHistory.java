package com.projectname.test.functional.chartprevisist.encounterendtoend.verifycancel;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.pages.SocialHistoryPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyCancelEncounterTwoForSocialHistory extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private SocialHistoryPage socialHistoryPage=null;


	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify cancel Encounter Social History: 4")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterTwoForSocialHistory(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		 ChartPreVisitLib socialHisData = new ChartPreVisitLib();
		 socialHisData.workSheetName = "CreateSocialHistory";
		 socialHisData.testCaseId = "TC_ESH_001";
		 socialHisData.fetchChartPreVisitTestData(); 
		verifyCancel(userAccount, socialHisData);
	}	
		/**
		 * verify Cancel Encounter
		 * function to verify Cancel Encounter
		 * @param 		socialHisData 
		 * @param 		patientData
		 * @param 		browser
		 * @param 		webSite
		 * @throws      Exception 
		 * @since  	    Mar 25, 2015
		 */

	
	private boolean verifyCancel(String userAccount,ChartPreVisitLib socialHisData) throws Exception {
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, socialHisData.userName, socialHisData.userPassword);
			logTitleMessage("Login Successful");			
			
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
			//  Step-5:Add Summary Social History								 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Add Summary Social History");
			patientChartPage.clickSummaryTab(driver);
			socialHistoryPage=patientChartPage.goToSocialHistory(driver);
		    patientChartPage.createSocialHistoryEndToEnd(driver, socialHisData, userAccount, socialHistoryPage);
		    patientChartPage.saveSummarySocialHistory(driver, socialHistoryPage);
			logTitleMessage("Summary Social History added successfully");

			//--------------------------------------------------------------------//
			//  Step-6:Begin an Encounter							 	  		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Social History in encounter A -> B");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			patientChartPage.goToEncounterSocialHistory(driver, encounterPage);
			patientChartPage.clickEditEncounterSocialHistory(driver, socialHistoryPage);
			ChartPreVisitLib socialHisData2 = new ChartPreVisitLib();
			socialHisData2.workSheetName = "CreateSocialHistory";
			socialHisData2.testCaseId = "TC_ESH_002";
			socialHisData2.fetchChartPreVisitTestData(); 

		    patientChartPage.createEncounterSocialHistoryEndToEnd(driver, socialHisData2, userAccount, socialHistoryPage, encounterPage);
		    patientChartPage.clickSaveEditSocialHistory(driver, socialHistoryPage);
			logTitleMessage("Social History edit in encounter successful");

			//--------------------------------------------------------------------//
			//  Step-7:Save the Encounter							 	  		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Save the Encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Encounter saved successfully");

			//--------------------------------------------------------------------//
			//  Step-8:Edit Social History from Summary							  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Social History from Summary B -> C");
			patientChartPage.clickSummaryTab(driver);
			socialHistoryPage=patientChartPage.goToSocialHistory(driver);
			patientChartPage.clickEditEncounterSocialHistory(driver, socialHistoryPage);
			ChartPreVisitLib socialHisData3 = new ChartPreVisitLib();
			socialHisData3.workSheetName = "CreateSocialHistory";
			socialHisData3.testCaseId = "TC_ESH_003";
			socialHisData3.fetchChartPreVisitTestData(); 

		    patientChartPage.createSocialHistoryEndToEnd(driver, socialHisData3, userAccount, socialHistoryPage);
		    patientChartPage.clickSaveEditSocialHistory(driver, socialHistoryPage);
		    patientChartPage.clickSaveSummaryEditSocialHistory(driver, socialHistoryPage);
			logTitleMessage("Social History edit successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit the Social History again from Pending Encounter		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Social History in encounter : C -> D");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEncounterSocialHistory(driver, encounterPage);
			patientChartPage.clickEditEncounterSocialHistory(driver, socialHistoryPage);
			ChartPreVisitLib socialHisData4 = new ChartPreVisitLib();
			socialHisData4.workSheetName = "CreateSocialHistory";
			socialHisData4.testCaseId = "TC_ESH_004";
			socialHisData4.fetchChartPreVisitTestData(); 

		    patientChartPage.createEncounterSocialHistoryEndToEnd(driver, socialHisData4, userAccount, socialHistoryPage, encounterPage);
		    patientChartPage.clickSaveEditSocialHistory(driver, socialHistoryPage);
			logTitleMessage("Social History edit in encounter successful");

			//--------------------------------------------------------------------//
			//  Step-10:Cancel the Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-11:Verify Social History in Summary							  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Social History in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifySocialHistoryInSummary(driver,socialHisData,socialHisData3,userAccount );
			logTitleMessage("Verification successful");

		}
		catch(RuntimeException e)
			{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
			}
		
		return true;
	}
}
