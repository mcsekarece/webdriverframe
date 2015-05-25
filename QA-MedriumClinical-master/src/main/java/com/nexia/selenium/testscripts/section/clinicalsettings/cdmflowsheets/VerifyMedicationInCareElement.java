package com.nexia.selenium.testscripts.section.clinicalsettings.cdmflowsheets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractCdmFlowSheets;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMedicationInCareElement extends AbstractCdmFlowSheets {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing add existing manage care template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationInManagedCare(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_004";
		mcTemplate.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyMedicationInCare(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing add existing manage care template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationClassInManagedCare(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_004";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		verifyMedicationClassInCare(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To verify add manage care template
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying add action for manage care template
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Jun 25, 2014
	***************************************************************************************************/
	
	public boolean verifyMedicationInCare(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
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
			//  Step-3: Navigate to Managed Care Template						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareTemplate(selenium),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create managed care template with mandatory		          //
			//--------------------------------------------------------------------//
			cal=Calendar.getInstance();
			dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			uniqueName=dateFormat.format(cal.getTime());
			assertTrue(createManagedCareTemplateWithMandatory(selenium,mcTemplate,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
									
			//--------------------------------------------------------------------//
			//  Step-5: Create Patient with mandatory datum					      //
			//--------------------------------------------------------------------//
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_002";
			patientData.fetchHomeTestData();
			assertTrue(createNewPatientWithMandatoryFields(selenium,patientData),"Mandatory patient cration failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patId = getText(selenium, "patientID");
						
			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount)){
				searchPatientNexiaForProviderHomePage(selenium,patId);
				waitForPageLoad(selenium);
				}
				else{
					USsearchPatientGotoChart(selenium,patId);
					waitForPageLoad(selenium);
				}

			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Managed Care flow sheet in Patient Chart	and edit FlowSheet  // 
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,"No flowsheet data found"),"Care Element is not present", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkFlowSheet),"Could not click the Flow sheet;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnAdd1), "Could not click on Add button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,ajxCategory),"could ot click category", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"currentItem_1"),"could ot click option", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtCategoryName,mcTemplate.category),"Could not type the last name : More Details"+mcTemplate.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSaveCategoryName),"could ot click save1", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxCategory,mcTemplate.category),"Could not select category", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtDisplayAs,mcTemplate.display), "Could not type display as", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxCareElementPanelsuggestBox,"Medications"),"Could not select custom widget", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createSpecifiedMedicationInFlowSheet(selenium,mcTemplate,userAccount),"Specified medication creation failed", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium, btnSaveCare), "Could not click save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveWhole),"Could not click Save;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isTextPresent(selenium,mcTemplate.usDrugClassName1),"Text is Not present", selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	public boolean verifyMedicationClassInCare(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
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
			//  Step-3: Navigate to Managed Care Template						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareTemplate(selenium),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create managed care template with mandatory		          //
			//--------------------------------------------------------------------//
			cal=Calendar.getInstance();
			dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			uniqueName=dateFormat.format(cal.getTime());
			assertTrue(createManagedCareTemplateWithMandatory(selenium,mcTemplate,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
									
			//--------------------------------------------------------------------//
			//  Step-5: Create Patient with mandatory datum					      //
			//--------------------------------------------------------------------//
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_002";
			patientData.fetchHomeTestData();
			assertTrue(createNewPatientWithMandatoryFields(selenium,patientData),"Mandatory patient cration failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patId = getText(selenium, "patientID");
			
			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount)){
				searchPatientNexiaForProviderHomePage(selenium,patId);
				waitForPageLoad(selenium);
				}
				else{
					USsearchPatientGotoChart(selenium,patId);
					waitForPageLoad(selenium);
				}

			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Managed Care flow sheet in Patient Chart	and edit FlowSheet  // 
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,"No flowsheet data found"),"Care Element is not present", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkFlowSheet),"Could not click the Flow sheet;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnAdd1), "Could not click on Add button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,ajxCategory),"could ot click category", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"currentItem_1"),"could ot click option", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtCategoryName,mcTemplate.category),"Could not type the last name : More Details"+mcTemplate.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSaveCategoryName),"could ot click save1", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxCategory,mcTemplate.category),"Could not select category", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtDisplayAs,mcTemplate.display), "Could not type display as", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxCareElementPanelsuggestBox,"Medications"),"Could not select custom widget", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createSpecifiedMedicationClassInFlowSheet(selenium,mcTemplate,userAccount),"Specified medication creation failed", selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSaveCare), "Could not click save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveWhole),"Could not click Save;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isTextPresent(selenium,mcTemplate.usDrugClassName1),"Text is Not present", selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}


}

