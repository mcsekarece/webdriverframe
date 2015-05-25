package com.nexia.selenium.testscripts.section.operations.waitListMangement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAddWaitListInQueueAndSummary extends AbstractOperationsTest{

	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Added Wait List in wait list quee and summary")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAddedWaitListInWaitListQueeAndSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		OperationsTestLib addWaitList = new OperationsTestLib();
		addWaitList.workSheetName = "VerifyWaitList";
		addWaitList.testCaseId = "TC_VWL_011";
		addWaitList.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,addWaitList);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Add Wait List in Queue and summary
	* @action 		  verifying Add Wait List in Queue and summary
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 10, 2013	
	***************************************************************************************************/
	
	public boolean waitListManagement(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, OperationsTestLib addWaitList ) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + addWaitList.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, addWaitList.userName, addWaitList.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,addWaitList.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
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
			searchPatientForBookingVisit(selenium,addWaitList.patientName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Fill the wait list details For First Patient			  //
			//--------------------------------------------------------------------//
			assertTrue(fillWaitListDetailsForExistingPatient(selenium,addWaitList, userAccount), "Visit details failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Wait list management 						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToWaitListMgmt(selenium),"Could not navigate to wait list management", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-------------------------------------------------------------------------------------//
			//  Step-9: verify the Wait list management values in summary page For First Patient   //
			//-------------------------------------------------------------------------------------//
			assertTrue(verifyStoreValuesWaitListMgmt(selenium, addWaitList, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-10: Navigate to Wait list Queue 						      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkBack), "Could not click on back link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkWaitListQueue), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//---------------------------------------------------------------------//
			//  Step-11: verify the Wait list management values in summary page    //
			//---------------------------------------------------------------------//
			assertTrue(verifyStoreValuesWaitListQueueSummary(selenium, addWaitList, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
			//---------------------------------------------------------------------//
			//  Step-12: verify the wait list details in Wait list Queue           //
			//---------------------------------------------------------------------//
			assertTrue(click(selenium, lnkFirstWaitListQueue), "Could not click on first wait list queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyStoreValuesWaitListQueue(selenium, addWaitList, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
