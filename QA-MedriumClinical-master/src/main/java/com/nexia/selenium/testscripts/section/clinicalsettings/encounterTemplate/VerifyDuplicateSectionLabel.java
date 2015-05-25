package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDuplicateSectionLabel extends AbstractClinicalSettings{

	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Duplicate Section label ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyDuplicateLabelSection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_018";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		VisitSection(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	public boolean VisitSection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib encounterTemplateTestData) throws IOException{
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
			assertTrue(deleteAllVisitSection(selenium),"Could not Delete All Encounter Template", selenium, ClassName, MethodName);
				
			assertTrue(verifyduplicatewidget(selenium,encounterTemplateTestData),"Verification of duplicate label failed ", selenium, ClassName, MethodName);
			/*//--------------------------------------------------------------------//
			//  Step-5: Add new Encounter Template 								  //
			//--------------------------------------------------------------------//
			assertTrue(addVisitSection(selenium, encounterTemplateTestData),"Could not add new Encounter Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify the encounter template values in summary page      //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValuesEncounterTemplate(selenium, encounterTemplateTestData),"Verification failed for added encounter template in summary page", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtSearch, encounterTemplateTestData.templateDescription), "Could not type template name", selenium, ClassName, MethodName);
			selenium.keyPress(txtSearch, "\\13");
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			if(isElementPresent(selenium,"//div[2]/div/div[2]/div/div/div/div/div"))	{
				selenium.click("//div[2]/div/div[2]/div/div/div/div/div");		}
			else{
				Assert.fail("Serach result is not present");
			}
		
			//--------------------------------------------------------------------//
			//  Step-7: Add Same Section Again      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnOption), "Could not click Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium, "css=div.canvas-item.canvas-item-empty"), "Could not click Second row in Add Visit section page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium, "link=Title"), "Could not click Title label", selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);		
			selenium.click("//div[2]/div/div/div[2]/input");
			selenium.focus("//div[2]/div/div/div[2]/input");
			selenium.type("//div[2]/div/div/div[2]/input", encounterTemplateTestData.customSection1);
			assertTrue(click(selenium, btnwidgtSave), "Could not click Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Verify duplicate warning       								//
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium,"//div[2]/div/div/div[2]/input"))
			{
				return true;
			}
			else
			{
				return false;
			}			*/
			
		}
		catch(Exception e)
		{
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);

		}
		return true;
		}
	
	
}
