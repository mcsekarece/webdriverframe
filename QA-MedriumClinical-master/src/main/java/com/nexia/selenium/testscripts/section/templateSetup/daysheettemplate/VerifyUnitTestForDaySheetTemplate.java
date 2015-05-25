package com.nexia.selenium.testscripts.section.templateSetup.daysheettemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.templateSetup.AbstractTemplateSetup;
import com.nexia.selenium.genericlibrary.templateSetup.TemplateSetupUnitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnitTestForDaySheetTemplate extends AbstractTemplateSetup {
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Day sheet template name with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDaySheetTemplateNameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_CreateTemplateSetup";
		daySheetTemplateTestData.testCaseId = "TC_UTS_001";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}

	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Day sheet template name with invalid file name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDaySheetTemplateNameWithInvalidFileName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_CreateTemplateSetup";
		daySheetTemplateTestData.testCaseId = "TC_UTS_002";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Day sheet template name with invaild format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDaySheetTemplateNameWithInvalidFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_CreateTemplateSetup";
		daySheetTemplateTestData.testCaseId = "TC_UTS_003";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThreadUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Day sheet template name with invalid template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDaySheetTemplateNameWithInvalidTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupUnitLib daySheetTemplateTestData = new TemplateSetupUnitLib();
		daySheetTemplateTestData.workSheetName = "UnitTest_CreateTemplateSetup";
		daySheetTemplateTestData.testCaseId = "TC_UTS_004";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, daySheetTemplateTestData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify unit test in day sheet template
	* @Specification  SRS_SCH_ADMIN_Day Sheets_Rev0.0
	* @action 		  Verifying unit test in day sheet template
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 29, 2013
	***************************************************************************************************/
	
	public boolean daySheetTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TemplateSetupUnitLib daySheetTemplateTestData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + daySheetTemplateTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, daySheetTemplateTestData.userName, daySheetTemplateTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,daySheetTemplateTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Day sheet template  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToDaySheetTemplate(selenium),"Could not navigate to day sheet template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Add new day sheet Template for unit test				  //
			//--------------------------------------------------------------------//
			assertTrue(addNewDaySheetTemplateUnitTest(selenium, daySheetTemplateTestData,userAccount), "Could not Add new day sheet template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Verify Unit Test Functionality For day sheet Template	  //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium, daySheetTemplateTestData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, daySheetTemplateTestData.validationFieldID).contains(daySheetTemplateTestData.validationMessage), "The expected validation message should contain the text - "+ daySheetTemplateTestData.validationMessage + " The actual validation message shown - " + getText(selenium, daySheetTemplateTestData.validationFieldID), selenium, ClassName, MethodName);
				
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}