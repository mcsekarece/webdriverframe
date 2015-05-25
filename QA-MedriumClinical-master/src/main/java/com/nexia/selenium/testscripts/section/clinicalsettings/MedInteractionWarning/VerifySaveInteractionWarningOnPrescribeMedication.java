package com.nexia.selenium.testscripts.section.clinicalsettings.MedInteractionWarning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySaveInteractionWarningOnPrescribeMedication extends AbstractClinicalSettings {
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing prescribe medication interaction Warning with low level practice warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveWarningWithLowLevelPracticeWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_005";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing prescribe medication interaction Warning with high level practice warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveWarningWithHighLevelPracticeWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_006";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify save action for interaction warning management
	* @Specification  SRS_Medications_Interaction_Warning Management_Rev0.0
	* @action 		  select appropriate option for interaction warning management
	* @expected       Selected warning option should successfully save 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      March 15, 2013
	***************************************************************************************************/

	
	public boolean verifySaveAction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib interacWarn) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + interacWarn.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, interacWarn.userName, interacWarn.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,interacWarn.switchRole),"Could not change the switch role;More Details:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Medication Interaction Warning//
			//--------------------------------------------------------------------//
			assertTrue(navigateToInteracWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3:Edit Medication Interaction Warning//
			//--------------------------------------------------------------------//
			assertTrue(editInteracWarn(selenium,interacWarn),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,interacWarn.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Deafult warning on Prescribe medication //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkChartSummary),"Could not click the chart summary;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Delete All existing Allergy//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllAllergy(selenium,interacWarn),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Add Allergy//
			//--------------------------------------------------------------------//
			if(userAccount.equalsIgnoreCase(CAAccount)){
				selectValueFromAjaxList(selenium,ajxAllergySuggestBox,interacWarn.allergenCA);
			}
			else{
				selectValueFromAjaxList(selenium,ajxAllergySuggestBox,interacWarn.allergen);
			}
			if(getText(selenium, "allergyMoreDetails").equalsIgnoreCase("Show more details")){
				assertTrue(click(selenium,"allergyMoreDetails"),"Could not on show more button", selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,"severitysuggestBox","moderat");
			selectValueFromAjaxList(selenium,"statusSuggestBoxsuggestBox","Active");
			assertTrue(click(selenium,btnAdd),"Could not click the add button;More details:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			/*assertTrue(click(selenium,btnSaveButton),"Could not click the save button;More details:"+interacWarn.toString());
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-9: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,ajxProvider,interacWarn.provider);
			selectValueFromAjaxList(selenium,ajxLoaction,interacWarn.location);
			if(userAccount.equalsIgnoreCase(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,interacWarn.allergenCA),"Could not type Prescribe Medication;More Details:"+interacWarn.toString(), selenium, ClassName, MethodName);
			}
			else{
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,interacWarn.allergen),"Could not type Prescribe Medication;More Details:"+interacWarn.toString(), selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEdit),"Could not click the Prescribe link;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Verify drug allergy interaction
			/*assertTrue(isElementPresent(selenium, lblPrescribeInteractionWarning), "Drug Allergy interaction is not displayed");
			returnValue = true;*/
			
			waitForPageLoad(selenium);
			
			if(!verifyWarning(selenium,interacWarn)){
				Assert.fail("Warning option not saved properly; More Details :"+ interacWarn.toString());
				returnValue= false;
			}else
				returnValue=true;
			

			//--------------------------------------------------------------------//
			//  Step-5: Verify Save warning on My Settings //
			//--------------------------------------------------------------------//
			
			if(interacWarn.testCaseId.equals("TC_IWM_002")){
				interacWarn.workSheetName = "InteractionWarning";
				interacWarn.testCaseId = "TC_IWM_004";
				interacWarn.fetchClinicalSettingsTestData();
			}
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Medication Interaction Warning//
			//--------------------------------------------------------------------//
			assertTrue(navigateToInteracWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(editInteracWarnMySettings(selenium,interacWarn),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyWarning(selenium,interacWarn)){
				Assert.fail("Warning option not saved properly; More Details :"+ interacWarn.toString());
				returnValue= false;
			}else
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	public boolean verifyWarning(Selenium selenium,ClinicalSettingLib interacWarn){
		boolean returnValue=true;
		
		if(getText(selenium,lblForCancelPrescribeMedWarning).toLowerCase(new java.util.Locale("en","US")).trim().contains(interacWarn.warning.trim().toLowerCase(new java.util.Locale("en","US")))){
			returnValue=true;
		}	
		
		return returnValue;
	}
}