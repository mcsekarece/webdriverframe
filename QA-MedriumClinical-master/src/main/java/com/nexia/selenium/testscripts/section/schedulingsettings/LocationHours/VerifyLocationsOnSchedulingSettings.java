package com.nexia.selenium.testscripts.section.schedulingsettings.LocationHours;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

	public class VerifyLocationsOnSchedulingSettings extends AbstractSchedulingTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify locations on scheduling screen")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLocationOnScheduling(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib lhour = new SchedulingTestLib();
		lhour.workSheetName = "LocationHours";
		lhour.testCaseId = "TC_LH_001";
		lhour.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify search location")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchLocationOnScheduling(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib lhour = new SchedulingTestLib();
		lhour.workSheetName = "LocationHours";
		lhour.testCaseId = "TC_LH_002";
		lhour.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify search location with invalid location")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchLocationWithInvalidLocation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib lhour = new SchedulingTestLib();
		lhour.workSheetName = "LocationHours";
		lhour.testCaseId = "TC_LH_003";
		lhour.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify clear search field")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyClearSearchField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib lhour = new SchedulingTestLib();
		lhour.workSheetName = "LocationHours";
		lhour.testCaseId = "TC_LH_004";
		lhour.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Locations on scheduling settings screen
	* @action 		  verify the created locations on scheduling page
	* @expected       To Ensure that the created New Non Provider Resource Room works fine    
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      June 10, 2013
	***************************************************************************************************/

	public boolean verifyLocations(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib lhour) throws Exception{
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
			/*assertTrue(switchRole(selenium,lhour.switchRole));
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Practice										  //
			//--------------------------------------------------------------------//
			 assertTrue(click(selenium,lnkTopPracticeMenu),"Could not click on practice menu",selenium, ClassName, MethodName);
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
			 }
		        
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Location Hours						  //
			//--------------------------------------------------------------------//
			 
			 assertTrue(click(selenium, lnkQuickAction), "could not able to click the quick action link",selenium, ClassName, MethodName);
			 assertTrue(click(selenium, lnkScheduling), "could not able to click the Scheduling Setting link",selenium, ClassName, MethodName);
			
			 
			 if(lhour.testCaseId.equals("TC_LH_002")){
				 selectValueFromAjaxList(selenium,txtSearchBox,lhour.location1);
				
				 waitForPageLoad(selenium);
				 if(getText(selenium,lblLocationHoursDisplay).contains(lhour.location1)){
					 returnValue=true;
				 }if(getText(selenium,lblLocationHoursDisplay).contains(lhour.location2)){
					 returnValue=false;
				 }
				 
			 }
			 
			 if(lhour.testCaseId.equals("TC_LH_003")){
				 selectValueFromAjaxList(selenium,txtSearchBox,lhour.location1);
				 if(getText(selenium,lblLocationHoursDisplay).contains(lhour.location1)){
					 returnValue=false;
				 }if(getText(selenium,lblLocationHoursDisplay).contains(lhour.location2)){
					 returnValue=false;
				 }
				 
			 }

			 if(lhour.testCaseId.equals("TC_LH_004")){
				 selectValueFromAjaxList(selenium,txtSearchBox,lhour.location1);
				 waitForPageLoad(selenium);
				 if(getText(selenium,lblLocationHoursDisplay).contains(lhour.location1)){
					 returnValue=true;
				 }if(getText(selenium,lblLocationHoursDisplay).contains(lhour.location2)){
					 returnValue=false;
				 }
				 assertTrue(click(selenium, btnSearchClose), "Could not click on X mark",selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				 if(getText(selenium,lblLocationHoursDisplay).contains(lhour.location1)){
					 returnValue=true;
				 }if(getText(selenium,lblLocationHoursDisplay).contains(lhour.location2)){
					 returnValue=true;
				 }
				 
			 }
			//--------------------------------------------------------------------//
			//  Step-4:Verify Locations					  //
			//--------------------------------------------------------------------//
			 if(lhour.testCaseId.equals("TC_LH_001")){
				 if(getText(selenium,lblLocationHoursDisplay).contains(lhour.location1)){
					 returnValue=true;
				 } if(getText(selenium,lblLocationHoursDisplay).contains(lhour.location2)){
				 returnValue=true;
			 	}
			 }
			 return returnValue;
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
