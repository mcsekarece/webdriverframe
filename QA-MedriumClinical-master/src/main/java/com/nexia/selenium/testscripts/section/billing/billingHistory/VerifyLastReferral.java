package com.nexia.selenium.testscripts.section.billing.billingHistory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLastReferral extends AbstractHomeTest {
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying billing information")
    @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicalPayerInformation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "BillingHistory";
		billingData.testCaseId = "TC_BH_001";
		billingData.fetchBillingTestData();
		verifyBillingHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    
    /**
	 * verifyBillingHistory
	 * function to verify Billing History
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      	IOException 
	 * @since  	   	Jan 24, 2014
	 */
	
	public boolean verifyBillingHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		String date =null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Billing History //
			//--------------------------------------------------------------------//
			
			assertTrue(goToBillingHistory(selenium,billingData),"Navigation Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3:Add Referrals//
			//--------------------------------------------------------------------//
			
			/*searchPatientNexia(selenium,billingData.patientID);
			waitForPageLoad(selenium);*/
			
			HomeLib refData = new HomeLib();
			refData.workSheetName = "CreateReferral";
			refData.testCaseId = "TC_CRL_001";
			refData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			
			assertTrue(click(selenium,lnkReferralsHistory),"could not click referral link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddReferral),"Could not Click on Add Referral Button:"+ refData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createReferral(selenium,refData),"Referral creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Verify Payer Details//
			//--------------------------------------------------------------------//
			assertTrue(goToBillingHistory(selenium,billingData),"Navigation Failed ", selenium, ClassName, MethodName);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if(userAccount.equals(USAccount))
				DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			else
				DateFormat=new SimpleDateFormat("MMM dd, yyyy");
			date=DateFormat.format(cal.getTime());
			DateFormat=new SimpleDateFormat("HH");
			
			assertTrue(verifyLastReferral(selenium,refData,date),"Navigation Failed ", selenium, ClassName, MethodName);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
