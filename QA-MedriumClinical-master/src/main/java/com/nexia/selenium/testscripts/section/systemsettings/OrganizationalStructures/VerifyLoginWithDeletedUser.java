package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import static com.sharedlibrary.ThreadSafeSeleniumSessionStorage.session;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLoginWithDeletedUser extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Logging in with a created user")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void loginWithCreatedNewUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_008";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		loginWithCreatedNewUsers(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	/**
	 * loginWithCreatedNewUsers
	 * function to login With Created New Users
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	     June 05, 2010
	*/
	public boolean loginWithCreatedNewUsers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pracData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pracData.userName, pracData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pracData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to User //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			pracData.workSheetName = "UserData";
			pracData.testCaseId = "TC_NU_010";
			pracData.fetchSystemSettingTestData();
			
			assertTrue(type(selenium,txtProFirstName,pracData.userName1),"Could not type the last name", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnUserSearch),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!getText(selenium,txtUserName1).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.userName1.trim().toLowerCase(new java.util.Locale("en","US")))){
				if(!getText(selenium,txtLastName1).equals(pracData.lastName)){
					
					if(isElementPresent(selenium,chkIncludeInactiveUserscheckbox)){
						click(selenium,chkIncludeInactiveUserscheckbox);
						waitForPageLoad(selenium);
						if(getText(selenium,txtLastName1).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
							if(isElementPresent(selenium,"//a[contains(text(),'Activate')]")){
							System.out.print("User is in inactive status");
							}
						}
						else{
							return false;
						}
					}
				}

			}
			else
			{
				assertTrue(click(selenium,btnDeleteUser),"Could not delete user", selenium, ClassName, MethodName);
				click(selenium,btnYes);
				waitForPageLoad(selenium);
			}
		
			assertTrue(click(selenium,btnBack),"Could not go to home page" + pracData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkTopMenuHeader),"Could not click on the link" + pracData .toString(), selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignOutAction),"Could not click on System settings link:" + pracData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(session(),lnkBtnYes);
			waitForPageLoad(selenium);
			
			  if(!waitForElement(selenium, lnkLoginAccountText, WAIT_TIME*4)){
		        	Assert.fail("Login Page Not loaded More Details; UserAccount :- "+userAccount +"  UserName :- " +pracData.userName1+ " UserPassword :- "+ pracData.password);
		        }
		        type(selenium, lnkLoginAccountText, userAccount);
		        type(selenium, lnkLoginUseridText,  pracData.userName1);
		        type(selenium, lnkLoginPasswordText, pracData.password);
		        click(selenium,btnLogin);
		        waitForPageLoad(selenium);
			
		    if(getText(selenium,lblMessage).contains("Your authentication failed. Please contact your system administrator.")){
					return returnValue;
			}
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
		}
		
		return returnValue;
	}

}

