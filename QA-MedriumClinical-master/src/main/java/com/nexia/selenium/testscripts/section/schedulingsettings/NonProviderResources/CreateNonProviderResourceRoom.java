package com.nexia.selenium.testscripts.section.schedulingsettings.NonProviderResources;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;


public class CreateNonProviderResourceRoom extends AbstractSchedulingTest{
	
	@Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create NonProvider Resource")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewNonProviderResourceRoom(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProvider = new SchedulingTestLib();
		nonProvider.workSheetName = "NonProviderResource";
		nonProvider.testCaseId = "TC_NP_001";
		nonProvider.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createNewNonProviderRoom(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProvider);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Create New Non Provider Resource Room
	* @action 		  verify Creating New Non Provider Resource Room
	* @expected       To Ensure that the created New Non Provider Resource Room works fine    
	* @author         Jagmit
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      June 06, 2013
	***************************************************************************************************/
	public boolean createNewNonProviderRoom(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib nonProvider) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + nonProvider.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, nonProvider.userName, nonProvider.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,nonProvider.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Non Provider Resource Room						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToNonProviderResource(selenium),"Could not navigate to non provider resource Room", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete All Non Provider Resource	Room					  //	
			//--------------------------------------------------------------------//
			assertTrue(deleteAllNonProviderResource(selenium,nonProvider),"Could not delete All Non Provider Resource Room", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Create New Non Provider Resource	Room					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource", selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createNewNonProviderResourceRoom(selenium,nonProvider,uniqueName),"Could not create a non provider resource room", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Verify Stored Values For Non Provider Resource Room			  //
			//--------------------------------------------------------------------//
			assertTrue(verfyStoredValuesForNonProviderResource(selenium,nonProvider),"Non Provider Resource Room not created correctly", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}		
}
