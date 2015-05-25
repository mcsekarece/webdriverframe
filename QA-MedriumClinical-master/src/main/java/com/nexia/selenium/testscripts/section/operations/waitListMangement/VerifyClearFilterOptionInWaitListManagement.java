package com.nexia.selenium.testscripts.section.operations.waitListMangement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyClearFilterOptionInWaitListManagement extends AbstractOperationsTest{

	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Clear Filter In Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyClearFilter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		OperationsTestLib waitListDataObj1 = new OperationsTestLib();
		waitListDataObj1.workSheetName = "VerifyWaitList";
		waitListDataObj1.testCaseId = "TC_VWL_001";
		waitListDataObj1.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyClearFilters(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListDataObj1);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Clear Functionality In Wait List Management
	* @action 		  verifying Clear Functionality In Wait List Management 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 20, 2013
	***************************************************************************************************/
	
	public boolean verifyClearFilters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, OperationsTestLib waitListDataObj1 ) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + waitListDataObj1.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, waitListDataObj1.userName, waitListDataObj1.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,waitListDataObj1.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
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
			//  Step-5: Add wait list for patient-1								  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddResCalandar), "Could not click the Add new wait list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID							  //
			//--------------------------------------------------------------------//
			searchPatientForBookingVisit(selenium,waitListDataObj1.patientName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Fill the wait list details For First Patient			  //
			//--------------------------------------------------------------------//
			assertTrue(fillWaitListDetailsForExistingPatient(selenium,waitListDataObj1, userAccount), "Visit details failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Wait list management 						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToWaitListMgmt(selenium),"Could not navigate to wait list management", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-------------------------------------------------------------------------------------//
			//  Step-9: verify the Wait list management values in summary page For First Patient   //
			//-------------------------------------------------------------------------------------//
			assertTrue(verifyStoreValuesWaitListMgmt(selenium, waitListDataObj1, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-10: Add wait list for patient-2								  //
			//--------------------------------------------------------------------//
			OperationsTestLib waitListDataObj2 = new OperationsTestLib();
			waitListDataObj2.workSheetName = "VerifyWaitList";
			waitListDataObj2.testCaseId = "TC_VWL_009";
			waitListDataObj2.fetchSchedulingSettingsTestData();
			
			assertTrue(click(selenium, btnAddResCalandar), "Could not click the Add new wait list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11: Advanced search with Patient ID							  //
			//--------------------------------------------------------------------//
			searchPatientForBookingVisit(selenium,waitListDataObj2.patientName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: Fill the wait list details For Second Patient			  //
			//--------------------------------------------------------------------//
			assertTrue(fillWaitListDetailsForExistingPatient(selenium,waitListDataObj2, userAccount), "Visit details failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-13: Navigate to Wait list management 						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToWaitListMgmt(selenium),"Could not navigate to wait list management", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------------------------//
			//  Step-14: verify the Wait list management values in summary page For Second Patient   //
			//--------------------------------------------------------------------------------------//
			assertTrue(verifyStoreValuesWaitListMgmt(selenium, waitListDataObj2, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);

			//Verify Wait list clear functionality
			//First filter based on location, then clear the filters
			assertTrue(selectValueFromAjaxList(selenium,ajxLocationWL,waitListDataObj1.location),"Could not select location value"+waitListDataObj1.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------------------------//
			//  Step-15: verify the Wait list management values in summary page For First Patient   //
			//--------------------------------------------------------------------------------------//
			assertTrue(verifyStoreValuesWaitListMgmt(selenium, waitListDataObj1, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
			// All filters based on first patient data's. So, Second patient details should not be displayed in summary page
			assertTrue(verifyStoreValuesDoNotPresentInWaitListMgmt(selenium, waitListDataObj2, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkClear),"Could click clear button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-------------------------------------------------------------------------------------//
			//  Step-16: verify the Wait list management values in summary page For First Patient   //
			//-------------------------------------------------------------------------------------//
			// All filters based on first patient data's. So, First patient details should be displayed in summary page 
			assertTrue(verifyStoreValuesWaitListMgmt(selenium, waitListDataObj1, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------------------------//
			//  Step-17: verify the Wait list management values in summary page For Second Patient   //
			//--------------------------------------------------------------------------------------//
			
			// If the test for check clear functionality, Then Second patient details also displayed in summary page
			assertTrue(verifyStoreValuesWaitListMgmt(selenium, waitListDataObj2, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
