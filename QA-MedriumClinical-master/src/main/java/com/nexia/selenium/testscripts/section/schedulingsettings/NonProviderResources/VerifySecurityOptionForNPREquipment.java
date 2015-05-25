package com.nexia.selenium.testscripts.section.schedulingsettings.NonProviderResources;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForNPREquipment extends AbstractSchedulingTest  {
	
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProviderEq = new SchedulingTestLib();
		nonProviderEq.workSheetName = "VerifySecurityOption";
		nonProviderEq.testCaseId = "TC_VSP_001";
		nonProviderEq.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProviderEq);
	} 

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProviderEq = new SchedulingTestLib();
		nonProviderEq.workSheetName = "VerifySecurityOption";
		nonProviderEq.testCaseId = "TC_VSP_002";
		nonProviderEq.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProviderEq);
	} 
	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProviderEq = new SchedulingTestLib();
		nonProviderEq.workSheetName = "VerifySecurityOption";
		nonProviderEq.testCaseId = "TC_VSP_003";
		nonProviderEq.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProviderEq);
	}

	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProviderEq = new SchedulingTestLib();
		nonProviderEq.workSheetName = "VerifySecurityOption";
		nonProviderEq.testCaseId = "TC_VSP_004";
		nonProviderEq.fetchSchedulingTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProviderEq);
	}

	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    June 25, 2013
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib nonProviderEq) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + nonProviderEq.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, nonProviderEq.userName, nonProviderEq.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role //
			//--------------------------------------------------------------------//
					
			assertTrue(switchRole(selenium,nonProviderEq.switchRole),"Switch Role Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			//No Access User Role	
			if(nonProviderEq.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(click(selenium,lnkQuickAction),"Could not click the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				
				assertTrue(!selenium.isTextPresent("System Settings"),"Text Not Present",selenium, ClassName, MethodName);
				if(!selenium.isTextPresent("Calendar Settings")){
					return true;
				}
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate to Non Provider Resource (equipment)			  //
			//--------------------------------------------------------------------//
		
			
			if(!nonProviderEq.testCaseId.equals("TC_VSP_003")){
			
				assertTrue(navigateToNonProviderResource(selenium),"Could not navigate to non provider resource Equipment", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium, lnkNonProviderResourceEquipment), "could not able to click the NPR Equipment link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(selenium.isTextPresent("Non-Provider Resources"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Equipment"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
			
			}
								
			//--------------------------------------------------------------------//
			//  Step-4: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,nonProviderEq)){
				Assert.fail("Security option not show properly; More Details :"+ nonProviderEq.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SchedulingTestLib nonProviderEq) throws IOException{
		boolean returnValue=true;
					
				
		//Limited Access User Role
		if(nonProviderEq.testCaseId.equals("TC_VSP_001")){
			
			nonProviderEq.workSheetName = "NonProviderResource";
			nonProviderEq.testCaseId = "TC_NP_004";
			nonProviderEq.fetchSchedulingTestData();
			
			//--------------------------------------------------------------------//
			//  Step-5:Create New Non Provider Resource	Equipment				  //
			//--------------------------------------------------------------------//
							
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource",selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createNewNonProviderResourceRoom(selenium,nonProviderEq,uniqueName),"Could not create a non provider resource room",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			// Delete button should be hidden
			assertTrue(!selenium.isElementPresent(lnkDeleteNonProviderResource), "Delete Button is visible", selenium, ClassName, MethodName);
			
			// Edit button should be Visible
			assertTrue(selenium.isElementPresent(btnEdit), "Edit Button is not visible", selenium, ClassName, MethodName);
			
		}
		
		//View Only User Role
		if(nonProviderEq.testCaseId.equals("TC_VSP_002")){
			// Add Button should not be Visible
			assertTrue(!selenium.isVisible(btnAddNonProviderResource), "Add Button is visible", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			// Edit Button should not visible
			assertTrue(!selenium.isTextPresent("Edit"), "Edit Button is visible", selenium, ClassName, MethodName);
			// Deleted Button Should not be Visible
			assertTrue(!selenium.isTextPresent("Delete"), "Delete Button is visible", selenium, ClassName, MethodName);
			
		}
		
		//Full Access Only User Role
		if(nonProviderEq.testCaseId.equals("TC_VSP_004")){
				
			
			nonProviderEq.workSheetName = "NonProviderResource";
			nonProviderEq.testCaseId = "TC_NP_004";
			nonProviderEq.fetchSchedulingTestData();
			
			//--------------------------------------------------------------------//
			//  Step-5:Create New Non Provider Resource	Equipment				  //
			//--------------------------------------------------------------------//
							
			assertTrue(deleteAllNonProviderResource(selenium,nonProviderEq),"Could not delete All Non Provider Resource Room",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource",selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createNewNonProviderResourceRoom(selenium,nonProviderEq,uniqueName),"Could not create a non provider resource room",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
							
			assertTrue(selenium.isVisible(lnkDeleteNonProviderResource), "Delete Button is not visible", selenium, ClassName, MethodName);			
			
		}
		
		return returnValue;
	}
}