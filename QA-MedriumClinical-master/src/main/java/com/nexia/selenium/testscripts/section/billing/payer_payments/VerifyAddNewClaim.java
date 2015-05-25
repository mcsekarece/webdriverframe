package com.nexia.selenium.testscripts.section.billing.payer_payments;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAddNewClaim extends AbstractBilling {
    	
    @Test(groups = {"AdvancedSmokeUS","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify add new claim in payer payments")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAddNewClaim(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "PayerPayments";
		billingData.testCaseId = "TC_PP_001";
		billingData.fetchBillingTestData();
		verifyAddNewClaim(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}

    /*************************************************************************************************** 
	* @purpose        Verify add new claim in payer payments
	* @action 		  verifying add new claim in payer payments
	* @Specification  SRS_BLG_Payer_Payments_Rev0.0
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Review
	* @useraccount    US
	* @since  	      Feb 05, 2014	
	***************************************************************************************************/
	public boolean verifyAddNewClaim(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to payer payment								  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToBatchPayerPayment(selenium),"Could not navigate to service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			//--------------------------------------------------------------------//
			//  Step-3: Verify add new claim in payer payments					  //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium, ajxInsurance, billingData.insurance), "Could not select the Payer/ Insurance", selenium, ClassName, MethodName);
			if(userAccount.equals(USAccount)){
				assertTrue(click(selenium, btnAddClaim), "Could not click add claim button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(!isElementPresent(selenium, lblSecondClaim), "Add new Claim functionality not working in the batch payer payment", selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

