package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class EncounterStructureTemplateEndToEnd extends AbstractClinicalSettings{

	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for creating Encounter Structure template EndToEnd")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void CreateVisitsection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "CreateVisitSection";
		encounterTemplateTestData.testCaseId = "TC_VS_001";
		encounterTemplateTestData.fetchClinicalSettingsTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
}
	 
	/**
	 * Encounter TEmplate
	 * Function to Verify Encounter Structure Template End to End
	 * @param selenium
	 */
	
public boolean encounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib encounterTemplateTestData) throws IOException{
		
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
			//  Step-4: Create a Custom section with widget 					  //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,templateName,"Visit Section"),"Selecting Custom section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			assertTrue(DeleteAllCustomSection(selenium),"Deletion of Visition Section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(CreateVisitSectionWithWidget(selenium,encounterTemplateTestData),"Deletion of Visition Section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,templateName,"Visit Section"),"Selecting Custom section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(VerifyCreatedSection(selenium,encounterTemplateTestData),"Deletion of Visition Section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium, lnkEncounterTemplate), "Could not click on encounter template link");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Add Created section with Default visit outline			  //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,templateName,"Visit Outline"),"Selecting Custom section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectdefaulttemplate(selenium),"Could not select default template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, EncoEdit), "Could not click on encounter template Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(DeleteCustomComponenetInEditDefalutPage(selenium),"Could not delete Custom component in Edit Default Template Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(click(selenium, btnAddNewUserDefined), "Could not click on Add new component", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtCustomCompName,encounterTemplateTestData.ComponenetName),"Could not type the lable name", selenium, ClassName, MethodName);	
			assertTrue(selectValueFromAjaxList(selenium,ajxTemplateType,"Use Custom Content"),"Selecting Custom componenet  failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		//	assertTrue(click(selenium, btnComponentEdit), "Could not click on Edit component", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnAddcustomSection), "Could not click on Add custom section", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtCustomSectionLAbel,encounterTemplateTestData.SectionName),"Could not type the lable name", selenium, ClassName, MethodName);	
			assertTrue(selectValueFromAjaxList(selenium,ajxTemplateType,"Use Custom Content"),"Selecting Custom componenet  failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSelectfronlibrary), "Could not click on Select from library ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblTemplate1), "Could not click on CustomSection in Visit section page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnusethis), "Could not click on Use this button in Visit section page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveCustomSection), "Could not click on Use this button in Visit section page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave2), "Could not click on Use this button in Visit section page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Create a new patient to check the Encounter template 	  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, lnkQuickLink), "Could not click Quick Action Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not click Quick Action Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib PatientData = new ChartPreVisitLib();	
			PatientData.workSheetName = "NewPatientCheckIn";
			PatientData.testCaseId = "TC_NP_001";
			String date=null;	
			PatientData.fetchChartPreVisitTestData();		
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MMMMddHH:mm:ss");
			date = DateFormat.format(cal.getTime());
			PatientData.lastName=PatientData.lastName+date;
			assertTrue( createNewPatientWithMandatory(selenium,PatientData),"Could not create a patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Search newly created Patient							 	  //
			//--------------------------------------------------------------------//		
			searchPatientNexiaForProviderHomePage(selenium,PatientData.lastName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8:Verify Default template in Encounter Note				 	  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllEncounters(selenium),"could not Delete", selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			assertTrue(goToBeginEncounter(selenium),"Navigation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(VerifyDefaultTemplateInEncounterNote(selenium,encounterTemplateTestData),"Verification of Default template with Encounter note failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//Save the First Encounter 
			assertTrue(click(selenium, lnkEncounterAction),"Could not click the Action button in Encounter note", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnEncountreSave),"Could not click the Save link under encounter Action", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-9:Goto Practice Library								 	  //
			//--------------------------------------------------------------------//	
			assertTrue(navigateToEncounterTemplate(selenium),"Navigation to encounter template Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,templateName,"Visit Section"),"Selecting Custom section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-10:Edit Visit Section									 	  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lblTemplate),"Could not click the First Labek in visit section that we have alresdy created ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnVisitysectionEdit),"Could not click the Edit button in visit section ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-11:Verify Edited Visit Section								  //
			//--------------------------------------------------------------------//	
			assertTrue(EditVisitSectionWithWidget(selenium,encounterTemplateTestData),"Edit visit section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,templateName,"Visit Section"),"Selecting Custom section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(VerifyEditedVisitSection(selenium,encounterTemplateTestData),"Deletion of Visition Section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-12:Verify Newly Edited Default Template with Encounter Note //
			//--------------------------------------------------------------------//	
			searchPatientNexiaForProviderHomePage(selenium,PatientData.lastName);
			waitForPageLoad(selenium);
			assertTrue(goToBeginEncounter(selenium),"Navigation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);					
			assertTrue(VerifyEditedDefaultTemplateInEncounterNote(selenium,encounterTemplateTestData),"Verification of Default template with Encounter note failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSign),"Could not click the Sign button in encounter note ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-13:Verify Newly Edited Default Template with First Encounter Note  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,PendingSignOffLabel),"Could not click the Pending Encounter in encounter tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(VerifyEditedDefaultTemplateInPrevouusEncounterNote(selenium,encounterTemplateTestData),"Edit visit section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSign),"Could not click the Sign button in encounter note ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectAutomationPractice(selenium),"Verification of Default template with Encounter note failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			
		}
	catch(Exception e)
	{
		Assert.fail(e.getMessage());
		return false;
	}
		return true;
}



}