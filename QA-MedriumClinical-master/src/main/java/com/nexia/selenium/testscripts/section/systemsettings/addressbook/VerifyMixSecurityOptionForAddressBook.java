package com.nexia.selenium.testscripts.section.systemsettings.addressbook;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForAddressBook extends AbstractSystemSettingsTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminAddrData = new SystemSettingsLib();
		adminAddrData.workSheetName = "VerifySecurityOption";
		adminAddrData.testCaseId = "TC_VSP_007";
		adminAddrData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adminAddrData);
	}

	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 05, 2012
	 */

	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib adminAddrData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminAddrData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, adminAddrData.userName, adminAddrData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,adminAddrData.switchRole),"Could not change the switch role;More Details:"+adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//

			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_028";
			userRoleData.fetchSystemSettingTestData();			

			if(userRoleData.addressBook.contains("No Access")){				
				assertTrue(noAccessMixSecuritySystemSetting(selenium, adminAddrData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isVisible(lnkAddressBook),"Address Book is present",selenium, ClassName, MethodName);
			}			

			//--------------------------------------------------------------------//
			//  Step-4: Full, View Access User Role 									  //
			//--------------------------------------------------------------------//
			if(!userRoleData.addressBook.contains("No Access")){
				assertTrue(fullViewAccessUserSystemSetting(selenium, adminAddrData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;			

			}			

			//--------------------------------------------------------------------//
			//  Step-3: Verify security option //
			//--------------------------------------------------------------------//
			assertTrue(verifySecurity(selenium,adminAddrData, userRoleData, userAccount), "Security option not show properly; More Details :"+ adminAddrData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	public boolean verifySecurity(Selenium selenium,SystemSettingsLib adminAddrData,SystemSettingsLib userRoleData, String userAccount) throws IOException{
		boolean returnValue=true;

		//Limited Access
		if(userRoleData.addressBook.contains("Limited Access")){
			adminAddrData.workSheetName = "CreateAddressBook";
			adminAddrData.testCaseId = "TC_CAB_001";
			adminAddrData.fetchSystemSettingTestData();
			click(selenium,lnkAddressBook);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddressBookEntry),"Could not click the button", selenium, ClassName, MethodName);
			assertTrue(createAddressBook(selenium,adminAddrData, userAccount),"Creation failed", selenium, ClassName, MethodName);
			if(isElementPresent(selenium,btnDelete )){
				returnValue= false;
			}else
				return returnValue;
		}

		// View Only Access
		if(userRoleData.addressBook.contains("View Only")){
			click(selenium,lnkAddressBook);
			waitForPageLoad(selenium);
			//if(isElementPresent(selenium,"addNewAddressBookEntry")||isElementPresent(selenium, "//div[2]/div/div/div/span/button")){
			if(getText(selenium,btnAddressBookEntry).toLowerCase(new java.util.Locale("en","US")).trim().contains("Add New".trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue= false;
			} 
			else
				return returnValue;
		}

		// Full Access
		if(userRoleData.addressBook.contains("Full Access")){
			adminAddrData.workSheetName = "CreateAddressBook";
			adminAddrData.testCaseId = "TC_CAB_001";
			adminAddrData.fetchSystemSettingTestData();

			click(selenium,lnkAddressBook);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAddressBook(selenium),"Deletion Failed", selenium, ClassName, MethodName);

			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddressBookEntry),"Could not click the button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(createAddressBook(selenium,adminAddrData, userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnDelete ),"Not found Delete button" , selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}
}