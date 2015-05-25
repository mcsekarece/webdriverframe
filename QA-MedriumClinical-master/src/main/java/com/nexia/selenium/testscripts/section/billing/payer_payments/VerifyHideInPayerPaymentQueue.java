package com.nexia.selenium.testscripts.section.billing.payer_payments;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyHideInPayerPaymentQueue extends AbstractBilling {
    	
    @Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify payer payment hide from queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPayerPaymentPost(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "PayerPayments";
		billingData.testCaseId = "TC_PP_001";
		billingData.fetchBillingTestData();
		verifyPayerPaymentPost(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}

    /*************************************************************************************************** 
	* @purpose        Verify payer payment hide from queue
	* @action 		  verifying payer payment hide from queue
	* @Specification  SRS_BLG_Payer_Payments_Rev0.0
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Review
	* @useraccount    US
	* @since  	      Feb 05, 2014	
	***************************************************************************************************/
	public boolean verifyPayerPaymentPost(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Verify Hide in payer payment queue					 	  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkUnpostedQuee),"Could not able to click the unposted queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium, lnkSuperBillHide),"Could not able to find the hide in unposted queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium, lblPayerNameUnpostQueue),"Could not able to find the payer name label", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkSuperBillHide),"Could not able to click the hide in unposted queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

