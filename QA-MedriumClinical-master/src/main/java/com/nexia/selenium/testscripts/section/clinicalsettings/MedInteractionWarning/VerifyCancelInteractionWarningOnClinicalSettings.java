package com.nexia.selenium.testscripts.section.clinicalsettings.MedInteractionWarning;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelInteractionWarningOnClinicalSettings extends AbstractClinicalSettings{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Save action for interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelForInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib interacWarn = new ClinicalSettingLib();
		interacWarn.workSheetName = "InteractionWarning";
		interacWarn.testCaseId = "TC_IWM_001";
		interacWarn.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySaveAction(seleniumHost, seleniumPort, browser, webSite, userAccount, interacWarn);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify cancel action for interaction warning management
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
			
			interacWarn.workSheetName = "InteractionWarning";
			interacWarn.testCaseId = "TC_IWM_002";
			interacWarn.fetchClinicalSettingsTestData();
			
			assertTrue(editInteracWarn(selenium,interacWarn),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Verify saved warning option //
			//--------------------------------------------------------------------//
			
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

	public boolean verifyWarning(Selenium selenium,ClinicalSettingLib interacWarn) throws IOException{
		boolean returnValue=true;
		
		assertTrue(!isTextPresent(selenium,interacWarn.warning),"Could not find return statement", selenium, ClassName, MethodName);
		return returnValue;
	}
}