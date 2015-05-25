/*************************************************************************************************** 
* @purpose This testcase verify security user access for Clinical Settings - Interaction Warnings
* @Specification SRS_Medication_Interaction_Warning Management_Rev0.0 - Section 2.4   
* @action Login User with No Access, View Only, Limited Acess and Full Access permission 
* @expected  No Access			Interaction Warnings is grayed out.
* @expected  View Only			Edit buttons is hidden
* @expected  Limited Access		All options are available
* @expected  Full Access		All options are available
* 
* @author       Jagmit 
* @state        Ready for Review
* @useraccount  US and Canada
***************************************************************************************************/

package com.nexia.selenium.testscripts.section.clinicalsettings.MedInteractionWarning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityForInteractionWarning extends AbstractChartPreVisit {
	
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib InteracWarn = new ChartPreVisitLib();
		InteracWarn.workSheetName = "VerifySecurityOption";
		InteracWarn.testCaseId = "TC_VSP_001";
		InteracWarn.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, InteracWarn);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib InteracWarn = new ChartPreVisitLib();
		InteracWarn.workSheetName = "VerifySecurityOption";
		InteracWarn.testCaseId = "TC_VSP_002";
		InteracWarn.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, InteracWarn);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib InteracWarn = new ChartPreVisitLib();
		InteracWarn.workSheetName = "VerifySecurityOption";
		InteracWarn.testCaseId = "TC_VSP_003";
		InteracWarn.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, InteracWarn);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib InteracWarn = new ChartPreVisitLib();
		InteracWarn.workSheetName = "VerifySecurityOption";
		InteracWarn.testCaseId = "TC_VSP_004";
		InteracWarn.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, InteracWarn);
	}

	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib InteracWarn) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + InteracWarn.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, InteracWarn.userName, InteracWarn.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,InteracWarn.switchRole),"Could not change the switch role;More Details:"+InteracWarn.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Medication Interaction Warning//
			//--------------------------------------------------------------------//
			
			//No Access User Role	
			if(InteracWarn.testCaseId.equals("TC_VSP_003")){
				  if(isElementPresent(selenium, btnErrorClose))
						assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
				assertTrue(click(selenium, lnkSettings), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!isElementPresent(selenium,lnkClinicalSetting), "Could not click on system settings", selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnNexiaLogo),"unable to click nexia home button",selenium,ClassName,MethodName);
			 if(isElementPresent(selenium, btnErrorClose))
			 {
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			if(!InteracWarn.testCaseId.equals("TC_VSP_003")){
				navigateToInteracWarn(selenium);
				waitForPageLoad(selenium);
			}				
			//--------------------------------------------------------------------//
			//  Step-4: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,InteracWarn)){
				Assert.fail("Security option not show properly; More Details :"+ InteracWarn.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib InteracWarn) throws IOException{
		boolean returnValue=true;
					
				
		//Limited Access User Role
		if(InteracWarn.testCaseId.equals("TC_VSP_001")){
			
			assertTrue(isElementPresent(selenium,btnEditWarning), "Edit Button not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Medication Interaction Warning Settings"),"", selenium, ClassName, MethodName);			
			assertTrue(!selenium.isTextPresent("No permission"),"", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"", selenium, ClassName, MethodName);
		}
		
		//View Only User Role
		else if(InteracWarn.testCaseId.equals("TC_VSP_002")){
			assertTrue(selenium.isTextPresent("Medication Interaction Warning Settings"),"", selenium, ClassName, MethodName);
			
			
		}
		
		//Full Access Only User Role
		else if(InteracWarn.testCaseId.equals("TC_VSP_004")){
			
			assertTrue(isElementPresent(selenium,btnEditWarning), "Edit Button is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Medication Interaction Warning Settings"),"", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"", selenium, ClassName, MethodName);
			
		}
		
		return returnValue;
	}
	
}
