package com.nexia.selenium.testscripts.section.demographics.frontOfficeHomePage;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyViewCalander extends AbstractHomeTest {
	HomeLib PatientData = new HomeLib();
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying view my calander")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyViewCalander(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_014";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying Nexia Logo")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNexiaLogo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_001";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify create a New Patient entry
	* @action 		  verifying create a New Patient entry
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 23, 2012
	***************************************************************************************************/
	public boolean createNewPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, btnErrorClose))
	    			assertTrue(click(selenium, btnErrorClose),"Could not click error button", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify View Calendar								  //
			//--------------------------------------------------------------------//
			
			assertTrue(isElementPresent(selenium,btnSaveHCT),"Could not find view calander;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSaveHCT),"Could not click view calander;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,lnkAddResource)){
				Assert.fail("My View Not Present");
			}
			
			if(patientData.testCaseId.contains("TC_NPC_001")){
			assertTrue(isElementPresent(selenium,btnNexiaLogo),"Could not find nexia logo;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click on nexia logo;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, btnErrorClose))
	    			assertTrue(click(selenium, btnErrorClose),"Could not click error button", selenium, ClassName, MethodName);
			
			if(!isElementPresent(selenium,btnSaveHCT)){
				Assert.fail("User is not navigated to home page");
			}
			}
		
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}