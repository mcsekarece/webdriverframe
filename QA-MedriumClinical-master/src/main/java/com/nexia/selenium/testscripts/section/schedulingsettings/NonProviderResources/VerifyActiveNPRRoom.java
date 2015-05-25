package com.nexia.selenium.testscripts.section.schedulingsettings.NonProviderResources;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyActiveNPRRoom extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Active NPRRoom")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void activeNPRRoom(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProvider = new SchedulingTestLib();
		nonProvider.workSheetName = "NonProviderResource";
		nonProvider.testCaseId = "TC_NP_002";
		nonProvider.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyActiveNPRRoom(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProvider);
	}
	
	/**     
	* @purpose        VerifyActiveNPR Room
	* @action         VerifyActive NPR Room
	* @expected       Verify Active checkbox for NPR Room working properly
	* @author		  AspireQA         
	* @state          Developing
	* @useraccount    Both
	* @since  	      Dec 16, 2013
	* 
	*/
	
	public boolean verifyActiveNPRRoom(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib nonProvider) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + nonProvider.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, nonProvider.userName, nonProvider.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,nonProvider.switchRole),"Switch Role Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Non Provider Resource Room						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToNonProviderResource(selenium),"Could not navigate to non provider resource Room", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete All Non Provider Resource	Room					  //	
			//--------------------------------------------------------------------//
			assertTrue(deleteAllNonProviderResource(selenium,nonProvider),"Could not delete All Non Provider Resource Room", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Create New Non Provider Resource	Room					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource", selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createNewNonProviderResourceRoom(selenium,nonProvider,uniqueName),"Could not create a non provider resource room", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Delete  Created Non Provider Resource Room				  //
			//--------------------------------------------------------------------//
			String[] tempArray = getText(selenium, lblRooms).split(" ");
			
			int resourceNPRRoomCount=Integer.parseInt(tempArray[1].replace("(", "").replace(")", ""));

			for(int count=1;count<=resourceNPRRoomCount;count++){		
				if(getText(selenium,"//div[@id='NonProviderResourcesRoomsListWidget']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(nonProvider.roomName.trim().toLowerCase(new java.util.Locale("en","US")))){
				   assertTrue(click(selenium,btnDeleteNPR), "Could not click the delete button", selenium, ClassName, MethodName);
				   waitForPageLoad(selenium);
				   assertTrue(click(selenium, btnYesButton), "Could not click the yes button in delete pop up", selenium, ClassName, MethodName);
				   waitForPageLoad(selenium);
				   break;
				}
					
			 }
							 
			 if(getText(selenium, lblSummaryPageNonProviderResourceRoom).contains(nonProvider.roomName)){
				 Assert.fail("The Room Name deletion failed");
			 }
						 
	          assertTrue(click(selenium,chkIncludeInactiveCheckboxNPR),"Could not click IncludeInactiveCheckbox for NPR", selenium, ClassName, MethodName);
			  waitForPageLoad(selenium);
			  
			//--------------------------------------------------------------------//
			//  Step-7: Active the In Active Equipment			  //
			//--------------------------------------------------------------------//	 
			selectValueFromAjaxList(selenium,txtSearchNonProviderResource, nonProvider.roomName+uniqueName);
					 
			assertTrue(click(selenium,activateLink),"Could not click the active user",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				 
			assertTrue(click(selenium,btnYesButton),"Could not click the yes button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				 
				assertTrue(selenium.isVisible(lblNonProvider),"The room deletion failed",selenium, ClassName, MethodName);
			}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
