package com.nexia.selenium.testscripts.section.billing.adjusmentCodes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class SaveCancelTestAdjusmentReasons extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void cancelAdjusmentReasons(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_004";
		adjustmentCodeData.fetchBillingTestData();
		cancelAdjusmentReasons(seleniumHost, seleniumPort, browser, webSite,
				userAccount, adjustmentCodeData);
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

	public boolean cancelAdjusmentReasons(String seleniumHost,
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
			if (isElementPresent(selenium, btnAdd)) {
				assertTrue(click(selenium, btnAdd),
						"Not able to click Add New", selenium, ClassName,
						MethodName);
			}
				assertTrue(addAdjustmentReasons(selenium, adjustmentCodeData),
						"Not able to click Add New", selenium, ClassName,
						MethodName);
				if (isElementPresent(selenium, btnCancel)) {
					assertTrue(click(selenium, btnCancel),
							"Could not click Cancel button", selenium, ClassName,
							MethodName);
				}
				assertTrue(
						isElementPresent(selenium,lblEmptyList),"Adjustment Navigation Failed", selenium, ClassName,
						MethodName);
		

			waitForPageLoad(selenium);
			return returnValue;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
