package com.nexia.selenium.testscripts.section.billing.adjusmentCodes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingUnitTestLib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestsForAdjustmentReasons extends AbstractBilling {

	@Test(groups = { "RegressionUnit", "firefox", "iexplore", "safari",
			"default" }, description = "PayerWithInvalid")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void unitWithNoReason(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib adjustmentCodeData = new BillingUnitTestLib();
		adjustmentCodeData.workSheetName = "UnitTest_AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_UAC_001";
		adjustmentCodeData.fetchBillingTestData();
		addAdjustmentReason(seleniumHost, seleniumPort, browser, webSite,
				userAccount, adjustmentCodeData);
	}

	@Test(groups = { "RegressionUnit", "firefox", "iexplore", "safari",
			"default" }, description = "PayerWithInvalid")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void unitWithNoDescription(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib adjustmentCodeData = new BillingUnitTestLib();
		adjustmentCodeData.workSheetName = "UnitTest_AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_UAC_002";
		adjustmentCodeData.fetchBillingTestData();
		addAdjustmentReason(seleniumHost, seleniumPort, browser, webSite,
				userAccount, adjustmentCodeData);
	}

	@Test(groups = { "RegressionUnit", "firefox", "iexplore", "safari",
			"default" }, description = "PayerWithInvalid")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void unitCheckReasonLength(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib adjustmentCodeData = new BillingUnitTestLib();
		adjustmentCodeData.workSheetName = "UnitTest_AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_UAC_003";
		adjustmentCodeData.fetchBillingTestData();
		addAdjustmentReason(seleniumHost, seleniumPort, browser, webSite,
				userAccount, adjustmentCodeData);
	}

	@Test(groups = { "RegressionUnit", "firefox", "iexplore", "safari",
			"default" }, description = "PayerWithInvalid")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void unitCheckDescriptionLength(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib adjustmentCodeData = new BillingUnitTestLib();
		adjustmentCodeData.workSheetName = "UnitTest_AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_UAC_004";
		adjustmentCodeData.fetchBillingTestData();
		addAdjustmentReason(seleniumHost, seleniumPort, browser, webSite,
				userAccount, adjustmentCodeData);
	}

	/**
	 * addFeeSchedule function to add fee schedule
	 * 
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @throws IOException
	 * @since Jan 06, 2014
	 */

	public boolean addAdjustmentReason(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount,
			BillingUnitTestLib billingData) throws IOException {
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
							+ billingData.toString());
			assertTrue(
					loginForNexiaFromProviderSite(selenium, userAccount,
							billingData.userName, billingData.userPassword),
					"Login Failed ", selenium, ClassName, MethodName);

			// --------------------------------------------------------------------//
			// Step-2: Go to Fee Schedule //
			// --------------------------------------------------------------------//

			assertTrue(goToAdjustmentReasons(selenium), "Navigation Failed",
					selenium, ClassName, MethodName);

			// --------------------------------------------------------------------//
			// Step-3: Add Adjustment Reason //
			// --------------------------------------------------------------------//

			if (isElementPresent(selenium, "css=span.add")) {
				assertTrue(click(selenium, "css=span.add"),
						"Not able to click Add New", selenium, ClassName,
						MethodName);
			}
			assertTrue(unitTestAddAdjustmentReasons(selenium, billingData),
					"Creation Failed", selenium, ClassName, MethodName);

			// --------------------------------------------------------------------//
			// Step-4: Verify Field validation //
			// --------------------------------------------------------------------//

			if (!billingData.alert.equals("")) {
				assertTrue(isElementPresent(selenium, billingData.alert),
						"The validation message field did not appear",
						selenium, ClassName, MethodName);
				assertTrue(
						getText(selenium, billingData.alert).contains(
								billingData.alertMessage),
						"The expected validation message should contain the text - "
								+ billingData.alertMessage
								+ " The actual validation message shown - "
								+ getText(selenium, billingData.alert),
						selenium, ClassName, MethodName);
				return true;
			} else {
				return true;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,
					"Failed Due to the Exception; \n\t*) ExceptionDetails :"
							+ e.getMessage() + "\n\t*)", selenium, ClassName,
					MethodName);
		}
		return returnValue;
	}
}
