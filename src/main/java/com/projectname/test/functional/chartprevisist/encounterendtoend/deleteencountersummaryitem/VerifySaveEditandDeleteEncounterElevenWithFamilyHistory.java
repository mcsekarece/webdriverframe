package com.projectname.test.functional.chartprevisist.encounterendtoend.deleteencountersummaryitem;

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

public class VerifySaveEditandDeleteEncounterElevenWithFamilyHistory  extends TestBaseClass {

	private HomePage homePage;
	private SharedPage sharedPage;
	private PatientRegistationPage patientRegistationPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private FamilyHistoryPage familyHistoryPage;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Save Edit and Delete Encounter Eleven with Family History")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	
	public void verifySaveEditandDeleteEncounterElevenWithFamilyHistory(String userAccount,String website,String browser,String seleniumHost,String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ChartPreVisitLib familyHistoryData = new ChartPreVisitLib();
	 familyHistoryData.workSheetName = "CreateFamilyHistory";
	 familyHistoryData.testCaseId = "TC_CFM_030";
	 familyHistoryData.fetchChartPreVisitTestData();
	 verifySaveEditandDeleteEncounterElevenWithFamilyHistory(familyHistoryData,userAccount);
}

	/**
     * VerifySaveEditandDeleteEncounterEleven
     * To Verify function Save Edit and Delete Encounter Eleven with Family Hisstory
     * @param familyHistoryData(Family History  details to be added )
     * @param userAccount(Application Environment)
     * @since  May 25, 2015
     */

	public boolean verifySaveEditandDeleteEncounterElevenWithFamilyHistory(ChartPreVisitLib familyHistoryData, String userAccount) throws Exception{
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
			//  Step-5: Navigate to Begin encounter page 						  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Begin encounter page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated into Begin encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Family History in encounter page	     	  //  
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Family History in encounter page");
			familyHistoryPage = patientChartPage.goToEncounterFamilyHistory(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated to Family History in encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-7: Add Family History A in Encounter page		     	 		      // 
			//--------------------------------------------------------------------//	
	
			logTitleMessage("Add  to  Family History A in encounter page");
			patientChartPage.createEncounterFamilyHistory(driver, familyHistoryData, familyHistoryPage, encounterPage);
			patientChartPage.addFamilyHistory(driver, familyHistoryPage);
			logTitleMessage("Successfully Added the  Family History A in encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-8:   Save the Encounter A      							  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Save the encounter A ");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter A ");
			
			//--------------------------------------------------------------------//
			//  Step-9:   Login as User B	  								      // 
			//--------------------------------------------------------------------//
			
			
			 ChartPreVisitLib familyHistoryData1 = new ChartPreVisitLib();
			 familyHistoryData1.workSheetName = "CreateFamilyHistory";
			 familyHistoryData1.testCaseId = "TC_CDFM_001";
			 familyHistoryData1.fetchChartPreVisitTestData();


			logTitleMessage("Login as User B");
			sharedPage.logoutofApplication(driver);
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,familyHistoryData1.userName, familyHistoryData1.userPassword);
			logTitleMessage("Sucessfully Logged as User B");
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, familyHistoryData1.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver,patientData.lastName);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-10: Edit Family History from A --> B in Summary				      //
			//--------------------------------------------------------------------//		
			
			 logTitleMessage("Edit Family History  from Summary A -> B ");
			
			 patientChartPage.clickSummaryTab(driver);
				
			 familyHistoryPage = patientChartPage.navigateToFamilyHistory(driver);
				
			 patientChartPage.clickEditFamilyHistory(familyHistoryPage);

			 patientChartPage.createSummaryFamilyHistory(driver, familyHistoryData1, familyHistoryPage);
			    
			 patientChartPage.clickSaveEditFamilyHistory(driver, familyHistoryPage);
			    
			 patientChartPage.saveAddedFamilyHistory(driver, familyHistoryPage);
			    
			 logTitleMessage("Family History edit A --> B  successfully");
				
			
			//--------------------------------------------------------------------//
			//  Step-9:   Login as User A	  								      // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Login as User A");
			sharedPage.logoutofApplication(driver);
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,familyHistoryData.userName, familyHistoryData.userPassword);
			logTitleMessage("Sucessfully Logged as User a");
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, familyHistoryData.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver,patientData.lastName);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-10:   Navigate to saved Encounter 	 A  					  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to saved Encounter A");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.clickSavedEncounter(driver);
			logTitleMessage("Sucessfully navigated into the saved encounter A");
			
			//----------------------------------------------------------------------------//
			//  Step-11:  Edit the Family History  B --> C in encounter page      		  // 
			//---------------------------------------------------------------------------//		
			
		    logTitleMessage("Navigate to Family History  B in Encounter Page");
			
		    patientChartPage.goToEncounterFamilyHistory(driver, encounterPage);
			patientChartPage.clickEditFamilyHistory(familyHistoryPage);
					
			logTitleMessage("Sucessfully Navigated into Family History B in Encounter Page");
					
			ChartPreVisitLib familyHistoryData2 = new ChartPreVisitLib();
			familyHistoryData2.workSheetName = "CreateFamilyHistory";
			familyHistoryData2.testCaseId = "TC_CFM_032";
			familyHistoryData2.fetchChartPreVisitTestData();

					
			logTitleMessage("Edit Family History in encounter B -> C");
			patientChartPage.createEncounterFamilyHistory(driver, familyHistoryData2, familyHistoryPage, encounterPage);
			patientChartPage.clickSaveEditFamilyHistory(driver, familyHistoryPage);
			logTitleMessage("Family History edited  B --> C in encounter page successfully");
					
						
			logTitleMessage("Save the encounter B");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter B");
			
			
			//--------------------------------------------------------------------//
			//  Step-12:   Delete the Encounter 	  							  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Delete the encounter");
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.deleteAllEncounters(driver);
			logTitleMessage("Sucessfully deleted the encounter");
			
			//--------------------------------------------------------------------//
			//  Step-13:Verify Family History details B in Summary				  //
			//--------------------------------------------------------------------//		
		
			logTitleMessage("Verify Family History  details B in Summary");
			patientChartPage.clickSummaryTab(driver);
			patientChartPage.verfiyFamilyHistoryInSummary(driver,familyHistoryData1);
			logTitleMessage("Successfully verified the Family History  details B in Summary");
			
			
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
}

