package com.projectname.test.functional.demographics.endtoendvisit;



import java.util.Calendar;
import java.util.TimeZone;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.genericutility.testDataLib.SchedulingTestLib;
import com.projectname.testutils.pages.BillingHistoryPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.ReferralsPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.pages.billing.BillingChargesPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class EndToEndVisitOne extends TestBaseClass{
	private BillingHistoryPage billingHistoryPage;
	private ReferralsPage referralsPage;
	private BillingChargesPage billingChargesPage;
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "End To End for Visits- One")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void endToEndReferralOne(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib schedulingData = new SchedulingTestLib();
		schedulingData.workSheetName = "VisitsEndToEnd";
		schedulingData.testCaseId = "TC_ETE_001";
		schedulingData.fetchSchedulingTestData();
		createReferral(schedulingData, userAccount);
	}
	
	/**
	 * Create Referral for a patient
	 * function to add referral for a patient
	 * @param 	SchedulingData- Data for Scheduling
	 * @param 	String-User Account
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */
	
	public boolean createReferral(SchedulingTestLib schedulingData, String userAccount) {
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Verify if the Time Zone is EST //
			//--------------------------------------------------------------------//
			TimeZone timeZone = Calendar.getInstance().getTimeZone(); 
			System.out.println(timeZone.getDisplayName(false, TimeZone.SHORT)); 
			String currentTimeZone=timeZone.getDisplayName(false, TimeZone.SHORT);
			logTitleMessage("Current Time Zone is:"+ currentTimeZone);
			assertTrue(currentTimeZone.equals("EST"),"This script has to be Executed only in EST Time Zone", driver, className, methodName);
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Log into application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, schedulingData.userName, schedulingData.userPassword);
			logTitleMessage("Sucessfully logged into application");
			//--------------------------------------------------------------------//
			//  Step-2: Create a Referral for Patient A                     //
			//--------------------------------------------------------------------//
			SharedPage sharedPage=homePage.navigateToSharedPage();
			logTitleMessage("Switch Role");
			sharedPage.switchRole(driver, schedulingData.switchRole);
			logTitleMessage("Switch Role successful");
			
			logTitleMessage("Create Referral");
			billingHistoryPage=sharedPage.searchPatientForBillerRole(driver, schedulingData.patientId);
			referralsPage=billingHistoryPage.goToReferral(driver);
			
			logTitleMessage("Delete All Referrals");
			billingHistoryPage.deleteAllReferral(referralsPage, driver);
			logTitleMessage("All referrals deleted successfully");
			//--------------------------------------------------------------------//
			//  Step-3: Fetch details to get referral Data                        //
			//--------------------------------------------------------------------//
			logTitleMessage("Fetch Data to create Referral");
			HomeLib refData = new HomeLib();
			refData.workSheetName = "CreateReferral";
			refData.testCaseId = "TC_CRL_016";
			refData.fetchHomeTestData();
			logTitleMessage("Data fetching successfull");
			//-------------------------------------------------------------------------------//
			//  Step-4: Create referral with A1 as authorization and 10 as number of visits  //
			//-------------------------------------------------------------------------------//
			billingHistoryPage.clickAddReferral(referralsPage);
			billingHistoryPage.createReferral(referralsPage, driver, refData);
			logTitleMessage("Referral created successfully");
			//-------------------------------------------------------------------------------//
			//  Step-5: Verify Created referral                                              //
			//-------------------------------------------------------------------------------//
			logTitleMessage("Verification");
			billingHistoryPage.verifyReferralSummary(referralsPage,schedulingData.verifyAuthorization, schedulingData.verifyVisitsScheduled,schedulingData.verifyVisitsAllowed, schedulingData.verifyNumberUsed, schedulingData.testCaseId);
			logTitleMessage("Verification Successful");
			//--------------------------------------------------------------------//
			//  Step-3: go to Charges tab
			//--------------------------------------------------------------------//
			billingChargesPage=billingHistoryPage.goToCharges(driver);
			logTitleMessage("Navigation Successfull");
			//--------------------------------------------------------------------//
			//  Step-4: Void the First Claim                  //
			//--------------------------------------------------------------------//
			logTitleMessage("Void the Charge at Claim Level");
		    billingHistoryPage.voidAllClaim(billingChargesPage);
			logTitleMessage("Voiding the Charge successfull");
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(ReferralsPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}catch(Exception e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(ReferralsPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
}
