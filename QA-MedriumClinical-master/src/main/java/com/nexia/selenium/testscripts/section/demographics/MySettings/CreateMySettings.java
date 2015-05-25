package com.nexia.selenium.testscripts.section.demographics.MySettings;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class CreateMySettings extends AbstractHomeTest{
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for My Settings")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createMySettings(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib mySettingsData = new HomeLib();
		mySettingsData.workSheetName = "MySettings";
		mySettingsData.testCaseId = "TC_NMS_001";
		mySettingsData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createMySetting(seleniumHost, seleniumPort, browser, webSite, userAccount, mySettingsData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify create My Setting
	* @action 		  verifying create My Setting
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 27, 2012
	***************************************************************************************************/
	public boolean createMySetting(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib mySettingsData) throws Exception{
		Selenium selenium = null;	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mySettingsData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, mySettingsData.userName, mySettingsData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,mySettingsData.switchRole),"",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to User //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSystemSetting),"Could not click the system setting link;More details :"+ mySettingsData.toString(),selenium,ClassName,MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
		
			//--------------------------------------------------------------------//
			//  Step-4: SearchUser //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkOrganizationalStructure),"Could not navigate to Org Structures",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtUserSearch,mySettingsData.firstName),"Could not type first name;More deatils :"+mySettingsData.firstName,selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnUserSearch),"Could not click the serach button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Existing user //
			//--------------------------------------------------------------------//
			int counter=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+counter+"]/td")){
			if(getText(selenium,"//div[@id='users']/table/tbody/tr["+counter+"]/td").toLowerCase(new java.util.Locale("en","Us")).trim().contains(mySettingsData.firstName.trim().toLowerCase(new java.util.Locale("en","Us")))){
				click(selenium,"//div[@id='users']/table/tbody/tr["+counter+"]/td[2]/div/a");
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);
				}else counter++;
				if(counter>15)
					break;
			}
			
			//--------------------------------------------------------------------//
			//  Step-6: Add User//
			//--------------------------------------------------------------------//
			assertTrue(createNewUser(selenium,mySettingsData,uniqueName),"",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Home page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnBackButton),"Could not click the back button",selenium,ClassName,MethodName);
			//assertTrue(click(selenium,lnkSystemSetting),"Could not click the system setting link;More details :"+ mySettingsData.toString());
			
			//--------------------------------------------------------------------//
			//  Step-8: Sign out the Application//
			//--------------------------------------------------------------------//
			selenium.clickAt(lnkTopMenu, "");
			selenium.focus(lnkTopMenu);
			selenium.fireEvent(lnkTopMenu, "keypress");
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,lnkTopMenu),"Could not click the Top Menu Link;More details :"+ mySettingsData.toString());
			assertTrue(click(selenium,lnkSignout),"Could not click the Sign out Link;More details :"+ mySettingsData.toString(),selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnYesButton),"Could not click the Yes button;More details :"+ mySettingsData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Login to the Application//
			//--------------------------------------------------------------------//
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, mySettingsData.userName1+uniqueName, mySettingsData.password),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Navigate to Top Menu//
			//--------------------------------------------------------------------//
			/*waitForPageLoad(selenium);
			selenium.focus(lnkTopMenu);
			assertTrue(click(selenium,lnkTopMenu),"Could not click the Top Menu Link;More details :"+ mySettingsData.toString());*/
			
			selenium.clickAt(lnkTopMenu, "");
			selenium.focus(lnkTopMenu);
			selenium.fireEvent(lnkTopMenu, "keypress");
			selenium.keyPress(lnkTopMenu, "\\13");
			click(selenium,"//div[5]/div/div");
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMySetting),"Could not click the My setting link;More details :"+ mySettingsData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnResetPassword),"Could not click the reset Password Link;More details :"+ mySettingsData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtCurrentPassword,mySettingsData.password),"Could not type the current Password;More details:"+mySettingsData.toString(),selenium,ClassName,MethodName);
			assertTrue(type(selenium,txtNewPassword,mySettingsData.newPassword),"Could not type the new Password;More details:"+mySettingsData.toString(),selenium,ClassName,MethodName);
			assertTrue(type(selenium,txtConfirmPassword,mySettingsData.newConfirmPassword),"Could not type the new confirm Password;More details:"+mySettingsData.toString(),selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the Top Menu Link;More details :"+ mySettingsData.toString(),selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnOk),"Could not click the Top Menu Link;More details :"+ mySettingsData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11: Sign out the Application//
			//--------------------------------------------------------------------//
			//assertTrue(click(selenium,lnkSystemSetting),"Could not click the system setting link;More details :"+ mySettingsData.toString());
			//assertTrue(click(selenium,btnBackButton),"Could not click the back button");
			//assertTrue(click(selenium,lnkSystemSetting),"Could not click the system setting link;More details :"+ mySettingsData.toString());
			waitForPageLoad(selenium);
			selenium.focus(lnkTopMenu);
			
			selenium.clickAt(lnkTopMenu, "");
			selenium.focus(lnkTopMenu);
			selenium.fireEvent(lnkTopMenu, "keypress");
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,lnkTopMenu),"Could not click the Top Menu Link;More details :"+ mySettingsData.toString());
			assertTrue(click(selenium,lnkSignout),"Could not click the Sign out Link;More details :"+ mySettingsData.toString(),selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnYesButton),"Could not click the Yes button;More details :"+ mySettingsData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: Login to the Application//
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtAccountNumber,userAccount),"Could not type the current Password;More details:"+mySettingsData.toString(),selenium,ClassName,MethodName);
			assertTrue(type(selenium,txtUserName,mySettingsData.userName1+uniqueName),"Could not type the new Password;More details:"+mySettingsData.toString(),selenium,ClassName,MethodName);
			assertTrue(type(selenium,txtPassword,mySettingsData.newPassword),"Could not type the new confirm Password;More details:"+mySettingsData.toString(),selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnLogin),"Could not click the Top Menu Link;More details :"+ mySettingsData.toString(),selenium,ClassName,MethodName);
			
			assertTrue(type(selenium,txtCurrentPassword,mySettingsData.newPassword),"Could not type the current Password;More details:"+mySettingsData.toString(),selenium,ClassName,MethodName);
			assertTrue(type(selenium,txtNewPassword,mySettingsData.newPassword),"Could not type the new Password;More details:"+mySettingsData.toString(),selenium,ClassName,MethodName);
			assertTrue(type(selenium,txtConfirmPassword,mySettingsData.newPassword),"Could not type the new confirm Password;More details:"+mySettingsData.toString(),selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnContinue),"Could not click the Top Menu Link;More details :"+ mySettingsData.toString(),selenium,ClassName,MethodName);
			
			assertTrue(isElementPresent(selenium,lnkSystemSetting),"System Setting link is present",selenium,ClassName,MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}