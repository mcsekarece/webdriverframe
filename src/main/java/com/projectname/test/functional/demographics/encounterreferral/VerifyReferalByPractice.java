package com.projectname.test.functional.demographics.encounterreferral;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.DemographicsPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.ReferralLetterPage;
import com.projectname.testutils.pages.ReferralsPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class VerifyReferalByPractice extends TestBaseClass{

	private HomePage homePage;
	private SharedPage sharedPage;
	private PatientRegistationPage patientRegistationPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private DemographicsPage demographicsPage;
	private ReferralLetterPage referralLetterPage;
	private ReferralsPage referralsPage ;
	
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Referral By Practice Option")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})

	public void verifyReferalByPractice(String userAccount,String website,String browser,String seleniumHost,String seleniumPort) throws Exception {
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib referralData = new ChartPreVisitLib();
		referralData.workSheetName = "ImplementReferrals";
		referralData.testCaseId = "TC_IRL_012";
		referralData.fetchChartPreVisitTestData();
		verifyReferalByPracticeOption(referralData,userAccount);
}
	
/**
 * verifyReferalByPracticeOption - VEL-5549
 * To Verify Referal By Practice Option
 * @param referralData,userAccount
 * @param userAccount(Application Environment)
 * @since  Mar 12, 2015
 */	
	
	public boolean verifyReferalByPracticeOption(ChartPreVisitLib referralData, String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{			
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount,referralData.userName, referralData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to Full Access                            // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, referralData.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
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
			//  Step-4: Search newly created Patient							 	  //
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Search patient");
			demographicsPage=sharedPage.searchPatientNexiaForProviderHomePage(driver, patientData.lastName);
			patientChartPage=demographicsPage.goToChart(driver);
			logTitleMessage("Search patient successful");

			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Begin encounter page 						  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Begin encounter page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounterReferral(driver, encounterPage,referralData);
			logTitleMessage("Sucessfully Navigated into Begin encounter page");
			
			//--------------------------------------------------------------------//
			//  Step-6:Add a referral  								 	          //
			//--------------------------------------------------------------------//		
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/YYYY");
			String date =dateFormat.format(cal.getTime());
			
			logTitleMessage("Add a referral");
			referralLetterPage= patientChartPage.navigateToReferralLetterPage(driver, encounterPage);
			patientChartPage.addNewReferralLetter(driver, referralData, referralLetterPage, encounterPage);
			logTitleMessage("Referral added successfully");
			
			//--------------------------------------------------------------------//
			//  Step-7:   Save  the Encounter 	  					              // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Save the encounter ");
			patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully saved the encounter ");
		
			//--------------------------------------------------------------------//
			//  Step-8:   Navigate to Patient  Registration and Referrals  Tab    // 
			//--------------------------------------------------------------------//
			
			logTitleMessage(" Navigate to Patient  Registration");
			demographicsPage=patientChartPage.goToPatientRegistration(driver);
			logTitleMessage("Sucessfully  Navigate to Patient  Registration Page");
			
			logTitleMessage("Navigate to Patient  Referrals Tab");
			referralsPage = demographicsPage.goToReferral(driver);
			logTitleMessage("Sucessfully  Navigate to Patient  Referrals Tab");
			
			//--------------------------------------------------------------------//
			//  Step-9:  Verify Referral details								  // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Verify Referral details");
	        demographicsPage.verifyReferralDetails(driver,referralsPage,referralData,date);
			logTitleMessage("Sucessfully Verified Referral details");
			
			
		
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
}
	return returnValue;
}
	
	
}
