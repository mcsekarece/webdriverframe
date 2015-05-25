package com.nexia.selenium.testscripts.section.systemsettings.directories;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class TabbingOrderForDirectories extends AbstractSystemSettingsTest{
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Tabbing a Directories")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabingorderForDirectories(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib directoriesTabOrder = new SystemSettingsLib();
		directoriesTabOrder.workSheetName = "CreateDirectories";
		directoriesTabOrder.testCaseId = "TC_CDIR_001";
		directoriesTabOrder.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingorderForDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, directoriesTabOrder);
	}
	/**
	 * verifyTabbingorderForDirectories
	 * function to verify Tabbing order For Directories
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		InterruptedException 
	 
	 * @since  	    Aug 27, 2012
	*/
	public void verifyTabbingorderForDirectories(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,SystemSettingsLib directoriesTabOrder) throws IOException{
		Selenium selenium=null;
		String csspaths[]={"css=#pharmacyName","css=#addr1","css=#city","css=#stateSuggestBoxsuggestBox","css=#zip","css=#countrySuggestBoxsuggestBox","css=#phone","css=#phoneExtension","css=#fax","css=#email","css=#website","css=#titlesuggestBox","css=#lastName","css=#firstName","css=#commentTextBoxId"};
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + directoriesTabOrder .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, directoriesTabOrder.userName, directoriesTabOrder.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			//assertTrue(switchRole(selenium,directoriesTabOrder.switchRole));
			//waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Directories //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickLink),"Could not click on System settings link:" + directoriesTabOrder .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingLink),"Could not click on System settings link:" + directoriesTabOrder .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkDirectories),"Could not click the Directories link;More Details:"+directoriesTabOrder.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNew),"Could not click the add Directories; More details"+directoriesTabOrder.toString(), selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Tabbing order For Directories//
			//--------------------------------------------------------------------//
			for(int i =0;i<csspaths.length;i++){
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,csspaths[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspaths[i]);
				waitForElementToEnable(selenium,csspaths[i]);
				selenium.keyPress(csspaths[i], btnEnter2);
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
			}
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}
