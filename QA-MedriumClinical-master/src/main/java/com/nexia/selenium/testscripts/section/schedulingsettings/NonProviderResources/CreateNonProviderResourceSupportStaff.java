package com.nexia.selenium.testscripts.section.schedulingsettings.NonProviderResources;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;


public class CreateNonProviderResourceSupportStaff  extends AbstractSchedulingTest{
	
	@Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create NonProvider Resource Support Staff")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewNonProviderResourceSupportStaff(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProviderSS = new SchedulingTestLib();
		nonProviderSS.workSheetName = "NonProviderResource";
		nonProviderSS.testCaseId = "TC_NP_007";
		nonProviderSS.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createNewNonProviderStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProviderSS);
   }

	/*************************************************************************************************** 
	* @purpose        To verify Create New Non Provider Resource Support Staff
	* @action 		  verify Creating New Non Provider Resource Support Staff
	* @expected       To Ensure that the created New Non Provider Resource Support Staff works fine    
	* @author         Jagmit
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      June 06, 2013
	***************************************************************************************************/
	
	public boolean createNewNonProviderStaff(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib nonProviderSS) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + nonProviderSS.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, nonProviderSS.userName, nonProviderSS.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,nonProviderSS.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Non Provider Resource Support Staff  		  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToNonProviderResource(selenium),"Could not navigate to non provider resource Support Staff", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkNonProviderResourceSupportStaff), "could not able to click the Non Provider Resource Support Staff link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete All Non Provider Resource	Support Staff			  //	
			//--------------------------------------------------------------------//
			assertTrue(deleteAllNonProviderResource(selenium,nonProviderSS),"Could not delete All Non Provider Resource Support Staff", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Create New Non Provider Resource	Support Staff					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource", selenium, ClassName, MethodName);			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createNewNonProviderResourceRoom(selenium,nonProviderSS,uniqueName),"Could not create a non provider resource Support Staff", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Verify Stored Values For Non Provider Resource Support Staff	  //
			//--------------------------------------------------------------------//
			assertTrue(verfyStoredValuesForNonProviderResource(selenium,nonProviderSS),"Non Provider Resource Support Staff not created correctly", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Verify adding same staff with same location				  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtSupportStaffName, nonProviderSS.staffName+uniqueName), "Could not type the Support Staff Name", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxlocation, nonProviderSS.location);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSaveNonProviderResource), "Could not click the save button", selenium, ClassName, MethodName);
			
			if(getText(selenium, "css=li > div").equalsIgnoreCase("Failed to add non-provider resource")){
				returnValue= true;
			}
			else{
				returnValue= false;
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
