package com.projectname.testutils.pages.billing;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;


public class BillingPage extends SeleniumWebDriver{
	
	public  BillingPage() {
        PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	public static By readyLocator = By.id("!billingChargesHistory");
	
}
