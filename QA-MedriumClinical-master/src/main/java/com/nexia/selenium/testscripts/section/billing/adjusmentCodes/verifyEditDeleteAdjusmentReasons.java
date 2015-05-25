package com.nexia.selenium.testscripts.section.billing.adjusmentCodes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class verifyEditDeleteAdjusmentReasons extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifySummaryAdjusmentReasons(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_010";
		adjustmentCodeData.fetchBillingTestData();
		verifySummaryAdjusmentReasons(seleniumHost, seleniumPort, browser, webSite,
				userAccount, adjustmentCodeData);
	}

	/**
	 * verifySummaryAdjusmentReasons function to Add and Verify Summary of Adjustment Reasons
	 * 
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @throws IOException
	 * 
	 * @since Jan 23, 2014
	 */

	public boolean verifySummaryAdjusmentReasons(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount,
			BillingLib adjustmentCodeData) throws IOException {
		Selenium selenium = null;
		String date = null;
		String time = null;
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
					"Not able to Add New Adjustment Reason", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MMM dd, yyyy");
			date = DateFormat.format(cal.getTime());
			DateFormat = new SimpleDateFormat("HH");
			time = DateFormat.format(cal.getTime());
			assertTrue(
					verifyAdjustmentReasonsSummary(selenium, adjustmentCodeData),
					"New Adjustment Reason not added", selenium, ClassName,
					MethodName);

			assertTrue(
					verifyTimeStampForProviderPage(selenium,
							summaryAdjustmentReasons, date, time),
					"Time stamp is not displayed", selenium, ClassName,
					MethodName);
			
			return returnValue;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
