package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceCalendars;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreateNewProviderWD extends AbstractSchedulingTest{
	
	WebDriver driver = null;	
	@Test(groups = {"CalendarUIWD","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Provider", priority=2)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateProvider";
		providerData.testCaseId = "TC_PO_010";
		providerData.fetchSystemSettingTestData();
		createProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Provider - BAC-416", priority=2)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewProvider2(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateProvider";
		providerData.testCaseId = "TC_PO_011";
		providerData.fetchSystemSettingTestData();
		createProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Provider - BAC-416", priority=2)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewProvider3(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateProvider";
		providerData.testCaseId = "TC_PO_012";
		providerData.fetchSystemSettingTestData();
		createProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	/**
	 * createProvider
	 * function to create Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     Sept 17, 2014
	 */
	public boolean createProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		
			Selenium selenium=null;
			boolean returnValue=true;
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				
				driver = getWebdriver(seleniumHost, seleniumPort, browser, webSite, ClassName, MethodName, driver);
				assertTrue(loginForNexiaForWebdriver(driver, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-2: Navigate to System Settings								  //
				//--------------------------------------------------------------------//
			
				assertTrue(gotoSystemSetting(driver),"Could not navigate to System setting", driver, ClassName, MethodName);
			    
				
				
				//--------------------------------------------------------------------//
				//  Step-3: Delete Provider //
				//--------------------------------------------------------------------//
				assertTrue(click(driver,lnkOrgStructures),"Could not click the Org Structure;More Details:"+providerData.toString(), driver, ClassName, MethodName);
				/* providerData.workSheetName = "CreateProvider";
				providerData.testCaseId = "TC_PO_010";
				providerData.fetchSystemSettingTestData();*/
				
				assertTrue(deleteProvider(driver,providerData),"Could not delete the provider", driver, ClassName, MethodName);
								
				//--------------------------------------------------------------------//
				//  Step-4: Create Provider //
				//--------------------------------------------------------------------//
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("ddMMyyHHmm");
				String uniqueName=DateFormat.format(cal.getTime());
		
				assertTrue(click(driver,"addProvider"),"Could not click on provider link:" + providerData .toString(), driver, ClassName, MethodName);
				
				assertTrue(createProviderWithMandatory(driver,providerData,userAccount ),"Provider creation Failed", driver, ClassName, MethodName);				
				
						
				
				//--------------------------------------------------------------------//
				//  Step-5: Verifying Entered Details are saved properly  //
				//--------------------------------------------------------------------//
				
			/*	assertTrue(click(driver,btnEdit2),"Could not click the edit button"+providerData.toString(), driver, ClassName, MethodName);
				
				if(!verifyStoredValuesProvider(driver,providerData)){
					fail("User details not saved properly; More Details :"+ providerData.toString());
					returnValue=false;
				}else
					return returnValue;*/
				
				//--------------------------------------------------------------------//
				//  Step-6: Click on Particular Practice (Automation Nexia)			  //
				//--------------------------------------------------------------------//
				
				assertTrue(click(driver,lnkOrgStructures),"Could not click on organizational structure" + providerData .toString(), driver, ClassName, MethodName);				
				assertTrue(click(driver, lblAutomationNexia),"Could not click Particular Practice",driver, ClassName, MethodName);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				assertTrue(click(driver, btnAddNew),"Could not click on Add New Association",driver, ClassName, MethodName);
				waitForPageLoad(driver);
				
				//--------------------------------------------------------------------//
				//  Step-7: Search a Provider 										  //
				//--------------------------------------------------------------------//
			    
				assertTrue(type(driver,txtSearchProvider,providerData.firstName),"Could not enter the Provider FirstName",driver, ClassName, MethodName);	
				assertTrue(click(driver, btnSearchProvider),"Could not click on Search Provider Button",driver, ClassName, MethodName);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				
				assertTrue(clickXPath(driver, chkProvider),"Could not click on Provider CheckBox",driver, ClassName, MethodName);
				assertTrue(click(driver, btnSave2),"Could not click on Save Associated Provider",driver, ClassName, MethodName);
				
								
								
			}catch (RuntimeException e){
				e.printStackTrace();
				fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString());
			}
			return returnValue;
		}
	
	public boolean verifyStoredValuesProvider(WebDriver driver,SystemSettingsLib providerData) throws IOException, InterruptedException{
		
		//assertTrue(getText(driver,"providerTypesuggestBox").trim().contains(providerData.providerType.trim()),"Could not get the providerType"+providerData.toString(), driver, ClassName, MethodName);
			
		//assertTrue(getText(driver,txtLastname).trim().contains(providerData.lastName.trim()),"Could not get the LastName"+providerData.toString(), driver, ClassName, MethodName);
		
		assertTrue(driver.getPageSource().contains(providerData.lastName.trim()),"Could not get the LastName"+providerData.toString(), driver, ClassName, MethodName);
		
		Thread.sleep(5000);			
		
		return true;
	}
	
	
	@AfterClass(alwaysRun = true) 
	public void testDown() throws Exception {
		try { 
	driver.quit();
	copyWebDriverLogs(driver,ClassName, MethodName);
	 
	} 
	finally { 
	driver.quit(); 
	} 
	}
	
}
