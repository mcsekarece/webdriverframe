package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyVisitTypePrompt extends AbstractClinicalSettings{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing visit type prompt")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void visitTypePrompt(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_017";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyvisitTypePrompt(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify visit Type Prompt
	* @Specification  SRS_EMR_Encounter_Structure_Templates Rev0.0
	* @action 		  Verifying visit Type Prompt
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @defect		  #7800	
	* @useraccount    Both
	* @since  	      Sep 25, 2013
	***************************************************************************************************/
	public boolean verifyvisitTypePrompt(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib encounterTemplateTestData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterTemplateTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterTemplateTestData.userName, encounterTemplateTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role 									  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,encounterTemplateTestData.switchRole),"Could not change the switch role;More Details:"+encounterTemplateTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			AbstractSchedulingTest visitData = new AbstractSchedulingTest();
			
			SchedulingTestLib visitType = new SchedulingTestLib();
			visitType.workSheetName = "CreateVisittype";
			visitType.testCaseId = "TC_VT_001";
			visitType.fetchSchedulingTestData();
			
			//--------------------------------------------------------------------//
			//  Step-3:Naviagte to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(visitData.goToScheduling(selenium),"Could not Navigate to Scheduling section",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Naviagte to Visit Type							          //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,visitData.lnkVisitType),"could not click the Visit Type Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Create Visit type							      		  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,visitData.btnAdd),"Could not click on add new button",selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(visitData.createVisitType(selenium,visitType,uniqueName),"Create visit type is failled",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Encounter Template 							  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToEncounterTemplate(selenium),"Navigation to encounter template Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Delete All Encounter Template 							  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllEncounterTemplate(selenium),"Could not Delete All Encounter Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
						
			//--------------------------------------------------------------------//
			//  Step-7: Add new Encounter Template 								  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNew), "Could not click on add new button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtTemplateName, encounterTemplateTestData.templateName), "Could not type template name", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAreaTemplateDescription, encounterTemplateTestData.templateDescription), "Could not type template description", selenium, ClassName, MethodName);
			
			//It will be used for get the very first value of the visit type from the list
			assertTrue(click(selenium, ajxassociatedVisit), "Could not click ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(selectValueFromAjaxList(selenium,ajxassociatedVisit,visitType.visitName+uniqueName),"Could not select visit type"+visitType.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkStartBlank), "Could not click start blank template name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Naviagte to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(visitData.goToScheduling(selenium),"Could not Navigate to Scheduling section",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9:Naviagte to Visit Type							          //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,visitData.lnkVisitType),"could not click the Visit Type Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10:Delete Created Visit Type							     //
			//--------------------------------------------------------------------//
			
			selectValueFromAjaxList(selenium,visitData.txtSearchType,visitType.visitName+uniqueName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,visitData.btnDelete),"could not click the delete button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11:							     //
			//--------------------------------------------------------------------//
			if(!verifyPromptDetails(selenium,visitType,uniqueName )){
				Assert.fail("Prompt Details are not getting displayed");
			}

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyPromptDetails(Selenium selenium,SchedulingTestLib visitType, String uniqueName){
	
		if(!isElementPresent(selenium,"css=div.popupContent > div")){
			return false;
		}
		if(!selenium.isTextPresent("The selected visit type is used on the following encounter template(s).")){
			return false;
		}
		
		if(!selenium.isTextPresent(visitType.visitName+uniqueName)){
			return false;
		}
		
		if(!selenium.isTextPresent("System will not delete the selected visit type until it is no longer in use.")){
			return false;
		}
		return true;
	}
}
