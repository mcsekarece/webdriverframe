package com.nexia.selenium.testscripts.section.schedulingsettings.CalendarPreferences;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForCalendarPreferences extends AbstractSchedulingTest {
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Mixed security role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
	
	SchedulingTestLib visitGroup = new SchedulingTestLib();
	visitGroup.workSheetName = "VerifySecurityOption";
	visitGroup.testCaseId = "TC_VSP_005";
	visitGroup.fetchSchedulingTestData();
	
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
	verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		IOException 
	 * @since  	   	Nov 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib cdsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cdsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cdsData.userName, cdsData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,cdsData.switchRole),"Could not change the switch role;More Details:"+cdsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_025";
			userRoleData.fetchSystemSettingTestData();
			
			if(userRoleData.calendarSettings.contains("No Access")){				
			    assertTrue(noAccessUserSchedulingSettings(selenium, cdsData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);				
			}			
			
			//--------------------------------------------------------------------//
			//  Step-4: Full, View Access User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.calendarSettings.contains("No Access")){
			    assertTrue(fullViewAccessUserSchedulingSettings(selenium, cdsData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;				
			    
			    if(!verifySecurity(selenium,cdsData, userRoleData, userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ cdsData.toString());
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
	public boolean verifySecurity(Selenium selenium,SchedulingTestLib ResourceCalData,SystemSettingsLib userRoleData, String userAccount) throws IOException{
		boolean returnValue=true;
		
		//Full Access Permission	
		if(userRoleData.calendarPreferences.contains("Full Access")){
		  assertTrue(click(selenium,lnkCalenderPreference),"Could not click the Calender Preference", selenium, ClassName, MethodName);
		 // Edit Button Should be Visible
		    waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent("Edit"), "Edit Button is visible", selenium, ClassName, MethodName);
		}
	
		//View Only Access Permission
		if(userRoleData.calendarPreferences.contains("View Only")){
		   assertTrue(click(selenium,lnkCalenderPreference),"Could not click the Calender Preference", selenium, ClassName, MethodName);
		 // Edit Button Should not be Visible
			assertTrue(!selenium.isTextPresent("Edit"), "Edit Button is visible", selenium, ClassName, MethodName);
		}
		 
		//Limited Access Permission
		if(userRoleData.calendarPreferences.contains("Limited Access")){
		    assertTrue(click(selenium,lnkCalenderPreference),"Could not click the Calender Preference", selenium, ClassName, MethodName);
		 // Edit Button Should be Visible
			assertTrue(selenium.isTextPresent("Edit"), "Edit Button is visible", selenium, ClassName, MethodName);	
			
		}
		
		//No Access Permission
		if(userRoleData.calendarPreferences.contains("No Access")){
		    assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"css=#schedulingSettingsAction > span.actionItemSpan"), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!schedulingSettingsPreferencesShow"), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,lblHeader).contains("Calendar Preferences"),"", selenium, ClassName, MethodName);
		}
		
		return returnValue;
	}

}

