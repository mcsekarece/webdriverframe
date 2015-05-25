package com.nexia.selenium.testscripts.section.systemsettings.externalproviders;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForExternalProvider extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "VerifySecurityOption";
		providerData.testCaseId = "TC_VSP_001";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "VerifySecurityOption";
		providerData.testCaseId = "TC_VSP_002";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "VerifySecurityOption";
		providerData.testCaseId = "TC_VSP_003";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "VerifySecurityOption";
		providerData.testCaseId = "TC_VSP_004";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
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
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,providerData.switchRole),"Could not change the switch role;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//						
			if(providerData.testCaseId.equals("TC_VSP_003")){				
				assertTrue(noAccessUserSystemSetting(selenium, providerData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);				
			}			

			//--------------------------------------------------------------------//
			//  Step-4: Full and View Only User Role 							  //
			//--------------------------------------------------------------------//			
			if(!providerData.testCaseId.equals("TC_VSP_003")){				
				assertTrue(fullViewAccessUserSystemSetting(selenium, providerData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);				
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			assertTrue( verifySecurity(selenium,providerData,userAccount) , 
					"Security option not show properly; More Details :"+ providerData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib providerData,String account ) throws IOException{
		boolean returnValue=true;
		if(providerData.testCaseId.equals("TC_VSP_001")){
			providerData.workSheetName = "CreateExternalProviders";
			providerData.testCaseId = "TC_EP_001";
			providerData.fetchSystemSettingTestData();
			

			click(selenium,lnkExternalProviderList);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkAddReferringProvider),"Could not click the button",selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueNo=DateFormat.format(cal.getTime());
			assertTrue(createExternalProvider(selenium,providerData,uniqueNo,account),"Creation failed",selenium, ClassName, MethodName);
			
			assertTrue( isElementPresent(selenium,btnDelete), "Delete button not found", selenium, ClassName, MethodName);
			
		}
		if(providerData.testCaseId.equals("TC_VSP_002")){

			click(selenium,lnkExternalProviderList);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,lnkAddReferringProvider).equalsIgnoreCase("Add New")||getText(selenium,"editButtonId").equalsIgnoreCase("Edit"), 
					"Not able to find text Add New or Edit", selenium, ClassName, MethodName);						
		}
		
		if(providerData.testCaseId.equals("TC_VSP_004")){
			providerData.workSheetName = "CreateExternalProviders";
			providerData.testCaseId = "TC_EP_001";
			providerData.fetchSystemSettingTestData();
			click(selenium,lnkExternalProviderList);
			waitForPageLoad(selenium);
			assertTrue(deleteAllExternalProvider(selenium ),"Deletion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkAddReferringProvider),"Could not click the button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueNo=DateFormat.format(cal.getTime());
			assertTrue(createExternalProvider(selenium,providerData,uniqueNo,account),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,btnDelete), "Delete button not present", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
