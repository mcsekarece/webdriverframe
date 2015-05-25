package com.nexia.selenium.testscripts.section.billing.serviceCode;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingUnitTestLib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestsForCustomServiceCode extends AbstractBilling {
    	
    @Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "Custom Code With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void customCodeWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_ServiceCode";
		billingData.testCaseId = "TC_USC_001";
		billingData.fetchBillingTestData();
		customServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    @Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "Custom Code With Maximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void customCodeWithMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_ServiceCode";
		billingData.testCaseId = "TC_USC_002";
		billingData.fetchBillingTestData();
		customServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    @Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "Custom Description With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void customDescriptionWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_ServiceCode";
		billingData.testCaseId = "TC_USC_003";
		billingData.fetchBillingTestData();
		customServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    @Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "Custom Description With Maximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void customDescriptionWithMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_ServiceCode";
		billingData.testCaseId = "TC_USC_004";
		billingData.fetchBillingTestData();
		customServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    /*************************************************************************************************** 
	* @purpose        verify Unit Tests For Custom Service Code Section
	* @action 		  verifying Unit Tests For Custom Service Code Section 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US
	* @since  	      Jan 07, 2014	
	***************************************************************************************************/
	
	public boolean customServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingUnitTestLib billingData) throws IOException{
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
			//  Step-2: Navigate to service code								  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToServiceCode(selenium),"Could not navigate to service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Add Custom Service Code									  //
			//--------------------------------------------------------------------//
			assertTrue(addCustomServiceCode(selenium,billingData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Field validation 								  //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,billingData.alert), "The validation message field did not appear",selenium, ClassName, MethodName);
			assertTrue(getText(selenium,billingData.alert).contains(billingData.alertMessage), "The expected validation message should contain the text - "+billingData.alertMessage + " The actual validation message shown - " + getText(selenium,billingData.alert),selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}

