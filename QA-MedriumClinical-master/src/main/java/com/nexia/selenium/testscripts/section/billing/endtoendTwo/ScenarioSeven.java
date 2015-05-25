package com.nexia.selenium.testscripts.section.billing.endtoendTwo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.sharedlibrary.annotations.MapToTestLink;
import com.thoughtworks.selenium.Selenium;

public class ScenarioSeven extends AbstractBilling{
	@MapToTestLink(testCaseID = "Voiding a Payment")
	@Test(groups = {"EndToEnd","Developing","firefox", "iexplore", "safari", "default"}, description = "Verify add new claim in payer payments")//,dependsOnGroups = "BeforeCreatePatientAndPayerTwo")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endToEndWorkFlow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "SuperBillEntry";
		billingData.testCaseId = "TC_SBE_007";
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
		float amount, amount1, amount2, amount3, amount4, amount5,totAmount;
		String toTalAmount;
		try{
			//Scenario - 1
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
			payerData.testCaseId = "TC_CP_028";
			payerData.fetchHomeTestData();
			billingData.patientID = payerData.patientId;
			
			HomeLib payer2Data = new HomeLib();
			payer2Data.workSheetName = "AddPayers";
			payer2Data.testCaseId = "TC_CP_029";
			payer2Data.fetchHomeTestData();
			 HomeLib payerDataB = new HomeLib();
			 
			payerDataB.workSheetName = "AddPayers";
			payerDataB.testCaseId = "TC_CP_030";
			payerDataB.fetchHomeTestData();
			billingData.patientID = payerDataB.patientId;
			//----------------------------------------------------------------------
			//Fetching the saved data of Scenario One 
			//----------------------------------------------------------------------
			BillingLib endToend = new BillingLib();
			endToend.workSheetName = "EndToEnd";
			endToend.testCaseId = "SC_001";
			endToend.fetchBillingTestData();
			
			amount1 = Float.parseFloat(endToend.toTalFee1);
			amount2 = Float.parseFloat(endToend.toTalFee2);
			amount3 = Float.parseFloat(endToend.toTalFee3);
			amount4 = Float.parseFloat(endToend.toTalFee4);
			
			//end To End Work Flow Start
			//Verify Data After Data SetUp
			//Verify Billing Summary Details in Patient A
			totAmount = amount1+amount2+amount3+amount4;
			 
			
			//ToTal Insureance balance
			toTalAmount = String.valueOf(totAmount);
			
			//Verify Billing Summary Details in Patient B
			billingData.patientID = payerDataB.patientId;
			
			//-----------------------------------------------------------------------------//
			//  Step-8: Post PayerPayment For Patient A and Patient B With Payer1//
			//----------------------------------------------------------------------------//
			BillingLib payerPaymemtData = new BillingLib();
			payerPaymemtData.workSheetName = "PayerPayments";
			payerPaymemtData.testCaseId = "TC_PP_003";
			payerPaymemtData.fetchBillingTestData();
			
			//-----------------------------------------------------------------------------//
			//  Step-10: Verify After Post PayerPayment With Patient B and Payer1  //
			//----------------------------------------------------------------------------//
			billingData.patientID = payerDataB.patientId;
			
			//-----------------------------------------------------------------------------//
			//  Step11: Post PayerPayment For Patient A With Payer2                       //
			//----------------------------------------------------------------------------//
			BillingLib payerPaymemtData1 = new BillingLib();
			payerPaymemtData1.workSheetName = "PayerPayments";
			payerPaymemtData1.testCaseId = "TC_PP_004";
			payerPaymemtData1.fetchBillingTestData();
			
			//-----------------------------------------------------------------------------//
			//  Step-12: Verify After Post PayerPayment With Patient A and Payer1  //
			//----------------------------------------------------------------------------//
			billingData.patientID = payerData.patientId;
			
			//-----------------------------------------------------------------------------//
			//  Step-13:  Post Patient Payment With Patient A and Patient B  //
			//----------------------------------------------------------------------------//
			//Navigate To Enter patient payment
			
			BillingLib patientPaymemtData = new BillingLib();
			patientPaymemtData.workSheetName = "PostPatientPayment";
			patientPaymemtData.testCaseId = "TC_PPP_032";
			patientPaymemtData.fetchBillingTestData();
			
			BillingLib patientPaymemtData1 = new BillingLib();
			patientPaymemtData1.workSheetName = "PostPatientPayment";
			patientPaymemtData1.testCaseId = "TC_PPP_033";
			patientPaymemtData1.fetchBillingTestData();
			
			patientPaymemtData.patientID = payerData.patientId;
			//-----------------------------------------------------------------------------//
			//  Step-13: Verify After Post Patient Payment With Patient A   //
			//----------------------------------------------------------------------------//
			// Patient A
			billingData.patientID = payerData.patientId;
			// Patient B
			
			billingData.patientID = payerDataB.patientId;
			//Billing History Payment - need to clarification on BA 
			
			//--------------------------------------------------------------------//
			//  Step-14: Apply Paient Payemnt//
			//--------------------------------------------------------------------//
			billingData.patientID = payerData.patientId;
			
			
			//--------------------------------------------------------------------//
			//  Step-15:reverse Charge//
			//--------------------------------------------------------------------//
			//Click on Show Details in Service code with claim one
			
			//--------------------------------------------------------------------//
			//  Step-16:void Payment with patient B//
			//--------------------------------------------------------------------//
			assertTrue(navigateToBillingHXCharge(selenium,billingData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPaymentHistory),"Could not click the Payment History in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(btnActions, "");
			
			assertTrue(click(selenium,lnkVoidPayment),"Could not click charge Action in Charge Entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnPaymentYes),"Could not click the yes button in payment page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkBillingSummary),"Could not click the Summary link in Billing summary page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);

		}catch (Exception e ){
			e.printStackTrace();
		}		
	return true;
	}
	
