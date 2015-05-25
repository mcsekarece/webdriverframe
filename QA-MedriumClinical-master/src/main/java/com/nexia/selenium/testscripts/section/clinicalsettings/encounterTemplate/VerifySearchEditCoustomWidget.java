package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;



import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchEditCoustomWidget extends AbstractClinicalSettings{
	@Test(groups = {"SingleThread","Review","firefox", "iexplore", "safari", "default" }, description = "Test for Search and Edit widget in Edit status")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
public void verifySearchEditCoustomWidget(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception
{
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "CreateVisitSection";
		encounterTemplateTestData.testCaseId = "TC_VS_001";
		encounterTemplateTestData.fetchClinicalSettingsTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyEncounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
}
	
	
	public boolean verifyEncounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib encounterTemplateTestData) throws Exception
	{
		Selenium selenium=null;	
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
			assertTrue(selectPractice(selenium),"Could not Select Encouter Structure Practice"+encounterTemplateTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(switchRole(selenium,encounterTemplateTestData.switchRole),"Could not change the switch role;More Details:"+encounterTemplateTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter Template 							  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToEncounterTemplate(selenium),"Navigation to encounter template Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Delete All widgets                  					  //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,templateName,"Visit Section"),"Selecting Custom section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			assertTrue(DeleteAllCustomSection(selenium),"Deletion of Visition Section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Create a Custom widgets                 				  //
			//--------------------------------------------------------------------//
			assertTrue(CreateVisitSectionWithWidget(selenium,encounterTemplateTestData),"Deletion of Visition Section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,templateName,"Visit Section"),"Selecting Custom section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			//--------------------------------------------------------------------//
			//   Step-6: Verify created custom widget
			//--------------------------------------------------------------------//
			assertTrue(VerifyCreatedSection(selenium,encounterTemplateTestData),"Deletion of Visition Section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//-------------------------------------------------------------------//
			//  Step-7: Edit the Widget
			//-------------------------------------------------------------------//
			assertTrue(searchAddEditVisitSection(selenium,encounterTemplateTestData),"Edit search fail",selenium,ClassName,MethodName);
	
		}catch(RuntimeException e)
		{
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
			
		return true;
	}
}
