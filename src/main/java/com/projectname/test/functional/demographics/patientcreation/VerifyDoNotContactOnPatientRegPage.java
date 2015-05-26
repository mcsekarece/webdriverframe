package com.projectname.test.functional.demographics.patientcreation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.Constants;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.DemographicsPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class VerifyDoNotContactOnPatientRegPage extends TestBaseClass {
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for verify DNC feature")
	@Parameters({ "userAccount", "website","browser" })
	public void verifyDoNotDisturbForPatient(String userAccount,String webSite, String browser) {
		className = this.getClass().getName().substring(39);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "PatientData";
		patientData.testCaseId = "TC_NPC_001";
		patientData.fetchHomeTestData();
		createPatientWithDoNotDisturb(patientData, userAccount);
	}
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for verify DNC feature")
	@Parameters({ "userAccount", "website","browser" })
	public void verifyCancelOption(String userAccount,String webSite, String browser) {
		className = this.getClass().getName().substring(39);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "PatientData";
		patientData.testCaseId = "TC_NPC_002";
		patientData.fetchHomeTestData();
		createPatientWithDoNotDisturb(patientData, userAccount);
	}
	/*
	* @purpose To verify the Do Not Contact functionality on different practice
	* @author AspireQA
	* @since December 24, 2014
	* @version 2.1
	*/
	public boolean createPatientWithDoNotDisturb(HomeLib patientData,
			String userAccount) {
		try {
			// --------------------------------------------------------------------//
			// Step-1: Login to the application and search for the given patient
			// //
			// --------------------------------------------------------------------//
			PatientRegistationPage patientRegPage=null;
			SharedPage sharedPage=null;
			LoginPage loginPage=null;
			DemographicsPage demographicsPage=null;
			logTitleMessage("Login to application");
			loginPage = new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,
					Constants.userAccount, patientData.userName,
					patientData.userPassword);
			logTitleMessage("Login Successful");
			// --------------------------------------------------------------------//
			// Step-2: Create a patient with Mandatory fields with DNC             //
			// --------------------------------------------------------------------//
			logTitleMessage("Navigate to patient Registration page and create a new patient with Do Not Contact");
			sharedPage = homePage.navigateToSharedPage();
		    patientRegPage = sharedPage
					.goToPatientRegPage(driver);
			patientRegPage
					.createPatientWithDNC(driver, patientData,
							Constants.userAccount);
			demographicsPage=new DemographicsPage();
			logTitleMessage("Patient created successfully with Do Not Contact");
			// -------------------------------------------------------------------//
			// Step-3 Verify DNC on patient demographics Page                     //
			// -------------------------------------------------------------------//
			logTitleMessage("Verify DNC on patient info page");
			demographicsPage.verifyDoNotDisturbStatusDemographicsPage(driver);
			logTitleMessage("DNC verified on patient info page");
			// -------------------------------------------------------------------//
			// Step-4: verify the cancel button                                   //
			// -------------------------------------------------------------------//
			if(patientData.testCaseId.equals("TC_NPC_002"))
			{
		    logTitleMessage("Verify Cancel button action in patient info page");
			demographicsPage.clickEditButtonOnPatientInfoPage(driver);
			patientRegPage.verifyCancelButtonOnPatientRegPage(driver);
			demographicsPage.verifyDoNotDisturbStatusDemographicsPage(driver);
			logTitleMessage("Cancel Button verified on patient info page");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false,
					"Failed Due to the Exception; \n\t*) ExceptionDetails :"
							+ e.getMessage() + "\n\t*)", driver, className,
					methodName);
		}
		return true;
	}
}