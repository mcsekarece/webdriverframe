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

public class VerifyCancelEncounterSevenForFamilyHistory extends TestBaseClass{

	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private FamilyHistoryPage familyHistoryPage=null;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Cancel Encounter Family History: 11")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyCancelEncounterSevenForFamilyHistory(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib familyHistoryData = new ChartPreVisitLib();
		familyHistoryData.workSheetName = "CreateFamilyHistory";
		familyHistoryData.testCaseId = "TC_CFM_030";
		familyHistoryData.fetchChartPreVisitTestData();
	 verifyfamilyHistory(familyHistoryData,userAccount);
}

	/**
     * verifyfamilyHistory
     * To Verify function Cancel Encounter 
     * @param familyHistoryData(Family History details to be added)
     * @param userAccount(Application Environment)
     * @since  Mar 25, 2015
     */

	public boolean verifyfamilyHistory(ChartPreVisitLib familyHistoryData, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,familyHistoryData.userName, familyHistoryData.userPassword);
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
			logTitleMessage("Create Encounter Family History");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			familyHistoryPage=patientChartPage.navigateToFamilyHistory(driver);
		    patientChartPage.createEncounterFamilyHistory(driver, familyHistoryData, familyHistoryPage, encounterPage);
		    patientChartPage.addFamilyHistory(driver, familyHistoryPage);
			logTitleMessage("Encounter Family History creation successful");
			
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
			ChartPreVisitLib familyHistoryData2 = new ChartPreVisitLib();
			familyHistoryData2.workSheetName = "CreateFamilyHistory";
			familyHistoryData2.testCaseId = "TC_CFM_032";
			familyHistoryData2.fetchChartPreVisitTestData();

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, familyHistoryData2.userName, familyHistoryData2.userPassword);
			logTitleMessage("Login successful");

			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, familyHistoryData2.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");

			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-7:Edit Family History from Summary							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Family History from Summary A -> B");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.navigateToFamilyHistory(driver);
			patientChartPage.clickEditFamilyHistory(familyHistoryPage);

		    patientChartPage.createSummaryFamilyHistory(driver, familyHistoryData2, familyHistoryPage);
		    patientChartPage.clickSaveEditFamilyHistory(driver, familyHistoryPage);
		    patientChartPage.saveAddedFamilyHistory(driver, familyHistoryPage);
			logTitleMessage("Family History edit successful");

			logTitleMessage("Log out");
			sharedPage.logoutofApplication(driver);
			logTitleMessage("Log out successful");
			
			//--------------------------------------------------------------------//
			//  Step-8:Login into application as User A							 	  //
			//--------------------------------------------------------------------//	
			logTitleMessage("Login as different user and search patient");
			ChartPreVisitLib familyHistoryData3 = new ChartPreVisitLib();
			familyHistoryData3.workSheetName = "CreateFamilyHistory";
			familyHistoryData3.testCaseId = "TC_CFM_033";
			familyHistoryData3.fetchChartPreVisitTestData();

			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, familyHistoryData3.userName, familyHistoryData3.userPassword);
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Login and search patient successful");

			//--------------------------------------------------------------------//
			//  Step-9:Edit the Family History again from Pending Encounter		  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Edit Family History in encounter : B -> C");
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.goToEncounterFamilyHistory(driver, encounterPage);
			patientChartPage.clickEditFamilyHistory(familyHistoryPage);

		    patientChartPage.createEncounterFamilyHistory(driver, familyHistoryData3, familyHistoryPage, encounterPage);
		    patientChartPage.clickSaveEditFamilyHistory(driver, familyHistoryPage);
			logTitleMessage("Family History edit in encounter successful");
		    
			//--------------------------------------------------------------------//
			//  Step-11:Cancel the Encounter							 	      //
			//--------------------------------------------------------------------//		
			logTitleMessage("Cancel the Encounter");
			patientChartPage.cancelEncounter(encounterPage);
			logTitleMessage("Encounter cancelled");

			//--------------------------------------------------------------------//
			//  Step-10:Verify Family History in Summary							  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Verify Family History in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verfiyFamilyHistoryInSummary(driver, familyHistoryData2);
			logTitleMessage("Verification successful");
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );	
		}
	return returnValue;
}

}
