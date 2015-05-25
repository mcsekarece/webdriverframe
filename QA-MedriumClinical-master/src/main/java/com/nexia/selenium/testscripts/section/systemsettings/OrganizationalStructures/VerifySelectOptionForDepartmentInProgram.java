package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectOptionForDepartmentInProgram extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchResultForDepartmentForProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib programData = new SystemSettingsLib();
		programData.workSheetName = "CreateProgram";
		programData.testCaseId = "TC_CP_001";
		programData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySearchResultForDepartment(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	/**
	 * verifySearchResultForDepartment
	 * function to verify Search Result For Department
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    July 05, 2012
	 */
	public boolean verifySearchResultForDepartment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib programData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
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
			//  Step-2: Go to System Settings and navigate to Internal Programs //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium, lnkSettings), "Could not click on Quick Actions button");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium, lnkSystemSettingLink), "Could not click on system setting link");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddProgram),"Could not click on add a program link:" + programData .toString(), selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Add an Internal Programs //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,ajxSuggestBoxProg ,programData.department);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxSuggestBoxProg , "");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lstItemSelected)){
				if(getText(selenium,lstItemSelected).equalsIgnoreCase(programData.country))
					if(isElementPresent(selenium,lstSuggestBoxOracle))
						returnValue=true;
			}
			else
				returnValue=false;
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			returnValue=false;
		}return returnValue;
	}	
}
