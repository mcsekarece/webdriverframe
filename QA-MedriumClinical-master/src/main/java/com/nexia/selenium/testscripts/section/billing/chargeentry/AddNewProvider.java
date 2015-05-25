package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class AddNewProvider extends AbstractBilling {

	@Test(groups = {"RegressionUS","Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAddNewProvider(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_011";
		chargeEntryData.fetchBillingTestData();
		verifyAddNewProvider(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	
	public boolean verifyAddNewProvider(String seleniumHost,
			int seleniumPort, String browser, String webSite,
			String userAccount, BillingLib chargeEntryData) throws IOException {
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
			if (chargeEntryData.testCaseId.equals("TC_CE_011")) {
				if (isElementPresent(selenium, btnAddNewProvider)) {
					assertTrue(click(selenium, btnAddNewProvider),
							"Not able to click Add New Provider", selenium, ClassName,
							MethodName);

				}
				assertTrue(isElementPresent(selenium, ajxProviderChargeEntry0),
						"Provider List box not present", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, ajxProviderTypeChargeEntry0),
						"Provider Type not present", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, btnDeleteProvider),
						"Delete button not present", selenium,
						ClassName, MethodName);
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
