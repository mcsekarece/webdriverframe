package com.projectname.testutils.pages;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class InjectionPage extends SeleniumWebDriver {
	
	
	public InjectionPage(){
		PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	private By readyLocator= By.id("injectionSearchBox");
	
	private By txtQuickinjection = By.id("injectionSearchBox");
	private By txtexpiryDate =By.id( "expiryDate");
	private By txtDosage = By.id("dosageQuantity");
	private By txtadminOn = By.id("administeredOn");
	private By lnkInjectionShowMoreArrow =By.id( "medicationsMoreDetails");
	private By ajxConsentSuggest =By.id( "consentsuggestBox");
	private By ajxDosageUnit =By.id( "dosageUnitsuggestBox");
	private By site = By.id("siteSuggestBoxsuggestBox");
	private By ajxInjectionRoute =By.id( "routeSuggestBoxsuggestBox");
	private By ajxAdminBy = By.id("administeredBysuggestBox");
	private By ajxCptCode1 =By.id( "cptCode1SuggestBoxsuggestBox");
	private By ajxCptCode2 =By.id( "cptCode2SuggestBoxsuggestBox");
	private By ajxReaction = By.id("reactionSuggestBoxsuggestBox");
	private By chkInjectionConsentBox = By.id("consentcheckbox");
	private By txtLotNo = By.id("lotNumberBox");
	private By txtComment = By.id("comment");
	private By btnSave = By.linkText("Save");
	private By btnAdd = By.id("add");
	private By lnkEncounterInjection = By.xpath("(//a[contains(text(),'Injections')])[2]");
	private By lnkInjection = By.linkText("Injections");
	private By btnSaveInjection=By.id("saveInjection");
	private By btnEdit = By.xpath("//a[contains(text(),'Edit')]");
	private By btnSaveEditedInjection = By.id("saveInjectionEdit");
	
	
	/**createInjection
	 * function to create an injection 
	 * @param driver
   	 * @since May 21, 2015
 */
	public boolean createInjection(WebDriver driver,
			ChartPreVisitLib injectionData, String account)
					throws Exception {
		String date = null;
		try {
			if (!injectionData.injection.equals("")){
				assertTrue(selectValueFromAjaxList(driver, txtQuickinjection,injectionData.injection),"Could not select injection in quick list text box;More Details:",driver, className, methodName);
			}
			if (! injectionData.lotNumber.equals("")){
			assertTrue(type(driver, txtLotNo, injectionData.lotNumber),"Could not type the Lot Number;More Details:",driver, className, methodName);
			}
			if (account.equals("CA2000")) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = DateFormat.format(cal.getTime());
			} else {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal.getTime());
			}
			if (!injectionData.expiryData.equals("")){
			assertTrue(enterDate(driver, txtexpiryDate,injectionData.expiryData),"Could not enter the expiry Date;More Details:"+ injectionData.toString(),driver, className, methodName);
			}
			if (!injectionData.dosage.equals("")){
			assertTrue(type(driver, txtDosage, injectionData.dosage),"Could not enter the Dosage;More Details:"+ injectionData.toString(),driver, className, methodName);
			}
			if (!injectionData.dosageUnit.equals("")){
			selectValueFromAjaxList(driver, ajxDosageUnit,injectionData.dosageUnit);
			}
				assertTrue(click(driver, lnkInjectionShowMoreArrow),"Could not click on Injection Show More Arrow",driver, className, methodName);
				waitForPageLoad(driver);
				if (account.equals("CA2000")) {
					assertTrue(enterDate(driver, txtadminOn, date),"Could not enter the expiry Date;More Details:",driver, className, methodName);
				} else {
					assertTrue(enterDate(driver, txtadminOn, date),"Could not enter the expiry Date;More Details:",driver, className, methodName);
				}
				if (injectionData.consentCheck.equalsIgnoreCase("yes")) {
					assertTrue(click(driver, chkInjectionConsentBox),"Could not click the consent check box",driver, className, methodName);
					if (!injectionData.consent.equals("")){
					selectValueFromAjaxList(driver, ajxConsentSuggest,injectionData.consent);
					waitForPageLoad(driver);
					}
				}
				if (!injectionData.site.equals("")){
				selectValueFromAjaxList(driver, site, injectionData.site);
				waitForPageLoad(driver);
				}
				if (!injectionData.route.equals("")){
				selectValueFromAjaxList(driver, ajxInjectionRoute,injectionData.route);
				waitForPageLoad(driver);
				}
				if (!injectionData.cptCode1.equals("")){
				selectValueFromAjaxList(driver, ajxCptCode1,injectionData.cptCode1);
				waitForPageLoad(driver);
				}
				if (!injectionData.cptCode2.equals("")){
				selectValueFromAjaxList(driver, ajxCptCode2,injectionData.cptCode2);
				waitForPageLoad(driver);
				}
				if (!injectionData.reaction.equals("")){
				selectValueFromAjaxList(driver, ajxReaction,injectionData.reaction);
				waitForPageLoad(driver);
				}
				if (!injectionData.comment.equals("")){
				assertTrue(type(driver, txtComment, injectionData.comment),"Could not enter the comment;More Details:",driver, className, methodName);
				}
			if (injectionData.testCaseId.equals("TC_ETE_001"))
			{
				assertTrue(click(driver, btnAdd),"Could not click the Add buton;More Details:",driver, className, methodName);
			}
			else
			{
				assertTrue(click(driver, btnSave),"Could not click on save button;More Details:",driver, className, methodName);
			}
			waitForPageLoad(driver);
		} catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}
		return true;
	}
	 /**clickInjectionLinkOnEncounterNote
     * function to click injection link on encounter note
	 * @param driver
   	 * @since May 21, 2015
      */
	public boolean clickInjectionLinkOnEncounterNote(WebDriver driver)throws Exception {
		assertTrue(click(driver,lnkEncounterInjection),
				"Injection Link Not Visible;More Details", driver,
				className, methodName);
		waitForPageLoad(driver);
		return true;
	}
	
	 /**clickInjectionLinkOnSummary
		 * function to click injection link on summary 
		 * @param driver
	   	 * @since May 21, 2015
	      */
	public boolean clickInjectionLinkOnSummary(WebDriver driver)throws Exception 
	{
	assertTrue(click(driver,lnkInjection),"Could not click Injections link;More Details:",driver, className, methodName);
	waitForPageLoad(driver);
	return true;
	}
	
	
	/**
	 * saveSummaryProblemList function to a create Problem List
	 * @param driver  	
	 * @since March 12, 2015
	 * @version 2.1
	 */
	
	public boolean saveSummaryInjection(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnAdd), "add button not found", driver);
			waitForPageLoad(driver);
		}
		catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}
	
	
	/**
	 * clickSaveEditProblemList function to a Click Add button
	 * @param driver
	 * @since March 12, 2015
	 * @version 2.1
	 */
	
	public boolean clickSaveInjection(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnSaveInjection), "edit save button not found", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}
	
	
	
	/**
	 * clickSaveEditInjection 
	 * function to a Click Save button
	 * @param driver
	 * @since May 22, 2015
	 * @version 2.1
	 */
	
	public boolean clickSaveEditInjection(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnSaveEditedInjection), "edit save button not found", driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}

	
	
	
	/**
	 * clickEditProblemList function to a Click Edit button
	 * @since March 12, 2015
	 * @version 2.1
	 */

	public boolean clickEditInjection(WebDriver driver)
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
	
}
