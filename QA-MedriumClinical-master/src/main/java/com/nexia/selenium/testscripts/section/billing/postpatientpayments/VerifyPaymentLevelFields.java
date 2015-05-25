package com.nexia.selenium.testscripts.section.billing.postpatientpayments;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPaymentLevelFields extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Method OfPayment PickList In PostPatientPayment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void paymentLevelFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_001";
		PostPatientPaymentData.fetchBillingTestData();
		verifyPaymentLevelFields(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
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
		verifyPaymentLevelFields(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Payment Level Fields For Patient Payment
	* @action 		  verify Payment Level Fields For Patient Payment
	* @expected       To Ensure that the verify Payment Level Fields For Patient Payment works fine 
	* @Specification  SRS_BLG_Patient Payments Rev0.0
	* @author         Aspire Qa 
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 04, 2014
	***************************************************************************************************/
	
	public boolean verifyPaymentLevelFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib PostPatientPaymentData) throws IOException{
		
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
			assertTrue(isElementPresent(selenium,txtSearchPatientId),"search patient Id field is not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,txtSearchPatient),"search patient name field is not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,ajxMethodOfPayment),"Method of payment field is not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,txtreferenceNo),"reference No field is not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,txpaidAmount),"Paid amount field is not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,ajxPPPprovider),"Provider field is not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,ajxPPPLocation),"Location field is not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,chkUnAllocate),"UnAllocate field is not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,imgNotePopUp),"Note image is not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,btnPPRemove),"Remove button is not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,lnkEpandArrow),"Expand Arrow is not present", selenium, ClassName, MethodName);

			// button Verify
			assertTrue(isElementPresent(selenium,btnPost),"Post button is not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,btnPPPCancel),"Cancel button is not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,btnPPtSave),"save button is not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,btnPPatiemtPaymentAdd),"Add button is not present", selenium, ClassName, MethodName);
			
			
			
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		
	}
	
}
