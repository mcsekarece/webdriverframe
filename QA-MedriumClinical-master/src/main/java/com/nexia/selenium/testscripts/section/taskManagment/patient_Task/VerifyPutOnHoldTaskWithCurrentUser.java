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

public class VerifyPutOnHoldTaskWithCurrentUser extends AbstractTaskManagement{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Put on Hold Task With Current Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void putOnHoldTaskWithCurrentUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib createPatientTask = new TaskManagementLib();
		createPatientTask.workSheetName = "createPatientTask";
		createPatientTask.testCaseId = "TC_CGT_008";
		createPatientTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyPutOnHoldTask(seleniumHost, seleniumPort, browser, webSite, userAccount,createPatientTask);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Put on Hold Task with current user
	* @action 		  verifying Put on Hold Task with current user
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 10, 2013
	***************************************************************************************************/
	
	public boolean verifyPutOnHoldTask(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib createPatientTask ) throws IOException{
		
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
			//  Step-4: createPatientTaskUnit //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createPatientTask(selenium,createPatientTask,uniqueName),"Create GeneralTask failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			//--------------------------------------------------------------------//
			//  Step-5 : Navigate To Work Queue  and Search Task//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,lnkTask),"Could not click on Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			//selectValueFromAjaxList(selenium,ajxSuggest,"My tasks");
			waitForPageLoad(selenium);	
			String resultList=getText(selenium,lnkTask);
			String[] splits = resultList.split(" ");
			int metricResult = Integer.parseInt(splits[0]);
			System.out.println(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td"));
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
					/*assertTrue(click(selenium, lnkTaskList), "Could not click on more option in the task queue", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);	
					count = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
					waitForPageLoad(selenium);*/
				
			}
			//---------------------------------------------------------------------------//
			//  Step-5 : Navigate To Assign To Me page and select the put on hold option//
			//--------------------------------------------------------------------------//
			assertTrue(click(selenium, lnkAction), "Could not click on Action in assigned to me page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
				
			assertTrue(click(selenium, lnkPutOnHold), "Could not click Put on hold option from action", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
			selectValueFromAjaxList(selenium,ajxDueIn, createPatientTask.dueIn);
			click(selenium,"//div[6]/div/div/div/div/div");
			selectValueFromAjaxList(selenium,ajxDueInUnit,createPatientTask.dueDateUnit);
			click(selenium,"//div[6]/div/div/div/div/div");
			assertTrue(click(selenium,btnContinue),"Could not click the continue button",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	

			//--------------------------------------------------------------------//
			//  Step-5 : Navigate To Work Queue  and Search Hold on Task//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,lnkTask),"Could not click on Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(type(selenium,txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(txtTaskSearchbox, "\\13");
			selectValueFromAjaxList(selenium,ajxSuggest,"Task on hold");
			click(selenium,"//div[5]/div/div/div/div/div");
			/*while(getText(selenium,lnkTaskList).equalsIgnoreCase("Show more...")){
				assertTrue(click(selenium, lnkTaskList), "Could not click on more option in the task queue", selenium, ClassName, MethodName);
			}*/
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			
			int count = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
			int tempCount=1;
			
			if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains(createPatientTask.taskName+uniqueName)){
				return true;
			}else{
				while(count>=tempCount){
				System.out.println(getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+count+"]/td"));
				System.out.println(createPatientTask.taskName+uniqueName);
					if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+count+"]/td").trim().contains(createPatientTask.taskName+uniqueName)){
						return true;
					}
						
					tempCount++;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
}
