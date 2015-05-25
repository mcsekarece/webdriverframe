package com.nexia.selenium.testscripts.section.billing.payer_payments;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelInClaimAdjustment extends AbstractBilling {
    	
    @Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify cancel in claim adjustment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelInClaimAdjustment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "PayerPayments";
		billingData.testCaseId = "TC_PP_001";
		billingData.fetchBillingTestData();
		verifyCancelInClaimAdjustment(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}

    /*************************************************************************************************** 
	* @purpose        Verify cancel in claim adjustment
	* @action 		  verifying in claim adjustment
	* @Specification  SRS_BLG_Payer_Payments_Rev0.0
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Review
	* @useraccount    US
	* @since  	      Feb 06, 2014	
	***************************************************************************************************/
	public boolean verifyCancelInClaimAdjustment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
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
			//  Step-4: Fill Payer Batch Details								  //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium, ajxInsurance, billingData.insurance), "Could not select the Payer/ Insurance", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			 assertTrue(type(selenium, txtClaimPatientSearch, billingData.patientName),"Could not type patient id", selenium, ClassName, MethodName);
			
			selenium.keyPress(txtClaimPatientSearch, "\\13");
			waitForElement(selenium,lblPatientResult,10000);
			
			 assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+billingData.patientName, selenium, ClassName, MethodName);
			 assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(billingData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))), "",selenium, ClassName, MethodName);
			click(selenium,lblPatientResult);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Fill Claim Adjustment details							  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnShowClaimAdjustment), "Could not click show claim adjustment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium, ajxGroupCode, billingData.groupCode), "Could not select the group code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(selectValueFromAjaxList(selenium, ajxReasonCode, billingData.reasonCode), "Could not select the group reason", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 assertTrue(type(selenium, txtCASAmount, billingData.CASAmount),"Could not type CAS amount", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify cancel in claim adjustment						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, CASCancel), "Could not click cancel button in CAS", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, CASCancel)){
				Assert.fail("Cancel funtionality not working in CAS");
			}
			
			assertTrue(click(selenium, btnShowClaimAdjustment), "Could not click show claim adjustment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//To ensure that after click 'cancel' button, Details are not saved
			if ((getText(selenium, ajxGroupCode ).trim().toLowerCase()).contains(billingData.groupCode.trim().toLowerCase())) {
				return false;
			}
			if ((getText(selenium, ajxReasonCode).trim().toLowerCase()).contains(billingData.reasonCode.trim().toLowerCase())) {
				return false;
			}
			if ((getText(selenium, txtCASAmount).trim().toLowerCase()).contains(billingData.CASAmount.trim().toLowerCase())) {
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

