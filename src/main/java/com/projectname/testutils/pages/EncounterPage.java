package com.projectname.testutils.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.genericutility.testDataLib.SystemSettingsLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;



public class EncounterPage extends SeleniumWebDriver{
	
	private By readyLocator = By.id("!chartEncounters");
	private By btnErrorClose = By.id("errorCloseButton");
	private By btnBeginEncounter = By.id("BeginEncounterButton");
	private By lnkStartNewWncouter =By.id("beginNewEncounter");	
	//FIXME TICKET IN REVIEW
	private By lnkEncounterWidget1 =By.xpath("//body/div[4]/div/div/div[2]/div[2]");
	private By lnkEncounterWidget2 =By.xpath("//body/div[5]/div/div/div[2]/div[2]");
	private By lnkEncounterWidget3 =By.xpath("//div[4]/div/div/div[2]/div[2]");
		private By lnkEncounterWizard =By.xpath("//a[@class='wizard-step-circle']");
	private By lnkEncounterAction =By.id("actionAnchorEncounter");
	private By lnkAssignTask = By.id("assignTask");
	private By ajxContactMode =By.id("contactModesuggestBox");
	
	//FIXME VEL -8447
	private By lnkProvider =By.xpath("//div[@id='encounterNote']/div[3]/div/div/div/div[5]/a");
	
	private By lblEncounterSave = By.xpath("//a[@id='saveEncounter']/span");
	private By lblEncounterCancel = By.xpath("//a[@id='cancelEncounter']/span");
	private By btnSign=By.id("sign");
	private By ajxProviderSugBox=By.id("providersuggestBox");
	private By lnkTopMenu=By.id("username");
	private By lnkEncounterAllergy = By.id("4");
	private By lnkEncounterProcedure = By.id("2");
    private By btnAllergyEdit=By.xpath("//a[contains(text(),'Edit')]");
    private By iconPresMedi=By.xpath("//img[@title='Prescribe Medication']");
	private By lnkMore=By.linkText("More");
	private By lnkToManagedCare=By.xpath("//a[2]/span");
	private By btnAddNew=By.id("addNewButton");
	private By ajxNameMedication = By.id("suggestBox");
	private By txtBaseLineDate = By.id("baselineDate");
	private By btnTemplateSave=By.id("saveButton");
	private By ajxCosignSuggestBox= By.id("coSignSuggestBoxsuggestBox");
	private By btnSaveCosign=By.id("saveReason");
	private By btnYes = By.id("yesButton");
    private By numbericWidgetDescription=By.xpath("//*[contains(@id,'numericWidgetdescription')]");
	private By titleWidget=By.xpath("//*[contains(@id,'labelTitleRender')]");
	private By lnkEncounterProblemlist=By.xpath("(//a[contains(text(),'Problem List')])[2]");
	private By txtFreeTextWidget = By.xpath("//*[contains(@id,'freeTextdescription')]");
	private By txtFreeTextWidgetNew = By.xpath("//*[contains(@id,'freeTextdescription')]");
	private By txtNumericWidget = By.xpath("//*[contains(@id,'numericWidgetvalue')]");
	private By txtNumericWidgetComment = By.xpath("//*[contains(@id,'numericWidgetdescription')]");
	private By chkQuestionWidget = By.xpath("//*[contains(@id,'ansChkBoxQueRenderDiv')]");
	private By txtScoreone=By.xpath("(//input[contains(@id,'AssToolRenderTextArea')])[1]");
	private By txtScoretwo=By.xpath("(//input[contains(@id,'AssToolRenderTextArea')])[2]");
	private By txtScoretextarea=By.id("urlTextArea");	
	private By ajxThirdQuestion=By.xpath("(//input[@id='suggestBox'])[4]");
	private By txtthiredqustextarea=By.xpath("(//textarea[@id='description'])[3]");
	private By txtFourthquetextarea=By.xpath("(//textarea[@id='description'])[4]");
	private By txtToDate = By.xpath("//*[contains(@id,'dateRange')]");
	private By txtDateComment=By.xpath("//*[contains(@id,'additionalDateInfoTextArea')]");
	private By ajxAssessmentSearch= By.id("assessmentSearchBox");
	private By chkReuseQuestionWidget = By.xpath("(//input[@id='ansChkBoxQueRenderDiv2'])[2]");
	private By chkcancelcheckboxfour=By.xpath("(//input[@id='ansChkBoxQueRenderDiv1'])[2]");
	private By txtFromDate = By.xpath("(//input[contains(@id,'date')])[2]");
	private By txtReuseNumericTextBox=By.xpath("(//*[contains(@id,'numericWidgetdescription')])[2]");
	private By txtReuseNumericWidget=By.xpath("(//*[contains(@id,'numericWidgetvalue')])[2]");
	private By ajxQuestionWidget = By.xpath("(//input[@id='suggestBox'])[2]");
	private By txtReuseFreeText=By.xpath("(//*[contains(@id,'freeTextdescription')])[2]");	   
	private By btnEditAssessment=By.id("edit");
	private By lnkQuestionWidget=By.id("clickToSelect");
	private By chkAnswer1=By.id("1checkbox");
	private By chkAnswer2=By.id("2checkbox");
	private By chkAnswer3=By.id("3checkbox");	
	private By chkAnswer4=By.id("4checkbox");
	private By chkAnswer5=By.id("5checkbox");
	private By btnCloseSelection=By.id("multiSelectionCloseButton");
	private By txtQuestionWidgetComment=By.id("description");
	private By txtSecondQuestionWidgetComment=By.xpath("(//textarea[@id='description'])[2]");
	private By ajxComplaintBox=By.id("chiefComplaintBox");	
	private By lnkAssessmentCreated= By.xpath("//span[contains(@id,'problems')]");	
	private By chkFifthquesanswer=By.xpath("(//input[@id='ansChkBoxQueRenderDiv2'])[3]");
	private By txtEncounterDate = By.xpath("(//input[contains(@id,'date')])[1]");
	private By txtReuseNumericTextBox3=By.xpath("(//*[contains(@id,'numericWidgetdescription')])[3]");
	private By txtReuseNumericWidget3=By.xpath("(//*[contains(@id,'numericWidgetvalue')])[3]");
	// Order New Labs
	private By chkCancelSecondbox=By.id("ansChkBoxQueRenderDiv2");
	private By imgOrderNewLabs = By.xpath("//img[@title='Order New Labs']");
    private By lnkOrderNewLab = By.id("encLabAction");
    private By lnkViewOrderNewLab = By.id("//a[@id='view']");
    private By textValueDecimal=By.xpath("(//input[contains(@id,'numericWidgetvalue')])[2]");
    private By question3Description=By.xpath("(//textarea[@id='description'])[7]");
    private By question4Description=By.xpath("(//textarea[@id='description'])[8]");
    private By txtFreetextComponenet=By.xpath("//textarea[contains(@id,'CustomComponentFreeText')]");
	private By txtFreetextSection=By.xpath("(//textarea[contains(@id,'generic')])[13]");
	private By question2DescriptionEdit=By.xpath("(//textarea[@id='description'])[6]");
	private By radioButtonQuestion4=By.xpath("(//input[@id='ansChkBoxQueRenderDiv2'])[4]");
    private By txtFreeTextWidgetEdit = By.xpath("(//textarea[contains(@id,'freeTextdescription')])[2]");
    private By numbericWidgetDescriptionEdit=By.xpath("(//textarea[contains(@id,'numericWidgetdescription')])[2]");
    private By ajxQuestionWidgetEdit= By.linkText("Click to select");
    private By txtQuestionWidgetCommentEdit=By.xpath("(//textarea[@id='description'])[5]");
    private By ajxQuestionThird=By.xpath("(//input[@id='suggestBox'])[3]");
    private By question3AnswerAjaxList=By.xpath("(//input[@id='suggestBox'])[8]"); 
    private By ajxProviderSuggBox=By.id("referralSearchBox");
    private By chkfifthquestionreuseAns=By.xpath("(//input[@id='ansChkBoxQueRenderDiv1'])[4]");
    private By lnkVitalsPage = By.xpath("(//a[contains(text(),'VITALS')])[2]");
    public By lnkEncounterInjection = By.xpath("(//a[contains(text(),'Injections')])[2]");			
    private By lnkMedicationsPage = By.xpath("(//a[contains(text(),'Medications')])[2]");
    private By lnkMedicationsSummaryPage = By.id("MedicationTitle");
    private By lnkMedicationDrug = By.id("drugName");
    private By lnkRemoveMedication = By.id("delete");
    
    public By btnEncounterEditProblemList = By.xpath("//span[contains (@id,'problems_')]");
    private By btnEncounterEditInjection=By.xpath("//span[contains (@id,'injection')]");
    private By lnkRemoveProblemList = By.id("delete");
    private By lnkRemoveInjection=By.id("delete");
	public By btnEditInEncounter = By.id("edit");

	public By lnkDeleteEncounterImmunization = By.xpath("//span[contains (@id,'immunization_')]");
	private By lnkRemoveImmunization = By.id("delete");
	
	private By lnkEncounterVitals = By.xpath("(//a[contains(text(),'VITALS')])[2]");
	private By lnkEncounterImmunization = By.xpath("(//a[contains(text(),'Immunizations')])[2]");
	private By imgReferralIcon = By.xpath("//img[@title='Add New Referral']");
	private By image = By.cssSelector("image");
	private By selectanserlabel=By.xpath("//*[contains(@class,'gwt-CheckBox checkBoxSelectEntry checkbox-group')]");
	private By imgDIOrder = By.xpath("//img[@title='Order New Diagnostic Imaging']");
	private By lblDiordere = By.xpath("(//span[contains(@id,'lineTitle')])[2]");
	private By txtEdit = By.xpath("//a[@id='edit']/span");

	
	private By lnkPostCharge = By.linkText("link=Post");
	
	

	private By lnkUploadImage = By.xpath("//button[@id='imageBrowseButton-browse-anchor']");
	private By lnkDeleteImage = By.cssSelector("a.gwt-Anchor > span.delete-button");
	private By lnkEncounterFamilyHistory = By.xpath("(//a[contains(text(),'Family History')])[2]");
	
	private By lnkSocialHistoryEncounter = By.xpath("(//a[contains(text(),'Social History')])[2]");
	
	private By lnkSocialHistoryExpandArrow = By.xpath("(//a[contains(@Id,'socialHistoryExpandAnchor')])");

	private By lblRecAndPlanItem = By.xpath("//span[contains(@id,'lineTitle')]/span");
	
