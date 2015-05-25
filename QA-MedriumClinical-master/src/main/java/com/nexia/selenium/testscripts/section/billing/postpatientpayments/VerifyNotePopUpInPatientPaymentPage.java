package com.nexia.selenium.testscripts.section.billing.postpatientpayments;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyNotePopUpInPatientPaymentPage  extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Note PopUp Value in Post Patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void noteDetailsWithPostPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_018";
		PostPatientPaymentData.fetchBillingTestData();
		verifyNotePopUpValue(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Note PopUp Value in Entry Patient Payment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void noteDetailsWithEntryPatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_019";
		PostPatientPaymentData.fetchBillingTestData();
		verifyNotePopUpValue(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	/*******************************************************************************************************
	* @purpose        To verify Note PopUp Value In Patient Payment and Enter Patient Payment
	* @action 		  verify Note PopUp Value In Post Patient Payment and Enter Patient Payment
	* @expected       To Ensure that the defaultValue works fine 
	* @Specification  SRS_BLG_Patient Payments Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 07, 2014
	********************************************************************************************************/
	
	public boolean verifyNotePopUpValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib PostPatientPaymentData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue=false;
		String comment = "Amount Details";
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
			//  Step-3: Navigate to Post Patient Payments Page //
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
			
				
			assertTrue(click(selenium,imgNotePopUp),"Could not click the Note pop up image", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtCommentBox,comment),"Could not enter the value in Comment Box", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnPopUpSave),"Could not click the Save button in Note pop up ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
		/*	assertTrue(click(selenium,imgNotePopUp),"Could not click the Note pop up image", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);*/
			
			//verify comment details
			
			if(!verifyNotePopUp(selenium,PostPatientPaymentData,comment )){
				Assert.fail("Details are not stored properly");
			}else
				returnValue = true;
			

		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyNotePopUp(Selenium selenium,BillingLib patientPaymentData, String comment ) throws IOException{
		try{
			String provider= getText(selenium, lnkTopMenu);
			String providerName= provider.replaceAll(", "+patientPaymentData.switchRole, "");
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			String date = DateFormat.format(cal.getTime());
	
			
			
			if(!getValue(selenium,txtCommentBox).contains(comment)){
				return false;
			}
			
			if(!getText(selenium,"css=div.gwt-Label").contains(providerName + ", " + date)){
				return false;
			}
			
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
