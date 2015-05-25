package com.nexia.selenium.testscripts.section.systemsettings.directories;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForDirectories extends AbstractSystemSettingsTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib dirData = new SystemSettingsLib();
		dirData.workSheetName = "VerifySecurityOption";
		dirData.testCaseId = "TC_VSP_004";
		dirData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOptionForLimitedAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, dirData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib dirData = new SystemSettingsLib();
		dirData.workSheetName = "VerifySecurityOption";
		dirData.testCaseId = "TC_VSP_002";
		dirData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, dirData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib dirData = new SystemSettingsLib();
		dirData.workSheetName = "VerifySecurityOption";
		dirData.testCaseId = "TC_VSP_003";
		dirData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, dirData);
	} 
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib dirData = new SystemSettingsLib();
		dirData.workSheetName = "VerifySecurityOption";
		dirData.testCaseId = "TC_VSP_004";
		dirData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, dirData);
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Feb 19,2013
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib dirData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + dirData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, dirData.userName, dirData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			
			assertTrue(switchRole(selenium,dirData.switchRole),"Could not change the switch role;More Details:"+dirData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role  									  //
			//--------------------------------------------------------------------//
						
			if(dirData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(noAccessUserSystemSetting(selenium, dirData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Full Access and View Only User Role  									  //
			//--------------------------------------------------------------------//
			
			if(!dirData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(fullViewAccessUserSystemSetting(selenium, dirData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);	
				
			}
						
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			assertTrue(verifySecurity(selenium,dirData, userAccount), 
					"Security option not show properly; More Details :"+ dirData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib dirData, String userAccount ) throws IOException{
		boolean returnValue=true;

		if(dirData.testCaseId.equals("TC_VSP_002")){

			 
			assertTrue( click(selenium,lnkDirectories),"could not click on directories link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxDirectoryType,"Pharmacies");
			
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isTextPresent("Delete"),"Delete Button is Visible", selenium, ClassName, MethodName);
			assertTrue(!selenium.isVisible(btnAddNew),"Add New is Visible", selenium, ClassName, MethodName);
			
			/*if(selenium.isVisible(btnDelete) || selenium.isVisible(btnAddNew)){
				returnValue=false;
			}else
				return returnValue;*/
			
		 
		}
		
	
		
		if(dirData.testCaseId.equals("TC_VSP_004")){
			dirData.workSheetName = "CreateDirectories";
			dirData.testCaseId = "TC_CDIR_001";
			dirData.fetchSystemSettingTestData();
			click(selenium,lnkDirectories);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxDirectoryType,"Pharmacies");
			waitForPageLoad(selenium);
			assertTrue(deleteDirectories(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNew),"Could not click the button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createDirectories(selenium,dirData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnDelete)){
				return returnValue;
			}else
				returnValue=false;
		}
		return returnValue;
	}
	
	public boolean verifySecurityOptionForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib dirData) throws IOException{
		Selenium selenium=null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + dirData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, dirData.userName, dirData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,dirData.switchRole),"Could not change the switch role;More Details:"+dirData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"Could not click Close button",selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkQuickLink),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"Could not click Close button",selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkSystemSettingsAction ),"Could not click the systemSettings link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Create Mandatory Field									  //
			//--------------------------------------------------------------------//
			
			dirData.workSheetName = "CreateDirectories";
			dirData.testCaseId = "TC_CDIR_001";
			dirData.fetchSystemSettingTestData();
			click(selenium,lnkDirectories);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxDirectoryType,"Pharmacies");
			waitForPageLoad(selenium);
			assertTrue(deleteDirectories(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNew),"Could not click the button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createDirectories(selenium,dirData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Switch to LimitedAccess Role
			SystemSettingsLib dirData1 = new SystemSettingsLib();
			dirData1.workSheetName = "VerifySecurityOption";
			dirData1.testCaseId = "TC_VSP_001";
			dirData1.fetchSystemSettingTestData();
			waitForPageLoad(selenium);
			assertTrue(switchroleSecondTime(selenium,dirData),"Could not change the switch role;More Details:"+dirData1.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"Could not click Close button",selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,	lnkQuickLink),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"Could not click Close button",selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkSystemSettingsAction ),"Could not click the systemSettings link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkDirectories);
			waitForPageLoad(selenium);
			
			// check for the absence of Delete Button
			if(isElementPresent(selenium,btnDelete)){
				return false;
			}else
				return true;		
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
}