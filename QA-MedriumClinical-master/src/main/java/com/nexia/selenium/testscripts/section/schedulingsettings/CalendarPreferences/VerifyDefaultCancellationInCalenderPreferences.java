package com.nexia.selenium.testscripts.section.schedulingsettings.CalendarPreferences;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultCancellationInCalenderPreferences  extends AbstractSchedulingTest{
	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Default Cancellation In Calender Preferences")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultCancellationInCalenderPreferences(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib calendarPreference = new SchedulingTestLib();
		calendarPreference.workSheetName = "VerifySecurityOption";
		calendarPreference.testCaseId = "TC_VSP_004";
		calendarPreference.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCalenderPreferences(seleniumHost, seleniumPort, browser, webSite, userAccount, calendarPreference);
	}


	/*************************************************************************************************** 
	* @purpose       VerifyDefaultCancellationInCalenderPreferences
	* @action 		  VerifyDefaultCancellationInCalenderPreferences
	* @expected       To Ensure Default Cancellation In Calender Preferences
	* @author         Aspire QA
	 * @throws IOException 
	* @useraccount    Both
	* @since  	      Aug 7, 2013
	***************************************************************************************************/
	
	
	public boolean verifyCalenderPreferences(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib calendarPreference) throws IOException{
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
							
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to SchedulingSettings //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not click the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkCalenderPreference),"Could not click the Calender Preference",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnEdit),"Could not click Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxDefaultCancellation,"No-show"),"Could not select default cancellation",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    
			assertTrue(click(selenium,btnSave),"Could not click Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getValue(selenium,vfyCancellation).contains("No-show"),"The Default Cancellation is not properly saved", selenium, ClassName, MethodName);
			return true;
		
		}catch(RuntimeException e ){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + calendarPreference.toString(), selenium, ClassName,MethodName);
		}
		return returnValue;
	}
}
