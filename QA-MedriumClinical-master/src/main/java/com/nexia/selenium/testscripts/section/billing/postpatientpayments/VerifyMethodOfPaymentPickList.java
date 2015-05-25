package com.nexia.selenium.testscripts.section.billing.postpatientpayments;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMethodOfPaymentPickList extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Method OfPayment PickList In PostPatientPayment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void MethodOfPaymentPickListInPostPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_001";
		PostPatientPaymentData.fetchBillingTestData();
		verifyMethodOfPayment(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Method Of PaymentPickListInEnterPatientPayment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void MethodOfPaymentPickListInEnterPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_002";
		PostPatientPaymentData.fetchBillingTestData();
		verifyMethodOfPayment(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Method Of Payment
	* @action 		  verify  Method Of Payment
	* @expected       To Ensure that the verify  Method Of Payment works fine 
	* @Specification  SRS_BLG_Patient Payments Rev0.0
	* @author         Aspire Qa 
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 04, 2014
	***************************************************************************************************/
	
	public boolean verifyMethodOfPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib PostPatientPaymentData) throws IOException{
		
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
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Post Patient Payment In Home Page //
			//--------------------------------------------------------------------//
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_001")){
				assertTrue(click(selenium,lnkPPatientPaymentQueue),"Could not click the Post Patient Payment Queue", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lnkStartNewBranch)){
					assertTrue(click(selenium, lnkStartNewBranch),"Could not click the Start New branch Link", selenium,ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			}
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Enter Patient Payment In Quick Action //
			//--------------------------------------------------------------------//
			
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_002")){
				assertTrue(navigateToEnterPatientPayment(selenium),"Could not Navigate to Enter Patient payment", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify the Method of Payment PickList//
			//--------------------------------------------------------------------//
			if(getValue(selenium,ajxMethodOfPayment).equals("Check")){
				returnValue = true;
			}else
				Assert.fail("Default Value is not present in the Method of Payment pick list");
			
			assertTrue(click(selenium,ajxMethodOfPayment),"Could not click the Ajx Method Payment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isTextPresent("Visa"),"Visa text is not present the in list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Master Card"),"Master Card text is not present the in list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Discover"),"Discover text is not present the in list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("AMEX"),"AMEX text is not present the in list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Cash"),"Cash text is not present the in list", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Check"),"Check text is not present the in list", selenium, ClassName, MethodName);

		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		
	}
}
