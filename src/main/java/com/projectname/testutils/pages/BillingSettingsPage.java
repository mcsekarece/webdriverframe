package com.projectname.testutils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.BillingLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class BillingSettingsPage extends SeleniumWebDriver{
	StatementPreferencesPage statementPreferencesPage;
	public  BillingSettingsPage() {
        PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	private static By readyLocator = By.id("!billingServiceCodes");
	private By lnkStatementPreferences =By.id("!billingSettingsStatementPreferencesShow");
	private By btnDeactivateAutoGen = By.linkText("Deactivate auto generation of statements");
	private By btnActivateAutoGen = By.linkText("Activate auto generation of statements");
	private By btnEdit = By.linkText("Edit");
	private By crcMetaInformation = By.xpath("//div[@id='BlueNavigationWiget_MainPanel']/div[2]/div");
	
	
/**goToStatementPreferences
	 * function to goToStatementPreferences
	 * @param driver
   	 * @since Dec 22, 2012
 */
	
	public BillingSettingsPage goToStatementPreferences(WebDriver driver) {
		try {
			assertTrue(click(driver, lnkStatementPreferences),"Could not click on Statement preferences link:", driver,className,methodName);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			assertTrue(isElementPresent(driver, btnDeactivateAutoGen) || isElementPresent(driver, btnActivateAutoGen),"Go To Statement Preferences Page Failed", driver, className,methodName);
			waitForPageLoad(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new BillingSettingsPage ();
	}
	
	
	/**goToStatementPreferencesWizard
		 * function to goToStatementPreferencesWizard
		 * @param driver
	   	 * @since Dec 22, 2012
	 */
	
	public void goToStatementPreferencesWizard(WebDriver driver) {
		try {
			  if (!isElementPresent(driver, btnEdit)) {
			    	
				assertTrue(click(driver, btnActivateAutoGen), "Could not find Activate button", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(isTextPresent(driver,"Auto generation of statements is currently activated"), "Default screen is incorrect", driver, className,
					methodName);
				   }
			    assertTrue(click(driver, btnEdit), "Could not find edit button", driver, className, methodName);
			    waitForPageLoad(driver);

				assertTrue(isElementPresent(driver, crcMetaInformation),"Go To Statement Preferences Wizard Page Failed", driver, className,methodName);
				waitForPageLoad(driver);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		statementPreferencesPage= new StatementPreferencesPage();
	}
	
	
	/**statementCycleGenerationSetup
	 * function to statementCycleGenerationSetup
	 * @param driver
   	 * @since Dec 22, 2012
 */
	
	public void statementCycleGenerationSetup(WebDriver driver, BillingLib billingData) {
		statementPreferencesPage.statementCycleGenerationSetup(driver, billingData);
		
	}
	
	
}