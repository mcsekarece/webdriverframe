package com.nexia.selenium.testscripts.section.templateSetup.daysheettemplate;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.templateSetup.AbstractTemplateSetup;
import com.nexia.selenium.genericlibrary.templateSetup.TemplateSetupLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForPrintCalendarReport extends AbstractTemplateSetup {
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Print Calendar Report With No Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrintCalendarReportWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		TemplateSetupLib daySheetTemplateTestData = new  TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "VerifySecurityOption";
		daySheetTemplateTestData.testCaseId = "TC_VSP_001";
		daySheetTemplateTestData.fetchTemplateSetupTestData();				
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}

	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Print Calendar Report With Full Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrintCalendarReportWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		TemplateSetupLib daySheetTemplateTestData = new  TemplateSetupLib();
		daySheetTemplateTestData.workSheetName = "VerifySecurityOption";
		daySheetTemplateTestData.testCaseId = "TC_VSP_002";
		daySheetTemplateTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		daySheetTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,daySheetTemplateTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Print Calendar Report
	* @action 		  verifying Security Option For Print Calendar Report
	* @expected       To Ensure that security option works fine for Print Calendar Report 
	* @author         Aspire QA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 28, 2013
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
			//  Step-2: Switch Role												  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,daySheetTemplateTestData.switchRole),"Could not change the switch role;More Details:"+daySheetTemplateTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify Security											  //
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
			
			assertTrue(click(selenium,lnkQuickAction),"Could not click the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, lnkCalendar)){
				return false;
			}
		}else{
			
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
			//  Step-7: Navigate to Print Calendar		  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToPrintCalendar(selenium),"Could not navigate to print calendar", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Print Calendar For Full Access User				  //
			//--------------------------------------------------------------------//
			assertTrue(verifyPrintReportUsingDaySheetTemplate(selenium, daySheetTemplateTestData,userAccount), "Could not verify print calendar", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 
		}
		
		return returnValue;
	}
	
}