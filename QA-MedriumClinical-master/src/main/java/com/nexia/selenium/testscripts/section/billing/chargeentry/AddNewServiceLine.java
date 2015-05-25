package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.Keys;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class AddNewServiceLine extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAddNewServiceLine(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_006";
		chargeEntryData.fetchBillingTestData();
		verifyAddNewServiceLine(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAddNewServiceLinePressingEnter(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_007";
		chargeEntryData.fetchBillingTestData();
		verifyAddNewServiceLine(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAddNewServiceLine3Times(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_008";
		chargeEntryData.fetchBillingTestData();
		verifyAddNewServiceLine(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	public boolean verifyAddNewServiceLine(String seleniumHost,
			int seleniumPort, String browser, String webSite,
			String userAccount, BillingLib chargeEntryData) throws IOException, AWTException {
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
			//callChargeEntry(selenium, chargeEntryData);
			if (chargeEntryData.testCaseId.equals("TC_CE_006")) {
				if (isElementPresent(selenium, btnAddNewServiceLine)) {
					assertTrue(click(selenium, btnAddNewServiceLine),
							"Not able to click Add New Service Line", selenium, ClassName,
							MethodName);

				}
				assertTrue(isElementPresent(selenium, lnkDeleteServiceLine1),
						"Second Row not added by clicking Add New", selenium,
						ClassName, MethodName);
			}
			if (chargeEntryData.testCaseId.equals("TC_CE_007")) {
				selenium.clickAt(txtServiceLineUnits1, "");
				selenium.focus(txtServiceLineUnits1);	
//				selenium.click(txtServiceLineUnits1);
				selenium.type(txtServiceLineUnits1, "1");
				selenium.focus(txtServiceLineUnits1);	
				selenium.clickAt(txtServiceLineUnits1, "");
				selenium.keyDown(txtServiceLineUnits1, "\\13");
				selenium.keyDown(txtServiceLineUnits1, "\\13");
				selenium.keyDown(txtServiceLineUnits1, "\\13");
				//selenium.keyPress(txtServiceLineUnits1, Keys.ENTER);
				//selenium.keyPressNative(Keys.ENTER);
				//selenium.keyPressNative(Integer.toString(KeyEvent.VK_ENTER));
				Robot r = new Robot();

				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);

				assertTrue(isElementPresent(selenium, lnkDeleteServiceLine1),
						"Second Row not added by hitting enter", selenium,
						ClassName, MethodName);
			}
			if (chargeEntryData.testCaseId.equals("TC_CE_008")) {
				for (int i = 0; i <= 2; i++) {
					if (isElementPresent(selenium, btnAddNewServiceLine)) {
						assertTrue(click(selenium, btnAddNewServiceLine),
								"Not able to click Add New Service Line", selenium, 
								ClassName, MethodName);

					}
				}
				assertTrue((Integer) selenium.getXpathCount(lnkDeleteServiceLine)==4,
						"3 more Service Lines not added", selenium,
						ClassName, MethodName);
		}

		}catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
