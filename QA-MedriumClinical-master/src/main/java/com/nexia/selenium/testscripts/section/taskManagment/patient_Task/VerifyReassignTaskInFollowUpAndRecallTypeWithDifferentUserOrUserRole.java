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

public class VerifyReassignTaskInFollowUpAndRecallTypeWithDifferentUserOrUserRole extends AbstractTaskManagement{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Reassign Task In Follow Up Type With Different User or User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void reassignTaskInFollowUpWithDifferentUserorUserRole(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib createPatientTask = new TaskManagementLib();
		createPatientTask.workSheetName = "createPatientTask";
		createPatientTask.testCaseId = "TC_CGT_014";
		createPatientTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyReassignTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createPatientTask);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Reassign Task In Recall Type With Different User or User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void reassignTaskInRecallWithDifferentUserOrUserRole(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib createPatientTask = new TaskManagementLib();
		createPatientTask.workSheetName = "createPatientTask";
		createPatientTask.testCaseId = "TC_CGT_015";
		createPatientTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyReassignTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createPatientTask);
	}
	
	/****************************************************************************************************** 
	* @purpose        verify Reassign Task In Follow Up And Recall Type with differnt user role or  user
	* @action 		  verifying Reassign Task In Follow Up And Recall Type with differnt user role or  user
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 13, 2013
	*******************************************************************************************************/
	
	public boolean verifyReassignTask(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib createPatientTask ) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + createPatientTask.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, createPatientTask.assignToUser, createPatientTask.assignToPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Get Count //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,createPatientTask.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//String providerNameTemp= getText(selenium, lnkTopMenu);
			//String userRole= providerNameTemp.replaceAll("Security Chart," ,"");
			
			
			String taskResultList=getText(selenium,lnkTask);
			String[] taskSplits = taskResultList.split(" ");
			int taskResult = Integer.parseInt(taskSplits[0]);
			
			//--------------------------------------------------------------------//
			//  Step-3: Log out the user //
			//--------------------------------------------------------------------//
			assertTrue(logoutofApplication(selenium,createPatientTask),"Logout Application failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Login to the Another user //
			//--------------------------------------------------------------------//
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, createPatientTask.userName, createPatientTask.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Search Patient//
			//--------------------------------------------------------------------//
			String providerTemp= getText(selenium, lnkTopMenu);
			String userName= providerTemp.replaceAll(", "+createPatientTask.switchRole, "");
			
			searchPatientNexiaForProviderHomePage(selenium,createPatientTask.patientID);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Create a General Task//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(navigateToCreateTask(selenium), "Could not navigate to create task",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		     
			//--------------------------------------------------------------------//
			//  Step-7: createPatientTask //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createPatientTask(selenium,createPatientTask,uniqueName),"Create GeneralTask failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
	
			//--------------------------------------------------------------------//
			//  Step-8 : Navigate To Work Queue  and Search Task//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTask),"Could not click on Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			String resultList=getText(selenium,lnkTask);
			String[] splits = resultList.split(" ");
			int metricResult = Integer.parseInt(splits[0]);
			
			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			waitForPageLoad(selenium);
			while(isElementPresent(selenium, lnkShowMoreTask)&&isElementVisible(selenium, lnkShowMoreTask)){
				click(selenium, lnkShowMoreTask);
				waitForPageLoad(selenium);
			}
			//selectValueFromAjaxList(selenium,ajxSuggest,"My tasks");
			//click(selenium,"//div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);	
			
			//get Task Count//
			
			
			
			int counter = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
			int tempCount=1;
			
			if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains(createPatientTask.taskName+uniqueName)){
				assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr/td"), "Could not click on task", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}else{
				while(counter>=tempCount){
					if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+tempCount+"]/td").trim().contains(createPatientTask.taskName+uniqueName)){
						assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr["+tempCount+"]/td"), "Could not click on task", selenium, ClassName, MethodName);
						waitForPageLoad(selenium);	
						break;
					}
					tempCount++;
				}
			}
			
			//---------------------------------------------------------------------------//
			//  Step-9 : Navigate To Assign To Me page and click on Notify Assigner//
			//--------------------------------------------------------------------------//
			assertTrue(click(selenium, lnkAction), "Could not click on Action link in assigned to me page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
				
			assertTrue(click(selenium, lnkReassign), "Could not click on Reassign option from action link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			selectValueFromAjaxList(selenium,ajxSelectAssignUser,createPatientTask.switchRole);
			waitForPageLoad(selenium);	
			
			assertTrue(type(selenium,txtReassignReason,createPatientTask.notifyMe),"Could not enter the comments", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,btnSend),"Could not click the send button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//----------------------------------------------------------------------------//
			//  Step-8 : Navigate to Task Notification and Compare  Notification count//
			//----------------------------------------------------------------------------//
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			
			String notificationresultList1=getText(selenium,lnkTask);
			String[] notificationSplits1 = notificationresultList1.split(" ");
			int notificationResult1 = Integer.parseInt(notificationSplits1[0]);
			
			if(!(notificationResult1<=metricResult)){
				Assert.fail("Task Notification Count is not increased");
			}
			
			//--------------------------------------------------------------------//
			//  Step-9: Log out the another user //
			//--------------------------------------------------------------------//
			assertTrue(logoutofApplication(selenium,createPatientTask),"Logout Application failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Login to the First user //
			//--------------------------------------------------------------------//
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, createPatientTask.assignToUser, createPatientTask.assignToPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11: Compare the count //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,createPatientTask.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String taskResultList1=getText(selenium,lnkTask);
			String[] taskSplits1 = taskResultList1.split(" ");
			int taskResult1 = Integer.parseInt(taskSplits1[0]);
			
			if(!(taskResult1>taskResult)){
				Assert.fail("Count is not increased");
			}
			
			
			//---------------------------------------------------------------------------//
			//  Step-12 : Search Task //
			//--------------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTask),"Could not click on Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			selectValueFromAjaxList(selenium,ajxSuggest,createPatientTask.switchRole);
			waitForPageLoad(selenium);	
			
			
			int count = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
			int tempCount1=1;
			
			if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains(createPatientTask.taskName+uniqueName)){
				if(!getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains("In progress")){
					returnValue = true;
				}
			}else{
				while(count>=tempCount1){
					if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+tempCount1+"]/td").trim().contains(createPatientTask.taskName+uniqueName)){
						if(!getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+tempCount+"]/td").trim().contains("In progress")){
							Assert.fail("Inprogress task record is not getting dispaled");
						}
						returnValue = true;
						break;
					}
					tempCount1++;
				}
			}
			
			
			//---------------------------------------------------------------------------//
			//  Step-13 : Verify Task Details//
			//--------------------------------------------------------------------------//
			if(!verifyTaskDetails(selenium,createPatientTask,uniqueName,userName, tempCount1)){
				Assert.fail("Details Not saved properly");
			}else
				returnValue = true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		 return returnValue;
	}
	
	public boolean verifyTaskDetails(Selenium selenium,TaskManagementLib createPatientTask, String uniqueName, String userName,int tempCount){
		if(!getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+tempCount+"]/td").trim().contains(createPatientTask.taskName+uniqueName)){
			return false;
		}	
		if(!getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+tempCount+"]/td").trim().contains(userName)){
			return false;
		}	
		if(!getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+tempCount+"]/td").trim().contains(createPatientTask.switchRole)){
			return false;
		}
		return true;
	}
}
