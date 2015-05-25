package com.nexia.selenium.testscripts.section.clinicalsettings.cdmflowsheets;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractCdmFlowSheets;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySortOfManagedCareTemplate extends AbstractCdmFlowSheets{
	@Test(groups = {"SingleThread","Regression","Approved","SingleThread","firefox", "iexplore", "safari", "default" }, description = "Test to verify the sort options in Managed Care List filters.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySortOfManagedCareTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_048";
		mcTemplate.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    verifySort(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify the sort options in Managed Care List filters.
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying the sort options in Managed Care List filters
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 11, 2014
	***************************************************************************************************/
	
	public boolean verifySort(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
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
			//  Step-4: Delete Existing Managed Care Template						          //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllManagedCareTemplate(selenium,mcTemplate),"Deletion Failed:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Managed Care Template						          //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=dateFormat.format(cal.getTime());
			assertTrue(createManagedCareTemplateWithMandatory(selenium,mcTemplate,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ClinicalSettingLib mcTemplate1 = new ClinicalSettingLib();
			mcTemplate1.workSheetName = "ManagedCaredTemplate";
			mcTemplate1.testCaseId = "TC_MCT_049";
			mcTemplate1.fetchClinicalSettingsTestData();
			assertTrue(createManagedCareTemplateWithMandatory(selenium,mcTemplate1,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ClinicalSettingLib mcTemplate2 = new ClinicalSettingLib();
			mcTemplate2.workSheetName = "ManagedCaredTemplate";
			mcTemplate2.testCaseId = "TC_MCT_050";
			mcTemplate2.fetchClinicalSettingsTestData();
			assertTrue(createManagedCareTemplateWithMandatory(selenium,mcTemplate2,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Sort with Template Name  				          //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxsortCriteria,"Template name"),"Could not select Sort option", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,lblTemplateDetails+"["+1+"]").contains(mcTemplate.templateName+uniqueName),"Text not present", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblTemplateDetails+"["+2+"]").contains(mcTemplate1.templateName+uniqueName),"Text not present", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblTemplateDetails+"["+3+"]").contains(mcTemplate2.templateName+uniqueName),"Text not present", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-7: Verify Sort with Template Description  			          //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxsortCriteria,"Description"),"Could not select Sort option", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,lblTemplateDetails+"["+1+"]").contains(mcTemplate.templateName+uniqueName),"Text not present", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblTemplateDetails+"["+2+"]").contains(mcTemplate1.templateName+uniqueName),"Text not present", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblTemplateDetails+"["+3+"]").contains(mcTemplate2.templateName+uniqueName),"Text not present", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-8: Verify Sort with Template Created date 			          //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxsortCriteria,"Created date"),"Could not select Sort option", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,lblTemplateDetails+"["+1+"]").contains(mcTemplate2.templateName+uniqueName),"Text not present", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblTemplateDetails+"["+2+"]").contains(mcTemplate1.templateName+uniqueName),"Text not present", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblTemplateDetails+"["+3+"]").contains(mcTemplate.templateName+uniqueName),"Text not present", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-9: Verify Sort with Template Creator   			          //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxsortCriteria,"Creator"),"Could not select Sort option", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,lblTemplateDetails+"["+1+"]").contains(mcTemplate.templateName+uniqueName),"Text not present", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblTemplateDetails+"["+2+"]").contains(mcTemplate1.templateName+uniqueName),"Text not present", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblTemplateDetails+"["+3+"]").contains(mcTemplate2.templateName+uniqueName),"Text not present", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-10: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,mcTemplate.patientId),"Patient search failed",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11: Navigate to Managed Care  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCloseTemplate), "Could not click on Close ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate2,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCloseTemplate), "Could not click on Close ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate1,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCloseTemplate), "Could not click on Close ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: Verify Alphabetical arrangemnet of Template <name>        //
			//--------------------------------------------------------------------//
			assertTrue(getText(selenium,lblTemplate1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(mcTemplate.templateName.trim().toLowerCase(new java.util.Locale("en","Us"))),"Template name is not present", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblTemplate2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(mcTemplate1.templateName.trim().toLowerCase(new java.util.Locale("en","Us"))),"Template name is not present", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblTemplate3).toLowerCase(new java.util.Locale("en","Us")).trim().contains(mcTemplate1.templateName.trim().toLowerCase(new java.util.Locale("en","Us"))),"Template name is not present", selenium, ClassName, MethodName);

			
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}
