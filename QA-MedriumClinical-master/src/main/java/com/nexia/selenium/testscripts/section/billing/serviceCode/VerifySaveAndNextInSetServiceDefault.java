package com.nexia.selenium.testscripts.section.billing.serviceCode;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySaveAndNextInSetServiceDefault extends AbstractBilling {
    	
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Save And Next In Set Service Default")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveAndNextInSetServiceDefault(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_001";
		billingData.fetchBillingTestData();
		verifySaveAndNextInSetServiceDefault(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    /*************************************************************************************************** 
	* @purpose        Verify Save And Next In Set Service Default
	* @action 		  verifying Save And Next In Set Service Default
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US and CA
	* @since  	      Jan 22, 2014	
	***************************************************************************************************/
	public boolean verifySaveAndNextInSetServiceDefault(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			if(selenium.isElementPresent("errorCloseButton") && selenium.isVisible("errorCloseButton")){
				assertTrue( click(selenium, "errorCloseButton"), "Could not click Close button in error dialog box", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to service code								  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToServiceCode(selenium),"Could not navigate to service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Add two custom Service Code								  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnManageServiceCodes),"Could not click the add button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkCustomTab),"Could not click the custom tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// get the Unique custom service code using current date and time
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			DateFormat = new SimpleDateFormat("MMddHHmmss");
			billingData.serviceCode1 = DateFormat.format(cal.getTime());
			billingData.serviceDescription1 = billingData.serviceDescription1 + billingData.serviceCode1;
			
			assertTrue(type(selenium, txtCustomServiceCode, billingData.serviceCode1),"Could not type the custom service code", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtCustomDescription, billingData.serviceDescription1),"Could not type the custom service description", selenium, ClassName,MethodName);
			assertTrue(click(selenium, btnAddCustomServiceCode),"Could not click the add button in the custom service code tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// get the Unique custom service code using current date and time
			cal = Calendar.getInstance();
			DateFormat = new SimpleDateFormat("MMddHHmmss");
			billingData.serviceCode2 = DateFormat.format(cal.getTime());
			billingData.serviceDescription2 = billingData.serviceDescription2 + billingData.serviceCode2;
			
			assertTrue(type(selenium, txtCustomServiceCode, billingData.serviceCode2),"Could not type the custom service code", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtCustomDescription, billingData.serviceDescription2),"Could not type the custom service description", selenium, ClassName,MethodName);
			assertTrue(click(selenium, btnAddCustomServiceCode),"Could not click the add button in the custom service code tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, rdoSetServiceFees),"Could not click the set service fees radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Fill details in service fees						      //
			//--------------------------------------------------------------------//
			assertTrue(fillServiceFee(selenium, billingData, userAccount),"Could not fill the service fees", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(fillServiceFeeSecond(selenium, billingData, userAccount),"Could not fill the second service fees", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, rdoSetServiceDefault),"Could not click the set service default radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Save And Next In Set Service Default	   		      //
			//--------------------------------------------------------------------//
			assertTrue(verifyDetailsInSetServiceDefault(selenium, billingData, userAccount),"Verify failed for the selected service code and set service fee details in set service default", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnSaveAndNext),"Could not click the save and next", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue( getValue(selenium, txtServiceCode).contains(billingData.serviceCode2.trim()),
					"Not able to find service code " +billingData.serviceCode2 , selenium, ClassName, MethodName);
						
							
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

