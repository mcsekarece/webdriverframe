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

public class VerifyCancelEncounterTwoForInjection extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private InjectionPage injectionPage=null;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify cancel Encounter Problem List: 4")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterTwoForInjection(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_058";
		injectionData.fetchChartPreVisitTestData();
		verifyCancel(userAccount, injectionData);
	}	
		/**
		 * verify Cancel Encounter
		 * function to verify Cancel Encounter
		 * @param 		injectionData 
		 * @param 		patientData
		 * @param 		browser
		 * @param 		webSite
		 * @throws      Exception 
		 * @since  	    Mar 25, 2015
		 */

	
	private boolean verifyCancel(String userAccount,ChartPreVisitLib injectionData) throws Exception {
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, injectionData.userName, injectionData.userPassword);
			logTitleMessage("Login Successful");			

			//--------------------------------------------------------------------//
			//  Step-3: Create a new patient 									  //
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
			//  Step-5:Add Summary Injection								 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Add Summary Injection");
			patientChartPage.clickSummaryTab(driver);
			injectionPage=patientChartPage.goToInjection(driver);
		    patientChartPage.createInjectionEndToEnd(driver, injectionData, userAccount, injectionPage);
		    patientChartPage.saveSummaryInjection(driver, injectionPage);
		    patientChartPage.clickSaveInjection(driver, injectionPage);
			logTitleMessage("Summary Injection added successfully");

			//--------------------------------------------------------------------//
			//  Step-6:Begin an Encounter							 	  		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Injection in encounter A -> B");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			patientChartPage.goToEncounterInjection(driver, encounterPage);
			patientChartPage.clickEditInjection(driver, injectionPage);
			ChartPreVisitLib injectionData2 = new ChartPreVisitLib();
			injectionData2.workSheetName = "CreateInjection";
			injectionData2.testCaseId = "TC_CI_059";
			injectionData2.fetchChartPreVisitTestData();

		    patientChartPage.createEncounterInjectionEndToEnd(driver, injectionData2, userAccount, injectionPage, encounterPage);
		    patientChartPage.clickSaveEditInjection(driver, injectionPage);
			logTitleMessage("Injection edit in encounter successful");

			//--------------------------------------------------------------------//
			//  Step-7:Save the Encounter							 	  		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Save the Encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Encounter saved successfully");

			//--------------------------------------------------------------------//
			//  Step-8:Edit Injection from Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Injection from Summary B -> C");
			patientChartPage.clickSummaryTab(driver);
			injectionPage=patientChartPage.goToInjection(driver);
			patientChartPage.clickEditInjection(driver, injectionPage);
			ChartPreVisitLib injectionData3 = new ChartPreVisitLib();
			injectionData3.workSheetName = "CreateInjection";
			injectionData3.testCaseId = "TC_CI_060";
			injectionData3.fetchChartPreVisitTestData();

		    patientChartPage.createInjectionEndToEnd(driver, injectionData3, userAccount, injectionPage);
		    patientChartPage.clickSaveEditInjection(driver, injectionPage);
		    patientChartPage.clickSaveInjection(driver, injectionPage);
			logTitleMessage("Injection edit successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit the Injection again from Pending Encounter						 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Injection in encounter : C -> D");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEncounterInjection(driver, encounterPage);
			patientChartPage.clickEditInjection(driver, injectionPage);
			ChartPreVisitLib injectionData4 = new ChartPreVisitLib();
			injectionData4.workSheetName = "CreateInjection";
			injectionData4.testCaseId = "TC_CI_061";
			injectionData4.fetchChartPreVisitTestData();

		    patientChartPage.createEncounterInjectionEndToEnd(driver, injectionData4, userAccount, injectionPage, encounterPage);
		    patientChartPage.clickSaveEditInjection(driver, injectionPage);
			logTitleMessage("Injection edit in encounter successful");

			//--------------------------------------------------------------------//
			//  Step-10:Cancel the Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-12:Verify Injection in Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify injection in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyInjectionInSummary(driver, injectionData3, userAccount);
			logTitleMessage("Verification successful");

		}
		catch(RuntimeException e)
			{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
			}
		return true;
	}

}
