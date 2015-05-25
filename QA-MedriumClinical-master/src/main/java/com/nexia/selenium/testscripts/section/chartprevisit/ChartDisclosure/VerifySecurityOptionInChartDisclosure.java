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

public class VerifySecurityOptionInChartDisclosure extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib chartDisclosureData = new ChartPreVisitLib();
		chartDisclosureData.workSheetName = "VerifySecurityOption";
		chartDisclosureData.testCaseId = "TC_VSP_001";
		chartDisclosureData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, chartDisclosureData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib chartDisclosureData = new ChartPreVisitLib();
		chartDisclosureData.workSheetName = "VerifySecurityOption";
		chartDisclosureData.testCaseId = "TC_VSP_002";
		chartDisclosureData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, chartDisclosureData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib chartDisclosureData = new ChartPreVisitLib();
		chartDisclosureData.workSheetName = "VerifySecurityOption";
		chartDisclosureData.testCaseId = "TC_VSP_003";
		chartDisclosureData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, chartDisclosureData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib chartDisclosureData = new ChartPreVisitLib();
		chartDisclosureData.workSheetName = "VerifySecurityOption";
		chartDisclosureData.testCaseId = "TC_VSP_004";
		chartDisclosureData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, chartDisclosureData);
	}
		/*************************************************************************************************** 
		* @purpose        To verify Customize Setting PopUp
		* @action 		  verifying Customize Setting PopUp
		* @author         Aspire QA
		* @throws         IOException 
		* @state          Developing
		* @useraccount    Both (US and Canada)
		* @since  	      Aug 23, 2012
		***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLib chartDisclosureData) throws IOException{
		boolean returnValue = false;
		Selenium selenium = null;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + chartDisclosureData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, chartDisclosureData.userName, chartDisclosureData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch Role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,chartDisclosureData.switchRole),"Could not change the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify security option //
			//--------------------------------------------------------------------//
			verifySecurityOption(selenium,chartDisclosureData, userAccount);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurityOption(Selenium selenium,ChartPreVisitLib chartDisclosureData, String userAccount){
		//No Access
		try {
			ChartPreVisitLib PatienttaskData = new ChartPreVisitLib();
			String date = null;
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MMddHHmm");
			date = DateFormat.format(cal.getTime());
			assertTrue(switchRole(selenium,"Full"),"Could not change the role", selenium, ClassName, MethodName);
			if(chartDisclosureData.testCaseId.equals("TC_VSP_002")){
				PatienttaskData.workSheetName = "CreatePatientTask";
				PatienttaskData.testCaseId = "TC_CD_035";
				chartDisclosureData.testCaseId="TC_VSP_002";
			}else if(chartDisclosureData.testCaseId.equals("TC_VSP_001")){
				PatienttaskData.workSheetName = "CreatePatientTask";
				PatienttaskData.testCaseId = "TC_CD_034";
				chartDisclosureData.testCaseId="TC_VSP_001";
			}else if(chartDisclosureData.testCaseId.equals("TC_VSP_003")){
				PatienttaskData.workSheetName = "CreatePatientTask";
				PatienttaskData.testCaseId = "TC_CD_033";
				chartDisclosureData.testCaseId="TC_VSP_003";
			}
			else if(chartDisclosureData.testCaseId.equals("TC_VSP_004")){
				PatienttaskData.workSheetName = "CreatePatientTask";
				PatienttaskData.testCaseId = "TC_CD_036";
				chartDisclosureData.testCaseId="TC_VSP_004";
			}
			
			PatienttaskData.fetchChartPreVisitTestData();	
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
			 chartDisclosureData.Instruction=PatienttaskData.Instruction+date;
			 assertTrue(selectValueFromAjaxList(selenium,Tasksuggestbox,PatienttaskData.TaskType),"Could not select the task type", selenium , ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium, ajxAssignToChartDis,PatienttaskData.AssignToChartDis),"Could not select Requested By", selenium,ClassName, MethodName);
			 assertTrue(createMandatoryChartDisclosureFromPC(selenium, PatienttaskData, userAccount),"Could not create Chart Disclosure from Patient Option", selenium, ClassName, MethodName);
			 assertTrue(click(selenium,btnChartDisSave),"Could not click the Patient option",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(!isElementPresent(selenium,btnChartDisSave),"not getting saved",selenium,ClassName,MethodName);
			 assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);	
			 if(chartDisclosureData.testCaseId.equals("TC_VSP_002")||chartDisclosureData.testCaseId.equals("TC_VSP_003")){
			 assertTrue(switchRole(selenium,chartDisclosureData.switchRole),"Could not change the role", selenium, ClassName, MethodName);
			 }
			 waitForPageLoad(selenium);	
			 assertTrue(click(selenium,lnkTask),"Could not click the Patient option",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);	
			 assertTrue(type(selenium,txtSearchBox1,chartDisclosureData.Instruction),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
			 assertTrue(type(selenium,txtSearchBox1,"\\13"),"Could not Press Enter", selenium , ClassName, MethodName);
			 waitForPageLoad(selenium);	
			 assertTrue(isElementPresent(selenium,lnkTaskList),"Chart Disclosure not available in ", selenium , ClassName, MethodName);
			 assertTrue(click(selenium,lnkTaskList),"Chart Disclosure not available in ", selenium , ClassName, MethodName);
			 
			 if(chartDisclosureData.testCaseId.equals("TC_VSP_002")||chartDisclosureData.testCaseId.equals("TC_VSP_003")){
				 assertTrue(!isElementVisible(selenium,btnSelectItems),"Select Items button present", selenium , ClassName, MethodName);
				 assertTrue(click(selenium,lnkPatientOption),"Select Items button present", selenium , ClassName, MethodName);
				 assertTrue(!isElementVisible(selenium,lnkChartDisclosure),"Link to chart disclosure present", selenium , ClassName, MethodName);
			 }
			 else{
				 assertTrue(isElementVisible(selenium,btnSelectItems),"Select Items button is not present", selenium , ClassName, MethodName);
				 assertTrue(click(selenium,lnkPatientOption),"Not able to click Patient Option", selenium , ClassName, MethodName);
				 assertTrue(isElementVisible(selenium,lnkChartDisclosure),"Link to chart disclosure is not present", selenium , ClassName, MethodName);
				 assertTrue(click(selenium,btnSelectItems),"Select Items button is not present", selenium , ClassName, MethodName);
				 assertTrue(isElementPresent(selenium,btnEditRequest),"Select Items button is not present", selenium , ClassName, MethodName);
			 }
			 				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
