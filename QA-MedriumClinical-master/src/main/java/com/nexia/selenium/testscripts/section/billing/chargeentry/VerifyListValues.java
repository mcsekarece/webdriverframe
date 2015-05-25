package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyListValues extends AbstractBilling {

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyDateTypeList(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_022";
		chargeEntryData.fetchBillingTestData();
		verifyListValues(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAmbulanceTransReasonList(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_023";
		chargeEntryData.fetchBillingTestData();
		verifyListValues(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	@Test(groups = { "RegressionUS", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyConditionCodesList(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_024";
		chargeEntryData.fetchBillingTestData();
		verifyListValues(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	public boolean verifyListValues(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount,
			BillingLib chargeEntryData) throws IOException {
		Selenium selenium = null;
		boolean returnValue = true;

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
			goToPostNewCharge(selenium, chargeEntryData);
			if (chargeEntryData.testCaseId.equals("TC_CE_022")) {
				assertTrue(check(selenium, chkBoxAccident),
						"Not able to check accident related charge checkbox",
						selenium, ClassName, MethodName);
				selenium.typeKeys(lstDateType, "\b");
				selenium.type(lstDateType, "");
				waitForPageLoad(selenium);
				selenium.focus(lstDateType);
				assertTrue(
						selenium.isTextPresent("Onset of Current Illness/Symptom"),
						"Onset of Current Illness/Symptom text is not present",
						selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Initial Treatment"),
						"Initial Treatment text is not present", selenium,
						ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Last Seen Date"),
						"Last Seen Date text is not present", selenium,
						ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Acute Manifestation"),
						"Acute Manifestation text is not present", selenium,
						ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Accident"),
						"Accident text is not present", selenium, ClassName,
						MethodName);
				assertTrue(selenium.isTextPresent("LMP"),
						"LMP text is not present", selenium, ClassName,
						MethodName);
				assertTrue(selenium.isTextPresent("Last X-Ray"),
						"Last X-Ray text is not present", selenium, ClassName,
						MethodName);
				assertTrue(
						selenium.isTextPresent("Hearing &Vision Prescription"),
						"Hearing &Vision Prescription text is not present",
						selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Disability Begin"),
						"Disability Begin text is not present", selenium,
						ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Disability End"),
						"Disability End text is not present", selenium,
						ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Last Worked"),
						"Last Worked text is not present", selenium, ClassName,
						MethodName);
				
			} else if (chargeEntryData.testCaseId.equals("TC_CE_023")) {
				assertTrue(isElementPresent(selenium, lnkShowDetail),
						"Show All Detail link not present", selenium,
						ClassName, MethodName);
				assertTrue(click(selenium, lnkShowDetail),
						"Not able to click Show All Detail link", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, chkAmbulanceTrans),
						"ambulance Transport Reason CheckBox not present",
						selenium, ClassName, MethodName);
				assertTrue(
						check(selenium, chkAmbulanceTrans),
						"Not able to check ambulance Transport Reason CheckBox",
						selenium, ClassName, MethodName);
				selenium.typeKeys(lstAmbulanceTransReason, "\b");
				selenium.type(lstAmbulanceTransReason, "");
				waitForPageLoad(selenium);
				selenium.focus(lstAmbulanceTransReason);
				assertTrue(
						selenium.isTextPresent("A - Patient was transported to nearest facility for care of symptoms, complaints or both"),
						"All Reasons not Present", selenium, ClassName,
						MethodName);
				assertTrue(
						selenium.isTextPresent("B - Patient was transported for the benefit of a preferred physician"),
						"All Reasons not Present", selenium, ClassName,
						MethodName);
				assertTrue(
						selenium.isTextPresent("C - Patient was transported for the nearness of family members"),
						"All Reasons not Present", selenium, ClassName,
						MethodName);
				assertTrue(
						selenium.isTextPresent("D - Patient was transported for the care of a specialist of for availability of specialized equipment"),
						"All Reasons not Present", selenium, ClassName,
						MethodName);
				assertTrue(
						selenium.isTextPresent("E - Patient transferred to rehabilitation facility"),
						"All Reasons not Present", selenium, ClassName,
						MethodName);
			} else if (chargeEntryData.testCaseId.equals("TC_CE_024")) {

				assertTrue(isElementPresent(selenium, lnkShowDetail),
						"Show All Detail link not present", selenium,
						ClassName, MethodName);
				assertTrue(click(selenium, lnkShowDetail),
						"Not able to click Show All Detail link", selenium,
						ClassName, MethodName);
				assertTrue(isElementPresent(selenium, chkAmbulanceTrans),
						"ambulance Transport Reason CheckBox not present",
						selenium, ClassName, MethodName);
				assertTrue(
						click(selenium, chkAmbulanceTrans),
						"Not able to check ambulance Transport Reason CheckBox",
						selenium, ClassName, MethodName);
				assertTrue(
						isElementPresent(selenium,
								lnkClickToSelectConditionCode),
						"Click To Select link not present", selenium,
						ClassName, MethodName);
				assertTrue(click(selenium, lnkClickToSelectConditionCode),
						"Not able to click Click To Select link", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						selenium.isTextPresent("01 - Patient was admitted to a hospital"),
						"All Reasons not Present", selenium, ClassName,
						MethodName);
				assertTrue(
						selenium.isTextPresent("04 - Patient was moved by stretcher"),
						"All Reasons not Present", selenium, ClassName,
						MethodName);
				assertTrue(
						selenium.isTextPresent("05 - Patient was unconscious or in shock"),
						"All Reasons not Present", selenium, ClassName,
						MethodName);
				assertTrue(
						selenium.isTextPresent("06 - Patient was transported in an emergency situation"),
						"All Reasons not Present", selenium, ClassName,
						MethodName);
				assertTrue(
						selenium.isTextPresent("07 - Patient had to be physically restrained"),
						"All Reasons not Present", selenium, ClassName,
						MethodName);
				

			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
