package com.nexia.selenium.testscripts.section.operations.CheckinAssistant;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPatientInfoInCheckInAssistWD extends AbstractOperationsTest{
	WebDriver driver = null;
	@Test(groups = {"SmokeCalendarUIWD","firefox", "iexplore", "safari", "default" }, description = "verifyPatientInfoInCheckInAssist", priority=5)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientInfoInCheckInAssist(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib checkInAssistTestData = new  OperationsTestLib();
		checkInAssistTestData.workSheetName = "VerifyCheckInAssistant";
		checkInAssistTestData.testCaseId = "TC_VCA_001";
		checkInAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkInAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,checkInAssistTestData);
	}
	
	@Test(groups = {"CalendarUIWD","firefox", "iexplore", "safari", "default" }, description = "verifyPatientInfoInCheckInAssist", priority=6)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientInfoInCheckInAssistNewProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib checkInAssistTestData = new  OperationsTestLib();
		checkInAssistTestData.workSheetName = "VerifyCheckInAssistant";
		checkInAssistTestData.testCaseId = "TC_VCA_003";
		checkInAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkInAssistant(seleniumHost, seleniumPort, browser, webSite, userAccount,checkInAssistTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Patient Info in Patient CheckIn Assistant (WebDriver)
	* @action 		  verifying Patient Info in Patient CheckIn Assistant
	* @author         Jagmit
	 * @throws IOException 
	 * @throws InterruptedException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      August 1, 2014
	***************************************************************************************************/
	public boolean checkInAssistant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib checkInAssistTestData) throws IOException, InterruptedException{
		Selenium selenium = null;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application								  //
			//--------------------------------------------------------------------//		
			driver = getWebdriver(seleniumHost, seleniumPort, browser, webSite, ClassName, MethodName, driver);		
			assertTrue(loginForNexiaForWebdriver(driver, userAccount,checkInAssistTestData.userName, checkInAssistTestData.userPassword),"Login Failed ",driver, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Checking Assistant							  //
			//--------------------------------------------------------------------//
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			assertTrue(goToOperations(driver),"Could not click the Operations link",driver,ClassName,MethodName);
			waitForPageLoad(driver);	
			assertTrue(click(driver,lnkCheckInAssistant),"Could not click on Checking Assistant Link", driver, ClassName, MethodName);
			waitForPageLoad(driver);
						
			
			//--------------------------------------------------------------------//
			//  Step-3: Select the patient in the CheckIn Assistant //
			//--------------------------------------------------------------------//
				
			assertTrue(selectValueFromAjaxList(driver,ajxResourceList,checkInAssistTestData.resource),"Could not select Visit type"+checkInAssistTestData.toString(), driver, ClassName, MethodName);
			waitForPageLoad(driver);
			Thread.sleep(10000);
			
			/*assertTrue(selectValueFromAjaxList(driver,ajxLocationList,checkInAssistTestData.location),"Could not select Visit type"+checkInAssistTestData.toString(), driver, ClassName, MethodName);
			waitForPageLoad(driver);
			Thread.sleep(10000);*/
			
			assertTrue(click(driver,btnRefreshButton),"Could not click on Refresh Button", driver, ClassName, MethodName);
			waitForPageLoad(driver);
			
			assertTrue(click(driver,lnkCheckInAssistantList),"Could not click on the Appointment List", driver, ClassName, MethodName);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			
			assertTrue(click(driver,btnNextButton),"Could not click on Next Button", driver, ClassName, MethodName);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			
			assertTrue(click(driver,btnNextButton),"Could not click on Next Button", driver, ClassName, MethodName);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			
			assertTrue(click(driver,btnDoneButton),"Could not click on Done Button", driver, ClassName, MethodName);
			waitForPageLoad(driver);
			Thread.sleep(10000);
			
			//--------------------------------------------------------------------//
			//  Step-4: Checkout the Patient						  			 //
			//--------------------------------------------------------------------//
			
			assertTrue(click(driver,btnRefreshButton),"Could not click on Refresh Button", driver, ClassName, MethodName);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			
			assertTrue(clickClassName(driver,lnkCheckInAppointmentCell),"Could not click on the CheckIn AppointmentCell", driver, ClassName, MethodName);
			waitForPageLoad(driver);
			
			assertTrue(type(driver,txtCheckInTime,checkInAssistTestData.startMin),"Could not enter Start Minutes ", driver, ClassName, MethodName);
			waitForPageLoad(driver);
			
			assertTrue(type(driver,txtCheckOutTime,checkInAssistTestData.endMin),"Could not enter End Minutes", driver, ClassName, MethodName);
			waitForPageLoad(driver);
			
			assertTrue(clickLinkText(driver,"Save"),"Could not click on the Save Button", driver, ClassName, MethodName);
			waitForPageLoad(driver);
			
			/*if(isElementPresent(selenium,"checkInWizard_NextButton")){
				return true;
			}*/
			
		}			
		catch (RuntimeException e){
			
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		return true;
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
