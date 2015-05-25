package com.nexia.selenium.testscripts.section.billing.feeSchedule;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCopyFeeSchedule extends AbstractBilling {
    	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Copy Fee Schedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCopyFeeSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "FeeSchedule";
		billingData.testCaseId = "TC_FS_001";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Copy Fee Schedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditCopyFeeSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "FeeSchedule";
		billingData.testCaseId = "TC_FS_005";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    	
    	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Copy Fee Schedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditCopyFeeScheduleWithPercent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "FeeSchedule";
		billingData.testCaseId = "TC_FS_006";
		billingData.fetchBillingTestData();
		addFeeSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
	
	/**
	 * addFeeSchedule
	 * function to add fee schedule
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      	IOException 
	 * @since  	   	Jan 09, 2014
	 */
	
	public boolean addFeeSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Fee Schedule //
			//--------------------------------------------------------------------//
			
			assertTrue(goToFeeSchedule(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete All Fee Schedule//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteAllFeeSchedule(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Add Fee Schedule //
			//--------------------------------------------------------------------//
			
			assertTrue(addFeeSchedule(selenium,billingData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			
			if(!(isElementPresent(selenium,lnkDelete) && isElementPresent(selenium,lnkEdit))){
			    returnValue=false;
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Fee Schedule //
			//--------------------------------------------------------------------//
			
			if(billingData.testCaseId.equals("TC_FS_005")){
			    assertTrue(click(selenium,lnkEdit),"Could not click on Edit button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    
			    billingData.workSheetName = "FeeSchedule";
			    billingData.testCaseId = "TC_FS_004";
			    billingData.fetchBillingTestData();
				
			    assertTrue(selectValueFromAjaxList(selenium, ajxCopyPayer,billingData.payer1),"could not select existingPayer", selenium, ClassName, MethodName);
			    assertTrue(selectValueFromAjaxList(selenium, ajxCopyProvider,billingData.plan),"could not select practice", selenium, ClassName, MethodName);
			    assertTrue(type(selenium, txtIncreaseAmount,billingData.allowedUnit),"could not enter IncreaseAmount", selenium, ClassName, MethodName);
			    assertTrue(selectValueFromAjaxList(selenium, ajxAmountType,billingData.allowedType),"could not AmountType", selenium, ClassName, MethodName);
			    assertTrue(type(selenium, txtCopyEffectiveDate,billingData.effectiveDate),"could not enter Effective Date", selenium, ClassName, MethodName);
				
			    assertTrue(click(selenium, btnCopy),"could not click on copy button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    
			    if(!verifyCopiedDetails(selenium,billingData)){
				    Assert.fail("Copy Failed");
				}
				
				/*assertTrue(click(selenium, btnSaveFeeSchedule),"could not click on save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(!isElementPresent(selenium,btnAddNewFeeSchedule)){
				    returnValue=false;
				}*/
				
				/*if(!verifyFeeScheduelInSummary(selenium,billingData)){
				    Assert.fail("Creation Failed");
				}*/
				
				return true;
			}
			
			if(billingData.testCaseId.equals("TC_FS_006")){
			    assertTrue(click(selenium,lnkEdit),"Could not click on Edit button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    
			    billingData.workSheetName = "FeeSchedule";
			    billingData.testCaseId = "TC_FS_004";
			    billingData.fetchBillingTestData();
				
			    assertTrue(selectValueFromAjaxList(selenium, ajxCopyPayer,billingData.payer1),"could not select existingPayer", selenium, ClassName, MethodName);
			    assertTrue(selectValueFromAjaxList(selenium, ajxCopyProvider,billingData.plan),"could not select practice", selenium, ClassName, MethodName);
			    assertTrue(type(selenium, txtIncreaseAmount,billingData.allowedUnit),"could not enter IncreaseAmount", selenium, ClassName, MethodName);
			    assertTrue(selectValueFromAjaxList(selenium, ajxAmountType,"Percent"),"could not AmountType", selenium, ClassName, MethodName);
			    assertTrue(type(selenium, txtCopyEffectiveDate,billingData.effectiveDate),"could not enter Effective Date", selenium, ClassName, MethodName);
				
			    assertTrue(click(selenium, btnCopy),"could not click on copy button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    
			    if(!verifyCopiedDetails(selenium,billingData)){
				    Assert.fail("Copy Failed");
				}
				
				/*assertTrue(click(selenium, btnSaveFeeSchedule),"could not click on save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(!isElementPresent(selenium,btnAddNewFeeSchedule)){
				    returnValue=false;
				}*/
				
				/*if(!verifyFeeScheduelInSummary(selenium,billingData)){
				    Assert.fail("Creation Failed");
				}*/
				
				return true;
			}
			billingData.workSheetName = "FeeSchedule";
			billingData.testCaseId = "TC_FS_004";
			billingData.fetchBillingTestData();
			
			assertTrue(copyFeeSchedule(selenium,billingData),"Creation Failed", selenium, ClassName, MethodName);
			
			if(!verifyCopiedDetails(selenium,billingData)){
			    Assert.fail("Copy Failed");
			}
			
			assertTrue(click(selenium, btnSaveFeeSchedule),"could not click on save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,btnAddNewFeeSchedule)){
			    returnValue=false;
			}
			
			/*if(!verifyFeeScheduelInSummary(selenium,billingData)){
			    Assert.fail("Creation Failed");
			}*/
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyFeeScheduelInSummary(Selenium selenium,BillingLib billingData) throws IOException{
	    	boolean returnValue=true;
	    
	    	if(!getText(selenium,lblFeeScheduleSummary).contains(billingData.payer1)){
		    returnValue=false;
		}
		if(!getText(selenium,lblFeeScheduleSummary).contains(billingData.plan)){
		    returnValue=false;
		}
		if(!getText(selenium,lblFeeScheduleSummary).contains(billingData.provider1)){
		    returnValue=false;
		}
		if(!getText(selenium,lblFeeScheduleSummary).contains(billingData.practice)){
		    returnValue=false;
		}
		if(!getText(selenium,lblFeeScheduleSummary).contains(billingData.speciality)){
		    returnValue=false;
		}
		if(!getText(selenium,lblFeeScheduleSummary).contains(billingData.location)){
		    returnValue=false;
		}
		return returnValue;
	}
	
	public boolean verifyCopiedDetails(Selenium selenium,BillingLib billingData) throws IOException{
	    	boolean returnValue=true;
	    
	    	String increasedAmount=billingData.allowedAmount;
	    	String increasedunit=billingData.allowedUnit;
	    	int increasedAmount1=Integer.parseInt(increasedAmount);
	    	int increasedunit1=Integer.parseInt(increasedunit);
	    	int finalAllowedUnit=increasedAmount1+increasedunit1;
	    	String finalAllowedunit=Integer.toString(finalAllowedUnit);
	    	
	    	if(!getValue(selenium,txtAllowedAmount).contains(finalAllowedunit)){
		    returnValue=false;
		}
		
		return returnValue;
	}
}
