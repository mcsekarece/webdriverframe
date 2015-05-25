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

public class VerifyApplyOptionsInSetServiceFee extends AbstractBilling {

	 @Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Apply Options In Set Service Fee based on percentage")
	 @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void verifyApplyOptionsInSetServiceFeeBasedOnPercentage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "ServiceCodes";
			billingData.testCaseId = "TC_SC_031";
			billingData.fetchBillingTestData();
			verifyApplyOption(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	 }
	 
	 @Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Apply Options In Set Service Fee based on amount")
	 @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void verifyApplyOptionsInSetServiceFeeBasedOnAmount(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "ServiceCodes";
			billingData.testCaseId = "TC_SC_032";
			billingData.fetchBillingTestData();
			verifyApplyOption(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	 }
     /*************************************************************************************************** 
	 * @purpose       Verify Apply Options In Set Service Fee
	 * @action 		  Verifying Apply Options In Set Service Fee
	 * @author        Aspire QA
	 * @throws        IOException 
	 * @state         Developing
	 * @useraccount   CA
	 * @since  	      May 07, 2014	
	 ***************************************************************************************************/
	 public boolean verifyApplyOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
			Selenium selenium=null;
			Float oldFee ;
			Float newFee = Float.valueOf(0);
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
				assertTrue(click(selenium, btnManageServiceCodes),"Could not click the add button", selenium, ClassName,MethodName);
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
				//  Step-4: Fill details in service fees						      //
				//--------------------------------------------------------------------//
				//get the standard fee
				System.out.println(getText(selenium, lblStandaredFeeInSetServiceFee));
				oldFee = Float.parseFloat(getText(selenium, lblStandaredFeeInSetServiceFee));
				if(oldFee==null){
					oldFee = (float) 0;
				}
				
				//get the current date
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat;
				if (userAccount.equalsIgnoreCase(CAAccount)) {
					DateFormat = new SimpleDateFormat("dd/MM/YYYY");
				}else{
					DateFormat = new SimpleDateFormat("MM/dd/YYYY");
				}
				billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());

				//type the value in the modifier
				if(billingData.testCaseId.equalsIgnoreCase("TC_SC_031")){
					//set the condition, If oldFee is zero then don't enter the calculation part
					if(oldFee!=0){
					  newFee = oldFee + (oldFee/Float.parseFloat(billingData.percentage));
					}
					assertTrue(type(selenium, txtIncreaseValue, billingData.percentage),"Could not type the increase amount", selenium, ClassName,MethodName);
				}else if(billingData.testCaseId.equalsIgnoreCase("TC_SC_032")){
					newFee = oldFee + (Float.parseFloat(billingData.amount));
					assertTrue(type(selenium, txtIncreaseValue, billingData.amount),"Could not type the increase amount", selenium, ClassName,MethodName);
				}
				//select the modifier based on type of case
				assertTrue(selectValueFromAjaxList(selenium, ajxModiferType,billingData.modifierType),"Could not select the increase type modifier", selenium,ClassName, MethodName);
				assertTrue(enterDate(selenium,txtEffectiveNewDates,billingData.effectiveOnDateCurrent),"Could not enter the new effective date", selenium,ClassName, MethodName);
				
				assertTrue(click(selenium, btnApply),"Could not click the apply button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5: Verify Apply option in service fees						  //
				//--------------------------------------------------------------------//
				System.out.println(newFee);
				if(!getValue(selenium, txtFeeAmount).contains(String.valueOf(newFee))){
					Assert.fail("Verification failed for Apply Options In Set Service Fee");
				}else
					return true;
			
			}	
			catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return true;
	    }
}