package com.nexia.selenium.testscripts.section.schedulingsettings.NonProviderResources;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityForNPRRooms extends AbstractSchedulingTest {
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
	public boolean verifySecurity(Selenium selenium,SchedulingTestLib nonProvider,SystemSettingsLib userRoleData, String userAccount) throws IOException{
		boolean returnValue=true;
		
		//Full Access Permission	
		if(userRoleData.nonProviderResources.contains("Full Access")){
		    	assertTrue(navigateToNonProviderResource(selenium),"Could not navigate to non provider resource Equipment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkNonProviderResource), "could not able to click the Non Provider Resource link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    	nonProvider.workSheetName = "NonProviderResource";
			nonProvider.testCaseId = "TC_NP_001";
			nonProvider.fetchSchedulingTestData();
			
			//--------------------------------------------------------------------//
			//  Create New Non Provider Resource Room					          //
			//--------------------------------------------------------------------//
							
			assertTrue(deleteAllNonProviderResource(selenium,nonProvider),"Could not delete All Non Provider Resource Room",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource",selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createNewNonProviderResourceRoom(selenium,nonProvider,uniqueName),"Could not create a non provider resource room",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Delete Button should be visible
			assertTrue(selenium.isVisible(lnkDeleteNonProviderResource), "Delete Button is not visible", selenium, ClassName, MethodName);
		}
	
		//View Only Access Permission
		if(userRoleData.nonProviderResources.contains("View Only")){
		    	assertTrue(navigateToNonProviderResource(selenium),"Could not navigate to non provider resource Equipment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkNonProviderResource), "could not able to click the Non Provider Resource link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    	// Add Button should not Visible
			assertTrue(!selenium.isVisible(btnAddNonProviderResource), "Add Button is visible", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			// Edit Button should not visible
			assertTrue(!selenium.isTextPresent("Edit"), "Edit Button is visible", selenium, ClassName, MethodName);
			// Deleted Button Should not be Visible
			assertTrue(!selenium.isTextPresent("Delete"), "Delete Button is visible", selenium, ClassName, MethodName); 
		}
		 
		//Limited Access Permission
		if(userRoleData.nonProviderResources.contains("Limited Access")){
		    	assertTrue(navigateToNonProviderResource(selenium),"Could not navigate to non provider resource Equipment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkNonProviderResource), "could not able to click the Non Provider Resource link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    	nonProvider.workSheetName = "NonProviderResource";
			nonProvider.testCaseId = "TC_NP_001";
			nonProvider.fetchSchedulingTestData();
			//--------------------------------------------------------------------//
			//  Create New Non Provider Resource Room					        //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource",selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createNewNonProviderResourceRoom(selenium,nonProvider,uniqueName),"Could not create a non provider resource room",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Delete button should be hidden
			assertTrue(!selenium.isElementPresent(lnkDeleteNonProviderResource), "Delete Button is visible", selenium, ClassName, MethodName);
						
			// Edit button should be Visible
			assertTrue(selenium.isElementPresent(btnEdit), "Edit Button is not visible", selenium, ClassName, MethodName);		
		}
		
		//No Access Permission
		if(userRoleData.nonProviderResources.contains("No Access")){
		    assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"css=#schedulingSettingsAction > span.actionItemSpan"), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!schedulingSettingsNonProviderResourcesRoomsList"), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblHeader).contains("Non-Provider Resources Rooms")){
			    returnValue= false;
			 }else
			    return returnValue;
		}
		
		return returnValue;
	}

}


