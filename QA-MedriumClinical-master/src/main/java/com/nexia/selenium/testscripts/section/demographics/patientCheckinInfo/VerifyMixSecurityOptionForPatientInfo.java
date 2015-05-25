package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForPatientInfo extends AbstractHomeTest{	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "VerifySecurityOption";
		patientData.testCaseId = "TC_VSP_006";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Security Option
	* @action 		  verifying Security Option
	* @author         Jagmit
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 05, 2013
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify security option //
			//--------------------------------------------------------------------//
			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_014";
			userRoleData.fetchSystemSettingTestData();
			
			if(!verifySecurity(selenium,userRoleData,patientData,userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ patientData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib userRoleData,HomeLib patientData,String userAccount) throws IOException{
	
			waitForPageLoad(selenium);
			// No access
			if(userRoleData.personalInfo.contains("No Access")){
				patientData.workSheetName = "NewPatientCheckIn";
				patientData.testCaseId = "TC_NPC_001";
				patientData.fetchHomeTestData();
				assertTrue(selenium.isElementPresent(registerPatient),"Register patient link is available in home page", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkQuickActions),"Could not Click on Export chart option"+ patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(selenium.isElementPresent(lnkQuickActionsRegisterPatient),"Register patient link is available in quick actions", selenium, ClassName, MethodName);
				return true;				
			}
			// View Only Access
			else if(userRoleData.personalInfo.contains("View Only")){
				patientData.workSheetName = "NewPatientCheckIn";
				patientData.testCaseId = "TC_NPC_001";
				patientData.fetchHomeTestData();
				//assertTrue(selenium.isElementPresent(registerPatient),"Register patient link is available in home page", selenium, ClassName, MethodName);
				//waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkQuickActions),"Could not Click on Export chart option"+ patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(selenium.isElementPresent(lnkQuickActionsRegisterPatient),"Register patient link is available in quick actions", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!(getText(selenium,lnkQuickActionsRegisterPatient).contains("Register patient")),"Register patient link is available in quick actions", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(searchPatientNexia(selenium,patientData.patientId),"Could not search patient", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!(selenium.isElementPresent(btnRegistrationEdit)),"Edit button available for view only user"+ patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,""))
				return true;
			}
			
		// Limited Access	
		if(userRoleData.personalInfo.contains("Limited Access")){
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patientData.patientId);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on Export chart option"+ patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!(selenium.isElementPresent(lnkPatientExportPortal)),"Search Results are displayed for No Access User", selenium, ClassName, MethodName);
			
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();
			
			assertTrue(goToNewPatientCheckIn(selenium), "Could not navigate to Patient information page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(createPatient(selenium,patientData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			if(isElementPresent(selenium,btnRegistrationEdit)){
				return true;
			}else
				return false;
		}
		
		// Full Access
		if(userRoleData.personalInfo.contains("Full Access")){
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();
			assertTrue(goToNewPatientCheckIn(selenium), "Could not navigate to Patient information page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isElementPresent(btnSave1),"patient registration not opened", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createPatient(selenium,patientData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			if(isElementPresent(selenium,btnRegistrationEdit)){
				return true;
			}else
				return false;
		}
		return true;
	}	
}