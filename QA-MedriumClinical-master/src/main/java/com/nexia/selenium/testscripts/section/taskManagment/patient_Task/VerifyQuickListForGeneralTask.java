package com.nexia.selenium.testscripts.section.taskManagment.patient_Task;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.taskManagement.AbstractTaskManagement;
import com.nexia.selenium.genericlibrary.taskManagement.TaskManagementLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyQuickListForGeneralTask  extends AbstractTaskManagement{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify QuickList For GeneralTask")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyQuickListForGeneralTask(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib CreateGeneralTask = new TaskManagementLib();
		CreateGeneralTask.workSheetName = "CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_GT_006";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyQuickList(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	}
	
	/*************************************************************************************************** 
	* @purpose       verifyQuickListForGeneralTask
	* @action 		 verifying QuickList For GeneralTask
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 12, 2013
	***************************************************************************************************/
	
	public boolean verifyQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib CreateGeneralTask ) throws IOException{
		
	    Selenium selenium=null;
		boolean returnValue=true;
		  String UniqueName= null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + CreateGeneralTask.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, CreateGeneralTask.userName, CreateGeneralTask.userPassword),"Login Failed ", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Create a General Task//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateToCreateGeneralTask(selenium), "Could not Navigate to Create a General Task",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		     
			//--------------------------------------------------------------------//
			//  Step-3: CreateGeneralTaskUnit //
			//--------------------------------------------------------------------//
			
			assertTrue(CreateGeneralTask(selenium,CreateGeneralTask,UniqueName),"Create GeneralTask failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4 : Verify Quick List //
			//--------------------------------------------------------------------//
			
			assertTrue(navigateToCreateGeneralTask(selenium), "Could not Navigate to Create a General Task",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtTaskName,CreateGeneralTask.taskName), "Could not type Task Name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnQuickList), "Could not click on Quick List button",selenium, ClassName, MethodName);
			
			if(!getText(selenium,vfyQuickList).contains(CreateGeneralTask.taskName)){
				Assert.fail("Verify Quick List Failed");
			}
	
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		}
	
}
