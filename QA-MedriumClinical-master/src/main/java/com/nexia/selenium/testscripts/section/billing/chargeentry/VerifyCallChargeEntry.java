package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;

import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCallChargeEntry extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyCallChargeEntry(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_044";
		chargeEntryData.fetchBillingTestData();
		verifyChargeEntryView(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	public boolean verifyChargeEntryView(String seleniumHost, int seleniumPort,
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
			assertTrue(click(selenium, btnNexiaLogo),
					"Could not click the Nexia Logo", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	        
	        waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, lnkPostChargeHome),
					"Could not present the Booking Appointment", selenium,
					ClassName, MethodName);
			assertTrue(click(selenium, lnkPostChargeHome),
					"Could not click the Booking Appointment", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	        
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, btnAddPostCharge),
					"Could not present the Booking Appointment", selenium,
					ClassName, MethodName);
			assertTrue(click(selenium, btnAddPostCharge),
					"Could not click the Booking Appointment", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, ajxPostChargeSearchPatient, chargeEntryData.patientID),"Could not type patient id", selenium, ClassName,MethodName);
			selenium.clickAt(ajxPostChargeSearchPatient,"");
			selenium.focus(ajxPostChargeSearchPatient);			
			selenium.fireEvent(ajxPostChargeSearchPatient,"keypress");		
			waitForElement(selenium, lblPatientResult, 10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ chargeEntryData.patientID, selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			selenium.click(lblPatientResult);
			waitForPageLoad(selenium);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
