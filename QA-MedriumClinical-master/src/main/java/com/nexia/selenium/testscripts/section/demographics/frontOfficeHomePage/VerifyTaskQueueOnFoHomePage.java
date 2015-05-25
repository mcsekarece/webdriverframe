package com.nexia.selenium.testscripts.section.demographics.frontOfficeHomePage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.taskManagement.AbstractTaskManagement;
import com.nexia.selenium.genericlibrary.taskManagement.TaskManagementLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTaskQueueOnFoHomePage extends AbstractTaskManagement {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Urgent General Task on Front Office Home Page")
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
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
//			assertTrue(switchRole(selenium,CreateGeneralTask.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Check Count on Task queue  				                  //
			//--------------------------------------------------------------------//
			
			String resultList=getText(selenium,"css=span.gwt-InlineHTML");
			String[] splitS = resultList.split(" ");
			int metricResult1 = Integer.parseInt(splitS[0]);
			System.out.println(metricResult1);
			
			if(metricResult1>=0){
				returnValue=true;
			}
			else{
				Assert.fail("Could not find count of task queue");;
			}
			
			//--------------------------------------------------------------------//
			//  Step-4:Verify Presence of Overdue tasks									  //
			//--------------------------------------------------------------------//
			
			/*if(metricResult1>=1){
				if(getText(selenium,lnkTask).contains("overdue")){
					returnValue=true;
				}
				else{
					Assert.fail("overdue not present");;
				}
				
			}*/
			//--------------------------------------------------------------------//
			//  Step-4: Get the count of the Urgent Task from before adding task//
			//--------------------------------------------------------------------//
			
			resultList=getText(selenium,lnkTask);
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
			//String Date=DateFormat.format(cal.getTime());
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
			//int metricResult1 = Integer.parseInt(splits[0]);
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
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
