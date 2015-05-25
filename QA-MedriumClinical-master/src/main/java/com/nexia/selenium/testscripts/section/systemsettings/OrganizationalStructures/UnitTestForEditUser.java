package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForEditUser extends AbstractSystemSettingsTest{
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify Password field with blank while editing")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPasswordWithBlankinEdit(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest userData= new SystemsSettingsUnitTest();
		userData.workSheetName = "UnitTest_SS_EditUser";
		userData.testCaseId = "TC_SS_EUS_001";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify Confirm Password field with blank while editing")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyConfirmPasswordWithBlankinEdit(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest userData= new SystemsSettingsUnitTest();
		userData.workSheetName = "UnitTest_SS_EditUser";
		userData.testCaseId = "TC_SS_EUS_002";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Double click Reset password without any alert")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDoubleClickResetPassword(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest userData= new SystemsSettingsUnitTest();
		userData.workSheetName = "UnitTest_SS_EditUser";
		userData.testCaseId = "TC_SS_EUS_003";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	/**
	 * editUser
	 * function to edit User
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		InterruptedException 
	 
	 * @since  	    June 05, 2010
	 */
	public boolean editUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemsSettingsUnitTest userData) throws IOException{
		Selenium selenium = null;
		String alertText="";
		boolean returnValue=true;
	
		try{
			
			//--------------------------------------------------------------------//
			// Login to the application//
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + userData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, userData.userName, userData.userPassword);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,userData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to system settings  //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3: Create an user //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:  Enter Test Data and Submit                               //
			//--------------------------------------------------------------------//
			if(!editUserUnitTest(selenium, userData,uniqueName) && userData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
				if(isElementPresent(selenium,"//p")){
					alertText = getText(selenium, "//p");
					if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(userData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US")))){
				   	 returnValue=true;			
					}
					else{
						Assert.fail("An unxpected Alert is displayed with message; The Expected :"+userData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + userData.toString());
					}
				}
				else{
					Assert.fail("Alert is not getting displayed; The Expected :"+userData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + userData.toString());
				}	
			}else if(userData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
				returnValue=true;
			}else{
				if(userData.resetPassword.contains("No")){
					if(isElementPresent(selenium,btnEdit1))
						returnValue =true;
				}
			}
			waitForPageLoad(selenium);
			click(selenium,btnCancel);
			waitForPageLoad(selenium);
			if(getText(selenium,txtLastName1).contains(userData.lastName+uniqueName)){
				click(selenium,"//div[@id='users']/table/tbody/tr/td[2]/div/a");
				assertTrue(click(selenium,btnYes),"Could not click the yes button", selenium, ClassName, MethodName);
				returnValue=true;
			}
			int count=1;
			int counter=(Integer)selenium.getXpathCount(txtLastName1);
			while(getText(selenium,vfySearchDepartment).contains(userData.lastName+uniqueName)&&count<counter){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td").contains(userData.lastName+uniqueName)){
					assertTrue(click(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td[2]/div/a"),"Could not delete the User", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnYes),"Could not click the yes button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					returnValue=true;
					break;
				}
				count++;
			}
			
		}	
		catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + userData.toString(), selenium, ClassName, MethodName);
			returnValue=false;
		}
		return returnValue;
	}
}
