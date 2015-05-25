package com.nexia.selenium.testscripts.section.schedulingsettings.LocationHours;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyHourFormatForLocationHoursWD extends AbstractSchedulingTest {
	WebDriver driver = null;
	@Test(groups = {"SmokeCalendarUIWD","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify 12 hour format", priority=1)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verify12HourFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib lhour = new SchedulingTestLib();
		lhour.workSheetName = "LocationHours";
		lhour.testCaseId = "TC_LH_009";
		lhour.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyHourFormat(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	
	@Test(groups = {"CalendarUIWD","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify 12 hour format", priority=1)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verify12HourFormat_2(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib lhour = new SchedulingTestLib();
		lhour.workSheetName = "LocationHours";
		lhour.testCaseId = "TC_LH_009";
		lhour.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyHourFormat(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}

	
	/*************************************************************************************************** 
	* @purpose        To verify 12/24 hour format in location hours
	* @action 		  verifying 12/24 hour format in location hours
	* @expected       To Ensure that 12/24 hour format works fine    
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      June 16, 2013
	***************************************************************************************************/
	public boolean verifyHourFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib lhour) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			driver = getWebdriver(seleniumHost, seleniumPort, browser, webSite, ClassName, MethodName, driver);		
			assertTrue(loginForNexiaForWebdriver(driver, userAccount, lhour.userName, lhour.userPassword),"Login Failed ",selenium, ClassName, MethodName);
				
			//--------------------------------------------------------------------//
			//  Step-2:Navigate To Location Hours						  //
			//--------------------------------------------------------------------//
			
			assertTrue(goToScheduling(driver),"Could not click the link", driver, ClassName, MethodName);
			waitForPageLoad(driver);						
			assertTrue(click(driver,lnkLocationHours),"Could not click Location Hours link", driver, ClassName, MethodName);
			waitForPageLoad(driver);
						
			//--------------------------------------------------------------------//
			//  Step-3: Search Location Hour						  //
			//--------------------------------------------------------------------//
			// Search for a Specific Resource
			assertTrue(type(driver,txtSearchBox,lhour.location2),"Could not select search resource", driver, ClassName, MethodName);
			Thread.sleep(6000); 
			
			if (!driver.getPageSource().contains(lhour.location2)){			
				return false;					
			}			
			 
			//--------------------------------------------------------------------//
			//  Step-4: Edit Location Hour						  //
			//--------------------------------------------------------------------//			
			assertTrue(editlocationHour(driver, lhour), "Edit Location failed",selenium, ClassName, MethodName);
			waitForPageLoad(driver);
			 
			//--------------------------------------------------------------------//
			//  Step-7: Verify Presence of Edit Button and Location Hours Text
			//--------------------------------------------------------------------//
		
					
			assertTrue(clickXPath(driver, btnEditLocation), "could not able to click the edit link",driver, ClassName, MethodName);
			waitForPageLoad(driver);
			
			if(!isTextPresent(driver,"Location Hours")){
				 return false;
			} 	
			
			assertTrue(click(driver, btnsaveLocationHours), "could not able to click SaveLocatioHours",driver, ClassName, MethodName);
			
			 
		}
		catch(RuntimeException e){
			e.printStackTrace();
			//assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	@AfterClass(alwaysRun = true) 
	public void testDown() throws Exception {
		try { 
	driver.quit();
	copyWebDriverLogs(driver,ClassName, MethodName);
	 
	} 
	finally { 
	driver.quit(); 
	} 
	}	
	
}