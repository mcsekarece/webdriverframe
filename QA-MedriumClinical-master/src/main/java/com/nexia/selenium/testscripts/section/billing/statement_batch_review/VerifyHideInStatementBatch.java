package com.nexia.selenium.testscripts.section.billing.statement_batch_review;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyHideInStatementBatch extends AbstractBilling {
    	
    @Test(groups = {"RegressionUS","Developing","firefox", "iexplore", "safari", "default" }, description = "Verify Hide in statement batch review")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHideInStatementBatch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "BatchStatements";
		billingData.testCaseId = "TC_BS_001";
		billingData.fetchBillingTestData();
		verifyHideInStatementBatch(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}

    /*************************************************************************************************** 
	* @purpose        Verify Hide in statement batch review
	* @action 		  verifying Hide in statement batch review
	* @Specification  SRS_BLG_Statements_BatchReview_Rev0.0
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US
	* @since  	      Feb 18, 2014	
	***************************************************************************************************/
	public boolean verifyHideInStatementBatch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
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
			//  Step-3: Verify Hide in statement batch review					  //
			//--------------------------------------------------------------------//
			if(!isElementPresent(selenium, txtFromDateUnprintStatement)){
				Assert.fail("Hide functionality is not in statement batch review");
			}
			
			assertTrue(click(selenium, lnkSuperBillHide), "Could not click hide button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(selenium.isTextPresent("Hide")){
				Assert.fail("Hide functionality is not in statement batch review");
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

