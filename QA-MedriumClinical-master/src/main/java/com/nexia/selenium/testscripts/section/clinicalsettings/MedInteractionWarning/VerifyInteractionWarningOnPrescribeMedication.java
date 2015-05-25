package com.nexia.selenium.testscripts.section.clinicalsettings.MedInteractionWarning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyInteractionWarningOnPrescribeMedication extends AbstractClinicalSettings {
	@Test(groups = {"SmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing prescribe medication interaction Warning with low level practice warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrescribeMedWithLowLevelPracticeWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_005";
		interacWarn.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing prescribe medication interaction Warning with high level practice warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrescribeMedWithHighLevelPracticeWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_006";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save In Prescribe MedWarning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySavePrescribeMedWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_007";
		interacWarn.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Cancel Prescribe MedWarning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelPrescribeMedWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_008";
		interacWarn.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Default Interaction Practice Level In MedWarning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultInteractionPracticeLevelInMedWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_009";
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
			if(!interacWarn.testCaseId.equals("TC_IWM_005")){
			assertTrue(switchRole(selenium,interacWarn.switchRole),"Could not change the switch role;More Details:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
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
			selectValueFromAjaxList(selenium,"severitysuggestBox","moderat");
			assertTrue(click(selenium, "reactionLink"),"Could not on show more button",selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, "1checkboxAllergyReaction"),	"Could not on show more button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, "multiSelectionCloseButton"),"Could not on show more button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAdd),"Could not click the add button;More details:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAllergysave),"Could not click the save button;More details:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-9: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
		//	selectValueFromAjaxList(selenium,ajxProvider,interacWarn.provider);
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
			
			//Check if the "Proceed Anyway" Button is present
	
			
			if ((!isElementPresent(selenium, btnOverride))&& isElementPresent(selenium, btnCancelButton)){
				assertTrue(click(selenium, btnCancelButton),
						"Could not Click Proceed Anyway button"+ interacWarn.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			//Verify drug allergy interaction
			/*assertTrue(isElementPresent(selenium, lblPrescribeInteractionWarning), "Drug Allergy interaction is not displayed");
			waitForPageLoad(selenium);*/

			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_005")){
				//click the wheel icon
				waitForPageLoad(selenium);
				selenium.clickAt(btnWheelIcon, "");
				selenium.focus(btnWheelIcon);
				selenium.fireEvent(btnWheelIcon, "click");
				waitForPageLoad(selenium);
				
				if(!verifyWarningWithLowLevelInteraction(selenium,interacWarn)){
					Assert.fail("Warning option not saved properly; More Details :"+ interacWarn.toString());
				
				}else
					returnValue=true;
			}
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_006")){
				//click the wheel icon
				waitForPageLoad(selenium);
				assertTrue(clickAt(selenium,btnWheelIcon, ""),"Could not click the mild to severe checkbox;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				assertTrue(focus(selenium,btnWheelIcon),"Could not click the mild to severe checkbox;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				selenium.fireEvent(btnWheelIcon, "click");
				waitForPageLoad(selenium);
				
				if(!verifyWarningWithHighLevelInteraction(selenium,interacWarn)){
					
					Assert.fail("Warning option not saved properly; More Details :"+ interacWarn.toString());
					returnValue= false;
				}else
					returnValue=true;
			}

			else if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_007")){
				//click the wheel icon
				waitForPageLoad(selenium);
				selenium.clickAt(btnWheelIcon, "");
				selenium.focus(btnWheelIcon);
				selenium.fireEvent(btnWheelIcon, "click");
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,rdoMildToSevere),"Could not click the mild to severe checkbox;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnCloseButton),"Could not click the close button;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				
				if(!verifySavePrescribeMedWarning(selenium,interacWarn)){
					
					Assert.fail("Warning option not saved properly; More Details :"+ interacWarn.toString());
					returnValue= false;
				}else
					returnValue=true;
			}
			
			else if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_008")){
				String warningLevel=getText(selenium,"css=div.inlineBlock > span.red.bold");
				
				//click the wheel icon
				waitForPageLoad(selenium);
				selenium.clickAt(btnWheelIcon, "");
				selenium.focus(btnWheelIcon);
				selenium.fireEvent(btnWheelIcon, "click");
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnCloseButton),"Could not click the close button;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(!verifyCancelPrescribeMedWarning(selenium,warningLevel)){
					
					Assert.fail("Warning option not saved properly; More Details :"+ interacWarn.toString());
					returnValue= false;
				}else
					returnValue=true;
			}
			
			else if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_009")){
				
				//click the wheel icon
				waitForPageLoad(selenium);
				selenium.clickAt(btnWheelIcon, "");
				selenium.focus(btnWheelIcon);
				selenium.fireEvent(btnWheelIcon, "click");
				waitForPageLoad(selenium);
				
				if(!verifyDefaultInteractionPracticeLevelInMedWarning(selenium,interacWarn)){
					
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

	public boolean verifyWarningWithLowLevelInteraction(Selenium selenium,ClinicalSettingLib interacWarn) throws IOException{
	
		boolean returnValue=true;
		assertTrue(getText(selenium,lblWarningForLowLevel).toLowerCase(new java.util.Locale("en","US")).trim().contains(interacWarn.warning.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not click the close button;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return returnValue;
	}
	
	public boolean verifyWarningWithHighLevelInteraction(Selenium selenium,ClinicalSettingLib interacWarn){
		boolean returnValue=false;
		
		if(!(getText(selenium,lblWarningForHighLevel).toLowerCase(new java.util.Locale("en","US")).trim().contains(interacWarn.warning.trim().toLowerCase(new java.util.Locale("en","US"))))){
			returnValue=true;
		}	
		
		return returnValue;
	}
	
	public boolean verifySavePrescribeMedWarning(Selenium selenium,ClinicalSettingLib interacWarn) throws IOException{
		boolean returnValue=false;
		assertTrue(getText(selenium,lblForSavePrescribeMedWarning).toLowerCase(new java.util.Locale("en","US")).trim().contains(interacWarn.warning.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not click the close button;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
		
		
		return returnValue;
	}
	
	public boolean verifyCancelPrescribeMedWarning(Selenium selenium,String warningLevel){
		boolean returnValue=false;
		
		if(getText(selenium,"css=div.inlineBlock > span.red.bold").toLowerCase(new java.util.Locale("en","US")).trim().contains(warningLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
			returnValue=true;
		}	
		
		return returnValue;
	}
	
	public boolean verifyDefaultInteractionPracticeLevelInMedWarning(Selenium selenium,ClinicalSettingLib interacWarn){
		boolean returnValue=false;
		
		if((getText(selenium,"css=div.marginTop10 > div > span.red").toLowerCase(new java.util.Locale("en","US")).trim().contains(interacWarn.warning.trim().toLowerCase(new java.util.Locale("en","US"))))){
			returnValue=true;
		}
		
		return returnValue;
	}
}