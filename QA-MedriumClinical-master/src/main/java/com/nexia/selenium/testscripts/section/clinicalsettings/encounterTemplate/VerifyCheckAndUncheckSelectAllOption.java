package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCheckAndUncheckSelectAllOption extends AbstractClinicalSettings{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing cancel in encounter template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void checkAndUncheckSelectAllOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_001";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCheckAndUncheckSelectAllOption(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify cancel in encounter template
	* @Specification  SRS_EMR_Encounter_Structure_Templates Rev0.0
	* @action 		  Verifying cancel in encounter template
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @defect 		  #7574	
	* @useraccount    Both
	* @since  	      Oct 01, 2013
	***************************************************************************************************/

	public boolean verifyCheckAndUncheckSelectAllOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib encounterTemplateTestData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterTemplateTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterTemplateTestData.userName, encounterTemplateTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role 									  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,encounterTemplateTestData.switchRole),"Could not change the switch role;More Details:"+encounterTemplateTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter Template 							  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToEncounterTemplate(selenium),"Navigation to encounter template Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: create Encounter Template						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNew), "Could not click on add new button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkStartBlank), "Could not click start blank template name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: create Encounter Template						  //
			//--------------------------------------------------------------------//
			if(!isChecked(selenium,chkPEAudit)){
				assertTrue(click(selenium,chkPEAudit), "Could not click Audlt check box", selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,lnkEditAudlt), "Could not click Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			// Check the select All check box 
			
			if(!isChecked(selenium,chkSelectAll)){
				assertTrue(click(selenium,chkSelectAll), "Could not click Audlt check box", selenium, ClassName, MethodName);
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Select all check box details					  //
			//--------------------------------------------------------------------//
			if(!verifySelectAllCheckBoxDetails(selenium)){
				Assert.fail("The check boxes are not selected");
			}
			
			if(isChecked(selenium,chkSelectAll)){
				assertTrue(click(selenium,chkSelectAll), "Could not click Audlt check box", selenium, ClassName, MethodName);
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Un Select all check box details					  //
			//--------------------------------------------------------------------//
			
			assertTrue(verifyUnSelectAllCheckBoxDetails(selenium), "The check boxes are not selected", selenium, ClassName, MethodName);
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySelectAllCheckBoxDetails(Selenium selenium){
		
		if(!isChecked(selenium,chkSelectAll)){
			return false;
		}
		
		if(!isChecked(selenium,chkEyes)){
			return false;
		}
		if(!isChecked(selenium,chkEars)){
			return false;
		}
		if(!isChecked(selenium,chkCardiovascular)){
			return false;
		}
		if(!isChecked(selenium,chkRespiratory)){
			return false;
		}
		if(!isChecked(selenium,chkGastrointestinal)){
			return false;
		}
		if(!isChecked(selenium,chkGenitourinary)){
			return false;
		}
		if(!isChecked(selenium,chkMusculoskeletal)){
			return false;
		}
		if(!isChecked(selenium,chkSkin)){
			return false;
		}
		if(!isChecked(selenium,chkNeurologic)){
			return false;
		}
		if(!isChecked(selenium,chkPsychiatric)){
			return false;
		}
		if(!isChecked(selenium,chkHematologic)){
			return false;
		}
		
		return true;
		
	}
	
	public boolean verifyUnSelectAllCheckBoxDetails(Selenium selenium){

		if(isChecked(selenium,chkSelectAll)){
			return false;
		}
		
		if(isChecked(selenium,chkEyes)){
			return false;
		}
		if(isChecked(selenium,chkEars)){
			return false;
		}
		if(isChecked(selenium,chkCardiovascular)){
			return false;
		}
		if(isChecked(selenium,chkRespiratory)){
			return false;
		}
		if(isChecked(selenium,chkGastrointestinal)){
			return false;
		}
		if(isChecked(selenium,chkGenitourinary)){
			return false;
		}
		if(isChecked(selenium,chkMusculoskeletal)){
			return false;
		}
		if(isChecked(selenium,chkSkin)){
			return false;
		}
		if(isChecked(selenium,chkNeurologic)){
			return false;
		}
		if(isChecked(selenium,chkPsychiatric)){
			return false;
		}
		if(isChecked(selenium,chkHematologic)){
			return false;
		}
		return true;
	}
}
