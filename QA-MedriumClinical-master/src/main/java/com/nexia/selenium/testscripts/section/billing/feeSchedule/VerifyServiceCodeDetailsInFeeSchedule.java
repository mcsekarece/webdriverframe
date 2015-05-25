package com.nexia.selenium.testscripts.section.billing.feeSchedule;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyServiceCodeDetailsInFeeSchedule extends AbstractBilling {
    	
    @Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Custom Service Code Details in Fee Schedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyServiceCodeDetailsInFeeSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_004";
		billingData.fetchBillingTestData();
		verifyServiceCodeDetailsInFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    /*************************************************************************************************** 
	* @purpose        Verify Custom Service Code Details in Fee Schedule
	* @action 		  verifying Custom Service Code Details in Fee Schedule
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US
	* @since  	      Feb 19, 2014	
	***************************************************************************************************/
	public boolean verifyServiceCodeDetailsInFeeSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		String payerName = "Aspire QA";
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
			//  Step-3: Add Master List Service Code							  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddServiceCode),"Could not click the add button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Add Custom Service Code									  //
			//--------------------------------------------------------------------//
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
			assertTrue(click(selenium, btnAddServiceCode),"Could not click the add button in the custom service code tab", selenium, ClassName,MethodName);
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
			
			//--------------------------------------------------------------------------------------------//
			//  Step-8: Verify the created service code details in service code summary Right Panel	      //
			//--------------------------------------------------------------------------------------------//
			assertTrue(click(selenium, lblFilterResultInServiceCodeFirst),"Could not click the first filtered result in the service code summary", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyServiceCodeDetailsInSummaryRightPanel(selenium, billingData, userAccount), "Verify failed for added service code details in service code summary Right Panel", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Navigate to Fee Schedule 								  //
			//--------------------------------------------------------------------//
			assertTrue(goToFeeSchedule(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			click(selenium, btnAddNewFeeSchedule);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium, ajxPayer, payerName), "could not select payer", selenium, ClassName, MethodName);
			
			assertTrue(selectValueFromAjaxList(selenium, ajxSearch,billingData.serviceCode1),"could not search searchServiceCode", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify Custom Service Code Details in Fee Schedule		  //
			//--------------------------------------------------------------------//
			if (!(getText(selenium,lblChargeAmount).toLowerCase().contains(billingData.currentFees.toLowerCase().trim()))) {
				return false;
			}
			
			if (!(getText(selenium,lblChargeUnit).toLowerCase().contains(billingData.units.toLowerCase().trim()))) {
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

