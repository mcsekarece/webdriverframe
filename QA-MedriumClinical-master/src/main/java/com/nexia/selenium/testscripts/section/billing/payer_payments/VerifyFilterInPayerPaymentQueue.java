package com.nexia.selenium.testscripts.section.billing.payer_payments;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyFilterInPayerPaymentQueue extends AbstractBilling {
    	
    @Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify filter in payer payment queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFilterInPayerPaymentQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "PayerPayments";
		billingData.testCaseId = "TC_PP_001";
		billingData.fetchBillingTestData();
		verifyFilterInPayerPaymentQueue(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}

    /*************************************************************************************************** 
	* @purpose        Verify filter in payer payment queue
	* @action 		  verifying filter in payer payment queue
	* @Specification  SRS_BLG_Payer_Payments_Rev0.0
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Review
	* @useraccount    US
	* @since  	      Feb 13, 2014	
	***************************************************************************************************/
	public boolean verifyFilterInPayerPaymentQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		String allInShowFilter = "All";
		String unPostedPayerBatchesInShowFilter = "Unposted Payer Batches";
		String electronicRemittanceInShowFilter = "Electronic Remittance";
		
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
			//  Step-4: Fill Payer Batch Details								  //
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
			
			assertTrue(click(selenium, btnPPtSave), "Could not click the Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the post button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify filter in payer payment queue					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkUnpostedQuee),"Could not able to click the unposted queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);

			//verify the default value is 'All' in the show filter
			if(!(getValue(selenium, ajxSpecialty).equalsIgnoreCase(allInShowFilter))){
				return false;
			}
			
			if(!(getText(selenium, lblSummaryUnpostQueue).toLowerCase().contains(billingData.insurance))){
				return false;
			}
			
			//verify the 'un posted payer batches' in the show filter
			assertTrue(selectValueFromAjaxList(selenium, ajxSpecialty, unPostedPayerBatchesInShowFilter), "Could not select the value in show filter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!(getText(selenium, lblSummaryUnpostQueue).toLowerCase().contains(billingData.insurance))){
				return false;
			}
			
			//verify the 'electronic remitence' in the show filter
			assertTrue(selectValueFromAjaxList(selenium, ajxSpecialty, electronicRemittanceInShowFilter), "Could not select the value in show filter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(getText(selenium, lblSummaryUnpostQueue).toLowerCase().contains(billingData.insurance)){
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

