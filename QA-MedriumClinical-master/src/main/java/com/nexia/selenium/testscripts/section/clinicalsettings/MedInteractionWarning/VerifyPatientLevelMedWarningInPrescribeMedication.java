package com.nexia.selenium.testscripts.section.clinicalsettings.MedInteractionWarning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPatientLevelMedWarningInPrescribeMedication extends AbstractClinicalSettings {
	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Patient Medication Interaction Warning On Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientMedInteractionWarningOnPrescribeMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_010";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyPatientMedInPrescribeMed(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Patient Medication Interaction Warning On Prescribe Medication
	* @Specification  SRS_Medications_Interaction_Warning Management_Rev0.0
	* @action 		  select appropriate option for interaction warning management
	* @expected       Selected Patient Medication Interaction Warning should be displayed in Prescribe Medication
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      March 19, 2013
	***************************************************************************************************/

	
	public boolean verifyPatientMedInPrescribeMed(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib interacWarn) throws IOException{
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
			//  Step-4: Verify Deafult warning on patient Options //
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,interacWarn.patientId);
			waitForPageLoad(selenium);
			assertTrue(navigateToPatientOptionWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,rdoMildToSevere),"Could not check moderate radio button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveOnPatientOptions1),"Could not click the save button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to allergy section //
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
				assertTrue(selectValueFromAjaxList(selenium,"severitysuggestBox","moderat"),"could not select", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkReaction),"Could not on show more button",selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, chkfirst),	"Could not on show more button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnpopclose),"Could not on show more button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,"statusSuggestBoxsuggestBox","Active"),"Could not select", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
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
			//selectValueFromAjaxList(selenium,ajxProvider,interacWarn.provider);
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
			assertTrue(selenium.isTextPresent("Medication Interaction Warning"), "Drug Allergy interaction is not displayed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

				
			if(!verifyPatientMedInPrescribeMed(selenium,interacWarn)){
				
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

	public boolean verifyPatientMedInPrescribeMed(Selenium selenium,ClinicalSettingLib interacWarn) throws IOException{		
		assertTrue(getText(selenium,lblForSavePrescribeMedWarning).toLowerCase(new java.util.Locale("en","US")).trim().contains(interacWarn.warning.trim().toLowerCase(new java.util.Locale("en","US"))),"", selenium, ClassName, MethodName);
		return true;
	}
	
}