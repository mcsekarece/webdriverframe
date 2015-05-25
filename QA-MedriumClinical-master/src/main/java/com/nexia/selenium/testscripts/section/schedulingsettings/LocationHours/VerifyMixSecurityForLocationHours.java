package com.nexia.selenium.testscripts.section.schedulingsettings.LocationHours;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityForLocationHours extends AbstractSchedulingTest {
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
			    assertTrue(fullViewAccessUserSchedulingSettings(selenium, cdsData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);				
			    
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
	public boolean verifySecurity(Selenium selenium,SchedulingTestLib calendarTemplate,SystemSettingsLib userRoleData, String userAccount) throws IOException{
		boolean returnValue=true;
		
		//Full Access Permission	
		if(userRoleData.locationHours.contains("Full Access")){
		    assertTrue(selenium.isElementPresent("//a[contains(text(),'Edit')]"),"", selenium, ClassName, MethodName);
			return returnValue;
		}
	
		//View Only Access Permission
		if(userRoleData.locationHours.contains("View Only")){
		    // Edit Button should not be Visible
			assertTrue(!selenium.isElementPresent("//a[contains(text(),'Edit')]"),"", selenium, ClassName, MethodName);
			return returnValue;
		}
		 
		//Limited Access Permission
		if(userRoleData.locationHours.contains("Limited Access")){
		   assertTrue(selenium.isElementPresent("//a[contains(text(),'Edit')]"),"", selenium, ClassName, MethodName);
			return returnValue;
		   }
		
		//No Access Permission
		if(userRoleData.locationHours.contains("No Access")){
		    assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"schedulingSettingsAction"), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(click(selenium,"!schedulingSettingsLocationHoursList"), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,lblHeader).contains("Location Hours"),"", selenium, ClassName, MethodName);
			return returnValue;
		}
		
		return returnValue;
	}

}
