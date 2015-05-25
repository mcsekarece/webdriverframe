package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTimeBasedServiceCode extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyServiceTimePopUp(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_056";
		chargeEntryData.fetchBillingTestData();
		verifyServiceTimePopUp(seleniumHost, seleniumPort, browser,
				webSite, userAccount, chargeEntryData);
	}

	public boolean verifyServiceTimePopUp(String seleniumHost,
			int seleniumPort, String browser, String webSite,
			String userAccount, BillingLib chargeEntryData) throws IOException {
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
			// Step-2: Navigate to service code //
			// --------------------------------------------------------------------//

			assertTrue(navigateToServiceCode(selenium),
					"Could not navigate to service code", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			// --------------------------------------------------------------------//
			// Step-3: Add Master List Service Code //
			// --------------------------------------------------------------------//
			assertTrue(click(selenium, btnManageServiceCodes),
					"Could not click the add button", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, lnkCustomTab),
					"Could not click the custom tab", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);

			// get the Unique custom service code using current date and time
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			DateFormat = new SimpleDateFormat("MMddHHmmss");
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "ServiceCodes";
			billingData.testCaseId = "TC_SC_004";
			billingData.fetchBillingTestData();
			billingData.serviceCode1 = DateFormat.format(cal.getTime());
			billingData.serviceDescription1 = billingData.serviceDescription1
					+ billingData.serviceCode1;

			assertTrue(
					type(selenium, txtCustomServiceCode,
							billingData.serviceCode1),
					"Could not type the custom service code", selenium,
					ClassName, MethodName);
			assertTrue(
					type(selenium, txtCustomDescription,
							billingData.serviceDescription1),
					"Could not type the custom service description", selenium,
					ClassName, MethodName);
			assertTrue(
					click(selenium, btnAddCustomServiceCode),
					"Could not click the add button in the custom service code tab",
					selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-4: Fill details in service fees //
			// --------------------------------------------------------------------//
			assertTrue(click(selenium, rdoSetServiceFees),
					"Could not click the set service fees radio button",
					selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(fillServiceFee(selenium, billingData, userAccount),
					"Could not fill the service fees", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, rdoSetServiceDefault),"Could not click the set service default radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if (!isChecked(selenium, chkMultiplyFee)) {
				assertTrue(click(selenium, chkMultiplyFee),
						"Could not check the multiply fee", selenium,
						ClassName, MethodName);
			}
			if (!isChecked(selenium, chkTimedProcedure)) {
				assertTrue(click(selenium, chkTimedProcedure),
						"Could not check the timed procedure", selenium,
						ClassName, MethodName);
			}
			assertTrue(
					selectValueFromAjaxList(selenium, ajxTypeOfService,
							chargeEntryData.ServiceType),
					"Service Code not available", selenium, ClassName,
					MethodName);
			
			
			assertTrue(click(selenium, btnDoneServiceCode),
					"Could not click the done button", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);

			navigateToPatient(selenium, chargeEntryData);
			goToPostNewCharge(selenium, chargeEntryData);
			assertTrue(
					selectValueFromAjaxList(selenium, serviceCode,
							billingData.serviceCode1),
					"Service Code not available", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			selenium.click(txtUnits);
			
			assertTrue(isElementPresent(selenium, serviceTimePopUp),
					"Service Time Pop up not present", selenium, ClassName,
					MethodName);
			assertTrue(type(selenium, startTimeServiceTimeHr,chargeEntryData.StartServiceHr),
					"Could not enter service start time Hr", selenium, ClassName,
					MethodName);
			assertTrue(type(selenium, startTimeServiceTimeMin,chargeEntryData.StartServiceMin),
					"Could not enter service start time Min", selenium, ClassName,
					MethodName);
			assertTrue(type(selenium, endTimeServiceTimeHr,chargeEntryData.EndServiceHr),
					"Could not enter service end time Hr", selenium, ClassName,
					MethodName);
			assertTrue(type(selenium, endTimeServiceTimeMin,chargeEntryData.EndServiceMin),
					"Could not enter service end time Min", selenium, ClassName,
					MethodName);
			assertTrue(type(selenium,durationServiceTime,chargeEntryData.ServiceTimeDuration),
					"Could not enter service duration", selenium, ClassName,
					MethodName);
			assertTrue(click(selenium, btnSaveServiceTime),
					"Could not save service time", selenium, ClassName,
					MethodName);
			selenium.mouseOver(serviceCode);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxTherapy,
							chargeEntryData.Therapy),
					"Could not select Therapy", selenium, ClassName,
					MethodName);
			assertTrue(click(selenium, btnSaveTherapy),
					"Could not save Therapy", selenium, ClassName,
					MethodName);
				

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
