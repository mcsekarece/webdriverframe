package com.nexia.selenium.testscripts.section.systemsettings.consents;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class EditConsents extends AbstractSystemSettingsTest{
	
	@Test(groups={"Regression","Approved","firefox", "iexplore", "safari", "default" },description = "Test for Editing Admin Consents")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editConsentsForAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SystemSettingsLib adminEditConsentData = new SystemSettingsLib();
		adminEditConsentData.workSheetName="AdminNewConsent";
		adminEditConsentData.testCaseId="TT_ANC_001";
		adminEditConsentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		adminEditConsent(seleniumHost, seleniumPort, browser, webSite, userAccount, adminEditConsentData);
	}
	
	/**
	 * adminEditConsent
	 * function to admin Edit Consent
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     Apr 02, 2012
	 */
	
	public boolean adminEditConsent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemSettingsLib adminEditConsentData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//--------------  Step-1: Login to the application  ------------------//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminEditConsentData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, adminEditConsentData.userName, adminEditConsentData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,adminEditConsentData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-4: Go to Security Setting  --------------// 
			//--------------------------------------------------------------------//	
			
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			assertTrue(click(selenium, lnkSecuritysetting), "Could not click Security Settings link ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkconsentList),"Could not click the Admin consent; More details"+adminEditConsentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-5: Delete Consents  --------------// 
			//--------------------------------------------------------------------//	
			//--------------------------------------------------------------------//
			while(isElementPresent(selenium, btnDelete)){
				assertTrue(click(selenium, btnDelete),"Could not click delete button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnYes), "Could not click yes button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//---------------  Step-6: Create Consents  --------------// 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnConsent),"Could not click the add Consent; More details"+adminEditConsentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createConsents(selenium,adminEditConsentData),"Consents8Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-7: Edit Consents  --------------// 
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnEdit),"Could not click edit button; More Details"+adminEditConsentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			adminEditConsentData.workSheetName="AdminNewConsent";
			adminEditConsentData.testCaseId="TT_ANC_002";
			adminEditConsentData.fetchSystemSettingTestData();
			assertTrue(editConsents(selenium,adminEditConsentData),"Edit Consents Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.chooseOkOnNextConfirmation(); 
			click(selenium,btnEdit);
		//	selenium.getConfirmation();			
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStroeValue(selenium,adminEditConsentData), "Consents not saved properly;More Details:"+adminEditConsentData.toString(), selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStroeValue(Selenium selenium,SystemSettingsLib adminEditConsentData){
		waitForPageLoad(selenium);
		if(!getValue(selenium, ajxConsentSuggestBox).trim().contains(adminEditConsentData.consentType.trim())){
			return false;
		}
		if(!getValue(selenium,txtConsentName).trim().contains(adminEditConsentData.consentName.trim())){
			return false;
		}
		if(!getValue(selenium,txtValidNumInEdit).trim().contains(adminEditConsentData.validFor.trim())){
			return false;
		}
		if(!getValue(selenium,ajxRestrictionLevel).trim().contains(adminEditConsentData.restrictionLevel.trim())){
			return false;
		}
		return true;
	}
}
