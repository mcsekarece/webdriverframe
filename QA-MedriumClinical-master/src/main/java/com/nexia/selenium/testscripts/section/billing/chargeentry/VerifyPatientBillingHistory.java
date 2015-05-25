package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPatientBillingHistory extends AbstractBilling {
    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for Verifying patient billing history")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void postChargeEntryMandatoryFields(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib chargeEntryData = new BillingLib();
	chargeEntryData.workSheetName = "ChargeEntry";
	chargeEntryData.testCaseId = "TC_CE_016";
	chargeEntryData.fetchBillingTestData();
	postChargeEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, chargeEntryData);
    }

    public boolean postChargeEntry(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, BillingLib chargeEntryData)
	    throws IOException {
	Selenium selenium = null;
	boolean returnValue = true;

	try {

	    // --------------------------------------------------------------------//
	    // Step-1: Login to the application and search for the given patient
	    // //
	    // --------------------------------------------------------------------//

	    selenium = getSession(seleniumHost, seleniumPort, browser, webSite);

	    Assert.assertNotNull(selenium, "Could Not Retrive the New Selenium Session; More Details :" + chargeEntryData.toString());

	    assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, chargeEntryData.userName, chargeEntryData.userPassword), "Login Failed ", selenium,
		    ClassName, MethodName);

	    waitForPageLoad(selenium);

	    assertTrue(switchRole(selenium, chargeEntryData.switchRole), "Switch Role Failed", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    // --------------------------------------------------------------------//
	    // Step-2: Go to Post New Charge
	    // --------------------------------------------------------------------//
	    navigateToPatient(selenium, chargeEntryData);
	    goToPostNewCharge(selenium, chargeEntryData);
	    
	    // --------------------------------------------------------------------//
	    // Step-3: Count the claims
	    // --------------------------------------------------------------------//
	    assertTrue(click(selenium, lnkPatientBillingHistory), "Could not present the Booking Appointment", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    String countClaims=getText(selenium,lblCountClaims);
	    String[] count=countClaims.split(" ");
	    int count1=Integer.parseInt((count[1]));
	    assertTrue(click(selenium, lnkClose), "Could not click close", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    savePostChargeEntry(selenium, chargeEntryData,userAccount);
	    assertTrue(isElementPresent(selenium, btnNexiaLogo), "Did not navigate to HomePage", selenium, ClassName, MethodName);
	    navigateToPatient(selenium, chargeEntryData);
	    goToPostNewCharge(selenium, chargeEntryData);

	    // --------------------------------------------------------------------//
	    // Step-3: Verify Patient Billing history
	    // --------------------------------------------------------------------//
	    assertTrue(click(selenium, lnkPatientBillingHistory), "Could not present the Booking Appointment", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    String countClaims1=getText(selenium,lblCountClaims);
	    String[] count2=countClaims1.split(" ");
	    int count3=Integer.parseInt((count2[1]));
	    
	    if(count3<count1){
		Assert.fail("Count updation failed");
	    }
	    
	} catch (RuntimeException e) {
	    e.printStackTrace();
	}

	return returnValue;
    }
}
