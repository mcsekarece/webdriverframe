package com.projectname.testutils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class BillingStatementsPage extends SeleniumWebDriver{
	
	public  BillingStatementsPage() {
        PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	private static By readyLocator = By.id("!BillingStatementHistorySearchBox");
	private By chkDontSendoption =By.id("doNotSendStatementToPatientcheckbox");
	
	
	/**
	 *  Verify Statement Send Option Set Up
	 *  @param driver
	 *  @param statementoption(statement option  to be setup)
	 * @since	DEC 22,2014
	 */
	
	public boolean verifyStatementSendOption(WebDriver driver){
		try{
	    	assertTrue(isChecked(driver,chkDontSendoption)," verify Statement Send Option Failed", driver, className,methodName);
			waitForPageLoad(driver);
	    	return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	

/**
	 * VerifyStatementSendOption
	 * To Verify Statement Send Option
	 *  @param driver
	 * @since	DEC 22,2014
	 */
	public boolean statementSendOptionSetUP(WebDriver driver, String statementoption){
		try{
			if(statementoption.equalsIgnoreCase("Yes")){
			if(!isChecked(driver,chkDontSendoption)){
				assertTrue(click(driver,chkDontSendoption)," Could not check Dont Send option ", driver, className,methodName);
				waitForPageLoad(driver);
			}
			}else{
				if(isChecked(driver,chkDontSendoption)){
					assertTrue(click(driver,chkDontSendoption)," Could not Uncheck Dont Send option ", driver, className,methodName);
					waitForPageLoad(driver);
				}
			}
			
			waitForPageLoad(driver);
	    	return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	
}
