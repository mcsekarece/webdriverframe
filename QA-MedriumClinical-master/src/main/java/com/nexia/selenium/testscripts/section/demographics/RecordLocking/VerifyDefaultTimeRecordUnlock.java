package com.nexia.selenium.testscripts.section.demographics.RecordLocking;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultTimeRecordUnlock extends AbstractHomeTest  {
	
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for VerifyDefaultTimeRecordUnlock")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultTimeRecordUnlock(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib casesData = new HomeLib();
		casesData.workSheetName = "NewCases";
		casesData.testCaseId = "TC_NC_014";
		casesData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    verifyDefaultTime(seleniumHost, seleniumPort, browser, webSite, userAccount, casesData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Record Locking unlock
	* @action 		  Verifying Record Locking unlock
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 18, 2013
	***************************************************************************************************/
	
	public boolean verifyDefaultTime(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib noteData) throws Exception{
		Selenium selenium = null;
			
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + noteData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, noteData.userName, noteData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Go to Manage Records //
			//--------------------------------------------------------------------//
	        assertTrue(click(selenium,lnkQuickAction),"Could not click on quick action",selenium, ClassName, MethodName);
            waitForPageLoad(selenium);
            assertTrue(click(selenium,lnkSecuritysetting),"Could not click on security settings",selenium, ClassName, MethodName);
            waitForPageLoad(selenium);
            assertTrue(click(selenium,lnkRecordLocking),"Could not click on Record Locking link",selenium, ClassName, MethodName);
            waitForPageLoad(selenium);
            
        	//--------------------------------------------------------------------//
			//  Step-3: Verify the Default Time //
			//--------------------------------------------------------------------//
                       
            assertTrue(click(selenium,btnEdit1),"Could not click on Edit",selenium, ClassName, MethodName);
            waitForPageLoad(selenium);
                        
            assertTrue(!getText(selenium,txtRTime).contains(" "),"Verificaton failed", selenium, ClassName, MethodName);
            assertTrue(!getText(selenium,ajxTimeUnit).contains(" "),"Verification failed", selenium, ClassName, MethodName);
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		
		}
		return true;
    
	}
}
