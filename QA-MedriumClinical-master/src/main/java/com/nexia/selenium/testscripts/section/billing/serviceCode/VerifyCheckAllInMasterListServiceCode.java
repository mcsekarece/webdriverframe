package com.nexia.selenium.testscripts.section.billing.serviceCode;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCheckAllInMasterListServiceCode extends AbstractBilling {
    	
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Check All In Master List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCheckAllInMasterListServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_003";
		billingData.fetchBillingTestData();
		verifyCheckAll(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
   
    /*************************************************************************************************** 
	* @purpose        Verify Check All In Master List Service Code
	* @action 		  verifying Check All In Master List Service Code
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US and CA
	* @since  	      May 06, 2014	
	***************************************************************************************************/
	public boolean verifyCheckAll(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
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
			//  Step-3: Filter some Service Codes In Master List		    	  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddServiceCode),"Could not click the add button", selenium, ClassName,MethodName);
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
			
			assertTrue(type(selenium, txtFilterCodeRangeFrom, billingData.serviceCode1),"Could not type the code in range from", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtFilterCodeRangeEnd, billingData.serviceCode3),"Could not type the code in range end", selenium, ClassName,MethodName);
			selenium.keyPress(txtFilterCodeRangeEnd, "\\13");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Check All In Master List Service Code			  //
			//--------------------------------------------------------------------//
			if(!isChecked(selenium, chkSelectAllServiceCode)){
				assertTrue(click(selenium, chkSelectAllServiceCode),"Could not click the select all check box", selenium, ClassName,MethodName);
			}
			waitForPageLoad(selenium); 
			
			String lblFirstAddedServiceCode = getText(selenium, lblAddedServiceCodes).trim();

			if (!((lblFirstAddedServiceCode.contains(billingData.serviceCode1.trim())) 
					&& (lblFirstAddedServiceCode.contains(billingData.serviceCode2.trim()))
					&& (lblFirstAddedServiceCode.contains(billingData.serviceCode3.trim())))) {
				Assert.fail("Check all service code is not working");
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify unCheck All In Master List Service Code			  //
			//--------------------------------------------------------------------//
			if(isChecked(selenium, chkSelectAllServiceCode)){
				assertTrue(click(selenium, chkSelectAllServiceCode),"Could not click the select all check box", selenium, ClassName,MethodName);
			}
			waitForPageLoad(selenium); 
			
			lblFirstAddedServiceCode = getText(selenium, lblAddedServiceCodes).trim();

			if ((lblFirstAddedServiceCode.contains(billingData.serviceCode1.trim())) 
					&& (lblFirstAddedServiceCode.contains(billingData.serviceCode2.trim()))
					&& (lblFirstAddedServiceCode.contains(billingData.serviceCode3.trim()))) {
				Assert.fail("Check all service code is not working");
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

