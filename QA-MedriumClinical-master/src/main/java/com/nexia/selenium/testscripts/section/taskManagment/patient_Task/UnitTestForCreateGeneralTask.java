package com.nexia.selenium.testscripts.section.taskManagment.patient_Task;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.taskManagement.AbstractTaskManagement;
import com.nexia.selenium.genericlibrary.taskManagement.TaskManagementUnitLib;


import com.thoughtworks.selenium.Selenium;

public class UnitTestForCreateGeneralTask extends AbstractTaskManagement{

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify TaskName With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})

	public void verifyTaskNameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_001";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Assignto with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})

	public void verifyAssigntoWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_002";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Assignto with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAssigntoWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_003";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify duein with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifydueinWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_004";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify duein Unit with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifydueinUnitWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_006";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify duein Unit with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDueinUnitWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_007";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify duein with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDueinWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_005";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Another PracticeAssign With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAnotherPracticeAssignWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_008";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forverifyNofitymeWithInvalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNofitymeWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_009";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Nofityme Unit With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNofitymeUnitWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_010";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring End Occurences with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecurringEndOccurenceswithblank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_011";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify  Recurring End Occurences with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringEndOccurenceswithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_012";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring End Date with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringEndDatewithblank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_013";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring End Date with invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringEndDatewithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_014";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring Daily Date with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringDailyDatewithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_015";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring Daily Date with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringDailyDatewithinvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_016";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring Week with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringWeekwithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_017";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring Week with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringWeekwithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_018";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring Monthly Dayofmonth  with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringMonthlyDayofmonthwithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_019";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring Monthly Dayofmonth  with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringMonthlyDayofmonthwithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_020";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring Monthly Qualifier Weekofmonth  with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringMonthlyQualifierWeekofmonthwithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_021";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring Monthly Qualifier Weekofmonth  with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringMonthlyQualifierWeekofmonthwithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_022";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring Monthly day selection Weekofmonth  with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringMonthlydayselectionWeekofmonthwithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_023";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring Monthly day selection Weekofmonth  with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringMonthlydayselectionWeekofmonthwithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_024";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring Yearly dateofmonth  with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringYearlydateofmonthwithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_025";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring Yearly dateofmonth  with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringYearlydateofmonthwithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_026";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring Yearly Month  with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringYearlyMonthwithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_027";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Recurring Yearly Month  with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyRecurringYearlyMonthwithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementUnitLib CreateGeneralTask = new TaskManagementUnitLib();
		CreateGeneralTask.workSheetName = "UnitTest_CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_UCG_028";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createGeneralTaskUnit(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	
	}
	
	
	/*************************************************************************************************** 
	* @purpose        verify UnitTestForCreateGeneralTask
	* @action 		  verifying UnitTest For CreateGeneralTask
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 29, 2013
	***************************************************************************************************/
	
	public boolean createGeneralTaskUnit(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementUnitLib CreateGeneralTask ) throws IOException{
		
	    Selenium selenium=null;
		boolean returnValue=true;

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + CreateGeneralTask.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, CreateGeneralTask.userName, CreateGeneralTask.userPassword),"Login Failed ", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Create a General Task//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateToCreateGeneralTask(selenium), "Could not navigateTo CreateGeneralTask ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		     
			//--------------------------------------------------------------------//
			//  Step-3: CreateGeneralTaskUnit //
			//--------------------------------------------------------------------//
			
			assertTrue(UnitTest_CreateGeneralTask(selenium,CreateGeneralTask),"Create GeneralTask Unit failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			CreateGeneralTask.validationFieldID = CreateGeneralTask.validationFieldID == null ? CreateGeneralTask.validationFieldID ="" : CreateGeneralTask.validationFieldID.trim();
			
			if(!CreateGeneralTask.validationFieldID.equals("")){
				assertTrue(isElementPresent(selenium, CreateGeneralTask.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
				assertTrue(getText(selenium, CreateGeneralTask.validationFieldID).contains(CreateGeneralTask.validationMessage), "The expected validation message should contain the text - "+ CreateGeneralTask.validationMessage + " The actual validation message shown - " + getText(selenium, CreateGeneralTask.validationFieldID),selenium, ClassName, MethodName);
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
