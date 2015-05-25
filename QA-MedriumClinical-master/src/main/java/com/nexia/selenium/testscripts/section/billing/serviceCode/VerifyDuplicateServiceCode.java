package com.nexia.selenium.testscripts.section.billing.serviceCode;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDuplicateServiceCode extends AbstractBilling {
    	
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Service Code duplicate popup")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDuplicateServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_001";
		billingData.fetchBillingTestData();
		verifyAddServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}

    /*************************************************************************************************** 
	* @purpose        Verify Service Code duplicate 
	* @action 		  verifying Service Code duplicate 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US and CA
	* @since  	      Apr 09, 2014	
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
				
			assertTrue(click(selenium, rdoSetServiceFees),"Could not click the set service fees radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Fill details in service fees						      //
			//--------------------------------------------------------------------//
			assertTrue(fillServiceFee(selenium, billingData, userAccount),"Could not fill the service fees", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, rdoSetServiceDefault),"Could not click the set service default radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//----------------------------------------------------------------------------------------------//
			//  Step-5: Verify selected service code and set service fee details in set service default     //
			//----------------------------------------------------------------------------------------------//
			assertTrue(verifyDetailsInSetServiceDefault(selenium, billingData, userAccount),"Verify failed for the selected service code and set service fee details in set service default", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Fill details in set service default					      //
			//--------------------------------------------------------------------//
			assertTrue(fillSetServiceDefault(selenium, billingData, userAccount),"Could not fill the set service default", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnDoneServiceCode),"Could not click the done button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------------------//
			//  Step-7: Verify the created service code details in service code summary	      //
			//--------------------------------------------------------------------------------//
			assertTrue(type(selenium, txtSearchInServiceCode, billingData.serviceCode1),"Could not type the service code in search box", selenium, ClassName,MethodName);
			selenium.keyPress(txtSearchInServiceCode, "\\13");
			waitForPageLoad(selenium);
			
			assertTrue(verifyServiceCodeDetailsInSummary(selenium, billingData, userAccount),"Verify failed for added service code details in service code summary", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Service Code duplicate verification						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnManageServiceCodes),"Could not click the add button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkCustomTab),"Could not click the custom tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium, txtCustomServiceCode, billingData.serviceCode1),"Could not type the custom service code", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtCustomDescription, billingData.serviceDescription1),"Could not type the custom service description", selenium, ClassName,MethodName);
			assertTrue(click(selenium, btnAddCustomServiceCode),"Could not click the add button in the custom service code tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			selenium.mouseOver(txtCustomServiceCode);
			waitForPageLoad(selenium);
			assertTrue( getText(selenium, lblDuplicateServiceCode).toLowerCase().contains(("Enterprise service code "+ billingData.serviceCode1 + " (Active) already exists and may not be added").toLowerCase()),
					"Service Code duplicate verification failed", selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

