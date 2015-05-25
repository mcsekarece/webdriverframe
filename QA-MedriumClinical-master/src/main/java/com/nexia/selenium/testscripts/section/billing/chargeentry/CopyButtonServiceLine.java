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

public class CopyButtonServiceLine extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void copyButtonOfServiceLine(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_009";
		chargeEntryData.fetchBillingTestData();
		copyButtonOfServiceLine(seleniumHost, seleniumPort, browser, webSite,
				userAccount, chargeEntryData);
	}

	public boolean copyButtonOfServiceLine(String seleniumHost,
			int seleniumPort, String browser, String webSite,
			String userAccount, BillingLib chargeEntryData) throws IOException {
		Selenium selenium = null;
		boolean returnValue = true;
		String date = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
		if(userAccount.equals(CAAccount)){
			DateFormat = new SimpleDateFormat("dd/MM/yyyy");
		}
		date = DateFormat.format(cal.getTime());
		chargeEntryData.dateOfService1=date;
		chargeEntryData.dateOfService2=date;

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
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if (chargeEntryData.testCaseId.equals("TC_CE_009")) {
				if(userAccount.equals(CAAccount)){
					assertTrue(enterDate(selenium, dateSLDateCA, chargeEntryData.dateOfService1),
							"Adjustment Reason textbox not Present", selenium, ClassName,
							MethodName);
				}
				else{
				assertTrue(enterDate(selenium, dateSLStartDate, chargeEntryData.dateOfService1),
						"Adjustment Reason textbox not Present", selenium, ClassName,
						MethodName);
				assertTrue(enterDate(selenium, dateSLEndDate, chargeEntryData.dateOfService2),
						"Adjustment Reason textbox not Present", selenium, ClassName,
						MethodName);
				}

				assertTrue(isElementPresent(selenium, txtServiceLineUnits1),
						"Units textbox not present", selenium, ClassName,
						MethodName);
				assertTrue(
						type(selenium, txtServiceLineUnits1,
								chargeEntryData.unitsServiceLine),
						"not able to enter units", selenium, ClassName,
						MethodName);
				assertTrue(isElementPresent(selenium, btnCopyServiceLine1),
						"Copy Button not present", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, btnCopyServiceLine1),
						"Could not click Copy Button", selenium, ClassName,
						MethodName);
			}
			assertTrue(verifyNewServiceLineByCopyButton(selenium, chargeEntryData),
					"Copy not done Properly", selenium, ClassName,
					MethodName);
			

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}
	
	/**
	 * verifyNewServiceLineByCopyButton 
	 * @since Jan 28, 2014
	 */
	public boolean verifyNewServiceLineByCopyButton(Selenium selenium,BillingLib chargeEntryData) {
		try {
			
			if (!getValue(selenium, txtServiceLineUnits2).trim().contains(
					chargeEntryData.unitsServiceLine.trim())) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
