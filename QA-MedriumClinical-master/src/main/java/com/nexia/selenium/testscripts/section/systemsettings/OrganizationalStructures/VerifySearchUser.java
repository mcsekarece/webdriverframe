package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchUser extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for search with first name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchUsersWithFirstName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "CreateUser";
		userData.testCaseId = "TC_CU_008";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for search with Last name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchUsersWithLastName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "CreateUser";
		userData.testCaseId = "TC_CU_009";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for search with User name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchUsersWithUserName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "CreateUser";
		userData.testCaseId = "TC_CU_010";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify search name with User
	* @expected       Search user details should be displayed
	* @author         Aspire QA
	* @defectno		  #2409
	* @state          Closed
	* @useraccount    Both
	* @since  	      March 17, 2013
	***************************************************************************************************/
	
	public boolean searchUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib userData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + userData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, userData.userName, userData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,userData.switchRole), "Switch role failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to User                //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,lnkOrgStructures),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			//getting user name, first name and last name
			assertTrue(type(selenium,txtUserSearch,userData.userName),"Could not type first name;More deatils :"+userData.userName, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnUserSearch),"Could not click the serach button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lblSearchDetails)){
				assertTrue(click(selenium,lblSearchDetails),"Could not click the serached user", selenium, ClassName, MethodName);
				String name= getText(selenium, txtUserName);
				userData.userName1 = name;
				
				String names[]= name.split(" ");
				userData.firstName = names[0];
				userData.lastName = names[1];
				
				assertTrue(click(selenium,lnkOrgStructures),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
			}else{
				Assert.fail("The details is not getting displyed properly");
			}
			
			if(userData.testCaseId.equals("TC_CU_008")){
				assertTrue(type(selenium,txtUserSearch,userData.firstName),"Could not type first name;More deatils :"+userData.firstName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnUserSearch),"Could not click the serach button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(getText(selenium,lblSearchDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue = true;
				}else{
					Assert.fail("The details is not getting displyed properly");
					returnValue = false;
				}
			}if(userData.testCaseId.equals("TC_CU_009")){
				assertTrue(type(selenium,txtUserSearch,userData.lastName),"Could not type first name;More deatils :"+userData.lastName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnUserSearch),"Could not click the serach button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(getText(selenium,lblSearchDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue = true;
				}else{
					Assert.fail("The details is not getting displyed properly");
					returnValue = false;
				}
			}if(userData.testCaseId.equals("TC_CU_010")){
				assertTrue(type(selenium,txtUserSearch,userData.userName),"Could not type first name;More deatils :"+userData.userName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnUserSearch),"Could not click the serach button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(getText(selenium,lblSearchDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userName1.trim().toLowerCase(new java.util.Locale("en","US")))){
					returnValue = true;
				}else{
					Assert.fail("The details is not getting displyed properly");
					returnValue = false;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
}

