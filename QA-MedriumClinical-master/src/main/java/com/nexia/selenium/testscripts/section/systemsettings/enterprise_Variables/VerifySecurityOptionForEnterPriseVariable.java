package com.nexia.selenium.testscripts.section.systemsettings.enterprise_Variables;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForEnterPriseVariable extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminAddrData = new SystemSettingsLib();
		adminAddrData.workSheetName = "VerifySecurityOption";
		adminAddrData.testCaseId = "TC_VSP_004";
		adminAddrData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOptionForLimitedAccess (seleniumHost, seleniumPort, browser, webSite, userAccount, adminAddrData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminAddrData = new SystemSettingsLib();
		adminAddrData.workSheetName = "VerifySecurityOption";
		adminAddrData.testCaseId = "TC_VSP_002";
		adminAddrData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adminAddrData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminAddrData = new SystemSettingsLib();
		adminAddrData.workSheetName = "VerifySecurityOption";
		adminAddrData.testCaseId = "TC_VSP_003";
		adminAddrData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adminAddrData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminAddrData = new SystemSettingsLib();
		adminAddrData.workSheetName = "VerifySecurityOption";
		adminAddrData.testCaseId = "TC_VSP_004";
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
			
			if(adminAddrData.testCaseId.equals("TC_VSP_003")){
			
				assertTrue(noAccessUserSystemSetting(selenium, adminAddrData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
						
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Full and View Only User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!adminAddrData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(fullViewAccessUserSystemSetting(selenium, adminAddrData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);	
				
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option 									  //
			//--------------------------------------------------------------------//
			assertTrue(verifySecurity(selenium,adminAddrData), 
			"Security option not show properly; More Details :"+ adminAddrData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib adminAddrData) throws IOException{
			
		if(adminAddrData.testCaseId.equals("TC_VSP_002")){

			click(selenium,lnkEnterpriseVariables);
			waitForPageLoad(selenium);
			if(getText(selenium,btnAddenterprise).equalsIgnoreCase("Add New")||getText(selenium,btnEdit).equalsIgnoreCase("Edit")
					||getText(selenium,btnDelete).equalsIgnoreCase("Delete")){
				return false;
			}else
				return true;
		}
		
				
		if(adminAddrData.testCaseId.equals("TC_VSP_004")){
			adminAddrData.workSheetName = "AdminEnterPriseVariables";
			adminAddrData.testCaseId = "TC_Pv_002";
			adminAddrData.fetchSystemSettingTestData();

			click(selenium,lnkEnterpriseVariables);
			waitForPageLoad(selenium);
			
			assertTrue(deleteEnterPrise(selenium,adminAddrData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddenterprise),"Could not click the button", selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createEnterPrise(selenium,adminAddrData,uniqueName),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnDelete)){
				return true;
			}else
				return false;
		}
		return true;
	}
	
   	
  public boolean verifySecurityOptionForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib adminAddrData) throws IOException{
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
			
			assertTrue(click(selenium,lnkQuickLink),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction ),"Could not click the systemSettings link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Create Mandatory Field									  //
			//--------------------------------------------------------------------//
			
			adminAddrData.workSheetName = "AdminEnterPriseVariables";
			adminAddrData.testCaseId = "TC_Pv_002";
			adminAddrData.fetchSystemSettingTestData();
			
			click(selenium,lnkEnterpriseVariables);
			waitForPageLoad(selenium);
			assertTrue(deleteEnterPrise(selenium,adminAddrData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddenterprise),"Could not click the button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createEnterPrise(selenium,adminAddrData,uniqueName),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Switch to LimitedAccess Role
			adminAddrData.workSheetName = "VerifySecurityOption";
			adminAddrData.testCaseId = "TC_VSP_001";
			adminAddrData.fetchSystemSettingTestData();
			assertTrue(switchRole(selenium,adminAddrData.switchRole),"Could not change the switch role;More Details:"+adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickLink),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction ),"Could not click the systemSettings link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkEnterpriseVariables);
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