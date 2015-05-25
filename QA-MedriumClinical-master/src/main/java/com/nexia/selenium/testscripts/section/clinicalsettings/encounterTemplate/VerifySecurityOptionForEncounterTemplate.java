package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForEncounterTemplate extends AbstractClinicalSettings {

	//#5963 - Defect: Encounter Template: User can able to delete the Encounter template, while user have view only and Limited permission role.
	@Test(groups = {"AdvancedSmoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Encounter Template With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterTemplateWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib verifySecurityObj = new  ClinicalSettingLib();
		verifySecurityObj.workSheetName = "VerifySecurityOption";
		verifySecurityObj.testCaseId = "TC_VSP_004";
		verifySecurityObj.fetchClinicalSettingsTestData();				
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		//encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,verifySecurityObj);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Encounter Template With No Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterTemplateWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClinicalSettingLib verifySecurityObj = new  ClinicalSettingLib();
		verifySecurityObj.workSheetName = "VerifySecurityOption";
		verifySecurityObj.testCaseId = "TC_VSP_001";
		verifySecurityObj.fetchClinicalSettingsTestData();				
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		//encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,verifySecurityObj);
	}

	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Encounter Template With Full Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterTemplateWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClinicalSettingLib verifySecurityObj = new  ClinicalSettingLib();
		verifySecurityObj.workSheetName = "VerifySecurityOption";
		verifySecurityObj.testCaseId = "TC_VSP_002";
		verifySecurityObj.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		//encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,verifySecurityObj);
	}
	
	//#5963 - Defect: Encounter Template: User can able to delete the Encounter template, while user have view only and Limited permission role.
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Encounter Template With View Only Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterTemplateWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClinicalSettingLib verifySecurityObj = new  ClinicalSettingLib();
		verifySecurityObj.workSheetName = "VerifySecurityOption";
		verifySecurityObj.testCaseId = "TC_VSP_003";
		verifySecurityObj.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		//encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,verifySecurityObj);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Encounter Template
	* @action 		  verifying Security Option For Encounter Template
	* @expected       To Ensure that security option works fine for Encounter Template  
	* @author         Aspire QA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 26, 2013
	***************************************************************************************************/

	public boolean encounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ClinicalSettingLib verifySecurityObj) throws Exception{
		Selenium selenium = null;
		boolean returnValue= true;
		try{
			
			//--------------------------------------------------------------------//
			// Step 1:Login to the application									  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + verifySecurityObj.toString());
			
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, verifySecurityObj.userName, verifySecurityObj.userPassword),"Login Failed ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Verify Security				   							  //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,verifySecurityObj,userAccount)){
				Assert.fail("Security for" +verifySecurityObj.switchRole+ "is not proper:"+ verifySecurityObj.toString());
			}else
				return returnValue;
			
		}			
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + verifySecurityObj.toString(), selenium, ClassName,MethodName);
		}
		return returnValue;
	}	

	public boolean verifySecurity(Selenium selenium, ClinicalSettingLib verifySecurityObj,String userAccount) throws Exception{
		boolean returnValue=true;
		
		//No Access Permission
		if(verifySecurityObj.testCaseId.equals("TC_VSP_001")){
			
			//--------------------------------------------------------------------//
			//  Step-3: Switch Role//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,verifySecurityObj.switchRole),"Could not change the switch role;More Details:"+verifySecurityObj.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkQuickAction),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkClinicalSettingsLink), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, lnkEncounterTemplate)){
				return false;
			}
		}else{
			//--------------------------------------------------------------------//
			//  Step-3: Switch Role//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,"DFFullAccess"),"Could not change the switch role;More Details:"+verifySecurityObj.toString(), selenium, ClassName,MethodName);
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
			ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
			encounterTemplateTestData.workSheetName = "EncounterTemplate";
			encounterTemplateTestData.testCaseId = "TC_ET_001";
			encounterTemplateTestData.fetchClinicalSettingsTestData();
			
			assertTrue(addEncounterTemplate(selenium, encounterTemplateTestData),"Could not add new Encounter Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify the encounter template values in summary page      //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValuesEncounterTemplate(selenium, encounterTemplateTestData),"Verification failed for added encounter template in summary page", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-11: Switch Role//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,verifySecurityObj.switchRole),"Could not change the switch role;More Details:"+verifySecurityObj.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-12: Navigate to Encounter Template 						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToEncounterTemplate(selenium),"Navigation to encounter template Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Full Access Permission	
			if(verifySecurityObj.testCaseId.equals("TC_VSP_002")){
				assertTrue(selenium.isElementPresent(btnAddNew),"Add encounter template not present",selenium, ClassName, MethodName);
				assertTrue(selenium.isElementPresent(lnkEdit),"Edit encounter template not present",selenium, ClassName, MethodName);
				assertTrue(selenium.isElementPresent(lnkDeleteEncounterTemplate),"Delete encounter template not present",selenium, ClassName, MethodName);
			}
		
			//View Only Access Permission
			if(verifySecurityObj.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(!selenium.isElementPresent(btnAddNew),"Add encounter template not present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isElementPresent(lnkEdit),"Edit encounter template not present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isElementPresent(lnkDeleteEncounterTemplate),"Delete encounter template not present",selenium, ClassName, MethodName);
				
				//-------------------------------------------------------------------------------------//
				//  Step-13: verify the Encounter Template values in summary page For First Patient   //
				//-------------------------------------------------------------------------------------//
				assertTrue(verifyStoreValuesEncounterTemplate(selenium, encounterTemplateTestData),"Verification failed for added encounter template in summary page", selenium, ClassName, MethodName);
					
			}
			 
			//Limited Access Permission
			if(verifySecurityObj.testCaseId.equals("TC_VSP_004")){

				assertTrue(selenium.isElementPresent(btnAddNew),"Add encounter template not present",selenium, ClassName, MethodName);
				assertTrue(selenium.isElementPresent(lnkEdit),"Edit encounter template not present",selenium, ClassName, MethodName);
				assertTrue(selenium.isElementPresent(lnkDeleteEncounterTemplate),"Delete encounter template not present",selenium, ClassName, MethodName);
			}
		}
		
		return returnValue;
	}
		
}