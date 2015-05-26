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



public class ProblemListPage extends SeleniumWebDriver{
	
	private By readyLocator = By.id("medicalConditionTextBox");
	
	private By btnDeleteProblemList = By.xpath("//a[starts-with(@id,'Delete')]");
	private By txtdeleteReason = By.id("deleteReason");
	private By lnkDeleteReason = By.xpath("//button[contains(@id,'deleteReason')]");

	private By txtMedicatl = By.id("medicalConditionTextBox");
	private By txtOnset = By.id("onsetDate");	
	private By ajxItem = By.id("itemStatusInputsuggestBox");
	private By lnkProblemListShowMoreArrow = By.id("medicationsMoreDetails");
	private By ajxlifeStage = By.id("lifeStagesuggestBox");
	private By txtResolvedDate = By.id("resolvedDate");
	private By txtcomment = By.id("summaryComment");
	private By ajxdiagnosis = By.id("diagnosissuggestBox");
	private By ajxCodingSystem = By.id("codingSystemsuggestBox");
	
	private By btnCancelSummaryProblemList = By.id("cancelProblemList");
	private By chkQuickList = By.id("saveListcheckbox");
	private By btnAdd = By.id("add");
	private By btnSave1 = By.xpath("(//a[contains(text(),'Save')])[3]");
	private By btnSaveProblemList = By.id("saveProblemList");
	private By btnCancelProblemListEdit = By.id("cancelProblemList");
	private By btnEditSaveProblemList = By.id("problemEditSaveButton");
	public By btnEdit = By.xpath("//a[contains(text(),'Edit')]");
	public By btnEditInEncounter = By.id("edit");
	public By lblEnProblemList= By.xpath("//span[starts-with(@id, 'problems')]");
	
	
	
