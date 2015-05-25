package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteServiceLine extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyDeleteServiceLine(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_008";
		chargeEntryData.fetchBillingTestData();
		verifyDeleteServiceLine(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyDeleteAddNewServiceLine(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_012";
		chargeEntryData.fetchBillingTestData();
		verifyDeleteServiceLine(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	public boolean verifyDeleteServiceLine(String seleniumHost,
			int seleniumPort, String browser, String webSite,
			String userAccount, BillingLib chargeEntryData) throws IOException {
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
			//callChargeEntry(selenium, chargeEntryData);
			if (chargeEntryData.testCaseId.equals("TC_CE_008")) {
				if (isElementPresent(selenium, btnAddNewServiceLine)) {
					assertTrue(click(selenium, btnAddNewServiceLine),
							"Not able to click Add New", selenium, ClassName,
							MethodName);

				}
				assertTrue(isElementPresent(selenium, lnkDeleteServiceLine1),
						"Delete Button not present", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, lnkDeleteServiceLine1),
						"Not able to click Delete Button", selenium, ClassName,
						MethodName);
			}
			
			if (chargeEntryData.testCaseId.equals("TC_CE_012")) {
				if (isElementPresent(selenium, btnAddNewServiceLine)) {
					assertTrue(click(selenium, btnAddNewServiceLine),
							"Not able to click Add New", selenium, ClassName,
							MethodName);
					assertTrue(click(selenium, btnAddNewServiceLine),
							"Not able to click Add New", selenium, ClassName,
							MethodName);

				}
				assertTrue(isElementPresent(selenium, lnkDeleteServiceLine1),
						"Delete Button not present", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, lnkDeleteServiceLine1),
						"Not able to click Delete Button", selenium, ClassName,
						MethodName);
				assertTrue((Integer) selenium.getXpathCount(lnkDeleteServiceLine)==2,
						"Service Lines not Deleted Properly", selenium,
						ClassName, MethodName);
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}


}
