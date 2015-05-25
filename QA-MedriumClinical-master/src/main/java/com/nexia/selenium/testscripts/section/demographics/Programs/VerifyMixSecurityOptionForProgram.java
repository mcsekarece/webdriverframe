package com.nexia.selenium.testscripts.section.demographics.Programs;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForProgram extends AbstractHomeTest{	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "VerifySecurityOption";
		programData.testCaseId = "TC_VSP_006";
		programData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify security option New Patient Check in Programs
	* @action 		  verify security option New Patient Check in Programs
	* @author         Jagmit Singh
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 05, 2013
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib programData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not retrieve the new Selenium Session; More Details :" + programData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, programData.userName, programData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,programData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										  //
			//--------------------------------------------------------------------//
			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_014";
			userRoleData.fetchSystemSettingTestData();
			
			if(userRoleData.programs.contains("No Access")){
				
				assertTrue(searchPatientNexiaMixSecurityNoAccess(selenium,programData.patientId),"Could search patient", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isVisible(lnkProgram),"Program Link is Visible", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
						
			}			
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Programs									  //
			//--------------------------------------------------------------------//
			
		    if(!userRoleData.programs.contains("No Access")){
			  
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
			assertTrue(verifySecurity(selenium,userRoleData,programData, userAccount),
					"Security option not show properly; More Details :"+ programData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib userRoleData,HomeLib programData,String userAccount) throws IOException{
		
		// Limited Access		
		if(userRoleData.programs.contains("Limited Access")){
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
		if(userRoleData.programs.contains("View Only")){
			
			assertTrue(!selenium.isVisible(btnAddPrograms),"Add Button is visible", selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(lnkDeleteProgram),"Delete Button is visible", selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(lnkEditProgrem),"Edit Button is visible", selenium, ClassName, MethodName);			
			
		}
		
		// Full Access
		if(userRoleData.programs.contains("Full Access")){
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
			
			assertTrue(selenium.isElementPresent(lnkDeleteProgram),"Delete Button is not Present", selenium, ClassName, MethodName);
			assertTrue(selenium.isElementPresent(lnkEditProgrem),"Edit Button is not visible", selenium, ClassName, MethodName);
						
		}
		
		return true;
	}	
	
  }