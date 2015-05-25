package com.nexia.selenium.testscripts.section.schedulingsettings.CalendarTemplates;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchCalendarTemplate extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Search New Calender Template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchCalenderTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib calendarTemplate = new SchedulingTestLib();
		calendarTemplate.workSheetName = "CalendarTemplate";
		calendarTemplate.testCaseId = "TC_CT_001";
		calendarTemplate.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchCalenderTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, calendarTemplate);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verifying Search Calendar Template
	* @action 		  verifying Search Calendar Template
	* @expected       To Ensure that the Search calendar functionality to working fine    
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      June 12, 2013
	***************************************************************************************************/
	public boolean searchCalenderTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib calendarTemplate) throws Exception{
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
			//  Step-4:Delete All Calendar Template							  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllCalendarTemplate(selenium,calendarTemplate),"Could not delete All calendar template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Create New Calendar Template							  //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(createNewCalendarTemplate(selenium,calendarTemplate,uniqueName),"Could not navigate to calendar template", selenium, ClassName, MethodName);
			String oldCalendarTemplate=calendarTemplate.templateName;
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Verify Stored Values For Calendar Template							  //
			//--------------------------------------------------------------------//
			assertTrue(verfyStoredValuesForCalendarTemplate(selenium,calendarTemplate),"Could not navigate to calendar template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Create another New Calendar Template							  //
			//--------------------------------------------------------------------//
			calendarTemplate.testCaseId = "TC_CT_003";
			calendarTemplate.fetchSchedulingTestData();
			
			
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName1=DateFormat1.format(cal1.getTime());
			waitForPageLoad(selenium);
			
			
			assertTrue(createNewCalendarTemplate(selenium,calendarTemplate,uniqueName1),"Could not navigate to calendar template", selenium, ClassName, MethodName);
			String newCalendarTemplate=calendarTemplate.templateName;
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify Stored Values For Calendar Template							  //
			//--------------------------------------------------------------------//
			assertTrue(verfyStoredValuesForCalendarTemplate(selenium,calendarTemplate),"Could not navigate to calendar template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify search feature in Calendar Template				  //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium, txtSearchCalendarTemplate, calendarTemplate.templateName), "Could not type the template name", selenium, ClassName, MethodName);
			selenium.fireEvent(txtSearchCalendarTemplate,"keydown");
			selenium.fireEvent(txtSearchCalendarTemplate,"keypress");                           
			selenium.fireEvent(txtSearchCalendarTemplate,"keyup");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify Serch result For Calendar Template				//
			//--------------------------------------------------------------------//
			assertTrue(verfySearchResultForCalendarTemplate(selenium,newCalendarTemplate, oldCalendarTemplate),"Could not navigate to calendar template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
