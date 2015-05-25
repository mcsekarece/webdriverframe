package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityForEncounterTeamplate extends AbstractClinicalSettings {
    @Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Mixed security role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib cdsData = new ClinicalSettingLib();
		cdsData.workSheetName = "VerifySecurityOption";
		cdsData.testCaseId = "TC_VSP_005";
		cdsData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, cdsData);
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		IOException 
	 * @since  	   	Nov 08, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib cdsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cdsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cdsData.userName, cdsData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,cdsData.switchRole),"Could not change the switch role;More Details:"+cdsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_021";
			userRoleData.fetchSystemSettingTestData();
			
			if(userRoleData.clinicalSetting.contains("No Access")){				
			    assertTrue(noAccessUserClinicalSetting(selenium, cdsData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);				
			}			
			
			//--------------------------------------------------------------------//
			//  Step-4: Full, View Access User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.clinicalSetting.contains("No Access")){
			    assertTrue(fullViewAccessUserClinicalSetting(selenium, cdsData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;				
			    
			    if(!verifySecurity(selenium,cdsData, userRoleData, userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ cdsData.toString());
				returnValue= false;
			    }else
				returnValue=true;
			}			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ClinicalSettingLib cdsData,SystemSettingsLib userRoleData, String userAccount) throws IOException{
		boolean returnValue=true;
		
		assertTrue(switchRole(selenium,"DFFullAccess"),"Could not change the switch role;More Details:"+cdsData.toString(), selenium, ClassName,MethodName);
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
		//assertTrue(switchRole(selenium,cdsData.switchRole),"Could not change the switch role;More Details:"+cdsData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-12: Navigate to Encounter Template 						  //
		//--------------------------------------------------------------------//
		assertTrue(navigateToEncounterTemplate(selenium),"Navigation to encounter template Failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(SearchAddedTemplateForoutline(selenium, encounterTemplateTestData),"Could not search the Added ENCOUNTER TEMPLATE", selenium, ClassName, MethodName);
		//Full Access Permission	
		if(userRoleData.encounterTemplates.contains("Full Access")){
			assertTrue(selenium.isElementPresent(btnAddNew),"Add encounter template not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isElementPresent(EncoEdit),"Edit encounter template not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isElementPresent("css=button.secondary-button.left-button-spacer"),"Delete encounter template not present",selenium, ClassName, MethodName);
			return returnValue;
		}
	
		//View Only Access Permission
		if(userRoleData.encounterTemplates.contains("View Only")){
			
			assertTrue(!selenium.isElementPresent(btnAddNew),"Add encounter template not present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(EncoEdit),"Edit encounter template not present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent("css=button.secondary-button.left-button-spacer"),"Delete encounter template not present",selenium, ClassName, MethodName);
			return returnValue;
		}
		 
		//Limited Access Permission
		if(userRoleData.encounterTemplates.contains("Limited Access")){

			assertTrue(selenium.isElementPresent(btnAddNew),"Add encounter template not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isElementPresent(EncoEdit),"Edit encounter template not present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent("css=button.secondary-button.left-button-spacer"),"Delete encounter template not present",selenium, ClassName, MethodName);
			return returnValue;
		}
		
		//No Access Permission
		if(userRoleData.encounterTemplates.contains("No Access")){
		    assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkClinicalSettingsLink), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkEncounterTemplate), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblHeader).contains("Encounter Templates")){
			    returnValue= false;
			 }else
			    return returnValue;
		}
		
		return returnValue;
	}
}