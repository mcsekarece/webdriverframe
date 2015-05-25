package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.taskManagement.AbstractTaskManagement;
import com.nexia.selenium.genericlibrary.taskManagement.TaskManagementLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditTaskInEncounter extends AbstractTaskManagement{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Complete Task In Follow Up Type")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editTaskInEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TaskManagementLib createPatientTask = new TaskManagementLib();
		createPatientTask.workSheetName = "createPatientTask";
		createPatientTask.testCaseId = "TC_CGT_012";
		createPatientTask.fetchTaskManagementTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editTaskInEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount,createPatientTask);
	}
	/*************************************************************************************************** 
	* @purpose        verify Edit Task In Encounter 
	* @Specification  SRS_EMR_Encounter_OverAll Rev0.0
	* @action 		  verifying Create Task In Encounter 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @defect		  ##7842
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 10, 2013
	***************************************************************************************************/
	
	public boolean editTaskInEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TaskManagementLib createPatientTask ) throws IOException{
		
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
			//  Step-3: Delete Exist Encounter//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,createPatientTask),"Could nor delete", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate To Begin Encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to Begin encouter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate To Assign Task//
			//--------------------------------------------------------------------//
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkAssginTask),"Could not click the Assign Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
		     
			//--------------------------------------------------------------------//
			//  Step-4: createPatientTask //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createPatientTask(selenium,createPatientTask,uniqueName),"Create GeneralTask failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			
			//--------------------------------------------------------------------//
			//  Step-5: Edit PatientTask //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lblEncounterEditTask),"Could not click the created Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium, lnkTaskEdit),"Could not click the edit Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			TaskManagementLib editPatientTask = new TaskManagementLib();
			editPatientTask.workSheetName = "createPatientTask";
			editPatientTask.testCaseId = "TC_CGT_014";
			editPatientTask.fetchTaskManagementTestData();
			
			
			assertTrue(createPatientTask(selenium,editPatientTask,uniqueName),"Create GeneralTask failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			if(!verifyCreateTask(selenium,editPatientTask)){
				Assert.fail("Details are not saved properly");
			}else
				returnValue = true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyCreateTask(Selenium selenium, TaskManagementLib createPatientTask){
		
		if(!getText(selenium, lblEncounterTask).contains("Follow up")){
			return false;
		}
		if(!getText(selenium, lblEncounterTask).contains(createPatientTask.taskType)){
			return false;
		}
		return true;
	}
}
