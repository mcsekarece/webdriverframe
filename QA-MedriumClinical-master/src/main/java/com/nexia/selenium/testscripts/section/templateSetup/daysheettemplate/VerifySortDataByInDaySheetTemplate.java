package com.nexia.selenium.testscripts.section.templateSetup.daysheettemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.templateSetup.AbstractTemplateSetup;
import com.nexia.selenium.genericlibrary.templateSetup.TemplateSetupLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySortDataByInDaySheetTemplate extends AbstractTemplateSetup {
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Sort Data By Appoinment Time in day sheet template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySortDataByAppoinmentTime(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupLib daySheetTemplateTestData = new TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "CreateTemplateSetup";
		daySheetTemplateTestData.testCaseId = "TC_TS_003";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Sort Data By Chart Number in day sheet template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySortDataByChartNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupLib daySheetTemplateTestData = new TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "CreateTemplateSetup";
		daySheetTemplateTestData.testCaseId = "TC_TS_004";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Sort Data By Patient ID in day sheet template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySortDataByPatientID(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupLib daySheetTemplateTestData = new TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "CreateTemplateSetup";
		daySheetTemplateTestData.testCaseId = "TC_TS_005";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Sort Data By Patient Name in day sheet template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySortDataByPatientName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupLib daySheetTemplateTestData = new TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "CreateTemplateSetup";
		daySheetTemplateTestData.testCaseId = "TC_TS_006";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Sort Data By Visit Location in day sheet template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySortDataByVisitLocation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupLib daySheetTemplateTestData = new TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "CreateTemplateSetup";
		daySheetTemplateTestData.testCaseId = "TC_TS_007";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}

	/*************************************************************************************************** 
	* @purpose        verify "sort data by" in add day sheet template 
	* @action 		  verifying "sort data by" in add day sheet template 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 24, 2013	
	***************************************************************************************************/
	
	public boolean daySheetTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TemplateSetupLib daySheetTemplateTestData ) throws IOException{
		
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
			//  Step-3: Navigate to Day sheet template  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToDaySheetTemplate(selenium),"Could not navigate to day sheet template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete all Day sheet template							  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllDaySheetTemplate(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-5: Create New Day sheet template with "sort By" selection	  //
			//--------------------------------------------------------------------//
			assertTrue(addNewDaySheetTemplate(selenium, daySheetTemplateTestData,userAccount), "Could not Add new day sheet template with 'sort By' selection", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify the Day sheet template values in summary page      //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValuesDaySheetTemplate(selenium, daySheetTemplateTestData, userAccount),"Verification failed for added day sheet template in summary page", selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
