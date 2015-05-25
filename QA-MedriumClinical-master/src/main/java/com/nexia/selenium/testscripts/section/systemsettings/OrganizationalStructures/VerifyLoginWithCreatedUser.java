package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import static com.sharedlibrary.ThreadSafeSeleniumSessionStorage.session;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLoginWithCreatedUser extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Logging in with a created user")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void loginWithCreatedNewUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_002";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		loginWithCreatedNewUsers(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	/**
	 * loginWithCreatedNewUsers
	 * function to login With Created New Users
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	     June 05, 2010
	*/
	public boolean loginWithCreatedNewUsers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws IOException{
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
			//  Step-2: Go to System Settings and navigate to User //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Existing user //
			//--------------------------------------------------------------------//
			SystemSettingsLib userData = new SystemSettingsLib();
			userData.workSheetName = "CreateUser";
			userData.testCaseId = "TC_CU_003";
			userData.fetchSystemSettingTestData();
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			/*if(!isChecked(selenium, chkIncludeInactiveUserscheckbox)){
				assertTrue(click(selenium,chkIncludeInactiveUserscheckbox),"Could not click the include inactive check box in practice ;More Details:"+pracData.toString(), selenium, ClassName, MethodName);
			}
			
			type(selenium,txtProFirstName1,userData.firstName);
			waitForPageLoad(selenium);
			
			click(selenium,txtProFirstName2);
			waitForPageLoad(selenium);
			
			int Counter=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,"//a[starts-with(@id, 'DeleteUser')]");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					
				}else Counter++;
				if(Counter>15)
					break;
				}*/
			//--------------------------------------------------------------------//
			//  Step-6: Create an user //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createNewUser(selenium,userData,uniqueName),"Create user failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify whether user gets saved properly //
			//--------------------------------------------------------------------//			
			waitForPageLoad(selenium);
			/*if(!verifyStoredValuesinSummary(selenium,userData)){
				Assert.fail("User details not saved properly; More Details :"+ userData.toString());
				returnValue=false;
			}else
				 returnValue=true;
*/
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,"//div[5]/div/div"),"Could not click on the link" + userData .toString());
			assertTrue(click(selenium,lnkTopMenuHeader),"Could not click on the link" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignOutAction),"Could not click on System settings link:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			click(selenium,"Yes");
			
			if(!waitForElement(selenium, txtAccount, WAIT_TIME*4)){
	        	Assert.fail("Login Page Not loaded More Details; UserAccount :- "+userAccount +"  UserName :- " +userData.userName1+uniqueName+ " UserPassword :- "+ userData.password);
	        }
	        type(selenium, txtAccount, userAccount);
	        type(selenium, lnkLoginUseridText, userData.userName1+uniqueName);
	        type(selenium, lnkLoginPasswordText, userData.password);
	        click(selenium, btnLogin);
	        if(isElementPresent(selenium,btnAgree)){
	        	click(selenium,btnAgree);
	        }
			
			
			if(isElementPresent(selenium, btnErrorClose)){
				click(selenium, btnErrorClose);
				waitForPageLoad(selenium);
			}
			
			
			//assertTrue(click(selenium, lnkSystemSettings),"Could not click on System settings link:" + userData .toString());
			assertTrue(click(selenium,lnkSettings ),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			click(selenium,lnkAdminOrgStructureLists);
			waitForPageLoad(selenium);
			
		/*	if(!isChecked(selenium, chkIncludeInactiveUserscheckbox)){
				assertTrue(click(selenium,chkIncludeInactiveUserscheckbox),"Could not click the include inactive check box in practice ;More Details:"+pracData.toString(), selenium, ClassName, MethodName);
			}
			
			type(selenium,txtProFirstName1,userData.firstName);
			waitForPageLoad(selenium);
			
			click(selenium,txtProFirstName2);
			waitForPageLoad(selenium);
			
			
			int Counter1=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,"//a[starts-with(@id, 'DeleteUser')]");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					
				}else Counter1++;
				if(Counter1>15)
					break;
				}*/
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
		}
		
		return returnValue;
	}
	public boolean verifyStoredValuesinSummary(Selenium selenium,SystemSettingsLib programData){
		waitForPageLoad(selenium);
		if(!getText(selenium,vfyStoreValinSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.userName1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,vfyStoreValinSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,vfyStoreValinSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,vfyStoreValinSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.userRole.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
