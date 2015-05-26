package com.projectname.test.functional.chartprevisist.encounterendtoend.deleteencountersummaryitem;

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
import com.projectname.testutils.pages.SocialHistoryPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

public class VerifySaveEditandDeleteEncounterFourWithInjections extends TestBaseClass {

	private HomePage homePage;
	private SharedPage sharedPage;
	private PatientRegistationPage patientRegistationPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private SocialHistoryPage socialHistoryPage;
	private InjectionPage injectionPage;
	

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Save Edit and Delete Encounter With Injections")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifySaveEditandDeleteEncounterFour(String userAccount,String website,String browser,String seleniumHost,String seleniumPort)throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ChartPreVisitLib injectionData = new ChartPreVisitLib();
	 injectionData.workSheetName = "CreateInjection";
	 injectionData.testCaseId = "TC_CI_058";
	 injectionData.fetchChartPreVisitTestData();
	 verifySaveEditandDeleteEncounter(injectionData,userAccount);
}

	/**
     * VerifySaveEditandDeleteEncounterFour
     * To Verify Save Edit and Delete Encounter With Injections for scenario four
     * @param socialHisData(Injections details to be added)
     * @param userAccount(Application Environment)
     * @since  Mar 21, 2015
     */

	public boolean verifySaveEditandDeleteEncounter(ChartPreVisitLib injectionData, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,injectionData.userName, injectionData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to Full Access                            // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
	    	sharedPage.switchRole(driver, injectionData.switchRole);
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
			//  Step-5: Navigate to Injections  page						  //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to Injections page");
			injectionPage = patientChartPage.goToInjection(driver);
			logTitleMessage("Sucessfully navigated to Injections page");
			
			//--------------------------------------------------------------------//
			//  Step-6: Injections in summary page 					              //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Add Injections List in summary page");
			patientChartPage.createInjectionEndToEnd(driver, injectionData, userAccount, injectionPage);
			patientChartPage.saveSummaryInjection(driver, injectionPage);
			logTitleMessage("Sucessfully Added Socail History in summary page");
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Begin encounter page 						  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Begin encounter page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated into Begin encounter page");
						
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Edit Injections in encounter page	      // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Edit Injections in encounter page");
		
			injectionPage=patientChartPage.goToEncounterInjection(driver, encounterPage);
			patientChartPage.clickEditInjection(driver, injectionPage);
			
			logTitleMessage("Sucessfully Navigated to Edit Injections in encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-9:  Edit the Injections in encounter page	     	      // 
			//--------------------------------------------------------------------//		
			
			ChartPreVisitLib injectionData1 = new ChartPreVisitLib();
			injectionData1.workSheetName = "CreateInjection";
			injectionData1.testCaseId = "TC_CI_059";
			injectionData1.fetchChartPreVisitTestData();
			
			logTitleMessage("Edit the Injections in encounter page A --> B");
		    patientChartPage.createEncounterInjectionEndToEnd(driver, injectionData1, userAccount, injectionPage, encounterPage);
		    patientChartPage.clickSaveEditInjection(driver, injectionPage);
			logTitleMessage("Sucessfully Edited the Injections in encounter page A --> B");
			
			//--------------------------------------------------------------------//
			//  Step-10:   Save the Encounter A      							  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Save the encounter A ");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter A ");
			
			//--------------------------------------------------------------------//
			//  Step-11: Navigate to Injections Summary  page    			      //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to Injections page");
			patientChartPage.clickSummaryTab(driver);
			injectionPage = patientChartPage.goToInjection(driver);
			logTitleMessage("Sucessfully navigated to Injections page");
			
			//--------------------------------------------------------------------//
			//  Step-12:  Edit the Injections in summary page B -- > C 	          // 
			//--------------------------------------------------------------------//		
			
			ChartPreVisitLib injectionData2 = new ChartPreVisitLib();
			injectionData2.workSheetName = "CreateInjection";
			injectionData2.testCaseId = "TC_CI_060";
			injectionData2.fetchChartPreVisitTestData();
			
			logTitleMessage("Edit the Injections in summary page B --> C");
			
			patientChartPage.clickEditInjection(driver, injectionPage);

		    patientChartPage.createInjectionEndToEnd(driver, injectionData2, userAccount, injectionPage);
		    
		    patientChartPage.clickSaveEditInjection(driver, injectionPage);
		    
		    patientChartPage.clickSaveInjection(driver, injectionPage);
			
		    logTitleMessage("Sucessfully Edited the Injections in summary page B --> C");
		
			
			//--------------------------------------------------------------------//
			//  Step-13:   Navigate to saved Encounter 	 A  					  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to saved Encounter A");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.clickSavedEncounter(driver);
			logTitleMessage("Sucessfully navigated into the saved encounter A");
			
			
			//----------------------------------------------------------------------------//
			//  Step-14:  Edit the Injections in encounter page and save encounter B // 
			//---------------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Edit Injections in encounter page");
		
			injectionPage=patientChartPage.goToEncounterInjection(driver, encounterPage);
			patientChartPage.clickEditInjection(driver, injectionPage);
			
			logTitleMessage("Sucessfully Navigated to Edit Injections  in encounter page");
			
			
			ChartPreVisitLib injectionData3 = new ChartPreVisitLib();
			injectionData3.workSheetName = "CreateInjection";
			injectionData3.testCaseId = "TC_CI_061";
			injectionData3.fetchChartPreVisitTestData();

			logTitleMessage("Edit the Injections in encounter page C --> D");
			patientChartPage.createEncounterInjectionEndToEnd(driver, injectionData3, userAccount, injectionPage, encounterPage);
			patientChartPage.clickSaveEditInjection(driver, injectionPage);
			logTitleMessage("Sucessfully Edited the Injections in encounter page C --> D");
			
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
			//  Step-16:Verify Injections in Summary						      //
			//--------------------------------------------------------------------//		
		
			logTitleMessage("Verify Injections C in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verifyInjectionInSummary(driver, injectionData2, userAccount);
			logTitleMessage("Successfully verified the Injections C in Summary");
			
			
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
}


