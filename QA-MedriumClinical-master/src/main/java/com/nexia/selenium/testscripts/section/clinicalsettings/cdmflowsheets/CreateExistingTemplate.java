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

public class CreateExistingTemplate extends AbstractCdmFlowSheets {
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing add existing manage care template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_004";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		createManagedCareTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
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
	
	public boolean createManagedCareTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
		Selenium selenium=null;
		boolean returnValue= true;
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
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createManagedCareTemplateWithMandatory(selenium,mcTemplate,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Created Managed Care Template			          //
			//--------------------------------------------------------------------//
			assertTrue(verifyCreatedManagedCareTemplate(selenium,mcTemplate,uniqueName),"Details are incorrect"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-7: Create Existing Template            			          //
			//--------------------------------------------------------------------//
	
			assertTrue(selectValueFromAjaxList(selenium,ajxTemplateType,"Managed Care"),"Could not select template type", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnCreateCustom), "Could not click on create button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkApplyExistingTemplate), "Could not click on existing template link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium, txtSearch,mcTemplate.templateName+uniqueName), "Could not click on existing template link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, "link="+mcTemplate.templateName+uniqueName), "Could not click on searched item from the list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Preview          			                      //
			//--------------------------------------------------------------------//
			
			assertTrue(selenium.isTextPresent("Practice template"),"Practice template text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Practice template"),"Practice template text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Medications"),"Medication text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Display all medications"),"Medication text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Allergies"),"Allergies text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Risk Factors"),"Risk Factors text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Flowsheet"),"Flowsheet text is not present", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium, btnUseThis), "Could not click on use this icon", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName1=DateFormat1.format(cal1.getTime());
			assertTrue(createManagedCareTemplateWithMandatory(selenium,mcTemplate,uniqueName1),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify Created Managed Care Template			          //
			//--------------------------------------------------------------------//
			assertTrue(verifyCreatedManagedCareTemplate(selenium,mcTemplate,uniqueName),"Details are incorrect"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}	
	return returnValue;
	}
}
