package com.nexia.selenium.testscripts.section.templateSetup.daysheettemplate;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.templateSetup.AbstractTemplateSetup;
import com.nexia.selenium.genericlibrary.templateSetup.TemplateSetupLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelInPrintCalendarReport extends AbstractTemplateSetup {
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify 'cancel' in print calendar report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelInPrintCalendarReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupLib daySheetTemplateTestData = new TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "CreateTemplateSetup";
		daySheetTemplateTestData.testCaseId = "TC_TS_001";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}

	/*************************************************************************************************** 
	* @purpose        verify 'cancel' in print calendar report
	* @action 		  verifying 'cancel' in print calendar report
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 28, 2013	
	***************************************************************************************************/
	
	public boolean daySheetTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TemplateSetupLib daySheetTemplateTestData ) throws IOException, AWTException, InterruptedException{
		
		Selenium selenium=null;
		boolean returnValue=false;

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
			//  Step-3: Navigate to Print Calendar		  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToPrintCalendar(selenium),"Could not navigate to print calendar", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify 'cancel' in Print Calendar report				  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnCancel), "Could not click on cancel in print calendar report", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium, lnkPrintReport)){
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
