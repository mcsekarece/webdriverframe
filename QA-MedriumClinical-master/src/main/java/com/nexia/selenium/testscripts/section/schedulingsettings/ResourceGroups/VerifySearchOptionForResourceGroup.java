package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceGroups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchOptionForResourceGroup extends AbstractSchedulingTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Search Newly created Resource Group")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchNewResourceGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib resourceGroup = new SchedulingTestLib();
		resourceGroup.workSheetName = "NonProviderResource";
		resourceGroup.testCaseId = "TC_NP_001d";
		resourceGroup.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchResourceGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceGroup);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Searching Newly created Resource Group
	* @action 		  verify Searching Newly created Resource Group
	* @expected       To Ensure that the searching of newly created Resource Group works fine    
	* @author         Jagmit
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      June 06, 2013
	***************************************************************************************************/

	public boolean searchResourceGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib resourceGroup) throws Exception{
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
			assertTrue(goToScheduling(selenium),"Could not Navigate to Scheduling Setting", selenium, ClassName, MethodName);
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
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
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
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(deleteAllResourceGroups(selenium,resourceGroup),"Could not delete All Resource Groups", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9:Create New Resource	Group								  //
			//--------------------------------------------------------------------//
			
			resourceGroup.workSheetName = "ResourceGroup";
			resourceGroup.testCaseId = "TC_RG_004";
			resourceGroup.fetchSchedulingTestData();
					
			assertTrue(click(selenium, btnAddResourceGroup), "could not able to click Add New button for Resource Group", selenium, ClassName, MethodName);
			
			assertTrue(createaddNewResourceGroups(selenium,resourceGroup,uniqueName),"Could not create a New Resource Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10:Create Another New Resource	Group								  //
			//--------------------------------------------------------------------//
			
			resourceGroup.workSheetName = "ResourceGroup";
			resourceGroup.testCaseId = "TC_RG_005";
			resourceGroup.fetchSchedulingTestData();
					
			assertTrue(click(selenium, btnAddResourceGroup), "could not able to click Add New button for Resource Group", selenium, ClassName, MethodName);
						
			assertTrue(createaddNewResourceGroups(selenium,resourceGroup,uniqueName),"Could not create a New Resource Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-11:Verify Search Values For Resource Group				      //
			//--------------------------------------------------------------------//
			
			assertTrue(type(selenium,txtSearchResourceGroup,resourceGroup.resourceGroupName),"Could not Type the Resource Group ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(txtSearchResourceGroup, "\\13");
			waitForPageLoad(selenium);
		
			assertTrue(getText(selenium, lblSummaryResourceGroup).contains(resourceGroup.resourceGroupName),"Search result is not getting displayed", selenium, ClassName, MethodName);
				 
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}	