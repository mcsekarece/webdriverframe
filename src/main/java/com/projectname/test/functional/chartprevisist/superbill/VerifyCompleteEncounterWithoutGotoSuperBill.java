package com.projectname.test.functional.chartprevisist.superbill;

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
import com.projectname.testutils.pages.ProblemListPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.pages.VitalsPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

public class VerifyCompleteEncounterWithoutGotoSuperBill extends TestBaseClass{

	private HomePage homePage;
	private SharedPage sharedPage;
	private PatientRegistationPage patientRegistationPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private ProblemListPage problemListPage;
	private VitalsPage vitalsPage;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "To Verify user shouldn't navigate to Superbill page after sign the encounter  - VEL-7292")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	
	public void verifyCompleteEncounterWithoutGotoSuperBill(String userAccount,String website,String browser,String seleniumHost,String seleniumPort) throws Exception {
 	 className=this.getClass().getName().substring(39); 
	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib probData = new ChartPreVisitLib();
		probData.workSheetName = "CreateProblemList";
		probData.testCaseId = "TC_SPL_013";
		probData.fetchChartPreVisitTestData();
		verifyCompleteEncounterWithoutGotoSuperBill(probData,userAccount);
}

	/**
     * VerifyDonotMoveToSuperBillPage - VEL-7292
     * To Verify user shouldn't navigate to Superbill page after sign the encounter 
     * @param problemListData 
     * @param userAccount(Application Environment)
     * @since  May  18, 2015
     */

	public boolean verifyCompleteEncounterWithoutGotoSuperBill(ChartPreVisitLib probData, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{			
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, probData.userName, probData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to Biller                                 // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to BILLER Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, probData.switchRole);
			logTitleMessage("Switched the role to BILLER  Access Sucessfuly");
			
			//--------------------------------------------------------------------//
			//  Step-3: Create a new patient 	  								  //
			//--------------------------------------------------------------------//
			logTitleMessage("Create a new patient");
			sharedPage=homePage.navigateToSharedPage();
			patientRegistationPage= sharedPage.goToPatientRegPage(driver);
			HomeLib patientData = new HomeLib();	
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();	
			patientRegistationPage.createNewPatientWithMandatory(driver,patientData,userAccount);
			logTitleMessage("Patient creation successful");
			
			//--------------------------------------------------------------------//
			//  Step-4:Search newly created Patient							 	  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Search patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Search patient successful");
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Begin encounter page 						  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Begin encounter page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated into Begin encounter page");

			//--------------------------------------------------------------------//
			//  Step-6:Create new Problem List				 	  				  //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Create new Problem List");			
			patientChartPage.selectAssessment(encounterPage, probData.medicalCondition);
		    patientChartPage.createProblemList(encounterPage, probData);
			logTitleMessage("Problem List created Successfully");
			
			//--------------------------------------------------------------------//
			//  Step-7: Sign  the Encounter		  									//
			//--------------------------------------------------------------------//
			
			logTitleMessage("Sign the encounter");	
			patientChartPage.signEncounter(driver, encounterPage);
			logTitleMessage("Successfully Signed the encounter");	

			//--------------------------------------------------------------------//
			//  Step-8:  Verify  the User not navigate to super bill page   	  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Verify the User not navigate to super bill page");
			patientChartPage.clickEncounterTab(driver);				
			
			patientChartPage.verifyEncounterDetails(driver,userAccount);		
			
			patientChartPage.verifySuperBillPageNotPresent(driver,encounterPage);
			logTitleMessage("Sucessfully Verified the User not navigate to super bill page");
			
		
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}

	
	

}
