package com.nexia.selenium.testscripts.section.systemsettings.userroles;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForUserRoles extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "VerifySecurityOption";
		mandData.testCaseId = "TC_VSP_001";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "VerifySecurityOption";
		mandData.testCaseId = "TC_VSP_002";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "VerifySecurityOption";
		mandData.testCaseId = "TC_VSP_003";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "VerifySecurityOption";
		userRoleData.testCaseId = "TC_VSP_004";
		userRoleData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 07, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib userRoleData) throws IOException{
		Selenium selenium=null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + userRoleData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, userRoleData.userName, userRoleData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,userRoleData.switchRole),"Could not change the switch role;More Details:"+userRoleData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//
			
			if(userRoleData.testCaseId.equals("TC_VSP_003")){				
			assertTrue(noAccessUserSecuritySetting(selenium, userRoleData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);				
				
			}
						
			
			//--------------------------------------------------------------------//
			//  Step-4: Full, View Access User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.testCaseId.equals("TC_VSP_003")){
			assertTrue(fullViewAccessUserSecuritySetting(selenium, userRoleData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;				
			
			}	
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//			
			assertTrue(verifySecurity(selenium,userRoleData), 
					"Security option not show properly; More Details :"+ userRoleData.toString(), selenium, ClassName, MethodName);						
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	//A Limited Access
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib userRoleData) throws IOException{
		
		boolean returnValue=true;
		
		if(userRoleData.testCaseId.equals("TC_VSP_001")){
			userRoleData.workSheetName = "CreateUserRole";
			userRoleData.testCaseId = "TC_UU_001";
			userRoleData.fetchSystemSettingTestData();
			
			click(selenium,lnkUserRole);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnDelete)){
				returnValue=false;
			}else
				return returnValue;
		}
		//View Only Access
		if(userRoleData.testCaseId.equals("TC_VSP_002")){
			click(selenium,lnkUserRole);
			waitForPageLoad(selenium);
			
			assertTrue(!getText(selenium,btnAddIdentifierType).contains("Add New".trim()), 
					"Not able to find text Add New", selenium, ClassName, MethodName);						
			
			
			if(isElementPresent(selenium,btnDelete)){
				returnValue=false;
			}else
				return returnValue;
			
			if(isElementPresent(selenium,btnEdit)){
				returnValue=false;
			}else
				return returnValue;
		}
		
		//Full Access
		if(userRoleData.testCaseId.equals("TC_VSP_004")){
			click(selenium,lnkUserRole);
			waitForPageLoad(selenium);

			if(isElementPresent(selenium,btnAddIdentifierType)){
				return returnValue;
			}else
				returnValue=false;
			
			if(isElementPresent(selenium,btnDelete)){
				return returnValue;
			}else
				returnValue=false;
			
			if(isElementPresent(selenium,btnEdit)){
				return returnValue;
			}else
				returnValue=false;
		
	}
		return returnValue;
}
}
