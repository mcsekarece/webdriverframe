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

public class VerifyAddNewFeeInSetServiceDefault extends AbstractBilling {

	 @Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Add New Private Fee In Set Service Default")
	 @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void verifyAddNewFeeInSetServiceDefault(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "ServiceCodes";
			billingData.testCaseId = "TC_SC_033";
			billingData.fetchBillingTestData();
			verifyAddNewFee(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	 }
	 
     /*************************************************************************************************** 
	 * @purpose       Verify Add New Private Fee In Set Service Default
	 * @action 		  Verifying Add New Private Fee In Set Service Default
	 * @author        Aspire QA
	 * @throws        IOException 
	 * @state         Developing
	 * @useraccount   CA
	 * @since  	      May 07, 2014	
	 ***************************************************************************************************/
	 public boolean verifyAddNewFee(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
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
				//  Step-3: Add Master List Service Code							  //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium, btnAddServiceCode),"Could not click the add button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			
				assertTrue(click(selenium, lnkMasterListTab),"Could not click the master list tab", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
					
				assertTrue(selectValueFromAjaxList(selenium, ajxCodingSystem, billingData.codingSystemCA),"Could not select the type of coding system", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
					
				billingData.serviceCode1 = getText(selenium, lblMasterListServiceCode1);
				billingData.serviceDescription1 = getText(selenium, lblMasterListServiceDescription1);
					
			    assertTrue(click(selenium, chkMasterListServiceCode1),"Could not check the the first master list code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
					
				assertTrue(click(selenium, rdoSetServiceFees),"Could not click the set service fees radio button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-4: Navigate to service default							      //
				//--------------------------------------------------------------------//
				billingData.currentFees = getText(selenium, lblStandaredFeeInSetServiceFee).trim();
				billingData.effectiveOnDateCurrent = getText(selenium, lblStandaredEffectiveDateInSetServiceFee).trim();	
				
				//get the current date
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat;
				if (userAccount.equalsIgnoreCase(CAAccount)) {
					DateFormat = new SimpleDateFormat("dd/MM/YYYY");
				}else{
					DateFormat = new SimpleDateFormat("MM/dd/YYYY");
				}
				
				String privateEffectiveDate1= DateFormat.format(cal.getTime());
				
				assertTrue(type(selenium, txtFeeAmount, billingData.privateFee1), "Could not type the private fee-1 amount", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(enterDate(selenium, txtEffectiveDateInServiceFee, privateEffectiveDate1), "Could not type effect date for private fee-1", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium, rdoSetServiceDefault),"Could not click the set service default radio button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5: Add private fee in set service default					  //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium, btnAddNewInServiceDefault),"Could not click the 'add new' private fee in set service default", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				 
				
				cal.add(Calendar.DATE, 1);
				String privateEffectiveDate2= DateFormat.format(cal.getTime());
				
				assertTrue(type(selenium, txtPrivateFee1, billingData.privateFee2), "Could not type the private fee-2 amount", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(enterDate(selenium, txtPrivateEffectiveDate1, privateEffectiveDate2), "Could not type effect date for private fee-2", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium, btnDoneServiceCode),"Could not click the done button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------------------//
				//  Step-6: Verify the created service code details in service code summary	      //
				//--------------------------------------------------------------------------------//
				assertTrue(type(selenium, txtSearchInServiceCode, billingData.serviceCode1),"Could not type the service code in search box", selenium, ClassName,MethodName);
				selenium.keyPress(txtSearchInServiceCode, "\\13");
				waitForPageLoad(selenium);
				
				billingData.currentFees = billingData.privateFee1;
				
				assertTrue(verifyServiceCodeDetailsInSummary(selenium, billingData, userAccount),"Verify failed for added service code details in service code summary", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------------------------------//
				//  Step-7: Verify Added private fee in service code summary Right Panel	    			  //
				//--------------------------------------------------------------------------------------------//
				assertTrue(click(selenium, lblFilterResultInServiceCodeFirst),"Could not click the first filtered result in the service code summary", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				String SummaryServiceCodeRightPanel = getText(selenium, lblSummaryServiceCodeRightPanel);
				
				// verify entered mandatory field values in right side panel
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(billingData.serviceCode1.toLowerCase().trim())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(billingData.currentFees.toLowerCase().trim())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(billingData.privateFee1.toLowerCase().trim())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(billingData.privateFee2.toLowerCase().trim())) {
					return false;
				}
			}	
			catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return true;
	    }
}