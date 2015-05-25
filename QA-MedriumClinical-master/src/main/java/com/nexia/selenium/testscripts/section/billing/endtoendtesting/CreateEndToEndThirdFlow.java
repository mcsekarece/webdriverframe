package com.nexia.selenium.testscripts.section.billing.endtoendtesting;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class CreateEndToEndThirdFlow extends AbstractBilling{
	@Test(groups = {"EndToEnd","Developing","firefox", "iexplore", "safari", "default" }, description = "Verify add new claim in payer payments")//,dependsOnGroups = "BeforeCreatePatientAndPayerThird")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endToEndWorkFlow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "SuperBillEntry";
		billingData.testCaseId = "TC_SBE_008";
		billingData.fetchBillingTestData();
		endToEndWorkFlow(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
	
	/*************************************************************************************************** 
	* @purpose        Verify End To end Work Flow two
	* @action 		  Verify End To end Work Flow in  Biller related 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @ticket		  #8759
	* @useraccount    US
	* @since  	      Feb 04, 2014	
	***************************************************************************************************/
	
	
	public boolean endToEndWorkFlow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		
		
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//Data Set Up
			//-----------------------------------------------------------------------------//
			//  Step-2: navigate to Post Charge,Search Create PatientA and Claim Creation 1//
			//----------------------------------------------------------------------------//
			HomeLib payerData = new HomeLib();
			payerData.workSheetName = "AddPayers";
			payerData.testCaseId = "TC_CP_031";
			payerData.fetchHomeTestData();
			billingData.patientID = payerData.patientId;
			
			assertTrue(callChargeEntry(selenium,billingData),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//claim creation : 1
			assertTrue(claimCreationForOne(selenium,billingData,payerData,userAccount),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			assertTrue(callChargeEntry(selenium,billingData),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);

			//claim creation : 2
			
			BillingLib chargeData = new BillingLib();
			chargeData.workSheetName = "ChargeEntry";
			chargeData.testCaseId = "TC_CE_057";
			chargeData.fetchBillingTestData();
			
			assertTrue(claimCreationForTwo(selenium,billingData,chargeData,payerData,userAccount),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//Statement Genration
			
			
			//End To End Work Flow
			billingData.patientID = payerData.patientId;
			assertTrue(navigateToBillingHXCharge(selenium,billingData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-1: Validate that all data from Visit Contains is correct//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkChargeHistory),"Could not click the charge entry in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(btnActions, "");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkEditclaim),"Could not click the Edit Cliam option in charge entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyShowAllDetailsEditClaim(selenium,chargeData)){
				Assert.fail("Cliam 2 Details are not saved properly");
			}
			
			//-----------------------------------------------------------------------------------------------------------------------------//
			//  Step-2 & Step : 3 Validate On Hold Claims and Validate max # Service Codes and Max # of Modifiers are displaying correctly//
			//----------------------------------------------------------------------------------------------------------------------------//
			//Click on Nexia Logo
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			 
			//Verify OnHold Queue
			if(!verifyOnHoldClaimsInOnHoldQueue(selenium,chargeData,payerData )){
				Assert.fail("Claims one Details are not display in the claim queue");
			}
			
			//verify claim details in Billing summary Charge pages 
			if(!verifyCliamdetailsInChargePage(selenium,billingData,chargeData,payerData)){
				Assert.fail("Claims one Details are not display in Billing history charge screen");
			}
			
			//ReSubmit claim
			selenium.clickAt(btnActions, "");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkReSubmitClaim),"Could not click ReSubmit Claims on Charge Entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnChrYes),"Could not click yes button in charge entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------------------//
			//  Step-4 Validate that statement will be generated when balance is paid in full //
			//--------------------------------------------------------------------------------//
			BillingLib patientPaymemtData = new BillingLib();
			patientPaymemtData.workSheetName = "PostPatientPayment";
			patientPaymemtData.testCaseId = "TC_PPP_034";
			patientPaymemtData.fetchBillingTestData();
			
			assertTrue(patientPaymentAmount(selenium,patientPaymemtData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Apply to All charges
			assertTrue(applyAmountToCharge(selenium),"Patient Payment failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//Statment genration
			assertTrue(statmentTrigger(selenium, webSite),"Patient Payment failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//verifyPatientInUnprintedQueue
			if(!verifyUnprintedQueue(selenium,payerData,userAccount)){
				System.out.println("Already statment has been generated");
				return true;
			}
			
			//-----------------------------------------------------------------------------------//
			//  Step-5 : Validate that statement will be generated when Write Off Balances below //
			//-----------------------------------------------------------------------------------//
			assertTrue(updatedStamentPreference(selenium),"Statement Preference could not be updated", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//Billing History Payment
			billingData.patientID = payerData.patientId;
			assertTrue(navigateToBillingHXCharge(selenium,billingData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPaymentHistory),"Could not click  Payment in Billing History page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(btnActions, "");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkVoidPayment),"Could not click  Void payment in Payment page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnPaymentYes),"Could not click yes button in Payment page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Statment genration
			assertTrue(statmentTrigger(selenium, webSite),"Patient Payment failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//VerifyAmountDetails in Billing Summary page
			billingData.patientID = payerData.patientId;
			assertTrue(navigateToBillingHXCharge(selenium,billingData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			if(!verifyAmountDetails(selenium)){
				System.out.println("Already statment has been generated");
				return true;
			}else
				return true;
			
		}catch (Exception e ){
			e.printStackTrace();
		}		
	return true;
	}
	
	public boolean verifyAmountDetails(Selenium selenium){
		
		if(!getText(selenium,lblPatientBalance).contains("0")){
			return false;
		}
		
		if(!getText(selenium,lblInsurance).contains("0")){
			return false;
		}
		if(!getText(selenium,txtUnAppliedAmount).contains("0")){
			return false;
		}
		return true;
	}
	
}
