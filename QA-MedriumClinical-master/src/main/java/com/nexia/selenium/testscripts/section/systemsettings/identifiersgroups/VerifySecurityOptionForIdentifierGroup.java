package com.nexia.selenium.testscripts.section.systemsettings.identifiersgroups;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForIdentifierGroup extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib idGroupData = new SystemSettingsLib();
		idGroupData.workSheetName = "VerifySecurityOption";
		idGroupData.testCaseId = "TC_VSP_001";
		idGroupData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, idGroupData);
	} 

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib idGroupData = new SystemSettingsLib();
		idGroupData.workSheetName = "VerifySecurityOption";
		idGroupData.testCaseId = "TC_VSP_002";
		idGroupData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, idGroupData);
	} 
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib idGroupData = new SystemSettingsLib();
		idGroupData.workSheetName = "VerifySecurityOption";
		idGroupData.testCaseId = "TC_VSP_003";
		idGroupData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, idGroupData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib idGroupData = new SystemSettingsLib();
		idGroupData.workSheetName = "VerifySecurityOption";
		idGroupData.testCaseId = "TC_VSP_004";
		idGroupData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, idGroupData);
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
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib idGroupData) throws IOException{
		Selenium selenium=null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + idGroupData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, idGroupData.userName, idGroupData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,idGroupData.switchRole),"Could not change the switch role;More Details:"+idGroupData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//
						
			if(idGroupData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(noAccessUserSystemSetting(selenium, idGroupData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
				
			}		

			//--------------------------------------------------------------------//
			//  Step-4: Full and View Only User Role 							  //
			//--------------------------------------------------------------------//
			
			if(!idGroupData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(fullViewAccessUserSystemSetting(selenium, idGroupData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);
				
			}
											
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,idGroupData)){
				Assert.fail("Security option not show properly; More Details :"+ idGroupData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib idGroupData) throws IOException{
		boolean returnValue=true;
		
		// Limited Access
		if(idGroupData.testCaseId.equals("TC_VSP_001")){
			idGroupData.workSheetName = "CreateIdentifierGroups";
			idGroupData.testCaseId = "TC_IDG_001";
			idGroupData.fetchSystemSettingTestData();

			click(selenium,lnkIdentifierGroup);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click the button", selenium, ClassName, MethodName);
			assertTrue(createIdGroup(selenium,idGroupData),"Creation failed", selenium, ClassName, MethodName);
			if(isElementPresent(selenium,btnDelete)){
				returnValue= false;
			}else
				return returnValue;
		}
		
		// View Only Access
		if(idGroupData.testCaseId.equals("TC_VSP_002")){
			click(selenium,lnkIdentifierGroup);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEditId)){
				waitForPageLoad(selenium);
				returnValue= false;
			}else
				return returnValue;
		}
		
		// Full Access
		if(idGroupData.testCaseId.equals("TC_VSP_004")){
			idGroupData.workSheetName = "CreateIdentifierGroups";
			idGroupData.testCaseId = "TC_IDG_001";
			idGroupData.fetchSystemSettingTestData();
			click(selenium,lnkIdentifierGroup);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllIdentifiersGroup(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click the button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createIdGroup(selenium,idGroupData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnDelete)){
				return returnValue;
			}else
				returnValue= false;
		}
		return returnValue;
	}

}
