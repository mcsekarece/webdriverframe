package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.http.client.UserTokenHandler;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyServiceCodeWithUnitFee extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari","default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite","userAccount" })
	public void verifyServiceCodeWithUnitFee(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_043";
		chargeEntryData.fetchBillingTestData();
		verifyServiceCodeWithUnitFee(seleniumHost, seleniumPort, browser,webSite, userAccount, chargeEntryData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyServiceCodeWithTotal(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_054";
		chargeEntryData.fetchBillingTestData();
		verifyServiceCodeWithUnitFee(seleniumHost, seleniumPort, browser,
				webSite, userAccount, chargeEntryData);
	}

	@Test(groups = { "RegressionCA", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyServiceCodePopUp(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib chargeEntryData = new BillingLib();
		chargeEntryData.workSheetName = "ChargeEntry";
		chargeEntryData.testCaseId = "TC_CE_061";
		chargeEntryData.fetchBillingTestData();
		verifyServiceCodeWithUnitFee(seleniumHost, seleniumPort, browser,
				webSite, userAccount, chargeEntryData);
	}

	public boolean verifyServiceCodeWithUnitFee(String seleniumHost,int seleniumPort, String browser, String webSite,String userAccount, BillingLib chargeEntryData) throws IOException {
		
		Integer mul=null;
		Selenium selenium = null;
		boolean returnValue = true;
		String date = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
		if(userAccount.equals(CAAccount)){
			DateFormat = new SimpleDateFormat("dd/MM/yyyy");
		}
		date = DateFormat.format(cal.getTime());
		chargeEntryData.dateOfService1 = date;
		chargeEntryData.dateOfService2 = date;

		try {

			// --------------------------------------------------------------------//
			// Step-1: Login to the application and search for the given patient
			// //
			// --------------------------------------------------------------------//

			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "ServiceCodes";
			billingData.testCaseId = "TC_SC_004";
			billingData.fetchBillingTestData();
			billingData.dateOfService1 = DateFormat.format(cal.getTime());

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
			if(!chargeEntryData.testCaseId.equals("TC_CE_061")){

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

			// // get the Unique custom service code using current date and time
			DateFormat = new SimpleDateFormat("MMddHHmmss");
			
			if (userAccount.equals(CAAccount)) {
				DateFormat = new SimpleDateFormat("dd/MM/YYYY");
				chargeEntryData.dateOfService1 = chargeEntryData.dateOfService2 = DateFormat
						.format(cal.getTime());

			}
			
			SimpleDateFormat	DateFormat1 = new SimpleDateFormat("hhMMss");
		
			billingData.serviceCode1 = billingData.serviceCode1+ DateFormat1.format(cal.getTime());

			billingData.serviceDescription1 = billingData.serviceDescription1 + billingData.serviceCode1;

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
			
			
			waitForPageLoad(selenium);
			billingData.fee = billingData.currentFees;
			assertTrue(click(selenium, rdoSetServiceDefault),
					"Could not click the set service default radio button",
					selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(userAccount.equals(USAccount)){
				if (!isChecked(selenium, chkMultiplyFee)) {
					assertTrue(click(selenium, chkMultiplyFee),
							"Could not check the multiply fee", selenium,
							ClassName, MethodName);
				}	
			}
		
			assertTrue(click(selenium, btnSaveAndNext),
					"Could not click the done button", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			
	
			assertTrue(click(selenium, btnDoneServiceCode),
					"Could not click the done button", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			//
			
			}

			navigateToPatient(selenium, chargeEntryData);
			goToPostNewCharge(selenium, chargeEntryData);

			if (userAccount.equals(USAccount)) {
				assertTrue(
						enterDate(selenium, dateSLEndDate,
								chargeEntryData.dateOfService2),
						"Adjustment Reason textbox not Present", selenium,
						ClassName, MethodName);
			}else
				assertTrue(
						enterDate(selenium, dateSLDateCA,
								chargeEntryData.dateOfService1),
						"Adjustment Reason textbox not Present", selenium,
						ClassName, MethodName);
				assertTrue(
					selectValueFromAjaxList(selenium, serviceCode,
							billingData.serviceCode1),
					"Service Code not available", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			if(!chargeEntryData.testCaseId.equals("TC_CE_061")){
			assertTrue(selenium.getValue(txtUnits).equals(billingData.units),
					"Proper Units value not present", selenium, ClassName,
					MethodName);
			assertTrue(selenium.getValue(txtFee).contains(billingData.fee),
					"Proper fee value not present", selenium, ClassName,
					MethodName);
			String chargeAmount = selenium.getValue(lblChargeAmountCE);
			chargeAmount = chargeAmount.replace(",", "");
			 mul = Integer.parseInt(billingData.units)
					* Integer.parseInt(billingData.fee);
			assertTrue(chargeAmount.contains(mul.toString()),
					"Proper fee value not present", selenium, ClassName,
					MethodName);
			}
			if (chargeEntryData.testCaseId.equals("TC_CE_054")) {
				assertTrue(isElementPresent(selenium, btnCopyServiceLine1),
						"Copy Button not present", selenium, ClassName,
						MethodName);
				assertTrue(click(selenium, btnCopyServiceLine1),
						"Could not click Cpy Button", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);
				String totalAmount = selenium.getValue(lblTotal);
				Integer totInteger = mul + mul;
				totalAmount = totalAmount.toString().replace(",", "");
				assertTrue(totalAmount.contains(totInteger.toString()),
						"Proper fee value not present", selenium, ClassName,
						MethodName);
			}
			if (chargeEntryData.testCaseId.equals("TC_CE_061")) {
				selenium.mouseOver(serviceCode);			
				assertTrue(selenium.isTextPresent("Current Amount: $21.7"),
						"Copy Button not present", selenium, ClassName,
						MethodName);
				assertTrue(selenium.isTextPresent("Effective Date: Dec 01, 2011"),
						"Copy Button not present", selenium, ClassName,
						MethodName);
				assertTrue(selenium.isTextPresent("Expiry Date:"),
						"Copy Button not present", selenium, ClassName,
						MethodName);
				assertTrue(selenium.isTextPresent("Past Amount:"),
						"Copy Button not present", selenium, ClassName,
						MethodName);			
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

}
