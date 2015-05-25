package com.nexia.selenium.testscripts.section.operations.waitListMangement;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForWaitListManagement extends AbstractOperationsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Wait List Management With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWaitListManagementWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		OperationsTestLib waitListTestData = new  OperationsTestLib();
		waitListTestData.workSheetName = "VerifySecurityOption";
		waitListTestData.testCaseId = "TC_VSP_004";
		waitListTestData.fetchSchedulingSettingsTestData();				
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListTestData);
	}
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Wait List Management With No Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWaitListManagementWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib waitListTestData = new  OperationsTestLib();
		waitListTestData.workSheetName = "VerifySecurityOption";
		waitListTestData.testCaseId = "TC_VSP_001";
		waitListTestData.fetchSchedulingSettingsTestData();				
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListTestData);
	}

	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Wait List Management With Full Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWaitListManagementWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib waitListTestData = new  OperationsTestLib();
		waitListTestData.workSheetName = "VerifySecurityOption";
		waitListTestData.testCaseId = "TC_VSP_002";
		waitListTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListTestData);
	}
	
	//#5946 - Defect: Wait List Mangement: WaitList Management Option is Not Available In The Queue For ' View Only' User Role
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify Wait List Management With View Only Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWaitListManagementWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib waitListTestData = new  OperationsTestLib();
		waitListTestData.workSheetName = "VerifySecurityOption";
		waitListTestData.testCaseId = "TC_VSP_003";
		waitListTestData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,waitListTestData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Wait List Management
	* @action 		  verifying Security Option For Wait List Management
	* @expected       To Ensure that security option works fine for Wait List Management  
	* @author         Aspire QA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 20, 2013
	***************************************************************************************************/

	public boolean waitListManagement(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib waitListTestData) throws Exception{
		Selenium selenium = null;
		boolean returnValue= true;
		try{
			
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + waitListTestData.toString());
			
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, waitListTestData.userName, waitListTestData.userPassword),"Login Failed ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//-----------------------------------------//
			//  Step-2: Verify Security//
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
		if(waitListTestData.testCaseId.equals("TC_VSP_001")){
			
			//--------------------------------------------------------------------//
			//  Step-3: Switch Role//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,waitListTestData.switchRole),"Could not change the switch role;More Details:"+waitListTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkQuickAction),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, lnkWaitListMgmt)){
				return false;
			}
		}else{
			//--------------------------------------------------------------------//
			//  Step-3: Switch Role//
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
			//verify the existence of resource. If not available pass the case.(Because, Depends on calendar creation)
			if(!selectValueFromAjaxList(selenium,ajxResource,addWaitList.resource)){
				return true;
			}
			
			assertTrue(fillWaitListDetailsForExistingPatient(selenium,addWaitList, userAccount), "Visit details failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Navigate to Wait list management 						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToWaitListMgmt(selenium),"Could not navigate to wait list management", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: verify the Wait list management values in summary page    //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValuesWaitListMgmt(selenium, addWaitList, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-11: Switch Role//
			//--------------------------------------------------------------------//
			click(selenium, back);
					
			assertTrue(switchRole(selenium,waitListTestData.switchRole),"Could not change the switch role;More Details:"+waitListTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: Navigate to Wait list management 						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToWaitListMgmt(selenium),"Could not navigate to wait list management", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Full Access Permission	
			if(waitListTestData.testCaseId.equals("TC_VSP_002")){
				assertTrue(selenium.isElementPresent(btnAddResCalandar),"Add waitlist not present Present",selenium, ClassName, MethodName);
				assertTrue(selenium.isElementPresent(lnkEditWaitList),"Edit waitlist not present Present",selenium, ClassName, MethodName);
				assertTrue(selenium.isElementPresent(btnDelete),"Delete waitlist not present Present",selenium, ClassName, MethodName);
			}
		
			//View Only Access Permission
			if(waitListTestData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(!selenium.isElementPresent(btnAddResCalandar),"Add waitlist not present Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isElementPresent(lnkEditWaitList),"Edit waitlist not present Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isElementPresent(btnDelete),"Delete waitlist not present Present",selenium, ClassName, MethodName);
				
				//Verify Wait list Filters based on priority
				assertTrue(selectValueFromAjaxList(selenium,ajxPriorityWL,addWaitList.priority),"Could not select priority value"+waitListTestData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//-------------------------------------------------------------------------------------//
				//  Step-13: verify the Wait list management values in summary page For First Patient   //
				//-------------------------------------------------------------------------------------//
				assertTrue(verifyStoreValuesWaitListMgmt(selenium, waitListTestData, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
				
					
			}
			 
			//Limited Access Permission
			if(waitListTestData.testCaseId.equals("TC_VSP_004")){

				assertTrue(selenium.isElementPresent(btnAddResCalandar),"Add waitlist not present Present",selenium, ClassName, MethodName);
				assertTrue(selenium.isElementPresent(lnkEditWaitList),"Edit waitlist not present Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isElementPresent(btnDelete),"Delete waitlist not present Present",selenium, ClassName, MethodName);
			}
		}
		
		return returnValue;
	}
		
}