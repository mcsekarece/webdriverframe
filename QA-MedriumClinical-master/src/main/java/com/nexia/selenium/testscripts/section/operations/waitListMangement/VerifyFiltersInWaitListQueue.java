package com.nexia.selenium.testscripts.section.operations.waitListMangement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyFiltersInWaitListQueue extends AbstractOperationsTest{

	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Filter By Patient In Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFilterByPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		OperationsTestLib waitListDataObj1 = new OperationsTestLib();
		waitListDataObj1.workSheetName = "VerifyWaitList";
		waitListDataObj1.testCaseId = "TC_VWL_004";
		waitListDataObj1.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFilters(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListDataObj1);
	}
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Filter By Resource In Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFilterByResource(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		OperationsTestLib waitListDataObj1 = new OperationsTestLib();
		waitListDataObj1.workSheetName = "VerifyWaitList";
		waitListDataObj1.testCaseId = "TC_VWL_005";
		waitListDataObj1.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFilters(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListDataObj1);
	}
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Filter By Visit Type In Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFilterByVisitType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		OperationsTestLib waitListDataObj1 = new OperationsTestLib();
		waitListDataObj1.workSheetName = "VerifyWaitList";
		waitListDataObj1.testCaseId = "TC_VWL_006";
		waitListDataObj1.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFilters(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListDataObj1);
	}
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Filter By Priority In Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFilterByPriority(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		OperationsTestLib waitListDataObj1 = new OperationsTestLib();
		waitListDataObj1.workSheetName = "VerifyWaitList";
		waitListDataObj1.testCaseId = "TC_VWL_007";
		waitListDataObj1.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFilters(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListDataObj1);
	}
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Filter By Location In Wait List Management")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFilterByLocation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		OperationsTestLib waitListDataObj1 = new OperationsTestLib();
		waitListDataObj1.workSheetName = "VerifyWaitList";
		waitListDataObj1.testCaseId = "TC_VWL_008";
		waitListDataObj1.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFilters(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListDataObj1);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Filters In Wait List Queue
	* @action 		  verifying Filters In Wait List Queue 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 09, 2013
	***************************************************************************************************/
	
	public boolean verifyFilters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, OperationsTestLib waitListDataObj1 ) throws IOException{
		
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
			
			//-------------------------------------------------------------------------------------//
			//  Step-9: verify the Wait list management values in summary page For First Patient   //
			//-------------------------------------------------------------------------------------//
			assertTrue(verifyStoreValuesWaitListMgmt(selenium, waitListDataObj1, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-10: Add wait list for patient-2							  //
			//--------------------------------------------------------------------//
			OperationsTestLib waitListDataObj2 = new OperationsTestLib();
			waitListDataObj2.workSheetName = "VerifyWaitList";
			waitListDataObj2.testCaseId = "TC_VWL_009";
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
			//  Step-13: Navigate to Wait list management 						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToWaitListMgmt(selenium),"Could not navigate to wait list management", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------------------------//
			//  Step-14: verify the Wait list management values in summary page For Second Patient  //
			//--------------------------------------------------------------------------------------//
			assertTrue(verifyStoreValuesWaitListMgmt(selenium, waitListDataObj2, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-15: Navigate to Wait list Queue 						      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkBack), "Could not click on back link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkWaitListQueue), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-------------------------------------------------------------------------//
			//  Step-16: Verify Filters For Different Scenarios In Wait list Queue     //
			//-------------------------------------------------------------------------//
			if(waitListDataObj1.testCaseId.equalsIgnoreCase("TC_VWL_004")){
				//Verify Wait list Filters based on patient
				assertTrue(type(selenium,txtPatientSearch,waitListDataObj1.patientName),"Could not type patient id", selenium, ClassName, MethodName);
				
				selenium.keyPress(txtPatientSearch, "\\13");
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
			}else if(waitListDataObj1.testCaseId.equalsIgnoreCase("TC_VWL_005")){
				//Verify Wait list Filters based on resource
				assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBox,waitListDataObj1.resource),"Could not select resource value"+waitListDataObj1.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}else if(waitListDataObj1.testCaseId.equalsIgnoreCase("TC_VWL_006")){
				//Verify Wait list Filters based on visit type
				assertTrue(selectValueFromAjaxList(selenium,ajxVisitTypeWL,waitListDataObj1.visitType),"Could not select visit type value"+waitListDataObj1.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}else if(waitListDataObj1.testCaseId.equalsIgnoreCase("TC_VWL_007")){
				//Verify Wait list Filters based on priority
				assertTrue(selectValueFromAjaxList(selenium,ajxPriorityWL,waitListDataObj1.priority),"Could not select priority value"+waitListDataObj1.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}else if(waitListDataObj1.testCaseId.equalsIgnoreCase("TC_VWL_008")){
				//Verify Wait list Filters based on location
				assertTrue(selectValueFromAjaxList(selenium,ajxLocationWL,waitListDataObj1.location),"Could not select location value"+waitListDataObj1.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//-------------------------------------------------------------------------------------//
			//  Step-17: verify the Wait list management values in summary page For First Patient  //
			//-------------------------------------------------------------------------------------//
			// All filters based on first patient data's. So, First patient details should be displayed in summary page 
			assertTrue(verifyStoreValuesWaitListQueueSummary(selenium, waitListDataObj1, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------------------------//
			//  Step-18: verify the Wait list management values in summary page For Second Patient  //
			//--------------------------------------------------------------------------------------//
			if(!(waitListDataObj1.testCaseId.equalsIgnoreCase("TC_VWL_006"))){
				// All filters based on first patient data's. So, Second patient details should not be displayed in summary page
				assertTrue(verifyStoreValuesDoNotPresentInWaitListQueue(selenium, waitListDataObj2, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			}
			else{
				assertTrue(verifyStoreValuesWaitListQueueSummary(selenium, waitListDataObj2, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
