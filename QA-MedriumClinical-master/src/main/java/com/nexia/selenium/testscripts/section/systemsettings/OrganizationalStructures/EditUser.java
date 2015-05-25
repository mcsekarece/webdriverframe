package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class EditUser extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing the details of an user")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editNewUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_002";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editUser(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	/**
	 * editUser
	 * function to edit User
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
	public boolean editUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pracData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pracData.userName, pracData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			/*assertTrue(switchRole(selenium,pracData.switchRole), "Switch role failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to User //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3: Delete Practice//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
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
					
				}else {counter++;}
				if(counter>5)
					break;
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Add Practice//
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,btnAddPractice),"Could not find add practice button");
			waitForPageLoad(selenium);
			
			assertTrue(addAdminPracticeWithMandatory(selenium,pracData,userAccount,uniqueName),"Practice Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to User//
			//--------------------------------------------------------------------//
			SystemSettingsLib userData = new SystemSettingsLib();
			userData.workSheetName = "CreateUser";
			userData.testCaseId = "TC_CU_001";
			userData.fetchSystemSettingTestData();
					
			
			//--------------------------------------------------------------------//
			//  Step-6: SearchUser //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			type(selenium,txtUserSearch,userData.lastName+uniqueName);
			waitForPageLoad(selenium);
			
			click(selenium,btnUserSearch);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Delete Existing user //
			//--------------------------------------------------------------------//
			
			int Counter=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+counter+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,"//div[2]/div/div/div[3]/div/div[2]/table/tbody/tr["+counter+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					}else Counter++;
				if(counter>15)
					break;
				}
			//--------------------------------------------------------------------//
			//  Step-8: Create user //
			//--------------------------------------------------------------------//
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("ddMMyyyyHH:mm:ss");
			String uniqueName1=DateFormat1.format(cal1.getTime());
			
			
			assertTrue(createNewUser(selenium,userData,uniqueName1), "Create new user failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-9: Edit an user //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit1),"Could not click on edit a program link:" + userData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			userData.workSheetName = "EditUser";
			userData.testCaseId = "TC_EU_001";
			userData.fetchSystemSettingTestData();
			
			assertTrue(editUser(selenium,userData,uniqueName1),"Could not edit the user details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnEdit1),"Could not click on edit a program link:" + userData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-10: Verify whether user gets saved properly //
			//--------------------------------------------------------------------//
			if(!verifyStoredValues(selenium,userData,uniqueName1)){
				Assert.fail("User details not saved properly; More Details :"+ userData.toString());
				returnValue=false;
			}waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkAdminOrgStructureLists);
			waitForPageLoad(selenium);
			
			type(selenium,txtUserSearch,userData.lastName+uniqueName1);
            waitForPageLoad(selenium);
			
			click(selenium,btnUserSearch);
			waitForPageLoad(selenium);
			int count=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td").trim().toLowerCase(new java.util.Locale("en","US")).contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,"//div[2]/div/div/div[3]/div/div[2]/table/tbody/tr["+count+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					count++;
				}else count++;
				if(count>10)
					break;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium,SystemSettingsLib programData,String uniqueName){
		
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium, txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}		
		if(!getText(selenium,txtUserName).contains(programData.userName1+uniqueName)){
			return false;
		}
				
		//if(!getValue(selenium,ajxExternalEmrsuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.externalEmr.trim().toLowerCase(new java.util.Locale("en","US")))){
			//return false;
		//}
		if(!getValue(selenium,txtCredentials).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.credentials.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,ajxUserRolesuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.userRole.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		/*if(!getValue(selenium,ajxPractise).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.practise.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		return true;
	}
}

