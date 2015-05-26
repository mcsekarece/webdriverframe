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

public class VerifyCancelEncounterSevenForSocialHistory extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private SocialHistoryPage socialHistoryPage=null;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Cancel Encounter Social History: 11")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterSevenForSocialHistory(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ChartPreVisitLib socialHisData = new ChartPreVisitLib();
	 socialHisData.workSheetName = "CreateSocialHistory";
	 socialHisData.testCaseId = "TC_ESH_001";
	 socialHisData.fetchChartPreVisitTestData(); 
	 verifySocialHistory(socialHisData,userAccount);
}

	/**
     * verifySocialHistory
     * To Verify function Cancel Encounter 
     * @param socialHisData(Social History details to be added)
     * @param userAccount(Application Environment)
     * @since  Mar 25, 2015
     */

	public boolean verifySocialHistory(ChartPreVisitLib socialHisData, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,socialHisData.userName, socialHisData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient 	 								  //
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
			//  Step-3:Search newly created Patient							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-4:Begin an Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Create Encounter Social History");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			socialHistoryPage=patientChartPage.goToSocialHistory(driver);
		    patientChartPage.createEncounterSocialHistoryEndToEnd(driver, socialHisData, userAccount, socialHistoryPage, encounterPage);
		    patientChartPage.addEncounterSocialHistory(driver, socialHistoryPage);
			logTitleMessage("Encounter Social History creation successful");
			
			//--------------------------------------------------------------------//
			//  Step-5:   Save the Encounter and Log out	  				            	  // 
			//--------------------------------------------------------------------//
			logTitleMessage("Save the encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter");

			logTitleMessage("Log out");
			sharedPage.logoutofApplication(driver);
			logTitleMessage("Log out successful");
			
			//--------------------------------------------------------------------//
			//  Step-6:Login into application as User B							 	  //
			//--------------------------------------------------------------------//	
		
			logTitleMessage("Login as different user");
			ChartPreVisitLib socialHisData2 = new ChartPreVisitLib();
			socialHisData2.workSheetName = "CreateSocialHistory";
			socialHisData2.testCaseId = "TC_ESH_003";
			socialHisData2.fetchChartPreVisitTestData(); 

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, socialHisData2.userName, socialHisData2.userPassword);
			logTitleMessage("Login successful");

			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, socialHisData2.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");

			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-7:Edit Social History from Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Social History from Summary A -> B");
			patientChartPage.clickSummaryTab(driver);
			socialHistoryPage=patientChartPage.goToSocialHistory(driver);
			patientChartPage.clickEditEncounterSocialHistory(driver, socialHistoryPage);

		    patientChartPage.createSocialHistoryEndToEnd(driver, socialHisData2, userAccount, socialHistoryPage);
		    patientChartPage.clickSaveEditSocialHistory(driver, socialHistoryPage);
		    patientChartPage.clickSaveSummaryEditSocialHistory(driver, socialHistoryPage);
			logTitleMessage("Social History edit successful");

			logTitleMessage("Log out");
			sharedPage.logoutofApplication(driver);
			logTitleMessage("Log out successful");
			
			//--------------------------------------------------------------------//
			//  Step-8:Login into application as User A							 	  //
			//--------------------------------------------------------------------//	
			logTitleMessage("Login as different user and search patient");
			ChartPreVisitLib socialHisData3 = new ChartPreVisitLib();
			socialHisData3.workSheetName = "CreateSocialHistory";
			socialHisData3.testCaseId = "TC_ESH_004";
			socialHisData3.fetchChartPreVisitTestData(); 

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, socialHisData3.userName, socialHisData3.userPassword);
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Login and search patient successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit the Social History again from Pending Encounter						 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Social History in encounter : B -> C");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEncounterSocialHistory(driver, encounterPage);
			patientChartPage.clickEditEncounterSocialHistory(driver, socialHistoryPage);

		    patientChartPage.createEncounterSocialHistoryEndToEnd(driver, socialHisData3, userAccount, socialHistoryPage, encounterPage);
		    patientChartPage.clickSaveEditSocialHistory(driver, socialHistoryPage);
			logTitleMessage("Social History edit in encounter successful");
		    
			//--------------------------------------------------------------------//
			//  Step-10:Cancel the Encounter							 	      //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-11:Verify Social History in Summary							  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Social History in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifySocialHistoryInSummary(driver,socialHisData,socialHisData2,userAccount );
			logTitleMessage("Verification successful");
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
		}
	return returnValue;
}
}
