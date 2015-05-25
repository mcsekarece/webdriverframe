package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultEncounterTemplate extends AbstractClinicalSettings {
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing default encounter template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultEncounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_008";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify default encounter template
	* @Specification  SRS_EMR_Encounter_Structure_Templates Rev0.0
	* @action 		  Verifying default encounter template
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 16, 2013
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
						
			//----------------------------------------------------------------------------//
			//  Step-5: verify the default encounter template values in summary page      //
			//----------------------------------------------------------------------------//
			assertTrue(verifyStoreValuesEncounterTemplate(selenium, encounterTemplateTestData),"Verification failed for added encounter template in summary page", selenium, ClassName, MethodName);
			
			assertTrue(!getText(selenium, lnkDeleteEncounterTemplate).equalsIgnoreCase("Delete"),"Verification failed for added encounter template in summary page", selenium, ClassName, MethodName);
						
			//----------------------------------------------------------------------------//
			//  Step-6: Edit the default encounter template						 	      //
			//----------------------------------------------------------------------------//
			assertTrue(click(selenium, EncoEdit), "Could not click on edit", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//----------------------------------------------------------------------------//
			//  Step-7: Verify all the menu's are checked in by default				 	  //
			//----------------------------------------------------------------------------//
			// get the number of encounter template menus
			int encounterTempCount= (Integer) selenium.getXpathCount("//div[@class='display-cell checkbox-col']");
			for(int count=1; count<= encounterTempCount; count++){
				if(!isChecked(selenium, "//tr["+count+"]/td/div/div/div/div/div/span/input")){
					Assert.fail("All menu's are not checked by default");
				}
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}