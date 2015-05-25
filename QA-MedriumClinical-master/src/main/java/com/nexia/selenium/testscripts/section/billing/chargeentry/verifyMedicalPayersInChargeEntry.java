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

public class verifyMedicalPayersInChargeEntry extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyMedicalPayers(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_052";
		chargeEntryData.fetchBillingTestData();
		verifyMedicalPayers(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyMedicalPayersDetails(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_053";
		chargeEntryData.fetchBillingTestData();
		verifyMedicalPayers(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	public boolean verifyMedicalPayers(String seleniumHost, int seleniumPort,
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
			AbstractHomeTest payers = new AbstractHomeTest();
			assertTrue(payers.deleteAllPayers(selenium),
					"Delete All Payers failed", selenium, ClassName, MethodName);
			/* start here */if (chargeEntryData.testCaseId.equals("TC_CE_026")
					|| chargeEntryData.testCaseId.equals("TC_CE_027")
					|| chargeEntryData.testCaseId.equals("TC_CE_028")) {

				waitForPageLoad(selenium);

				assertTrue(click(selenium, payers.btnAddNew),
						"Could not click New button", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat1 = new SimpleDateFormat(
						"MM/dd/yyyy");
				date = DateFormat1.format(cal.getTime());

				payerData.workSheetName = "AddPayers";
				payerData.testCaseId = "TC_CP_018";
				payerData.fetchHomeTestData();
				ClassName = this.getClass().getName().substring(39);
				MethodName = Thread.currentThread().getStackTrace()[1]
						.getMethodName();

				assertTrue(payers.addNewPayer(selenium, payerData, date,
						userAccount), "Add New Payer failed", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);
				if (chargeEntryData.testCaseId.equals("TC_CE_052")) {
					payerData.testCaseId = "TC_CP_019";
					payerData.fetchHomeTestData();
					assertTrue(payers.addNewPayer(selenium, payerData, date,
							userAccount), "Add New Payer failed", selenium,
							ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				navigateToPatient(selenium, chargeEntryData);
				goToPostNewCharge(selenium, chargeEntryData);
				Integer cntMedicalPayers = (Integer) selenium
						.getXpathCount(lstAuthorization);

				assertTrue(cntMedicalPayers == 2,
						"All Medical Payers not Present", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);
			}
			else{
				navigateToPatient(selenium, chargeEntryData);
				goToPostNewCharge(selenium, chargeEntryData);
				assertTrue(
						getText(selenium, lblEmpPayers).contains(
								payerData.payerName),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						getText(selenium, lblEmpPayers).contains(
								payerData.memberId),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						getText(selenium, lblEmpPayers).contains(
								payerData.groupName),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						getText(selenium, lblEmpPayers).contains(
								payerData.firstName),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
				assertTrue(
						getText(selenium, lblEmpPayers)
								.contains(payerData.lastName),
						"Wait Days text  not present properly", selenium,
						ClassName, MethodName);
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}
	
}
