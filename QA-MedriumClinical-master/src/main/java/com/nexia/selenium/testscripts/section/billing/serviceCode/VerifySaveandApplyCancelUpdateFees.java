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

public class VerifySaveandApplyCancelUpdateFees extends AbstractBilling {  	
	
	 @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Save Update Fees")
	 @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void VerifySaveUpdateFees(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "ServiceCodes";
			billingData.testCaseId = "TC_SC_001";
			billingData.fetchBillingTestData();
			verifyUpdateFees(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	}

	 @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Custom Save Update Fees")
	 @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void VerifyCustomSaveUpdateFees(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "ServiceCodes";
			billingData.testCaseId = "TC_SC_007";
			billingData.fetchBillingTestData();
			verifyUpdateFees(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	}
	 @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Cancel Update Fees")
	 @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void VerifyCancelUpdateFees(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "ServiceCodes";
			billingData.testCaseId = "TC_SC_002";
			billingData.fetchBillingTestData();
			verifyUpdateFees(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	}
	 
	 /*************************************************************************************************** 
		* @purpose        Verify Save and Apply Cancel Update Fees
		* @action 		  Verify Save and Apply Cancel Update Fees
		* @author         Aspire QA
		* @throws         IOException 
		* @state          Developing
		* @useraccount    US and CA
		* @since  	      Feb 16, 2014	
		***************************************************************************************************/
	    
	    public boolean verifyUpdateFees(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
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
				//  Step-3: Add Master List Service Code							  //
				//--------------------------------------------------------------------//
				
				assertTrue(click(selenium, btnManageServiceCodes),"Could not click the add button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(billingData.testCaseId.equalsIgnoreCase("TC_SC_001")|| billingData.testCaseId.equalsIgnoreCase("TC_SC_002")){
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
				}
				
				//--------------------------------------------------------------------//
				//  Step-4: Add Custom Service Code									  //
				//--------------------------------------------------------------------//
				
				else if(billingData.testCaseId.equalsIgnoreCase("TC_SC_007")){
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
					
				}
				
				assertTrue(click(selenium, rdoSetServiceFees),"Could not click the set service fees radio button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5: Fill details in service fees						      //
				//--------------------------------------------------------------------//
				
				assertTrue(updateFillServiceFeeAndDefaultForSave(selenium, billingData, userAccount),"Could not fill the service fees", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-6: Navigate to Update fees								  //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium, btnUpdateFees),"Could not click the update fee button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			
				//--------------------------------------------------------------------//
				//  Step-7:  Search the service code 					  //
				//--------------------------------------------------------------------//
				selenium.type(txtSearchInMasterList, billingData.serviceCode1+' ');
		    	selenium.typeKeys(txtSearchInMasterList, "\\b");
						
				//--------------------------------------------------------------------//
				//  Step-8: Set the increase amount conditions					      //
				//--------------------------------------------------------------------//
				
				if(!(billingData.testCaseId.equalsIgnoreCase("TC_SC_002"))){
					
					assertTrue(type(selenium, txtIncreaseValue, billingData.percentage),"Could not type the increase amount", selenium, ClassName,MethodName);
					assertTrue(selectValueFromAjaxList(selenium, ajxModiferType, "percent"),"Could not select the increase type modifier", selenium,ClassName, MethodName);
					
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat DateFormat;
					if (userAccount.equalsIgnoreCase(CAAccount)) {
						DateFormat = new SimpleDateFormat("dd/MM/yyyy");
					} else {
						DateFormat = new SimpleDateFormat("MM/dd/yyyy");
					}
					
					
					cal.add(Calendar.DATE, 1);
					billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());
					
					assertTrue(enterDate(selenium,txtEffectiveNewDates,billingData.effectiveOnDateCurrent),"Could not enter the new effective date", selenium,ClassName, MethodName);
					
					assertTrue(click(selenium, clkApply),"Could not click the apply button", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					
					assertTrue(click(selenium, clkOverrideAll),"Could not click the continue and apply to all button", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);

					waitForPageLoad(selenium);
					
//					assertTrue(click(selenium, btnSaveUpdate),"Could not click the update fee  Save button", selenium, ClassName,MethodName);
//					waitForPageLoad(selenium);
//					
//					//--------------------------------------------------------------------//
//					//  Step-9:  Navigate to Update fees					  //
//					//--------------------------------------------------------------------//
//					
//					assertTrue(click(selenium, btnUpdateFees),"Could not click the update fee button", selenium, ClassName,MethodName);
//					waitForPageLoad(selenium);
//					
//					selenium.type(txtSearchInMasterList, billingData.serviceCode1+' ');
//			    	selenium.typeKeys(txtSearchInMasterList, "\\b");
//				
//					//--------------------------------------------------------------------//
//					//  Step-10: Verify the Updated Fees values			                  //
//					//--------------------------------------------------------------------//
//			    	waitForPageLoad(selenium);
//			    	waitForPageLoad(selenium);
			    	assertTrue(verifyUpdateFees(selenium, billingData, userAccount),"Verify the Updated Fees values	 failed", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				
				}else{
					
					// Verify the Cancel Function
					assertTrue(type(selenium, txtIncreaseValue, billingData.amount),"Could not type the increase amount", selenium, ClassName,MethodName);
					assertTrue(selectValueFromAjaxList(selenium, ajxModiferType, "dollars"),"Could not select the increase type modifier", selenium,ClassName, MethodName);
					assertTrue(enterDate(selenium,txtEffectiveNewDates,billingData.effectiveOnDateCurrent),"Could not enter the new effective date", selenium,ClassName, MethodName);
					assertTrue(click(selenium, clkApply),"Could not click the apply button", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium, clkOverrideCancel),"Could not click the update fee  Cancel button", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);					
					assertTrue( !selenium.isTextPresent(txtIncreaseValue), "Verify Cancel failed", selenium, ClassName, MethodName);
				}	
			
			}
			catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return true;
	    }
	    
	    
	    public boolean updateFillServiceFeeAndDefaultForSave(Selenium selenium, BillingLib billingData,
	    		String userAccount) throws IOException {
	    		Calendar cal = Calendar.getInstance();
	    		SimpleDateFormat DateFormat;
	    		if (userAccount.equalsIgnoreCase(CAAccount)) {
	    			DateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    		} else {
	    			DateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    		}
	    		billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());
	    		assertTrue(type(selenium, txtFeeAmount, billingData.currentFees),
	    				"Could not type the fee amount", selenium, ClassName,
	    				MethodName);
	    		assertTrue(
	    				enterDate(selenium, txtEffectiveDateInServiceFee,
	    						billingData.effectiveOnDateCurrent),
	    				"Could not type effect", selenium, ClassName, MethodName);
	    		if(userAccount.equals(USAccount)){
		    		assertTrue(type(selenium, txtUnits, billingData.units),
		    				"Could not type the units", selenium, ClassName, MethodName);
	    		}
	    		assertTrue(click(selenium, rdoSetServiceDefault),"Could not click the set service default radio button", selenium, ClassName,MethodName);
	    		waitForPageLoad(selenium);
	    		assertTrue(click(selenium, btnSaveAndNext),"Could not click the Save and Next button", selenium, ClassName,MethodName);
	    		waitForPageLoad(selenium);
	    		assertTrue(click(selenium, btnSaveAndNext),"Could not click the second time Save and Next button", selenium, ClassName,MethodName);
	    		waitForPageLoad(selenium);
	    		assertTrue(click(selenium, btnDoneServiceCode),"Could not click the done button", selenium, ClassName,MethodName);
	    		waitForPageLoad(selenium);
	    		
	    		return true;
	    	}
	    	
	    public boolean verifyUpdateFees(Selenium selenium,BillingLib billingData,String userAccount) throws IOException {
	    	assertTrue( getValue(selenium, txtNewFeeDate).trim().contains(billingData.effectiveOnDateCurrent.trim()),
	    		    "Not able to find text " +billingData.effectiveOnDateCurrent , selenium, ClassName, MethodName);				
	    	
	    	assertTrue( getValue(selenium, txtUpdateFeeAmount).trim().contains(billingData.updatedAmtPercent.trim()),
	    		    "Not able to find text " +billingData.updatedAmtPercent , selenium, ClassName, MethodName);				
	    		
			return true;
		}
}


