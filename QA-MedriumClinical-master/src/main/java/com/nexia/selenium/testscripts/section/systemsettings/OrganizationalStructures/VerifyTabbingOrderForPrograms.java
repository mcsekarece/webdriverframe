package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForPrograms extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a External Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForPrograms(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib programData = new SystemSettingsLib();
		programData.workSheetName = "CreateProgram";
		programData.testCaseId = "TC_CP_001";
		programData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingOrderForProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	/**
	 * verifyTabbingOrderForProgram
	 * function to verify Tabbing Order For Program
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
	public void verifyTabbingOrderForProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib programData) throws Exception{
	
		Selenium selenium=null;
		String csspaths[]={tabSuggestBox,tabProgramName,tabDescription};
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + programData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, programData.userName, programData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			/*assertTrue(switchRole(selenium,programData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to External Providers //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			assertTrue(click(selenium,btnAddProgram),"Could not click add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			// Step-3:Tab order													 // 
			//--------------------------------------------------------------------//
			for(int i =0;i<csspaths.length;i++){
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
