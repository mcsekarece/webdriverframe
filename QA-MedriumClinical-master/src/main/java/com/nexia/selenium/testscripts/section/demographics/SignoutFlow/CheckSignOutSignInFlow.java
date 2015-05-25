package com.nexia.selenium.testscripts.section.demographics.SignoutFlow;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class CheckSignOutSignInFlow extends AbstractHomeTest{
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Signout Flow")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void checkSignOutSignInFlow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib mySettingsData = new HomeLib();
		mySettingsData.workSheetName = "MySettings";
		mySettingsData.testCaseId = "TC_NMS_002";
		mySettingsData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		checkSignoutFlow(seleniumHost, seleniumPort, browser, webSite, userAccount, mySettingsData);
	}
 
	/*************************************************************************************************** 
	* @purpose        To verify Signout Flow
	* @action 		  verifying Signout Flow
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 27, 2012
	***************************************************************************************************/
	public boolean checkSignoutFlow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib mySettingsData) throws Exception{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mySettingsData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, mySettingsData.userName, mySettingsData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,lnkSecuritySetting),"Could not click system settings link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAudit),"Could not click system settings link",selenium,ClassName,MethodName);
			assertTrue(isElementPresent(selenium,btnSearchHouseHold), "Could not move to audit log page",selenium,ClassName,MethodName);
			assertTrue(click(selenium,lnkTopMenu),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignout),"Could not click the log out button",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnYesButton),"Could not click yes button;More Details"+mySettingsData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, mySettingsData.userName1, mySettingsData.newPassword),"Login Failed while using the password which has been reset",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkSecuritySetting))
				return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
}
