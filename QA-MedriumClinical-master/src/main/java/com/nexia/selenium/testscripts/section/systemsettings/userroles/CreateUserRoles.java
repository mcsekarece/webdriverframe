package com.nexia.selenium.testscripts.section.systemsettings.userroles;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreateUserRoles extends AbstractSystemSettingsTest{
	@Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "CreateUserRole";
		userRoleData.testCaseId = "TC_UU_001";
		userRoleData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}

	/**
	 * createUserRole
	 * function to Create User Role 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 16, 2012
	 */
	public boolean createUserRoles (String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib userRoleData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		int counter = 0;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrieve the New Selenium Session; More Details :" + userRoleData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, userRoleData.userName, userRoleData.userPassword),"Login Failed", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,userRoleData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to Security Settings and navigate to User Rules//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkSettings), "Could not click Quick Actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSecuritySetting),"Could not click on Security settings link:" + userRoleData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkUserRole),"Could not click the User Role link:"+userRoleData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			while(getText(selenium, lnkUserRoleMore).contains("Show more...")){
				click(selenium,lnkUserRoleMore);
				waitForPageLoad(selenium);
			}

			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Delete select User role //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			int count=1;

			while(isElementPresent(selenium,"xpath=(//div[starts-with(@id,'collapsableTitle')])["+count+"]")){
				if(getText(selenium,"xpath=(//div[starts-with(@id,'collapsableTitle')])["+count+"]").contains(userRoleData.userRole)){
					waitForPageLoad(selenium);
					click(selenium,"xpath=(//a[starts-with(@id,'Delete')])["+count+"]");
					waitForPageLoad(selenium);
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					while(getText(selenium, lnkUserRoleMore).contains("Show more...")){
						click(selenium,lnkUserRoleMore);
						waitForPageLoad(selenium);
					}
				}else
					count++;
			}

			//--------------------------------------------------------------------//
			//  Step-4:Create User role //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(click(selenium, btnAddIdentifierType),"Could not click Add new button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createUserRole(selenium,userRoleData,uniqueName),"User role creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			while(getText(selenium, lnkUserRoleMore).contains("Show more...")){
				click(selenium,lnkUserRoleMore);
				waitForPageLoad(selenium);
			}
			count=1;
			while(isElementPresent(selenium,"xpath=(//div[starts-with(@id,'collapsableTitle')])["+count+"]")){
				if(getText(selenium,"xpath=(//div[starts-with(@id,'collapsableTitle')])["+count+"]").contains(userRoleData.userRole+uniqueName)){
					counter = count;
					break;
				}else
					count++;
			}
			//--------------------------------------------------------------------//
			//  Step-5:Verify Stored vlues in Summary Page Of User Role           // 
			//--------------------------------------------------------------------//
			if(!verifySummaryValue(selenium,userRoleData , counter , uniqueName)){
				Assert.fail("User Role details not saved properly :"+ userRoleData.toString());
				returnValue=false;
			}else
				returnValue = true;
			//Click Edit of Created User Role
			assertTrue(click(selenium, "xpath=(//a[starts-with(@id,'Edit')])["+counter+"]"),"Could not click edit button of created User Role", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-5:Verify values in Edit Page Of User Role           // 
			//--------------------------------------------------------------------//
			if(!verifyStoreValue(selenium,userRoleData , counter , uniqueName)){
				Assert.fail("User Role details not displayed Properly while Edit :"+ userRoleData.toString());
				returnValue=false;
			}else
				returnValue = true;
			assertTrue(click(selenium, btnCancel), "Could not click cancel button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lnkUserRoleMore)){
				click(selenium,lnkUserRoleMore);
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium, "xpath=(//a[starts-with(@id,'Delete')])["+counter+"]"), "Could not delete the created User role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			waitForPageLoad(selenium);
			return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	public boolean verifySummaryValue(Selenium selenium,SystemSettingsLib userRoleData , int counter , String uniqueName){
		waitForPageLoad(selenium);
		if(!getText(selenium,"xpath=(//div[starts-with(@id,'collapsableTitle')])["+counter+"]").trim().contains(userRoleData.userRole+uniqueName.trim())){
			return false;
		}
		if(!getText(selenium,"xpath=(//div[starts-with(@id,'collapsableTitle')])["+counter+"]").trim().contains(userRoleData.description.trim())){
			return false;
		}
		return true;
	}

	public boolean verifyStoreValue(Selenium selenium,SystemSettingsLib userRoleData , int counter , String uniqueName){
		waitForPageLoad(selenium);
		if(!getValue(selenium,txtUserRoleMore).trim().contains(userRoleData.userRole+uniqueName.trim())){
			return false;
		}
		if(!getValue(selenium,txtdescription).trim().contains(userRoleData.description.trim())){
			return false;
		}
		if(!getValue(selenium,ajxHomePageView).trim().contains(userRoleData.homePage.trim())){
			return false;
		}
		if(userRoleData.limitedAccess.equalsIgnoreCase("Yes")){
			if(!getValue(selenium, chkLimitedAccess).equalsIgnoreCase("on"))
				return false;
		}
		return true;
	}
}