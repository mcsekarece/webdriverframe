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

public class VerifyCreateGeneralTask extends AbstractTaskManagement  {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Create General Task for Another user")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCreateGeneralTaskforAnotherUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib CreateGeneralTask = new TaskManagementLib();
		CreateGeneralTask.workSheetName = "CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_GT_003";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyGeneralTask(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Create General Task Same user")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCreateGeneralTaskSameUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib CreateGeneralTask = new TaskManagementLib();
		CreateGeneralTask.workSheetName = "CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_GT_007";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyGeneralTask(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	}

	/*************************************************************************************************** 
	* @purpose        verify createGeneralTask
	* @action 		  verifying create General Task  
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 03, 2013
	***************************************************************************************************/
	
	public boolean verifyGeneralTask(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib CreateGeneralTask ) throws IOException{
		
	    Selenium selenium=null;
		boolean returnValue=false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + CreateGeneralTask.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, CreateGeneralTask.userName, CreateGeneralTask.userPassword),"Login Failed ", selenium, ClassName, MethodName);
					
			
			//--------------------------------------------------------------------//
			//  Step-2: Get the count of the Task from before adding task//
			//--------------------------------------------------------------------//
			
			String resultList=getText(selenium,lnkTask);
			String[] splits = resultList.split(" ");
			
			int metricResult = Integer.parseInt(splits[0]);
			System.out.println("TaskCount - " +metricResult);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
			String Date=DateFormat.format(cal.getTime());
			SimpleDateFormat DateFormat2=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String UniqueName=DateFormat2.format(cal.getTime());

			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Create a General Task//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateToCreateGeneralTask(selenium), "Could not Navigate to Create a General Task",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		     
			//--------------------------------------------------------------------//
			//  Step-3: CreateGeneralTaskUnit //
			//--------------------------------------------------------------------//
			CreateGeneralTask.taskName = CreateGeneralTask.taskName +UniqueName;
			assertTrue(CreateGeneralTask(selenium,CreateGeneralTask,UniqueName),"Create GeneralTask failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Logout of the Application //
			//--------------------------------------------------------------------//
			
			if(CreateGeneralTask.testCaseId.equals("TC_GT_003")){
				
			assertTrue(logoutofApplication(selenium,CreateGeneralTask),"Logout Application failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//  Step-5: Login into the Application //
			
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, CreateGeneralTask.assignToUser, CreateGeneralTask.assignToPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			}

			//--------------------------------------------------------------------//
			//  Step-6: Get the count of the Task from after adding task//
			//--------------------------------------------------------------------//
			
			String resultList1=getText(selenium,lnkTask);
			String[] splits1 = resultList1.split(" ");
			int metricResult1 = Integer.parseInt(splits1[0]);
			System.out.println("TaskCount - " +metricResult1);
			if(metricResult1>metricResult){
				returnValue=true;
			}
			/*else
				Assert.fail("Count is not increased");*/
		
			//--------------------------------------------------------------------//
			//  Step-7: select the Assigned task  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkTask),"Could not click on Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(type(selenium,txtTaskSearchbox, CreateGeneralTask.taskName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			
			if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains( UniqueName)){
				assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr/td"), "Could not click on task", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}else{
				int count = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
				//int counter = metricResult1;
				int tempCount=1;
				//while(count<=counter){
					while(count>tempCount){
						if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+tempCount+"]/td").trim().contains( UniqueName)){
							assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr["+tempCount+"]/td"), "Could not click on task", selenium, ClassName, MethodName);
							returnValue = true;
							break;
						}
						tempCount++;
					}
					/*assertTrue(click(selenium, lnkTaskList), "Could not click on more option in the task queue", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);	
					count = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
					waitForPageLoad(selenium);*/
				//}
			}
			waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-8: Verify the Assigned task  //
			//--------------------------------------------------------------------//
			assertTrue(verifyAssignedTaskDetails(selenium, CreateGeneralTask,Date,UniqueName), "Verify Assigned details failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	public boolean verifyAssignedTaskDetails(Selenium selenium,TaskManagementLib CreateGeneralTask,String Date,String UniqueName) throws IOException{
		
		assertTrue(isTextPresent(selenium,UniqueName), "Verify Assigned details failed", selenium, ClassName, MethodName);
		
		
		assertTrue(isTextPresent(selenium,"Pending"), "Verify Assigned details failed", selenium, ClassName, MethodName);
		
		assertTrue(isTextPresent(selenium,Date), "Verify Assigned details failed", selenium, ClassName, MethodName);
		
		
		return true;
	}

}
