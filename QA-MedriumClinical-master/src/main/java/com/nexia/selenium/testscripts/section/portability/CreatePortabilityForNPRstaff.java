package com.nexia.selenium.testscripts.section.portability;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class CreatePortabilityForNPRstaff extends AbstractSchedulingTest {
	@Test(groups = {"Regression","Review", "firefox", "iexplore", "safari", "default" }, description = "Create NonProvider Resource Equipment", dependsOnGroups= "BeforeLocation")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewNonProviderResourceStaff1(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProviderEq = new SchedulingTestLib();
		nonProviderEq.workSheetName = "NonProviderResourcePortability";
		nonProviderEq.testCaseId = "TC_NPR_001";
		nonProviderEq.fetchSchedulingTestData();
		Selenium selenium = null;
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		assertTrue(createNewNonProviderStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProviderEq),"Problem With Creating New Non Provider Resource Equipment",selenium,ClassName,MethodName);
	}
	@Test(groups = {"Regression","Review", "firefox", "iexplore", "safari", "default" }, description = "Create NonProvider Resource Equipment", dependsOnGroups= "BeforeLocation")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewNonProviderResourceStaff2(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProviderEq = new SchedulingTestLib();
		nonProviderEq.workSheetName = "NonProviderResourcePortability";
		nonProviderEq.testCaseId = "TC_NPR_002";
		nonProviderEq.fetchSchedulingTestData();
		Selenium selenium = null;
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		assertTrue(createNewNonProviderStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProviderEq),"Problem With Creating New Non Provider Resource Equipment",selenium,ClassName,MethodName);
	}
	@Test(groups = {"Regression","Review", "firefox", "iexplore", "safari", "default" }, description = "Create NonProvider Resource Equipment", dependsOnGroups= "BeforeLocation")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewNonProviderResourceStaff3(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProviderEq = new SchedulingTestLib();
		nonProviderEq.workSheetName = "NonProviderResourcePortability";
		nonProviderEq.testCaseId = "TC_NPR_003";
		nonProviderEq.fetchSchedulingTestData();
		Selenium selenium = null;
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		assertTrue(createNewNonProviderStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProviderEq),"Problem With Creating New Non Provider Resource Equipment",selenium,ClassName,MethodName);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Create New Non Provider Resource Support Staff
	* @action 		  verify Creating New Non Provider Resource Support Staff
	* @expected       To Ensure that the created New Non Provider Resource Support Staff works fine    
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      June 19, 2013
	***************************************************************************************************/
	
	public boolean createNewNonProviderStaff(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib nonProviderSS) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + nonProviderSS.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, nonProviderSS.userName, nonProviderSS.userPassword),"Login Failed ",selenium,ClassName,MethodName);
	
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,nonProviderSS.switchRole),"Couldn't switch role",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Non Provider Resource Support Staff  		  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToNonProviderResource(selenium),"Could not navigate to non provider resource Support Staff",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkNonProviderResourceSupportStaff), "could not able to click the Non Provider Resource Support Staff link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete All Non Provider Resource	Support Staff			  //	
			//--------------------------------------------------------------------//
			
			int count=1;
			while(isElementPresent(selenium,"//div[@id='NonProviderResourcesRoomsListWidget']/table/tbody/tr"+count+"/td")){
				
				if(getText(selenium,"//div[@id='NonProviderResourcesRoomsListWidget']/table/tbody/tr"+count+"/td").contains(nonProviderSS.staffName)  ){
					System.out.println("Non Provider Resource Room name with " + nonProviderSS.staffName +"has been already created ");
					return true;
				}
				
				if(count>15){
					break;
				}
			}
			
			//--------------------------------------------------------------------//
			//  Step-5:Create New Non Provider Resource	Support Staff					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource",selenium,ClassName,MethodName);			
			
			assertTrue(createNewNonProviderResourceStaffPort(selenium,nonProviderSS),"Could not create a non provider resource Support Staff",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
		}
		
		catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + nonProviderSS.toString());
		}
		return returnValue;
		
	}
	
}