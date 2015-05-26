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
import com.projectname.testutils.pages.VitalsPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyCancelEncounterSixForVitals extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private VitalsPage vitalsPage=null;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify cancel Encounter For Vitals: 10")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterSixForVitals(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
	    vitalsData.workSheetName = "CreateVitals";
	    vitalsData.testCaseId = "TC_ECV_001";
	    vitalsData.fetchChartPreVisitTestData();
		verifyCancel(userAccount, vitalsData, webSite, browser, seleniumHost, seleniumPort);
	}	
		/**
		 * verify Cancel Encounter
		 * function to verify Cancel Encounter
		 * @param proData 
		 * @param 		patientData
		 * @param 		browser
		 * @param 		webSite
		 * @throws      Exception 
		 * @since  	    May 21, 2015
		 */

		
	private boolean verifyCancel(String userAccount,ChartPreVisitLib vitalsData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, vitalsData.userName, vitalsData.userPassword);
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
			//  Step-5:Begin an Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Create Encounter Vitals");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			vitalsPage=patientChartPage.goToEncounterVitals(driver, encounterPage);
			patientChartPage.addEncounterVitals(driver,encounterPage,vitalsPage,vitalsData);
			logTitleMessage("Encounter Vitals creation successful");
			
			//--------------------------------------------------------------------//
			//  Step-6:Save the Encounter and Log out of application		 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Save the Encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Encounter saved and logged out successfully");

			//--------------------------------------------------------------------//
			//  Step-7:Edit the Vitals again from Pending Encounter						 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Viatls in encounter : A -> B");
			patientChartPage.gotoPendingEncounters(driver);
			vitalsPage=patientChartPage.goToEncounterVitals(driver, encounterPage);
			ChartPreVisitLib vitalsData2 = new ChartPreVisitLib();
		    vitalsData2.workSheetName = "CreateVitals";
		    vitalsData2.testCaseId = "TC_ECV_002";
		    vitalsData2.fetchChartPreVisitTestData();

			patientChartPage.addEncounterVitals(driver,encounterPage,vitalsPage,vitalsData2);
			logTitleMessage("Vitals edit in encounter successful");
			
			//--------------------------------------------------------------------//
			//  Step-9:Cancel the Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-10:Verify Vitals in Summary							  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Vitals in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyVitalsInSummary(driver, vitalsData);
			logTitleMessage("Verification successful");
			
		}
		catch(RuntimeException e)
			{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
			}
		
		return true;
	}

}
