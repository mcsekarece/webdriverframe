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

public class VerifyCompletedTaskWithCurrentUser extends AbstractTaskManagement{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Complete Task With Current Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void completeTaskWithCurrentUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib createPatientTask = new TaskManagementLib();
		createPatientTask.workSheetName = "createPatientTask";
		createPatientTask.testCaseId = "TC_CGT_011";
		createPatientTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCompleteTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createPatientTask);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Complete Task with current user
	* @action 		  verifying complete Task with current user
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 10, 2013
	***************************************************************************************************/
	
	public boolean verifyCompleteTask(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib createPatientTask ) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
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
			String uniqueName=DateFormat.format(cal.getTime());
			
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
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSuggest,"My tasks");
			click(selenium,"//div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);	
			//String resultList=getText(selenium,lnkTask);
			//String[] splits = resultList.split(" ");
			
			//Get Count and click on Paticular task
			//int metricResult = Integer.parseInt(splits[0]);
			int counter = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
			int tempCount=1;
			
			if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains(createPatientTask.taskName+uniqueName)){
				assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr/td"), "Could not click on task", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}else{	
				
				
				while(counter>=tempCount){
					if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+counter+"]/td").trim().contains(createPatientTask.taskName+uniqueName)){
						assertTrue(click(selenium,"//div[@id='TaskList']/table/tbody/tr["+counter+"]/td"),"could not click the task",selenium, ClassName, MethodName);
						break;
					}
					tempCount++;
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
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//Get task notification count
			String notificationresultList1=getText(selenium,lnkTaskNotification);
			String[] notificationSplits1 = notificationresultList1.split(" ");
			int notificationResult1 = Integer.parseInt(notificationSplits1[0]);
			
			if(!(notificationResult1>notificationResult)){
				Assert.fail("Task Notification Count is not increased");
			}else{
				
			}
			
			//----------------------------------------------------------------------------//
			//  Step-9 : Search Inprogress Notification//
			//----------------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTaskNotification),"Could not click on Task Notification", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSuggest,"In Progress Tasks");
//			click(selenium,"//div[5]/div/div/div/div/div");
//			waitForPageLoad(selenium);
//			
//			
//			int counter1 = (Integer) selenium.getXpathCount("//div[3]/div/div/div/div/div/div[2]/div/div[2]");
			int tempCount1=1;
//			
//			
//			
//			if(getText(selenium,"//div[3]/div/div/div/div/div/div[2]/div/div[2]").trim().contains(createPatientTask.taskName+uniqueName)){
//				if(!(getText(selenium,"//div[3]/div/div/div/div/div/div[2]/div/div[2]").contains(" in progress"))){
//					Assert.fail("records are not getting displayed");
//				}
//			}else{
//			
//				while(counter1>=tempCount1){
//					if(getText(selenium,"//div[3]/div/div/div/div["+tempCount1+"]/div/div[2]/div/div[2]").trim().contains(createPatientTask.taskName+uniqueName)){
//						if(!(getText(selenium,"//div[3]/div/div/div/div["+tempCount1+"]/div/div[2]/div/div[2]").contains(" in progress"))){
//							Assert.fail("records are not getting displayed");
//						}
//						returnValue = true;
//						break;
//					}
//					tempCount1++;
//				}
//			}
			//----------------------------------------------------------------------------//
			//  Step-10 : Verify InProgress Notification Data//
			//----------------------------------------------------------------------------//
			
			
			
			if(!verifyStoredValuesInTaskNotification(selenium,createPatientTask,userAccount,tempCount1,uniqueName)){
				Assert.fail("Data Not Saved Properly");
			}
			//---------------------------------------------------------------------------//
			//  Step-11 : Navigate To Assign To Me page and click on complete button//
			//--------------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTask),"Could not click on Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			waitForPageLoad(selenium);	
			selectValueFromAjaxList(selenium,ajxSuggest,"My tasks");
			//click(selenium,"//div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);
			
			if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains(createPatientTask.taskName+uniqueName)){
				assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr/td"), "Could not click on task", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}	
			
			assertTrue(click(selenium, btnComplete), "Could not click on Complete button in assigned to me page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			
			assertTrue(type(selenium,txtReason,createPatientTask.reason),"Could not enter the reason", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnContinue), "Could not click on continue button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-12 : Navigate To Task Notification //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTaskNotification),"Could not click on Task Notification", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			selectValueFromAjaxList(selenium,ajxSuggest,"Completed Tasks");
			waitForPageLoad(selenium);	
//			click(selenium,"//div[5]/div/div/div/div/div");
//			waitForPageLoad(selenium);
//			
//			
//			int count = (Integer) selenium.getXpathCount("//div[3]/div/div/div/div/div/div[2]/div/div[2]");
			int tempCount2=1;
//			
//			if(getText(selenium,"//div[3]/div/div/div/div/div/div[2]/div/div[2]").trim().contains(createPatientTask.taskName+uniqueName)){
//				if(!(getText(selenium,"//div[3]/div/div/div/div/div/div[2]/div/div[2]").contains("completed"))){
//					Assert.fail("Complated Task is not getting displayed");
//				}
//			}else{
//				while(count>=tempCount2){
//					if(getText(selenium,"//div[3]/div/div/div/div["+tempCount2+"]/div/div[2]/div/div[2]").trim().contains(createPatientTask.taskName+uniqueName)){
//						if((getText(selenium,"//div[3]/div/div/div/div["+tempCount2+"]/div/div[2]/div/div[2]").contains("completed"))){
//							returnValue = true;
//							break;
//						}
//					}
//					tempCount2++;
//				}
//			
//			}
			//--------------------------------------------------------------------//
			//  Step-13: Verify the  Task Notification //
			//--------------------------------------------------------------------//
			
			if(verifyStoredValuesInTaskNotification(selenium,createPatientTask,userAccount,tempCount2,uniqueName))
				returnValue=true;
			else
				Assert.fail("The Edit values are not stored properly in queue");
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
