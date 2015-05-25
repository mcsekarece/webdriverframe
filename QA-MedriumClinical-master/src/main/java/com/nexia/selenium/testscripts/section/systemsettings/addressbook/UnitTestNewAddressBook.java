package com.nexia.selenium.testscripts.section.systemsettings.addressbook;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestNewAddressBook extends AbstractSystemSettingsTest{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "First Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void firstNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_001";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Last Name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void lastNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_002";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Department with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void departmentWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_003";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "department with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void departmentWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_004";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "contact company with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void contactCompanyWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_005";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "address1 with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void address1WithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_006";
		contactTypeTestData.fetchSystemSettingTestData();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "address2 with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void address2WithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_007";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "primary phone number with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void primaryPhoneNumberWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_011";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

/*	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Primary phone type blank with number filled")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void primaryPhoneTypeBlankWithNumberFilled(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_012";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "secondary phone number is Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void secondaryPhoneNumberBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){

		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_013";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "secondary phone type is Blank with nnumber Filled")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void secondaryPhoneTypeBlankWithnumberFilled(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){

		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_014";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "tertiary phone number blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void tertiaryPhoneNumberBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){

		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_015";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "tertiary phone type is blank with number filled")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void tertiaryPhoneTypeBlankWithNumberFilled(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){

		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_016";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}*/

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "contact type with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void contactTypeWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_017";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "job title with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void jobTitleWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_018";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}


	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "zip code with minimum Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void zipCodeWithMinLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_021";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "zip code with max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void zipCodeWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_022";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "zip code with max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void zipCodeWithSpecialChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_023";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "zip code with max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void zipCodeWithAlphanumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_024";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "mail id with space between the address")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void mailIdWithSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_025";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "mail id with invalid format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void mailIdWithInvalidFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_026";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Mail id with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void mailIdWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_027";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "primary phone number with alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void primaryNumberWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_028";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

/*	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "secondary phone number with alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void secondaryPhoneNumberWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){

		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_029";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "tertiary phone number with alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void tertiaryPhoneNumberWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){

		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_030";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}*/

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "primary number with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void primaryNumberWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_031";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

/*	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "secondary number with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void secondaryNumberWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){

		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_032";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "tertiary phpne number with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void tertiaryPhoneNumberWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){

		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_033";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}*/

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "primary Extension number with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void primaryExtnNumWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_034";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

/*	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "secondary Extension number with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void secondaryExtnNumWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){

		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_035";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "tertiary Extension number with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void tertiaryExtnNumWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){

		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_036";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}*/

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "primary Extension number with alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void primaryExtnNumWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_037";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}


/*	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "tertiary Extension number with Alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void tertiaryExtnNumberWithAlphanumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){

		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_038";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Secondary Extension number with alpha numeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void secondaryExtnNumWithAlphanumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){

		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_039";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}*/
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Web Address with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void webAddrWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_040";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "comments with max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void commentWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest contactTypeTestData= new SystemsSettingsUnitTest();
		contactTypeTestData.workSheetName = "UnitTest_SS_AddressBook";
		contactTypeTestData.testCaseId = "TC_AB_041";
		contactTypeTestData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, contactTypeTestData);
	}



	/**
	 * addAddressBook
	 * function to add a Contact Type
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	    Feb 09, 2012
	 */  
	
	public boolean addAddressBook(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemsSettingsUnitTest contactTypeTestData) throws IOException{
		
		Selenium selenium = null;
		String alertText="";
		boolean returnValue=true;
	
		try{
			
			//--------------------------------------------------------------------//
			// Login to the application//
			//--------------------------------------------------------------------//			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + contactTypeTestData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, contactTypeTestData.userName, contactTypeTestData.userPassword);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,contactTypeTestData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-------------------------------------------------------------------------//
			//  Step-3: Navigation to the settings page and click on Address Book Link //
			//-------------------------------------------------------------------------// 
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			SystemsSettingsUnitTest epData= new SystemsSettingsUnitTest();
			
			epData.workSheetName = "EP_AddressBook";
			epData.testCaseId = "TC_AB_001";
			epData.fetchSystemSettingTestData();
			
			assertTrue(click(selenium,lnkEnterpriseVariables),"Could not click on Identifier Group link:" + epData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			type(selenium, txtSearchBox,epData.contactValue);
			click(selenium,"searchButtonId");
			waitForPageLoad(selenium);
			click(selenium,lnkDelete);
			click(selenium, btnYes);
			assertTrue(click(selenium,btnAddenterprise),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium, ajxSuggestBox,epData.contactType), "Could not select from list", selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			type(selenium,txtVariableBox,epData.contactValue);
			click(selenium,"save");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAddressBook ),"Could not click the Admin Address Book; More details"+contactTypeTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddressBookEntry),"Could not click the add Address Book; More details"+contactTypeTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:  Enter Test Data and Submit                               //
			//--------------------------------------------------------------------//			
			try {
				if(!addAddress(selenium, contactTypeTestData) && contactTypeTestData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
					if(isElementPresent(selenium,"//p")){
						alertText = getText(selenium, "//p");
						if(alertText.toLowerCase(new java.util.Locale("en", "US")).contains(contactTypeTestData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US"))))
						{
							return returnValue;			
						}else{
							assertTrue(false, "An unexpected Alert is displayed with message; The Expected :"+contactTypeTestData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + contactTypeTestData.toString(), selenium, ClassName, MethodName);							
						}
					}else{
						assertTrue(false, "Alert is not getting displayed; The Expected :"+contactTypeTestData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + contactTypeTestData.toString(), selenium, ClassName, MethodName);
					}	
				}else if(contactTypeTestData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
					return returnValue;
				}else{
					assertTrue(false, "Expected Alert is not displayed; The Expected :"+contactTypeTestData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + contactTypeTestData.toString(), selenium, ClassName, MethodName);					
				}
			} catch (InterruptedException e) {
				assertTrue(false, "Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + contactTypeTestData.toString(), selenium, ClassName, MethodName);
				returnValue=false;
			}
		}	
		catch (RuntimeException e) {
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			returnValue=false;
		}
		return returnValue;
	}
	
	
	 /**
	 * addAddress
	 * function to add a AddressBook
	 * @param 		selenium
	 * @throws IOException 
	 * @throws 		: InterruptedException 
	 
	 * @since  	     may 17, 2012
	 */  
	
	public boolean addAddress(Selenium selenium, SystemsSettingsUnitTest contactTypeTestData ) throws InterruptedException, IOException{
		try{
			if(contactTypeTestData.contactLevel.equalsIgnoreCase("Global"))
			{
				assertTrue(click(selenium,rdGlobal), "could not click contact level", selenium, ClassName, MethodName);
			}
			else{
				assertTrue(click(selenium,rdLocal ), "could not click contact level", selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,  ajxContactSuggestBox, contactTypeTestData.contactType);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtAddContactCompany, contactTypeTestData.contactCompany),"Could not Enter the Company;More Details:"+contactTypeTestData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,  ajxTitleSuggestBox,contactTypeTestData.salutation);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtAddBookLastName, contactTypeTestData.lastName),"Could not enter Last Name; More Details:" + contactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkFirstName, contactTypeTestData.firstName),"Could not enter First Name; More Details:" + contactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkMiddleName,contactTypeTestData.middleName),"Could not enter the Middle name;More Details:"+contactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, "xpath=(//input[@type='text'])[11]",contactTypeTestData.jobTitle),"Could not Enter the Job Name;More Details"+contactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtcmt,contactTypeTestData.comments),"Could not type the Comments; More Details"+contactTypeTestData.toString(), selenium, ClassName, MethodName);
			if(contactTypeTestData.testCaseId.contains("TC_AB_041")){
				assertTrue(click(selenium, "comments"),"Could not click on comments", selenium, ClassName, MethodName);
				selenium.keyPress("comments",btnEnter);
				return false;
			}
			assertTrue(type(selenium, txtAddBkDept, contactTypeTestData.department),"Could not enter Department; More Details:" + contactTypeTestData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy1suggestBox,contactTypeTestData.telephoneType1);
			assertTrue(type(selenium, txtAddBkPrimaryPhone, contactTypeTestData.telephoneNo1),"Could not enter primary phone number; More Details:" + contactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,  txtAddBkPrimaryPhoneExt, contactTypeTestData.telephoneextnNo1),"Could not enter primary extn number; More Details:" + contactTypeTestData.toString(), selenium, ClassName, MethodName);
