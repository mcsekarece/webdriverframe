package com.nexia.selenium.testscripts.section.templateSetup.daysheettemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.templateSetup.AbstractTemplateSetup;
import com.nexia.selenium.genericlibrary.templateSetup.TemplateSetupLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchInDaySheetTemplate extends AbstractTemplateSetup {
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify search in day sheet template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchInDaySheetTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupLib daySheetTemplateTestData = new TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "CreateTemplateSetup";
		daySheetTemplateTestData.testCaseId = "TC_TS_001";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}

	/*************************************************************************************************** 
	* @purpose        verify search in day sheet template 
	* @action 		  verifying search in day sheet template 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 23, 2013	
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
			//  Step-5: Create first New Day sheet template					      //
			//--------------------------------------------------------------------//
			assertTrue(addNewDaySheetTemplate(selenium, daySheetTemplateTestData,userAccount), "Could not Add new day sheet template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//store the file name recently we created
			String firstUploadedFileName= uploadFileName;
			
			//---------------------------------------------------------------------//
			//  Step-6: verify the first Day sheet template values in summary page //
			//---------------------------------------------------------------------//
			assertTrue(verifyStoreValuesDaySheetTemplate(selenium, daySheetTemplateTestData, userAccount),"Verification failed for added day sheet template in summary page", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Create second New Day sheet template 					  //
			//--------------------------------------------------------------------//
			assertTrue(addNewDaySheetTemplate(selenium, daySheetTemplateTestData,userAccount), "Could not Add new day sheet template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//store the file name recently we created
			String secondUploadedFileName= uploadFileName;
			
			//--------------------------------------------------------------------//
			//  Step-8: verify search in Day sheet template summary	    		  //
			//--------------------------------------------------------------------//
			//Trim the file extention
			firstUploadedFileName = firstUploadedFileName.replace(".docx", "");
			secondUploadedFileName = secondUploadedFileName.replace(".docx", "");
			
			//search the first created day sheet template
			assertTrue(type(selenium,txtSearchDaySheetTemplate,firstUploadedFileName),"Could not type template name in the search box", selenium, ClassName, MethodName);
			selenium.keyPress(txtSearchDaySheetTemplate, "\\13");
			waitForPageLoad(selenium);
			
			//verify existence of first created day sheet template in summary
			if(!getText(selenium,lblWholeSummaryDaySheetTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains(firstUploadedFileName.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			
			//verify Non-existence of second created day sheet template in summary
			if(getText(selenium,lblWholeSummaryDaySheetTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains(secondUploadedFileName.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			
			//--------------------------------------------------------------------//
			//  Step-9: verify the search close in Day sheet template summary	  //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtSearchDaySheetTemplate,""),"Could not type empty template name in the search box", selenium, ClassName, MethodName);
			selenium.keyPress(txtSearchDaySheetTemplate, "\\13");
			
			//verify existence of both created day sheet templates in summary
			if(!getText(selenium,lblWholeSummaryDaySheetTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains(firstUploadedFileName.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(!getText(selenium,lblWholeSummaryDaySheetTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains(secondUploadedFileName.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
