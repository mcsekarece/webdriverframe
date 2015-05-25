package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceGroups;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForResourceGroups extends AbstractSchedulingTest {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib resourceGroup = new SchedulingTestLib();
		resourceGroup.workSheetName = "VerifySecurityOption";
		resourceGroup.testCaseId = "TC_VSP_001";
		resourceGroup.fetchSchedulingTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceGroup);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib resourceGroup = new SchedulingTestLib();
		resourceGroup.workSheetName = "VerifySecurityOption";
		resourceGroup.testCaseId = "TC_VSP_002";
		resourceGroup.fetchSchedulingTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceGroup);
				
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib resourceGroup = new SchedulingTestLib();
		resourceGroup.workSheetName = "VerifySecurityOption";
		resourceGroup.testCaseId = "TC_VSP_003";
		resourceGroup.fetchSchedulingTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceGroup);
		
		}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib resourceGroup = new SchedulingTestLib();
		resourceGroup.workSheetName = "VerifySecurityOption";
		resourceGroup.testCaseId = "TC_VSP_004";
		resourceGroup.fetchSchedulingTestData();		

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceGroup);
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
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib resourceGroup) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + resourceGroup.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, resourceGroup.userName, resourceGroup.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role //
			//--------------------------------------------------------------------//
					
			assertTrue(switchRole(selenium,resourceGroup.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
									
			//No Access User Role	
			if(resourceGroup.testCaseId.equals("TC_VSP_003")){
				
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
			//  Step-3:Navigate to Scheduling section							  //
			//--------------------------------------------------------------------//
			
			if(!resourceGroup.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(goToScheduling(selenium),"", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				
				assertTrue(click(selenium, lnkResourceGroup), "could not able to click the Non Provider Resource link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(selenium.isTextPresent("Resource Groups "),"Resource Groups Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				
			}
								
			//--------------------------------------------------------------------//
			//  Step-4: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,resourceGroup)){
				Assert.fail("Security option not show properly; More Details :"+ resourceGroup.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SchedulingTestLib resourceGroup) throws IOException{
		boolean returnValue=true;
					
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
		String uniqueName=DateFormat.format(cal.getTime());
		
		//Limited Access User Role
		if(resourceGroup.testCaseId.equals("TC_VSP_001")){
			
			resourceGroup.workSheetName = "ResourceGroup";
			resourceGroup.testCaseId = "TC_RG_001";
			resourceGroup.fetchSchedulingTestData();
			
			assertTrue(click(selenium, btnAddResourceGroup), "could not able to click Add New button for Resource Group", selenium, ClassName, MethodName);
						
			assertTrue(createaddNewResourceGroups(selenium,resourceGroup,uniqueName),"Could not create a New Resource Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Delete button should be hidden
			assertTrue(!selenium.isElementPresent(btnDelete), "Delete Button is visible", selenium, ClassName, MethodName);
			
			// Edit button should be Visible
			assertTrue(selenium.isElementPresent(btnEdit), "Edit Button is not visible", selenium, ClassName, MethodName);
		}
		
		//View Only User Role
		if(resourceGroup.testCaseId.equals("TC_VSP_002")){
			
			// Add Button should not be Visible			
			assertTrue(!selenium.isVisible(btnAddResourceGroup), "Add Button is visible", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			// Edit Button should not visible
			assertTrue(!selenium.isTextPresent("Edit"), "Edit Button is visible", selenium, ClassName, MethodName);
			// Deleted Button Should not be Visible
			assertTrue(!selenium.isTextPresent("Delete"), "Delete Button is visible", selenium, ClassName, MethodName);
			
		}
		
		//Full Access Only User Role
		if(resourceGroup.testCaseId.equals("TC_VSP_004")){
			
						
			assertTrue(deleteAllResourceGroups(selenium,resourceGroup),"Could not delete All Resource Groups", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			resourceGroup.workSheetName = "ResourceGroup";
			resourceGroup.testCaseId = "TC_RG_001";
			resourceGroup.fetchSchedulingTestData();
					
			assertTrue(click(selenium, btnAddResourceGroup), "could not able to click Add New button for Resource Group", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Create New Resource	Group								         //
			//--------------------------------------------------------------------//
			
			
			assertTrue(createaddNewResourceGroups(selenium,resourceGroup,uniqueName),"Could not create a New Resource Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Delete Button should be Visible			
			assertTrue(selenium.isVisible(btnDelete), "Delete Button is not visible", selenium, ClassName, MethodName);		
			
		}
		return returnValue;
	}
	
}