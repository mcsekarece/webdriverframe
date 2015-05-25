package com.nexia.selenium.testscripts.section.billing.serviceCode;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteInSelectedServiceCode extends AbstractBilling {
    	
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Delete In Selected Service Code by delete")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteInSelectedServiceCodeByDelete(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_001";
		billingData.fetchBillingTestData();
		verifyDeleteInSelectedServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Delete In Selected Service Code by check box")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteInSelectedServiceCodeByCheckbox(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_002";
		billingData.fetchBillingTestData();
		verifyDeleteInSelectedServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}

    /*************************************************************************************************** 
	* @purpose        Verify Delete In Selected Service Code
	* @action 		  Verifying Delete In Selected Service Code
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US and CA
	* @since  	      Jan 10, 2014	
	***************************************************************************************************/
	public boolean verifyDeleteInSelectedServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
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
			//  Step-3: Add the master Service Code to the right panel			  //
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
			
			billingData.serviceCode1 = getText(selenium, lblMasterListServiceCode1);
			
			billingData.serviceDescription1 = getText(selenium, lblMasterListServiceDescription1);
			
			assertTrue(click(selenium, chkMasterListServiceCode1),"Could not check the the first master list code", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
				
			if (!(getText(selenium, lblSelectedServiceCodeFirstResult).trim().contains(billingData.serviceCode1.trim()))
					&& (getText(selenium, lblSelectedServiceCodeFirstResult).trim().contains(billingData.serviceDescription1.trim()))) {
				Assert.fail("Added service code is not displayed in the right side panel");
			}
			
			//verify the delete service code from right panel by clicking 'delete' button
			if(billingData.testCaseId.equalsIgnoreCase("TC_SC_001")){
				assertTrue(click(selenium, lnkDelete),"Could not click delete in the right panel", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			//verify the delete service code from right panel by check box unchecking 
			else if(billingData.testCaseId.equalsIgnoreCase("TC_SC_002")){
				assertTrue(click(selenium, chkMasterListServiceCode1),"Could not uncheck the the first master list code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify delete In selected Service Code			  		  //
			//--------------------------------------------------------------------//
			if ((getText(selenium, lblSelectedServiceCodeFirstResult).trim().contains(billingData.serviceCode1.trim()))
					|| (getText(selenium, lblSelectedServiceCodeFirstResult).trim().contains(billingData.serviceDescription1.trim()))) {
				Assert.fail("Added master service code not shown in right panel");
			}
			
			if(isChecked(selenium, chkMasterListServiceCode1)){
				Assert.fail("After deleting master service code, Check box not unchecked");
			}

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

