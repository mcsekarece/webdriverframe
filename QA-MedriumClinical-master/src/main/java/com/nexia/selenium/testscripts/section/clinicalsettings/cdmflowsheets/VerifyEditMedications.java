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

public class VerifyEditMedications extends AbstractCdmFlowSheets {
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying specify current medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_005";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		createManagedCareTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying specify current delete medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_006";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		createManagedCareTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying specify current preview medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPreviewMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_007";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		createManagedCareTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying specify current cancel medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_008";
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
				assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-6: Verify specify current medications to include			              //
				//--------------------------------------------------------------------//
				
				assertTrue(addMedicationTotemplate(selenium,mcTemplate,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//Verfiy Delete
				if(mcTemplate.testCaseId.equals("TC_MCT_006")){
					assertTrue(click(selenium, btnDeleteMedication), "Could not click on delete button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if(userAccount.equals(CAAccount)){
					assertTrue(getValue(selenium,ajxMedicationName2).contains(mcTemplate.medicationName2),"Deleted entry still appears on the screen", selenium, ClassName, MethodName);
					}
					else{
						assertTrue(getValue(selenium,ajxMedicationName1).contains(mcTemplate.usmedicationName2),"Deleted entry still appears on the screen", selenium, ClassName, MethodName);	
					}
					return true;
				}
				
				//Verify Preview
				if(mcTemplate.testCaseId.equals("TC_MCT_007")){
					assertTrue(click(selenium, btnPreview), "Could not click on Preview button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(isElementPresent(selenium, lnkClosePreview), "Could not click on close button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium, lnkClosePreview), "Could not click on close button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					return true;
				}
				
				//Verify Cancel
				if(mcTemplate.testCaseId.equals("TC_MCT_008")){
					assertTrue(click(selenium, lnkCancelMedication), "Could not click on Preview button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(isElementPresent(selenium, lnkEditMedications), "Could not find edit button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium, lnkEditMedications), "Could not click on close button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if(userAccount.equals(CAAccount)){
					assertTrue(!getValue(selenium,ajxMedicationName1).contains(mcTemplate.DrugClassName1),"Cancelled entry still appears on the screen", selenium, ClassName, MethodName);
					}
					else{
						assertTrue(!getValue(selenium,ajxMedicationName1).contains(mcTemplate.usDrugClassName1),"Cancelled entry still appears on the screen", selenium, ClassName, MethodName);	
					}
					return true;
				}
				assertTrue(isElementPresent(selenium, lnkEditMedications), "Could not find edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}	
		return returnValue;
		}
	}

