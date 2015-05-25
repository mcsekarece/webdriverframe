package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreateNewUser extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding an User")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_002";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createUser(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding an User With Many Roles")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUserWithManyRoles(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_002";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createUserWithManyRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	/**
	 * createUser
	 * function to create User
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 * @since  	     June 05, 2010
	 */
	public boolean createUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pracData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pracData.userName, pracData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pracData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to User //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			Assert.assertTrue(gotoSystemSetting(selenium));
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Verify active users //
			//--------------------------------------------------------------------//
			
			int count=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains("Inactive")){
					Assert.fail(" Inactive user is in default mode");
				}else 
					count++;
				if(count>15)
					break;
				}
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Practice//
			//--------------------------------------------------------------------//
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			type(selenium, txtSearchBox ,pracData.practiceName+uniqueName);
			waitForPageLoad(selenium);
			click(selenium,btnSearchBox);
			waitForPageLoad(selenium);
			int counter=1;
			while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div")){
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div").contains(pracData.practiceName)){
					click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					
				}
				else {counter++;}
				if(counter>10)
					break;
			}
			//--------------------------------------------------------------------//
			//  Step-5: Add Practice//
			//--------------------------------------------------------------------//
			
			
			Assert.assertTrue(click(selenium,btnAddPractice),"Could not find add practice button");
			waitForPageLoad(selenium);
			
			assertTrue(addAdminPracticeWithMandatory(selenium,pracData,userAccount,uniqueName),"Practice Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to user //
			//--------------------------------------------------------------------//
			SystemSettingsLib userData = new SystemSettingsLib();
			userData.workSheetName = "CreateUser";
			userData.testCaseId = "TC_CU_001";
			userData.fetchSystemSettingTestData();
				
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName1=DateFormat1.format(cal1.getTime());
			//--------------------------------------------------------------------//
			//  Step-7: SearchUser //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			type(selenium,txtUserSearch,userData.lastName+uniqueName1);
			waitForPageLoad(selenium);
			
			click(selenium,btnUserSearch);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: Delete Existing user //
			//--------------------------------------------------------------------//
			
			int Counter=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,"//a[starts-with(@id, 'DeleteUser')]");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					
				}else Counter++;
				if(counter>15)
					break;
				}
			//--------------------------------------------------------------------//
			//  Step-9: Add User//
			//--------------------------------------------------------------------//
			assertTrue(createNewUser(selenium,userData,uniqueName1),"Create new user failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-10: Verify whether user gets saved properly //
			//--------------------------------------------------------------------//
			if(!verifyStoredValues(selenium,userData,uniqueName1,userAccount)){
				Assert.fail("User details not saved properly; More Details :"+ userData.toString());
				returnValue=false;
			}
			assertTrue(click(selenium,btnCancel),"Could not click on cancel button:" + userData .toString(), selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-11: SearchUser //
			//--------------------------------------------------------------------//
			
			type(selenium,txtUserSearch,userData.lastName+uniqueName1);
			waitForPageLoad(selenium);			
			click(selenium,btnUserSearch);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: Delete User //
			//--------------------------------------------------------------------//
			
			count=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,"//a[starts-with(@id, 'DeleteUser')]");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					break;
				}else count++;
				if(count>15)
					break;
				}
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/**
	 * createUserWithManyRoles
	 * function to create User With Many Roles
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		: InterruptedException 
	 * @since  	     June 05, 2010
	 */
	public boolean createUserWithManyRoles(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pracData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pracData.userName, pracData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pracData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to User //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Practice//
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			type(selenium, txtSearchBox ,pracData.practiceName+uniqueName);
			waitForPageLoad(selenium);
			click(selenium,btnSearchBox);
			waitForPageLoad(selenium);
			int counter=1;
			while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div")){
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div").contains(pracData.practiceName)){
					click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					
				}
				else {counter++;}
				if(counter>5)
					break;
			}
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Add Practice//
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(click(selenium,btnAddPractice),"Could not find add practice button");
			waitForPageLoad(selenium);
			
			assertTrue(addAdminPracticeWithMandatory(selenium,pracData,userAccount,uniqueName),"Practice Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to User//
			//--------------------------------------------------------------------//
			SystemSettingsLib userData = new SystemSettingsLib();
			userData.workSheetName = "CreateUser";
			userData.testCaseId = "TC_CU_002";
			
			userData.fetchSystemSettingTestData();
			
			//--------------------------------------------------------------------//
			//  Step-7: SearchUser //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName1=DateFormat1.format(cal1.getTime());
			type(selenium,txtUserSearch,userData.lastName+uniqueName1);
			waitForPageLoad(selenium);
			
			click(selenium,btnUserSearch);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: Delete Existing user //
			//--------------------------------------------------------------------//
			int Counter=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,"//a[starts-with(@id, 'DeleteUser')]");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					break;
				}else Counter++;
				if(counter>15)
					break;
			}
			//--------------------------------------------------------------------//
			//  Step-9: Create an user With May role//
			//--------------------------------------------------------------------//
			
			assertTrue(createUserWithManyRoles(selenium,userData,uniqueName1),"Create many roles failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-10: Verify whether user gets saved properly //
			//--------------------------------------------------------------------//
			
			if(!verifyStoredValues(selenium,userData,uniqueName1,userAccount)){
				Assert.fail("User details not saved properly; More Details :"+ userData.toString());
				returnValue=false;
			}
			assertTrue(click(selenium,btnCancel),"Could not click on cancel button:" + userData .toString(), selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-11: SearchUser //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			type(selenium,txtUserSearch,userData.lastName+uniqueName1);
			waitForPageLoad(selenium);			
			click(selenium,btnUserSearch);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: Delete User //
			//--------------------------------------------------------------------//
			int count=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,"//a[starts-with(@id, 'DeleteUser')]");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					break;
				}else count++;
				if(count>15)
					break;
				}
			}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium,SystemSettingsLib programData,String uniqueName, String userAccount) throws IOException{
		assertTrue(click(selenium,btnEdit1),"Could not click edit button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!getText(selenium,txtUserName).contains(programData.userName1+uniqueName.trim())){
		return false;
		}
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.lastName+uniqueName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium, txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			if(!getValue(selenium,ajxExternalEmrsuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.externalEmr.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		if(!getValue(selenium,txtCredentials).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.credentials.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(programData.testCaseId.equalsIgnoreCase("TC_CU_002")){
			if(!getValue(selenium,"xpath=(//input[@id='userRolesuggestBox'])[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.userRole.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			/*if(!getValue(selenium,ajxSuggestBoxProg ).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.practise.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
		}
		else{
			if(!getValue(selenium,ajxUserRolesuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.userRole.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			/*if(!getValue(selenium,ajxSuggestBoxProg ).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.practise.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
		}
		return true;
	}
}