	public boolean patientPayement(Selenium selenium){
		
		try{
			
			int count;
			int counter = 1;
			int defaultCount = 11;
			//int applyCounter = 2;
			String chargeAmount = null;
			String currentPayer = null;
			for(count = 1; count <defaultCount; count++){
				chargeAmount = getText(selenium,"xpath=(//div[@id='amountDue'])["+counter+"]").replace("$", "");
				currentPayer = getText(selenium,"xpath=(//div[@id='currentPayer'])["+counter+"]");
				
				if((chargeAmount.equals("100.00")&&currentPayer.equals("Patient"))){
					
					selenium.clickAt("//div[contains(text(),'Patient')]/parent::div/parent::div/div[10]/div/div", "");
					waitForPageLoad(selenium);
					assertTrue(click(selenium,lnkApplyPatientPayment),"Could not click the Apply patient payments post button", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					
					assertTrue(type(selenium,txtPAppliedAmount,chargeAmount),"Could not enter the paid amount", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				
					assertTrue(click(selenium,btnChrSave),"Could not click the save button in charge entry page", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					return true;
				}counter++;
				//applyCounter++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean voidChargeWithPayer(Selenium selenium){
			
		try{
			BillingLib patientPaymemtData = new BillingLib();
			patientPaymemtData.workSheetName = "PostPatientPayment";
			patientPaymemtData.testCaseId = "TC_PPP_034";
			patientPaymemtData.fetchBillingTestData();
			
			assertTrue(patientPaymentAmount(selenium,patientPaymemtData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkChargeHistory),"Could not click the charge entry in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt("xpath=(//a[contains(text(),'Actions')])[2]", "");
			waitForPageLoad(selenium);
			
			/*assertTrue(click(selenium,lnkApplyPatientPayment),"Could not click the Apply patient payments post button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtPAppliedAmount,"50"),"Could not enter the paid amount", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,btnChrSave),"Could not click the save button in charge entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			assertTrue(click(selenium,lnkVoidCharge),"Could not click charge Action in Charge Entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean showDetailsWithPatient(Selenium selenium){
		
		try{
			
			int count;
			int counter = 1;
			int defaultCount = 11;
			//int applyCounter = 2;
			String chargeAmount = null;
			String currentPayer = null;
			for(count = 1; count <defaultCount; count++){
				chargeAmount = getText(selenium,"xpath=(//div[@id='amountDue'])["+counter+"]").replace("$", "");
				currentPayer = getText(selenium,"xpath=(//div[@id='currentPayer'])["+counter+"]");
				
				if((chargeAmount.equals("0.00")&&currentPayer.equals("Patient"))){
					
					selenium.clickAt("//div[contains(text(),'Patient')]/parent::div/parent::div/div[9]/div/div", "");
					waitForPageLoad(selenium);
					assertTrue(click(selenium,lnkReverse),"Could not click the reverse in service code one ", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnChrYes),"Could not click charge Action in Charge Entry page", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					return true;
				}
				counter++;
				//applyCounter++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
}
