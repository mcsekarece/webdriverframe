package com.nexia.selenium.testscripts.section.operations.Calendar;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class ConflictingMsgAptCalendar_SCH845_WD extends AbstractOperationsTest{	

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
		
  /**     
  * @purpose          ConflictingMsg on AppointmentBooking (SCH-845)
  *  @action          CancelAppointmenCalenderView
  *  @expected        
  *  @author          Jagmit Singh
  *  @state           Developing
  *  @useraccount     Both
  * @since  	      Oct22, 2014
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
		//  Step-3: Search for a Resource and scroll to a particular element coordinate the save the Booking //
		//--------------------------------------------------------------------//
		
		assertTrue(selectValueFromAjaxList(driver,txtSearchResources,bookingAssistTestData.searchResource),"Could not select searched Resource"+bookingAssistTestData.toString(), driver, ClassName,MethodName);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		
		WebElement Element2 = driver.findElement(By.id("x0y48"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element2);
		Thread.sleep(500);
		
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		
		//WebElement mnuElement2 = driver.findElement(By.id("x0y48"));
	    Actions builder2 = new Actions(driver);					
		builder2.moveToElement(Element2).clickAndHold().build().perform();
		
		if (!isTextPresent(driver,"Actions"))
		
		{	
		assertTrue(selectValueFromAjaxList(driver,ajxVisitLocation,bookingAssistTestData.location),"Could not select Visit Location", driver, ClassName, MethodName);
	    waitForPageLoad(driver);
	    
	    assertTrue(selectValueFromAjaxList(driver,ajxVisitTypeBox,bookingAssistTestData.visitType),"Could not select visit Type"+bookingAssistTestData.toString(), driver, ClassName, MethodName);
	    waitForPageLoad(driver);
	    waitForPageLoad(driver);		
		
		assertTrue(type(driver,txtEndTime, "5"),"Could not Type at EndTime Hour TextBox", driver, ClassName,MethodName);
		waitForPageLoad(driver);	
		waitForPageLoad(driver);
		
	    assertTrue(clickLinkText(driver,"Save"),"Could not click Save button", driver, ClassName,MethodName);
		waitForPageLoad(driver);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element2);
		Thread.sleep(500);
		
		waitForPageLoad(driver);
		waitForPageLoad(driver);
					    					
		builder2.moveToElement(Element2).clickAndHold().build().perform();
		
	    }
		
		//--------------------------------------------------------------------//
		//  Step-4: Edit the previous appointment and make the start time same as EndTime //
		//--------------------------------------------------------------------//
			
	
		assertTrue(clickLinkText(driver,"Edit Slot"),"Could not click the Link - Edit Slot", driver, ClassName,MethodName);
		waitForPageLoad(driver);
		
		assertTrue(typeXPath(driver,txtEndHourBox,"4"),"Could not type hour unit in the box", driver, ClassName,MethodName);
		waitForPageLoad(driver);
		
		assertTrue(typeXPath(driver,txtEndMinBox,"00"),"Could not type Minute unit in the box", driver, ClassName,MethodName);
		waitForPageLoad(driver);
		
	    assertTrue(clickLinkText(driver,"Save"),"Could not click Save button", driver, ClassName,MethodName);
		waitForPageLoad(driver);
				
		assertTrue(isTextPresent(driver,"End time can not be equal start time"),"Warning message not Present", driver, ClassName, MethodName );
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