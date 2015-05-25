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

public class VerifyMedicationPreview extends AbstractCdmFlowSheets {
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Preview medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationPreviewButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_031";
		mcTemplate.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyMedicationPreviewButton(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Medication drug class")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationDrugClassPreview(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_031";
		mcTemplate.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyMedicationDrugClassPreview(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
		/*************************************************************************************************** 
		* @purpose        Verify medication preview button
		* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
		* @action 		  Verifying Click preview medication
		* @author         AspireQA
		* @throws 		  IOException 
		* @state          Developing
		* @useraccount    Both
		* @since  	      Jun 25, 2014
		***************************************************************************************************/
		
		public boolean verifyMedicationPreviewButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
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
				//  Step-4: Add Managed Care Template					      		  //
				//--------------------------------------------------------------------//
				cal=Calendar.getInstance();
				dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
				uniqueName=dateFormat.format(cal.getTime());
				assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate,uniqueName),"Template creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5: Verify Medication preview						          //
				//--------------------------------------------------------------------//
				assertTrue(verifyPreviewMedicationButton(selenium,mcTemplate,uniqueName,userAccount),"Template creation failed", selenium, ClassName, MethodName);

			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}	
		return returnValue;
		}
		
		/*************************************************************************************************** 
		* @purpose        Test for Verifying Medication drug class Preview
		* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
		* @action 		  Test for Verifying Medication drug class
		* @author         AspireQA
		* @throws 		  IOException 
		* @state          Developing
		* @useraccount    Both
		* @since  	      Jun 25, 2014
		***************************************************************************************************/
		
		public boolean verifyMedicationDrugClassPreview(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
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
				//  Step-4: Add Managed Care Template					      		  //
				//--------------------------------------------------------------------//
				cal=Calendar.getInstance();
				dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
				uniqueName=dateFormat.format(cal.getTime());
				assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate,uniqueName),"Template creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5: Verify Medication Class preview						          //
				//--------------------------------------------------------------------//
				assertTrue(verifyPreviewMedicationClass(selenium,mcTemplate,uniqueName,userAccount),"Template creation failed", selenium, ClassName, MethodName);
				
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}	
		return returnValue;
		}
	}

