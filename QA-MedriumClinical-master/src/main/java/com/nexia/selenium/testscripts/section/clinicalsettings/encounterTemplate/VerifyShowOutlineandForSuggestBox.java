package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyShowOutlineandForSuggestBox extends AbstractClinicalSettings{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Show outline and For Suggest box")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyShow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_001";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose       Test for Verifing Show outline and For Suggest box
	* @Specification  SRS_EMR_Encounter_Structure_Templates Rev0.0
	* @action 		  Verifing Show outline and For Suggest box
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	     June 20, 2014
	***************************************************************************************************/
	public boolean encounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib encounterTemplateTestData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
try
{
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
	
	// if we use the same template name, In inactive template list, very hard to find what we inactivated
	// So, We append current date to give unique name for template name
	String date =null;
	Calendar cal=Calendar.getInstance();
	SimpleDateFormat DateFormat;
	if(userAccount.equalsIgnoreCase(CAAccount)){
		DateFormat=new SimpleDateFormat("dd/MM/YYYY");
	}
	else{
		DateFormat=new SimpleDateFormat("MM/dd/YYYY");
	}
	date=DateFormat.format(cal.getTime());
	
	encounterTemplateTestData.templateName = encounterTemplateTestData.templateName +date;
	
	assertTrue(addEncounterTemplate(selenium, encounterTemplateTestData),"Could not add new Encounter Template", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	
	//--------------------------------------------------------------------//
	//  Step-6: verify the encounter template values in summary page      //
	//--------------------------------------------------------------------//
	assertTrue(verifyStoreValuesEncounterTemplate(selenium, encounterTemplateTestData),"Verification failed for added encounter template in summary page", selenium, ClassName, MethodName);

	//--------------------------------------------------------------------//
	//  Step-7: Veridy Foe and outline Filter   //
	//--------------------------------------------------------------------//
	assertTrue(type(selenium, txtSearch, encounterTemplateTestData.templateName), "Could not type template name", selenium, ClassName, MethodName);
	selenium.keyPress(txtSearch, "\\13");
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);
	if(selenium.getValue(ajxShowOutline).trim().contains("Anyone"))
	{
		returnValue=true;
	}
	else
	{
		returnValue=false;
	}
	assertTrue( selectValueFromAjaxList(selenium,ajxShowOutline,"Me"), "Could not Select value for Shoe Outline", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue( selectValueFromAjaxList(selenium,ajxFor,encounterTemplateTestData.Forvalue), "Could not Select value for Shoe Outline", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	String lblencountertemplate="templateFocusPanel";
	if(isElementPresent(selenium,lblencountertemplate))
	{
		selenium.click(lblencountertemplate);
	}
	else
	{
		Assert.fail("Serach result is not present");
	}
	//--------------------------------------------------------------------//
	//  Step-8:Verify Template										   //
	//--------------------------------------------------------------------//
	waitForPageLoad(selenium);
	assertTrue(VerifyTemplate(selenium,encounterTemplateTestData), "Could not Select value for Shoe Outline", selenium, ClassName, MethodName);
}
	catch(Exception e)
	{
	Assert.fail(e.getMessage());
	}
return returnValue;	
	}
	
	public boolean VerifyTemplate(Selenium selenium, ClinicalSettingLib encounterTemplateTestData) throws IOException	{
		assertTrue(selenium.isTextPresent(encounterTemplateTestData.templateName), "Could not find the texte", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(encounterTemplateTestData.visitType1), "Could not find the texte", selenium, ClassName, MethodName);
		return true;
	}
	}
