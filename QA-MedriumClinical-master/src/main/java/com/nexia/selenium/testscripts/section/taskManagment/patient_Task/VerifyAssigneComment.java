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

public class VerifyAssigneComment  extends AbstractTaskManagement{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Assign Comment With Cureent User")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void assigneCommentWithCurrentUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib createPatientTask = new TaskManagementLib();
		createPatientTask.workSheetName = "createPatientTask";
		createPatientTask.testCaseId = "TC_CGT_016";
		createPatientTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAssigneCommentWithCurrentUser(seleniumHost, seleniumPort, browser, webSite, userAccount,createPatientTask);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Assign Comment With User Or User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void assigneCommentWithDifferentUserOrUserRole(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib createPatientTask = new TaskManagementLib();
		createPatientTask.workSheetName = "createPatientTask";
		createPatientTask.testCaseId = "TC_CGT_017";
		createPatientTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAssigneCommentWithDifferentUser(seleniumHost, seleniumPort, browser, webSite, userAccount,createPatientTask);
	}
	
	/****************************************************************************************************** 
	* @purpose        verify Assigne Comment with Cureent user 
	* @action 		  verifying Assigne Comment with Cureent user 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 13, 2013
	*******************************************************************************************************/
	
	public boolean verifyAssigneCommentWithCurrentUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib createPatientTask ) throws IOException{
		
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
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String onBehalfOf= providerNameTemp.replaceAll(", "+ createPatientTask.switchRole, "");
			
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
			waitForPageLoad(selenium);	
			selectValueFromAjaxList(selenium,ajxSuggest,"My tasks");
			click(selenium,"//div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);	
			String resultList=getText(selenium,lnkTask);
			String[] splits = resultList.split(" ");
			int metricResult = Integer.parseInt(splits[0]);
			waitForPageLoad(selenium);	
			
			if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains(createPatientTask.taskName+uniqueName)){
				assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr/td"), "Could not click on task", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}else{
				int count = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
				int counter = metricResult;
				int tempCount=1;
			
					while(count>tempCount){
						if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+counter+"]/td").trim().contains(createPatientTask.taskName+uniqueName)){
							assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr["+counter+"]/td"), "Could not click on task", selenium, ClassName, MethodName);
							returnValue = true;
							break;
						}
						tempCount++;
					}
				
				}
			
			
			//---------------------------------------------------------------------------//
			//  Step-7 : Navigate To Assign To Me page and Enter the comment//
			//--------------------------------------------------------------------------//		
			assertTrue(click(selenium, lnkAddComment), "Could not click on Add comment link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
			String date=DateForma1t.format(cal1.getTime());
			DateFormat=new SimpleDateFormat("HH:mm");
			String time=DateFormat.format(cal1.getTime());
			
			assertTrue(type(selenium,txtComment,createPatientTask.notifyMe),"Could not enter the comments", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,lnkSave),"Could not click on save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			
			//---------------------------------------------------------------------------//
			//  Step-9: Verify the task details//
			//--------------------------------------------------------------------------//
			if(!verifyCommentDetails(selenium,createPatientTask,onBehalfOf,  date, time)){
				Assert.fail("Comment is Not saved properly");
				return false;
			}
			
			//---------------------------------------------------------------------------//
			//  Step-9: Navigate To Home page and search the task//
			//--------------------------------------------------------------------------//
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,lnkTask),"Could not click on Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			waitForPageLoad(selenium);	
			selectValueFromAjaxList(selenium,ajxSuggest,"My tasks");
			click(selenium,"//div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);	
			
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			
			int counter = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
			int tempCount=1;
			
			if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains(createPatientTask.taskName+uniqueName)){
				returnValue = true;
			}else{
				while(counter>=tempCount){
					if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+tempCount+"]/td").trim().contains(createPatientTask.taskName+uniqueName)){
						assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr["+tempCount+"]/td"), "Could not click on task", selenium, ClassName, MethodName);
						returnValue = true;
						break;
					}
					tempCount++;
				}
			}
			
			//---------------------------------------------------------------------------//
			//  Step-10: Verify the task details//
			//--------------------------------------------------------------------------//
			if(!verifyTaskDetails(selenium,createPatientTask,uniqueName, tempCount,onBehalfOf)){
				Assert.fail("Details Not saved properly");
			}
		
			//---------------------------------------------------------------------------//
			//  Step-11: Notify Assinger//
			//--------------------------------------------------------------------------//
			
			if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains(createPatientTask.taskName+uniqueName)){
				assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr/td"), "Could not click on task", selenium, ClassName, MethodName);
				
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
			
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			
			waitForPageLoad(selenium);	
			assertTrue(click(selenium, lnkAction), "Could not click on Action in assigned to me page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
				
			assertTrue(click(selenium, lnkNotifyAssigner), "Could not click on Notify Assigner option from action", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(type(selenium,txtNotify,createPatientTask.notifyMe),"Could not enter the comments", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,btnSend),"Could not click the send button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-12 : Navigate To Task Notification //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTaskNotification),"Could not click on Task Notification", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			waitForPageLoad(selenium);	
			selectValueFromAjaxList(selenium,ajxSuggest,"In Progress Tasks");
			click(selenium,"//div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
		
			int count = (Integer) selenium.getXpathCount("xpath=(//div[contains(@id,'taskTypeOrName')])");
			int tempCount2=1;
			
			if(getText(selenium,"xpath=(//div[contains(@id,'taskTypeOrName')])").trim().contains(createPatientTask.taskName+uniqueName)){
				returnValue = true;
			}else{
				while(count>=tempCount2){
					if(getText(selenium,"xpath=(//div[contains(@id,'taskTypeOrName')])["+tempCount2+"]").trim().contains(createPatientTask.taskName+uniqueName)){
						returnValue = true;
						break;
					}
					tempCount2++;
				}
			
			}
			
			
			//---------------------------------------------------------------------------//
			//  Step-13: Verify the task Notification details//
			//--------------------------------------------------------------------------//
			if(!verifyTaskNotificationDetails(selenium,createPatientTask,tempCount2,uniqueName,onBehalfOf)){
				Assert.fail("Details Not saved properly");
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	public boolean verifyTaskDetails(Selenium selenium,TaskManagementLib createPatientTask, String uniqueName, int count, String provider){
		
		if(!getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+count+"]/td").trim().contains(createPatientTask.taskName+uniqueName)){
			return false;
		}
		
		if(!isElementPresent(selenium,imgComment)){
			return false;
		}
		
		if(!getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+count+"]/td").trim().contains(createPatientTask.dueIn)){
			return false;
		}
		
		if(!getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(createPatientTask.dueDateUnit.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		return true;
	}
	
	
	public boolean verifyCommentDetails(Selenium selenium,TaskManagementLib createPatientTask,String onBehalfOf, String date, String time){
		
		/*if(!getText(selenium,labcomment).trim().contains(createPatientTask.notifyMe)){
			return false;
		}*/
		
		System.out.println(getText(selenium,labcomment).toLowerCase(new java.util.Locale("en","US")).trim());
		System.out.println(("Commented by " + onBehalfOf + " at " + time ));
		System.out.println((" on "+ date));
		if(!(getText(selenium,labcomment).toLowerCase(new java.util.Locale("en","US")).trim().contains(("Commented by " + onBehalfOf + " at " + time)))){
			if((getText(selenium,labcomment).toLowerCase(new java.util.Locale("en","US")).trim().contains(" on "+ date)))
			return false;
		}
		return true;
	}
	
	
	public boolean verifyTaskNotificationDetails(Selenium selenium,TaskManagementLib createPatientTask, int tempCount2, String uniqueName,String onBehalfOf){
		
		//public String commentimage= null; 
		//commentPopup = ("css=div.display-cell.workqueue-comment");
		String path="//div[@id='TaskList']/table/tbody/tr/td";
		
		if(getText(selenium,path).contains(createPatientTask.patientID.toUpperCase())){
			return false;
		}
		if(getText(selenium,path).contains(createPatientTask.taskName+uniqueName.trim())){
			return false;
		}
		System.out.println();
		if(getText(selenium,path).contains(onBehalfOf.trim())){
			return false;
		}
		if(getText(selenium,path).contains("in progress".toUpperCase())){
			return false;
		}
		if(getText(selenium,path).contains("Notified by "+onBehalfOf)){
			return false;
		}
		return true;
	}
	
	/****************************************************************************************************** 
	* @purpose        verify Assigne Comment with Cureent user 
	* @action 		  verifying Assigne Comment with Cureent user 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 13, 2013
	*******************************************************************************************************/
	
	public boolean verifyAssigneCommentWithDifferentUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib createPatientTask ) throws IOException{
		
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
			//  Step-2: Switch Role and get Role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,createPatientTask.assignTo), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//String UserRoleTemp= getText(selenium, lnkTopMenu);
			//String userRole= UserRoleTemp.replaceAll("Security Chart," ,"");
			
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
			//  Step-8: Log out the user //
			//--------------------------------------------------------------------//
			assertTrue(logoutofApplication(selenium,createPatientTask),"Logout Application failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Login to the First user //
			//--------------------------------------------------------------------//
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, createPatientTask.assignToUser, createPatientTask.assignToPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-10: Switch Role and get Role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,createPatientTask.assignTo), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String onBehalfOf= providerNameTemp.replaceAll(","+ createPatientTask.switchRole, "");
			
			//--------------------------------------------------------------------//
			//  Step-11: Navigate To Work Queue  and Search Task//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTask),"Could not click on Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			waitForPageLoad(selenium);	
			//selectValueFromAjaxList(selenium,ajxSuggest,"My tasks");
			waitForPageLoad(selenium);	
		//	click(selenium,"//div[5]/div/div/div/div/div");
			
			String resultList=getText(selenium,lnkTask);
			String[] splits = resultList.split(" ");
			int metricResult = Integer.parseInt(splits[0]);
			int count = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
			int counter = metricResult;
			int tempCount=1;
			
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			
			if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains(createPatientTask.taskName+uniqueName)){
				assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr/td"), "Could not click on task", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}else{
				while(count>tempCount){
						if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+counter+"]/td").trim().contains(createPatientTask.taskName+uniqueName)){
							assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr["+counter+"]/td"), "Could not click on task", selenium, ClassName, MethodName);
							returnValue = true;
							break;
						}
						tempCount++;
					
				/*	assertTrue(click(selenium, lnkTaskList), "Could not click on more option in the task queue", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);	
					count = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
					waitForPageLoad(selenium);*/
				}
			}
			 if(isElementPresent(selenium, btnErrorClose))
		   			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			//---------------------------------------------------------------------------//
			//  Step-12 : Navigate To Assign To Me page and Enter the comment//
			//--------------------------------------------------------------------------//
			assertTrue(click(selenium, lnkAddComment), "Could not click on Add comment link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
			String date=DateForma1t.format(cal1.getTime());
			DateFormat=new SimpleDateFormat("HH:mm");
			String time=DateFormat.format(cal1.getTime());
			
			assertTrue(type(selenium,txtComment,createPatientTask.notifyMe),"Could not enter the comments", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,lnkSave),"Could not click on save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			//---------------------------------------------------------------------------//
			//  Step-13: Verify the task details//
			//--------------------------------------------------------------------------//
			if(!verifyCommentDetails(selenium,createPatientTask,onBehalfOf,  date, time)){
				Assert.fail("Comment is Not saved properly");
				return false;
			}
			
			//---------------------------------------------------------------------------//
			//  Step-14: Navigate To Home page and search the task//
			//--------------------------------------------------------------------------//
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			 if(isElementPresent(selenium, btnErrorClose))
		   			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			assertTrue(click(selenium,lnkTask),"Could not click on Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			waitForPageLoad(selenium);	
			selectValueFromAjaxList(selenium,ajxSuggest,"All tasks");
		
			click(selenium,"//div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);	
		
		
			int Counter = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
			int tempCount1=1;
			while(Counter>=tempCount1){
				if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+tempCount1+"]/td").trim().contains(createPatientTask.taskName+uniqueName)){
					//assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr["+tempCount+"]/td"), "Could not click on task", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);	
					break;
				}
				tempCount++;
			}

			//---------------------------------------------------------------------------//
			//  Step-15: Verify the task details//
			//--------------------------------------------------------------------------//
			if(verifyTaskDetails(selenium,createPatientTask,uniqueName, tempCount1,onBehalfOf)){
				return true;
			}else{
				Assert.fail("Details Not saved properly");
			}
		
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
