package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAvailableListValues extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyRenderingProviderListView(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_040";
		chargeEntryData.fetchBillingTestData();
		verifyListValues(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyBillingProviderListView(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_041";
		chargeEntryData.fetchBillingTestData();
		verifyListValues(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyReferringProviderListView(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_042";
		chargeEntryData.fetchBillingTestData();
		verifyListValues(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	public boolean verifyListValues(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount,
			BillingLib chargeEntryData) throws IOException {
		Selenium selenium = null;
		boolean returnValue = true;
		HomeLib payerData = new HomeLib();

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
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkLocationHeader),
					"Could not click header", selenium, ClassName, MethodName);
			String currentPractice = selenium.getText(lnkPractice);
			waitForPageLoad(selenium);
			Integer count = (Integer) selenium.getXpathCount(practice);
			if (chargeEntryData.testCaseId.equals("TC_CE_042")) {
			for (int rowPos = 1; rowPos <= count; rowPos++) {
				System.out.println(String.format(lnkpractice, rowPos));
				if (selenium.getText(String.format(lnkpractice, rowPos))
						.equals(currentPractice)) {
					selenium.click(String.format(lnkpractice, rowPos));
					break;
				}
			}}
			waitForPageLoad(selenium);
			String lblCount=selenium.getText(providers);
			lblCount=lblCount.replace('(', ' ');
			lblCount=lblCount.replace(')', ' ').trim();
			Integer countProviders = Integer.parseInt(lblCount);
			
			
			gotoSystemSettingExternalProviders(selenium);
			Integer countExtProviders = (Integer) selenium
					.getXpathCount(externalProviders);

			navigateToPatient(selenium, chargeEntryData);
			assertTrue(click(selenium,lnkUpdateDemographics),
					"Could not click Update Demographics", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			AbstractHomeTest payers = new AbstractHomeTest();
			click(selenium, lnkReferrals);
			waitForPageLoad(selenium);
			assertTrue(payers.deleteAllReferral(selenium),
					"Could not delete all referals", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			
			// ----------------------------------------------------------
			// ----------//
			// Step-7: Create a new Referral //
			// ----------------------------------------------------------
			// ----------//

			payerData.workSheetName = "CreateReferral";
			payerData.testCaseId = "TC_CRL_015";
			payerData.fetchHomeTestData();
			ClassName = this.getClass().getName().substring(39);
			MethodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			assertTrue(
					click(selenium, btnAddReferral),
					"Could not Click on Add Referral Button:"
							+ payerData.toString(), selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			assertTrue(payers.createReferral(selenium, payerData),
					"Referral creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			navigateToPatient(selenium, chargeEntryData);
			goToPostNewCharge(selenium, chargeEntryData);
			if (chargeEntryData.testCaseId.equals("TC_CE_041")) {
				selenium.click(lstRenderingProvider);
			} else if (chargeEntryData.testCaseId.equals("TC_CE_040")) {
				selenium.click(lstBillingProvider);
			}
			
			if (chargeEntryData.testCaseId.equals("TC_CE_040")
					|| chargeEntryData.testCaseId.equals("TC_CE_041")) {
				if(selenium.getXpathCount(rendingProviders).toString().equals(countProviders.toString()))
				assertTrue(
						selenium.getXpathCount(rendingProviders).toString().equals(countProviders.toString()),
						"Providers are not same as the in the system setting",
						selenium, ClassName, MethodName);
			} else if (chargeEntryData.testCaseId.equals("TC_CE_042")) {
				selenium.click(lstReferringProvider);
				waitForPageLoad(selenium);
				Integer countRef = countProviders + countExtProviders + 1;
				System.out.println((Integer) selenium.getXpathCount(rendingProviders));
				assertTrue(
							selenium.getXpathCount(rendingProviders).toString().equals(countRef.toString()),
							"Providers are not same as the in the system setting",
							selenium, ClassName, MethodName);
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
