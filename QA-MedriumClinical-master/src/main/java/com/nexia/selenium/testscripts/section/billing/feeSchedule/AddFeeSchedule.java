package com.nexia.selenium.testscripts.section.billing.feeSchedule;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;

import com.thoughtworks.selenium.Selenium;

public class AddFeeSchedule extends AbstractBilling {
    
   	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Fee Schedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addFeeSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "FeeSchedule";
		billingData.testCaseId = "TC_FS_001";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
   	
   	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Fee Schedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCodeRangeFilter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "FeeSchedule";
		billingData.testCaseId = "TC_FS_002";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
   	
   	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Fee Schedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelAddNewFeeSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "FeeSchedule";
		billingData.testCaseId = "TC_FS_003";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
   	
   	/**
	 * addFeeSchedule
	 * function to add fee schedule
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      	IOException 
	 * @since  	   	Jan 03, 2014
	 */
	
	public boolean addFeeSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
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
			//  Step-2: Go to Fee Schedule //
			//--------------------------------------------------------------------//
			
			assertTrue(goToFeeSchedule(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Add Fee Schedule //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllFeeSchedule(selenium),"Creation Failed", selenium, ClassName, MethodName);
			assertTrue(addFeeSchedule(selenium,billingData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
