package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class RemoveAssociatedProgramForInternalProvider extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Removing a Program in Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void removeAssociateProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateProvider";
		providerData.testCaseId = "TC_PO_001";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		removeProgramInProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/**
	 * removeProgramInProvider
	 * function to remove Program InProvider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 06, 2010
	 * 
	 */
	public boolean removeProgramInProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws IOException{
		
		Selenium selenium=null;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,providerData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Provider //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3:search Provider //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,txtProFirstName),"first  name not found", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtProFirstName,"john"),"Could not type the first name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSearchOrg2),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSearchProvider),"could not click the data;More Details"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4:Add Program //
			//--------------------------------------------------------------------//
			click(selenium,btnAddButton );
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"search"),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnDelete);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"//span/input"),"Could not click the check box"+providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			click(selenium,btnYes);
			//-------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!getText(selenium,"xpath=(//div[@id='providers']/table/tbody/tr/td)[2]").equals(providerData.program)){
				click(selenium,btnRemovePro);
				waitForPageLoad(selenium);
				click(selenium,btnYes);
				return true;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return false;
	}
}
