package com.nexia.selenium.testscripts.section.operations.Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class CancelAppointmentCalenderViewWD extends AbstractOperationsTest{	

	 WebDriver driver = null;
	@Test(groups = {"SmokeCalendarUIWD","firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithVisitType", priority=3)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelAppointmentProvider_1(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_012";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"CalendarUIWD","firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithVisitType", priority=4)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelAppointmentProvider_2(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_016";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithVisitType", priority=4)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelAppointmentProvider_3(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_017";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default" }, description = "VerifyCalenderViewWithVisitType", priority=4)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelAppointmentProvider_4(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_018";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}
	
	
		
  /**     
  * @purpose          CancelAppointmentCalenderView 
  *  @action          CancelAppointmenCalenderView
  *  @expected        
  *  @author          Jagmit Singh
  *  @state           Developing
  *  @useraccount     Both
  * @since  	      July 31, 2014
  * 
  */


public boolean CalenderView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData) throws Exception{
	Selenium selenium = null;
	String date = null;
	boolean returnValue= true;
	try{
		
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application  								  //
		//--------------------------------------------------------------------//
			
		driver = getWebdriver(seleniumHost, seleniumPort, browser, webSite, ClassName, MethodName, driver);		
		assertTrue(loginForNexiaForWebdriver(driver, userAccount, bookingAssistTestData.userName, bookingAssistTestData.userPassword),"Login Failed ", selenium, ClassName,MethodName);
	
		//--------------------------------------------------------------------//
		//  Step-2: Navigate to CalenderView 								  //
		//--------------------------------------------------------------------//
					
		assertTrue(goToOperations(driver),"Could not click the Operations link", driver, ClassName,MethodName);
		waitForPageLoad(driver);
	
		
				
		//--------------------------------------------------------------------//
		//  Step-3: Search for a Resource and Cancel all the appointments		  //
		//--------------------------------------------------------------------//
		
		assertTrue(selectValueFromAjaxList(driver,txtSearchResources,bookingAssistTestData.searchResource),"Could not select searched Resource"+bookingAssistTestData.toString(), driver, ClassName,MethodName);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		
		
		
		assertTrue(click(driver,btnActions),"Could not click Action link", driver, ClassName,MethodName);
		waitForPageLoad(driver);
		assertTrue(click(driver,btnCancelAction),"Could not click Cancel Action button", driver, ClassName,MethodName);
		waitForPageLoad(driver);
		
		assertTrue(type(driver,txtStartTime, "1"),"Could not Type at StartTime TextBox", driver, ClassName,MethodName);
		waitForPageLoad(driver);
		
		assertTrue(click(driver,txtStartFormat),"Could not click ON AM-PM dropdown Box", driver, ClassName,MethodName);
		waitForPageLoad(driver);
		
		assertTrue(click(driver,lblCurrentItem1),"Could not click on CurrentItem 1", driver, ClassName,MethodName);
		waitForPageLoad(driver);		
		
		assertTrue(click(driver,rdoDoNotBump),"Could not click Cancel Action button", driver, ClassName,MethodName);
		waitForPageLoad(driver);		
		assertTrue(selectValueFromAjaxList(driver,txtCancelReason,bookingAssistTestData.reason),"Could not select Cancellation Reason"+bookingAssistTestData.toString(), driver, ClassName,MethodName);
		waitForPageLoad(driver);		
	    assertTrue(clickLinkText(driver,"Save"),"Could not click Save button", driver, ClassName,MethodName);
		waitForPageLoad(driver);				
		
		
	}			
		catch (RuntimeException e){
			
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			
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
