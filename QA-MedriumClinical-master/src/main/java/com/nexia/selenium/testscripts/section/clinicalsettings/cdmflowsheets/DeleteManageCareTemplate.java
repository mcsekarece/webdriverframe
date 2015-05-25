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

public class DeleteManageCareTemplate extends AbstractCdmFlowSheets {
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing delete manage care template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteManageCareTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_001";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		deleteManagedCareTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing cancel in delete manage care template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void cancelDeleteManageCareTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_002";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		deleteManagedCareTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Activating deleted manage care template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void activateDeletedManageCareTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_003";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		deleteManagedCareTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	

	/*************************************************************************************************** 
	* @purpose        To verify delete manage care template
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying delete action for manage care template
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Jun 25, 2014
	***************************************************************************************************/
	
	public boolean deleteManagedCareTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
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
			//  Step-7: Verify Delete Managed Care Template			          //
			//--------------------------------------------------------------------/
			if(!mcTemplate.testCaseId.equals("TC_MCT_002")){
				assertTrue(deleteAllManagedCareTemplate(selenium,mcTemplate),"Deletion Failed:"+mcTemplate.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(mcTemplate.testCaseId.equals("TC_MCT_003")){
					if(!isChecked(selenium,chkIncludeInactive)){
						assertTrue(click(selenium, chkIncludeInactive), "Could not check include inactive", selenium, ClassName, MethodName);
					}
					 waitForElement(selenium, btnActivates, WAIT_TIME*15);
					assertTrue(click(selenium, btnActivates), "Could not click on actiavte button", selenium, ClassName, MethodName);
					 waitForElement(selenium, btnDelete, WAIT_TIME*15);
					assertTrue(isElementPresent(selenium, btnDelete), "Could not click on delete button", selenium, ClassName, MethodName);
					assertTrue(isElementPresent(selenium, btnEdit), "Could not click on Edit button", selenium, ClassName, MethodName);
				}
				
				return true;
			}
			assertTrue(click(selenium, btnDelete), "Could not click on delete button", selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnNo), "Could not click on delete button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium, btnDelete), "Delete Cancellation is not working", selenium, ClassName, MethodName);
			
			
		}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}	
	return returnValue;
	}
}