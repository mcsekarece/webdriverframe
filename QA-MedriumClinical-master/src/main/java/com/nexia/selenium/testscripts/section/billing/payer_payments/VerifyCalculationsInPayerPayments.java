package com.nexia.selenium.testscripts.section.billing.payer_payments;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCalculationsInPayerPayments extends AbstractBilling {
    	
    @Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Calculations In Payer Payments")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalculationsInPayerPayments(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "PayerPayments";
		billingData.testCaseId = "TC_PP_001";
		billingData.fetchBillingTestData();
		verifyCalculationsInPayerPayments(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}

    /*************************************************************************************************** 
	* @purpose        Verify Calculations In Payer Payments
	* @action 		  verifying Calculations In Payer Payments
	* @Specification  SRS_BLG_Payer_Payments_Rev0.0
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Review
	* @useraccount    US
	* @since  	      Feb 14, 2014	
	***************************************************************************************************/
	public boolean verifyCalculationsInPayerPayments(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
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

			//In 'dataSetupForPayerPayment' method we append dynamic date and time with adjustment reason. The old value needed in some place. So, We take back up.
			//String tempAdjustmentReason = adjustmentCodeData.adjusmentReason;
			
			assertTrue(dataSetupForPayerPayment(selenium, adjustmentCodeData, chargeEntryData, userAccount),"Could not navigate to service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//Read charge entry data
			chargeEntryData.fetchBillingTestData();
			
			//add one more charge entry
			//adjustmentCodeData.adjusmentReason = tempAdjustmentReason;
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
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(billingData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))), "",selenium, ClassName, MethodName);
			click(selenium,lblPatientResult);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Fill Claim details										  //
			//--------------------------------------------------------------------//
			assertTrue(fillFirstClaimEntry(selenium, billingData, userAccount), "Could not fill the first claim details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(fillSecondClaimEntry(selenium, billingData, userAccount), "Could not fill the first claim details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Calculations In Payer Payments					  //
			//--------------------------------------------------------------------//
			Float subTotalAllowedAmt =  Float.parseFloat(billingData.allowedAmt1) + Float.parseFloat(billingData.allowedAmt2);
			Float subTotalDeductable =  Float.parseFloat(billingData.deductable1) + Float.parseFloat(billingData.deductable2);
			Float subTotalCoInsurance =  Float.parseFloat(billingData.coInsurance1) + Float.parseFloat(billingData.coInsurance2);
			Float subTotalCoPayment =  Float.parseFloat(billingData.coPayment1) + Float.parseFloat(billingData.coPayment2);
			Float subTotalPaidAmt =  Float.parseFloat(billingData.paidAmt1) + Float.parseFloat(billingData.paidAmt2);
			Float subTotalAdjustmentAmt =  Float.parseFloat(billingData.adjustmentAmt1) + Float.parseFloat(billingData.adjustmentAmt2);
			
			//the out come amount prefix with '$' symbol... So, We replace that with empty character and trim the amount
			if((Float.parseFloat(getText(selenium, lblSubTotalAllowedAmt).replace('$',' ').trim()))!= (subTotalAllowedAmt)){
				return false;
			}
			if((Float.parseFloat(getText(selenium, lblSubTotalDeductable).replace('$',' ').trim()))!= (subTotalDeductable)){
				return false;
			}
			if((Float.parseFloat(getText(selenium, lblSubTotalCoInsurance).replace('$',' ').trim()))!= (subTotalCoInsurance)){
				return false;
			}
			if((Float.parseFloat(getText(selenium, lblSubTotalCoPayment).replace('$',' ').trim()))!= (subTotalCoPayment)){
				return false;
			}
			if((Float.parseFloat(getText(selenium, lblSubTotalPaidAmount).replace('$',' ').trim()))!= (subTotalPaidAmt)){
				return false;
			}
			if((Float.parseFloat(getText(selenium, lblSubTotalAdjustmentAmount).replace('$',' ').trim()))!= (subTotalAdjustmentAmt)){
				return false;
			}

		
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