	/***
		/***
	 * Call to super constructor
	 */
	public EncounterPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	public boolean beginEncounter(WebDriver driver)  {
		try {
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			//String onBehalfOf= provider.replaceAll(", "+orderData.switchRole, "");
			//String location = "";
			if(isElementPresent(driver, btnErrorClose))
				assertTrue(click(driver, btnErrorClose),"Could not click on Close Button",driver, className, methodName);
			if (isElementPresent(driver, btnBeginEncounter)) {	

			
				//Continue
				// if (isElementPresent(driver, lblEncounterChoosePanel)) {
				if (isElementPresent(driver, lnkStartNewWncouter)) {
					waitForPageLoad(driver);
					click(driver, lnkStartNewWncouter);
				} else if (isElementPresent(driver,
						lnkEncounterWidget1)) {
					click(driver,lnkEncounterWidget1);
				} else if (isElementPresent(driver,
						lnkEncounterWidget2)) {
					click(driver, lnkEncounterWidget2);
				} else if (isElementPresent(driver,
						lnkEncounterWidget3)) {
					click(driver, lnkEncounterWidget3);
				} //else if(isVisible(driver,lnkEncounterWidget4)){
					//click(driver,lnkEncounterWidget4);
				//}
				waitForPageLoad(driver);
				// }
				if (isElementPresent(driver,lnkEncounterWizard)) {
					click(driver,lnkEncounterWizard);
				}
				if(isElementPresent(driver, btnErrorClose))
				{
					assertTrue(click(driver, btnErrorClose),"Could not click on Close Button",driver, className, methodName);
				}
				waitForPageLoad(driver);
				assertTrue(
						isElementPresent(driver, lnkEncounterAction),
						"Sign button is not present",driver, className, methodName);
				if(isAlertPresent(driver)){
					alertAccept(driver);
				}
				if(isVisible(driver,ajxContactMode))
				{
					selectValueFromAjaxList(driver,ajxContactMode,"Scheduled");	
				}
				
				if(isVisible(driver,ajxProviderSugBox))
				{ String providerNameTemp= getText(driver, lnkTopMenu);

				if(providerNameTemp.toLowerCase().contains(" biller"))
				{
				String providerName= providerNameTemp.replaceAll(", BILLER", "");

				String tempArray[]=providerName.split(" ");
				String pName=tempArray[1]+", "+tempArray[0];
				selectValueFromAjaxList(driver,ajxProviderSugBox,pName);	
				}
				else{
				String providerName= providerNameTemp.replaceAll(", FULL", "");

				String tempArray[]=providerName.split(" ");
				String pName=tempArray[1]+", "+tempArray[0];
				selectValueFromAjaxList(driver,ajxProviderSugBox,pName);	
				}			

				}

			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
	public boolean beginEncounterReferral(WebDriver driver,ChartPreVisitLib referralData)  {
		try {
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			if(isElementPresent(driver, btnErrorClose))
				verifyTrue(click(driver, btnErrorClose),"Could not click on Close Button",driver);
			if (isElementPresent(driver, btnBeginEncounter)) {	

				//Continue
			
				if (isElementPresent(driver, lnkStartNewWncouter)) {
					waitForPageLoad(driver);
					click(driver, lnkStartNewWncouter);
				} else if (isElementPresent(driver,
						lnkEncounterWidget1)) {
					click(driver,lnkEncounterWidget1);
				} else if (isElementPresent(driver,
						lnkEncounterWidget2)) {
					click(driver, lnkEncounterWidget2);
				} else if (isElementPresent(driver,
						lnkEncounterWidget3)) {
					click(driver, lnkEncounterWidget3);
				} 
				waitForPageLoad(driver);

				if (isElementPresent(driver,lnkEncounterWizard)) {
					click(driver,lnkEncounterWizard);
				}
				if(isElementPresent(driver, btnErrorClose))
				{
					verifyTrue(click(driver, btnErrorClose),"Could not click on Close Button",driver);
				}
				waitForPageLoad(driver);
				verifyTrue(
						isElementPresent(driver, lnkEncounterAction),
						"Sign button is not present",driver);
				if(isAlertPresent(driver)){
					alertAccept(driver);
				}
				if(isVisible(driver,ajxContactMode))
				{
					verifyTrue(selectValueFromAjaxList(driver,ajxContactMode,"Scheduled"),"Could select mode",driver);
				}
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				
				if(isVisible(driver,lnkProvider))
				{ 
					verifyTrue(click(driver,lnkProvider),"Could link provider link",driver);
					waitForPageLoad(driver);
					if(isVisible(driver,ajxProviderSugBox))
					verifyTrue(selectValueFromAjaxList(driver,ajxProviderSugBox,referralData.referral1),"Could select referral",driver);
					waitForPageLoad(driver);
				}			

			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	
	/**
	 * goToAssignTask
	 * function to  go To Assign Task
	 * param driver
	 * @since  	Mar 20, 2015
	 * @version 2.1
	 */	
	public boolean goToAssignTask (WebDriver driver)
	{
		verifyTrue(click(driver,lnkEncounterAction),"Could not click the Patient Options link", driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver,lnkAssignTask),"Could not click the Assign Task link", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);

		return true;
	}
	
	/**
	 * goToEncounterImmunization
	 * function to  go To Encounter Immnization
	 * param driver
	 * @since  	Mar 25, 2015
	 * @version 2.1
	 */	
	public ImmunizationPage goToEncounterImmunization (WebDriver driver)
	{
		verifyTrue(click(driver,lnkEncounterImmunization),"Could not click the Encounter Immnization link", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);

		return new ImmunizationPage();
	}

	
	/**
	 * goToEncounterVitals
	 * function to  go To Encounter Vitals
	 * param driver
	 * @since  	Mar 25, 2015
	 * @version 2.1
	 */	
	public VitalsPage goToEncounterVitals (WebDriver driver)
	{
		verifyTrue(click(driver,lnkEncounterVitals),"Could not click the Encounter Vitals link", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);

		return new VitalsPage();
	}

	
	/**
   	 * saveAddedEncounterMedications
   	 * Function to Save Added Encounter Medications
   	 * @param 	driver
   	 * @param  medicationsPage
   	 * @since  	Mar 23, 2015
   	 * @version 2.1
   	 */	

   	public void saveAddedEncounterMedications(WebDriver driver,MedicationsPage medicationsPage){
   		try{
   			medicationsPage.saveAddedEncounterMedications(driver);
   	       
   		}catch (Exception e) {
   		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   	    }
   		
   	}
	
	/**
	 * navigateToReferralLetterPage function to navigate to Referral Letter Page
	 * @param driver
	 * @since  	@since April 24, 2015
	 * @version 2.1
	 */

	public ReferralLetterPage navigateToReferralLetterPage(WebDriver driver) throws IOException {
	try{
		
		verifyTrue(click(driver,imgReferralIcon),"Could not click the referral order button", driver);		
		waitForPageLoad(driver);
		waitForPageLoad(driver);

	} catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	}

		return new ReferralLetterPage();
	}

	/**
	 * addNewReferralLetter function to add Referral Letter
	 * @param driver
	 * @param ChartPreVisitLib - referralData
	 * @param referralLetterPage
	 * @since  	@since April 27, 2015
	 * @version 2.1
	 */
	
	public boolean addNewReferralLetter(WebDriver driver, ChartPreVisitLib referralData, ReferralLetterPage referralLetterPage) throws IOException {

		referralLetterPage.addNewReferralLetter(driver, referralData);
		return true;
	}
	
	/**
	 * verifyMultipleProviderNamesInReferralSuggestBox function to verify Multiple Provider Names In Referral SuggestBox
	 * @param driver
	 * @param ChartPreVisitLib - referralData
	 * @param referralLetterPage
	 * @since  	@since April 27, 2015
	 * @version 2.1
	 */
	
	public boolean verifyMultipleProviderNamesInReferralSuggestBox(WebDriver driver, SystemSettingsLib providerData, String provdata, int count, ReferralLetterPage referralLetterPage) throws IOException {

		try{
			referralLetterPage.verifyMultipleProviderNamesInReferralSuggestBox(driver, providerData, provdata, count);
			waitForPageLoad(driver);

		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
	
		return true;
	}	
	
	/**
	 * verifyPracticeInReferralSuggestBox function to verify Practice Name In Referral SuggestBox
	 * @param driver
	 * @param ChartPreVisitLib - referralData
	 * @param referralLetterPage
	 * @since  	@since April 24, 2015
	 * @version 2.1
	 */
	
	public boolean verifyPracticeInReferralSuggestBox(WebDriver driver, SystemSettingsLib pracData, SystemSettingsLib providerData, ReferralLetterPage referralLetterPage) throws IOException {

		try{
			referralLetterPage.verifyPracticeInReferralSuggestBox(driver, pracData, providerData);
			waitForPageLoad(driver);

		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
	
		return true;
	}	

	/**
	 * verifyHeadIconInSearch function to verify HeadIcon In Search Referral SuggestBox
	 * @param driver
	 * @param ChartPreVisitLib - referralData
	 * @param SystemSettingsLib - providerData
	 * @param referralLetterPage
	 * @since  	@since April 29, 2015
	 * @version 2.1
	 */
	
	public boolean verifyHeadIconInSearch(WebDriver driver, ChartPreVisitLib referralData, ReferralLetterPage referralLetterPage) throws IOException {

		try{
			referralLetterPage.verifyHeadIconInSearch(driver, referralData);
			waitForPageLoad(driver);
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
	
		return true;
	}	

	/**
	 * verifyLetterContents function to verify Letter Contents in Referral Letter Page
	 * @param driver
	 * @param referralLetterPage
	 * @param ChartPreVisitLib - referralData
	 * @param String - defaultTemplateName
	 * @since  	@since April 28, 2015
	 * @version 2.1
	 */

	public boolean verifyLetterContents(WebDriver driver, ChartPreVisitLib referralData, String defaultTemplateName, ReferralLetterPage referralLetterPage) throws IOException {
	try{
		referralLetterPage.verifyLetterContents(driver, referralData, defaultTemplateName);
		waitForPageLoad(driver);

	} catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	}
		return true;
	}


    public boolean VerifyDefaultTemplateInEncounterNote(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)
    {try{
    	waitForPageLoad(driver);
	   waitForPageLoad(driver);
	   waitForPageLoad(driver);
    	System.out.print(driver.findElement(By.tagName("body")).getText());
 	   scrollDown(driver);
	   assertTrue(isTextPresent(driver,encounterTemplateTestData.ComponenetName),"", driver, className, methodName); 	
	   assertTrue( isTextPresent(driver,encounterTemplateTestData.SectionName.toUpperCase()),"", driver, className, methodName);
	   assertTrue( isTextPresent(driver,encounterTemplateTestData.FreeTextLabel),"", driver, className, methodName);
	   assertTrue( isTextPresent(driver,encounterTemplateTestData.NumericLabel),"", driver, className, methodName);
	   assertTrue( isTextPresent(driver,encounterTemplateTestData.QuestionLabel),"", driver, className, methodName);
	   assertTrue( isTextPresent(driver,encounterTemplateTestData.QuestionLabel1),"", driver, className, methodName);
	   assertTrue( isTextPresent(driver,encounterTemplateTestData.QuestionLabel3),"", driver, className, methodName);
	   assertTrue( isTextPresent(driver,encounterTemplateTestData.QuestionLabel4),"", driver, className, methodName);
	   assertTrue( isTextPresent(driver,encounterTemplateTestData.scorefieldone),"", driver, className, methodName);
	   assertTrue( isTextPresent(driver,encounterTemplateTestData.scorefieldtwo),"", driver, className, methodName);
	   assertTrue( isTextPresent(driver,encounterTemplateTestData.datelabel),"", driver, className, methodName);
	   assertTrue( isTextPresent(driver,encounterTemplateTestData.TitleLabel.toUpperCase()),"", driver, className, methodName);
	   assertTrue( isTextPresent(driver,encounterTemplateTestData.instructionWidget),"", driver, className, methodName);
	   assertTrue( isTextPresent(driver,encounterTemplateTestData.assessment),"", driver, className, methodName);
	 
    }
    catch(Exception e){
    	  assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
    }
    return true;
    }
    
    public boolean verifyDeletedWidgetsInNote(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)
    {
   try{
	   assertTrue(!isTextPresent(driver,encounterTemplateTestData.FreeTextLabel),"FreeTextLabel is not present",driver, className, methodName);
	   assertTrue(!isTextPresent(driver,encounterTemplateTestData.NumericLabel),"NumericLabel is not present",driver, className, methodName);
	   
   }
   catch(Exception e){
	   assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

   }
   return true;
    }
    
    /**
     * saveAddedSummaryMedications
     * Function to Save Added summary Medications
     * @param 	driver
     * @param  medicationsPage
     * @since  	Mar 24, 2015
     * @version 2.1
     */	

    public void saveAddedSummaryMedications(WebDriver driver,MedicationsPage medicationsPage){
    	medicationsPage.saveAddedSummaryMedications(driver);

    }
    /**
     * verifyAlertProblemListItemDeleted
     * Function to Verify Alert Message ProblemList Item Deleted
     * @param 	driver
     * @throws Exception 
     * @since	March 23,2015
     * @version 2.1
     */  
    public void verifyAlertProblemListItemDeleted(WebDriver driver)
    {
    	try{
    	assertTrue(isTextPresent(driver,"This record is not available anymore. It was deleted"),"Alert Message not found",driver,className,methodName);
    	}catch (Exception e) {
			  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		    }
	
    }
   
    public boolean typeFreeTextInEncounter(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,String date) 
    {
    	try{
    	assertTrue(type(driver,txtFreeTextWidgetNew,encounterTemplateTestData.freeTextComment),"Could not type reason ;More Details",driver, className, methodName);
    	}
    	catch(Exception e)
    	{
	assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
    	}

    	return true;
    }
  
    /**
	 * Record Values In Encounter Note Widgets
	 * function to   Record Values In Encounter Note Widgets
	 * @param driver
	 * @param encounterPage- Page
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */	
    
    public boolean recordWidgetsInEncounterNote(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,String date) 
    {
    	try{
    		By txtsectionlabel=By.id(encounterTemplateTestData.SectionName);
    		verifyTrue(	type(driver,txtFreeTextWidget,encounterTemplateTestData.freeTextComment),"Could not type", driver);
    		verifyTrue(	type(driver,txtNumericWidgetComment,encounterTemplateTestData.numericWidgetComment),"Could not type", driver);    	
    		verifyTrue(	selectanserfrommultiplecheckbox(driver,lnkQuestionWidget,encounterTemplateTestData.Answer4),"Could not select ansers ", driver);
    		//verifyTrue(selectValueFromAjaxList(driver,ajxQuestionWidget,encounterTemplateTestData.Answer4),"Could not Select", driver);
    		verifyTrue(type(driver,txtQuestionWidgetComment,encounterTemplateTestData.questionWidgetComment),"Could not type", driver);
    		verifyTrue(type(driver,txtSecondQuestionWidgetComment,encounterTemplateTestData.QuestionWidgetComment1),"Could not type", driver);
    		verifyTrue(click(driver, chkQuestionWidget),"Could not Click", driver);
    		verifyTrue(type(driver,txtFromDate,encounterTemplateTestData.fromDate),"Could not type", driver);
    		verifyTrue(type(driver,txtToDate,encounterTemplateTestData.toDate),"Could not type", driver);
    		verifyTrue(type(driver,txtDateComment,encounterTemplateTestData.dateComment),"Could not type", driver);
    		verifyTrue(selectValueFromAjaxList(driver,ajxQuestionWidget,encounterTemplateTestData.answer12),"Could not select question widget values", driver);
    		verifyTrue(type(driver,txtthiredqustextarea,encounterTemplateTestData.questionWidgetComment3),"Could not type answers", driver);
    		verifyTrue(click (driver,chkReuseQuestionWidget),"Could not Click question widget", driver);
    		verifyTrue(type(driver,txtFourthquetextarea,encounterTemplateTestData.questionWidgetComment4),"Could not type fourth question widget", driver);
    		verifyTrue(type(driver,txtScoreone,encounterTemplateTestData.scorefieldone),"Could not type score", driver);
    		verifyTrue(type(driver,txtScoretwo,encounterTemplateTestData.scorefieldtwo),"Could not type score two", driver);
    		verifyTrue(type(driver,txtScoretextarea,encounterTemplateTestData.assessmenttextbox),"Could not type input area", driver);
    		verifyTrue(type(driver,txtFreetextComponenet,encounterTemplateTestData.freetextcomponent),"Could not type free text component", driver);
    		verifyTrue(type(driver,txtsectionlabel,encounterTemplateTestData.freetextsectionnote),"Could not type free text component", driver);
    		verifyTrue(type(driver,txtNumericWidget,encounterTemplateTestData.numericWidgetValue),"Could not numeric widget value  type", driver);
    		Thread.sleep(3000);
		    	
    	}
    	 catch(Exception e)
    	{
    	     new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
    	}
		
		return true;
    }

    /**
	 * Record Values In Encounter Note Widgets
	 * function to   Record Values In Encounter Note Widgets
	 * @param driver
	 * @param encounterPage- Page
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */	
    
    public boolean recordValuesForWidgetsInEncounter(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,String date) 
    {
    	try
    	{
    	type(driver,txtFreeTextWidget,encounterTemplateTestData.freeTextComment);
		type(driver,txtNumericWidgetComment,encounterTemplateTestData.numericWidgetComment);
		selectValueFromAjaxList(driver,ajxQuestionWidget,encounterTemplateTestData.Answer4);
		waitForPageLoad(driver);
		type(driver,txtQuestionWidgetComment,encounterTemplateTestData.questionWidgetComment);
		type(driver,txtSecondQuestionWidgetComment,encounterTemplateTestData.QuestionWidgetComment1);
		click(driver, chkQuestionWidget);	
		type(driver,txtFromDate,encounterTemplateTestData.fromDate);
		type(driver,txtToDate,encounterTemplateTestData.toDate);
		type(driver,txtDateComment,encounterTemplateTestData.dateComment);	
		selectValueFromAjaxList(driver,ajxThirdQuestion,encounterTemplateTestData.Answer3);
		type(driver,txtthiredqustextarea,encounterTemplateTestData.questionWidgetComment3);
		click (driver,chkReuseQuestionWidget);
		type(driver,txtFourthquetextarea,encounterTemplateTestData.questionWidgetComment4);
		type(driver,txtScoreone,encounterTemplateTestData.scorefieldone);
		type(driver,txtScoretwo,encounterTemplateTestData.scorefieldtwo);
		type(driver,txtScoretextarea,encounterTemplateTestData.assessmenttextbox);
		type(driver,txtNumericWidget,encounterTemplateTestData.numericWidgetValue);
		Thread.sleep(3000);
    	}
    	catch(Exception e)
         {
     new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
          }
    	return true;
    }
    
    public boolean recordWidgetsDeletedWidgetEncounterNote(WebDriver driver)  
    {
    	
  try{
	  		assertTrue(type(driver,txtFreeTextWidget,"Deleted Widget free text"),"Could not type reason ;More Details",driver, className, methodName);
       	 	assertTrue(type(driver,txtNumericWidgetComment,"Deleted Widget in Numeric widget"),"Could not type reason ;More Details",driver, className, methodName);
      	 	waitForPageLoad(driver);
  }
catch(Exception e)
{
	assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
}
  

    	return true;
    }
    
    
    

    /**
	 * Record Values In Encounter Note For Cancel Operation 
	 * function to  Record Values In Encounter Note For Cancel Operation 
	 * @param driver
	 * @param encounterPage- Page
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */	
    
    public boolean recordWidgetsforcancelEncounter(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,String date)  
    {   	 encounterTemplateTestData.scorefieldone="2";
    	encounterTemplateTestData.scorefieldtwo="3";
    	encounterTemplateTestData.fromDate="01/01/2013";
    	encounterTemplateTestData.toDate="03/01/2013";
    	type(driver,txtFreetextSection,encounterTemplateTestData.freetextsectionnote);
    	type(driver,txtFreeTextWidget,encounterTemplateTestData.freeTextComment);
		type(driver,txtNumericWidgetComment,encounterTemplateTestData.numericWidgetComment);
		selectValueFromAjaxList(driver,ajxQuestionWidget,encounterTemplateTestData.Answer2);
		type(driver,txtQuestionWidgetComment,encounterTemplateTestData.questionWidgetComment);
		type(driver,txtSecondQuestionWidgetComment,encounterTemplateTestData.QuestionWidgetComment1);
		click(driver, chkCancelSecondbox);	
		type(driver,txtFromDate,encounterTemplateTestData.fromDate);
		type(driver,txtToDate,encounterTemplateTestData.toDate);
		type(driver,txtDateComment,encounterTemplateTestData.dateComment+"cancel");	
		selectValueFromAjaxList(driver,ajxThirdQuestion,encounterTemplateTestData.Answer2);
		type(driver,txtthiredqustextarea,encounterTemplateTestData.questionWidgetComment3);
		click (driver,chkcancelcheckboxfour);
		type(driver,txtFourthquetextarea,encounterTemplateTestData.questionWidgetComment4);
		type(driver,txtScoreone,encounterTemplateTestData.scorefieldone);
		type(driver,txtScoretwo,encounterTemplateTestData.scorefieldtwo);
		type(driver,txtScoretextarea,encounterTemplateTestData.assessmenttextbox);
		type(driver,txtFreetextComponenet,encounterTemplateTestData.freetextcomponent);
		type(driver,txtNumericWidget,encounterTemplateTestData.QuestionAnswer);
    	return true;
    }

    
    /**
	 * Verify Recorded Values In Encounter Note Edit Mode 
	 * function to  	Verify Recorded Values In Encounter Note Edit Mode
	 * @param driver
	 * @param encounterPage- Page
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */	
    
    public boolean verifyRecordedWidgetInEditMode(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)
	   {
    	try{
    	waitForPageLoad(driver); 
    	 By chkDefaultansinSecondQuestionwidget=By.xpath("(//*[contains(@id,'ansChkBoxQueRenderDiv')])[3]");
    	if(!(getValue(driver,txtNumericWidget).contains(encounterTemplateTestData.numericWidgetValue)))
    			{
    	 	driver.findElement(txtNumericWidget).sendKeys("2");
    			}
    		scrollDown(driver);
    		  assertTrue( getValue(driver,txtFreeTextWidget).contains(encounterTemplateTestData.freeTextComment),"", driver, className, methodName);
    		  assertTrue(getValue(driver,txtNumericWidget).contains(encounterTemplateTestData.numericWidgetValue),"", driver, className, methodName);
    		  assertTrue(getValue(driver,txtNumericWidgetComment ).contains(encounterTemplateTestData.numericWidgetComment),"", driver, className, methodName);
    		  assertTrue(getText(driver, lnkQuestionWidget ).contains(encounterTemplateTestData.Answer4),"", driver, className, methodName);
    		  assertTrue(getValue(driver,txtQuestionWidgetComment).contains( encounterTemplateTestData.questionWidgetComment),"", driver, className, methodName);
    		  assertTrue(getValue(driver,txtSecondQuestionWidgetComment).contains( encounterTemplateTestData.QuestionWidgetComment1),"", driver, className, methodName);
    		  assertTrue(getValue(driver,txtFromDate ).contains(encounterTemplateTestData.fromDate),"", driver, className, methodName);
    		  assertTrue(getValue(driver, txtToDate ).contains(encounterTemplateTestData.toDate),"", driver, className, methodName);
    		  assertTrue(getValue(driver, txtDateComment ).contains(encounterTemplateTestData.dateComment),"", driver, className, methodName);
    		  assertTrue(getValue( driver,txtSecondQuestionWidgetComment).contains(encounterTemplateTestData.QuestionWidgetComment1),"", driver, className, methodName);
    		  assertTrue(isChecked(driver, chkQuestionWidget),"", driver, className, methodName);
    		  assertTrue(isChecked(driver, chkDefaultansinSecondQuestionwidget),"Default answer is not checked in question with three answers ", driver, className, methodName);
    		  assertTrue(getValue(driver,ajxQuestionWidget).contains(encounterTemplateTestData.answer12),"", driver, className, methodName);
    		  assertTrue(getValue(driver,txtthiredqustextarea).contains(encounterTemplateTestData.questionWidgetComment3),"", driver, className, methodName);
    		  assertTrue(isChecked (driver,chkReuseQuestionWidget),"", driver, className, methodName);
    		  assertTrue(getValue(driver,txtFourthquetextarea).contains(encounterTemplateTestData.questionWidgetComment4),"", driver, className, methodName);
    		  assertTrue(getValue(driver,txtScoreone).contains(encounterTemplateTestData.scorefieldone),"", driver, className, methodName);
    		  assertTrue(getValue(driver,txtScoretwo).contains(encounterTemplateTestData.scorefieldtwo),"", driver, className, methodName);
    		  assertTrue(getValue(driver,txtScoretextarea).contains(encounterTemplateTestData.assessmenttextbox),"", driver, className, methodName);
    		  assertTrue(getValue(driver,txtFreetextComponenet).contains(encounterTemplateTestData.freetextcomponent),"", driver, className, methodName);
    		  assertTrue(getValue(driver,txtFreetextSection).contains(encounterTemplateTestData.freetextsectionnote),"", driver, className, methodName);
    	}
    	catch(Exception e)
    	{
    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);	
    	}
		   return true;
	   }
    
    /**
	 * enter encounter date
	 * function to enter encounter date
	 * @param driver
	 * @param encounterPage- Page
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */	
    public boolean enterencounterdate(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)
    {
    	  type(driver,txtEncounterDate,encounterTemplateTestData.encounterdate);
		return true;
    	
    }
    
    
    public boolean scrollDown(WebDriver driver)
    {
    	try{
    		
    By scroll=By.xpath("//*[@id='encounterNote']/div[3]");
  	WebElement scrollUp = driver.findElement(scroll);
  	scrollUp.sendKeys(Keys.PAGE_DOWN);
   	scrollUp.sendKeys(Keys.PAGE_DOWN);
  	scrollUp.sendKeys(Keys.PAGE_DOWN);
  	scrollUp.sendKeys(Keys.PAGE_DOWN);
  	scrollUp.sendKeys(Keys.PAGE_DOWN);
 	waitForPageLoad(driver); 
  	scrollUp.sendKeys(Keys.PAGE_DOWN);
  	scrollUp.sendKeys(Keys.PAGE_DOWN);
  	scrollUp.sendKeys(Keys.PAGE_DOWN);
 	waitForPageLoad(driver); 
    	}
    	catch(Exception e)
    	{
    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

    	}
		return true;
    	
    	
    }
    public boolean verifyRecordedWidgetvalueInDeletedwidgets(WebDriver driver)
	   {
    	try{
    		  assertTrue(getValue(driver,txtFreeTextWidget).contains("Deleted Widget free text"),"freeTextComment is not present",driver, className, methodName);
    	 	   assertTrue(getValue(driver,txtNumericWidgetComment ).contains("Deleted Widget in Numeric widget"),"numericWidget comment is not present",driver, className, methodName);
    	}
    	catch(Exception e)
    	{
    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
    	}
 	 
		return true;
	   }
    
    
    /**
     * Verify Cancelled Allergy In Summary
     * Function to Verify Cancelled Allergy In Summary
     * @param 	driver
     * @param 	encounterPage
     * @param 	labOrderPage
     * @throws  Exception 
     * @since	Jan 29,2015
     */
    public boolean verifycancelledAllergyInNote(WebDriver driver,ChartPreVisitLib allergyData,ChartPreVisitLib proData ,String account)
	{
		try{
			if (account.equals("CA2000"))	
			{
	    		assertTrue(!isTextPresent(driver,allergyData.allergenCa),"allergen is not present",driver, className, methodName);
	    		assertTrue(!isTextPresent(driver,proData.medicalCondition1),"allergen is not present",driver, className, methodName);
			}
	    	else
	    	{
		    	assertTrue(!isTextPresent(driver,allergyData.allergen),"allergen is not present",driver, className, methodName);
		    	assertTrue(!isTextPresent(driver,proData.medicalCondition1),"allergen is not present",driver, className, methodName);
	    	}
		
		}
		catch(Exception e)
		{
	Assert.fail();
		}
		return true;
	}
    /**
	 * saveEncounter
	 * function to save encounter
	 * @param driver
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */	
	public boolean saveEncounter (WebDriver driver)
{
	try{
	verifyTrue(click(driver, lnkEncounterAction),"Could not click the Action button in Encounter note", driver);	
	waitForPageLoad(driver);
	verifyTrue(click(driver, lblEncounterSave),"Could not click the Save link under encounter Action", driver);	
	waitForPageLoad(driver);
	waitForPageLoad(driver);
    }catch(Exception e){
       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
}  
	return true;
}
    
    public boolean cancelEncounter (WebDriver driver)
    {
    	waitForPageLoad(driver);
    	assertTrue(click(driver, lnkEncounterAction),"Could not click the Action button in Encounter note", driver, className, methodName);	
		waitForPageLoad(driver);
		assertTrue(click(driver, lblEncounterCancel),"Could not click the Cancel link under encounter Action", driver, className, methodName);	
		waitForPageLoad(driver);
		assertTrue(click(driver, btnYes),"Could not click the yes", driver, className, methodName);	
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		return true;
    }
    
    
    public boolean VerifyEditedDefaultTemplateInEncounterNote(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)
    {	System.out.print(driver.findElement(By.tagName("body")).getText());
    	scrollDown(driver);
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.FreeTextLabel),"Could not find the free text ",driver, className, methodName);    			
    	assertTrue(	isTextPresent(driver,encounterTemplateTestData.QuestionLabel1),"Could not find the question widget",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,"Click to select"),"Could not find the question widget two",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.NumericLabel),"Could not find the numeric widget",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.answer10),"Could not find the answer",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.answer11),"Could not find the answer",driver, className, methodName);      		
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.Answer6),"Could not find the answer",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.ComponenetName),"Could not find the component ",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel1Edit),"Could not find the edited question label",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.SectionName.toUpperCase()),"Could not find the ",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.datelabel),"Could not find the ",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.instructionWidget),"Could not find the instruction widget",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.TitleLabel.toUpperCase()),"Could not find the title",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel3),"Could not find the 3rd question widget",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel4),"Could not find the 4th question widget",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.questionLabel5),"Could not find the 5th question widget",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.assessment),"Could not find the assessment field",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.scorefieldone),"Could not find the score value",driver, className, methodName);  
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.scoretwo),"Could not find the score valuse",driver, className, methodName);  
    	return true;
    }
    public boolean recordValuesForWidgetsInEditEncounter(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,String date) 
    {
    	if(!encounterTemplateTestData.testCaseId.equals("TC_VS_010")&&!encounterTemplateTestData.testCaseId.equals("TC_VS_011")&&!encounterTemplateTestData.testCaseId.equals("TC_VS_012"))
    	{
    	encounterTemplateTestData.freeTextComment=encounterTemplateTestData.freeTextComment+date;
    	encounterTemplateTestData.numericWidgetComment=encounterTemplateTestData.numericWidgetComment+date;
    	encounterTemplateTestData.questionWidgetComment=encounterTemplateTestData.questionWidgetComment+date;
    	}
    	assertTrue(type(driver,txtFreeTextWidgetEdit,encounterTemplateTestData.freeTextComment),"Could not type reason ;More Details",driver, className, methodName);
    	waitForPageLoad(driver);
		assertTrue(type(driver,numbericWidgetDescriptionEdit,encounterTemplateTestData.numericWidgetComment),"Could not type reason ;More Details",driver, className, methodName);
		assertTrue(type(driver,textValueDecimal,encounterTemplateTestData.Minvalue1),"unable to enter the numeric value",driver,className,methodName);
		waitForPageLoad(driver);
		assertTrue(click(driver,ajxQuestionWidgetEdit),"Could not type reason ;More Details",driver, className, methodName);
		assertTrue(click(driver,chkAnswer2),"unable to choose the first value",driver,className,methodName);
		assertTrue(click(driver,btnCloseSelection),"unable to click the close button",driver,className,methodName);
		waitForPageLoad(driver);
		assertTrue(type(driver,txtQuestionWidgetCommentEdit,encounterTemplateTestData.questionWidgetComment),"Could not type reason ;More Details",driver, className, methodName);
		waitForPageLoad(driver);
		assertTrue(click(driver,chkFifthquesanswer),"unable to click the answer radio button",driver,className,methodName);
		assertTrue(type(driver,question2DescriptionEdit,encounterTemplateTestData.QuestionWidgetComment1),"unable to type the comment for question-2 comment",driver,className,methodName);
		waitForPageLoad(driver);
		assertTrue(selectValueFromAjaxList(driver,question3AnswerAjaxList,encounterTemplateTestData.Answer6),"unable to click the answer radio button",driver,className,methodName);
		assertTrue(type(driver,question3Description,encounterTemplateTestData.questionWidgetComment3),"unable to type the comment for question-2 comment",driver,className,methodName);
		waitForPageLoad(driver);
		assertTrue(click(driver,radioButtonQuestion4),"unable to click the answer radio button",driver,className,methodName);
		assertTrue(type(driver,question4Description,encounterTemplateTestData.questionWidgetComment4),"unable to type the comment for question-2 comment",driver,className,methodName);
		waitForPageLoad(driver);
		assertTrue(isElementPresent(driver,titleWidget),"unable to find title widget",driver,className,methodName);
		waitForPageLoad(driver);
    	return true;
    }


    public boolean recordWidgetsInEditedEncounterNote(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,String date) 
    {
     	try{
     		waitForPageLoad(driver);
     	assertTrue(type(driver,txtFreeTextWidget,encounterTemplateTestData.freeTextComment),"could not record values in widget	",driver, className, methodName);
     	assertTrue(type(driver,txtNumericWidgetComment,encounterTemplateTestData.numericWidgetComment),"could not record values in widget	",driver, className, methodName);
        assertTrue(click(driver,lnkQuestionWidget),"Could not type reason ;More Details",driver, className, methodName);
		waitForPageLoad(driver);
		assertTrue(click(driver,chkAnswer5),"Could not type reason ;More Details",driver, className, methodName);
		assertTrue(click(driver,btnCloseSelection),"Could not type reason ;More Details",driver, className, methodName);
		waitForPageLoad(driver);
		assertTrue(	type(driver,txtQuestionWidgetComment,encounterTemplateTestData.questionWidgetComment),"could not record values in widget	",driver, className, methodName);
		assertTrue(type(driver,txtSecondQuestionWidgetComment,encounterTemplateTestData.QuestionWidgetComment1),"could not record values in widget	",driver, className, methodName);
		assertTrue(click(driver, chkQuestionWidget),"could not record values in widget	",driver, className, methodName);
		assertTrue(type(driver,txtFromDate,encounterTemplateTestData.fromDate),"could not record values in widget	",driver, className, methodName);
		assertTrue(type(driver,txtToDate,encounterTemplateTestData.toDate),"could not record values in widget	",driver, className, methodName);
		assertTrue(type(driver,txtDateComment,encounterTemplateTestData.dateComment),"could not record values in widget	",driver, className, methodName);
		assertTrue(selectValueFromAjaxList(driver,ajxQuestionThird,encounterTemplateTestData.Answer3),"could not record values in widget	",driver, className, methodName);
		assertTrue(type(driver,txtthiredqustextarea,encounterTemplateTestData.questionWidgetComment3),"could not record values in widget	",driver, className, methodName);
		assertTrue(click (driver,chkReuseQuestionWidget),"could not record values in widget	",driver, className, methodName);
		assertTrue(type(driver,txtFourthquetextarea,encounterTemplateTestData.questionWidgetComment4),"could not record values in widget	",driver, className, methodName);
		assertTrue(type(driver,txtScoreone,encounterTemplateTestData.scorefieldone),"could not record values in widget	",driver, className, methodName);
		assertTrue(type(driver,txtScoretwo,encounterTemplateTestData.scorefieldtwo),"could not record values in widget	",driver, className, methodName);
		assertTrue(type(driver,txtScoretextarea,encounterTemplateTestData.assessmenttextbox),"could not record values in widget	",driver, className, methodName);
		assertTrue(check(driver,chkFifthquesanswer),"could not record values in widget	",driver, className, methodName);
		assertTrue(type(driver,txtFreetextComponenet,encounterTemplateTestData.freetextcomponent),"could not record values in widget	",driver, className, methodName);
		//assertTrue(type(driver,txtFreetextSection,encounterTemplateTestData.freetextsectionnote),"could not record values in widget	",driver, className, methodName);
		assertTrue(type(driver,txtNumericWidget,encounterTemplateTestData.numericWidgetValuedecimal),"could not record values in widget	",driver, className, methodName);
		
		Thread.sleep(3000); 		
    	   	}
    	   	catch(Exception e)
    	   	{
    	   		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
    	   	}    
     	return true;
    }

    

    public boolean verifySecondRecordedWidgetInTimeLine(WebDriver driver,ClinicalSettingLib encounterTemplateTestData) 
    {
     	try{
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.freeTextComment),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.numericWidgetComment),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.Answer5),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.questionWidgetComment),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionWidgetComment1),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.Answer1),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.fromDate),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.toDate),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.dateComment),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.Answer3),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.questionWidgetComment3),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.Answer7),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.questionWidgetComment4),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.scorefieldone),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.scorefieldtwo),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.assessmenttextbox),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.answer11),"Recorede value is missing in time line",driver, className, methodName);
     		assertTrue(isTextPresent(driver,encounterTemplateTestData.numericWidgetValuedecimal),"Recorede value is missing in time line",driver, className, methodName);
		Thread.sleep(3000); 		
    	   	}
    	   	catch(Exception e)
    	   	{
    	   		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
    	   	}    
     	return true;
    }

