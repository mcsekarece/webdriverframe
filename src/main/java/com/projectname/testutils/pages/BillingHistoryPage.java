package com.projectname.testutils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.BillingLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.billing.BillingChargesPage;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;


public class BillingHistoryPage extends SeleniumWebDriver{
	
	public  BillingHistoryPage() {
        PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	private static By readyLocator = By.id("!billingChargesHistory");
	private By lnkReferrals=By.id("!billingReferralsHistory");
	private By lnkCharges=By.id("!billingChargesHistory");
	private By lnkBillingStatements =By.id("!billingStatementsHistory");
	private By lnkQuickLink = By.linkText("Quick actions");
	private By lnkBillingSettings =By.id("billingSettingsAction");
	private By lnkStatementPreferences =By.id("!billingSettingsStatementPreferencesShow");
	private By btnDeactivateAutoGen = By.linkText("Deactivate auto generation of statements");
	private By btnActivateAutoGen = By.linkText("Activate auto generation of statements");
	

	
	private By lblFinancialstatus = By.id("usPanelDiv");
	
	
	
	/**
	 * Function go To Statement Preferences
	 * 
	 * @since Dec 22, 2014
	 */
	
	public boolean goToStatementPreferences(WebDriver driver) {
		boolean returnValue = true;
		try {
			assertTrue(click(driver, lnkQuickLink), "could not click Quick Actions",driver,className,methodName);
			waitForPageLoad(driver);
			assertTrue(click(driver, lnkBillingSettings),"could not click Billing Settings", driver,className,methodName);
			waitForPageLoad(driver);
			assertTrue(click(driver, lnkStatementPreferences),"Could not click on Statement preferences link:", driver,className,methodName);

			assertTrue(isElementPresent(driver, btnDeactivateAutoGen) || isElementPresent(driver, btnActivateAutoGen),"Go To Statement Preferences Page Failed", driver, className,methodName);
			waitForPageLoad(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}


	
	/**goToBillingStatements
	 * function to goToBillingStatements 
	 * @param driver
     * * @throws IOException
	 * @since Dec 23, 2014
 */
	
	public BillingStatementsPage goToBillingStatements(WebDriver driver) {
		try {
			assertTrue(click(driver,lnkBillingStatements),"Click Billing Statements failed", driver, className,methodName);
			waitForPageLoad(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BillingStatementsPage();
	}
	

    /**verifyFinancialStatus
	 * function to verifyFinancialStatus
	 * @param driver
   	 * @param chargeEntryData (Test Data for check Financial status)
	 * @since Dec 22, 2014
 */
	
	public boolean verifyFinancialStatus(WebDriver driver,BillingLib chargeEntryData) {
		boolean returnValue = true;
		try {
			
			assertTrue(getText(driver,lblFinancialstatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(chargeEntryData.financialStatus.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify the Financial Status Failed", driver, className,methodName);
			waitForPageLoad(driver);
		    
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}
	
	
	/**
	 * Delete All referral
	 * function to delete all referral for a patient
	 * @param 	referralsPage- Page
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */
	public boolean deleteAllReferral(ReferralsPage referralsPage,WebDriver driver) throws Exception {
		referralsPage.deleteAllReferral(driver);
		return true;
	}

	/**
	 * create referral
	 * fuction to create referral for a patient
	 * @param 	referralsPage- Page
	 * @param 	refData- data to create referral
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */
	public boolean createReferral(ReferralsPage referralsPage, WebDriver driver, HomeLib refData) throws Exception {
		referralsPage.createReferral(driver, refData);
		return true;
	}
	/**
	 * create referral
	 * function to go to referral page
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */
	public ReferralsPage goToReferral(WebDriver driver) throws Exception {
	    try {

	        assertTrue(click(driver, lnkReferrals),
					"Could not click Patient options", driver, className,
					methodName);
			waitForPageLoad(driver);
		} catch (RuntimeException e) {
			e.printStackTrace();
	    }
	    return new ReferralsPage();
	}
	/**
	 * goToCharges
	 * fuction to go to charges page
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */
	public BillingChargesPage goToCharges(WebDriver driver) throws Exception {
	    try {

	        assertTrue(click(driver, lnkCharges),
					"Could not click Patient options", driver, className,
					methodName);
			waitForPageLoad(driver);
		} catch (RuntimeException e) {
			e.printStackTrace();
	    }
	    return new BillingChargesPage();
	}
	/**
	 * verifyReferralSummary
	 * function to verify referral Summary
	 * @param 	referralsPage- Page
	 * @param 	authoNumber- authorization number
	 * @param 	visitsScheduled- visits Scheduled
	 * @param 	visitsAllowed- visits Allowed
	 * @param 	visitsUsed- visits Used
	 * @param 	testCaseID- testCase ID
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */
	public boolean verifyReferralSummary(ReferralsPage referralsPage, String authoNumber, String visitsScheduled,String visitsAllowed, String visitsUsed, String testCaseID){
		return referralsPage.verifySchedulingInReferralSummary(authoNumber, visitsScheduled, visitsAllowed, visitsUsed, testCaseID);	
	}
	/**
	 * voidFirstCharge
	 * function to void the first created charge
	 * @param 	billingChargesPage- Page
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */
	public void voidFirstCharge(BillingChargesPage billingChargesPage){
		billingChargesPage.voidFirstCharge();
	}
	/**
	 * voidFirstClaim
	 * function to void the first created claim
	 * @param 	billingChargesPage- Page
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */	
	public void voidFirstClaim(BillingChargesPage billingChargesPage){
		billingChargesPage.voidFirstClaim();
	}
	/**
	 * voidAllClaim
	 * function to void all claim
	 * @param 	billingChargesPage- Page
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */
	public void voidAllClaim(BillingChargesPage billingChargesPage){
		billingChargesPage.voidAllClaim();
	}
	/**
	 * clickAddReferral
	 * function to click Add Referral Button
	 * @param 	referralsPage- Page
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */
	public void clickAddReferral(ReferralsPage referralsPage){
		referralsPage.clickAddReferral();
	}
	
	
	
	
}
