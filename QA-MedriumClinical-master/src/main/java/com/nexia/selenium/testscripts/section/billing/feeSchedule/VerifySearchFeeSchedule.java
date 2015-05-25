package com.nexia.selenium.testscripts.section.billing.feeSchedule;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchFeeSchedule extends AbstractBilling{
    	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Search With Code")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchWithCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "FeeSchedule";
		billingData.testCaseId = "TC_FS_002";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Search With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "FeeSchedule";
		billingData.testCaseId = "TC_FS_001";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Search With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchWithPayerDescription(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "FeeSchedule";
		billingData.testCaseId = "TC_FS_004";
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
	 * @since  	   	Jan 08, 2014
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
			//  Step-3: Delete All Fee Schedule//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteAllFeeSchedule(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Add Fee Schedule //
			//--------------------------------------------------------------------//
			
			assertTrue(addFeeSchedule(selenium,billingData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Search //
			//--------------------------------------------------------------------//
			
			if(!verifySearchWithCode(selenium,billingData)){
			    Assert.fail("Search With Code Failed");
			}
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySearchWithCode(Selenium selenium,BillingLib billingData) throws IOException{
	    boolean returnValue=true;
	    try{
	    	if(billingData.testCaseId.equals("TC_FS_001")){
		    	assertTrue(selectValueFromAjaxList(selenium, ajxSearch,"%^&"),"could not search searchServiceCode", selenium, ClassName, MethodName);
		    	if(!getText(selenium,"css=div.no-data-text").contains("No results found")){
		    		returnValue=false;
		    	}
		    	return returnValue;
	    	}
	    	
	    	if(billingData.testCaseId.equals("TC_FS_002")){
	    	    SystemSettingsLib payerAdminData = new SystemSettingsLib();
	    	    payerAdminData.workSheetName = "PortAddPayers";
	    	    payerAdminData.testCaseId = "TC_AP_001";
	    	    payerAdminData.fetchSystemSettingTestData();
		
	    	    assertTrue(selectValueFromAjaxList(selenium, ajxSearch,payerAdminData.payerCode),"could not search searchServiceCode", selenium, ClassName, MethodName);
		
	    	    if(!getText(selenium,lblFeeScheduleSummary).contains(billingData.payer)){
	    		returnValue=false;
	    	    }
	    	}
	    	
		if(billingData.testCaseId.equals("TC_FS_004")){
		   
    	    assertTrue(selectValueFromAjaxList(selenium, ajxSearch,billingData.payer),"could not search searchServiceCode", selenium, ClassName, MethodName);
    	    if(!getText(selenium,lblFeeScheduleSummary).contains(billingData.payer)){
    		returnValue=false;
    	    }
		}
		
		
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	    return returnValue;
	}
}
