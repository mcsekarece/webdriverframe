	package com.nexia.selenium.testscripts.section.taskManagment.patient_Task;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.taskManagement.AbstractTaskManagement;
import com.nexia.selenium.genericlibrary.taskManagement.TaskManagementLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAddAttachmentInGeneralTask extends AbstractTaskManagement{
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Create GeneralTask for other practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addAttachmentInGeneralTask(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib CreateGeneralTask = new TaskManagementLib();
		CreateGeneralTask.workSheetName = "CreateGeneralTask";
		CreateGeneralTask.testCaseId = "TC_GT_005";
		CreateGeneralTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAddAttachment(seleniumHost, seleniumPort, browser, webSite, userAccount,CreateGeneralTask);
	}
	/*************************************************************************************************** 
	* @purpose        verify createGeneralTask
	* @action 		  verifying create General Task  
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @defect		  #7628
	* @useraccount    Both (US and Canada)
	* @since  	      Dec 26, 2013
	***************************************************************************************************/
	
	public boolean verifyAddAttachment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib CreateGeneralTask ) throws IOException, AWTException, InterruptedException{
		
	    Selenium selenium=null;
		boolean returnValue=true;
       
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
			assertTrue(navigateToCreateGeneralTask(selenium), "Could not click on Navigate to Create a General Task",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAttachment),"Could not click the Add Attachement Button", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3:Attache File in Task//
			//--------------------------------------------------------------------//
			assertTrue(addAttachment(selenium), "Could not Update the file",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
