package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCreateEditDeleteButtonInTemplate extends AbstractClinicalSettings {
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Buttons in view ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCreateEditDeleteButtonInVisitOutline(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception
	{
		ClinicalSettingLib templateData = new ClinicalSettingLib();
		templateData.workSheetName = "ManagedCaredTemplate";
		templateData.testCaseId = "TC_MCT_004";
		templateData.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCreateEditDeleteButtons(seleniumHost,seleniumPort,browser,webSite,userAccount,templateData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Buttons in view ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySystemDefinedComponentsAndSectionsInVisitOutline(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception
	{
		ClinicalSettingLib templateData = new ClinicalSettingLib();
		templateData.workSheetName = "ManagedCaredTemplate";
		templateData.testCaseId = "TC_MCT_001";
		templateData.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCreateEditDeleteButtons(seleniumHost,seleniumPort,browser,webSite,userAccount,templateData);
	}
	

	public boolean verifyCreateEditDeleteButtons(String seleniumHost,int seleniumPort,String browser,String webSite,String userAccount,ClinicalSettingLib templateData)throws Exception
	{
		Selenium selenium=null;
		//boolean returnValue=true;
		try
		{
		//--------------------------------------------------------------------//
		//  Step-1 Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + templateData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, templateData.userName, templateData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		//--------------------------------------------------------------------//
		//  Step-2 Change the switch role 									  //
		//--------------------------------------------------------------------//
		assertTrue(switchRole(selenium,templateData.switchRole),"Could not change the switch role;More Details:"+templateData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//-------------------------------------------------------------------//
		//  Step-3 Navigate to visit outline Template
		//-------------------------------------------------------------------//
		assertTrue(navigateToVisitOutlineTemplate(selenium),"Unable to naviagate to visit outline",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//-------------------------------------------------------------------//
		//  Step-4 Verify of Create Visit Outline Template Page
		//-------------------------------------------------------------------//
		assertTrue(getValue(selenium,ajxSelectiontemp).equals("Visit Outline"),"Unable to click the create Custom template",selenium, ClassName, MethodName);
		assertTrue(selectValueFromAjaxList(selenium,ajxSelectiontemp,"Visit Section"),"Unable to select the visit section value from the ajax list",selenium, ClassName, MethodName);
		assertTrue(selectValueFromAjaxList(selenium,ajxSelectiontemp,"Visit Outline"),"Unable to select the visit section value from the ajax list",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(!selenium.isTextPresent("delete"),"Delete button is present for default template",selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnAddCustom),"Unable to click create new template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//-------------------------------------------------------------------//
		// Step-5 Verify create new page Visit Online Template
		//-------------------------------------------------------------------//
		assertTrue(verifyVisitOutlineTemplatePage(selenium),"Fail to check the visit outline page",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkTemp),"Add exit template not present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//-------------------------------------------------------------------//
		//  Step-6 Verify 'Start Blank' page
		//-------------------------------------------------------------------//
		assertTrue(verifyVisitOutlineTemplatePage(selenium),"Fail to Create New Page",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//------------------------------------------------------------------//
		//  Step-7 Verify VisitOutline page with Option Button
		//------------------------------------------------------------------//
		assertTrue(verifyCheckBoxForVisitOutline(selenium),"Fail to check all the visit settings checkBox",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//-----------------------------------------------------------------//
		//  Step-8 Verify all system defined components Data Present 
		//-----------------------------------------------------------------//
		if(templateData.testCaseId.equals("TC_MCT_001"))
		{
		assertTrue(verifyCheckBoxForVisitSettings(selenium),"Unable to check the VisitSettings",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(verifyCheckBoxForPastMedicalHistory(selenium),"Unable to check the all the items in the past Medical History",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(verifyCheckBoxForReviewOfSystems(selenium),"Unable to check all the items in the Review of systems tab",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(verifyCheckBoxForPhysicalExam(selenium),"Unable to check all the items in the Physical Examination",selenium,ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		
		}catch(RuntimeException e)
		{
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*", selenium, ClassName, MethodName);
		}
		return true;
	}
		
	
}
