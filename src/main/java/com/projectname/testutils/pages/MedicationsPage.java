package com.projectname.testutils.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class MedicationsPage extends SeleniumWebDriver{
	private By readyLocator = By.id("medicationSuggestBox");	

	private By ajxMedicationName = By.id("medicationSuggestBox");
	private By chkFreeText = By.id("enterAsFreeTextcheckbox");
	private By txtFreeTextArea = By.id("freeTextArea");
	private By lnkAdd = By.id("add");
	private By btndone = By.id("done");
	private By chkSelectAll = By.id("selectAllCheckbox");
	private By btnRenew = By.id("renew");
	private By txtRefills1 = By.id("ofRefillsid");
	private By txtRefills2 = By.xpath("(//input[@id='ofRefillsid'])[2]");
	private By btnApprove = By.id("approve");
	private By btnSignApproved =By.xpath("(//button[@id='sign'])[2]");
	private By txtPassword = By.xpath("//input[@type='password']");
	
	private By btnSign1 = By.id("signButtonBox");
	private By btnPrint = By.id("renewReviewPrintButton");
	
	private By btnSaveMedication = By.id("saveMedications");
	private By btnSaveMedicationEdit = By.id("saveMedicationsEdit");
	public By btnEdit = By.xpath("//a[contains(text(),'Edit')]");

	 private By btnSaveMedications = By.id("saveMedications");
	
	public MedicationsPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}

	/**
	 * addEncounterMedicationssummary page
	 * Function to add Encounter Medications in summary page
	 * @param 	driver, mcTemplate
	 * @throws IOException 
	 * @since	Mar 19,2015
	 */
	
	public boolean addEncounterMedications(WebDriver driver,ClinicalSettingLib mcTemplate){
	try{
		if (!mcTemplate.medicationName1.equals("")){
		verifyTrue(selectValueFromAjaxList(driver,ajxMedicationName,mcTemplate.medicationName1),"Could not select height option as cm/inches", driver);
		waitForPageLoad(driver);
		}
		if(!isChecked(driver,chkFreeText))
		{
		verifyTrue(click(driver,chkFreeText),"Unable to click the Free text check box",driver);
		}
		verifyTrue(type(driver,txtFreeTextArea,mcTemplate.display), "Could not type free text medications", driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver,lnkAdd),"Unable to click link add ",driver);
		waitForPageLoad(driver);
		
	}catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	}
		return true;
}
	/**
	 * editEncounterMedicationsinEncounterPage
	 * Function to edit Encounter Medications in encounter page
	 * @param 	driver, mcTemplate
	 * @throws IOException 
	 * @since	Mar 19,2015
	 */
	
	public boolean editEncounterMedications(WebDriver driver,ClinicalSettingLib mcTemplate){
	try{
		
		if(!isChecked(driver,chkFreeText))
		{
		verifyTrue(click(driver,chkFreeText),"Unable to click the Free text check box",driver);
		}
		verifyTrue(type(driver,txtFreeTextArea,mcTemplate.display), "Could not type free text medications", driver);
		waitForPageLoad(driver);
		
		
	}catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	}
		return true;
}
	
	/**
	 * addRenewedMedication
	 * Function to add Encounter renewed medications
	 * @param 	driver
	 * @throws IOException 
	 * @since	Mar 20,2015
	 */
	
	public boolean addRenewedMedication(WebDriver driver,ChartPreVisitLib medData){
	try{

		verifyTrue(click(driver,chkSelectAll),"Unable to click SelectAll ",driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver,btnRenew),"Unable to click Renew ",driver);
		waitForPageLoad(driver);
		verifyTrue(type(driver,txtRefills1, medData.refillQuantityCa),"Unable to type refills 1 ",driver);
		waitForPageLoad(driver);
		verifyTrue(type(driver,txtRefills2, medData.refillQuantityCa),"Unable to type refills 2 ",driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver,btnApprove),"Unable to click btnApprove ",driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver,btnSignApproved),"Unable to click btnSignApproved ",driver);
		waitForPageLoad(driver);
		verifyTrue(type(driver,txtPassword, medData.userPassword),"Unable to type Password ",driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver,btnSign1),"Unable to click btnSign1 ",driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver,btnPrint),"Unable to click btnPrint ",driver);
		waitForPageLoad(driver);
		Thread.sleep(20000);
		Thread.sleep(20000);
		Robot rb =new Robot();	
		Thread.sleep(20000);
		rb.keyPress(KeyEvent.VK_ESCAPE);
		rb.keyRelease(KeyEvent.VK_ESCAPE);		
		Thread.sleep(2000);		
		waitForPageLoad(driver);
		verifyTrue(click(driver,btndone),"Unable to click link done button ",driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
	
	}catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	}
		return true;
}

	public boolean saveMedication(WebDriver driver)
	{
		try{
		verifyTrue(click(driver, btnSaveMedication), "Save button not found", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}

		return true;
	}

	/**
	 * saveMedicationEdit function to a click Save button
	 * @since  	@since March 24, 2015
	 * @version 2.1
	 */
	
	public boolean saveMedicationEdit(WebDriver driver)
	{
		try{
		verifyTrue(click(driver, btnSaveMedicationEdit), "Save button not found", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}

		return true;
	}
	
	/**
   	 * saveAddedSummaryMedications
   	 * Function to Save Added Summary Medications
   	 * @param 	driver
   	 * @since  	Mar 23, 2015
   	 * @version 2.1
   	 */	
	
	public boolean saveAddedSummaryMedications(WebDriver driver){
	try{
		verifyTrue(click(driver,btnSaveMedications),"Unable to click the done button",driver);
	
	}catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	}
		return true;
}


	/**
	 * clickEditMedication function to a Click Edit button
	 * @since  	@since March 24, 2015
	 * @version 2.1
	 */

	public boolean clickEditMedication(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnEdit), "edit button not found", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}	
		catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}
	
	/**
	 * goToEditEncounterMedications function to a Click Edit button
	 * @param driver
	 * @since March 25, 2015
	 * @version 2.1
	 */

	public boolean goToEditEncounterMedications(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnEdit), "edit button not found", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}	
		catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}
	/**
   	 * saveAddedEncounterMedications
   	 * Function to Save Added Encounter Medications
   	 * @param 	driver
   	 * @since  	Mar 23, 2015
   	 * @version 2.1
   	 */	
	
	public boolean saveAddedEncounterMedications(WebDriver driver){
	try{
		verifyTrue(click(driver,btnSaveMedicationEdit),"Unable to click the save button",driver);
		verifyTrue(click(driver,btndone),"Unable to click the done button",driver);
		
	}catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	}
		return true;
}

	
}
