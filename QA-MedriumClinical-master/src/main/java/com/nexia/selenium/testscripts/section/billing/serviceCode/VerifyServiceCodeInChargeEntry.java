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

public class VerifyServiceCodeInChargeEntry extends AbstractBilling {
    	
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Service Code availability in charge entry")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyServiceCodeAvailabilityInChargeEntry(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_001";
		billingData.fetchBillingTestData();
		verifyAddServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Service Code not available in charge entry ")
   	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
   	public void verifyServiceCodeNotAvailableInChargeEntry(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
   		ClassName=this.getClass().getName().substring(39);	
   		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
   		BillingLib billingData = new BillingLib();
   		billingData.workSheetName = "ServiceCodes";
   		billingData.testCaseId = "TC_SC_030";
   		billingData.fetchBillingTestData();
   		verifyAddServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
   	}

    /*************************************************************************************************** 
	* @purpose        Verify Service Code in charge entry 
	* @action 		  verifying Service Code in charge entry
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
			if(billingData.testCaseId.equalsIgnoreCase("TC_SC_001")){
				if (userAccount.equalsIgnoreCase(CAAccount)) {
					DateFormat = new SimpleDateFormat("dd/MM/YYYY");
				} else {
					DateFormat = new SimpleDateFormat("MM/dd/YYYY");
				}
				billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());
	
				if(userAccount.equals(CAAccount)){
					billingData.units = String.valueOf(0);
					billingData.currentFees = getText(selenium, lblStandaredFeeInSetServiceFee).trim();
					billingData.effectiveOnDateCurrent = getText(selenium, lblStandaredEffectiveDateInSetServiceFee).trim();	
				}
				else{
					assertTrue(type(selenium, txtFeeAmount, billingData.currentFees),"Could not type the fee amount", selenium, ClassName,MethodName);
					assertTrue(enterDate(selenium, txtEffectiveDateInServiceFee,billingData.effectiveOnDateCurrent),"Could not type effect", selenium, ClassName, MethodName);
					assertTrue(type(selenium, txtUnits, billingData.units),"Could not type the units", selenium, ClassName, MethodName);
				}
			}else{
				cal.add(Calendar.DATE, 1);
				
				if (userAccount.equalsIgnoreCase(CAAccount)) {
					DateFormat = new SimpleDateFormat("dd/MM/YYYY");
				} else {
					DateFormat = new SimpleDateFormat("MM/dd/YYYY");
				}
				billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());
				if(userAccount.equals(CAAccount)){
					billingData.units = String.valueOf(0);
					billingData.currentFees = getText(selenium, lblStandaredFeeInSetServiceFee).trim();
					billingData.effectiveOnDateCurrent = getText(selenium, lblStandaredEffectiveDateInSetServiceFee).trim();	
				}
				else{
					assertTrue(type(selenium, txtFeeAmount, billingData.currentFees),"Could not type the fee amount", selenium, ClassName,MethodName);
					assertTrue(enterDate(selenium, txtEffectiveDateInServiceFee,billingData.effectiveOnDateCurrent),"Could not type effect", selenium, ClassName, MethodName);
					assertTrue(type(selenium, txtUnits, billingData.units),"Could not type the units", selenium, ClassName, MethodName);
				}
			}

			
			assertTrue(click(selenium, rdoSetServiceDefault),"Could not click the set service default radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Fill details in set service default					      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnDoneServiceCode),"Could not click the done button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------------------//
			//  Step-6: Verify the created service code details in service code summary	      //
			//--------------------------------------------------------------------------------//
			assertTrue(type(selenium, txtSearchInServiceCode, billingData.serviceCode1),"Could not type the service code in search box", selenium, ClassName,MethodName);
			selenium.keyPress(txtSearchInServiceCode, "\\13");
			waitForPageLoad(selenium);
			
			String FirstFilteredResultInServiceCode = getText(selenium,
					lblFilterResultInServiceCodeFirst);

			assertTrue( FirstFilteredResultInServiceCode.toLowerCase().contains(billingData.serviceCode1.toLowerCase().trim()),
				    "Not able to find text " +billingData.serviceCode1 , selenium, ClassName, MethodName);		
								
			assertTrue( FirstFilteredResultInServiceCode.toLowerCase().contains(billingData.serviceDescription1.toLowerCase()),
				    "Not able to find text " +billingData.serviceDescription1 , selenium, ClassName, MethodName);				
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Service Code in charge entry						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToPatient(selenium, billingData),"Could not navigate to patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(goToPostNewCharge(selenium, billingData),"Could not navigate to charge entry", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//get the current calendar object
			cal = Calendar.getInstance();
			billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());
			
			assertTrue(enterDate(selenium, dateSLStartDate, billingData.effectiveOnDateCurrent), "Could not enter From date", selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium, dateSLEndDate, billingData.effectiveOnDateCurrent), "Could not enter To date", selenium, ClassName, MethodName);
			
			if(billingData.testCaseId.equalsIgnoreCase("TC_SC_001")){
				//verify existence of service code
				assertTrue( selectValueFromAjaxList(selenium, ajxServiceCodeCharge, billingData.serviceCode1),
						"Service Code Not Appear In The Charge Entry", selenium, ClassName, MethodName);
			}
			else{
				//verify not existence of service code
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge, billingData.serviceCode1),
						 "Service Code Appear In The Charge Entry", selenium, ClassName, MethodName);
				assertTrue(click(selenium, ajxServiceCodeCharge),
						 "Service Code Appear In The Charge Entry", selenium, ClassName, MethodName);
				assertTrue(!isElementPresent(selenium, scrollPanel),
						 "Service Code Appear In The Charge Entry", selenium, ClassName, MethodName);
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

