package com.nexia.selenium.testscripts.section.billing.adminstatement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStatementSetupWizardWorkFlow extends AbstractBilling {
    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for verifying statement setup wizard workflow")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifysetupWizardWorkFlow(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib billingData = new BillingLib();
	billingData.workSheetName = "AdminStatements";
	billingData.testCaseId = "TC_AS_001";
	billingData.fetchBillingTestData();
	verifySetupWizardWorkFlow(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }

    /**
     * verifySetupWizardWorkFlow function to verify statement setup wizard
     * @param seleniumHost
     * @param seleniumPort
     * @param browser
     * @param webSite
     * @throwsIOException
     * @since Apr 10, 2014
     */

    public boolean verifySetupWizardWorkFlow(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, BillingLib billingData)
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
	    // Step-2: Go to Statement Preferences                                 
	    // --------------------------------------------------------------------//

	    assertTrue(goToStatementPreferences(selenium), "Navigation Failed", selenium, ClassName, MethodName);

	    // --------------------------------------------------------------------//
	    // Step-3: Verify setup work flow                                       
	    // --------------------------------------------------------------------//

	    if (!isElementPresent(selenium, btnEdit)) {
		assertTrue(click(selenium, btnDeactivateAutoGen), "Could not find Activate button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent("Auto generation of statements is currently activated"), "Default screen is incorrect", selenium, ClassName,
			MethodName);
	    }
	    assertTrue(click(selenium, btnEdit), "Could not find edit button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    assertTrue(selenium.isTextPresent("Statement Preferences Wizard"), "Default screen is incorrect", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, btnNextWizard), "Could not find next button", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, btnWizardDone), "Could not find done button", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, btnCircleMetaInfo), "Could not find Circle MetaInfo", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, btnCircleFormat), "Could not find Circle Format", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, btnCircleStatementCycle), "Could not find Circle Statement Cycle", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, btnCircleDunningMessages), "Could not find Circle Dunning Messages", selenium, ClassName, MethodName);

	    assertTrue(selenium.isTextPresent("Include patients who are"), "Default screen is incorrect", selenium, ClassName,
			MethodName);
	    
	} catch (RuntimeException e) {
	    e.printStackTrace();
	    assertTrue(false, "Failed Due to the Exception; \n\t*) ExceptionDetails :" + e.getMessage() + "\n\t*)", selenium, ClassName, MethodName);
	}
	return returnValue;
    }
}
