package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceGroups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class EditResourceGroup extends AbstractSchedulingTest {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Edit Resource Group")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editNewResourceGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib resourceGroup = new SchedulingTestLib();
		resourceGroup.workSheetName = "ResourceGroup";
		resourceGroup.testCaseId = "TC_RG_002";
		resourceGroup.fetchSchedulingTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		editResourceGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceGroup);
	}
		/*************************************************************************************************** 
		* @purpose        To verify Editing New Resource Group
		* @action 		  verify Editing New Resource Group
		* @expected       To Ensure that the edited Resource Group works fine    
		* @author         Jagmit
		* @state          Developing
		* @useraccount    Both (US and Canada)
		* @since  	      June 06, 2013
		***************************************************************************************************/
		
	public boolean editResourceGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib resourceGroup) throws Exception{
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
			/*assertTrue(switchRole(selenium,resourceGroup.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkResourceGroup), "could not able to click the Ressource Group Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete All Resource	Group								  //	
			//--------------------------------------------------------------------//
			assertTrue(deleteAllResourceGroups(selenium,resourceGroup),"Could not delete All Resource Groups", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Create New Resource	Group								  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddResourceGroup), "could not able to click Add New button for Resource Group", selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);		
			assertTrue(createaddNewResourceGroups(selenium,resourceGroup,uniqueName),"Could not create a New Resource Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: edit New Resource Group									  //
			//--------------------------------------------------------------------//
			
			resourceGroup.workSheetName = "ResourceGroup";
			resourceGroup.testCaseId = "TC_RG_003";
			resourceGroup.fetchSchedulingTestData();
			
			assertTrue(click(selenium, btnEdit), "could not able to click on Edit button", selenium, ClassName, MethodName);
				
			assertTrue(createaddNewResourceGroups(selenium,resourceGroup,uniqueName),"Could not create a New Resource Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Verify Stored Values For Resource Group					  //
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
