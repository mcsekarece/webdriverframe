package com.projectname.testutils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class OrderTemplatePage extends SeleniumWebDriver{

	public  OrderTemplatePage() {
		
        PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	private static By readyLocator = By.id("searchTextBox");
	
	private static By txtTemplateName = By.id("templateName");
	private static By txtSectionName0 = By.id("sectionName0");
	private static By txtSectionName1 = By.id("sectionName1");
	private static By txtSectionName2 = By.id("sectionName2");
	private static By txtSectionName3 = By.id("sectionName3");
	
	private static By txtTestName0 = By.id("testName0");
	private static By txtTestName1 = By.id("testName1");
	private static By txtTestName2 = By.id("testName2");
	private static By txtTestName3 = By.id("testName3");
	
	private static By btnNextButton = By.id("nextButton");
	private static By btnDoneButton = By.id("doneButton");
	

	private static By btnAddNewTemplate = By.id("addNew");
	
	
	
	private static By btnAddNewTemplate1 = By.id("addNewServiceLineDiv");
	
	 
	 /**
	 * createOrderTemplate
	 * Function to create Order Template
	 * @param 	driver
	 * @param dIData(Order template details to be added )
     * @throws Exception 
  	 * @since	Jan 27,2015
	 */  
    
      public OrderTemplatePage createOrderTemplate(WebDriver driver,ChartPreVisitLib diData) throws Exception	 {	

    	try {
  			assertTrue(click(driver,btnAddNewTemplate),"Click Add new  Template button failed", driver, className,methodName);
  			waitForPageLoad(driver);
  			
  			assertTrue(type(driver,txtTemplateName,diData.templateName),"Couldn't type Template Name", driver, className,methodName);
  			waitForPageLoad(driver);
  			assertTrue(type(driver,txtSectionName0,diData.templateName),"Couldn't type Section Name", driver, className,methodName);
  			waitForPageLoad(driver);
  			
  			assertTrue(selectValueFromAjaxList(driver,txtTestName0,diData.testName),"Couldn't type Test  Name", driver, className,methodName);
  			waitForPageLoad(driver);
  			
  			assertTrue(click(driver,btnAddNewTemplate1),"Click Add new  Template button failed", driver, className,methodName);
  			waitForPageLoad(driver);
  			
  			assertTrue(type(driver,txtSectionName1,diData.templateName),"Couldn't type Section Name1", driver, className,methodName);
  			waitForPageLoad(driver);
  			
  			assertTrue(selectValueFromAjaxList(driver,txtTestName1,diData.testName1),"Couldn't type Test  Name1", driver, className,methodName);
  			waitForPageLoad(driver);
  			
  			assertTrue(click(driver,btnAddNewTemplate1),"Click Add new  Template button failed", driver, className,methodName);
  			waitForPageLoad(driver);
  			
  			assertTrue(type(driver,txtSectionName2,diData.templateName),"Couldn't type Section Name2", driver, className,methodName);
  			waitForPageLoad(driver);
  			
  			assertTrue(selectValueFromAjaxList(driver,txtTestName2,diData.testName2),"Couldn't type Test  Name2", driver, className,methodName);
  			waitForPageLoad(driver);
  			
  			assertTrue(click(driver,btnAddNewTemplate1),"Click Add new  Template button failed", driver, className,methodName);
  			waitForPageLoad(driver);
  			
  			assertTrue(type(driver,txtSectionName3,diData.templateName),"Couldn't type Section Name3", driver, className,methodName);
  			waitForPageLoad(driver);
  			
  			assertTrue(selectValueFromAjaxList(driver,txtTestName3,diData.testName3),"Couldn't type Test  Name3", driver, className,methodName);
  			waitForPageLoad(driver);
  			
  			assertTrue(click(driver,btnNextButton),"Couldn't click next button", driver, className,methodName);
  			waitForPageLoad(driver);
  			
  			assertTrue(click(driver,btnDoneButton),"Couldn't click done button", driver, className,methodName);
  			waitForPageLoad(driver);
  	
  			assertTrue(isElementPresent(driver,readyLocator),"Create Order Template Failed", driver, className,methodName);
  			waitForPageLoad(driver);
  			
    	} catch (Exception e) {
  			e.printStackTrace();
  		}
    	  
    	return  new OrderTemplatePage();
    	
    }
	
}
