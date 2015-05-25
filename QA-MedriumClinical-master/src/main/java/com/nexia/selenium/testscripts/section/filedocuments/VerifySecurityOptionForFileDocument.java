package com.nexia.selenium.testscripts.section.filedocuments;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.templateSetup.AbstractTemplateSetup;
import com.nexia.selenium.genericlibrary.templateSetup.TemplateSetupLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForFileDocument extends AbstractTemplateSetup{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify File Document With Limited Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFileDocumentWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		TemplateSetupLib daySheetTemplateTestData = new  TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "VerifySecurityOption";
		daySheetTemplateTestData.testCaseId = "TC_VSP_004";
		daySheetTemplateTestData.fetchTemplateSetupTestData();				
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFileDocument(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify File Document With No Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFileDocumentWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		TemplateSetupLib daySheetTemplateTestData = new  TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "VerifySecurityOption";
		daySheetTemplateTestData.testCaseId = "TC_VSP_001";
		daySheetTemplateTestData.fetchTemplateSetupTestData();				
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFileDocument(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify File Document With No Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFileDocumentWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		TemplateSetupLib daySheetTemplateTestData = new  TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "VerifySecurityOption";
		daySheetTemplateTestData.testCaseId = "TC_VSP_003";
		daySheetTemplateTestData.fetchTemplateSetupTestData();				
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFileDocument(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Print Calendar Report
	* @action 		  verifying Security Option For Print Calendar Report
	* @expected       To Ensure that security option works fine for Print Calendar Report 
	* @author         Aspire QA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @defect		  #6683
	* @since  	      Jan 03, 2014
	***************************************************************************************************/
	public boolean verifyFileDocument(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TemplateSetupLib documentTestData ) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + documentTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, documentTestData.userName, documentTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,documentTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Day sheet template  						  //
			//--------------------------------------------------------------------//
			
			if(documentTestData.testCaseId.equals("TC_VSP_001")){
				assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(!isElementPresent(selenium,lnkFileDoucment)){
					Assert.fail("Faile Document Link is getting display in No Access role");
				}else{
					return true;
				}
				
			}else
				assertTrue(navigateToFileDocument(selenium),"Could not navigate to day sheet template", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Security						  //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,documentTestData)){
				Assert.fail("Security for" +documentTestData.switchRole+ "is not proper:"+ documentTestData.toString());
			}
			

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium  selenium, TemplateSetupLib documentTestData){
		
		//Limited Access
		if(documentTestData.testCaseId.equals("TC_VSP_004")){
			if(!isElementPresent(selenium,btnUpload)){
				return false;
			}
		}
		
		//View Only Access
		if(documentTestData.testCaseId.equals("TC_VSP_003")){
			if(!isElementPresent(selenium,btnFileDeleteDelete)){
				return false;
			}
		}
		
		return true;
	}
	
}
