package com.nexia.selenium.testscripts.section.billing.endtoendtestingDataSetUp;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class CreateBillingSetUpforFourthFlow extends AbstractBilling{
	@Test(groups = { "EndToEnd", "Developing", "firefox", "iexplore", "safari","default" }, description = "Test for Verify Billing settings page")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite","userAccount" })
	public void billingSetUPForFourthFlow(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib sCodeData = new BillingLib();
		sCodeData.workSheetName = "ServiceCodes";
		sCodeData.testCaseId = "TC_SC_019";
		sCodeData.fetchBillingTestData();
		addServiceCode(seleniumHost, seleniumPort, browser, webSite,userAccount, sCodeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Billing Setting Set Up
	* @action         verifying Billing Setting Set Up
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	  	  Mar 17, 2014
	***************************************************************************************************/
	
	public boolean addServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,BillingLib sCodeData) throws IOException {
		Selenium selenium = null;
		boolean returnValue = true;
		
		try {

			// --------------------------------------------------------------------//
			// Step-1: Login to the application and search for the given patient   // 
			// --------------------------------------------------------------------//

			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :"+ sCodeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount,sCodeData.userName,sCodeData.userPassword), "Login Failed ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-2:Switch Role                                                  //    
			// --------------------------------------------------------------------//
			assertTrue(switchRole(selenium, sCodeData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-3:Create Six Service Line with 1 unit and 100 fee              //
			// --------------------------------------------------------------------//
			//Navigate to Service Code
			assertTrue(navigateToServiceCode(selenium),"Could not navigate to service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 1
			assertTrue(createEndToEndServiceCode(selenium,sCodeData, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 2
			BillingLib sCode2Data = new BillingLib();
			sCode2Data.workSheetName = "ServiceCodes";
			sCode2Data.testCaseId = "TC_SC_020";
			sCode2Data.fetchBillingTestData();
			
			assertTrue(createEndToEndServiceCode(selenium,sCode2Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 3
			BillingLib sCode3Data = new BillingLib();
			sCode3Data.workSheetName = "ServiceCodes";
			sCode3Data.testCaseId = "TC_SC_021";
			sCode3Data.fetchBillingTestData();
			
			assertTrue(createEndToEndServiceCode(selenium,sCode3Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 4
			BillingLib sCode4Data = new BillingLib();
			sCode4Data.workSheetName = "ServiceCodes";
			sCode4Data.testCaseId = "TC_SC_022";
			sCode4Data.fetchBillingTestData();
			
			assertTrue(createEndToEndServiceCode(selenium,sCode4Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 5
			BillingLib sCode5Data = new BillingLib();
			sCode5Data.workSheetName = "ServiceCodes";
			sCode5Data.testCaseId = "TC_SC_023";
			sCode5Data.fetchBillingTestData();
			
			assertTrue(createEndToEndServiceCode(selenium,sCode5Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//Service code 6
			BillingLib sCode6Data = new BillingLib();
			sCode6Data.workSheetName = "ServiceCodes";
			sCode6Data.testCaseId = "TC_SC_024";
			sCode6Data.fetchBillingTestData();
			
			assertTrue(createEndToEndServiceCode(selenium,sCode6Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 7
			BillingLib sCode7Data = new BillingLib();
			sCode7Data.workSheetName = "ServiceCodes";
			sCode7Data.testCaseId = "TC_SC_025";
			sCode7Data.fetchBillingTestData();
			
			assertTrue(createEndToEndServiceCode(selenium,sCode7Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 8
			BillingLib sCode8Data = new BillingLib();
			sCode8Data.workSheetName = "ServiceCodes";
			sCode8Data.testCaseId = "TC_SC_026";
			sCode8Data.fetchBillingTestData();
			
			assertTrue(createEndToEndServiceCode(selenium,sCode8Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 9
			BillingLib sCode9Data = new BillingLib();
			sCode9Data.workSheetName = "ServiceCodes";
			sCode9Data.testCaseId = "TC_SC_027";
			sCode9Data.fetchBillingTestData();
			
			assertTrue(createEndToEndServiceCode(selenium,sCode9Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 10
			BillingLib sCode10Data = new BillingLib();
			sCode10Data.workSheetName = "ServiceCodes";
			sCode10Data.testCaseId = "TC_SC_028";
			sCode10Data.fetchBillingTestData();
			
			assertTrue(createEndToEndServiceCode(selenium,sCode10Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 11
			BillingLib sCode11Data = new BillingLib();
			sCode11Data.workSheetName = "ServiceCodes";
			sCode11Data.testCaseId = "TC_SC_029";
			sCode11Data.fetchBillingTestData();
			
			assertTrue(createEndToEndServiceCode(selenium,sCode11Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			// --------------------------------------------------------------------//
			// Step-3:Create Two Fee Schedule         //
			// --------------------------------------------------------------------//
			// Fee code one 
			BillingLib fee1Data = new BillingLib();
			fee1Data.workSheetName = "FeeSchedule";
			fee1Data.testCaseId = "TC_FS_009";
			fee1Data.fetchBillingTestData();
			
			assertTrue(click(selenium, lnkFeeSchedule),"Could not click on fee schedule link:", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(createEndToEndFeeSchedule(selenium,fee1Data, userAccount),"Fee Schedule could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//Fee Code Two
			BillingLib fee2Data = new BillingLib();
			fee2Data.workSheetName = "FeeSchedule";
			fee2Data.testCaseId = "TC_FS_010";
			fee2Data.fetchBillingTestData();
			
			assertTrue(click(selenium, lnkFeeSchedule),"Could not click on fee schedule link:", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(createEndToEndFeeSchedule(selenium,fee2Data, userAccount),"Fee Schedule could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			// --------------------------------------------------------------------//
			// Step-7:Create Five Super Bill Template with six service code        //
			// --------------------------------------------------------------------//
			
			// super bill one 
			BillingLib superBillData = new BillingLib();
			superBillData.workSheetName = "SuperBillSetUp";
			superBillData.testCaseId = "TC_SBS_014";
			superBillData.fetchBillingTestData();

			assertTrue(click(selenium,lnkSuperBillSetUp),"Could not click the Super bill Set up link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createEndToEndSuperBillSetUp(selenium,superBillData),"Could not Navigate to Biller Setting page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// super bill Two 
			BillingLib superBill2Data = new BillingLib();
			superBill2Data.workSheetName = "SuperBillSetUp";
			superBill2Data.testCaseId = "TC_SBS_015";
			superBill2Data.fetchBillingTestData();

			assertTrue(click(selenium,lnkSuperBillSetUp),"Could not click the Super bill Set up link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createEndToEndSuperBillSetUp(selenium,superBill2Data),"Could not Navigate to Biller Setting page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// super bill Three 
			BillingLib superBill3Data = new BillingLib();
			superBill3Data.workSheetName = "SuperBillSetUp";
			superBill3Data.testCaseId = "TC_SBS_016";
			superBill3Data.fetchBillingTestData();

			assertTrue(click(selenium,lnkSuperBillSetUp),"Could not click the Super bill Set up link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createEndToEndSuperBillSetUp(selenium,superBill3Data),"Could not Navigate to Biller Setting page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			// super bill four 
			BillingLib superBill4Data = new BillingLib();
			superBill4Data.workSheetName = "SuperBillSetUp";
			superBill4Data.testCaseId = "TC_SBS_017";
			superBill4Data.fetchBillingTestData();

			assertTrue(click(selenium,lnkSuperBillSetUp),"Could not click the Super bill Set up link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createEndToEndSuperBillSetUp(selenium,superBill4Data),"Could not Navigate to Biller Setting page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// super bill five 
			BillingLib superBill5Data = new BillingLib();
			superBill5Data.workSheetName = "SuperBillSetUp";
			superBill5Data.testCaseId = "TC_SBS_018";
			superBill5Data.fetchBillingTestData();

			assertTrue(click(selenium,lnkSuperBillSetUp),"Could not click the Super bill Set up link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createEndToEndSuperBillSetUp(selenium,superBill5Data),"Could not Navigate to Biller Setting page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return returnValue;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}
}
