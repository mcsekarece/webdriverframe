package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyForcePasswordReset extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting an User")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyForcePasswordResetForUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pwdData = new SystemSettingsLib();
		pwdData.workSheetName = "ForcePasswordReset";
		pwdData.testCaseId = "TC_FPR_001";
		pwdData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyForcePasswordReset(seleniumHost, seleniumPort, browser, webSite, userAccount, pwdData);
	}
	
	/**
	 * verifyForcePasswordReset
	 * function to verify Force Password Reset
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 * @since  	    August 13, 2012
	 */
	public boolean verifyForcePasswordReset(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pwdData) throws Exception{
		
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pwdData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pwdData.userName, pwdData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pwdData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to User                //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-3: Search for a patient//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			type(selenium,txtUserSearch,pwdData.userName1);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnUserSearch),"Could not click on search button:" + pwdData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isElementPresent(selenium,"DeleteUserAAAPPLE")){
				assertTrue(click(selenium,chkIncludeInactiveUserscheckbox),"Could not click on include Inactive Users checkbox:" + pwdData .toString(), selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,"ActivateUserAAAPPLE"),"Could not find the user", selenium, ClassName, MethodName);
				assertTrue(click(selenium,"ActivateUserAAAPPLE"),"Could not click on activate button:" + pwdData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,txtdescription),"Could not click on user link:" + pwdData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}else{
				assertTrue(click(selenium,txtdescription),"Could not click on user link:" + pwdData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				}
			
			//--------------------------------------------------------------------//
			//  Step-4:Reset Password for the selected user//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit1),"Could not click on edit button:" + pwdData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("HHmm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			selectValueFromAjaxList(selenium,ajxExternalEmrsuggestBox,pwdData.externalEmr);
			waitForPageLoad(selenium);
			click(selenium,chkResetPassword);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPassword,pwdData.password1+uniqueName+"a"),"Could not type password" + pwdData .toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtConfirmPassword,pwdData.password1+uniqueName+"a"),"Could not type confirmation password" + pwdData .toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click on save button:" + pwdData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5:Logut and login as the created us//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not go to home page" + pwdData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			assertTrue(click(selenium,lnkTopMenuHeader),"Could not click on the link" + pwdData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignOutAction),"Could not click on System settings link:" + pwdData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			click(selenium,"Yes");
			waitForPageLoad(selenium); 
			assertTrue(loginForNexiaToVerifyForcePwdReset(selenium, userAccount, pwdData.userName1, pwdData.password1+uniqueName+"a"),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}catch (RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pwdData.toString(), selenium, ClassName, MethodName);
		}
	return returnValue;
	}
}
		

