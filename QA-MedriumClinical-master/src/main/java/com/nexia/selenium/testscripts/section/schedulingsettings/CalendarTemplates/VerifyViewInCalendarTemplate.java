package com.nexia.selenium.testscripts.section.schedulingsettings.CalendarTemplates;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyViewInCalendarTemplate extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying View Details In Calender Template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyViewInCalendarTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib calendarTemplate = new SchedulingTestLib();
		calendarTemplate.workSheetName = "CalendarTemplate";
		calendarTemplate.testCaseId = "TC_CT_001";
		calendarTemplate.fetchSchedulingTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyViewInCalendarTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, calendarTemplate);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verifying View Details In Calendar Template
	* @action 		  verifying View Details In Calendar Template
	* @expected       To Ensure that the View Details In calendar Template functionality to working fine    
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      June 17, 2013
	***************************************************************************************************/
	public boolean verifyViewInCalendarTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib calendarTemplate) throws Exception{
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
			//  Step-4:Delete All Calendar Template							      //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllCalendarTemplate(selenium,calendarTemplate),"Could not delete All calendar template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Create New Calendar Template							      //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			
			
			assertTrue(createNewCalendarTemplate(selenium,calendarTemplate,uniqueName),"Could not navigate to calendar template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Verify Stored Values For Calendar Template				  //
			//--------------------------------------------------------------------//
			assertTrue(verfyStoredValuesForCalendarTemplate(selenium,calendarTemplate),"Could not verify the created calendar template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Verify View Details Values In Calendar Template				  //
			//--------------------------------------------------------------------//
			assertTrue(verfyViewDetailsStoredValuesForCalendarTemplate(selenium,calendarTemplate),"Could not verify the created calendar template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}