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

public class VerifyStatementPreferences extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyStatementPreferencesPage(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib statementPreferencesData = new BillingLib();
		statementPreferencesData.workSheetName = "StatementPreferences";
		statementPreferencesData.testCaseId = "TC_SP_001";
		statementPreferencesData.fetchBillingTestData();
		verifyStatementPreferencesPage(seleniumHost, seleniumPort, browser,
				webSite, userAccount, statementPreferencesData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyStatementPreferencesEditPage(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib statementPreferencesData = new BillingLib();
		statementPreferencesData.workSheetName = "StatementPreferences";
		statementPreferencesData.testCaseId = "TC_SP_002";
		statementPreferencesData.fetchBillingTestData();
		verifyStatementPreferencesPage(seleniumHost, seleniumPort, browser,
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

	public boolean verifyStatementPreferencesPage(String seleniumHost,
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

				if(selenium.isElementPresent("Activate auto generation of statements"))
				{
				assertTrue(selenium.isTextPresent("Auto generation of statements is currently deactivated"),
						"Auto generation of statements is currently activated text not present",
						selenium, ClassName, MethodName);

				assertTrue(isElementPresent(selenium, btnActivateAutoGen),
						"Deactivate Auto Generation Code button is not present",
						selenium, ClassName, MethodName);
						
				}
				else
				{
					assertTrue(click(selenium, btnDeactivateAutoGen),
							"Edit not clicked ", selenium, ClassName,
							MethodName);
				}
									
				
			} 
			else if (statementPreferencesData.testCaseId.equals("TC_SP_002")) {
				if(isElementVisible(selenium, btnActivateAutoGen)){
				assertTrue(click(selenium, btnActivateAutoGen),
						"Edit not clicked ", selenium, ClassName,
						MethodName);
				}
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnEditStatePre),
						"Edit not clicked ", selenium, ClassName,
						MethodName);
				assertTrue(isElementPresent(selenium, btnWizardNext),
						"Wizard Next button is not present", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, btnWizardDone),
						"Wizard Done button is not present", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, lnkDotMetaInfo),
						"Wizard Next button is not present", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, lnkDotFormate),
						"Wizard Done button is not present", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, lnkDotStatementCycle),
						"Wizard Next button is not present", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, lnkDotDunningMsg),
						"Wizard Done button is not present", selenium,
						ClassName, MethodName);
			}
				
			return returnValue;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
