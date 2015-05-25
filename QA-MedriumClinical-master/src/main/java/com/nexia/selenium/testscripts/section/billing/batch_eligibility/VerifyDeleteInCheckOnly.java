package com.nexia.selenium.testscripts.section.billing.batch_eligibility;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteInCheckOnly  extends AbstractBilling {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Delete in batch eligibility check only")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteInCheckOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_001";
		billingData.fetchBillingTestData();
		deleteInCheckOnly(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
	
	/*************************************************************************************************** 
	* @purpose        Verify Delete in batch eligibility check only
	* @action 		  verifying Delete in batch eligibility check only
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US and CA
	* @since  	      May 19, 2014	
	***************************************************************************************************/
	public boolean deleteInCheckOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
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
			//  Step-3: Click Add New in check only								  //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium, btnActivateAutoGenerationOfBatchEligibility)){
				assertTrue(click(selenium, btnActivateAutoGenerationOfBatchEligibility),"Could not click the link activate auto generation of batch eligibility", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium, btnAddServiceCode),"Could not click the add button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnAddServiceCode),"Could not click the add button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------------------//
			//  Step-4: Verify the Delete in check only								      	  //
			//--------------------------------------------------------------------------------//
			assertTrue(click(selenium, btnDelete2InCheckOnly),"Could not click the delete button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if (isElementPresent(selenium, btnDelete2InCheckOnly)) {
				Assert.fail("Verification failed for Delete in batch eligibility check only");
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

