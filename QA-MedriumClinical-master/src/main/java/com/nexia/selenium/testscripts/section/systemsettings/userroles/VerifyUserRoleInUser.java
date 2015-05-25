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

public class VerifyUserRoleInUser extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUserRole(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "CreateUserRole";
		userRoleData.testCaseId = "TC_UU_001";
		userRoleData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyUserRoleInUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	/**
	 * verifyUserRoleInUser
	 * function to verify User Role In User
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	    Aug 30, 2012
	 */
	public boolean verifyUserRoleInUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib userRoleData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrieve the New Selenium Session; More Details :" + userRoleData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, userRoleData.userName, userRoleData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,userRoleData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to Security Settings and navigate to User Rules//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickLink), "Could not click Quick Actions link", selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSecuritySettings1),"Could not click on Security settings link:" + userRoleData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkUserRole),"Could noy click the User Role link:"+userRoleData.toString(), selenium, ClassName, MethodName);
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
				}else
					count++;
			}
			//--------------------------------------------------------------------//
			//  Step-4:Create User role //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddIdentifierType),"Could not click the add button;More details:"+userRoleData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createUserRole(selenium,userRoleData,uniqueName),"creation User role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5:Navigate to System setting and go to User //
			//--------------------------------------------------------------------//
			click(selenium,"back");
			waitForPageLoad(selenium);
			userRoleData.workSheetName = "CreateUser";
			userRoleData.testCaseId = "TC_CU_004";
			userRoleData.fetchSystemSettingTestData();
			
			assertTrue(click(selenium, lnkQuickLink), "Could not click Quick Actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click on System settings link:" + userRoleData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnadduser),"Could not click on add a user link:" + userRoleData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5:Verify Create User role in user //
			//--------------------------------------------------------------------//
			if(selectValueFromAjaxList(selenium,ajxUserRolesuggestBox,userRoleData.userRole+uniqueName)){
				return returnValue;
			}else
				returnValue=false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
