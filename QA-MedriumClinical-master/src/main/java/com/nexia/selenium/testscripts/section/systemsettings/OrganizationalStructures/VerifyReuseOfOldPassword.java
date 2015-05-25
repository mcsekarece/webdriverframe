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

public class VerifyReuseOfOldPassword extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding an User")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReuseOfOldPwd(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_002";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyReUseOfOldPwd(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	/**
	 * createUser
	 * function to create User
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	    August 06, 2012
	 */
	public boolean verifyReUseOfOldPwd(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
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
			assertTrue(switchRole(selenium,pracData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to User //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3: Delete Practice//
			//--------------------------------------------------------------------//
			type(selenium, txtSearchBox ,pracData.practiceName);
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
			//  Step-4: Add Practice//
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			pracData.practiceName= pracData.practiceName+ uniqueName;
			
			assertTrue(addPracticeWithMandatory(selenium,pracData,userAccount),"Practice Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to user //
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
			
			/*assertTrue(type(selenium,txtProFirstName1,userData.firstName),"Could not type first name;More deatils :"+userData.firstName, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnUserSearch),"Could not click the serach button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Delete Existing user //
			//--------------------------------------------------------------------//
			
			int Counter=1;
			while(getText(selenium,txtUserName1).contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,"//div[2]/div/div/div[3]/div/div[2]/table/tbody/tr["+Counter+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					
				}else Counter++;
				if(counter>15)
					break;
			}*/
			
			//--------------------------------------------------------------------//
			//  Step-8: Add User//
			//--------------------------------------------------------------------//
			assertTrue(createNewUser(selenium,userData,uniqueName),"Create user failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify whether user gets saved properly //
			//--------------------------------------------------------------------//
			/*if(!verifyStoredValues(selenium,userData,uniqueName)){
				Assert.fail("User details not saved properly; More Details :"+ userData.toString());
				returnValue=false;
			}*/
		//	assertTrue(click(selenium,btnCancel),"Could not click on cancel button:" + userData .toString(), selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-10: Login as the created user //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				selenium.chooseOkOnNextConfirmation();
			}
			
			if(isElementPresent(selenium, btnErrorClose))
				Assert.assertTrue(click(selenium, btnErrorClose));
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkTopMenuHeader),"Could not click on the link" + userData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignOutAction),"Could not click on System settings link:" + userData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,"link=Yes");assertTrue(click(selenium,lnkTopMenuHeader),"Could not click on the link" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		/*	assertTrue(click(selenium,lnkSignOutAction),"Could not click on System settings link:" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			click(selenium,"Yes");*/
			
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, userData.userName1+uniqueName, userData.password),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-11: Reset the password //
			//--------------------------------------------------------------------//
			
			if(isElementPresent(selenium, btnErrorClose)){
				click(selenium, btnErrorClose);
				waitForPageLoad(selenium);
			}
			
			waitForPageLoad(selenium);
			
			selenium.focus(lnkTopMenuHeader);
			//selenium.clickAt(lnkTopMenuHeader, "");
			assertTrue(click(selenium,lnkTopMenuHeader),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"mySettingsAction"),"Could not click my settings link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnResetPassword),"Could not click my Reset password link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("HHmm");
			String uniqueName1=DateFormat1.format(cal1.getTime());
			assertTrue(type(selenium,txtCurrentPassword,userData.password),"Could not type current password", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtNewPassword,userData.newpassword+uniqueName1),"Could not type new password", selenium, ClassName, MethodName);
			assertTrue(type(selenium,"confirmNewPassword",userData.newpassword+uniqueName1),"Could not type new Confirm password", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium,SystemSettingsLib programData,String uniqueName) throws IOException{
		assertTrue(click(selenium,btnEdit1),"Could not click edit button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!getText(selenium,txtUserName).startsWith(programData.userName1+uniqueName.trim())){
		return false;
		}
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.lastName+uniqueName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium, txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getValue(selenium,txtCredentials).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.credentials.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(programData.testCaseId.equalsIgnoreCase("TC_CU_002")){
			if(!getValue(selenium,ajxUserRolesuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.userRole.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxPractise).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.practise.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		else{
			if(!getValue(selenium,ajxUserRolesuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.userRole.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxPractise).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.practise.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		return true;
	}
}
