package com.nexia.selenium.testscripts.section.operations.BookingAssistant;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAppointmentDragDropWD extends AbstractOperationsTest{
	WebDriver driver = null;	
	@Test(groups = {"firefox", "iexplore", "safari", "default" }, description = "SearchResourceInCalender", priority=5)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchResourceInCalender_3(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib bookingAssistTestData = new  OperationsTestLib();
		bookingAssistTestData.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData.testCaseId = "TC_SBA_017";
		bookingAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CalenderView(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	}	
	
		
	/*************************************************************************************************** 
	* @purpose        verify add new patient in booking assistant
	* @action 		  verifying add new patient in booking assistant
	* @author         Jagmit
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      October 2nd, 2014
	***************************************************************************************************/
	
	
public boolean CalenderView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib bookingAssistTestData) throws Exception{
		
	boolean returnValue= true;
	try{
		
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application								  //
		//--------------------------------------------------------------------//		
		driver = getWebdriver(seleniumHost, seleniumPort, browser, webSite, ClassName, MethodName, driver);		
		assertTrue(loginForNexiaForWebdriver(driver, userAccount,bookingAssistTestData.userName, bookingAssistTestData.userPassword),"Login Failed ",driver, ClassName, MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-2: Navigate to BookingAssistant //
		//--------------------------------------------------------------------//
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		assertTrue(goToOperations(driver),"Could not click the Operations link",driver,ClassName,MethodName);
		waitForPageLoad(driver);						
		/*assertTrue(click(driver,lnkBookingAssistant),"Could not click Resource Calender link", driver, ClassName, MethodName);
		waitForPageLoad(driver);
					
		//--------------------------------------------------------------------//
		//  Step-3: Search Resource Calender Visit Type, Resource and Location Type//
		//--------------------------------------------------------------------//
			     
		assertTrue(selectValueFromAjaxList(driver,ajxVisitType,bookingAssistTestData.visitType),"Could not select visit type"+bookingAssistTestData.toString(),driver,ClassName,MethodName);
		waitForPageLoad(driver);
		assertTrue(selectValueFromAjaxList(driver,ajxBassLocationResource,bookingAssistTestData.resourceName1),"Could not select resource1 type"+bookingAssistTestData.toString(),driver,ClassName,MethodName);
		waitForPageLoad(driver);
		//assertTrue(selectValueFromAjaxList(driver,ajxLocation,bookingAssistTestData.location),"Could not select location"+bookingAssistTestData.toString(),driver,ClassName,MethodName);
		System.out.println("Location = " +  bookingAssistTestData.location);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
				
		Thread.sleep(12000);
				
						
		//--------------------------------------------------------------------//
		//  Step-4: Click on a Appointment at available Timeslot
		//--------------------------------------------------------------------//
				
		WebElement mnuElement2 = driver.findElement(By.xpath(lnkAppointment));
		Actions builder2 = new Actions(driver);					
		builder2.moveToElement(mnuElement2).click().build().perform();
						
		waitForPageLoad(driver);
		waitForPageLoad(driver);
				
				
		//--------------------------------------------------------------------//
		//  Step-5: Search for a Patient and Book a Visit					  //
		//--------------------------------------------------------------------//
				
		waitForPageLoad(driver);
		assertTrue(searchPatientForBookingVisitWD(driver, bookingAssistTestData.patientName),"Search Patient Failed",driver, ClassName, MethodName);
		waitForPageLoad(driver);		
		waitForPageLoad(driver);
		assertTrue(bookVisitWebDriver(driver, bookingAssistTestData),"Book Visit for a Patient Failed",driver, ClassName, MethodName);
		waitForPageLoad(driver);	
				*/
		//--------------------------------------------------------------------//
		//  Step-6: Verify the added patient at the Calendar View 			  //
		//--------------------------------------------------------------------//
				
		assertTrue(click(driver,lnkOperationsCalender),"Could not click operations Calender link", driver, ClassName,MethodName);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		Thread.sleep(12000);
				
				
		assertTrue(selectValueFromAjaxList(driver,txtSearchResources,bookingAssistTestData.searchResource),"Could not select searched Resource"+bookingAssistTestData.toString(), driver, ClassName,MethodName);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		
		assertTrue(clickLinkText(driver,lnkAddResource),"Could not click the Link - Add Resource to this view", driver, ClassName,MethodName);
		
		OperationsTestLib bookingAssistTestData2 = new  OperationsTestLib();
		bookingAssistTestData2.workSheetName = "SearchBookingAssistant";
		bookingAssistTestData2.testCaseId = "TC_SBA_018";
		bookingAssistTestData2.fetchSchedulingSettingsTestData();
		
		//assertTrue(selectValueFromAjaxList(driver,txtAddResources,bookingAssistTestData2.searchResource),"Could not select searched Resource"+bookingAssistTestData2.toString(), driver, ClassName,MethodName);
		assertTrue(type(driver,txtAddResources,bookingAssistTestData2.searchResource),"Could not select searched Resource"+bookingAssistTestData2.toString(), driver, ClassName,MethodName);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		
		assertTrue(click(driver,chkProviderCheckbox),"Could not click on Provider CheckBox", driver, ClassName,MethodName);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		
		assertTrue(clickLinkText(driver,"Add"),"Could not click on ADD button", driver, ClassName,MethodName);		
				
		assertTrue(isTextPresent(driver,bookingAssistTestData.patientName),"Could not find the added patient at the Calendar View", driver, ClassName,MethodName);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		
		WebElement element = driver.findElement(By.cssSelector("div.dragdrop-handle"));
		WebElement target = driver.findElement(By.id("x0y171"));
					
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(element).moveToElement(target).release(target).build();
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		dragAndDrop.perform();
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		
	}			
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + bookingAssistTestData.toString(), driver, ClassName,MethodName);
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