package com.nexia.selenium.testscripts.section.clinicalsettings.MedInteractionWarning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMedWarningAfterChangeWarningLevelInPrescribeMed extends AbstractClinicalSettings {
	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Mild Warning After Change In Warning Level In Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyMildWarningAfterChangeInWarningLevelInPrescribeMed(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_011";
		interacWarn.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyMedWarnings(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Moderate Warning After Change In Warning Level In Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyModerateWarningAfterChangeInWarningLevelInPrescribeMed(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_012";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyMedWarnings(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing High Warning After Change In Warning Level In Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyHighWarningAfterChangeInWarningLevelInPrescribeMed(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_013";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyMedWarnings(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Severe Warning After Change In Warning Level In Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifySevereWarningAfterChangeInWarningLevelInPrescribeMed(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_014";
		interacWarn.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyMedWarnings(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Medication Warning After Change In Warning Level In Prescribe Medication
	* @Specification  SRS_Medications_Interaction_Warning Management_Rev0.0
	* @action 		  verifying Medication Warning After Change In Warning Level In Prescribe Medication
	* @expected       After Changing The Lower Warning Level In Prescribe Medication, It should not shows the warnings in medication warning
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      March 20, 2013
	***************************************************************************************************/

	
	public boolean verifyMedWarnings(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib interacWarn) throws IOException{
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
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,interacWarn.patientId),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(navigateToPatientOptionWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,rdoModerateToSevere),"Could not click the mild to severe checkbox;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveOnPatientOptions1),"Could not click the save button;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
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
			selectValueFromAjaxList(selenium,"severitysuggestBox",interacWarn.severity);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, "reactionLink"),
					"Could not on show more button",selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, "1checkboxAllergyReaction"),
					"Could not on show more button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, "multiSelectionCloseButton"),
					"Could not on show more button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//selectValueFromAjaxList(selenium,ajxStatus,interacWarn.status);
			assertTrue(click(selenium,btnAdd),"Could not click the add button;More details:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(interacWarn.testCaseId.equals("TC_IWM_011")){
			assertTrue(click(selenium,btnAllergysave),"Could not click the save button;More details:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}else{
			assertTrue(click(selenium,btnSave1),"Could not click the save button;More details:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			waitForPageLoad(selenium);
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
				selenium.chooseOkOnNextConfirmation();
				}
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-9: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxProvider,interacWarn.provider),"Navigation Failed", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxLoaction,interacWarn.location),"Navigation Failed", selenium, ClassName, MethodName);
			if(userAccount.equalsIgnoreCase(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,interacWarn.allergenCA),"Could not type Prescribe Medication;More Details:"+interacWarn.toString(), selenium, ClassName, MethodName);
			}
			else{
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,interacWarn.allergen),"Could not type Prescribe Medication;More Details:"+interacWarn.toString(), selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkEdit),"Could not click the Prescribe link;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if (selenium.isTextPresent("Proceed Anyway") ) {
				assertTrue(
						click(selenium, btnCancelButton),
						"Could not Click Proceed Anyway button"
								+ interacWarn.toString(), selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);
			}
			
			
			//Verify drug allergy interaction
			/*assertTrue(isElementPresent(selenium, lblFoodAndDrinkInteractionWarning), "Drug Allergy interaction is not displayed");
			waitForPageLoad(selenium);
*/
			//click the wheel icon
			/*waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			selenium.focus("//div[5]/div/div/div[3]/div[2]");
			selenium.click("//div[5]/div/div/div[3]/div[2]");
			
			selenium.fireEvent("//div[5]/div/div/div[3]/div[2]", "click");
			waitForPageLoad(selenium);*/
			
			//click the wheel icon
			waitForPageLoad(selenium);
			selenium.clickAt(btnWheelIcon, "");
			selenium.focus(btnWheelIcon);
			selenium.fireEvent(btnWheelIcon, "click");
			waitForPageLoad(selenium);
			
			
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_011")){
				
				assertTrue(click(selenium,rdoMildToSevere),"Could not click the mild to severe checkbox;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				
				
				if(!verifyPrescribeMedication(selenium,interacWarn)){
					
					Assert.fail("Warning option not saved properly; More Details :"+ interacWarn.toString());
					returnValue= false;
				}else
					returnValue=true;
			}
			
			else if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_012")){

				assertTrue(click(selenium,rdoModerateToSevere),"Could not click the mild to severe checkbox;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnCloseButton),"Could not click the close button;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				
				if(!verifyPrescribeMedication(selenium,interacWarn)){
					Assert.fail("Warning option not saved properly; More Details :"+ interacWarn.toString());
					
					returnValue= false;
				}else
					returnValue=true;
			}

			else if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_013")){
				
				assertTrue(click(selenium,rdoHighToSevere),"Could not click the mild to severe checkbox;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnCloseButton),"Could not click the close button;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				
				if(!verifyPrescribeMedication(selenium,interacWarn)){
					
					Assert.fail("Warning option not saved properly; More Details :"+ interacWarn.toString());
					returnValue= false;
				}else
					returnValue=true;
			}
			
			else if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_014")){

				assertTrue(click(selenium,rdoSevereOnly),"Could not click the mild to severe checkbox;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnCloseButton),"Could not click the close button;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				
				if(!verifyPrescribeMedication(selenium,interacWarn)){
					
					Assert.fail("Warning option not saved properly; More Details :"+ interacWarn.toString());
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

	public boolean verifyPrescribeMedication(Selenium selenium,ClinicalSettingLib interacWarn) throws IOException{
	
		boolean returnValue=false;
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,"css=a.absolute.right10 > img"),"Could not click the button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if(getText(selenium,"css=div.inline-block > span.red.bold").toLowerCase(new java.util.Locale("en","US")).trim().contains(interacWarn.warning.trim().toLowerCase(new java.util.Locale("en","US")))){
			returnValue=true;
		}	
		return returnValue;
	}
	
	
}