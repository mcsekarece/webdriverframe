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
import com.projectname.testutils.pages.ImmunizationPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyCancelEncounterFourForImmunization extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private ImmunizationPage immunizationPage=null;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify cancel Encounter For Immunization: 6")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelFourForImmunization(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib immData = new ChartPreVisitLib();
		immData.workSheetName = "CreateImmunization";
		immData.testCaseId = "TC_CIM_077";
		immData.fetchChartPreVisitTestData();
		verifyCancel(userAccount, immData, webSite, browser, seleniumHost, seleniumPort);
	}	
		/**
		 * verify Cancel Encounter
		 * function to verify Cancel Encounter
		 * @param immData 
		 * @param 		patientData
		 * @param 		browser
		 * @param 		webSite
		 * @throws      Exception 
		 * @since  	    May 21, 2015
		 */

		
	private boolean verifyCancel(String userAccount,ChartPreVisitLib immData, String webSite, String browser, String seleniumHost, String seleniumPort) throws Exception {
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, immData.userName, immData.userPassword);
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
			//  Step-5:Add Summary Immunization							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Add Summary Immunization");
			patientChartPage.clickSummaryTab(driver);
			immunizationPage=patientChartPage.goToSummaryImmunization(driver);
		    patientChartPage.createImmunization(driver,immData,userAccount,immunizationPage);
		    patientChartPage.addImmunization(driver, immunizationPage);
		    patientChartPage.saveImmunization(driver, immunizationPage);
			logTitleMessage("Summary Immunization added successfully");

			//--------------------------------------------------------------------//
			//  Step-6:Begin an Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Immunization in encounter A -> B");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			patientChartPage.goToEncounterImmunization(driver, encounterPage);
			patientChartPage.clickEditImmnization(driver, immunizationPage);
			ChartPreVisitLib immData2 = new ChartPreVisitLib();
			immData2.workSheetName = "CreateImmunization";
			immData2.testCaseId = "TC_CIM_078";
			immData2.fetchChartPreVisitTestData();

		    patientChartPage.createImmunization(driver,immData2,userAccount,immunizationPage);
		    patientChartPage.saveImmunizationEdit(driver, immunizationPage);
			logTitleMessage("Immunization edit in encounter successful");
			
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
			ChartPreVisitLib immData3 = new ChartPreVisitLib();
			immData3.workSheetName = "CreateImmunization";
			immData3.testCaseId = "TC_CIM_079";
			immData3.fetchChartPreVisitTestData();

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, immData3.userName, immData3.userPassword);
			logTitleMessage("Login successful");
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, immData3.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");

			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit Immunization from Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Immunization from Summary B -> C");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.goToSummaryImmunization(driver);
			patientChartPage.clickEditImmnization(driver, immunizationPage);

		    patientChartPage.createImmunization(driver,immData3,userAccount,immunizationPage);
		    patientChartPage.saveImmunizationEdit(driver, immunizationPage);
		    patientChartPage.saveImmunization(driver, immunizationPage);
			logTitleMessage("Immunization edit successful");

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
			ChartPreVisitLib immData4 = new ChartPreVisitLib();
			immData4.workSheetName = "CreateImmunization";
			immData4.testCaseId = "TC_CIM_080";
			immData4.fetchChartPreVisitTestData();

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, immData4.userName, immData4.userPassword);
			logTitleMessage("Login successful");
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-10:Edit the Immunization again	from Pending Encounter						 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Immunization in encounter : C -> D");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEncounterImmunization(driver, encounterPage);
			patientChartPage.clickEditImmnization(driver, immunizationPage);

		    patientChartPage.createImmunization(driver,immData4,userAccount,immunizationPage);
		    patientChartPage.saveImmunizationEdit(driver, immunizationPage);
			logTitleMessage("Immunization edit in encounter successful");

			//--------------------------------------------------------------------//
			//  Step-11:Cancel the Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-12:Verify Immunization in Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Immunization in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyImmunizationsInSummary(driver, immData3, userAccount);
			logTitleMessage("Verification successful");

		}
		catch(RuntimeException e)
			{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
			}
	
		
		return true;
	}

}
