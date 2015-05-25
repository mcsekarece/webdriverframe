package com.nexia.selenium.testscripts.section.systemsettings.passwordrules;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForPasswordRules extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminConsentData = new SystemSettingsLib();
		adminConsentData.workSheetName = "VerifySecurityOption";
		adminConsentData.testCaseId = "TC_VSP_009";
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
			assertTrue(switchRole(selenium,adminConsentData.switchRole1),"Could not change the switch role;More Details:"+adminConsentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				


			//--------------------------------------------------------------------//
			//  Step-3: No access User Role 									  //
			//--------------------------------------------------------------------//
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_017";
			userRoleData.fetchSystemSettingTestData();

			if(userRoleData.securitySettings.contains("No Access")){			
				assertTrue(noAccessUserSecuritySetting(selenium, adminConsentData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
			}			

			//--------------------------------------------------------------------//
			//  Step-4: Full, View User Role 									  //
			//--------------------------------------------------------------------//
			if(!userRoleData.securitySettings.contains("No Access")){				
				assertTrue(fullViewAccessUserSecuritySetting(selenium, adminConsentData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);						
			}

			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			assertTrue(verifySecurity(selenium,adminConsentData,userRoleData), 
					"Security option not show properly; More Details :"+ adminConsentData.toString(), selenium, ClassName, MethodName);


		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib adminConsentData, SystemSettingsLib userRoleData) throws IOException{
		boolean returnValue=true;
		// Limited Access
		if(userRoleData.passwordRules.contains("Limited Access")){
			click(selenium,lnkPasswordRules);
			waitForPageLoad(selenium);
			if(!isElementPresent(selenium,btnPREdit)){
				returnValue = false;
			}else
				return returnValue;
		}

		// View Only Access
		if(userRoleData.passwordRules.contains("View Only")){
			click(selenium,lnkPasswordRules);
			waitForPageLoad(selenium);			
			assertTrue(!getText(selenium,btnPREdit).contains("Edit".trim()), 
					"Found text Edit", selenium, ClassName, MethodName);						
			
		}

		// Full Access
		if(userRoleData.passwordRules.contains("Full Access")){
			click(selenium,lnkPasswordRules);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnPREdit)){
				return returnValue;
			}else
				returnValue = false;
		}

		if(userRoleData.passwordRules.contains("No Access")){
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);

			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSecuritySetting), "Could not click on Clinical settings", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			click(selenium,lnkPasswordRules);
			waitForPageLoad(selenium);

			if(selenium.isTextPresent("Password Rules")){
				returnValue= false;
			}else
				return returnValue;
		}

		return returnValue;
	}
}
