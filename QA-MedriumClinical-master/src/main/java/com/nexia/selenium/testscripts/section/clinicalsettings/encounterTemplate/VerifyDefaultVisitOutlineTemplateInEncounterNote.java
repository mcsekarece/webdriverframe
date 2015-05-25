package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultVisitOutlineTemplateInEncounterNote extends AbstractClinicalSettings {
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Default template in newly created patient Encounter note")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultVisitOutlineTemplateInEncounterNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception 
	{
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_008";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyDefaultVisitOutlineTemplateInEncounterNote(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Default template in newly created patient Encounter note")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditDefaultVisitOutlineTemplateInEncounterNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception 
	{
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_019";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyDefaultVisitOutlineTemplateInEncounterNote(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify Default template on encounter template
	* @Specification  SRS_EMR_Encounter_Structure_Templates Rev0.0
	* @action 		  Verifying visit outline encounter template
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @user account   Both
	* @since  	      October 28, 2013
	***************************************************************************************************/
	public boolean verifyDefaultVisitOutlineTemplateInEncounterNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib encounterTemplateTestData)throws Exception
	{
		Selenium selenium=null;
		
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
			//  Step-3: Change the practice                                       //
			//--------------------------------------------------------------------//
			assertTrue(selectPractice(selenium),"Unable to change to Encounter Structed Template",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Encounter Template 							  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToEncounterTemplate(selenium),"Navigation to encounter template Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Delete All Encounter Template 							  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllEncounterTemplate(selenium),"Could not Delete All Encounter Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//------------------------------------------------------------------//
			//  Step-5: Edit Default template                                   //
			//------------------------------------------------------------------//
			assertTrue(editDefaultTemplateInVisitOutline(selenium,encounterTemplateTestData),"Unable to Complete the Edit template",selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(NaviageToPatientRegisterationpageToEncounter(selenium),"Unable to Navigate to New Patient Registration Page",selenium,ClassName,MethodName);
			//------------------------------------------------------------------//
			//  Step-6: Create patient With Mandatory Fields                    //
			//------------------------------------------------------------------//
			ChartPreVisitLib proData = new ChartPreVisitLib();
			proData.workSheetName = "NewPatientCheckIn";
			proData.testCaseId = "TC_NP_001";
			proData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,proData),"Unable to create a new patient",selenium,ClassName,MethodName);
			String NewPatientID=getText(selenium,"patientID");
			//------------------------------------------------------------------//
			//  Step-7: Navigate to patient Chart                               //
			//------------------------------------------------------------------//
			assertTrue(NavigateToPatientToPatientChart(selenium),"Unable to Naviage to Patient Chart",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//------------------------------------------------------------------//
			//  Step-8: Verify in Encounter Page                                //
			//------------------------------------------------------------------//
			assertTrue(verifyDefaultEncounterTemplate(selenium,encounterTemplateTestData),"Unable to check the template in Encounter page",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEncounterList),"Unable to find the link",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	//-----------------------------------------------------------------//
	    	//  Step-9: Verify Saved Encounter page                            //
	    	//-----------------------------------------------------------------//
	    //	assertTrue(isElementPresent(selenium,"titlePanel_"+encounterTemplateTestData.section),"Data not matched in template and Encounter page",selenium,ClassName,MethodName);
	    	assertTrue(cancelEncounterTemplate(selenium),"",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	
	    	if(encounterTemplateTestData.testCaseId.equals("TC_ET_019"))
	    	{
	    		//--------------------------------------------------------------------//
				//  Step-10 Navigate to Encounter Template 							  //
				//--------------------------------------------------------------------//
				assertTrue(navigateToEncounterTemplate(selenium),"Navigation to encounter template Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//------------------------------------------------------------------//
				//  Step-11: Edit Default template                                  //
				//------------------------------------------------------------------//
				assertTrue(verifyEditDefaultTemplateInVisitOutline(selenium,encounterTemplateTestData),"Unable to Complete the Edit template",selenium,ClassName, MethodName);
				waitForPageLoad(selenium);
				//-------------------------------------------------------------------//
				//  Step-12 : Search the Patient                                     // 
				//-------------------------------------------------------------------//
				assertTrue(searchPatientUsingPatientId(selenium,NewPatientID),"Unable to get into the patient",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				//------------------------------------------------------------------//
				//  Step-13: Verify in Encounter Page                               //
				//------------------------------------------------------------------//
				assertTrue(verifyEditDefaultEncounterTemplate(selenium,encounterTemplateTestData),"Unable to check the template in Encounter page",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkencounterTab),"Unable to click the encounter tab link",selenium,ClassName,MethodName);
		    	waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkEncounterListEdit),"Unable to find the link",selenium,ClassName,MethodName);
		    	waitForPageLoad(selenium);
		    	//-----------------------------------------------------------------//
		    	//  Step-14: Verify Saved Encounter page                           //
		    	//-----------------------------------------------------------------//
		    	
		    	assertTrue(isTextPresent(selenium,encounterTemplateTestData.sectionEdit),"Data not matched in template and Encounter page",selenium,ClassName,MethodName);
		    	waitForPageLoad(selenium);
	    		
	    	}
	    	
	    }catch(RuntimeException e)
		{
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}
