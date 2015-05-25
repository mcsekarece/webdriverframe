package com.nexia.selenium.testscripts.section.billing.batchstatement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTopWorkQueueDisplay extends  AbstractBilling {
	
	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for verifying TopWork Queue Display By Default")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyTopWorkQueueDisplay(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib billingData = new BillingLib();
	billingData.workSheetName = "BatchStatements";
	billingData.testCaseId = "TC_BS_001";
	billingData.fetchBillingTestData();
	verifyTopWorkQueueDisplayByDefault(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
    }
	
	
	
	
	 /**
     *  To verify TopWork Queue Display By Default 
     * @param seleniumHost
     * @param seleniumPort
     * @param browser
     * @param webSite
     * @throwsIOException
     * @since Apr 11, 2014
     */
	
	public boolean verifyTopWorkQueueDisplayByDefault(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, BillingLib billingData)
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
	    
		//--------------------------------------------------------------------//
		//  Step-2:Change Switch Role  										  //
		//--------------------------------------------------------------------//
		assertTrue(switchRole(selenium,billingData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

	    // --------------------------------------------------------------------//
	    // Step-3: Go to Unprinted Statement Queues                                 
	    // --------------------------------------------------------------------//
	   
	    assertTrue(click(selenium,lnkUnprintedStatement),"Could not click Unprinted Statement in the home page", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		 // --------------------------------------------------------------------//
	    // Step-4: Verify Top Work Queue display                                     
	    // --------------------------------------------------------------------//
			
		 assertTrue(isElementPresent(selenium, ajxSearch), "Could not find Search patient field", selenium, ClassName, MethodName);
		 assertTrue(isElementPresent(selenium, ajxSuggestBox), "Could not find  patient status field", selenium, ClassName, MethodName);
		 assertTrue(isElementPresent(selenium, ajxUnprinted), "Could not find  Unprinted field", selenium, ClassName, MethodName);
		 assertTrue(isElementPresent(selenium, txtFromDateUnprintStatement), "Could not find  Unprinted statement FromDate field", selenium, ClassName, MethodName);
		 assertTrue(isElementPresent(selenium, txtToDateUnprintStatement), "Could not find  Unprinted statement ToDate field", selenium, ClassName, MethodName);
		 assertTrue(isElementPresent(selenium, btnPrintSendUnprintStatement), "Could not find  Print/Send buttton", selenium, ClassName, MethodName);
		 assertTrue(isElementPresent(selenium, lnkHideAnchor), "Could not find  link hide anchor", selenium, ClassName, MethodName);
		 
		 
	} catch (RuntimeException e) {
	    e.printStackTrace();
	    assertTrue(false, "Failed Due to the Exception; \n\t*) ExceptionDetails :" + e.getMessage() + "\n\t*)", selenium, ClassName, MethodName);
	}
	return returnValue;
 }
	
}
	

