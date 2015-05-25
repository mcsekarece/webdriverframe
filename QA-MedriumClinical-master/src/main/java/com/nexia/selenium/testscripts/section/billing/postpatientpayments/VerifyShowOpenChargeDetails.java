package com.nexia.selenium.testscripts.section.billing.postpatientpayments;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyShowOpenChargeDetails extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Create Post Patient Payment With Hide Details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addPostPatientPaymentWithShowDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_002";
		PostPatientPaymentData.fetchBillingTestData();
		postPatientPaymentWithSinglePatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Create Post Patient Payment
	* @action 		  verify Create Post Patient Payment
	* @expected       To Ensure that the verify Create Post Patient Payment works fine 
	* @Specification  SRS_BLG_Patient Payments Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 04, 2014
	***************************************************************************************************/
	
	public boolean postPatientPaymentWithSinglePatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib PostPatientPaymentData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue=false;
		
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
			
			BillingLib chargeEntryData = new BillingLib();
			chargeEntryData.workSheetName = "PostChargePortablity";
			chargeEntryData.testCaseId = "TC_PCP_002";
			chargeEntryData.fetchBillingTestData();
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Post Patiment Payments Page //
			//--------------------------------------------------------------------//
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_002")){
				assertTrue(click(selenium,lnkPPatientPaymentQueue),"Could not click the Post Patient Payment Queue", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lnkStartNewBranch))
					assertTrue(click(selenium, lnkStartNewBranch),"Could not click the Start New branch Link", selenium,ClassName, MethodName);
					waitForPageLoad(selenium);
			}
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_011")){
				assertTrue(navigateToEnterPatientPayment(selenium),"Could not navigate to Post Payment Page", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: create post payment //
			//--------------------------------------------------------------------//
			assertTrue(addPostPatientPayment(selenium,PostPatientPaymentData),"Post patient payment creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Open Patient charges//
			//--------------------------------------------------------------------//
			if(!verifyOpenPatientCharges(selenium,chargeEntryData)){
				Assert.fail("Details are not getting displayed");
			}else
				returnValue = true;
			
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		
	}
	
	
	public boolean verifyOpenPatientCharges(Selenium selenium,  BillingLib  chargeEntryData){
	try{
		assertTrue(getText(selenium,lblChServiceCode).contains(chargeEntryData.serviceCode),"Added details not present", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblChChargeAmount).contains(chargeEntryData.fee),"Added details not present", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblChCurrentPayer).contains("Patient"),"Added details not present", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblChProvider).contains("ABBY , ABRAHAM"),"Added details not present", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblChLocation).contains(chargeEntryData.location),"Added details not present", selenium, ClassName, MethodName);
		
			
			}catch(Exception e){
		e.printStackTrace();
	}
		return true;
	}
	
	
}
