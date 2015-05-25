package com.nexia.selenium.testscripts.section.taskManagment.patient_Task;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.taskManagement.AbstractTaskManagement;
import com.nexia.selenium.genericlibrary.taskManagement.TaskManagementUnitLib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForCreateTask extends AbstractTaskManagement{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Task Name With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTaskNameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_001";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Due Time count with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDueTimeCountWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_002";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Due Time count with Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDueTimeCountWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_003";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Due Time Count with Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDueTimeCountWithSpecialCharater(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_004";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Due Time Unit with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDueTimeUnitWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_005";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Due Time Unit with Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDueTimeUnitWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_006";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Due Time Unit with Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDueTimeUnitWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_007";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Assign To User With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAssignToUserWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_008";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Assign To User With Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAssignToUserWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_009";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Assign To User With InValid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAssignToUserWithInValid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_010";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Practice With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPracticeWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_011";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Practice With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPracticeWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_012";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify User With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUserWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_013";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify User With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUserWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_014";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Daily With empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDailyWithempty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_015";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Daily with charatcer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDailywithcharatcer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_016";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Daily With Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDailyWithSpecialcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_017";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Day With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDayWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_018";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Week Of The Month With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWeekOfTheMonthWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_019";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Day Of The Month With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDayOfTheMonthWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_020";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Date of the Year with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDateOfTheYearWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_021";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Month Selection With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMonthSelectionWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_022";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Ocurrence With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOcurrenceWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_023";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Ocureence With Below two")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOcureenceWithBelowTwo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_024";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Ocurrence With character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOcurrenceWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_025";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify End Date With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndsDataWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_026";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify End Date With Past Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndsDataWithPastDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_027";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify End Data With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndDataWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_028";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Due Time Count with Above 60")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDueTimeCountWithAbove60(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_029";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Notify me  with Above 60")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNotifyMeWithAbove60(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_030";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Reason With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReasonWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_031";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify OnBehalf With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOnBehalfWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib createTaskData = new TaskManagementUnitLib();
		createTaskData.workSheetName = "UnitTest_CreatePatientTask";
		createTaskData.testCaseId = "TC_UCT_032";
		createTaskData.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestCreateTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createTaskData);
	}
	/*************************************************************************************************** 
	* @purpose        verify unitTestCreateTask
	* @action 		  verifying unit Test CreateTask
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 29, 2013
	***************************************************************************************************/
	public boolean unitTestCreateTask(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementUnitLib createTaskData ) throws IOException{
		boolean returnValue = false;
		Selenium selenium = null;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + createTaskData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, createTaskData.userName, createTaskData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Search Patient//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,createTaskData.patientID);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Create Task//
			//--------------------------------------------------------------------//
			assertTrue(navigateToCreateTask(selenium), "Could not navigate the create task",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Unit test for Create task //
			//--------------------------------------------------------------------//
			assertTrue(unitTest_CreateTask(selenium,createTaskData), "Create Task Unit Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			createTaskData.validationFieldID = createTaskData.validationFieldID == null ? createTaskData.validationFieldID ="" : createTaskData.validationFieldID.trim();
			
			if(!createTaskData.validationFieldID.equals("")){
				assertTrue(isElementPresent(selenium, createTaskData.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
				assertTrue(getText(selenium, createTaskData.validationFieldID).contains(createTaskData.validationMessage), "The expected validation message should contain the text - "+ createTaskData.validationMessage + " The actual validation message shown - " + getText(selenium, createTaskData.validationFieldID),selenium, ClassName, MethodName);
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
