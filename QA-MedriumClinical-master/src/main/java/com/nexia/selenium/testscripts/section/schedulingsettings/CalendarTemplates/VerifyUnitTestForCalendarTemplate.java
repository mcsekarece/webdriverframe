package com.nexia.selenium.testscripts.section.schedulingsettings.CalendarTemplates;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingUnitTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnitTestForCalendarTemplate extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Unit test in Calender Template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUnitTestForCalendarTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib calendarTemplate = new SchedulingUnitTestLib();
		calendarTemplate.workSheetName = "UnitTest_CalendarTemplate";
		calendarTemplate.testCaseId = "TC_CT_001";
		calendarTemplate.fetchSchedulingSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyUnitTestForCalendarTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, calendarTemplate);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verifying Unit test in Calendar Template
	* @action 		  verifying Unit test in Calendar Template
	* @expected       To Ensure that the Unit test in calendar to working fine    
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      June 14, 2013
	***************************************************************************************************/
	public boolean verifyUnitTestForCalendarTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingUnitTestLib calendarTemplate) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + calendarTemplate.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, calendarTemplate.userName, calendarTemplate.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,calendarTemplate.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Calendar Template							  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToCalendarTemplate(selenium),"Could not navigate to calendar template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Create New Calendar Template							  //
			//--------------------------------------------------------------------//
			assertTrue(createNewCalendarTemplateUnitTest(selenium,calendarTemplate),"Could not navigate to calendar template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Verify Unit Test Functionality For Calendar Template		  //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium, calendarTemplate.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, calendarTemplate.validationFieldID).contains(calendarTemplate.validationMessage), "The expected validation message should contain the text - "+ calendarTemplate.validationMessage + " The actual validation message shown - " + getText(selenium, calendarTemplate.validationFieldID), selenium, ClassName, MethodName);
				
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
