package com.nexia.selenium.testscripts.section.systemsettings.externalproviders;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForExternalProvider extends AbstractHomeTest{

	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a External Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void  verifyTabingOrderForExternalProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerTabOrder = new SystemSettingsLib();
		providerTabOrder.workSheetName = "CreateExternalProviders";
		providerTabOrder.testCaseId = "TC_EP_001";
		providerTabOrder.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabingOrderForAdminExternalProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerTabOrder);
	}
	/**
	 * verifyTabbingOrderForAdminExtenalProvider
	 * function to verify Tabbing Order For Admin Extenal Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 

	 * @since  	     Mar 16, 2012
	 */	
	public void verifyTabingOrderForAdminExternalProvider(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,SystemSettingsLib providerTabOrder) throws IOException{

		Selenium selenium=null;
		String csspaths[]={"css=#referringCode","css=#lastName","css=#mi","css=#credentials","css=#stateLicNum","css=#suggestBox","css=#billingExclusioncheckbox","css=#pecoscheckbox","css=#upin","css=#npi","css=#taxonomyCode","css=#comments","xpath=//input[starts-with(@id, 'practiceName')]","xpath=(//input[@type='text'])[16]"};
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//

			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerTabOrder .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerTabOrder.userName, providerTabOrder.userPassword),"Login Failed ",selenium, ClassName, MethodName);					

			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,providerTabOrder.switchRole)," Switch role failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to External Providers //
			//--------------------------------------------------------------------//

			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkSystemSettingLink ),"Could not click on link System Settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExternalProviderList),"Could not click on External Providers link:" + providerTabOrder .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//Go to Referring Provider
			click(selenium, lnkAddReferringProvider);
			waitForPageLoad(selenium);
			// Tab order // 
			for(int i =0;i<csspaths.length;i++){
				assertTrue(isElementPresent(selenium,csspaths[i]),"Not found",selenium, ClassName, MethodName);
				selenium.focus(csspaths[i]);
				waitForElementToEnable(selenium,csspaths[i]);
				selenium.keyPress(csspaths[i], "\\9");

				assertTrue(selenium.getElementIndex("dom=document.activeElement") == selenium.getElementIndex(csspaths[i]), 
						"Index of css paths not matched", selenium, ClassName, MethodName);

			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}
