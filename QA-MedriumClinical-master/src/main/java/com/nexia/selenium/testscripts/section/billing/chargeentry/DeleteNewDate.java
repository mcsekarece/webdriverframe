package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteNewDate extends AbstractBilling {

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void deleteNewDate(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_019";
		chargeEntryData.fetchBillingTestData();
		verifyDeleteNewDate(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	
	public boolean verifyDeleteNewDate(String seleniumHost,
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
			if (chargeEntryData.testCaseId.equals("TC_CE_019")) {
				if (isElementPresent(selenium, btnAddNewDate)) {
					assertTrue(click(selenium, btnAddNewDate),
							"Not able to click Add New Date", selenium, ClassName,
							MethodName);

				}
				assertTrue(isElementPresent(selenium, btnDeleteDate1),
						"DateType list box not present", selenium,
						ClassName, MethodName);
				assertTrue(click(selenium, btnDeleteDate1),
						"Date picker not found", selenium,
						ClassName, MethodName);
				assertTrue(!isElementPresent(selenium, lstDateType),
						"Date picker not found", selenium,
						ClassName, MethodName);
				assertTrue(!isElementPresent(selenium, dateAddDate),
						"Date picker not found", selenium,
						ClassName, MethodName);	
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
