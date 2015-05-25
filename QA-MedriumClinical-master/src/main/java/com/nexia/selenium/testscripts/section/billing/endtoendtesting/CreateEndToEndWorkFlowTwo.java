package com.nexia.selenium.testscripts.section.billing.endtoendtesting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class CreateEndToEndWorkFlowTwo extends AbstractBilling{
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
			
			assertTrue(callChargeEntry(selenium,billingData),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//claim creation : 1
			assertTrue(claimCreationOne(selenium,billingData,payerData,userAccount),"Could not create cliam creation one",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//Click on Nexia Logo
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose), "could not click error close",selenium, ClassName, MethodName);
			//-----------------------------------------------------------------------------//
			//  Step-3: navigate to Post Charge,Search Create PatientA and Claim Creation2//
			//----------------------------------------------------------------------------//
			assertTrue(callChargeEntry(selenium,billingData),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//claim creation : 2
			assertTrue(claimCreationTwo(selenium,billingData,payerData,userAccount),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//Click on Nexia Logo
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose), "could not click error close",selenium, ClassName, MethodName);
			//-----------------------------------------------------------------------------//
			//  Step-4: navigate to Post Charge,Search Create PatientA and Claim Creation 3//
			//----------------------------------------------------------------------------//
			HomeLib payer2Data = new HomeLib();
			payer2Data.workSheetName = "AddPayers";
			payer2Data.testCaseId = "TC_CP_029";
			payer2Data.fetchHomeTestData();
			
			assertTrue(callChargeEntry(selenium,billingData),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//claim creation : 3
			assertTrue(claimCreationThree(selenium,billingData,payer2Data,userAccount),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//Click on Nexia Logo
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose), "could not click error close",selenium, ClassName, MethodName);
			//-----------------------------------------------------------------------------//
			//  Step-5: navigate to Post Charge,Search Create PatientA and Claim Creation4//
			//----------------------------------------------------------------------------//
			HomeLib payerData3 = new HomeLib();
			payerData3.workSheetName = "AddPayers";
			payerData3.testCaseId = "TC_CP_027";
			payerData3.fetchHomeTestData();
			
			assertTrue(callChargeEntry(selenium,billingData),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//claim creation : 4
			assertTrue(claimCreationFour(selenium,billingData,payerData3,userAccount),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//Click on Nexia Logo
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose), "could not click error close",selenium, ClassName, MethodName);
			
			//-----------------------------------------------------------------------------//
			//  Step-6: navigate to Post Charge,Search Create PatientA and Claim Creation 5//
			//----------------------------------------------------------------------------//
			assertTrue(callChargeEntry(selenium,billingData),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//claim creation : 5
			assertTrue(claimCreationFive(selenium,billingData,payerData,userAccount),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//Click on Nexia Logo
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose), "could not click error close",selenium, ClassName, MethodName);
			//-----------------------------------------------------------------------------//
			//  Step-7: navigate to Post Charge,Search Create PatientB and Claim Creation 6//
			//----------------------------------------------------------------------------//
			HomeLib payerDataB = new HomeLib();
			payerDataB.workSheetName = "AddPayers";
			payerDataB.testCaseId = "TC_CP_030";
			payerDataB.fetchHomeTestData();
			billingData.patientID = payerDataB.patientId;
			
			assertTrue(callChargeEntry(selenium,billingData),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//claim creation : 4
			assertTrue(claimCreationOne(selenium,billingData,payerDataB,userAccount),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//Click on Nexia Logo
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose), "could not click error close",selenium, ClassName, MethodName);
			
			//end To End Work Flow Start
			//Verify Data After Data SetUp
			//Verify Billing Summary Details in Patient A
			amount1 = Float.parseFloat(billingData.toTalFee1);
			amount2 = Float.parseFloat(billingData.toTalFee2);
			amount3 = Float.parseFloat(billingData.toTalFee3);
			amount4 = Float.parseFloat(billingData.toTalFee4);
			
			
			totAmount = amount1+amount2+amount3+amount4;
			
			//ToTal Insureance balance
			toTalAmount = String.valueOf(totAmount);
			
			//Billing Histroy Page
			billingData.patientID = payerData.patientId;
			assertTrue(navigateToBillingHXCharge(selenium,billingData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Verify Summary Details
			
			if(!getText(selenium,lblInsurance).contains(toTalAmount)){
				return false;
			}
			
			if(!getText(selenium,lblPatientBalance).contains(billingData.toTalFee5)){
				return false;
			}
			
			//Verify Billing Summary Details in Patient B
			billingData.patientID = payerDataB.patientId;
			assertTrue(navigateToBillingHXCharge(selenium,billingData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Verify Summary Details
			if(!getText(selenium,lblInsurance).contains(billingData.toTalFee1)){
				return false;
			}
			
			//-----------------------------------------------------------------------------//
			//  Step-8: Post PayerPayment For Patient A and Patient B With Payer1//
			//----------------------------------------------------------------------------//
			BillingLib payerPaymemtData = new BillingLib();
			payerPaymemtData.workSheetName = "PayerPayments";
			payerPaymemtData.testCaseId = "TC_PP_003";
			payerPaymemtData.fetchBillingTestData();
			
			//Click on Nexia Logo
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose), "could not click error close",selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkPostPayer),"Could not click the Post Payer Payment in Home Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(endToEndPayerPaymentTwo(selenium,payerPaymemtData,billingData,payerData,payerDataB,userAccount),"Payer Payment Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose), "could not click error close",selenium, ClassName, MethodName);
			//Unposted Payer Batch

			if(!verifyUnPostedQueue(selenium,payerPaymemtData,payerData,userAccount )){
				Assert.fail("Un Posted Details are not displayed properly");
			}
			
			
			//-----------------------------------------------------------------------------//
			//  Step-9: Verify After Post PayerPayment With Patient A and Payer1  //
			//----------------------------------------------------------------------------//
			billingData.patientID = payerData.patientId;
			assertTrue(navigateToBillingHXCharge(selenium,billingData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyAfterPostPaymentWithPatientA(selenium, billingData,toTalAmount)){
				Assert.fail("Patient A Details are getting displayed");
			}
			
			
			//-----------------------------------------------------------------------------//
			//  Step-10: Verify After Post PayerPayment With Patient B and Payer1  //
			//----------------------------------------------------------------------------//
			billingData.patientID = payerDataB.patientId;
			
			assertTrue(navigateToBillingHXCharge(selenium,billingData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyAfterPaostPaymentWithPatientB(selenium, billingData)){
				Assert.fail("Patient A Details are getting displayed");
			}
			
			//-----------------------------------------------------------------------------//
			//  Step11: Post PayerPayment For Patient A With Payer2                       //
			//----------------------------------------------------------------------------//
			BillingLib payerPaymemtData1 = new BillingLib();
			payerPaymemtData1.workSheetName = "PayerPayments";
			payerPaymemtData1.testCaseId = "TC_PP_004";
			payerPaymemtData1.fetchBillingTestData();
			
			//Click on Nexia Logo
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose), "could not click error close",selenium, ClassName, MethodName);
			 
			assertTrue(click(selenium,lnkPostPayer),"Could not click the Post Payer Payment in Home Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(endToEndPayerPaymentTwoWithPayerTwo(selenium,payerPaymemtData1,billingData,payer2Data,userAccount),"Payer Payment Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose), "could not click error close",selenium, ClassName, MethodName);
			//-----------------------------------------------------------------------------//
			//  Step-12: Verify After Post PayerPayment With Patient A and Payer1  //
			//----------------------------------------------------------------------------//
			billingData.patientID = payerData.patientId;
			assertTrue(navigateToBillingHXCharge(selenium,billingData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyAfterPostPaymentPayerTwoWithPatientA(selenium, billingData, payerPaymemtData1)){
				Assert.fail("Patient A Details are getting displayed Properly");
			}
			
			
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
			
			assertTrue(navigateToEnterPatientPayment(selenium),"Could not Navigate to Enter Patient payment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			patientPaymemtData.patientID = payerData.patientId;
			assertTrue(endToEndEnterPatientPayment(selenium,patientPaymemtData,patientPaymemtData1,payerDataB ),"Post Patient Payment Failled", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//-----------------------------------------------------------------------------//
			//  Step-13: Verify After Post Patient Payment With Patient A   //
			//----------------------------------------------------------------------------//
			// Patient A
			billingData.patientID = payerData.patientId;
			assertTrue(navigateToBillingHXCharge(selenium,billingData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyPostPatientPaymentWithPatientA(selenium,billingData)){
				Assert.fail("Summary Details are not getting displayed properly after patient pay the amount");
			}
			
			// Patient B
			
			billingData.patientID = payerDataB.patientId;
			assertTrue(navigateToBillingHXCharge(selenium,billingData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyPostPatientPaymentWithPatientB(selenium,billingData)){
				Assert.fail("Summary Details are not getting displayed properly after patient pay the amount");
			}
			
			
			//Billing History Payment - need to clarification on BA 
			
			
			//--------------------------------------------------------------------//
			//  Step-14: Apply Paient Payemnt//
			//--------------------------------------------------------------------//
			billingData.patientID = payerData.patientId;
			assertTrue(navigateToBillingHXCharge(selenium,billingData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkChargeHistory),"Could not click the charge entry in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			/*selenium.clickAt("xpath=(//a[contains(text(),'Actions')])[11]", "");
			
			assertTrue(click(selenium,lnkApplyPatientPayment),"Could not click the charge entry in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtPAppliedAmount, patientPaymemtData.paidAmount),"Could not enter the paid amount", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			assertTrue(patientPayement(selenium),"could pay the amount in patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Verify Billing History Summary
			if(!verifyAfterApplyingPatientPaymentInPatientA(selenium,billingData, patientPaymemtData)){
				Assert.fail("Details are not getting displayed properly");
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-15:reverse Charge//
			//--------------------------------------------------------------------//
			//Click on Show Details in Service code with claim one
			assertTrue(click(selenium,lnkChargeHistory),"Could not click the charge entry in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(showDetailsWithPatient(selenium),"could not reverse the amount in patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Verify Data after Reversing a Payment
			if(!verifyDataAfterReversingAPayment(selenium,billingData,patientPaymemtData)){
				Assert.fail("Details are not getting displayed properly After Reversing patientA Payment");
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-16:void Payment with patient B//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkPaymentHistory),"Could not click the Payment History in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(btnActions, "");
			
			assertTrue(click(selenium,lnkVoidPayment),"Could not click charge Action in Charge Entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnPaymentYes),"Could not click the yes button in payment page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkBillingSummary),"Could not click the Summary link in Billing summary page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//-----------------------------------------------------------------------------//
			//  Step-17: Void Amount with Claim 2 to patient A  //
			//----------------------------------------------------------------------------//
			// Patient A
			billingData.patientID = payerData.patientId;
			assertTrue(navigateToBillingHXCharge(selenium,billingData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(voidChargeWithPayer(selenium),"Could not void charge in  Charge Entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!selenium.isTextPresent("To void a charge, the balance has to equal the original charge amount. Please create offsetting adjustment and unapply associated payments.")){
				Assert.fail("Void message is not getting displayed");
			}else
				return true;

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
