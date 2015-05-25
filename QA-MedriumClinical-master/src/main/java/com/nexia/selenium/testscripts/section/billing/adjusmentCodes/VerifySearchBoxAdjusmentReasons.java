package com.nexia.selenium.testscripts.section.billing.adjusmentCodes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchBoxAdjusmentReasons extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifySearchAdjusmentReasons(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_015";
		adjustmentCodeData.fetchBillingTestData();
		verifySearchAdjusmentReasons(seleniumHost, seleniumPort, browser,
				webSite, userAccount, adjustmentCodeData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifySearchAdjusmentInactiveReasons(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_016";
		adjustmentCodeData.fetchBillingTestData();
		verifySearchAdjusmentReasons(seleniumHost, seleniumPort, browser,
				webSite, userAccount, adjustmentCodeData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifySearchAdjusmentIncludeInactiveReasons(
			String seleniumHost, int seleniumPort, String browser,
			String webSite, String userAccount) throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_017";
		adjustmentCodeData.fetchBillingTestData();
		verifySearchAdjusmentReasons(seleniumHost, seleniumPort, browser,
				webSite, userAccount, adjustmentCodeData);
	}

	/**
	 * verifySearchAdjusmentReasons function Verify Search Box in Adjustment
	 * Reasons
	 * 
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @throws IOException
	 * 
	 * @since Jan 09, 2014
	 */

	public boolean verifySearchAdjusmentReasons(String seleniumHost,
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

			if (isElementPresent(selenium, btnAdd)) {
				assertTrue(click(selenium, btnAdd),
						"Not able to click Add New", selenium, ClassName,
						MethodName);
			}
			assertTrue(addAdjustmentReasons(selenium, adjustmentCodeData),
					"Not able to Add New Adjustment Reason", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);
			if (adjustmentCodeData.testCaseId.equals("TC_AC_015")){ 
			assertTrue(searchAdjustmentReasons(selenium, adjustmentCodeData),
					"Not able search Adjustment Reason", selenium,
					ClassName, MethodName);
			}
			if (!adjustmentCodeData.testCaseId.equals("TC_AC_015")) {
				assertTrue(deleteAllAdjustmentCodes(selenium),
						"Adjustment Deletion Failed", selenium, ClassName,
						MethodName);
			}
			if (adjustmentCodeData.testCaseId.equals("TC_AC_017")) {
				assertTrue(check(selenium, chkInactiveAdjustmentReason),
						"Not able to check inactive", selenium, ClassName,
						MethodName);
				assertTrue(searchAdjustmentReasons(selenium, adjustmentCodeData),
						"Not able search Adjustment Reason", selenium,
						ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			
			if (adjustmentCodeData.testCaseId.equals("TC_AC_016")) {
				assertTrue(searchAdjustmentReasons(selenium, adjustmentCodeData),
						"Not able search Adjustment Reason", selenium,
						ClassName, MethodName);
				assertTrue(
						!verifyAdjustmentReasonsSummary(selenium,
								adjustmentCodeData),
						"Inactive Reasons visible when inactive is not selected",
						selenium, ClassName, MethodName);
			}else if (!adjustmentCodeData.testCaseId.equals("TC_AC_016")) {
				assertTrue(verifyAdjustmentReasonsSummary(selenium,adjustmentCodeData),"Inactive Reasons not visible when inactive is selected",selenium, ClassName, MethodName);
			}

			return returnValue;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
