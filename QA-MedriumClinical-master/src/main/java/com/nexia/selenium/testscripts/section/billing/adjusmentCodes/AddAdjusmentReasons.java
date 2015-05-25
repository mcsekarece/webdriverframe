package com.nexia.selenium.testscripts.section.billing.adjusmentCodes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class AddAdjusmentReasons extends AbstractBilling {

	@Test(groups = {"AdvancedSmoke","Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void addnewAdjusmentReasons(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_003";
		adjustmentCodeData.fetchBillingTestData();
		addAdjusmentReasons(seleniumHost, seleniumPort, browser, webSite,
				userAccount, adjustmentCodeData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAddAdjusmentReasonsPageButtons(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_007";
		adjustmentCodeData.fetchBillingTestData();
		addAdjusmentReasons(seleniumHost, seleniumPort, browser, webSite,
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

	public boolean addAdjusmentReasons(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount,
			BillingLib adjustmentCodeData) throws IOException {
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

			if (adjustmentCodeData.testCaseId.equals("TC_AC_007")) {
				verifyAddAdjusmentReasonsPageButtons(selenium);

			}

			return returnValue;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

	/**
	 * verifyAddAdjusmentReasonsPageButtons function verifies the buttons in add
	 * Adjustment Reasons page Summary
	 * 
	 * @since Jan 22, 2014
	 */

	public boolean verifyAddAdjusmentReasonsPageButtons(Selenium selenium) {

		waitForPageLoad(selenium);
		try {
			assertTrue(isElementPresent(selenium, btnSaveAndAddAnother),
					"Save And Add another Button not present in summary",
					selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium, btnSave),
					"Save Button not present in summary", selenium, ClassName,
					MethodName);
			assertTrue(isElementPresent(selenium, btnCancel),
					"Cancel Button not present in summary", selenium,
					ClassName, MethodName);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
