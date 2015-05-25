package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingUnitTestLib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestsForSeriesWithParticipant extends AbstractSchedulingTest {
    	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "seriesNameWithEmpty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void seriesNameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_001";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "seriesNameWithMaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void seriesNameWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_002";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "groupSizeWithMaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void groupSizeWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_003";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Group Size With AlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void groupSizeWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
		pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
		pdgSeriesData.testCaseId = "TC_UAS_004";
		pdgSeriesData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "pgmNameWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void pgmNameWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_005";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "pgmCoordinatorWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void pgmCoordinatorWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_006";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    	
    	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "locationTypeWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void locationTypeWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_007";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "locationWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void locationWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_008";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "roomWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void roomWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_009";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    	
    	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "startDateLessThanCurrentDate")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void startDateLessThanCurrentDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_010";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "startTimeLessThanCurrentTime")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void startTimeLessThanCurrentTime(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
		pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
		pdgSeriesData.testCaseId = "TC_UAS_011";
		pdgSeriesData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    	
    	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "startDateWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void startDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_012";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "startDateWithEmpty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void startDateWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_013";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "hoursWithAlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void hoursWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_014";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "hoursWithMoreThanTwelve")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void hoursWithMoreThanTwelve(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_015";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "hoursWithMaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void hoursWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_016";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "hoursWithEmpty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void hoursWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_017";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "hoursWithZero")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void hoursWithZero(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_018";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "minuteWithAlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void minuteWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_019";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "minuteWithMoreThanFiftyFive")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void minuteWithMoreThanFiftyFive(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_020";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "minuteWithMaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void minuteWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_021";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "timeWithoutFivMinInterval")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void timeWithoutFivMinInterval(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_022";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "intervalWithEmpty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void intervalWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
		pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
		pdgSeriesData.testCaseId = "TC_UAS_023";
		pdgSeriesData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Interval With Alphanumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void intervalWithAlphanumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_024";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "intervalWithMaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void intervalWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
	pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
	pdgSeriesData.testCaseId = "TC_UAS_025";
	pdgSeriesData.fetchSchedulingSettingsTestData();
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "occurringWithoutSelection")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void occurringWithoutSelection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
		pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
		pdgSeriesData.testCaseId = "TC_UAS_026";
		pdgSeriesData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "endDateWithPastDate")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endDateWithPastDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
		pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
		pdgSeriesData.testCaseId = "TC_UAS_027";
		pdgSeriesData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "endDateWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
		pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
		pdgSeriesData.testCaseId = "TC_UAS_028";
		pdgSeriesData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "endDateWithEmpty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endDateWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
		pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
		pdgSeriesData.testCaseId = "TC_UAS_029";
		pdgSeriesData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "After Occurrence With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void afterOccurrenceWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
		pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
		pdgSeriesData.testCaseId = "TC_UAS_030";
		pdgSeriesData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "afterOccurrenceWithMaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void afterOccurrenceWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
		pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
		pdgSeriesData.testCaseId = "TC_UAS_031";
		pdgSeriesData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "afterOccurrenceWithAlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void afterOccurrenceWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
	    SchedulingUnitTestLib pdgSeriesData = new SchedulingUnitTestLib();
		pdgSeriesData.workSheetName = "UnitTest_SeriesWithParticipant";
		pdgSeriesData.testCaseId = "TC_UAS_032";
		pdgSeriesData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	
    	
    
   /*************************************************************************************************** 
	* @purpose        To perform validations
	* @action 	  perform field level validations
	* @expected       To create program series
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	  Oct 28, 2013
	***************************************************************************************************/
	
	public boolean createProgramAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingUnitTestLib pdgSeriesData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pdgSeriesData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, pdgSeriesData.userName, pdgSeriesData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pdgSeriesData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Progarm Group						  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not navigate to Calender Setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkProgramGroup), "could not able to click the Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Program Group					  //
			//--------------------------------------------------------------------//

			SchedulingTestLib pDGData = new SchedulingTestLib();
			pDGData.workSheetName = "ProgramGroupAdmin";
			pDGData.testCaseId = "TC_PDG_010";
			pDGData.fetchSchedulingTestData();
			
			assertTrue(deleteProgramForPDGAdmin(selenium,pDGData),"Could not delete Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-4: Create Program					  //
			//--------------------------------------------------------------------//
			
			
			selectValueFromAjaxList(selenium,ajxProgramType,pDGData.programType);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createProgramForPDGAdmin(selenium,pDGData,uniqueName),"Could not Create Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnAdd)){
				return false;
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Add New Series					  //
			//--------------------------------------------------------------------//
			
			assertTrue(unitTestForaddNewSeries(selenium,pdgSeriesData),"Could not Create series", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!(pdgSeriesData.testCaseId.equals("TC_UAS_003")||pdgSeriesData.testCaseId.equals("TC_UAS_031")||pdgSeriesData.testCaseId.equals("TC_UAS_016")||pdgSeriesData.testCaseId.equals("TC_UAS_025")||pdgSeriesData.testCaseId.equals("TC_UAS_021"))){
				pdgSeriesData.validationFieldID = pdgSeriesData.validationFieldID == null ? pdgSeriesData.validationFieldID ="" : pdgSeriesData.validationFieldID.trim();
				if(!pdgSeriesData.validationFieldID.equals("")){
					assertTrue(isElementPresent(selenium, pdgSeriesData.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
					assertTrue(getText(selenium, pdgSeriesData.validationFieldID).contains(pdgSeriesData.validationMessage), "The expected validation message should contain the text - "+ pdgSeriesData.validationMessage + " The actual validation message shown - " + getText(selenium, pdgSeriesData.validationFieldID),selenium, ClassName, MethodName);
				}
			}
			else{
			    assertTrue(click(selenium,btnSeriesAction),"Could not click Action ", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    assertTrue(click(selenium,lnkViewAllSeries),"Could not click View Series ", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    assertTrue(click(selenium,lnkEditSeries),"Could not click Edit Series ", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    
			    if(pdgSeriesData.testCaseId.equals("TC_UAS_003")){
				 if(getValue(selenium,txtGroupSize).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.groupName.trim().toLowerCase(new java.util.Locale("en","US")))){
				       return false;
				   }
			    }
			    if(pdgSeriesData.testCaseId.equals("TC_UAS_031")){
				if(getValue(selenium,txtAfterOcc).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.afterOcc.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				  }
			    }
			    if(pdgSeriesData.testCaseId.equals("TC_UAS_016")){
				 if(getValue(selenium,txtStartTimeHour).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.startHour.trim().toLowerCase(new java.util.Locale("en","US")))){
				       return false;
				   }
			    }
			    if(pdgSeriesData.testCaseId.equals("TC_UAS_025")){
				if(getValue(selenium,txtEvery).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.everyWeek.trim().toLowerCase(new java.util.Locale("en","US")))){
				       return false;
				   }
			    }
			    if(pdgSeriesData.testCaseId.equals("TC_UAS_021")){
				 if(getValue(selenium,txtStartTimeMins).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.startMin.trim().toLowerCase(new java.util.Locale("en","US")))){
				       return false;
				   }
			    }
			    return true;
			}
			
			
		}
		catch(RuntimeException e){
			e.printStackTrace();
			
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}