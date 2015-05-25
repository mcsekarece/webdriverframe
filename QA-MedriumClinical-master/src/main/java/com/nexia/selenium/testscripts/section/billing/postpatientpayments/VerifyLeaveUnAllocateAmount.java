package com.nexia.selenium.testscripts.section.billing.postpatientpayments;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLeaveUnAllocateAmount extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Leave Un Allocate Amount Using ok Button With Post Patient Payment ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void leaveUnAllocateAmountOkWithPostPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_023";
		PostPatientPaymentData.fetchBillingTestData();
		verifyAutoAllocateAmount(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Leave Un Allocate Amount Using ok Button With Enter Patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void leaveUnAllocateAmountOkWithEntryPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_024";
		PostPatientPaymentData.fetchBillingTestData();
		verifyAutoAllocateAmount(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Leave Un Allocate Amount Using Cancel Button With Post Patient Payment ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void leaveUnAllocateAmountCancelWithPostPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_025";
		PostPatientPaymentData.fetchBillingTestData();
		verifyAutoAllocateAmount(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Leave Un Allocate Amount Using Cancel Button With Enter Patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void leaveUnAllocateAmountCancelWithEntryPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_026";
		PostPatientPaymentData.fetchBillingTestData();
		verifyAutoAllocateAmount(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify leave UnAllocate Amount For Post Patient Payment
	* @action 		  verify Create  For Post Patient Payment
	* @expected       To Ensure that the verify Create Post Patient Payment works fine 
	* @Specification  SRS_BLG_Patient Payments Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 04, 2014
	***************************************************************************************************/
	
	public boolean verifyAutoAllocateAmount(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib PostPatientPaymentData) throws IOException{
		
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
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_023")||PostPatientPaymentData.testCaseId.equals("TC_PPP_025")){
				assertTrue(click(selenium,lnkPPatientPaymentQueue),"Could not click the Post Patient Payment Queue", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lnkStartNewBranch)){
					assertTrue(click(selenium, lnkStartNewBranch),"Could not click the Start New branch Link", selenium,ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			}
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_024")||PostPatientPaymentData.testCaseId.equals("TC_PPP_026")){
				assertTrue(navigateToEnterPatientPayment(selenium),"Could not navigate to Post Payment Page", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: create post payment //
			//--------------------------------------------------------------------//
			assertTrue(addPostPatientPayment(selenium,PostPatientPaymentData),"Post patient payment creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Type Paid Amount //
			//--------------------------------------------------------------------//
			
			BillingLib chargeEntryData = new BillingLib();
			chargeEntryData.workSheetName = "PostChargePortablity";
			chargeEntryData.testCaseId = "TC_PCP_014";
			chargeEntryData.fetchBillingTestData();
			
			sAmount = Integer.parseInt(chargeEntryData.fee);
			sPaidAmount = String.valueOf(sAmount);
			assertTrue(type(selenium,txPaidAmount1,sPaidAmount),"Could not Enter the Service Paid Amount", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify UnAllocate Amount Message//
			//--------------------------------------------------------------------//
			
			if(!isChecked(selenium,chkUnAllocate)){
				assertTrue(click(selenium, chkUnAllocate),"Could not check the leave un allocate check box", selenium,ClassName, MethodName);
			}
			if(!getText(selenium,imgUnAllocatedPopUp).contains("Applied payments will be removed")){
				Assert.fail("UnAllocated Payment pop up message is not displayed properly");
			}
			
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_023")||PostPatientPaymentData.testCaseId.equals("TC_PPP_024")){
				assertTrue(click(selenium,btnPPRemoveYes),"Could not click the Yes button",selenium, ClassName, MethodName);
				if(!getText(selenium, txtUnAppliedAmount).contains(PostPatientPaymentData.paidAmount)){
					Assert.fail("Charge amount is not updated");	
				}else
					returnValue = true;
			}
				
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_025")||PostPatientPaymentData.testCaseId.equals("TC_PPP_026")){
				assertTrue(click(selenium,btnPPRemoveNo),"Could not click the Cancel button",selenium, ClassName, MethodName);
				
				paidAmount = Integer.parseInt(PostPatientPaymentData.paidAmount);
				 
				 unAppliedAmount = paidAmount - sAmount;
				 unAAmount = String.valueOf(unAppliedAmount);
				if(!getText(selenium, txtUnAppliedAmount).contains(unAAmount)){
					Assert.fail("Charge amount is not updated");	
				}else
					returnValue = true;
			}
			

		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
