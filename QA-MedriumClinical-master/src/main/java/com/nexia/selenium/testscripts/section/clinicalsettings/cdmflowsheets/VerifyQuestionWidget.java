package com.nexia.selenium.testscripts.section.clinicalsettings.cdmflowsheets;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractCdmFlowSheets;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyQuestionWidget extends AbstractCdmFlowSheets{
	@Test(groups = {"SingleThread","Regression","Approved","SingleThread","firefox", "iexplore", "safari", "default" }, description = "Test to verify the Question Widget.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyQuestionWidget(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_036";
		mcTemplate.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTreatmentTarget(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","SingleThread","firefox", "iexplore", "safari", "default" }, description = "Test to verify the Question Widget With Display All Answers in One Cell.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDisplayAllAnswersInOneCell(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_041";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		verifyQuestionWidgets(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}

	@Test(groups = {"SingleThread","Regression","Approved","SingleThread","firefox", "iexplore", "safari", "default" }, description = "Test to verify the Question Widget with Display Answers As Seperate Rows.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDisplayAnswersAsSeparateRows(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_042";
		mcTemplate.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyQuestionWidgets(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}


	/*************************************************************************************************** 
	* @purpose        To verify the Question Widget.
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying Question Widget
	* @author         AspireQA
	* @throws 		  IOException 
	 * @throws InterruptedException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 30, 2014
	***************************************************************************************************/
	
	public boolean verifyTreatmentTarget(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException, InterruptedException{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mcTemplate.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, mcTemplate.userName, mcTemplate.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role 									  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,mcTemplate.switchRole),"Could not change the switch role;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter Template 							  //
			//--------------------------------------------------------------------//
			ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
			encounterTemplateTestData.workSheetName = "CreateVisitSection";
			encounterTemplateTestData.testCaseId = "TC_VS_003";
			encounterTemplateTestData.fetchClinicalSettingsTestData();		
			AbstractClinicalSettings obj= new AbstractClinicalSettings();
			assertTrue(obj.navigateToEncounterTemplate(selenium),"Navigation to encounter template Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create a Custom section with widget 					  //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxTemplateType,"Visit Section"),"Selecting Custom section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(obj.DeleteAllCustomSection(selenium),"Deletion of Visition Section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(obj.CreateVisitSectionWithWidget(selenium,encounterTemplateTestData),"Deletion of Visition Section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSectionSave), "Could not click Select all check box in Section page custom section save",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, obj.lnkEncounterTemplate), "Could not click on encounter template link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Managed Care Template						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareTemplate(selenium),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Managed Care Template			          //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllManagedCareTemplate(selenium,mcTemplate),"Deletion Failed:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Managed Care Template						          //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(addQuestionWidgetCareElement(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Add Same Care element and check Duplication Warning       //
			//--------------------------------------------------------------------//
			mcTemplate.workSheetName = "ManagedCaredTemplate";
			mcTemplate.testCaseId = "TC_MCT_043";
			mcTemplate.fetchClinicalSettingsTestData();
			assertTrue(addQuestionWidgetCareElement(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveWhole),"could ot click save", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-7: Advanced search with Patient ID                           //
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,mcTemplate.patientId);
			waitForPageLoad(selenium);
			assertTrue(obj.goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);  
			assertTrue(click(selenium,lnkSummary),"Could not click the Summary tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Managed Care and give widget value            //
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnOption),"Could not click the Option link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnRecordData),"Could not click the Record button link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chkWidget),"Could not click the chk widget", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSign),"Could not click the sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-9: Verify Color of font                                      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkMore), "Could not click on more link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkFlowSheets), "Could not click on flow sheets link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkViewEdit), "Could not click on view link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.getAttribute(lblValue).toLowerCase(new java.util.Locale("en","Us")).trim().contains("red".trim().toLowerCase(new java.util.Locale("en","Us"))),"Font is not in Red", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-10: Change Target Value and Verify Color of font              //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkFlowSheet),"Could not click the Flow sheet link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxCategory,mcTemplate.heightLowerLimit),"Selecting Category  failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveWhole),"Could not click the Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!selenium.getAttribute(lblValue).toLowerCase(new java.util.Locale("en","Us")).trim().contains("red".trim().toLowerCase(new java.util.Locale("en","Us"))),"Font is in red", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-11: Verify Print                                             //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnPrint),"Could not click on Print", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnClosePrint),"Could not click on Close button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify the Question Widget with more than one response.
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying Question Widget
	* @author         AspireQA
	* @throws 		  IOException 
	 * @throws InterruptedException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 06, 2014
	***************************************************************************************************/
	
	public boolean verifyQuestionWidgets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException, InterruptedException{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mcTemplate.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, mcTemplate.userName, mcTemplate.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role 									  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,mcTemplate.switchRole),"Could not change the switch role;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter Template 							  //
			//--------------------------------------------------------------------//
			ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
			encounterTemplateTestData.workSheetName = "CreateVisitSection";
			encounterTemplateTestData.testCaseId = "TC_VS_003";
			encounterTemplateTestData.fetchClinicalSettingsTestData();		
			AbstractClinicalSettings obj= new AbstractClinicalSettings();
			assertTrue(obj.navigateToEncounterTemplate(selenium),"Navigation to encounter template Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create a Custom section with widget 					  //
			//--------------------------------------------------------------------//
			
			assertTrue(selectValueFromAjaxList(selenium,ajxTemplateType,"Visit Section"),"Selecting Custom section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(obj.DeleteAllCustomSection(selenium),"Deletion of Visition Section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(obj.CreateVisitSectionWithWidget(selenium,encounterTemplateTestData),"Deletion of Visition Section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSectionSave), "Could not click Select all check box in Section page custom section save",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, obj.lnkEncounterTemplate), "Could not click on encounter template link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Managed Care Template						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareTemplate(selenium),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Managed Care Template			          //
			//--------------------------------------------------------------------//
		//	assertTrue(deleteAllManagedCareTemplate(selenium,mcTemplate),"Deletion Failed:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Managed Care Template						          //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(addQuestionWidgetWithMultipleResponses(selenium,encounterTemplateTestData,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveWhole),"could ot click save", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID                           //
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,mcTemplate.patientId);
			waitForPageLoad(selenium);
			assertTrue(obj.goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);  
			assertTrue(click(selenium,lnkSummary),"Could not click the Summary tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Managed Care and give widget value            //
			//--------------------------------------------------------------------//
			
			assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnOption),"Could not click the Option link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnRecordData),"Could not click the Record button link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chkWidget),"Could not click the chk widget", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chkWidget2),"Could not click the chk widget2", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAction),"Could not click the Action button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveEncounter),"Could not click the Save Encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Color of font                                      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkMore), "Could not click on more link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkFlowSheets), "Could not click on flow sheets link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkViewEdit), "Could not click on view link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify all answers are in same cell                                      //
			//--------------------------------------------------------------------//
			if(mcTemplate.testCaseId.equals("TC_MCT_041")){
			assertTrue(getText(selenium,lblEncounterValue).toLowerCase(new java.util.Locale("en","Us")).trim().contains(mcTemplate.heightUpperLimit.trim().toLowerCase(new java.util.Locale("en","Us"))),"Value1 is not present", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblEncounterValue).toLowerCase(new java.util.Locale("en","Us")).trim().contains(mcTemplate.heightLowerLimit.trim().toLowerCase(new java.util.Locale("en","Us"))),"Value2 is not present", selenium, ClassName, MethodName);
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

