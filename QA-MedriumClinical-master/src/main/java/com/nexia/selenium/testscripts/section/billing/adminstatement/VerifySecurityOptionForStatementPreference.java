package com.nexia.selenium.testscripts.section.billing.adminstatement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForStatementPreference extends AbstractBilling {

	
	
    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for View Only")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyViewOnly(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib billingData = new BillingLib();
	billingData.workSheetName = "VerifySecurityOption";
	billingData.testCaseId = "TC_VSP_002";
	billingData.fetchBillingTestData();
	verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }

    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for No Access Role")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyNoAccess(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib billingData = new BillingLib();
	billingData.workSheetName = "VerifySecurityOption";
	billingData.testCaseId = "TC_VSP_003";
	billingData.fetchBillingTestData();
	verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }

    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for Full Access role")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyFullAccess(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib billingData = new BillingLib();
	billingData.workSheetName = "VerifySecurityOption";
	billingData.testCaseId = "TC_VSP_004";
	billingData.fetchBillingTestData();
	verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }

    /**
     * verifySecurity function to verify security option for statement
     * preference
     * 
     * @param seleniumHost
     * @param seleniumPort
     * @param browser
     * @param webSite
     * @throws IOException
     * @since Apr 11, 2014
     */

    public boolean verifySecurity(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, BillingLib billingData)
	    throws IOException {
	Selenium selenium = null;
	boolean returnValue = true;
	try {
	    // --------------------------------------------------------------------//
	    // Step-1: Login to the application and search for the given patient
	    // //
	    // --------------------------------------------------------------------//
	    selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
	    Assert.assertNotNull(selenium, "Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
	    assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword), "Login Failed ", selenium,
		    ClassName, MethodName);

	    // --------------------------------------------------------------------//
	    // Step-2: change the switch role //
	    // --------------------------------------------------------------------//
	    assertTrue(switchRole(selenium, billingData.switchRole), "Could not change the switch role;More Details:" + billingData.toString(), selenium,
		    ClassName, MethodName);
	    waitForPageLoad(selenium);

	    // --------------------------------------------------------------------//
	    // Step-3: No Access User Role //
	    // --------------------------------------------------------------------//
	    if (billingData.testCaseId.equals("TC_VSP_003")) {
		assertTrue(!selenium.isTextPresent("No permission"), "No Permission Present", selenium, ClassName, MethodName);
		assertTrue(!selenium.isTextPresent("error"), " Error Message Present", selenium, ClassName, MethodName);
		assertTrue(searchPatientNexiaNoAccess(selenium, billingData.patientID), "Could search patient", selenium, ClassName, MethodName);
		return true;
	    }
	    // --------------------------------------------------------------------//
	    // Step-4: Visit the Allergy Link //
	    // --------------------------------------------------------------------//

	    if (!billingData.testCaseId.equals("TC_VSP_003")) {
		BillingLib billingData1 = new BillingLib();
		billingData1.workSheetName = "VerifySecurityOption";
		billingData1.testCaseId = "TC_VSP_004";
		billingData1.fetchBillingTestData();

		assertTrue(switchRole(selenium, billingData1.switchRole), "Could not change the switch role;More Details:" + billingData.toString(), selenium,
			ClassName, MethodName);
		waitForPageLoad(selenium);
		searchPatientNexiaForProviderHomePage(selenium, billingData.patientID);
		waitForPageLoad(selenium);

		assertTrue(click(selenium, lnkQuickAction), "Navigation Failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkBillingSettings), "could not click Billing Settings", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkFeeSchedule), "Could not click on fee schedule link:", selenium, ClassName, MethodName);

		assertTrue(!selenium.isTextPresent("No permission"), "Text Not Present", selenium, ClassName, MethodName);
		assertTrue(!selenium.isTextPresent("error"), "Text Not Present", selenium, ClassName, MethodName);

		BillingLib billingData2 = new BillingLib();
		billingData2.workSheetName = "FeeSchedule";
		billingData2.testCaseId = "TC_FS_001";
		billingData2.fetchBillingTestData();

		assertTrue(addFeeSchedule(selenium, billingData2, userAccount), "Creation Failed", selenium, ClassName, MethodName);

		assertTrue(switchRole(selenium, billingData.switchRole), "Could not change the switch role;More Details:" + billingData.toString(), selenium,
			ClassName, MethodName);
		waitForPageLoad(selenium);

	    }
	} catch (RuntimeException e) {
	    e.printStackTrace();
	    assertTrue(false, "Failed Due to the Exception; \n\t*) ExceptionDetails :" + e.getMessage() + "\n\t*)", selenium, ClassName, MethodName);
	}
	return returnValue;
    }
}
