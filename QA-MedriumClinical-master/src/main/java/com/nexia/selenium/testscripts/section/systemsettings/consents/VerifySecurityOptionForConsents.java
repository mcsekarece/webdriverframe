package com.nexia.selenium.testscripts.section.systemsettings.consents;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForConsents extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminConsentData = new SystemSettingsLib();
		adminConsentData.workSheetName = "VerifySecurityOption";
		adminConsentData.testCaseId = "TC_VSP_001";
		adminConsentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adminConsentData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminConsentData = new SystemSettingsLib();
		adminConsentData.workSheetName = "VerifySecurityOption";
		adminConsentData.testCaseId = "TC_VSP_002";
		adminConsentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adminConsentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminConsentData = new SystemSettingsLib();
		adminConsentData.workSheetName = "VerifySecurityOption";
		adminConsentData.testCaseId = "TC_VSP_003";
		adminConsentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adminConsentData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminConsentData = new SystemSettingsLib();
		adminConsentData.workSheetName = "VerifySecurityOption";
		adminConsentData.testCaseId = "TC_VSP_004";
		adminConsentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adminConsentData);
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
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib adminConsentData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminConsentData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, adminConsentData.userName, adminConsentData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,adminConsentData.switchRole),"Could not change the switch role;More Details:"+adminConsentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
		
			//--------------------------------------------------------------------//
			//  Step-3: No access User Role 									  //
			//--------------------------------------------------------------------//			
			if(adminConsentData.testCaseId.equals("TC_VSP_003")){
				assertTrue(noAccessUserSecuritySetting(selenium, adminConsentData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
			}			
		
			//--------------------------------------------------------------------//
			//  Step-4: Full, View User Role 									  //
			//--------------------------------------------------------------------//			
			if(!adminConsentData.testCaseId.equals("TC_VSP_003")){
				assertTrue(fullViewAccessUserSecuritySetting(selenium, adminConsentData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);						
			}
						
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			assertTrue(verifySecurity(selenium,adminConsentData),"Security option not show properly; More Details :"+ adminConsentData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib adminConsentData) throws IOException{
		boolean returnValue=true;
		if(adminConsentData.testCaseId.equals("TC_VSP_001")){
			adminConsentData.workSheetName = "AdminNewConsent";
			adminConsentData.testCaseId = "TT_ANC_001";
			adminConsentData.fetchSystemSettingTestData();
			click(selenium,lnkconsentList);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnConsent),"Could not click the button", selenium, ClassName, MethodName);
			assertTrue(createConsents(selenium,adminConsentData),"Creation failed", selenium, ClassName, MethodName);
			if(isElementPresent(selenium, btnDelete)){
				returnValue= false;
			}else
				return returnValue;
		}
		if(adminConsentData.testCaseId.equals("TC_VSP_002")){
			click(selenium,lnkconsentList);
			waitForPageLoad(selenium);
			//if(isElementPresent(selenium,"addConsentType")){
			if(getText(selenium,btnConsent).toLowerCase(new java.util.Locale("en","US")).trim().contains("Add New".trim().toLowerCase(new java.util.Locale("en","US")))){
				returnValue= false;
			}else
				return returnValue;
		}
		
		if(adminConsentData.testCaseId.equals("TC_VSP_004")){
			adminConsentData.workSheetName = "AdminNewConsent";
			adminConsentData.testCaseId = "TT_ANC_001";
			adminConsentData.fetchSystemSettingTestData();
			click(selenium,lnkconsentList);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnConsent),"Could not click the button", selenium, ClassName, MethodName);
			assertTrue(createConsents(selenium,adminConsentData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(click(selenium," Activate349"),"Could not click the button");
			//waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnConsent)){
			return returnValue;
			}else
				returnValue=false;
			}
		
		return returnValue;
	}

	

}
