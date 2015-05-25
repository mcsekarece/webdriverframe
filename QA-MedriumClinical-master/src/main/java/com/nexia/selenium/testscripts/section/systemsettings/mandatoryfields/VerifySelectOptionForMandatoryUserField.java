package com.nexia.selenium.testscripts.section.systemsettings.mandatoryfields;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectOptionForMandatoryUserField extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding an Identifier type")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void selectOptionForMandatoryUserField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "CreateMandatoryField";
		mandData.testCaseId = "TC_MF_001";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySelectOptionForMandatoryUserField(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
	}
	/**
	 * verifySelectOptionForMandatoryUserField
	 * function to verify Select Option For Mandatory User Field
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    July 06, 2012
	 */
	public boolean verifySelectOptionForMandatoryUserField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib mandData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mandData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, mandData.userName, mandData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,mandData.switchRole),"Swicth role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Mandatory User Field //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminMandatoryUserField),"Could not click on Mandatory User Field link:" + mandData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkAddMandatoryUserField);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			// Step-2:Select Option For Mandatory User Field //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,ajxUnitSuggestBox ,mandData.unit);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxUnitSuggestBox ,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lstItemSelectedMan))
			{
				if(getText(selenium,lstItemSelectedMan).equalsIgnoreCase(mandData.unit))
					if(isElementPresent(selenium,lstSuggestBoxOracleMan ))
					{
						returnValue=true;
						click(selenium,lstItemSelectedMan);
					}
			}
			else
				return false;
			
			selectValueFromAjaxList(selenium,ajxFieldSuggestBox,mandData.field);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxFieldSuggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lstItemSelectedMan)){
				if(getText(selenium,lstItemSelectedMan).equalsIgnoreCase(mandData.field))
					if(isElementPresent(selenium,lstSuggestBoxOracleMan ))
					{
						returnValue=true;
						click(selenium,lstItemSelectedMan);
					}
			}
			else
				return false;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
