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

public class VerifyWidgetsInEncounterNote extends AbstractClinicalSettings{

	@Test(groups = {"AdvancedSmoke","SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for creating Encounter Structure template EndToEnd")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void CreateVisitsection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "CreateVisitSection";
		encounterTemplateTestData.testCaseId = "TC_VS_002";
		encounterTemplateTestData.fetchClinicalSettingsTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
		
}	
	public boolean encounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib encounterTemplateTestData) throws IOException{
		Selenium selenium=null;
	try
	{	//--------------------------------------------------------------------//
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
		waitForPageLoad(selenium);		
		assertTrue(DeleteCustomComponenetInEditDefalutPage(selenium),"Could not delete Custom component in Edit Default Template Page", selenium, ClassName, MethodName);
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
		assertTrue(createNewPatientWithMandatory(selenium,PatientData),"Could not create a patient", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-7:Search newly created Patient							 	  //
		//--------------------------------------------------------------------//		
		assertTrue(searchPatientNexiaForProviderHomePage(selenium,PatientData.lastName),"Could not select the created patient", selenium, ClassName, MethodName);
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
		assertTrue(EnterValueInWidget(selenium,encounterTemplateTestData),"COuld not enter value in Widgets ", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,	lnkAllergy),"Could not click the encounter tab", selenium, ClassName, MethodName);
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_001";
		allergyData.fetchChartPreVisitTestData();
		waitForPageLoad(selenium);
		assertTrue(CreateAllergyForEncounterTemplate(selenium,allergyData,userAccount),"COuld not enter value in Widgets ", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(getValue(selenium,txtwidgettextarea).contains(encounterTemplateTestData.SectionName),"COuld not find the text", selenium, ClassName, MethodName);
		assertTrue(isChecked(selenium, chkQuestionWidget),"Could not type the lable name", selenium, ClassName, MethodName);	
		assertTrue(getValue(selenium,btnValue).contains(encounterTemplateTestData.Minvalue),"COuld not find the text", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	}
		catch (Exception e)
		{
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);	
		}
			return true;	
		}
		
	
	public boolean EnterValueInWidget(Selenium selenium,ClinicalSettingLib encounterTemplateTestData) throws IOException
	{
		assertTrue(type(selenium, txtwidgettextarea,encounterTemplateTestData.SectionName),"Could not type the lable name", selenium, ClassName, MethodName);	
		selenium.fireEvent(txtwidgettextarea, "blur");
		assertTrue(type(selenium, btnValue,encounterTemplateTestData.Minvalue),"Could not type the lable name", selenium, ClassName, MethodName);
		selenium.fireEvent(txtwidgettextarea, "blur");
		assertTrue(click(selenium, chkQuestionWidget),"Could not type the lable name", selenium, ClassName, MethodName);	
		selenium.fireEvent(txtwidgettextarea, "blur");
		return true;
		
	}

	public boolean CreateAllergyForEncounterTemplate(Selenium selenium,ChartPreVisitLib allergyData,String userAccount) throws IOException {
		if (userAccount.equalsIgnoreCase(CAAccount)) {
			assertTrue(selectValueFromAjaxList(selenium, ajxAllergySuggestBox,allergyData.allergenCa),"Could not select",selenium, ClassName, MethodName);	
		} else {
			assertTrue(selectValueFromAjaxList(selenium, ajxAllergySuggestBox,allergyData.allergen),"Could not select",selenium, ClassName, MethodName);	
		}
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkReaction),"Could not on show more button",selenium, ClassName, MethodName);			
		waitForPageLoad(selenium);
		assertTrue(click(selenium, chkfirst),"Could not on show more button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnpopclose),"Could not on show more button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxSeverity,allergyData.severity),"Could not on show more button",selenium, ClassName, MethodName);	
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxStatus, allergyData.status),"Could not select",selenium, ClassName, MethodName);	
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnAdd),"Could not click the add button;More details:"+ allergyData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
}

	

}
