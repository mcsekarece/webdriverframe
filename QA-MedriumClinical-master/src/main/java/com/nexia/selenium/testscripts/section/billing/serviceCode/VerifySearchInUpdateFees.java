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

public class VerifySearchInUpdateFees extends AbstractBilling {
    	
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Search In UpdateFees by code")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchUpdateFeesByCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_001";
		billingData.fetchBillingTestData();
		verifyAddServiceCode(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	}
    
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Search In UpdateFees by description")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchUpdateFeesByDescription(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_002";
		billingData.fetchBillingTestData();
		verifyAddServiceCode(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	}
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Search Custom In UpdateFees by code")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchCustomUpdateFeesByCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_004";
		billingData.fetchBillingTestData();
		verifyAddServiceCode(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	}
    
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Search Custom In UpdateFees by description")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchCustomUpdateFeesByDescription(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_005";
		billingData.fetchBillingTestData();
		verifyAddServiceCode(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	}
     
    /*************************************************************************************************** 
	* @purpose        VerifySearchInUpdateFeesBy Code/Description
	* @action 		  VerifySearchInUpdateFeesBy Code/Description
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US and CA
	* @since  	      Feb 14, 2014	
	***************************************************************************************************/

    public boolean verifyAddServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
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
			//  Step-3: Add Master List Service Code							  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnManageServiceCodes),"Could not click the add button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(billingData.testCaseId.equalsIgnoreCase("TC_SC_001")||billingData.testCaseId.equalsIgnoreCase("TC_SC_002")){
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
				
				billingData.serviceDescription1 = getText(selenium, lblMasterListServiceDescription1);
				billingData.serviceDescription2 = getText(selenium, lblMasterListServiceDescription2);
				
				
				assertTrue(click(selenium, chkMasterListServiceCode1),"Could not check the the first master list code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, chkMasterListServiceCode2),"Could not check the the second master list code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
			}
			
			//--------------------------------------------------------------------//
			//  Step-3: Add Custom Service Code									  //
			//--------------------------------------------------------------------//
			else if(billingData.testCaseId.equalsIgnoreCase("TC_SC_004")||billingData.testCaseId.equalsIgnoreCase("TC_SC_005")){
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
			}
			
			assertTrue(click(selenium, btnDoneServiceCode),"Could not click the done button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to  Update fees								  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnUpdateFees),"Could not click the update fee button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify the service code results								  //
			//--------------------------------------------------------------------//
			
			if(billingData.testCaseId.equalsIgnoreCase("TC_SC_001") || billingData.testCaseId.equalsIgnoreCase("TC_SC_004")){
				assertTrue(type(selenium, txtSearchInMasterList, billingData.serviceCode2),"Could not type the code in search box", selenium, ClassName,MethodName);
			}
			else if(billingData.testCaseId.equalsIgnoreCase("TC_SC_002") || billingData.testCaseId.equalsIgnoreCase("TC_SC_005")){
				assertTrue(type(selenium, txtSearchInMasterList, billingData.serviceDescription2),"Could not type the description in search box", selenium, ClassName,MethodName);
			}
	        selenium.focus(txtSearchInMasterList);
	        selenium.keyPress(txtSearchInMasterList, "\\13");    
	        selenium.clickAt(txtSearchInMasterList,"");
			waitForPageLoad(selenium);
			
			//verify  existence of service code 2 in filtered result
			if (!(getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceCode2.trim()))
					&& (getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceDescription2.trim()))){				
				assertTrue( false, "Searched service code is not displayed in Update service code list", selenium, ClassName, MethodName);
			}
			//verify not existence of service code 1 in filtered result
			if (getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceCode1.trim())
					&& (getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceDescription1.trim()))){				
				assertTrue( false, "Searched service code is not displayed in Update service code list ", selenium, ClassName, MethodName);
			}
			
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
    }
    
}