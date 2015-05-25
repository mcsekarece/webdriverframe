package com.nexia.selenium.testscripts.section.taskManagment.patient_Task;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.taskManagement.AbstractTaskManagement;
import com.nexia.selenium.genericlibrary.taskManagement.TaskManagementLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyRemoveTaskFromTaskNotifcation  extends AbstractTaskManagement{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Remove Task")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void removeTask(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib createPatientTask = new TaskManagementLib();
		createPatientTask.workSheetName = "createPatientTask";
		createPatientTask.testCaseId = "TC_CGT_011";
		createPatientTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyRemoveTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createPatientTask);
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
	
	public boolean verifyRemoveTask(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib createPatientTask ) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
		String uniqueName = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + createPatientTask.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, createPatientTask.userName, createPatientTask.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Search Patient//
			//--------------------------------------------------------------------//
			//String providerTemp= getText(selenium, lnkTopMenu);
			//String userName= providerTemp.replaceAll(", FULL", "");
			
			searchPatientNexiaForProviderHomePage(selenium,createPatientTask.patientID);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Create a General Task//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(navigateToCreateTask(selenium), "Could not navigate to create task",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		     
			//--------------------------------------------------------------------//
			//  Step-4: createPatientTask //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createPatientTask(selenium,createPatientTask,uniqueName),"Create GeneralTask failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-5 :Get Task Notification Count//
			//--------------------------------------------------------------------//
			String notificationresultList=getText(selenium,lnkTaskNotification);
			String[] notificationSplits = notificationresultList.split(" ");
			int notificationResult = Integer.parseInt(notificationSplits[0]);
			
			//--------------------------------------------------------------------//
			//  Step-6 : Navigate To Work Queue  and Search Task//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTask),"Could not click on Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			//selectValueFromAjaxList(selenium,ajxSuggest,"My tasks");
			waitForPageLoad(selenium);	
			String resultList=getText(selenium,lnkTask);
			String[] splits = resultList.split(" ");
			int metricResult = Integer.parseInt(splits[0]);
			
			if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains(createPatientTask.taskName+uniqueName)){
				assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr/td"), "Could not click on task", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}else{
				int count = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
				int counter = metricResult;
				int tempCount=1;
				while(count<=counter){
					while(count>tempCount){
						if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+counter+"]/td").trim().contains(createPatientTask.taskName+uniqueName)){
							assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr["+counter+"]/td"), "Could not click on task", selenium, ClassName, MethodName);
							returnValue = true;
							break;
						}
						tempCount++;
					}
					assertTrue(click(selenium, lnkTaskList), "Could not click on more option in the task queue", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);	
					count = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
					waitForPageLoad(selenium);
				}
			}
			
			//---------------------------------------------------------------------------//
			//  Step-7 : Navigate To Assign To Me page and click on Notify Assigner//
			//--------------------------------------------------------------------------//
			assertTrue(click(selenium, lnkAction), "Could not click on Action in assigned to me page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
				
			assertTrue(click(selenium, lnkNotifyAssigner), "Could not click on Notify Assigner option from action", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(type(selenium,txtNotify,createPatientTask.notifyMe),"Could not enter the comments", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,btnSend),"Could not click the send button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//----------------------------------------------------------------------------//
			//  Step-8 : Navigate to Task Notification and Compare  Notification count//
			//----------------------------------------------------------------------------//
			//assertTrue(click(selenium, backbtn), "Could not click on back button", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			String notificationresultList1=getText(selenium,lnkTaskNotification);
			String[] notificationSplits1 = notificationresultList1.split(" ");
			int notificationResult1 = Integer.parseInt(notificationSplits1[0]);
			
			if(notificationResult1>notificationResult){
				returnValue = true;
			}else{
				Assert.fail("Task Notification Count is not increased");
			}
			
			//----------------------------------------------------------------------------//
			//  Step-9 : Search Task Notification//
			//----------------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTaskNotification),"Could not click on Task Notification", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			waitForPageLoad(selenium);	
			//selectValueFromAjaxList(selenium,ajxSuggest,"In Progress Tasks");
			//click(selenium,"//div[5]/div/div/div/div/div");
			while(getText(selenium,lnkTaskList).equalsIgnoreCase("Show more...")){
				assertTrue(click(selenium, lnkTaskList), "Could not click on more option in the task queue", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				waitForPageLoad(selenium);	
				
			}
			int counter = (Integer) selenium.getXpathCount("//div[3]/div/div/div/div/div/div[2]/div/div[2]");
			int tempCount1=1;
			while(counter>=tempCount1){
				if(getText(selenium,"//div[3]/div/div/div/div["+tempCount1+"]/div/div[2]/div/div[2]").trim().contains(createPatientTask.taskName+uniqueName)){
					assertTrue(click(selenium, "//div[3]/div/div/div/div["+tempCount1+"]/div/div[2]/div/div[2]"), "Could not click the task from queue", selenium, ClassName, MethodName);
					returnValue = true;
					break;
				}
				tempCount1++;
			}
			
			//----------------------------------------------------------------------------//
			//  Step-10: Remove Task//
			//----------------------------------------------------------------------------//
			assertTrue(click(selenium,btnRemove),"Could not click on edit button from Task Notification Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//----------------------------------------------------------------------------//
			//  Step-11: Navigate To Task Notifcation Queue and Compare the count//
			//----------------------------------------------------------------------------//
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			
			String notificationresultList2=getText(selenium,lnkTaskNotification);
			String[] notificationSplits2 = notificationresultList2.split(" ");
			int notificationResult2 = Integer.parseInt(notificationSplits2[0]);
			
			if(notificationResult1>=notificationResult2){
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
