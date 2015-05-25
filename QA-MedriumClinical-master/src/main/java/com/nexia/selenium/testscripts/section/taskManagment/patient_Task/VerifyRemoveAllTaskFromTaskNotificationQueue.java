package com.nexia.selenium.testscripts.section.taskManagment.patient_Task;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.taskManagement.AbstractTaskManagement;
import com.nexia.selenium.genericlibrary.taskManagement.TaskManagementLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyRemoveAllTaskFromTaskNotificationQueue extends AbstractTaskManagement{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Remove All Task")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void removeAllTask(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib createPatientTask = new TaskManagementLib();
		createPatientTask.workSheetName = "createPatientTask";
		createPatientTask.testCaseId = "TC_CGT_011";
		createPatientTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyRemoveAllTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createPatientTask);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Remove Task 
	* @action 		  verifying Remove Task
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 13, 2013
	***************************************************************************************************/
	
	public boolean verifyRemoveAllTask(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib createPatientTask ) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + createPatientTask.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, createPatientTask.userName, createPatientTask.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//----------------------------------------------------------------------------//
			//  Step-2 : Naviagte to Task Notification//
			//----------------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTaskNotification),"Could not click on Task Notification", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//----------------------------------------------------------------------------//
			//  Step-3: Remove All Task//
			//----------------------------------------------------------------------------//
			String notificationresultList=getText(selenium,lnkTaskNotification);
			String[] notificationSplits = notificationresultList.split(" ");
			int notificationResult = Integer.parseInt(notificationSplits[0]);
			
			assertTrue(click(selenium,chkSelectAllBox),"Could not select the check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,btnRemove),"Could not click on delete button from Task Notification Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,btnYesbutton),"Could not click on delete button from Task Notification Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//----------------------------------------------------------------------------//
			//  Step-4: Compare the count//
			//----------------------------------------------------------------------------//
			String notificationresultList2=getText(selenium,lnkTaskNotification);
			String[] notificationSplits2 = notificationresultList2.split(" ");
			int notificationResult2 = Integer.parseInt(notificationSplits2[0]);
			
			if(notificationResult>notificationResult2){
				returnValue = true;
			}else{
				Assert.fail("Task Notification Count is not decreased");
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
