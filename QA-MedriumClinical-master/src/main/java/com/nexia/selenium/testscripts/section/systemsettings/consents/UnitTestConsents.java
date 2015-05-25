package com.nexia.selenium.testscripts.section.systemsettings.consents;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestConsents extends AbstractSystemSettingsTest{
	
/*	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "consent Name With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void consentNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest consentData = new SystemsSettingsUnitTest();
		consentData.workSheetName = "UnitTest_SS_Constents";
		consentData.testCaseId = "TC_SSCON_001";
		consentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		systemSettingAddConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "consent Type With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void consentTypeWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest consentData = new SystemsSettingsUnitTest();
		consentData.workSheetName = "UnitTest_SS_Constents";
		consentData.testCaseId = "TC_SSCON_002";
		consentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		systemSettingAddConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "restriction Level With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void restrictionLevelWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest consentData = new SystemsSettingsUnitTest();
		consentData.workSheetName = "UnitTest_SS_Constents";
		consentData.testCaseId = "TC_SSCON_003";
		consentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		systemSettingAddConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentData);
	}*/
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "validFor With Char")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void validForWithChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest consentData = new SystemsSettingsUnitTest();
		consentData.workSheetName = "UnitTest_SS_Constents";
		consentData.testCaseId = "TC_SSCON_004";
		consentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		systemSettingAddConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "validFor With Special Char")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void validForWithSpecialChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest consentData = new SystemsSettingsUnitTest();
		consentData.workSheetName = "UnitTest_SS_Constents";
		consentData.testCaseId = "TC_SSCON_005";
		consentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		systemSettingAddConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "validFor With Alphanumeric And Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void validForWithAlphanumericAndSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest consentData = new SystemsSettingsUnitTest();
		consentData.workSheetName = "UnitTest_SS_Constents";
		consentData.testCaseId = "TC_SSCON_006";
		consentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		systemSettingAddConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentData);
	}  
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "validFor With Numeric And Special Chars")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void validForWithNumericAndSpecialChars(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest consentData = new SystemsSettingsUnitTest();
		consentData.workSheetName = "UnitTest_SS_Constents";
		consentData.testCaseId = "TC_SSCON_007";
		consentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		systemSettingAddConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentData);
	}  
	
	/**
	 * systemSettingAddConsents
	 *  function to system Setting Add Consents
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	     May 02, 2012
	 */
	
	public void systemSettingAddConsents(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemsSettingsUnitTest consentData) throws Exception{
		
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			//--------------  Step-1: Login to the application  ------------------//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + consentData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, consentData.userName, consentData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,consentData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//-----------------------Step-3: Go to System Setting-----------------// 
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			click(selenium,lnkSecuritysetting);
			
			click(selenium,lnkconsentList);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------------Step-4: Verify the Unit Test-------------------// 
			//--------------------------------------------------------------------//	
			click(selenium,btnConsent);
			waitForPageLoad(selenium);
			
			assertTrue(createConsents_UnitTest(selenium,consentData),"Creation failed", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,consentData.alert),"The Validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,consentData.alert).contains(consentData.alertMessage),"The expected validation message should contain the text - "+consentData.alertMessage+ " The actual validation message shown - " +getText(selenium,consentData.alert), selenium, ClassName, MethodName);
		
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}
