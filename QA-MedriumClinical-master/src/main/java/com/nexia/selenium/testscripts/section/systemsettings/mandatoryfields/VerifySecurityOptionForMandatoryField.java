package com.nexia.selenium.testscripts.section.systemsettings.mandatoryfields;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForMandatoryField extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "VerifySecurityOption";
		mandData.testCaseId = "TC_VSP_004";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOptionWithLimitedAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
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
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "VerifySecurityOption";
		mandData.testCaseId = "TC_VSP_004";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);		
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
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib mandData) throws IOException{
		Selenium selenium=null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mandData.toString());
			//assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, mandData.userName, mandData.userPassword),"Login Failed ");
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, mandData.userName, mandData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			
			assertTrue(switchRole(selenium,mandData.switchRole),"Could not change the switch role;More Details:"+mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//
						
			if(mandData.testCaseId.equals("TC_VSP_003")){				
				assertTrue(noAccessUserSystemSetting(selenium, mandData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
				
			}		

			//--------------------------------------------------------------------//
			//  Step-4: Full and View Only User Role 							  //
			//--------------------------------------------------------------------//
			
			if(!mandData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(fullViewAccessUserSystemSetting(selenium, mandData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
				
			
			if(!verifySecurity(selenium,mandData)){
				Assert.fail("Security option not show properly; More Details :"+ mandData.toString());
				returnValue= false;
			}else
				returnValue=true;
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib mandData) throws IOException{
	   if(mandData.testCaseId.equals("TC_VSP_002")){

			click(selenium,lnkAdminMandatoryUserField);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkAddMandatoryUserField)||isElementPresent(selenium,btnDelete)||isElementPresent(selenium,btnEdit)){
				return true;
			}else
				return false;
		}
						
		if(mandData.testCaseId.equals("TC_VSP_004")){
			mandData.workSheetName = "CreateMandatoryField";
			mandData.testCaseId = "TC_MF_001";
			mandData.fetchSystemSettingTestData();
			click(selenium,lnkAdminMandatoryUserField);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatoryUserField(selenium),"Delete AllMandatoryUserField failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			//---------------------------------------------------------- ----------//
			//  Deleting existing entries  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkAddMandatoryUserField),"Could not click the button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
									
			assertTrue(createMandatoryUserField(selenium,mandData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnDelete)){
				return true;
			}else 
				return false;			
			
		}
		return true;
	}
	
	
	public boolean verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib mandData) throws IOException{
		Selenium selenium=null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mandData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, mandData.userName, mandData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,mandData.switchRole),"Could not change the switch role;More Details:"+mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,	lnkQuickLink),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction ),"Could not click the systemSettings link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Create Mandatory Field									  //
			//--------------------------------------------------------------------//
			
			mandData.workSheetName = "CreateMandatoryField";
			mandData.testCaseId = "TC_MF_001";
			mandData.fetchSystemSettingTestData();
			
			click(selenium,lnkAdminMandatoryUserField);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatoryUserField(selenium),"Delete AllMandatoryUserField failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAddMandatoryUserField),"Could not click the button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createMandatoryUserField(selenium,mandData),"Creation failed", selenium, ClassName, MethodName);
			
			// Smitch to LimitedAccess Role
			mandData.workSheetName = "VerifySecurityOption";
			mandData.testCaseId = "TC_VSP_001";
			mandData.fetchSystemSettingTestData();
			assertTrue(switchRole(selenium,mandData.switchRole),"Could not change the switch role;More Details:"+mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickLink),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction ),"Could not click the systemSettings link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkAdminMandatoryUserField);
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
