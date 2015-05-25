package com.nexia.selenium.testscripts.section.billing.postpatientpayments;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAutoAllocatePayment extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Auto Allocate Payment for Post Patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void autoAllocatePaymentWithPostPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_018";
		PostPatientPaymentData.fetchBillingTestData();
		verifyAutoAllocatePayment(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Auto Allocate Payment for Entry Patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void autoAllocatePaymentWithEntryPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_019";
		PostPatientPaymentData.fetchBillingTestData();
		verifyAutoAllocatePayment(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	/*******************************************************************************************************
	* @purpose        To verify Auto Allocate Payment For Post Patient Payment and Enter Patient Payment
	* @action 		  verify Auto Allocate Payment For Post Patient Payment and Enter Patient Payment
	* @expected       To Ensure that the Auto Allocate Payment works fine 
	* @Specification  SRS_BLG_Patient Payments Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 07, 2014
	********************************************************************************************************/
	
	public boolean verifyAutoAllocatePayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib PostPatientPaymentData) throws IOException{
		
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
			//  Step-4: Navigate to Post Patiment Payments Page //
			//--------------------------------------------------------------------//
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_018")){
				assertTrue(click(selenium,lnkPPatientPaymentQueue),"Could not click the Post Patient Payment Queue", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lnkStartNewBranch)){
					assertTrue(click(selenium, lnkStartNewBranch),"Could not click the Start New branch Link", selenium,ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			}
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_019")){
				assertTrue(navigateToEnterPatientPayment(selenium),"Could not navigate to Post Payment Page", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: create post payment //
			//--------------------------------------------------------------------//
			assertTrue(addPostPatientPayment(selenium,PostPatientPaymentData),"Post patient payment creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify Auto Allocate Payment and Auto Allocate Check box //
			//--------------------------------------------------------------------//
			
			if(!isChecked(selenium,chkAutoAllocatePayment)){
				assertTrue(click(selenium,chkAutoAllocatePayment),"Could not click the auto allocate payment check box",selenium, ClassName, MethodName);
			}
			
			if(isChecked(selenium,chkAutoAllocatePayment)&&(isChecked(selenium,chkAutoAllocate))){
				returnValue = true;
			}
			BillingLib chargeEntryData = new BillingLib();
			chargeEntryData.workSheetName = "PostChargePortablity";
			chargeEntryData.testCaseId = "TC_PCP_011";
			chargeEntryData.fetchBillingTestData();
			
			//Calcluate the unapplied amount
			 sAmount = Integer.parseInt(chargeEntryData.fee);
			 sPaidAmount = String.valueOf(sAmount);
			 assertTrue(type(selenium,txPaidAmount1,sPaidAmount),"Could not Enter the Service Paid Amount", selenium, ClassName, MethodName);
			 selenium.isTextPresent(sPaidAmount);
			 
			 
			 paidAmount = Integer.parseInt(PostPatientPaymentData.paidAmount);
			 
			 
			 unAppliedAmount = paidAmount - sAmount;
			 unAAmount = String.valueOf(unAppliedAmount);
			 selenium.isTextPresent(unAAmount);
			
			 
			 if(!getText(selenium, txtUnAppliedAmount).contains(unAAmount)){
					Assert.fail("Charge amount is not updated");	
				}else
					returnValue = true;
			//--------------------------------------------------------------------//
			//  Step-7: verify Auto Allocate Payment and Auto Allocate Check box //
			//--------------------------------------------------------------------//
			 
			 if(isChecked(selenium,chkAutoAllocatePayment)){
					assertTrue(click(selenium,chkAutoAllocatePayment),"Could not click the auto allocate payment check box",selenium, ClassName, MethodName);
			}
				
			if((!isChecked(selenium,chkAutoAllocatePayment))&&((isChecked(selenium,chkAutoAllocate)))){
				returnValue = true;
			}
			

		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
