package com.nexia.selenium.testscripts.section.billing.adjusmentCodes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class EditCancelTestAdjusmentReasons extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void cancelEditAdjusmentReasons(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_008";
		adjustmentCodeData.fetchBillingTestData();
		cancelEditAdjusmentReasons(seleniumHost, seleniumPort, browser, webSite,
				userAccount, adjustmentCodeData);
	}

	/**
	 * cancelEditAdjusmentReasons function cancels the edit Adjustment Reasons
	 * 
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @throws IOException
	 * 
	 * @since Jan 10, 2014
	 */

	public boolean cancelEditAdjusmentReasons(String seleniumHost,
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
				adjustmentCodeData.workSheetName = "AdjustmentCodes";
				adjustmentCodeData.testCaseId = "TC_AC_003";
				adjustmentCodeData.fetchBillingTestData();
				if (isElementPresent(selenium, btnAdd)) {
					assertTrue(click(selenium, btnAdd),
							"Not able to click Add New", selenium, ClassName,
							MethodName);
					addAdjustmentReasons(selenium, adjustmentCodeData);
				}
				waitForPageLoad(selenium);

				// --------------------------------------------------------------------//
				// Step-3: Edit Payers //
				// --------------------------------------------------------------------//
				adjustmentCodeData.workSheetName = "AdjustmentCodes";
				adjustmentCodeData.testCaseId = "TC_AC_008";
				adjustmentCodeData.fetchBillingTestData();
				assertTrue(click(selenium, btnEdit),
						"Could not click Edit button", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);
				assertTrue(cancelEditAdjustmentReasons(selenium, adjustmentCodeData),
						"Could not Edit Adjustment Reasons", selenium,
						ClassName, MethodName);

			waitForPageLoad(selenium);
			return returnValue;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}
	
	public boolean cancelEditAdjustmentReasons(Selenium selenium,
			BillingLib adjustmentCodeData) throws IOException {
		try {
			assertTrue(
					type(selenium, txtadjustmentReason,
							adjustmentCodeData.adjusmentReason),
					"Could not type Adjustment Reason", selenium, ClassName,
					MethodName);
			assertTrue(
					type(selenium, txtdescription,
							adjustmentCodeData.description),
					"Could not type Description", selenium, ClassName,
					MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxc_DAdjusment,
							adjustmentCodeData.c_DAdjusment),
					"Could not select credit or debit adjustment", selenium,
					ClassName, MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxReportCategory,
							adjustmentCodeData.reportCategory),
					"Could not select Report category for adjustment",
					selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnCancel), "Could not click Cancel button",
					selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
