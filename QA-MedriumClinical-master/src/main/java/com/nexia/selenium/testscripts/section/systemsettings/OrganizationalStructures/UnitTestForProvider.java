package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForProvider extends AbstractSystemSettingsTest{
	
	/*@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider type with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void providerTypeWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_001";
		providerData.fetchSystemSettingTestData();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "provider code with minimum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void providerCodeWithMinLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_002";
		providerData.fetchSystemSettingTestData();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "provider code with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void providerCodeWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_003";
		providerData.fetchSystemSettingTestData();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Last name with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void lastNameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_004";
		providerData.fetchSystemSettingTestData();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "First name with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void firstNameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_005";
		providerData.fetchSystemSettingTestData();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "cell phone number with alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void cellPhoneNumWithAlphanum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_006";
		providerData.fetchSystemSettingTestData();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Cell phone number with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void cellPhoneNumWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_007";
		providerData.fetchSystemSettingTestData();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Pager with alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void pagerWithAlphanum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_008";
		providerData.fetchSystemSettingTestData();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Pager with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void pagerWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_009";
		providerData.fetchSystemSettingTestData();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Email id with invalid format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void emailIdWithInvalidFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_010";
		providerData.fetchSystemSettingTestData();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}*/
	
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Email id with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void emailIdWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_011";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Maximum FTp with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void maxiumFTPWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_012";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Hours worked with max value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void hoursWorkedWithMaxValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_013";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Hours worked with negative value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void hoursWorkedWithNegativeValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_014";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "comments with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void commentsWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_015";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "zip code with alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void zipCodeWithAlphaNum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_016";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Zip code with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void zipCodeWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_017";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Office phone with alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void officePhoneWithAlphanum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_018";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Office phone with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void officePhoneWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_019";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Office Extn with alphnumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void officeExtnWithAlphnum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_020";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Office extn with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void officeExtnWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_021";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only	
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax with alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void faxWithAlphNum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_022";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Fax with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void faxWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_021";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Billing address zip code with alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void billingAddrZipCodeWithAlphanum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_024";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Billing address zip code with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void billingAddrZipCodeWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_025";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "DEA with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void dEAWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_026";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
		}
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "UPIN with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void uPINWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_027";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
		}
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "NPI with alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void nPIWithAlphanum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_028";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
		}
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "NPI with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void nPIWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_029";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
		}
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Type with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void typeWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_030";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Group with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void groupWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_031";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "value with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void valueWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_032";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "value with invalid format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void valueWithInvalidFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_033";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "cell Phone With Min Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void cellPhoneWithMinLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_034";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "cell Phone With Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void cellPhoneWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_035";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "pager With Min Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void pagerWithMinLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_036";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "pagerWithMaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void pagerWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_037";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "officePhoneWithMinLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void officePhoneWithMinLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_038";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "officePhoneWithMaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void officePhoneWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_039";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "faxWithMinLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void faxWithMinLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_040";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "faxWithMaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void faxWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_041";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "signatureDateWithFutureDate")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void signatureDateWithFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_042";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
		}
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "signatureDateWithInvalidData")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void signatureDateWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_043";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
		}
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "signatureDateWithInvalidDate")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void signatureDateWithInvalidDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_044";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
		}
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "npiWithMinLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void npiWithMinLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_045";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
		}
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "npiWithMinLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void emailWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest providerData = new SystemsSettingsUnitTest();
		providerData.workSheetName = "UnitTest_SS_Provider";
		providerData.testCaseId = "TC_SSP_046";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
		}
	}
	
	/**
	 * addProvider
	 * function to add Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     June 07, 2012
	 */
	
	public boolean addProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemsSettingsUnitTest providerData) throws InterruptedException, IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,providerData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Program //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	

			if(!providerData.groupName.equals("")){
				addIdentifier(selenium,providerData);
			
			assertTrue(click(selenium,lnkOrgStructuresId),"Could not click on organisation structure link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);}
			assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:  Enter Test Data and Submit                               //
			//--------------------------------------------------------------------//
			
			assertTrue(submitProvider(selenium,providerData),"Provider failed", selenium, ClassName, MethodName);
			providerData.alert= providerData.alert == null ? providerData.alert = "" : providerData.alert.trim();
			if(!providerData.alert.equals("")){
			assertTrue(isElementPresent(selenium, providerData.alert), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, providerData.alert).contains(providerData.alertMessage), "The expected validation message should contain the text - "+ providerData.alertMessage + " The actual validation message shown - " + getText(selenium, providerData.alert), selenium, ClassName, MethodName);
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"+ providerData.toString(), selenium, ClassName, MethodName);
			returnValue=false;
		}
		return returnValue;
	}


	/**
	 * submitProvider
	 * function to submit a Provider.
	 * @throws IOException 
	 
	 
	 * @since  	     June 07, 2012
	 */	
	public boolean submitProvider(Selenium selenium,SystemsSettingsUnitTest providerData) throws IOException{
		try{
			
			selectValueFromAjaxList(selenium,ajxProviderTypesuggestBox,providerData.providerType);
			assertTrue(type(selenium,txtProviderCode,providerData.providerCode),"Could not enter the provider code", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxTitleSuggestBox,providerData.title);
			assertTrue(type(selenium, txtFirstName,providerData.firstName),"Could not enter the  name"+ providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLastName,providerData.lastName),"Could not type a last name"+ providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMiddleName,providerData.middleName),"Could not type a middle name"+ providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCredentials,providerData.credentials),"Could not type credentials"+ providerData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,txtSpecialtySuggestBox,providerData.speciality);
			click(selenium,btnAddSpecialtyButton);
			selectValueFromAjaxList(selenium,ajxGendersuggestBox ,providerData.gender);
			selectValueFromAjaxList(selenium,ajxLanguagesuggestBox,providerData.language);
			click(selenium,btnAddLanguageButton);
			assertTrue(type(selenium,txtCellPhone ,providerData.cellPhone),"Could not type cell phone number"+ providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPager,providerData.pager),"Could not type pager number"+ providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtEmail ,providerData.email),"Could not type email"+ providerData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxMaximumFTESuggestBoxsuggestBox,providerData.maximumFte);
			assertTrue(type(selenium,ajxHoursWorked,providerData.hoursWorked),"Could not type hours worked"+ providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtcmt,providerData.comments),"Could not type comments"+ providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtMailingStreet1,providerData.address1),"Could not type street"+ providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingStreet2 ,providerData.address2),"Could not type street2"+ providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingCity,providerData.city),"Could not type city"+ providerData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,txtMailingStatesuggestBox,providerData.state);
			assertTrue(type(selenium,txtMailingZipPostalCode,providerData.zipcode),"Could not type Zip Code"+ providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(txtMailingCountrysuggestBox, "\\9");
			click(selenium,btnYes);
			waitForElementToEnable(selenium,txtMailingCity);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtMailingStatesuggestBox);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtMailingCountrysuggestBox);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,"mailingOfficePhone",providerData.officePhone),"Could not type office phone"+ providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingOfficePhoneExt,providerData.officePhone1),"Could not type office phone extno"+ providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingFax,providerData.fax),"Could not type fax number,"+providerData.toString(), selenium, ClassName, MethodName);
			if(providerData.billingAddressCheck.equalsIgnoreCase("No"))
			{
				if(isChecked(selenium,chkSameAsMailingAddresscheckbox))
				assertTrue(click(selenium,chkSameAsMailingAddresscheckbox), "Could not click Mailing box",selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtBillingStreet1,providerData.billingStreet1), "Could not type the billing address"+providerData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtBillingStreet2,providerData.billingStreet2), "Could not type the billing address2"+providerData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtCityPro,providerData.billingCity), "Could not type the billing city"+providerData.toString(), selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxBillingStatesuggestBox,providerData.billingState);
				assertTrue(type(selenium,txtBillingZipPostalCode,providerData.billingZipcode), "Could not type the billing zip code"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selenium.keyPress(txtBillingCountrysuggestBox, "\\9");
				click(selenium,btnYes);
				waitForElementToEnable(selenium, txtCityPro);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,ajxBillingStatesuggestBox);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,txtBillingCountrysuggestBox);
				waitForPageLoad(selenium);
			}
			if(providerData.billingInfoCheck.equals("Yes")){
				click(selenium, chkSignatureOnFilecheckbox);
				enterDate(selenium,txtSignatureDate,providerData.signatureDate);
			}
			selectValueFromAjaxList(selenium,ajxReportMethodsuggestBox,providerData.reportMethod);
			type(selenium,  txtDea ,providerData.dEA);
			type(selenium,txtUpinPro,providerData.uPIN);
						
			type(selenium,txtNpi,providerData.npi);
			waitForPageLoad(selenium);
			click(selenium,"xpath=(//button[@type='button'])[7]");
			if(!(providerData.groupName.equalsIgnoreCase(""))){
				selectValueFromAjaxList(selenium,ajxPractice,providerData.practice);
				selectValueFromAjaxList(selenium,ajxGroupName,providerData.groupName);
				selectValueFromAjaxList(selenium,ajxGroupFor,providerData.groupFor);
				type(selenium,ajxIdTypeMask,providerData.idTypeMask);
			}
			waitForPageLoad(selenium);
			
			if(providerData.testCaseId.equals("TC_SSP_046")){
				click(selenium,"//span/input");
			}
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean addIdentifier(Selenium selenium,SystemsSettingsUnitTest providerData) throws IOException{
		boolean returnValue=true;
		try{
			
			
			//---------------------------------------------------------- ----------//
			//  Step-1: Deleting existing Identifier Groups  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkIdentifierGroup),"Delete Identifier group failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllIdentifiersGroup(selenium),"Deletio failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-2: Add a new Identifier Group
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			SystemSettingsLib idGroupData = new SystemSettingsLib();
			idGroupData.workSheetName = "CreateIdentifierGroups";
			idGroupData.testCaseId = "TC_IDG_001";
			idGroupData.fetchSystemSettingTestData();
			createIdGroup(selenium,idGroupData);
			
			//Navigate to Identifier Types
			
			assertTrue(click(selenium,lnkIdentifierType),"Could not click on Identifier Type link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-3: Deleting existing Identifier Type  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllIdentifiersTypes(selenium),"Delete Indentifier type failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-4: Add a new Identifier Group
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddIdentifierType),"Could not click on Add Identifier Type link:" + providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			SystemSettingsLib idTypeData = new SystemSettingsLib();
			idTypeData.workSheetName = "CreateIdentifierTypes";
			idTypeData.testCaseId = "TC_IDT_003";
			idTypeData.fetchSystemSettingTestData();
			createIdType(selenium,idTypeData);
			return returnValue;
		}
		catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
}
