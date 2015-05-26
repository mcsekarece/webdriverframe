package com.projectname.testutils.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.Constants;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class AllergyPage extends SeleniumWebDriver {

	private By readyLocator = By.id("searchAllergyTextBox");

	//DeleteAllergies
	
	private By chkshowAllRecords =By.id("includeInactivecheckbox");
	private By btnDeleteAllergy = By.xpath("//a[contains(text(),'Delete')]");
	private By txtdeleteReason =By.id("deleteReason");
	private By btnDeleteReason = By.xpath("//button[@id='deleteReason']");
	private By btnSave = By.id("saveAllergy");
	
	//Create Allergies
	
	public By lnkAllergy =  By.linkText("link=Allergies");
	private By chkInto = By.id("intoleranceradio");
	private By ajxSearchAllergy =By.id("searchAllergyTextBox");
	private By ajxAllergyReaction =By.id("reactionLink");
	private By chkReaction=By.id("1checkboxAllergyReaction");
	private By lnkClose=By.id("multiSelectionCloseButton");
	private By lnkAllShowmore =By.id("medicationsMoreDetails");
	private By lnkAllergyShowmore =By.id("medicationsMoreDetails");
	private By txtOnset = By.id("onsetDate");
	
	private By ajxSeverity =By.id("severitysuggestBox");
	private By ajxStatus =By.id( "statusSuggestBoxsuggestBox");
	private By ajxlifeStage =By.id("lifeStagesuggestBox");
	private By txtcomment =By.id("summaryComment");
	private By btnAllergyCancel=By.id("cancelAllergyButton");
	private By btnAdd =By.id("add");
	private By btnSaveAllergy = By.id("saveAllergyButton");
	public By btnEdit = By.xpath("//a[contains(text(),'Edit')]");

	public AllergyPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
		
	/**
	 * deleteAllergy function to delete Allergy
	 * @throws IOException 
	 * 
	 * @since Oct 17, 2012
	 */
	public boolean deleteAllAllergy(WebDriver driver,
			ChartPreVisitLib allergyData) throws IOException {
		boolean historyDeleted = true;
		int historyCount = 0;
		try {

			assertTrue(click(driver, chkshowAllRecords),
					"Could not click the show All recorded check box;More Details:"
							+ allergyData.toString(),driver, className, methodName);
			waitForPageLoad(driver);
			waitForElement(driver, btnDeleteAllergy, WAIT_TIME);
			
			
			while (isElementPresent(driver,btnDeleteAllergy)) {
				assertTrue(click(driver, btnDeleteAllergy),"Could not Click the Delete Allergy Button",driver, className, methodName);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				assertTrue(
						type(driver, txtdeleteReason, allergyData.reason),
						"Could not type reason for deletion",driver, className, methodName);
				assertTrue(click(driver, btnDeleteReason),
						"Could not click Delete button;More Details:"
								+ allergyData.toString(),driver, className, methodName);
				historyCount++;
				waitForPageLoad(driver);
				
				if(historyCount>15){
					break;
				}
			
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return historyDeleted;
	}
	
	/**
	 * verifyAllergenName
	 * @throws IOException 
	 * @since Jan 22, 2015
	 */
	public AllergyPage verifyAllergenName(WebDriver driver) throws IOException {
		
		assertTrue(click(driver, lnkAllergy),
				"Could not Intolernce radio button;More Details",driver, className, methodName);
		
		return  new AllergyPage();	
	}
	
	/**
	 * verifyTextPresent
	 * @throws IOException 
	 * @since Jan 22, 2015
	 */
	public boolean verifyTextPresent(String text)
	{
		return isTextPresent(driver, text);
	}
	
	/**
	 * createAllergy function to create Allergy
	 * @throws Exception 
	 * @since Nov 01, 2012
	 */
	public boolean createAllergy(WebDriver driver,
			ChartPreVisitLib allergyData, String account) throws Exception {
		try {
			waitForPageLoad(driver);
			if (allergyData.testCaseId.equals("TC_CA_004")
					|| allergyData.testCaseId.equals("TC_CAE_004")) {
				assertTrue(click(driver, chkInto),
						"Could not Intolernce radio button;More Details",driver, className, methodName);
			}

			if(!allergyData.testCaseId.equals("TC_CA_045")){
			
			if (account.equals("CA2000")) {
				selectValueFromAjaxList(driver, ajxSearchAllergy,
						allergyData.allergenCa);
			} else {
				selectValueFromAjaxList(driver, ajxSearchAllergy,
						allergyData.allergen);
			}
			//			selectValueFromAjaxList(driver, ajxAllergyReaction,
			//					allergyData.reaction);
			}else{
				assertTrue(
						type(driver, ajxSearchAllergy, allergyData.allergenCa),
						"Could not type reason for deletion",driver, className, methodName);
			}
			
			assertTrue(click(driver, ajxAllergyReaction),
					"Could not on show more button",driver, className, methodName);			
			waitForPageLoad(driver);
			assertTrue(click(driver, chkReaction),
					"Could not on show more button",driver, className, methodName);
			waitForPageLoad(driver);
			assertTrue(click(driver, lnkClose),
					"Could not on show more button",driver, className, methodName);
			waitForPageLoad(driver);
			if (!(allergyData.testCaseId.equals("TC_CA_001") || allergyData.testCaseId
					.equals("TC_CAE_001"))) {
				if (getText(driver, lnkAllShowmore).equalsIgnoreCase(
						"Show more details")) {
					assertTrue(click(driver, lnkAllergyShowmore),
							"Could not on show more button",driver, className, methodName);
				}
				if (getText(driver, lnkAllShowmore).equalsIgnoreCase(
				"Show more details")) {
					assertTrue(click(driver, lnkAllergyShowmore),
					"Could not on show more button",driver, className, methodName);
				}

				selectValueFromAjaxList(driver, ajxSeverity,
						allergyData.severity);

				selectValueFromAjaxList(driver, ajxStatus, allergyData.status);

				/*if (account.equals(Constants.propUserAccountCA)) {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat DateFormat = new SimpleDateFormat(
							"dd/MM/yyyy");
					String date = DateFormat.format(cal.getTime());
					waitForPageLoad(driver);
					assertTrue(enterDate(driver, txtOnset, date),
							"Could not enter the Admin on ;More Details:"
									+ allergyData.toString(),driver, className, methodName);
				} else {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat DateFormat = new SimpleDateFormat(
							"MM/dd/yyyy");
					String date = DateFormat.format(cal.getTime());
					waitForPageLoad(driver);
					assertTrue(enterDate(driver, txtOnset, date),
							"Could not enter the Admin on ;More Details:"
									+ allergyData.toString(),driver, className, methodName);
				}*/
				selectValueFromAjaxList(driver, ajxlifeStage,
						allergyData.lifeStage);

				assertTrue(
						type(driver, txtcomment, allergyData.comment),
						"Could not enter the comment;More Details:"
								+ allergyData.toString(),driver, className, methodName);
			}
			if (allergyData.testCaseId.equalsIgnoreCase("TC_CA_041")) {
				assertTrue(
						type(driver, txtcomment, allergyData.comment),
						"Could not enter the comment;More Details:"
								+ allergyData.toString(),driver, className, methodName);
			}

			if (!(allergyData.testCaseId.equalsIgnoreCase("TC_CA_046"))) {
				if (allergyData.testCaseId.equalsIgnoreCase("TC_CA_005")
						|| allergyData.testCaseId
						.equalsIgnoreCase("TC_CAE_005")) {
					assertTrue(click(driver, btnAllergyCancel),
							"Could not click the cancel button;More details:"
									+ allergyData.toString(),driver, className, methodName);
				} else
					assertTrue(click(driver, btnAdd),
							"Could not click the add button;More details:"
									+ allergyData.toString(),driver, className, methodName);
			} else {
				assertTrue(click(driver, btnSave),
						"Could not click the save button;More details:"
								+ allergyData.toString(),driver, className, methodName);
			}
			waitForPageLoad(driver);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	/**
	 * createAllergyEndToEnd
	 * function to create Allergy
	 * @param allergyData
	 * @param driver
	 * @param account
	 * @throws Exception 
	 * @since May 20, 2015
	 */
	public boolean createAllergyEndToEnd(WebDriver driver,ChartPreVisitLib allergyData, String account) throws Exception {
		try {
			String date="";
			waitForPageLoad(driver);
			if (!allergyData.intolerance.equals("")){
			verifyTrue(click(driver, chkInto),"Could not Intolernce radio button;More Details",driver);
			}
			
			if (!allergyData.allergenCa.equals("")||!allergyData.allergen.equals("")){
				if (account.equals("CA2000")) {
					verifyTrue(type(driver, ajxSearchAllergy, allergyData.allergenCa), "Allergy Search Box not found", driver);
					waitForPageLoad(driver);
				}
				else
				{
					verifyTrue(type(driver, ajxSearchAllergy, allergyData.allergen), "Allergy Search Box not found", driver);
					waitForPageLoad(driver);
				}
				}

			if (!allergyData.reaction.equals("")){
				verifyTrue(click(driver, ajxAllergyReaction),"Could not on show more button",driver);			
				waitForPageLoad(driver);
				verifyTrue(click(driver, chkReaction),"Could not on show more button",driver);
				waitForPageLoad(driver);
				verifyTrue(click(driver, lnkClose),	"Could not on show more button",driver);
				waitForPageLoad(driver);
			}

			if (!allergyData.severity.equals("")){
				verifyTrue(selectValueFromAjaxList(driver, ajxSeverity, allergyData.severity),"Could not on select Severity",driver);			
				waitForPageLoad(driver);
			}
			
			if (!allergyData.status.equals("")){
				verifyTrue(selectValueFromAjaxList(driver, ajxStatus, allergyData.status),"Could not on select Status",driver);
				waitForPageLoad(driver);
			}

			if (getText(driver, lnkAllShowmore).equalsIgnoreCase("Show more details") && !allergyData.lifeStage.equals("")) {
				verifyTrue(click(driver, lnkAllergyShowmore),"Could not on show more button",driver);
				waitForPageLoad(driver);
			}

			if (!allergyData.lifeStage.equals("")){
				verifyTrue(selectValueFromAjaxList(driver, ajxlifeStage,allergyData.lifeStage),"Could not select LifeStage",driver);
				waitForPageLoad(driver);
			}

			if (!allergyData.onsetDate.equals("")){
				if (account.equals(Constants.CAACCOUNT)) {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
					date = DateFormat.format(cal.getTime());
					verifyTrue(enterDate(driver, txtOnset, date), "txtOnset not found", driver);

				} else {
					Calendar cal1 = Calendar.getInstance();
					SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
					date = DateFormat.format(cal1.getTime());
					
					verifyTrue(enterDate(driver, txtOnset, date), "txtOnset not found", driver);
				}

			if (!allergyData.comment.equals("")){
					verifyTrue(type(driver, txtcomment, allergyData.comment),"Could not type comment",driver);
					waitForPageLoad(driver);
			}

		}
		}
		catch (RuntimeException e) {
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}
		return true;
	}

	/**
	 * addAllergy
	 * function to Add Allergy
	 * @throws Exception 
	 * @since May 20, 2015
	 */
	public boolean addAllergy(WebDriver driver) throws Exception {
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
	 * saveAllergy
	 * function to Add Allergy
	 * @param driver
	 * @throws Exception 
	 * @since May 20, 2015
	 */
	public boolean saveAllergy(WebDriver driver) throws Exception {
		try {
			verifyTrue(click(driver, btnSaveAllergy),"Could not click Save button",driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}
		catch (RuntimeException e) {
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}
		return true;
	}

	/**
	 * clickEditAllergy
	 * function to  Click Edit button
	 * @since May 20, 2015
	 * @version 2.1
	 */
	public boolean clickEditAllergy()
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
	 * clickSaveEditAllergy 
	 * function to a Click Save button
	 * @param driver
	 * @since May 20, 2015
	 * @version 2.1
	 */
	
	public boolean clickSaveEditAllergy(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnSave), "edit save button not found", driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}

}
