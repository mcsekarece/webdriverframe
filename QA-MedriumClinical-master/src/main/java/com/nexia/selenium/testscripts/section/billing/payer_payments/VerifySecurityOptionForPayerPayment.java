package com.nexia.selenium.testscripts.section.billing.payer_payments;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForPayerPayment extends AbstractBilling{
	@Test(groups = {"AdvancedSmokeUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib postPayerPaymentData = new BillingLib();
		postPayerPaymentData.workSheetName = "VerifySecurityOption";
		postPayerPaymentData.testCaseId = "TC_VSP_001";
		postPayerPaymentData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, postPayerPaymentData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib postPayerPaymentData = new BillingLib();
		postPayerPaymentData.workSheetName = "VerifySecurityOption";
		postPayerPaymentData.testCaseId = "TC_VSP_002";
		postPayerPaymentData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, postPayerPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib postPayerPaymentData = new BillingLib();
		postPayerPaymentData.workSheetName = "VerifySecurityOption";
		postPayerPaymentData.testCaseId = "TC_VSP_003";
		postPayerPaymentData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, postPayerPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib postPayerPaymentData = new BillingLib();
		postPayerPaymentData.workSheetName = "VerifySecurityOption";
		postPayerPaymentData.testCaseId = "TC_VSP_004";
		postPayerPaymentData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, postPayerPaymentData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To verify Security Option For Payer Payment
	* @action 		  verify Security Option For Post Payer Payment
	* @expected       To Ensure that the Security Option For Payer Payment is work fine 
	* @Specification  SRS_BLG_Payer_Payments_Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Review
	* @useraccount    US
	* @since  	      Feb 11, 2014
	***************************************************************************************************/
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib postPayerPaymentData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue = false;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + postPayerPaymentData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, postPayerPaymentData.userName, postPayerPaymentData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch to Biller role 									  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,postPayerPaymentData.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										  //
			//--------------------------------------------------------------------//
			if(postPayerPaymentData.testCaseId.equals("TC_VSP_003")){
				
				if(isElementPresent(selenium,lnkPayerPayment)){
					Assert.fail("Post Payer Payment link is present in No access role");
				}else
					return true;
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Full, View only And  Limited Access role			 //
			//--------------------------------------------------------------------//
			if(!verifySecurityOption(selenium,postPayerPaymentData, userAccount)){
				Assert.fail("Security option not show properly; More Details :"+postPayerPaymentData.toString());
			}else
				returnValue = true; 
			
			
		
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifySecurityOption(Selenium selenium, BillingLib postPayerPaymentData, String userAccount) throws IOException{
		
		//View Only Access
		if(postPayerPaymentData.testCaseId.equals("TC_VSP_002")){
			assertTrue(click(selenium, lnkQuickAction),"Could not click the Quick Action", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lnkPayerPayment)){
				Assert.fail("Enter patient payment is present in  View only access role");
			}	
				
		}
		
		//Limited Access
		if(postPayerPaymentData.testCaseId.equals("TC_VSP_001")){
		
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to payer payment								  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToBatchPayerPayment(selenium),"Could not navigate to service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify add new payer payments and post					  //
			//--------------------------------------------------------------------//
			if(selenium.isVisible(btnPost)){
				return false;
			}
		}

		//Full Access and Limited Access
		if((postPayerPaymentData.testCaseId.equals("TC_VSP_004"))){
			postPayerPaymentData.workSheetName = "PayerPayments";
			postPayerPaymentData.testCaseId = "TC_PP_001";
			postPayerPaymentData.fetchBillingTestData();
			
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
			
			postPayerPaymentData.adjustmentReason = adjustmentCodeData.adjusmentReason;
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to payer payment								  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToBatchPayerPayment(selenium),"Could not navigate to service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify add new payer payments and post					  //
			//--------------------------------------------------------------------//
			assertTrue(fillBatchPayerEntry(selenium, postPayerPaymentData, userAccount), "Could not fill all batch payer entry", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			postPayerPaymentData.patientID = chargeEntryData.patientID;
			
			assertTrue(type(selenium, txtClaimPatientSearch, postPayerPaymentData.patientID),"Could not type patient id", selenium, ClassName, MethodName);
			
			selenium.keyPress(txtClaimPatientSearch, "\\13");
			waitForElement(selenium,lblPatientResult,10000);
			
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+postPayerPaymentData.patientName, selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(postPayerPaymentData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"", selenium, ClassName, MethodName);
			click(selenium,lblPatientResult);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnPost), "Could not click the post button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, btnYesInPost), "Could not click the yes button in post", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}
		
		return true;
		
		
	}
}
