package com.nexia.selenium.testscripts.section.operations.waitListMangement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForWaitListInQueue extends AbstractOperationsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Wait List Queue With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWaitListQueueWithLimitedAccessInFrontDeskView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		OperationsTestLib waitListTestData = new  OperationsTestLib();
		waitListTestData.workSheetName = "VerifySecurityOption";
		waitListTestData.testCaseId = "TC_VSP_010";
		waitListTestData.fetchSchedulingSettingsTestData();				
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityInwaitListQueue(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListTestData);
	}
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Wait List Queue With No Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWaitListQueueWithNoAccessInFrontDeskView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib waitListTestData = new  OperationsTestLib();
		waitListTestData.workSheetName = "VerifySecurityOption";
		waitListTestData.testCaseId = "TC_VSP_007";
		waitListTestData.fetchSchedulingSettingsTestData();				
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityInwaitListQueue(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListTestData);
	}

	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Wait List Queue With Full Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWaitListQueueWithFullAccessInFrontDeskView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib waitListTestData = new  OperationsTestLib();
		waitListTestData.workSheetName = "VerifySecurityOption";
		waitListTestData.testCaseId = "TC_VSP_008";
		waitListTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityInwaitListQueue(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListTestData);
	}
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Wait List Queue With View Only Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWaitListQueueWithViewOnlyAccessInFrontDeskView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib waitListTestData = new  OperationsTestLib();
		waitListTestData.workSheetName = "VerifySecurityOption";
		waitListTestData.testCaseId = "TC_VSP_009";
		waitListTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityInwaitListQueue(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListTestData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Wait List Queue
	* @action 		  verifying Security Option For Wait List Queue
	* @expected       To Ensure that security option works fine for Wait List Queue  
	* @author         Aspire QA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Jan 06, 2014
	***************************************************************************************************/

	public boolean verifySecurityInwaitListQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib waitListTestData) throws Exception{
		Selenium selenium = null;
		boolean returnValue= true;
		try{
			
			//--------------------------------------------------------------------//
			// Step 1: Login to the application									  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + waitListTestData.toString());
			
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, waitListTestData.userName, waitListTestData.userPassword),"Login Failed ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Verify Security											  //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,waitListTestData,userAccount)){
				Assert.fail("Security for" +waitListTestData.switchRole+ "is not proper:"+ waitListTestData.toString());
			}else
				return returnValue;
			
		}			
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + waitListTestData.toString(), selenium, ClassName,MethodName);
		}
		return returnValue;
	}	

	public boolean verifySecurity(Selenium selenium, OperationsTestLib waitListTestData,String userAccount) throws Exception{
		boolean returnValue=true;
		
		//No Access Permission
		if(waitListTestData.testCaseId.equals("TC_VSP_010")){
			
			//--------------------------------------------------------------------//
			//  Step-3: Switch Role												  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,waitListTestData.switchRole),"Could not change the switch role;More Details:"+waitListTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, lnkWaitListQueue)){
				return false;
			}
		}else{
			//--------------------------------------------------------------------//
			//  Step-3: Switch Role											      //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,"DFFullAccess"),"Could not change the switch role;More Details:"+waitListTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Wait list management 						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToWaitListMgmt(selenium),"Could not navigate to wait list management", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete all Wait list									  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllWaitList(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-6: Add wait list for patient								  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddResCalandar), "Could not click the Add new wait list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Advanced search with Patient ID							  //
			//--------------------------------------------------------------------//
			OperationsTestLib addWaitList = new  OperationsTestLib();
			addWaitList.workSheetName = "VerifyWaitList";
			addWaitList.testCaseId = "TC_VWL_001";
			addWaitList.fetchSchedulingSettingsTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
			searchPatientForBookingVisit(selenium,addWaitList.patientName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Fill the wait list details								  //
			//--------------------------------------------------------------------//
			assertTrue(fillWaitListDetailsForExistingPatient(selenium,addWaitList, userAccount), "Visit details failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Navigate to Wait list management 						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToWaitListMgmt(selenium),"Could not navigate to wait list management", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: verify the Wait list management values in summary page   //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValuesWaitListMgmt(selenium, addWaitList, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-11: Switch Role											  //
			//--------------------------------------------------------------------//
			click(selenium, back);
					
			assertTrue(switchRole(selenium,waitListTestData.switchRole),"Could not change the switch role;More Details:"+waitListTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: Navigate to Wait list management 						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkWaitListQueue),"Could not click the wait list queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-------------------------------------------------------------------------//
			//  Step-13: Filters the created wait list In Wait list Queue   		   //
			//-------------------------------------------------------------------------//
			assertTrue(type(selenium,txtPatientSearch,waitListTestData.patientName),"Could not type patient id", selenium, ClassName, MethodName);
			
			selenium.keyPress(txtPatientSearch, "\\13");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//-------------------------------------------------------------------------------------//
			//  Step-14: verify the Wait list management values in Queue						   //
			//-------------------------------------------------------------------------------------//
			assertTrue(verifyStoreValuesWaitListQueueSummary(selenium, waitListTestData, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-15: Navigate to Wait list management 						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lblFirstWaitListQueue),"Could not click the first wait list queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}
		
		return returnValue;
	}
		
}