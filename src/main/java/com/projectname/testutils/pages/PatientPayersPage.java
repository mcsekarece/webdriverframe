package com.projectname.testutils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class PatientPayersPage extends SeleniumWebDriver{
	
	private By readyLocator = By.id("addNewMedicalPayerButton");
	private By medicalPayerstab=By.id("medicalPayers");
	private By btnAddNewMedicalPayer = By.id("addNewMedicalPayerButton");
	private By payerSuggBox=By.id("payerSearchSuggestBoxsuggestBox");
	private By payerStartDate=By.id("startDate");
	private By payerMemId=By.id("memberId");
	private By payerDOB=By.id("dob");
	private By payerRelationShipSuggBox=By.id("subscriberRelationshipSuggestBoxsuggestBox");
	private By btnSaveMedicalPayer=By.linkText("Save");
		
	
      public PatientPayersPage(){
	  PageFactory.initElements(SeleniumWebDriver.driver, this);	
	  SeleniumWebDriver.isElementPresent(readyLocator);
      }
/**
* clickAddNewMedicalPayers
* Function to navigate to Payers
* @param 	driver
* @param   encounterTemplateTestData
* @throws Exception 
* @since	May 12,2015
* @Version 2.1
*/
public boolean clickAddNewMedicalPayers(WebDriver driver) throws Exception {
try {
	verifyTrue(click(driver, medicalPayerstab),"could not click medical payer tab link", driver);
	waitForPageLoad(driver);
	assertTrue(click(driver, btnAddNewMedicalPayer),"could not click add new button for medical payer", driver,className,methodName);
	waitForPageLoad(driver);
} catch (RuntimeException e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
}
return true;
}


/**
* addNewMedicalPayerWithMandatoryFields
* Function to create a new medical payer with mandatory data
* @param 	driver
* @param   encounterTemplateTestData
* @throws Exception 
* @since	May 12,2015
* @Version 2.1
*/
public boolean addNewMedicalPayerWithMandatoryFields(WebDriver driver,HomeLib payerData) throws Exception {
try {
	assertTrue(selectValueFromAjaxList(driver,payerSuggBox,payerData.payerName),"Unable to select the value from the payers ajax list",driver,className,methodName);
	waitForPageLoad(driver);
	assertTrue(enterDate(driver,payerStartDate,payerData.newSeriesStartDate),"Unable to select the value from the payers ajax list",driver,className,methodName);
	waitForPageLoad(driver);
	assertTrue(type(driver,payerMemId,payerData.payerCode),"Unable to select the value from the payers ajax list",driver,className,methodName);
	waitForPageLoad(driver);
	assertTrue(enterDate(driver,payerDOB,payerData.dob),"Unable to select the value from the payers ajax list",driver,className,methodName);
	waitForPageLoad(driver);
    assertTrue(selectValueFromAjaxList(driver,payerRelationShipSuggBox,payerData.relationshipStatus),"Unable to select the value from the payers ajax list",driver,className,methodName);
	waitForPageLoad(driver);
} catch (RuntimeException e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
}
return true;
}

/**
* saveMedicalPayer
* Function to save the created to Payers
* @param 	driver
* @param   encounterTemplateTestData
	 * @throws Exception 
* @since	May 12,2015
* @Version 2.1
*/
public boolean saveMedicalPayer(WebDriver driver) throws Exception {
try {
	assertTrue(click(driver, btnSaveMedicalPayer),"could not click save button for medical payer", driver,className,methodName);
	waitForPageLoad(driver);
} catch (RuntimeException e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
}
return true;
}


}
