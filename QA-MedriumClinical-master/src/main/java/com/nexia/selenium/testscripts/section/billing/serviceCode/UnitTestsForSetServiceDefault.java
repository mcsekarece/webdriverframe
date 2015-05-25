package com.nexia.selenium.testscripts.section.billing.serviceCode;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingUnitTestLib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestsForSetServiceDefault extends AbstractBilling {
    	
    @Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "Custom Code With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void customCodeWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_SetServiceDefault";
		billingData.testCaseId = "TC_USD_001";
		billingData.fetchBillingTestData();
		setServiceDefault(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    @Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "Custom Code With Maximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void customCodeWithMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_SetServiceDefault";
		billingData.testCaseId = "TC_USD_002";
		billingData.fetchBillingTestData();
		setServiceDefault(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    
    @Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "Custom Description With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void customDescriptionWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_SetServiceDefault";
		billingData.testCaseId = "TC_USD_003";
		billingData.fetchBillingTestData();
		setServiceDefault(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    @Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "Custom Description With Maximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void customDescriptionWithMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_SetServiceDefault";
		billingData.testCaseId = "TC_USD_004";
		billingData.fetchBillingTestData();
		setServiceDefault(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    @Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "Current fee with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void currentFeeWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_SetServiceDefault";
		billingData.testCaseId = "TC_USD_005";
		billingData.fetchBillingTestData();
		setServiceDefault(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    
  
    //Bug -#8163
    @Test(enabled = false)
    //@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "Current fee with Maximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void currentFeeWithMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_SetServiceDefault";
		billingData.testCaseId = "TC_USD_006";
		billingData.fetchBillingTestData();
		setServiceDefault(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    
    @Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "New fee with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void newFeeWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_SetServiceDefault";
		billingData.testCaseId = "TC_USD_007";
		billingData.fetchBillingTestData();
		setServiceDefault(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    
    //@Test(groups = {"RegressionUSUnit","firefox", "iexplore", "safari", "default" }, description = "New fee With Maximum")
    //Bug -#8163
    @Test(enabled = false)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void newFeeWithMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingUnitTestLib billingData = new BillingUnitTestLib();
		billingData.workSheetName = "UnitTest_SetServiceDefault";
		billingData.testCaseId = "TC_USD_008";
		billingData.fetchBillingTestData();
		setServiceDefault(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    /*************************************************************************************************** 
	* @purpose        verify Unit Tests For Set Service Default Section
	* @action 		  verifying Unit Tests For Set Service Default Section
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US
	* @since  	      Jan 08, 2014	
	***************************************************************************************************/
	
	public boolean setServiceDefault(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingUnitTestLib billingData) throws IOException{
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
			// get the Unique custom service code using current date and time
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			DateFormat = new SimpleDateFormat("MMddHHmmss");
			String tempCustomCode = DateFormat.format(cal.getTime());
			
			assertTrue(click(selenium, btnAddServiceCode),"Could not click the add button in the service code", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkCustomTab),"Could not click the custom tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium, txtCustomServiceCode, tempCustomCode),"Could not type the custom service code", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtCustomDescription, billingData.customServiceDescription),"Could not type the custom service description", selenium, ClassName,MethodName);
			
			assertTrue(click(selenium, btnAddServiceCode),"Could not click the add button in the custom service code tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify The Added Custom Service Code In Right Panel		  //
			//--------------------------------------------------------------------//
			assertTrue(verifyAddedServiceCodeInRightPanel(selenium,billingData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium, rdoSetServiceDefault),"Could not click the set service default radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Fill details in set service default					      //
			//--------------------------------------------------------------------//
			assertTrue(fillSetServiceDefaultUnit(selenium, billingData, userAccount),"Could not fill the set service default", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnDoneServiceCode),"Could not click the done button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-: Verify Field validation 									  //
			//--------------------------------------------------------------------//
			if(!billingData.alert.equals("")){
				assertTrue(isElementPresent(selenium,billingData.alert), "The validation message field did not appear",selenium, ClassName, MethodName);
				assertTrue(getText(selenium,billingData.alert).contains(billingData.alertMessage), "The expected validation message should contain the text - "+billingData.alertMessage + " The actual validation message shown - " + getText(selenium,billingData.alert),selenium, ClassName, MethodName);
				return true;
			}
			else{
			    	return true;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}

