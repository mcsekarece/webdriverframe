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

public class VerifyApplyOptions extends AbstractBilling {

	 @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Apply options Continue and apply to all")
	 @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void verifyContinueAndApplyToAll(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "ServiceCodes";
			billingData.testCaseId = "TC_SC_001";
			billingData.fetchBillingTestData();
			verifyUpdateFees(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	}
	 
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Update Fees By Amount")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyContinueAndKeepExisting(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "ServiceCodes";
			billingData.testCaseId = "TC_SC_002";
			billingData.fetchBillingTestData();
			verifyUpdateFees(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	}
	
	  /*************************************************************************************************** 
		* @purpose        VerifyUpdateFeesBy Amount/Percentage for future date
		* @action 		  VerifyUpdateFeesBy Amount/Percentage for future date
		* @author         Aspire QA
		* @throws         IOException 
		* @state          Developing
		* @useraccount    US and CA
		* @since  	      Feb 17, 2014	
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
					
				billingData.serviceCode2 = getText(selenium, lblMasterListServiceCode2);
				billingData.serviceDescription2 = getText(selenium, lblMasterListServiceDescription2);

			    assertTrue(click(selenium, chkMasterListServiceCode1),"Could not check the the first master list code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, chkMasterListServiceCode2),"Could not check the the second master list code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
								
				assertTrue(click(selenium, rdoSetServiceFees),"Could not click the set service fees radio button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5: Fill details in service fees						      //
				//--------------------------------------------------------------------//
			
				assertTrue(updateFillServiceFeeAndDefault(selenium, billingData, userAccount),"Could not fill the service fees", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
							
				//--------------------------------------------------------------------//
				//  Step-6: Navigate to Update fees								  //
				//--------------------------------------------------------------------//
			
				assertTrue(click(selenium, btnUpdateFees),"Could not click the update fee button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			
				// Search the service code 
			
				assertTrue(type(selenium, txtFilterCodeRangeFrom, billingData.serviceCode1),"Could not type the code in range from", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtFilterCodeRangeEnd, billingData.serviceCode2),"Could not type the code in range end", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.keyPress(txtFilterCodeRangeEnd, "\\13");
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-9: Set the increase amount conditions					      //
				//--------------------------------------------------------------------//
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE,2); 
				SimpleDateFormat DateFormat;
				if (userAccount.equalsIgnoreCase(CAAccount)) {
					DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				}else{
					DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				}
				billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());

				assertTrue(updateFees(selenium, billingData, userAccount),"Could not update the fees", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
				//--------------------------------------------------------------------//
				//  Step-10: Verify the Updated Fees values			    //
				//--------------------------------------------------------------------//
				
				assertTrue(verifyUpdateFees(selenium, billingData, userAccount),"Verify the Updated Fees values	 failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-11: Verify the the apply options		    //
				//--------------------------------------------------------------------//
				
				cal.add(Calendar.DATE,2); 
				if (userAccount.equalsIgnoreCase(CAAccount)) {
					DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				}else{
					DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				}
				billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());
				
				if(billingData.testCaseId.equalsIgnoreCase("TC_SC_001")){
				assertTrue(updateFees(selenium, billingData, userAccount),"Could not update the fees", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				// Verify the Updated Fees values			
				
				assertTrue(verifyUpdateFees(selenium, billingData, userAccount),"Verify the Updated Fees values	 failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				}else{

				// Verify Continue And Keep Existing
					
				  assertTrue(type(selenium, txtIncreaseValue, billingData.percentage),"Could not type the increase amount", selenium, ClassName,MethodName);
				  assertTrue(selectValueFromAjaxList(selenium, ajxModiferType, "percent"),"Could not select the increase type modifier", selenium,ClassName, MethodName);
				  assertTrue(enterDate(selenium,txtEffectiveNewDates,billingData.effectiveOnDateCurrent),"Could not enter the new effective date", selenium,ClassName, MethodName);
				  assertTrue(click(selenium, clkApply),"Could not click the apply button", selenium, ClassName,MethodName);
				  assertTrue(click(selenium, clkOverrideSome),"Could not click the continue but keep existing all button", selenium, ClassName,MethodName);
				  
				// Verify the Updated Fees values			
					
					assertTrue(verifyUpdateFees_KeepExisting(selenium, billingData, userAccount),"Verify the Updated Fees values	 failed", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
		        }
			
			   }	
			catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return true;
	    }
	    public boolean verifyUpdateFees(Selenium selenium,BillingLib billingData,String userAccount) throws IOException {
	    	/*String date = null;
	    	if (userAccount.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal.getTime());
				
			} else {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal.getTime());

			}
	    	billingData.effectiveOnDateCurrent = date;*/
	    	if (userAccount.equals(CAAccount)) {
	    		if(billingData.testCaseId.equals("TC_SC_001")){
			    	if (!(getValue(selenium, txtUpdateFeeAmount).trim().contains(billingData.updatedAmtPercent.trim()))){
					     return false;	
			   	     }
			    	if (!(getValue(selenium, txtUpdateFeeAmount1).trim().contains(billingData.updatedAmtPercent1.trim()))){
					     return false;	
			   	     }
			   
			    	if (!(getValue(selenium, txtNewFeeDate).trim().contains(billingData.effectiveOnDateCurrent.trim()))){
					     return false;	
			    	}
			    	if (!(getValue(selenium, txtNewFeeDate1).trim().contains(billingData.effectiveOnDateCurrent.trim()))){
					     return false;	
			    	}
					
		    	}if(billingData.testCaseId.equals("TC_SC_002")){
			    	if (!(getValue(selenium, txtUpdateFeeAmount).trim().contains(billingData.updatedAmt.trim()))){
					     return false;	
			   	     }
			    	if (!(getValue(selenium, txtUpdateFeeAmount1).trim().contains(billingData.updatedAmt1.trim()))){
					     return false;	
			   	     }
			   
			    	if (!(getValue(selenium, txtNewFeeDate).trim().contains(billingData.effectiveOnDateCurrent.trim()))){
					     return false;	
			    	}
			    	if (!(getValue(selenium, txtNewFeeDate1).trim().contains(billingData.effectiveOnDateCurrent.trim()))){
					     return false;	
			    	}
					
		    	}
	    	}else{
	    		if (!(getValue(selenium, txtUpdateFeeAmount).trim().contains(billingData.updatedAmt.trim()))){
				     return false;	
		   	     }
		    	if (!(getValue(selenium, txtUpdateFeeAmount1).trim().contains(billingData.updatedAmt1.trim()))){
				     return false;	
		   	     }
		   
		    	if (!(getValue(selenium, txtNewFeeDate).trim().contains(billingData.effectiveOnDateCurrent.trim()))){
				     return false;	
		    	}
		    	if (!(getValue(selenium, txtNewFeeDate1).trim().contains(billingData.effectiveOnDateCurrent.trim()))){
				     return false;	
		    	}
				
	    	}
	    	return true;
	    }
	    		
		
	    public boolean verifyUpdateFees_KeepExisting(Selenium selenium,BillingLib billingData,String userAccount) throws IOException {

	    	//String date = null;
	    	/*if (userAccount.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd");
				date = DateFormat.format(cal.getTime());
				int date1 = Integer.parseInt(date);
				if (date1 < 10) {
					SimpleDateFormat DateForma1t = new SimpleDateFormat(
							"MMM d, yyyy");
					date = DateForma1t.format(cal.getTime());
				} else {
					SimpleDateFormat DateFormat2 = new SimpleDateFormat(
							"MMM dd, yyyy");
					date = DateFormat2.format(cal.getTime());
				}
			} else {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal.getTime());

			}
	    	billingData.effectiveOnDateCurrent = date;*/
	    	
	    	if (!(getValue(selenium, txtUpdateFeeAmount).trim().contains(billingData.updatedAmtPercent.trim()))){
			     return false;	
	   	     }
	    	if (!(getValue(selenium, txtUpdateFeeAmount1).trim().contains(billingData.updatedAmtPercent1.trim()))){
			     return false;	
	   	     }
	   
	    	if (!(getValue(selenium, txtNewFeeDate).trim().contains(billingData.effectiveOnDateCurrent.trim()))){
			     return false;	
	    	}
	    	if (!(getValue(selenium, txtNewFeeDate1).trim().contains(billingData.effectiveOnDateCurrent.trim()))){
			     return false;	
	    	}
			return true;
		}
}