package com.nexia.selenium.testscripts.section.demographics.MySettings;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForMySettings extends AbstractHomeTest{
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "current Password With Blank space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void currentPasswordWithBlankspace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest mySettingsTestData = new HomeLibUnitTest();
		mySettingsTestData.workSheetName = "UnitTest_FV_PC_MySettings";
		mySettingsTestData.testCaseId = "UT_MS_001";
		mySettingsTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createMySettings(seleniumHost, seleniumPort, browser, webSite, userAccount, mySettingsTestData );	
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "New Password With Blank space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void newPasswordWithBlankspace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest mySettingsTestData = new HomeLibUnitTest();
		mySettingsTestData.workSheetName = "UnitTest_FV_PC_MySettings";
		mySettingsTestData.testCaseId = "UT_MS_002";
		mySettingsTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createMySettings(seleniumHost, seleniumPort, browser, webSite, userAccount, mySettingsTestData );	
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "confirm Password With Blank space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void confirmPasswordWithBlankspace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest mySettingsTestData = new HomeLibUnitTest();
		mySettingsTestData.workSheetName = "UnitTest_FV_PC_MySettings";
		mySettingsTestData.testCaseId = "UT_MS_003";
		mySettingsTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createMySettings(seleniumHost, seleniumPort, browser, webSite, userAccount, mySettingsTestData );	
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "new Password With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void newPasswordWithUnknownData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest mySettingsTestData = new HomeLibUnitTest();
		mySettingsTestData.workSheetName = "UnitTest_FV_PC_MySettings";
		mySettingsTestData.testCaseId = "UT_MS_005";
		mySettingsTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createMySettings(seleniumHost, seleniumPort, browser, webSite, userAccount, mySettingsTestData );	
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "confirm Password With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void confirmPasswordWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest mySettingsTestData = new HomeLibUnitTest();
		mySettingsTestData.workSheetName = "UnitTest_FV_PC_MySettings";
		mySettingsTestData.testCaseId = "UT_MS_006";
		mySettingsTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createMySettings(seleniumHost, seleniumPort, browser, webSite, userAccount, mySettingsTestData );	
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "current Password With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void currentPasswordWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest mySettingsTestData = new HomeLibUnitTest();
		mySettingsTestData.workSheetName = "UnitTest_FV_PC_MySettings";
		mySettingsTestData.testCaseId = "UT_MS_004";
		mySettingsTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createMySettings(seleniumHost, seleniumPort, browser, webSite, userAccount, mySettingsTestData );	
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "confirm Password must match new password")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void confirmPasswordMatchesNewPassword(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest mySettingsTestData = new HomeLibUnitTest();
		mySettingsTestData.workSheetName = "UnitTest_FV_PC_MySettings";
		mySettingsTestData.testCaseId = "UT_MS_007";
		mySettingsTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createMySettings(seleniumHost, seleniumPort, browser, webSite, userAccount, mySettingsTestData );	
	}
	/*@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = " Password should not be the same as username")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void newpasswordWithUserName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		HomeLibUnitTest mySettingsTestData = new HomeLibUnitTest();
		mySettingsTestData.workSheetName = "UnitTest_FV_PC_MySettings";
		mySettingsTestData.testCaseId = "UT_MS_008";
		mySettingsTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createMySettings(seleniumHost, seleniumPort, browser, webSite, userAccount, mySettingsTestData );	
	}*/
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = " Password should not be the same as username")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void newpasswordWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest mySettingsTestData = new HomeLibUnitTest();
		mySettingsTestData.workSheetName = "UnitTest_FV_PC_MySettings";
		mySettingsTestData.testCaseId = "UT_MS_009";
		mySettingsTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createMySettings(seleniumHost, seleniumPort, browser, webSite, userAccount, mySettingsTestData );	
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = " Password should not be the same as username")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void confirmPasswordWithIncorrectData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest mySettingsTestData = new HomeLibUnitTest();
		mySettingsTestData.workSheetName = "UnitTest_FV_PC_MySettings";
		mySettingsTestData.testCaseId = "UT_MS_010";
		mySettingsTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createMySettings(seleniumHost, seleniumPort, browser, webSite, userAccount, mySettingsTestData );	
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify unit test for create My Settings
	* @action 		  verifying unit test for create My Settings
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 27, 2012
	***************************************************************************************************/
	public boolean createMySettings(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,HomeLibUnitTest mySettingsTestData) throws IOException{
		Selenium selenium = null;	
		String alertText="";
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			// Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mySettingsTestData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, mySettingsTestData.userName, mySettingsTestData.userPassword);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,mySettingsTestData.switchRole),"",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkTopMenu),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMySetting),"Could not click my settings link",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnResetPassword),"Could not click my Reset password link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(!submitMySettings(selenium, mySettingsTestData) && mySettingsTestData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
				if(isElementPresent(selenium,"//p")){
					alertText = getText(selenium, "//p");
					if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(mySettingsTestData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US")))){
						return returnValue;			
					}else{
						Assert.fail("An unxpected Alert is displayed with message; The Expected :"+mySettingsTestData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + mySettingsTestData.toString());
					}
				}else{
					Assert.fail("Alert is not getting displayed; More Details :" + mySettingsTestData.toString());
				}	
			}else if(mySettingsTestData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
				return returnValue;
			}else{
				Assert.fail("Expected Alert is not displayed; The Expected :"+mySettingsTestData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + mySettingsTestData.toString());
			}
		}	
		catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean submitMySettings(Selenium selenium,HomeLibUnitTest mySettingsData) throws IOException{
		
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtCurrentPassword,mySettingsData.currentPassword),"Could not type current password",selenium,ClassName,MethodName);
		assertTrue(type(selenium,txtNewPassword,mySettingsData.newPassword),"Could not type new password",selenium,ClassName,MethodName);
		assertTrue(type(selenium,txtConfirmPassword,mySettingsData.newConfirmPassword),"Could not type new Confirm password",selenium,ClassName,MethodName);
		assertTrue(click(selenium,btnSave),"Could not click save button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,registerPatient)){
			return true;
		}
		else{
			return false;
		}
		
	}
}