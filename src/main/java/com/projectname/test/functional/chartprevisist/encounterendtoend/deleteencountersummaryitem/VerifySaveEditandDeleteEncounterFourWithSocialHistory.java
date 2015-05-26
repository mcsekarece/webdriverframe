package com.projectname.test.functional.chartprevisist.encounterendtoend.deleteencountersummaryitem;

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
import com.projectname.testutils.pages.SocialHistoryPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifySaveEditandDeleteEncounterFourWithSocialHistory extends TestBaseClass {

	private HomePage homePage;
	private SharedPage sharedPage;
	private PatientRegistationPage patientRegistationPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private SocialHistoryPage socialHistoryPage;
	

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Save Edit and Delete Encounter With Social History")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifySaveEditandDeleteEncounterFour(String userAccount,String website,String browser,String seleniumHost,String seleniumPort)throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ChartPreVisitLib socialHisData = new ChartPreVisitLib();
	 socialHisData.workSheetName = "CreateSocialHistory";
	 socialHisData.testCaseId = "TC_ESH_001";
	 socialHisData.fetchChartPreVisitTestData(); 
	 verifySaveEditandDeleteEncounter(socialHisData,userAccount);
}

	/**
     * VerifySaveEditandDeleteEncounterFour
     * To Verify Save Edit and Delete Encounter With Social History for scenario four
     * @param socialHisData(Social History details to be added)
     * @param userAccount(Application Environment)
     * @since  Mar 21, 2015
     */

	public boolean verifySaveEditandDeleteEncounter(ChartPreVisitLib socialHisData, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,socialHisData.userName, socialHisData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to Full Access                            // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
	    	sharedPage.switchRole(driver, socialHisData.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			//--------------------------------------------------------------------//
			//  Step-3: Create a new patient 	 								 //
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
		    patientChartPage=sharedPage.searchPatientForTestingtester(driver,patientData.lastName);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Social History  page						  //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to Social History page");
			socialHistoryPage = patientChartPage.goToSocialHistory(driver);
			logTitleMessage("Sucessfully navigated to Social History page");
			
			//--------------------------------------------------------------------//
			//  Step-6: Social History in summary page 					          //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Add Social History List in summary page");
	        patientChartPage.createSocialHistoryEndToEnd(driver,socialHisData,userAccount,socialHistoryPage);
	    	patientChartPage.saveSummarySocialHistory(driver, socialHistoryPage);
			logTitleMessage("Sucessfully Added Socail History in summary page");
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Begin encounter page 						  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Begin encounter page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated into Begin encounter page");
						
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Edit Social History in encounter page	      // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Edit Social History in encounter page");
		
			patientChartPage.goToEncounterSocialHistory(driver,encounterPage);

			patientChartPage.clickEditEncounterSocialHistory(driver,socialHistoryPage);
			
			logTitleMessage("Sucessfully Navigated to Edit Social History in encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-9:  Edit the Social History in encounter page	     	      // 
			//--------------------------------------------------------------------//		
			
			ChartPreVisitLib socialHisData1 = new ChartPreVisitLib();
			socialHisData1.workSheetName = "CreateSocialHistory";
			socialHisData1.testCaseId = "TC_ESH_002";
			socialHisData1.fetchChartPreVisitTestData(); 
			
			logTitleMessage("Edit the Social History in encounter page A --> B");
			patientChartPage.createEncounterSocialHistoryEndToEnd(driver, socialHisData1, userAccount,socialHistoryPage,encounterPage);
			patientChartPage.clickSaveEditSocialHistory(driver, socialHistoryPage);
			logTitleMessage("Sucessfully Edited the Social History in encounter page A --> B");
			
			//--------------------------------------------------------------------//
			//  Step-10:   Save the Encounter A      							  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Save the encounter A ");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter A ");
			
			//--------------------------------------------------------------------//
			//  Step-11: Navigate to Social History Summary  page    			  //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to Social History page");
			patientChartPage.clickSummaryTab(driver);
			socialHistoryPage = patientChartPage.goToSocialHistory(driver);
			logTitleMessage("Sucessfully navigated to Social History page");
			
			//--------------------------------------------------------------------//
			//  Step-12:  Edit the Social History in summary page B -- > C 	      // 
			//--------------------------------------------------------------------//		
			
			ChartPreVisitLib socialHisData2 = new ChartPreVisitLib();
			socialHisData2.workSheetName = "CreateSocialHistory";
			socialHisData2.testCaseId = "TC_ESH_003";
			socialHisData2.fetchChartPreVisitTestData(); 
			
			logTitleMessage("Edit the Social History in summary page B --> C");
			
			patientChartPage.clickEditEncounterSocialHistory(driver,socialHistoryPage);
		    
			patientChartPage.createSocialHistoryEndToEnd(driver,socialHisData2,userAccount,socialHistoryPage);
			
		    patientChartPage.clickSaveEditSocialHistory(driver, socialHistoryPage);
			patientChartPage.clickSaveSummaryEditSocialHistory(driver, socialHistoryPage);
			
			logTitleMessage("Sucessfully Edited the Social History in summary page B --> C");
		
			
			//--------------------------------------------------------------------//
			//  Step-13:   Navigate to saved Encounter 	 A  					  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to saved Encounter A");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.clickSavedEncounter(driver);
			logTitleMessage("Sucessfully navigated into the saved encounter A");
			
			
			//----------------------------------------------------------------------------//
			//  Step-14:  Edit the Social History in encounter page and save encounter B // 
			//---------------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Edit Social History in encounter page");
		
			patientChartPage.goToEncounterSocialHistory(driver,encounterPage);
			patientChartPage.clickEditEncounterSocialHistory(driver,socialHistoryPage);
			
			logTitleMessage("Sucessfully Navigated to Edit Social History  in encounter page");
			
			ChartPreVisitLib socialHisData3 = new ChartPreVisitLib();
			socialHisData3.workSheetName = "CreateSocialHistory";
			socialHisData3.testCaseId = "TC_ESH_004";
			socialHisData3.fetchChartPreVisitTestData(); 

			logTitleMessage("Edit the Social History in encounter page C --> D");
			patientChartPage.createEncounterSocialHistoryEndToEnd(driver, socialHisData3, userAccount,socialHistoryPage,encounterPage);
			patientChartPage.clickSaveEditSocialHistory(driver, socialHistoryPage);
			logTitleMessage("Sucessfully Edited the Social History in encounter page C --> D");
			
			logTitleMessage("Save the encounter B");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter B");
		
			//--------------------------------------------------------------------//
			//  Step-15:   Delete the Encounter 	  							  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Delete the encounter");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.deleteAllEncounters(driver);
			logTitleMessage("Sucessfully deleted the encounter");
			
			//--------------------------------------------------------------------//
			//  Step-16:Verify Social History in Summary						  //
			//--------------------------------------------------------------------//		
		
			logTitleMessage("Verify Social History C in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifySocialHistoryInSummary(driver,socialHisData,socialHisData2,userAccount);
			logTitleMessage("Successfully verified the Social History C in Summary");
			
			
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
}
