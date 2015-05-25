package com.nexia.selenium.testscripts.section.chartprevisit.ChartDisclosure;



import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyChartDisclosureThroughCreateTask extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Cancel For Export Chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyChartDisclosureMandatory(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ChartPreVisitLib PatienttaskData = new ChartPreVisitLib();
		PatienttaskData.workSheetName = "CreatePatientTask";
		PatienttaskData.testCaseId = "TC_CD_001";
		PatienttaskData.fetchChartPreVisitTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreatePatientTask(seleniumHost, seleniumPort, browser, webSite,userAccount, PatienttaskData);
	}
	@Test(groups = {"Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Cancel For Export Chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyChartDisclosureAllFields(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ChartPreVisitLib PatienttaskData = new ChartPreVisitLib();
		PatienttaskData.workSheetName = "CreatePatientTask";
		PatienttaskData.testCaseId = "TC_CD_002";
		PatienttaskData.fetchChartPreVisitTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreatePatientTask(seleniumHost, seleniumPort, browser, webSite,userAccount, PatienttaskData);
	}
	@Test(groups = {"Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Cancel For Export Chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyChartDisclosureOtherReq(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ChartPreVisitLib PatienttaskData = new ChartPreVisitLib();
		PatienttaskData.workSheetName = "CreatePatientTask";
		PatienttaskData.testCaseId = "TC_CD_003";
		PatienttaskData.fetchChartPreVisitTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreatePatientTask(seleniumHost, seleniumPort, browser, webSite,userAccount, PatienttaskData);
	}
	@Test(groups = {"Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Cancel For Export Chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyChartDisclosurePatientRecDelMail(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ChartPreVisitLib PatienttaskData = new ChartPreVisitLib();
		PatienttaskData.workSheetName = "CreatePatientTask";
		PatienttaskData.testCaseId = "TC_CD_004";
		PatienttaskData.fetchChartPreVisitTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreatePatientTask(seleniumHost, seleniumPort, browser, webSite,userAccount, PatienttaskData);
	}
	public void VerifyChartDisclosurePatientRecDelFax(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ChartPreVisitLib PatienttaskData = new ChartPreVisitLib();
		PatienttaskData.workSheetName = "CreatePatientTask";
		PatienttaskData.testCaseId = "TC_CD_005";
		PatienttaskData.fetchChartPreVisitTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreatePatientTask(seleniumHost, seleniumPort, browser, webSite,userAccount, PatienttaskData);
	}
	public void VerifyChartDisclosureThirdPartyRecDelMail(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ChartPreVisitLib PatienttaskData = new ChartPreVisitLib();
		PatienttaskData.workSheetName = "CreatePatientTask";
		PatienttaskData.testCaseId = "TC_CD_006";
		PatienttaskData.fetchChartPreVisitTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreatePatientTask(seleniumHost, seleniumPort, browser, webSite,userAccount, PatienttaskData);
	}
	public void VerifyChartDisclosureThirdPartyRecDelFax(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ChartPreVisitLib PatienttaskData = new ChartPreVisitLib();
		PatienttaskData.workSheetName = "CreatePatientTask";
		PatienttaskData.testCaseId = "TC_CD_007";
		PatienttaskData.fetchChartPreVisitTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreatePatientTask(seleniumHost, seleniumPort, browser, webSite,userAccount, PatienttaskData);
	}
	
	public boolean CreatePatientTask(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, ChartPreVisitLib chartDisclosureData){
		Selenium selenium=null;
		boolean returnValue=true;
		String date = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MMddHHmm");
		date = DateFormat.format(cal.getTime());
		
		try
	{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + chartDisclosureData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium,userAccount, chartDisclosureData.userName, chartDisclosureData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//------------------------------------------//
			//  Step-2: Advanced search with Patient ID //
			//------------------------------------------//
			 assertTrue(switchRole(selenium,chartDisclosureData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
     		 waitForPageLoad(selenium);	 
			waitForPageLoad(selenium);
			navigateToPatient(selenium,chartDisclosureData.patientId);
			assertTrue(click(selenium,lnkviewchart),"Could not click the viewchart",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//------------------------------------------//
			//  Step-3:Create Chart discloser in patient task //
			//------------------------------------------//
		
			assertTrue(click(selenium,lnkPatientOption),"Could not click the Patient option",selenium, ClassName, MethodName);
			 assertTrue(click(selenium,lnkcreateTase),"Could not click the Create task",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 if(selenium.isConfirmationPresent()){
					System.out.println(selenium.getConfirmation());
					//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
					selenium.chooseOkOnNextConfirmation();
					}
			 waitForPageLoad(selenium);
			 chartDisclosureData.Instruction=chartDisclosureData.Instruction+date;
			 assertTrue(selectValueFromAjaxList(selenium,Tasksuggestbox,chartDisclosureData.TaskType),"Could not select the task type", selenium , ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium, ajxAssignToChartDis,chartDisclosureData.AssignToChartDis),"Could not select Requested By", selenium,ClassName, MethodName);
			 assertTrue(createMandatoryChartDisclosureFromPC(selenium, chartDisclosureData, userAccount),"Could not create Chart Disclosure from Patient Option", selenium, ClassName, MethodName);
			 assertTrue(click(selenium,btnChartDisSave),"Could not click the Patient option",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
		 
			 if(isElementPresent(selenium,btnChartDisSave))
			 {
				 Assert.fail("Task creation failed or could not click save button");
			 }
			 assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);			 
			 assertTrue(click(selenium,lnkTask),"Could not click the Patient option",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);	
			 assertTrue(type(selenium,txtSearchBox1,chartDisclosureData.Instruction),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
			 assertTrue(type(selenium,txtSearchBox1,"\\13"),"Could not Press Enter", selenium , ClassName, MethodName);
			 waitForPageLoad(selenium);	
			 assertTrue(isElementPresent(selenium,lnkTaskList),"Chart Disclosure not available in ", selenium , ClassName, MethodName);
			 assertTrue(click(selenium,lnkTaskList),"Chart Disclosure not available in ", selenium , ClassName, MethodName);
			 if(isElementPresent(selenium, btnEditRequest)){
				 assertTrue(click(selenium,btnEditRequest),"Could not Click Edit Request ", selenium , ClassName, MethodName);
					
			 }
			 verifyChartDisclosureData(selenium,chartDisclosureData);
			 
			 
		 return true;
		
	}
	catch(Exception e)
	{
		
	}
	return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
