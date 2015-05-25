package com.nexia.selenium.testscripts.section.clinicalsettings.MedInteractionWarning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class MildtoSevereVerifyInteractionWarning extends AbstractClinicalSettings {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMildtoSeveretoModerateInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_019";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMildtoSeveretoHighInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_020";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMildtoSeveretoSevereInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_021";
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
	* @author         Jagmit
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 04, 2013
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
			//  Step-3: Navigate to Clinical Setting, Practice level change 
			//--------------------------------------------------------------------//
			assertTrue(navigateToInteracWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4:Edit Interaction Warning at Practice level (old Practice Level)
			//  set to Mild to Severe
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,rdoMildToSevere),"Could not click the mild to severe checkbox;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium, btnWarningSave), "Could not click on Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to System Setting, Provider Level change
			//--------------------------------------------------------------------//
			assertTrue(navigateToMySettingsInteracWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Clinical Setting, Practice level change 
			//--------------------------------------------------------------------//
			assertTrue(navigateToInteracWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-8:Edit Interaction Warning at Practice level (New Practice Level)  
			//--------------------------------------------------------------------//
			assertTrue(editInteracWarn(selenium,interacWarn),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-9: Navigate to System Setting, Provider Level change
			//--------------------------------------------------------------------//
			assertTrue(navigateToMySettingsInteracWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10:Verify the impact at the Provider level (New Provider Level)			
			//--------------------------------------------------------------------//
		
			
			if(!verifyMildtoSevereTransition(selenium,interacWarn,userAccount)){
				Assert.fail("Mild to Severe Transition did not happen properly; More Details :"+ interacWarn.toString());
				returnValue= false;
			}else
				returnValue=true;
			

			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyMildtoSevereTransition(Selenium selenium,ClinicalSettingLib interacWarn,String account) throws IOException{
		
		boolean returnValue=true;		
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_019")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		   // Check if the Moderate and Mild radio buttons are present and "Moderate to Severe" radio button is checked
			
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isChecked(rdoModerateToSevere), "Moderate Radio Button is not checked", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
		
			// Check if the Moderate to Severe Warning message present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
			
			// Check if the Moderate to Severe Warning message present 				
			//assertTrue(selenium.isTextPresent(interacWarn.warning)," Warning text not present", selenium, ClassName, MethodName);				
		 
		}
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_020")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			// Check if the High, Moderate and Mild radio buttons are present and High radio button is checked
			
			assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio Button is not present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isChecked(rdoHighToSevere), "Moderate Radio Button is not checked", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
			
			// Check if the High to Severe Warning message present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
			//assertTrue(selenium.isTextPresent(interacWarn.warning)," Warning text not present", selenium, ClassName, MethodName);
		}

		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_021")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
		// Check if the Severe, High, Moderate and Mild radio buttons are present and Severe radio button is checked
			assertTrue(selenium.isVisible(rdoSevereOnly), "Severe Radio Button is not present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(selenium.isChecked(rdoSevereOnly), "Severe Radio Button is not checked", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
			
		// Check if the Severe Warning message present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
			//assertTrue(selenium.isTextPresent(interacWarn.warning)," Warning text not present", selenium, ClassName, MethodName);
		}		
		
		return returnValue;
	}
	
}