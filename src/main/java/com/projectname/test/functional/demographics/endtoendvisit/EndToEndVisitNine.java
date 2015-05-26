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
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.ReferralsPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.pages.billing.BillingChargesPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class EndToEndVisitNine extends TestBaseClass{
	private ReferralsPage referralsPage;
	private BillingHistoryPage billingHistoryPage;
	private BillingChargesPage billingChargesPage;
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "End To End for Visits- One")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void endToEndReferralNine(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib schedulingData = new SchedulingTestLib();
		schedulingData.workSheetName = "VisitsEndToEnd";
		schedulingData.testCaseId = "TC_ETE_009";
		schedulingData.fetchSchedulingTestData();
		voidChargeAtChargeLevel(schedulingData, userAccount);
	}
	
	/**
	 * Void Charge at charge level
	 * function to Void Charge at claim level
	 * @param 	SchedulingData- Data for Scheduling
	 * @param 	String-User Account
	 * @throws  Exception 
	 * @since  	Dec 22, 2014
	 * @version 2.1
	 */
	
	public boolean voidChargeAtChargeLevel(SchedulingTestLib schedulingData, String userAccount){
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
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, schedulingData.userName, schedulingData.userPassword);
			logTitleMessage("Sucessfully logged into application");
			//--------------------------------------------------------------------//
			//  Step-2: Search for patient and go to Billing History Page                    //
			//--------------------------------------------------------------------//
			logTitleMessage("Navigate to Patient Charges");
			SharedPage sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, schedulingData.switchRole);
			billingHistoryPage=sharedPage.searchPatientForBillerRole(driver, schedulingData.patientId);
			//--------------------------------------------------------------------//
			//  Step-3: go to Charges tab
			//--------------------------------------------------------------------//
			billingChargesPage=billingHistoryPage.goToCharges(driver);
			logTitleMessage("Navigation Successfull");
			//--------------------------------------------------------------------//
			//  Step-4: Void the First Claim                  //
			//--------------------------------------------------------------------//
			logTitleMessage("Void the Charge at Claim Level");
			billingHistoryPage.voidFirstCharge(billingChargesPage);
			logTitleMessage("Voiding the Charge successfull");
			//--------------------------------------------------------------------//
			//  Step-5: Go to referral                 //
			//--------------------------------------------------------------------//
			logTitleMessage("Navigate to Referral");
			referralsPage=billingHistoryPage.goToReferral(driver);
			logTitleMessage("Navigation successfull");
			//--------------------------------------------------------------------//
			//  Step-6: Verify Data in Referral                 //
			//--------------------------------------------------------------------//
			logTitleMessage("Verification");
			billingHistoryPage.verifyReferralSummary(referralsPage,schedulingData.verifyAuthorization, schedulingData.verifyVisitsScheduled,schedulingData.verifyVisitsAllowed, schedulingData.verifyNumberUsed, schedulingData.testCaseId);
			logTitleMessage("Verification Successfull");
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(ReferralsPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}catch(Exception e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(ReferralsPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
}
