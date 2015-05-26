package com.projectname.test.functional.demographics.patientcreation;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.genericutility.testDataLib.SchedulingTestLib;
import com.projectname.testutils.genericutility.testDataLib.SystemSettingsLib;
import com.projectname.testutils.pages.BillingHistoryPage;
import com.projectname.testutils.pages.CalendarPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.ReferralsPage;
import com.projectname.testutils.pages.ReferringProviderPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.pages.SystemSettingsPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class SelectReferralByPracticeNameInBookingAppointment extends TestBaseClass {
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for verify end to end visit flow")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifyreferringpracticename(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) {
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		HomeLib referralData = new HomeLib();
		referralData.workSheetName = "CreateReferral";
		referralData.testCaseId = "TC_CRL_021";
		referralData.fetchHomeTestData();
		scheduleAppointments(referralData,userAccount);
    }
	/*
	* @purpose To book three appointments in calendar page for a particular patient with same provider
	* @author AspireQA
	* @since December 19, 2014
	* @version 2.1
	*/
	public boolean scheduleAppointments(HomeLib referralData,String userAccount)
	{
		SharedPage sharedPage=null;
		CalendarPage calendarPage=null;
		BillingHistoryPage billingHistoryPage=null;
		ReferralsPage referralsPage=null;
		 SystemSettingsPage systemSettingsPage=null;
		 ReferringProviderPage referringProviderPage=null;
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
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, referralData.userName,referralData.userPassword);
			logTitleMessage("Login Successful");
			//---------------------------------------------------------------------//
			//  Step-2: Switch Role and Select Practice                            // 
			//---------------------------------------------------------------------//
			sharedPage=homePage.navigateToSharedPage();
			logTitleMessage("Select user role");
			sharedPage.switchRole(driver,referralData.switchRole);
			logTitleMessage("User Role selected successfully");
			//---------------------------------------------------------------------//
			//  Step-3: Navigate to External Provider                              //
			//---------------------------------------------------------------------//
			logTitleMessage("Navigate to external provider");
			systemSettingsPage= sharedPage.goToSystemSettings(driver);
			referringProviderPage=systemSettingsPage.goToReferringProviderPage(driver);		
			SystemSettingsLib referrralProviderData = new SystemSettingsLib();
			referrralProviderData.workSheetName = "CreateExternalProviders";
			referrralProviderData.testCaseId = "TC_RP_013";
			referrralProviderData.fetchSystemSettingTestData();
			logTitleMessage("Delete same provider in external provider page");
			referringProviderPage.deleteExternalProvider(driver,referrralProviderData.firstName);
			logTitleMessage("Successfully Delete same provider in external provider page");
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String date = DateFormat.format(cal.getTime());
			referrralProviderData.referringCode=referrralProviderData.referringCode+date;
			logTitleMessage("Create a Referral provider	");
			referringProviderPage.clickAddNewExternalProvider(driver);
			systemSettingsPage.addNewReferringProvider(driver, referrralProviderData, referringProviderPage);
			assertTrue(systemSettingsPage.clickSaveReferralProvider(driver, referringProviderPage), "Could not click Save Button" , driver, className, methodName);
			logTitleMessage("Successfully Created Referral provider");
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
			resouceCalendar.testCaseId = "TC_CRC_007";
			resouceCalendar.fetchSchedulingTestData();
			calendarPage.openProvidersCalendar(resouceCalendar,driver);
			logTitleMessage("Successfully Navigate and open a resource calendar");
			//---------------------------------------------------------------------//
			//  Step-5: Delete all appointment 
			//---------------------------------------------------------------------//
			calendarPage.deleteAllAppointment(driver,resouceCalendar);
			//---------------------------------------------------------------------//
			//  Step-5: Create an Appointment-1                                   //
			//---------------------------------------------------------------------//
			logTitleMessage("Create Appointment-1");
		    calendarPage.makeResourceAppointment(driver,resouceCalendar,"one","");
		    logTitleMessage("Appointment-1 Created successfully");
		
			//--------------------------------------------------------------------//
			//    Step-8: verify on patient Referrals Page                        //
			//--------------------------------------------------------------------//
			logTitleMessage("Navigate to patient Referral Page and verify Authentication number,total visits&visit scheduled");
			billingHistoryPage=sharedPage.searchPatientForBillerRole(driver, resouceCalendar.patientId);
			referralsPage=billingHistoryPage.goToReferral(driver);
		
			logTitleMessage("Successfully verified the Patient referrals details");
		}catch(Exception e)
		{
			new ExceptionHandler(e, driver, getCustomAttributeValue(ReferralsPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
		return true;
	}
}