package com.nexia.selenium.testscripts.section.schedulingsettings.CalendarTemplates;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForCalendarTemplates extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib calendarTemplate = new SchedulingTestLib();
		calendarTemplate.workSheetName = "VerifySecurityOption";
		calendarTemplate.testCaseId = "TC_VSP_001";
		calendarTemplate.fetchSchedulingTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, calendarTemplate);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib calendarTemplate = new SchedulingTestLib();
		calendarTemplate.workSheetName = "VerifySecurityOption";
		calendarTemplate.testCaseId = "TC_VSP_002";
		calendarTemplate.fetchSchedulingTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, calendarTemplate);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib calendarTemplate = new SchedulingTestLib();
		calendarTemplate.workSheetName = "VerifySecurityOption";
		calendarTemplate.testCaseId = "TC_VSP_003";
		calendarTemplate.fetchSchedulingTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOptionForNoAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, calendarTemplate);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib calendarTemplate = new SchedulingTestLib();
		calendarTemplate.workSheetName = "VerifySecurityOption";
		calendarTemplate.testCaseId = "TC_VSP_004";
		calendarTemplate.fetchSchedulingTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, calendarTemplate);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Calendar Template
	* @action 		  verifying Security Option For Calendar Template
	* @expected       To Ensure that security option works fine for calendar template     
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      June 20, 2013
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib calendarTemplate) throws IOException{
		Selenium selenium=null;
		String ClassName = null;
		ClassName=this.getClass().getName().substring(39);
		String MethodName = null;
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + calendarTemplate.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, calendarTemplate.userName, calendarTemplate.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,calendarTemplate.switchRole),"Could not change the switch role;More Details:"+calendarTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Calendar Template							  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToCalendarTemplate(selenium),"Could not navigate to calendar template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify security option //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,calendarTemplate, userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ calendarTemplate.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SchedulingTestLib calendarTemplate, String userAccount) throws IOException{
		boolean returnValue=true;
		
		// Limited Access
		if(calendarTemplate.testCaseId.equals("TC_VSP_001")){
			
			calendarTemplate.workSheetName = "CalendarTemplate";
			calendarTemplate.testCaseId = "TC_CT_001";
			calendarTemplate.fetchSchedulingTestData();
			
			// Create New Calender Template
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(createNewCalendarTemplate(selenium,calendarTemplate,uniqueName),"Could not navigate to calendar template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
			// Deleted Button Should not be Visible
			assertTrue(!selenium.isTextPresent("Delete"), "Delete Button is visible", selenium, ClassName, MethodName);
						
			// Edit Button Should be Visible
			assertTrue(selenium.isTextPresent("Edit"), "Edit Button is not visible", selenium, ClassName, MethodName);
			
		}
		// View Only Access
		if(calendarTemplate.testCaseId.equals("TC_VSP_002")){
			
		// Add Button Should not be Visible
		assertTrue(!selenium.isVisible(btnAddNewCalendarTemplate), "Add Button is visible", selenium, ClassName, MethodName);
		// Edit Button should not visible
		assertTrue(!selenium.isTextPresent("Edit"), "Edit Button is visible", selenium, ClassName, MethodName);
		// Deleted Button Should not be Visible
		assertTrue(!selenium.isTextPresent("Delete"), "Delete Button is visible", selenium, ClassName, MethodName);
			
		}
		
		// Full Access
		if(calendarTemplate.testCaseId.equals("TC_VSP_004")){
			
			calendarTemplate.workSheetName = "CalendarTemplate";
			calendarTemplate.testCaseId = "TC_CT_001";
			calendarTemplate.fetchSchedulingTestData();
			
			assertTrue(deleteAllCalendarTemplate(selenium,calendarTemplate),"Could not delete All calendar template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Create New Calender Template
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(createNewCalendarTemplate(selenium,calendarTemplate,uniqueName),"Could not navigate to calendar template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Deleted Button Should be Visible
			assertTrue(selenium.isVisible(lnkDeleteCalendarTemplate), "Delete Button is not visible", selenium, ClassName, MethodName);
			
			// Edit Button Should be Visible
			assertTrue(selenium.isVisible(btnEdit), "Edit Button is not visible", selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Calendar Template
	* @action 		  verifying Security Option For Calendar Template
	* @expected       To Ensure that security option works fine for calendar template     
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      June 20, 2013
	***************************************************************************************************/
	public boolean verifySecurityOptionForNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib calendarTemplate) throws IOException{
		Selenium selenium=null;
		String ClassName = null;
		ClassName=this.getClass().getName().substring(39);
		String MethodName = null;
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + calendarTemplate.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, calendarTemplate.userName, calendarTemplate.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,calendarTemplate.switchRole),"Could not change the switch role;More Details:"+calendarTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Quick Actions and looks for Calender Settings  //
			//--------------------------------------------------------------------//
						
			assertTrue(click(selenium,lnkQuickAction),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
			
			//assertTrue(selenium.isTextPresent("System Settings"),"Text Not Present",selenium, ClassName, MethodName);
			if(!selenium.isTextPresent("Calendar Settings")){
				return true;
			}
			
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
