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

public class VerifyFilterInServiceFees extends AbstractBilling {
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Filter In Service Fee Using Master Service Code")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFilterInServiceFeeUsingMasterServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_001";
		billingData.fetchBillingTestData();
		verifyFilterInServiceFees(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    //Fix
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Filter In Service Fee Using custom Service Code")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFilterInServiceFeeUsingCustomServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_002";
		billingData.fetchBillingTestData();
		verifyFilterInServiceFees(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
   
    /*************************************************************************************************** 
	* @purpose        Verify Filter In Service Fee
	* @action 		  verifying Filter In Service Fee
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US and CA
	* @since  	      Jan 09, 2014	
	***************************************************************************************************/
	public boolean verifyFilterInServiceFees(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
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
			//  Step-3: Add Master List Service Code							  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnManageServiceCodes),"Could not click the add button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(billingData.testCaseId.equalsIgnoreCase("TC_SC_001")){
				assertTrue(click(selenium, lnkMasterListTab),"Could not click the master list tab", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				if(userAccount.equalsIgnoreCase(CAAccount)){
					assertTrue(selectValueFromAjaxList(selenium, ajxCodingSystem, billingData.codingSystemCA),"Could not select the type of coding system", selenium, ClassName,MethodName);
				}
				else{
					assertTrue(selectValueFromAjaxList(selenium, ajxCodingSystem, billingData.codingSystem),"Could not select the type of coding system", selenium, ClassName,MethodName);
				}
				waitForPageLoad(selenium);
				
				billingData.serviceCode1 = getText(selenium, lblMasterListServiceCode1);
				billingData.serviceCode2 = getText(selenium, lblMasterListServiceCode2);
				billingData.serviceCode3 = getText(selenium, lblMasterListServiceCode3);
				
				
				assertTrue(click(selenium, chkMasterListServiceCode1),"Could not check the the first master list code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, chkMasterListServiceCode2),"Could not check the the second master list code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
			}
			//--------------------------------------------------------------------//
			//  Step-3: Add Custom Service Code									  //
			//--------------------------------------------------------------------//
			else if(billingData.testCaseId.equalsIgnoreCase("TC_SC_002")){
				assertTrue(click(selenium, lnkCustomTab),"Could not click the custom tab", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				// get the Unique custom service code using current date and time
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat;
				DateFormat = new SimpleDateFormat("MMddHHmmss");
				billingData.serviceCode1 = DateFormat.format(cal.getTime());
				
				assertTrue(type(selenium, txtCustomServiceCode, billingData.serviceCode1),"Could not type the custom service code", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtCustomDescription, billingData.serviceDescription1),"Could not type the custom service description", selenium, ClassName,MethodName);
				assertTrue(click(selenium, btnAddCustomServiceCode),"Could not click the add button in the custom service code tab", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				// get the Unique custom service code using current date and time
				cal = Calendar.getInstance();
				DateFormat = new SimpleDateFormat("MMddHHmmss");
				billingData.serviceCode2 = DateFormat.format(cal.getTime());
				
				assertTrue(type(selenium, txtCustomServiceCode, billingData.serviceCode2),"Could not type the custom service code", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtCustomDescription, billingData.serviceDescription2),"Could not type the custom service description", selenium, ClassName,MethodName);
				assertTrue(click(selenium, btnAddCustomServiceCode),"Could not click the add button in the custom service code tab", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				// get the Unique custom service code using current date and time
				cal = Calendar.getInstance();
				DateFormat = new SimpleDateFormat("MMddHHmmss");
				billingData.serviceCode3 = DateFormat.format(cal.getTime());
				
				assertTrue(type(selenium, txtCustomServiceCode, billingData.serviceCode3),"Could not type the custom service code", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtCustomDescription, billingData.serviceDescription3),"Could not type the custom service description", selenium, ClassName,MethodName);
				assertTrue(click(selenium, btnAddCustomServiceCode),"Could not click the add button in the custom service code tab", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Filtering Service Code in service fees			  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, rdoSetServiceFees),"Could not click the set service fees radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium, txtFilterCodeRangeFrom, billingData.serviceCode1),"Could not type the code in range from", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtFilterCodeRangeEnd, billingData.serviceCode2),"Could not type the code in range end", selenium, ClassName,MethodName);
			selenium.keyPress(txtFilterCodeRangeEnd, "\\13");
			waitForPageLoad(selenium);
			
			//verify non existence of service code-3 in filtered result
			assertTrue( !getText(selenium, lblFilterResultInSetServiceFee).trim().contains(billingData.serviceCode3.trim()),
					"Searched service code is not displayed in the master list", selenium, ClassName, MethodName);
			
			//verify the existence of service code-1 and service code-2 in filtered result
			if (!(getText(selenium, lblFilterResultInSetServiceFee).trim().contains(billingData.serviceCode1.trim()))
					&& (getText(selenium, lblFilterResultInSetServiceFee).trim().contains(billingData.serviceCode2.trim()))) {				
				assertTrue( false, "Searched service code is not displayed in the master list", selenium, ClassName, MethodName);
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

