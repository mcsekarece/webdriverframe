package com.nexia.selenium.testscripts.section.templateSetup.daysheettemplate;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.templateSetup.AbstractTemplateSetup;
import com.nexia.selenium.genericlibrary.templateSetup.TemplateSetupUnitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnitTestForPrintCalendarReport extends AbstractTemplateSetup {
	//Fix-Me
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Day sheet template name with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDaySheetTemplateNameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_001";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Day sheet template name with invalid file name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDaySheetTemplateNameWithInvalidFileName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_002";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	//Fix-Me
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with atleast one resource selected")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithAteleastOneResourceSelected(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_003";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with specific date empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithSpecificDateEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_004";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with specific date invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithSpecificDateInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_005";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with DateRangeFrom empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithDateRangeFromEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_006";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with Date Range From invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithDateRangeFromInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_007";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with Date Range To empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithDateRangeToEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_008";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with Date Range To invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithDateRangeToInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_009";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range From Hour empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeFromHourEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_010";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range From Hour string")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeFromHourString(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_011";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range From Hour invalid string")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeFromHourInvalidTime(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_012";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	//Fix-Me
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range From Hour maximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeFromHourMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_013";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range From minute is not five series")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeFromMinuteNotFiveSeries(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_014";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range From minute string")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeFromMinuteString(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_015";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range From invalid minute string")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeFromMinuteInvalidTime(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_016";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	//Fix-Me
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range From minute maximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeFromMinuteMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_017";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range To Hour empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeToHourEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_018";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range To Hour string")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeToHourString(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_019";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range To Hour invalid string")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeToHourInvalidTime(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_020";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	//Fix-Me
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range To Hour maximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeToHourMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_021";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range To minute is not five series")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeToMinuteNotFiveSeries(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_022";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range To minute string")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeToMinuteString(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_023";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range To invalid minute string")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeToMinuteInvalidTime(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_024";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	//Fix-Me
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing calendar report with time Range To minute maximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeToMinuteMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_025";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify To date must be equal or greater than from date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithDateRangeToEqualOrGreaterthanFromDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_026";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	//Fix-Me
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify To time must be equal or greater than from time")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalenderReportWithTimeRangeToEqualOrGreaterthanFromTime(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_PrintCalendarReport";
		daySheetTemplateTestData.testCaseId = "TC_UCR_027";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify unit test in print calendar report
	* @Specification  SRS_SCH_RPT_Print Daysheet_Rev0.0
	* @action 		  Verifying unit test in print calendar report
	* @author         AspireQA
	* @throws 		  IOException 
	* @throws         InterruptedException 
	* @throws         AWTException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 29, 2013
	***************************************************************************************************/
	
	public boolean daySheetTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TemplateSetupUnitLib daySheetTemplateTestData) throws IOException, AWTException,        InterruptedException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + daySheetTemplateTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, daySheetTemplateTestData.userName, daySheetTemplateTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,daySheetTemplateTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Print Calendar		  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToPrintCalendar(selenium),"Could not navigate to print calendar", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify unit test in print calendar report section		  //
			//--------------------------------------------------------------------//
			assertTrue(verifyPrintReportUnitTest(selenium, daySheetTemplateTestData,userAccount), "Could not Add new day sheet template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Verify Unit Test Functionality For print calendar report	  //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium, daySheetTemplateTestData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, daySheetTemplateTestData.validationFieldID).contains(daySheetTemplateTestData.validationMessage), "The expected validation message should contain the text - "+ daySheetTemplateTestData.validationMessage + " The actual validation message shown - " + getText(selenium, daySheetTemplateTestData.validationFieldID), selenium, ClassName, MethodName);
				
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}