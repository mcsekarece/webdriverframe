package com.nexia.selenium.testscripts.section.operations.CheckinAssistant;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyRoomsInCheckInAssist extends AbstractOperationsTest{
	@Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "verifyRoomsInCheckInAssist")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRoomsInCheckInAssist(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		OperationsTestLib checkInAssistTestData = new  OperationsTestLib();
		checkInAssistTestData.workSheetName = "VerifyCheckInAssistant";
		checkInAssistTestData.testCaseId = "TC_VCA_001";
		checkInAssistTestData.fetchSchedulingSettingsTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyRoomsInCheckInAssist(seleniumHost, seleniumPort, browser, webSite, userAccount,checkInAssistTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Rooms in Patient CheckIn Assistant
	* @action 		  verifying Rooms in Patient CheckIn Assistant
	* @author         Aspire QA
	* @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 05, 2013
	***************************************************************************************************/
	public boolean verifyRoomsInCheckInAssist(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,OperationsTestLib checkInAssistTestData) throws IOException{
		Selenium selenium = null;
		try{
			
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + checkInAssistTestData.toString());
			
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, checkInAssistTestData.userName, checkInAssistTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,checkInAssistTestData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Non Provider Resource Room						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToNonProviderResource(selenium),"Could not navigate to non provider resource Room", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete All Non Provider Resource	Room					  //	
			//--------------------------------------------------------------------//
			assertTrue(deleteAllNonProviderResource(selenium),"Could not delete All Non Provider Resource Room", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Create New Non Provider Resource	Room					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtRoomName, checkInAssistTestData.location), "Could not type the Room name", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxlocation, checkInAssistTestData.location);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSaveNonProviderResource), "Could not click the save button", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to CheckIn Assistant //
			//--------------------------------------------------------------------//
			assertTrue(goToOperations(selenium),"Could not click the Operations link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkCheckInAssistant),"Could not click Check in assistant link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Select the patient in the CheckIn Assistant //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxResourceList,checkInAssistTestData.resource),"Could not select Visit type"+checkInAssistTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxLocationList,checkInAssistTestData.location),"Could not select Visit type"+checkInAssistTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			click(selenium, "//div[@id='AppointmentList']/table/tbody/tr/td/div/div/div[2]/div");
			
			if(!getText(selenium,"").toLowerCase(new java.util.Locale("en","Us")).trim().contains(checkInAssistTestData.location.trim().toLowerCase(new java.util.Locale("en","Us")))){
						
				return false;
			}
			
		}			
		catch (RuntimeException e){
			
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		return true;
	}
}
