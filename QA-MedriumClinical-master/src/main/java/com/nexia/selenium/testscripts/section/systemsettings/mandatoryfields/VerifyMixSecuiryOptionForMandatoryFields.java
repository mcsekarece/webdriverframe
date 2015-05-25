package com.nexia.selenium.testscripts.section.systemsettings.mandatoryfields;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecuiryOptionForMandatoryFields extends AbstractSystemSettingsTest {
    	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Mix Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminMandatoryFrData = new SystemSettingsLib();
		adminMandatoryFrData.workSheetName = "VerifySecurityOption";
		adminMandatoryFrData.testCaseId = "TC_VSP_007";
		adminMandatoryFrData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adminMandatoryFrData);
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
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib adminMandatoryFrData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminMandatoryFrData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, adminMandatoryFrData.userName, adminMandatoryFrData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,adminMandatoryFrData.switchRole),"Could not change the switch role;More Details:"+adminMandatoryFrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			
		
			//--------------------------------------------------------------------//
			//  Step-3: No access User Role 									  //
			//--------------------------------------------------------------------//
			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_028";
			userRoleData.fetchSystemSettingTestData();
			
			if(userRoleData.mandatoryFields.contains("No Access")){			
				assertTrue(noAccessMixSecuritySystemSetting(selenium, adminMandatoryFrData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isVisible(lnkAdminMandatoryUserField),"Mandatory Field link is present",selenium, ClassName, MethodName);
				
			}			
		
			//--------------------------------------------------------------------//
			//  Step-4: Full, View User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.mandatoryFields.contains("No Access")){				
				assertTrue(fullViewAccessUserSystemSetting(selenium, adminMandatoryFrData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);						
			}
						
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,adminMandatoryFrData,userRoleData,userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ adminMandatoryFrData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib mandData, SystemSettingsLib userRoleData,String userAccount) throws IOException{
		boolean returnValue=true;
		// Limited Access
		if(userRoleData.mandatoryFields.contains("Limited Access")){
		    	assertTrue(switchRole(selenium,"DFFullAccess"),"Could not change the switch role;More Details:"+mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,	lnkQuickLinkDiv),"Could not click on the link", selenium, ClassName, MethodName);
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
			
			assertTrue(switchRole(selenium,mandData.switchRole),"Could not change the switch role;More Details:"+mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,	lnkQuickLinkDiv),"Could not click on the link", selenium, ClassName, MethodName);
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
		}
		
		// View Only Access
		if(userRoleData.mandatoryFields.contains("View Only")){
		    	click(selenium,lnkAdminMandatoryUserField);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkAddMandatoryUserField)||isElementPresent(selenium,btnDelete)||isElementPresent(selenium,btnEdit)){
				return true;
			}else
				return false;	
		}
			
		// Full Access
		if(userRoleData.mandatoryFields.contains("Full Access")){
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
		
		if(userRoleData.mandatoryFields.contains("No Access")){
		    	Assert.assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button");
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,lnkSystemSettingLink), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,lnkAdminMandatoryUserField), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblHeader).contains("Mandatory field")){
			    returnValue= false;
			 }else
			  return returnValue;
		}
		
		return returnValue;
	}
}
