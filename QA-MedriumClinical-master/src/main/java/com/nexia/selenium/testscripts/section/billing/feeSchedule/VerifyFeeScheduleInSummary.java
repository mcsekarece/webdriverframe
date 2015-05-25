package com.nexia.selenium.testscripts.section.billing.feeSchedule;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyFeeScheduleInSummary extends AbstractBilling {
    	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Fee Schedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFeeSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "FeeSchedule";
		billingData.testCaseId = "TC_FS_001";
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
	 * @since  	   	Jan 09, 2014
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
			//  Step-4: Delete Fee Schedule //
			//--------------------------------------------------------------------//
			
			if(!(isElementPresent(selenium,lnkDelete) && isElementPresent(selenium,lnkEdit))){
			    returnValue=false;
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Fee Schedule //
			//--------------------------------------------------------------------//
			
			if(!verifyFeeScheduelInSummary(selenium,billingData)){
			    Assert.fail("Creation Failed");
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyFeeScheduelInSummary(Selenium selenium,BillingLib billingData) throws IOException{
	    	boolean returnValue=true;
	    
	    	if(!getText(selenium,lblFeeScheduleSummary).contains(billingData.payer1)){
		    returnValue=false;
		}
		if(!getText(selenium,lblFeeScheduleSummary).contains(billingData.plan)){
		    returnValue=false;
		}
		if(!getText(selenium,lblFeeScheduleSummary).contains(billingData.provider1)){
		    returnValue=false;
		}
		
		String s = getText(selenium,lblFeeScheduleSummary).toLowerCase(new java.util.Locale("en","US"));
		if(!getText(selenium,lblFeeScheduleSummary).toLowerCase(new java.util.Locale("en","US")).contains(billingData.practice.toLowerCase(new java.util.Locale("en","US")))){
		    returnValue=false;
		}
		if(!getText(selenium,lblFeeScheduleSummary).contains(billingData.speciality)){
		    returnValue=false;
		}
		if(!getText(selenium,lblFeeScheduleSummary).contains(billingData.location)){
		    returnValue=false;
		}
		return returnValue;
	}
}
