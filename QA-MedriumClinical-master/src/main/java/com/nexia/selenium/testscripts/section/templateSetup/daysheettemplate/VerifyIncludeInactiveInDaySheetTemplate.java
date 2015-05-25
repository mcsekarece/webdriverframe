package com.nexia.selenium.testscripts.section.templateSetup.daysheettemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.templateSetup.AbstractTemplateSetup;
import com.nexia.selenium.genericlibrary.templateSetup.TemplateSetupLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyIncludeInactiveInDaySheetTemplate extends AbstractTemplateSetup {
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify inactive in day sheet template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncludeInactiveInDaySheetTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupLib daySheetTemplateTestData = new TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "CreateTemplateSetup";
		daySheetTemplateTestData.testCaseId = "TC_TS_001";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}

	/*************************************************************************************************** 
	* @purpose        verify inactive in day sheet template 
	* @action 		  verifying inactive in day sheet template 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 22, 2013	
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
			//  Step-5: Create New Day sheet template							  //
			//--------------------------------------------------------------------//
			assertTrue(addNewDaySheetTemplate(selenium, daySheetTemplateTestData,userAccount), "Could not Add new day sheet template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify the Day sheet template values in summary page      //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValuesDaySheetTemplate(selenium, daySheetTemplateTestData, userAccount),"Verification failed for added day sheet template in summary page", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Delete the created Day sheet template					  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllDaySheetTemplate(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: verify the Day sheet template not exist in summary		  //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtSearchDaySheetTemplate,daySheetTemplateTestData.templateName),"Could not type template name in the search box", selenium, ClassName, MethodName);
			selenium.keyPress(txtSearchDaySheetTemplate, "\\9");
			
			if(getText(selenium,lblSummaryDaySheetTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains(daySheetTemplateTestData.templateName.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			
			//----------------------------------------------------------------------------//
			//  Step-9: verify the deleted Day sheet template in inactive section		  //
			//----------------------------------------------------------------------------//
			if(!isChecked(selenium, chkIncludeInactive)){
				assertTrue(click(selenium, chkIncludeInactive), "Could not click on include inactive", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			if(!getText(selenium,lblSummaryDaySheetTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains(daySheetTemplateTestData.templateName.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(!getText(selenium,lblSummaryDaySheetTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains("Inactive".trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(!isElementPresent(selenium, lnkActive)){
				return false;  
			}
			
			//--------------------------------------------------------------------//
			//  Step-10: verify the activates Day sheet template in summary		  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkActive), "Could not click on active button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isChecked(selenium, chkIncludeInactive)){
				assertTrue(click(selenium, chkIncludeInactive), "Could not click on include inactive", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			if(!getText(selenium,lblSummaryDaySheetTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains(daySheetTemplateTestData.templateName.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
