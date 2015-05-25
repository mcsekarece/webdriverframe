package com.nexia.selenium.testscripts.section.templateSetup.daysheettemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.templateSetup.AbstractTemplateSetup;
import com.nexia.selenium.genericlibrary.templateSetup.TemplateSetupLib;
import com.thoughtworks.selenium.Selenium;

public class RenameReferralLetterTemplate extends AbstractTemplateSetup {
	
	public String lnkLetterTemplate = "!templatesLetter" ;
	public String btnAddLetterTemplate ="link=Add New";
	public String txtLetterTemplateName = "letterTemplateName";
	public String ajxPageSize = "letterTemplatePageSizesuggestBox";
	public String btnAddTemplateField ="//*[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div/div[3]/div/div[2]/div/div[2]/div/div/div[2]/a/div";
	private String nameOfTemplateToRename;


	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify copying of Letter template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void renameReferralLetterTemplateTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupLib letterTemplateTestData = new TemplateSetupLib();
		letterTemplateTestData.workSheetName = "CreateTemplateSetup";
		letterTemplateTestData.testCaseId = "TC_TS_001";
		letterTemplateTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		renamingReferralLetterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData);
	}

	/*************************************************************************************************** 
	* @purpose        verify Add letter template 
	* @action 		  verifying Add letter template 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      May 26, 2014	
	***************************************************************************************************/
	
	public boolean renamingReferralLetterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TemplateSetupLib daySheetTemplateTestData ) throws IOException{
		
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
			//  Step-3: Navigate to Letter template  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToLetterTemplate(selenium),"Could not navigate to day sheet template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Get name of template to copy //
			//--------------------------------------------------------------------//
			nameOfTemplateToRename = "GroupTemp";				
			
			//--------------------------------------------------------------------//
			//  Step-5: Rename Letter template							  //
			//--------------------------------------------------------------------//
			assertTrue(renameLetterTemplate(selenium,daySheetTemplateTestData,userAccount,nameOfTemplateToRename), "Could not copy letter template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}


	private boolean renameLetterTemplate(Selenium selenium, TemplateSetupLib daySheetTemplateTestData, String userAccount, String sourceTemplate) throws IOException {
		String lnkTemplateEdit = "//*[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div/div[3]/div/div/div/div[1]/div[2]/a[2]";
		assertTrue(click(selenium,lnkTemplateEdit),"Could not click Edit link.", selenium , ClassName, MethodName);
		
		assertTrue(type(selenium,txtLetterTemplateName,"Renamed"+sourceTemplate),"Could not type template name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, btnSave ), "Could not click Save button in the popup", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		
		return true;
	}

	public boolean navigateToLetterTemplate(Selenium selenium) throws IOException{
		
		assertTrue(click(selenium, lnkSettings), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkTemplateSetup), "Could not click on Template setup", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkLetterTemplate), "Could not click on Letter template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!isElementPresent(selenium, btnAddLetterTemplate)){
			return false;
		}
		return true;
	}
	
	
}
