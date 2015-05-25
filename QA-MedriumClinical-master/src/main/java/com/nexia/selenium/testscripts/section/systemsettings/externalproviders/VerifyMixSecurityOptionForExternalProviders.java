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

public class VerifyMixSecurityOptionForExternalProviders extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Mix Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminEProvData = new SystemSettingsLib();
		adminEProvData.workSheetName = "VerifySecurityOption";
		adminEProvData.testCaseId = "TC_VSP_007";
		adminEProvData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adminEProvData);
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

	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib adminEProvData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrieve the New Selenium Session; More Details :" + adminEProvData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, adminEProvData.userName, adminEProvData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,adminEProvData.switchRole),"Could not change the switch role;More Details:"+adminEProvData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				

			//--------------------------------------------------------------------//
			//  Step-3: No access User Role 									  //
			//--------------------------------------------------------------------//			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_028";
			userRoleData.fetchSystemSettingTestData();

			if(userRoleData.externalProviders.contains("No Access")){		

				assertTrue(noAccessMixSecuritySystemSetting(selenium, adminEProvData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isVisible(lnkExternalProviderList),"Enterprise Providers is present",selenium, ClassName, MethodName);
			}			

			//--------------------------------------------------------------------//
			//  Step-4: Full, View User Role 									  //
			//--------------------------------------------------------------------//			
			if(!userRoleData.externalProviders.contains("No Access")){				
				assertTrue(fullViewAccessUserSystemSetting(selenium, adminEProvData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);						
			}

			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			assertTrue(verifySecurity(selenium,adminEProvData,userRoleData,userAccount), 
					"Security option not show properly; More Details :"+ adminEProvData.toString(), selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib providerData, SystemSettingsLib userRoleData,String userAccount) throws IOException{
		boolean returnValue=true;
		// Limited Access
		if(userRoleData.externalProviders.contains("Limited Access")){
			providerData.workSheetName = "CreateExternalProviders";
			providerData.testCaseId = "TC_EP_001";
			providerData.fetchSystemSettingTestData();


			click(selenium,lnkExternalProviderList);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkAddReferringProvider),"Could not click the button",selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueNo=DateFormat.format(cal.getTime());
			assertTrue(createExternalProvider(selenium,providerData,uniqueNo,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//Assert.assertTrue(!isElementPresent(selenium, btnDelete),"Delete Element Present");
			assertTrue(!isElementVisible(selenium, btnDelete),"Delete Element Visible", selenium, ClassName, MethodName);
			System.out.println(returnValue);			
			return returnValue;

			/*	if(isElementPresent(selenium,btnDelete)){
				returnValue=false;
			}else
				return returnValue;*/
		}

		// View Only Access
		if(userRoleData.externalProviders.contains("View Only")){
			click(selenium,lnkExternalProviderList);
			waitForPageLoad(selenium);
			if(getText(selenium,lnkAddReferringProvider).equalsIgnoreCase("Add New")||getText(selenium,"editButtonId").equalsIgnoreCase("Edit")){
				returnValue= false;
			}else
				return returnValue;		
		}

		// Full Access
		if(userRoleData.externalProviders.contains("Full Access")){
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
			assertTrue(createExternalProvider(selenium,providerData,uniqueNo,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(isElementPresent(selenium,btnDelete),"Not able to find delete button", selenium, ClassName, MethodName);
		}

		if(userRoleData.externalProviders.contains("No Access")){
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingLink), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExternalProviderList), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(getText(selenium,lblHeader).contains("External Providers"), 
					"Not able to find text External Providers", selenium, ClassName, MethodName);
		}

		return returnValue;
	}
}