package com.nexia.selenium.testscripts.section.billing.batch_eligibility;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelInEligibilityCheckPreference  extends AbstractBilling {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Cancel in Eligibility check preference")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelInEligibilityCheckPreference(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_001";
		billingData.fetchBillingTestData();
		verifyCancel(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
	
	/*************************************************************************************************** 
	* @purpose        Verify Cancel in Eligibility check preference
	* @action 		  verifying Cancel in Eligibility check preference
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US and CA
	* @since  	      May 19, 2014	
	***************************************************************************************************/
	public boolean verifyCancel(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Batch Eligibility							  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToBatchEligibility(selenium),"Could not navigate to service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			//--------------------------------------------------------------------//
			//  Step-3: Click Cancel in Eligibility check preference			  //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium, btnActivateAutoGenerationOfBatchEligibility)){
				assertTrue(click(selenium, btnActivateAutoGenerationOfBatchEligibility),"Could not click the link activate auto generation of batch eligibility", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium, btnCancel),"Could not click the cancel button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------------------//
			//  Step-4: Verify the Cancel in Eligibility check preference				      //
			//--------------------------------------------------------------------------------//
			if (isElementPresent(selenium, btnCancel)) {
				Assert.fail("Verification failed for cancel in batch eligibility");
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

