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

public class VerifyMixSecurityOptionForEnterPriseVariable extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminEnterData = new SystemSettingsLib();
		adminEnterData.workSheetName = "VerifySecurityOption";
		adminEnterData.testCaseId = "TC_VSP_007";
		adminEnterData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adminEnterData);
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
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib adminEnterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminEnterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, adminEnterData.userName, adminEnterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			
			assertTrue(switchRole(selenium,adminEnterData.switchRole),"Could not change the switch role;More Details:"+adminEnterData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_028";
			userRoleData.fetchSystemSettingTestData();	
			
			if(userRoleData.enterpriseVariables.contains("No Access")){				
				assertTrue(noAccessMixSecuritySystemSetting(selenium, adminEnterData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isVisible(lnkEnterpriseVariables),"Enterprise Variables is present",selenium, ClassName, MethodName);				
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Full and View Only User Role 									  //
			//--------------------------------------------------------------------//
			
			if(userRoleData.enterpriseVariables.contains("View Only") || userRoleData.enterpriseVariables.contains("Full Access")){
				assertTrue(fullViewAccessUserSystemSetting(selenium, adminEnterData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);
				
				assertTrue(verifySecurity(selenium,adminEnterData,userRoleData), 
					"Security option not show properly; More Details :"+ adminEnterData.toString(), selenium, ClassName, MethodName);
							
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Limited Access User 									  //
			//--------------------------------------------------------------------//
			
			if(userRoleData.enterpriseVariables.contains("Limited Access")){
				assertTrue(verifySecurityOptionForLimitedAccess (seleniumHost, seleniumPort, browser, webSite, userAccount, adminEnterData), 
						"Security option not show properly; More Details :"+ adminEnterData.toString(), selenium, ClassName, MethodName);								
			}
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib adminEnterData,SystemSettingsLib userRoleData) throws IOException{
		
		// View Only Access		
		if(adminEnterData.testCaseId.equals("View Only")){
			
			click(selenium,lnkEnterpriseVariables);
			waitForPageLoad(selenium);
			if(getText(selenium,btnAddenterprise).equalsIgnoreCase("Add New")||getText(selenium,btnEdit).equalsIgnoreCase("Edit")
					||getText(selenium,btnDelete).equalsIgnoreCase("Delete")){
				return false;
			}else
				return true;
		}
		
		// Full Access		
		if(adminEnterData.testCaseId.equals("Full Access")){
			adminEnterData.workSheetName = "AdminEnterPriseVariables";
			adminEnterData.testCaseId = "TC_Pv_002";
			adminEnterData.fetchSystemSettingTestData();

			click(selenium,lnkEnterpriseVariables);
			waitForPageLoad(selenium);
			
			assertTrue(deleteEnterPrise(selenium,adminEnterData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddenterprise),"Could not click the button", selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createEnterPrise(selenium,adminEnterData,uniqueName),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnDelete)){
				return true;
			}else
				return false;
		}
		return true;
	}
	
   	
  public boolean verifySecurityOptionForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib adminEnterData) throws IOException{
		Selenium selenium=null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminEnterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, adminEnterData.userName, adminEnterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			SystemSettingsLib userRoleDataFull = new SystemSettingsLib();
			userRoleDataFull.workSheetName = "UserRole";
			userRoleDataFull.testCaseId = "TC_UR_004";
			userRoleDataFull.fetchSystemSettingTestData();
			
			
			assertTrue(switchRole(selenium,userRoleDataFull.switchRole),"Could not change the switch role;More Details:"+userRoleDataFull.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(click(selenium,	lnkQuickLinkDiv),"Could not click on the link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,	lnkQuickLink),"Could not click on the link", selenium, ClassName, MethodName);
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
			
			adminEnterData.workSheetName = "AdminEnterPriseVariables";
			adminEnterData.testCaseId = "TC_Pv_002";
			adminEnterData.fetchSystemSettingTestData();
			
			click(selenium,lnkEnterpriseVariables);
			waitForPageLoad(selenium);
			assertTrue(deleteEnterPrise(selenium,adminEnterData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddenterprise),"Could not click the button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createEnterPrise(selenium,adminEnterData,uniqueName),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Switch to LimitedAccess Role
			adminEnterData.workSheetName = "VerifySecurityOption";
			adminEnterData.testCaseId = "TC_VSP_001";
			adminEnterData.fetchSystemSettingTestData();
			assertTrue(switchRole(selenium,adminEnterData.switchRole),"Could not change the switch role;More Details:"+adminEnterData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,	lnkQuickLink),"Could not click on the link", selenium, ClassName, MethodName);
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