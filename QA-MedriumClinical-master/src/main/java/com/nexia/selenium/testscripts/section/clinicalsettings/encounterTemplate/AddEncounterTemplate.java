package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class AddEncounterTemplate extends AbstractClinicalSettings {
	
	@Test(groups = {"SmokeSingle","SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing add encounter template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addEncounterTemplateInSimpleView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_001";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing add encounter template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addEncounterTemplateInExpandedView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_002";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify add encounter template
	* @Specification  SRS_EMR_Encounter_Structure_Templates Rev0.0
	* @action 		  Verifying add encounter template
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 25, 2013
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
			//  Step-5: Add new Encounter Template 								  //
			//--------------------------------------------------------------------//
			assertTrue(addEncounterTemplate(selenium, encounterTemplateTestData),"Could not add new Encounter Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify the encounter template values in summary page      //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValuesEncounterTemplate(selenium, encounterTemplateTestData),"Verification failed for added encounter template in summary page", selenium, ClassName, MethodName);
			
			//----------------------------------------------------------------------------------//
			//  Step-7: verify the encounter template values in summary page Expanded View      //
			//----------------------------------------------------------------------------------//
			
			
			
			if(encounterTemplateTestData.testCaseId.equalsIgnoreCase("TC_ET_002")){
				assertTrue(type(selenium, txtSearch, encounterTemplateTestData.templateName), "Could not type template name", selenium, ClassName, MethodName);
				selenium.keyPress(txtSearch, "\\13");
				waitForPageLoad(selenium);	
				waitForPageLoad(selenium);	
				if(isElementPresent(selenium,"//div[2]/div/div[2]/div/div/div/div[2]/div"))	{
					selenium.click("//div[2]/div/div[2]/div/div/div/div[2]/div");		}
				else{
					Assert.fail("Serach result is not present");
				}
				
				
				assertTrue(VerifyEncounterInExpandView(selenium, encounterTemplateTestData),"Verification failed for added encounter template in summary page", selenium, ClassName, MethodName);
				
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}