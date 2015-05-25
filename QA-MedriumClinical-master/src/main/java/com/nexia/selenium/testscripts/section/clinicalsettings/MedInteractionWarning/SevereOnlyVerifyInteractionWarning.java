package com.nexia.selenium.testscripts.section.clinicalsettings.MedInteractionWarning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class SevereOnlyVerifyInteractionWarning extends AbstractClinicalSettings {
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeveretoMildInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_037";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeveretoModeratetoModerateInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_038";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeveretoHightoHighInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_039";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeveretoHightoMildtoMildInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_040";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeveretoHightoModeratetoModerateInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_041";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeveretoHightoHightoHighInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_042";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeveretoModeratetoMildtoMildInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_043";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeveretoModeratetoModeratetoModerateInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_044";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeveretoModeratetoHightoModerateInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_045";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeveretoMildtoMildtoMildInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_046";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeveretoMildtoModeratetoMildInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_047";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeveretoMildtoHightoMildInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_048";
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
			//  Severe Only Option
			//--------------------------------------------------------------------//
					
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,rdoSevereOnly),"Could not click the Severe Only radio button;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);			
			assertTrue(click(selenium, btnWarningSave), "Could not click on Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to System Setting, Provider Level change
			//--------------------------------------------------------------------//
			assertTrue(navigateToMySettingsInteracWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Edit Interaction Warning at Provider level (old Provider Level)
			//  set to Severe, High, Moderate and Mild
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_037") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_038") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_039") ){
				
				assertTrue(click(selenium,rdoSevereOnly),"Could not click the Severe Only Radiobutton ;More Details:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
			}
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_040") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_041") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_042") ){
				assertTrue(click(selenium,rdoHighToSevere),"Could not click the High_to_Severe Radiobutton;More Details:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
			}
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_043") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_044") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_045") ){
				assertTrue(click(selenium,rdoModerateToSevere),"Could not click the Moderate_to_Severe radiobutton;More Details:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
			}			

			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_046") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_047") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_048") ){
				assertTrue(click(selenium,rdoMildToSevere),"Could not click the Mild_to_Severe radiobutton;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
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
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_037") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_038") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_039") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_040") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_041") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_042") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_043") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_044") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_046") ){				
				assertTrue(editInteracWarn(selenium,interacWarn),"Navigation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
		    }
				
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_045") ){
				    assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
				    waitForPageLoad(selenium);
					assertTrue(click(selenium,rdoHighToSevere),"Could not click the High_to_Severe radiobutton;More Details:"+interacWarn.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium, btnWarningSave), "Could not click on Save button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);					
			 }	
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_047") ){
				assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
				assertTrue(click(selenium,rdoModerateToSevere),"Could not click the Moderate_to_Severe radio button;More Details:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnWarningSave), "Could not click on Save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
		     }
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_048") ){
				assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
				assertTrue(click(selenium,rdoHighToSevere),"Could not click the High_to_Severe radio button;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
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
			//  Step-10:Verify the impact at Provider level (New Provider Level)			
			//--------------------------------------------------------------------//
			
			
			if(!verifySeveretoSevereTransition(selenium,interacWarn,userAccount)){
				Assert.fail("Severe to Severe Transition did not happen properly; More Details :"+ interacWarn.toString());
				returnValue= false;
			}else
				returnValue=true;
												
			
						
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
public boolean verifySeveretoSevereTransition(Selenium selenium,ClinicalSettingLib interacWarn,String account) throws IOException{
		
		boolean returnValue=true;
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_037")){
			// Changed cannot be less than practice level
			// check if the msg is present "Because your practice level is set to show all warnings, you are not able to make any changes".		
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
			//assertTrue(selenium.isTextPresent(interacWarn.warning)," Warning text not present", selenium, ClassName, MethodName);
		}
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_038")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Changed cannot be less than practice level				
			// Check if the Moderate and Mild radio buttons are present and moderate radio button is checked
			assertTrue(selenium.isChecked(rdoModerateToSevere), "Moderate Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
							
			// Check if the MODERATE to SEVERE Warning msg is present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
		}

		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_039")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			
			// Changed cannot be less than practice level
			
			// Check if the High, Moderate and Mild radio buttons are present and High radio button is checked
			assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isChecked(rdoHighToSevere), "High Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
			
			// Check if the High to SEVERE Warning msg is present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;							
						
		}
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_040")){
						
			// Changed cannot be less than practice level
			// check if the msg is present "Because your practice level is set to show all warnings, you are not able to make any changes".		
			
			assertTrue(selenium.isTextPresent(interacWarn.warning), "Warning not found", selenium, ClassName, MethodName);
			
			 
		}
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_041")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Changed cannot be less than practice level
			
			// Check if the Moderate and Mild radio buttons are present and moderate radio button is checked
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isChecked(rdoModerateToSevere), "Moderate Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);				
			
			// Check if the MODERATE to SEVERE Warning msg is present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;	
							
		
		}

		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_042")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// No change
			
			// Check if the High, Moderate and Mild radio buttons are present and Severe radio button is checked
			assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isChecked(rdoHighToSevere), "High Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
			
			// Check if the SEVERE Warning msg is present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
							
						
		}
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_043")){
			
		   // Changed cannot be less than practice level
		   // check if the msg is present "Because your practice level is set to show all warnings, you are not able to make any changes".		
			
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
			 
		}
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_044")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// No Change
			
			// Check if the Moderate and Mild radio buttons are present and moderate radio button is checked
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isChecked(rdoModerateToSevere), "Moderate Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);				
			
			// Check if the MODERATE to SEVERE Warning msg is present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;	
							
		
		}

		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_045")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// No change
			
			// Check if the High, Moderate and Mild radio buttons are present and "moderate to severe" radio button is checked
			assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isChecked(rdoModerateToSevere), "Moderate Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
			
			// Check if the High to SEVERE Warning msg is present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
							
						
		}			
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_046")){
			
			// No change
			// check if the msg is present "Because your practice level is set to show all warnings, you are not able to make any changes".	
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
			 
		}
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_047")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// No Change
			// Check if the Moderate and Mild radio buttons are present and "mild to severe" radio button is checked
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isChecked(rdoMildToSevere), "Mild Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);				
			
			// Check if the MODERATE to SEVERE Warning msg is present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;	
		
		}

		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_048")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// No change				
			// Check if the High, Moderate and Mild radio buttons are present and "moderate to severe" radio button is checked
			assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isChecked(rdoMildToSevere), "Mild Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
			
			// Check if the High to SEVERE Warning msg is present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
		}
		
		return returnValue;		
}		
}