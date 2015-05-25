package com.nexia.selenium.testscripts.section.billing.billingHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyBillingHistoryScreen  extends AbstractBilling  {
    @Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Fee Schedule")
    @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBillingHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "BillingHistory";
		billingData.testCaseId = "TC_BH_001";
		billingData.fetchBillingTestData();
		verifyBillingHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	/**
	 * verifyBillingHistory
	 * function to verify Billing History
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      	IOException 
	 * @since  	   	Jan 24, 2014
	 */
	
	public boolean verifyBillingHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Billing History //
			//--------------------------------------------------------------------//
			
			assertTrue(goToBillingHistory(selenium,billingData),"Navigation Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify Billing History Screen//
			//--------------------------------------------------------------------//
			
			assertTrue(verifyBillingSumary(selenium,billingData),"Navigation Failed ", selenium, ClassName, MethodName);
					
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
