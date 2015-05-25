package com.nexia.selenium.testscripts.section.billing.payer_payments;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPayerPaymentPost extends AbstractBilling {
    	
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify payer payment post")
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
	* @purpose        Verify payer payment post
	* @action 		  verifying payer payment post
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
			//  Step-2: Setup Data For Payer Batch Payment						  //
			//--------------------------------------------------------------------//
			//Read adjustment code data
			BillingLib adjustmentCodeData = new BillingLib();
			adjustmentCodeData.workSheetName = "AdjustmentCodes";
			adjustmentCodeData.testCaseId = "TC_AC_020";
			adjustmentCodeData.fetchBillingTestData();
			
			//Read charge entry data
			BillingLib chargeEntryData = new BillingLib();
			chargeEntryData.workSheetName = "ChargeEntry";
			chargeEntryData.testCaseId = "TC_CE_034";
			chargeEntryData.fetchBillingTestData();
			
			assertTrue(dataSetupForPayerPayment(selenium, adjustmentCodeData, chargeEntryData, userAccount),"Could not navigate to service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			billingData.adjustmentReason = adjustmentCodeData.adjusmentReason;
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to payer payment								  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToBatchPayerPayment(selenium),"Could not navigate to service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Post in payer payments							  //
			//--------------------------------------------------------------------//
			assertTrue(fillBatchPayerEntry(selenium, billingData, userAccount), "Could not fill all batch payer entry", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium, txtClaimPatientSearch, billingData.patientName),"Could not type patient id", selenium, ClassName, MethodName);
			
			selenium.keyPress(txtClaimPatientSearch, "\\13");
			waitForElement(selenium,lblPatientResult,10000);
			
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+billingData.patientName, selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(billingData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"", selenium, ClassName, MethodName);
			click(selenium,lblPatientResult);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnPost), "Could not click the post button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnNoInPost), "Could not click the no button in post", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnPost), "Could not click the post button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnYesInPost), "Could not click the yes button in post", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

