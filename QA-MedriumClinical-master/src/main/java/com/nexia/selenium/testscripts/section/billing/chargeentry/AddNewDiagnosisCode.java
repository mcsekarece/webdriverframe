package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class AddNewDiagnosisCode extends AbstractBilling {

	@Test(groups = {"AdvancedSmokeUS", "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAddNewDiagnosisCodeCheckDelete(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_002";
		chargeEntryData.fetchBillingTestData();
		verifyAddNewDiagnosisCode(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = {"RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAddNewDiagnosisCodeCheckColumns(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_003";
		chargeEntryData.fetchBillingTestData();
		verifyAddNewDiagnosisCode(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = {"RegressionUS","Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAddNewDiagnosisCodeButtonNotAvailable(
			String seleniumHost, int seleniumPort, String browser,
			String webSite, String userAccount) throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_004";
		chargeEntryData.fetchBillingTestData();
		verifyAddNewDiagnosisCode(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	public boolean verifyAddNewDiagnosisCode(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount,
			BillingLib chargeEntryData) throws IOException {
		Selenium selenium = null;
		boolean returnValue = true;

		try {

			// --------------------------------------------------------------------//
			// Step-1: Login to the application
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
			//callChargeEntry(selenium, chargeEntryData);
			if (chargeEntryData.testCaseId.equals("TC_CE_002")
					|| chargeEntryData.testCaseId.equals("TC_CE_003")) {
				if (isElementPresent(selenium, btnAddNewDiagnosisCode)) {
					assertTrue(click(selenium, btnAddNewDiagnosisCode),
							"Not able to click Add New Diagnosos Code", selenium, ClassName,
							MethodName);

				}
				assertTrue(isElementPresent(selenium, btnDelDiagnosisCode),
						"Delete Button not present, Row not added", selenium, ClassName, MethodName);
				
				if (chargeEntryData.testCaseId.equals("TC_CE_003")) {
					assertTrue(isElementPresent(selenium, lstDiagnosis41),
							"Second Row not added", selenium, ClassName,
							MethodName);
					assertTrue(isElementPresent(selenium, lstDiagnosis51),
							"Second Row not added", selenium, ClassName,
							MethodName);
					assertTrue(isElementPresent(selenium, lstDiagnosis61),
							"Second Row not added", selenium, ClassName,
							MethodName);
					assertTrue(isElementPresent(selenium, lstDiagnosis71),
							"Second Row not added", selenium, ClassName,
							MethodName);
				}

			}
			
			if (chargeEntryData.testCaseId.equals("TC_CE_004")){
				if (isElementPresent(selenium, btnAddNewDiagnosisCode)) {
					assertTrue(click(selenium, btnAddNewDiagnosisCode),
							"Not able to click Add New Diagnosos Code", selenium, ClassName,
							MethodName);
					assertTrue(click(selenium, btnAddNewDiagnosisCode1),
							"Not able to click Add New Diagnosos Code", selenium, ClassName,
							MethodName);

				}
				assertTrue(!isElementVisible(selenium, btnAddNewDiagnosisCode),
						"Add button still present after adding 12 Diagnosis Code", selenium, ClassName,
						MethodName);
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
