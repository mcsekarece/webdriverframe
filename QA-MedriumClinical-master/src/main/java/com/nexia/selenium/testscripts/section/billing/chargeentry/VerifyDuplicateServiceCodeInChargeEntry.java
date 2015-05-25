package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDuplicateServiceCodeInChargeEntry extends AbstractBilling{
	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari","default" }, description = "Test for Verify Duplicate Service code in charge Entry")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void duplicateServiceCodeInChargeEntry(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	BillingLib chargeEntryData = new BillingLib();
	chargeEntryData.workSheetName = "ChargeEntry";
	chargeEntryData.testCaseId = "TC_CE_014";
	chargeEntryData.fetchBillingTestData();
	verifyDuplicateServiceCode(seleniumHost, seleniumPort, browser, webSite,userAccount, chargeEntryData);
	}
	/*************************************************************************************************** 
	* @purpose        Verify End To end Work Flow two
	* @action 		  Verify End To end Work Flow in  Biller related 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @ticket		  #9207
	* @useraccount    Both
	* @since  	      Apr 01, 2014	
	***************************************************************************************************/
	public boolean verifyDuplicateServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//-----------------------------------------------------------------------------//
			//  Step-2: navigate to Post Charge,Search Patient//
			//----------------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo", selenium, ClassName, MethodName);
			
			assertTrue(callChargeEntry(selenium,billingData),"Could not navigate and search the patient",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//-----------------------------------------------------------------------------//
			//  Step-3: create charge//
			//----------------------------------------------------------------------------//
			assertTrue(verifyDuplicateServiceCode(selenium,billingData,userAccount),"charge has been cretaed",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
//			selenium.mouseOver(ajxServiceCode2);
//			if(!selenium.isTextPresent("Please select unique service codes")){
//				Assert.fail("Alert message is not getting displayed");
//			}else
//				return true;
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent("Summary"),
					"Not navigated to Summary page after Post Charge Entry", selenium,
					ClassName, MethodName);
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
}
