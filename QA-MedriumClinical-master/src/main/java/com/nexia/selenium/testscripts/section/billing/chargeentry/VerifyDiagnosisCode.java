package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;

import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDiagnosisCode extends AbstractBilling {

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyDiagnosisCode(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_044";
		chargeEntryData.fetchBillingTestData();
		verifyDiagnosisCode(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	public boolean verifyDiagnosisCode(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount,
			BillingLib chargeEntryData) throws IOException {
		Selenium selenium = null;
		boolean returnValue = true;

		try {

			// --------------------------------------------------------------------//
			// Step-1: Login to the application and search for the given patient
			// //
			// --------------------------------------------------------------------//

			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);

			Assert.assertNotNull(selenium,
					"Could Not Retrive the New Selenium Session; More Details :"
							+ chargeEntryData.toString());

			assertTrue(
					loginForNexiaFromProviderSite(selenium, userAccount,
							chargeEntryData.userName,
							chargeEntryData.userPassword), "Login Failed ",
					selenium, ClassName, MethodName);

			waitForPageLoad(selenium);

			assertTrue(switchRole(selenium, chargeEntryData.switchRole),
					"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			// --------------------------------------------------------------------//
			// Step-2: Go to Post New Charge
			// --------------------------------------------------------------------//
			navigateToPatient(selenium, chargeEntryData);
			goToPostNewCharge(selenium, chargeEntryData);
			assertTrue(
					selectValueFromAjaxList(selenium, lstDiagnosis00,
							chargeEntryData.diagnosisCodeSL),
					"Not able to enter Diagnosis Code", selenium, ClassName,
					MethodName);
			assertTrue(
					selenium.getText(diagnosisCodeSL).equals(chargeEntryData.diagnosisCode),
					"Diagnosis Code in Service Line is same as the Diagnosis Code above", selenium, ClassName,
					MethodName);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
