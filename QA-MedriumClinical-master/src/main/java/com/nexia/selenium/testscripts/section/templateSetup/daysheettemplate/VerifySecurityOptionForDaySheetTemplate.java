package com.nexia.selenium.testscripts.section.templateSetup.daysheettemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.templateSetup.AbstractTemplateSetup;
import com.nexia.selenium.genericlibrary.templateSetup.TemplateSetupLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForDaySheetTemplate extends AbstractTemplateSetup {
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Day Sheet Template With No Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDaySheetTemplateWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		TemplateSetupLib daySheetTemplateTestData = new  TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "VerifySecurityOption";
		daySheetTemplateTestData.testCaseId = "TC_VSP_001";
		daySheetTemplateTestData.fetchTemplateSetupTestData();				
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}

	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Day Sheet Template With Full Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDaySheetTemplateWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		TemplateSetupLib daySheetTemplateTestData = new  TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "VerifySecurityOption";
		daySheetTemplateTestData.testCaseId = "TC_VSP_002";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Day Sheet Template With View Only Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDaySheetTemplateWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		TemplateSetupLib daySheetTemplateTestData = new  TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "VerifySecurityOption";
		daySheetTemplateTestData.testCaseId = "TC_VSP_003";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Day Sheet Template
	* @action 		  verifying Security Option For Day Sheet Template
	* @expected       To Ensure that security option works fine for Day Sheet Template 
	* @author         Aspire QA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 23, 2013
	***************************************************************************************************/

	public boolean daySheetTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,TemplateSetupLib daySheetTemplateTestData) throws Exception{
		Selenium selenium = null;
		boolean returnValue= true;
		
		try{
			
			//--------------------------------------------------------------------//
			// Step 1:Login to the application									  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + daySheetTemplateTestData.toString());
			
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, daySheetTemplateTestData.userName, daySheetTemplateTestData.userPassword),"Login Failed ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Verify Security											  //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,daySheetTemplateTestData,userAccount)){
				Assert.fail("Security for" +daySheetTemplateTestData.switchRole+ "is not proper:"+ daySheetTemplateTestData.toString());
			}else
				return returnValue;
			
		}			
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + daySheetTemplateTestData.toString(), selenium, ClassName,MethodName);
		}
		return returnValue;
	}	

	public boolean verifySecurity(Selenium selenium, TemplateSetupLib daySheetTemplateTestData,String userAccount) throws Exception{
		boolean returnValue=true;
		
		//No Access Permission
		if(daySheetTemplateTestData.testCaseId.equals("TC_VSP_001")){
			
			//--------------------------------------------------------------------//
			//  Step-3: Switch Role//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,daySheetTemplateTestData.switchRole),"Could not change the switch role;More Details:"+daySheetTemplateTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkQuickAction),"Could not click the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, lnkTemplateSetup)){
				return false;
			}
		}else{
			//--------------------------------------------------------------------//
			//  Step-3: Switch Role												  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,"DFFullAccess"),"Could not change the switch role;More Details:"+daySheetTemplateTestData.toString(), selenium, ClassName,MethodName);
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
			//  Step-6: Switch Role											      //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,daySheetTemplateTestData.switchRole),"Could not change the switch role;More Details:"+daySheetTemplateTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Day sheet template  						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkSettings), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkTemplateSetup), "Could not click on Template setup", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkDaySheetTemplate), "Could not click on Day sheet template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Full Access Permission	
			if(daySheetTemplateTestData.testCaseId.equals("TC_VSP_002")){
				assertTrue(selenium.isElementPresent(btnAddDaySheetTemplate),"Add day sheet template not present Present",selenium, ClassName, MethodName);
				assertTrue(selenium.isElementPresent(btnEdit),"Edit day sheet template not present Present",selenium, ClassName, MethodName);
				assertTrue(selenium.isElementPresent(btnDelete),"Delete day sheet template not present Present",selenium, ClassName, MethodName);
				
				//---------------------------------------------------------------------------------------//
				//  Step-8: verify the Day sheet template values in summary page at view only access     //
				//---------------------------------------------------------------------------------------//
				assertTrue(verifyStoreValuesDaySheetTemplate(selenium, daySheetTemplateTestData, userAccount),"Verification failed for added day sheet template in summary page", selenium, ClassName, MethodName);
				
			}
		
			//View Only Access Permission
			if(daySheetTemplateTestData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(isElementPresent(selenium, btnAddDaySheetTemplate),"Verfication Failed", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Edit"),"Verfication Failed", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Delete"),"Verfication Failed", selenium, ClassName, MethodName);

					//---------------------------------------------------------------------------------------//
					//  Step-9: verify the Day sheet template values in summary page at view only access     //
					//---------------------------------------------------------------------------------------//
					assertTrue(verifyStoreValuesDaySheetTemplate(selenium, daySheetTemplateTestData, userAccount),"Verification failed for added day sheet template in summary page", selenium, ClassName, MethodName);
				
			}
			
			 
		}
		
		return returnValue;
	}
	
}