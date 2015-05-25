package com.nexia.selenium.testscripts.section.operations.waitListMangement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyWaitListQueue extends AbstractOperationsTest{
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Filter By Patient In Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void waitListQueueDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		OperationsTestLib waitListDataObj1 = new OperationsTestLib();
		waitListDataObj1.workSheetName = "VerifyWaitList";
		waitListDataObj1.testCaseId = "TC_VWL_014";
		waitListDataObj1.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyWaitListQueue(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListDataObj1);
	}
	/*************************************************************************************************** 
	* @purpose        verify Wait List Queue
	* @action 		  verifying Wait List Queue 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @defect 		  #7793	
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 09, 2013
	***************************************************************************************************/
	
	public boolean verifyWaitListQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, OperationsTestLib waitListDataObj1 ) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;

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
			
			//--------------------------------------------------------------------//
			//  Step-10: Add wait list for patient-2							  //
			//--------------------------------------------------------------------//
			OperationsTestLib waitListDataObj2 = new OperationsTestLib();
			waitListDataObj2.workSheetName = "VerifyWaitList";
			waitListDataObj2.testCaseId = "TC_VWL_015";
			waitListDataObj2.fetchSchedulingSettingsTestData();
			
			assertTrue(click(selenium, btnAddResCalandar), "Could not click the Add new wait list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11: Advanced search with Patient ID						  //
			//--------------------------------------------------------------------//
			searchPatientForBookingVisit(selenium,waitListDataObj2.patientName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: Fill the wait list details For Second Patient			  //
			//--------------------------------------------------------------------//
			assertTrue(fillWaitListDetailsForExistingPatient(selenium,waitListDataObj2, userAccount), "Visit details failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-15: Navigate to Wait list Queue 						      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkWaitListQueue), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-16: verify Store Value 						      //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtPatientSearch,waitListDataObj1.patientName),"Could not type patient id", selenium, ClassName, MethodName);
			selenium.keyPress(txtPatientSearch, "\\13");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//-------------------------------------------------------------------------------------//
			//  Step-17: verify the Wait list management values in summary page For First Patient  //
			//-------------------------------------------------------------------------------------//
			// All filters based on first patient data's. So, First patient details should be displayed in summary page 
			assertTrue(verifyStoreValuesWaitListQueueSummary(selenium, waitListDataObj1, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-18: Navigate to Wbump list Queue 						      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkBumpList), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-19: Navigate to Wait list Queue 						      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkWaitListQueue), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!(getText(selenium,lblWaitListQueueSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListDataObj1.patientName.trim().toLowerCase(new java.util.Locale("en","US")))
					&&(getText(selenium,lblWaitListQueueSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListDataObj2.patientName.trim().toLowerCase(new java.util.Locale("en","US")))))){
				Assert.fail("Queue is not displayed properly");
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
