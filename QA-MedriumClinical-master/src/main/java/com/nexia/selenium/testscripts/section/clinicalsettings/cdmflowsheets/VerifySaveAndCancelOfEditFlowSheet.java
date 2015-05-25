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

public class VerifySaveAndCancelOfEditFlowSheet extends AbstractCdmFlowSheets{
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify the save actions on Edit Flow Sheet.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveEditFlowSheet(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_028";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		verifySaveAndCancelOfEditFlowSheet(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify the cancel actions on Edit Flow Sheet.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelEditFlowSheet(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_029";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		verifySaveAndCancelOfEditFlowSheet(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	

	/*************************************************************************************************** 
	* @purpose        To verify the save and cancel actions on Edit Flow Sheet.
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying save and cancel actions on Edit Flow Sheet
	* @author         AspireQA
	* @throws 		  IOException 
	 * @throws InterruptedException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 27, 2014
	***************************************************************************************************/
	
	public boolean verifySaveAndCancelOfEditFlowSheet(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException, InterruptedException{
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
			encounterTemplateTestData.testCaseId = "TC_VS_004";
			encounterTemplateTestData.fetchClinicalSettingsTestData();		
			AbstractClinicalSettings obj= new AbstractClinicalSettings();
			assertTrue(obj.navigateToEncounterTemplate(selenium),"Navigation to encounter template Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create a Custom section with widget 					  //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxTemplateType,"Visit Section"),"Selecting Custom section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(obj.CreateVisitSectionWithWidget(selenium,encounterTemplateTestData),"Deletion of Visition Section failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSectionSave), "Could not click Select all check box in Section page custom section save",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Managed Care Template						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareTemplate(selenium),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Managed Care Template						          //
			//--------------------------------------------------------------------//
			//assertTrue(deleteAllManagedCareTemplate(selenium,mcTemplate),"Deletion Failed:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Managed Care Template						          //
			//--------------------------------------------------------------------//
			ClinicalSettingLib mcTemplate1 = new ClinicalSettingLib();
			mcTemplate1.workSheetName = "ManagedCaredTemplate";
			mcTemplate1.testCaseId = "TC_MCT_022";
			mcTemplate1.fetchClinicalSettingsTestData();
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=dateFormat.format(cal.getTime());
			assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate1,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(addCustomWidgetCareElement(selenium,mcTemplate1,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
									
			assertTrue(click(selenium,btnSaveWhole),"could ot click save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,mcTemplate.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Managed Care//
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkFlowSheet),"Could not click the Flow sheet;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			//--------------------------------------------------------------------//
			//  Step-8: add Custom Widget Care Element in patient chart 
			//--------------------------------------------------------------------//
			assertTrue(addCustomWidgetCareElementInPatientChart(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(mcTemplate.testCaseId.equals("TC_MCT_028")){
				assertTrue(verifySaveFlowSheet(selenium,mcTemplate,uniqueName,userAccount),"Save failed", selenium, ClassName, MethodName);
			}
			else
			{
				assertTrue(verifyCancelFlowSheet(selenium,mcTemplate,uniqueName,userAccount),"Cancel failed", selenium, ClassName, MethodName);
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
}
	
			public boolean verifySaveFlowSheet(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String account) throws IOException{
				assertTrue(click(selenium,btnSaveWhole),"could ot click Save", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
												
				assertTrue(isTextPresent(selenium,mcTemplate.display),"Text not present", selenium, ClassName, MethodName);
				
				assertTrue(click(selenium,lnkCloseTemplate),"could not click close", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,lnkRemove),"could not click Remove", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnYes),"could not click Yes", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(!isTextPresent(selenium,mcTemplate.templateName+uniqueName),"Text present", selenium, ClassName, MethodName);
				
				return true;
			}
			
		public boolean verifyCancelFlowSheet(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String account) throws IOException{
			assertTrue(click(selenium,btncancel),"could ot click cancel", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!isTextPresent(selenium,mcTemplate.display),"Text present", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkCloseTemplate),"could not click close", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkRemove),"could not click Remove", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNo),"could not click No", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isTextPresent(selenium,mcTemplate.templateName+uniqueName),"Text present", selenium, ClassName, MethodName);
			
				return true;
			}
}
