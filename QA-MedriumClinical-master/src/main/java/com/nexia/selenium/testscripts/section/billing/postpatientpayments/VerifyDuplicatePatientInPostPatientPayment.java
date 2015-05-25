package com.nexia.selenium.testscripts.section.billing.postpatientpayments;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDuplicatePatientInPostPatientPayment extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing duplicate patient in Post Patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void duplicatePatientWithPostPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_018";
		PostPatientPaymentData.fetchBillingTestData();
		verifyDuplicatePatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing duplicate patient in Entry Patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void duplicatePatientWithEntryPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_019";
		PostPatientPaymentData.fetchBillingTestData();
		verifyDuplicatePatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	/*******************************************************************************************************
	* @purpose        To verify Duplicate Patient In Patient Payment and Enter Patient Payment
	* @action 		  verify Duplicate Patient In Post Patient Payment and Enter Patient Payment
	* @expected       To Ensure that the Auto Allocate Payment works fine 
	* @Specification  SRS_BLG_Patient Payments Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 07, 2014
	********************************************************************************************************/
	
	public boolean verifyDuplicatePatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib PostPatientPaymentData) throws IOException{
		
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
			//  Step-4: Navigate to Post Patient Payments Page //
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
			
			//Add One patient
			assertTrue(searchPatientPayment(selenium,PostPatientPaymentData),"Could not search the patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Click add new button
			assertTrue(click(selenium,btnPPatiemtPaymentAdd),"Could not click the add new button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// Add Same patient
			assertTrue(type(selenium, txtClaimPatientSearch1, PostPatientPaymentData.patientID),"Could not type patient id", selenium, ClassName,MethodName);
			selenium.clickAt(txtClaimPatientSearch1,"");
			selenium.focus(txtClaimPatientSearch1);			
			selenium.fireEvent(txtClaimPatientSearch1,"keypress");		
			waitForElement(selenium, txtClaimPatientSearch1, 10000);
			assertTrue(selenium.isElementPresent(txtClaimPatientSearch1),"Search Results are not displayed for the patient with ID :-"+ PostPatientPaymentData.patientID, selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			selenium.click(lblPatientResult);
			waitForPageLoad(selenium);
			
			//Click on Save button
			assertTrue(click(selenium,btnPPtSave),"Could not click the Save button in patient payment page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//Verify Duplicate Alert message
			assertTrue(selenium.isTextPresent("This patient has already been added to this batch. Please select a different patient"),"Duplicate Alert message is not getting displayed",selenium, ClassName,MethodName);
			returnValue = true;
			
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	
}
