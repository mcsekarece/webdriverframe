package com.nexia.selenium.testscripts.section.billing.statement_batch_review;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPrintInStatementBatch extends AbstractBilling {
    	
    @Test(groups = {"RegressionUS","Developing","firefox", "iexplore", "safari", "default" }, description = "Verify Print in statement batch review")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrintInStatementBatch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "BatchStatements";
		billingData.testCaseId = "TC_BS_001";
		billingData.fetchBillingTestData();
		verifyPrintInStatementBatch(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}

    /*************************************************************************************************** 
	* @purpose        Verify Print in statement batch review
	* @action 		  verifying Print in statement batch review
	* @Specification  SRS_BLG_Statements_BatchReview_Rev0.0
	* @author         Aspire QA
	* @throws         IOException 
    * @throws 		  AWTException 
    * @throws 		  InterruptedException 
	* @state          Developing
	* @useraccount    US
	* @since  	      Feb 18, 2014	
	***************************************************************************************************/
	public boolean verifyPrintInStatementBatch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException, AWTException, InterruptedException{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to statement batch queue						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkUnprintedStatements), "Could not click unprint statement in the queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			//--------------------------------------------------------------------//
			//  Step-3: Verify Print in statement batch review					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnPrintSendUnprintStatement), "Could not click print/send button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,chkFirstItemInUnprintStatement),"Could not check the first item in the print statement", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnPrintUnprintStatement),"Could not click the print button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Robot robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			
			if(!isElementPresent(selenium, lnkClosePreview)){
				 return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

