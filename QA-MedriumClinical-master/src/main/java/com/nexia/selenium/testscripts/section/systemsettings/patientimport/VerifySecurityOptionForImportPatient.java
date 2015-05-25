
package com.nexia.selenium.testscripts.section.systemsettings.patientimport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForImportPatient extends AbstractSystemSettingsTest{
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
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
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
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "VerifySecurityOption";
		mandData.testCaseId = "TC_VSP_002";
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
	 * @since  	    Dec 21, 2012
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
			
			assertTrue(click(selenium,lnkQuickLink),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(mandData.testCaseId.equals("TC_VSP_003")){
				if(isElementPresent(selenium,lnkSystemSettingsAction)){
					return false;
				}else
					return true;
			}
			
			if(!mandData.testCaseId.equals("TC_VSP_004")){
				if(isElementPresent(selenium,lnkImportPatientActionCss)){
					return false;
			}
			
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the systemSettings link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			
			if(!verifySecurity(selenium,mandData)){
				Assert.fail("Security option not show properly; More Details :"+ mandData.toString());
				returnValue= false;
			}else
				returnValue=true;
			
			}
			else
			{
					
			assertTrue(click(selenium,lnkImportPatientAction),"Could not click the systemSettings link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,mandData)){
				Assert.fail("Security option not show properly; More Details :"+ mandData.toString());
				returnValue= false;
			}else
				returnValue=true;
			
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib mandData){
	
		if(mandData.testCaseId.equals("TC_VSP_001")){
			if(isElementPresent(selenium,lnkImportChart)){
				return true;
			}else
				return false;
		}
		if(mandData.testCaseId.equals("TC_VSP_002")){
			if(isElementPresent(selenium,lnkImportChart)){
				return true;
			}else
				return false;
		}
		
		if(mandData.testCaseId.equals("TC_VSP_004")){
			click(selenium,lnkImportChart);
			if(isElementPresent(selenium,txtPatientSearch)){
				return true;
			}else
				return false;
		}
		return true;
	}
}
