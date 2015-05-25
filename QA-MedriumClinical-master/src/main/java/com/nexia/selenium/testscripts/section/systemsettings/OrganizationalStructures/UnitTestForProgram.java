package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForProgram extends AbstractSystemSettingsTest{
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "department Name With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void departmentNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest programData = new SystemsSettingsUnitTest();
		programData.workSheetName = "UnitTest_SS_Program";
		programData.testCaseId = "TC_SSP_001";
		programData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "program Name With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void programNameNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest programData = new SystemsSettingsUnitTest();
		programData.workSheetName = "UnitTest_SS_Program";
		programData.testCaseId = "TC_SSP_002";
		programData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "duplicate prograqm name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void duplicateProgramName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest programData = new SystemsSettingsUnitTest();
		programData.workSheetName = "UnitTest_SS_Program";
		programData.testCaseId = "TC_SSP_003";
		programData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Unknown provider Name ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unknownproviderName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest programData = new SystemsSettingsUnitTest();
		programData.workSheetName = "UnitTest_SS_Program";
		programData.testCaseId = "TC_SSP_004";
		programData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	/**
	 * addProgram
	 * function to add Program
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     Apr 02, 2012
	 */
	public boolean addProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemsSettingsUnitTest programData) throws IOException{
		Selenium selenium=null;
		String alertText="";
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
			assertTrue(switchRole(selenium,programData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Program //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			
			if(getText(selenium,"//div[@id='programs']/table/tbody/tr[2]/td/div/div",10000).contains(programData.unitProgram))
			{
				click(selenium,"//div[@id='programs']/table/tbody/tr[2]/td[2]/div/a");
				click(selenium,btnYes);

			}
			assertTrue(click(selenium,btnAddProgram),"Could not click on add a program link:" + programData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:  Enter Test Data and Submit                               //
			//--------------------------------------------------------------------//	
			if(!submitProgram(selenium, programData) && programData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
				if(isElementPresent(selenium,"//p")){
					alertText = getText(selenium, "//p");
					if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(programData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US")))){
						return returnValue;			
					}else{
						Assert.fail("An unxpected Alert is displayed with message; The Expected :"+programData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + programData.toString());
					}
				}else if(isElementPresent(selenium,"class=errorDialog")){
					alertText=getText(selenium,"class=errorDialog");
					if(alertText.toLowerCase(new java.util.Locale("en", "US")).contains(programData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US")))){
							return returnValue;			
					}else{
						Assert.fail("An unxpected Alert is displayed with message; The Expected :"+programData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + programData.toString());
						}
				}
				else if(isElementPresent(selenium,"noProviderFound")){
					alertText = getText(selenium, "noProviderFound");
				if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(programData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US")))){
				   		return returnValue;			
					}else{
						Assert.fail("An unxpected result is displayed; The Expected :"+programData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + programData.toString());
					}
				}else{
					Assert.fail("Alert is not getting displayed; More Details :" + programData.toString());
				}	
			}else if(programData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
				return returnValue;
			}else{
				Assert.fail("Expected Alert is not displayed; The Expected :"+programData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + programData.toString());
				}
				
		}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + programData.toString(), selenium, ClassName, MethodName);
			returnValue=false;
		}
		return returnValue;
	}
	public boolean submitProgram(Selenium selenium,SystemsSettingsUnitTest programData) throws IOException{
		try{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			isElementPresent(selenium,ajxSuggestBoxProg );
			selectValueFromAjaxList(selenium,"id=suggestBox",programData.department);
			if(programData.testCaseId.equalsIgnoreCase("TC_SSP_002")||programData.testCaseId.equalsIgnoreCase("TC_SSP_003"))
				assertTrue(type(selenium,typeProgramName ,programData.program),"Could not type a program name" + programData .toString(), selenium, ClassName, MethodName);
			else
			assertTrue(type(selenium,typeProgramName ,programData.program+uniqueName),"Could not type a program name" + programData .toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtdescription,programData.description),"Could not type a description" + programData .toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + programData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(programData.providerPresent.contains("Yes")){
				assertTrue(click(selenium,btnAddProvider),"Could not click on add additional provider:" + programData .toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtProviderSearchBox ,programData.provider),"Could not type a provider" + programData .toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,"id=searchButton"),"Could not click on search a provider:" + programData .toString(), selenium, ClassName, MethodName);
				if(isElementPresent(selenium,"//span/input"))
				{
					assertTrue(click(selenium,"//span/input"),"Could not click the provider:" + programData .toString(), selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
			}
			if(isElementPresent(selenium,lblTitle)){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
}
