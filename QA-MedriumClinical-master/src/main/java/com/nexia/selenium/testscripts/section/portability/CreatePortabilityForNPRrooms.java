package com.nexia.selenium.testscripts.section.portability;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class CreatePortabilityForNPRrooms extends AbstractSchedulingTest {
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Create NonProvider Resource", dependsOnGroups= "BeforeLocation")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewNonProviderResourceRoom1(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProvider = new SchedulingTestLib();
		nonProvider.workSheetName = "NonProviderResourcePortability";
		nonProvider.testCaseId = "TC_NPR_001";
		nonProvider.fetchSchedulingTestData();
		Selenium selenium = null;
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		assertTrue(createNewNonProviderRoom(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProvider),"Problem With Creating New Non Provider Resource",selenium,ClassName,MethodName);
	}
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Create NonProvider Resource", dependsOnGroups= "BeforeLocation")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewNonProviderResourceRoom2(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProvider = new SchedulingTestLib();
		nonProvider.workSheetName = "NonProviderResourcePortability";
		nonProvider.testCaseId = "TC_NPR_002";
		nonProvider.fetchSchedulingTestData();
		Selenium selenium = null;
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		assertTrue(createNewNonProviderRoom(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProvider),"Problem With Creating New Non Provider Resource",selenium,ClassName,MethodName);
	}
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Create NonProvider Resource", dependsOnGroups= "BeforeLocation")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewNonProviderResourceRoom3(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProvider = new SchedulingTestLib();
		nonProvider.workSheetName = "NonProviderResourcePortability";
		nonProvider.testCaseId = "TC_NPR_003";
		nonProvider.fetchSchedulingTestData();
		Selenium selenium = null;
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		assertTrue(createNewNonProviderRoom(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProvider),"Problem With Creating New Non Provider Resource",selenium,ClassName,MethodName);
	}
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Create NonProvider Resource", dependsOnGroups= "BeforeLocation")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewNonProviderResourceRoom4(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProvider = new SchedulingTestLib();
		nonProvider.workSheetName = "NonProviderResourcePortability";
		nonProvider.testCaseId = "TC_NPR_004";
		nonProvider.fetchSchedulingTestData();
		Selenium selenium = null;
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		assertTrue(createNewNonProviderRoom(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProvider),"Problem With Creating New Non Provider Resource",selenium,ClassName,MethodName);
	}
	
		/*************************************************************************************************** 
		* @purpose        To Create portability scripts for Non Provider Resource Room
		* @action 		  verify Creating New Non Provider Resource Room
		* @expected       To Ensure that the created New Non Provider Resource Room works fine    
		* @author         AspireQA
		* @state          Developing
		* @useraccount    Both (US and Canada)
		* @since  	      June 19, 2013
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
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, nonProvider.userName, nonProvider.userPassword),"Login Failed ",selenium,ClassName,MethodName);
		
		
				//--------------------------------------------------------------------//
				//  Step-2:Change Switch Role  										  //
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,nonProvider.switchRole),"Couldn't switch role",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-3:Navigate To Non Provider Resource Room						  //
				//--------------------------------------------------------------------//
				assertTrue(navigateToNonProviderResource(selenium),"Could not navigate to non provider resource Room",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-4:Check Existing Rooms				  //	
				//--------------------------------------------------------------------//
				int count=1;
				while(isElementPresent(selenium,"//div[@id='NonProviderResourcesRoomsListWidget']/table/tbody/tr"+count+"/td")){
					
					if(getText(selenium,"//div[@id='NonProviderResourcesRoomsListWidget']/table/tbody/tr"+count+"/td").contains(nonProvider.roomName) && getText(selenium,"//div[@id='NonProviderResourcesRoomsListWidget']/table/tbody/tr").contains(nonProvider.location) ){
						System.out.println("Non Provider Resource Room name with " + nonProvider.roomName +"has been already created ");
						return true;
					}
					
					if(count>15){
						break;
					}
				}
				
				//--------------------------------------------------------------------//
				//  Step-5:Create New Non Provider Resource	Room					  //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource",selenium,ClassName,MethodName);
				
				assertTrue(createNewNonProviderResourceRoomPortability(selenium,nonProvider),"Could not create a non provider resource room",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				
			}	
			catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + nonProvider.toString());
			}
			return returnValue;
		

		}		
			
	}
