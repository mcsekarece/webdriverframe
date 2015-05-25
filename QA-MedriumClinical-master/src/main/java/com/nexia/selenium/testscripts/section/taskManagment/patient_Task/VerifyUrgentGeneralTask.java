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

public class VerifyUrgentGeneralTask  extends AbstractTaskManagement {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Urgent General Task For Same user")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUrgentGeneralTaskForSameUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib CreateGeneralTask = new TaskManagementLib();
		CreateGeneralTask.workSheetName = "CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_GT_008";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyUrgentGeneralTask(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	}
	
	
	/*************************************************************************************************** 
	* @purpose       verify Urgent General Task For same user
	* @action 		 verifying Urgent General Task For same user
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 12, 2013
	***************************************************************************************************/
	
	public boolean verifyUrgentGeneralTask(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib CreateGeneralTask ) throws IOException{
		
	    Selenium selenium=null;
		boolean returnValue=false;
		String urgentResult1= "";
		String urgentResult= "";
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + CreateGeneralTask.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, CreateGeneralTask.userName, CreateGeneralTask.userPassword),"Login Failed ", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-2: Get the count of the Urgent Task from before adding task//
			//--------------------------------------------------------------------//
			
			String resultList=getText(selenium,lnkTask);
			String[] splits = resultList.split(" ");
			//int metricResult = Integer.parseInt(splits[0]);
			if(resultList.contains("urgent")){
				 urgentResult = splits[2].replaceAll("[(]", "");
			}else
				urgentResult = "0";
			
			int urgentResultCount = Integer.parseInt(urgentResult);
			System.out.println("urgentTaskCount - " +urgentResultCount);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
			String Date=DateFormat.format(cal.getTime());
			SimpleDateFormat DateFormat2=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String UniqueName=DateFormat2.format(cal.getTime());

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Create a General Task//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateToCreateGeneralTask(selenium), "Could not Navigate to Create a General Task",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		     
			//--------------------------------------------------------------------//
			//  Step-4: CreateGeneralTaskUnit //
			//--------------------------------------------------------------------//
			
			assertTrue(CreateGeneralTask(selenium,CreateGeneralTask,UniqueName),"Create GeneralTask failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		

			//--------------------------------------------------------------------//
			//  Step-5: Get the count of the Urgent Task from after adding task//
			//--------------------------------------------------------------------//

			String resultList1=getText(selenium,lnkTask);
			String[] splits1 = resultList1.split(" ");
			int metricResult1 = Integer.parseInt(splits[0]);
			if(resultList1.contains("urgent")){
				 urgentResult1 = splits1[2].replaceAll("[(]", "");
			}else
				urgentResult1 = "0";
			
			int urgentResultCount1 = Integer.parseInt(urgentResult1);
			System.out.println("urgentTaskCount1 - " +urgentResultCount1);
			
			if(urgentResultCount1>=urgentResultCount){
				returnValue = true;
			}else
				Assert.fail("Urgent task count is not increased");
			
		
			//--------------------------------------------------------------------//
			//  Step-6: Select the Assigned task  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkTask),"Could not click on Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(type(selenium,txtTaskSearchbox, UniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			selenium.keyPress(txtTaskSearchbox, "\\13");
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			System.out.print(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td"));
			if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains(UniqueName)){
				assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr/td"), "Could not click on task", selenium, ClassName, MethodName);
				
			}else{
				int count = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
				int counter = metricResult1;
				int tempCount=1;
				while(count<=counter){
					while(count>tempCount){
						if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+counter+"]/td").trim().contains( UniqueName)){
							assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr["+counter+"]/td"), "Could not click on task", selenium, ClassName, MethodName);
							returnValue = true;
							break;
						}
						tempCount++;
					}
					/*assertTrue(click(selenium, lnkTaskList), "Could not click on more option in the task queue", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);	
					count = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
					waitForPageLoad(selenium);*/
					count++;
				}
			}
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify the Assigned task  //
			//--------------------------------------------------------------------//
		
			assertTrue(verifyAssignedUrgentTaskDetails(selenium, CreateGeneralTask,Date,UniqueName), "Verify Urgent Task Assigned details failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	public boolean verifyAssignedUrgentTaskDetails(Selenium selenium,TaskManagementLib CreateGeneralTask,String Date,String UniqueName) throws IOException{
		
		assertTrue(isTextPresent(selenium, UniqueName), "Verify Urgent Task Assigned details failed", selenium, ClassName, MethodName);
		
		assertTrue(isTextPresent(selenium,CreateGeneralTask.instructions), "Verify Urgent Task Assigned details failed", selenium, ClassName, MethodName);
		
		assertTrue(isTextPresent(selenium, Date), "Verify Urgent Task Assigned details failed", selenium, ClassName, MethodName);
		
				
		return true;
	}

}
