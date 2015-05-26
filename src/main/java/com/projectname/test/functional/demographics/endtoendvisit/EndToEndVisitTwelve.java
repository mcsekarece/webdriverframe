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
public class EndToEndVisitTwelve extends TestBaseClass{
	PostChargesPage postChargePage;
	ReferralsPage referralsPage;
	BillingHistoryPage billingHistoryPage;
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "End To End for Visits- One")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void endToEndVisitsTwelve(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib schedulingData = new SchedulingTestLib();
		schedulingData.workSheetName = "VisitsEndToEnd";
		schedulingData.testCaseId = "TC_ETE_012";
		schedulingData.fetchSchedulingTestData();
		verifyAuthorization(schedulingData, userAccount);
	}
	
	/**
	 * Create New patient
	 * function to add a new patient
	 * @param schedulingData 
	 * @param 		patientData
	 * @param 		browser
	 * @param 		webSite
	 * @throws      Exception 
	 * @since  	    Nov 24, 2012
	 */
	
	public boolean verifyAuthorization(SchedulingTestLib schedulingData, String userAccount) {
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
			//  Step-2: Fetch Data to post charge                    //
			//--------------------------------------------------------------------//
			logTitleMessage("Fetch Data to post charges");
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "ChargeEntry";
			billingData.testCaseId = "TC_CE_071";
			billingData.fetchBillingTestData();
			logTitleMessage("Data fetching Successful"); 
			//--------------------------------------------------------------------//
			//  Step-3: Go to post Charges                     //
			//--------------------------------------------------------------------//
			logTitleMessage("Navigate to Post Charges");
			SharedPage sharedPage=new SharedPage();
			sharedPage.switchRole(driver, schedulingData.switchRole);
			postChargePage=sharedPage.gotoChargeEntryPage(driver, billingData.patientID);
			logTitleMessage("Navigation Successfull");
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Available authorization numbers                   //
			//--------------------------------------------------------------------//
			logTitleMessage("Verification");
			assertTrue(!postChargePage.verifyAvailableAuthorization(billingData.referringProvider, billingData.authorizationToSelect),billingData.authorizationToSelect+" authorization number is still available", driver,className, methodName);
			billingData.workSheetName = "ChargeEntry";
			billingData.testCaseId = "TC_CE_067";
			billingData.fetchBillingTestData();
			assertTrue(postChargePage.verifyAvailableAuthorization(billingData.referringProvider, billingData.authorizationToSelect),billingData.authorizationToSelect+" authorization number is still available", driver,className, methodName);
			logTitleMessage("Verification Successfull");
			
		
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(ReferralsPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}catch(Exception e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(ReferralsPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}
}
