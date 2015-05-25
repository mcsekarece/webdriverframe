package com.nexia.selenium.testscripts.section.taskManagment.patient_Task;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.taskManagement.AbstractTaskManagement;
import com.nexia.selenium.genericlibrary.taskManagement.TaskManagementLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyShowDetailsInTaskNotification extends AbstractTaskManagement{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Show Details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void showDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib createPatientTask = new TaskManagementLib();
		createPatientTask.workSheetName = "createPatientTask";
		createPatientTask.testCaseId = "TC_CGT_011";
		createPatientTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyShowDetails(seleniumHost, seleniumPort, browser, webSite, userAccount,createPatientTask);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        verify Show details in task Notification Queue
	* @action 		  verifying Show details in task Notification Queue
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 04, 2013
	***************************************************************************************************/
	
	public boolean verifyShowDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib createPatientTask ) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + createPatientTask.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, createPatientTask.userName, createPatientTask.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//----------------------------------------------------------------------------//
			//  Step-2 : Navigate to  Task Notification//
			//----------------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkTaskNotification),"Could not click on Task Notification", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//----------------------------------------------------------------------------//
			//  Step-3 : Verify the Show details//
			//----------------------------------------------------------------------------//
			
			if(!getValue(selenium,ajxSuggest).contains("All Tasks")){
				Assert.fail("Default value is not getting displayed");
			}
			
			assertTrue(click(selenium,ajxSuggest),"could not click the show ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			assertTrue(selenium.isTextPresent("Urgent Tasks"),"Urgent Tasks is not getting displayed",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Overdue Tasks"),"Overdue Tasksis not getting displayed",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Pending Tasks"),"Pending Tasksis not getting displayed",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("In Progress Tasks"),"In Progress Tasks is not getting displayed",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Completed Tasks"),"Completed Tasks is not getting displayed",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Can't Complete Tasks"),"Can't Complete Tasks is not getting displayed",selenium, ClassName, MethodName);
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
			
}