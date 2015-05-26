package com.projectname.testutils.pages;


import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import com.projectname.testutils.seleniumutils.SeleniumWebDriver;



public class LoginPage extends SeleniumWebDriver{
	
	private static By readyLocator = By.id("loginAccountText");
	private By txtAccount = By.id("loginAccountText");
	private By txtUserName = By.id("loginUseridText");
	private By txtPassword = By.id("loginPasswordText");
	private By btnLogin = By.id("loginButton");
	private By txtPatientBox = By.id("searchPatientBox");
	private By btnErrorClose = By.id("errorCloseButton");
	private static int WAIT_TIME = 10;
	
	/***
	 * Call to super constructor
	 */
	
	public  LoginPage(){
        PageFactory.initElements(SeleniumWebDriver.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	/**
	 * loginForNexiaFromProviderSite
	 * This function will login For Nexia From Provider Site
	 * @param 		driver (an instance of current driver browser )
	 * @param 		userAccount
	 * @param 		userName
	 * @param 		userPassword
	 * @throws       IOException 
	 * @since  	     Mar 29, 2010
	 */
	public HomePage loginForNexiaFromProviderSite(WebDriver driver, String userAccount, String userName, String userPassword) {   
		try{
		if(!waitForElement(driver,txtAccount, WAIT_TIME*1000)){
        	Assert.fail("Login Page Not loaded More Details; UserAccount :- "+userAccount +"  UserName :- " +userName+ "UserPassword :- "+ userPassword);
        }
		type(driver, txtAccount, userAccount);
		type(driver, txtUserName, userName);
		type(driver, txtPassword, userPassword);

		click(driver, btnLogin);
		
		while(isElementPresent(driver,lblImageLoad)){
        waitForPageLoad(driver);
		}
        
        /*if(isElementPresent(driver,btnAgree)){
        	click(driver,btnAgree);
        }*/
	    
		waitForPageLoad(driver);
	    waitForPageLoad(driver);
        waitForPageLoad(driver);
        
        if(waitForElement(driver,btnErrorClose,WAIT_TIME))
        {
        	if(isElementPresent(driver,btnErrorClose))
        	click(driver,btnErrorClose);
        }
     isElementPresent(txtPatientBox);
        if(isElementPresent(driver,btnErrorClose))
        	click(driver,btnErrorClose);
               
     }catch(RuntimeException e){
         e.printStackTrace();
     } 
	return new HomePage();
	}




}
