package com.projectname.test.functional.demographics.patientcreation;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.Constants;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;


public class CreateNewPatient extends TestBaseClass {
	PatientRegistationPage patientRegPage;
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for verify DNC feature")
	@Parameters({ "userAccount" })
	public void createPatient(String userAccount)
			throws Exception {
		className = this.getClass().getName().substring(39);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "PatientData";
		patientData.testCaseId = "TC_NPC_001";
		patientData.fetchHomeTestData();
		CreatePatientWithAllDetails(patientData, userAccount);
	}

	/**
	 * Create New patient function to add a new patient
	 * 
	 * @param patientData
	 * @param browser
	 * @param webSite
	 * @throws Exception
	 * @since Nov 24, 2012
	 */

	public boolean CreatePatientWithAllDetails(HomeLib patientData,
			String userAccount) throws Exception {
		boolean returnValue = true;
		try {
			// --------------------------------------------------------------------//
			// Step-1: Login to the application and search for the given patient
			// //
			// --------------------------------------------------------------------//
			LoginPage loginPage = new LoginPage();
			homePage = loginPage
					.loginForNexiaFromProviderSite(driver, userAccount,
							patientData.userName, patientData.userPassword);
			// --------------------------------------------------------------------//
			// Step-2: Create a patient with full details //
			// --------------------------------------------------------------------//
			SharedPage sharedPage = homePage.navigateToSharedPage();
			patientRegPage = sharedPage.goToPatientRegPage(driver);
			patientRegPage.createPatient(driver, patientData,
					Constants.userAccount);

		} catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,
					"Failed Due to the Exception; \n\t*) ExceptionDetails :"
							+ e.getMessage() + "\n\t*)", driver, className,
					methodName);
		}
		return returnValue;
	}
}
