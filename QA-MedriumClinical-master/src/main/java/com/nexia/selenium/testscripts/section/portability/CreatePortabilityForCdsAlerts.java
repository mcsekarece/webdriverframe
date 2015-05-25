package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreatePortabilityForCdsAlerts extends AbstractChartPreVisit {
	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for verifying CDS alert for patient with Blood pressure measurement")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void verifyCDSAlertForBloodPressureMeasurement(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws IOException {
		ChartPreVisitLib cdsData = new ChartPreVisitLib();
		cdsData.workSheetName = "CreateProblemList";
		cdsData.testCaseId = "TC_CPL_014";
		cdsData.fetchChartPreVisitTestData();
		verifyCdsAlert(seleniumHost, seleniumPort, browser, webSite,
				userAccount, cdsData);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	}

	/**
	 * verifyCdsAlert Function to verify CDS alert
	 * 
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @throws IOException
	 * @since Oct 11, 2012
	 */

	public boolean verifyCdsAlert(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount,
			ChartPreVisitLib cdsData) throws IOException {
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
							+ cdsData.toString());
			assertTrue(
					loginForNexiaFromProviderSite(selenium, userAccount,
							cdsData.userName, cdsData.userPassword),
					"Login Failed ", selenium, ClassName, MethodName);

			// --------------------------------------------------------------------//
			// Step-2: Navigate to CDS and uncheck all the rules//
			// --------------------------------------------------------------------//

			navigateToCDSUncheck(selenium);
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-3: Search for a patient//
			// --------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium, cdsData.patientId);
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-4: Count the number of encounters present//
			// --------------------------------------------------------------------//
			click(selenium, lnkencounterTab);
			waitForPageLoad(selenium);
			int count = 0, count1 = 0;
			if (isElementPresent(selenium, lblUnsignedEncounterList))
				count = 1;
			if (isElementPresent(selenium, lblSignedEncounterList))
				count1 = 1;
			while (isElementPresent(selenium,
					"//div[2]/div/div[2]/table/tbody/tr[" + count
							+ "]/td[2]/div/div")) {
				count++;

				if (count > 15)
					break;
			}

			while (isElementPresent(selenium,
					"//div[2]/div[2]/div/div[2]/table/tbody/tr[" + count1
							+ "]/td[2]/div/div")) {
				count1++;

				if (count1 > 15)
					break;
			}

			int counter = count + count1;

			if (counter - 1 == 1) {
				assertTrue(click(selenium, btnBeginEncounter),
						"Could not click the Begin Encounter link", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);

				if (isElementPresent(selenium, lblEncounterChoosePanel)) {
					if (isElementPresent(selenium, lnkStartNewWncouter)) {
						click(selenium, lnkStartNewWncouter);
						click(selenium, btnSign);
						waitForPageLoad(selenium);
					} else {
						click(selenium, lnkEncounterLink2);
						click(selenium, btnSign);
						waitForPageLoad(selenium);
					}
				}

				waitForPageLoad(selenium);
			} else if (counter == 0) {
				assertTrue(click(selenium, btnBeginEncounter),
						"Could not click the Begin Encounter link", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);

				if (isElementPresent(selenium, lblEncounterChoosePanel)) {
					if (isElementPresent(selenium, lnkStartNewWncouter)) {
						click(selenium, lnkStartNewWncouter);
						click(selenium, btnSign);
						waitForPageLoad(selenium);
					} else {
						click(selenium, lnkEncounterLink2);
						click(selenium, btnSign);
						waitForPageLoad(selenium);
					}
				}

				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnBeginEncounter),
						"Could not click the Begin Encounter link", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);

				if (isElementPresent(selenium, lblEncounterChoosePanel)) {
					if (isElementPresent(selenium, lnkStartNewWncouter)) {
						click(selenium, lnkStartNewWncouter);
						click(selenium, btnSign);
						waitForPageLoad(selenium);
					} else {
						click(selenium, lnkEncounterLink2);
						click(selenium, btnSign);
						waitForPageLoad(selenium);
					}
				}

				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium, lnkProblemList),
					"Could not click the Immunization link;More Details",
					selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-5: Delete All existing Problem List//
			// --------------------------------------------------------------------//
			assertTrue(deleteAllProblemList(selenium, cdsData),
					"Couldn't delete", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-6: Add Procedure//
			// --------------------------------------------------------------------//

			assertTrue(createProblemList(selenium, cdsData, userAccount),
					"Creation failed", selenium, ClassName, MethodName);

			waitForPageLoad(selenium);
			if (isElementPresent(selenium, lblCreatedProblemListEntry)) {
				returnValue = true;
			} else
				returnValue = false;

			ChartPreVisitLib cdsData1 = new ChartPreVisitLib();

			cdsData1.workSheetName = "CreateVitals";
			cdsData1.testCaseId = "TC_CV_002";
			cdsData1.fetchChartPreVisitTestData();

			assertTrue(click(selenium, lnkVitals),
					"Could not click the Allergy link;More Details", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);
			// --------------------------------------------------------------------//
			// Step-7: Add Vitals //
			// --------------------------------------------------------------------//
			assertTrue(addVitalsForCds(selenium, cdsData1),
					"Vitals Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if (isElementPresent(selenium, lblCreatedVitalsEntry)) {
				returnValue = true;
			} else
				returnValue = false;

			navigateToCDSCheck(selenium);
			waitForPageLoad(selenium);
			if (!verifyCDSAlert(selenium, cdsData, cdsData1)) {
				Assert.fail("CDS alert is not displayed as expected: More Details :"
						+ cdsData.toString());
				returnValue = false;
			} else
				returnValue = true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	public boolean verifyCDSAlert(Selenium selenium, ChartPreVisitLib cdsData,
			ChartPreVisitLib cdsData1) {
		boolean returnValue = true;
		click(selenium, btnBack);
		waitForPageLoad(selenium);
		try {
			assertTrue(type(selenium, txtsearchbox, cdsData.patientId),
					"Could not type patient id",selenium,ClassName,MethodName);
			selenium.keyPress(txtsearchbox, "\\9");
			waitForElement(selenium, lblsearchResult, 10000);

			assertTrue(selenium.isElementPresent(lblsearchResult),
					"Search Results are not displayed for the patient with ID :-"
							+ cdsData.patientId, selenium, ClassName,
					MethodName);

			assertTrue(getText(selenium, lblsearchResult).contains(
					cdsData.patientId),"Could not get text",selenium,ClassName,MethodName);
			click(selenium, lblsearchResult);
			waitForPageLoad(selenium);

			if (cdsData1.testCaseId.equals("TC_CV_013")) {
				if (!isElementPresent(selenium, lblpatientname))
					return false;
			}
			if (cdsData.testCaseId.equals("TC_CPL_012")) {
				if (!getText(selenium, lblcdsAlert).contains(
						"Blood Pressure Measurement:")) {
					returnValue = true;
				}
			} else {
				if (!getText(selenium, lblcdsAlert).contains(
						"Blood Pressure Measurement:")) {
					returnValue = false;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
}
