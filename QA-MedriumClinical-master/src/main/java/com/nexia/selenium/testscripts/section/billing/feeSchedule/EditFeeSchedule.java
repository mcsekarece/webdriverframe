package com.nexia.selenium.testscripts.section.billing.feeSchedule;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class EditFeeSchedule extends AbstractBilling {
    	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing Fee Schedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editFeeSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "FeeSchedule";
		billingData.testCaseId = "TC_FS_001";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing Fee Schedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDetailsInEditFeeSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "FeeSchedule";
		billingData.testCaseId = "TC_FS_005";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing Fee Schedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelInEditFeeSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "FeeSchedule";
		billingData.testCaseId = "TC_FS_002";
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
	 * @since  	   	Jan 10, 2014
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
			//  Step-4: Edit Fee Schedule //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkEdit),"Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(billingData.testCaseId.equals("TC_FS_005")){
			    assertTrue(click(selenium, btnCancelFeeSchedule),"could not click on Cancel button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);  
			    
			    if(!isElementPresent(selenium,btnAddNewFeeSchedule)){
				    returnValue=false;
			    }
			    
			    return true;
			}
			if(billingData.testCaseId.equals("TC_FS_005")){
			    if(!verifyFeeScheduelInEditScreen(selenium,billingData)){
				    Assert.fail("Creation Failed");
			    }
			    
			    return true;
			}
			billingData.workSheetName = "FeeSchedule";
			billingData.testCaseId = "TC_FS_004";
			billingData.fetchBillingTestData();
			
			assertTrue(addFeeSchedule(selenium,billingData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			
			if(!isElementPresent(selenium,btnAddNewFeeSchedule)){
			    returnValue=false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyFeeScheduelInEditScreen(Selenium selenium,BillingLib billingData) throws IOException{
	    	boolean returnValue=true;
	    
	    if(!getText(selenium,lblEditFeeScheduleSummary).contains(billingData.payer1)){
		    returnValue=false;
		}
		if(!getText(selenium,lblEditFeeScheduleSummary).contains(billingData.plan)){
		    returnValue=false;
		}
		if(!getText(selenium,lblEditFeeScheduleSummary).contains(billingData.provider1)){
		    returnValue=false;
		}
		if(!getText(selenium,lblEditFeeScheduleSummary).contains(billingData.practice)){
		    returnValue=false;
		}
		if(!getText(selenium,lblEditFeeScheduleSummary).contains(billingData.speciality)){
		    returnValue=false;
		}
		if(!getText(selenium,lblEditFeeScheduleSummary).contains(billingData.location)){
		    returnValue=false;
		}
		return returnValue;
	}
}

