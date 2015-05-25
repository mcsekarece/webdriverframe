package com.nexia.selenium.testscripts.section.clinicalsettings.MedInteractionWarning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class ModeratetoSevereVerifyInteractionWarning extends AbstractClinicalSettings {
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyModeratetoSeveretoMildInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_022";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyModeratetoSeveretoHighInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_023";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyModeratetoSeveretoSevereInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_024";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyModeratetoMildtoMildInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_025";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyModeratetoMildtoHighInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_026";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyModeratetoMildtoSevereInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_027";
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
			assertTrue(click(selenium,rdoModerateToSevere),"Could not click the mild to severe checkbox;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium, btnWarningSave), "Could not click on Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to System Setting, Provider Level change (old provider level)
			//--------------------------------------------------------------------//
			assertTrue(navigateToMySettingsInteracWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Edit Interaction Warning at Provider level (old Provider Level)
			//  set it to Moderate to Severe and Mild to Severe
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_022") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_023") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_024") ){
				
			assertTrue(click(selenium,rdoModerateToSevere),"Could not click the Moderate radio button ;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			}
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_025") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_026") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_027") ){
				assertTrue(click(selenium,rdoMildToSevere),"Could not click the mild radio button;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
			}			
			
			assertTrue(click(selenium, btnWarningSave), "Could not click on Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Clinical Setting, Practice level change 
			//--------------------------------------------------------------------//
			assertTrue(navigateToInteracWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-8:Edit Interaction Warning at Practice level (New Practice Level)  
			//--------------------------------------------------------------------//
			
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_022") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_023") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_024") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_025")){
				
				assertTrue(editInteracWarn(selenium,interacWarn),"Navigation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
		    	}
				
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_026") ){
				    assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
				    waitForPageLoad(selenium);
					assertTrue(click(selenium,rdoHighToSevere),"Could not click the mild to severe checkbox;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium, btnWarningSave), "Could not click on Save button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);					
			 }	
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_027") ){
				assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
				assertTrue(click(selenium,rdoSevereOnly),"Could not click the mild to severe checkbox;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnWarningSave), "Could not click on Save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
		     }
			
			
			//--------------------------------------------------------------------//
			//  Step-9: Navigate to System Setting, Provider Level change
			//--------------------------------------------------------------------//
			assertTrue(navigateToMySettingsInteracWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-10:Verify the impact at provider level (New Provider Level)			
			//--------------------------------------------------------------------//
				
	
			if(!verifyModeratetoSevereTransition(selenium,interacWarn,userAccount)){
				Assert.fail("Moderate to Severe Transition did not happen properly; More Details :"+ interacWarn.toString());
				returnValue= false;
			}else
				returnValue=true;
			

						
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
public boolean verifyModeratetoSevereTransition(Selenium selenium,ClinicalSettingLib interacWarn,String account) throws IOException{
		
		boolean returnValue=true;
		
		
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_022")){

			// 	Changed cannot be less than practice level
			// check if the msg is present "Because your practice level is set to show all warnings, you are not able to make any changes".
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
			//assertTrue(selenium.isTextPresent(interacWarn.warning)," Warning text not present", selenium, ClassName, MethodName);

		}

		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_023")){

				assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
	
				// Check if the High, Moderate and Mild radio buttons are present and "High to Severe" radio button is checked
				assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio Button is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isChecked(rdoHighToSevere), "High Radio Button is not checked", selenium, ClassName, MethodName);
				assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
	
				// Check if the High to Severe Warning message is present
				if(selenium.isTextPresent(interacWarn.warning)){
					return true;
				}else
					return false;
								
			
			}
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_024")){
			
				assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				// Check if the Severe, High, Moderate and Mild radio buttons are present and "Severe" radio button is checked
				assertTrue(selenium.isVisible(rdoSevereOnly), "Severe Radio Button is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isChecked(rdoSevereOnly), "Severe Radio Button is not checked", selenium, ClassName, MethodName);
				assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio Button is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
				
				// Check if the Severe Warning message is present
				if(selenium.isTextPresent(interacWarn.warning)){
					return true;
				}else
					return false;
							
						
			}
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_025")){
									
				// No Change Condition
				// check if this msg is present "Because your practice level is set to show all warnings, you are not able to make any changes".
				if(selenium.isTextPresent("Because your practice level is set to show all warnings, you are not able to make any changes")){
					return true;
				}else
					return false;

			
			}
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_026")){
			
				assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				// No Change Condition
				// Check if the High, Moderate and Mild radio buttons are present and "Mild to Severe" radio button is checked
				assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio Button is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isChecked(rdoMildToSevere), "Mild Radio Button is not checked", selenium, ClassName, MethodName);
				assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);		
				
				// Check if the HIGH to SEVERE Warning message is present
				if(selenium.isTextPresent(interacWarn.warning)){
					return true;
				}else
					return false;

			}
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_027")){
			
				assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
							
				// No Change Condition
				// Check if the Severe, High, Moderate and Mild radio buttons are present and "Mild to Severe" radio button is checked
				assertTrue(selenium.isVisible(rdoSevereOnly), "Severe Radio Button is not present", selenium, ClassName, MethodName);				
				assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio Button is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isChecked(rdoMildToSevere), "Mild Radio Button is not checked", selenium, ClassName, MethodName);
				assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
				
				// Check if the SEVERE Warning message present
				if(selenium.isTextPresent(interacWarn.warning)){
					return true;
				}else
					return false;
				
			}
	
		return returnValue;
	
}
}