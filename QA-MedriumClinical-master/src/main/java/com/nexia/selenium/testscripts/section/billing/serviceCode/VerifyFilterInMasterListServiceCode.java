package com.nexia.selenium.testscripts.section.billing.serviceCode;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyFilterInMasterListServiceCode extends AbstractBilling {
    	
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Filter In Master List By Service Code")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFilterInMasterListServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_003";
		billingData.fetchBillingTestData();
		verifyFilter(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
   
    /*************************************************************************************************** 
	* @purpose        Verify Filter In Master List Service Code
	* @action 		  verifying Filter In Master List Service Code
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US and CA
	* @since  	      Jan 09, 2014	
	***************************************************************************************************/
	public boolean verifyFilter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
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
			//  Step-3: Verify Filter In Master List Service Code				  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnManageServiceCodes),"Could not click the add button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium); 
			
			assertTrue(click(selenium, lnkMasterListTab),"Could not click the master list tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium, ajxCodingSystem, billingData.codingSystemCA),"Could not select the type of coding system", selenium, ClassName,MethodName);
			}
			else{
				assertTrue(selectValueFromAjaxList(selenium, ajxCodingSystem, billingData.codingSystem),"Could not select the type of coding system", selenium, ClassName,MethodName);
			}
			waitForPageLoad(selenium);
			
			//Get the first three service codes from the master list
			billingData.serviceCode1 = getText(selenium, lblMasterListServiceCode1);
			billingData.serviceCode2= getText(selenium, lblMasterListServiceCode2);
			billingData.serviceCode3 = getText(selenium, lblMasterListServiceCode3);
			billingData.serviceCode4 = getText(selenium, lblMasterListServiceCode4);
			
			assertTrue(type(selenium, txtFilterCodeRangeFrom, billingData.serviceCode1),"Could not type the code in range from", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtFilterCodeRangeEnd, billingData.serviceCode3),"Could not type the code in range end", selenium, ClassName,MethodName);
			selenium.keyPress(txtFilterCodeRangeEnd, "\\13");
			waitForPageLoad(selenium);
			
			//Verify Filtered result In Master List
			if (!((getText(selenium, lblFilterResultInMasterList).trim().contains(billingData.serviceCode1.trim()))
					&& (getText(selenium, lblFilterResultInMasterList).trim().contains(billingData.serviceCode2.trim()))
					&& (getText(selenium, lblFilterResultInMasterList).trim().contains(billingData.serviceCode3.trim())))) {				
				assertTrue( false, "Filtered service code is not displayed in the master list", selenium, ClassName, MethodName);
			}
			
			//Verify not existence of, Out of the Filtered result In Master List			
			assertTrue( !getText(selenium, lblFilterResultInMasterList).trim().contains(billingData.serviceCode4.trim()),
					"Out of Filtered service code is also displayed in the master list", selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

