package com.nexia.selenium.testscripts.section.schedulingsettings.NonProviderResources;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;


public class VerifySearchOptionForRoom extends AbstractSchedulingTest {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create NonProvider Resource")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewNonProviderResourceRoom(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProvider = new SchedulingTestLib();
		nonProvider.workSheetName = "NonProviderResource";
		nonProvider.testCaseId = "TC_NP_001a";
		nonProvider.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchRoom(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProvider);
		
}

	/*************************************************************************************************** 
	* @purpose        To verify Search Function for Room 
	* @action 		  verifying search Function  for Room 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jun 17, 2012
	***************************************************************************************************/
	
	public boolean searchRoom(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingTestLib nonProvider) throws IOException{
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			// Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + nonProvider.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, nonProvider.userName, nonProvider.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,nonProvider.switchRole),"Switch Role Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Navigation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Navigate to Non Provider Resource Room		          //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkNonProviderResource), "could not able to click the Non Provider Resource link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
									
			//--------------------------------------------------------------------//
			//  Step-5:Delete All Existing Non Provider Resource Room		      //
			//--------------------------------------------------------------------//
		
			assertTrue(deleteAllNonProviderResource(selenium,nonProvider),"Could not delete All Non Provider Resource Room",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Create  a new Non Provider Resource Room      		  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource",selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
					
			assertTrue(createNewNonProviderResourceRoom(selenium,nonProvider,uniqueName),"Could not create a non provider resource room",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Create Another Non Provider Resource Room   	      	//
			//--------------------------------------------------------------------//

			nonProvider.workSheetName = "NonProviderResource";
			nonProvider.testCaseId = "TC_NP_001b";
			nonProvider.fetchSchedulingTestData();
			
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource",selenium, ClassName, MethodName);
			
			assertTrue(createNewNonProviderResourceRoom(selenium,nonProvider,uniqueName),"Could not create a non provider resource room",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify Search Values For Room Name				      //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtSearchNonProviderResource,nonProvider.roomName),"Could not Type the Room Name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(txtSearchNonProviderResource, "\\13");
			waitForPageLoad(selenium);
			
			 assertTrue(getText(selenium, lblSummaryNonProviderResource).contains(nonProvider.roomName),"Search result is not getting displayed",selenium, ClassName, MethodName);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	
}	