package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyIncludeInactiveInEncounterTemplate extends AbstractClinicalSettings {
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing include inactive in encounter template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncludeInactiveInEncounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_001";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify include inactive in encounter template
	* @Specification  SRS_EMR_Encounter_Structure_Templates Rev0.0
	* @action 		  Verifying include inactive in encounter template
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @user account   Both
	* @since  	      September 26, 2013
	***************************************************************************************************/
	
	public boolean encounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib encounterTemplateTestData) throws IOException{
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
			assertTrue(selectAutomationNexiaPractice(selenium),"Could not change the practice",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(switchRole(selenium,encounterTemplateTestData.switchRole),"Could not change the switch role;More Details:"+encounterTemplateTestData.toString(), selenium, ClassName, MethodName);
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
		
			String date =null;
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if(userAccount.equalsIgnoreCase(CAAccount)){
				DateFormat=new SimpleDateFormat("dd/MM/YYYY");
			}
			else{
				DateFormat=new SimpleDateFormat("MM/dd/YYYY");
			}
			date=DateFormat.format(cal.getTime());
			
			encounterTemplateTestData.templateName = encounterTemplateTestData.templateName +date;
			
			assertTrue(addEncounterTemplate(selenium, encounterTemplateTestData),"Could not add new Encounter Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify the encounter template values in summary page      //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValuesEncounterTemplate(selenium, encounterTemplateTestData),"Verification failed for added encounter template in summary page", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Delete All Encounter Template 							  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllEncounterTemplate(selenium),"Could not Delete All Encounter Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//----------------------------------------------------------------------------------//
			//  Step-8: verify search the in activated encounter template				        //
			//----------------------------------------------------------------------------------//
			assertTrue(type(selenium, txtSearch, encounterTemplateTestData.templateName), "Could not type template name", selenium, ClassName, MethodName);
			selenium.keyPress(txtSearch, "\\13");
			
			//-----------------------------------------------------------------------------------------------------//
			//  Step-9: verify the in activated encounter template values should not be available in summary page //
			//				Because, We in-activated the created template			                               //
			//-----------------------------------------------------------------------------------------------------//
			assertTrue(verifyStoreValuesNotShowEncounterTemplate(selenium, encounterTemplateTestData),"Verification failed for search feature in encounter template in summary page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//----------------------------------------------------------------------------------//
			//  Step-10: click include inactive check box   								    //
			//----------------------------------------------------------------------------------//
			
			assertTrue(click(selenium, chkSelectAll), "Could not click include inactive", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			//------------------------------------------------------------------------------//
			//  Step-11: verify the encounter template values in inactive template page     //
			//------------------------------------------------------------------------------//
			assertTrue(verifyStoreValuesEncounterTemplate(selenium, encounterTemplateTestData),"Verification failed for added encounter template in summary page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
				
			//-------------------------------------------------------------------------------//
			//  Step-12: verify the encounter template values in summary page after activate //
			//-------------------------------------------------------------------------------//
			assertTrue(verifyStoreValuesEncounterTemplate(selenium, encounterTemplateTestData),"Verification failed for search feature in encounter template in summary page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//------------------------------------------------------------------------------//
			//  Step-13: change Inactive state into activate state                          //
			//------------------------------------------------------------------------------//
			
			assertTrue(navigateToActivateAndInActivateSearchValue(selenium,encounterTemplateTestData),"Unable to navigate to search result",selenium,ClassName, MethodName);
			
			assertTrue(click(selenium,btnActivate),"Unable to click the activate button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-----------------------------------------------------------------------------//
			//  Step-14: Navigate and verify the activate state                            //
			//-----------------------------------------------------------------------------//
			assertTrue(click(selenium, chkSelectAll), "Could not click include inactive checkBox", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(navigateToActivateAndInActivateSearchValue(selenium,encounterTemplateTestData),"Unable to navigate to search result",selenium,ClassName, MethodName);
			//----------------------------------------------------------------------------//
			//  Step-15: Verify data in the Activate state template                       //
			//----------------------------------------------------------------------------//
			assertTrue(verifyStoreValuesEncounterTemplate(selenium, encounterTemplateTestData),"Verification failed for search feature in encounter template in summary page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}