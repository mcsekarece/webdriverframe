package com.nexia.selenium.testscripts.section.billing.adminstatement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySetupWizardStatementCycle extends AbstractBilling {
    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for verifying statement cycle")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifySetupWizardStatementCycle(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib billingData = new BillingLib();
	billingData.workSheetName = "AdminStatements";
	billingData.testCaseId = "TC_AS_001";
	billingData.fetchBillingTestData();
	verifyStatementCycle(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }
    

    /**
     * verifyStatementCycle function to Verify statement cycle
     * @param seleniumHost
     * @param seleniumPort
     * @param browser
     * @param webSite
     * @throwsIOException
     * @since Apr 11, 2014
     */

    public boolean verifyStatementCycle(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, BillingLib billingData)
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
	    // Step-3: Navigate to statement Cycle //
	    // --------------------------------------------------------------------//
	    
	    assertTrue(navigateToStatementCycle(selenium), "Navigation Failed", selenium, ClassName, MethodName);
	   
	    // --------------------------------------------------------------------//
	    // Step-3: Verify statement cycle home screen
	    // --------------------------------------------------------------------//

	    assertTrue(verifyStatementHomeScreen(selenium), "verification Failed", selenium, ClassName, MethodName);
	    
	    // --------------------------------------------------------------------//
	    // Step-4: Verify Delete statement cycle
	    // --------------------------------------------------------------------//
	    
	    assertTrue(deleteAllStatementCycle(selenium), "Deletion Failed", selenium, ClassName, MethodName);

	    // --------------------------------------------------------------------//
	    // Step-5: Verify statement cycle add screen
	    // --------------------------------------------------------------------//
	   
	    assertTrue(verifyStatementAddWizard(selenium,billingData), "Addition Failed", selenium, ClassName, MethodName);
	    
	    // --------------------------------------------------------------------//
	    // Step-6: Verify statement cycle Edit screen
	    // --------------------------------------------------------------------//
	   
	    assertTrue(verifyEditStatementCycle(selenium,billingData), "Edit Failed", selenium, ClassName, MethodName);
	     
	    // --------------------------------------------------------------------//
	    // Step-7: Verify pop up and overlap alert
	    // --------------------------------------------------------------------//
	    
	    assertTrue(verifyOverlapInStatementCycle(selenium,billingData), "Checking Failed", selenium, ClassName, MethodName);
	    
	    // --------------------------------------------------------------------//
	    // Step-8: Verify cancel
	    // --------------------------------------------------------------------//
	   
	    assertTrue(verifyCancel(selenium,billingData), "Cancellation Failed", selenium, ClassName, MethodName);
	    
	    // --------------------------------------------------------------------//
	    // Step-9: Verify cancel
	    // --------------------------------------------------------------------//
	    assertTrue(deleteAllStatementCycle(selenium), "Deletion Failed", selenium, ClassName, MethodName);
	    
	    // --------------------------------------------------------------------//
	    // Step-10: Verify navigation to next circle
	    // --------------------------------------------------------------------//
	    
	    assertTrue(click(selenium, btnWizardNext), "Wizard Next button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(isElementPresent(selenium, ajxBadDept), "Navigation failed", selenium, ClassName, MethodName);
	    
	} catch (RuntimeException e) {
	    e.printStackTrace();
	    assertTrue(false, "Failed Due to the Exception; \n\t*) ExceptionDetails :" + e.getMessage() + "\n\t*)", selenium, ClassName, MethodName);
	}
	return returnValue;
    }
}
