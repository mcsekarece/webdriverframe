package com.nexia.selenium.testscripts.section.smoketest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;

import com.thoughtworks.selenium.Selenium;

public class VerifyQuickActionLink extends AbstractOperationsTest{
	@Test(groups = {"Smoke","Review","firefox", "iexplore", "safari", "default" }, description = "SearchResourceInCalender")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyActionLink(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_005";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLink(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Link for quick action 
	* @action 		  verifying cancel Function  for quick action 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 14, 2013
	***************************************************************************************************/
	
	public boolean verifyLink(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData) throws IOException{
		Selenium selenium = null;
		try {
		
		//--------------------------------------------------------------------//
		// Step-1:Login to the application//
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" +bookingAssistTestData.toString());
		assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, bookingAssistTestData.userName, bookingAssistTestData.userPassword),"Login Failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		// Step-2:Navigate to the Quick action//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkQuickAction),"Could not click the quick action", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium,lnkOperations)&& isElementPresent(selenium,lnkWaitListMgmt)){
			return true;
		}else
			return false;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName, MethodName);
		}
		return true;
	}
}
