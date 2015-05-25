package com.nexia.selenium.testscripts.section.billing.endtoendtestingDataSetUp;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class CreateBillingSettingSetUpCA extends AbstractBilling{
	@Test(groups = { "EndToEndCA", "Developing", "firefox", "iexplore", "safari","default" }, description = "Test for Create Billing Set Up")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite","userAccount" })
	public void addnewAdjusmentReasons(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_020";
		adjustmentCodeData.fetchBillingTestData();
		addAdjusmentReasons(seleniumHost, seleniumPort, browser, webSite,userAccount, adjustmentCodeData);
	}

	
	
	/*************************************************************************************************** 
	* @purpose        To verify Billing Setting Set Up
	* @action         verifying Billing Setting Set Up
	* @author         Jagmit
	* @state          Developing
	* @useraccount    Both
	* @since  	  August 20, 2014
	***************************************************************************************************/
	
	public boolean addAdjusmentReasons(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,BillingLib adjustmentCodeData) throws IOException {
		Selenium selenium = null;
		boolean returnValue = true;
		
		try {

			// --------------------------------------------------------------------//
			// Step-1: Login to the application and search for the given patient   // 
			// --------------------------------------------------------------------//

			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :"+ adjustmentCodeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount,adjustmentCodeData.userName,adjustmentCodeData.userPassword), "Login Failed ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-2:Switch Role                                                  //    
			// --------------------------------------------------------------------//
			assertTrue(switchRole(selenium, adjustmentCodeData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-3: Go to Adjustment Reasons                                    //
			// --------------------------------------------------------------------//
			assertTrue(goToAdjustmentReasons(selenium),"Adjustment Navigation Failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-3: Search  Adjustment Reasons                                    //
			// --------------------------------------------------------------------//
			assertTrue(createEndToEndAjustmentReason(selenium,adjustmentCodeData),"Adjustment Navigation Failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			// --------------------------------------------------------------------//
			// Step-5:Create Adjustment with Debit Option                          //
			// --------------------------------------------------------------------//
		
			adjustmentCodeData.testCaseId = "TC_AC_021";
			adjustmentCodeData.fetchBillingTestData();
			
			assertTrue(click(selenium, lnkAdjustmentCodes),"Could not click Adjustment Reasons", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(createEndToEndAjustmentReason(selenium,adjustmentCodeData),"Adjustment Navigation Failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-6:Create Six Service Line with 1 unit and 100 fee              //
			// --------------------------------------------------------------------//
			//Navigate to Service Code
			assertTrue(click(selenium, lnkServiceCode),"Could not navigate to service code section", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 1
			BillingLib sCodeData = new BillingLib();
			sCodeData.workSheetName = "ServiceCodes";
			sCodeData.testCaseId = "TC_SC_009";
			sCodeData.fetchBillingTestData();
			
			assertTrue(createEndToEndServiceCode(selenium,sCodeData, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 2
			BillingLib sCode2Data = new BillingLib();
			sCode2Data.workSheetName = "ServiceCodes";
			sCode2Data.testCaseId = "TC_SC_010";
			sCode2Data.fetchBillingTestData();
			
			
			
			assertTrue(createEndToEndServiceCode(selenium,sCode2Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 3
			BillingLib sCode3Data = new BillingLib();
			sCode3Data.workSheetName = "ServiceCodes";
			sCode3Data.testCaseId = "TC_SC_011";
			sCode3Data.fetchBillingTestData();
			
			
			
			assertTrue(createEndToEndServiceCode(selenium,sCode3Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 4
			BillingLib sCode4Data = new BillingLib();
			sCode4Data.workSheetName = "ServiceCodes";
			sCode4Data.testCaseId = "TC_SC_012";
			sCode4Data.fetchBillingTestData();
			
			assertTrue(click(selenium, lnkServiceCode),"Could not navigate to service code section", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createEndToEndServiceCode(selenium,sCode4Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 5
			BillingLib sCode5Data = new BillingLib();
			sCode5Data.workSheetName = "ServiceCodes";
			sCode5Data.testCaseId = "TC_SC_013";
			sCode5Data.fetchBillingTestData();
			
			
			assertTrue(createEndToEndServiceCode(selenium,sCode5Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//Service code 6
			BillingLib sCode6Data = new BillingLib();
			sCode6Data.workSheetName = "ServiceCodes";
			sCode6Data.testCaseId = "TC_SC_014";
			sCode6Data.fetchBillingTestData();
			
			
			
			assertTrue(createEndToEndServiceCode(selenium,sCode6Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 7
			BillingLib sCode7Data = new BillingLib();
			sCode7Data.workSheetName = "ServiceCodes";
			sCode7Data.testCaseId = "TC_SC_015";
			sCode7Data.fetchBillingTestData();
			
			
			
			assertTrue(createEndToEndServiceCode(selenium,sCode7Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 8
			BillingLib sCode8Data = new BillingLib();
			sCode8Data.workSheetName = "ServiceCodes";
			sCode8Data.testCaseId = "TC_SC_016";
			sCode8Data.fetchBillingTestData();
			
			
			
			assertTrue(createEndToEndServiceCode(selenium,sCode8Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 9
			BillingLib sCode9Data = new BillingLib();
			sCode9Data.workSheetName = "ServiceCodes";
			sCode9Data.testCaseId = "TC_SC_017";
			sCode9Data.fetchBillingTestData();
			
			
			assertTrue(createEndToEndServiceCode(selenium,sCode9Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Service code 10
			BillingLib sCode10Data = new BillingLib();
			sCode10Data.workSheetName = "ServiceCodes";
			sCode10Data.testCaseId = "TC_SC_018";
			sCode10Data.fetchBillingTestData();
			
			assertTrue(createEndToEndServiceCode(selenium,sCode10Data, userAccount),"Service code  could not be created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-7:Create Super Bill Template with six service code            //
			// --------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSuperBillSetUp),"Could not click the Super bill Set up link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			BillingLib superBillData = new BillingLib();
			superBillData.workSheetName = "SuperBillSetUp";
			superBillData.testCaseId = "TC_SBS_013";
			superBillData.fetchBillingTestData();

			assertTrue(createEndToEndSuperBillSetUp(selenium,superBillData),"Could not Navigate to Biller Setting page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			return returnValue;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}
	
	
	
}
