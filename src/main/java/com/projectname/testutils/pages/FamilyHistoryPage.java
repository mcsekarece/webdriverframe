package com.projectname.testutils.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class FamilyHistoryPage extends SeleniumWebDriver{

	private By readyLocator = By.id("familyHistoryQuicklist");
	
	/***
	 * Call to super constructor
	 */
	public FamilyHistoryPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}

	private By ajxFamilyMedical = By.id("familyHistoryQuicklist");
	private By ajxFamilyrelation = By.id("relationshipsuggestBox");
	private By txtAgeOfOnset = By.id("ageOfOnset");
	private By ajxdiagnosis = By.id("diagnosissuggestBox");
	private By lnkFamilkShowMoreDeatils = By.id("medicationsMoreDetails");
	private By chkCasue = By.id("causeOfDeathcheckbox");
	private By txtAgeat = By.id("ageAtDeath");
	private By ajxlifeStage = By.id("lifeStagesuggestBox");
	private By txtTreatMent = By.id("treatment");
	private By txtComment = By.id("comment");
	private By btnAdd =By.id("add");
	private By chkQuickList = By.id("saveListcheckbox");
	private By btnEdit = By.xpath("//a[contains(text(),'Edit')]");
	private By btnSaveFamilyHistoryEdit = By.id("saveFamilyHistoryEdit");
	private By btnSaveFamilyHistory = By.id("saveFamilyHistory");
	
	
	/**
	 * createFamilyHistory 
	 * function to create FamilyHistory
	 * @param driver
	 * @param historyData
	 * @throws IOException 
	 * @since May 20, 2015
	 */
	public boolean createFamilyHistory(WebDriver driver, ChartPreVisitLib historyData) throws IOException {
		try {
			if (!historyData.medical.equals("")){
			verifyTrue(type(driver, ajxFamilyMedical, historyData.medical),	"Could not enter the medical",driver);
			}

			if (!historyData.relation.equals("")){
			verifyTrue(selectValueFromAjaxList(driver, ajxFamilyrelation,historyData.relation),	"Could not enter the relation",driver);
			waitForPageLoad(driver);
			}
			
			waitForPageLoad(driver);
			
			if (!historyData.age.equals("")){
			verifyTrue(type(driver, txtAgeOfOnset, historyData.age),"Could not enter the age;More Details:"	+ historyData.toString(),driver);
			waitForPageLoad(driver);
			}
			
			if (!historyData.diagnosis.equals("")){
			verifyTrue(selectValueFromAjaxList(driver, ajxdiagnosis,historyData.diagnosis),"Could not enter the Diagnosis"	+ historyData.toString(),driver);
			waitForPageLoad(driver);
			}
			
			if (!historyData.lifeStage.equals("")){
			verifyTrue(click(driver, lnkFamilkShowMoreDeatils),	"Could not on show more button",driver);
			waitForPageLoad(driver);
			}
			
			if (historyData.cause.equals("yes")) {
					verifyTrue(click(driver, chkCasue),	"Could not click the check box",driver);
					waitForPageLoad(driver);
					verifyTrue(type(driver, txtAgeat, historyData.ageAtDeath),"Could not enter the age at death",driver);
				}
				
			if (!historyData.lifeStage.equals("")){
				verifyTrue(selectValueFromAjaxList(driver, ajxlifeStage, historyData.lifeStage),"Could not enter the lifeStage"	+ historyData.toString(),driver);
				waitForPageLoad(driver);
			}
			
			if (!historyData.treatment.equals("")){
				verifyTrue(	type(driver, txtTreatMent, historyData.treatment),	"Could not enter the treatment;More Details:"+ historyData.toString(),driver);
			}
			
			if (!historyData.comment.equals("")){
				verifyTrue(type(driver, txtComment, historyData.comment),"Could not enter the comments;More Details:"	+ historyData.toString(),driver);
			}
			
			if (historyData.saveList.equals("yes")) {
					verifyTrue(click(driver, chkQuickList),	"Could not click the check box;More Details:"+ historyData.toString(),driver);
			}
			

		} catch (RuntimeException e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
		return true;
	}

	/**
	 * addFamilyHistory
	 * function to Add FamilyHistory
	 * @param driver
	 * @throws Exception 
	 * @since May 20, 2015
	 */
	public boolean addFamilyHistory(WebDriver driver) throws Exception {
		try {
			verifyTrue(click(driver, btnAdd),"Could not click Add button",driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}
		catch (RuntimeException e) {
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}
		return true;
	}

	/**
	 * saveAddedFamilyHistory
	 * function to Save Added Family History
	 * @param driver
	 * @throws Exception 
	 * @since May 20, 2015
	 */
	public boolean saveAddedFamilyHistory(WebDriver driver) throws Exception {
		try {
			verifyTrue(click(driver, btnSaveFamilyHistory),"Could not click Save button",driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}
		catch (RuntimeException e) {
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}
		return true;
	}

	/**
	 * clickEditFamilyHistory
	 * function to  Click Edit button
	 * @since May 20, 2015
	 * @version 2.1
	 */
	public boolean clickEditFamilyHistory()
	{
		try{
			verifyTrue(click(driver, btnEdit), "edit button not found", driver);
			waitForPageLoad(driver);
		}	
		catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}

	/**
	 * clickSaveEditFamilyHistory 
	 * function to a Click Save button
	 * @param driver
	 * @since May 20, 2015
	 * @version 2.1
	 */
	
	public boolean clickSaveEditFamilyHistory(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnSaveFamilyHistoryEdit), "edit save button not found", driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}

}
