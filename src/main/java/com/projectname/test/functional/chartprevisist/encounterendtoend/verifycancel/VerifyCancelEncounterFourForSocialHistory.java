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

public class VerifyCancelEncounterFourForSocialHistory extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private SocialHistoryPage socialHistoryPage=null;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify cancel Encounter For Social History: 6")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterFourForSocialHistory(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		 ChartPreVisitLib socialHisData = new ChartPreVisitLib();
		 socialHisData.workSheetName = "CreateSocialHistory";
		 socialHisData.testCaseId = "TC_ESH_001";
		 socialHisData.fetchChartPreVisitTestData(); 
		verifyCancel(userAccount, socialHisData, webSite, browser, seleniumHost, seleniumPort);
	}	
		/**
		 * verify Cancel Encounter
		 * function to verify Cancel Encounter
		 * @param immData 
		 * @param 		patientData
		 * @param 		browser
		 * @param 		webSite
		 * @throws      Exception 
		 * @since  	    May 25, 2015
		 */

		
	private boolean verifyCancel(String userAccount,ChartPreVisitLib socialHisData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
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
			//  Step-3: Create a new patient								 	  //
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
			//  Step-5:Add Summary Social History							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Add Summary Social History");
			patientChartPage.clickSummaryTab(driver);
			socialHistoryPage=patientChartPage.goToSocialHistory(driver);
		    patientChartPage.createSocialHistoryEndToEnd(driver, socialHisData, userAccount, socialHistoryPage);
		    patientChartPage.saveSummarySocialHistory(driver, socialHistoryPage);
			logTitleMessage("Summary Social History added successfully");

			//--------------------------------------------------------------------//
			//  Step-6:Begin an Encounter							 	  //
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
			//  Step-7:Log out of application		 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Log out");
			sharedPage.logoutofApplication(driver);
			driver.close();
			logTitleMessage("Log out successful");
			
			//--------------------------------------------------------------------//
			//  Step-8:Login into application as User B							 	  //
			//--------------------------------------------------------------------//	
			logTitleMessage("Login as different user");
			genericSetUp(webSite, browser, userAccount, seleniumHost, seleniumPort);
			ChartPreVisitLib socialHisData3 = new ChartPreVisitLib();
			socialHisData3.workSheetName = "CreateSocialHistory";
			socialHisData3.testCaseId = "TC_ESH_003";
			socialHisData3.fetchChartPreVisitTestData(); 

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, socialHisData3.userName, socialHisData3.userPassword);
			logTitleMessage("Login successful");
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, socialHisData3.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");

			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit Social History from Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Social History from Summary B -> C");
			patientChartPage.clickSummaryTab(driver);
			socialHistoryPage=patientChartPage.goToSocialHistory(driver);
			patientChartPage.clickEditEncounterSocialHistory(driver, socialHistoryPage);

		    patientChartPage.createSocialHistoryEndToEnd(driver, socialHisData3, userAccount, socialHistoryPage);
		    patientChartPage.clickSaveEditSocialHistory(driver, socialHistoryPage);
		    patientChartPage.clickSaveSummaryEditSocialHistory(driver, socialHistoryPage);
			logTitleMessage("Social History edit successful");

			//--------------------------------------------------------------------//
			//  Step-9:Log out							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Log out");
			sharedPage.logoutofApplication(driver);
			driver.close();
			logTitleMessage("Log out successful");

			//--------------------------------------------------------------------//
			//  Step-9:Log in as User A							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Log in as User A");
			genericSetUp(webSite, browser, userAccount, seleniumHost, seleniumPort);
			ChartPreVisitLib socialHisData4 = new ChartPreVisitLib();
			socialHisData4.workSheetName = "CreateSocialHistory";
			socialHisData4.testCaseId = "TC_ESH_004";
			socialHisData4.fetchChartPreVisitTestData(); 

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, socialHisData4.userName, socialHisData4.userPassword);
			logTitleMessage("Login successful");
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-10:Edit the Social History again	from Pending Encounter						 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Social History in encounter : C -> D");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEncounterSocialHistory(driver, encounterPage);
			patientChartPage.clickEditEncounterSocialHistory(driver, socialHistoryPage);

		    patientChartPage.createEncounterSocialHistoryEndToEnd(driver, socialHisData4, userAccount, socialHistoryPage, encounterPage);
		    patientChartPage.clickSaveEditSocialHistory(driver, socialHistoryPage);
			logTitleMessage("Social History edit in encounter successful");

			//--------------------------------------------------------------------//
			//  Step-11:Cancel the Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-12:Verify Social History in Summary							 	  //
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
