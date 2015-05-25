package com.nexia.selenium.testscripts.section.operations.waitListMangement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCannotReachInWaitListQueue extends AbstractOperationsTest{

	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Wait List cannot reach in wait list queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCannotReachInWaitListQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		OperationsTestLib addWaitList = new OperationsTestLib();
		addWaitList.workSheetName = "VerifyWaitList";
		addWaitList.testCaseId = "TC_VWL_011";
		addWaitList.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,addWaitList);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Wait List cannot reach in wait list queue
	* @action 		  verifying Wait List cannot reach in wait list queue
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 15, 2013	
	***************************************************************************************************/
	
	public boolean waitListManagement(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, OperationsTestLib waitListDataObj1 ) throws IOException{
		
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
			//  Step-5: Add wait list for patient								  //
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
			//  Step-10: Navigate to Wait list Queue 						      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkBack), "Could not click on back link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkWaitListQueue), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//---------------------------------------------------------------------//
			//  Step-11: Navigate to first wait list in Wait list queue            //
			//---------------------------------------------------------------------//
			assertTrue(click(selenium, lnkFirstWaitListQueue), "Could not click on first wait list queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			//  Step-12: Click on 'cannot reach' in Wait list 		               //
			//---------------------------------------------------------------------//
			assertTrue(click(selenium, btnAction), "Could not click on action", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkCannotReach), "Could not click on cannot reach", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-13: Navigate to Wait list Queue 						      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkWaitListQueue), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			//  Step-14: Verify 'cannot reach' in Wait list queue	               //
			//---------------------------------------------------------------------//
			if(!getText(selenium,lnkFirstWaitListQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains("Couldn't reach".trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
