package com.nexia.selenium.testscripts.section.billing.postpatientpayments;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class CancelSinglePostPatientPayment extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Cancel the Post patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void cancelPostPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_003";
		PostPatientPaymentData.fetchBillingTestData();
		cancelPPPayment(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify cancel post patient payment
	* @action 		  verify cancel Post Patient Payment
	* @expected       To Ensure that the verify cancel Post Patient Payment works fine 
	* @Specification  SRS_BLG_Patient Payments Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 04, 2014
	***************************************************************************************************/
	
	public boolean cancelPPPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib PostPatientPaymentData) throws IOException{
		
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
			//  Step-3:Navigate to search patient //
			//--------------------------------------------------------------------//
			assertTrue(navigateToPatient(selenium,PostPatientPaymentData),"Could not search patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Post Patiment Payments Page //
			//--------------------------------------------------------------------//
	
			/*assertTrue(navigateToPostPatientPayment(selenium,PostPatientPaymentData),"Could not navigate to Post Payment Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientPostPatientPayments),"Could not Click", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
   	        if(isElementPresent(selenium, lnkStartNewBatch)&&(isElementVisible(selenium, lnkStartNewBatch))) {    				
   					assertTrue(click(selenium, lnkStartNewBatch),"could not click error close", selenium, ClassName,MethodName);    				
   				waitForPageLoad(selenium);
   			}	

			//--------------------------------------------------------------------//
			//  Step-4: create post payment //
			//--------------------------------------------------------------------//
			assertTrue(addPatientPayment(selenium,PostPatientPaymentData),"Post patient payment creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium, btnNexiaLogo),"Home page is not getting displayed", selenium, ClassName,MethodName);
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		
	}
}
