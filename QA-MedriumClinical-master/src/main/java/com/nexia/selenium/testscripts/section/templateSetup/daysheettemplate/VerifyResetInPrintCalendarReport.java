package com.nexia.selenium.testscripts.section.templateSetup.daysheettemplate;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.templateSetup.AbstractTemplateSetup;
import com.nexia.selenium.genericlibrary.templateSetup.TemplateSetupLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyResetInPrintCalendarReport extends AbstractTemplateSetup {
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify 'reset' in print calendar report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyResetInPrintCalendarReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupLib daySheetTemplateTestData = new TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "CreateTemplateSetup";
		daySheetTemplateTestData.testCaseId = "TC_TS_001";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}

	/*************************************************************************************************** 
	* @purpose        verify 'reset' in print calendar report
	* @action 		  verifying 'reset' in print calendar report
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
			//  Step-4: Enter data's and click 'reset' in Print Calendar report	  //
			//--------------------------------------------------------------------//
			assertTrue(verifyResetInPrintCalendarReport(selenium, daySheetTemplateTestData,userAccount), "Could not verify print calendar", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnReset), "Could not click on reset button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify 'reset' in Print Calendar report	  				  //
			//--------------------------------------------------------------------//
			
			//After "Reset", Verify 'search resource' field is empty by default
			if(!getText(selenium,txtSearchResource).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase("")){
				return false;
			}
			
			//After "Reset", Verify 'select all' should not checked
			if(isChecked(selenium, chkSelectAllResource)){
				return false;
			}
			
			//get the total number of resources available
			int resourceCount=(Integer) selenium.getXpathCount("//div[@class='display-table searchResourcesPanel']/div");
			
			//After "Reset", Verify none of the resource name should checked
			for(int count=1; count<=resourceCount; count++){
				if(isChecked(selenium, "//div[@class='display-table searchResourcesPanel']/div["+count+"]/span/input")){
					Assert.fail("The following resource names is checked after 'reset':: "+ getText(selenium, "//div[@class='display-table searchResourcesPanel']/div["+count+"]/div"));
				}
			}
			
			//After "reset", the resource names in the added resource also gone.. So, verify the "No resource has been added" message" 
			if(!getText(selenium,lblNoAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains("No resource has been added".trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
			//After "Reset", Verify 'Print Report Today' should be selected
			if(!isChecked(selenium, rdoPrintReportToday)){
				return false;
			}
			
			//After "Reset", Verify 'Print Report full day' should be selected
			if(!isChecked(selenium, rdoPrintReportFullDay)){
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
