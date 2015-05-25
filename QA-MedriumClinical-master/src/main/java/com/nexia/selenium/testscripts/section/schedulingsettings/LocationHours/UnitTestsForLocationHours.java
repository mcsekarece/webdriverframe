package com.nexia.selenium.testscripts.section.schedulingsettings.LocationHours;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingUnitTestLib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestsForLocationHours extends AbstractSchedulingTest {
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Star Hour With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStarHourWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_001";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Star Hour With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStarHourWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_002";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Star Hour With InValid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStarHourWithInValid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_003";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Start Hour With Float")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStarHourWithFloat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_004";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Star Hour With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStarMinWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_005";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Star Hour With InValid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStarMinWithInValid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_006";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Start Hour With Float")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStarMinWithFloat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_007";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify End Hour With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndHourWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_008";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify End Hour With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndHourWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_009";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify End Hour With InValid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndHourWithInValid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_010";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify End Hour With Float")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndHourWithFloat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_011";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify End Hour With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndMinWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_012";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify End Hour With InValid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndMinWithInValid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_013";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify End Hour With Float")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndMinWithFloat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_014";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Start Min Without Multiples Of Five")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStartMinWithoutMultiplesOfFive(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_015";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify End Time Greater Than Start Time")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndTimeGreaterThanStartTime(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_016";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify End Min Without Multiples Of Five")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEndMinWithoutMultiplesOfFive(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib lhour = new SchedulingUnitTestLib();
		lhour.workSheetName = "UnitTest_LocationHours";
		lhour.testCaseId = "TC_ULH_017";
		lhour.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLocations(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}
	/*************************************************************************************************** 
	* @purpose        To verify field level validations
	* @action 		  verify field level validations
	* @expected       To Ensure all the field level validations are in place
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      June 12, 2013
	***************************************************************************************************/

	public boolean verifyLocations(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingUnitTestLib lhour) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + lhour.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, lhour.userName, lhour.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			/*assertTrue(switchRole(selenium,lhour.switchRole));
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Practice										  //
			//--------------------------------------------------------------------//
			 assertTrue(click(selenium,lnkTopPracticeMenu),"Could not click on practice menu", selenium, ClassName, MethodName);
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
			 
			 assertTrue(click(selenium, lnkQuickAction), "could not able to click the quick action link", selenium, ClassName, MethodName);
			 assertTrue(click(selenium, lnkScheduling), "could not able to click the Scheduling Setting link", selenium, ClassName, MethodName);
			
			 assertTrue(locationHourUnitTest(selenium, lhour), "Unit test failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				// step 4:perform unit test for various fields in Add ResourceCalender //
				//--------------------------------------------------------------------//
				
				assertTrue(isElementPresent(selenium, lhour.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
				assertTrue(getText(selenium, lhour.validationFieldID).contains(lhour.validationMessage), "The expected validation message should contain the text - "+ lhour.validationMessage + " The actual validation message shown - " + getText(selenium, lhour.validationFieldID),selenium, ClassName, MethodName);
					
			}
			catch  (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
				
			}
			
			return returnValue;
			
		}
}

