package com.nexia.selenium.testscripts.section.billing.postpatientpayments;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPaidAmountDetails extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify charge Amount Less then Paid Amount for Post Patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void chargeAmountLessThenpaidAmountWithPostPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_012";
		PostPatientPaymentData.fetchBillingTestData();
		verifyPaidAmount(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify charge Amount greater then Paid Amount for Post Patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void chargeAmountGreaterThenPaidAmountWithPostPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_013";
		PostPatientPaymentData.fetchBillingTestData();
		verifyPaidAmount(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify  charge Amount equal to paid amount for Enter Patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void chargeAmountEqualPaidAmountWithPostPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_014";
		PostPatientPaymentData.fetchBillingTestData();
		verifyPaidAmount(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for charge Amount Less then Paid Amount for Enter Patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void chargeAmountLessThenPaidAmountWithEntryPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_015";
		PostPatientPaymentData.fetchBillingTestData();
		verifyPaidAmount(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for charge Amount Greater than Paid Amount for Enter Patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void chargeAmountEqualPaidAmountWithEntryPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_016";
		PostPatientPaymentData.fetchBillingTestData();
		verifyPaidAmount(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for charge Amount equal to Paid Amount for Enter Patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void chargeEntryEqulaPaidAmountWithEntryPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_017";
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
		int sAmount;
		int paidAmount;
		int unAppliedAmount;
		String unAAmount;
		String sPaidAmount;
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
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_012")||PostPatientPaymentData.testCaseId.equals("TC_PPP_013")
					||PostPatientPaymentData.testCaseId.equals("TC_PPP_014")){
				assertTrue(click(selenium,lnkPPatientPaymentQueue),"Could not click the Post Patient Payment Queue", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lnkStartNewBranch)){
					assertTrue(click(selenium, lnkStartNewBranch),"Could not click the Start New branch Link", selenium,ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			}
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_015")||PostPatientPaymentData.testCaseId.equals("TC_PPP_016")||PostPatientPaymentData.testCaseId.equals("TC_PPP_017")){
				assertTrue(navigateToEnterPatientPayment(selenium),"Could not navigate to Post Payment Page", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-4: create post payment //
			//--------------------------------------------------------------------//
			assertTrue(addPostPatientPayment(selenium,PostPatientPaymentData),"Post patient payment creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------------------------//
			//  Step-5: verifying the waring message for charge amount greater than to paid amount //
			//------------------------------------------------------------------------------------//
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_013")||PostPatientPaymentData.testCaseId.equals("TC_PPP_016")){
				BillingLib chargeEntryData = new BillingLib();
				chargeEntryData.workSheetName = "PostChargePortablity";
				chargeEntryData.testCaseId = "TC_PCP_009";
				chargeEntryData.fetchBillingTestData();
				
				sAmount = Integer.parseInt(chargeEntryData.fee)+5;
				sPaidAmount = String.valueOf(sAmount);
				assertTrue(type(selenium,txPaidAmount1,sPaidAmount),"Could not Enter the Service Paid Amount", selenium, ClassName, MethodName);
				
				if(getText(selenium,imgSPaidAmount).contains("The payment amount will result in a credit balance. Do you want to continue?")){
					assertTrue(click(selenium,btnPPRemoveYes),"Could not click the Yes button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					 paidAmount = Integer.parseInt(PostPatientPaymentData.paidAmount);
					//Calcluate the unapplied amount
					 unAppliedAmount = paidAmount - sAmount;
					 unAAmount = String.valueOf(unAppliedAmount);
					 if(!getText(selenium, txtUnAppliedAmount).contains(unAAmount)){
							Assert.fail("Charge amount is not updated");	
						}else
							returnValue = true;
				}
			}
			
			//---------------------------------------------------------------------------------------//
			//  Step-6: verifying charge amount Less than to paid amount //
			//------------------------------------------------------------------------------------//
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_012")||PostPatientPaymentData.testCaseId.equals("TC_PPP_015")){
				 
				BillingLib chargeEntryData = new BillingLib();
				chargeEntryData.workSheetName = "PostChargePortablity";
				chargeEntryData.testCaseId = "TC_PCP_008";
				chargeEntryData.fetchBillingTestData();
				
				
				sAmount = Integer.parseInt(chargeEntryData.fee)-5;
				 sPaidAmount = String.valueOf(sAmount);
				 assertTrue(type(selenium,txPaidAmount1,sPaidAmount),"Could not Enter the Service Paid Amount", selenium, ClassName, MethodName);
				 selenium.isTextPresent(sPaidAmount);
				 
				 paidAmount = Integer.parseInt(PostPatientPaymentData.paidAmount);
				 
				 //Calcluate the unapplied amount
				 unAppliedAmount = paidAmount - sAmount;
				 unAAmount = String.valueOf(unAppliedAmount);
				 if(!getText(selenium, txtUnAppliedAmount).contains(unAAmount)){
						Assert.fail("Charge amount is not updated");	
					}else
						returnValue = true;
			}
			
			//---------------------------------------------------------------------------------------//
			//  Step-7: verifying charge amount equal to paid amount //
			//------------------------------------------------------------------------------------//
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_014")||PostPatientPaymentData.testCaseId.equals("TC_PPP_017")){
				 
				BillingLib chargeEntryData = new BillingLib();
				chargeEntryData.workSheetName = "PostChargePortablity";
				chargeEntryData.testCaseId = "TC_PCP_010";
				chargeEntryData.fetchBillingTestData();
				
				 sAmount = Integer.parseInt(chargeEntryData.fee);
				 sPaidAmount = String.valueOf(sAmount);
				 assertTrue(type(selenium,txPaidAmount1,sPaidAmount),"Could not Enter the Service Paid Amount", selenium, ClassName, MethodName);
				 selenium.isTextPresent(sPaidAmount);
				 
				 
				 paidAmount = Integer.parseInt(PostPatientPaymentData.paidAmount);
				 
				 //Calcluate the unapplied amount
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
