package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceGroups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteResourceGroup extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = " Delete Newly created Resource Group")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteNewResourceGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib resourceGroup = new SchedulingTestLib();
		resourceGroup.workSheetName = "ResourceGroup";
		resourceGroup.testCaseId = "TC_RG_001";
		resourceGroup.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteResourceGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, resourceGroup);
	}
	/*************************************************************************************************** 
	* @purpose        To verify Delete Resource Group
	* @action 		 verify Delete Resource Group
	* @expected       To Ensure that the Delete Resource Group works fine    
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Dec 16, 2013
	***************************************************************************************************/
	
	public boolean deleteResourceGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib resourceGroup) throws Exception{
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
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(click(selenium, btnAddResourceGroup), "could not able to click Add New button for Resource Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(createaddNewResourceGroups(selenium,resourceGroup,uniqueName),"Could not create a New Resource Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-10:Verify Stored Values For Resource Group					  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValuesForResourceGroup(selenium,resourceGroup),"Resource Group not created correctly", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11:Delete Created Resource Group					  //
			//--------------------------------------------------------------------//
			String resourceGroupName = resourceGroup.resourceGroupName+uniqueName;
			selectValueFromAjaxList(selenium,txtSearchResourceGroup,resourceGroup.searchResourceName);
			waitForPageLoad(selenium);
			
			selenium.focus(txtSearchResourceGroup);
			
			selenium.fireEvent(txtSearchResourceGroup, "\\13");
			selenium.typeKeys(txtSearchResourceGroup, "a");
			
			assertTrue(deleteAllResourceGroups(selenium,resourceGroup),"Could not delete All Resource Groups", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
				if(getText(selenium, lblResourceGroup).contains(resourceGroupName)){
					Assert.fail("Record is not deleted Properly");
			     }
			}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
