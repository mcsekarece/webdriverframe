package com.projectname.test.functional.chartprevisist.encounterendtoend.deleteencountersummaryitem;

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

public class VerifySaveEditandDeleteEncounterFiveWithFamilyHistory extends TestBaseClass {

	private HomePage homePage;
	private SharedPage sharedPage;
	private PatientRegistationPage patientRegistationPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private FamilyHistoryPage familyHistoryPage;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Save Edit and Delete Encounter Five with Family history")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	
	public void verifySaveEditandDeleteEncounterFiveWithFamilyHistory(String userAccount,String website,String browser,String seleniumHost,String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ChartPreVisitLib familyHistoryData = new ChartPreVisitLib();
	 familyHistoryData.workSheetName = "CreateFamilyHistory";
	 familyHistoryData.testCaseId = "TC_CFM_030";
	 familyHistoryData.fetchChartPreVisitTestData();
	 verifySaveEditandDeleteEncounterFiveWithFamilyHistory(familyHistoryData,userAccount);
}

	/**
     * VerifySaveEditandDeleteEncounterFive
     * To Verify function Save Edit and Delete Encounter Five with Family History
     * @param familyHistoryData(Family History details to be added )
     * @param userAccount(Application Environment)
     * @since  May 25, 2015
     */

	public boolean verifySaveEditandDeleteEncounterFiveWithFamilyHistory(ChartPreVisitLib familyHistoryData, String userAccount) throws Exception{
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
			//  Step-2: Switch the role to Full Access                            // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, familyHistoryData.switchRole);
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
			//  Step-5: Navigate to Family History  page						  //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to Family History page");
			familyHistoryPage = patientChartPage.navigateToFamilyHistory(driver);
			logTitleMessage("Sucessfully navigated to Family History page");
			
			//--------------------------------------------------------------------//
			//  Step-6: Family History A in summary page 					      //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Add Family History List in summary page");
			patientChartPage.createSummaryFamilyHistory(driver, familyHistoryData, familyHistoryPage);
			patientChartPage.addFamilyHistory(driver, familyHistoryPage);
			patientChartPage.saveAddedFamilyHistory(driver, familyHistoryPage);
			
			logTitleMessage("Sucessfully Added Fammily History A in summary page");
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Begin encounter page 						  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Begin encounter page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated into Begin encounter page");
						
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Edit Family History in encounter page	      // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Edit Family History A in encounter page");
		
			patientChartPage.goToEncounterFamilyHistory(driver, encounterPage);
			patientChartPage.clickEditFamilyHistory(familyHistoryPage);
			
			logTitleMessage("Sucessfully Navigated to Edit Family History  A in encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-9:  Edit the Family History in encounter page	     	      // 
			//--------------------------------------------------------------------//		
			
			 ChartPreVisitLib familyHistoryData1 = new ChartPreVisitLib();
			 familyHistoryData1.workSheetName = "CreateFamilyHistory";
			 familyHistoryData1.testCaseId = "TC_CFM_031";
			 familyHistoryData1.fetchChartPreVisitTestData();
			 
			
			logTitleMessage("Edit the Family History in encounter page A --> B");
			patientChartPage.createEncounterFamilyHistory(driver, familyHistoryData1, familyHistoryPage, encounterPage);
		    patientChartPage.clickSaveEditFamilyHistory(driver, familyHistoryPage);
			logTitleMessage("Sucessfully Edited the Family History in encounter page A --> B");
			
			//--------------------------------------------------------------------//
			//  Step-10:   Save the Encounter A      							  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Save the encounter A ");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter A ");
			
			
			//--------------------------------------------------------------------//
			//  Step-11:   Login as User B	  								      // 
			//--------------------------------------------------------------------//
			

			 ChartPreVisitLib familyHistoryData2 = new ChartPreVisitLib();
			 familyHistoryData2.workSheetName = "CreateFamilyHistory";
			 familyHistoryData2.testCaseId = "TC_CFM_032";
			 familyHistoryData2.fetchChartPreVisitTestData();
			 

			logTitleMessage("Login as User B");
			sharedPage.logoutofApplication(driver);
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,familyHistoryData2.userName, familyHistoryData2.userPassword);
			logTitleMessage("Sucessfully Logged as User B");
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, familyHistoryData2.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			
			//--------------------------------------------------------------------//
			//  Step-12:  Edit the Family History in summary page B -- > C 	      // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver,patientData.lastName);
			logTitleMessage("Search patient successful");

            logTitleMessage("Edit Family History  from Summary B -> C ");
			
			patientChartPage.clickSummaryTab(driver);
			
			familyHistoryPage = patientChartPage.navigateToFamilyHistory(driver);
			
			patientChartPage.clickEditFamilyHistory(familyHistoryPage);

		    patientChartPage.createSummaryFamilyHistory(driver, familyHistoryData2, familyHistoryPage);
		    
		    patientChartPage.clickSaveEditFamilyHistory(driver, familyHistoryPage);
		    
		    patientChartPage.saveAddedFamilyHistory(driver, familyHistoryPage);
		    
			logTitleMessage("Family History edit B --> C  successfully");
			
			
			//--------------------------------------------------------------------//
			//  Step-13:   Navigate to saved Encounter 	 A  					  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to saved Encounter A");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.clickSavedEncounter(driver);
			logTitleMessage("Sucessfully navigated into the saved encounter A");
			
			//----------------------------------------------------------------------------//
			//  Step-14:  Edit the Family History in encounter page and save encounter B  // 
			//----------------------------------------------------------------------------//		
			
			
            logTitleMessage("Navigate to Family History  C in Encounter Page");
			
			patientChartPage.goToEncounterFamilyHistory(driver, encounterPage);
			patientChartPage.clickEditFamilyHistory(familyHistoryPage);
			
			logTitleMessage("Sucessfully Navigated into Family History C in Encounter Page");
			
			ChartPreVisitLib familyHistoryData3 = new ChartPreVisitLib();
			familyHistoryData3.workSheetName = "CreateFamilyHistory";
			familyHistoryData3.testCaseId = "TC_CFM_033";
			familyHistoryData3.fetchChartPreVisitTestData();

			
			logTitleMessage("Edit Family History in encounter C -> D");
			patientChartPage.createEncounterFamilyHistory(driver, familyHistoryData3, familyHistoryPage, encounterPage);
			patientChartPage.clickSaveEditFamilyHistory(driver, familyHistoryPage);
			logTitleMessage("Family History edited  C --> D in encounter page successfully");
			
				
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
			//  Step-16:Verify Family History C in Summary						  //
			//--------------------------------------------------------------------//		
		
			logTitleMessage("Verify Family History C in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verfiyFamilyHistoryInSummary(driver, familyHistoryData2);
			logTitleMessage("Successfully verified the Family History C in Summary");
			
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
	
}