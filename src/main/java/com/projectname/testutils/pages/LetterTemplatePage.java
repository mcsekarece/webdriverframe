package com.projectname.testutils.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class LetterTemplatePage extends SeleniumWebDriver{
	
	public LetterTemplatePage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);
		SeleniumWebDriver.isElementPresent(readyLocator);
		}
	
	    private static By readyLocator=By.linkText("Add New");
	    private By btnAddNew=By.linkText("Add New");
	    private By btnEdit = By.xpath("(//a[contains(text(),'Edit')])[");
	    private By chkDefaultTemplate = By.id("isDefaultcheckbox");
	    private By txtLetterTemplateName = By.id("letterTemplateName");
	    private By btnCancel = By.linkText("Cancel");
	    private By btnAddNewWidget=By.id("addAnchor");
	    private By fieldTypesSuggBox=By.id("suggestBox");
	    private By cancelOnWidgetPanel=By.xpath("(//a[contains(text(),'Cancel')])[2]");
	    private By saveOnWidgetPanel=By.xpath("(//a[contains(text(),'Save')])[2]");
	    private By btnDeleteReferralLetter=By.linkText("Delete");
	    private By btnYesConfirmDelete=By.linkText("Yes");
	    private By widgetName=By.id("toodadFieldName");
	    private By ajxreferralLetterTypeName=By.id("letterTemplateName");
	    private By ajxreferralTemplateType=By.id("letterTemplateTypesuggestBox");
	    private By ajxPageSize=By.id("letterTemplatePageSizesuggestBox"); 
	    private By widgetSearchBox=By.xpath("(//input[@type='text'])[6]"); 
	    private By lnkSaveLetterTemplate=By.linkText("Save");
	    private By lnkStyles=By.xpath("cke_top cke_reset_all");
	    private By chkBoxDefault=By.id("isDefaultcheckbox");
	    private By btnYes=By.id("yesButton");
	    private By btnNo=By.id("noButton");
	    
	    //Fix Me- VEL-8370
	    private By nameForPractice=By.xpath("//div[4]/div/div/div[2]/div/div[2]/div/div");
	    private By addressForPractice=By.xpath("//div[2]/div[2]/div");
	    private By phoneForPractice=By.xpath("//div[2]/div[3]/div");
	    private By faxForPractice=By.xpath("//div[2]/div[4]/div");
	    private By nameForPatientPayers=By.xpath("//div[4]/div/div/div[2]/div/div[2]/div/div");
	    private By memberIDForPatientPayers=By.xpath("//div[2]/div[2]/div");
	    private By subscriberNameForPatientPayers=By.xpath("//div[2]/div[3]/div");
	    private By subscriberDOBForPatientPayers=By.xpath("//div[2]/div[4]/div");
	    private By dropPlaceOfFieldTypeElements=By.xpath("//div[2]/div[2]/div/div");
	    private By dropbackToFieldTypeElements=By.xpath("//body/div[4]/div/div/div[2]/div/div[2]");
	    private By widgetAfterSearch=By.cssSelector("div.gwt-Label");
	    String panelTextofLetterTemplate="//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div/div[3]/div/div/div/div[%s]/div";
	    private By defaultText=By.xpath("//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div/div[3]/div/div/div/div/div/div[1]/div/div");
		/**
		 * getDefaultTemplateName
		 * function for  getting Default Template Name
		 * @param 		driver 
		 * @throws IOException 
		 * @throws ExceptionHandler 
		 * @since  	    Apr 27, 2015
		 */

		public String getDefaultTemplateName (WebDriver driver) throws ExceptionHandler, IOException
		{
			String templateName ="";
			try{
			for(int i=1; i<=20; i++){
			By temp = By.xpath("(//a[contains(text(),'Edit')])["+i+"]");
			if(isElementPresent( driver, temp))
			{
				verifyTrue(click(driver, temp),"could not click Letter edit link", driver);
				waitForPageLoad(driver);
				if(isChecked( driver, chkDefaultTemplate))
				{
					templateName = getValue(driver, txtLetterTemplateName);
					verifyTrue(click(driver, btnCancel),"could not click Letter cancel link", driver);
					waitForPageLoad(driver);
					return templateName;
				}
				else
				{
					verifyTrue(click(driver, btnCancel),"could not click Letter cancel link", driver);
					waitForPageLoad(driver);
				}
			}
			}
			}
		 catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
		return templateName;
	}
		/**
		 * clickAddNewButton
		 * function for  click add new button
		 * @param 		driver 
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 8, 2015
		 */
	
		public boolean clickAddNewButton (WebDriver driver) throws ExceptionHandler, IOException
		{
			try{
				waitForPageLoad(driver);
				assertTrue(click(driver,btnAddNew),"unable to click the add new button",driver,className,methodName);
				waitForPageLoad(driver);
			   }
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
		/**
		 * verifyPraticeInFieldTypes
		 * function for  verify Practice in field types box
		 * @param 		driver 
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 8, 2015
		 */
	
		public boolean verifyPracticeFieldTypes (WebDriver driver,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			try{
				assertTrue(click(driver,btnAddNewWidget),"unable to click the add new button",driver,className,methodName);
				waitForPageLoad(driver);
				assertTrue(selectValueFromAjaxList(driver,fieldTypesSuggBox,letterTemplateTestData.referral1),"unable to select the value in the ajax list",driver,className,methodName);
				waitForPageLoad(driver);
				assertTrue(isElementPresent(driver,nameForPractice),"Name not available in the 'Available Fields'",driver,className,methodName);
				assertTrue(isElementPresent(driver,addressForPractice),"address not available in the 'Available Fields'",driver,className,methodName);
				assertTrue(isElementPresent(driver,phoneForPractice),"phone not available in the 'Available Fields'",driver,className,methodName);
				assertTrue(isElementPresent(driver,faxForPractice),"fax not available in the 'Available Fields'",driver,className,methodName);
				waitForPageLoad(driver);
				assertTrue(click(driver,cancelOnWidgetPanel),"unable to click the cancel button",driver,className,methodName);
			   }
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
		/**
		 * verifyPraticeInFieldTypes
		 * function for  verify patient Payers in field types box
		 * @param 		driver 
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 8, 2015
		 */
	
		public boolean verifyPatientPayersFieldType(WebDriver driver,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			try{
				assertTrue(click(driver,btnAddNewWidget),"unable to click the add new button",driver,className,methodName);
				waitForPageLoad(driver);
				assertTrue(selectValueFromAjaxList(driver,fieldTypesSuggBox,letterTemplateTestData.referral1),"unable to select the value in the ajax list",driver,className,methodName);
				waitForPageLoad(driver);
				assertTrue(isElementPresent(driver,nameForPatientPayers),"name not available in the 'Available Fields'",driver,className,methodName);
				assertTrue(isElementPresent(driver,memberIDForPatientPayers),"memberID not available in the 'Available Fields'",driver,className,methodName);
				assertTrue(isElementPresent(driver,subscriberNameForPatientPayers),"subscriber not available in the 'Available Fields'",driver,className,methodName);
				assertTrue(isElementPresent(driver,subscriberDOBForPatientPayers),"subscriber DOB not available in the 'Available Fields'",driver,className,methodName);
				waitForPageLoad(driver);
				assertTrue(click(driver,cancelOnWidgetPanel),"unable to click the cancel button",driver,className,methodName);
			   }
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
		
		
		/**
		 * verifyPraticeFieldTypesAddDelete
		 * function for  verify Practice Field Types Add Delete
		 * @param 		driver 
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 8, 2015
		 */
	
		public String verifyPracticeFieldTypesAddDelete (WebDriver driver,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			String uniqueName="";
			try{
				assertTrue(click(driver,btnAddNewWidget),"unable to click the add new button",driver,className,methodName);
				waitForPageLoad(driver);
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("M:d:HH:mm:ss");
				uniqueName=DateFormat.format(cal.getTime());
				assertTrue(type(driver,widgetName,uniqueName),"unable to type the widget name",driver,className,methodName);
				assertTrue(selectValueFromAjaxList(driver,fieldTypesSuggBox,letterTemplateTestData.referral1),"unable to select the value in the ajax list",driver,className,methodName);
				waitForPageLoad(driver);
				//drag and drop function 
				WebElement DragFrom_Name = driver.findElement(nameForPractice);
				WebElement DragFrom_Address = driver.findElement(addressForPractice);
				WebElement DragFrom_Phone = driver.findElement(phoneForPractice);
				WebElement DragFrom_Fax = driver.findElement(faxForPractice);
				WebElement DropTo = driver.findElement(dropPlaceOfFieldTypeElements);
			    Actions action = new Actions(driver);					
			    action.dragAndDrop(DragFrom_Name,DropTo).build().perform();
			    waitForPageLoad(driver);
			    action.dragAndDrop(DragFrom_Address,DropTo).build().perform();
			    waitForPageLoad(driver);
			    action.dragAndDrop(DragFrom_Phone,DropTo).build().perform();
			    waitForPageLoad(driver);
			    action.dragAndDrop(DragFrom_Fax,DropTo).build().perform();
			    waitForPageLoad(driver);
			    if(letterTemplateTestData.testCaseId.equals("TC_IRL_003"))
			    {
			    	//drag and drop back function
				WebElement DropToBack = driver.findElement(dropbackToFieldTypeElements);				
			    action.dragAndDrop(DragFrom_Name,DropToBack).build().perform();
			    waitForPageLoad(driver);
			    action.dragAndDrop(DragFrom_Address,DropToBack).build().perform();
			    waitForPageLoad(driver);
			    action.dragAndDrop(DragFrom_Phone,DropToBack).build().perform();
			    waitForPageLoad(driver);
			    action.dragAndDrop(DragFrom_Fax,DropToBack).build().perform();
			    waitForPageLoad(driver);	    
				assertTrue(click(driver,cancelOnWidgetPanel),"unable to click the cancel button",driver,className,methodName);
			    }
			    else
			    {
			    	assertTrue(click(driver,saveOnWidgetPanel),"unable to click the cancel button",driver,className,methodName);
			    	waitForPageLoad(driver);
			    }
			   }
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return uniqueName;
		}
		
		
		
		/**
		 * verifyPraticeFieldTypesAddDelete
		 * function for  verify Practice Field Types Add Delete
		 * @param 		driver 
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 8, 2015
		 */
	
		public String verifyPatientPayersFieldTypesAddDelete (WebDriver driver,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			String uniqueName="";
			try{
				assertTrue(click(driver,btnAddNewWidget),"unable to click the add new button",driver,className,methodName);
				waitForPageLoad(driver);
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("M:d:HH:mm:ss");
				uniqueName=DateFormat.format(cal.getTime());
				assertTrue(type(driver,widgetName,uniqueName),"unable to type the widget name",driver,className,methodName);
				assertTrue(selectValueFromAjaxList(driver,fieldTypesSuggBox,letterTemplateTestData.referral1),"unable to select the value in the ajax list",driver,className,methodName);
				waitForPageLoad(driver);
				//drag and drop function 
				WebElement DragFrom_Name = driver.findElement(nameForPatientPayers);
				WebElement DragFrom_MemberID = driver.findElement(memberIDForPatientPayers);
				WebElement DragFrom_SubsName = driver.findElement(subscriberNameForPatientPayers);
				WebElement DragFrom_DOB = driver.findElement(subscriberDOBForPatientPayers);
				WebElement DropTo = driver.findElement(dropPlaceOfFieldTypeElements);
			    Actions action = new Actions(driver);					
			    action.dragAndDrop(DragFrom_Name,DropTo).build().perform();
			    waitForPageLoad(driver);
			    action.dragAndDrop(DragFrom_MemberID,DropTo).build().perform();
			    waitForPageLoad(driver);
			    action.dragAndDrop(DragFrom_SubsName,DropTo).build().perform();
			    waitForPageLoad(driver);
			    action.dragAndDrop(DragFrom_DOB,DropTo).build().perform();
			    waitForPageLoad(driver);
			    if(letterTemplateTestData.testCaseId.equals("TC_IRL_004"))
			    {
				//drag and drop back function
				WebElement DropToBack = driver.findElement(dropbackToFieldTypeElements);				
			    action.dragAndDrop(DragFrom_Name,DropToBack).build().perform();
			    waitForPageLoad(driver);
			    action.dragAndDrop(DragFrom_MemberID,DropToBack).build().perform();
			    waitForPageLoad(driver);
			    action.dragAndDrop(DragFrom_SubsName,DropToBack).build().perform();
			    waitForPageLoad(driver);
			    action.dragAndDrop(DragFrom_DOB,DropToBack).build().perform();
			    waitForPageLoad(driver);	    
				assertTrue(click(driver,cancelOnWidgetPanel),"unable to click the cancel button",driver,className,methodName);
			    }
			    else
				    {
				    	assertTrue(click(driver,saveOnWidgetPanel),"unable to click the cancel button",driver,className,methodName);
				    	waitForPageLoad(driver);
				    }
			   }
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return uniqueName;
		}
		

		/**
		 * verifyPraticeFieldTypesAddDelete
		 * function for  verify Practice Field Types Add Delete
		 * @param 		driver 
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 8, 2015
		 */
	
		public boolean deleteAllLetterTemplate (WebDriver driver) throws ExceptionHandler, IOException
		{
			try{
				int count=1;
				while(isVisible(driver,btnDeleteReferralLetter))
				{
				assertTrue(click(driver,btnDeleteReferralLetter),"unable to click the delete button",driver,className,methodName);
				assertTrue(click(driver,btnYesConfirmDelete),"unable to click the yes button",driver,className,methodName);
				waitForPageLoad(driver);
				count++;
				if(count>15){
					break;
				}
				}
			}
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
		/**
		 * updateAsTemplateReferral
		 * function for  update the all the fields in the template page consider as referral template type
		 * @param 		driver 
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 11, 2015
		 */
	
		public boolean updateAsTemplateReferral (WebDriver driver,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			try{
			assertTrue(type(driver,ajxreferralLetterTypeName,letterTemplateTestData.letterTemplateName),"Unable to update the template name in the template name text box",driver,className,methodName);;
			waitForPageLoad(driver);
			assertTrue(selectValueFromAjaxList(driver,ajxreferralTemplateType,letterTemplateTestData.templateType),"Unable to select the template type as Referral lette template",driver,className,methodName);;
			waitForPageLoad(driver);
			assertTrue(selectValueFromAjaxList(driver,ajxPageSize,letterTemplateTestData.templatePageSize),"Unable to select pageSize as letter",driver,className,methodName);
			waitForPageLoad(driver);
			}
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
		/**
		 * updateAsTemplateReferral
		 * function for  update the all the fields in the template page consider as referral template type
		 * @param 		driver 
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 11, 2015
		 */
	
		public boolean searchWidgetAndDragIntoTemplatePage(WebDriver driver,String uniqueName) throws ExceptionHandler, IOException
		{
			try{
			assertTrue(type(driver,widgetSearchBox,uniqueName),"Unable to update the template name in the template name text box",driver,className,methodName);;
			waitForPageLoad(driver);
			WebElement element=driver.findElement(widgetSearchBox);
			//Actions action = new Actions(driver);
			element.sendKeys(Keys.ENTER);
			//action.doubleClick(element).perform();
			waitForPageLoad(driver);
			//Click and hold
			WebElement elementClickAndHold=driver.findElement(widgetAfterSearch);
			Actions builder = new Actions(driver);
		    builder.clickAndHold(elementClickAndHold).build().perform();
	       //drop the element
		    WebElement elementDrop=driver.findElement(lnkStyles);
		    builder.moveToElement(elementDrop).build().perform();
            //Release the element
		    builder.release(elementDrop).build().perform();
		    waitForPageLoad(driver);
			}
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
		/**
		 * clickSaveLetterTemplatesButton
		 * function for  click save button
		 * @param 		driver 
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 11, 2015
		 */
	
		public boolean clickSaveLetterTemplatesButton (WebDriver driver) throws ExceptionHandler, IOException
		{
			try{
				waitForPageLoad(driver);
				assertTrue(click(driver,lnkSaveLetterTemplate),"unable to click the add new button",driver,className,methodName);
				waitForPageLoad(driver);
			   }
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}	
		
		/**
		 * updateAsTemplateReferral
		 * function for  update the all the fields in the template page consider as referral template type
		 * @param 		driver 
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 11, 2015
		 */
	
		public boolean validateDefaultCheckBox (WebDriver driver,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			try{
			assertTrue(selectValueFromAjaxList(driver,ajxreferralTemplateType,letterTemplateTestData.templateType),"Unable to select the template type as Referral lette template",driver,className,methodName);;
			waitForPageLoad(driver);
			assertTrue(isVisible(driver,chkBoxDefault),"Default check box is not present for referral letter type",driver,className,methodName);
			assertTrue(selectValueFromAjaxList(driver,ajxreferralTemplateType,letterTemplateTestData.templateNameToCopy),"Unable to select the template type as Referral lette template",driver,className,methodName);;
			waitForPageLoad(driver);
			assertTrue(!isVisible(driver,chkBoxDefault),"Default check box is present for all letter type",driver,className,methodName);
			assertTrue(selectValueFromAjaxList(driver,ajxreferralTemplateType,letterTemplateTestData.templateNameToRename),"Unable to select the template type as Referral lette template",driver,className,methodName);;
			waitForPageLoad(driver);
			assertTrue(!isVisible(driver,chkBoxDefault),"Default check box is present for all letter type",driver,className,methodName);
			}
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		/**
		 * updateAsTemplateReferral
		 * function for  update the all the fields in the template page consider as referral template type
		 * @param 		driver 
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 11, 2015
		 */
	
		public boolean clickReferralLetterTemplateDefaultCheckBox(WebDriver driver) throws ExceptionHandler, IOException
		{
			try{
				waitForPageLoad(driver);
				assertTrue(click(driver,chkBoxDefault),"unable to click the add new button",driver,className,methodName);
				waitForPageLoad(driver);
			}
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		/**
		 * overrideWithYesButton
		 * function for Override with Yes option
		 * @param 		driver 
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 11, 2015
		 */
	
		public boolean overrideWithYesButton(WebDriver driver,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			try{
				waitForPageLoad(driver);
				assertTrue(isTextPresent(driver,letterTemplateTestData.templateHTML),"unable to find Override message",driver,className,methodName);
				assertTrue(click(driver,btnYes),"unable to click the add new button",driver,className,methodName);
				waitForPageLoad(driver);
			}
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		/**
		 * overrideWithNoButton
		 * function for Override with No option
		 * @param 		driver 
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 11, 2015
		 */
	
		public boolean overrideWithNoButton(WebDriver driver,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			try{
				waitForPageLoad(driver);
				assertTrue(isTextPresent(driver,letterTemplateTestData.templateHTML),"unable to find Override message",driver,className,methodName);
				assertTrue(click(driver,btnNo),"unable to click the add new button",driver,className,methodName);
				waitForPageLoad(driver);
			}
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
		/**
		 * verificationAfterSaveTemplate
		 * function for to verify the saved data is displayed properly or not
		 * @param 		driver ,letterTemplateTestData
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 11, 2015
		 */
	
		public boolean verificationAfterSaveTemplate(WebDriver driver,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			try{
				assertTrue(isTextPresent(driver,letterTemplateTestData.letterTemplateName),"unable to find the letter template name with default properly",driver,className,methodName);
	    	    assertTrue(isTextPresent(driver,letterTemplateTestData.templateType),"unable to find the letter template type",driver,className,methodName);
	    	    assertTrue(isTextPresent(driver,letterTemplateTestData.allTemplateFields),"unable to find the default keyword in the page",driver,className,methodName);
			}
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
		/**
		 * verificationAfterSaveTemplate
		 * function for to verify the saved data is displayed properly or not
		 * @param 		driver ,letterTemplateTestData
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 11, 2015
		 */
	
		public boolean verifyTemplateOverride(WebDriver driver,ChartPreVisitLib letterTemplateTestData) throws ExceptionHandler, IOException
		{
			try{
				int count=1;
		        while(isElementPresent(driver,By.xpath(String.format(panelTextofLetterTemplate,count))))
				{
			    if(getText(driver,By.xpath(String.format(panelTextofLetterTemplate,count))).contains(letterTemplateTestData.allTemplateFields))
			    		{
			    	    assertTrue(isTextPresent(driver,letterTemplateTestData.letterTemplateName),"unable to find the letter template name with default properly",driver,className,methodName);
			    	    assertTrue(isTextPresent(driver,letterTemplateTestData.templateType),"unable to find the letter template type",driver,className,methodName);
					    break;
			    		}
			    else
			    {
			    	count++;
			    }
				}
			}
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
		
		/**
		 * verifyColourOfDefaultText
		 * function for to verify text color of default 
		 * @param 		driver ,letterTemplateTestData
		 * @throws    IOException 
		 * @throws   ExceptionHandler 
		 * @since  	    May 11, 2015
		 */
	
		public boolean verifyColourOfDefaultText(WebDriver driver) throws ExceptionHandler, IOException
		{
			try{
				WebElement textDefault = driver.findElement(defaultText); 
				textDefault.getCssValue("color");	
			}
			 catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
}