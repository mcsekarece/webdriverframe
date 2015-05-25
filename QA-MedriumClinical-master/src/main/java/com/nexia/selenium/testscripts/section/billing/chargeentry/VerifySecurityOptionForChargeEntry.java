package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForChargeEntry extends AbstractBilling {
    @Test(groups = { "AdvancedSmoke", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount)
	    throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib chargeEntryData = new BillingLib();
	chargeEntryData.workSheetName = "VerifySecurityOption";
	chargeEntryData.testCaseId = "TC_VSP_001";
	chargeEntryData.fetchBillingTestData();
	verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, chargeEntryData);
    }

    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib chargeEntryData = new BillingLib();
	chargeEntryData.workSheetName = "VerifySecurityOption";
	chargeEntryData.testCaseId = "TC_VSP_003";
	chargeEntryData.fetchBillingTestData();
	verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, chargeEntryData);
    }

    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib chargeEntryData = new BillingLib();
	chargeEntryData.workSheetName = "VerifySecurityOption";
	chargeEntryData.testCaseId = "TC_VSP_004";
	chargeEntryData.fetchBillingTestData();
	verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, chargeEntryData);
    }

    /***************************************************************************************************
     * @purpose To Verify Security Option For Charge entry
     * @action Verify Security Option For Charge Entry
     * @expected To Ensure that the Security Option For Charge Entry
     * @Specification SRS_BLG_Charge Entry_Rev0.0
     * @author Aspire Qa
     * @throws IOException
     * @state Developing
     * @useraccount Both (US and Canada)
     * @since Feb 12, 2014
     ***************************************************************************************************/

    public boolean verifySecurityOption(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, BillingLib superBillData)
	    throws IOException {

	Selenium selenium = null;
	boolean returnValue = false;
	try {

	    // --------------------------------------------------------------------//
	    // Step-1: Login to the application and search for the given patient
	    // //
	    // --------------------------------------------------------------------//
	    selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
	    Assert.assertNotNull(selenium, "Could Not Retrive the New Selenium Session; More Details :" + superBillData.toString());
	    assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, superBillData.userName, superBillData.userPassword), "Login Failed ", selenium,
		    ClassName, MethodName);

	    // --------------------------------------------------------------------//
	    // Step-2: Switch to Biller role //
	    // --------------------------------------------------------------------//
	    assertTrue(switchRole(selenium, superBillData.switchRole), "Siwtch role failed", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    // --------------------------------------------------------------------//
	    // Step-3: Verify Security Option //
	    // --------------------------------------------------------------------//

	    if (!verifySecurityOption(selenium, superBillData, userAccount)) {
		Assert.fail("Security option not show properly; More Details :" + superBillData.toString());
	    } else
		returnValue = true;

	} catch (RuntimeException e) {
	    e.printStackTrace();
	}
	return returnValue;
    }

    public boolean verifySecurityOption(Selenium selenium, BillingLib chargeEntryData, String account) throws IOException {

	boolean returnValue=true;
	
	// Limited Access
	if (chargeEntryData.testCaseId.equals("TC_VSP_001")) {
 String btnPostchar="xpath=(//a[contains(text(),'Post charges')])[2]";
	    assertTrue(type(selenium, txtPatientBox, chargeEntryData.patientID), "Could not type patient id", selenium, ClassName, MethodName);
	    selenium.clickAt(txtPatientBox,"");
		selenium.focus(txtPatientBox);			
		selenium.fireEvent(txtPatientBox,"keypress");	
	    waitForElement(selenium, lblPatientResult, 10000);
	    assertTrue(selenium.isElementPresent(lblPatientResult), "Search Results are not displayed for the patient with ID :-" + chargeEntryData.patientID,
		    selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    assertTrue(
		    getText(selenium, lblPatientResult).toLowerCase(new java.util.Locale("en", "US")).trim()
			    .contains(chargeEntryData.patientID.trim().toLowerCase(new java.util.Locale("en", "US"))), "match failed", selenium, ClassName,
		    MethodName);
	      selenium.mouseOver(lblPatientResult);
	    waitForPageLoad(selenium);

	    assertTrue(isElementPresent(selenium, btnPostchar), "Could not find post link", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    assertTrue(click(selenium, btnPostchar), "Could not find click post charges link", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	      assertTrue(isElementPresent(selenium, lnkPostNewCharge), "Could not find post new charge link", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    assertTrue(click(selenium, lnkPostNewCharge), "Could not find click post new charges link", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    if(isElementPresent(selenium, btnPostChargeEntry)){
		Assert.fail("Post button is present");
	    }
	   
	    
	    return returnValue;
	}
	// No Access
	if (chargeEntryData.testCaseId.equals("TC_VSP_002")) {

	    assertTrue(type(selenium, txtPatientBox, chargeEntryData.patientID), "Could not type patient id", selenium, ClassName, MethodName);
	    selenium.keyPress(txtPatientBox, "\\9");
	    waitForElement(selenium, lblPatientResult, 10000);
	    assertTrue(selenium.isElementPresent(lblPatientResult), "Search Results are not displayed for the patient with ID :-" + chargeEntryData.patientID,
		    selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    assertTrue(
		    getText(selenium, lblPatientResult).toLowerCase(new java.util.Locale("en", "US")).trim()
			    .contains(chargeEntryData.patientID.trim().toLowerCase(new java.util.Locale("en", "US"))), "match failed", selenium, ClassName,
		    MethodName);
	    // assertTrue(getText(selenium,lblPatientResult).contains(patientID));
	    waitForPageLoad(selenium);

	    selenium.mouseOver(lblPatientResult);
	    waitForPageLoad(selenium);

	    if(isElementPresent(selenium, lnkPostCharge)){
		Assert.fail("Post button is present");
	    }
	    return returnValue;
	}
	
	// Full Access
	if (chargeEntryData.testCaseId.equals("TC_VSP_001")) {

	    assertTrue(type(selenium, txtPatientBox, chargeEntryData.patientID), "Could not type patient id", selenium, ClassName, MethodName);
	    selenium.keyPress(txtPatientBox, "\\9");
	    waitForElement(selenium, lblPatientResult, 10000);
	    assertTrue(selenium.isElementPresent(lblPatientResult), "Search Results are not displayed for the patient with ID :-" + chargeEntryData.patientID,
		    selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    assertTrue(
		    getText(selenium, lblPatientResult).toLowerCase(new java.util.Locale("en", "US")).trim()
			    .contains(chargeEntryData.patientID.trim().toLowerCase(new java.util.Locale("en", "US"))), "match failed", selenium, ClassName,
		    MethodName);
	    // assertTrue(getText(selenium,lblPatientResult).contains(patientID));
	    waitForPageLoad(selenium);

	    selenium.mouseOver(lblPatientResult);
	    waitForPageLoad(selenium);

	    assertTrue(isElementPresent(selenium, lnkPostCharge), "Could not find post charges link", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    assertTrue(click(selenium, lnkPostCharge), "Could not click post charges link", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    if(isElementPresent(selenium, btnPostChargeEntry)){
		Assert.fail("Post button is present");
	    }
	    assertTrue(isElementPresent(selenium, btnPostChargeEntry), "Could not find post button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	   
	    assertTrue(isElementPresent(selenium, btnSaveChargeEntry), "Could not find save button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    return returnValue;
	}
	
	return returnValue;
    }
}
