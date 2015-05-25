package com.nexia.selenium.testscripts.section.systemsettings.passwordrules;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestsForPasswordRules extends AbstractHomeTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Pwd Length With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void pwdLengthWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest pwdData = new SystemsSettingsUnitTest();
		pwdData.workSheetName = "UnitTest_SS_PassWordRules";
		pwdData.testCaseId = "TC_SSPR_001";
		pwdData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPasswordRules(seleniumHost, seleniumPort, browser, webSite, userAccount, pwdData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "pwd Reuse With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void pwdReuseWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest pwdData = new SystemsSettingsUnitTest();
		pwdData.workSheetName = "UnitTest_SS_PassWordRules";
		pwdData.testCaseId = "TC_SSPR_002";
		pwdData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPasswordRules(seleniumHost, seleniumPort, browser, webSite, userAccount, pwdData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "pwd Expiry With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void pwdExpiryWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest pwdData = new SystemsSettingsUnitTest();
		pwdData.workSheetName = "UnitTest_SS_PassWordRules";
		pwdData.testCaseId = "TC_SSPR_003";
		pwdData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPasswordRules(seleniumHost, seleniumPort, browser, webSite, userAccount, pwdData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "pwd Failed Attempt WithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void pwdFailedAttemptWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest pwdData = new SystemsSettingsUnitTest();
		pwdData.workSheetName = "UnitTest_SS_PassWordRules";
		pwdData.testCaseId = "TC_SSPR_004";
		pwdData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPasswordRules(seleniumHost, seleniumPort, browser, webSite, userAccount, pwdData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "pwd Failed Attempt WithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void pwdZeroDayExpiry(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest pwdData = new SystemsSettingsUnitTest();
		pwdData.workSheetName = "UnitTest_SS_PassWordRules";
		pwdData.testCaseId = "TC_SSPR_005";
		pwdData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addPasswordRules(seleniumHost, seleniumPort, browser, webSite, userAccount, pwdData);
	}
	/**
	 * addPasswordRules
	 * function to add PasswordRules
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	    Aug 03, 2012
	 */
	public void addPasswordRules(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemsSettingsUnitTest pwdData) throws IOException{

		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pwdData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pwdData.userName, pwdData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pwdData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to Security Settings and navigate to Password Rules//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSecuritysetting),"Could not click on System settings link:" + pwdData .toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkPasswordRules),"Could not click on Password Rules link:" + pwdData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Create a new Passwor rules                                      //
			//--------------------------------------------------------------------//
			assertTrue(submitRules(selenium,pwdData),"Password Rules edition failed", selenium, ClassName, MethodName);
			pwdData.validationFieldID = pwdData.validationFieldID == null ? pwdData.validationFieldID = "" : pwdData.validationFieldID.trim();
			assertTrue(isElementPresent(selenium, pwdData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, pwdData.validationFieldID).contains(pwdData.validationMessage), "The expected validation message should contain the text - "+ pwdData.alertMessage + " The actual validation message shown - " + getText(selenium, pwdData.validationFieldID), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnCancl),"Could not click on cancel button:" + pwdData .toString(), selenium, ClassName, MethodName);
			
		}catch (RuntimeException e) {
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
	
	
	/**
	 * submitRules
	 * function to submit a Rules
	 * @throws IOException 
	 * @since  	    August 03, 2012
	 */
	
	
	public boolean submitRules(Selenium selenium, SystemsSettingsUnitTest pwdData) throws IOException{
		
		try{	
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"//button[contains(text(),'Edit')]"),"Could not click on Edit Password Rules button:" + pwdData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPwdLength,pwdData.pwdlength),"Could not enter password length; More Details :" + pwdData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtresetsBeforeReuse,pwdData.resetsBeforeReuse),"Could not enter resets Before Reuse; More Details :" + pwdData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtExpires,pwdData.expires),"Could not enter expires length; More Details :" + pwdData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtfailedAttempts,pwdData.failedAttempts),"Could not enter failed Attempts; More Details :" + pwdData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click on save button:" + pwdData .toString(), selenium, ClassName, MethodName);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + pwdData.toString(), selenium, ClassName, MethodName);
			return false;
		}
	}
 }