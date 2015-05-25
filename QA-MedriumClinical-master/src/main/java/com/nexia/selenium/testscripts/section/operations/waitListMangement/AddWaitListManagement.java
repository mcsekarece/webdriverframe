package com.nexia.selenium.testscripts.section.operations.waitListMangement;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class AddWaitListManagement extends AbstractOperationsTest{

	@Test(groups = {"Smoke","Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Add Wait List From Existing Patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addWaitListFromExistingPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		OperationsTestLib addWaitList = new OperationsTestLib();
		addWaitList.workSheetName = "VerifyWaitList";
		addWaitList.testCaseId = "TC_VWL_001";
		addWaitList.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,addWaitList);
	}
	
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Add Wait List from New patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addWaitListFromNewPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		OperationsTestLib addWaitList = new OperationsTestLib();
		addWaitList.workSheetName = "VerifyWaitList";
		addWaitList.testCaseId = "TC_VWL_003";
		addWaitList.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		waitListManagement(seleniumHost, seleniumPort, browser, webSite, userAccount,addWaitList);
	}

	/*************************************************************************************************** 
	* @purpose        verify Add Wait List Management From Existing and New patient
	* @action 		  verifying Add Wait List Management and New patient
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 18, 2013	
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
			//  Step-5: Add wait list for patient								  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddResCalandar), "Could not click the Add new wait list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID							  //
			//--------------------------------------------------------------------//
			if(addWaitList.testCaseId.equalsIgnoreCase("TC_VWL_003")){
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
				
				addWaitList.patientName = addWaitList.patientName +date;
				
				
				
				assertTrue(type(selenium,txtpatientsearch,addWaitList.patientName),"Could not type patient id", selenium, ClassName, MethodName);
				
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
				//verify the existence of resource. If not available pass the case.(Because, Depends on calendar creation)
				if(!selectValueFromAjaxList(selenium,ajxResource,addWaitList.resource)){
					return true;
				}
				assertTrue(fillWaitListDetailsForNewPatient(selenium,addWaitList, userAccount), "Visit details failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------------//
				//  Step-8: Verify the created temporary patient in global patient search   //
				//--------------------------------------------------------------------------//
				//Bug Id --> #5354
				assertTrue(type(selenium,txtPatientBox,addWaitList.patientName),"Could not type patient id", selenium, ClassName,MethodName);
				selenium.keyPress(txtPatientBox, "\\9");
				waitForElement(selenium,lblPatientResult,10000);
				assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+addWaitList.patientName, selenium, ClassName,MethodName);
				assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(addWaitList.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"get text patient result failed", selenium, ClassName,MethodName);
				
				
			}else{
				searchPatientForBookingVisit(selenium,addWaitList.patientName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-7: Fill the wait list details								  //
				//--------------------------------------------------------------------//
				//verify the existence of resource. If not available pass the case.(Because, Depends on calendar creation)
				if(!selectValueFromAjaxList(selenium,ajxResource,addWaitList.resource)){
					return true;
				}
				
				assertTrue(fillWaitListDetailsForExistingPatient(selenium,addWaitList, userAccount), "Visit details failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-9: Navigate to Wait list management 						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToWaitListMgmt(selenium),"Could not navigate to wait list management", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: verify the Wait list management values in summary page   //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValuesWaitListMgmt(selenium, addWaitList, userAccount),"Verification failed for added wait list management in summary page", selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
