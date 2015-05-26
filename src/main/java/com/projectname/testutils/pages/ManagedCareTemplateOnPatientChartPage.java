package com.projectname.testutils.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.Constants;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class ManagedCareTemplateOnPatientChartPage extends SeleniumWebDriver{

	
	public ManagedCareTemplateOnPatientChartPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	private By readyLocator=By.id("addNewButton");
	private By btnAddNew=By.id("addNewButton");
	private By ajxNameMedication = By.xpath("(//input[@id='suggestBox'])[2]");
	private By removeManagedCare=By.xpath("(//a[contains(@id,'deleteButton')])");
	private By txtBaseLineDate = By.id("baselineDate");
	private By btnTemplateSave=By.id("saveButton");
	private By viewEdit=By.linkText("View/Edit");
	private By flowSheet=By.id("flowsheetName");
	private By linkYes=By.id("yesButton");
	private By suggBox=By.id("suggestBox");
	private By expandButton=By.xpath("(//span[contains(@id,'flowsheetValue')])[3]");
	private By btnOptions=By.xpath("//a[@id='actions']/div");
	private By btnRecord=By.id("recordDataButton");
	private By lnkLabel=By.id("label");
	/*private By ajxSuggBox=By.id("contactModesuggestBox");
	private By ajxSuggBoxProvider=By.id("providersuggestBox");*/
	private By txtArea=By.xpath("(//textarea[contains(@id,'freeTextdescription')])");
	private By ansCheckBox=By.id("ansChkBoxQueRenderDiv1");
	private By actionlink=By.id("actionAnchorEncounter");
	private By lnkSave=By.xpath("//a[@id='saveEncounter']/span");
	private By managedCarePanel=By.id("scrollPanel");
	
	/*private By lnkScheduled=By.linkText("Scheduled");
	private By lnkOnCall=By.linkText("On-Call");
	private By lnkWalkIn=By.linkText("Walk-in");
	private By lnkUrgent=By.linkText("Urgent/Same Day");
	private By lnkCrisis=By.linkText("Crisis/Emergency");
	
	private By lnkProvider1=By.linkText("ABRAHAM, ABBY");
	private By lnkProvider2=By.linkText("SMITH, JOHN");
	private By lnkProvider3=By.linkText("AVOLOK, MARK");
	private By lnkProvider4=By.linkText("Riveria, Nick");*/
	
	
	public void navigateToParticularManagedCareTemplate(WebDriver driver,ClinicalSettingLib mcTemplate,String uniqueName,String account)throws Exception
	{
		String date="";
		assertTrue(click(driver,btnAddNew),"Unable to click the add new button",driver,className,methodName);
    	waitForPageLoad(driver);
    	if(isElementPresent(driver,suggBox))
    	{
    		assertTrue(selectValueFromAjaxList(driver,suggBox,mcTemplate.templateName),"Unable to enter the name of the template",driver,className,methodName);
    	}
    	if(isElementPresent(driver,ajxNameMedication))
    	{
    	assertTrue(selectValueFromAjaxList(driver,ajxNameMedication,mcTemplate.templateName),"Unable to enter the name of the template",driver,className,methodName);
    	}
    	if (account.contains("CA")) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());
		} else if(account.contains("US")) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());
		}
    	assertTrue(enterDate(driver,txtBaseLineDate,date),"Unable to enter the Date",driver,className,methodName);
    	//waitForPageLoad(driver);
    	assertTrue(click(driver,btnTemplateSave),"Unable to click the save button",driver,className,methodName);
    	waitForPageLoad(driver);
	}
	
	
	public void clickViewEdit(WebDriver driver)throws Exception
	{
		verifyTrue(click(driver,viewEdit),"unable to click the view/edit link",driver);
    	waitForPageLoad(driver);
    	waitForPageLoad(driver);
	}

	public void recordValueForManagedCare(WebDriver driver,ClinicalSettingLib mcTemplate)throws Exception
	{
		boolean state=true;
		assertTrue(click(driver,viewEdit),"unable to click the view/edit link",driver,className,methodName);
		waitForElement(driver,flowSheet,Constants.WAIT_TIME*100);
		assertTrue(click(driver,btnOptions),"unable to click the options button",driver,className,methodName);
		waitForElement(driver,btnRecord,Constants.WAIT_TIME);
		assertTrue(click(driver,btnRecord),"unable to click the record data button",driver,className,methodName);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		/*while(state)
		{
			if(isElementPresent(driver,lnkScheduled))
			{
				assertTrue(click(driver,lnkScheduled),"unable to click the link",driver,className,methodName);
				assertTrue(selectValueFromAjaxList(driver,ajxSuggBox,mcTemplate.type),"unable to select scheduled as a ajax list",driver,className,methodName);
				break;
			}
			else if(isElementPresent(driver,lnkOnCall))
			{
				assertTrue(click(driver,lnkOnCall),"unable to click the link",driver,className,methodName);
				assertTrue(selectValueFromAjaxList(driver,ajxSuggBox,mcTemplate.type),"unable to select scheduled as a ajax list",driver,className,methodName);
				break;
			}
			else if(isElementPresent(driver,lnkWalkIn))
			{
				assertTrue(click(driver,lnkWalkIn),"unable to click the link",driver,className,methodName);
				assertTrue(selectValueFromAjaxList(driver,ajxSuggBox,mcTemplate.type),"unable to select scheduled as a ajax list",driver,className,methodName);
				break;
			}
			else if(isElementPresent(driver,lnkUrgent))
			{
				assertTrue(click(driver,lnkUrgent),"unable to click the link",driver,className,methodName);
				assertTrue(selectValueFromAjaxList(driver,ajxSuggBox,mcTemplate.type),"unable to select scheduled as a ajax list",driver,className,methodName);
				break;
			}
			else if(isElementPresent(driver,lnkCrisis))
			{
				assertTrue(click(driver,lnkCrisis),"unable to click the link",driver,className,methodName);
				assertTrue(selectValueFromAjaxList(driver,ajxSuggBox,mcTemplate.type),"unable to select scheduled as a ajax list",driver,className,methodName);
				break;
			}
			else if(state)
			{
				assertTrue(selectValueFromAjaxList(driver,ajxSuggBox,mcTemplate.type),"unable to select scheduled as a ajax list",driver,className,methodName);
				break;
			}
			state=false;
		}
		state=true;
		while(state)
		{
			
			if(isElementPresent(driver,lnkProvider1))
			{
				assertTrue(click(driver,lnkProvider1),"unable to click the link",driver,className,methodName);
				assertTrue(selectValueFromAjaxList(driver,ajxSuggBoxProvider,mcTemplate.referredBy),"unable to select scheduled as a ajax list",driver,className,methodName);
				break;
			}
			else if(isElementPresent(driver,lnkProvider2))
			{
				assertTrue(click(driver,lnkProvider2),"unable to click the link",driver,className,methodName);
				assertTrue(selectValueFromAjaxList(driver,ajxSuggBoxProvider,mcTemplate.referredBy),"unable to select scheduled as a ajax list",driver,className,methodName);
				break;
			}
			else if(isElementPresent(driver,lnkProvider3))
			{
				assertTrue(click(driver,lnkProvider3),"unable to click the link",driver,className,methodName);
				assertTrue(selectValueFromAjaxList(driver,ajxSuggBoxProvider,mcTemplate.referredBy),"unable to select scheduled as a ajax list",driver,className,methodName);
				break;
			}
			else if(isElementPresent(driver,lnkProvider4))
			{
				assertTrue(click(driver,lnkProvider4),"unable to click the link",driver,className,methodName);
				assertTrue(selectValueFromAjaxList(driver,ajxSuggBoxProvider,mcTemplate.referredBy),"unable to select scheduled as a ajax list",driver,className,methodName);
				break;
			}
			else if(state)
			{
				assertTrue(selectValueFromAjaxList(driver,ajxSuggBoxProvider,mcTemplate.referredBy),"unable to select scheduled as a ajax list",driver,className,methodName);
				break;
			}
			state=false;
		}*/
		assertTrue(type(driver,txtArea,mcTemplate.condtionAge),"Unable to type the value in the text box",driver,className,methodName);
		waitForPageLoad(driver);
		assertTrue(click(driver,actionlink),"unable to click the actions link",driver,className,methodName);
		assertTrue(click(driver,lnkSave),"Unable to click the save button",driver,className,methodName);
	}
	
	public boolean verifyOnManagedCareTemplate(WebDriver driver,ClinicalSettingLib mcTemplate)throws Exception
	{
		assertTrue(click(driver,viewEdit),"unable to click the view/edit link",driver,className,methodName);
		waitForElement(driver,flowSheet,Constants.WAIT_TIME*100);
		if(isElementPresent(driver,expandButton))
		{
			click(driver,expandButton);
		}
		assertTrue(getText(driver,managedCarePanel).contains(mcTemplate.condtionAge),"Unable to find the recorded value",driver,className,methodName);
		return true;
	}
	
	public boolean verifyDefaultOnManagedCareTemplate(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)throws Exception
	{
		try
		{
		waitForPageLoad(driver); 
		isTextPresent(driver,encounterTemplateTestData.freeTextComment);
		isTextPresent(driver,encounterTemplateTestData.numericWidgetComment);
		isTextPresent(driver,encounterTemplateTestData.Answer4);
		waitForPageLoad(driver);	
		isTextPresent(driver,encounterTemplateTestData.Answer3);
		isTextPresent(driver,encounterTemplateTestData.numericWidgetValue);
		isTextPresent(driver,encounterTemplateTestData.Answer1);
		Thread.sleep(3000);
		}catch(Exception e)
		{ 
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
    	}
    	return true;
	}
	
	public boolean verifyEditedManagedCareTemplate(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)throws Exception
	{
		try
		{
		waitForPageLoad(driver); 
		isTextPresent(driver,encounterTemplateTestData.freeTextComment);
		isTextPresent(driver,encounterTemplateTestData.numericWidgetComment);
		isTextPresent(driver,encounterTemplateTestData.Answer6);
		waitForPageLoad(driver);	
		isTextPresent(driver,encounterTemplateTestData.Answer2);
//		isTextPresent(driver,encounterTemplateTestData.Answer7);
		isTextPresent(driver,encounterTemplateTestData.numericWidgetValue);
		isTextPresent(driver,"25");
		Thread.sleep(3000);
		}catch(Exception e)
		{ 
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
    	}
    	return true;
	}
	
	
	public boolean navigateToCareTemplateAlreadyOpen(WebDriver driver)
	{
		assertTrue(click(driver, viewEdit),
				"unable to click the view/edit link", driver, className,
				methodName);
		waitForPageLoad(driver);
		return true;
	}
	public boolean recordValueForEditedManagedCare(WebDriver driver)throws Exception
	{
		boolean state=true;
		if(isElementPresent(driver,viewEdit))
		{
		assertTrue(click(driver,viewEdit),"unable to click the view/edit link",driver,className,methodName);
		waitForPageLoad(driver);
		}
		assertTrue(click(driver,btnOptions),"unable to click the options button",driver,className,methodName);
		waitForPageLoad(driver);
		assertTrue(click(driver,btnRecord),"unable to click the record data button",driver,className,methodName);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		return true;
	}
	
	public boolean removeAlreadyCreatedTemplate(WebDriver driver)
	{
		if(isElementPresent(driver,removeManagedCare))
		{
			assertTrue(click(driver,removeManagedCare),"unable to delete the already created care element",driver,className,methodName);
			assertTrue(click(driver,linkYes),"unable to click the yes button",driver,className,methodName);
			waitForPageLoad(driver);
		}
		return true;
	}
	/**
	 * verifyValuesInFlowSheet
	 * Function Verify Values In FlowSheet
	 * @param driver
	 * @param mcTemplate - test data
	 * @since March 30, 2015
	 * @version 2.1
	 */

	public boolean verifyValuesInFlowSheet(WebDriver driver,ClinicalSettingLib mcTemplate,ChartPreVisitLib immData,ChartPreVisitLib immData2,ClinicalSettingLib mcTemplatesVital,ChartPreVisitLib vitalsData)
	{
	 try{
		 //Immunizations
		 assertTrue(isTextPresent(driver,mcTemplate.display),"Display value for Immunizations not found",driver,className,methodName);
		 
		 if(immData2.testCaseId.equalsIgnoreCase("TC_CIM_076")){
		 assertTrue(!isTextPresent(driver,immData2.Vaccine1CA)," Added Immunizations value not found",driver,className,methodName);
		 }else{
			 assertTrue(isTextPresent(driver,immData.Vaccine1CA)," Added Immunizations value not found",driver,className,methodName);
		 }
		 
		 //Vitals
		 assertTrue(isTextPresent(driver,mcTemplatesVital.display),"Display value for Vitals not found",driver,className,methodName);
		 
		 assertTrue(!isTextPresent(driver,vitalsData.heightInCm),"Added Vitals values found",driver,className,methodName);
		 
		/* // Medications
		 assertTrue(isTextPresent(driver,mcTemplatesMed.display),"Display value for Medications not found",driver,className,methodName);
		*/
		 
	    
	}catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
			return true;
	}
	/**
	 * verifyMedicationsInFlowSheet
	 * Function Verify Medications In FlowSheet
	 * @param driver
	 * @param mcTemplate - test data
	 * @since March 30, 2015
	 * @version 2.1
	 */

	public boolean verifyMedicationsInFlowSheet(WebDriver driver,ClinicalSettingLib mcTemplate)
	{
	 try{
		 
		assertTrue(isTextPresent(driver,mcTemplate.medicationName1),"Medication Name not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,mcTemplate.display),"Display value not found",driver,className,methodName);
	    
	}catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
			return true;
	}
	/**
	 * verifyVitalsInFlowSheet
	 * Function Verify Vitals In FlowSheet
	 * @param driver
	 * @param mcTemplate - test data
	 * @param VitalsData - test data
	 * @since March 30, 2015
	 * @version 2.1
	 */

	public boolean verifyVitalsInFlowSheet(WebDriver driver,ClinicalSettingLib mcTemplate,ChartPreVisitLib vitalsData)
	{
	 try{
		 
		assertTrue(isTextPresent(driver,mcTemplate.display),"Display not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.heightInCm),"Height value not found",driver,className,methodName);
	    
	}catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
			return true;
	}
	
	/**
	 * verifyImmunizationInFlowSheet
	 * Function Verify Immunization In FlowSheet
	 * @param driver
	 * @param mcTemplate - test data
	 * @param immData - test data
	 * @since April 01, 2015
	 * @version 2.1
	 */

	public boolean verifyImmunizationInFlowSheet(WebDriver driver,ClinicalSettingLib mcTemplate,ChartPreVisitLib immData)
	{
		 try{
	     		assertTrue(isTextPresent(driver,mcTemplate.display),"Display not found",driver,className,methodName);
			    assertTrue(isTextPresent(driver,immData.Vaccine1CA),"Vaccine1CA value not found",driver,className,methodName);
			    
			}catch (Exception e) {
					new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
				}
					return true;
			}

}
