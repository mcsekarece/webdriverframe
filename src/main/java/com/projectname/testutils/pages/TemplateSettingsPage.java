package com.projectname.testutils.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class TemplateSettingsPage extends SeleniumWebDriver{
	
	public   TemplateSettingsPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);
		SeleniumWebDriver.isElementPresent(readyLocator);
		}
	
	    private static By readyLocator=By.id("!templatesDaysheet");
	    private By lnkLetterTemplate = By.id("!templatesLetter");

		/**
		 * goToLetterTemplate
		 * function for  navigating to letter Template
		 * @param 		driver 
		 * @since  	    Apr 27, 2015
		 */

		public LetterTemplatePage goToLetterTemplate (WebDriver driver)
		{
			verifyTrue(click(driver, lnkLetterTemplate),"could not click Letter Template link", driver);
			waitForPageLoad(driver);
			return new LetterTemplatePage();
		}

		
		/**
		 * getDefaultTemplateName
		 * function for  getting Default Template Name
		 * @param 		driver 
		 * @param 		letterTemplatePage
		 * @throws IOException 
		 * @throws ExceptionHandler 
		 * @since  	    Apr 27, 2015
		 */

		public String getDefaultTemplateName (WebDriver driver, LetterTemplatePage letterTemplatePage) throws ExceptionHandler, IOException
		{
			String templateName="";
			templateName= letterTemplatePage.getDefaultTemplateName(driver);
			return templateName;
		}
		
		/**
		 * addNewReferralLetter
		 * function for  click add new button
		 * @param 		driver 
		 * @param 		letterTemplatePage
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 8, 2015
		 */

		public boolean addNewlLetterTemplate (WebDriver driver, LetterTemplatePage letterTemplatePage) throws ExceptionHandler, IOException
		{
			letterTemplatePage.clickAddNewButton(driver);
			return true;
		}
		
		/**
		 * verifyPraticeInFieldTypes
		 * function for  verify PracticeInFieldTypes
		 * @param 		driver 
		 * @param 		letterTemplatePage
		 * @param       referralData
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 8, 2015
		 */

		public boolean verifyPracticeFieldTypes (WebDriver driver, LetterTemplatePage letterTemplatePage,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			letterTemplatePage.verifyPracticeFieldTypes(driver,letterTemplateTestData);
			return true;
		}
		
		/**
		 * verifyPatientPayersFieldType
		 * function for  verify Patient Payers In FieldTypes
		 * @param 		driver 
		 * @param 		letterTemplatePage
		 * @param       referralData
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 8, 2015
		 */

		public boolean verifyPatientPayersFieldType (WebDriver driver, LetterTemplatePage letterTemplatePage,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			letterTemplatePage.verifyPatientPayersFieldType(driver,letterTemplateTestData);
			return true;
		}
		
		/**
		 * verifyPraticeFieldTypesAddDelete
		 * function for  add delete PracticeInFieldTypes
		 * @param 		driver 
		 * @param 		letterTemplatePage
		 * @param       referralData
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 8, 2015
		 */

		public String verifyPraticeFieldTypesAddDelete (WebDriver driver, LetterTemplatePage letterTemplatePage,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			String uniqueName=letterTemplatePage.verifyPracticeFieldTypesAddDelete(driver,letterTemplateTestData);
			return uniqueName;
		}
		
		/**
		 * verifyPatientPayersFieldTypesAddDelete
		 * function for  add delete patient Payers InFieldTypes
		 * @param 		driver 
		 * @param 		letterTemplatePage
		 * @param       referralData
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 8, 2015
		 */

		public String verifyPatientPayersFieldTypesAddDelete (WebDriver driver, LetterTemplatePage letterTemplatePage,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			String uniqueName=letterTemplatePage.verifyPatientPayersFieldTypesAddDelete(driver,letterTemplateTestData);
			return uniqueName;
		}
		
		
		/**
		 * deleteAllLetterTemplate
		 * function for delete All Letter Template
		 * @param 		driver 
		 * @param 		letterTemplatePage
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 8, 2015
		 */

		public boolean deleteAllLetterTemplate (WebDriver driver, LetterTemplatePage letterTemplatePage) throws ExceptionHandler, IOException
		{
			letterTemplatePage.deleteAllLetterTemplate(driver);
			return true;
		}
		
		/**
		 * addNewReferralTemplate
		 * function for  update the all the fields in the template page consider as referral template type
		 * @param 		driver 
		 * @param 		letterTemplatePage
		 * @param       letterTemplateTestData
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 11, 2015
		 */

		public boolean addNewReferralTemplate (WebDriver driver, LetterTemplatePage letterTemplatePage,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			letterTemplatePage.updateAsTemplateReferral(driver,letterTemplateTestData);
			return true;
		}
		
		/**
		 * searchWidgetAndDragIntoTemplatePage
		 * function for  drag and drop from search result into template page
		 * @param 		driver 
		 * @param 		letterTemplatePage
		 * @param       uniqueName
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 11, 2015
		 */

		public boolean searchWidgetAndDragIntoTemplatePage (WebDriver driver, LetterTemplatePage letterTemplatePage,String uniqueName) throws ExceptionHandler, IOException
		{
			letterTemplatePage.searchWidgetAndDragIntoTemplatePage(driver,uniqueName);
			return true;
		}
		
		/**
		 * searchWidgetAndDragIntoTemplatePage
		 * function for  drag and drop from search result into template page
		 * @param 		driver 
		 * @param 		letterTemplatePage
		 * @param       uniqueName
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 11, 2015
		 */

		public boolean clickSaveLetterTemplatesButton (WebDriver driver, LetterTemplatePage letterTemplatePage) throws ExceptionHandler, IOException
		{
			letterTemplatePage.clickSaveLetterTemplatesButton(driver);
			return true;
		}
		
		/**
		 * validateDefaultCheckBox
		 * function for  validate the default check box
		 * @param 		driver 
		 * @param 		letterTemplatePage
		 * @param       letterTemplateTestData
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 11, 2015
		 */

		public boolean validateDefaultCheckBox (WebDriver driver, LetterTemplatePage letterTemplatePage,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			letterTemplatePage.validateDefaultCheckBox(driver,letterTemplateTestData);
			return true;
		}
		
		/**
		 * clickReferralLetterTemplateDefaultCheckBox
		 * function for  click referral letter default check box
		 * @param 		driver 
		 * @param 		letterTemplatePage
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 11, 2015
		 */

		public boolean clickReferralLetterTemplateDefaultCheckBox (WebDriver driver, LetterTemplatePage letterTemplatePage) throws ExceptionHandler, IOException
		{
			letterTemplatePage.clickReferralLetterTemplateDefaultCheckBox(driver);
			return true;
		}
		
		
		/**
		 * overrideWithYesButton
		 * function for Override with Yes option
		 * @param 		driver 
		 * @param 		letterTemplatePage
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 11, 2015
		 */

		public boolean overrideWithYesButton (WebDriver driver, LetterTemplatePage letterTemplatePage,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			letterTemplatePage.overrideWithYesButton(driver,letterTemplateTestData);
			return true;
		}
		
		/**
		 * overrideWithNoButton
		 * function for Override with No option
		 * @param 		driver 
		 * @param 		letterTemplatePage
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 11, 2015
		 */

		public boolean overrideWithNoButton (WebDriver driver, LetterTemplatePage letterTemplatePage,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			letterTemplatePage.overrideWithNoButton(driver,letterTemplateTestData);
			return true;
		}
		
		/**
		 * verificationAfterSaveTemplate
		 * function for Verify the letter template
		 * @param 		driver 
		 * @param 		letterTemplatePage,letterTemplateTestData  
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 11, 2015
		 */

		public boolean verificationAfterSaveTemplate (WebDriver driver, LetterTemplatePage letterTemplatePage,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			letterTemplatePage.verificationAfterSaveTemplate(driver,letterTemplateTestData);
			return true;
		}
		
		/**
		 * verifyTemplateOverride
		 * function for Verify the letter template page after override the default template
		 * @param 		driver 
		 * @param 		letterTemplatePage,letterTemplateTestData  
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 11, 2015
		 */

		public boolean verifyTemplateOverride (WebDriver driver, LetterTemplatePage letterTemplatePage,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			letterTemplatePage.verifyTemplateOverride(driver,letterTemplateTestData);
			return true;
		}
		
		/**
		 * verifyColourOfDefaultText
		 * function for Verify colour of default  text
		 * @param 		driver 
		 * @param 		letterTemplatePage,letterTemplateTestData  
		 * @throws      IOException 
		 * @throws      ExceptionHandler 
		 * @since  	    May 12, 2015
		 */

		public boolean verifyColourOfDefaultText (WebDriver driver, LetterTemplatePage letterTemplatePage) throws ExceptionHandler, IOException
		{
			letterTemplatePage.verifyColourOfDefaultText(driver);
			return true;
		}
		
}
