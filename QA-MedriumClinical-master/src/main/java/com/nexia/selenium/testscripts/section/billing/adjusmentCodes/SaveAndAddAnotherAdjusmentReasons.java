package com.nexia.selenium.testscripts.section.billing.adjusmentCodes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class SaveAndAddAnotherAdjusmentReasons extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void saveAndAddAnotherAdjusmentReasons(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_006";
		adjustmentCodeData.fetchBillingTestData();
		saveAndAddAnotherAdjusmentReasons(seleniumHost, seleniumPort, browser,
				webSite, userAccount, adjustmentCodeData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifySaveAndAddAnotherAdjusmentReasons(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_012";
		adjustmentCodeData.fetchBillingTestData();
		saveAndAddAnotherAdjusmentReasons(seleniumHost, seleniumPort, browser,
				webSite, userAccount, adjustmentCodeData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifySaveAndAddAnotherAdjusmentReasonsPage(
			String seleniumHost, int seleniumPort, String browser,
			String webSite, String userAccount) throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_013";
		adjustmentCodeData.fetchBillingTestData();
		saveAndAddAnotherAdjusmentReasons(seleniumHost, seleniumPort, browser,
				webSite, userAccount, adjustmentCodeData);
	}

	/**
	 * verifyAdjusmentReasons function to Add and Verify Adjustment Reasons
	 * 
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @throws IOException
	 * 
	 * @since Jan 03, 2014
	 */

	public boolean saveAndAddAnotherAdjusmentReasons(String seleniumHost,
			int seleniumPort, String browser, String webSite,
			String userAccount, BillingLib adjustmentCodeData)
			throws IOException {
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
							+ adjustmentCodeData.toString());

			assertTrue(
					loginForNexiaFromProviderSite(selenium, userAccount,
							adjustmentCodeData.userName,
							adjustmentCodeData.userPassword), "Login Failed ",
					selenium, ClassName, MethodName);

			waitForPageLoad(selenium);

			assertTrue(switchRole(selenium, adjustmentCodeData.switchRole),
					"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-2: Go to Adjustment Reasons
			// --------------------------------------------------------------------//

			assertTrue(goToAdjustmentReasons(selenium),
					"Adjustment Navigation Failed", selenium, ClassName,
					MethodName);
			
			assertTrue(deleteAllAdjustmentCodes(selenium),
					"Adjustment Deletion Failed", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			if (isElementPresent(selenium, btnAdd)) {
				assertTrue(click(selenium, btnAdd),
						"Not able to click Add New", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(addAdjustmentReasons(selenium, adjustmentCodeData),
					"Not able to click Add New", selenium, ClassName,
					MethodName);
			if (isElementPresent(selenium, btnSaveAndAddAnother)) {
				assertTrue(click(selenium, btnSaveAndAddAnother),
						"Not able to click Save and Add Another", selenium, ClassName,
						MethodName);
			}
			waitForPageLoad(selenium);
			if (adjustmentCodeData.testCaseId.equals("TC_AC_012")) {
				assertTrue(click(selenium, btnCancel),
							"Not able to click Cancel", selenium, ClassName,
							MethodName);
				waitForPageLoad(selenium);
				searchAdjustmentReasons(selenium,adjustmentCodeData);
				assertTrue(
						verifyAdjustmentReasonsSummary(selenium,
								adjustmentCodeData),
						"New Adjustment Reason not added", selenium, ClassName,
						MethodName);

			}

			if (adjustmentCodeData.testCaseId.equals("TC_AC_013")) {
				verifySaveAndAddAnotherAdjusmentReasonsPage(selenium);
			}

			waitForPageLoad(selenium);
			return returnValue;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

	/**
	 * verifySaveAndAddAnotherAdjusmentReasonsPage function adds a new
	 * Adjustment Reasons
	 * 
	 * @since Jan 06, 2014
	 */

	public boolean verifySaveAndAddAnotherAdjusmentReasonsPage(
			Selenium selenium)
			throws IOException {
		waitForPageLoad(selenium);

		assertTrue(isElementPresent(selenium, txtadjustmentReason),
				"Could not type Adjustment Reason", selenium, ClassName,
				MethodName);

		assertTrue(isElementPresent(selenium, txtdescription),
				"Could not type Description", selenium, ClassName, MethodName);

		assertTrue(isElementPresent(selenium, ajxc_DAdjusment),
				"Could not select credit or debit adjustment", selenium,
				ClassName, MethodName);

		assertTrue(isElementPresent(selenium, ajxReportCategory),
				"Could not select Report category for adjustment", selenium,
				ClassName, MethodName);

		waitForPageLoad(selenium);

		return true;
	}

}
