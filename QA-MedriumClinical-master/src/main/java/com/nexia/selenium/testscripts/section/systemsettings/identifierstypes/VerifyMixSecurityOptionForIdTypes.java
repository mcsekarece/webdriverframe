package com.nexia.selenium.testscripts.section.systemsettings.identifierstypes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForIdTypes extends AbstractSystemSettingsTest {
    	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Mix Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminIdentifierTypeData = new SystemSettingsLib();
		adminIdentifierTypeData.workSheetName = "VerifySecurityOption";
		adminIdentifierTypeData.testCaseId = "TC_VSP_007";
		adminIdentifierTypeData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adminIdentifierTypeData);
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
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib adminIdentifierTypeData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminIdentifierTypeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, adminIdentifierTypeData.userName, adminIdentifierTypeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,adminIdentifierTypeData.switchRole),"Could not change the switch role;More Details:"+adminIdentifierTypeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			
		
			//--------------------------------------------------------------------//
			//  Step-3: No access User Role 									  //
			//--------------------------------------------------------------------//
			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_028";
			userRoleData.fetchSystemSettingTestData();
			
			if(userRoleData.identifiersAdmin.contains("No Access")){				
				assertTrue(noAccessMixSecuritySystemSetting(selenium, adminIdentifierTypeData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isVisible(lnkIdentifierGroupSec),"Identifier Type is present",selenium, ClassName, MethodName);
				
			}			
		
			//--------------------------------------------------------------------//
			//  Step-4: Full, View User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.identifiersAdmin.contains("No Access")){				
				assertTrue(fullViewAccessUserSystemSetting(selenium, adminIdentifierTypeData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);						
			}
						
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,adminIdentifierTypeData,userRoleData,userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ adminIdentifierTypeData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib idGroupData, SystemSettingsLib userRoleData,String userAccount) throws IOException{
		boolean returnValue=true;
		// Limited Access
		if(userRoleData.identifiersAdmin.contains("Limited Access")){
		    	idGroupData.workSheetName = "CreateIdentifierTypes";
			idGroupData.testCaseId = "TC_IDT_001";
			idGroupData.fetchSystemSettingTestData();

			click(selenium,lnkIdentifierGroupSec);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAddIdentifierTypeSec),"Could not click the button", selenium, ClassName, MethodName);
			assertTrue(createIdType(selenium,idGroupData),"Creation failed", selenium, ClassName, MethodName);
			if(isElementPresent(selenium,btnDelete)){
				returnValue=false;
			}else
				return returnValue;
		}
		
		// View Only Access
		if(userRoleData.identifiersAdmin.contains("View Only")){
		    	click(selenium,lnkIdentifierType);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEditIdType)){
				waitForPageLoad(selenium);
				returnValue=false;
			}else
				return returnValue;		
		}
			
		// Full Access
		if(userRoleData.identifiersAdmin.contains("Full Access")){
		    	idGroupData.workSheetName = "CreateIdentifierTypes";
			idGroupData.testCaseId = "TC_IDT_001";
			idGroupData.fetchSystemSettingTestData();
			
			click(selenium,lnkIdentifierType);
			waitForPageLoad(selenium);
			assertTrue(deleteAllIdentifiersTypes(selenium ),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAddIdentifierTypeSec),"Could not click the button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createIdType(selenium,idGroupData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnDelete)){
				return returnValue;
			}else
				returnValue= false;
		}
		
		if(userRoleData.identifiersAdmin.contains("No Access")){
		    	Assert.assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,lnkSystemSettingLink), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,lnkIdentifierGroup), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblHeader).contains("Identifier Types")){
			    returnValue= false;
			 }else
			  return returnValue;
		}
		
		return returnValue;
	}
}
