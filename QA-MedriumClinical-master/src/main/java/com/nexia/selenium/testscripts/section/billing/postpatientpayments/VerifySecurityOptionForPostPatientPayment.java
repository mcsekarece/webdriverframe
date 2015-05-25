package com.nexia.selenium.testscripts.section.billing.postpatientpayments;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForPostPatientPayment extends AbstractBilling{
	@Test(groups = {"AdvancedSmoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib postPatientPaymentData = new BillingLib();
		postPatientPaymentData.workSheetName = "VerifySecurityOption";
		postPatientPaymentData.testCaseId = "TC_VSP_001";
		postPatientPaymentData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, postPatientPaymentData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib postPatientPaymentData = new BillingLib();
		postPatientPaymentData.workSheetName = "VerifySecurityOption";
		postPatientPaymentData.testCaseId = "TC_VSP_002";
		postPatientPaymentData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, postPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib postPatientPaymentData = new BillingLib();
		postPatientPaymentData.workSheetName = "VerifySecurityOption";
		postPatientPaymentData.testCaseId = "TC_VSP_003";
		postPatientPaymentData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, postPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib postPatientPaymentData = new BillingLib();
		postPatientPaymentData.workSheetName = "VerifySecurityOption";
		postPatientPaymentData.testCaseId = "TC_VSP_004";
		postPatientPaymentData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, postPatientPaymentData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Security Option For Post Patient Payment
	* @action 		  verify Security Option For Post Patient Payment
	* @expected       To Ensure that the Security Option For Post Patient Payment is work fine 
	* @Specification  SRS_BLG_Patient Payments Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 08, 2014
	***************************************************************************************************/
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib postPatientPaymentData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue = false;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + postPatientPaymentData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, postPatientPaymentData.userName, postPatientPaymentData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch to Biller role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,postPatientPaymentData.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
			if(postPatientPaymentData.testCaseId.equals("TC_VSP_003")){
				
				if(isElementPresent(selenium,lnkPPatientPaymentQueue)){
					Assert.fail("Post Patient Payment link is present in No access role");
				}else
					return true;
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Full, View only And  Limited Access role			 //
			//--------------------------------------------------------------------//
			if(!verifySecurityOption(selenium,postPatientPaymentData)){
				Assert.fail("Security option not show properly; More Details :"+postPatientPaymentData.toString());
			}else
				returnValue = true; 
			
			
		
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifySecurityOption(Selenium selenium, BillingLib postPatientPaymentData) throws IOException{
		
		//View Only Access
		if(postPatientPaymentData.testCaseId.equals("TC_VSP_002")){
			if(selenium.isVisible(lnkPPatientPaymentQueue)){
				Assert.fail("Post Patient Payment link is present in No access role");
			}
			
		}
		
		//Limited Access
		if(postPatientPaymentData.testCaseId.equals("TC_VSP_001")){
			BillingLib PostPatientPaymentData = new BillingLib();
			PostPatientPaymentData.workSheetName = "PostPatientPayment";
			PostPatientPaymentData.testCaseId = "TC_PPP_008";
			PostPatientPaymentData.fetchBillingTestData();
			
			
			assertTrue(click(selenium,lnkPPatientPaymentQueue),"Could not click the Post Patient Payment Queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkStartNewBranch))
				assertTrue(click(selenium, lnkStartNewBranch),"Could not click the Start New branch Link", selenium,ClassName, MethodName);
				waitForPageLoad(selenium);
			
				if(selenium.isVisible(btnPost)){
					Assert.fail("Post button is present in  Limited access role");
				}	
				
			//Create post patient payment
			assertTrue(addPostPatientPayment(selenium,PostPatientPaymentData),"createion failled", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			if(!isElementPresent(selenium,lnkPPatientPaymentQueue)){
				Assert.fail("Post patient payment is present in Limited access role");
			}	
		}
		
		//Full Access
		
		if(postPatientPaymentData.testCaseId.equals("TC_VSP_004")){
			BillingLib PostPatientPaymentData = new BillingLib();
			PostPatientPaymentData.workSheetName = "PostPatientPayment";
			PostPatientPaymentData.testCaseId = "TC_PPP_020";
			PostPatientPaymentData.fetchBillingTestData();
			
			
			assertTrue(click(selenium,lnkPPatientPaymentQueue),"Could not click the Post Patient Payment Queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkStartNewBranch))
				assertTrue(click(selenium, lnkStartNewBranch),"Could not click the Start New branch Link", selenium,ClassName, MethodName);
				waitForPageLoad(selenium);
			
				if(!(isElementPresent(selenium,btnPost)&&(isElementPresent(selenium,btnPPPCancel)&&(isElementPresent(selenium,btnPPtSave))))){
					Assert.fail("Post, Cancel and Save  buttons are not  present in  Full access role");
				}		
				
			//Create post patient payment
			assertTrue(addPostPatientPayment(selenium,PostPatientPaymentData),"createion failled", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			if(!isElementPresent(selenium,lnkPPatientPaymentQueue)){
				Assert.fail("Post patient payment is present in Full access role");
			}	
		}
		return true;
		
		
	}
	
	
	
}
