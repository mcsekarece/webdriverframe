package com.projectname.test.functional.demographics.endtoendvisit;
import java.util.Calendar;
import java.util.TimeZone;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.SchedulingTestLib;
import com.projectname.testutils.pages.BillingHistoryPage;
import com.projectname.testutils.pages.CalendarPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.ReferralsPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class EndToEndVisitSeven extends TestBaseClass{
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for verify end to end visit flow")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void changeAuthorizationNumber(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) {
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib calendarTemplate = new SchedulingTestLib();
		calendarTemplate.workSheetName = "VisitsEndToEnd";
		calendarTemplate.testCaseId = "TC_ETE_007";
		calendarTemplate.fetchSchedulingTestData();
		changeFromA1ToA2(calendarTemplate,userAccount);
	}
	/*
	* @purpose To change the authorization value from A1 to A2 for the particular selected patient
	* @author AspireQA
	* @since December 19, 2014
	* @version 2.1
	*/
  public boolean changeFromA1ToA2(SchedulingTestLib calendarTemplate,String userAccount)
  {
	    SharedPage sharedPage=null;
		CalendarPage calendarPage=null;
		ReferralsPage referralsPage=null;
		BillingHistoryPage billingHistoryPage=null;
	  try
		{
		  	//--------------------------------------------------------------------//
			//  Verify if the Time Zone is EST //
			//--------------------------------------------------------------------//
			TimeZone timeZone = Calendar.getInstance().getTimeZone(); 
			System.out.println(timeZone.getDisplayName(false, TimeZone.SHORT)); 
			String currentTimeZone=timeZone.getDisplayName(false, TimeZone.SHORT);
			logTitleMessage("Current Time Zone is:"+ currentTimeZone);
			assertTrue(currentTimeZone.equals("EST"),"This script has to be Executed only in EST Time Zone", driver, className, methodName);
		// --------------------------------------------------------------------//
		// Step-1: Login to the application and search for the given patient   //
		// --------------------------------------------------------------------//
		logTitleMessage("Login to application");
		LoginPage loginPage = new LoginPage();
		homePage = loginPage.loginForNexiaFromProviderSite(driver, userAccount,
				calendarTemplate.userName, calendarTemplate.userPassword);
		logTitleMessage("Login Successful");
		//---------------------------------------------------------------------//
		//  Step-2: Select Practice and Navigate to calendar page              // 
		//---------------------------------------------------------------------//
		sharedPage=homePage.navigateToSharedPage();
		logTitleMessage("Select Main Clinic as a practice");
		sharedPage.selectPractice(driver,calendarTemplate.location);
		logTitleMessage("successfully Main clinic selected as a practice");
		logTitleMessage("Select BILLER as a user role");
		sharedPage.switchRole(driver,calendarTemplate.switchRole);
		logTitleMessage("User Role BILLER selected successfully");
		//---------------------------------------------------------------------//
		//  Step-3: Navigate to calendar page                                  //
		//---------------------------------------------------------------------//
		logTitleMessage("Navigate to Provider Calendar Page and open a provider calendar");
	    // ---------------------------------------------------------------------//
		calendarPage=sharedPage.navigateToCalendar(driver);
		// Step-3: Search the provider in calendar page                         //
		// ---------------------------------------------------------------------//
		SchedulingTestLib resouceCalendar = new SchedulingTestLib();
		resouceCalendar.workSheetName = "CreateResourceCalender";
		resouceCalendar.testCaseId = "TC_CRC_001";
		resouceCalendar.fetchSchedulingTestData();
		calendarPage.openProvidersCalendar(resouceCalendar, driver);
		logTitleMessage("Successfully Navigate and open a resource calendar");
		//----------------------------------------------------------------------//
		//  Step-4: Change Authorization Value                                  //
		//----------------------------------------------------------------------//
		logTitleMessage("Change Authorization value for an appointment");
		calendarPage.editPatientVisit(driver,calendarTemplate,calendarTemplate.testCaseId);
		logTitleMessage("Successfully authorization number changed");
		//----------------------------------------------------------------------//
		//  Step-5: Verify On Patient Referrals Page                            //
		//----------------------------------------------------------------------//
		logTitleMessage("Navigate to patient Referral Page and verify the change of authorization number");
		billingHistoryPage=sharedPage.searchPatientForBillerRole(driver, calendarTemplate.patientId);
		referralsPage=billingHistoryPage.goToReferral(driver);
		billingHistoryPage.verifyReferralSummary(referralsPage,calendarTemplate.verifyAuthorization,calendarTemplate.verifyVisitsScheduled,calendarTemplate.verifyVisitsAllowed,calendarTemplate.verifyNumberUsed,calendarTemplate.testCaseId);
		logTitleMessage("Successfully verified the authorization change value in  Patient referrals page");
		}catch(Exception e)
		{
			new ExceptionHandler(e, driver, getCustomAttributeValue(ReferralsPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	  return true;
  }
}