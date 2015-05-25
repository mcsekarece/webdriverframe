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



public class VerifySearchOptionForEquipment extends AbstractSchedulingTest  {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Search NonProvider Resource Equipment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchNonProviderResourceEquipment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib nonProviderEq = new SchedulingTestLib();
		nonProviderEq.workSheetName = "NonProviderResource";
		nonProviderEq.testCaseId = "TC_NP_004b";
		nonProviderEq.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchEquipment(seleniumHost, seleniumPort, browser, webSite, userAccount, nonProviderEq);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Search Function for Equipment 
	* @action 		  verifying search Function  for Equipment 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jun 17, 2012
	***************************************************************************************************/
	
	public boolean searchEquipment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingTestLib nonProviderEq) throws IOException{
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			// Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + nonProviderEq.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, nonProviderEq.userName, nonProviderEq.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,nonProviderEq.switchRole),"Switch Role Failed",selenium, ClassName, MethodName );
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Navigate to Non Provider Resource Equipment		          //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkNonProviderResource), "could not able to click the Non Provider Resource link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkNonProviderResourceEquipment), "could not able to click the Non Provider Resource Equipment link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5:Delete All Existing Non Provider Resource Equipment		      //
			//--------------------------------------------------------------------//
		
			assertTrue(deleteAllNonProviderResource(selenium,nonProviderEq),"Could not delete All Non Provider Resource Equipment",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Create  a new Non Provider Resource Equipment      		  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource",selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createNewNonProviderResourceRoom(selenium,nonProviderEq,uniqueName),"Could not create a non provider resource room",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Create Another Non Provider Resource Equipment   	      	//
			//--------------------------------------------------------------------//

			nonProviderEq.workSheetName = "NonProviderResource";
			nonProviderEq.testCaseId = "TC_NP_004c";
			nonProviderEq.fetchSchedulingTestData();
			
			assertTrue(click(selenium, btnAddNonProviderResource), "could not able to click Add New button for Non Provider Resource",selenium, ClassName, MethodName);
			
			assertTrue(createNewNonProviderResourceRoom(selenium,nonProviderEq,uniqueName),"Could not create a non provider resource equipment",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify Search Values For Equipment Name				      //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtSearchNonProviderResource,nonProviderEq.equipmentName),"Could not Type the Equipment Name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(txtSearchNonProviderResource, "\\13");
			waitForPageLoad(selenium);
			
			 assertTrue(selenium.isVisible(lblSummaryNonProviderResource),"Search result is not getting displayed",selenium, ClassName, MethodName);
		     
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	

}
