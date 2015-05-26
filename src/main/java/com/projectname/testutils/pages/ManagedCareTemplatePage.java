package com.projectname.testutils.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.Constants;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class ManagedCareTemplatePage extends SeleniumWebDriver {

	public ManagedCareTemplatePage(){
		 PageFactory.initElements(TestBaseClass.driver, this);	
			SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	private By readyLocator=By.id("createCustomTmplbtn");
	private By btnDelete=By.id("deletetBtn");
	private By btnYes=By.id("yesButton");
	private By lnkEditFlowSheets=By.xpath("(//a[contains(text(),'Edit')])[4]");
	private By btnAddCareElement=By.cssSelector("button.secondary-button.left-button-spacer");
	private By ajxCategory=By.id("categoryPanelsuggestBox");
	private By ajxCareElementPanelsuggestBox=By.id("careElementPanelsuggestBox");
	private By txtDisplayAs=By.id("displayAsTextBox");
	private By btnSaveAnother =By.id("saveAnother");
	private By btnAddCategory=By.cssSelector("button.secondary-button");
	
	private By ajxTargetCarepanel=By.xpath("(//input[@id='categoryPanelsuggestBox'])[3]");
	private By txtLowerheight=By.id("minTextBox");
	private By txtUpperheight=By.id("maxTextBox");
	private By ajxHeightSuggest=By.id("heightBoxsuggestBox");
	private By lnkTargetExceptions =By.id("clickToAdd");
	private By lnkTargetExceptionType =By.id("ageSuggestBoxsuggestBox");
	private By txtUprHeightExcep =By.id("maxSystoli");
	private By txtLwrHeightExcep =By.id("minSystoli");
   
	private By ajxPatientType =By.id("sexSuggestBoxsuggestBox");
	private By ajxConditionType =By.id("yearsSuggestBoxsuggestBox");
	private By txtLwrAgeLmt =By.id("yearsAgeMin");
	private By txtUprAgeLmt =By.id("yearsAgeMax");
	private By txtConditionAgeDuration =By.xpath("(//input[@id='sexSuggestBoxsuggestBox'])[2]");
	private By btnSaveTargetExp =By.xpath("//button[@id='save']");
	private By btnSave=By.id("saveButton");
	private By btnCreateCustom =By.id("createCustomTmplbtn");
	private By lnkSave=By.linkText("Save");
	private By ajxCarepanel=By.xpath("(//input[@id='categoryPanelsuggestBox'])[2]");
	private By DeleteCareElement = By.xpath("//a[contains(@id,'remove_CareElment')]");
	private By DeleteCategory = By.xpath("//a[contains(@id,'remove_CareCategory')]");
	private By txtCategory=By.cssSelector("input.text-box");
	private By btnSaveCategory=By.cssSelector("div.popup-buttons > button.secondary-button");
    private By btnCreateCustomTemplate=By.id("createCustomTmplbtn");
    private By txtTemplateName=By.id("templateName");
    private By txtTemplateDescription=By.id("templateDescription");
    private By lnkStartBlank=By.id("startBlankTemplate");
    private By chkBoxFlowSheets=By.xpath("//span[@id='Flowsheet_itemCheckBox']/input");
    private By btnSaveWidget=By.id("save");
    private By templatePanel=By.id("templateFocusPanel");
    private By editBtn=By.id("editBtn");
	private By txtDue=By.id("dueEveryTextBox");
	private By ajxDueType=By.id("monthsPanel1suggestBox");
	private By txtUpcoming=By.id("upcomingTextBox");
	private By ajxAdvanceDue=By.id("upcomingPanel1suggestBox");
	private By lnkClickToSelect=By.linkText("Click to select");
	private By ajxSearchImmunization = By.xpath("//div[@id='searchPanel']/input");
	private By chkImmunization1=By.xpath("//input[contains(@id,'elementCheckBox')]");
	private By lnkDelete=By.linkText("Delete");
	private By lnkClose=By.cssSelector("a.close-x");
	private By ajxMedicationName = By.xpath("//input[@id='medicationSuggestBoxsuggestBox']");
	private By ajxDrugName = By.xpath("//input[@id='medicationClassSuggestBoxsuggestBox']");

   
	public boolean deleteAllManagedCareTemplate(WebDriver driver) throws Exception{
	try{
		int count=1;
		while(isElementPresent(driver,btnDelete)){
			assertTrue(click(driver, btnDelete), "Could not click on delete button", driver, className, methodName);
			assertTrue(click(driver, btnYes), "Could not click on delete button", driver, className, methodName);
			waitForPageLoad(driver);
			if(count<15){
				break;
			}
		}
	}catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
    }
		return true;
	}
	public boolean SaveManagedCareCustomWidgetCareElement(WebDriver driver,ClinicalSettingLib mcTemplate)
	{
		if(!mcTemplate.testCaseId.equals("TC_MCT_022")&&!mcTemplate.testCaseId.equals("TC_MCT_027")&&!mcTemplate.testCaseId.equals("TC_MCT_033")&&!mcTemplate.testCaseId.equals("TC_MCT_056")){
			assertTrue(click(driver, btnSave), "Could not click save", driver, className, methodName);
			waitForPageLoad(driver);
			
			assertTrue(isElementPresent(driver, btnCreateCustom), "Immunization care element addition failed", driver, className, methodName);
		}
		else{
				assertTrue(click(driver, lnkSave), "Could not click save", driver, className, methodName);
				waitForPageLoad(driver);
		}
		
		return true;
	}
	
	
	public boolean addCustomWidgetCareElement(WebDriver driver,ClinicalSettingLib mcTemplate,String uniqueName,String numberOfTime) throws Exception{
		if(!isChecked(driver,chkBoxFlowSheets))
		{
			assertTrue(click(driver,chkBoxFlowSheets),"Unable to click the check box",driver,className,methodName);
		}
		waitForElement(driver,lnkEditFlowSheets,Constants.WAIT_TIME);
		assertTrue(click(driver, lnkEditFlowSheets), "Could not click on edit flow sheets", driver, className, methodName);
		if(numberOfTime.equals("firstTime"))
		{
		if(!mcTemplate.testCaseId.equals("TC_MCT_027")&&!mcTemplate.testCaseId.equals("TC_MCT_056")&&!mcTemplate.testCaseId.equals("TC_MCT_045")){
		assertTrue(deleteandaddCategory(driver, mcTemplate), "Adding category failed", driver, className, methodName);
		}
		}
		assertTrue(click(driver, btnAddCareElement), "Could not click on Add button", driver, className, methodName);
		waitForPageLoad(driver);
		assertTrue(selectValueFromAjaxList(driver,ajxCategory,mcTemplate.category),"Could not category", driver, className, methodName);	
		assertTrue(selectValueFromAjaxList(driver,ajxCareElementPanelsuggestBox,mcTemplate.category),"Could not select custom widget", driver, className, methodName);	
		assertTrue(type(driver, txtDisplayAs,mcTemplate.display), "Could not type display as", driver, className, methodName);
		if(numberOfTime.equals("firstTime"))
		{
		assertTrue(selectValueFromAjaxList(driver,ajxCarepanel,mcTemplate.textTemplateName),"Could not type due type", driver, className, methodName);
		}
		if(numberOfTime.equals("numeric"))
		{
		assertTrue(selectValueFromAjaxList(driver,ajxCarepanel,mcTemplate.numericTemplateName),"Could not type due type", driver, className, methodName);
		}
		if(numberOfTime.equals("Question1"))
		{
		assertTrue(selectValueFromAjaxList(driver,ajxCarepanel,mcTemplate.questionTemplateOne),"Could not type due type", driver, className, methodName);
		}
		if(numberOfTime.equals("Question2"))
		{
		assertTrue(selectValueFromAjaxList(driver,ajxCarepanel,mcTemplate.questionTemplateTwo),"Could not type due type", driver, className, methodName);
		}
		if(numberOfTime.equals("Question3"))
		{
		assertTrue(selectValueFromAjaxList(driver,ajxCarepanel,mcTemplate.questionTemplateThree),"Could not type due type", driver, className, methodName);
		}
		if(numberOfTime.equals("Question4"))
		{
		assertTrue(selectValueFromAjaxList(driver,ajxCarepanel,mcTemplate.questionTemplateFour),"Could not type due type", driver, className, methodName);
		}
		if(numberOfTime.equals("Question5"))
		{
		assertTrue(selectValueFromAjaxList(driver,ajxCarepanel,mcTemplate.deleteCategory),"Could not type due type", driver, className, methodName);
		}
		assertTrue(click(driver,btnSaveWidget),"could not click save",driver,className,className);
		waitForPageLoad(driver);
		if(!mcTemplate.testCaseId.equals("TC_MCT_032")){
	    assertTrue(isElementPresent(driver, btnAddCategory), "Immunization care element addition failed", driver, className, methodName);
		assertTrue(click(driver, lnkSave), "Could not click save", driver, className, methodName);
		waitForPageLoad(driver);
		}
		else 
		{
			assertTrue(click(driver, btnSaveAnother), "Could not click save", driver, className, methodName);
			waitForPageLoad(driver);	
			return true;
		}
		//assertTrue(isElementPresent(driver, btnAddCategory), "Immunization care element addition failed", driver, className, methodName);
		return true;
	}
	
	public boolean deleteandaddCategory(WebDriver driver,ClinicalSettingLib mcTemplate){
		try {
		if(isElementPresent(driver,DeleteCareElement)) {
		assertTrue(click(driver, DeleteCareElement), "Could not delete care element", driver, className, methodName);
		assertTrue(click(driver, btnYes), "Could not click on yes", driver, className, methodName);
		}
		if(isElementPresent(driver,DeleteCategory)) {
		assertTrue(click(driver, DeleteCategory), "Could not delete category", driver, className, methodName);
		assertTrue(click(driver, btnYes), "Could not yes", driver, className, methodName);
		}
		assertTrue(click(driver, btnAddCategory), "Could not click on add new category", driver, className, methodName);
		assertTrue(type(driver, txtCategory,mcTemplate.category), "Could not type category", driver, className, methodName);
		assertTrue(click(driver, btnSaveCategory), "Could not click on save category", driver, className, methodName);
		waitForPageLoad(driver);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	public boolean editManagedCareTemplatePage(WebDriver driver)
	{
		assertTrue(click(driver,editBtn),"unable to click the edit button in managed care template",driver,className,methodName);
		waitForPageLoad(driver);
		return true;
	}
	
	public boolean startNewManagedCareTemplate(WebDriver driver,ClinicalSettingLib mcTemplate,String uniqueName)
	{
	try{
		assertTrue(click(driver,btnCreateCustomTemplate),"Unable to click the start new template button",driver,className,methodName);
		waitForElement(driver,lnkStartBlank,Constants.WAIT_TIME);
		assertTrue(type(driver,txtTemplateName,mcTemplate.templateName+uniqueName),"Unable to enter the template name",driver,className,methodName);
		assertTrue(type(driver,txtTemplateDescription,mcTemplate.templateDescription),"Unable to enter the template description",driver,className,methodName);
		assertTrue(click(driver,lnkStartBlank),"Unable to click the start new template",driver,className,methodName);
	}catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
    }
		return true;
	}
	
	
	
	
	public boolean verifyMangaedCareTemplate(WebDriver driver,ClinicalSettingLib mcTemplate,String uniqueName)throws Exception
	{
		assertTrue(getText(driver,templatePanel).contains(mcTemplate.templateName+uniqueName),"Unable to find the template name",driver,className,methodName);
		assertTrue(getText(driver,templatePanel).contains(mcTemplate.templateDescription),"unable to find the template description",driver,className,methodName);
		return true;
	}
	
	/**
	 * addImmunizationCareElement 
	 * Function to add Immunization Care Element
	 * @param 	driver, mcTemplate, uniqueName, account
	 * @throws IOException 
	 * @since	Mar 16,2015
	 */
	public boolean addImmunizationCareElement(WebDriver driver,ClinicalSettingLib mcTemplate,String uniqueName,String account) throws IOException{
	try{
		verifyTrue(click(driver, lnkEditFlowSheets), "Could not click on edit flow sheets", driver);
		waitForPageLoad(driver);
		if (mcTemplate.deleteCategory.equals("Yes")){
			verifyTrue(deleteandaddCategory(driver, mcTemplate), "Adding category failed", driver);
			waitForPageLoad(driver);
			}
		verifyTrue(click(driver, btnAddCareElement), "Could not click on Add button", driver);
		waitForPageLoad(driver);
		if (!mcTemplate.category.equals("")){
		verifyTrue(selectValueFromAjaxList(driver,ajxCategory,mcTemplate.category),"Could not category", driver);
		waitForPageLoad(driver);
		}
		
		verifyTrue(selectValueFromAjaxList(driver,ajxCareElementPanelsuggestBox,"Immunizations"),"Could not select Immunizations", driver);
		waitForPageLoad(driver);
		
		if (!mcTemplate.display.equals("")){
		verifyTrue(type(driver, txtDisplayAs,mcTemplate.display), "Could not type display as", driver);
		waitForPageLoad(driver);
		}
		if (!mcTemplate.due.equals("")){
		verifyTrue(type(driver, txtDue,mcTemplate.due), "Could not type due", driver);
		waitForPageLoad(driver);
		}
		if (!mcTemplate.dueType.equals("")){
		verifyTrue(selectValueFromAjaxList(driver,ajxDueType,mcTemplate.dueType),"Could not type due type", driver);
		waitForPageLoad(driver);
		}
		if (!mcTemplate.due.equals("")){
		verifyTrue(type(driver, txtUpcoming,mcTemplate.due), "Could not type due", driver);
		waitForPageLoad(driver);
		}
		if (!mcTemplate.dueType.equals("")){
		verifyTrue(selectValueFromAjaxList(driver,ajxAdvanceDue,mcTemplate.dueType),"Could not type due type", driver);
		waitForPageLoad(driver);
		}
		if (!mcTemplate.immunization.equals("")){
		verifyTrue(click(driver, lnkClickToSelect), "Could not click on select link", driver);
		waitForPageLoad(driver);
		
		if(!account.equals(Constants.CAACCOUNT)){
			verifyTrue(selectValueFromAjaxList(driver, ajxSearchImmunization,mcTemplate.immunization), "Could not type due", driver);
			waitForPageLoad(driver);
		}else{
			verifyTrue(selectValueFromAjaxList(driver, ajxSearchImmunization,mcTemplate.immunization), "Could not type due", driver);
			waitForPageLoad(driver);
		}
		if(!isChecked(driver,chkImmunization1)){
			verifyTrue(click(driver, chkImmunization1), "Could not check Immunization", driver);
			waitForPageLoad(driver);
		}
		
		if(isElementPresent(driver,lnkDelete)){
			verifyTrue(click(driver, lnkClose), "Could not click close", driver);
			waitForPageLoad(driver);
		}
		}
	}
	catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	}

		return true;
	}
	/**
	 * addVitalsCareElement 
	 * Function to add Vitals Care Element
	 * @param 	driver, mcTemplate, uniqueName, account
	 * @throws IOException 
	 * @since	Mar 18,2015
	 */
public boolean addVitalsCareElement(WebDriver driver,ClinicalSettingLib mcTemplate) {
	try{
		verifyTrue(click(driver, lnkEditFlowSheets), "Could not click on edit flow sheets", driver);
		waitForPageLoad(driver);
		if (mcTemplate.deleteCategory.equals("Yes")){
			verifyTrue(deleteandaddCategory(driver, mcTemplate), "Adding category failed", driver);
			waitForPageLoad(driver);
		}
		
		verifyTrue(click(driver, btnAddCareElement), "Could not click on Add button", driver);
		waitForPageLoad(driver);
		
		if (!mcTemplate.category.equals("")){
		verifyTrue(selectValueFromAjaxList(driver,ajxCategory,mcTemplate.category),"Could not category", driver);
		waitForPageLoad(driver);
		}
		
		verifyTrue(selectValueFromAjaxList(driver,ajxCareElementPanelsuggestBox,"Vitals"),"Could not select Care element type", driver);
		waitForPageLoad(driver);
		
		if (!mcTemplate.display.equals("")){
		verifyTrue(type(driver, txtDisplayAs,mcTemplate.display), "Could not type Vital display as", driver);
		waitForPageLoad(driver);
		}
		
		if (!mcTemplate.due.equals("")){
		verifyTrue(type(driver, txtDue,mcTemplate.due), "Could not type due", driver);
		waitForPageLoad(driver);
		}
		if (!mcTemplate.dueType.equals("")){
		verifyTrue(selectValueFromAjaxList(driver,ajxDueType,mcTemplate.dueType),"Could not type due type", driver);
		waitForPageLoad(driver);
		}
		// Upcoming
		if (!mcTemplate.due.equals("")){
		verifyTrue(type(driver, txtUpcoming,mcTemplate.due), "Could not type due", driver);
		waitForPageLoad(driver);
		}
		if (!mcTemplate.dueType.equals("")){
		verifyTrue(selectValueFromAjaxList(driver,ajxAdvanceDue,mcTemplate.dueType),"Could not type due type", driver);
		waitForPageLoad(driver);
		}
		
		if (!mcTemplate.measurement.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,ajxCarepanel,mcTemplate.measurement),"Could not type due type", driver);
			waitForPageLoad(driver);
			}
		if (!mcTemplate.targetType.equals("")){
		    verifyTrue(selectValueFromAjaxList(driver,ajxTargetCarepanel,mcTemplate.targetType),"Could not select target Type", driver);
			waitForPageLoad(driver);
		}
		if (!mcTemplate.heightUpperLimit.equals("")){
			verifyTrue(type(driver, txtUpperheight,mcTemplate.heightUpperLimit), "Could not type upper limit height", driver);
			waitForPageLoad(driver);
		}
		if (!mcTemplate.heightLowerLimit.equals("")){
			verifyTrue(type(driver, txtLowerheight,mcTemplate.heightLowerLimit), "Could not type lower limit height", driver);
			waitForPageLoad(driver);
		}
		verifyTrue(click(driver, lnkTargetExceptions), "Could not click on add target exceptions link", driver);
			waitForPageLoad(driver);
		if (!mcTemplate.targetExceptionType.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,lnkTargetExceptionType,mcTemplate.targetExceptionType),"Could not select target exception type", driver);
			waitForPageLoad(driver);
		}
		if (!mcTemplate.eheightUpperLimit.equals("")){
		    verifyTrue(type(driver,txtUprHeightExcep,mcTemplate.eheightUpperLimit), "Could not type Upper limit height", driver);
			waitForPageLoad(driver);
		}
		if (!mcTemplate.eheightLowerLimit.equals("")){
			verifyTrue(type(driver,txtLwrHeightExcep,mcTemplate.eheightLowerLimit), "Could not type Lower limit height", driver);
			waitForPageLoad(driver);
		}
		if (!mcTemplate.measurementScale.equals("")){
		//	verifyTrue(selectValueFromAjaxList(driver,ajxHeightSuggest,mcTemplate.measurementScale),"Could not select height suggest type", driver);
			waitForPageLoad(driver);
		}
		if (!mcTemplate.forWho.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,ajxPatientType,mcTemplate.forWho),"Could not select measurement", driver);
			waitForPageLoad(driver);
		}
		if (!mcTemplate.condtionType.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,ajxConditionType,mcTemplate.condtionType),"Could not select measurement",driver);
			waitForPageLoad(driver);
		}
		if (!mcTemplate.condtionAge.equals("")){
			verifyTrue(type(driver, txtLwrAgeLmt,mcTemplate.condtionAge), "Could not type Lower limit height", driver);
			waitForPageLoad(driver);
		}
		if (!mcTemplate.conditionAgeIn.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,txtConditionAgeDuration,mcTemplate.conditionAgeIn),"Could not select measurement", driver);
			waitForPageLoad(driver);
		}
		
		verifyTrue(click(driver, btnSaveTargetExp), "Could not click save target exception vitals button", driver);
		waitForPageLoad(driver);
		
	}catch (Exception e) {
		 new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
		return true;
	}
	/**
	 *NavigateToFlowSheets
	 * Function to Navigate To Flow Sheets 
	 * @param 	driver
	 * @since	Mar 18,2015
	 */ 

	public boolean navigateToFlowSheets(WebDriver driver)  
	{	 
		try{
			if(!isChecked(driver,chkBoxFlowSheets))
			{
				verifyTrue(click(driver,chkBoxFlowSheets),"Unable to click the check box",driver);
			}
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
		
		return true;
	}

	/**
	 * addMedicationCareElement 
	 * Function to add Medication Care Element
	 * @param 	driver, mcTemplate, account
	 * @throws IOException 
	 * @since	Mar 23,2015
	 */
	public boolean addMedicationCareElement(WebDriver driver,ClinicalSettingLib mcTemplate) {
	try{
		verifyTrue(click(driver, lnkEditFlowSheets), "Could not click on edit flow sheets", driver);
		waitForPageLoad(driver);
		if (mcTemplate.deleteCategory.equals("Yes")){
			verifyTrue(deleteandaddCategory(driver, mcTemplate), "Adding category failed", driver);
			waitForPageLoad(driver);
			}
		verifyTrue(click(driver, btnAddCareElement), "Could not click on Add button", driver);
		waitForPageLoad(driver);
		if (!mcTemplate.category.equals("")){
		verifyTrue(selectValueFromAjaxList(driver,ajxCategory,mcTemplate.category),"Could not category", driver);
		waitForPageLoad(driver);
		}
		
		verifyTrue(selectValueFromAjaxList(driver,ajxCareElementPanelsuggestBox,"Medications"),"Could not select Care element type", driver);
		waitForPageLoad(driver);
		
		if (!mcTemplate.display.equals("")){
		verifyTrue(type(driver, txtDisplayAs,mcTemplate.display), "Could not type Vital display as", driver);
		waitForPageLoad(driver);
		}
		
		if (!mcTemplate.due.equals("")){
		verifyTrue(type(driver, txtDue,mcTemplate.due), "Could not type due", driver);
		waitForPageLoad(driver);
		}
		if (!mcTemplate.dueType.equals("")){
		verifyTrue(selectValueFromAjaxList(driver,ajxDueType,mcTemplate.dueType),"Could not type due type", driver);
		waitForPageLoad(driver);
		}
		
		if (!mcTemplate.due.equals("")){
		verifyTrue(type(driver, txtUpcoming,mcTemplate.due), "Could not type due", driver);
		waitForPageLoad(driver);
		}
		if (!mcTemplate.dueType.equals("")){
		verifyTrue(selectValueFromAjaxList(driver,ajxAdvanceDue,mcTemplate.dueType),"Could not type due type", driver);
		waitForPageLoad(driver);
		}
		
		if (!mcTemplate.medicationName1.equals("")){
		verifyTrue(selectValueFromAjaxList(driver, ajxMedicationName,mcTemplate.medicationName1), "Could not type Vital display as", driver);
		waitForPageLoad(driver);
		}

		if (!mcTemplate.DrugClassName1.equals("")){
		verifyTrue(selectValueFromAjaxList(driver, ajxDrugName,mcTemplate.DrugClassName1), "Could not type Vital display as", driver);
		waitForPageLoad(driver);
		}

	}
	catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
		return true;
	}

	
	/**
	 * saveCareElement 
	 * Function to Save Care Element
	 * @param 	driver
	 * @throws IOException 
	 * @since	Mar 23,2015
	 */
	public boolean saveCareElement(WebDriver driver) {
	try{
		verifyTrue(click(driver, btnSaveWidget), "Could not click on Save1 button", driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver, lnkSave), "Could not click on Save2 button", driver);
		waitForPageLoad(driver);
	}
	catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
		return true;
	}

	
	/**
	 * saveTemplate 
	 * Function to Save Template
	 * @param 	driver
	 * @throws IOException 
	 * @since	Mar 23,2015
	 */
	public boolean saveTemplate(WebDriver driver) {
	try{
		verifyTrue(click(driver, btnSave), "Could not click on Save button", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
	}
	catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
		return true;
	}

}
