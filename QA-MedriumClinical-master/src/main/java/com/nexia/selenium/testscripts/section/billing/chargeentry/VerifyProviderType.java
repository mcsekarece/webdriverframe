package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyProviderType extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyProviderTypeOrdering(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_050";
		chargeEntryData.fetchBillingTestData();
		verifyListValues(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyProviderTypeOthers(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_051";
		chargeEntryData.fetchBillingTestData();
		verifyListValues(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	public boolean verifyListValues(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount,
			BillingLib chargeEntryData) throws IOException {
		Selenium selenium = null;
		boolean returnValue = true;
		String lblCount;
		Integer countProviders;

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
			gotoSystemSetting(selenium);
			
			if (chargeEntryData.testCaseId.equals("TC_CE_050")) {
				
				lblCount = selenium.getText(lblProviderCount);
				lblCount = lblCount.replace('(', ' ');
				lblCount = lblCount.replace(')', ' ').trim();
				countProviders = Integer.parseInt(lblCount);

				gotoSystemSettingExternalProviders(selenium);
				Integer countExtProviders = (Integer) selenium
						.getXpathCount(externalProviders);

				navigateToPatient(selenium, chargeEntryData);
				goToPostNewCharge(selenium, chargeEntryData);

				assertTrue(
						selectValueFromAjaxList(selenium,
								ajxProviderTypeChargeEntry,
								chargeEntryData.ProviderType),
						"Adjustment Reason textbox not Present", selenium,
						ClassName, MethodName);
				selenium.click(ajxProviderChargeEntry);
				assertTrue(
						(Integer) selenium.getXpathCount(rendingProviders) == (countProviders + countExtProviders),
						"Providers are not same as the in the system setting",
						selenium, ClassName, MethodName);
			} else {
				String currentPractice = selenium.getText(lnkLocationHeader);
				Integer count = (Integer) selenium.getXpathCount(practice);
				for (int rowPos = 1; rowPos <= count; rowPos++) {
					if (selenium.getText(String.format(lnkpractice, rowPos))
							.equals(currentPractice)) {
						selenium.click(String.format(lnkpractice, rowPos));
					}
				}
				
				lblCount = selenium.getText(providers);
				lblCount = lblCount.replace('(', ' ');
				lblCount = lblCount.replace(')', ' ').trim();
				countProviders = Integer.parseInt(lblCount);
				navigateToPatient(selenium, chargeEntryData);
				goToPostNewCharge(selenium, chargeEntryData);
				
				assertTrue(
						selectValueFromAjaxList(selenium,
								ajxProviderTypeChargeEntry,
								chargeEntryData.ProviderType),
						"Adjustment Reason textbox not Present", selenium,
						ClassName, MethodName);
				selenium.click(ajxProviderChargeEntry);
				assertTrue(
						(Integer) selenium.getXpathCount(rendingProviders) == (countProviders),
						"Providers are not same as the in the system setting",
						selenium, ClassName, MethodName);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
