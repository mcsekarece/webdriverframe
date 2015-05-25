package com.nexia.selenium.testscripts.section.templateSetup.daysheettemplate;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.templateSetup.AbstractTemplateSetup;
import com.nexia.selenium.genericlibrary.templateSetup.TemplateSetupLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPreviewInAddDaySheetTemplate extends AbstractTemplateSetup {
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify preview in Add day sheet template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPreviewInAddDaySheetTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupLib daySheetTemplateTestData = new TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "CreateTemplateSetup";
		daySheetTemplateTestData.testCaseId = "TC_TS_008";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}

	/*************************************************************************************************** 
	* @purpose        verify preview in Add day sheet template 
	* @action 		  verifying preview in Add day sheet template 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 24, 2013	
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
			//  Step-5: Create New Day sheet template							  //
			//--------------------------------------------------------------------//
			assertTrue(addNewDaySheetTemplate(selenium, daySheetTemplateTestData,userAccount), "Could not Add new day sheet template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-------------------------------------------------------------------------------//
			//  Step-6: verify the preview in Day sheet template 					         //
			//-------------------------------------------------------------------------------//
			assertTrue(click(selenium, btnPreview), "Could not click on preview in add new Day sheet template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Robot robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			
			//verify preview title
			if(!getText(selenium,lblTitlePreview).toLowerCase(new java.util.Locale("en","US")).trim().contains(uploadFileName.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;
			}
			//verify preview close button
			if(!isElementPresent(selenium, lnkClosePreview)){
				 return false;
			}
			
			assertTrue(click(selenium, lnkClosePreview), "Could not click on close preview in add new Day sheet template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium, btnSave)){
				 return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
