package com.nexia.selenium.testscripts.section.systemsettings.healthcareteam;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForHealthCareTeam extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Mix Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib adminHealthCareData = new SystemSettingsLib();
		adminHealthCareData.workSheetName = "VerifySecurityOption";
		adminHealthCareData.testCaseId = "TC_VSP_007";
		adminHealthCareData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adminHealthCareData);
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
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib adminHealthCareData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminHealthCareData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, adminHealthCareData.userName, adminHealthCareData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,adminHealthCareData.switchRole),"Could not change the switch role;More Details:"+adminHealthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			
		
			//--------------------------------------------------------------------//
			//  Step-3: No access User Role 									  //
			//--------------------------------------------------------------------//
			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_028";
			userRoleData.fetchSystemSettingTestData();
			
			if(userRoleData.healthCareTeamAdmin.contains("No Access")){			
				
				assertTrue(noAccessMixSecuritySystemSetting(selenium, adminHealthCareData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isVisible(lnkAdminHealthcareTeamList),"HealthCare Team is present",selenium, ClassName, MethodName);
			}			
		
			//--------------------------------------------------------------------//
			//  Step-4: Full, View User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.healthCareTeamAdmin.contains("No Access")){				
				assertTrue(fullViewAccessUserSystemSetting(selenium, adminHealthCareData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);						
			}
						
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,adminHealthCareData,userRoleData,userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ adminHealthCareData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib healthCareData, SystemSettingsLib userRoleData,String userAccount) throws IOException{
		boolean returnValue=true;
		// Limited Access
		if(userRoleData.healthCareTeamAdmin.contains("Limited Access")){
			healthCareData.workSheetName="CreateHealthCareTeam";
			healthCareData.testCaseId="TC_HCT_001";
			healthCareData.fetchSystemSettingTestData();
		    	Assert.assertTrue(click(selenium,lnkAdminHealthcareTeamList), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
		    	assertTrue(click(selenium, btnAddHealthcareTeam),"Could not click on Add Health Care Datalink:" + healthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
				
			assertTrue(createHealthCareTeam(selenium,healthCareData,uniqueName),"Health Care team Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Assert.assertTrue(!isElementPresent(selenium,"link=Delete"), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(isElementPresent(selenium,"link=Edit"), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
		}
		
		// View Only Access
		if(userRoleData.healthCareTeamAdmin.contains("View Only")){
		   	Assert.assertTrue(click(selenium,lnkAdminHealthcareTeamList), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
			
		    	//assertTrue(!isElementPresent(selenium, btnAddHealthcareTeam),"Could not click on Add Health Care Datalink:" + healthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		    	Assert.assertTrue(!isElementPresent(selenium,"link=Delete"), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(!isElementPresent(selenium,"link=Edit"), "Could not click on Clinical settings");
			waitForPageLoad(selenium);			
		}
			
		// Full Access
		if(userRoleData.healthCareTeamAdmin.contains("Full Access")){
			healthCareData.workSheetName="CreateHealthCareTeam";
			healthCareData.testCaseId="TC_HCT_001";
			healthCareData.fetchSystemSettingTestData();
		    	Assert.assertTrue(click(selenium,lnkAdminHealthcareTeamList), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
		    	assertTrue(click(selenium, btnAddHealthcareTeam),"Could not click on Add Health Care Datalink:" + healthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM-dd-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
				
			assertTrue(createHealthCareTeam(selenium,healthCareData,uniqueName),"Health Care team Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Assert.assertTrue(isElementPresent(selenium,"link=Delete"), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(isElementPresent(selenium,"link=Edit"), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
	
		}
		
		if(userRoleData.healthCareTeamAdmin.contains("No Access")){
		    	Assert.assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button");
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,lnkSystemSettingLink), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,lnkAdminHealthcareTeamList), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblHeader).contains("Healthcare Team Administration")){
			    returnValue= false;
			 }else
			    return returnValue;
		}
		
		return returnValue;
	}
}
