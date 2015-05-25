package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingUnitTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnitTestForEncounterTemplate extends AbstractClinicalSettings {
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing encounter template name with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterTemplateNameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingUnitTest encounterTemplateTestData = new ClinicalSettingUnitTest();
		encounterTemplateTestData.workSheetName = "UnitTest_EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_001";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing encounter template name with maximum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterTemplateNameWithMaximum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingUnitTest encounterTemplateTestData = new ClinicalSettingUnitTest();
		encounterTemplateTestData.workSheetName = "UnitTest_EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_002";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing encounter template with empty slot")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterTemplateWithEmptySlot(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingUnitTest encounterTemplateTestData = new ClinicalSettingUnitTest();
		encounterTemplateTestData.workSheetName = "UnitTest_EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_003";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify unit test in encounter template
	* @Specification  SRS_EMR_Encounter_Structure_Templates Rev0.0
	* @action 		  Verifying unit test in encounter template
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 30, 2013
	***************************************************************************************************/
	
	public boolean encounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingUnitTest encounterTemplateTestData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterTemplateTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterTemplateTestData.userName, encounterTemplateTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role 									  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,encounterTemplateTestData.switchRole),"Could not change the switch role;More Details:"+encounterTemplateTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter Template 							  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToEncounterTemplate(selenium),"Navigation to encounter template Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Add new Encounter Template 								  //
			//--------------------------------------------------------------------//
			assertTrue(addEncounterTemplateUnitTest(selenium, encounterTemplateTestData),"Could not add new Encounter Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Verify Unit Test Functionality For Encounter Template	  //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium, encounterTemplateTestData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, encounterTemplateTestData.validationFieldID).contains(encounterTemplateTestData.validationMessage), "The expected validation message should contain the text - "+ encounterTemplateTestData.validationMessage + " The actual validation message shown - " + getText(selenium, encounterTemplateTestData.validationFieldID), selenium, ClassName, MethodName);
				
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}