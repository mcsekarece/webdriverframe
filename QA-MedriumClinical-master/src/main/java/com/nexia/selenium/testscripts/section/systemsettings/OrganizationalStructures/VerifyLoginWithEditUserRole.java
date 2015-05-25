package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;


import static com.sharedlibrary.ThreadSafeSeleniumSessionStorage.session;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLoginWithEditUserRole extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Login with Editing user")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void loginWithEditUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib editUserData = new SystemSettingsLib();
		editUserData.workSheetName = "LoginWithUpdateUser";
		editUserData.testCaseId = "TC_FUU_001";
		editUserData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLoginWithEditUser(seleniumHost, seleniumPort, browser, webSite, userAccount, editUserData);
	}
	/**
	 * verifyLoginWithEditUser
	 * function to verify Login With Edit User
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 
	 * 		webSite
	 * @throws IOException 
	 
	 * @since  	    Aug 30, 2012
	 */
	public boolean verifyLoginWithEditUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib editUserData) throws IOException{
		Selenium selenium=null;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + editUserData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, editUserData.userName, editUserData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,editUserData.switchRole), "Switch role failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to User //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3: search User //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium, txtProFirstName))
				assertTrue(type(selenium,txtProFirstName,editUserData.userName1),"Could not type user name on search field" + editUserData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnUserSearch),"Could not click on search button:" + editUserData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isElementPresent(selenium,"DeleteUserORANGE")){
				assertTrue(click(selenium,chkIncludeInactiveUserscheckbox),"Could not click on include Inactive Users checkbox:" + editUserData .toString(), selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,btnActivateORANGE),"Could not find the user", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnActivateORANGE),"Could not click on activate button:" + editUserData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,txtdescription),"Could not click on user link:" + editUserData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else{
				assertTrue(click(selenium,txtdescription),"Could not click on user link:" + editUserData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				}

			//--------------------------------------------------------------------//
			//  Step-4:Updated role//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit1),"Could not click on edit button:" + editUserData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(getValue(selenium,ajxUserRolesuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(editUserData.userRole.trim().toLowerCase(new java.util.Locale("en","US")))){
				selectValueFromAjaxList(selenium,ajxUserRolesuggestBox,editUserData.userRole1);
			}
			else selectValueFromAjaxList(selenium,ajxUserRolesuggestBox,editUserData.userRole);
			assertTrue(click(selenium,btnSave),"Could not click on save button:" + editUserData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5:Logout and login as the created us//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose))
					Assert.assertTrue(click(selenium, btnErrorClose));
			assertTrue(click(selenium,lnkTopMenuHeader),"Could not click on the link" + editUserData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignOutAction),"Could not click on System settings link:" + editUserData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(session(),btnYes);
			waitForPageLoad(selenium);
			click(selenium,"Yes");
			waitForPageLoad(selenium);
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, editUserData.userName1, editUserData.password1),"Login Failed ", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}
}
