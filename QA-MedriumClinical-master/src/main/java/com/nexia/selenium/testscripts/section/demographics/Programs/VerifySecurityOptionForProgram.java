package com.nexia.selenium.testscripts.section.demographics.Programs;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForProgram extends AbstractHomeTest{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "VerifySecurityOption";
		programData.testCaseId = "TC_VSP_001";
		programData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "VerifySecurityOption";
		programData.testCaseId = "TC_VSP_002";
		programData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "VerifySecurityOption";
		programData.testCaseId = "TC_VSP_003";
		programData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "VerifySecurityOption";
		programData.testCaseId = "TC_VSP_004";
		programData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify security option New Patient Check in Programs
	* @action 		  verify security option New Patient Check in Programs
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 05, 2012
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib programData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrieve the New Selenium Session; More Details :" + programData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, programData.userName, programData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,programData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										  //
			//--------------------------------------------------------------------//
			
			
			if(programData.testCaseId.equals("TC_VSP_003")){
			
				assertTrue(searchPatientNexiaNoAccess(selenium,programData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}			
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Programs									  //
			//--------------------------------------------------------------------//
			
		    if(!programData.testCaseId.equals("TC_VSP_003")){
			  
		    	searchPatientNexiaForProviderHomePage(selenium,programData.patientId);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,lnkProgram),"Could not click the Program", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
				
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			}			
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//			
			assertTrue( verifySecurity(selenium,programData, userAccount),
					"Security option not show properly; More Details :"+ programData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,HomeLib programData, String userAccount) throws IOException{
		
		// Limited Access
		
		if(programData.testCaseId.equals("TC_VSP_001")){			
			programData.workSheetName = "NewProgram";
			programData.testCaseId = "TC_P_001";
			programData.fetchHomeTestData();
			//assertTrue(deleteAllPrograms(selenium), "Could not delete all programs", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,lnkEditProgrem)){
			
				assertTrue(switchRole(selenium,"DFFullAccess"),"Could not change the switch role;More Details:"+programData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				searchPatientNexia(selenium,programData.patientId);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkProgram),"Could not click the Program", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteAllPrograms(selenium), "Could not delete all programs", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(switchRole(selenium,"DFLimitedAccess"),"Could not change the switch role;More Details:"+programData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				searchPatientNexia(selenium,programData.patientId);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkProgram),"Could not click the Program", selenium, ClassName, MethodName);
				
			}
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddPrograms),"Could not click the add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProgram(selenium,programData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			
			assertTrue(!selenium.isElementPresent(lnkDeleteProgram),"Delete Button Present", selenium, ClassName, MethodName);
			assertTrue(selenium.isElementPresent(lnkEditProgrem),"Edit Button is not visible", selenium, ClassName, MethodName);
						
		}
		
		// View Only Access
		
		if(programData.testCaseId.equals("TC_VSP_002")){
			
			assertTrue(!selenium.isVisible(btnAddPrograms),"Add Button is visible", selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(lnkDeleteProgram),"Delete Button is visible", selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(lnkEditProgrem),"Edit Button is visible", selenium, ClassName, MethodName);			
			
		}
		
		// Full Access
		if(programData.testCaseId.equals("TC_VSP_004")){
			programData.workSheetName = "NewProgram";
			programData.testCaseId = "TC_P_001";
			programData.fetchHomeTestData();
			waitForPageLoad(selenium);
			assertTrue(deleteAllPrograms(selenium), "Could not delete all programs", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddPrograms),"Could not click the add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(createProgram(selenium,programData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isElementPresent(btnDeleteCase),"Delete Button is not Present", selenium, ClassName, MethodName);
			assertTrue(selenium.isElementPresent(lnkEditProgrem),"Edit Button is not visible", selenium, ClassName, MethodName);
						
		}
		
		return true;
	}	
	
  }
