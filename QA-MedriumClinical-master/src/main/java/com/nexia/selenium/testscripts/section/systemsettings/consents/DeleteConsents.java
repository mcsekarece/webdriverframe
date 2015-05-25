package com.nexia.selenium.testscripts.section.systemsettings.consents;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteConsents extends AbstractSystemSettingsTest{
	@Test(groups={"Regression","Approved","firefox", "iexplore", "safari", "default" },description = "Test for Deleteing Admin Consents")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteConsentsForAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SystemSettingsLib deleteConsentData = new SystemSettingsLib();
		deleteConsentData.workSheetName="AdminNewConsent";
		deleteConsentData.testCaseId="TT_ANC_001";
		deleteConsentData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		adminDeleteConsent(seleniumHost, seleniumPort, browser, webSite, userAccount, deleteConsentData);
	}
	
	/**
	 * adminDeleteConsent
	 * function to admin Delete Consent
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	     May 24, 2012
	 */
	public boolean adminDeleteConsent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib deleteConsentData) throws Exception{
		boolean returnValue= true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//--------------  Step-1: Login to the application  ------------------//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + deleteConsentData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, deleteConsentData.userName, deleteConsentData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,deleteConsentData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-3: Go to System Setting  --------------// 
			//--------------------------------------------------------------------//	
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSecuritysetting), "Could not click Security Settings link" , selenium, ClassName, MethodName);
						
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkconsentList),"Could not click the Admin consent; More details"+deleteConsentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-4: Delete Consents  --------------// 
			//--------------------------------------------------------------------//	
			//--------------------------------------------------------------------//
			while(isElementPresent(selenium, btnDelete )){
				assertTrue(click(selenium,btnDelete),"Could not click delete button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnYes), "Could not click yes button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//---------------  Step-5: Create Consents  --------------// 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnConsent ),"Could not click the add Consent; More details"+deleteConsentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createConsents(selenium,deleteConsentData),"Consents Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-6: Delete newly added consents//
			//--------------------------------------------------------------------//
			while(isElementPresent(selenium, btnDelete)){
				assertTrue(click(selenium, btnDelete),"Could not click delete button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnYes), "Could not click yes button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}


