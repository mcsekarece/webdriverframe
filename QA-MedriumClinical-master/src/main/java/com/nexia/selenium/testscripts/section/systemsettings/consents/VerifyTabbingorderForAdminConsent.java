package com.nexia.selenium.testscripts.section.systemsettings.consents;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingorderForAdminConsent extends AbstractSystemSettingsTest{
	@Test(groups={"Regression","Approved","firefox", "iexplore", "safari", "default" },description = "Test for Adding a New Admin Consents")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForConsents(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SystemSettingsLib adminConsentTabOrder = new SystemSettingsLib();
		adminConsentTabOrder.workSheetName="AdminNewConsent";
		adminConsentTabOrder.testCaseId="TT_ANC_001";
		adminConsentTabOrder.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingOrderForadminConsent(seleniumHost, seleniumPort, browser, webSite, userAccount, adminConsentTabOrder);
	}
	
	/**
	 * verifyTabbingOrderForAdminConsent
	 * function to verify verify Tabbing Order For admin Consent
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     Mar 16, 2012
	 */	
	public void verifyTabbingOrderForadminConsent(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,SystemSettingsLib adminConsentTabOrder) throws IOException{
		Selenium selenium=null;
		String csspaths[]={"css=#consentTypeSuggestBoxsuggestBox","css=#consentName","css=#validForNumber","css=#validForType","css=#restrictionLevelSuggestBoxsuggestBox"};
		try{
			//--------------------------------------------------------------------//
			//--------------  Step-1: Login to the application  ------------------//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminConsentTabOrder.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, adminConsentTabOrder.userName, adminConsentTabOrder.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,adminConsentTabOrder.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-2: Go to System Setting  --------------// 
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSecuritysetting),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkconsentList),"Could not click the Admin consent; More details"+adminConsentTabOrder.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Go to consent
			assertTrue(click(selenium, btnConsent ), "Could not click Consent button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Tab order // 
			for(int i =0;i<csspaths.length;i++){
				assertTrue(isElementPresent(selenium,csspaths[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspaths[i]);
				waitForElementToEnable(selenium,csspaths[i]);
				selenium.keyPress(csspaths[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
				}
			
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}
