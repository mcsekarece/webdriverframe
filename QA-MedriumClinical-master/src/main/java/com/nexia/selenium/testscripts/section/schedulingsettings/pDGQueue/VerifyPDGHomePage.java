package com.nexia.selenium.testscripts.section.schedulingsettings.pDGQueue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.nexia.selenium.genericlibrary.taskManagement.AbstractTaskManagement;
import com.nexia.selenium.genericlibrary.taskManagement.TaskManagementLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPDGHomePage extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify PDG Home Page ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void PDGHomePage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ScheduleSeries";
		pDGData.testCaseId = "TC_SS_018";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyPDGHomePage(seleniumHost, seleniumPort, browser, webSite, userAccount,pDGData);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify PDG Home Page
	* @action 		  verify PDG Home Page
	* @author         Aspire QA
	* @throws         IOException 
	* @defect 		  #7858
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Dec 18, 2013
	***************************************************************************************************/
	public boolean verifyPDGHomePage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pDGData ) throws IOException{
		
	    Selenium selenium=null;
		boolean returnValue=true;
        String uniqueName= null;
        String needAction = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pDGData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, pDGData.userName, pDGData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch Role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pDGData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Verify PDG Home Page //
			//--------------------------------------------------------------------//
			AbstractChartPreVisit chartData = new AbstractChartPreVisit();
			
			needAction = getText(selenium,chartData.lblAction);
			
			if(!needAction.contains(chartData.lblTask)){
				Assert.fail("Task  is not getting displayed");
			}
			
			if(!needAction.contains(chartData.lblRxrenewals)){
				Assert.fail("Rx renewals is not getting displayed");
			}
			
			if(!needAction.contains(chartData.lblReport)){
				Assert.fail("Report is not getting displayed");
			}
			
			if(!needAction.contains(chartData.lblEncounter)){
				Assert.fail("Encounter is not getting displayed");
			}
			
			if(!needAction.contains(chartData.lblUnMatched)){
				Assert.fail("Un Matched patient record is not getting displayed");
			}
			if(!needAction.contains(chartData.lblbumpList)){
				Assert.fail("Bump List is not getting displayed");
			}
			if(!needAction.contains(chartData.lblwaitList)){
				Assert.fail("wait List is not getting displayed");
			}
			if(!needAction.contains(chartData.lblUnConfirm)){
				Assert.fail("UnConfirm visit is not getting displayed");
			}

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Create a General Task//
			//--------------------------------------------------------------------//
			AbstractTaskManagement TaskData = new AbstractTaskManagement();
			TaskManagementLib createPatientTask = new TaskManagementLib();
			createPatientTask.workSheetName = "CreateGeneralTask";
			createPatientTask.testCaseId = "TC_GT_009";
			createPatientTask.fetchTaskManagementTestData();
			
			assertTrue(TaskData.navigateToCreateGeneralTask(selenium), "Could not click on Navigate to Create a General Task",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		     
			//--------------------------------------------------------------------//
			//  Step-4: CreateGeneralTaskUnit //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(TaskData.CreateGeneralTask(selenium,createPatientTask,uniqueName),"Create GeneralTask failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,TaskData.lnkTask),"Could not click on Task", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(type(selenium,TaskData.txtTaskSearchbox,createPatientTask.taskName+uniqueName),"Could not type the task name", selenium, ClassName, MethodName);
			selenium.keyPress(TaskData.txtTaskSearchbox, "\\13");
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,TaskData.ajxSuggest,"My tasks");
			click(selenium,"//div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);	
			//String resultList=getText(selenium,lnkTask);
			//String[] splits = resultList.split(" ");
			
			//Get Count and click on Paticular task
			//int metricResult = Integer.parseInt(splits[0]);
			int counter = (Integer) selenium.getXpathCount("//div[@id='TaskList']/table/tbody/tr/td");
			int tempCount=1;
			
			if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr/td").trim().contains(createPatientTask.taskName+uniqueName)){
				assertTrue(click(selenium, "//div[@id='TaskList']/table/tbody/tr/td"), "Could not click on task", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}else{	
				
				
				while(counter>=tempCount){
					if(getText(selenium,"//div[@id='TaskList']/table/tbody/tr["+counter+"]/td").trim().contains(createPatientTask.taskName+uniqueName)){
						assertTrue(click(selenium,"//div[@id='TaskList']/table/tbody/tr["+counter+"]/td"),"could not click the task",selenium, ClassName, MethodName);
						break;
					}
					tempCount++;
				}
			}
			
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-2: Verify PDG Home Page //
			//--------------------------------------------------------------------//
			
			if(!selenium.isTextPresent("PDG sessions for")){
				Assert.fail("PDG page is not getting displayed");
			}
	
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
