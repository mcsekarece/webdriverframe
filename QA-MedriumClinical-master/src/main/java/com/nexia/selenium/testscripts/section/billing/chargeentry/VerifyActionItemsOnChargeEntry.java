package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyActionItemsOnChargeEntry extends AbstractBilling {
    @Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Cancel")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyCancelChargeEntry(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib chargeEntryData = new BillingLib();
	chargeEntryData.workSheetName = "ChargeEntry";
	chargeEntryData.testCaseId = "TC_CE_016";
	chargeEntryData.fetchBillingTestData();
	verifyAction(seleniumHost, seleniumPort, browser, webSite, userAccount, chargeEntryData);
    }

    public boolean verifyAction(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, BillingLib chargeEntryData)throws IOException {
	Selenium selenium = null;
	boolean returnValue = true;

	try {

	    // --------------------------------------------------------------------//
	    // Step-1: Login to the application and search for the given patient
	    //
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
	    assertTrue(goToPostNewCharge(selenium, chargeEntryData),"Navigation Failed", selenium, ClassName, MethodName);
	   
	    // --------------------------------------------------------------------//
	    // Step-3: Verify Action Items
	    // --------------------------------------------------------------------//
	    waitForPageLoad(selenium);
	    waitForPageLoad(selenium);
	   assertTrue(click(selenium, btnActions),"Could not click on Action Items", selenium,ClassName, MethodName);
	   waitForPageLoad(selenium);
	   int count=0;
	   while(!isElementPresent(selenium,lnkCancel)){
	       selenium.clickAt(btnActions, "");
	       count++;
	       
	       if(count>10){
		   break;
	       }
	   }
	   assertTrue(isElementPresent(selenium, lnkCancel),"Could not find on Cancel button", selenium,ClassName, MethodName);
	   waitForPageLoad(selenium);
	   assertTrue(isElementPresent(selenium, lnkPostAndHoldClaim),"Could  find on post and hold claim Link", selenium,ClassName, MethodName);
	   waitForPageLoad(selenium);
	   	 
	return returnValue;
	}
	catch (RuntimeException e) {
		e.printStackTrace();
	}
	return returnValue;

    }
}