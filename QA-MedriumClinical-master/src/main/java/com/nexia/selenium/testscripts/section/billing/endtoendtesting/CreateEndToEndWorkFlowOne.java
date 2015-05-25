package com.nexia.selenium.testscripts.section.billing.endtoendtesting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;


public class CreateEndToEndWorkFlowOne extends AbstractBilling{
	@Test(groups = {"EndToEnd","Developing","firefox", "iexplore", "safari", "default"}, description = "Verify add new claim in payer payments")//, dependsOnGroups = "BeforeCreatePatientAndPayer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endToEndWorkFlow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "SuperBillEntry";
		billingData.testCaseId = "TC_SBE_006";
		billingData.fetchBillingTestData();
		endToEndWorkFlow(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
	
	 /*************************************************************************************************** 
	* @purpose        Verify End To end Work Flow 
	* @action 		  Verify End To end Work Flow in  Biller related 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @ticket		  #8579	
	* @useraccount    US
	* @since  	      Feb 27, 2014	
	***************************************************************************************************/
	public boolean endToEndWorkFlow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		float totalAmount, credit, debit;
		int counter = 1;
		String currentPayer = null;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//Part A - Creating and Posting a Charge from an Encounter Step : 1
			//--------------------------------------------------------------------//
			//  Step-2: navigat to chart summary Page //
			//--------------------------------------------------------------------//
			AbstractChartPreVisit chartVisit = new AbstractChartPreVisit();
			ChartPreVisitLib encounterData = new ChartPreVisitLib();
			
			HomeLib payerData = new HomeLib();
			payerData.workSheetName = "AddPayers";
			payerData.testCaseId = "TC_CP_024";
			payerData.fetchHomeTestData();
			billingData.patientID = payerData.patientId;
			
			assertTrue(navigateToViewChart(selenium,billingData,chartVisit),"Could not serach the patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: navigate to Encounter Page //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,chartVisit.lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(chartVisit.deleteAllEncounters(selenium,encounterData),"Could not delete", selenium, ClassName, MethodName);
			assertTrue(chartVisit.goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+billingData.switchRole, "");
			String tempArray[]=providerName.split(" ");
			String provider=tempArray[1]+", "+tempArray[0];
			
			selectValueFromAjaxList(selenium, chartVisit.ajxEncounterProvider,provider);
			waitForPageLoad(selenium);
			
			encounterData.workSheetName = "CreateProblemList";
			encounterData.testCaseId = "TC_CPL_047";
			encounterData.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			
			//Create Diagnosis Code
			assertTrue(chartVisit.createDiagnosisCodes(selenium,encounterData,userAccount),"Could not create the Assessment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create Complete Super Bill Template //
			//--------------------------------------------------------------------//
			assertTrue(endToEndCompleteSuperBill(selenium,billingData,payerData,userAccount),"Could not serach the patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Part A : STEP : 2 and Step 3 : 
			//--------------------------------------------------------------------//
			//  Step-5: Super Bill Work Queue //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			assertTrue(click(selenium,lnkSuperBill),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifySuperBillDetailsInSuperBillQueue(selenium,billingData)){
				Assert.fail("Details are not displayed properly");
			}

			if(!isChecked(selenium,chkHardCopy)){
				Assert.fail("Hard Copy check is not chekced");
			}
			//Veriry Encounter Note Details in charge Entry page
			if(!verifyChargeEntryNote(selenium, encounterData)){
				Assert.fail("Encounter Note is not getting displayed");
			}
			assertTrue(click(selenium,btnPostChargeEntry),"Could not click the post button in charge Entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Part c - Primary Payer Makes a Payment Step : 6
			//--------------------------------------------------------------------//
			//  Step-6: Navigate To Post Payer Payment page //
			//--------------------------------------------------------------------//
			assertTrue(navigateToPostPaymentOption(selenium),"Could not serach the patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Enter Payer Payments //
			//--------------------------------------------------------------------//
			BillingLib payerPaymemtData = new BillingLib();
			payerPaymemtData.workSheetName = "PayerPayments";
			payerPaymemtData.testCaseId = "TC_PP_002";
			payerPaymemtData.fetchBillingTestData();
			
			payerPaymemtData.patientName = billingData.patientID;
			
			assertTrue(endToEndPayerPayment(selenium,payerPaymemtData,payerData, userAccount), "Payer Payment Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Part D Actions drop down on the individual Service Lines
			//--------------------------------------------------------------------//
			//  Step-8: Navigate To Billing History HX Charge Page//
			//--------------------------------------------------------------------//
			assertTrue(navigateToBillingHXCharge(selenium,billingData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkChargeHistory),"Could not click the charge entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Verify Charge Details
			if(!verfyChargeDetailsInChargePage(selenium,billingData)){
				Assert.fail("Hard Copy check is not chekced");
			}

			//Step : 8
			//--------------------------------------------------------------------//
			//  Step-8: void Charges//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkChargeHistory),"Could not click the charge entry in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(click(selenium,"xpath=(//a[contains(text(),'Actions')])[7]"),"Could not click charge Action in Charge Entry page", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			selenium.clickAt("xpath=(//a[contains(text(),'Actions')])[7]", "");
			
			assertTrue(click(selenium,lnkVoidCharge),"Could not click charge Action in Charge Entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnChrYes),"Could not click charge Action in Charge Entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//Step : 9
			//--------------------------------------------------------------------//
			//  Step-10: adjust Charge with credit $30//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkChargeHistory),"Could not click the charge entry in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			selenium.clickAt(lnkChargeAction, "");
			waitForPageLoad(selenium);
			
			String amountDue = getText(selenium,"totalAmountDueDiv").replace("$", "");
			System.out.println(amountDue);
			totalAmount = Float.parseFloat(amountDue);
			
			assertTrue(click(selenium,lnkAdjustCharge),"Could not click the Adjust charge in Charge Entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxchrReason,"End Credit");
			assertTrue(type(selenium, txtChrAmount,payerPaymemtData.credit),"Could not enter the charge amount",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnChrSave),"Could not click the save button in charge page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			credit =  Float.parseFloat(payerPaymemtData.credit);
			totalAmount = totalAmount - credit;
			payerPaymemtData.paidAmt1 = String.valueOf(totalAmount);
			
			if(!verifyBillingHistryCreditAmount(selenium,payerPaymemtData )){
				Assert.fail("Amount details are not displayed properly");
			}
			
			//Step : 10
			//--------------------------------------------------------------------//
			//  Step-10: adjust Charge with Debit $60//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkChargeHistory),"Could not click the charge entry in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkChargeAction, "");
			waitForPageLoad(selenium);
			
			String  debitamount = getText(selenium,"totalAmountDueDiv").replace("$", "");
			System.out.println(debitamount);
			totalAmount =  Float.parseFloat(debitamount);
			
			assertTrue(click(selenium,lnkAdjustCharge),"Could not click the Adjust charge in Charge Entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxchrReason,"End Debit");
			assertTrue(type(selenium, txtChrAmount,payerPaymemtData.debit),"Could not enter the charge amount",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnChrSave),"Could not click the save button in charge page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			
			debit =  Float.parseFloat(payerPaymemtData.debit);
			totalAmount = totalAmount + debit;
			payerPaymemtData.paidAmt1 = String.valueOf(totalAmount);
			
			
			
			if(!verifyBillingHistryDebitAmount(selenium,payerPaymemtData )){
				Assert.fail("Amount details are not displayed properly");
			}
			//Step : 11 : Change service line to Patient Payer
			assertTrue(click(selenium,lnkChargeHistory),"Could not click the charge entry in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkChargeAction, "");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkChangeToPatient),"Could not click the charge entry in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtPayerReason, "reason"),"Could not enter the paid amount", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnChrYes),"Could not click the yes button in charge entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			//Step : 12
			//--------------------------------------------------------------------//
			//  Step-10: Apply Paient Payemnt//
			//--------------------------------------------------------------------//
			BillingLib patientPaymemtData = new BillingLib();
			patientPaymemtData.workSheetName = "PostPatientPayment";
			patientPaymemtData.testCaseId = "TC_PPP_031";
			patientPaymemtData.fetchBillingTestData();
			
			assertTrue(patientPaymentAmount(selenium,patientPaymemtData),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkChargeHistory),"Could not click the charge entry in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkChargeAction, "");
			waitForPageLoad(selenium);
			
			String  patientAmount = getText(selenium,"totalAmountDueDiv").replace("$", "");
			patientPaymemtData.autoallocate = patientAmount;
			
			assertTrue(click(selenium,lnkApplyPatientPayment),"Could not click the charge entry in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtPAppliedAmount, patientPaymemtData.paidAmount),"Could not enter the paid amount", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnChrSave),"Could not click the save button in charge entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			if(!verifyPatientPaidAmount(selenium,patientPaymemtData )){
				Assert.fail("Amount details are not displayed properly");
			}
			
			//Step : 13
			//--------------------------------------------------------------------//
			//  Step-10: change payer//
			//-------------------------------------------------------------------//
			assertTrue(click(selenium,lnkChargeHistory),"Could not click the charge entry in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkchargePayerAction, "");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkChangePayer),"Could not click the Change payer in charge entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			currentPayer = getText(selenium,"xpath=(//div[@id='currentPayer'])["+counter+"]");
				if(currentPayer.equals("ASP007")){
					selectValueFromAjaxList(selenium,"suggestBox","EndToEndPayer3" );
					}else if(currentPayer.equals("ASP008")){
					selectValueFromAjaxList(selenium,"suggestBox","EndToEndPayer2" );
				}	
			assertTrue(type(selenium,txtPayerReason, "reason"),"Could not enter the paid amount", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSend),"Could not click the send button in charge entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyPayerAmountInSummary(selenium,patientPaymemtData )){
				Assert.fail("Amount details are not displayed properly");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

		return true;
	}
	
	public boolean verifyPayerAmountInSummary(Selenium selenium, BillingLib patientPaymemtData )throws IOException{
		
		String  patientAmount = getText(selenium,"totalAmountDueDiv").replace("$", "");
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkBillingSummary),"Could not click the Summary link in Billing summary page", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(!getText(selenium,lblInsurance).contains(patientAmount)){
			return false;
		}
		
		if(!selenium.isTextPresent(patientPaymemtData.paidAmount)){
			return false;
		}
		
		if(!getText(selenium,txtUnAppliedAmount).contains("0.00")){
			return false;
		}
		
		if(!getText(selenium,lblPatientBalance).contains("0.00")){
			return false;
		}
		return true;
	}
	
}
