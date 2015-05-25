package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestAutomatedRecall extends AbstractClinicalList {
	@Test(enabled=false)
	//This Test for checking "Manage care alert & Automate Recall Listy ". It removed from UI. So, Disable the script from execution
//	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Task Name with Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})

	public void verifyTaskNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLibUnitTest alertData = new ClinicalListLibUnitTest();
		alertData.workSheetName = "UnitTest_AutomatedRecall";
		alertData.testCaseId = "TC_UAR_001";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Assign to with Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAssignToWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLibUnitTest alertData = new ClinicalListLibUnitTest();
		alertData.workSheetName = "UnitTest_AutomatedRecall";
		alertData.testCaseId = "TC_UAR_002";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Assign to with Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAssignToWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLibUnitTest alertData = new ClinicalListLibUnitTest();
		alertData.workSheetName = "UnitTest_AutomatedRecall";
		alertData.testCaseId = "TC_UAR_003";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For AssignTask Due Date With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void assignTaskDueDateWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLibUnitTest alertData = new ClinicalListLibUnitTest();
		alertData.workSheetName = "UnitTest_AutomatedRecall";
		alertData.testCaseId = "TC_UAR_004";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For AssignTask Due Date With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void assignTaskDueDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLibUnitTest alertData = new ClinicalListLibUnitTest();
		alertData.workSheetName = "UnitTest_AutomatedRecall";
		alertData.testCaseId = "TC_UAR_005";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For AssignTask Due Unit  With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void assignTaskDueUnitWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLibUnitTest alertData = new ClinicalListLibUnitTest();
		alertData.workSheetName = "UnitTest_AutomatedRecall";
		alertData.testCaseId = "TC_UAR_006";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For AssignTask Due Unit With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void assignTaskDueUnitWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLibUnitTest alertData = new ClinicalListLibUnitTest();
		alertData.workSheetName = "UnitTest_AutomatedRecall";
		alertData.testCaseId = "TC_UAR_007";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Unit Test For Verify Reason With Maximum Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReasonWithMaximumCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLibUnitTest alertData = new ClinicalListLibUnitTest();
		alertData.workSheetName = "UnitTest_AutomatedRecall";
		alertData.testCaseId = "TC_UAR_008";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createAlerts(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Unit Test For Autoamted Recall
	* @action 		  Unit Test For Autoamted Recall
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct  26, 2013
	***************************************************************************************************/
	
	public boolean createAlerts(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLibUnitTest alertData) throws IOException{
		Selenium selenium=null;
		String date =null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + alertData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, alertData.userName, alertData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Clinical Lists//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Medication Reconciliation  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkAutomatedRecall),"Could not click on Automated Recallt link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnEditRecall),"Could not click on link edit recall", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: UnitTest For Automated Recall //
			//--------------------------------------------------------------------//
						
			if(alertData.testCaseId.equals("TC_UAR_008")){
				
		     assertTrue(type(selenium,txtTaskReasonName,alertData.taskName), "Could not type task reason name",selenium, ClassName, MethodName);
		     waitForPageLoad(selenium);
			 assertTrue(selenium.isTextPresent(alertData.validationMessage),"Validation msg not found",selenium, ClassName, MethodName);

		   /*  if(!selenium.isTextPresent(alertData.validationMessage)){
		    	 return false;
		     }else{
		    	 return true;
		     }*/
			
			}
			
			assertTrue(UnitTestForAutomatedRecall(selenium,alertData,date),"Unit Test For Automated failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		    alertData.validationFieldID = alertData.validationFieldID == null ? alertData.validationFieldID ="" : alertData.validationFieldID.trim();
	            if(!alertData.validationFieldID.equals("")){
	            	waitForPageLoad(selenium);
					assertTrue(isElementPresent(selenium, alertData.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(getText(selenium, alertData.validationFieldID).contains(alertData.validationMessage), "The expected validation message should contain the text - "+ alertData.validationMessage + " The actual validation message shown - " + getText(selenium, alertData.validationFieldID),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
			}
				
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
