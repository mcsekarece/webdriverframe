package com.nexia.selenium.testscripts.section.billing.adminstatement;

import java.io.IOException;

import org.openqa.selenium.internal.seleniumemulation.IsTextPresent;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStatementSetupWizardSummaryPage extends AbstractBilling {
    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for verifying setup wizard meta information")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifysetupWizardSummary(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib billingData = new BillingLib();
	billingData.workSheetName = "AdminStatements";
	billingData.testCaseId = "TC_AS_001";
	billingData.fetchBillingTestData();
	verifyMetaInformation(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }

    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for verifying default values for meta information")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyEditButton(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount)
	    throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib billingData = new BillingLib();
	billingData.workSheetName = "AdminStatements";
	billingData.testCaseId = "TC_AS_002";
	billingData.fetchBillingTestData();
	verifyMetaInformation(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }
    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for verifying setup wizard meta information")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifysetupWizardDoneButton(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib billingData = new BillingLib();
	billingData.workSheetName = "AdminStatements";
	billingData.testCaseId = "TC_AS_003";
	billingData.fetchBillingTestData();
	verifyMetaInformation(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }

    /**
     * verifyMetaInformation function to verify statement setup wizard meta
     * information
     * 
     * @param seleniumHost
     * @param seleniumPort
     * @param browser
     * @param webSite
     * @throwsIOException
     * @since Apr 10, 2014
     */

    public boolean verifyMetaInformation(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, BillingLib billingData)
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
	    // Step-3: Navigate to Meta Information
	    // --------------------------------------------------------------------//

	    if (!isElementPresent(selenium, btnEdit)) {
		assertTrue(click(selenium, btnDeactivateAutoGen), "Could not find Activate button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent("Auto generation of statements is currently activated"), "Default screen is incorrect", selenium, ClassName,
			MethodName);
	    }
	    assertTrue(click(selenium, btnEdit), "Could not find edit button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    // --------------------------------------------------------------------//
	    // Step-4: Verify Meta Information
	    // --------------------------------------------------------------------//
	    if (billingData.testCaseId.equals("TC_AS_002")) {
	    	 assertTrue(selenium.isVisible(chkIncludeInactiveSP), "Meta Information Page not opened", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);waitForPageLoad(selenium);
	    }
	    if (billingData.testCaseId.equals("TC_AS_001")) {
	    	
	    	 assertTrue(type(selenium, txtWaitDays, "30"), "Could not type wait days", selenium, ClassName, MethodName);
	    	 assertTrue(click(selenium, btnWizardDone), "Could not click Done button", selenium, ClassName, MethodName);
	    	 waitForPageLoad(selenium);
	    	 assertTrue(selenium.isTextPresent("30"), "Validation faild in Summary page", selenium, ClassName, MethodName);
	    	 assertTrue(selenium.isTextPresent("Auto generation of statements is currently activated"), "Validation faild in Summary page", selenium, ClassName, MethodName);
	    	 assertTrue(click(selenium, btnEdit), "Could not find edit button", selenium, ClassName, MethodName);
	    	 waitForPageLoad(selenium);
	    	 assertTrue(type(selenium, txtWaitDays, "28"), "Could not type wait days", selenium, ClassName, MethodName);
	    	 assertTrue(click(selenium, btnWizardDone), "Could not click Done button", selenium, ClassName, MethodName);
	    	 
	    	 waitForPageLoad(selenium);
	    	 
			 
		}
	    if (billingData.testCaseId.equals("TC_AS_003")) {
	    	 // --------------------------------------------------------------------//
	 	    // clicking Done button from Meta-Information
	 	    // --------------------------------------------------------------------//
	    	 assertTrue(click(selenium, btnWizardDone), "Could not click Done button", selenium, ClassName, MethodName);
	    	 waitForPageLoad(selenium);
	    	 assertTrue(selenium.isTextPresent("Auto generation of statements is currently activated"), "Could not navigate to Summary page", selenium, ClassName, MethodName);
	    	 // --------------------------------------------------------------------//
	 	    // clicking Done button from Dunning Messages
	 	    // --------------------------------------------------------------------//
	    	 assertTrue(click(selenium, btnEdit), "Could not find edit button", selenium, ClassName, MethodName);
	    	 waitForPageLoad(selenium);
	    	 assertTrue(click(selenium, btnCircleDunningMessages), "Could not click Done button", selenium, ClassName, MethodName);
	    	 waitForPageLoad(selenium);
	    	 assertTrue(click(selenium, btnWizardDone), "Could not click Done button", selenium, ClassName, MethodName);
	    	 waitForPageLoad(selenium);
	    	 assertTrue(selenium.isTextPresent("Auto generation of statements is currently activated"), "Could not navigate to Summary page", selenium, ClassName, MethodName);
	    	 // --------------------------------------------------------------------//
	 	    // clicking Done button from Format
	 	    // --------------------------------------------------------------------//
	    	 assertTrue(click(selenium, btnEdit), "Could not find edit button", selenium, ClassName, MethodName);
	    	 waitForPageLoad(selenium);
	    	 assertTrue(click(selenium, btnCircleFormat), "Could not click Done button", selenium, ClassName, MethodName);
	    	 waitForPageLoad(selenium);
	    	 assertTrue(click(selenium, btnWizardDone), "Could not click Done button", selenium, ClassName, MethodName);
	    	 waitForPageLoad(selenium);
	    	 assertTrue(selenium.isTextPresent("Auto generation of statements is currently activated"), "Could not navigate to Summary page", selenium, ClassName, MethodName);
	    	 // --------------------------------------------------------------------//
	 	    // clicking Done button from Statement Cycle
	 	    // --------------------------------------------------------------------//
	    	 assertTrue(click(selenium, btnEdit), "Could not find edit button", selenium, ClassName, MethodName);
	    	 waitForPageLoad(selenium);
	    	 assertTrue(click(selenium, btnCircleStatementCycle), "Could not click Done button", selenium, ClassName, MethodName);
	    	 waitForPageLoad(selenium);
	    	 assertTrue(click(selenium, btnWizardDone), "Could not click Done button", selenium, ClassName, MethodName);
	    	 waitForPageLoad(selenium);
	    	 assertTrue(selenium.isTextPresent("Auto generation of statements is currently activated"), "Could not navigate to Summary page", selenium, ClassName, MethodName);
	    	 
			 
		}


	} catch (RuntimeException e) {
	    e.printStackTrace();
	    assertTrue(false, "Failed Due to the Exception; \n\t*) ExceptionDetails :" + e.getMessage() + "\n\t*)", selenium, ClassName, MethodName);
	}
	return returnValue;
    }
}
