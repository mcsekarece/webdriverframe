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

public class VerifyDeleteServiceCode extends AbstractBilling {
    	
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify delete 'yes' option in the service code")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteYesInServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_001";
		billingData.fetchBillingTestData();
		verifyDeleteServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify delete 'no' option in the service code")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteNoInServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_002";
		billingData.fetchBillingTestData();
		verifyDeleteServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    
    /*************************************************************************************************** 
	* @purpose        Verify Delete In Service Code
	* @action 		  verifying Delete In Service Code
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US and CA
	* @since  	      Jan 23, 2014	
	***************************************************************************************************/
	
    public boolean verifyDeleteServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not retrieve the New Selenium Session; More Details :" + billingData.toString());
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
			//  Step-3: Add Custom Service Code									  //
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
			
			assertTrue(click(selenium, rdoSetServiceFees),"Could not click the set service fees radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Fill details in service fees						      //
			//--------------------------------------------------------------------//
			assertTrue(fillServiceFee(selenium, billingData, userAccount),"Could not fill the service fees", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, rdoSetServiceDefault),"Could not click the set service default radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnDoneServiceCode),"Could not click the set service default radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify the created service code in summary				  //
			//--------------------------------------------------------------------//
			
			assertTrue(type(selenium, txtSearchInServiceCode, billingData.serviceCode1),"Could not type the service code in search box", selenium, ClassName,MethodName);
			selenium.keyPress(txtSearchInServiceCode, "\\13");
			waitForPageLoad(selenium);
			
			if (!(getText(selenium, lblFilterResultInServiceCodeFirst).trim().contains(billingData.serviceCode1.trim())
					&& (getText(selenium, lblFilterResultInServiceCodeFirst).trim().contains(billingData.serviceDescription1.trim())))){				
				assertTrue( false,"Searched service code is not displayed in the master list", selenium, ClassName, MethodName);
			}
			
			assertTrue(click(selenium, lblFilterResultInServiceCodeFirst),"Could not click the first filtered result in the service code summary", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Delete the created service code			     			  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnDeleteServiceCode),"Could not click the delete button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(billingData.testCaseId.equalsIgnoreCase("TC_SC_001")){
				assertTrue(click(selenium, btnYesbutton),"Could not click yes in the delete popup", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkServiceCode),
						"Could not navigate to service code section", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtSearchInServiceCode, billingData.serviceCode1),"Could not type the service code in search box", selenium, ClassName,MethodName);
				selenium.keyPress(txtSearchInServiceCode, "\\13");
				waitForPageLoad(selenium);
				
			   //--------------------------------------------------------------------//
			   //  Step-6: Verify the service code	Deleted			    			  //
			   //--------------------------------------------------------------------//
				//even we deleted the service code,It still exist in that location(but visibility- off). So, we use the isVisible method
				//if (getText(selenium, lblFilterResultInServiceCodeFirst).trim().contains(billingData.serviceCode.trim())){
				
				assertTrue(!getText(selenium, lblFilterResultInServiceCodeFirst).trim().contains(billingData.serviceCode1.trim()),
						"Deleted service code is displayed in the summary list", selenium, ClassName, MethodName);
				
				
		    }else if(billingData.testCaseId.equalsIgnoreCase("TC_SC_002")){
			
			    assertTrue(click(selenium, btnNobutton),"Could not click no in the delete popup", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkServiceCode),
						"Could not navigate to service code section", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtSearchInServiceCode, billingData.serviceCode1),"Could not type the service code in search box", selenium, ClassName,MethodName);
				selenium.keyPress(txtSearchInServiceCode, "\\13");
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-6: Verify the service code not deleted		     			  //
				//--------------------------------------------------------------------//				
				assertTrue( getText(selenium, lblFilterResultInServiceCodeFirst).trim().contains(billingData.serviceCode1.trim()),
						"Searched service code is not displayed in the master list", selenium, ClassName, MethodName);
				
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

