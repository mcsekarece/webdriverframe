package com.nexia.selenium.testscripts.section.billing.adminstatement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStatementSetupWizardDunningMessages extends AbstractBilling {
    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for verifying dunning messages wizard")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifySetupWizardStatementCycle(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib billingData = new BillingLib();
	billingData.workSheetName = "AdminStatements";
	billingData.testCaseId = "TC_AS_001";
	billingData.fetchBillingTestData();
	verifyDunningMessageWizard(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }
    
    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for verifying dunning messages wizard")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyDunningMessageBadDeptCollection1(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib billingData = new BillingLib();
	billingData.workSheetName = "AdminStatements";
	billingData.testCaseId = "TC_AS_003";
	billingData.fetchBillingTestData();
	verifyDunningMessageWizard(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }
    
    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for verifying dunning messages wizard")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyDunningMessageBadDeptCollection2(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib billingData = new BillingLib();
	billingData.workSheetName = "AdminStatements";
	billingData.testCaseId = "TC_AS_004";
	billingData.fetchBillingTestData();
	verifyDunningMessageWizard(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }
    
    

    /**
     * verifyDunningMessageWizard function to Verify dunning message wizard
     * @param seleniumHost
     * @param seleniumPort
     * @param browser
     * @param webSite
     * @throwsIOException
     * @since Apr 11, 2014
     */

    public boolean verifyDunningMessageWizard(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, BillingLib billingData)
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

	    assertTrue(navigateToDunningMessage(selenium), "Navigation Failed", selenium, ClassName, MethodName);

	    // --------------------------------------------------------------------//
	    // Step-3: Verify Dunning home screen
	    // --------------------------------------------------------------------//

	    assertTrue(verifyStatementHomeScreen(selenium), "verification Failed", selenium, ClassName, MethodName);

	    // --------------------------------------------------------------------//
	    // Step-5: Verify statement cycle add screen
	    // --------------------------------------------------------------------//
	    if(billingData.testCaseId.equals("TC_AS_001"))
	    	assertTrue(verifyDunningWizard(selenium), "Addition Failed", selenium, ClassName, MethodName);
	    else
	    	assertTrue(verifyDunningMessageBadDeptCollection(selenium,billingData), "Addition Failed", selenium, ClassName, MethodName);
	    


	} catch (RuntimeException e) {
	    e.printStackTrace();
	    assertTrue(false, "Failed Due to the Exception; \n\t*) ExceptionDetails :" + e.getMessage() + "\n\t*)", selenium, ClassName, MethodName);
	}
	return returnValue;
    }
    
    /**
     * verifyDunningMessageBadDeptCollection function to verify statement BadDept and Collection
     * @since Apr 15, 2014
     */
    public boolean verifyDunningMessageBadDeptCollection(Selenium selenium, BillingLib billingData) {
	boolean returnValue = true;
	try {
		   if(billingData.testCaseId.equals("TC_AS_003")){
		 assertTrue(selectValueFromAjaxList(selenium, ajxBadDept, "02"), "Could not select bad dept", selenium, ClassName, MethodName);
		 assertTrue(selectValueFromAjaxList(selenium, ajxCollection, "03"), "Could not select collection", selenium, ClassName, MethodName);

	    
	    assertTrue(click(selenium, btnWizardDone), "Wizard Done button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(isElementPresent(selenium, btnEdit), "Could not find collection", selenium, ClassName, MethodName);
		   }
		   else
		   { assertTrue(selectValueFromAjaxList(selenium, ajxBadDept, "02"), "Could not select bad dept", selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium, ajxCollection, "01"), "Could not select collection", selenium, ClassName, MethodName);

			    
			    assertTrue(click(selenium, btnWizardDone), "Wizard Done button is not present", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    selenium.isTextPresent("This dunning number must be higher than the bad debt dunning number.");
			   
		   }
	    
	    return returnValue;
	} catch (Exception e) {
	    e.printStackTrace();
	    returnValue = false;
	}
	return returnValue;
    }
    
    
}
