package com.nexia.selenium.testscripts.section.schedulingsettings.LocationHours;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForLocationHours extends AbstractSchedulingTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify location hours view only access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib lhour = new SchedulingTestLib();
		lhour.workSheetName = "VerifySecurityOption";
		lhour.testCaseId = "TC_VSP_002";
		lhour.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify location hours no access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib lhour = new SchedulingTestLib();
		lhour.workSheetName = "VerifySecurityOption";
		lhour.testCaseId = "TC_VSP_003";
		lhour.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify location hours full access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib lhour = new SchedulingTestLib();
		lhour.workSheetName = "VerifySecurityOption";
		lhour.testCaseId = "TC_VSP_004";
		lhour.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
		
	/*************************************************************************************************** 
	* @purpose        To verify Security Options for Locations Hours
	* @action 		  verify security access for locations hours on scheduling page
	* @expected       To verify the security access    
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      June 11, 2013
	***************************************************************************************************/

	public boolean verifySecurity(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib lhour) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + lhour.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, lhour.userName, lhour.userPassword),"Login Failed ",selenium, ClassName, MethodName);
	
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,lhour.switchRole),"Switch Role failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Practice										  //
			//--------------------------------------------------------------------//
			/* assertTrue(click(selenium,lnkTopPracticeMenu),"Could not click on practice menu",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 int count=1;
			 while(isElementPresent(selenium,"//tr["+count+"]/td/a/span")){
				 if(getText(selenium,"//tr["+count+"]/td/a/span").contains(lhour.practiceName)){
				 click(selenium,"//tr["+count+"]/td/a/span");
				 waitForPageLoad(selenium);
				 }
				 else{
					 count++;
				 }
				 
				 if(count>15){
					 break;
				 }
			 }*/
		        
			
			//No Access User Role	
			if(lhour.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(click(selenium,lnkQuickAction),"Could not click the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				
				assertTrue(!selenium.isTextPresent("System Settings"),"Text Not Present",selenium, ClassName, MethodName);
				if(!selenium.isTextPresent("Calendar Settings")){
					return true;
				}
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Location Hours						  //
			//--------------------------------------------------------------------//
			 
			if(!lhour.testCaseId.equals("TC_VSP_003")){
			
				assertTrue(click(selenium, lnkQuickAction), "could not able to click the quick action link",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkScheduling), "could not able to click the Scheduling Setting link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(selenium.isTextPresent("Location Hours"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
				
			}
		 
					 
		   if(!verifySecurity(selenium,lhour)){
					Assert.fail("Security option not show properly; More Details :"+ lhour.toString());
					returnValue= false;
				}else
					returnValue=true;
			}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return returnValue;
		}
	
		public boolean verifySecurity(Selenium selenium,SchedulingTestLib lhour){
			boolean returnValue=true;
			
			// View Only Access
			if(lhour.testCaseId.equals("TC_VSP_002")){
				 
				// Edit Button should not be Visible
				if(selenium.isElementPresent("//a[contains(text(),'Edit')]")){
					returnValue=false;
				}else
					return returnValue;
			}
			
			// Full Access 
			else if(lhour.testCaseId.equals("TC_VSP_004")){
				//if(selenium.isTextPresent("An error has occured") || selenium.isTextPresent("No Permission") ){
			 
				// Edit button should be visible
				if(selenium.isElementPresent("//a[contains(text(),'Edit')]")){
					return returnValue;
				}else
					returnValue=false;
			}
					
			return returnValue;
		}
}