package com.projectname.test.functional.chartprevisist.encounterendtoend.verifycancel;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.AllergyPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyCancelEncounterFourForAllergy extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private AllergyPage allergyPage=null;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify cancel Encounter For Allergy: 6")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterFourForAllergy(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CAE_002";
		allergyData.fetchChartPreVisitTestData();
		verifyCancel(userAccount, allergyData, webSite, browser, seleniumHost, seleniumPort);
	}	
		/**
		 * verify Cancel Encounter
		 * function to verify Cancel Encounter
		 * @param allergyData 
		 * @param 		patientData
		 * @param 		browser
		 * @param 		webSite
		 * @throws      Exception 
		 * @since  	    May 21, 2015
		 */

		
	private boolean verifyCancel(String userAccount,ChartPreVisitLib allergyData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, allergyData.userName, allergyData.userPassword);
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
			//  Step-5:Add Summary Allergy							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Add Summary Allergy");
			patientChartPage.clickSummaryTab(driver);
			allergyPage=patientChartPage.nvigatetoSummaryallergy(driver);
		    patientChartPage.createSummaryAllergyEndToEnd(driver, allergyData, userAccount, allergyPage);
		    patientChartPage.addAllergy(driver, allergyPage);
		    patientChartPage.saveAllergy(driver, allergyPage);
			logTitleMessage("Summary Allergy added successfully");

			//--------------------------------------------------------------------//
			//  Step-6:Begin an Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Allergy in encounter A -> B");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			patientChartPage.goToEncounterAllergy(driver, encounterPage);
			patientChartPage.clickEditAllergy(allergyPage);
			ChartPreVisitLib allergyData2 = new ChartPreVisitLib();
			allergyData2.workSheetName = "CreateAllergy";
			allergyData2.testCaseId = "TC_CAE_003";
			allergyData2.fetchChartPreVisitTestData();

		    patientChartPage.createEncounterAllergyEndToEnd(driver,allergyData2,userAccount,allergyPage, encounterPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
			logTitleMessage("Allergy edit in encounter successful");
			
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
			ChartPreVisitLib allergyData3 = new ChartPreVisitLib();
			allergyData3.workSheetName = "CreateAllergy";
			allergyData3.testCaseId = "TC_CAE_004";
			allergyData3.fetchChartPreVisitTestData();

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, allergyData3.userName, allergyData3.userPassword);
			logTitleMessage("Login successful");
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, allergyData3.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");

			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit Allergy from Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Allergy from Summary B -> C");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.nvigatetoSummaryallergy(driver);
			patientChartPage.clickEditAllergy(allergyPage);

		    patientChartPage.createSummaryAllergyEndToEnd(driver, allergyData3, userAccount, allergyPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
		    patientChartPage.saveAllergy(driver, allergyPage);
			logTitleMessage("Allergy edit successful");

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
			ChartPreVisitLib allergyData4 = new ChartPreVisitLib();
			allergyData4.workSheetName = "CreateAllergy";
			allergyData4.testCaseId = "TC_CAE_005";
			allergyData4.fetchChartPreVisitTestData();

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, allergyData4.userName, allergyData4.userPassword);
			logTitleMessage("Login successful");
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-10:Edit the Allergy again	from Pending Encounter						 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Allergy in encounter : C -> D");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEncounterAllergy(driver, encounterPage);
			patientChartPage.clickEditAllergy(allergyPage);

		    patientChartPage.createEncounterAllergyEndToEnd(driver,allergyData4,userAccount,allergyPage, encounterPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
			logTitleMessage("Allergy edit in encounter successful");

			//--------------------------------------------------------------------//
			//  Step-11:Cancel the Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-12:Verify Allergy in Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Allergy in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyAllergyandMedicationinSummary(driver, allergyData3, userAccount);
			logTitleMessage("Verification successful");

		}
		catch(RuntimeException e)
			{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
			}
		
		return true;
	}
}
