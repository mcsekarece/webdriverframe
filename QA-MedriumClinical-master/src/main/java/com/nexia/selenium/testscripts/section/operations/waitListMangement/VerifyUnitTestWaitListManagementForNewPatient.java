package com.nexia.selenium.testscripts.section.operations.waitListMangement;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsUnitTestlib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnitTestWaitListManagementForNewPatient extends AbstractOperationsTest{
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Email with invalid in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEmailWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList_NewPatient";
		bookingAssistTestData.testCaseId = "TC_UWL_001";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Last Name with empty in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLastNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList_NewPatient";
		bookingAssistTestData.testCaseId = "TC_UWL_002";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify First Name with empty in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFirstNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList_NewPatient";
		bookingAssistTestData.testCaseId = "TC_UWL_003";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify DOB with empty in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDOBWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList_NewPatient";
		bookingAssistTestData.testCaseId = "TC_UWL_004";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify DOB with invalid in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDOBWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList_NewPatient";
		bookingAssistTestData.testCaseId = "TC_UWL_005";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Phone Number with empty in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneNumberWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList_NewPatient";
		bookingAssistTestData.testCaseId = "TC_UWL_006";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Phone Number with invalid in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneNumberWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList_NewPatient";
		bookingAssistTestData.testCaseId = "TC_UWL_007";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Phone Number with Maximum in Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPhoneNumberWithMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsUnitTestlib bookingAssistTestData = new  OperationsUnitTestlib();
		bookingAssistTestData.workSheetName = "UnitTest_WaitList_NewPatient";
		bookingAssistTestData.testCaseId = "TC_UWL_008";
		bookingAssistTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,bookingAssistTestData);
	} 
	
	/*************************************************************************************************** 
	* @purpose        To Verify Unit Test For Wait List Management For New Patient
	* @action 		  verifying Unit Test For Wait List Management For New Patient
	* @expected       To Ensure that Unit Test works fine for Wait List Management For New Patient  
	* @author         Aspire QA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 24, 2013
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
			String date =null;
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if(userAccount.equalsIgnoreCase(CAAccount)){
				DateFormat=new SimpleDateFormat("dd/MM/YYYY");
			}
			else{
				DateFormat=new SimpleDateFormat("MM/dd/YYYY");
			}
			date=DateFormat.format(cal.getTime());
			
			waitListTestData.patientName = waitListTestData.patientName +date;
			
			
			
			assertTrue(type(selenium,txtpatientsearch,waitListTestData.patientName),"Could not type patient id", selenium, ClassName, MethodName);
			
			selenium.keyPress(txtpatientsearch, "\\9");
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "//body/div[3]/div/div/div/div[2]/div/div/div/div")){
				click(selenium, "//body/div[3]/div/div/div/div[2]/div/div/div/div");
			}else{
				Assert.fail("Add new patient is not available");
			}
			
			//--------------------------------------------------------------------//
			//  Step-7: Fill the wait list details								  //
			//--------------------------------------------------------------------//
			assertTrue(fillWaitListDetailsForNewPatientUnitTest(selenium,waitListTestData, userAccount), "Visit details failed", selenium, ClassName, MethodName);
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