	/***
	 * Call to super constructor
	 */
	public ProblemListPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
   	/**
	 * deleteAllProblemList Function to delete All Existing Problem List
	 * @param 	WebDriver
	 * @param 	ChartPreVisitLib- Data for Problem List
	 * @throws  IOException 
	 * @since  	@since Nov 05, 2012
	 * @version 2.0
	 */
	public boolean deleteAllProblemList(WebDriver driver, ChartPreVisitLib proData) throws IOException {
		boolean problemDeleted = true;
		int problemCount = 0;
		try {

			while (isElementPresent(btnDeleteProblemList)) {

				assertTrue(click(btnDeleteProblemList),"Could not click on the immunization button",driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(
						type(driver, txtdeleteReason,
								proData.userAccount),
						"Could not enter the reason",driver, className, methodName);
				assertTrue(click(lnkDeleteReason),"Could not click on Continue Button" ,driver, className, methodName);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				
				if (!isElementPresent(btnDeleteProblemList)) {

					break;
				}
				problemCount++;
				if(problemCount>15){
					break;
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return problemDeleted;
	}
	/**
	 * createProblemList function to a create Problem List
	 * @param 	ChartPreVisitLib- Data for Problem List
	 * @throws  Exception 
	 * @since  	@since Sept 28, 2012
	 * @version 2.0
	 */

	public boolean createProblemList(ChartPreVisitLib proData, String account)   {
		try {
			String date = "";
			waitForPageLoad(driver);
			if (proData.testCaseId.equals("TC_QL_001")
					|| (proData.testCaseId.equals("TC_QL_002"))
					|| (proData.testCaseId.equals("TC_QL_003"))
					|| proData.testCaseId.equals("TC_CPL_050"))
				assertTrue(
						type(driver, txtMedicatl, proData.quickList),
						"Could not type medical condition",driver, className, methodName);
			if (!proData.testCaseId.equals("TC_CPL_047")) {
				assertTrue(
						type(driver, txtMedicatl, proData.medicalCondition1),
						"Could not type medical condition",driver, className, methodName);
				waitForPageLoad(driver);
			}
			if (account.equals(Constants.CAACCOUNT)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = DateFormat.format(cal.getTime());
				assertTrue(
						enterDate(driver, txtOnset, date),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),driver, className, methodName);
			} else {
				Calendar cal1 = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal1.getTime());
				assertTrue(
						enterDate(driver, txtOnset, date),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),driver, className, methodName);
			}
			selectValueFromAjaxList(driver, ajxItem, proData.itemStatus);
			if (proData.testCaseId.equals("TC_CPL_002")
					|| proData.testCaseId.equals("TC_CPL_013")
					|| proData.testCaseId.equals("TC_QL_001")
					|| proData.testCaseId.equals("TC_QL_002")
					|| proData.testCaseId.equals("TC_CPL_020")
					|| proData.testCaseId.equals("TC_CPL_021")
					|| proData.testCaseId.equals("TC_CPL_022")
					|| proData.testCaseId.equals("TC_CPL_023")
					|| proData.testCaseId.equals("TC_CPL_024")
					|| proData.testCaseId.equals("TC_CPL_025")
					|| proData.testCaseId.equals("TC_CPL_026")
					|| proData.testCaseId.equals("TC_CPL_027")
					|| proData.testCaseId.equals("TC_CPL_028")
					|| proData.testCaseId.equals("TC_CPL_029")
					|| proData.testCaseId.equals("TC_CPL_030")
					|| proData.testCaseId.equals("TC_CPL_031")
					|| proData.testCaseId.equals("TC_CPL_032")
					|| proData.testCaseId.equals("TC_CPL_033")
					|| proData.testCaseId.equals("TC_CPL_034")
					|| proData.testCaseId.equals("TC_CPL_035")
					|| proData.testCaseId.equals("TC_CPL_036")
					|| proData.testCaseId.equals("TC_CPL_037")
					|| proData.testCaseId.equals("TC_CPL_038")
					|| proData.testCaseId.equals("TC_CPL_039")
					|| proData.testCaseId.equals("TC_CPL_040")
					|| proData.testCaseId.equals("TC_CPL_041")
					|| proData.testCaseId.equals("TC_CPL_044")) {
				waitForPageLoad(driver);
				click(driver, lnkProblemListShowMoreArrow);


				selectValueFromAjaxList(driver, ajxlifeStage,
						proData.lifeStage);

				if (account.equals(Constants.CAACCOUNT)) {
					assertTrue(
							enterDate(driver, txtResolvedDate, date),
							"Could not enter resolved date ;More Details:"
									+ proData.toString(),driver, className, methodName);
					assertTrue(
							type(driver, txtcomment, proData.comment),
							"Could not enter the comment;More Details:"
									+ proData.toString(),driver, className, methodName);
				} else
					assertTrue(
							enterDate(driver, txtResolvedDate, date),
							"Could not enter resolved date ;More Details:"
									+ proData.toString(),driver, className, methodName);
/*
				selectValueFromAjaxList(driver, ajxCodeingSystem,
						proData.codingSystem);*/
				waitForPageLoad(driver);
				if(isVisible(driver,ajxdiagnosis))
				{
					selectValueFromAjaxList(driver, ajxdiagnosis,
							proData.diagnosis);
					waitForPageLoad(driver);
				}
				assertTrue(
						type(driver, txtcomment, proData.comment),
						"Could not enter the comment;More Details:"
								+ proData.toString(),driver, className, methodName);
			}
			if (proData.testCaseId.equals("TC_CPL_050")) {
				return true;
			}
			if (proData.testCaseId.equals("TC_CPL_004")) {
				assertTrue(click(driver, btnCancelSummaryProblemList),
						"Could not click the Cancel button;More details:"
								+ proData.toString(),driver, className, methodName);
				return true;
			}
			if (proData.testCaseId.equals("TC_CPL_006")) {
				assertTrue(click(driver, btnCancelProblemListEdit),
						"Could not click the Cancel button;More details:"
								+ proData.toString(),driver, className, methodName);
				return true;
			}

			if (proData.testCaseId.equals("TC_QL_001")
					|| (proData.testCaseId.equals("TC_QL_002") || (proData.testCaseId
							.equals("TC_QL_005")))){
				assertTrue(click(driver, chkQuickList),
						"Could not click the Save Quick List check box;More Details:"
								+ proData.toString(),driver, className, methodName);
			waitForPageLoad(driver);}

			if (!proData.testCaseId.equals("TC_CPL_018")) {

				if(isVisible(driver, btnAdd)){
					assertTrue(click(driver, btnAdd),
							"Could not click the add button;More details:"
									+ proData.toString(),driver, className, methodName);
				}else
					assertTrue(click(driver, btnSave1),
							"Could not click the add button;More details:"
									+ proData.toString(),driver, className, methodName);
				waitForPageLoad(driver);
			} else {
				assertTrue(click(driver, btnSaveProblemList),
						"Could not click the add button;More details:"
								+ proData.toString(),driver, className, methodName);
				waitForPageLoad(driver);
			}
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}
	public void clickEditSaveProblemList(){
		click(btnEditSaveProblemList);
		
	}


	/**
	 * createProblemListEndToEnd function to a create Problem List
	 * @param driver,ChartPreVisitLib- Data for Problem List,userAccount
	 * @since  	@since March 12, 2015
	 * @version 2.1
	 */

	public boolean createProblemListEndToEnd(WebDriver driver,ChartPreVisitLib proData, String account)   {
		try {
			String date = "";
			waitForPageLoad(driver);

			if (!proData.medicalCondition1.equals("")){
				verifyTrue(type(driver, txtMedicatl, proData.medicalCondition1), "txtMedicatl not found", driver);
				waitForPageLoad(driver);
			}
			
			if (!proData.onsetDate.equals("")){
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
			waitForPageLoad(driver);
			}

			if (!proData.itemStatus.equals("")){
				verifyTrue(selectValueFromAjaxList(driver, ajxItem, proData.itemStatus), "ajxItem not found", driver);
			waitForPageLoad(driver);
			}

			if (!proData.showAllDetails.equals("")){
				verifyTrue(click(driver, lnkProblemListShowMoreArrow), "lnkProblemListShowMoreArrow not found", driver);
			waitForPageLoad(driver);
			}

			if (!proData.lifeStage.equals("")){
				verifyTrue(selectValueFromAjaxList(driver, ajxlifeStage,proData.lifeStage), "ajxlifeStage not found", driver);
				waitForPageLoad(driver);
			}

			if (!proData.resolvedDate.equals("")){
				if (account.equals(Constants.CAACCOUNT)) {
					verifyTrue(enterDate(driver, txtResolvedDate, date), "txtResolvedDate not found", driver);
				}
				else
				{
					verifyTrue(enterDate(driver, txtResolvedDate, date), "txtResolvedDate not found", driver);
				}
			waitForPageLoad(driver);
			}
			
		/*	if (!proData.codingSystem.equals("")){
				if(isVisible(driver,ajxCodingSystem))
				{
					verifyTrue(selectValueFromAjaxList(driver, ajxCodingSystem,proData.codingSystem), "Coding System not found", driver);
					waitForPageLoad(driver);
				}
			}*/

			if (!proData.diagnosis.equals("")){
				if(isVisible(driver,ajxdiagnosis))
				{
					verifyTrue(selectValueFromAjaxList(driver, ajxdiagnosis, proData.diagnosis), "ajxDiagnosis not found", driver);
					waitForPageLoad(driver);
				}
			}

			if (!proData.comment.equals("")){
				verifyTrue(type(driver, txtcomment, proData.comment), "comment not found", driver);
				waitForPageLoad(driver);
			}

			
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
		return true;
	}
	
	/**
	 * clickSaveSummaryProblemList function to a save Problem List
	 * @since  	@since March 13, 2015
	 * @version 2.1
	 */
	
	public boolean clickSaveSummaryProblemList(WebDriver driver)
	{
		try{
		verifyTrue(click(driver, btnSaveProblemList), "btnSaveProblemList not found", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
		return true;
	}

	
	/**
	 * saveSummaryProblemList function to a create Problem List
	 * @param driver  	
	 * @since March 12, 2015
	 * @version 2.1
	 */
	
	public boolean saveSummaryProblemList(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnAdd), "add button not found", driver);
			waitForPageLoad(driver);
			verifyTrue(click(driver, btnSaveProblemList), "btnSaveProblemList not found", driver);
			waitForPageLoad(driver);
		}
		catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}
	
	/**
	 * saveSummarySocialHistory function to a Social History
	 * @param driver  	
	 * @since May 21, 2015
	 * @version 2.1
	 */
	
	public boolean saveSummarySocialHistory(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnAdd), "add button not found", driver);
			waitForPageLoad(driver);
			verifyTrue(click(driver, btnSaveProblemList), "btn Save Social History not found", driver);
			waitForPageLoad(driver);
		}
		catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}
	
	
	/**
	 * addProblemList function to a click Add button for Problem List
	 * @since  	@since March 13, 2015
	 * @version 2.1
	 */
	
	public boolean addProblemList(WebDriver driver)
	{
		try{
		verifyTrue(click(driver, btnAdd), "add button not found", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		}
		catch (Exception e) {
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
	
	public boolean clickSaveEditProblemList(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnEditSaveProblemList), "edit save button not found", driver);
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

	public boolean clickEditProblemList()
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
	 * goToEditProblemListFromEncounter function to  Edit Problem List from encounter
	 * @since  	@since March 13, 2015
	 * @version 2.1
	 */

	public boolean goToEditProblemListFromEncounter()
	{
		try{
		verifyTrue(click(driver, lblEnProblemList), "lblEnProblemList button not found", driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver, btnEditInEncounter), "Edit button not found", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

		return true;
	}
	
	/**
	 * addEncounterProblemList function to a Click Add button
	 * @param driver
	 * @since March 27, 2015
	 * @version 2.1
	 */
	
	public boolean addEncounterProblemList(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnAdd), "Add button not found", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}
	
	
	
	
	
}
