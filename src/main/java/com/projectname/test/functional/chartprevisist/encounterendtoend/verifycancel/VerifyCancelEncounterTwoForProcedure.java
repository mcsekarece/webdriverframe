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
import com.projectname.testutils.pages.ProcedurePage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyCancelEncounterTwoForProcedure extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private ProcedurePage procedurePage=null;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify cancel Encounter Procedure: 4")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterTwoForProcedure(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProcedure";
		proData.testCaseId = "TC_CP_053";
		proData.fetchChartPreVisitTestData();
		verifyCancel(userAccount, proData);
	}	
		/**
		 * verify Cancel Encounter
		 * function to verify Cancel Encounter
		 * @param 		proData 
		 * @param 		patientData
		 * @param 		browser
		 * @param 		webSite
		 * @throws      Exception 
		 * @since  	    Mar 25, 2015
		 */

	
	private boolean verifyCancel(String userAccount,ChartPreVisitLib proData) throws Exception {
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, proData.userName, proData.userPassword);
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
			//  Step-5:Add Summary Procedure								 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Add Summary Procedure");
			patientChartPage.clickSummaryTab(driver);
			procedurePage=patientChartPage.navigatetoProcedure(driver);
		    patientChartPage.createSummaryProcedure(driver, proData, userAccount, procedurePage);
		    patientChartPage.clickAddProcedure(procedurePage);
		    patientChartPage.saveAddedProcedure(procedurePage);
			logTitleMessage("Summary Procedure added successfully");

			//--------------------------------------------------------------------//
			//  Step-6:Begin an Encounter							 	  		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Procedure in encounter A -> B");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			patientChartPage.goToEncounterProcedure(driver, encounterPage);
			patientChartPage.clickEditProcedure(procedurePage);
			ChartPreVisitLib proData2 = new ChartPreVisitLib();
			proData2.workSheetName = "CreateProcedure";
			proData2.testCaseId = "TC_CP_054";
			proData2.fetchChartPreVisitTestData();

		    patientChartPage.createEncounterProcedure(driver, proData2, userAccount, encounterPage, procedurePage);
		    patientChartPage.saveEditededProcedure(procedurePage);
			logTitleMessage("Procedure edit in encounter successful");

			//--------------------------------------------------------------------//
			//  Step-7:Save the Encounter							 	  		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Save the Encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Encounter saved successfully");

			//--------------------------------------------------------------------//
			//  Step-8:Edit Procedure from Summary							      //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit procedure from Summary B -> C");
			patientChartPage.clickSummaryTab(driver);
			procedurePage=patientChartPage.navigatetoProcedure(driver);
			patientChartPage.clickEditProcedure(procedurePage);
			ChartPreVisitLib proData3 = new ChartPreVisitLib();
			proData3.workSheetName = "CreateProcedure";
			proData3.testCaseId = "TC_CP_055";
			proData3.fetchChartPreVisitTestData();

		    patientChartPage.createSummaryProcedure(driver, proData3, userAccount, procedurePage);
		    patientChartPage.saveEditededProcedure(procedurePage);
		    patientChartPage.saveAddedProcedure(procedurePage);
			logTitleMessage("Procedure edit successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit the Procedure again from Pending Encounter	       	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Procedure in encounter : C -> D");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEncounterProcedure(driver, encounterPage);
			patientChartPage.clickEditProcedure(procedurePage);
			ChartPreVisitLib proData4 = new ChartPreVisitLib();
			proData4.workSheetName = "CreateProcedure";
			proData4.testCaseId = "TC_CP_056";
			proData4.fetchChartPreVisitTestData();

		    patientChartPage.createEncounterProcedure(driver, proData4, userAccount, encounterPage, procedurePage);
		    patientChartPage.saveEditededProcedure(procedurePage);
			logTitleMessage("Procedure edit in encounter successful");

			//--------------------------------------------------------------------//
			//  Step-10:Cancel the Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-11:Verify Injection in Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify injection in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyProcedureInSummary(driver, proData3, userAccount);
			logTitleMessage("Verification successful");

		}
		catch(RuntimeException e)
			{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
			}
		return true;
	}
}
