package com.nexia.selenium.testscripts.section.chartprevisit.correspondencereport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAssignTaskInCorresReport extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying task for signed Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTaskForSignedReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_014";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying task for signed Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTaskForUnSignedReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_015";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	int taskResult;
	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2:Delete All Correspondence report							 //
			//--------------------------------------------------------------------//
			//Get the count of Task Queue
			String taskQueuecount=getText(selenium,TaskQueue);
			System.out.println(TaskQueue);
			String[] splitS = taskQueuecount.split(" ");
			taskResult = Integer.parseInt(splitS[0]);
			System.out.println(taskResult);		
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	        assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(DeletecorrespondenceReport(selenium, corresData),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3:Correspondence  Report for A patient 
			//--------------------------------------------------------------------//		
			assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(CreateCorrespondenceReport(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
	        waitForPageLoad(selenium);		
	    	assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-4:Search the Patient
			//--------------------------------------------------------------------//	
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	        assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblFirstCorresReport),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, btncorressign),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-5:Verify Assign Task for signed and unsigned REport		//
			//--------------------------------------------------------------------//
			
			assertTrue(verifyAssignTask(selenium, corresData,userAccount),"Creation of task from Corres report failed", selenium, ClassName,MethodName);
			
						
		}
	catch(Exception e)
	{
		assertTrue(false,"Test for verifying task creation from Corres report failed", selenium, ClassName, MethodName);	
	}
		return true;	
}
	
public boolean verifyAssignTask(Selenium selenium,ChartPreVisitLib corresData,String userAccount) throws IOException
{
	try
	{
	
		if(corresData.testCaseId.equals("TC_CCR_014"))
		{
			assertTrue(click(selenium, lnkEncounterAction),"Could not click Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkAssignTask),"Could not click Task button under  Action button ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(CreateTaskForCorresReport(selenium,corresData,userAccount ),"Could not click Task button under  Action button ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);			
			String taskQueuecount=getText(selenium,TaskQueue);
			System.out.println(TaskQueue);
			String[] splitS = taskQueuecount.split(" ");
			int taskResult1 = Integer.parseInt(splitS[0]);
			System.out.println(taskResult1);		
			if(taskResult1>taskResult)
			{
				return true;
			}
			else
			{
				return false;
			}
		}	
		
		if(corresData.testCaseId.equals("TC_CCR_015"))
		{
			
			assertTrue(click(selenium, btncorressign),"Could not sign Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium, lnkEncounterAction),"Could not click Action button in  corres report page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkAssignTask),"Could not click Task button under  Action button ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(CreateTaskForCorresReport(selenium,corresData,userAccount ),"Could not click Task button under  Action button ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);			
			String taskQueuecount=getText(selenium,TaskQueue);
			System.out.println(TaskQueue);
			String[] splitS = taskQueuecount.split(" ");
			int taskResult1 = Integer.parseInt(splitS[0]);
			System.out.println(taskResult1);		
			if(taskResult1>taskResult)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	catch(Exception e)
	{
		assertTrue(false,"Creating task failed", selenium, ClassName, MethodName);	
	}
	return true;
}	
	
}