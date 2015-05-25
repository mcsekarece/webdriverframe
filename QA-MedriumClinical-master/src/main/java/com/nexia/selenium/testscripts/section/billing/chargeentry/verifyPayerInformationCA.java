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

public class verifyPayerInformationCA extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyHCNInformation(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_052";
		chargeEntryData.fetchBillingTestData();
		verifyPayerInformation(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyPayerInformation(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_053";
		chargeEntryData.fetchBillingTestData();
		verifyPayerInformation(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	public boolean verifyPayerInformation(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount,
			BillingLib chargeEntryData) throws IOException {
		Selenium selenium = null;
		String date = null;
		boolean returnValue = true;
		HomeLib payerData = new HomeLib();
		String HCN;
		AbstractHomeTest payers = new AbstractHomeTest();

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
			// --------------------------------------------------------------------//
			// Step-2: Go to Patient
			// --------------------------------------------------------------------//
			navigateToPatient(selenium, chargeEntryData);
			assertTrue(click(selenium, lnkViewChart),
					"Could not click the Payer", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkPatientOption),
					"Could not click the Payer", selenium, ClassName,
					MethodName);
			assertTrue(click(selenium, lnkViewRegistration),
					"Could not click the Payer", selenium, ClassName,
					MethodName);
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
				selenium.chooseOkOnNextConfirmation();
				}
			assertTrue(click(selenium, payers.btnRegistrationEdit),
					"Could not Edit Button", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			HCN=selenium.getText(payers.txtHealthCareNumber);
			assertTrue(click(selenium, payers.btnSave1),
					"Could not Edit Button", selenium, ClassName,
					MethodName);
//			assertTrue(click(selenium, payers.),
//					"Could not click the Payer", selenium, ClassName,
//					MethodName);
//			
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-3: Navigate to Payers //
			// --------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnPayerList),
					"Could not click the Payer", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat1 = new SimpleDateFormat(
					"dd/MM/yyyy");
			date = DateFormat1.format(cal.getTime());
			
			if(chargeEntryData.testCaseId.equals("TC_CE_053")){
				payerData.workSheetName = "AddPayers";
				payerData.testCaseId = "TC_CP_017";
				payerData.fetchHomeTestData();
				ClassName = this.getClass().getName().substring(39);
				MethodName = Thread.currentThread().getStackTrace()[1]
						.getMethodName();
	
				assertTrue(click(selenium, btnPatientMedicalPayers),
						"Could not click the Medical Payer", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);
			
				assertTrue(payers.deleteAllPayers(selenium),
						"Delete All Payers failed", selenium, ClassName, MethodName);
				
					waitForPageLoad(selenium);
					
	
					assertTrue(click(selenium, payers.btnAddNew),
							"Could not click New button", selenium, ClassName,
							MethodName);
					waitForPageLoad(selenium);
					assertTrue(payers.addNewPayer(selenium, payerData, date,
							userAccount), "Add New Payer failed", selenium,
							ClassName, MethodName);
					waitForPageLoad(selenium);
			}
				if(chargeEntryData.testCaseId.equals("TC_CE_052")){
					payerData.workSheetName = "AddPayers";
					payerData.testCaseId = "TC_CP_018";
					payerData.fetchHomeTestData();
					ClassName = this.getClass().getName().substring(39);
					MethodName = Thread.currentThread().getStackTrace()[1]
							.getMethodName();
					assertTrue(click(selenium, btnPatientOtherPayers),
							"Could not click the Medical Payer", selenium, ClassName,
							MethodName);
					waitForPageLoad(selenium);
					assertTrue(payers.deleteAllOtherPayers(selenium),
							"Delete All Payers failed", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium, payers.btnAddNewForOtherPayer),
							"Could not click New button", selenium, ClassName,
							MethodName);
					date="25/05/2014";
					assertTrue(payers.addNewPayer(selenium, payerData, date,
							userAccount), "Add New Payer failed", selenium,
							ClassName, MethodName);
				}
			
				navigateToPatient(selenium, chargeEntryData);
				goToPostNewCharge(selenium, chargeEntryData);
				
				if(chargeEntryData.testCaseId.equals("TC_CE_053")){
				assertTrue(selenium.isTextPresent(payerData.payerName),
						"Could not click New button", selenium, ClassName,
						MethodName);
				assertTrue(
						selenium.isTextPresent(HCN),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						isElementPresent(selenium,ajxPaymentProgram),
						"Payment Program pick list not present", selenium,
						ClassName, MethodName);
				assertTrue(
						isElementPresent(selenium,ajxBillTo),
						"Payment Program pick list not present", selenium,
						ClassName, MethodName);
				}
			
				if(chargeEntryData.testCaseId.equals("TC_CE_052")){
				assertTrue(
						selenium.getValue(selenium.getText(ajxBillTo)).contains(payerData.payerName),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						selenium.isTextPresent(HCN),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						selenium.getValue(selenium.getText(ajxPaymentProgram)).contains("HCP - Health Claims Payment"),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						click(selenium,chkBoxAccident),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						selenium.getValue(selenium.getText(ajxPaymentProgram)).contains("WCB - Workers Compensation Board"),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						isElementPresent(selenium,chkPayer),
						"Payment Program pick list not present", selenium,
						ClassName, MethodName);
				}
				
				
				

		
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}
	
}
