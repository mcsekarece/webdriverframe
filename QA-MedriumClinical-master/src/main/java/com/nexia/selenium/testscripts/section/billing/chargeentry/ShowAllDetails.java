package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;

import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class ShowAllDetails extends AbstractBilling {

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyShowAllDetailsView(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_033";
		chargeEntryData.fetchBillingTestData();
		verifyShowAllDetailsView(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyHideAllDetailsView(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_055";
		chargeEntryData.fetchBillingTestData();
		verifyShowAllDetailsView(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAmbulanceTransView(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_035";
		chargeEntryData.fetchBillingTestData();
		verifyShowAllDetailsView(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyChiroPracticView(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_036";
		chargeEntryData.fetchBillingTestData();
		verifyShowAllDetailsView(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyDMEView(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_037";
		chargeEntryData.fetchBillingTestData();
		verifyShowAllDetailsView(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyOxygenView(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_038";
		chargeEntryData.fetchBillingTestData();
		verifyShowAllDetailsView(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyNDCView(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_039";
		chargeEntryData.fetchBillingTestData();
		verifyShowAllDetailsView(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	public boolean verifyShowAllDetailsView(String seleniumHost,
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
			assertTrue(isElementPresent(selenium, lnkShowDetail),
					"Show All Detail link not present", selenium, ClassName,
					MethodName);
			assertTrue(click(selenium, lnkShowDetail),
					"Show All Detail link not present", selenium, ClassName,
					MethodName);
			if (!chargeEntryData.testCaseId.equals("TC_CE_055")) {
				if (chargeEntryData.testCaseId.equals("TC_CE_033")) {
					assertTrue(isElementPresent(selenium, txtstatementNote),
							"Show All Detail link not present", selenium,
							ClassName, MethodName);
					assertTrue(isElementPresent(selenium, lstSpclProgCode),
							"Show All Detail link not present", selenium,
							ClassName, MethodName);
					assertTrue(isElementPresent(selenium, lstDelayReaCode),
							"Show All Detail link not present", selenium,
							ClassName, MethodName);
					assertTrue(
							isElementPresent(selenium, chkStnFamilyPlanning),
							"Show All Detail link not present", selenium,
							ClassName, MethodName);
					assertTrue(isElementPresent(selenium, chkStnEmergency),
							"Show All Detail link not present", selenium,
							ClassName, MethodName);
					assertTrue(isElementPresent(selenium, chkStnEPSDT),
							"Show All Detail link not present", selenium,
							ClassName, MethodName);
					assertTrue(isElementPresent(selenium, chkChiroPrac),
							"Show All Detail link not present", selenium,
							ClassName, MethodName);
					assertTrue(isElementPresent(selenium, chkDME),
							"Show All Detail link not present", selenium,
							ClassName, MethodName);
					assertTrue(isElementPresent(selenium, chkNDCDrug),
							"Show All Detail link not present", selenium,
							ClassName, MethodName);
					assertTrue(isElementPresent(selenium, lstCorrection),
							"Show All Detail link not present", selenium,
							ClassName, MethodName);
					assertTrue(isElementPresent(selenium, txtOrgClaimRef),
							"Show All Detail link not present", selenium,
							ClassName, MethodName);
				} else
					savePostChargeEntry(selenium, chargeEntryData,userAccount);
			}
			else{
				assertTrue(isElementPresent(selenium, lnkShowDetail),
						"Show All Detail link not present", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, lnkShowDetail),
						"Show All Detail link not present", selenium, ClassName,
						MethodName);
				assertTrue(!isElementVisible(selenium, txtstatementNote),
						"Show All Detail link not present", selenium,
						ClassName, MethodName);
				assertTrue(!isElementVisible(selenium, lstSpclProgCode),
						"Show All Detail link not present", selenium,
						ClassName, MethodName);
				assertTrue(!isElementVisible(selenium, lstDelayReaCode),
						"Show All Detail link not present", selenium,
						ClassName, MethodName);
				assertTrue(
						!isElementVisible(selenium, chkStnFamilyPlanning),
						"Show All Detail link not present", selenium,
						ClassName, MethodName);
				assertTrue(!isElementVisible(selenium, chkStnEmergency),
						"Show All Detail link not present", selenium,
						ClassName, MethodName);
				assertTrue(!isElementVisible(selenium, chkStnEPSDT),
						"Show All Detail link not present", selenium,
						ClassName, MethodName);
				assertTrue(!isElementVisible(selenium, chkChiroPrac),
						"Show All Detail link not present", selenium,
						ClassName, MethodName);
				assertTrue(!isElementVisible(selenium, chkDME),
						"Show All Detail link not present", selenium,
						ClassName, MethodName);
				assertTrue(!isElementVisible(selenium, chkNDCDrug),
						"Show All Detail link not present", selenium,
						ClassName, MethodName);
				assertTrue(!isElementVisible(selenium, lstCorrection),
						"Show All Detail link not present", selenium,
						ClassName, MethodName);
				assertTrue(!isElementVisible(selenium, txtOrgClaimRef),
						"Show All Detail link not present", selenium,
						ClassName, MethodName);
				
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
