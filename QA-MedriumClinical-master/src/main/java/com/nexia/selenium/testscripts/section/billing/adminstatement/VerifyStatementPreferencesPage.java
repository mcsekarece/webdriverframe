package com.nexia.selenium.testscripts.section.billing.adminstatement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStatementPreferencesPage extends AbstractBilling {
    @Test(groups = { "AdvancedSmoke","Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for verifying statement preference page")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyStatementPreference(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "AdminStatements";
		billingData.testCaseId = "TC_AS_001";
		billingData.fetchBillingTestData();
		verifyStatementPreference(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }

    /**
     * verifyStatementPreference function to Verify statement preference
     * @param seleniumHost
     * @param seleniumPort
     * @param browser
     * @param webSite
     * @throwsIOException
     * @since Apr 10, 2014
     */

    public boolean verifyStatementPreference(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, BillingLib billingData)
	    throws IOException {
	Selenium selenium = null;
	boolean returnValue = true;
	try {
	    // --------------------------------------------------------------------//
	    // Step-1: Login to the application
	    // --------------------------------------------------------------------//
	    selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
	    Assert.assertNotNull(selenium, "Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
	    assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword), "Login Failed ", selenium,
		    ClassName, MethodName);

	    // --------------------------------------------------------------------//
	    // Step-2: Go to Statement Preferences //
	    // --------------------------------------------------------------------//

	    assertTrue(goToStatementPreferences(selenium), "Navigation Failed", selenium, ClassName, MethodName);

	    // --------------------------------------------------------------------//
	    // Step-3: Verify Default screen //
	    // --------------------------------------------------------------------//

	    if (!isElementPresent(selenium, btnEdit)) {
		assertTrue(click(selenium, btnActivateAutoGen), "Could not find Activate button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium, btnDoneServiceCode)){
			assertTrue(click(selenium, btnDoneServiceCode), "Could not find Activate button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		assertTrue(click(selenium, btnDeactivateAutoGen), "Could not find Activate button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(!selenium.isTextPresent("Auto generation of statements is currently activated"), "Default screen is incorrect", selenium, ClassName,
			MethodName);
		assertTrue(click(selenium, btnActivateAutoGen), "Could not find Activate button", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
	    }
	    assertTrue(selenium.isTextPresent("Auto generation of statements is currently activated"), "Default screen is incorrect", selenium, ClassName,
		    MethodName);

	} catch (RuntimeException e) {
	    e.printStackTrace();
	    assertTrue(false, "Failed Due to the Exception; \n\t*) ExceptionDetails :" + e.getMessage() + "\n\t*)", selenium, ClassName, MethodName);
	}
	return returnValue;
    }
}