public boolean VerifyEditedDefaultTemplateInPrevouusEncounterNote(WebDriver driver,ClinicalSettingLib encounterTemplateTestData){
	waitForPageLoad(driver);
	waitForPageLoad(driver);
	scrollDown(driver);
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.FreeTextLabel),"FreeTextLabel is not present",driver, className, methodName);
    			    	   			
    	assertTrue(isTextPresent(driver,encounterTemplateTestData.NumericLabel),"NumericLabel is not present",driver, className, methodName);
    			
   		 		
   		assertTrue(isTextPresent(driver,encounterTemplateTestData.ComponenetName),"ComponenetName is not present",driver, className, methodName);
   		
   		assertTrue(isTextPresent(driver,encounterTemplateTestData.SectionName),"SectionName is not present",driver, className, methodName);
    	
   		assertTrue(isTextPresent(driver,encounterTemplateTestData.datelabel),"TitleLabelEdit is not present",driver, className, methodName);
   		
   		assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel),"Ques one is not present",driver, className, methodName);
   		assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel1),"Ques two is not present",driver, className, methodName);
   		assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel3),"Ques thee is not present",driver, className, methodName);
   		assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel4),"Ques four is not present",driver, className, methodName);
   		assertTrue(isTextPresent(driver,encounterTemplateTestData.assessment),"Assessment  is not present",driver, className, methodName);
   		assertTrue(!isTextPresent(driver,encounterTemplateTestData.QuestionLabel1Edit),"Edited Question label is  Not created", driver, className, methodName);
   		assertTrue(!isTextPresent(driver,encounterTemplateTestData.questionLabel5),"Edited Question label is  Not created", driver, className, methodName);
   		return true;
    	
    	
    }

    public boolean signEncounter(WebDriver driver)
    {
    	assertTrue(click(driver,btnSign),"Could not click the Sign button in encounter note ", driver,className, methodName);
		waitForPageLoad(driver);
    	return true;
    }
    public boolean navigateToManagedCare(WebDriver driver,ClinicalSettingLib mcTemplate, String account,String uniqueName) throws Exception
    {
    	String date="";
    	assertTrue(click(driver, lnkMore), "Could not click on more link", driver, className, methodName);
		waitForPageLoad(driver);	
    	assertTrue(click(driver,lnkToManagedCare),"Unable to navigate to Managed care template",driver,className,methodName);
    	waitForPageLoad(driver);
    	assertTrue(click(driver,btnAddNew),"Unable to click the add new button",driver,className,methodName);
    	waitForPageLoad(driver);
    	assertTrue(selectValueFromAjaxList(driver,ajxNameMedication,mcTemplate.templateName+uniqueName),"Unable to enter the name of the template",driver,className,methodName);
    	if (account.contains("CA")) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());
		} else if(account.contains("US")) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal.getTime());
		}
    	assertTrue(enterDate(driver,txtBaseLineDate,date),"Unable to enter the Date",driver,className,methodName);
    	waitForPageLoad(driver);
    	assertTrue(click(driver,btnTemplateSave),"Unable to click the save button",driver,className,methodName);
    	waitForPageLoad(driver);
    	
        return true;	
    }

    public void selectAssessment(String medicalCondition)  {
    	selectValueFromAjaxList(driver, ajxAssessmentSearch,medicalCondition);
	 }
    public void enterComplaint(String compalaint)  {
    	type(driver, ajxComplaintBox,compalaint);
	 }
    
    public AllergyPage goToEncounterAllergy(WebDriver driver)
    {
    	assertTrue(click(driver, lnkEncounterAllergy),
				"Could not on click on Allergy link",driver, className, methodName);
    	waitForPageLoad(driver);
    	return new AllergyPage();
    	
    }
    public ProcedurePage goToEncounterProcedure(WebDriver driver)
    {
    	assertTrue(click(driver, lnkEncounterProcedure),
				"Could not on click on Procedure link",driver, className, methodName);
    	waitForPageLoad(driver);
    	return new ProcedurePage();
    	
    }
    
    public ManagedCareTemplateOnPatientChartPage navigateToManagedCare(WebDriver driver) throws Exception
    {
    	assertTrue(click(driver, lnkMore), "Could not click on more link", driver, className, methodName);
		waitForPageLoad(driver);	
    	assertTrue(click(driver,lnkToManagedCare),"Unable to navigate to Managed care template",driver,className,methodName);
    	waitForPageLoad(driver);
        return new ManagedCareTemplateOnPatientChartPage();	
    }
    
    public boolean associateManagedCareTemplateOnPatientChartPage(ManagedCareTemplateOnPatientChartPage managedCareTemplate,WebDriver driver,String userAccount,String uniqueName,ClinicalSettingLib mcTemplate)throws Exception
    {
    	managedCareTemplate.navigateToParticularManagedCareTemplate(driver,mcTemplate,uniqueName,userAccount);
    	return true;
    }
    public boolean createEncounterAllergy(WebDriver driver,
			ChartPreVisitLib allergyData, String account,AllergyPage allergyPage) throws Exception {
    	
    	allergyPage.createAllergy(driver, allergyData, account);
    	return true;
    }

    public boolean createEncounterProcedure(WebDriver driver,
			ChartPreVisitLib procedureData, String account,ProcedurePage procedurePage) throws Exception {
    	
    	procedurePage.createProcedure(driver,procedureData, account);
    	return true;
    }


    public boolean clickEditAllergy(WebDriver driver)
       {		
       	waitForPageLoad(driver);	
       	assertTrue(click(driver, btnAllergyEdit), "Could not click on more link", driver, className, methodName);
       	return true;
       }
    
    
    public PrescribeMedicationPage clickPresIcon(WebDriver driver)
    {
    	waitForPageLoad(driver);	
       	assertTrue(click(driver, iconPresMedi), "Could not click on more link", driver, className, methodName);
       	return new PrescribeMedicationPage();
    }
    
    public void createProblemList(ProblemListPage problemListPage, ChartPreVisitLib proData)  {
    	problemListPage.createProblemList(proData, proData.userAccount);
    }
    
	public boolean SearchPrescribeMed(WebDriver driver,ChartPreVisitLib prescribeData, String account,PrescribeMedicationPage prescribeMedicationPage) throws Exception {

		prescribeMedicationPage.SearchPrescribeMed(driver, prescribeData, account);
		return true;
	}
	
	public boolean addPrescribeMedication(WebDriver driver, ChartPreVisitLib prescribeData, String account,PrescribeMedicationPage prescribeMedicationPage) throws Exception
	{
		prescribeMedicationPage.addPrescribeMedication(driver, prescribeData, account);
		return true;
	}
	
	public boolean clickOnPrintPrescribeMedication (WebDriver driver,PrescribeMedicationPage prescribeMedicationPage) throws InterruptedException, AWTException
	{
		prescribeMedicationPage.clickOnPrintPrescribeMedication(driver);
		return true;
	}
	
	
	
	public boolean verifyAllRecordedValuesInEncounterNote (WebDriver driver,ChartPreVisitLib prescribeData,ChartPreVisitLib allergyData, String account,ClinicalSettingLib encounterEditTemplateTestData)
	{
		waitForPageLoad(driver);	
	if (account.equals("CA2000"))	
		{
   		assertTrue(isTextPresent(driver,prescribeData.prescribeCa),"prescribeCa is not present",driver, className, methodName);
   		assertTrue(isTextPresent(driver,allergyData.allergenCa),"allergenCa is not present",driver, className, methodName);
		}
		else
		{
	   	assertTrue(isTextPresent(driver,prescribeData.prescribe),"prescribe is not present",driver, className, methodName);
	   	assertTrue(isTextPresent(driver,allergyData.allergen),"allergen is not present",driver, className, methodName);
		}
		if(!getValue(driver,txtNumericWidget).contains(encounterEditTemplateTestData.minmumvalue1))
		{
			type(driver,txtNumericWidget,encounterEditTemplateTestData.minmumvalue1);
		}
		assertTrue(getValue(driver,txtFreeTextWidget).contains(encounterEditTemplateTestData.freeTextComment),"freeTextComment is not present",driver, className, methodName);
		assertTrue(getValue(driver,txtNumericWidget).contains(encounterEditTemplateTestData.minmumvalue1),"Recored Value in Numeric Widget is missing in Edit mode",driver, className, methodName);
		assertTrue(getValue(driver,txtNumericWidgetComment ).contains(encounterEditTemplateTestData.numericWidgetComment),"numericWidget comment is not present",driver, className, methodName);
		assertTrue(	isTextPresent(driver,encounterEditTemplateTestData.Answer1),"Entered answer is missing",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.Answer4),"Entered answer is missing",driver, className, methodName);
		assertTrue(isChecked(driver, chkQuestionWidget),"Not click the Action button in Encounter note", driver, className, methodName);	
		if(isElementPresent(driver,txtQuestionWidgetComment)){
			assertTrue(getValue(driver,txtQuestionWidgetComment).contains(encounterEditTemplateTestData.questionWidgetComment),"Could not type reason ;More Details",driver, className, methodName);
			}
			if(isElementPresent(driver,txtSecondQuestionWidgetComment)){
			assertTrue(getValue(driver,txtSecondQuestionWidgetComment).contains(encounterEditTemplateTestData.QuestionWidgetComment1),"Could not type reason ;More Details",driver, className, methodName);
			}
			assertTrue(	getValue(driver,ajxQuestionThird).contains(encounterEditTemplateTestData.Answer8),"Record values in third question widget is missing",driver, className, methodName);
			assertTrue(	getValue(driver,txtFourthquetextarea).contains(encounterEditTemplateTestData.questionWidgetComment3),"Record values in  question widget is missing",driver, className, methodName);
			assertTrue(	isChecked(driver,chkReuseQuestionWidget),"Record values in  question widget is missing",driver, className, methodName);
		assertTrue(getValue(driver,txtReuseNumericWidget).contains(encounterEditTemplateTestData.minmumvalue2),"questionWidgetAnswer1 Comment is not present",driver, className, methodName);
		assertTrue(getValue(driver,txtReuseNumericTextBox).contains( encounterEditTemplateTestData.numericWidgetCommentreuse),"Second questionWidget Comment is not present",driver, className, methodName);
		assertTrue(	isChecked(driver,chkFifthquesanswer),"Record values in  question widget is missing",driver, className, methodName);
		assertTrue(getValue(driver,txtReuseNumericWidget3).contains(encounterEditTemplateTestData.minmumvalue3),"Record values in  question widget is missing",driver, className, methodName);			
		assertTrue(getValue(driver,txtReuseNumericTextBox3).contains(encounterEditTemplateTestData.numericWidgetCommentreuse3),"Record values in  question widget is missing",driver, className, methodName);
		assertTrue(getValue(driver,txtReuseFreeText ).contains(encounterEditTemplateTestData.FreeTextLabel),"fromDate is not present",driver, className, methodName);
		assertTrue(getValue(driver,txtSecondQuestionWidgetComment).contains( encounterEditTemplateTestData.QuestionWidgetComment1),"Second questionWidget Comment is not present",driver, className, methodName);
		assertTrue(getValue(driver,txtScoreone).contains(encounterEditTemplateTestData.scorefieldone),"could not record values in widget	",driver, className, methodName);
		assertTrue(getValue(driver,txtScoretwo).contains(encounterEditTemplateTestData.scorefieldtwo),"could not record values in widget	",driver, className, methodName);
		assertTrue(getValue(driver,txtScoretextarea).contains(encounterEditTemplateTestData.assessmenttextbox),"could not record values in widget	",driver, className, methodName);
		assertTrue(getValue(driver,txtFromDate ).contains(encounterEditTemplateTestData.fromDate),"fromDate is not present",driver, className, methodName);
		assertTrue(getValue(driver, txtToDate ).contains(encounterEditTemplateTestData.toDate),"toDate is not present",driver, className, methodName);
		assertTrue(getValue(driver, txtDateComment ).contains(encounterEditTemplateTestData.dateComment),"toDate is not present",driver, className, methodName);
		assertTrue(getValue(driver,txtFreetextSection).contains(encounterEditTemplateTestData.freetextsectionnote),"Could not type reason ;More Details",driver, className, methodName);
		assertTrue(getValue(driver,txtFreetextComponenet).contains(encounterEditTemplateTestData.freetextcomponent),"Could not type reason ;More Details",driver, className, methodName);
		scrollDown(driver);		
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		return true;
	}
	
	public boolean verifythirdEncounterDetails(WebDriver driver,ChartPreVisitLib prescribeData,ChartPreVisitLib allergyData, String account,ClinicalSettingLib encounterEditTemplateTestData)
	{
		waitForPageLoad(driver);	
		if (account.equals("CA2000"))	
		{
   		assertTrue(isTextPresent(driver,prescribeData.prescribeCa),"prescribeCa is not present",driver, className, methodName);
   		assertTrue(isTextPresent(driver,allergyData.allergenCa),"allergenCa is not present",driver, className, methodName);
		}
		else
		{
	   	assertTrue(isTextPresent(driver,prescribeData.prescribe),"prescribe is not present",driver, className, methodName);
	   	assertTrue(isTextPresent(driver,allergyData.allergen),"allergen is not present",driver, className, methodName);
		}
		
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.freeTextComment),"Could not type reason ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.Minvalue1),"Could not type reason ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.numericWidgetComment),"Could not type reason ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.Answer2),"Could not Find Answer ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.Answer4),"Could not Find Answer ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.Answer1),"Could not Find Answer ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.answer11),"Could not Find Answer ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.Answer7),"Could not Find Answer ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.Answer8),"Could not Find Answer ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.questionWidgetComment),"Could not Find reason ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.QuestionWidgetComment1),"Could not Find reason ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.fromDate),"Could not Find reason ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.toDate),"Could not Find reason ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.dateComment),"Could not Find reason ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.Answer8),"Could not type Find ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.questionWidgetComment3),"Could not Find reason ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.minmumvalue2),"Could not type Find ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.numericWidgetCommentreuse),"Could not Find reason ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.minmumvalue3),"Could not Find reason ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.numericWidgetCommentreuse3),"Could not Find reason ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.scorefieldone),"could not Find values in widget	",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.scorefieldtwo),"could not Find values in widget	",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.assessmenttextbox),"could not Find values in widget	",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.FreeTextLabel),"Could not Find free text widget data ",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.freetextsectionnote),"Could not Find reason ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.freetextcomponent),"Could not Find reason ;More Details",driver, className, methodName);
		assertTrue(isTextPresent(driver,encounterEditTemplateTestData.minmumvalue1),"Could not Find reason ;More Details",driver, className, methodName);
		waitForPageLoad(driver);
		return true;
	}
	
	  public boolean verifyNewlyCreatedWidgetsInEncounterNote (WebDriver driver ,ClinicalSettingLib sectionCdata ,ClinicalSettingLib sectionDdata)
	    {
	    	assertTrue(isTextPresent(driver,sectionCdata.FreeTextLabel),"FreeTextLabel C Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,sectionDdata.FreeTextLabel),"FreeTextLabel D Label Not created", driver, className, methodName);

	    	return true;
	    }

	  public boolean recordVlaueInReuseWidgetsInEncounterNote(WebDriver driver,String date,ClinicalSettingLib encounterEditTemplateTestData)  
	    {
		  try{    	
				
	    	assertTrue(type(driver,txtFreeTextWidget,encounterEditTemplateTestData.freeTextComment),"Could not type reason ;More Details",driver, className, methodName);
			assertTrue(type(driver,txtNumericWidget,encounterEditTemplateTestData.Minvalue1),"Could not type reason ;More Details",driver, className, methodName);
			assertTrue(type(driver,txtNumericWidgetComment,encounterEditTemplateTestData.numericWidgetComment),"Could not type reason ;More Details",driver, className, methodName);
			assertTrue(click(driver,lnkQuestionWidget),"Could not type reason ;More Details",driver, className, methodName);
			assertTrue(click(driver,chkAnswer2),"Could not select Answer ;More Details",driver, className, methodName);
			assertTrue(click(driver,chkAnswer4),"Could not select Answer ;More Details",driver, className, methodName);
			assertTrue(click(driver,btnCloseSelection),"Could not type reason ;More Details",driver, className, methodName);
			Thread.sleep(3000);
	    	assertTrue(click(driver, chkQuestionWidget),"Could not click the Action button in Encounter note", driver, className, methodName);			
			if(isElementPresent(driver,txtQuestionWidgetComment)){
			assertTrue(type(driver,txtQuestionWidgetComment,encounterEditTemplateTestData.questionWidgetComment),"Could not type reason ;More Details",driver, className, methodName);
			}
			if(isElementPresent(driver,txtSecondQuestionWidgetComment)){
			assertTrue(type(driver,txtSecondQuestionWidgetComment,encounterEditTemplateTestData.QuestionWidgetComment1),"Could not type reason ;More Details",driver, className, methodName);
			}
			assertTrue(type(driver,txtFromDate,encounterEditTemplateTestData.fromDate),"Could not type reason ;More Details",driver, className, methodName);
			assertTrue(type(driver,txtToDate,encounterEditTemplateTestData.toDate),"Could not type reason ;More Details",driver, className, methodName);
			assertTrue(type(driver,txtDateComment,encounterEditTemplateTestData.dateComment),"Could not type reason ;More Details",driver, className, methodName);
			selectValueFromAjaxList(driver,ajxQuestionThird,encounterEditTemplateTestData.Answer8);
			type(driver,txtFourthquetextarea,encounterEditTemplateTestData.questionWidgetComment3);
			click(driver,chkReuseQuestionWidget);
			type(driver,txtReuseNumericWidget,encounterEditTemplateTestData.minmumvalue2);		
			type(driver,txtReuseNumericTextBox,encounterEditTemplateTestData.numericWidgetCommentreuse);
			click(driver,chkFifthquesanswer);
			click(driver,chkfifthquestionreuseAns);
			type(driver,txtReuseNumericWidget3,encounterEditTemplateTestData.minmumvalue3);			
			type(driver,txtReuseNumericTextBox3,encounterEditTemplateTestData.numericWidgetCommentreuse3);
			assertTrue(type(driver,txtScoreone,encounterEditTemplateTestData.scorefieldone),"could not record values in widget	",driver, className, methodName);
			assertTrue(type(driver,txtScoretwo,encounterEditTemplateTestData.scorefieldtwo),"could not record values in widget	",driver, className, methodName);
			assertTrue(type(driver,txtScoretextarea,encounterEditTemplateTestData.assessmenttextbox),"could not record values in widget	",driver, className, methodName);
			assertTrue(type(driver,txtReuseFreeText,encounterEditTemplateTestData.FreeTextLabel),"Could not type free text widget data ",driver, className, methodName);
			assertTrue(type(driver,txtFreetextSection,encounterEditTemplateTestData.freetextsectionnote),"Could not type reason ;More Details",driver, className, methodName);
			assertTrue(type(driver,txtFreetextComponenet,encounterEditTemplateTestData.freetextcomponent),"Could not type reason ;More Details",driver, className, methodName);
			assertTrue(type(driver,txtNumericWidget,encounterEditTemplateTestData.minmumvalue1),"Could not type reason ;More Details",driver, className, methodName);
			waitForPageLoad(driver);
		  }
		  catch(Exception e)
		  {
			  Assert.fail(e.getMessage());
		  }
	    	return true;
	    }

	  public boolean verifyDeletedSectionsInEncounterNote (WebDriver driver ,ClinicalSettingLib sectionCdata ,ClinicalSettingLib sectionDdata)
	    {
	    	assertTrue(!isTextPresent(driver,sectionCdata.FreeTextLabel),"FreeTextLabel C Label is present", driver, className, methodName);
	    	assertTrue(!isTextPresent(driver,sectionDdata.FreeTextLabel),"FreeTextLabel D Label is present", driver, className, methodName);

	    	return true;
	    }

	  public ProblemListPage goToeditAssessment(){
			click(lnkAssessmentCreated);
			click(btnEditAssessment);
			return new ProblemListPage();
			
		}
	  
	  /**
		 * goToCreateOrderLabTest
		 * Function to Navigate To Create Order Lab Test Page 
		 * @param 	driver
		 * @throws  Exception 
	  	 * @since	Jan 28,2015
		 */  
    
    public LabOrderPage goToCreateOrderLabTest(WebDriver driver)   {
  	 
    	verifyTrue(click(driver, imgOrderNewLabs),"Could not click order new lab icon",driver);
    	waitForPageLoad(driver);
    	
    	return new LabOrderPage();
    	
	}
    
    /**
     * Create New Order Lab Test
     * Function to Create New Order Lab Test
     *  @param 	driver
     *  @param  diData - Test Data
     * @param 	labOrderPage
     * @throws Exception  
     * @since	Jan 28,2015
     */  

    public void createNewOrderLabTest(WebDriver driver,ChartPreVisitLib diData,LabOrderPage labOrderPage)   {
   try{
    labOrderPage.createNewOrderLabTest(driver,diData);
    waitForPageLoad(driver);
    }catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

    }
    /**
     * Create New Order Lab Test
     * Function to Create New Order Lab Test
     *  @param 	driver
     * @param 	labOrderPage
     * @throws Exception  
     * @since	Jan 28,2015
     */  

    public void createNewOrderLabTestwithoutprint(WebDriver driver,ChartPreVisitLib diData,LabOrderPage labOrderPage)   {
    	
    labOrderPage.createNewOrderLabTestwithoutprint(driver,diData);
    waitForPageLoad(driver);

    }
    /**
     * Go TO Order Lab Test
     * Function for Go TO Order Lab Test
     * @param 	driver
     * @throws Exception 
     * @since	Jan 29,2015
     */  

    public LabOrderPage goTOOrderLabTest(WebDriver driver)   {
    try{
    verifyTrue(click(driver,lnkOrderNewLab),"Could not click link Order New Lab", driver);
     waitForPageLoad(driver);
     verifyTrue(click(driver,lnkViewOrderNewLab),"Could not click link View Order New Lab", driver);
     waitForPageLoad(driver);
    }catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
      return new LabOrderPage();

    }
    
    /**
     * Verify New Order Lab Test
     * Function to Verify Order Lab Test 
     * @param 	driver
     * @param 	encounterPage
     * @param 	labOrderPage
     * @throws  Exception 
     * @since	Jan 29,2015
     */  


    public void verifyNewOrderLabTest(WebDriver driver,ChartPreVisitLib diData,LabOrderPage labOrderPage) throws Exception {
    try{
    labOrderPage.verifyNewOrderLabTest(driver,diData);
    waitForPageLoad(driver);
    }catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
    }
    
    /**
     * Verify Checked Order Lab Test
     * Function to Verify Checked Order Lab Test
     * @param 	driver
     * @param   diData - Test Data
     * @param 	labOrderPage
     * @throws  Exception 
     * @since	Jan 29,2015
     */  

    public void verifyCheckedOrderLabTest(WebDriver driver,ChartPreVisitLib diData,LabOrderPage labOrderPage)   {
   
    labOrderPage.verifyCheckedOrderLabTest(driver,diData);
    waitForPageLoad(driver);

    }
    
    
    /**
     * Verify Unchecked Order Lab Test
     * Function to Verify Unchecked Order Lab Test
     * @param   diData - Test Data
     * @param 	driver
     * @param 	labOrderPage
     * @throws  Exception 
     * @since	Jan 29,2015
     */  

    public void verifyUncheckedOrderLabTest(WebDriver driver,ChartPreVisitLib diData,LabOrderPage labOrderPage) throws Exception {
   
    labOrderPage.verifyUncheckedOrderLabTest(driver,diData);
    waitForPageLoad(driver);

    }
    
    
    /**
     * Verify Edit Lab Order Test
     * Function to Verify Edit Lab Order Test
     * @param 	driver
     * @param 	labOrderPage
     * @throws  Exception 
     * @since	Jan 30,2015
     */  


    public void editLabOrderTest(WebDriver driver,ChartPreVisitLib diData,LabOrderPage labOrderPage) throws Exception {
    	
    	labOrderPage.editLabOrderTest(driver,diData);
        waitForPageLoad(driver);

    }
    
    public void selectCosign(ChartPreVisitLib encounterData)  {
    	selectValueFromAjaxList(driver, ajxCosignSuggestBox,encounterData.CosignProv);
    	click(driver, btnSaveCosign);
	 }
    public String getCosigner()  {
    	return getValue(driver, ajxCosignSuggestBox);
	 }
    
    /**
     * goToEncounterProblemList
     * Function to Navigate To ProblemList of Encounter Page
     * @param 	driver
     * @throws Exception 
     * @since	March 12,2015
     * @version 2.1
     */  
    public ProblemListPage goToEncounterProblemList(WebDriver driver)
    {
    try{
       click(lnkEncounterProblemlist);
       waitForPageLoad(driver);
    } catch (Exception e)
  	 {
  		 assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

  	 }
       return new ProblemListPage();
    }
    
    /**
     * goToEncounterSocialHistory
     * Function to Navigate To Social History of Encounter Page
     * @param 	driver
     * @since	May 21,2015
     * @version 2.1
     */  
    public SocialHistoryPage  goToEncounterSocialHistory(WebDriver driver)
    {
    try{
		verifyTrue(click(driver, lnkSocialHistoryEncounter), "Couln't click social History link", driver);
		waitForPageLoad(driver);
    } catch (Exception e)
  	 {
  		 assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

  	 }
       return new SocialHistoryPage();
    }
    

    /**
     * goToEncounterInjection
     * Function to Navigate To Injection of Encounter Page
     * @param 	driver
     * @throws Exception 
     * @since	May 21,2015
     * @version 2.1
     */  
    public InjectionPage goToEncounterInjection(WebDriver driver)
    {
    try{
       click(lnkEncounterInjection);
       waitForPageLoad(driver);
    } catch (Exception e)
  	 {
  		 assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

  	 }
       return new InjectionPage();
    }
    
    /**
     * goToEncounterProblemList
     * Function to Navigate To ProblemList of Encounter Page
     * @param 	driver
     * @param ChartPreVisitLib data- proData
     * @param account
     * @param problemListPage
     * @since	Mar 12,2015
     * @version 2.1
     */  
    
    public boolean createEncounterProblemListEndToEnd(WebDriver driver,ChartPreVisitLib proData, String account, ProblemListPage problemListPage)
    {
    	problemListPage.createProblemListEndToEnd(driver, proData, account);
       return true;
    }
    
    /**
    * createEncounterSocialHistoryEndToEnd
    * Function to Navigate To Social History of Encounter Page
    * @param 	driver
    * @param ChartPreVisitLib socialHistory data - socialHisData1
    * @param account
    * @param socialHistoryPage
    * @throws Exception 
    * @since	May 21,2015
    * @version 2.1
    */ 
    
    public boolean createEncounterSocialHistoryEndToEnd(WebDriver driver,ChartPreVisitLib socialHisData1, String account, SocialHistoryPage socialHistoryPage)
    {
    
    try {
       socialHistoryPage.createSocialHistoryEndToEnd(driver,socialHisData1,account);
       }catch (Exception e) {
    	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
       }
       return true;
    }
    
    
    

    
    /**
     * createEncounterInjectionEndToEnd
     * Function to Navigate To Injection of Encounter Page
     * @param 	driver
     * @param ChartPreVisitLib data- proData
     * @param account
     * @param problemListPage
     * @since	May 21,2015
     * @version 2.1
     */  
    
    public boolean createEncounterInjectionEndToEnd(WebDriver driver,ChartPreVisitLib proData, String account, InjectionPage injectionPage)throws Exception
    {
    	injectionPage.createInjection(driver, proData, account);
       return true;
    }
    /**
     * cancelEncounter
     * Function to Cancel Encounter
     * @throws Exception 
     * @since	Mar 12,2015
     * @version 2.1
     */
    public boolean cancelEncounter()
    {
    	click(lnkEncounterAction);
        waitForPageLoad(driver);
        click(lblEncounterCancel);
        waitForPageLoad(driver);
        click(btnYes);
        waitForPageLoad(driver);

    	return true;
    }
    
	/**
	 * goToEditProblemListFromEncounter function to  Edit Problem List from encounter
	 * @since  	@since March 13, 2015
	 * @version 2.1
	 */

	public boolean goToEditProblemListFromEncounter(ProblemListPage problemListPage)
	{
		problemListPage.goToEditProblemListFromEncounter();
		return true;
		
	}
	
	/**
     * clickEncounterEditProblemList function to a Click Edit button
     * @since  	@since March 12, 2015
     * @version 2.1
     */

    public boolean clickEncounterEditProblemList()
    {
		try{
			verifyTrue(click(driver, btnEncounterEditProblemList), "edit button not found", driver);
			waitForPageLoad(driver);
			verifyTrue(click(driver, btnEditInEncounter), "edit button not found", driver);
			waitForPageLoad(driver);
		}	
		catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
 	
    }
    
    /**
     * removeEncounterProblemList function to a Click Remove button
     * @since April 12, 2015
     * @version 2.1
     */

    public boolean removeEncounterProblemList()
    {
		try{
			verifyTrue(click(driver, btnEncounterEditProblemList), "Problem list Item link  not found", driver);
			waitForPageLoad(driver);
			verifyTrue(click(driver, lnkRemoveProblemList), "Remove button not found", driver);
			waitForPageLoad(driver);
			verifyTrue(click(driver, btnYes), "Yes button not found", driver);
			waitForPageLoad(driver);
		}	
		catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
 	
    }
    
    /**
     * removeEncounterProblemList function to a Click Remove button
     * @since April 12, 2015
     * @version 2.1
     */

    public boolean removeEncounterInjection(WebDriver driver)
    {
		try{
			verifyTrue(click(driver, btnEncounterEditInjection), "Problem list Item link  not found", driver);
			waitForPageLoad(driver);
			verifyTrue(click(driver, lnkRemoveInjection), "Remove button not found", driver);
			waitForPageLoad(driver);
			verifyTrue(click(driver, btnYes), "Yes button not found", driver);
			waitForPageLoad(driver);
		}	
		catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
 	
    }
	 /**
     * deleteEncounterProblemList
     * Function to Delete the Encounter ProblemList
     * @param 	driver
     * @since	Mar 17,2015
     * @version 2.1
     */  
    public void  deleteEncounterProblemList(WebDriver driver,ProblemListPage problemListPage,ChartPreVisitLib problemListData)
    {
      try {
    		problemListPage.deleteAllProblemList(driver, problemListData);
    	}catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
    	} 
    }
    
    /**
   	 * goToencounterVitals
   	 * function to goTo encounter Vitals Page 
   	 *  @param 	driver
   	 * @since  	Mar 18, 2015
   	 * @version 2.1
   	 */	
   	public VitalsPage goToencounterVitals(WebDriver driver)  {
   		try{
   			verifyTrue(click(driver, lnkVitalsPage), "Could not click on Vitals click", driver);
   	       
   		}catch (Exception e) {
   		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   	    }
   		 return new VitalsPage();
   	}
	/**
   	 * goToEncounterMedications
   	 * function to goTo Encounter Medications Page 
   	 *  @param 	driver
   	 * @since  	Mar 19, 2015
   	 * @version 2.1
   	 */		
   	public MedicationsPage goToEncounterMedications(WebDriver driver)  {
   	try{
   			verifyTrue(click(driver,lnkMedicationsSummaryPage), "Could not click on Medications  click", driver);
   			waitForPageLoad(driver);
   			waitForPageLoad(driver);
   	 }catch (Exception e) {
   		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   	    }
   		 return new MedicationsPage();
   	}
   	
   	
   	
   	/**
   	 * goToEditEncounterMedications
   	 * function to goTo Edit Encounter Medications Page 
   	 * @param 	driver
   	 * @param  encounterPage
   	 * @param  medicationsPage
   	 * @since  	Mar 25, 2015
   	 * @version 2.1
   	 */	

   	public void goToEditEncounterMedications(WebDriver driver,MedicationsPage medicationsPage)  {
   		try{
   		medicationsPage.goToEditEncounterMedications(driver);
   		}catch (Exception e) {
  		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
  	    }
   	}

   	/**
   	 * deleteEncounterMedications
   	 * function to Delete Encounter Medications Page 
   	 *  @param 	driver
   	 *  @param  encounterPage
   	 * @since  	Mar 19, 2015
   	 * @version 2.1
   	 */	

   	public void deleteEncounterMedications(WebDriver driver){
   		try{
   			verifyTrue(click(driver,lnkMedicationDrug),"Unable to click medications link in encounter page",driver);
   			waitForPageLoad(driver);
   			verifyTrue(click(driver,lnkRemoveMedication),"Unable to click remove medications link in encounter page",driver);
   			waitForPageLoad(driver);
   			verifyTrue(click(driver,btnYes),"Unable to click yes button in encounter page",driver);
   			waitForPageLoad(driver);   			
   		}catch (Exception e) {
   		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   	    }
   	    
   	}
   	

   	/**
   	 * deleteEncounterImmunizations
   	 * function to Delete Encounter Immunizations Page 
   	 *  @param 	driver
   	 *  @param  encounterPage
   	 * @since  	Mar 25, 2015
   	 * @version 2.1
   	 */	

   	public void deleteEncounterImmunizations(WebDriver driver){
   		try{
   			verifyTrue(click(driver,lnkDeleteEncounterImmunization),"Unable to click immunizations link in encounter page",driver);
   			waitForPageLoad(driver);
   			verifyTrue(click(driver,lnkRemoveImmunization),"Unable to click remove immunizations link in encounter page",driver);
   			waitForPageLoad(driver);
   			verifyTrue(click(driver,btnYes),"Unable to click yes button in encounter page",driver);
   			waitForPageLoad(driver);   
   		}catch (Exception e) {
   		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   	    }
   	    
   	}
   	
   	
   	
   	/**
   	 * Add Encounter Vitals
   	 * Function to Add Encounter Vitals
   	 * @param 	driver
   	 * @param  encounterPage
   	 * @param  vitalsPage
   	 * @param  ClinicalSettingLib - Medications test data
   	 * @since  	Mar 19, 2015
   	 * @version 2.1
   	 */	
   	public MedicationsPage addEncounterMedications(WebDriver driver,MedicationsPage medicationsPage,ClinicalSettingLib mcTemplate)  {
   		try{
   			medicationsPage.addEncounterMedications(driver,mcTemplate);
   	       
   		}catch (Exception e) {
   		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   	    }
   		 return new MedicationsPage();
   	}
   	
   	
   	/**
   	 * Add Encounter Vitals
   	 * Function to Add Encounter Vitals
   	 * @param 	driver
   	 * @param  medicationsPage
   	 * @since  	Mar 25, 2015
   	 * @version 2.1
   	 */	
   	public MedicationsPage editEncounterMedications(WebDriver driver,MedicationsPage medicationsPage,ClinicalSettingLib mcTemplate)  {
   		try{
   			medicationsPage.editEncounterMedications(driver, mcTemplate);
   	       
   		}catch (Exception e) {
   		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   	    }
   		 return new MedicationsPage();
   	}
   	
   	
   	/**
   	 * Add Encounter Vitals
   	 * Function to Add Encounter Vitals
   	 * @param 	driver
   	 * @param  encounterPage
   	 * @param  vitalsPage
   	 * @param  vitalsData - Vitals test data
   	 * @since  	Mar 19, 2015
   	 * @version 2.1
   	 */	
   	public boolean addEncounterVitals(WebDriver driver,VitalsPage vitalsPage,ChartPreVisitLib vitalsData)  {
   		try{
   			vitalsPage.addVitals(driver,vitalsData);
   	       
   		}catch (Exception e) {
   		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   	    }
   		 return  true;
   	}
   	
	/**
   	 * Remove Encounter Vitals
   	 * Function to Remove Encounter Vitals
   	 * @param 	driver
  	 * @param  vitalsPage
   	 * @since  	Apr 29, 2015
   	 * @version 2.1
   	 */	
   	
   public boolean removeEncounterVitals(WebDriver driver,VitalsPage vitalsPage)  {
   		try{
      	vitalsPage.removeEncounterVitals(driver);
   	       
   		}catch (Exception e) {
   		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   	    }
   		 return  true;
   	}
   
	/**
	 * verifyAssessmentInLetter function to verify Assessment In Letter
	 * @param driver
	 * @param ChartPreVisitLib - referralData
	 * @param referralLetterPage
	 * @since  May 05, 2015
	 * @version 2.1
	 */
	
	public boolean verifyAssessmentInLetter(WebDriver driver, ChartPreVisitLib proData, ReferralLetterPage referralLetterPage) throws IOException {

		try{
			referralLetterPage.verifyAssessmentInLetter(driver, proData);
			waitForPageLoad(driver);
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
	
		return true;
	}	

    /**
     * verifyImageWidgetInEncounter
		 * Function to verify Image Widget In Encounter Edit Mode 
		 * @param 	driver
		 * @param   encounterTemplateTestData
	  	 * @throws Exception 
		 * @since	May 07,2015
		 * @Version 2.1
		 */ 
    public boolean verifyImageWidgetInEncounter(WebDriver driver, ClinicalSettingLib encounterTemplateTestData, ClinicalSettingLib visitOutlineData)
    {
    	try{
   		   scrollDown(driver);
   		   scrollDown(driver);
    		assertTrue(isTextPresent(driver, encounterTemplateTestData.imageName),"Name value not found", driver, className, methodName);
    		assertTrue(isTextPresent(driver, encounterTemplateTestData.marker1),"marker1 value not found", driver, className, methodName);
    		assertTrue(isTextPresent(driver, encounterTemplateTestData.description1),"description1 value not found", driver, className, methodName);
    		assertTrue(isTextPresent(driver, encounterTemplateTestData.marker2),"marker2 value not found", driver, className, methodName);
    		assertTrue(isTextPresent(driver, encounterTemplateTestData.description2),"description2 value not found", driver, className, methodName);
    		assertTrue(isTextPresent(driver, visitOutlineData.ComponenetName),"ComponenetName value not found", driver, className, methodName);
    		assertTrue(isTextPresent(driver, visitOutlineData.SectionName),"SectionName value not found", driver, className, methodName);
    		assertTrue(isElementPresent(driver, image),"Image not found", driver, className, methodName);
   			waitForPageLoad(driver);
      	}
    	catch(Exception e)
    	{
    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
    	}
		return true;
    }
    
    public boolean selectanserfrommultiplecheckbox(WebDriver driver,By selectionElement,String Value )
    {
   try{
        int close=0; 
        verifyTrue(click(driver,selectionElement),"Could not click the answer check box", driver);                  
        for(int count=1;count<=getXpathCount(driver,selectanserlabel);count++)     {             
               By label=     By.xpath("(//*[contains(@class,'gwt-CheckBox checkBoxSelectEntry checkbox-group')])["+count+"]");                       
               if(getText(driver,label).contains(Value)){
                     By checkbox=By.id(count+"checkbox");
                     verifyTrue(click(driver,checkbox),"Could not click the answer check box", driver);
                     verifyTrue(click(driver,btnCloseSelection),"Could not click the Close button", driver);
                      close=1;
                      break;
                            }
               
        }
        if(close!=1)
        {
               verifyTrue(click(driver,btnCloseSelection),"Could not click the Close button", driver);      
        }
        assertTrue(getText(driver,selectionElement ).contains(Value),"Value is not selected ", driver, className, methodName);
        
 }
 catch(Exception e)
 {
        assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
 }
        return true;
 
}

    /**
     * Create New Order Lab Test
     * Function to Create New Order Lab Test
     *  @param 	driver
     * @param 	labOrderPage
     * @throws Exception  
     * @since	May 12, 2015
     */  

    
    


    public void createDIOrder(WebDriver driver,ChartPreVisitLib diData,LabOrderPage labOrderPage)   {
    	
    try {
		labOrderPage.orderNewDi(driver,diData);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    waitForPageLoad(driver);
    }
    /**
     * verifyPracticeDetailsOnThePage
		 * Function to verify practice details in the page
		 * @param 	driver
		 * @param   encounterTemplateTestData
	  	 * @throws Exception 
		 * @since	May 12,2015
		 * @Version 2.1
		 */ 
    public boolean verifyPracticeDetailsOnThePage(WebDriver driver,ChartPreVisitLib letterTemplateTestData)
    {
    	try{
    		assertTrue(isTextPresent(driver,letterTemplateTestData.primaryPhone),"unable to find primary phone number in the page",driver,className,methodName); 
    		assertTrue(isTextPresent(driver,letterTemplateTestData.primaryPhoneExtn),"unable to find primary phone number Extension in the page",driver,className,methodName); 
    		assertTrue(isTextPresent(driver,letterTemplateTestData.BussinessPhone),"unable to find Bussiness fax number in the page",driver,className,methodName); 
    		assertTrue(isTextPresent(driver,letterTemplateTestData.BussinessPhoneExtn),"unable to find Bussiness fax extn number in the page",driver,className,methodName);
    		assertTrue(isTextPresent(driver,letterTemplateTestData.addressLine1),"unable to find ADDRESS line 1  in the page",driver,className,methodName); 
    		assertTrue(isTextPresent(driver,letterTemplateTestData.addressLine2 ),"unable to find ADDRESS line 2 in the page",driver,className,methodName);
    		assertTrue(isTextPresent(driver,letterTemplateTestData.city),"unable to find city in the page",driver,className,methodName); 
    		assertTrue(isTextPresent(driver,letterTemplateTestData.state),"unable to find state in the page",driver,className,methodName); 
    		assertTrue(isTextPresent(driver,letterTemplateTestData.zipCode),"unable to find zip code in the page",driver,className,methodName); 
      	}
    	catch(Exception e)
    	{
    		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
    	}
		return true;
    }


    
    
    /**
  		 * goToCreateOrderLabTest
  		 * Function to Navigate To Create Order Lab Test Page 
  		 * @param 	driver
  		 * @throws  Exception 
  	  	 * @since	Jan 28,2015
  		 */  
      
      public LabOrderPage goToCreateOrderDITest(WebDriver driver)   {
    	 
      	assertTrue(click(driver, imgDIOrder),"Could not click order new lab icon",driver, className, methodName);
      	waitForPageLoad(driver);
      	
      	return new LabOrderPage();
      	
  	}

      /**
    		 * goToCreateDI
    		 * Function to Navigate To Create DI Page 
    		 * @param 	driver
    		 * @throws  Exception 
    	  	 * @since	May 26,2015
    		 */  
        
        public DiagnosticImagingPage goToCreateDI(WebDriver driver)   {
      	 
        	assertTrue(click(driver, imgDIOrder),"Could not click order new lab icon",driver, className, methodName);
        	waitForPageLoad(driver);
        	
        	return new DiagnosticImagingPage();
        	
    	}

    	/**
    	 * createDIReport 
    	 * function to a create DI Report
    	 * @param driver,ChartPreVisitLib- Data for DI,userAccount
    	 * @since May 26, 2015
    	 * @version 2.1
    	 */

    	public boolean createDIReport(WebDriver driver,ChartPreVisitLib proData, String account, DiagnosticImagingPage diagnosticImagingPage)   {
    		try {
    			diagnosticImagingPage.createDIReport(driver, proData, account);
    		}
    		catch (Exception e) {
    			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
    }
    		return true;
    	}

    	/**
    	 * clickSaveDI 
    	 * function to a save DI
    	 *@since May 26, 2015
    	 * @version 2.1
    	 */
    	
    	public boolean clickSaveDI(WebDriver driver, DiagnosticImagingPage diagnosticImagingPage)
    	{
    		try{
    			diagnosticImagingPage.clickSaveDI(driver);
    			waitForPageLoad(driver);
    		}
    		catch (Exception e) {
    			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
    }
    		return true;
    	}

        /**
  		 * editDIReport
  		 * Function to Navigate To Edit Di report Page 
  		 * @param 	driver
  		 * @throws  Exception 
  	  	 * @since	May 26,2015
  		 */  
      
      public DiagnosticImagingPage editDIReport(WebDriver driver)   {
    	 
      	assertTrue(click(driver, lblRecAndPlanItem),"Could not click order new lab",driver, className, methodName);
      	waitForPageLoad(driver);
      	assertTrue(click(driver, txtEdit),"Could not click Edit",driver, className, methodName);
      	waitForPageLoad(driver);
      	
      	return new DiagnosticImagingPage();
      	
  	}

      /**
		 * goToCreateOrderLabTest
		 * Function to Navigate To Create Order Lab Test Page 
		 * @param 	driver
		 * @throws  Exception 
	  	 * @since	Jan 28,2015
		 */  
    
    public LabOrderPage editDiOrder(WebDriver driver)   {
  	 
    	assertTrue(click(driver, lblDiordere),"Could not click order new lab icon",driver, className, methodName);
    	waitForPageLoad(driver);
    	assertTrue(click(driver, txtEdit),"Could not click order new lab icon",driver, className, methodName);
    	waitForPageLoad(driver);
    	
    	return new LabOrderPage();
    	
	}
    
    /**
	 * goToCreateOrderLabTest
	 * Function to Navigate To Create Order Lab Test Page 
	 * @param 	driver
	 * @throws  Exception 
  	 * @since	Jan 28,2015
	 */  

public boolean verifyDefaultWidgetValues(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)   {
	try{
		assertTrue(getValue(driver,txtNumericWidget).contains(encounterTemplateTestData.Minvalue)  ,"Numeric widget does have default value ",driver, className, methodName);
		click(driver,lnkQuestionWidget);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.Answer1) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.Answer2) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.Answer3) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.Answer4) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.Answer5) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.Answer6) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.Answer7) ,"Entered answers is not present in question widget",driver, className, methodName);
		click(driver,btnCloseSelection);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.Answer8) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.Answer9) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.answer10) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue(getValue(driver,ajxQuestionWidget).contains(encounterTemplateTestData.answer18)  ,"Default value in not present in question widget with 8 Answers",driver, className, methodName);
		click(driver,ajxQuestionWidget);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.answer11) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.answer12) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.answer13) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.answer14) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.answer15) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.answer16) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.answer17) ,"Entered answers is not present in question widget",driver, className, methodName);
		assertTrue( isTextPresent(driver,encounterTemplateTestData.answer18) ,"Entered answers is not present in question widget",driver, className, methodName);
		return true;
	}
	 catch(Exception e)
	 {
		  assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);	 
	 }	
	return true;
}
    

    
    
         /**
         * selectProviderInReferralPage
		 * Function to select provider in the sugg box
		 * @param 	driver
		 * @param   encounterTemplateTestData
	  	 * @throws Exception 
		 * @since	May 12,2015
		 * @Version 2.1
		 */ 
    public boolean selectProviderInReferralPage(WebDriver driver,ChartPreVisitLib letterTemplateTestData)
    {
    	try{
    		 waitForPageLoad(driver);
    		 assertTrue(selectValueFromAjaxList(driver,ajxProviderSuggBox,letterTemplateTestData.provider),"unable to select the value in the provider sugg box",driver,className,methodName);
    		 waitForPageLoad(driver);
      	}
    	catch(Exception e)
    	{
    		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
    	}
		return true;
    }
    
    
    
    /**
     * verifyPayersDetailsOnThePage
	 * Function to verify payer details on the page
	 * @param 	driver
	 * @param   encounterTemplateTestData
  	 * @throws Exception 
	 * @since	May 12,2015
	 * @Version 2.1
	 */ 
        public boolean verifyPayersDetailsOnThePage(WebDriver driver,HomeLib payerData,HomeLib patientData)
        {
	      try{
	    	  assertTrue(isTextPresent(driver,payerData.payerName),"unable to find the payer name",driver,className,methodName);
	    	  assertTrue(isTextPresent(driver,payerData.dob),"unable to find the DOB",driver,className,methodName);
	    	  assertTrue(isTextPresent(driver,payerData.payerCode),"unable to find the payer code",driver,className,methodName);
	    	  assertTrue(isTextPresent(driver,patientData.firstName),"unable to find member ID",driver,className,methodName);
	    	  assertTrue(isTextPresent(driver,patientData.lastName),"unable to find member ID",driver,className,methodName);
  	     }
	     catch(Exception e)
	     {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	     }
	    return true;
}

        
        /**
         * verifySuperBillPageNotPresent
    	 * Function to verify SuperBill Page Not Present asfter sign the encounter 
    	 * @param 	driver
    	 * @param   encounterTemplateTestData
      	 * @throws Exception 
    	 * @since	May 12,2015
    	 * @Version 2.1
    	 */ 
            public boolean verifySuperBillPageNotPresent(WebDriver driver)
            {
    	      try{
    	    	  
    	    	  assertTrue(!isTextPresent(driver,"Complete Superbill"),"Super bill page is present",driver,className,methodName);
    	    	  assertTrue(!isElementPresent(driver,lnkPostCharge),"Super bill page is present",driver,className,methodName);
      	     }
    	     catch(Exception e)
    	     {
    		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
    	     }
    	    return true;
    }

        /**
         * uploadImageInEncounter
    		 * Function to upload Image In Encounter 
    		 * @param 	driver
    		 * @param   encounterTemplateTestData
    	  	 * @throws Exception 
    		 * @since	May 18,2015
    		 * @Version 2.1
    		 */ 
        public boolean uploadImageInEncounter(WebDriver driver, ClinicalSettingLib encounterTemplateTestData)
        {
        	try{
       		   scrollDown(driver);
       		   scrollDown(driver);
        		assertTrue(isElementPresent(driver, lnkUploadImage),"Upload Image link not found", driver, className, methodName);
       			waitForPageLoad(driver);
				File dir1 = new File(".");
				String strBasePath = null;
				String file = null;
				String xmlName = encounterTemplateTestData.imageFileName;
				String sectionName = "clinicalsettings";
				strBasePath = dir1.getCanonicalPath();
				file = strBasePath + File.separator + "src" + File.separator+ "main" + File.separator + "resources" + File.separator+ "nexia" + File.separator + "testdata" + File.separator+ sectionName + File.separator + xmlName;
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("return document.getElementById('imageBrowseButton-browse-anchor').click()");
				waitForPageLoad(driver);
				WebElement element = driver.findElement(By.id("imageBrowseButton-file-upload"));
				element.sendKeys(file);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				Robot robot = null;
				robot = new Robot();
				Thread.sleep(5000);
				robot.keyPress(KeyEvent.VK_ESCAPE); 
            	robot.keyRelease(KeyEvent.VK_ESCAPE);		
				 if(isElementPresent(driver, btnErrorClose))
					 verifyTrue(click(driver, btnErrorClose),"could not click error close", driver);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
        		assertTrue(isElementPresent(driver, image),"Uploaded Image not found", driver, className, methodName);

        	}
        	catch(Exception e)
        	{
        		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
        	}
    		return true;
        }
    
        /**
         *  deleteUploadedImageInEncounter
    		 * Function to delete the uploaded Image In Encounter 
    		 * @param 	driver
    	  	 * @throws Exception 
    		 * @since	May 18,2015
    		 * @Version 2.1oo
    		  */
        public boolean deleteUploadedImageInEncounter(WebDriver driver)
        {
        	try{
       		   scrollDown(driver);
       		   scrollDown(driver);
        		assertTrue(isElementPresent(driver, lnkDeleteImage),"Delete link not found", driver, className, methodName);
       			waitForPageLoad(driver);
        		assertTrue(click(driver, lnkDeleteImage),"Delete link not found", driver, className, methodName);
       			waitForPageLoad(driver);
       			waitForPageLoad(driver);
        		assertTrue(!isVisible(driver, image),"Uploaded Image is not deleted", driver, className, methodName);
        	}
        	catch(Exception e)
        	{
        		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
        	}
    		return true;
        }

        /**
         * getImageDimension
    		 * Function to compare Deleted And Newly Uploaded image
    		 * @param 	driver
         * @param dimesions 
    	  	 * @throws Exception 
    		 * @since	May 18,2015
    		 * @Version 2.1
    		 */ 
        public Dimension getImageDimension(WebDriver driver, Dimension dimesions)
        {
        	try{
       		   scrollDown(driver);
       		   scrollDown(driver);
       		   dimesions=driver.findElement(By.cssSelector("image")).getSize();
       		   waitForPageLoad(driver);

        	}
        	catch(Exception e)
        	{
        		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
        	}
   			return dimesions;
        }

        /**
         * verifyNewlyUploadedImage
    		 * Function to verify Newly Uploaded Image 
    		 * @param 	driver
    	  	 * @throws Exception 
    		 * @since	May 18,2015
    		 * @Version 2.1
    		 */ 
        public boolean verifyNewlyUploadedImage(WebDriver driver, Dimension dimension1, Dimension dimension2)
        {
        	try{
        		if(dimension1==dimension2)
        			Assert.fail("Newly uploaded image not avaialble");
        		waitForPageLoad(driver);
        	}
        	catch(Exception e)
        	{
        		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
        	}
    		return true;
        }

        /**
         * goToEncounterFamilyHistory
    		 * Function to go To Encounter FamilyHistory
    		 * @param 	driver
    	  	 * @throws Exception 
    		 * @since	May 20,2015
    		 * @Version 2.1
    		 */ 
        public FamilyHistoryPage goToEncounterFamilyHistory(WebDriver driver)
        {
        	try{
        	verifyTrue(click(driver, lnkEncounterFamilyHistory),"Could not on click on FamilyHistory link",driver);
        	waitForPageLoad(driver);
        	}
        	catch(Exception e)
        	{
        		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
        	}
        	return new FamilyHistoryPage();
        }

    	/**
    	 * createAllergyEndToEnd
    	 * function to create Allergy
    	 * @param allergyData
    	 * @param driver
    	 * @param account
    	 * @throws Exception 
    	 * @since May 21, 2015
    	 */
    	public boolean createAllergyEndToEnd(WebDriver driver,ChartPreVisitLib allergyData, String account, AllergyPage allergyPage) throws Exception {
    		try {
    			allergyPage.createAllergyEndToEnd(driver, allergyData, account);
            	waitForPageLoad(driver);
            	}
            	catch(Exception e)
            	{
            		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
            	}
            	return true;
            }

    	/**
    	 * createFamilyHistory 
    	 * function to create FamilyHistory
    	 * @param driver
    	 * @param historyData
    	 * @throws IOException 
    	 * @since May 20, 2015
    	 */
    	public boolean createFamilyHistory(WebDriver driver, ChartPreVisitLib historyData, FamilyHistoryPage familyHistoryPage) throws IOException {
    		try {
    			familyHistoryPage.createFamilyHistory(driver, historyData);
            	waitForPageLoad(driver);
        	}
        	catch(Exception e)
        	{
        		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
        	}
        	return true;
        }
    			
}
