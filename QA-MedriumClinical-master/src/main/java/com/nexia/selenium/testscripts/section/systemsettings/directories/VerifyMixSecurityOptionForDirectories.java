package com.nexia.selenium.testscripts.section.systemsettings.directories;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForDirectories extends AbstractSystemSettingsTest {
    	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Mix Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminDirData = new SystemSettingsLib();
		adminDirData.workSheetName = "VerifySecurityOption";
		adminDirData.testCaseId = "TC_VSP_007";
		adminDirData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adminDirData);
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
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib adminDirData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminDirData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, adminDirData.userName, adminDirData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,adminDirData.switchRole),"Could not change the switch role;More Details:"+adminDirData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			
		
			//--------------------------------------------------------------------//
			//  Step-3: No access User Role 									  //
			//--------------------------------------------------------------------//
			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_028";
			userRoleData.fetchSystemSettingTestData();
			
			if(userRoleData.directories.contains("No Access")){			
				assertTrue(noAccessMixSecuritySystemSetting(selenium, adminDirData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkSystemSettingLink),"not able to click System Setting",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isVisible(lnkDirectories),"Directories is present",selenium, ClassName, MethodName);
				return true;
			}			
		
			//--------------------------------------------------------------------//
			//  Step-4: Full, View User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.directories.contains("No Access")){				
				assertTrue(fullViewAccessUserSystemSetting(selenium, adminDirData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);						
			}
						
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			assertTrue(!verifySecurity(selenium,adminDirData,userRoleData,userAccount), 
					"Security option not show properly; More Details :"+ adminDirData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib dirData, SystemSettingsLib userRoleData,String userAccount) throws IOException{
		boolean returnValue=true;
		// Limited Access
		if(userRoleData.directories.contains("Limited Access")){
		    	assertTrue(switchRole(selenium,"DFFullAccess"),"Could not change the switch role;More Details:"+dirData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkQuickLinkDiv),"Could not click on the link", selenium, ClassName, MethodName);
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
			
			dirData.workSheetName = "CreateDirectories";
			dirData.testCaseId = "TC_CDIR_001";
			dirData.fetchSystemSettingTestData();
			click(selenium,lnkDirectories);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,"Pharmacies");
			waitForPageLoad(selenium);
			assertTrue(deleteDirectories(selenium),"Deletion failed", selenium, ClassName, MethodName);
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
			
			assertTrue(click(selenium,	lnkQuickLinkDiv),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction ),"Could not click the systemSettings link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkDirectories);
			waitForPageLoad(selenium);
			
			// check for the absence of Delete Button
			if(isElementPresent(selenium,btnDelete)){
				return false;
			}else
				return true;
		}
		
		// View Only Access
		if(userRoleData.directories.contains("View Only")){
		    	assertTrue( click(selenium,lnkDirectories),"could not click on directories link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnDelete) || isElementPresent(selenium,btnAddNew)){
				returnValue=false;
			}else
				return returnValue;	
		}
			
		// Full Access
		if(userRoleData.directories.contains("Full Access")){
		    	dirData.workSheetName = "CreateDirectories";
			dirData.testCaseId = "TC_CDIR_001";
			dirData.fetchSystemSettingTestData();
			click(selenium,lnkDirectories);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,"Pharmacies");
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
		
		if(userRoleData.directories.contains("No Access")){
		    	Assert.assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button");
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,lnkSystemSettingLink), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,lnkDirectories), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblHeader).contains("Manage Directories")){
			    returnValue= false;
			 }else
			    return returnValue;
		}
		
		return returnValue;
	}
}
