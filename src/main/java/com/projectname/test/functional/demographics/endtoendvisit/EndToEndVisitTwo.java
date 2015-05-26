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
public class EndToEndVisitTwo extends TestBaseClass {
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for verify end to end visit flow")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void endToEndVisitsScheduleAppointments(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) {
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib calendarTemplate = new SchedulingTestLib();
		calendarTemplate.workSheetName = "VisitsEndToEnd";
		calendarTemplate.testCaseId = "TC_ETE_002";
		calendarTemplate.fetchSchedulingTestData();
		scheduleAppointments(calendarTemplate,userAccount);
    }
	/*
	* @purpose To book three appointments in calendar page for a particular patient with same provider
	* @author AspireQA
	* @since December 19, 2014
	* @version 2.1
	*/
	public boolean scheduleAppointments(SchedulingTestLib calendarTemplate,String userAccount)
	{
		SharedPage sharedPage=null;
		CalendarPage calendarPage=null;
		BillingHistoryPage billingHistoryPage=null;
		ReferralsPage referralsPage=null;
		try {
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
			homePage = loginPage.loginForNexiaFromProviderSite(driver,
					userAccount, calendarTemplate.userName,
					calendarTemplate.userPassword);
			logTitleMessage("Login Successful");
			//---------------------------------------------------------------------//
			//  Step-2: Switch Role and Select Practice                            // 
			//---------------------------------------------------------------------//
			sharedPage=homePage.navigateToSharedPage();
			logTitleMessage("Select BILLER as a user role");
			sharedPage.switchRole(driver,calendarTemplate.switchRole);
			logTitleMessage("User Role BILLER selected successfully");
			//---------------------------------------------------------------------//
			//  Step-3: Navigate to calendar page                                  //
			//---------------------------------------------------------------------//
			logTitleMessage("Navigate to Provider Calendar Page and open a provider calendar");
		    calendarPage=sharedPage.navigateToCalendar(driver);
			//---------------------------------------------------------------------//
			//  Step-4: Search the provider in calendar page                       //
			//---------------------------------------------------------------------//
		    SchedulingTestLib resouceCalendar = new SchedulingTestLib();
			resouceCalendar.workSheetName = "CreateResourceCalender";
			resouceCalendar.testCaseId = "TC_CRC_001";
			resouceCalendar.fetchSchedulingTestData();
			calendarPage.openProvidersCalendar(resouceCalendar,driver);
			logTitleMessage("Successfully Navigate and open a resource calendar");
			//---------------------------------------------------------------------//
			//  Step-5: Delete all appointment 
			//---------------------------------------------------------------------//
			calendarPage.deleteAllAppointment(driver,calendarTemplate);
			//---------------------------------------------------------------------//
			//  Step-5: Create an Appointment-1                                   //
			//---------------------------------------------------------------------//
			logTitleMessage("Create Appointment-1");
		    calendarPage.makeResourceAppointment(driver,calendarTemplate,"one","");
		    logTitleMessage("Appointment-1 Created successfully");
			//--------------------------------------------------------------------//
			//  Step-6: Create an Appointment-2                                   //
			//--------------------------------------------------------------------//
			logTitleMessage("Create Appointment-2");
			calendarPage.makeResourceAppointment(driver,calendarTemplate,"two","");
			logTitleMessage("Appointment-2 Created successfully");
			//--------------------------------------------------------------------//
			//    Step-7 : Create an Appointment-3                                //
			//--------------------------------------------------------------------//
			logTitleMessage("Create Appointment-3");
			calendarPage.makeResourceAppointment(driver,calendarTemplate,"three","");
			logTitleMessage("Appointment-3 Created successfully");
			//--------------------------------------------------------------------//
			//    Step-8: verify on patient Referrals Page                        //
			//--------------------------------------------------------------------//
			logTitleMessage("Navigate to patient Referral Page and verify Authentication number,total visits&visit scheduled");
			billingHistoryPage=sharedPage.searchPatientForBillerRole(driver, calendarTemplate.patientId);
			referralsPage=billingHistoryPage.goToReferral(driver);
			billingHistoryPage.verifyReferralSummary(referralsPage,calendarTemplate.verifyAuthorization,calendarTemplate.verifyVisitsScheduled,calendarTemplate.verifyVisitsAllowed,calendarTemplate.verifyNumberUsed,calendarTemplate.testCaseId);
			logTitleMessage("Successfully verified the Patient referrals details");
		}catch(Exception e)
		{
			new ExceptionHandler(e, driver, getCustomAttributeValue(ReferralsPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
		return true;
	}
}