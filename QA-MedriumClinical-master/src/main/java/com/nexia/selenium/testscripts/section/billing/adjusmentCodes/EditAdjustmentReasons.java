package com.nexia.selenium.testscripts.section.billing.adjusmentCodes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class EditAdjustmentReasons extends AbstractBilling {

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyAdjusmentReasonsListView(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_005";
		adjustmentCodeData.fetchBillingTestData();
		editAdjusmentReasons(seleniumHost, seleniumPort, browser, webSite,
				userAccount, adjustmentCodeData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyEditAdjustmentReasonsPage(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_014";
		adjustmentCodeData.fetchBillingTestData();
		editAdjusmentReasons(seleniumHost, seleniumPort, browser, webSite,
				userAccount, adjustmentCodeData);
	}

	public boolean editAdjusmentReasons(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount,
			BillingLib adjustmentCodeData) throws IOException {
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
							+ adjustmentCodeData.toString());

			assertTrue(
					loginForNexiaFromProviderSite(selenium, userAccount,
							adjustmentCodeData.userName,
							adjustmentCodeData.userPassword), "Login Failed ",
					selenium, ClassName, MethodName);

			waitForPageLoad(selenium);

			assertTrue(switchRole(selenium, adjustmentCodeData.switchRole),
					"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-2: Go to Adjustment Reasons
			// --------------------------------------------------------------------//

			assertTrue(goToAdjustmentReasons(selenium),
					"Adjustment Navigation Failed", selenium, ClassName,
					MethodName);

			assertTrue(deleteAllAdjustmentCodes(selenium),
					"Adjustment Deletion Failed", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			if (adjustmentCodeData.testCaseId.equals("TC_AC_005")) {
			adjustmentCodeData.workSheetName = "AdjustmentCodes";
			adjustmentCodeData.testCaseId = "TC_AC_003";
			adjustmentCodeData.fetchBillingTestData();
			}
			if (isElementPresent(selenium, btnAdd)) {
				assertTrue(click(selenium, btnAdd),
						"Not able to click Add New", selenium, ClassName,
						MethodName);
				addAdjustmentReasons(selenium, adjustmentCodeData);
			}
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-3: Edit Payers //
			// --------------------------------------------------------------------//
			searchAdjustmentReasons(selenium,adjustmentCodeData);
			if (adjustmentCodeData.testCaseId.equals("TC_AC_003")) {
			String adjustment=adjustmentCodeData.c_DAdjusment;
			adjustmentCodeData.workSheetName = "AdjustmentCodes";
			adjustmentCodeData.testCaseId = "TC_AC_005";
			adjustmentCodeData.fetchBillingTestData();
			adjustmentCodeData.c_DAdjusment=adjustment;
			}
			assertTrue(click(selenium, btnEdit), "Could not click Edit button",
					selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			if (adjustmentCodeData.testCaseId.equals("TC_AC_014")) {
				verifyEditAdjustmentReasonsPage(selenium);
				
			}
			if (!adjustmentCodeData.testCaseId.equals("TC_AC_014")) {
			assertTrue(editAdjustmentReasons(selenium, adjustmentCodeData),
					"Could not Edit Adjustment Reasons", selenium, ClassName,
					MethodName);
			searchAdjustmentReasons(selenium,adjustmentCodeData);
			assertTrue(
					verifyAdjustmentReasonsSummary(selenium, adjustmentCodeData),
					"Data Verification Failed", selenium, ClassName, MethodName);
			}
			return returnValue;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

	public boolean editAdjustmentReasons(Selenium selenium,
			BillingLib adjustmentCodeData) throws IOException {
		try {
			
			String date = null;
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MMddHHmm");
			date = DateFormat.format(cal.getTime());
			adjustmentCodeData.adjusmentReason = adjustmentCodeData.adjusmentReason
					+ date;
			assertTrue(
					type(selenium, txtadjustmentReason,
							adjustmentCodeData.adjusmentReason),
					"Could not type Adjustment Reason", selenium, ClassName,
					MethodName);
			assertTrue(
					type(selenium, txtdescription,
							adjustmentCodeData.description),
					"Could not type Description", selenium, ClassName,
					MethodName);
//			assertTrue(
//					selectValueFromAjaxList(selenium, ajxc_DAdjusment,
//							adjustmentCodeData.c_DAdjusment),
//					"Could not select credit or debit adjustment", selenium,
//					ClassName, MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxReportCategoryForEdit,
							adjustmentCodeData.reportCategory),
					"Could not select Report category for adjustment",
					selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSave), "Could not click Save button",
					selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public boolean verifyEditAdjustmentReasonsPage(Selenium selenium)
			throws IOException {
		try {
			assertTrue(isElementPresent(selenium, txtadjustmentReason),
					"Adjustment Reason Text Box not present", selenium,
					ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtdescription),
					"Description TextBox not present", selenium, ClassName,
					MethodName);
//			assertTrue(isElementPresent(selenium, ajxc_DAdjusment),
//					"Credit or Debit List Box not present", selenium,
//					ClassName, MethodName);
			assertTrue(isElementPresent(selenium, ajxReportCategoryForEdit),
					"Report Category List box not Present", selenium,
					ClassName, MethodName);
			assertTrue(isElementPresent(selenium, btnSave),
					"Save Button not present", selenium, ClassName, MethodName);

			assertTrue(isElementPresent(selenium, btnCancel),
					"Cancel Button not present", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
