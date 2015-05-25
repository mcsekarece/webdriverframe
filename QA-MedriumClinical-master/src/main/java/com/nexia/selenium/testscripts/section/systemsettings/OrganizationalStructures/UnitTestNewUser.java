package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestNewUser extends AbstractSystemSettingsTest{
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Last Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLastNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest userData= new SystemsSettingsUnitTest();
		userData.workSheetName = "UnitTest_SS_User";
		userData.testCaseId = "TC_SS_US_001";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addNewUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFirstNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest userData= new SystemsSettingsUnitTest();
		userData.workSheetName = "UnitTest_SS_User";
		userData.testCaseId = "TC_SS_US_002";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addNewUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "User Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUserNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest userData= new SystemsSettingsUnitTest();
		userData.workSheetName = "UnitTest_SS_User";
		userData.testCaseId = "TC_SS_US_003";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addNewUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Password with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPasswordWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest userData= new SystemsSettingsUnitTest();
		userData.workSheetName = "UnitTest_SS_User";
		userData.testCaseId = "TC_SS_US_004";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addNewUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Confirm password with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyConfirmPasswordWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest userData= new SystemsSettingsUnitTest();
		userData.workSheetName = "UnitTest_SS_User";
		userData.testCaseId = "TC_SS_US_005";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addNewUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "User role with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUserRoleWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest userData= new SystemsSettingsUnitTest();
		userData.workSheetName = "UnitTest_SS_User";
		userData.testCaseId = "TC_SS_US_007";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addNewUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Practice with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPracticeWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest userData= new SystemsSettingsUnitTest();
		userData.workSheetName = "UnitTest_SS_User";
		userData.testCaseId = "TC_SS_US_006";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addNewUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify password mismatch")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPasswordMismatch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest userData= new SystemsSettingsUnitTest();
		userData.workSheetName = "UnitTest_SS_User";
		userData.testCaseId = "TC_SS_US_008";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addNewUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify password with incorrect format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPasswordWithIncorrectFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{

		SystemsSettingsUnitTest userData= new SystemsSettingsUnitTest();
		userData.workSheetName = "UnitTest_SS_User";
		userData.testCaseId = "TC_SS_US_009";
		userData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addNewUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}
	/**
	 * addNewUser
	 * function to add New User
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		InterruptedException 
	 * 
	 
	 * @since  	    June 05, 2010
	 */
	public boolean addNewUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemsSettingsUnitTest userData) throws IOException{
	    Selenium selenium = null;
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
			assertTrue(switchRole(selenium,userData.switchRole), "Switch role failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to system settings  //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);				
			isElementPresent(selenium,lnkOrgStructuresId);
			//--------------------------------------------------------------------//
			//  Step-3:  Enter Test Data and Submit                               //
			//--------------------------------------------------------------------//
			assertTrue(createUserUnitTest(selenium,userData),"Provider failed", selenium, ClassName, MethodName);
			//providerData.alert = providerData.alert == null ? providerData.alert= "" : providerData.alert.trim();
			assertTrue(isElementPresent(selenium, userData.alert), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, userData.alert).contains(userData.alertMessage), "The expected validation message should contain the text - "+ userData.alertMessage + " The actual validation message shown - " + getText(selenium, userData.alert), selenium, ClassName, MethodName);
			} catch (RuntimeException e) {
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + userData.toString(), selenium, ClassName, MethodName);
				returnValue=false;
			}
			return returnValue;
	}
}
