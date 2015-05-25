package com.nexia.selenium.testscripts.section.billing.postpatientpayments;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPaidAmountInTopOfBatch  extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify  Paid Amount with Post Patient payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPaidAmountWithPostPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_027";
		PostPatientPaymentData.fetchBillingTestData();
		verifyPaidAmount(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify verify  Paid Amount with Entry Patient payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPaidAmountWithEnterPostPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_028";
		PostPatientPaymentData.fetchBillingTestData();
		verifyPaidAmount(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Paid Amount For Post Patient Payment and Entery Patient Payment 
	* @action 		  verify Paid Amount For Post Patient Payment and Entery Patient Payment 
	* @expected       To Ensure that the verify Paid Amount works fine 
	* @Specification  SRS_BLG_Patient Payments Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 06, 2014
	***************************************************************************************************/
	
	public boolean verifyPaidAmount(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib PostPatientPaymentData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue=false;
		
		String unAAmount;
		int paidAmount;
		int sAmount;
		String sPaidAmount;
		int unAppliedAmount;
		try {
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + PostPatientPaymentData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, PostPatientPaymentData.userName, PostPatientPaymentData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch to Biller role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,PostPatientPaymentData.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Post Patiment Payments Page //
			//--------------------------------------------------------------------//
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_027")){
				assertTrue(click(selenium,lnkPPatientPaymentQueue),"Could not click the Post Patient Payment Queue", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lnkStartNewBranch)){
					assertTrue(click(selenium, lnkStartNewBranch),"Could not click the Start New branch Link", selenium,ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			}
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_028")){
				assertTrue(navigateToEnterPatientPayment(selenium),"Could not navigate to Post Payment Page", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-4: create post payment //
			//--------------------------------------------------------------------//
			assertTrue(addPostPatientPayment(selenium,PostPatientPaymentData),"Post patient payment creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------------------------//
			//  Step-5: Calculate the un applied ammount//
			//------------------------------------------------------------------------------------//
			
			BillingLib chargeEntryData = new BillingLib();
			chargeEntryData.workSheetName = "PostChargePortablity";
			chargeEntryData.testCaseId = "TC_PCP_015";
			chargeEntryData.fetchBillingTestData();
			
			sAmount = Integer.parseInt(chargeEntryData.fee);
			sPaidAmount = String.valueOf(sAmount);
			assertTrue(type(selenium,txPaidAmount1,sPaidAmount),"Could not Enter the Service Paid Amount", selenium, ClassName, MethodName);
			
			 
			 
			paidAmount = Integer.parseInt(PostPatientPaymentData.paidAmount);
			 
			//Calcluate the un applied amount
			unAppliedAmount = paidAmount - sAmount;
			unAAmount = String.valueOf(unAppliedAmount);
			 
			if(!getText(selenium,txtUnAppliedAmount).contains(unAAmount)){
				Assert.fail("Could not calculate the un applied amount");
			}
			//---------------------------------------------------------------------------------------//
			//  Step-5: Verify Top of the batch Amount//
			//------------------------------------------------------------------------------------//
			if(!verifyStoreValue(selenium,PostPatientPaymentData ,sPaidAmount,unAAmount)){
				Assert.fail("Amount details are not displayed properly");
			}else
				returnValue = true;
			
			

		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyStoreValue(Selenium selenium,BillingLib PostPatientPaymentData,String sPaidAmount, String unAAmount){
		
		
		if(!getText(selenium,lblTotalPaidAmount).contains(PostPatientPaymentData.paidAmount)){
			return false;
		}	
		
		if(!getText(selenium,lblTotalAppliedAmount).contains(sPaidAmount)){
			return false;
		}
		
		if(!getText(selenium,lblTotalUnAppliedAmount).contains(unAAmount)){
			return false;
		}
		return true;
	}
	
}
