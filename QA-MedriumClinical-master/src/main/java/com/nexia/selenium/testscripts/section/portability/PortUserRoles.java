package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class PortUserRoles extends AbstractSystemSettingsTest {
	int counter = 0;
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles1(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_001";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles2(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_002";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles3(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_003";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles4(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_004";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles5(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_005";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles6(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_006";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles7(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_007";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles8(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_008";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles9(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_009";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles10(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_010";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles11(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_011";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles12(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_012";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles13(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_013";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles14(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_014";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles15(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_015";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles16(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_016";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles17(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_017";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles18(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_018";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles19(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_019";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles20(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_020";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles21(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_021";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles22(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_022";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles23(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_023";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles24(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_024";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles25(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_025";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles26(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_026";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles27(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_027";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles28(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_028";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles29(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_029";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create Biller Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles30(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_030";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create Biller Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles31(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_031";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create Biller Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles32(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_032";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create Biller Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles33(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_033";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create Biller Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles34(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_034";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	//Added today - 34 is already used
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create Biller Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles35(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_035";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability"}, description = "Create ChartManagement Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createUserRoles36(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib userRoleData = new SystemSettingsLib();
		userRoleData.workSheetName = "UserRole";
		userRoleData.testCaseId = "TC_UR_036";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userRoleData.fetchSystemSettingTestData();
		createUserRoles(seleniumHost, seleniumPort, browser, webSite, userAccount, userRoleData);
	}
	
	
	/**
	 * createUserRole
	 * function to Create User Role 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 16, 2012
	 */
	public boolean createUserRoles (String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib userRoleData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		boolean verifyStoredValues=false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + userRoleData.toString());
			 assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, userRoleData.userName, userRoleData.userPassword),"Login Failed",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Security Settings and navigate to User Rules        //
			//--------------------------------------------------------------------//   //close
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 //assertTrue(click(selenium,lnkQuickActions),"Could not click on the quick action link",selenium,ClassName,MethodName);
			 assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
		      waitForPageLoad(selenium);
			 assertTrue(click(selenium,lnkSecuritySetting),"Could not click the systemSettings link;More Deatils:", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			 assertTrue(click(selenium,lnkUserRole),"Could not click the User Role link:"+userRoleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			while(getText(selenium, lnkUserRoleMore).contains("Show more...")){
				click(selenium,lnkUserRoleMore);
				waitForPageLoad(selenium);
			}
			waitForPageLoad(selenium);
			
			//---------------------------//
			//  Step-3: Search User role //
			//---------------------------//
			if(!(searchUserRole(selenium, userRoleData))){
			
				//--------------------------//
				//  Step-4:Create User role //
				//--------------------------//
				 assertTrue(click(selenium, lnkAddIdentifierType),"Could not click Add new button",selenium,ClassName,MethodName);
 				 assertTrue(createUserRolePortability(selenium,userRoleData, userAccount),"User role creation Failed",selenium,ClassName,MethodName);
				verifyStoredValues=true;
			}
			
			else{
				waitForPageLoad(selenium);
				 assertTrue(click(selenium, "xpath=(//a[starts-with(@id,'Edit')])["+counter+"]"),"Could not click edit button of created User Role",selenium,ClassName,MethodName);
				if(!verifyStoreValue(selenium,userRoleData, userAccount)){
					 assertTrue(createUserRolePortability(selenium,userRoleData, userAccount),"User role creation Failed",selenium,ClassName,MethodName);
					verifyStoredValues=true;
				}
			}
			
			//if user roles created, then verify the created role
			if(verifyStoredValues){
				waitForPageLoad(selenium);
				while(getText(selenium, lnkUserRoleMore).contains("Show more...")){
					click(selenium,lnkUserRoleMore);
					waitForPageLoad(selenium);
				}
				waitForPageLoad(selenium);
				//The following function used for get the position of the user from the users list
				searchUserRole(selenium, userRoleData);
				waitForPageLoad(selenium);
				
				//Click Edit of Created User Role
				 assertTrue(click(selenium, "xpath=(//a[starts-with(@id,'Edit')])["+counter+"]"),"Could not click edit button of created User Role",selenium,ClassName,MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-5:Verify values in Edit Page Of User Role           // 
				//--------------------------------------------------------------------//
				if(!verifyStoreValue(selenium,userRoleData, userAccount)){
					Assert.fail("User Role details not displayed Properly while Edit :"+ userRoleData.toString());
					returnValue=false;
				}else
					returnValue = true;
			}

		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + userRoleData.toString());
		}
		return returnValue;
	}
	
	
	public boolean verifyStoreValue(Selenium selenium,SystemSettingsLib userRole,String userAccount){
		String arrowPossition;
		waitForPageLoad(selenium);
		  try {
			
		if(!getValue(selenium,"userRoleName").contains(userRole.userRole.trim())){
			return false;
		}
		
		if(!getValue(selenium,"description").contains(userRole.description.trim())){
			return false;
		}
		if(!getValue(selenium,"homePageViewsuggestBox").contains(userRole.homePage.trim())){
			return false;
		}
		
		
		 //Handle roles in patient Registration
		 if((userRole.patientRegistration.equals(""))){
			 
			 
			 arrowPossition = selenium.getAttribute(lnkRightsRegistration);
			 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
				
					assertTrue(click(selenium,lnkArrowRegister),"Could nod click the expand arrow of patientRegistration",selenium,ClassName,MethodName);
			 }
			 
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.personalInfo)+"PersonalInfo3radio"),"IS not checked the sub options in patientRegistration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.socioEconomics)+"Socio-Economics4radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.houseHold)+"Household5radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.contacts)+"Contacts6radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.identifiers)+"7radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.payers)+"Payers8radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.referrals)+"Referrals9radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.consents)+"Consents10radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.notes)+"Notes11radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.cases)+"Cases12radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.programs)+"Programs13radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.healthCareTeam)+"HealthcareTeam14radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.patientTimeLine)+"Timeline303radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
			
		 }
		 else{
			 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.patientRegistration)+"Registrationcheckbox"),"Could nod check access role of patientRegistration",selenium, ClassName, MethodName);
		 }
		 System.out.println();
		 
			 
		//Handle roles in Clinical
		 if((userRole.clinical.equals(""))){
			 arrowPossition = selenium.getAttribute(lnkRightsClinical);
			 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
				  assertTrue(click(selenium,lnkArrowClinical),"Could nod click the expand arrow of patientRegistration",selenium,ClassName,MethodName);
			 }
			 
			 
			 if((userRole.orders.equals(""))){
				  arrowPossition = selenium.getAttribute(lnkRightsOrders);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,lnkArrowOrders),"Could nod click the expand arrow of orders",selenium, ClassName, MethodName);
				 }
				
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.labsOrders)+"48radio"),"Could not check the lab reports in orders",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.diagnosticTestsOrders)+"463radio"),"Could not check the diagnostic test orders in orders",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.prescription)+"63radio"),"Could not check the prescriptions in orders",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.referralsOrders)+"464radio"),"Could not check the referrals in orders",selenium, ClassName, MethodName);
				 if(userRole.testCaseId.equalsIgnoreCase("TC_UR_035")|| userRole.testCaseId.equalsIgnoreCase("TC_UR_034")){
					 assertTrue(isChecked(selenium,"chk148checkbox"),"Could not check Signing Authority Check Box",selenium, ClassName, MethodName); 
					 assertTrue(isChecked(selenium,"chk1463checkbox"),"Could not check Signing Authority Check Box",selenium, ClassName, MethodName); 
					 assertTrue(isChecked(selenium,"chk163checkbox"),"Could not check Signing Authority Check Box",selenium, ClassName, MethodName); 
					 assertTrue(isChecked(selenium,"chk1464checkbox"),"Could not check Signing Authority Check Box",selenium, ClassName, MethodName); 
				 }
			 }
			 else{
				 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.orders)+"Orderscheckbox"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
			 }
			 
			 
			 if((userRole.reports.equals(""))){
				  arrowPossition = selenium.getAttribute(lnkRightsReports);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,lnkArrowReprots),"Could nod click the expand arrow of reports",selenium, ClassName, MethodName);
				 }
				
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.labsReports)+"47radio"),"Could not check the lab reports in reports",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.diagnosticTestsRepords)+"455radio"),"Could not check the diagnostic test orders in reports",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.correspondence)+"456radio"),"Could not check the correspondence in reports",selenium, ClassName, MethodName);
				 if(userRole.testCaseId.equalsIgnoreCase("TC_UR_035") || userRole.testCaseId.equalsIgnoreCase("TC_UR_034")){
					 assertTrue(isChecked(selenium,"chk147checkbox"),"Could not check Signing Authority Check Box",selenium, ClassName, MethodName); 
					 assertTrue(isChecked(selenium,"chk1455checkbox"),"Could not check Signing Authority Check Box",selenium, ClassName, MethodName); 
					 assertTrue(isChecked(selenium,"chk1456checkbox"),"Could not check Signing Authority Check Box",selenium, ClassName, MethodName);  
				 }
			 }
			 else{
				 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.reports)+"Reportscheckbox"),"Could not check the reports in Clinical",selenium, ClassName, MethodName);
			 }
			 
			 
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.chartDisclosure)+"ChartDisclosure454radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.encounters)+"Encounters72radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.timeLine)+"Timeline74radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.careAlerts)+"ManageCareAlerts258radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
			 
			
			 
			 
			 if((userRole.medicalSummary.equals(""))){
				 arrowPossition = selenium.getAttribute(lnkRightsMedicalSummary);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					  assertTrue(click(selenium,lnkArrowMedicalSummary),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
				 }
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.allergies)+"46radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.patientProblems)+"68radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.immunizations)+"43radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.injections)+"61radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.socialHistory)+"65radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.familyHistory)+"59radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.vitals)+"67radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.procedures)+"66radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.medicationsSummary)+"75radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
			 }
			 else{
				 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.medicalSummary)+"MedicalSummarycheckbox"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
			 }
			 
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.fileReport)+"FileReport73radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.exportChartData)+"ExportChartData80radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
		 }
		 else{
			 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.clinical)+"Clinicalcheckbox"),"Could nod click the expand arrow of Clinical",selenium, ClassName, MethodName);
		 }
		 
		 
		//Handle roles in Clinical Lists
		 if((userRole.clinicalLists.equals(""))){
			 arrowPossition = selenium.getAttribute(lnkRightsClinicalList);
			 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
				 assertTrue(click(selenium,lnkArrowClinicalList),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
			 }
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.clinicalPatientList)+"ClinicalPatientList78radio"),"Could nod check the sub options in Clinical Lists",selenium, ClassName, MethodName);
			 if(!userAccount.equalsIgnoreCase(CAAccount)){
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.clinicalQualityMeasures)+"ClinicalQualityMeasures85radio"),"Could nod check the sub options in Clinical Lists",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.meaningfulUseMeasures)+"MeaningfulUseMeasures81radio"),"Could nod check the sub options in Clinical Lists",selenium, ClassName, MethodName);
			 }
		 }
		 else{
			 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.clinicalLists)+"ClinicalListscheckbox"),"Could nod check access role of Clinical Lists",selenium, ClassName, MethodName);
		 }
		 
		 
		 
		//Handle roles in Clinical Setting
		 if((userRole.clinicalSetting.equals(""))){
			 arrowPossition = selenium.getAttribute(lnkRightsClinicalSettings);
			 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
				 assertTrue(click(selenium,lnkArrowClinicalSettings),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
			 }
			 
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.encounterTemplates)+"PracticeLibrary260radio"),"Could nod check the sub options in Clinical Setting",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.clinicalDecisionSupport)+"ClinicalDecisionSupport84radio"),"Could nod check the sub options in Clinical Setting",selenium, ClassName, MethodName);
			 
			 //change
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.electronicReports)+"ElectronicReports460radio"),"Could nod check the electronic report in Clinical Setting",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.laboratoryTemplates)+"LaboratoryTemplates311radio"),"Could nod check the labratory template in Clinical Setting",selenium, ClassName, MethodName);
			 //end
			 
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.interactionWarning)+"InteractionWarnings90radio"),"Could nod check the sub options in Clinical Setting",selenium, ClassName, MethodName);
			 
		 }
		 else{
			 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.clinicalSetting)+"ClinicalSettingscheckbox"),"Could nod check access role of Clinical Setting",selenium, ClassName, MethodName);
		 }
		 
		 
		 
		 
		 
		//Handle roles in Administration
		 if((userRole.administration.equals(""))){
			 arrowPossition = selenium.getAttribute(lnkRightsAdministration);
			 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
				assertTrue(click(selenium,lnkArrowAdministration),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
			 }
			 
			
			 
			//Handle roles in organizational structure 
			 if((userRole.organizationalStructure.equals(""))){
				 arrowPossition = selenium.getAttribute(lnkRightsOrganizationalStructure);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,lnkArrowOrganizationalStructure),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
				 }
				
				 
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.practice)+"Practice17radio"),"Could nod check the sub options in organizational structure",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.providers)+"Providers19radio"),"Could nod check the sub options in organizational structure",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.users)+"Users20radio"),"Could nod check the sub options in organizational structure",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.departments)+"Departments22radio"),"Could nod check the sub options in organizational structure",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.programsOrg)+"Programs36radio"),"Could nod check the sub options in organizational structure",selenium, ClassName, MethodName);
			 }
			 else{
				 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.organizationalStructure)+"OrganizationalStructurecheckbox"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
			 }
			 
			 
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.enterpriseVariables)+"EnterpriseVariables23radio"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.mandatoryFields)+"MandatoryFields24radio"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.addressBook)+"AddressBook25radio"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.externalProviders)+"ExternalProviders28radio"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.identifiersAdmin)+"Identifiers29radio"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.healthCareTeamAdmin)+"HealthcareTeam31radio"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
			 
			//Handle roles in directories 
			 if((userRole.directories.equals(""))){
				 arrowPossition = selenium.getAttribute(lnkRightsDirectories);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,lnkArrowDirectories),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
				 }
				
				 
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.referringProviders)+"ReferringProviders103radio"),"Could nod check the sub options in directories",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.payerDirectories)+"Payers252radio"),"Could nod check the sub options in directories",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.Pharmacies)+"Pharmacies50radio"),"Could nod check the sub options in directories",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.governmentAgencies)+"GovernmentAgencies104radio"),"Could nod check the sub options in directories",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.hospitals)+"Hospitals105radio"),"Could nod check the sub options in directories",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.labs)+"106radio"),"Could nod check the sub options in directories",selenium, ClassName, MethodName);
			 }
			 else{
				 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.directories)+"Directoriescheckbox"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
			 }
		 }
		 else{
			  assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.administration)+"SystemSettingscheckbox"),"Could nod check access role of Administration",selenium, ClassName, MethodName);
		 }
		 
			 
		//Handle roles in General 
		 if((userRole.general.equals(""))){
			 
			 arrowPossition = selenium.getAttribute(lnkRightsGeneral);
			 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
				 assertTrue(click(selenium, lnkArrowGeneral),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
			 }
			  
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.unmatchedItems)+"UnmatchedItems97radio"),"Could nod check the sub options in General",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.importChartData)+"ImportChartData91radio"),"Could nod check the sub options in General",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.failedTransmition)+"FailedTransmissions192radio"),"Could nod check the sub options in General",selenium, ClassName, MethodName);
			 
			 //change
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.unmatchedProviders)+"UnmatchedProviders461radio"),"Could nod check the un matched providers in General",selenium, ClassName, MethodName);
			 //end
			 
			
		 }
		 else{
			  assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.general)+"Generalcheckbox"),"Could nod check access role of General",selenium, ClassName, MethodName);
		 }
		 
		//Handle roles in Security Settings 
		 if((userRole.securitySettings.equals(""))){
			 arrowPossition = selenium.getAttribute(lnkRightsSecuritySettings);
			 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
				 assertTrue(click(selenium,lnkArrowSecuritySettings),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
			 }
			
			 
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.auditLog)+"AuditLog35radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.consentsSec)+"Consents38radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.userRoles)+"UserRoles39radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.passwordRules)+"PasswordManagement37radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
			 //change
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.emergencyAccess)+"EmergencyAccess458radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.userAccessExceptions)+"UserExceptions474radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
			 //end
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.manageRecords)+"ManageRecords96radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
			 //change
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.dataSharing)+"DataSharing457radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.restrictPatientChart)+"RestrictPatientChart459radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
			 //end
		 }
		 else{
			 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.securitySettings)+"SecuritySettingscheckbox"),"Could nod check access role of securitySettings",selenium, ClassName, MethodName);
		 }
		 
		 
		//Handle roles in Reports 
		 if((userRole.reports.equals(""))){
			 
			 arrowPossition = selenium.getAttribute(lnkRightsReports1);
			 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
				  assertTrue(click(selenium,lnkArrowReports1),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
			 }
			
			 
			   assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.generalReports)+"GeneralReports100radio"),"Could nod check the sub options in Reports",selenium, ClassName, MethodName);
			 
			
		 }
		 else{
			   //assertTrue(isChecked(selenium,"xpath=(//input[@id='chk"+getAccessPossition(userRole.reports)+"Reportscheckbox'])[2]"),"Could nod check access role of Reports",selenium, ClassName, MethodName);
		 }
		
		 
		
		 //Handle roles in Scheduling 
		 if((userRole.scheduler.equals(""))){
				
			 arrowPossition = selenium.getAttribute(lnkRightsScheduling);
			 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
				 assertTrue(click(selenium,lnkArrowScheduling),"Could nod click the expand arrow of scheduling",selenium, ClassName, MethodName);
			 }
			 
			 if((userRole.calendarSettings.equals(""))){
				 arrowPossition = selenium.getAttribute(lnkRightsCalenderSettings);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,lnkArrowCalenderSettings),"Could nod click the expand arrow of Calendar setting",selenium, ClassName, MethodName);
				 }
				 
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.locationHours)+"LocationHours202radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.nonProviderResources)+"Non-ProviderResources203radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.resourceGroups)+"ResourceGroups204radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.visitTypes)+"VisitTypes205radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.visitGroups)+"VisitGroups206radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.calendarTemplates)+"CalendarTemplates207radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.resourceCalendars)+"ResourceCalendars208radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.calendarPreferences)+"CalendarPreferences209radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.programGroups)+"ProgramGroups112radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.cancellationReasons)+"CancellationReasons306radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 
			 }
			 else{
				 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.calendarSettings)+"CalendarSettingscheckbox"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
			 }
			 
			 
			 if((userRole.calendarView.equals(""))){
				 arrowPossition = selenium.getAttribute(lnkRightsCalenderView);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					assertTrue(click(selenium,lnkArrowCalenderView),"Could nod click the expand arrow of calendar view" ,selenium, ClassName, MethodName);
				 }
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.calendarSuperUser)+"213radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.events)+"Events218radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.confirmAppt)+"ConfirmAppt214radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.checkinPatient)+"CheckinPatient215radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
			 }
			 else{
				 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.calendarView)+"CalendarViewcheckbox"),"Could nod check the sub options in Scheduling" ,selenium, ClassName, MethodName); 
			 }
			 
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.bumpList)+"BumpList221radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.waitListManagement)+"WaitListManagement216radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.recordAttendance)+"RecordAttendance113radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
			
			 if((userRole.PDG.equals(""))){
				 arrowPossition = selenium.getAttribute(lnkRightsPDG);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,lnkArrowPDG),"Could nod click the expand arrow of pdg",selenium, ClassName, MethodName);
				 }
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.openPDGSessions)+"OpenPDGSessions300radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 //change
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.viewEditPDGsession)+"View/EditPDGSessions110radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.unexplainedabsentees)+"UnexplainedAbsenteeismsWorkQueue111radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 //end
			 }
			 else{
				 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.PDG)+"PDGcheckbox"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
			 }
			
		 }
		 else{
			 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.scheduler)+"Schedulercheckbox"),"Could nod check access role of Scheduling",selenium, ClassName, MethodName);
		 }
		 
		//Handle roles in Template Setup 
		 if((userRole.templateSetup.equals(""))){
			 arrowPossition = selenium.getAttribute(lnkRightsTemplateSetup);
			 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
				 assertTrue(click(selenium,lnkArrowTemplateSetup),"Could nod click the expand arrow of Template setup",selenium, ClassName, MethodName);
			 }
			 
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.daysheetTemplates)+"DaysheetTemplate211radio"),"Could nod check the sub options in Template Setup",selenium, ClassName, MethodName);
			 //change
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.letterTemplates)+"LetterTemplates219radio"),"Could nod check the sub options in Template Setup",selenium, ClassName, MethodName);
			//end
		 }
		 else{
			  assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.templateSetup)+"TemplateSettingscheckbox"),"Could nod check access role of Template Setup",selenium, ClassName, MethodName);
		 }
		 
		 
		 //verify roles in biller
		 if((userRole.biller.equals(""))){
			 arrowPossition = selenium.getAttribute(lnkRightsBiller);
			 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
				 assertTrue(click(selenium,lnkArrowBiller),"Could nod click the expand arrow of Biller",selenium, ClassName, MethodName);
			 }
			 
			 if((userRole.billingSettings.equals(""))){
				 arrowPossition = selenium.getAttribute("arrowBilling Settings@class");
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,"arrowBilling Settings"),"Could nod click the expand arrow of Billing setting",selenium, ClassName, MethodName);
				 }
				 
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.superbillSetup)+"SuperbillSetup403radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.statementPreferences)+"StatementPreferences402radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.serviceCodes)+"ServiceCodes405radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.adjustmentReasons)+"AdjustmentReasons407radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.batchEligibilityPreferences)+"BatchEligibilitySettings453radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.billingRulesAdmin)+"BillingRules408radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
			 }
			 else{
				 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.billingSettings)+"BillingSettingscheckbox"),"Could nod check access role of billing setting",selenium, ClassName, MethodName);
			 }
			 
			 
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.superbillsToReview)+"UnpostedSuperbills411radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.rejectionsToReview)+"ClaimRejections431radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.onHoldClaims)+"ClaimsonHold435radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.unprintedStatements)+"UnprintedStatements434radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.unpostedPayerBatches)+"UnpostedPayerBatches412radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.paperClaimsToReview)+"PaperClaimstoReview452radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.postCharges)+"PostCharges430radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.postPatientPayments)+"PostPatientPayments413radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.postPayerPayments)+"PostPayerPayments425radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.insuranceAging)+"InsuranceAging433radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
			 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.patientsFailedEligibility)+"PatientFailedEligibility429radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
			 
			 if((userRole.billingHistory.equals(""))){
				 arrowPossition = selenium.getAttribute("arrowBilling History@class");
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,"arrowBilling History"),"Could nod click the expand arrow of Billing history",selenium, ClassName, MethodName);
				 }
				 
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.summary)+"Summary421radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.charges)+"Charges422radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.payments)+"Payments423radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(isChecked(selenium,"rd"+getAccessPossition(userRole.statements)+"Statements424radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
			 }
			 else{
				 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.billingHistory)+"BillingHistorycheckbox"),"Could nod check access role of billing history",selenium, ClassName, MethodName);
			 }
			 
		 }
		 else{
			 assertTrue(isChecked(selenium,"chk"+getAccessPossition(userRole.biller)+"Billingcheckbox"),"Could nod check access role of biller",selenium, ClassName, MethodName);
		 }
		 
		 
		 assertTrue(click(selenium,"save"),"Could not click the save button",selenium,ClassName,MethodName);
		 waitForPageLoad(selenium);
		 waitForPageLoad(selenium);
		 
	} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
	}
		  if(isElementPresent(selenium,"link=Expand all")){
				 return true;
			 }else{
				 return false;
			 }
	
	}
	
	
	public boolean searchUserRole(Selenium selenium, SystemSettingsLib userRoleData){
		waitForPageLoad(selenium);
		int count=1;
		while(isElementPresent(selenium,"//div[@id='AdminUserRoleList']/table/tbody/tr["+count+"]/td/div/div/span")){
			if(getText(selenium,"//div[@id='AdminUserRoleList']/table/tbody/tr["+count+"]/td/div/div/span").equalsIgnoreCase(userRoleData.userRole)){
				counter=count;
				return true;
			}else
				count++;
		}
		return false;
	}
	
}
