package com.nexia.selenium.testscripts.section.chartprevisit.ChartDisclosure;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectItems extends AbstractChartPreVisit {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncludeFullChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib chartDisclosureData = new ChartPreVisitLib();
		chartDisclosureData.workSheetName = "CreatePatientTask";
		chartDisclosureData.testCaseId = "TC_CD_008";
		chartDisclosureData.fetchChartPreVisitTestData();
		editRequest(seleniumHost, seleniumPort, browser, webSite, userAccount, chartDisclosureData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncludePartialChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib chartDisclosureData = new ChartPreVisitLib();
		chartDisclosureData.workSheetName = "CreatePatientTask";
		chartDisclosureData.testCaseId = "TC_CD_009";
		chartDisclosureData.fetchChartPreVisitTestData();
		editRequest(seleniumHost, seleniumPort, browser, webSite, userAccount, chartDisclosureData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncludePartialChartWithAllActivities(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib chartDisclosureData = new ChartPreVisitLib();
		chartDisclosureData.workSheetName = "CreatePatientTask";
		chartDisclosureData.testCaseId = "TC_CD_009";
		chartDisclosureData.fetchChartPreVisitTestData();
		editRequest(seleniumHost, seleniumPort, browser, webSite, userAccount, chartDisclosureData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncludePartialChartWithPartialSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib chartDisclosureData = new ChartPreVisitLib();
		chartDisclosureData.workSheetName = "CreatePatientTask";
		chartDisclosureData.testCaseId = "TC_CD_009";
		chartDisclosureData.fetchChartPreVisitTestData();
		editRequest(seleniumHost, seleniumPort, browser, webSite, userAccount, chartDisclosureData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncludePartialChartWithEncounters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib chartDisclosureData = new ChartPreVisitLib();
		chartDisclosureData.workSheetName = "CreatePatientTask";
		chartDisclosureData.testCaseId = "TC_CD_009";
		chartDisclosureData.fetchChartPreVisitTestData();
		editRequest(seleniumHost, seleniumPort, browser, webSite, userAccount, chartDisclosureData);
	}
	
		
	
	/**
	 * createChartDisclosure
	 * function to create Chart Disclosure
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    April 28, 2014
	 */
	
	public boolean editRequest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib chartDisclosureData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			String date = null;
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MMddHHmm");
			date = DateFormat.format(cal.getTime());
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + chartDisclosureData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, chartDisclosureData.userName, chartDisclosureData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			navigateToPatient(selenium, chartDisclosureData);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkviewchart),"Could not click the viewchart",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOption),"Could not click Patient Option Link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkcreateTase),"Could not click Chart Disclosure Link", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 if(selenium.isConfirmationPresent()){
					System.out.println(selenium.getConfirmation());
					//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
					selenium.chooseOkOnNextConfirmation();
					}
			//creating new Chart Disclosure
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
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);	
			 assertTrue(switchRole(selenium,chartDisclosureData.AssignToChartDis),"Could not click the nexia logo", selenium, ClassName,MethodName);
			 
			 assertTrue(click(selenium,lnkTask),"Could not click the Patient option",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);	
			 assertTrue(type(selenium,txtSearchBox1,chartDisclosureData.Instruction),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
			 selenium.keyPress(txtSearchBox1, "\\13");
			 waitForPageLoad(selenium);	
			 assertTrue(isElementPresent(selenium,lnkTaskList),"Chart Disclosure not available in ", selenium , ClassName, MethodName);
			 assertTrue(click(selenium,lnkTaskList),"Chart Disclosure not available in ", selenium , ClassName, MethodName);
			 waitForPageLoad(selenium);	
			 if(isElementPresent(selenium, btnSelectItems)){
				 assertTrue(click(selenium,btnSelectItems),"Could not Click Edit Request ", selenium , ClassName, MethodName);
			 }
			 if(isElementPresent(selenium, ajxChartConsentName)){
				 waitForPageLoad(selenium);	
				 selenium.typeKeys(ajxChartConsentName, "\b");
					selenium.type(ajxChartConsentName, "");
					waitForPageLoad(selenium);
					selenium.focus(ajxChartConsentName);
					waitForPageLoad(selenium);
					click(selenium,"currentItem_1");
					assertTrue(click(selenium,btnCntnue),"Could not click Chart Disclosure Link", selenium, ClassName, MethodName);
					 waitForPageLoad(selenium);	
				 }
			 assertTrue(isElementPresent(selenium,radIncludeFullChart),"Include Full Chart Radio Button not Present", selenium , ClassName, MethodName);
			 assertTrue(isElementPresent(selenium,radIncludePartialChart),"Include Partial Chart Radio Button not Present", selenium , ClassName, MethodName);
			 verifyChartDisclosurePrintData(selenium,chartDisclosureData);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/**
	 * verify Edit Chart disclosure 
	 * function navigateToPatient
	 * @since Feb 04, 2014
	 **/ 
	public boolean navigateToPatient(Selenium selenium, ChartPreVisitLib PatientData) throws IOException{
		
		assertTrue(type(selenium, txtPatientBox, PatientData.patientId),"Could not type patient id", selenium, ClassName,MethodName);
		selenium.clickAt("searchPatientBox","");
		selenium.focus("searchPatientBox");			
		selenium.fireEvent("searchPatientBox","keypress");		
		waitForElement(selenium, lblPatientResult, 10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ PatientData.patientId, selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		selenium.mouseOver(lblPatientResult2);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		return true;
		}
}
