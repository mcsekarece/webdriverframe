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

public class VerifyStatementPreferencesFormat extends AbstractBilling {
	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyStatementPreferencesFormat(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib statementPreferencesData = new BillingLib();
		statementPreferencesData.workSheetName = "StatementPreferences";
		statementPreferencesData.testCaseId = "TC_SP_005";
		statementPreferencesData.fetchBillingTestData();
		verifyStatementPreferencesFormat(seleniumHost, seleniumPort, browser,
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

	public boolean verifyStatementPreferencesFormat(String seleniumHost,
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
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnEditStatePre),
					"Edit not clicked ", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
						
			if (statementPreferencesData.testCaseId.equals("TC_SP_005")){
				
				assertTrue(click(selenium, btnWizardNext1),
						"Include Inactive is not Checked", selenium, ClassName,	MethodName);
				assertTrue(isElementPresent(selenium, btnWizardNext),
						"Wizard Next button is not present", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, btnWizardDone),
						"Wizard Done button is not present", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, btnWizardBack),
						"Wizard Next button is not present", selenium,
						ClassName, MethodName);
				
				
			}
				
			return returnValue;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
