package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class PayerAuthorization extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyPayerAuthorization(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_032";
		chargeEntryData.fetchBillingTestData();
		payerAuthorization(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	

	public boolean payerAuthorization(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount,
			BillingLib chargeEntryData) throws IOException {
		Selenium selenium = null;
		String date = null;
		boolean returnValue = true;
		HomeLib payerData = new HomeLib();
		

		try {

			// --------------------------------------------------------------------//
			// Step-1: Login to the application and search for the given patient
			// //
			// --------------------------------------------------------------------//

			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);

			Assert.assertNotNull(selenium,
					"Could Not Retrive the New Selenium Session; More Details :"
							+ chargeEntryData.toString());

			assertTrue(
					loginForNexiaFromProviderSite(selenium, userAccount,
							chargeEntryData.userName,
							chargeEntryData.userPassword), "Login Failed ",
					selenium, ClassName, MethodName);

			waitForPageLoad(selenium);

			assertTrue(switchRole(selenium, chargeEntryData.switchRole),
					"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
//			 --------------------------------------------------------------------//
//			 Step-2: Go to Post New Charge
//			 --------------------------------------------------------------------//
			navigateToPatient(selenium, chargeEntryData);
			assertTrue(click(selenium,lnkUpdateDemographics),
					"Could not click Update Demographics", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-3: Navigate to Payers //
			// --------------------------------------------------------------------//
			assertTrue(click(selenium, btnPayerList),
					"Could not click the Payer", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnPatientMedicalPayers),
					"Could not click the Medical Payer", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			// --------------------------------------------------------------------//
			// Step-4: Delete all Payers //
			// --------------------------------------------------------------------//
			AbstractHomeTest payers = new AbstractHomeTest();
			assertTrue(payers.deleteAllPayers(selenium),
					"Delete All Payers failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// --------------------------------------------------------------------//
			// Step-5: Add new Payers //
			// --------------------------------------------------------------------//
			assertTrue(click(selenium,payers.btnAddNew),
					"Could not click New button", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat1;
			if(userAccount.equals(CAAccount)){
				 DateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			}else{
					DateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			}
			date = DateFormat1.format(cal.getTime());
			
			payerData.workSheetName = "AddPayers";
			payerData.testCaseId = "TC_CP_017";
			payerData.fetchHomeTestData();
			ClassName = this.getClass().getName().substring(39);
			MethodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();
			
		
			

			assertTrue(
					payers.addNewPayer(selenium, payerData, date, userAccount),
					"Add New Payer failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkReferrals);
			waitForPageLoad(selenium);
			// --------------------------------------------------------------------//
			// Step-6: Delete all Referral //
			// --------------------------------------------------------------------//
			
			assertTrue(payers.deleteAllReferral(selenium), "Could not delete all referals", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-7: Create a new Referral //
			//---------------------------------------------------------- ----------//
			
			payerData.workSheetName = "CreateReferral";
			payerData.testCaseId = "TC_CRL_015";
			payerData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			assertTrue(click(selenium,btnAddReferral),"Could not Click on Add Referral Button:"+ payerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(payers.createReferral(selenium,payerData),"Referral creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			navigateToPatient(selenium, chargeEntryData);
			goToPostNewCharge(selenium, chargeEntryData);
			assertTrue(selectValueFromAjaxList(selenium,lstAuthorization, payerData.authorizationNum2),"", selenium, ClassName, MethodName);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
