package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceCalendars;


import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class CreateResourceCalenderForProviderWD extends AbstractSchedulingTest {
	
	WebDriver driver = null;	
	@Test(groups = {"SmokeCalendarUIWD","firefox", "iexplore", "safari", "default" }, description = "CreatePatternForResourceCalender", priority=2)	
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createResourceCalenderWebDriver_1(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib createResourceCalData = new SchedulingTestLib();
		createResourceCalData.workSheetName = "CreateResourceCalender";
		createResourceCalData.testCaseId = "TC_CRC_001";
		createResourceCalData.fetchSchedulingTestData();	
		createPattern(seleniumHost, seleniumPort, browser, webSite, userAccount, createResourceCalData);
	}	
	
	@Test(groups = {"CalendarUIWD","firefox", "iexplore", "safari", "default" }, description = "CreatePatternForResourceCalender", priority=3)	
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createResourceCalenderWebDriver_2(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib createResourceCalData = new SchedulingTestLib();
		createResourceCalData.workSheetName = "CreateResourceCalender";
		createResourceCalData.testCaseId = "TC_CRC_006";
		createResourceCalData.fetchSchedulingTestData();	
		createPattern(seleniumHost, seleniumPort, browser, webSite, userAccount, createResourceCalData);
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default" }, description = "CreatePatternForResourceCalender", priority=3)	
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createResourceCalenderWebDriver_3(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib createResourceCalData = new SchedulingTestLib();
		createResourceCalData.workSheetName = "CreateResourceCalender";
		createResourceCalData.testCaseId = "TC_CRC_007";
		createResourceCalData.fetchSchedulingTestData();	
		createPattern(seleniumHost, seleniumPort, browser, webSite, userAccount, createResourceCalData);
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default" }, description = "CreatePatternForResourceCalender", priority=3)	
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createResourceCalenderWebDriver_4(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib createResourceCalData = new SchedulingTestLib();
		createResourceCalData.workSheetName = "CreateResourceCalender";
		createResourceCalData.testCaseId = "TC_CRC_008";
		createResourceCalData.fetchSchedulingTestData();	
		createPattern(seleniumHost, seleniumPort, browser, webSite, userAccount, createResourceCalData);
	}
	
	public boolean createPattern(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingTestLib createResourceCalData) throws  IOException, InterruptedException{

		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//			
			
			driver = getWebdriver(seleniumHost, seleniumPort, browser, webSite, ClassName, MethodName, driver);
			assertTrue(loginForNexiaForWebdriver(driver, userAccount, createResourceCalData.userName, createResourceCalData.userPassword),"Login Failed ", driver , ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to SchedulingSettings //
			//--------------------------------------------------------------------//
			
			assertTrue(goToScheduling(driver),"Could not click the link", driver, ClassName, MethodName);
			waitForPageLoad(driver);
						
			assertTrue(click(driver,lnkResourceCalender),"Could not click Resource Calender link", driver, ClassName, MethodName);
			waitForPageLoad(driver);
			
						
			//--------------------------------------------------------------------//
			//  Step-3: check exisiting Calender and Create One if required
			//--------------------------------------------------------------------//
			
			if(checkInactiveResource(driver,createResourceCalData,userAccount)){
				
				System.out.println("No need to Create the new resource");
			}else{
		    		System.out.println("Create the new resource");		    		
		    		assertTrue(createResourceCalender(driver, createResourceCalData,userAccount), "Create Resource Calender With Mandatory Fields failed", driver, ClassName, MethodName);
		    		waitForPageLoad(driver);
		    		
		    		// Verify that Resource Calender is created properly
		    		
		    		if(!verifyStoreValues(driver,createResourceCalData)){
				    	fail("The Pattern Values are not stored properly");
				    }		    		
			}			
					
		}		
		
		catch(RuntimeException e){
			e.printStackTrace();
			driver.quit();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" );
		}
		return returnValue;
		
		
	}
	
	
	

	public boolean  verifyStoreValues(WebDriver driver,SchedulingTestLib createResourceCalData) throws IOException, InterruptedException{
		 
		  String date =null;
		  Calendar cal=Calendar.getInstance();
		  SimpleDateFormat DateFormat1=new SimpleDateFormat("MMMM dd");
		  date=DateFormat1.format(cal.getTime());
		  
		  //assertTrue(click(driver,lnkViewDetails2),"Could not click the link View Details", driver, ClassName, MethodName);		  
		  assertTrue(clickXPath(driver,lnkViewDetailsXPath),"Could not click the link View Details", driver, ClassName, MethodName);
  	  	  
		  waitForPageLoad(driver);
		  waitForPageLoad(driver);
		  waitForPageLoad(driver);
		  waitForPageLoad(driver);
		  waitForPageLoad(driver);
		  Thread.sleep(6000);
		  
		  int size = driver.getPageSource().split(createResourceCalData.visitType).length-1;
		  System.out.println("Size =" + size);
		  if (size >= 5)			  
		  {
			System.out.println("Required Appointments Already, No Further Requirement"); 
			return  true;			  
		  } else {
			  return false;
		  }
		 
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