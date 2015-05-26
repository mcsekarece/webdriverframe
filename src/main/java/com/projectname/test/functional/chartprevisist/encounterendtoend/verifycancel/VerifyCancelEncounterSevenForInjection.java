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
import com.projectname.testutils.pages.InjectionPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyCancelEncounterSevenForInjection extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private InjectionPage injectionPage=null;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Cancel Encounter Injection: 11")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterSevenForInjection(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_058";
		injectionData.fetchChartPreVisitTestData();
	 verifyInjection(injectionData,userAccount);
}

	/**
     * verifyInjection
     * To Verify function Cancel Encounter 
     * @param injectionData(Injection details to be added)
     * @param userAccount(Application Environment)
     * @since  Mar 25, 2015
     */

	public boolean verifyInjection(ChartPreVisitLib injectionData, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,injectionData.userName, injectionData.userPassword);
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
			logTitleMessage("Create Encounter Injection from Summary");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			injectionPage=patientChartPage.goToInjection(driver);
		    patientChartPage.createEncounterInjectionEndToEnd(driver, injectionData, userAccount, injectionPage, encounterPage);
		    patientChartPage.saveSummaryInjection(driver, injectionPage);
			logTitleMessage("Encounter Injection creation successful");
			
			//--------------------------------------------------------------------//
			//  Step-5:   Save the Encounter and Log out	  				      // 
			//--------------------------------------------------------------------//
			logTitleMessage("Save the encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter");

			logTitleMessage("Log out");
			sharedPage.logoutofApplication(driver);
			logTitleMessage("Log out successful");
			
			//--------------------------------------------------------------------//
			//  Step-6:Login into application as User B							  //
			//--------------------------------------------------------------------//	
		
			logTitleMessage("Login as different user");
			ChartPreVisitLib injectionData2 = new ChartPreVisitLib();
			injectionData2.workSheetName = "CreateInjection";
			injectionData2.testCaseId = "TC_CI_059";
			injectionData2.fetchChartPreVisitTestData();

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, injectionData2.userName, injectionData2.userPassword);
			logTitleMessage("Login successful");

			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, injectionData2.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");

			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-7:Edit Injection from Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Injection from Summary A -> B");
			patientChartPage.clickSummaryTab(driver);
			injectionPage=patientChartPage.goToInjection(driver);
			patientChartPage.clickEditInjection(driver, injectionPage);

		    patientChartPage.createInjectionEndToEnd(driver, injectionData2, userAccount, injectionPage);
		    patientChartPage.clickSaveEditInjection(driver, injectionPage);
		    patientChartPage.clickSaveInjection(driver, injectionPage);
			logTitleMessage("Injection edit successful");

			logTitleMessage("Log out");
			sharedPage.logoutofApplication(driver);
			logTitleMessage("Log out successful");
			
			//--------------------------------------------------------------------//
			//  Step-8:Login into application as User A							 	  //
			//--------------------------------------------------------------------//	
			logTitleMessage("Login as different user and search patient");
			ChartPreVisitLib injectionData3 = new ChartPreVisitLib();
			injectionData3.workSheetName = "CreateInjection";
			injectionData3.testCaseId = "TC_CI_060";
			injectionData3.fetchChartPreVisitTestData();

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, injectionData3.userName, injectionData3.userPassword);
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Login and search patient successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit the injection again	from Pending Encounter						 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Injection in encounter : B -> C");
			patientChartPage.gotoPendingEncounters(driver);
			injectionPage=patientChartPage.goToEncounterInjection(driver, encounterPage);
			patientChartPage.clickEditInjection(driver, injectionPage);

		    patientChartPage.createEncounterInjectionEndToEnd(driver, injectionData3, userAccount, injectionPage, encounterPage);
		    patientChartPage.clickSaveEditInjection(driver, injectionPage);
			logTitleMessage("Injection edit in encounter successful");
		    
			//--------------------------------------------------------------------//
			//  Step-10:Cancel the Encounter							 	      //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-10:Verify Injection in Summary							  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Injection in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyInjectionInSummary(driver, injectionData2, userAccount);
			logTitleMessage("Verification successful");
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
		}
	return returnValue;
}
}
