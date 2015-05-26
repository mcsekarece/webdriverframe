package com.projectname.testutils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.BillingLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class StatementPreferencesPage  extends SeleniumWebDriver{
	
	public  StatementPreferencesPage() {
        PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	private static By readyLocator = By.id("!chkIncludeInactivePatient");
	
	private By chkIncludeInactivePatient =By.id("includeInactivePatientscheckbox");
	private By chkIncludeIncollectionsPatient =By.id("includeInCollectionsPatientscheckbox");
	private By chkIncludeDeceasedPatient =By.id("includeDeceasedPatients");
	
	private By txtWaitDays = By.id("waitDays");
	private By btnNextWizard = By.id("wizardNextButton");


	private By chkPendingBox =By.id("pendingInsuranceChargescheckbox");
	private By chkZeroBox =By.id("zeroBalanceChargescheckbox");
	
	private By ajxPatientSelection =By.id("patientSelectionTypesuggestBox");
	private By rdoDaily =By.id("dailyradio");
	private By lnkSave =By.linkText("Save");
	
	private By btnAddNew =By.cssSelector("div.add-button");
	private By btnWizardDone= By.id("wizardDoneButton");
	
	private By ajxBadDept = By.id("badDebtStatusLevelBoxsuggestBox");
	private By ajxCollection= By.id("collectionsLevelBoxsuggestBox");
	
	
	private By rdobtnAllCharges = By.id("allOpenPatientChargesradio");



    /**statementCycleGenerationSetup
      * function to statementCycleGenerationSetup
      * @param driver
	 * @since Dec 22, 2012
   */
	
	public StatementPreferencesPage statementCycleGenerationSetup(WebDriver driver, BillingLib billingData) {
		try {
			
			// Meta Information 
			
			if(!isChecked(driver,chkIncludeInactivePatient)){
				assertTrue(click(driver,chkIncludeInactivePatient),"Could not check Include Inactive Patients", driver, className,methodName);
				waitForPageLoad(driver);
			}
			if(!isChecked(driver,chkIncludeIncollectionsPatient)){
				assertTrue(click(driver,chkIncludeIncollectionsPatient),"Could not check Include Incollections Patients", driver, className,methodName);
				waitForPageLoad(driver);
			}
			if(!isChecked(driver,chkIncludeDeceasedPatient)){
				assertTrue(click(driver,chkIncludeDeceasedPatient),"Could not check Include Deceased Patients", driver, className,methodName);
				waitForPageLoad(driver);
			}
				
			assertTrue(type(driver, txtWaitDays, billingData.waitDays), "Could not type wait days", driver, className, methodName);
			waitForPageLoad(driver);
			
			assertTrue(click(driver, btnNextWizard), "Could not click Next button", driver, className, methodName);
			waitForPageLoad(driver);
			
			// Format 
			
			assertTrue(click(driver,rdobtnAllCharges),"Could not click all charages button", driver, className,methodName);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			
			if(!isChecked(driver,chkPendingBox)){
				assertTrue(click(driver,chkPendingBox),"Could not check pending box ", driver, className,methodName);
				waitForPageLoad(driver);
			}
			if(!isChecked(driver,chkZeroBox)){
				assertTrue(click(driver,chkZeroBox),"Could not check  Zero Box", driver, className,methodName);
				waitForPageLoad(driver);
			}
			assertTrue(click(driver, btnNextWizard), "Could not click Next button", driver, className, methodName);
			waitForPageLoad(driver);
			
			// Statement Cycle Set up
			
			assertTrue(statementCycleWizardSetUp(driver), "Statement cycle Wizard SetUp Failed", driver, className, methodName);
			waitForPageLoad(driver);
			
			// Dunning Messages
			 
			assertTrue(selectValueFromAjaxList(driver, ajxBadDept,billingData.badDebt), "Could not find bed dept", driver, className, methodName);
			waitForPageLoad(driver);
		    assertTrue(selectValueFromAjaxList(driver, ajxCollection,billingData.pendingCollection), "Could not find collection", driver, className, methodName);
		    waitForPageLoad(driver);
			
			assertTrue(click(driver, btnWizardDone), "Could not click Done button", driver, className, methodName);
			waitForPageLoad(driver);
			
			assertTrue(isTextPresent(driver,"Auto generation of statements is currently activated"), "Basic Statement cycle Generation Set up is Failed", driver, className,
					methodName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StatementPreferencesPage();
	}
	
  /**statementCycleWizardSetUp
     * function to statementCycleWizardSetUp
     * @param driver
	 * @since Dec 22, 2012
  */
	
	public boolean statementCycleWizardSetUp(WebDriver driver) {
		boolean returnValue = true;
		try {
			
			waitForPageLoad(driver);
			assertTrue(click(driver, btnAddNew),"Could not click on Add new button", driver, className,methodName);
		    waitForPageLoad(driver);
		    assertTrue(isTextPresent(driver,"You can add multiple cycles, one at a time. No overlaps are allowed."), "Could not navigate to statement cycle",
				    driver, className, methodName);
			assertTrue(selectValueFromAjaxList(driver, ajxPatientSelection,"All patients"), "could not select the option", driver,className, methodName);
			waitForPageLoad(driver);
			assertTrue(click(driver, rdoDaily), "could not find daily radio button", driver, className, methodName);
			waitForPageLoad(driver);
			assertTrue(click(driver, lnkSave), "could not click statement cycle  save button ", driver, className, methodName);
			waitForPageLoad(driver);
			assertTrue(isElementPresent(driver, btnAddNew),"Statement Cycle Wizard SetUp Failed", driver, className,methodName);
		    waitForPageLoad(driver);
			assertTrue(click(driver, btnNextWizard), "Could not click Next button", driver, className, methodName);
			waitForPageLoad(driver);
		    
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}


}
