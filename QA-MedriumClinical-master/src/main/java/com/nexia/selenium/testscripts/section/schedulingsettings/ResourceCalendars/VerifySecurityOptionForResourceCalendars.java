package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceCalendars;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForResourceCalendars extends AbstractSchedulingTest {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProblemListWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();SchedulingTestLib ResourceCalData = new SchedulingTestLib();
		ResourceCalData.workSheetName = "VerifySecurityOption";
		ResourceCalData.testCaseId = "TC_VSP_001";
		ResourceCalData.fetchSchedulingTestData();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, ResourceCalData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With View Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProblemListWithViewOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib ResourceCalData = new SchedulingTestLib();
		ResourceCalData.workSheetName = "VerifySecurityOption";
		ResourceCalData.testCaseId = "TC_VSP_002";
		ResourceCalData.fetchSchedulingTestData();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, ResourceCalData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProblemListWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib ResourceCalData = new SchedulingTestLib();
		ResourceCalData.workSheetName = "VerifySecurityOption";
		ResourceCalData.testCaseId = "TC_VSP_003";
		ResourceCalData.fetchSchedulingTestData();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, ResourceCalData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProblemListWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib ResourceCalData = new SchedulingTestLib();
		ResourceCalData.workSheetName = "VerifySecurityOption";
		ResourceCalData.testCaseId = "TC_VSP_004";
		ResourceCalData.fetchSchedulingTestData();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, ResourceCalData);
	}
	/**
	 * verifySecurity
	 * function to verify Security
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Jun 10, 2013
	 */

	public boolean verifySecurity(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib ResourceCalData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ResourceCalData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, ResourceCalData.userName, ResourceCalData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch Role//
			//--------------------------------------------------------------------//
		
			
			assertTrue(switchRole(selenium,ResourceCalData.switchRole),"Could not change the switch role;More Details:"+ResourceCalData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//No Access User Role	
			if(ResourceCalData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(click(selenium,lnkQuickAction),"Could not click the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(!selenium.isTextPresent("System Settings"),"Text Not Present",selenium, ClassName, MethodName);
				if(!selenium.isTextPresent("Calendar Settings")){
					return true;
				}
			}
						
			//--------------------------------------------------------------------//
			//  Step-3:Navigate to Resource Calendar							  //
			//--------------------------------------------------------------------//
		
			if(!ResourceCalData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(goToScheduling(selenium),"Could not click the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,lnkResourceCalender),"Could not click Resource Calender link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(selenium.isTextPresent("Resource Calendars"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
			}
			
			
				
			//-----------------------------------------//
			//  Step-4: Verify Security//
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,ResourceCalData,userAccount)){
				fail("Security for" +ResourceCalData.switchRole+ "is not proper:"+ ResourceCalData.toString());
			}else
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ResourceCalData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium, SchedulingTestLib ResourceCalData,String userAccount) throws IOException{
		boolean returnValue=true;
		
		//Limited Access
		if(ResourceCalData.testCaseId.equals("TC_VSP_001")){
			ResourceCalData.workSheetName = "CreateResourceCalender";
			ResourceCalData.testCaseId = "TC_CRC_002";
			ResourceCalData.fetchSchedulingTestData();
			
			assertTrue(click(selenium,chkIncludeInactiveCheckbox),"Could not click IncludeInactiveCheckbox", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 			 
			 assertTrue(selectValueFromAjaxList(selenium,txtSearchResourceCal,ResourceCalData.search),"Could not select search resource"+ResourceCalData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 selenium.typeKeys(txtSearchResourceCal, "a");
			 waitForPageLoad(selenium);
			 
			 if(getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")).trim().contains(ResourceCalData.resource.trim().toLowerCase(new java.util.Locale("en","US")))){
				  if (selenium.isTextPresent("Activate"))					  
				  {				  
				  assertTrue(click(selenium,btnActivate),"Could not click Activate button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  assertTrue(click(selenium,btnYesButton),"Could not click Yes button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  
				  }
				  assertTrue(click(selenium,btnEdit),"Could not click Edit button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);			 			 
			  }		
			  else 
			  {  
				assertTrue(click(selenium,btnAdd),"Could not click add new button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			  }
			
			assertTrue(createResourceCalenderWithMandatoryFields(selenium, ResourceCalData,userAccount), "Create Resource Calender With Mandatory Fields failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			// Deleted Button Should not be Visible
			assertTrue(!selenium.isTextPresent("Delete"), "Delete Button is visible", selenium, ClassName, MethodName);
									
			// Edit Button Should be Visible
			assertTrue(selenium.isTextPresent("Edit"), "Edit Button is not visible", selenium, ClassName, MethodName);		
			
		}
		
		//View Only
		if(ResourceCalData.testCaseId.equals("TC_VSP_002")){
			
			// Add New Button Should not be Visible
			assertTrue(!selenium.isTextPresent("Add New"), "Add New is visible", selenium, ClassName, MethodName);
			// Edit Button should not visible
			assertTrue(!selenium.isTextPresent("Edit"), "Edit Button is visible", selenium, ClassName, MethodName);
			// Deleted Button Should not be Visible
			assertTrue(!selenium.isTextPresent("Delete"), "Delete Button is visible", selenium, ClassName, MethodName);
					
		}
						
		//Full Access
		if(ResourceCalData.testCaseId.equals("TC_VSP_004")){
			
			ResourceCalData.workSheetName = "CreateResourceCalender";
			ResourceCalData.testCaseId = "TC_CRC_001";
			ResourceCalData.fetchSchedulingTestData();
			
			assertTrue(deleteAllResourceCalendar(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			assertTrue(click(selenium,chkIncludeInactiveCheckbox),"Could not click IncludeInactiveCheckbox", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 			 
			 assertTrue(selectValueFromAjaxList(selenium,txtSearchResourceCal,ResourceCalData.search),"Could not select search resource"+ResourceCalData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 selenium.typeKeys(txtSearchResourceCal, "a");
			 waitForPageLoad(selenium);
			 	
			 if(getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")).trim().contains(ResourceCalData.resource.trim().toLowerCase(new java.util.Locale("en","US")))){
				  if (selenium.isTextPresent("Activate"))					  
				  {				  
				  assertTrue(click(selenium,btnActivate),"Could not click Activate button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  assertTrue(click(selenium,btnYesButton),"Could not click Yes button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  
				  }
				  assertTrue(click(selenium,btnEdit),"Could not click Edit button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);			 			 
			  }		
			  else 
			  {  
				assertTrue(click(selenium,btnAdd),"Could not click add new button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			  }
			
			assertTrue(createResourceCalenderWithMandatoryFields(selenium, ResourceCalData,userAccount), "Create Resource Calender With Mandatory Fields failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			// Deleted Button Should be Visible
			assertTrue(selenium.isTextPresent("Delete"), "Delete Button is not visible", selenium, ClassName, MethodName);
									
			// Edit Button Should be Visible
			assertTrue(selenium.isTextPresent("Edit"), "Edit Button is not visible", selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}
}
