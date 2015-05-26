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

public class VerifyCancelEncounterSixForImmunization extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private ImmunizationPage immunizationPage=null;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify cancel Encounter For Immunization: 10")
	@Parameters({"userAccount","webSite","browser"})

	public void verifyCancelEncounterSixForImmunization(String userAccount,String webSite,String browser) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib immData = new ChartPreVisitLib();
		immData.workSheetName = "CreateImmunization";
		immData.testCaseId = "TC_CIM_077";
		immData.fetchChartPreVisitTestData();
		verifyCancel(userAccount, immData);
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

		
	private boolean verifyCancel(String userAccount,ChartPreVisitLib immData) throws Exception {
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
			logTitleMessage("Create Encounter Immunization");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			immunizationPage=patientChartPage.goToEncounterImmunization(driver, encounterPage);
		    patientChartPage.createImmunization(driver,immData,userAccount,immunizationPage);
		    patientChartPage.addImmunization(driver, immunizationPage);
			logTitleMessage("Encounter Immunization creation successful");
			
			//--------------------------------------------------------------------//
			//  Step-6:Save the Encounter and Log out of application		 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Save the Encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Encounter saved and logged out successfully");

			//--------------------------------------------------------------------//
			//  Step-7:Edit Immunization from Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Immunization from Summary A -> B");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.goToSummaryImmunization(driver);
			patientChartPage.clickEditImmnization(driver, immunizationPage);
			ChartPreVisitLib immData2 = new ChartPreVisitLib();
			immData2.workSheetName = "CreateImmunization";
			immData2.testCaseId = "TC_CIM_078";
			immData2.fetchChartPreVisitTestData();

		    patientChartPage.createImmunization(driver,immData2,userAccount,immunizationPage);
		    patientChartPage.saveImmunizationEdit(driver, immunizationPage);
		    patientChartPage.saveImmunization(driver, immunizationPage);
			logTitleMessage("Immunization edit successful");

			//--------------------------------------------------------------------//
			//  Step-8:Edit the Immunization again	from Pending Encounter						 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Immunization in encounter : B -> C");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEncounterImmunization(driver, encounterPage);
			patientChartPage.clickEditImmnization(driver, immunizationPage);
			ChartPreVisitLib immData3 = new ChartPreVisitLib();
			immData3.workSheetName = "CreateImmunization";
			immData3.testCaseId = "TC_CIM_079";
			immData3.fetchChartPreVisitTestData();

		    patientChartPage.createImmunization(driver,immData3,userAccount,immunizationPage);
		    patientChartPage.saveImmunizationEdit(driver, immunizationPage);
			logTitleMessage("Immunization edit in encounter successful");
			
			//--------------------------------------------------------------------//
			//  Step-9:Cancel the Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-10:Verify Immunization in Summary							  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Immunization in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyImmunizationsInSummary(driver, immData2, userAccount);
			logTitleMessage("Verification successful");
			
		}
		catch(RuntimeException e)
			{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
			}
		
		return true;
	}

}
