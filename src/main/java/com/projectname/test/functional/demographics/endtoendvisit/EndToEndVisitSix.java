package com.projectname.test.functional.demographics.endtoendvisit;



import java.util.Calendar;
import java.util.TimeZone;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.BillingLib;
import com.projectname.testutils.genericutility.testDataLib.SchedulingTestLib;
import com.projectname.testutils.pages.BillingHistoryPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PostChargesPage;
import com.projectname.testutils.pages.ReferralsPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class EndToEndVisitSix extends TestBaseClass{
	private PostChargesPage postChargePage;
	private ReferralsPage referralsPage;
	private BillingHistoryPage billingHistoryPage;
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "End To End for Visits- One")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void endToEndReferralSix(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib schedulingData = new SchedulingTestLib();
		schedulingData.workSheetName = "VisitsEndToEnd";
		schedulingData.testCaseId = "TC_ETE_006";
		schedulingData.fetchSchedulingTestData();
		postChargeB(schedulingData, userAccount);
	}
	
	/**
	 * Post Charge for a Patient and verify Authorization Data
	 * function to post Charge for a patient
	 * @param 	SchedulingData- Data for Scheduling
	 * @param 	String-User Account
	 * @throws  Exception 
	 * @since  	Dec 18, 2014
	 * @version 2.1
	 */
	
	public boolean postChargeB(SchedulingTestLib schedulingData, String userAccount) {
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
			logTitleMessage("Log into Application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, schedulingData.userName, schedulingData.userPassword);
			logTitleMessage("Sucessfully logged into application");
			//--------------------------------------------------------------------//
			//  Step-2: Fetch Data to post charge B                  //
			//--------------------------------------------------------------------//
			logTitleMessage("Fetch Data to Post charges");
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "ChargeEntry";
			billingData.testCaseId = "TC_CE_068";
			billingData.fetchBillingTestData();
			logTitleMessage("Data fetching successfull");
			//--------------------------------------------------------------------//
			//  Step-3: Go to post Charges                     //
			//--------------------------------------------------------------------//
			logTitleMessage("Navigate to Post Charges");
			SharedPage sharedPage=new SharedPage();
			sharedPage.switchRole(driver, schedulingData.switchRole);
			postChargePage=sharedPage.gotoChargeEntryPage(driver, billingData.patientID);
			logTitleMessage("Navigation successfull");
			//--------------------------------------------------------------------//
			//  Step-4: Post Charge B                      //
			//--------------------------------------------------------------------//
			logTitleMessage("Post Charges");
			billingHistoryPage=postChargePage.savePostChargeEntry(driver, billingData, userAccount);
			logTitleMessage("Charge Posted successfully");
			//--------------------------------------------------------------------//
			//  Step-5: navigate to Referral to Verify                  //
			//--------------------------------------------------------------------//
			logTitleMessage("Navigate to referral");
			referralsPage=billingHistoryPage.goToReferral(driver);
			logTitleMessage("Navigation successfull");
			//--------------------------------------------------------------------//
			//  Step-6: Verify Data in Referral                 //
			//--------------------------------------------------------------------//
			logTitleMessage("Verification");
			billingHistoryPage.verifyReferralSummary(referralsPage,schedulingData.verifyAuthorization, schedulingData.verifyVisitsScheduled,schedulingData.verifyVisitsAllowed, schedulingData.verifyNumberUsed, schedulingData.testCaseId);
			logTitleMessage("Verification successfull");
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(ReferralsPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}catch(Exception e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(ReferralsPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
}
