package com.nexia.selenium.testscripts.section.demographics.Notes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForNotes extends AbstractHomeTest{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib noteData = new HomeLib();
		noteData.workSheetName = "VerifySecurityOption";
		noteData.testCaseId = "TC_VSP_001";
		noteData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib noteData = new HomeLib();
		noteData.workSheetName = "VerifySecurityOption";
		noteData.testCaseId = "TC_VSP_002";
		noteData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib noteData = new HomeLib();
		noteData.workSheetName = "VerifySecurityOption";
		noteData.testCaseId = "TC_VSP_003";
		noteData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib noteData = new HomeLib();
		noteData.workSheetName = "VerifySecurityOption";
		noteData.testCaseId = "TC_VSP_004";
		noteData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Notes
	* @action 		  Verifying Security Option For Notes
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 05, 2012
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib noteData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + noteData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, noteData.userName, noteData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,noteData.switchRole),"Could not change the switch role;More Details:"+noteData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									 //
			//--------------------------------------------------------------------//
			
			//No Access User Role	
			if(noteData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				assertTrue(searchPatientNexiaNoAccess(selenium,noteData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}	
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Notes 										 //
			//--------------------------------------------------------------------//
			
			if(!noteData.testCaseId.equals("TC_VSP_003")){
			
				    searchPatientNexiaForProviderHomePage(selenium,noteData.patientId);
					waitForPageLoad(selenium);					
					
					assertTrue(click(selenium,lnkNotes),"Could not click the Notes", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);			  	
					
					assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
					assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			  }		
			
				
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,noteData, userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ noteData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,HomeLib noteData, String userAccount) throws IOException{
		
		// Limited Access
		
		if(noteData.testCaseId.equals("TC_VSP_001")){
			noteData.workSheetName = "createNewNote";
			noteData.testCaseId = "TC_NO_001";
			noteData.fetchHomeTestData();
			
			assertTrue(click(selenium,btnAddNote),"Could not click the add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createNotes(selenium,noteData, userAccount),"Creation failed", selenium, ClassName, MethodName);
			
			assertTrue(!selenium.isElementPresent(lblDeleteNote),"Delete Button is present" , selenium, ClassName, MethodName);
		    assertTrue(selenium.isElementPresent(lblEditNote),"Edit Button is not present" , selenium, ClassName, MethodName);
			
		}
		
		// View Only Access
		
		if(noteData.testCaseId.equals("TC_VSP_002")){
			
			assertTrue(!selenium.isVisible(btnAddNote),"Add Button is visible" , selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(lblDeleteNote),"Delete Button is visible" , selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(lblEditNote),"Edit Button is visible" , selenium, ClassName, MethodName);		
			
		}
		
		
		// Full Access
		if(noteData.testCaseId.equals("TC_VSP_004")){
			noteData.workSheetName = "createNewNote";
			noteData.testCaseId = "TC_NO_001";
			noteData.fetchHomeTestData();
			assertTrue(click(selenium,btnAddNote),"Could not click the add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createNotes(selenium,noteData, userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(selenium.isElementPresent(lblDeleteNote),"Delete Button is not present" , selenium, ClassName, MethodName);
			assertTrue(selenium.isElementPresent(lblEditNote),"Edit Button is not present" , selenium, ClassName, MethodName);
			
			
		}
		return true;
	}

}
