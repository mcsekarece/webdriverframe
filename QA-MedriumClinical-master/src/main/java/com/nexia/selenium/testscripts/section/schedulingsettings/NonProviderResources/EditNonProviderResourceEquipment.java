package com.nexia.selenium.testscripts.section.schedulingsettings.NonProviderResources;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;


public class EditNonProviderResourceEquipment extends AbstractSchedulingTest {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Edit NonProvider Resource Equipment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editNewNonProviderResourceEquipment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProviderEq = new SchedulingTestLib();
		nonProviderEq.workSheetName = "NonProviderResource";
		nonProviderEq.testCaseId = "TC_NP_005";
		nonProviderEq.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editNewNonProviderEquipment(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProviderEq);		
  }
	
	/*************************************************************************************************** 
	* @purpose        To verify Edit New Non Provider Resource Equipment
	* @action 		  verify Editing New Non Provider Resource Equipment
	* @expected       To Ensure that the edited New Non Provider Resource Equipment works fine    
	* @author         Jagmit
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      June 06, 2013
	***************************************************************************************************/
	
	public boolean editNewNonProviderEquipment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib nonProviderEq) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + nonProviderEq.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, nonProviderEq.userName, nonProviderEq.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,nonProviderEq.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Non Provider Resource Equipment						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToNonProviderResource(selenium),"Could not navigate to non provider resource Equipment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkNonProviderResourceEquipment), "could not able to click the Non Provider Resource Equipment link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete All Non Provider Resource	Equipment					  //	
			//--------------------------------------------------------------------//
			assertTrue(deleteAllNonProviderResource(selenium,nonProviderEq),"Could not delete All Non Provider Resource Equipment", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Create New Non Provider Resource	Equipment					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource", selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());		
			assertTrue(createNewNonProviderResourceRoom(selenium,nonProviderEq,uniqueName),"Could not create a non provider resource room", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: edit New Non Provider Resource	Equipment				  //
			//--------------------------------------------------------------------//
			
			nonProviderEq.workSheetName = "NonProviderResource";
			nonProviderEq.testCaseId = "TC_NP_006";
			nonProviderEq.fetchSchedulingTestData();		
			
			assertTrue(click(selenium, btnEdit), "could not able to click on Edit button", selenium, ClassName, MethodName);
			
			assertTrue(createNewNonProviderResourceRoom(selenium,nonProviderEq,uniqueName),"Could not create a non provider resource room", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Verify Stored Values For Non Provider Resource Equipment			  //
			//--------------------------------------------------------------------//
			assertTrue(verfyStoredValuesForNonProviderResource(selenium,nonProviderEq),"Non Provider Resource Equipment not created correctly", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}

		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		
	}		
		
	}
	
