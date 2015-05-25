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

public class ScenarioOne extends AbstractBilling{
	@MapToTestLink(testCaseID = "Data Set Up")
	@Test(groups = {"EndToEnd","Developing","firefox", "iexplore", "safari", "default"}, description = "Verify add new claim in payer payments")//,dependsOnGroups = "BeforeCreatePatientAndPayerTwo")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void scenarioOne(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
			//-------------------------------------------------
			//Saving data in excel sheet for scenario:2
			//----------------------------------------------------
			BillingLib endToend = new BillingLib();
			endToend.workSheetName = "EndToEnd";
			endToend.testCaseId = "SC_001";
			endToend.toTalFee1=Float.toString(amount1);
			endToend.toTalFee2=Float.toString(amount2);
			endToend.toTalFee3=Float.toString(amount3);
			endToend.toTalFee4=Float.toString(amount4);
			
			endToend.WriteBillingTestData();
			
			
			totAmount = amount1+amount2+amount3+amount4;
			
			//ToTal Insureance balance
			toTalAmount = String.valueOf(totAmount);
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
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
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
