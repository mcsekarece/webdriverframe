package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class EditCustomSectionInEncounterTemplate extends AbstractClinicalSettings {
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing edit custom sections in encounter template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editCustomSectionInEncounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_005";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify edit custom sections in encounter template
	* @Specification  SRS_EMR_Encounter_Structure_Templates Rev0.0
	* @action 		  Verifying edit custom sections in encounter template
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 03, 2013
	***************************************************************************************************/
	
	public boolean encounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib encounterTemplateTestData) throws IOException{
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
			//  Step-4: Delete All Encounter Template 							  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllEncounterTemplate(selenium),"Could not Delete All Encounter Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
						
			//--------------------------------------------------------------------//
			//  Step-5: Add new Encounter Template with custom section name		  //
			//--------------------------------------------------------------------//
			assertTrue(addCustomSectionInEncounterTemplate(selenium, encounterTemplateTestData),"Could not add new Encounter Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Edit custom section name in Encounter Template			  //
			//--------------------------------------------------------------------//
			assertTrue(SearchAddedTemplateForoutline(selenium, encounterTemplateTestData),"Could not search the Added ENCOUNTER TEMPLATE", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, EncoEdit), "Could not click Edit button in Created Encounter template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			encounterTemplateTestData.customSection1= encounterTemplateTestData.customSection1+"Updated";
			
			assertTrue(type(selenium, txtUserDefinedName, encounterTemplateTestData.customSection1), "Could not type display as user defined section name", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: verify custom section name in summary page     			  //
			//--------------------------------------------------------------------//
			assertTrue(SearchAddedTemplateForoutline(selenium, encounterTemplateTestData),"Could not search the Added ENCOUNTER TEMPLATE", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isTextPresent(encounterTemplateTestData.customSection1),"Could not Find custom section name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}