package com.projectname.test.functional.chartprevisist.encounterendtoend.verifycancel;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.FamilyHistoryPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyCancelEncounterTwoForFamilyHistory extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private FamilyHistoryPage familyHistoryPage=null;


	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test to verify cancel Encounter Family History: 4")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterTwoForFamilyHistory(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib familyHistoryData = new ChartPreVisitLib();
		familyHistoryData.workSheetName = "CreateFamilyHistory";
		familyHistoryData.testCaseId = "TC_CFM_030";
		familyHistoryData.fetchChartPreVisitTestData();
		verifyCancel(userAccount, familyHistoryData);
	}	
		/**
		 * verify Cancel Encounter
		 * function to verify Cancel Encounter
		 * @param 		familyHistoryData 
		 * @param 		patientData
		 * @param 		browser
		 * @param 		webSite
		 * @throws      Exception 
		 * @since  	    Mar 25, 2015
		 */

	
	private boolean verifyCancel(String userAccount,ChartPreVisitLib familyHistoryData) throws Exception {
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, familyHistoryData.userName, familyHistoryData.userPassword);
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
			//  Step-5:Add Summary Family History								 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Add Summary Family History");
			patientChartPage.clickSummaryTab(driver);
			familyHistoryPage=patientChartPage.navigateToFamilyHistory(driver);
		    patientChartPage.createSummaryFamilyHistory(driver, familyHistoryData, familyHistoryPage);
		    patientChartPage.addFamilyHistory(driver, familyHistoryPage);
		    patientChartPage.saveAddedFamilyHistory(driver, familyHistoryPage);
			logTitleMessage("Summary Family History added successfully");

			//--------------------------------------------------------------------//
			//  Step-6:Begin an Encounter							 	  		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Family History in encounter A -> B");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			patientChartPage.goToEncounterFamilyHistory(driver, encounterPage);
			patientChartPage.clickEditFamilyHistory(familyHistoryPage);
			ChartPreVisitLib familyHistoryData2 = new ChartPreVisitLib();
			familyHistoryData2.workSheetName = "CreateFamilyHistory";
			familyHistoryData2.testCaseId = "TC_CFM_031";
			familyHistoryData2.fetchChartPreVisitTestData();

		    patientChartPage.createEncounterFamilyHistory(driver, familyHistoryData2, familyHistoryPage, encounterPage);
		    patientChartPage.clickSaveEditFamilyHistory(driver, familyHistoryPage);
			logTitleMessage("Family History edit in encounter successful");
			
			//--------------------------------------------------------------------//
			//  Step-7:Save the Encounter							 	  		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Save the Encounter");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Encounter saved successfully");

			//--------------------------------------------------------------------//
			//  Step-8:Edit Family History from Summary							  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Family History from Summary B -> C");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.navigateToFamilyHistory(driver);
			patientChartPage.clickEditFamilyHistory(familyHistoryPage);
			ChartPreVisitLib familyHistoryData3 = new ChartPreVisitLib();
			familyHistoryData3.workSheetName = "CreateFamilyHistory";
			familyHistoryData3.testCaseId = "TC_CFM_032";
			familyHistoryData3.fetchChartPreVisitTestData();

		    patientChartPage.createSummaryFamilyHistory(driver, familyHistoryData3, familyHistoryPage);
		    patientChartPage.clickSaveEditFamilyHistory(driver, familyHistoryPage);
		    patientChartPage.saveAddedFamilyHistory(driver, familyHistoryPage);
			logTitleMessage("Family History edit successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit the Family History again from Pending Encounter		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Family History in encounter : C -> D");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEncounterFamilyHistory(driver, encounterPage);
			patientChartPage.clickEditFamilyHistory(familyHistoryPage);
			ChartPreVisitLib familyHistoryData4 = new ChartPreVisitLib();
			familyHistoryData4.workSheetName = "CreateFamilyHistory";
			familyHistoryData4.testCaseId = "TC_CFM_033";
			familyHistoryData4.fetchChartPreVisitTestData();

		    patientChartPage.createEncounterFamilyHistory(driver, familyHistoryData4, familyHistoryPage, encounterPage);
		    patientChartPage.clickSaveEditFamilyHistory(driver, familyHistoryPage);
			logTitleMessage("Family History edit in encounter successful");

			//--------------------------------------------------------------------//
			//  Step-10:Cancel the Encounter							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-12:Verify Family History in Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Family History in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verfiyFamilyHistoryInSummary(driver, familyHistoryData3);
			logTitleMessage("Verification successful");

		}
		catch(RuntimeException e)
			{
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
			}
		
		return true;
	}
}
