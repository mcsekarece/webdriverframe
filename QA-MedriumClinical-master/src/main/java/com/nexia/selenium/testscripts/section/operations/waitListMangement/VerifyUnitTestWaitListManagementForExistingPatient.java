package com.nexia.selenium.testscripts.section.operations.waitListMangement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsUnitTestlib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnitTestWaitListManagementForExistingPatient extends AbstractOperationsTest{
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Call back with empty in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCallBackWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList";
		bookingAssistTestData.testCaseId = "TC_UWL_001";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Call back with invalid in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCallBackWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList";
		bookingAssistTestData.testCaseId = "TC_UWL_002";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Call back with maximum in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCallBackWithMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList";
		bookingAssistTestData.testCaseId = "TC_UWL_003";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Priority with empty in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPriorityWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList";
		bookingAssistTestData.testCaseId = "TC_UWL_004";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Priority with invalid in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPriorityWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList";
		bookingAssistTestData.testCaseId = "TC_UWL_005";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Visit Type with empty in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyVisitTypeWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList";
		bookingAssistTestData.testCaseId = "TC_UWL_006";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Visit Type with invalid in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyVisitTypeWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList";
		bookingAssistTestData.testCaseId = "TC_UWL_007";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Resource with empty in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyResourceWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList";
		bookingAssistTestData.testCaseId = "TC_UWL_008";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Resource with invalid in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyResourceWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList";
		bookingAssistTestData.testCaseId = "TC_UWL_009";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Location with empty in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLocationWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList";
		bookingAssistTestData.testCaseId = "TC_UWL_010";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Location with invalid in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLocationWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList";
		bookingAssistTestData.testCaseId = "TC_UWL_011";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	/*************************************************************************************************** 
	* @purpose        To Verify Unit Test For Wait List Management
	* @action 		  verifying Unit Test For Wait List Management
	* @expected       To Ensure that Unit Test works fine for Wait List Management  
	* @author         Aspire QA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 23, 2013
	***************************************************************************************************/
	public boolean waitListManagement(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsUnitTestlib waitListTestData) throws IOException{
		Selenium selenium = null;
		boolean returnValue= true;
		try{
			
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + waitListTestData.toString());
			
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, waitListTestData.userName, waitListTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch Role//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,waitListTestData.switchRole),"Could not change the switch role;More Details:"+waitListTestData.toString(), selenium, ClassName,MethodName);
			
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Wait list management 						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToWaitListMgmt(selenium),"Could not navigate to wait list management", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete all Wait list									  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllWaitList(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-5: Add wait list for patient								  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddResCalandar), "Could not click the Add new wait list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID							  //
			//--------------------------------------------------------------------//
			searchPatientForBookingVisit(selenium,waitListTestData.patientName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Fill the wait list details								  //
			//--------------------------------------------------------------------//
			assertTrue(fillWaitListDetailsForExistingPatientUnitTest(selenium,waitListTestData, userAccount), "Visit details failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium, waitListTestData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, waitListTestData.validationFieldID).contains(waitListTestData.validationMessage), "The expected validation message should contain the text - "+ waitListTestData.validationMessage + " The actual validation message shown - " + getText(selenium, waitListTestData.validationFieldID), selenium, ClassName, MethodName);
			
		}			
		catch (RuntimeException e){
			
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}
}
