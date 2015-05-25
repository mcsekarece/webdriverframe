package com.nexia.selenium.testscripts.section.chartprevisit.ChartSummaryTab;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDateField extends AbstractChartPreVisit {
    @Test(groups = { "Regression", "Review", "firefox", "iexplore", "safari", "default" }, description = "Test for verifying on the date field")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyDefaultValue(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	ChartPreVisitLib summaryData = new ChartPreVisitLib();
	summaryData.workSheetName = "CreateProcedure";
	summaryData.testCaseId = "TC_CP_001";
	summaryData.fetchChartPreVisitTestData();
	verifyDateField(seleniumHost, seleniumPort, browser, webSite, userAccount, summaryData);
    }

    @Test(groups = { "Regression", "Review", "firefox", "iexplore", "safari", "default" }, description = "Test for verifying read only view in medication tab")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyReadOnly(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	ChartPreVisitLib summaryData = new ChartPreVisitLib();
	summaryData.workSheetName = "CreateProcedure";
	summaryData.testCaseId = "TC_CP_002";
	summaryData.fetchChartPreVisitTestData();
	verifyDateField(seleniumHost, seleniumPort, browser, webSite, userAccount, summaryData);
    }

    @Test(groups = { "Regression", "Review", "firefox", "iexplore", "safari", "default" }, description = "Test for verifying read only view in medication tab")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyReset(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	ChartPreVisitLib summaryData = new ChartPreVisitLib();
	summaryData.workSheetName = "CreateProcedure";
	summaryData.testCaseId = "TC_CP_003";
	summaryData.fetchChartPreVisitTestData();
	verifyDateField(seleniumHost, seleniumPort, browser, webSite, userAccount, summaryData);
    }

    /***************************************************************************************************
     * @purpose To validate the date field on the medication tab
     * @action Verify date field with appropriate validations
     * @author Aspire QA
     * @throws IOException
     * @state Developing
     * @useraccount Both (US and Canada)
     * @since May 20, 2014
     ***************************************************************************************************/

    public boolean verifyDateField(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, ChartPreVisitLib summaryData)
	    throws IOException {
	boolean returnValue = false;
	Selenium selenium = null;
	String date = "";
	String dateToEnter = "";
	try {

	    // --------------------------------------------------------------------//
	    // Step-1: Login to the application and search for the given patient
	    // //
	    // --------------------------------------------------------------------//
	    selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
	    Assert.assertNotNull(selenium, "Could Not Retrive the New Selenium Session; More Details :" + summaryData.toString());
	    assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, summaryData.userName, summaryData.userPassword), "Login Failed ", selenium,
		    ClassName, MethodName);
	    waitForPageLoad(selenium);

	    // --------------------------------------------------------------------//
	    // Step-2: Navigate to Patient Chart//
	    // --------------------------------------------------------------------//
	    searchPatientNexiaForProviderHomePage(selenium, summaryData.patientId);
	    waitForPageLoad(selenium);

	    // --------------------------------------------------------------------//
	    // Step-3: Navigate to Chat Summary Tab//
	    // --------------------------------------------------------------------//

	    assertTrue(click(selenium, lnkSummary), "Could not click summary tab", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    if (userAccount.equals(CAAccount)) {
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
		date = DateFormat.format(cal1.getTime());
	    } else {
		Calendar cal2 = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
		date = DateFormat.format(cal2.getTime());

	    }

	    if (summaryData.testCaseId.equals("TC_CP_001")) {
		assertTrue(getValue(selenium, txtSummaryDate).equals(date), "Deafulat value is incorrect", selenium, ClassName, MethodName);
	    }

	    if (summaryData.testCaseId.equals("TC_CP_002")) {
		if (userAccount.equals(CAAccount)) {
		    Calendar cal3 = Calendar.getInstance();
		    SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");

		    cal3.add(Calendar.DATE, -1);
		    dateToEnter = DateFormat.format(cal3.getTime());
		} else {
		    Calendar cal3 = Calendar.getInstance();
		    SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");

		    cal3.add(Calendar.DATE, -1);
		    dateToEnter = DateFormat.format(cal3.getTime());
		}
		assertTrue(enterDate(selenium, txtSummaryDate, dateToEnter), "Could not enter date", selenium, ClassName, MethodName);

		assertTrue(click(selenium, lnkProcedure), "Could not click the Procedure link;More Details", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(!isElementPresent(selenium, txtProcedureDate), "Page is not read only", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(enterDate(selenium, txtSummaryDate, date), "Could not enter date", selenium, ClassName, MethodName);

		assertTrue(click(selenium, lnkProcedure), "Could not click the Procedure link;More Details", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(isElementPresent(selenium, txtProcedureDate), "Page is not read only", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	    }

	    if (summaryData.testCaseId.equals("TC_CP_003")) {
		assertTrue(click(selenium, lnkencounterTab), "Could not click encounter tab", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium, lnkSummary), "Could not click summary tab", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		if (userAccount.equals(CAAccount)) {
		    Calendar cal1 = Calendar.getInstance();
		    SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    date = DateFormat.format(cal1.getTime());
		} else {
		    Calendar cal2 = Calendar.getInstance();
		    SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
		    date = DateFormat.format(cal2.getTime());

		}

		assertTrue(getValue(selenium, txtSummaryDate).equals(date), "Deafulat value is incorrect", selenium, ClassName, MethodName);
	    }
	    if (summaryData.testCaseId.equals("TC_CP_004")) {

		String providerNameTemp = getText(selenium, lnkTopMenu);
		String pName = providerNameTemp.replaceAll(", " + summaryData.switchRole, "");
		String tempArray[] = pName.split(" ");
		String providerName = tempArray[1] + ", " + tempArray[0];

		if (userAccount.equals(CAAccount)) {
		    Calendar cal3 = Calendar.getInstance();
		    SimpleDateFormat DateFormat = new SimpleDateFormat("MMM dd,yyyy");
		    date = DateFormat.format(cal3.getTime());
		} else {
		    Calendar cal3 = Calendar.getInstance();
		    SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
		    date = DateFormat.format(cal3.getTime());
		}
		assertTrue(selenium.isTextPresent("Summary last reviewed on "+date+" by "+providerName), "Review details are incorrect", selenium, ClassName, MethodName);
	    }

	} catch (RuntimeException e) {
	    e.printStackTrace();
	    assertTrue(false, "Failed Due to the Exception; \n\t*) ExceptionDetails :" + e.getMessage() + "\n\t*)", selenium, ClassName, MethodName);
	}
	return returnValue;
    }
}
