package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForUsers extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding an User")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForUsers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "CreateUser";
		userData.testCaseId = "TC_CU_001";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingOrderForUsers(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	
	/**
	 * verifyTabbingOrderForUsers
	 * function to verifyTabbingOrderForUsers
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
	public void verifyTabbingOrderForUsers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib userData) throws Exception{
		Selenium selenium=null;
		String csspaths[]={tabLastName,tabFirstName,tabUserName,tabCredentials,tabExternalEmrsuggestBox,tabPassword,tabConfirmPassword,tabStartDate,tabEndDate,tabRoleSuggestBox1suggestBox,tabPracticeSuggestBox1,tabAddCptButton1};
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + userData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, userData.userName, userData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,userData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to User //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			assertTrue(click(selenium,btnadduser),"Could not find add practice button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// Step-3:Tab order													 // 
			//--------------------------------------------------------------------//
			for(int i =0;i<csspaths.length;i++){
			assertTrue(isElementPresent(selenium,csspaths[i]),"Not found", selenium, ClassName, MethodName);
			selenium.focus(csspaths[i]);
			waitForElementToEnable(selenium,csspaths[i]);
			selenium.keyPress(csspaths[i], "\\9");
			Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
			}
			
			assertTrue(click(selenium,btnAddRole),"Could not find add roles button", selenium, ClassName, MethodName);
			String csspaths1[]={tabRoleSuggestBox2suggestBox,tabPracticeSuggestBox2,tabAddCptButton2};
			for(int i =0;i<csspaths1.length;i++){
				assertTrue(isElementPresent(selenium,csspaths[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspaths1[i]);
				waitForElementToEnable(selenium,csspaths[i]);
				selenium.keyPress(csspaths1[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths1[i]));
				}
					
			}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}


