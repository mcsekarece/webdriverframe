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

public class VerifyOptionPopUpForComponent extends AbstractClinicalSettings{
	
		@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Option pop up for Componenet")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void addEncounterTemplateInSimpleView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
			encounterTemplateTestData.workSheetName = "EncounterTemplate";
			encounterTemplateTestData.testCaseId = "TC_ET_001";
			encounterTemplateTestData.fetchClinicalSettingsTestData();
			
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			
			encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
		}

		/*************************************************************************************************** 
		* @purpose        To verify Option pop for Componenet
		* @Specification  SRS_EMR_Encounter_Structure_Templates Rev0.0
		* @action 		  Verifying add encounter template
		* @author         AspireQA
		* @throws 		  IOException 
		* @state          Developing
		* @useraccount    Both
		* @since  	     June 24, 2014
		***************************************************************************************************/
		
		public boolean encounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib encounterTemplateTestData) throws IOException{
			Selenium selenium=null;
			boolean returnValue=true;
		try
		{
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
						
			//--------------------------------------------------------------------//
			//  Step-5: Add new Encounter Template 								  //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy HH:MM");
			String date=DateFormat.format(cal.getTime());
			encounterTemplateTestData.templateName=encounterTemplateTestData.templateName+date;
			assertTrue(addEncounterTemplate(selenium, encounterTemplateTestData),"Could not add new Encounter Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify the encounter template values in summary page      //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValuesEncounterTemplate(selenium, encounterTemplateTestData),"Verification failed for added encounter template in summary page", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-7: Search created template and click it				      //
			//--------------------------------------------------------------------//		
			assertTrue(SearchAddedTemplateForoutline(selenium, encounterTemplateTestData),"Could not serach Addes Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, EncoEdit), "Could not click Edit button in Created Encounter template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 if(!isChecked(selenium, "//tr[2]/td/div/div/div/div/div/span/input")){
				assertTrue(click(selenium, "//tr[2]/td/div/div/div/div/div/span/input"), "could not check the componenet check box", selenium, ClassName, MethodName);
			 }			
			assertTrue(click(selenium, btnPastMedicalOption), "could not click option button for Componenet", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(isElementPresent(selenium,OptionPop),"Option pop up is not present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,radioEditComponenetName) ,"Could not click on Edit componenet name Radio button", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtEditName,"Edited Component Name") ,"Could not type Componenet name", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnOptionSave) ,"Could not click on Edit componenet name Radio button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium,btnOptionSave),"Pop up not saved properly", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("Edited Component Name") ,"Edited Name Name should not be Changed here", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnAddNew),"Encounter template not saved ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-7: Verify Edited Component NAme In Encounter Component List Page				      //
			//------------------------------------------------------------------ --//		
			assertTrue(SearchAddedTemplateForoutline(selenium, encounterTemplateTestData),"Could not serach Added Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent("Edited Component Name") ,"Edited Name Name should  be  in summary", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			
		}
		catch(Exception e)
		{
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
		}
		
		
		
	
}
