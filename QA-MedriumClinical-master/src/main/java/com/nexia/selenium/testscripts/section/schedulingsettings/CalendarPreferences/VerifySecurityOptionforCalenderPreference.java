package com.nexia.selenium.testscripts.section.schedulingsettings.CalendarPreferences;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionforCalenderPreference extends AbstractSchedulingTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib calendarPreference = new SchedulingTestLib();
		calendarPreference.workSheetName = "VerifySecurityOption";
		calendarPreference.testCaseId = "TC_VSP_002";
		calendarPreference.fetchSchedulingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, calendarPreference);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With No only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib calendarPreference = new SchedulingTestLib();
		calendarPreference.workSheetName = "VerifySecurityOption";
		calendarPreference.testCaseId = "TC_VSP_003";
		calendarPreference.fetchSchedulingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, calendarPreference);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Calendar Preference
	* @action 		  verifying Security Option For Calendar Preference
	* @expected       To Ensure that security option works fine for calendar Preference     
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 10, 2013
	***************************************************************************************************/
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib calendarPreference) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + calendarPreference.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, calendarPreference.userName, calendarPreference.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch Role//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,calendarPreference.switchRole),"Could not change the switch role;More Details:"+calendarPreference.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//No Access User Role	
			if(calendarPreference.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(click(selenium,lnkQuickAction),"Could not click the link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
				
				assertTrue(!selenium.isTextPresent("systemSettingsAction"),"Text Not Present",selenium, ClassName, MethodName);
				if(!selenium.isTextPresent("Calendar Settings")){
					return true;
				}
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate to Resource Calendar							  //
			//--------------------------------------------------------------------//
		
			if(!calendarPreference.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(goToScheduling(selenium),"Could not click the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,lnkCalenderPreference),"Could not click the Calender Preference",selenium, ClassName, MethodName);
				
				assertTrue(selenium.isTextPresent("Calendar Preferences"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to SchedulingSettings //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not click the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-----------------------------------------//
			//  Step-4: Verify Security//
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,calendarPreference)){
				Assert.fail("Security for" +calendarPreference.switchRole+ "is not proper:"+ calendarPreference.toString());
			}else
				return returnValue;
		}catch(RuntimeException e ){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium ,SchedulingTestLib calendarPreference){
		//View only
		try
		{
		waitForPageLoad(selenium);
		if(calendarPreference.testCaseId.equals("TC_VSP_001")){
			
			// Edit Button Should not be Visible
			assertTrue(!selenium.isTextPresent("Edit"), "Edit Button is visible",selenium, ClassName, MethodName);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return true;
	}
}
