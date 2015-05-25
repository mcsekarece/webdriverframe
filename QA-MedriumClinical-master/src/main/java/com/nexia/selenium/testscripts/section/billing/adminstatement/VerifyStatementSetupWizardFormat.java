package com.nexia.selenium.testscripts.section.billing.adminstatement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStatementSetupWizardFormat extends AbstractBilling {
    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for verifying statement preference format")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyStatementFormat(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib billingData = new BillingLib();
	billingData.workSheetName = "AdminStatements";
	billingData.testCaseId = "TC_AS_001";
	billingData.fetchBillingTestData();
	verifyStatementformat(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }

    /**
     * verifyStatementformat function to Verify statement format
     * 
     * @param seleniumHost
     * @param seleniumPort
     * @param browser
     * @param webSite
     * @throwsIOException
     * @since Apr 10, 2014
     */

    public boolean verifyStatementformat(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, BillingLib billingData)
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
	    // Step-3: Navigate to statement Format //
	    // --------------------------------------------------------------------//

	    if (!isElementPresent(selenium, btnEdit)) {
		assertTrue(click(selenium, btnDeactivateAutoGen), "Could not find Activate button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	    }

	    assertTrue(click(selenium, btnEdit), "Could not find edit button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    assertTrue(click(selenium, btnCircleFormat), "Could not click format circle", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    // --------------------------------------------------------------------//
	    // Step-4: Verify statement Format
	    // --------------------------------------------------------------------//

	    assertTrue(selenium.isTextPresent("Select fields you would like to include in all statements"), "Could not navigate to format circle", selenium,
		    ClassName, MethodName);
	    waitForPageLoad(selenium);

	    assertTrue(isElementPresent(selenium, btnWizardNext), "Wizard Next button is not present", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, btnWizardDone), "Wizard Done button is not present", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, btnWizardBack), "Wizard Back button is not present", selenium, ClassName, MethodName);

	    assertTrue(selenium.isTextPresent("Which charges would you like to show?"), "Could not find text", selenium, ClassName, MethodName);
	    assertTrue(selenium.isTextPresent("What would you like to show for each charge?"), "Could not find text", selenium, ClassName, MethodName);
	    assertTrue(selenium.isTextPresent("Which credit cards do you accept?"), "Could not find text", selenium, ClassName, MethodName);
	    assertTrue(selenium.isTextPresent("General statement message:"), "Could not find text", selenium, ClassName, MethodName);

	    assertTrue(isElementPresent(selenium, btnWizardNext), "Could not find all open radio button", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, btnWizardDone), "Could not find new charges radio button", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, rdoAllCharges), "Could not find All  Patient Charges radio button", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, rdoNewPatientCharges), "Could not find New Patient Charges radio button", selenium, ClassName, MethodName);

	    assertTrue(isElementPresent(selenium, chkPending), "Could not find Pending Check box", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, chkZero), "Could not find zero check box", selenium, ClassName, MethodName);

	    assertTrue(isChecked(selenium, chkPayment), "Could not find payment Check box", selenium, ClassName, MethodName);
	    assertTrue(isChecked(selenium, chkAdjustmentBox), "Could not find adjustment check box", selenium, ClassName, MethodName);
	    assertTrue(isChecked(selenium, chkServiceCodeBox), "Could not find service code Check box", selenium, ClassName, MethodName);
	    assertTrue(!isChecked(selenium, chkServiceCodeDesc), "Could not find service code description check box", selenium, ClassName, MethodName);

	    assertTrue(!isChecked(selenium, chkMaster), "Could not find master card Check box", selenium, ClassName, MethodName);
	    assertTrue(!isChecked(selenium, chkDiscover), "Could not find Discover check box", selenium, ClassName, MethodName);
	    assertTrue(!isChecked(selenium, chkVisa), "Could not find visa  Check box", selenium, ClassName, MethodName);
	    assertTrue(!isChecked(selenium, chkAmerExpress), "Could not find american express check box", selenium, ClassName, MethodName);

	    // --------------------------------------------------------------------//
	    // Step-5: Verify Save statement Format
	    // --------------------------------------------------------------------//

	    if (!isChecked(selenium, chkPending)) {
		assertTrue(click(selenium, chkPending), "Could not find pending Check box", selenium, ClassName, MethodName);
	    }

	    if (!isChecked(selenium, chkZero)) {
		assertTrue(click(selenium, chkZero), "Could not find zero Check box", selenium, ClassName, MethodName);
	    }

	    if (!isChecked(selenium, chkPayment)) {
		assertTrue(click(selenium, chkPayment), "Could not find payment Check box", selenium, ClassName, MethodName);
	    }
	    if (!isChecked(selenium, chkAdjustmentBox)) {
		assertTrue(click(selenium, chkAdjustmentBox), "Could not find adjustment Check box", selenium, ClassName, MethodName);
	    }
	    if (!isChecked(selenium, chkServiceCodeBox)) {
		assertTrue(click(selenium, chkServiceCodeBox), "Could not find service code Check box", selenium, ClassName, MethodName);
	    }
	    if (!isChecked(selenium, chkServiceCodeDesc)) {
		assertTrue(click(selenium, chkServiceCodeDesc), "Could not find service code desc Check box", selenium, ClassName, MethodName);
	    }

	    if (!isChecked(selenium, chkMaster)) {
		assertTrue(click(selenium, chkMaster), "Could not find master card Check box", selenium, ClassName, MethodName);
	    }
	    if (!isChecked(selenium, chkDiscover)) {
		assertTrue(click(selenium, chkDiscover), "Could not find discover Check box", selenium, ClassName, MethodName);
	    }
	    if (!isChecked(selenium, chkVisa)) {
		assertTrue(click(selenium, chkVisa), "Could not find service visa Check box", selenium, ClassName, MethodName);
	    }
	    if (!isChecked(selenium, chkAmerExpress)) {
		assertTrue(click(selenium, chkAmerExpress), "Could not find american experess Check box", selenium, ClassName, MethodName);
	    }

	    assertTrue(click(selenium, btnWizardNext), "Wizard Next button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    assertTrue(click(selenium, btnWizardBack), "Wizard Next button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(isElementPresent(selenium, btnPreview), "Wizard Next button is not present", selenium, ClassName, MethodName);    

	} catch (RuntimeException e) {
	    e.printStackTrace();
	    assertTrue(false, "Failed Due to the Exception; \n\t*) ExceptionDetails :" + e.getMessage() + "\n\t*)", selenium, ClassName, MethodName);
	}
	return returnValue;
    }
}
