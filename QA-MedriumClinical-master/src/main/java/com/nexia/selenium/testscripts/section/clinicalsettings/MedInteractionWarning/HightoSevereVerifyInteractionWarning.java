package com.nexia.selenium.testscripts.section.clinicalsettings.MedInteractionWarning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class HightoSevereVerifyInteractionWarning extends AbstractClinicalSettings {
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHightoSeveretoMildInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_028";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHightoSeveretoModerateInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_029";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHightoSeveretoSevereInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_030";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHightoModeratetoMildInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_031";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHightoModeratetoModerateInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_032";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHightoModeratetoSevereInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_033";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHightoMildtoMildInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_034";
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
		interacWarn.testCaseId = "TC_IWM_035";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHightoMildtoModerateInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_036";
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
			//  set to High to Severe
			//--------------------------------------------------------------------//
					
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,rdoHighToSevere),"Could not click the mild to severe checkbox;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium, btnWarningSave), "Could not click on Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to System Setting to Provider Level
			//--------------------------------------------------------------------//
			assertTrue(navigateToMySettingsInteracWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Edit Interaction Warning at Provider level (old Provider Level)
			//  set to High, Moderate and Mild
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_028") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_029") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_030") ){
				
			assertTrue(click(selenium,rdoHighToSevere),"Could not click High_to_Severe radiobutton;More Details:"+interacWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			}
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_031") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_032") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_033") ){
				assertTrue(click(selenium,rdoModerateToSevere),"Could not click the Moderate_to_Severe radiobutton;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
			}
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_034") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_035") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_036") ){
				assertTrue(click(selenium,rdoMildToSevere),"Could not click the Mild_to_Severe Radiobutton;More Details:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}			

			assertTrue(click(selenium, btnWarningSave), "Could not click on Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Clinical Setting, new Practice level change 
			//--------------------------------------------------------------------//
			assertTrue(navigateToInteracWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-8:Edit Interaction Warning at Practice level (New Practice Level)  
			//--------------------------------------------------------------------//
			
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_028") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_029") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_030") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_031") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_032") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_034")){
				
				assertTrue(editInteracWarn(selenium,interacWarn),"Navigation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
		    	}
				
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_033") || interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_036")){
				    assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
				    waitForPageLoad(selenium);
					assertTrue(click(selenium,rdoSevereOnly),"Could not click the Severe_Only Radiobutton;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium, btnWarningSave), "Could not click on Save button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);					
			 }	
			
			if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_035") ){
				assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
				assertTrue(click(selenium,rdoModerateToSevere),"Could not click the Moderate_to_Severe Radiobutton;More Deatils:"+interacWarn.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnWarningSave), "Could not click on Save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
		     }
			
			
			//--------------------------------------------------------------------//
			//  Step-9: Navigate to System Setting, New Provider Level
			//--------------------------------------------------------------------//
			assertTrue(navigateToMySettingsInteracWarn(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10:Verify the Impact at the Provider level (New Provider Level)			
			//--------------------------------------------------------------------//
				
			assertTrue(verifyHightoSevereTransition(selenium,interacWarn,userAccount),"High to Severe Transition did not happen properly; More Details :"+ interacWarn.toString(), selenium, ClassName, MethodName);
						

						
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
public boolean verifyHightoSevereTransition(Selenium selenium,ClinicalSettingLib interacWarn,String account) throws IOException{
		
		boolean returnValue=true;
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_028")){
		    // Changed cannot be less than practice level
			// check if the msg is present "Because your practice level is set to show all warnings, you are not able to make any changes".		
			
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
			//assertTrue(selenium.isTextPresent(interacWarn.warning)," Warning text not present", selenium, ClassName, MethodName);			 
		}
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_029")){
			
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

		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_030")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			// Check if the Severe, High, Moderate and Mild radio buttons are present and "Severe" radio button is checked
			assertTrue(selenium.isVisible(rdoSevereOnly), "Severe Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isChecked(rdoSevereOnly), "Severe Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
			
		// Check if the SEVERE Warning message present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;		
						
		}
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_031")){
			// Changed cannot be less than practice level
			// check if the msg is present "Because your practice level is set to show all warnings, you are not able to make any changes".		
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
			 
		}
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_032")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Check if the Moderate and Mild radio buttons are present and "Moderate to Severe" radio button is checked
			assertTrue(selenium.isChecked(rdoModerateToSevere), "Moderate Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
		
			// Check if the "MODERATE to SEVERE" Warning msg is present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
		}

		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_033")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// No Change				
			// Check if the Severe, High, Moderate and Mild radio buttons are present and "Moderate to Severe" radio button is checked
			assertTrue(selenium.isVisible(rdoSevereOnly), "Severe Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isChecked(rdoModerateToSevere), "Moderate Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
			
			// Check if the SEVERE Warning msg is present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;
		}
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_034")){				
			// No Change
			// 	check if the msg is present "Because your practice level is set to show all warnings, you are not able to make any changes".				
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;				
			
		}
		
		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_035")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// No Change
			
			// Check if the Moderate and Mild radio buttons are present and "mild tp severe" radio button is checked
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isChecked(rdoMildToSevere), "Mild Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);				
			
			// Check if the MODERATE to SEVERE Warning msg is present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;							
		
		}

		if(interacWarn.testCaseId.equalsIgnoreCase("TC_IWM_036")){
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// No Change				
			// Check if the Severe, High, Moderate and Mild radio buttons are present and "Severe Only" radio button is checked
			assertTrue(selenium.isVisible(rdoSevereOnly), "Severe Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoHighToSevere), "High Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoModerateToSevere), "Moderate Radio Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isChecked(rdoMildToSevere), "Mild Radio Button is not checked", selenium, ClassName, MethodName);
			assertTrue(selenium.isVisible(rdoMildToSevere), "Mild Radio Button is not present", selenium, ClassName, MethodName);
			
			// Check if the SEVERE Warning msg is present
			if(selenium.isTextPresent(interacWarn.warning)){
				return true;
			}else
				return false;			
		}			
			
		return returnValue;
	
}

}