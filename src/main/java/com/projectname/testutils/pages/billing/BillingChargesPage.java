package com.projectname.testutils.pages.billing;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;


public class BillingChargesPage extends SeleniumWebDriver{
	
	public By lnkChargeAction = By.xpath("(//a[contains(text(),'Actions')])[%s]");
	public String lnkChargeActionGeneric = "(//a[contains(text(),'Actions')])[%s]";
	public By lnkChargeActionTot=By.xpath("//a[contains(text(),'Actions')]");
	public By ajxSearchBox =By.cssSelector("input.searchBox");
	public By readyLocator = By.cssSelector("input.searchBox");
	public By lnkVoidCharge = By.id("voidCharge");
	public By lnkVoidClaim= By.id("voidClaim");
	public By lnkYes= By.linkText("Yes");
	
	public  BillingChargesPage() {
        PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	/**
	 * voidFirstClaim
	 * function to void the first created claim
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */	
	public  void voidFirstClaim() {
		int totalCount=getElementCount(lnkChargeActionTot);
		for(int i=1;i<=totalCount;i++){
			lnkChargeAction=By.xpath(String.format(lnkChargeActionGeneric, i));
			if(isElementPresent(lnkChargeAction)&&isVisible(driver, lnkChargeAction)){
				click(lnkChargeAction);
				waitForPageLoad(driver);
				click(lnkVoidClaim);
				waitForPageLoad(driver);
				click(lnkYes);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				break;				
			}
		}
      
	}
	/**
	 * voidAllClaim
	 * function to void all claim
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */
	public  void voidAllClaim() {
		int totalCount=getElementCount(lnkChargeActionTot);
		int flag=0;
		for(int i=1;i<=totalCount;i++){
			lnkChargeAction=By.xpath(String.format(lnkChargeActionGeneric, i));
			if(isElementPresent(lnkChargeAction)&&isVisible(driver, lnkChargeAction)){
				if(flag==1){
				click(lnkChargeAction);
				waitForPageLoad(driver);
				click(lnkVoidCharge);
				waitForPageLoad(driver);
				click(lnkYes);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				flag=0;
				continue;
				}
				flag=1;
			}
		}
      
	}
	/**
	 * voidFirstCharge
	 * function to void the first created charge
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */
	public  void voidFirstCharge() {
		int totalCount=getElementCount(lnkChargeActionTot);
		int flag=0;
		for(int i=1;i<=totalCount;i++){
			lnkChargeAction=By.xpath(String.format(lnkChargeActionGeneric, i));
			if(isElementPresent(lnkChargeAction)&&isVisible(driver, lnkChargeAction)){
				if(flag==1){
				click(lnkChargeAction);
				waitForPageLoad(driver);
				click(lnkVoidCharge);
				waitForPageLoad(driver);
				click(lnkYes);
				waitForPageLoad(driver);
				break;
				}
				flag=1;
			}
		}
      
	}
	
}
