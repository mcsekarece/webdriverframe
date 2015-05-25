
package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceGroups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class CreateResourceGroup extends AbstractSchedulingTest {
	
	@Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create New Resource Group")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewResourceGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib resourceGroup = new SchedulingTestLib();
		resourceGroup.workSheetName = "NonProviderResource";
		resourceGroup.testCaseId = "TC_NP_001c";
		resourceGroup.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createResourceGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceGroup);
		
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Uniqueness For Resource Group")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUniquenessForResourceGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib resourceGroup = new SchedulingTestLib();
		resourceGroup.workSheetName = "NonProviderResource";
		resourceGroup.testCaseId = "TC_NP_001d";
		resourceGroup.fetchSchedulingTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createResourceGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceGroup);
		
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Create New Resource Group
	* @action 		  verify Creating New Resource Group
	* @expected       To Ensure that the created Resource Group works fine    
	* @author         Jagmit
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      June 06, 2013
	***************************************************************************************************/
	
	public boolean createResourceGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib resourceGroup) throws Exception{
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
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,resourceGroup.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4:Navigate to Non Provider Resource Room		          //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkNonProviderResource), "could not able to click the Non Provider Resource link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-5:Delete All Existing Non Provider Resource Room		      //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(deleteAllNonProviderResource(selenium,resourceGroup),"Could not delete All Non Provider Resource Room", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Create New Non Provider Resource	Room					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource", selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(createNewNonProviderResourceRoom(selenium,resourceGroup,uniqueName),"Could not create a non provider resource room", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Verify Stored Values For Non Provider Resource Room			  //
			//--------------------------------------------------------------------//
			assertTrue(verfyStoredValuesForNonProviderResource(selenium,resourceGroup),"Non Provider Resource Room not created correctly", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Navigate to  Resource Group						          //
			//--------------------------------------------------------------------//
				
			assertTrue(click(selenium, lnkResourceGroup), "could not able to click the Ressource Group Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			
			//--------------------------------------------------------------------//
			//  Step-8:Delete All Resource	Group								  //	
			//--------------------------------------------------------------------//
			assertTrue(deleteAllResourceGroups(selenium,resourceGroup),"Could not delete All Resource Groups", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9:Create New Resource	Group								  //
			//--------------------------------------------------------------------//
			
			resourceGroup.workSheetName = "ResourceGroup";
			resourceGroup.testCaseId = "TC_RG_001";
			resourceGroup.fetchSchedulingTestData();
					
			assertTrue(click(selenium, btnAddResourceGroup), "could not able to click Add New button for Resource Group", selenium, ClassName, MethodName);
						
			
			
			if(resourceGroup.testCaseId.equalsIgnoreCase("TC_NP_001d")){
				// Add new Resource Group
				assertTrue(type(selenium, txtResourceGroupName, resourceGroup.resourceGroupName + uniqueName), "Could not type the Resource Group name", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtSearchResources, resourceGroup.searchResourceName), "Could not type the Search Resource Name", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnSearchResources), "Could not click the Search button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium, chkSelectAllResources), "Could not click the check box Select All Resources", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnSaveResourceGroup), "Could not click the save button", selenium, ClassName, MethodName);
				if(!isElementPresent(selenium, btnAddResourceGroup)){
					return false;
				} 
				
				
				//add the same resource group name and verify the alert present
				// Add new Resource Group
				assertTrue(type(selenium, txtResourceGroupName, resourceGroup.resourceGroupName + uniqueName), "Could not type the Resource Group name", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtSearchResources, resourceGroup.searchResourceName), "Could not type the Search Resource Name", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnSearchResources), "Could not click the Search button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium, chkSelectAllResources), "Could not click the check box Select All Resources", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnSaveResourceGroup), "Could not click the save button", selenium, ClassName, MethodName);
				
				if(!isElementPresent(selenium, "errorCloseButton")){
					return false;
				}
				assertTrue(getText(selenium,"//li/div").contains("The resource group name must be unique"),"Verification Failed", selenium, ClassName, MethodName);
					
				return true;
			}
			
			assertTrue(createaddNewResourceGroups(selenium,resourceGroup,uniqueName),"Could not create a New Resource Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10:Verify Stored Values For Resource Group					  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValuesForResourceGroup(selenium,resourceGroup),"Resource Group not created correctly", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}
		
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}