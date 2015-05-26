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

public class VerifyCancelEncounterSevenForAllergy extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private AllergyPage allergyPage=null;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Cancel Encounter Allergy: 11")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterSevenForAllergy(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CAE_002";
		allergyData.fetchChartPreVisitTestData();
	 verifyAllergy(allergyData,userAccount);
}

	/**
     * verifyAllergy
     * To Verify function Cancel Encounter 
     * @param proData(Allergy details to be added)
     * @param userAccount(Application Environment)
     * @since  Mar 25, 2015
     */

	public boolean verifyAllergy(ChartPreVisitLib allergyData, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,allergyData.userName, allergyData.userPassword);
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
			logTitleMessage("Create Encounter Allergy");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			allergyPage=patientChartPage.goToEncounterAllergy(driver, encounterPage);
		    patientChartPage.createEncounterAllergyEndToEnd(driver,allergyData,userAccount,allergyPage, encounterPage);
		    patientChartPage.addAllergy(driver, allergyPage);
			logTitleMessage("Encounter Allergy creation successful");
			
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
			ChartPreVisitLib allergyData2 = new ChartPreVisitLib();
			allergyData2.workSheetName = "CreateAllergy";
			allergyData2.testCaseId = "TC_CAE_004";
			allergyData2.fetchChartPreVisitTestData();

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, allergyData2.userName, allergyData2.userPassword);
			logTitleMessage("Login successful");

			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, allergyData2.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");

			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-7:Edit Allergy from Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Allergy from Summary A -> B");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.nvigatetoSummaryallergy(driver);
			patientChartPage.clickEditAllergy(allergyPage);

		    patientChartPage.createSummaryAllergyEndToEnd(driver, allergyData2, userAccount, allergyPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
		    patientChartPage.saveAllergy(driver, allergyPage);
			logTitleMessage("Allergy edit successful");

			logTitleMessage("Log out");
			sharedPage.logoutofApplication(driver);
			logTitleMessage("Log out successful");
			
			//--------------------------------------------------------------------//
			//  Step-8:Login into application as User A							 	  //
			//--------------------------------------------------------------------//	
			logTitleMessage("Login as different user and search patient");
			ChartPreVisitLib allergyData3 = new ChartPreVisitLib();
			allergyData3.workSheetName = "CreateAllergy";
			allergyData3.testCaseId = "TC_CAE_005";
			allergyData3.fetchChartPreVisitTestData();

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, allergyData3.userName, allergyData3.userPassword);
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Login and search patient successful");

			//--------------------------------------------------------------------//
			//  Step-8:Edit the Allergy again from Pending Encounter						 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Allergy in encounter : B -> C");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEncounterAllergy(driver, encounterPage);
			patientChartPage.clickEditAllergy(allergyPage);

		    patientChartPage.createEncounterAllergyEndToEnd(driver,allergyData3,userAccount,allergyPage, encounterPage);
		    patientChartPage.clickSaveEditAllergy(driver, allergyPage);
			logTitleMessage("Allergy edit in encounter successful");
		    
			//--------------------------------------------------------------------//
			//  Step-10:Cancel the Encounter							 	      //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-10:Verify Allergy in Summary							  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Allergy in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyAllergyandMedicationinSummary(driver, allergyData2, userAccount);
			logTitleMessage("Verification successful");
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
		}
	return returnValue;
}
}
