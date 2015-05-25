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

public class VerifyTaskCountInAnotherPractice extends AbstractTaskManagement{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Task count with Another Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTaskCountWithAnotherPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib createPatientTask = new TaskManagementLib();
		createPatientTask.workSheetName = "createPatientTask";
		createPatientTask.testCaseId = "TC_CGT_007";
		createPatientTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTaskCount(seleniumHost, seleniumPort, browser, webSite, userAccount,createPatientTask);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Urgent Task count with Another Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUrgentTaskCountWithAnotherPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib createPatientTask = new TaskManagementLib();
		createPatientTask.workSheetName = "createPatientTask";
		createPatientTask.testCaseId = "TC_CGT_006";
		createPatientTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTaskCount(seleniumHost, seleniumPort, browser, webSite, userAccount,createPatientTask);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Task count In Task queue
	* @action 		  verifying Task count In Task queue
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 06, 2013
	***************************************************************************************************/
	
	public boolean verifyTaskCount(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib createPatientTask ) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
		String urgentResult1= "";
		String urgentResult= "";

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + createPatientTask.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, createPatientTask.assignToUser, createPatientTask.assignToPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Get the count of the Task from before adding task//
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String onBehalfOf= providerNameTemp.replaceAll(", "+createPatientTask.switchRole, "");
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String resultList=getText(selenium,lnkTask);
			String splits[] = resultList.split(" ");
			int metricResult = Integer.parseInt(splits[0]);
			System.out.println(metricResult);
			if(createPatientTask.testCaseId.equals("TC_CGT_006")){
				if(resultList.contains("urgent")){
					urgentResult = splits[2].replaceAll("[(]","");
				}else
					urgentResult = "0";
			}
			
			//--------------------------------------------------------------------//
			//  Step-3: Log out the SCHEUDLTEST user//
			//--------------------------------------------------------------------//
			assertTrue(logoutofApplication(selenium,createPatientTask),"Logout Application failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Login to testingtester user//
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
			assertTrue(navigateToCreateTask(selenium), "Could not navigate to Patient task",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		     
			//--------------------------------------------------------------------//
			//  Step-7: createPatientTask//
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			createPatientTask.assignTo = onBehalfOf;
			assertTrue(createPatientTask(selenium,createPatientTask,uniqueName),"Create GeneralTask failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			//--------------------------------------------------------------------//
			//  Step-8: Log out the test testing tester user//
			//--------------------------------------------------------------------//
			assertTrue(logoutofApplication(selenium,createPatientTask),"Logout Application failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Log in to the SCHEUDLTEST user//
			//--------------------------------------------------------------------//
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, createPatientTask.assignToUser, createPatientTask.assignToPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Get the count of the Task from after adding task//
			//--------------------------------------------------------------------//
			String resultList1=getText(selenium,lnkTask);
			String[] splits1 = resultList1.split(" ");
			int metricResult1 = Integer.parseInt(splits1[0]);
			System.out.println(metricResult1);
			if(createPatientTask.testCaseId.equals("TC_CGT_006")){
				if(resultList.contains("urgent")){
					 urgentResult1 = splits[2].replaceAll("[(]", "");
				}else
					urgentResult1 = "0";
			}

			if(createPatientTask.testCaseId.equals("TC_CGT_006")){
				int urgentTaskCount = Integer.parseInt(urgentResult1);
				int urgentTaskCounter = Integer.parseInt(urgentResult);
				if(urgentTaskCount>=urgentTaskCounter){
					returnValue = true;
				}else
					Assert.fail("Urgent task count is not increased");
				
			}else if(metricResult1>metricResult){
				returnValue=true;
			}else
				Assert.fail("Count is not increased");
	
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
