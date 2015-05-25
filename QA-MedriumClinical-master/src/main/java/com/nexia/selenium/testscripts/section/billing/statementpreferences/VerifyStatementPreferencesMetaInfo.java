package com.nexia.selenium.testscripts.section.billing.statementpreferences;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.internal.seleniumemulation.IsTextPresent;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingUnitTestLib;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStatementPreferencesMetaInfo extends AbstractBilling {
//	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
//			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Test(enabled=false)
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyStatementPreferencesMetaInfo(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib statementPreferencesData = new BillingLib();
		statementPreferencesData.workSheetName = "StatementPreferences";
		statementPreferencesData.testCaseId = "TC_SP_001";
		statementPreferencesData.fetchBillingTestData();
		verifyStatementPreferencesMetaInfo(seleniumHost, seleniumPort, browser,
				webSite, userAccount, statementPreferencesData);
	}

//	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
//			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Test(enabled=false)
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyStatementPreferencesMetaInfoChkBox(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib statementPreferencesData = new BillingLib();
		statementPreferencesData.workSheetName = "StatementPreferences";
		statementPreferencesData.testCaseId = "TC_SP_002";
		statementPreferencesData.fetchBillingTestData();
		verifyStatementPreferencesMetaInfo(seleniumHost, seleniumPort, browser,
				webSite, userAccount, statementPreferencesData);
	}

//	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
//			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Test(enabled=false)
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyStatementPreferencesMetaInfoNumFields(
			String seleniumHost, int seleniumPort, String browser,
			String webSite, String userAccount) throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib statementPreferencesData = new BillingLib();
		statementPreferencesData.workSheetName = "StatementPreferences";
		statementPreferencesData.testCaseId = "TC_SP_003";
		statementPreferencesData.fetchBillingTestData();
		verifyStatementPreferencesMetaInfo(seleniumHost, seleniumPort, browser,
				webSite, userAccount, statementPreferencesData);
	}

