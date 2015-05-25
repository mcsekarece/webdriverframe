package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForProvider extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Tabbing order for Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabingOrderForProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerTabOrder = new SystemSettingsLib();
		providerTabOrder.workSheetName = "CreateProvider";
		providerTabOrder.testCaseId = "TC_PO_001";
		providerTabOrder.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabingOrderForProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerTabOrder);
	}
	/**
	 * verifyTabingOrderForProvider
	 * function to verify Tabing Order For Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
	public void verifyTabingOrderForProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerTabOrder) throws Exception{
		
		Selenium selenium=null;
		String csspaths[]={tabProviderTypesuggestBox,tabProviderCode,tabTitlesuggestBox,tabLastName,tabFirstName,tabMiddleName,tabCredentials,tabSpecialtysuggestBox,tabChosenSpecialties,tabGendersuggestBox,tabChosenLanguagePanel,tabCellPhone,tabPager,tabEmail,tabMaximumFTESuggestBoxsuggestBox,tabHoursWorked,tabcomments,tabMailingStreet1,tabMailingStreet2,tabMailingCity,tabMailingStatesuggestBox,tabMailingZipPostalCode,tabMailingCountrysuggestBox,tabMailingOfficePhone,tabMailingOfficePhoneExt,tabMailingFax,tabSameAsMailingAddresscheckbox,tabBillingStreet1,tabBillingStreet2,tabBillingCity,tabBillingStateSuggestBox1,tabBillingZipPostalCode,tabBillingCountrySuggestBox1};
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerTabOrder .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerTabOrder.userName, providerTabOrder.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,providerTabOrder.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to External Providers //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerTabOrder.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//------------------------  Step-3: Tab Order For Provider------------//
			//--------------------------------------------------------------------//
			for(int i =0;i<csspaths.length;i++){
				if(i==25)
				{
					click(selenium,tabSameAsMailingAddresscheckbox);
					waitForPageLoad(selenium);
				}
				assertTrue(isElementPresent(selenium,csspaths[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspaths[i]);
				waitForElementToEnable(selenium,csspaths[i]);
				selenium.keyPress(csspaths[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
				}
			}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
	}
}
