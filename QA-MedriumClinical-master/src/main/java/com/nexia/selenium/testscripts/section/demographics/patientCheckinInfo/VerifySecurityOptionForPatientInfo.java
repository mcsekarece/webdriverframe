package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForPatientInfo extends AbstractHomeTest{
	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "VerifySecurityOption";
		patientData.testCaseId = "TC_VSP_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "VerifySecurityOption";
		patientData.testCaseId = "TC_VSP_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "VerifySecurityOption";
		patientData.testCaseId = "TC_VSP_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "VerifySecurityOption";
		patientData.testCaseId = "TC_VSP_004";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Security Option
	* @action 		  verifying Security Option
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 05, 2012
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
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,patientData,userAccount)){
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
	public boolean verifySecurity(Selenium selenium,HomeLib patientData,String userAccount) throws IOException{
	
			waitForPageLoad(selenium);
			if(patientData.testCaseId.equals("TC_VSP_003")){
				patientData.workSheetName = "NewPatientCheckIn";
				patientData.testCaseId = "TC_NPC_001";
				patientData.fetchHomeTestData();
				/*assertTrue(selenium.isElementPresent(registerPatient),"Register patient link is available in home page", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);*/
				assertTrue(click(selenium,lnkQuickActions),"Could not Click on Export chart option"+ patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isElementPresent(lnkQuickActionsRegisterPatient),"Register patient link is available in quick actions", selenium, ClassName, MethodName);
				return true;
			}else if(patientData.testCaseId.equals("TC_VSP_002")){
				patientData.workSheetName = "NewPatientCheckIn";
				patientData.testCaseId = "TC_NPC_001";
				patientData.fetchHomeTestData();
				/*assertTrue(selenium.isElementPresent(registerPatient),"Register patient link is available in home page", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);*/
				assertTrue(click(selenium,lnkQuickActions),"Could not Click on Export chart option"+ patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isElementPresent(lnkQuickActionsRegisterPatient),"Register patient link is available in quick actions", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!(getText(selenium,lnkQuickActionsRegisterPatient).contains("Register patient")),"Register patient link is available in quick actions", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
				if(isElementPresent(selenium,""))
				return true;
			}
		if(patientData.testCaseId.equals("TC_VSP_001")){
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patientData.patientId);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on Export chart option"+ patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!(selenium.isElementPresent(lnkPatientExportPortal)),"Search Results are displayed for No Access User", selenium, ClassName, MethodName);
			
			click(selenium,btnBackButton);
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
		if(patientData.testCaseId.equals("TC_VSP_004")){
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
