package com.nexia.selenium.testscripts.section.chartprevisit.Injection;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateEncounterInjection extends AbstractChartPreVisit {
	// Smoke Test Case
	@Test(groups = { "Smoke", "Regression", "Approved", "firefox", "iexplore",
			"safari", "default" }, description = "Function to add Encounter Injection")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void createEncounterInjectionwithHideDetails(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_015";
		injectionData.fetchChartPreVisitTestData();
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		addInjection(seleniumHost, seleniumPort, browser, webSite, userAccount,
				injectionData);
	}

	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari",
			"default" }, description = "Test for Adding Injection")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite",
			"userAccount" })
	public void createEncounterInjectionwithFullDetails(String seleniumHost,
			int seleniumPort, String browser, String webSite, String userAccount)
			throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_014";
		injectionData.fetchChartPreVisitTestData();

		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		addInjection(seleniumHost, seleniumPort, browser, webSite, userAccount,
				injectionData);
	}

	/**
	 * addInjection Function to add Encounter Injection
	 * 
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @throws IOException
	 * @since Oct 29, 2012
	 */
	public boolean addInjection(String seleniumHost, int seleniumPort,
			String browser, String webSite, String userAccount,
			ChartPreVisitLib injectionData) throws IOException {
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
							+ injectionData.toString());
			assertTrue(
					loginForNexiaFromProviderSite(selenium, userAccount,
							injectionData.userName, injectionData.userPassword),
					"Login Failed ", selenium, ClassName, MethodName);
			// --------------------------------------------------------------------//
			// Step-2: Advanced search with Patient ID//
			// --------------------------------------------------------------------//
			assertTrue(switchRole(selenium,"FULL"),"unable to switch the user role",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(goToRegisterPatient(selenium),"Could not navigated to register patient",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			ChartPreVisitLib patientData = new ChartPreVisitLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NP_001";
			patientData.fetchChartPreVisitTestData();		
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium, ClassName, MethodName);	
			assertTrue(	searchPatientNexiaForProviderHomePage(selenium,patientData.lastName),"Search patient failed",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			// --------------------------------------------------------------------//
			// Step-4: Delete Existing Injection //
			// --------------------------------------------------------------------//
			// Check if the Injection Link is Visible
			assertTrue(selenium.isVisible(lnkInjection),
					"Injection Link Not Visible;More Details", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkInjection),
					"Could not click Injections link;More Details:", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(deleteInjection(selenium), "Delete Failed", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-5: Navigate to Begin Encounter //
			// --------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium), "Navigation failed",
					selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			// --------------------------------------------------------------------//
			// Step-6: Create Injection//
			// --------------------------------------------------------------------//
			assertTrue(selenium.isVisible(lnkEncounterInjection),
					"Injection Link Not Visible;More Details", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, lnkEncounterInjection),
					"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			selenium.clickAt(lnkEncounterInjection, "");
			// selenium.focus(lnkInjection);
			// selenium.fireEvent(lnkInjection,"keypress");

			waitForPageLoad(selenium);

			String providerNameTemp = getText(selenium, lnkTopMenu);
			String providerName = providerNameTemp.replaceAll(", "
					+ injectionData.switchRole, "");

			String date = "";
			if (userAccount.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd");
				date = DateFormat.format(cal.getTime());
				int date1 = Integer.parseInt(date);
				if (date1 < 10) {
					SimpleDateFormat DateForma1t = new SimpleDateFormat(
							"MMM d, yyyy");
					date = DateForma1t.format(cal.getTime());
					date = DateFormat.format(cal.getTime());
					DateFormat = new SimpleDateFormat("HH");
				} else {
					SimpleDateFormat DateFormat2 = new SimpleDateFormat(
							"MMM dd,yyyy");
					date = DateFormat2.format(cal.getTime());
					date = DateFormat.format(cal.getTime());
					DateFormat = new SimpleDateFormat("HH");
				}

			} else {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal.getTime());
				DateFormat = new SimpleDateFormat("HH");

			}

			assertTrue(
					createInjection(selenium, injectionData, userAccount,
							providerName), "Injection Creation Failed",
					selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			/*
			 * if(isElementPresent(selenium,btnInjectionEdit)){
			 * returnValue=true; }else returnValue=false;
			 */

			// Click on edit button
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, lblEncounterInjection),
					"Could not find encounter details", selenium, ClassName,
					MethodName);
			assertTrue(click(selenium, lblEncounterInjection),
					"Could not click on created Injection", selenium,
					ClassName, MethodName);
			assertTrue(click(selenium, btnEditEncounter),
					"Could not click on Edit button", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);

			if (!verifyStoredValueInEncounterNote(selenium, injectionData,
					providerName, date)) {
				Assert.fail("Injection details not saved properly; More Details :"
						+ injectionData.toString());
				returnValue = false;
			} else {
				// --------------------------------------------------------------------//
				// Sign the Encounter //
				// --------------------------------------------------------------------//
				if (injectionData.testCaseId.equals("TC_CI_015")) {

					assertTrue(click(selenium, btnBeginEncounter), " ",
							selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(isElementPresent(selenium, btnSign),
							"Could not find the link", selenium, ClassName,
							MethodName);
					waitForPageLoad(selenium);
					if (selenium.isConfirmationPresent()) {
						System.out.println(selenium.getConfirmation());
						// Assert.assertEquals(selenium.getConfirmation(),
						// "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
						selenium.chooseOkOnNextConfirmation();
					}

					assertTrue(click(selenium, btnSign),
							"Could not click the sign link;More Details",
							selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				returnValue = true;

			}

		} catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,
					"Failed Due to the Exception; \n\t*) ExceptionDetails :"
							+ e.getMessage() + "\n\t*)", selenium, ClassName,
					MethodName);
		}
		return returnValue;
	}

	public boolean verifyStoredValueInEncounterNote(Selenium selenium,
			ChartPreVisitLib injectionData, String providerName, String date)
			throws IOException {

		waitForPageLoad(selenium);
		if (!getValue(selenium, txtQuickinjection)
				.toLowerCase(new java.util.Locale("en", "Us"))
				.trim()
				.contains(
						injectionData.injection.trim().toLowerCase(
								new java.util.Locale("en", "Us")))) {
			return false;
		}

		if (!getValue(selenium, txtexpiryDate).trim().contains(date.trim())) {
			return false;
		}
		if (!getValue(selenium, txtLotNo).trim().contains(
				injectionData.lotNumber.trim())) {
			return false;
		}

		// //
		// if(!getValue(selenium,txtDosage).trim().contains(injectionData.dosage.trim())){
		// // return false;
		// // }
		// if(!getValue(selenium,ajxDosageUnit).trim().contains(injectionData.dosageUnit.trim())){
		// return false;
		// }

		if (injectionData.testCaseId.equals("TC_CI_014")) {
			if (getText(selenium, lnkInjectionShowMoreArrow).equalsIgnoreCase(
					"Show more details")) {
				assertTrue(click(selenium, lnkInjectionShowMoreArrow),
						"Could not on show more button", selenium, ClassName,
						MethodName);
			}

			waitForPageLoad(selenium);
			if (!getValue(selenium, ajxAdminBy).trim().contains(
					providerName.trim())) {
				return false;
			}
			if (!getValue(selenium, ajxInjectionRoute)
					.toLowerCase(new java.util.Locale("en", "Us"))
					.trim()
					.contains(
							injectionData.route.trim().toLowerCase(
									new java.util.Locale("en", "Us")))) {
				return false;
			}

			if (!getValue(selenium, ajxCptCode1).trim().contains(
					injectionData.cptCode1.trim())) {
				return false;
			}

			if (!getValue(selenium, ajxCptCode2).trim().contains(
					injectionData.cptCode2.trim())) {
				return false;
			}
			if (!getValue(selenium, ajxReaction)
					.toLowerCase(new java.util.Locale("en", "Us"))
					.trim()
					.contains(
							injectionData.reaction.trim().toLowerCase(
									new java.util.Locale("en", "Us")))) {
				return false;
			}

		}
		return true;
	}

}
