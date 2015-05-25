package com.nexia.selenium.testscripts.section.billing.endtoendtesting;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.DemographicsPageFactoring;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.thoughtworks.selenium.Selenium;

public class CreateEndToEndWorkFlowFourth extends AbstractBilling{
	
	@Test(groups = {"EndToEnd","Developing","firefox", "iexplore", "safari", "default"}, description = "Verify add new claim in payer payments")//, dependsOnGroups = "BeforeCreatePatientAndPayerFourth")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endToEndWorkFlow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "SuperBillEntry";
		billingData.testCaseId = "TC_SBE_009";
		billingData.fetchBillingTestData();
		endToEndWorkFlow(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
	
	 /*************************************************************************************************** 
	* @purpose        Verify End To end Work Flow 
	* @action 		  Verify End To end Work Flow in  Biller related 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @ticket		  #8865	
	* @useraccount    US
	* @since  	      Mar 22, 2014	
	***************************************************************************************************/
	public boolean endToEndWorkFlow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		String date = null;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			//------------------------------------------------------------------------------------//
			//  Step-2: Validate that Service Codes with future effective date cannot be posted //
			//------------------------------------------------------------------------------------//
			AbstractChartPreVisit chartVisit = new AbstractChartPreVisit();
			ChartPreVisitLib encounterData = new ChartPreVisitLib();
			
			HomeLib payerData = new HomeLib();
			payerData.workSheetName = "AddPayers";
			payerData.testCaseId = "TC_CP_033";
			payerData.fetchHomeTestData();
			billingData.patientID = payerData.patientId;
				
			
			
			assertTrue(navigateToViewChart(selenium,billingData,chartVisit),"Could not serach the patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Navigate to Encounter Page
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
			
		
			//Create Complete Super Bill Template //
			
			assertTrue(endToEndCompleteSuperBill(selenium,billingData,payerData,userAccount),"could not create complete super bill template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//----------------------------------------------------------------------------------//
			//  Step-2:Validate that Service Codes with future effective date cannot be posted //
			//---------------------------------------------------------------------------------//
			
			BillingLib billingData1 = new BillingLib();
			billingData1.workSheetName = "SuperBillEntry";
			billingData1.testCaseId = "TC_SBE_010";
			billingData1.fetchBillingTestData();
			
			billingData1.patientID = payerData.patientId;
			
			assertTrue(navigateToViewChart(selenium,billingData1,chartVisit),"Could not serach the patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			// navigat to Encounter Page //
			
			assertTrue(click(selenium,chartVisit.lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(chartVisit.deleteAllEncounters(selenium,encounterData),"Could not delete", selenium, ClassName, MethodName);
			assertTrue(chartVisit.goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium, chartVisit.ajxEncounterProvider,provider);
			waitForPageLoad(selenium);
			
			//Create Diagnosis Code
			assertTrue(chartVisit.createDiagnosisCodes(selenium,encounterData,userAccount),"Could not create the Assessment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//Create Complete Super Bill Template //
			assertTrue(endToEndCompleteSuperBill(selenium,billingData1,payerData,userAccount),"could not create complete super bill template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//----------------------------------------------------------------------------------//
			//  Step-3: Validate that Service Codes with future effective date cannot be posted//
			//---------------------------------------------------------------------------------//
			BillingLib billingData2 = new BillingLib();
			billingData2.workSheetName = "SuperBillEntry";
			billingData2.testCaseId = "TC_SBE_011";
			billingData2.fetchBillingTestData();
			billingData2.patientID = payerData.patientId;
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(callChargeEntry(selenium,billingData2),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//claim creation : 1
			assertTrue(claimCreationOne(selenium,billingData2,payerData,userAccount),"Could not create cliam creation",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
		
			//Navigate To Post Payer Payment page and the payer payment and verify the allowed amount//
		
			assertTrue(navigateToPostPaymentOption(selenium),"Could not serach the patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			BillingLib payerPaymemtData = new BillingLib();
			payerPaymemtData.workSheetName = "PayerPayments";
			payerPaymemtData.testCaseId = "TC_PP_005";
			payerPaymemtData.fetchBillingTestData();
			
			payerPaymemtData.patientName = billingData2.patientID;
			
			assertTrue(verifyAllowedForPayerPayment(selenium,payerPaymemtData,payerData, userAccount), "Payer Payment Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//Navigate To Post Payer Payment page and the payer payment and verify the allowed amount//
		
			payerPaymemtData.patientName = billingData2.patientID;
			
			assertTrue(navigateToBillingHXCharge(selenium,billingData2),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPatientOption),"Could not click the Patient Option link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(navigateToPostPaymentOption(selenium),"Could not serach the patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			payerPaymemtData.testCaseId = "TC_PP_006";
			payerPaymemtData.fetchBillingTestData();
			
			assertTrue(verifyAllowedForPayerPayment(selenium,payerPaymemtData,payerData, userAccount), "Payer Payment Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------------------------------------//
			//  Step-4: Validate that Updating Fees is working//
			//--------------------------------------------------------------------------------------------------//
			//Navigate to Service code
			assertTrue(navigateToServiceCode(selenium),"Could not navigate to service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnUpdateFees),"Could not click the Update fee button in Service page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyUpdateFeeInServiceCode(selenium,billingData2,userAccount ),"Could not navigate to service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			billingData2.workSheetName = "SuperBillEntry";
			billingData2.testCaseId = "TC_SBE_011";
			billingData2.fetchBillingTestData();
			
			billingData2.patientID = payerData.patientId;
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(navigateToViewChart(selenium,billingData2,chartVisit),"Could not serach the patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Navigate to Encounter Page //
			assertTrue(click(selenium,chartVisit.lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(chartVisit.deleteAllEncounters(selenium,encounterData),"Could not delete", selenium, ClassName, MethodName);
			assertTrue(chartVisit.goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium, chartVisit.ajxEncounterProvider,provider);
			waitForPageLoad(selenium);
			
			//Create Diagnosis Code
			assertTrue(chartVisit.createDiagnosisCodes(selenium,encounterData,userAccount),"Could not create the Assessment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//Create Complete Super Bill Template //
			assertTrue(endToEndCompleteSuperBill(selenium,billingData2,payerData,userAccount),"Could not serach the patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			//---------------------------------------------------------------------------------------------------//
			//  Step-6 : Validate that changes at settings level have an effect (Payer)//
			//--------------------------------------------------------------------------------------------------//
			//Search patient and navigate to Billing History payer 
			assertTrue(navigateToBillingHXCharge(selenium,billingData2),"Could not navigate to Billing Hx Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Modified Payer date So it is outSide of Super bill
			DemographicsPageFactoring demoData = new DemographicsPageFactoring();
			
			HomeLib payer1Data = new HomeLib();
			payer1Data.workSheetName = "AddPayers";
			payer1Data.testCaseId = "TC_CP_034";
			payer1Data.fetchHomeTestData();
			
			assertTrue(click(selenium,demoData.lnkPayerHistory),"Could not click the Payer link in Billing History page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,demoData.btnEdit1),"Could not click the Edit button in Payer page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	cal.add(Calendar.DATE,2);
				date = DateFormat1.format(cal.getTime());
		    }else {
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
				cal.add(Calendar.DATE,2);
				date = DateFormat1.format(cal.getTime());
			}
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,demoData.btnYesButton),"Could not click the yes button in Edit Payer page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String payer = getValue(selenium,demoData.ajxPayerSelect);
			System.out.println(payer);
			assertTrue(type(selenium,demoData.txtPayerStartDate,date ),"Could not enter the Start Date", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,demoData.btnlnkSave),"Could not click the Save button in Edit Payer page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSuperBill),"Could not click super bill link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//SuperBill Queue
			if(!verifySuperBillDetailsInSuperBillQueue(selenium,billingData2)){
				Assert.fail("Details are not displayed properly");
			}
			
			if(selenium.isTextPresent(payer)){
				Assert.fail("Payer name is getting displayed in charge entry page, after modified Effectice date");
			}
			else
			
				return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
		
	}
	
	
	public boolean verifyChargeEntryPage(Selenium selenium,HomeLib payerData, HomeLib payer1Data ){
		
		if((selenium.isTextPresent(payerData.payerName)&&(selenium.isTextPresent(payer1Data.payerName)))){
			return false;
		}
		
		if(!selenium.isTextPresent("Patient")){
			return false;
		}
		
		return true;
	}
}
