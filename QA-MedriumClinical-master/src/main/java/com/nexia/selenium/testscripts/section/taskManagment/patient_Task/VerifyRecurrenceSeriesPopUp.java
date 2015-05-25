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

public class VerifyRecurrenceSeriesPopUp extends AbstractTaskManagement{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Recurrence series pop up in Edit Task")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void recurrenceSeriesPopUpWithEditTask(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib createPatientTask = new TaskManagementLib();
		createPatientTask.workSheetName = "createPatientTask";
		createPatientTask.testCaseId = "TC_CGT_020";
		createPatientTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyRecurrencePopUp(seleniumHost, seleniumPort, browser, webSite, userAccount,createPatientTask);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Complete Task with current user
	* @action 		  verifying complete Task with current user
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 14, 2013
	***************************************************************************************************/
	
	public boolean verifyRecurrencePopUp(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib createPatientTask ) throws IOException{
		
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
			//  Step-5 : Navigate To Work Queue  and Search Task//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTask),"Could not click on Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			//selectValueFromAjaxList(selenium,ajxSuggest,"My tasks");
			waitForPageLoad(selenium);	
			if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains(createPatientTask.taskName+uniqueName)){
				assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr/td"), "Could not click on task", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}else{	
				while(getText(selenium,lnkTaskList).equalsIgnoreCase("Show more...")){
					assertTrue(click(selenium, lnkTaskList), "Could not click on more option in the task queue", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);	
				}
				int counter = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
				int tempCount1=1;
				while(counter>=tempCount1){
					if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+counter+"]/td").trim().contains(createPatientTask.taskName+uniqueName)){
						assertTrue(click(selenium,"//div[@id='TaskList']/table/tbody/tr["+counter+"]/td"),"could not click the task",selenium, ClassName, MethodName);
						break;
					}
					tempCount1++;
				}
			}
			//---------------------------------------------------------------------------//
			//  Step-6 : Navigate To Assign To Me page and click on Notify Assigner//
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
			//  Step-7 : Search Task //
			//----------------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTaskNotification),"Could not click on Task Notification", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			//selectValueFromAjaxList(selenium,ajxSuggest,"In Progress Tasks");
			
			while(getText(selenium,lnkTaskList).equalsIgnoreCase("Show more...")){
				assertTrue(click(selenium, lnkTaskList), "Could not click on more option in the task queue", selenium, ClassName, MethodName);
			}
			
			assertTrue(click(selenium, lblWorkQueueListItem1), "Could not click on WorkQueue ListItem task queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			/*int counter1 = (Integer) selenium.getXpathCount("//div[3]/div/div/div/div/div/div[2]/div/div[2]");
			int tempCount=1;
			while(counter1>=tempCount){
				if(getText(selenium,"//div[3]/div/div/div/div["+tempCount+"]/div/div[2]/div/div[2]").trim().contains(createPatientTask.taskName+uniqueName)){
					assertTrue(click(selenium, "//div[3]/div/div/div/div["+tempCount+"]/div/div[2]/div/div[2]"), "Could not click Search task in the task queue", selenium, ClassName, MethodName);
					break;
				}
				tempCount++;
			}*/
	
			//----------------------------------------------------------------------------//
			//  Step-8 : Navigate to edit Task Page //
			//----------------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnEdit),"Could not click on edit button from Task Notification Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,btnSave),"could not click the save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//----------------------------------------------------------------------------//
			//  Step-9 : verify Recurrence Series pop up  //
			//----------------------------------------------------------------------------//
			if(!verifyRecurrenceSeriesPopUp(selenium)){
				Assert.fail("Recurrence Series Pop up is not getting displayed");
			}else{
				returnValue = true;
			}

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyRecurrenceSeriesPopUp(Selenium selenium){
		
		if(!isElementPresent(selenium,recurrencePopUp)){
			return false;
		}
		if(!isElementPresent(selenium,chckOnlyThisRecurrence)){
			return false;
		}
		if(!isElementPresent(selenium,chkAllRecurrence)){
			return false;
		}
		if(!isElementPresent(selenium,btnSend)){
			return false;
		}
		if(!isElementPresent(selenium,btnCancel)){
			return false;
		}
		return true;
	}
}
