package com.nexia.selenium.testscripts.section.billing.postpatientpayments;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class RemovePostPatientPayment extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Remove  Post Patient Payment with Yes Option ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void removePostPatientPaymentWithYesOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_004";
		PostPatientPaymentData.fetchBillingTestData();
		verifyRemovePatientPayment(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Remove Enter Patient Payment with Yes Option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void removeEnterPatientPaymentWithYesOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_005";
		PostPatientPaymentData.fetchBillingTestData();
		verifyRemovePatientPayment(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Remove  Post Patient Payment with No Option ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void removePostPatientPaymentWithNoOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_006";
		PostPatientPaymentData.fetchBillingTestData();
		verifyRemovePatientPayment(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Remove Enter Patient Payment with No Option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void removeEnterPatientPaymentWithNoOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib PostPatientPaymentData = new BillingLib();
		PostPatientPaymentData.workSheetName = "PostPatientPayment";
		PostPatientPaymentData.testCaseId = "TC_PPP_007";
		PostPatientPaymentData.fetchBillingTestData();
		verifyRemovePatientPayment(seleniumHost, seleniumPort, browser, webSite, userAccount, PostPatientPaymentData);
	}
	
	/*************************************************************************************************************************** 
	* @purpose        To verify remove Patient Payment  For Post Patient Payment and Enter Patient Payment
	* @action 		  verify remove Patient Payment  For Post Patient Payment and Enter Patient Payment
	* @expected       To Ensure that the verify Patient Payment  For Post Patient Payment and Enter Patient Payment works fine 
	* @Specification  SRS_BLG_Patient Payments Rev0.0
	* @author         Aspire Qa 
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Feb 04, 2014
	******************************************************************************************************************************/
	
	public boolean verifyRemovePatientPayment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib PostPatientPaymentData) throws IOException{
		
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
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_004")|| PostPatientPaymentData.testCaseId.equals("TC_PPP_006")){
				assertTrue(click(selenium,lnkPPatientPaymentQueue),"Could not click the Post Patient Payment Queue", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lnkStartNewBranch)){
					waitForPageLoad(selenium);
					assertTrue(click(selenium, lnkStartNewBranch),"Could not click the Start New branch Link", selenium,ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			}
			
			//--------------------------------------------------------------------//
			//  Navigate to Enter Patient Payment In Quick Action //
			//--------------------------------------------------------------------//
			
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_005")|| PostPatientPaymentData.testCaseId.equals("TC_PPP_007")){
				assertTrue(navigateToEnterPatientPayment(selenium),"Could not Navigate to Enter Patient payment", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: create Post Patient payment//
			//--------------------------------------------------------------------//
			assertTrue(addPostPatientPayment(selenium,PostPatientPaymentData),"createion failled", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:verify the warning message for Remove post patient payment//
			//--------------------------------------------------------------------//
			if(!getText(selenium,"css=div.popupContent").contains("Please confirm that you would like to delete this payment.")){
				Assert.fail("pop up message is not getting displayed properly");
			}
			
			assertTrue(click(selenium,btnPPRemove1),"could not click remove button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//yes button
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_004")||PostPatientPaymentData.testCaseId.equals("TC_PPP_005")){
				assertTrue(click(selenium,btnPPRemoveYes),"could not click yes button", selenium, ClassName, MethodName);
			}
			
			//no Button
			if(PostPatientPaymentData.testCaseId.equals("TC_PPP_006")||PostPatientPaymentData.testCaseId.equals("TC_PPP_007")){
				assertTrue(click(selenium,btnPPRemoveNo),"could not click no button", selenium, ClassName, MethodName);
			}
			
			
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		
	}
	
	public boolean verifyRemoveLine(Selenium selenium, BillingLib PostPatientPaymentData){
		
		if(PostPatientPaymentData.testCaseId.equals("TC_PPP_004")||PostPatientPaymentData.testCaseId.equals("TC_PPP_005")){
		
			if(!isElementPresent(selenium,txtSearchPatientId1)){
				return false;
			}
			

			if(!isElementPresent(selenium,txtSearchPatient1)){
				return false;
			}

			if(!isElementPresent(selenium,ajxMOP)){
				return false;
			}

			
		}
		if(PostPatientPaymentData.testCaseId.equals("TC_PPP_006")||PostPatientPaymentData.testCaseId.equals("TC_PPP_007")){
			if(isElementPresent(selenium,txtSearchPatientId1)){
				return false;
			}
			if(isElementPresent(selenium,txtSearchPatient1)){
				return false;
			}
			if(isElementPresent(selenium,ajxMOP)){
				return false;
			}

		
		}

		return true;
	}
	
}
