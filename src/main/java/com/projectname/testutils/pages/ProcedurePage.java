package com.projectname.testutils.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.Constants;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class ProcedurePage extends SeleniumWebDriver{
	
	private By readyLocator = By.id("searchProcedureTextBox");

	private By  chkQuickList = By.id("saveListcheckbox");
	private By  txtProcedureName = By.id("searchProcedureTextBox");
	private By  txtProcedureDate = By.id("procedureDate");
	private By  lnkProcedureShowMore = By.id("medicationsMoreDetails");
	private By  txtOnset = By.id("onsetDate");
	private By  txtcpt = By.id("cptSuggestBox0-1suggestBox");
	private By  txtcomment = By.id("summaryComment");
	private By  chkConsentBox = By.id("consentCheckBoxcheckbox");
	private By consent_procedure =By.id("consentSuggestBoxsuggestBox");
	private By  lnkAllergy = By.id("link=Allergies");
	private By  btnAdd = By.xpath("//button[@id='add']");
	private By lnkDeleteProcedure = By.xpath("//div[@id='ProcedureList']/table/tbody/tr/td[4]/div/a");
	private By  txtdeleteReason = By.id("deleteReason");
	private By  btnDeleteReason = By.xpath("//button[@id='deleteReason']");
	private By chkNoSignificantHistory=By.id("noEntryCheckboxcheckbox");
	private By ajxLifeState=By.id("lifeStagesuggestBox");
	private By btnEdit=By.xpath("//a[starts-with(@id,'Edit')]");
	private By btnSaveEditedProcedure = By.id("saveEditProcedures");
	private By btnSaveAddedProcedure =By.id("saveProcedures");
	
	public ProcedurePage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	public boolean createProcedure(WebDriver driver, ChartPreVisitLib proData,
			String account) throws IOException {
		String date = "";
		if (account.equals(Constants.CAACCOUNT)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd");
			date = DateFormat.format(cal.getTime());
			int date1 = Integer.parseInt(date);
			if (date1 < 10) {
				SimpleDateFormat DateForma1t = new SimpleDateFormat("d/MM/yyyy");
				date = DateForma1t.format(cal.getTime());
			} else {
				SimpleDateFormat DateFormat2 = new SimpleDateFormat(
						"dd/MM/yyyy");
				date = DateFormat2.format(cal.getTime());
			}
		} else {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal.getTime());

		}
		try {
			if(proData.saveListCheckBox.equals("no")){
					if (isChecked(driver, chkQuickList)) {
						assertTrue(click(driver, chkQuickList),
								"Could not click the Save Quick List check box;More Details:"
										+ proData.toString(),driver, className, methodName);
						
					}
				}else if(proData.saveListCheckBox.equals("yes")){
					if (!isChecked(driver, chkQuickList)) {
						assertTrue(click(driver, chkQuickList),
								"Could not click the Save Quick List check box;More Details:"
										+ proData.toString(),driver, className, methodName);
					}
				}
				waitForPageLoad(driver);
				if (proData.noSignificantHistory.equals("yes")) {	
					if (isChecked(driver, chkNoSignificantHistory)) {
						assertTrue(click(driver, chkNoSignificantHistory),
								"Could not click the Save Quick List check box;More Details:"
										+ proData.toString(),driver, className, methodName);
						
					}
				}else if(proData.saveListCheckBox.equals("yes")){
					if (!isChecked(driver, chkNoSignificantHistory)) {
						assertTrue(click(driver, chkNoSignificantHistory),
								"Could not click the Save Quick List check box;More Details:"
										+ proData.toString(),driver, className, methodName);
					}
					}
			if (proData.proName!="") {	
			assertTrue(
					type(driver, txtProcedureName, proData.proName),
					"Could not type procedure name",driver, className, methodName);
			}
			assertTrue(
					enterDate(driver, txtProcedureDate, date),
					"Could not enter the Admin on ;More Details:"
							+ proData.toString(),driver, className, methodName);
			
			waitForPageLoad(driver);
			if(proData.showMoreLink.equals("yes")){
					if (!isElementPresent(ajxLifeState)) {
						assertTrue(click(driver, lnkProcedureShowMore),
								"Could not on show more button",driver, className, methodName);
					}
				}
				waitForPageLoad(driver);
			
			if (proData.onsetDate.equals("yes"))
				{				
					assertTrue(
							enterDate(driver, txtOnset, date),
							"Could not enter the Admin on ;More Details:"
									+ proData.toString(),driver, className, methodName);
				}
			if(proData.cpt!=""){
				selectValueFromAjaxList(driver, txtcpt, proData.cpt);
			}

			if(proData.comment!=""){
				assertTrue(
						type(driver, txtcomment, proData.comment),
						"Could not enter the comment;More Details:"
								+ proData.toString(),driver, className, methodName);
			}
				if (proData.consentCheck.equals("yes")) {
					assertTrue(click(driver, chkConsentBox),
							"Could not on show more button",driver, className, methodName);
					selectValueFromAjaxList(driver, consent_procedure,
							proData.consent);
				}
			
			if (proData.testCaseId.equals("TC_CP_014")) {
				assertTrue(click(driver, lnkAllergy),
						"Could not click the Allergy link;More Details",driver, className, methodName);
				waitForPageLoad(driver);
				return true;
			}
			waitForPageLoad(driver);
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * deleteAllergy function to delete Allergy
	 * @throws IOException 
	 * 
	 * @since Oct 17, 2012
	 */
	public boolean deleteProcedure(ChartPreVisitLib proData) throws IOException {
		boolean procedureDeleted = true;
			try {
			
			while (isElementPresent(lnkDeleteProcedure)) {
				assertTrue(click(driver, lnkDeleteProcedure),
						"Could not clik the Delete button",driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(
						type(driver, txtdeleteReason, proData.reason),
						"Could not type the reason; More Details:"
								+ proData.toString(),driver, className, methodName);
				assertTrue(click(driver, btnDeleteReason),
						"Could not click the delete button;More Details:"
								+ proData.toString(),driver, className, methodName);
				waitForPageLoad(driver);
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return procedureDeleted;
	}

	
	public boolean clickAddProcedure(){
		return click(driver, btnAdd);
	}
	public boolean clickEditProcedure(){
		return click(driver, btnEdit);
	}
	
	/**
	 * saveEditededProcedure
	 * function to add Procedure 
	 * @throws Exception 
	 * @since May 22, 2015
	 * @version 2.1
	 */

	public boolean saveEditededProcedure(){
		verifyTrue(click(driver, btnSaveEditedProcedure), "could not click Save", driver);
		return true;
	}

	/**
	 * saveAddedProcedure
	 * function to add Procedure 
	 * @throws Exception 
	 * @since May 22, 2015
	 * @version 2.1
	 */

	public boolean saveAddedProcedure(){
		verifyTrue(click(driver, btnSaveAddedProcedure), "could not click Save", driver);
		return true;
	}


}
