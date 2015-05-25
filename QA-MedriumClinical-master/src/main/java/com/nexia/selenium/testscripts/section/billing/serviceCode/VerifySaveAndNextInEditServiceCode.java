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

public class VerifySaveAndNextInEditServiceCode extends AbstractBilling {
    	
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify 'save and next' in the edit service code")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveAndNextInEditServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_001";
		billingData.fetchBillingTestData();
		verifySaveAndNextInEditServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}

    /*************************************************************************************************** 
	* @purpose        Verify 'save and next' in the edit service code
	* @action 		  verifying 'save and next' in the edit service code
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US and CA
	* @since  	      Jan 23, 2014	
	***************************************************************************************************/
	public boolean verifySaveAndNextInEditServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
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
			
			String commonServiceCode = billingData.serviceCode1.substring(1, 9);
			
			int tempServiceCode = Integer.parseInt(billingData.serviceCode1);
			
			if(billingData.serviceCode1.charAt(9) == 9){
				billingData.serviceCode2 = String.valueOf(tempServiceCode -1);
				billingData.serviceDescription2 = billingData.serviceDescription2 + billingData.serviceCode2;
			}
			else{
				billingData.serviceCode2 = String.valueOf(tempServiceCode +1);
				billingData.serviceDescription2 = billingData.serviceDescription2 + billingData.serviceCode2;
			}
			
			
			assertTrue(type(selenium, txtCustomServiceCode, billingData.serviceCode1),"Could not type the custom service code", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtCustomDescription, billingData.serviceDescription1),"Could not type the custom service description", selenium, ClassName,MethodName);
			assertTrue(click(selenium, btnAddCustomServiceCode),"Could not click the add button in the custom service code tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
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
			
			assertTrue(click(selenium, btnDoneServiceCode),"Could not click the set service default radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify the created service code in summary				  //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium, txtSearchInServiceCode, commonServiceCode),"Could not type the common code in search box", selenium, ClassName,MethodName);
			selenium.keyPress(txtSearchInServiceCode, "\\13");
			waitForPageLoad(selenium);
			
			if (!(getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceCode1.trim())
					&& (getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceDescription1.trim())))){				
				assertTrue( false,"Searched service code is not displayed in the master list", selenium, ClassName, MethodName);
			}
			
			
				if (!(getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceCode2.trim())
						&& (getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceDescription2.trim())))){				
					assertTrue( false, "Searched service code is not displayed in the master list", selenium, ClassName, MethodName);
			
				}
			assertTrue(click(selenium, lblFilterResultInServiceCodeFirst),"Could not click the first filtered result in the service code summary", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify 'save and next' in the edit service code		      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnEditServiceCode),"Could not click the edit button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyDetailsInSetServiceDefault(selenium, billingData, userAccount),"Verify failed for added service code details in edit service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnSaveAndNext),"Could not click the save and next button", selenium, ClassName,MethodName);
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

