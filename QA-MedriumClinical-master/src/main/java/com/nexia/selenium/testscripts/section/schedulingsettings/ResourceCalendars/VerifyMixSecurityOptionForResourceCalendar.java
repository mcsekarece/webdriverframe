package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceCalendars;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForResourceCalendar extends AbstractSchedulingTest {
    	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Mixed security role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
	
	SchedulingTestLib visitGroup = new SchedulingTestLib();
	visitGroup.workSheetName = "VerifySecurityOption";
	visitGroup.testCaseId = "TC_VSP_005";
	visitGroup.fetchSchedulingTestData();
	
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
	verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		IOException 
	 * @since  	   	Nov 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib cdsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cdsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cdsData.userName, cdsData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,cdsData.switchRole),"Could not change the switch role;More Details:"+cdsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_025";
			userRoleData.fetchSystemSettingTestData();
			
			if(userRoleData.calendarSettings.contains("No Access")){				
			    assertTrue(noAccessUserSchedulingSettings(selenium, cdsData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);				
			}			
			
			//--------------------------------------------------------------------//
			//  Step-4: Full, View Access User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.calendarSettings.contains("No Access")){
			    assertTrue(fullViewAccessUserSchedulingSettings(selenium, cdsData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;				
			    
			    if(!verifySecurity(selenium,cdsData, userRoleData, userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ cdsData.toString());
				returnValue= false;
			    }else
				returnValue=true;
			}			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SchedulingTestLib ResourceCalData,SystemSettingsLib userRoleData, String userAccount) throws IOException{
		boolean returnValue=true;
		
		//Full Access Permission	
		if(userRoleData.resourceCalendars.contains("Full Access")){
		    	assertTrue(click(selenium,lnkResourceCalender),"Could not click Resource Calender link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
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
	
		//View Only Access Permission
		if(userRoleData.resourceCalendars.contains("View Only")){
		    	assertTrue(click(selenium,lnkResourceCalender),"Could not click Resource Calender link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    	// Add New Button Should not be Visible
			assertTrue(!selenium.isTextPresent("Add New"), "Add New is visible", selenium, ClassName, MethodName);
			// Edit Button should not visible
			assertTrue(!selenium.isTextPresent("Edit"), "Edit Button is visible", selenium, ClassName, MethodName);
			// Deleted Button Should not be Visible
			assertTrue(!selenium.isTextPresent("Delete"), "Delete Button is visible", selenium, ClassName, MethodName);
		}
		 
		//Limited Access Permission
		if(userRoleData.resourceCalendars.contains("Limited Access")){
			String role=ResourceCalData.switchRole;
		    	assertTrue(click(selenium,lnkResourceCalender),"Could not click Resource Calender link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    	ResourceCalData.workSheetName = "CreateResourceCalender";
			ResourceCalData.testCaseId = "TC_CRC_002";
			ResourceCalData.fetchSchedulingTestData();
			
			if(!isChecked(selenium, chkIncludeInactiveCheckbox)){
				assertTrue(click(selenium,chkIncludeInactiveCheckbox),"Could not click IncludeInactiveCheckbox", selenium, ClassName, MethodName);
			 	waitForPageLoad(selenium);
			}
			 			 
			assertTrue (type(selenium,txtSearchResourceCal,ResourceCalData.search),"Could not select search resource"+ResourceCalData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 selenium.typeKeys(txtSearchResourceCal, "a");
			 waitForPageLoad(selenium);
			 
			 if(getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")).trim().contains(ResourceCalData.resource.trim().toLowerCase(new java.util.Locale("en","US")))){
				  if (selenium.isTextPresent("Activate"))					  
				  {		
					  //for limited access user 'activate' link should not be present. So, we switch to 'full' access user
					  assertTrue(switchRole(selenium,"FULL"),"Could not change the switch role;More Details:", selenium, ClassName, MethodName);
					  waitForPageLoad(selenium);
					  
					  assertTrue(click(selenium,lnkQuickAction),"Could not click on the link" + ResourceCalData .toString(), selenium, ClassName, MethodName);
		              waitForPageLoad(selenium);
		              assertTrue(click(selenium,lnkScheduling),"Could not click the systemSettings link;More Deatils:"+ResourceCalData.toString(), selenium, ClassName, MethodName);
		              waitForPageLoad(selenium);
		                
		              assertTrue(click(selenium,lnkResourceCalender),"Could not click Resource Calender link", selenium, ClassName, MethodName);
		  			  waitForPageLoad(selenium);
		  			 
		  			 if(!isChecked(selenium, chkIncludeInactiveCheckbox)){
						assertTrue(click(selenium,chkIncludeInactiveCheckbox),"Could not click IncludeInactiveCheckbox", selenium, ClassName, MethodName);
					 	waitForPageLoad(selenium);
					 }
		  			 
		  			assertTrue(type(selenium,txtSearchResourceCal,ResourceCalData.search),"Could not select search resource"+ResourceCalData.toString(), selenium, ClassName, MethodName);
					 waitForPageLoad(selenium);
					 
					 selenium.typeKeys(txtSearchResourceCal, "a");
					 waitForPageLoad(selenium);
					 
					 assertTrue(click(selenium,btnActivate),"Could not click Activate button", selenium, ClassName, MethodName);
					 waitForPageLoad(selenium);
					 assertTrue(click(selenium,btnYesButton),"Could not click Yes button", selenium, ClassName, MethodName);
					 waitForPageLoad(selenium);
					 
					 //After activating inactive user, switch back to particular role
					 assertTrue(switchRole(selenium,role),"Could not change the switch role;More Details:", selenium, ClassName, MethodName);
					  waitForPageLoad(selenium);
					  
					  assertTrue(click(selenium,lnkQuickAction),"Could not click on the link" + ResourceCalData .toString(), selenium, ClassName, MethodName);
		              waitForPageLoad(selenium);
		              assertTrue(click(selenium,lnkScheduling),"Could not click the systemSettings link;More Deatils:"+ResourceCalData.toString(), selenium, ClassName, MethodName);
		              waitForPageLoad(selenium);
		                
		              assertTrue(click(selenium,lnkResourceCalender),"Could not click Resource Calender link", selenium, ClassName, MethodName);
		  			  waitForPageLoad(selenium);
		  			 
		  			 assertTrue(type(selenium,txtSearchResourceCal,ResourceCalData.search),"Could not select search resource"+ResourceCalData.toString(), selenium, ClassName, MethodName);
					 waitForPageLoad(selenium);
					 
					 selenium.typeKeys(txtSearchResourceCal, "a");
					 waitForPageLoad(selenium);
					 
				  
				  }
				  assertTrue(click(selenium,btnEdit),"Could not click Edit button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
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
		
		//No Access Permission
		if(userRoleData.resourceCalendars.contains("No Access")){
		    assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"css=#schedulingSettingsAction > span.actionItemSpan"), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"!schedulingSettingsResourceCalendarsList"), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblHeader).contains("Resource Calendars")){
			    returnValue= false;
			 }else
			    return returnValue;
		}
		
		return returnValue;
	}

}