//	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
//			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Test(enabled=false)
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyStatementPreferencesMetaInfoNext(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib statementPreferencesData = new BillingLib();
		statementPreferencesData.workSheetName = "StatementPreferences";
		statementPreferencesData.testCaseId = "TC_SP_004";
		statementPreferencesData.fetchBillingTestData();
		verifyStatementPreferencesMetaInfo(seleniumHost, seleniumPort, browser,
				webSite, userAccount, statementPreferencesData);
	}

	/**
	 * verifyStatementPreferencesPage function verifies Statement Preferences
	 * Page
	 * 
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @throws IOException
	 * 
	 * @since Jan 23, 2014
	 */

	public boolean verifyStatementPreferencesMetaInfo(String seleniumHost,
			int seleniumPort, String browser, String webSite,
			String userAccount, BillingLib statementPreferencesData)
			throws IOException {
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
							+ statementPreferencesData.toString());

			assertTrue(
					loginForNexiaFromProviderSite(selenium, userAccount,
							statementPreferencesData.userName,
							statementPreferencesData.userPassword),
					"Login Failed ", selenium, ClassName, MethodName);

			waitForPageLoad(selenium);

			assertTrue(
					switchRole(selenium, statementPreferencesData.switchRole),
					"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-2: Go to Statement preferences
			// --------------------------------------------------------------------//
			assertTrue(goToStatmentPreferences(selenium),
					"Statement Preferences Navigation Failed", selenium,
					ClassName, MethodName);
			if (statementPreferencesData.testCaseId.equals("TC_SP_001")) {
				assertTrue(click(selenium, btnEditStatePre),
						"Edit not clicked ", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium, chkIncludeInactiveSP),
						"Include Inactive Check Box is not present", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, chkInCollection),
						"In Collection check box is not present", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, chkIncludeDeceased),
						"Include Deceased is not present", selenium, ClassName,
						MethodName);
				assertTrue(!isChecked(selenium, chkIncludeInactiveSP),
						"Include Inactive is already Checked", selenium,
						ClassName, MethodName);
				assertTrue(!isChecked(selenium, chkInCollection),
						"In Collection is already Checked", selenium,
						ClassName, MethodName);
				assertTrue(!isChecked(selenium, chkIncludeDeceased),
						"Include Deceased is already Checked", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, chkSendStmtAftFullPay),
						"Include Inactive Check Box is not present", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, chkShowChrgPaid),
						"In Collection check box is not present", selenium,
						ClassName, MethodName);
				assertTrue(isChecked(selenium, chkSendStmtAftFullPay),
						"Include Inactive is already Checked", selenium,
						ClassName, MethodName);
				assertTrue(isChecked(selenium, chkShowChrgPaid),
						"Include Inactive is already Checked", selenium,
						ClassName, MethodName);
				assertTrue(
						getText(selenium, lblWaitDays)
								.contains("Wait at least"),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						getText(selenium, lblWaitDays)
								.contains(
										"days before sending a patient the next statement"),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, txtWaitDays),
						"Wait Days text box not present", selenium, ClassName,
						MethodName);
				//assertTrue(getText(selenium, txtWaitDays).contains("28"),"Wait Days text  not present properly", selenium,ClassName, MethodName);
				assertTrue(isElementPresent(selenium, txtMinPayment),
						"Include Inactive Check Box is not present", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, txtBalanceAtLeast),
						"In Collection check box is not present", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, txtWriteOffBalance),
						"Include Deceased is not present", selenium, ClassName,
						MethodName);
				assertTrue(isElementPresent(selenium, lstAdjustmentCode),
						"Include Deceased is not present", selenium, ClassName,
						MethodName);
				assertTrue(
						getText(selenium, lblMinimumPayment)
								.contains(
										"Minimum payment due in order to decrease the dunning level"),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						getText(selenium, lblBalanceAtLeast)
								.contains(
										"Do not send patient a statement until their balance is at least"),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						getText(selenium, lblWriteOffBalance).contains(
								"Write-off patient balances below"),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						getText(selenium, lblWriteOffBalance).contains(
								"using an adjustment code of"),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(getText(selenium, txtMinPayment).contains("0.00"),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(getText(selenium, txtBalanceAtLeast)
						.contains("5.00"),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						getText(selenium, txtWriteOffBalance).contains("0.00"),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);

			} else if (statementPreferencesData.testCaseId.equals("TC_SP_002")) {
				
				assertTrue(click(selenium, btnEditStatePre),
						"Edit not clicked ", selenium, ClassName,
						MethodName);
				assertTrue(check(selenium, chkIncludeInactiveSP),
						"Include Inactive is already Checked", selenium,
						ClassName, MethodName);
				assertTrue(check(selenium, chkInCollection),
						"In Collection is already Checked", selenium,
						ClassName, MethodName);
				assertTrue(check(selenium, chkIncludeDeceased),
						"Include Deceased is already Checked", selenium,
						ClassName, MethodName);
				assertTrue(check(selenium, chkSendStmtAftFullPay),
						"Include Inactive is already Checked", selenium,
						ClassName, MethodName);
				assertTrue(check(selenium, chkShowChrgPaid),
						"Include Inactive is already Checked", selenium,
						ClassName, MethodName);
				assertTrue(!isChecked(selenium, chkIncludeInactiveSP),
						"Include Inactive is not Checked", selenium, ClassName,
						MethodName);
				assertTrue(!isChecked(selenium, chkInCollection),
						"In Collection is not Checked", selenium, ClassName,
						MethodName);
				assertTrue(!isChecked(selenium, chkIncludeDeceased),
						"Include Deceased is not Checked", selenium, ClassName,
						MethodName);
				assertTrue(isChecked(selenium, chkSendStmtAftFullPay),
						"Include Inactive is not Checked", selenium, ClassName,
						MethodName);
				assertTrue(isChecked(selenium, chkShowChrgPaid),
						"Include Inactive is not Checked", selenium, ClassName,
						MethodName);
			} else if (statementPreferencesData.testCaseId.equals("TC_SP_003")) {
				assertTrue(click(selenium, btnEditStatePre),
						"Edit not clicked ", selenium, ClassName,
						MethodName);
				assertTrue(type(selenium, txtMinPayment, "5"),
						"Include Inactive is not Checked", selenium, ClassName,
						MethodName);				
				assertTrue(type(selenium, txtBalanceAtLeast, "50"),
						"Include Inactive is not Checked", selenium, ClassName,
						MethodName);
				assertTrue(type(selenium, txtWriteOffBalance, "5"),
						"Include Inactive is not Checked", selenium, ClassName,
						MethodName);
				assertTrue(getText(selenium, txtMinPayment).contains("5"),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(getText(selenium, txtBalanceAtLeast)
						.contains("50.00"),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						getText(selenium, txtWriteOffBalance).contains("5.00"),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
			}
			else if (statementPreferencesData.testCaseId.equals("TC_SP_004")){
				assertTrue(click(selenium, btnEditStatePre),
						"Edit not clicked ", selenium, ClassName,
						MethodName);
				assertTrue(type(selenium, txtMinPayment,statementPreferencesData.minPayment ),
						"Include Inactive is not Checked", selenium, ClassName,
						MethodName);
				assertTrue(check(selenium, chkIncludeDeceased),
						"Include Deceased is not Checked", selenium, ClassName,
						MethodName);
				assertTrue(check(selenium, chkSendStmtAftFullPay),
						"Include Inactive is not Checked", selenium, ClassName,
						MethodName);
				assertTrue(check(selenium, chkShowChrgPaid),
						"Include Inactive is not Checked", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, btnWizardNext1),
						"Include Inactive is not Checked", selenium, ClassName,
						MethodName);
				/*assertTrue(click(selenium, btnWizardBack1),
						"Include Inactive is not Checked", selenium, ClassName,
						MethodName);*/
				assertTrue(isChecked(selenium, chkIncludeDeceased),
						"Include Deceased is not Checked", selenium, ClassName,
						MethodName);
				assertTrue(isChecked(selenium, chkSendStmtAftFullPay),
						"Include Inactive is not Checked", selenium, ClassName,
						MethodName);
				assertTrue(isChecked(selenium, chkShowChrgPaid),
						"Include Inactive is not Checked", selenium, ClassName,
						MethodName);
				assertTrue(getText(selenium, txtMinPayment).contains(statementPreferencesData.minPayment),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				
				
			}
				
			return returnValue;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
