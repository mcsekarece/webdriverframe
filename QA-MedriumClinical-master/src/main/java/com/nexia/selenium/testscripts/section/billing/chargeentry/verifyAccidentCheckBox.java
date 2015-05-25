	package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.internal.seleniumemulation.IsTextPresent;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class verifyAccidentCheckBox extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAccidentEmployee(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_026";
		chargeEntryData.fetchBillingTestData();
		postChargeEntry(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAccidentAuto(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_027";
		chargeEntryData.fetchBillingTestData();
		postChargeEntry(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAccidentOther(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_028";
		chargeEntryData.fetchBillingTestData();
		postChargeEntry(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAccidentNoEmployee(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_029";
		chargeEntryData.fetchBillingTestData();
		postChargeEntry(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAccidentNoAuto(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_030";
		chargeEntryData.fetchBillingTestData();
		postChargeEntry(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAccidentNoOther(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_031";
		chargeEntryData.fetchBillingTestData();
		postChargeEntry(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	public boolean postChargeEntry(String seleniumHost, int seleniumPort,
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
			// Step-2: Go to Post New Charge
			// --------------------------------------------------------------------//
	
			navigateToPatient(selenium, chargeEntryData);
			assertTrue(click(selenium,lnkUpdateDemographics),
					"Could not click Update Demographics", selenium, ClassName, MethodName);
//			assertTrue(searchPatientNexia(selenium, chargeEntryData.patientID),
//					"Search Patient failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-3: Navigate to Payers //
			// --------------------------------------------------------------------//
			assertTrue(click(selenium, btnPayerList),
					"Could not click the Payer", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnPatientOtherPayers),
					"Could not click the Medical Payer", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			AbstractHomeTest payers = new AbstractHomeTest();
			assertTrue(payers.deleteAllOtherPayers(selenium),
					"Delete All Payers failed", selenium, ClassName, MethodName);
			if (chargeEntryData.testCaseId.equals("TC_CE_026")||chargeEntryData.testCaseId.equals("TC_CE_027")||chargeEntryData.testCaseId.equals("TC_CE_028")) {
			
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,payers.btnAddOtherNew),
					"Could not click New button", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat1.format(cal.getTime());
			if(userAccount.equals(CAAccount)){
				DateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
				date = DateFormat1.format(cal.getTime());
			}
			
			payerData.workSheetName = "AddPayers";
			if (chargeEntryData.testCaseId.equals("TC_CE_026")){
				payerData.testCaseId = "TC_CP_018";
			}else if (chargeEntryData.testCaseId.equals("TC_CE_027")){
				payerData.testCaseId = "TC_CP_035";
			}else if (chargeEntryData.testCaseId.equals("TC_CE_028")){
				payerData.testCaseId = "TC_CP_036";
			}
		
			payerData.fetchHomeTestData();
			ClassName = this.getClass().getName().substring(39);
			MethodName = Thread.currentThread().getStackTrace()[1]
					.getMethodName();

			assertTrue(
					payers.addNewPayer(selenium, payerData, date, userAccount),
					"Add New Payer failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
			navigateToPatient(selenium, chargeEntryData);
			goToPostNewCharge(selenium, chargeEntryData);
			assertTrue(isElementPresent(selenium, chkBoxAccident),
					"Adjustment Reason textbox not Present", selenium,
					ClassName, MethodName);
			assertTrue(click(selenium, chkBoxAccident),
					"Adjustment Reason textbox not Present", selenium,
					ClassName, MethodName);

			if (chargeEntryData.testCaseId.equals("TC_CE_026")) {
				assertTrue(isElementPresent(selenium, chkBoxEmployment),
						"Adjustment Reason textbox not Present", selenium,
						ClassName, MethodName);
				assertTrue(click(selenium, chkBoxEmployment),
						"Adjustment Reason textbox not Present", selenium,
						ClassName, MethodName);
				payerData.workSheetName = "AddPayers";
				payerData.testCaseId = "TC_CP_018";
				payerData.fetchHomeTestData();

			} else if (chargeEntryData.testCaseId.equals("TC_CE_027")) {
				assertTrue(isElementPresent(selenium, chkBoxAuto),
						"Adjustment Reason textbox not Present", selenium,
						ClassName, MethodName);
				assertTrue(click(selenium, chkBoxAuto),
						"Adjustment Reason textbox not Present", selenium,
						ClassName, MethodName);
				payerData.workSheetName = "AddPayers";
				payerData.testCaseId = "TC_CP_035";
				payerData.fetchHomeTestData();
			} else if (chargeEntryData.testCaseId.equals("TC_CE_028")) {
				assertTrue(isElementPresent(selenium, chkBoxAuto),
						"Adjustment Reason textbox not Present", selenium,
						ClassName, MethodName);
				payerData.workSheetName = "AddPayers";
				payerData.testCaseId = "TC_CP_036";
				payerData.fetchHomeTestData();
			}
			
			if (chargeEntryData.testCaseId.equals("TC_CE_026")||chargeEntryData.testCaseId.equals("TC_CE_027")||chargeEntryData.testCaseId.equals("TC_CE_028")) {
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
			assertTrue(
					getText(selenium, lblEmpPayers).contains(
							payerData.payerName),
					"Wait Days text  not present properly", selenium,
					ClassName, MethodName);
			if(userAccount.equals(USAccount)){
			assertTrue(
					getText(selenium, lblEmpPayers).contains(
							payerData.memberId),
					"Wait Days text  not present properly", selenium,
					ClassName, MethodName);
			}
			}
			if (chargeEntryData.testCaseId.equals("TC_CE_029")){
				assertTrue(isElementPresent(selenium, chkBoxEmployment),
						"Adjustment Reason textbox not Present", selenium,
						ClassName, MethodName);
				assertTrue(click(selenium, chkBoxEmployment),
						"Could not click Employment Checkbox", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						selenium.isTextPresent("No EMPLOYMENT payers found"),
						"No EMPLOYMENT payers found text not present", selenium,
						ClassName, MethodName);
			}else if (chargeEntryData.testCaseId.equals("TC_CE_030")){
				
				assertTrue(isElementPresent(selenium, chkBoxAuto),
						"AUTO check box not found", selenium,
						ClassName, MethodName);
				assertTrue(click(selenium, chkBoxAuto),
						"Could not click AUTO checbox", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						selenium.isTextPresent("No AUTO payers found"),
						"No AUTO payers found text not present", selenium,
						ClassName, MethodName);
				
			}else if (chargeEntryData.testCaseId.equals("TC_CE_031")){
				
				assertTrue(isElementPresent(selenium, chkBoxOther),
						"OTHER checkbox not found", selenium,
						ClassName, MethodName);
				if(!isChecked(selenium, chkBoxOther)){
					assertTrue(click(selenium, chkBoxOther),
						"Could not click OTHER check box", selenium,
						ClassName, MethodName);
				}
				waitForPageLoad(selenium);
				assertTrue(
						selenium.isTextPresent("No OTHER payers found"),
						"No Other payers found text not present", selenium,
						ClassName, MethodName);
			}
			
			

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