/*			selectValueFromAjaxList(selenium, "id=commType2suggestBox",contactTypeTestData.telephoneType2);
			assertTrue(type(selenium, "addressBookSecondaryPhone", contactTypeTestData.telephoneNo2),"Could not enter secondary  Phone number; More Details:" + contactTypeTestData.toString());
			assertTrue(type(selenium, "addressBookSecondaryPhoneExt", contactTypeTestData.telephoneextnNo2),"Could not enter secondary extn number; More Details:" + contactTypeTestData.toString());
			selectValueFromAjaxList(selenium, "id=commType3suggestBox",contactTypeTestData.telephoneType3);
			assertTrue(type(selenium, "addressBookTertiaryPhone", contactTypeTestData.telephoneNo3),"Could not enter tertiary number; More Details:" + contactTypeTestData.toString());
			assertTrue(type(selenium, "addressBookTertiaryPhoneExt", contactTypeTestData.telephoneextnNo3),"Could not enter tertiary extn number; More Details:" + contactTypeTestData.toString());*/
			
			assertTrue(type(selenium, txtAddBkAdd1,contactTypeTestData.address1),"Could not enter the Street1;More Details:"+contactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddrBkAdd2,contactTypeTestData.address2),"Could not enter the Street2;More Details:"+contactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddBkCity, contactTypeTestData.city),"Colud not enter the city;More Details"+contactTypeTestData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxAddBkStateSuggestBox,contactTypeTestData.state);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtAddBkZipCode, contactTypeTestData.zipcode),"Could not enter Zip; More Details:" + contactTypeTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!(contactTypeTestData.testCaseId.equals("TC_AB_024")||contactTypeTestData.testCaseId.equals("TC_AB_021")||contactTypeTestData.testCaseId.equals("TC_AB_023"))){
				selenium.keyPress(ajxaddBkCountrySuggestBox,btnEnter1);
				waitForPageLoad(selenium);
				click(selenium,btnYesbutton);
				waitForPageLoad(selenium);
			}
			else{
				selectValueFromAjaxList(selenium, cmbAddBkCountrySuggestBox,contactTypeTestData.country);
			}
			assertTrue(type(selenium, txtAddBkEmail,contactTypeTestData.email),"Could not Enter the Mail;More Details:"+contactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkWebAdd,contactTypeTestData.webAddress),"Could not enter the Web Address;Mor Details"+contactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnAddSave),"Could not find save button; More Details:" + contactTypeTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			if(isElementPresent(selenium, btnAddressBookEntry )){
				return true;
			}else{
				return false;
				}
			}
		
			catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return false;
		}	
	}
}	