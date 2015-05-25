package com.nexia.selenium.testscripts.section.demographics.Cases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForCases extends AbstractHomeTest{	
		
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib caseData = new HomeLib();
		caseData.workSheetName = "VerifySecurityOption";
		caseData.testCaseId = "TC_VSP_006";
		caseData.fetchHomeTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify security option
	* @action 		  Verifying security option
	* @author         Jagmit Singh
	 * @throws IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      Nov 05, 2013
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
			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_014";
			userRoleData.fetchSystemSettingTestData();
							
			if(userRoleData.cases.contains("No Access")){				
				
				assertTrue(searchPatientNexiaMixSecurityNoAccess(selenium,caseData.patientId),"Could search patient", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isVisible(lnkPatientCaseList),"Case Link is Visible", selenium, ClassName, MethodName);
								
			}	
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to cases //
			//--------------------------------------------------------------------//
						
			if(!userRoleData.cases.contains("No Access")){
				  
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
			assertTrue(verifySecurity(selenium,userRoleData,caseData,userAccount),"Security option not show properly; More Details :"+ caseData.toString(), selenium, ClassName, MethodName);
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib userRoleData,HomeLib caseData, String account) throws IOException{

		// Limited Access		
		if(userRoleData.cases.contains("Limited Access")){
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
		if(userRoleData.cases.contains("View Only")){
											
			assertTrue(!selenium.isVisible(btnAddCase),"Add Button is visible" , selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(btnDeleteCase),"Delete Button is visible" , selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(btnEditCase),"Edit Button is visible" , selenium, ClassName, MethodName);
					
		}
				
		// Full Access				
		if(userRoleData.cases.contains("Full Access")){
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