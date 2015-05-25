package com.nexia.selenium.testscripts.section.demographics.Cases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForCases extends AbstractHomeTest{
	
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib caseData = new HomeLib();
		caseData.workSheetName = "VerifySecurityOption";
		caseData.testCaseId = "TC_VSP_001";
		caseData.fetchHomeTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib caseData = new HomeLib();
		caseData.workSheetName = "VerifySecurityOption";
		caseData.testCaseId = "TC_VSP_002";
		caseData.fetchHomeTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib caseData = new HomeLib();
		caseData.workSheetName = "VerifySecurityOption";
		caseData.testCaseId = "TC_VSP_003";
		caseData.fetchHomeTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib caseData = new HomeLib();
		caseData.workSheetName = "VerifySecurityOption";
		caseData.testCaseId = "TC_VSP_004";
		caseData.fetchHomeTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify security option
	* @action 		  Verifying security option
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      April 09, 2012
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib caseData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + caseData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, caseData.userName, caseData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role 									  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,caseData.switchRole),"Could not change the switch role;More Details:"+caseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
							
			if(caseData.testCaseId.equals("TC_VSP_003")){				
				
				assertTrue(searchPatientNexiaNoAccess(selenium,caseData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}	
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to cases //
			//--------------------------------------------------------------------//
						
			if(!caseData.testCaseId.equals("TC_VSP_003")){
				  
				searchPatientNexiaForProviderHomePage(selenium,caseData.patientId);
				waitForPageLoad(selenium);					
				assertTrue(click(selenium,lnkPatientCaseList),"Could not click the cases", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			}					
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			assertTrue(verifySecurity(selenium,caseData,userAccount),"Security option not show properly; More Details :"+ caseData.toString(), selenium, ClassName, MethodName);
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium,HomeLib caseData, String account) throws IOException{

		// Limited Access
		
		if(caseData.testCaseId.equals("TC_VSP_001")){
			caseData.workSheetName = "NewCases";
			caseData.testCaseId = "TC_NC_003";
			caseData.fetchHomeTestData();
			assertTrue(click(selenium,btnAddCase),"Could not click the add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);					
			assertTrue(createCases(selenium,caseData, account),"Creation failed", selenium, ClassName, MethodName);
			
			assertTrue(!selenium.isElementPresent(btnDeleteCase),"Delete Button Present" , selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(btnEditCase),"Edit Button is not visible" , selenium, ClassName, MethodName);			
		}
		
		// View Only Access
		
		if(caseData.testCaseId.equals("TC_VSP_002")){
									
			assertTrue(!selenium.isVisible(btnAddCase),"Add Button is visible" , selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(btnDeleteCase),"Delete Button is visible" , selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(btnEditCase),"Edit Button is visible" , selenium, ClassName, MethodName);
			
		}
		
		// Full Access
		
		if(caseData.testCaseId.equals("TC_VSP_004")){
			caseData.workSheetName = "NewCases";
			caseData.testCaseId = "TC_NC_003";
			caseData.fetchHomeTestData();
			assertTrue(goToCases(selenium), "Could not navigate to Cases Page", selenium, ClassName, MethodName);
			assertTrue(deleteAllCases(selenium), "Could not delete cases", selenium, ClassName, MethodName);
			
			assertTrue(goToAddCase(selenium),"Could not Navigate to Add Cases Button : "+ caseData.toString(), selenium, ClassName, MethodName);
			assertTrue(createCases(selenium,caseData,account),"Creation failed", selenium, ClassName, MethodName);
			
			assertTrue(selenium.isElementPresent(btnDeleteCase),"Delete Button is not Present" , selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(btnEditCase),"Edit Button is not visible" , selenium, ClassName, MethodName);
			
		}
		return true;
	}	
	
}
