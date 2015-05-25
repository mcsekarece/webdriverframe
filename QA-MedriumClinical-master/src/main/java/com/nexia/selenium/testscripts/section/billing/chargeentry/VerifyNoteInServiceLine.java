package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyNoteInServiceLine extends AbstractBilling {

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyNoteInServiceLine(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_045";
		chargeEntryData.fetchBillingTestData();
		verifyNoteInServiceLine(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifySaveNoteSave(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_046";
		chargeEntryData.fetchBillingTestData();
		verifyNoteInServiceLine(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifySaveNoteSaveAfterCancel(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_047";
		chargeEntryData.fetchBillingTestData();
		verifyNoteInServiceLine(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifySaveNoteEdit(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_048";
		chargeEntryData.fetchBillingTestData();
		verifyNoteInServiceLine(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifySaveNoteViewHistory(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_049";
		chargeEntryData.fetchBillingTestData();
		verifyNoteInServiceLine(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}
	
	

	public boolean verifyNoteInServiceLine(String seleniumHost,
			int seleniumPort, String browser, String webSite,
			String userAccount, BillingLib chargeEntryData) throws IOException {
		Selenium selenium = null;
		boolean returnValue = true;
		String date = null;
		String provider = getText(selenium, lnkTopMenu);
		String onBehalfOf = provider.replaceAll(", "
				+ chargeEntryData.switchRole, "");

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

			if (chargeEntryData.testCaseId.equals("TC_CE_045")) {
				assertTrue(isElementPresent(selenium, noteServiceLine),
						"Note field is not present in the ServiceLine",
						selenium, ClassName, MethodName);
				assertTrue(click(selenium, noteServiceLine),
						"Not able to click Note in service line", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, lnkNoteComment),
						"Note Pop up not present", selenium, ClassName,
						MethodName);
				assertTrue(isElementPresent(selenium, lnkNoteSave),
						"Save Link not present", selenium, ClassName,
						MethodName);
				assertTrue(isElementPresent(selenium, lnkNoteCancel),
						"Cancel Link not present", selenium, ClassName,
						MethodName);

				assertTrue(
						type(selenium, lnkNoteComment, chargeEntryData.Comment),
						"Not able to type Comment", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, lnkNoteSave),
						"Not able to click Save", selenium, ClassName,
						MethodName);
				assertTrue(isElementPresent(selenium, lnkNoteHideComment ),
						"Hide Comment Link not present", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, lnkNoteHideComment),
						"Not able to click Hide Comment Link", selenium,
						ClassName, MethodName);
				assertTrue(
						!isElementPresent(selenium, lnkNoteComment),
						"Note Pop still present after clicking the cancel link",
						selenium, ClassName, MethodName);
			} else if (chargeEntryData.testCaseId.equals("TC_CE_046")) {
				assertTrue(click(selenium, noteServiceLine),
						"Not able to click Note in service line", selenium,
						ClassName, MethodName);
				assertTrue(
						type(selenium, lnkNoteComment, chargeEntryData.Comment),
						"Not able to type Comment", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, lnkNoteSave),
						"Not able to click Save", selenium, ClassName,
						MethodName);
				assertTrue(
						selenium.getText(lnkNoteComment).contains(
								chargeEntryData.Comment),
						"Didnt Save the Comment Properly", selenium, ClassName,
						MethodName);
			} else if (chargeEntryData.testCaseId.equals("TC_CE_047")) {
				assertTrue(click(selenium, noteServiceLine),
						"Not able to click Note in service line", selenium,
						ClassName, MethodName);
				assertTrue(
						type(selenium, lnkNoteComment, chargeEntryData.Comment),
						"Not able to type Comment", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, lnkNoteSave),
						"Not able to click Save", selenium, ClassName,
						MethodName);
				assertTrue(isElementPresent(selenium, lnkNoteHideComment),
						"Hide Comment Link not present", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, noteServiceLine),
						"Not able to click Note in service line", selenium,
						ClassName, MethodName);
				assertTrue(
						selenium.getText(lnkNoteComment).contains(
								chargeEntryData.Comment),
						"Didnt Save the Comment Properly", selenium, ClassName,
						MethodName);

			} else if (chargeEntryData.testCaseId.equals("TC_CE_048")) {
				assertTrue(click(selenium, noteServiceLine),
						"Not able to click Note in service line", selenium,
						ClassName, MethodName);
				assertTrue(
						type(selenium, lnkNoteComment, chargeEntryData.Comment),
						"Not able to type Comment", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, lnkNoteSave),
						"Not able to click Save", selenium, ClassName,
						MethodName);
				assertTrue(isElementPresent(selenium, lnkNoteCancel),
						"Hide Comment Link not present", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, lnkNoteEdit),
						"Not able to click Note in service line", selenium,
						ClassName, MethodName);
				assertTrue(
						type(selenium, lnkNoteComment, chargeEntryData.Comment1),
						"Not able to type Comment", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, lnkNoteSave),
						"Not able to click Save", selenium, ClassName,
						MethodName);
				assertTrue(
						selenium.getText(lnkNoteComment).contains(
								chargeEntryData.Comment1),
						"Didnt Save the Comment Properly", selenium, ClassName,
						MethodName);

			} else if (chargeEntryData.testCaseId.equals("TC_CE_049")) {
				assertTrue(click(selenium, noteServiceLine),
						"Not able to click Note in service line", selenium,
						ClassName, MethodName);
				assertTrue(
						type(selenium, lnkNoteComment, chargeEntryData.Comment),
						"Not able to type Comment", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, noteServiceLine),
						"Not able to click Note in service line", selenium,
						ClassName, MethodName);
				assertTrue(
						type(selenium, lnkNoteComment, chargeEntryData.Comment),
						"Not able to type Comment", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, lnkNoteSave),
						"Not able to click Save", selenium, ClassName,
						MethodName);
				assertTrue(isElementPresent(selenium, lnkNoteCancel),
						"Hide Comment Link not present", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, lnkNoteEdit),
						"Not able to click Note in service line", selenium,
						ClassName, MethodName);
				assertTrue(
						type(selenium, lnkNoteComment, chargeEntryData.Comment1),
						"Not able to type Comment", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, lnkNoteSave),
						"Not able to click Save", selenium, ClassName,
						MethodName);
				assertTrue(
						selenium.getText(lnkNoteComment).contains(
								chargeEntryData.Comment1),
						"Didnt Save the Comment Properly", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, lnkNoteViewHistory),
						"Not able to click View History", selenium, ClassName,
						MethodName);
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat(
						"MMM dd, yyyy");
				date = DateFormat.format(cal.getTime());
				Integer count = (Integer) selenium
						.getXpathCount(lblNoteHistoryCount);
				for (int rowPos = 1; rowPos <= count; rowPos++) {
					assertTrue(
							selenium.getText(
									String.format(lblNoteHistory, rowPos)
											.trim()).contains(onBehalfOf),
							"User name incorrect in history", selenium,
							ClassName, MethodName);
					assertTrue(
							selenium.getText(
									String.format(lblNoteHistory, rowPos)
											.trim()).contains(date),
							"incorrect Date", selenium, ClassName, MethodName);
				}

			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
