package com.nexia.selenium.testscripts.section.systemsettings.consents;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyConsentsIncludeInactive extends AbstractSystemSettingsTest{

	@Test(groups={"Regression","Approved","firefox", "iexplore", "safari", "default" },description = "Test for Adding a New Admin Consents")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createConsentsForAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SystemSettingsLib adminConsentData = new SystemSettingsLib();
		adminConsentData.workSheetName="AdminNewConsent";
		adminConsentData.testCaseId="TT_ANC_003";
		adminConsentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		adminCreateConsent(seleniumHost, seleniumPort, browser, webSite, userAccount, adminConsentData);
	}

	/**
	 * adminCreateConsent
	 * function to admin Create Consent
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 

	 * @since  	     May 02, 2012
	 */
	public boolean adminCreateConsent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemSettingsLib adminConsentData) throws IOException{
		boolean returnValue= true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//--------------  Step-1: Login to the application  ------------------//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminConsentData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, adminConsentData.userName, adminConsentData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,adminConsentData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			

			//--------------------------------------------------------------------//
			//---------------  Step-3: Go to System Setting  --------------// 
			//--------------------------------------------------------------------//
			click(selenium,lnkQuickAction);
			waitForPageLoad(selenium);
			click(selenium,lnkSecuritySettings);

			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkconsentList),"Could not click the Admin consent; More details"+adminConsentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-4: Delete Consents  --------------// 
			//--------------------------------------------------------------------//
			if(isChecked(selenium,chkConsentCheckBox ))
			assertTrue(click(selenium, chkConsentCheckBox),"Could not click delete button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(selenium.isTextPresent(adminConsentData.consentType+" - "+adminConsentData.consentName))
			{	
				while(isElementPresent(selenium, btnDelete )){
					assertTrue(click(selenium, btnDelete ),"Could not click delete button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnYes), "Could not click yes button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				if(!isChecked(selenium,chkConsentCheckBox))
					assertTrue(click(selenium, chkConsentCheckBox),"Could not click delete button", selenium, ClassName, MethodName);
				if(selenium.isTextPresent(adminConsentData.consentType+" - "+adminConsentData.consentName))
					return true;
				else{
					assertTrue(false, "The deleted medication is not displayed in the include inactives page", selenium, ClassName, MethodName);
				}	
				return true;
			}
			else
				assertTrue(click(selenium, chkConsentCheckBox),"Could not click delete button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(selenium.isTextPresent(adminConsentData.consentType+" - "+adminConsentData.consentName))
				return true;
			else
			{
				if(isChecked(selenium,chkConsentCheckBox))
					assertTrue(click(selenium, chkConsentCheckBox),"Could not click delete button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				while(isElementPresent(selenium,  btnDelete)){
					assertTrue(click(selenium, btnDelete),"Could not click delete button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium, btnYes), "Could not click yes button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				assertTrue(click(selenium,btnConsent),"Could not click the add Consent; More details"+adminConsentData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createConsents(selenium,adminConsentData),"Consents Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				

				if(selenium.isTextPresent(adminConsentData.consentType+" - "+adminConsentData.consentName))
					returnValue = true;
				else
					returnValue = false;

				click(selenium, "link=Edit");
				waitForPageLoad(selenium);

				//--------------------------------------------------------------------//
				//  Step-6: Verifying Entered Details are saved properly  //
				//--------------------------------------------------------------------//
				assertTrue(verifyStoreValue(selenium,adminConsentData), "Contacts details not saved properly in contacts page :"+ adminConsentData.toString(), selenium, ClassName, MethodName);
				
				assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ adminConsentData.toString(), selenium, ClassName, MethodName);
				while(isElementPresent(selenium,  btnDelete)){
					assertTrue(click(selenium,  btnDelete),"Could not click delete button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium, btnYes), "Could not click yes button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				if(!isChecked(selenium,chkConsentCheckBox ))
					assertTrue(click(selenium,chkConsentCheckBox ),"Could not click delete button", selenium, ClassName, MethodName);
				
				while(getText(selenium, lnkConsentShowMore).equalsIgnoreCase("Show more...")){
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					assertTrue(click(selenium, lnkConsentShowMore),"could not click on show more button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
				}
				
				assertTrue(selenium.isTextPresent(adminConsentData.consentType+" - "+adminConsentData.consentName), 
						"The deleted medication is not displayed in the include inactive page",selenium, ClassName, MethodName);
				
			}

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);

		}
		return returnValue;
	}

	public boolean verifyStoreValue(Selenium selenium,SystemSettingsLib adminConsentData){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajxConsentSuggestBox).toLowerCase(new java.util.Locale("en","Us")).trim().contains(adminConsentData.consentType.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getValue(selenium,txtConsentName).toLowerCase(new java.util.Locale("en","Us")).trim().contains(adminConsentData.consentName.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getValue(selenium,"validForNumberInputFieldId").toLowerCase(new java.util.Locale("en","Us")).trim().contains(adminConsentData.validFor.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getValue(selenium,ajxRestrictionLevel).toLowerCase(new java.util.Locale("en","Us")).trim().contains(adminConsentData.restrictionLevel.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		return true;
	}
}