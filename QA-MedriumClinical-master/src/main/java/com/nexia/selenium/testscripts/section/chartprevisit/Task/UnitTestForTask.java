package com.nexia.selenium.testscripts.section.chartprevisit.Task;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForTask extends AbstractChartPreVisit{
	@Test(enabled=false)
	//@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Due In Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDueInWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest taskTestData = new  ChartPreVisitLibUnitTest();
		taskTestData.workSheetName = "UnitTest_Task";
		taskTestData.testCaseId = "TC_UT_001";
		taskTestData.fetchHomeTestData();	
		createTask(seleniumHost, seleniumPort, browser, webSite, userAccount, taskTestData);
	} 
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Due In Unit Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDueInUnitWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest taskTestData = new  ChartPreVisitLibUnitTest();
		taskTestData.workSheetName = "UnitTest_Task";
		taskTestData.testCaseId = "TC_UT_002";
		taskTestData.fetchHomeTestData();	
		createTask(seleniumHost, seleniumPort, browser, webSite, userAccount, taskTestData);
	} 
	@Test(enabled=false)
	//@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Assign Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAssignWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest taskTestData = new  ChartPreVisitLibUnitTest();
		taskTestData.workSheetName = "UnitTest_Task";
		taskTestData.testCaseId = "TC_UT_003";
		taskTestData.fetchHomeTestData();	
		createTask(seleniumHost, seleniumPort, browser, webSite, userAccount, taskTestData);
	} 
	/**
	 * createTask
	 * function to perform unit test on the create Task page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	    Sep 12, 2012
	 */
	
	public boolean createTask(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLibUnitTest taskTestData) throws IOException{
		Selenium selenium = null;
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + taskTestData.toString());
			loginForNexiaFromProviderSite(selenium, userAccount, taskTestData.userName, taskTestData.userPassword);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//Step 2:Navigate to create a task page							//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickAction),"Could not click Quick Actions link",selenium,ClassName,MethodName);
			assertTrue(click(selenium,lnkRegisterPatient),"Could not click create a general task link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// step 4:perform unit test for various fields in prescribe medication //
			//--------------------------------------------------------------------//
			assertTrue(unitTestForTask(selenium, taskTestData),"",selenium,ClassName,MethodName);
			taskTestData.validationFieldID=taskTestData.validationFieldID==null? taskTestData.validationFieldID ="" : taskTestData.validationFieldID.trim();
			if(!taskTestData.validationFieldID.equals("")){
			assertTrue(isElementPresent(selenium, taskTestData.validationFieldID), "The validation message field did not appear",selenium,ClassName,MethodName);
			assertTrue(getText(selenium, taskTestData.validationFieldID).contains(taskTestData.validationMessage), "The expected validation message should contain the text - "+ taskTestData.validationMessage + " The actual validation message shown - " + getText(selenium, taskTestData.validationFieldID),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			returnValue=true;
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + taskTestData.toString());
			returnValue=false;
		}
		return returnValue;
	}
}

