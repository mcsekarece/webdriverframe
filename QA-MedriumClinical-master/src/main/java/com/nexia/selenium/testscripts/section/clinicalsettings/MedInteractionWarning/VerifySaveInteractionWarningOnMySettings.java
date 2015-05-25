package com.nexia.selenium.testscripts.section.clinicalsettings.MedInteractionWarning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySaveInteractionWarningOnMySettings extends AbstractClinicalSettings {
	
		
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save my settings interaction Warning with high level practice warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveWarningWithModeratetoSeverePracticeWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_015";
		interacWarn.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save my settings interaction Warning with high level practice warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveWarningWithSevereOnlyPracticeWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_016";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	} 
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save my settings interaction Warning with high level practice warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveWarningWithHightoSeverePracticeWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_017";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save my settings interaction Warning with high level practice warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveWarningWithMildtoSeverePracticeWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_018";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify save action for interaction warning management
	* @Specification  SRS_Medications_Interaction_Warning Management_Rev0.0 (Section 2.1) 
	* @action 		  select appropriate option for interaction warning management at the Practice level 
	* @expected       Selected warning option should successfully save for the provider options based on the changed to the practise level 
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
			//  Step-4: Verify Deafult warning on My Settings //
			//--------------------------------------------------------------------//
			assertTrue(navigateToMySettingsInteracWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyWarning(selenium,interacWarn),"Navigation Failed", selenium, ClassName, MethodName);
			
				
			assertTrue(verifyPatientLevelWarning(selenium,interacWarn),"Navigation Failed", selenium, ClassName, MethodName);
			
		
			//--------------------------------------------------------------------//
			//  Step-5: Verify Save warning on My Settings //
			//--------------------------------------------------------------------//
			
			/*if(interacWarn.testCaseId.equals("TC_IWM_015")){
				interacWarn.workSheetName = "InteractionWarning";
				interacWarn.testCaseId = "TC_IWM_004";
				interacWarn.fetchClinicalSettingsTestData();
			}
			
			assertTrue(editInteracWarnMySettings(selenium,interacWarn),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyPatientLevelWarning(selenium,interacWarn)){
				Assert.fail("Warning option not saved properly; More Details :"+ interacWarn.toString());
				returnValue= false;
			}else
				returnValue=true;
			*/
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	public boolean verifyWarning(Selenium selenium,ClinicalSettingLib interacWarn){
		boolean returnValue=true;
		
		if(getText(selenium,lblWarningOnSummary).contains(interacWarn.warning)){
			returnValue=true;
		}	
		
		return returnValue;
	}
	
	public boolean verifyPatientLevelWarning(Selenium selenium,ClinicalSettingLib interacWarn) throws IOException{
		boolean returnValue=true;
		
		if(interacWarn.testCaseId.equals("TC_IWM_015")){
			
			assertTrue(click(selenium,btnEditWarning), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(!selenium.isVisible(rdoSevereOnly), "Severe Radio button present", selenium, ClassName, MethodName);
			assertTrue(!selenium.isVisible(rdoHighToSevere), "High Radio button present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isChecked(rdoModerateToSevere), "Moderate Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button not present", selenium, ClassName, MethodName);
			
			assertTrue(selenium.isTextPresent(interacWarn.warning)," Warning text not present", selenium, ClassName, MethodName);		
		}
		
		else if(interacWarn.testCaseId.equals("TC_IWM_016")){
		
			assertTrue(click(selenium,btnEditWarning), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isVisible(rdoSevereOnly), "Severe Radio button present", selenium, ClassName, MethodName);
			assertTrue(selenium.isChecked(rdoSevereOnly), "Severe Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio button present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button not present", selenium, ClassName, MethodName);
		
			assertTrue(selenium.isTextPresent(interacWarn.warning)," Warning text not present", selenium, ClassName, MethodName);			
		}		
		
		else if(interacWarn.testCaseId.equals("TC_IWM_017")){			
			
			assertTrue(click(selenium,btnEditWarning), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isVisible(rdoSevereOnly), "Severe Radio button present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio button present", selenium, ClassName, MethodName);
			assertTrue(selenium.isChecked(rdoHighToSevere), "High to severe Radio Button is not Checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button not present", selenium, ClassName, MethodName);
			
			assertTrue(selenium.isTextPresent(interacWarn.warning)," Warning text not present", selenium, ClassName, MethodName);			
		}
		
		else if(interacWarn.testCaseId.equals("TC_IWM_018")){			
			
			/*assertTrue(!selenium.isVisible("severeradio"), "Severe Radio button present");
			assertTrue(!selenium.isVisible("highradio"), "High Radio button present");
			assertTrue(!selenium.isVisible("moderateradio"), "Moderate Radio Button present");
			assertTrue(selenium.isVisible("mildradio"), "Mild Radio Button present");*/
			
			if(selenium.isTextPresent("Because your practice level is set to show all warnings, you are not able to make any changes")){
				return true;
			}else
				return false;
		}		
		
		return returnValue;
	}
}