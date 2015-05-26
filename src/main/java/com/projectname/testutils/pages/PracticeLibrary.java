package com.projectname.testutils.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.projectname.testutils.genericutility.Constants;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;
import com.thoughtworks.selenium.Selenium;


public class PracticeLibrary extends SeleniumWebDriver{
	public   PracticeLibrary(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);
		SeleniumWebDriver.isElementPresent(readyLocator);

		}
		private By btnNumericDelete=By.xpath("(//button[@id='delete'])[2]");	
		private By ajxMumericFormat=By.id("numberFormatsuggestBox"); 
		private static By readyLocator=By.id("templateSuggestBoxsuggestBox");
		private By chkPlanandRecom =By.xpath("(//input[contains(@id,'checkBox')])[8]");
		private By ajxSectionsuggestBox=By.xpath("(//input[starts-with(@id,'selectLibrarySuggest')])[3]");
		private	By ajxSuggestBox1=By.id("specialitysuggestBox");
		private By btnSectionSave=By.id("topSave");
		private By unlockYes=By.id("yes");
		private By dtnsecondEdit=By.id("saveButton");
		private  By btndelete=By.id("deletetBtn");
		private By btnYesButton=By.id("yesButton");
		private By btnAddCustom =By.id("createCustomTmplbtn");
		private By btnErrorClose = By.id("errorCloseButton");
		private By ajxSuggestBox=By.id("specialtySuggestBoxIdsuggestBox");
		private By btnTitleDelete=By.xpath("(//button[@id='delete'])[5]");
		private By txtCustomCompName=By.xpath("(//input[starts-with(@id,'customComponentName')])[1]");
		private By txtCustomCompName1=By.xpath("(//input[starts-with(@id,'customComponentName')])[2]");
		private By txtCustomCompName2=By.xpath("(//*[contains(@id,'customComponentName')])[3]");
		private By txtCustomCompName3=By.xpath("(//input[contains(@id,'customComponentName')])[4]");
		private By txtCustomSectionLAbel=By.xpath("//td/div/div/div/div/div[2]/input");
		private By txtCustomSectionLAbel1=By.xpath("(//input[starts-with(@id,'customComponentName')])[2]");
		private By txtWidgetRow2=By.xpath("(//*[contains(@id,'widget_')])[2]");
		private By txtWidgetRow3=By.xpath("(//*[contains(@id,'widget_')])[3]");
		private By txtWidgetRow4=By.xpath("(//*[contains(@id,'widget_')])[4]");
		private By txtWidgetRow6=By.xpath("(//*[contains(@id,'widget_')])[6]");
		private By txtWidgetRow8=By.xpath("(//*[contains(@id,'widget_')])[8]");
		private By btnSectioncancel=By.id("topCancel");
		private By lnkFreeTextLabelwid=By.id("addButton-Free text");	
		private By lnkNumericWidget=By.id("addButton-Numeric Input");	
		private By lnkQuestionWidget=By.id("addButton-Question");	
		private By lnkTitleWidget=By.id("addButton-Title");
		private By btnAddNewUserDefined=By.id("addNewComponent");
		private By btnAddcustomSection=By.id("addNew");	
		private By btnSelectfronlibrary=By.xpath("(//button[starts-with(@id,'selectLibrary')])[2]");
		private By btnSelectfronlibraryatfirst=By.xpath("(//button[starts-with(@id,'selectLibrary')])");
		private By btnusethis=By.id("useBtn");
		private By btnSaveCustomSection = By.linkText("Save");
		private By btnSave2=By.id("save");
		private By lblCustomVisitSection=By.id("templateFocusPanel");
		private By btnVisitysectionEdit=By.id("editBtn");
		private By ajxFormatSuggestBox = By.id("formatsuggestBox");
		private By saveAll=By.linkText("Save");
		private By imgPopClose=By.xpath("//img");
		private By txtFreeTextLable=By.id("titleText");	
		private By txtNumericMin=By.id("minValue"); 
		private By txtNumericMax=By.id("maxValue"); 
		private By txtQuestionTotalAnswer=By.id("totalAns");	
		private By ajxQuestionDefault=By.id("defaultAnssuggestBox");
		private By btnQuestionsave=By.id("save");
		private By txtTitlelabel=By.id("titleText");
		private By txtQuestionAns1=By.id("ans_1");
		private By txtQuestionAns2=By.id("ans_2");
		private By txtQuestionAns3=By.id("ans_3");
		private By txtQuestionAns4=By.id("ans_4");
		private By txtQuestionAns5=By.id("ans_5");
		private By txtQuestionAns6=By.id("ans_6");
		private By txtQuestionAns7=By.id("ans_7");
		private By txtQuestionAns8=By.id("ans_8");
		private By encoEdit=By.id("editBtn");
		private By btnSaveWidget=By.id("save");
		private By btnNumericWidgetSave=By.id("save");
		private By txtQuestionLabel=By.id("labelText");
		private By txtNumericLabel=By.id("titleText");
		private By visitTypeSuggBox=By.id("visitSuggestBox1suggestBox");
		private By lblTemplate=By.id("templateFocusPanel");
		private By txtAreaTemplateDescription=By.id("templateDescription");
		private By btnDeleteCustomComponenet=By.xpath("(//a[contains(text(),'Remove')])[10]");   
		private By btnDeleteCustomComponenettwo=By.xpath("(//a[contains(text(),'Remove')])[9]");   
		private By chkoneresponse=By.xpath("//input[@id='onlyOneResponsecheckbox']"); 
		private By chkinputneeded=By.xpath("//input[@id='inputIsRequiredcheckbox']");  
		private By chkincludetextarea=By.xpath("//input[@id='includeTextAreacheckbox']");  
		private By templateName=By.id("templateSuggestBoxsuggestBox");
		private By chkHistoricaldata=By.id("showHistoricalDatacheckbox");
		private By btnDeleteFreetext=By.xpath("//*[contains(@id,'freeTextdelete')]");
		private By btnDeletenumeric=By.xpath("//button[contains(@id,'numericWidgetdelete')]");
		private By btnAddInstWidget=By.id("addButton-Instruction to user");		
		private By txtinstWidgrt=By.id("titleText");
		private By txtWidgetRow10=By.xpath("(//*[contains(@id,'widget_')])[10]");
		private By txtWidgetRow12=By.xpath("(//*[contains(@id,'widget_')])[12]");
		private By txtWidgetRow14=By.xpath("(//*[contains(@id,'widget_')])[14]");
		private By txtWidgetRow16=By.xpath("(//*[contains(@id,'widget_')])[16]");
		private By txtWidgetRow18=By.xpath("(//*[contains(@id,'widget_')])[18]");
		private By txtWidgetRow20=By.xpath("(//*[contains(@id,'widget_')])[20]");
		private By txtWidgetRow21=By.xpath("(//*[contains(@id,'widget_')])[21]");
		private By txtWidgetRow19=By.xpath("(//*[contains(@id,'widget_')])[19]");
		private By btnAddAssessmenttool=By.id("addButton-Assessment Tool");
		private By txtassessmentlabel=By.id("toolText");
		private By txtassessmentURl=By.id("toolUrlText");		
		private By txtassessmentotalscore=By.id("toolNumberofScoreText");
		private By txtscoreone=By.id("score_0");
		private By txtscoreTwo=By.id("score_1");
		private By btnEditNumericLabel=By.xpath("//button[contains(@id,'numericWidgetedit')]");
		private By btnEditQuestion1=By.id("edit");
		private By btnEditQuestion2=By.xpath("(//button[@id='edit'])[2]");
		private By visitSectionEditButton=By.xpath("(//div[contains(@id,'edit')])[1]");
		private By selectAllCheckBox=By.id("selectAllcheckbox");
		private By txtDateField=By.id("titleText");
		private By btnAddDateField=By.id("addButton-Date Field");
		private By chkallowtwodate=By.id("daterangeCB");
		private By chkpartialdate=By.id("partialdateCB");
		private By ajxTemplateType=By.xpath("//div[3]/div/div/div/input");
		private By ajxTemplatetypeSecond=By.xpath("(//input[contains(@id,'selectLibrarySuggest')])[2]");
		private By ajxTemplateType3=By.xpath("//tr[2]/td/div/div/div/div/div[3]/div/div/div/input");
		private By ajxTemplateType4=By.xpath("//tr[3]/td/div/div/div/div/div[3]/div/div/div/input");
		private By btnDatesave=By.id("saveButton");
		private By btnSaveInstruction=By.id("saveButton");
		private By btnCreateCustomTemplate=By.id("createCustomTmplbtn");
		private By txtTemplateName=By.id("templateName");
		private By txtTemplateDescription=By.id("templateDescription");
		private By lnkStartBlank=By.id("startBlankTemplate");
		private By questionWidgetScroll=By.xpath("//*[@id='dialogBoxAdd']/div/div/div[2]");
		private By lblVisitSectionScroll=By.id("previewPanelDiv");
		private By btnFreeTextEdit=By.xpath("(//button[contains(@id,'freeTextedit')])[1]");
		private By btnNumericEdit=By.xpath("(//button[contains(@id,'numericWidgetedit')])[1]");
		private By btnQueseditone=By.xpath("(//button[@id='edit'])[1]");
		private By btnQuesedittwo=By.xpath("(//button[@id='edit'])[2]");
		private By btnQueseditthree=By.xpath("(//button[@id='edit'])[3]");
		private By btnQueseditfour=By.xpath("(//button[@id='edit'])[4]");
		private By btnQueseditfive=By.xpath("(//button[@id='edit'])[5]");
		private By chkinputrequest=By.id("inputRequiredcheckbox");
		private By chkboxcomponent=By.xpath("(//input[contains(@id,'checkBox')])");
		private String numericWidget=null;
		private By reuseQuestionwidgetlabel=By.xpath("(//*[contains(@id,'widgetName_Question')])");
		private By txtNumericunit=By.id("unit");
		private By txtNumericustomValue=By.id("customValue");
	    private By ajxDefaultNumeric=By.id("defaultValuesuggestBox");
	    private By chkinputneed=By.id("inputIsRequiredCB");

		//Image Widget
		
		private By btnAddNewImageWidget = By.id("addButton-Image");
		private By txtName = By.id("titleText");
		private By ajxImageType = By.id("imageTypesuggestBox");
		private By btnUploadImage = By.id("imageBrowseButton-browse-anchor");
		private By chkEnableAnnotations = By.id("inputRequiredcheckbox");
		private By chkAdditionalInfo = By.xpath("(//input[@id='inputRequiredcheckbox'])[2]");
		private By txtNoOfMarkers = By.id("markerText");
		private By txtMarker = By.id("ans_1");
		private By txtMarker2= By.id("ans_2");
		//FIXME VEL-8301
		private By txtDescription = By.xpath("(//input[@type='text'])[31]");
		private By txtDescription2 = By.xpath("//div[2]/div[3]/input");
		private By btnRemove = By.xpath("//div[2]/div[2]/div/button");
		private By chkSaveAsNew = By.xpath("//input[contains(@id,'gwt-uid-')][1]");
		private By txtNewWidgetName = By.cssSelector("input.text-box");
		
		
		private By btnSaveImageWidget = By.id("save");
		private By btnCancelImageWidget = By.id("cancel");
		private By lblSectionNameOnMouseOver = By.xpath("//div[@id='popupPanel']");
		private By btnEditImage = By.xpath("(//button[contains(@id,'imageedit')])[1]");
		private By btnDeleteImage = By.xpath("(//button[contains(@id,'imagedelete')])[1]");
		private By btnCancelEdit = By.id("cancelButton");
		private By btnNo = By.id("noButton");
		private By lblImageCollapse = By.id("Image");
		private By btnEditFromCollapseView = By.id("editAnchor_Image1");
		private By btnAddFromCollapseView = By.id("addAnchor_Image1");
		private By image = By.cssSelector("image");
		private By txtBrowseFile= By.id("imageBrowseButton-file-upload");
		private By btnFile= By.id("file");
		private By btnEditVisitSection = By.id("editBtn");
		private By chkallergy=By.xpath("(//input[contains(@id,'checkBox')])[1]");
		private By chkProblemList=By.xpath("(//input[contains(@id,'checkBox')])[2]");
		/**
		 * Delete Previous Coustom Sections 
		 * Function to Delete Previous Coustom Sections 
		 * @param 	selenium
		 * @throws IOException 
		 * @since	DEC 25,2015
		 * @Version 2.1
		 */
	  public boolean deleteAllCustomSection(WebDriver driver) throws IOException
		{ if(isElementPresent(driver,btnErrorClose)){
        	click(driver,btnErrorClose);}
	    
		  int count=(Integer) getXpathCount(driver,By.xpath("//div[contains(@id,'templateFocusPanel')]"));
		  
		while(count>0)
		{
			By template=By.xpath("(//div[contains(@id,'templateFocusPanel')])["+count+"]");
			click(driver,template);
			 waitForPageLoad(driver);
			if(isElementPresent(driver,btndelete)&&isElementPresent(driver,template))
			{
			
				assertTrue(click(driver, btndelete),"could not click",driver, className, methodName);
				 waitForPageLoad(driver);
				 assertTrue(click(driver, btnYesButton), "could not click yes button",driver, className, methodName);
				 waitForPageLoad(driver);		
				 waitForPageLoad(driver);
			}
		
			 if(isElementPresent(driver,btnErrorClose)){
	            	click(driver,btnErrorClose);}
			 count--;
		    }
		return true;
		}
		  
	  /**
		 * deleteAllVisitOutline
		 * Function to deleteAllVisitOutline
		 * @param 	selenium
		 * @throws IOException 
		 * @since	Nov 25,2015
		 * @Version 2.1
		 */
	  public boolean deleteAllVisitOutline(WebDriver driver) throws IOException
		{ if(isElementPresent(driver,btnErrorClose)){
      	click(driver,btnErrorClose);}
	      int count=2;
		  int Count1=(Integer) getXpathCount(driver,By.xpath("//div[contains(@id,'templateFocusPanel')]"));
		  
		while(Count1>0)
		{
			By template=By.xpath("(//div[contains(@id,'templateFocusPanel')])["+count+"]");
			
			if(isElementPresent(driver,template))
			{

				click(driver,template);
				if(isVisible(driver,btndelete))

				 template=By.xpath("(//div[contains(@id,'templateFocusPanel')])["+count+"]");
				
				if(isElementPresent(driver,template))

				{

				assertTrue(click(driver, btndelete),"could not click",driver, className, methodName);
				 waitForPageLoad(driver);
				 assertTrue(click(driver, btnYesButton), "could not click yes button",driver, className, methodName);
				 waitForPageLoad(driver);

					click(driver,template);
					if(isVisible(driver,btndelete))
					{
					assertTrue(click(driver, btndelete),"could not click",driver, className, methodName);
					 waitForPageLoad(driver);
					 assertTrue(click(driver, btnYesButton), "could not click yes button",driver, className, methodName);
					 waitForPageLoad(driver);
					}

				}
			}
		
			 if(isElementPresent(driver,btnErrorClose)){
	            	click(driver,btnErrorClose);}
			 Count1--;
		
		}
		waitForPageLoad(driver);
		return true;
	}  
		 
	  /**
		 * start New VisitOutline
		 * Function to start New VisitOutline
		 * @param 	selenium
		 * @throws IOException 
		 * @since	Nov 25,2015
		 * @Version 2.1
		 */
		 
	 
		 public boolean startNewVisitOutline(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,String uniqueName)throws Exception
			{
			 waitForPageLoad(driver);
				assertTrue(click(driver,btnCreateCustomTemplate),"Unable to click the start new template button",driver,className,methodName);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				assertTrue(type(driver,txtTemplateName,encounterTemplateTestData.SectionName+uniqueName),"Unable to enter the template name",driver,className,methodName);
				assertTrue(type(driver,txtTemplateDescription,encounterTemplateTestData.SectionDescription),"Unable to enter the template description",driver,className,methodName);
				assertTrue(selectValueFromAjaxList(driver,visitTypeSuggBox,encounterTemplateTestData.visitType),"unable to visit type",driver,className,methodName);
				assertTrue(click(driver,lnkStartBlank),"Unable to click the start new template",driver,className,methodName);
				waitForPageLoad(driver);
				return true;
			}
		 
		 /**
			 * Create Custom Sections 
			 * Function to Delete Previous Custom Sections 
			 * @param 	selenium
		  	 * @throws Exception 
		  	 * @version 2.1
			 * @since	DEC 25,2014
			 */ 
		   
		    public boolean createVisitSectionWithWidget(WebDriver driver,ClinicalSettingLib encounterTemplateTestData) throws Exception
		    {	
		    	try {
		    		if(isElementPresent(driver,btnErrorClose)){
		            	click(driver,btnErrorClose);}
		    	assertTrue(click(driver, btnAddCustom),"Click on Add section failed",driver, className, methodName);
		    	waitForPageLoad(driver);	 
		       	assertTrue(type(driver, txtTemplateName,encounterTemplateTestData.SectionName), "Could not type template name",driver, className, methodName);
		    	assertTrue(type(driver, txtAreaTemplateDescription, encounterTemplateTestData.SectionDescription), "Could not type template description",driver, className, methodName);
		    	assertTrue(selectValueFromAjaxList(driver,ajxSuggestBox,encounterTemplateTestData.visitType1),"Could not select visit type"+encounterTemplateTestData.toString(),driver, className, methodName);
		      	

		    	if(encounterTemplateTestData.singlewidget.equals("Yes"))
		    	{
			    	//Free Text Widget
		    	    
			       	assertTrue(click(driver, txtWidgetRow2),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
			       	waitForElementToLoad(driver,lnkFreeTextLabelwid);
			    	assertTrue(click(driver, lnkFreeTextLabelwid),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
			    	waitForPageLoad(driver);
			    	assertTrue(type(driver, txtFreeTextLable,encounterTemplateTestData.FreeTextLabel),"Could not type the lable name",driver, className, methodName);
			    
			    	assertTrue(click(driver, btnSaveWidget),"Click on Save button  in section failed",driver, className, methodName);
			    	waitForPageLoad(driver);
			      	assertTrue(isTextPresent(driver,encounterTemplateTestData.FreeTextLabel),"Widget is not added",driver, className, methodName);
			    	assertTrue(click(driver, btnSectionSave),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
			    	waitForPageLoad(driver);
			    	
			     	return true;

		    	}
		    	
		    		
		    		//TiTle Widget
			    	assertTrue(click(driver, txtWidgetRow10),"Coild not click the first row in Create visit sectio page", driver, className, methodName);
			       	waitForElementToLoad(driver,lnkTitleWidget);
			    	assertTrue(click(driver, lnkTitleWidget),"Coild not click the first row in Create visit sectio page", driver, className, methodName);
			      	assertTrue(type(driver, txtTitlelabel,encounterTemplateTestData.TitleLabel),"Could not type the lable name", driver, className, methodName);
			     	assertTrue(click(driver, btnQuestionsave),"Click on Save button  in section failed",driver, className, methodName);
			    	waitForPageLoad(driver);
		   		
		    	//Free Text Widget
			    	
		       	assertTrue(click(driver, txtWidgetRow2),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
		    	waitForElementToLoad(driver,lnkFreeTextLabelwid);
		    	assertTrue(click(driver, lnkFreeTextLabelwid),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
		    	waitForPageLoad(driver);
		    	assertTrue(type(driver, txtFreeTextLable,encounterTemplateTestData.FreeTextLabel),"Could not type the lable name",driver, className, methodName);
		    	 assertTrue(click(driver, chkinputneeded),"Could not click the input neede in Create visit sectio page",driver, className, methodName);
		    	assertTrue(click(driver, btnSaveWidget),"Click on Save button  in section failed",driver, className, methodName);
		    	waitForPageLoad(driver);
		 	  
		    	
		    	//Numeric Widget
	        
		        assertTrue(click(driver, txtWidgetRow4),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
		        waitForElementToLoad(driver,lnkNumericWidget);
		        assertTrue(click(driver, lnkNumericWidget),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
		        waitForElementToLoad(driver,txtNumericLabel);
		        numericWidget=encounterTemplateTestData.NumericLabel;
		        assertTrue(type(driver, txtNumericLabel,encounterTemplateTestData.NumericLabel),"Could not type the lable name", driver, className, methodName);
		        assertTrue(selectValueFromAjaxList(driver,ajxMumericFormat,encounterTemplateTestData.NumericLabelFormet),"Could not select visit type"+encounterTemplateTestData.toString(),driver, className, methodName);
		        assertTrue(type(driver, txtNumericMin,encounterTemplateTestData.Minvalue),"Could not type the MAx value", driver, className, methodName);
		        assertTrue(type(driver, txtNumericMax,encounterTemplateTestData.MaxValue),"Could not type the  Min value", driver, className, methodName);
		        assertTrue(type(driver, txtNumericunit,"value"),"Could not type the  Min value", driver, className, methodName);        
		    	assertTrue(selectValueFromAjaxList(driver,ajxDefaultNumeric,"Custom value"),"Could not select value"+encounterTemplateTestData.toString(),driver, className, methodName);
		        assertTrue(type(driver, txtNumericustomValue,encounterTemplateTestData.Minvalue),"Could not type the  Min value", driver, className, methodName);        
		        assertTrue(click(driver, chkinputneeded),"Could not click the input neede in Create visit sectio page",driver, className, methodName);
			    assertTrue(click(driver, chkincludetextarea),"Could not click the  text area need in Create visit sectio page",driver, className, methodName);
			    assertTrue(click(driver, chkHistoricaldata),"Could not click the  Historical data in Create visit sectio page",driver, className, methodName);
			    assertTrue(click(driver, btnNumericWidgetSave),"Could not click the save button",driver, className, methodName);
		        waitForPageLoad(driver);   

		    	//Question  Widget -7 Answers 	
		    	
		    	assertTrue(click(driver, txtWidgetRow6),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
		    	waitForElementToLoad(driver,lnkQuestionWidget);
		    	assertTrue(click(driver, lnkQuestionWidget),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
		    	waitForElementToLoad(driver,txtQuestionLabel);
		    	assertTrue(type(driver, txtQuestionLabel,encounterTemplateTestData.QuestionLabel1),"Could not type the lable name",driver, className, methodName);
		    	assertTrue(type(driver, txtQuestionTotalAnswer,encounterTemplateTestData.QuestionAnswer1),"Could not type the lable name",driver, className, methodName);
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    	js.executeScript("return document.getElementById('totalAns').blur()");
		    	Thread.sleep(3000);
		    	assertTrue(type(driver, txtQuestionAns1,encounterTemplateTestData.Answer1),"Could not type the lable name", driver, className, methodName);
		    	assertTrue(type(driver, txtQuestionAns2,encounterTemplateTestData.Answer2),"Could not type the lable name", driver, className, methodName);
		    	assertTrue(type(driver, txtQuestionAns3,encounterTemplateTestData.Answer3),"Could not type the lable name", driver, className, methodName);	
		    	assertTrue(type(driver, txtQuestionAns4,encounterTemplateTestData.Answer4),"Could not type the lable name", driver, className, methodName);	
		    	assertTrue(type(driver, txtQuestionAns5,encounterTemplateTestData.Answer5),"Could not type the lable name", driver, className, methodName);	
		    	assertTrue(type(driver, txtQuestionAns6,encounterTemplateTestData.Answer6),"Could not type the lable name", driver, className, methodName);	
		    	assertTrue(type(driver, txtQuestionAns7,encounterTemplateTestData.Answer7),"Could not type the lable name", driver, className, methodName);	
		    	assertTrue(selectValueFromAjaxList(driver,ajxQuestionDefault,encounterTemplateTestData.Answer3),"Could not select value"+encounterTemplateTestData.toString(),driver, className, methodName);
		      	WebElement scrollUp = driver.findElement(questionWidgetScroll);
				scrollUp.sendKeys(Keys.PAGE_DOWN);
		    	scrollUp.sendKeys(Keys.PAGE_DOWN);
		         js.executeScript("return document.getElementById('inputIsRequiredcheckbox').click()");
		        Thread.sleep(3000);
		        js.executeScript("return document.getElementById('includeTextAreacheckbox').click()");
		        Thread.sleep(3000);
		    	assertTrue(click(driver, btnQuestionsave),"Click on Save button  in section failed",driver, className, methodName);
		    	waitForPageLoad(driver);
		    	assertTrue(getText(driver,txtWidgetRow6).trim().toLowerCase().contains(encounterTemplateTestData.QuestionLabel1.toLowerCase().trim()),"Numeric Label Not created", driver, className, methodName);   
		    	
		    	//Question Widget - 3 Answers 
		    	if(encounterTemplateTestData.moreRequired.equals("Yes"))
		    	{
		    	assertTrue(click(driver, txtWidgetRow8),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
		    	 waitForElementToLoad(driver, lnkQuestionWidget );
		    	assertTrue(click(driver, lnkQuestionWidget),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
		    	 waitForElementToLoad(driver, txtQuestionLabel );
		    	assertTrue(type(driver, txtQuestionLabel,encounterTemplateTestData.QuestionLabel),"Could not type the lable name",driver, className, methodName);
		     	assertTrue(type(driver, txtQuestionTotalAnswer,encounterTemplateTestData.QuestionAnswer),"Could not type the lable name",driver, className, methodName);
		    	JavascriptExecutor js1 = (JavascriptExecutor) driver;
		    	js1.executeScript("return document.getElementById('totalAns').blur()");
		     	assertTrue(type(driver, txtQuestionAns1,encounterTemplateTestData.Answer8),"Could not type the lable name", driver, className, methodName);
		    	assertTrue(type(driver, txtQuestionAns2,encounterTemplateTestData.Answer9),"Could not type the lable name", driver, className, methodName);
		    	assertTrue(type(driver, txtQuestionAns3,encounterTemplateTestData.answer10),"Could not type the lable name", driver, className, methodName);	
		    	assertTrue(selectValueFromAjaxList(driver,ajxQuestionDefault,encounterTemplateTestData.answer10),"Could not select value"+encounterTemplateTestData.toString(),driver, className, methodName);
		     
			        js.executeScript("return document.getElementById('inputIsRequiredcheckbox').click()");
			        Thread.sleep(3000);
			        js.executeScript("return document.getElementById('includeTextAreacheckbox').click()");
			        Thread.sleep(3000);
		    	assertTrue(click(driver, btnQuestionsave),"Click on Save button  in section failed",driver, className, methodName);
		    	waitForPageLoad(driver);
		    	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel),"Numeric Label Not created", driver, className, methodName);    	
		    	  		    	
		    	//Instruction to user
		    	assertTrue(click(driver, txtWidgetRow12),"Coild not click the 9th row in Create visit sectio page", driver, className, methodName);
		    	 waitForElementToLoad(driver, btnAddInstWidget );
		    	assertTrue(click(driver, btnAddInstWidget),"Coild not click addnew button  in instruction to user widget" ,driver, className, methodName);
		    	 waitForElementToLoad(driver,  txtinstWidgrt);
		    	assertTrue(type(driver, txtinstWidgrt,encounterTemplateTestData.instructionWidget),"Could not type the instruction to user widget", driver, className, methodName);
		    	assertTrue(click(driver, btnSaveInstruction),"Could not click save button  in instruction to user widget" ,driver, className, methodName);
		    	waitForPageLoad(driver);
		    
		    	//Date Field 
		    	assertTrue(click(driver, txtWidgetRow14),"Could not click the Date field widget ", driver, className, methodName);
		    	Thread.sleep(3000);
		    	assertTrue(click(driver, btnAddDateField),"Could not click Add new Date field widget ", driver, className, methodName);
		    	 waitForElementToLoad(driver,  txtDateField);
		    	 assertTrue(type(driver, txtDateField,encounterTemplateTestData.datelabel),"Could not type the title to date widget", driver, className, methodName);
		    	 assertTrue(selectValueFromAjaxList(driver,ajxFormatSuggestBox,encounterTemplateTestData.dateformate),"Could not select value date formate "+encounterTemplateTestData.toString(),driver, className, methodName);
		    	 assertTrue(click(driver, chkinputneed),"Could not click input needed check box in Date widget" ,driver, className, methodName);
		    	 assertTrue(click(driver, chkallowtwodate),"Could not click allowtwodate button  in Date widget" ,driver, className, methodName);
		 	    assertTrue(click(driver, chkpartialdate),"Could not click partialdate button  in date widget" ,driver, className, methodName);
		 	    Thread.sleep(3000);
		 	    js.executeScript("return document.getElementById('addtionaltextareaCB').click()");
		 	 	   assertTrue(webElementclick(driver, btnDatesave),"Could not Save the date widget" ,driver, className, methodName);
		 	 	 Thread.sleep(3000);
		 	 	 
		 	 	 //Adding Question widget  -8 Answers
		 	 	 
		 	 	 	click(driver, txtWidgetRow16);
		 	 	 	waitForElementToLoad(driver,lnkQuestionWidget  );
			    	click(driver, lnkQuestionWidget);
			    	 waitForElementToLoad(driver, txtQuestionLabel );
			    	type(driver, txtQuestionLabel,encounterTemplateTestData.QuestionLabel3);
			    	type(driver, txtQuestionTotalAnswer,encounterTemplateTestData.QuestionAnswer2);
			    	JavascriptExecutor jsone = (JavascriptExecutor) driver;
			    	jsone.executeScript("return document.getElementById('totalAns').blur()");
				    Thread.sleep(3000);
			    	type(driver, txtQuestionAns1,encounterTemplateTestData.answer11);
			    	type(driver, txtQuestionAns2,encounterTemplateTestData.answer12);
			    	type(driver, txtQuestionAns3,encounterTemplateTestData.answer13);	
			    	type(driver, txtQuestionAns4,encounterTemplateTestData.answer14);	
			    	type(driver, txtQuestionAns5,encounterTemplateTestData.answer15);
			    	type(driver, txtQuestionAns6,encounterTemplateTestData.answer16);
			    	type(driver, txtQuestionAns7,encounterTemplateTestData.answer17);
			    	type(driver, txtQuestionAns8,encounterTemplateTestData.answer18);
			    	selectValueFromAjaxList(driver,ajxQuestionDefault,encounterTemplateTestData.answer18);		    	
			    	WebElement scrollUp1 = driver.findElement(questionWidgetScroll);
					scrollUp1.sendKeys(Keys.PAGE_DOWN);
			 		scrollUp1.sendKeys(Keys.PAGE_DOWN);
			        js.executeScript("return document.getElementById('onlyOneResponsecheckbox').click()");
			        Thread.sleep(3000);
			        js.executeScript("return document.getElementById('inputIsRequiredcheckbox').click()");
			        Thread.sleep(3000);
			        js.executeScript("return document.getElementById('includeTextAreacheckbox').click()");
			        Thread.sleep(3000);
			    	click(driver, btnQuestionsave);
			    	waitForPageLoad(driver);   	
			    	
			   	//Question -2 Answers 	
			    	click(driver, txtWidgetRow18);
			    	 waitForElementToLoad(driver,lnkQuestionWidget  );
			    	click(driver, lnkQuestionWidget);
			    	 waitForElementToLoad(driver, txtQuestionLabel );
			    	type(driver, txtQuestionLabel,encounterTemplateTestData.QuestionLabel4);
			    	type(driver, txtQuestionTotalAnswer,encounterTemplateTestData.QuestionAnswer4);
			    	JavascriptExecutor jstwo = (JavascriptExecutor) driver;
			    	jstwo.executeScript("return document.getElementById('totalAns').blur()");
			    	Thread.sleep(50000);
			    	type(driver, txtQuestionAns1,encounterTemplateTestData.answer19);
			    	type(driver, txtQuestionAns2,encounterTemplateTestData.answer20);
			    	selectValueFromAjaxList(driver,ajxQuestionDefault,encounterTemplateTestData.answer20);
			        js.executeScript("return document.getElementById('onlyOneResponsecheckbox').click()");
			        Thread.sleep(3000);
			        js.executeScript("return document.getElementById('inputIsRequiredcheckbox').click()");
			        Thread.sleep(3000);
			        js.executeScript("return document.getElementById('includeTextAreacheckbox').click()");
			        Thread.sleep(3000);	
			         click(driver, btnQuestionsave);
			    	waitForPageLoad(driver);   	
			    	
			    	//Assessment-1		    	
			       	click(driver, txtWidgetRow20);
			        waitForElementToLoad(driver,btnAddAssessmenttool  );
			    	click(driver, btnAddAssessmenttool);
			    	 waitForElementToLoad(driver,  txtassessmentlabel);
			    	type(driver,txtassessmentlabel,encounterTemplateTestData.assessment);
			    	type(driver,txtassessmentURl,encounterTemplateTestData.assessmenturl);
			    	type(driver,txtassessmentotalscore,encounterTemplateTestData.assessmentscore);
			    	jstwo.executeScript("return document.getElementById('toolNumberofScoreText').blur()");
				    Thread.sleep(3000);
			    	type(driver,txtscoreone,encounterTemplateTestData.scoreone);
			    	type(driver,txtscoreTwo,encounterTemplateTestData.scoretwo);
			        js.executeScript("return document.getElementById('inputIsRequiredCB').click()");
			        Thread.sleep(3000);
			        js.executeScript("return document.getElementById('includeTextAreaAdditionalInformationCB').click()");
			        Thread.sleep(3000);
			    	click(driver,btnDatesave);
			    	waitForPageLoad(driver);
		    	             }
	             
		    	}
		    	  	catch(Exception e){
				return false ;
				}
		    	assertTrue(webElementclick(driver, btnSectionSave),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
	 	    	waitForPageLoad(driver);
		     	return true;
		    }



		/**
		 * Verify Created Custom Sections 
		 * Function to Verify Created Custom Sections 
		 * @param 	selenium
	  	 * @throws Exception 
		 * @since	DEC 25,2014
		 */ 
	    public boolean verifyCreatedSection(Selenium selenium,ClinicalSettingLib encounterTemplateTestData)
	    {	
	    	waitForPageLoad(driver);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.FreeTextLabel),"FreeTextLabel Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel),"QuestionLabel Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel1),"QuestionLabel Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.NumericLabel),"NumericLabel Label Not created", driver, className, methodName);	  
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.datelabel),"NumericLabel Label Not created", driver, className, methodName);	   
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.instructionWidget),"NumericLabel Label Not created", driver, className, methodName);	   
	    	return true;
	    		
	    }
	    /**
		 * Delete Custom sections in Default encounter
		 * Function to  Delete Custom sections in Default encounter
		 * @param 	selenium
	  	 * @throws Exception 
	  	 * @Version 2.1
		 * @since	DEC 25,2014
		 */ 
	    public boolean deleteCustomComponenetInEditDefalutPage(WebDriver driver) throws IOException
	    {
	 //  driver.findElement(By.xpath("(//a[contains(text(),'Remove')])[10]")).getSize();
	 int count;
	    	for(count=2;count<=getXpathCount(driver,chkboxcomponent);count++)
	    	{String check="(//input[contains(@id,'checkBox')])["+count+"]";
	    	By chksection=By.xpath(check);
	    	if(!isChecked(driver,chksection))
	    	{
	    		 assertTrue(click(driver, chksection),"could not click the check box"+check+" button",driver, className, methodName);	
	    	}
	    	}
	   	 waitForPageLoad(driver);
	   	 By btnDelete = By.xpath("(//a[contains(text(),'Remove')])["+count+"]");
	    	try{
	    		if(isElementPresent(driver,btnDelete)){

	    		if(isVisible(driver,btnDelete))
	    		{
	    			while(isElementPresent(driver,btnDelete))
			    	{
			    		 assertTrue(click(driver, btnDelete),"could not click the deleted button",driver, className, methodName);
			    		 waitForPageLoad(driver);
			    		 assertTrue(click(driver, btnYesButton), "could not click yes button",driver,  className, methodName);
			    		 waitForPageLoad(driver);
			    		 waitForPageLoad(driver);
			    		 if(!isElementPresent(driver,btnDelete))
			    		 {
			    			 break;
			    		 }	
	    		}
	    		}
		    	}
	    	}
	    	catch(Exception e)
	    	{
	    	       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
	    	}
	    
	    	return true;
	    }
	  
	    /**
	  		 *Verify created visit sections in encounter note page
	  		 * Function to  Delete Custom sections in Default encounter
	  		 * @param 	selenium
	  	  	 * @throws Exception 
	  		 * @since	DEC 25,2014
	  		 */ 
	    public boolean verifyDefaultTemplateInEncounterNote(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)    {
	    	waitForPageLoad(driver);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.FreeTextLabel),"FreeTextLabel Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel),"QuestionLabel Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.TitleLabel),"TitleLabel Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.NumericLabel),"NumericLabel Label Not created", driver, className, methodName);	    	
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.Answer1),"Answer Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.Answer2),"Second Answer Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.Answer3),"Third Answer Label Not created", driver, className, methodName);	    	
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.ComponenetName),"ComponenetName Label Not created", driver, className, methodName);	    	
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.SectionName),"SectionName Not created", driver, className, methodName);
	       		return true;
	    }  
	    /**
         *Edit Created Visit sections 
         * Function to  Edit Created Visit sections 
         * @param     selenium
         * @throws Exception 
         * @since     DEC 25,2014
         */ 
       
	    public boolean editVisitSectionWithWidget(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)   
	    {
	    	 try {
	    		//Edit Question Label
		    	 waitForPageLoad(driver);
		    	 assertTrue(webElementclick(driver, btnEditQuestion1),"Coild not click the Edit button for Question Widget",  driver, className, methodName);
		    	 waitForPageLoad(driver);
		    		WebElement scrollUp = driver.findElement(questionWidgetScroll);
		    		scrollUp.sendKeys(Keys.PAGE_DOWN);
		     		scrollUp.sendKeys(Keys.PAGE_DOWN);
		    	 JavascriptExecutor js1 = (JavascriptExecutor) driver;
		    	 js1.executeScript("return document.getElementById('inputIsRequiredcheckbox').click()"); 
		    	 js1.executeScript("return document.getElementById('onlyOneResponsecheckbox').click()");
		    	 waitForPageLoad(driver);
		         scrollUp.sendKeys(Keys.PAGE_UP);		    	
		    	 scrollUp.sendKeys(Keys.PAGE_UP);
		    	 assertTrue(click(driver, btnQuestionsave),"Click on Save button  in section failed", driver, className, methodName);
		    	 waitForPageLoad(driver);
		    	 assertTrue(webElementclick(driver, dtnsecondEdit),"Click on Save button  in section failed", driver, className, methodName);
		    	 waitForPageLoad(driver);
		    	 if(encounterTemplateTestData.moreRequired.equals("Yes"))
		 	    	{
		    	 //Edit second question label
		    	 assertTrue(click(driver, btnEditQuestion2),"Could not click the Edit button for Question Widget",  driver, className, methodName);
		    	 waitForPageLoad(driver);          
		    	 assertTrue(type(driver, txtQuestionLabel,encounterTemplateTestData.QuestionLabel1Edit),"Could not type the lable name",driver, className, methodName);
		    	 waitForPageLoad(driver);
		    	 JavascriptExecutor js2 = (JavascriptExecutor) driver;
		    	 js2.executeScript("return document.getElementById('inputIsRequiredcheckbox').click()"); 
		    	 waitForPageLoad(driver);  
		    	 assertTrue(webElementclick(driver, btnQuestionsave),"Click on Save button  in section failed",driver, className, methodName);
		    	 waitForPageLoad(driver); 
		    	 assertTrue(webElementclick(driver, dtnsecondEdit),"Click on Save button  in section failed", driver, className, methodName);
		 	    	}
		    	 //Edit First Numeric label
		    		 assertTrue(click(driver, btnEditNumericLabel),"Could not click the Edit button for Question Widget",  driver, className, methodName);
		    		 waitForPageLoad(driver);
		    		  assertTrue(selectValueFromAjaxList(driver,ajxMumericFormat,encounterTemplateTestData.NumericLabelFormet1),"Could not select visit type"+encounterTemplateTestData.toString(),driver, className, methodName);
		    		  waitForPageLoad(driver);
		    		  assertTrue(type(driver, txtNumericMin,encounterTemplateTestData.Minvalue1),"Could not type the MAx value", driver, className, methodName);
		    		  waitForPageLoad(driver);
		    		  assertTrue(type(driver, txtNumericMax,encounterTemplateTestData.MaxValue1),"Could not type the  Min value", driver, className, methodName);
		    		  waitForPageLoad(driver);
		    		    assertTrue(click(driver, chkinputneeded),"Could not click the input neede in Create visit sectio page",driver, className, methodName);
		    		    waitForPageLoad(driver);
		    		    assertTrue(webElementclick(driver, btnNumericWidgetSave),"Could not click the save button",driver, className, methodName);
		    		  waitForPageLoad(driver);
		    		  assertTrue(webElementclick(driver, dtnsecondEdit),"Click on Save button  in section failed", driver, className, methodName);
		    		  waitForPageLoad(driver);
		    	//Add New Question Widget	  
		    		  click(driver,txtWidgetRow19);
		    		  waitForPageLoad(driver);
		    			click(driver, lnkQuestionWidget);
				    	waitForPageLoad(driver);
				    	type(driver, txtQuestionLabel,encounterTemplateTestData.questionLabel5);
				    	type(driver, txtQuestionTotalAnswer,encounterTemplateTestData.questionAnswer5);
				    	JavascriptExecutor jstwo = (JavascriptExecutor) driver;
				    	jstwo.executeScript("return document.getElementById('totalAns').blur()");
				    	Thread.sleep(5000);
				    	type(driver, txtQuestionAns1,encounterTemplateTestData.answer10);
				    	type(driver, txtQuestionAns2,encounterTemplateTestData.answer11);
				    	webElementclick(driver, btnQuestionsave);
				   	 waitForPageLoad(driver);
				  
				      	 waitForPageLoad(driver);
				      	 click(driver,btnSectionSave);
		    	   		 waitForPageLoad(driver);
		    	   	    		// assertTrue(!isElementPresent(driver, btnSectionSave),"Could not click the first row in Create visit sectio page",driver, className, methodName);
	    	 }
	    	 
	    	catch(Exception e)
	    	{
	    		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(),"", "", "fail", "", getCallingMethodAndLineNumber()) );
	    	}
	    	 	    		
	    	  return true;
	                
	     
	    }


       
	    /**
         *Delete all previous visit sections
         * Function to Delete all previous visit sections
         * @param     selenium
         * @throws Exception 
         * @since     DEC 25,2014
         */ 
       
public boolean deleteVisitSections (WebDriver driver,ClinicalSettingLib encounterTemplateTestData)
{
	assertTrue(selectVisitSection(driver,encounterTemplateTestData.SectionName), "Could not click on CustomSection in Visit section page", driver, className, methodName);
	waitForPageLoad(driver);
 	assertTrue(click(driver, btndelete),"Coild not click the Delete button",driver, className, methodName);
	waitForPageLoad(driver);
	assertTrue(click(driver, btnYesButton),"Coild not click the Yes button",driver, className, methodName);
	waitForPageLoad(driver);
	waitForPageLoad(driver);
	if(isElementPresent(driver,btnErrorClose)){
    	click(driver,btnErrorClose);}
	assertTrue(!isTextPresent(driver,encounterTemplateTestData.SectionName),"Section did not get deleted",driver, className, methodName);
	return true;
}


/**
		 *Verify Edited Visit sections 
		 * Function to Verify Edited Visit sections 
		 * @param 	selenium
	  	 * @throws Exception 
		 * @since	DEC 25,2014
		 */ 

public boolean verifyEditedVisitSection(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)
{  
        waitForPageLoad(driver);
 assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel1Edit),"Edited Freee tect label is  Not created", driver, className, methodName);
 assertTrue(isTextPresent(driver,encounterTemplateTestData.NumericLabel),"Edited TitleLabelEdit label is  Not created", driver, className, methodName);
 return true;

}
	    
	    /**
  		 *Verify Edited Visit visit sections in Encounter note page 
  		 * Function to Verify Edited Visit sections 
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	DEC 25,2014
  		 */ 
public boolean verifyEditedDefaultTemplateInEncounterNote(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)
{
	assertTrue(isTextPresent(driver,encounterTemplateTestData.FreeTextLabel),"FreeTextLabel is not present",driver, className, methodName);
			
	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel),"QuestionLabel is not present",driver, className, methodName);
			
	assertTrue(isTextPresent(driver,encounterTemplateTestData.NumericLabel),"NumericLabel is not present",driver, className, methodName);
			
	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel1),"TitleLabel is not present",driver, className, methodName);
			
	assertTrue(isTextPresent(driver,encounterTemplateTestData.Answer1),"Answer1 is not present",driver, className, methodName);
		
	assertTrue(isTextPresent(driver,encounterTemplateTestData.Answer2),"Answer2 is not present",driver, className, methodName);
		
	assertTrue(isTextPresent(driver,encounterTemplateTestData.Answer3),"Answer3 is not present",driver, className, methodName);
			
	assertTrue(isTextPresent(driver,encounterTemplateTestData.ComponenetName),"ComponenetName is not present",driver, className, methodName);
			
	assertTrue(isTextPresent(driver,encounterTemplateTestData.instructionWidget),"FreeTextLabelEdit is not present",driver, className, methodName);
			
	assertTrue(isTextPresent(driver,encounterTemplateTestData.datelabel),"TitleLabelEdit is not present",driver, className, methodName);
			
 	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel1Edit),"Edited Question label is  Not created", driver, className, methodName);
 	
	assertTrue(isTextPresent(driver,encounterTemplateTestData.SectionName),"SectionName is not present",driver, className, methodName);
	
		return true;
}

	    /**
  		 *Navigate to visit section
  		 * Function to Navigate to visit section
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	DEC 25,2014
  		 */  
	    
	    public boolean navigateToVisitsection(WebDriver driver)  	    {	
	    	waitForPageLoad(driver);
	    	assertTrue(selectValueFromAjaxList(driver,templateName,"Visit Section"),"Selecting Custom section failed", driver, className, methodName);
	    	waitForPageLoad(driver);
	    	
	    	
			return true;
	    	
	    }
	    

	    /**
  		 *Delete Some of the widgets and verify that 
  		 * Function to Navigate to visit section
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	DEC 25,2014
  		 */  
	    
	    public boolean verifyDeletereusewidget(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)  	    {	
	    	
	    	try{
	    		waitForPageLoad(driver);
	    		assertTrue(selectVisitSection(driver,encounterTemplateTestData.SectionName), "Could not click on CustomSection in Visit section page", driver, className, methodName);
	    		waitForPageLoad(driver);
	    		assertTrue(click(driver,btnVisitysectionEdit),"Could not click the Edit button in visit section ", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(click(driver,btnDeleteFreetext),"Could not click the Delete button in Edit visit section for free text", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(click(driver,btnYesButton),"Could not click the Yes button in Edit visit section for free text", driver, className, methodName);
				waitForPageLoad(driver);
			
				assertTrue(click(driver,btnDeletenumeric),"Could not click the Delete button in  Edit visit section for numeric widget", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(click(driver,btnYesButton),"Could not click the Yes button in Edit visit section for free text", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(click(driver, btnSectionSave),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
		    	waitForPageLoad(driver);		    	
		    	assertTrue(click(driver, btnAddCustom),"Click on Add section failed",driver, className, methodName);
		    	waitForPageLoad(driver);
		    	assertTrue(click(driver, txtWidgetRow2),"Could not click the Date field widget ", driver, className, methodName);
		    	waitForPageLoad(driver);
		    	JavascriptExecutor js1 = (JavascriptExecutor) driver;
		    	js1.executeScript("return document.getElementById('Free text').click()");
		    	waitForPageLoad(driver);
		       	assertTrue(!isTextPresent(driver, encounterTemplateTestData.FreeTextLabel),"Deleted freetext widget should not be present in free text widget list ", driver, className, methodName);
		       	js1.executeScript("return document.getElementById('Numeric Input').click()");
		    	waitForPageLoad(driver);
		       	assertTrue(isTextPresent(driver, encounterTemplateTestData.NumericLabel),"Deleted multiple reuse widget should be present in list  ", driver, className, methodName);
		    	assertTrue(click(driver, btnSectioncancel),"Could not click Cancel button ", driver, className, methodName);
		    	waitForPageLoad(driver);
		    	assertTrue(click(driver,btnYesButton),"Could not click the Yes button in Edit visit section for free text", driver, className, methodName);
				waitForPageLoad(driver);	       	
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
	    	
	    	
	    	
			return true;
	    	
	    }
	    
	    /**
  		 *Navigate to visit outline
  		 * Function to Navigate to visit outline
  		 * @param 	selenium
  	  	 * @throws Exception 
  	  	 * @Version 2.1
  		 * @since	DEC 25,2014
  		 */  
	    
	    public boolean navigateToVisitoutline(WebDriver driver)  	    {	
	    	
	    	assertTrue(selectValueFromAjaxList(driver,templateName,"Visit Outline"),"Selecting Custom section failed", driver, className, methodName);
		waitForPageLoad(driver);
	    	    return true;
	    }
	    	       
	    
		/**
		 * Verify Created Custom Sections 
		 * Function to Verify Created Custom Sections 
		 * @param 	selenium
	  	 * @throws Exception 
		 * @since	DEC 25,2014
		 */ 
	    public boolean verifyCreatedSection(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)
	    {	
	
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.FreeTextLabel),"FreeTextLabel Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel),"QuestionLabel Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel1),"Seconf Question  Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.NumericLabel),"NumericLabel Label Not created", driver, className, methodName);	    	
	        WebElement scrollUp = driver.findElement(lblVisitSectionScroll);
			scrollUp.sendKeys(Keys.PAGE_DOWN);
	        waitForPageLoad(driver);
			scrollUp.sendKeys(Keys.PAGE_DOWN);	    	
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.instructionWidget),"instruction Widget Not created", driver, className, methodName);	
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.TitleLabel.toUpperCase()),"title Widget Not created", driver, className, methodName);	    	
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.datelabel),"Date Widget Not created", driver, className, methodName);	 
	    	return true;
	    		
	    }

	    
	    /**
  		 *click on Edit Button
  		 * Function to click on Edit Button
  		 * @param 	selenium
  	  	 * @throws Exception 
  	  	 * @Version 2.1
  		 * @since	DEC 26,2014
  		 */  
	    	    
	    public boolean clickOnEncoEdit(WebDriver driver)  	    {	
	    	assertTrue(click(driver, encoEdit),"Coild not click the Edit button", driver, className, methodName);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
	    	return true;
	    }
	
	    
	    /**
  		 *select Default Template
  		 * Function to select Default Template
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	DEC 26,2014
  		 */  

	    
	    public boolean selectDefaultTemplate(WebDriver driver) throws IOException, ExceptionHandler{
	    	waitForPageLoad(driver);
       		assertTrue(getText(driver,lblTemplate).contains("Default"),"Could not click default template name",driver, className, methodName);
    		assertTrue(click(driver,lblTemplate), "Could not click default template name",driver, className, methodName);
    		waitForPageLoad(driver);
    		waitForPageLoad(driver);
       	return true;
    }
   
	    /**
  		 *add VisitSection With VisitOutline
  		 * Function to add VisitSection With VisitOutline
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	DEC 26,2014
  		 */  

	    public boolean addNewVisitSectionWithVisitOutline(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)   {
			assertTrue(click(driver, btnAddNewUserDefined), "Could not click on Add new component", driver, className, methodName);
			waitForPageLoad(driver);
	    	if(encounterTemplateTestData.sectionC.equals("Yes")){
	    		assertTrue(type(driver, txtCustomCompName2,encounterTemplateTestData.ComponenetName),"Could not type the lable name", driver, className, methodName);	
				assertTrue(selectValueFromAjaxList(driver,ajxTemplateType3,"Use Custom"),"Selecting Custom componenet  failed", driver, className, methodName);
	    	}
	    	else  if(encounterTemplateTestData.sectionD.equals("Yes")){
	    		assertTrue(type(driver, txtCustomCompName3,encounterTemplateTestData.ComponenetName),"Could not type the lable name", driver, className, methodName);	
	    		ajxTemplateType4=By.xpath(" //tr[2]/td/div/div/div/div/div[3]/div/div/div/input");
	    		assertTrue(selectValueFromAjaxList(driver,ajxTemplateType4,"Use Custom"),"Selecting Custom componenet  failed", driver, className, methodName);
	    	}
	    	else
	    	{
	    		assertTrue(type(driver, txtCustomCompName,encounterTemplateTestData.ComponenetName),"Could not type the lable name", driver, className, methodName);	
	    		assertTrue(selectValueFromAjaxList(driver,ajxTemplateType,"Use Custom"),"Selecting Custom componenet  failed", driver, className, methodName);
	    	}
	    	assertTrue(click(driver, btnAddcustomSection), "Could not click on Add custom section", driver, className, methodName);
			waitForPageLoad(driver);
			assertTrue(type(driver, txtCustomSectionLAbel,encounterTemplateTestData.SectionName),"Could not type the lable name", driver, className, methodName);	
			assertTrue(selectValueFromAjaxList(driver,ajxTemplateType,"Use Custom"),"Selecting Custom componenet  failed", driver, className, methodName);
			assertTrue(click(driver, btnSelectfronlibrary), "Could not click on Select from library ", driver, className, methodName);
			waitForPageLoad(driver);
			assertTrue(selectVisitSection(driver,encounterTemplateTestData.SectionName), "Could not click on CustomSection in Visit section page", driver, className, methodName);
			assertTrue(click(driver,btnusethis), "Could not click on Use this button in Visit section page", driver, className, methodName);
			waitForPageLoad(driver);
			assertTrue(click(driver,btnSaveCustomSection), "Could not click on Use this button in Visit section page", driver, className, methodName);
			waitForPageLoad(driver);
			By unlockbutton=By.xpath("//button[@type='button']");
			if(isVisible(driver,unlockbutton))			{
				click(driver,unlockbutton);
				waitForPageLoad(driver);
				click(driver,unlockYes);	
			}
			
			if(!isChecked(driver,chkPlanandRecom)){
			assertTrue(click(driver, chkPlanandRecom),"Coild not click the Plan and Recomme check box", driver, className, methodName);
			waitForPageLoad(driver);
			}
			assertTrue(click(driver,btnSave2), "Could not click on Use this button in Visit section page", driver, className, methodName);
			waitForPageLoad(driver);
	    	return true;
	    }
	    

	    /**
  		 *add VisitSection With VisitOutline
  		 * Function to add VisitSection With VisitOutline
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	DEC 26,2014
  		 * @Version 2.1
  		 */  

	    public boolean addVisitSectionWithVisitOutline(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)   {
	    	String checkBox="(//input[contains(@id,'checkBox')])[";
	    	for(int count=2;count<=getXpathCount(driver,chkboxcomponent);count++)
	    	{
	    	   if(!isChecked(driver,By.xpath(checkBox+count+"]")))
	    	   {
	    		   assertTrue(click(driver,By.xpath(checkBox+count+"]")),"unable to click the check box"+count,driver,className,methodName);
	    	   }
	    	}
	    	waitForPageLoad(driver);
	    	assertTrue(click(driver,visitSectionEditButton),"unable to click the visit section edit button",driver,className,methodName);
	    	waitForPageLoad(driver);
	    	assertTrue(click(driver,selectAllCheckBox),"unable to check select all check box",driver,className,methodName);
	    	waitForPageLoad(driver);
	    	assertTrue(click(driver,saveAll),"unable to click save button",driver,className,methodName);
	    	waitForPageLoad(driver);

	    	assertTrue(selectValueFromAjaxList(driver,ajxSuggestBox1,encounterTemplateTestData.visitType1),"Could not select visit type"+encounterTemplateTestData.toString(),driver, className, methodName);
	    	waitForPageLoad(driver);
			assertTrue(click(driver, btnAddNewUserDefined), "Could not click on Add new component", driver, className, methodName);
			waitForPageLoad(driver);
	    	if(encounterTemplateTestData.sectionC.equals("Yes")){
	    		assertTrue(type(driver, txtCustomCompName,encounterTemplateTestData.SectionName),"Could not type the lable name", driver, className, methodName);	
				assertTrue(selectValueFromAjaxList(driver,ajxTemplateType,"Use Custom"),"Selecting Custom componenet  failed", driver, className, methodName);
	    	}
	    	else  if(encounterTemplateTestData.sectionD.equals("Yes")){
	    		assertTrue(type(driver, txtCustomCompName1,encounterTemplateTestData.SectionName),"Could not type the lable name", driver, className, methodName);	
	    	 		assertTrue(selectValueFromAjaxList(driver,ajxTemplatetypeSecond,"Use Custom"),"Selecting Custom componenet  failed", driver, className, methodName);
	    	}
	    	else
	    	{
	    		assertTrue(type(driver, txtCustomCompName,encounterTemplateTestData.ComponenetName2),"Could not type the lable name", driver, className, methodName);	
	    		assertTrue(selectValueFromAjaxList(driver,ajxTemplateType,"Use Free Text"),"Selecting Custom componenet  failed", driver, className, methodName);
	    		waitForPageLoad(driver);
	    		click(driver, btnAddNewUserDefined);
	    		type(driver, txtCustomCompName1,encounterTemplateTestData.ComponenetName);
	    		selectValueFromAjaxList(driver,ajxTemplatetypeSecond,"Use Custom");
	    	}
	    	waitForPageLoad(driver);
	       	assertTrue(click(driver, btnAddcustomSection), "Could not click on Add custom section", driver, className, methodName);
			waitForPageLoad(driver);
			type(driver, txtCustomSectionLAbel,encounterTemplateTestData.sectionName2);
			selectValueFromAjaxList(driver,ajxTemplateType,"Use Free Text");	
				click(driver, btnAddcustomSection);
				waitForPageLoad(driver);
			assertTrue(type(driver, txtCustomSectionLAbel1,encounterTemplateTestData.SectionName),"Could not type the lable name", driver, className, methodName);	
			assertTrue(selectValueFromAjaxList(driver,ajxTemplatetypeSecond,"Use Custom"),"Selecting Custom componenet  failed", driver, className, methodName);
			waitForPageLoad(driver);
			assertTrue(click(driver, btnSelectfronlibrary), "Could not click on Select from library ", driver, className, methodName);
			waitForPageLoad(driver);
			assertTrue(selectVisitSection(driver,encounterTemplateTestData.SectionName), "Could not click on CustomSection in Visit section page", driver, className, methodName);
			assertTrue(click(driver,btnusethis), "Could not click on Use this button in Visit section page", driver, className, methodName);
			waitForPageLoad(driver);		
			checkcheckboxes(driver);
			assertTrue(click(driver,btnSaveCustomSection), "Could not click on Use this button in Visit section page", driver, className, methodName);
			waitForPageLoad(driver);
			By unlockbutton=By.xpath("//button[@type='button']");
			if(isVisible(driver,unlockbutton))			{
				click(driver,unlockbutton);
				waitForPageLoad(driver);
				click(driver,unlockYes);	
			}			
			if(!isChecked(driver,chkPlanandRecom)){
			assertTrue(click(driver, chkPlanandRecom),"Coild not click the Plan and Recomme check box", driver, className, methodName);
			waitForPageLoad(driver);
			}
			assertTrue(click(driver,btnSave2), "Could not click on Use this button in Visit section page", driver, className, methodName);
			waitForPageLoad(driver);
	    	return true;
	    }
	    
	
	    /**
  		 * go to edit Visit Section
  		 * Function to go to edit Visit Section
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	DEC 26,2014
  		 */  

	    public boolean goToEditVisitSection(WebDriver driver) {

		assertTrue(click(driver,lblCustomVisitSection),"Could not click the First Labek in visit section that we have alresdy created ", driver, className, methodName);
		waitForPageLoad(driver);
		assertTrue(click(driver,btnVisitysectionEdit),"Could not click the Edit button in visit section ", driver, className, methodName);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		return true;
	    }

	    
	    /**
  		 *Select Visit Section 
  		 * Function to Select Visit Section 
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	DEC 26,2014
  		 */  
	    public boolean selectVisitSection(WebDriver driver,String sectionName) 		{
	    	try{
	    	for(int count=1;count<=10;count++)
	    	{
	    		By tempPosition=By.xpath("(//*[starts-with(@id,'templateFocusPanel')])["+count+"]");
	    		if(isElementPresent(driver,tempPosition) && getText(driver,tempPosition).contains(sectionName))
	    		{
	    			assertTrue(click(driver,tempPosition), "Could not click on the Visit section", driver, className, methodName);
	    			waitForPageLoad(driver);
	    			break;
	    		}
	    	}
	    		
	    	}
				catch(Exception e)
				{
					Assert.fail(e.getMessage());
				}
			return true;
	    }
				  /**
  		 *add Second VisitSection With VisitOutline
  		 * Function to add VisitSection With VisitOutline
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	DEC 26,2014
  		 */  

	    public boolean addVisitSecondSectionWithVisitOutline(WebDriver driver,ClinicalSettingLib encounterEditTemplateTestData)   {
			try
			{
				assertTrue(click(driver, btnAddNewUserDefined), "Could not click on Add new component", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(type(driver, txtCustomCompName1,encounterEditTemplateTestData.ComponenetName),"Could not type the lable name", driver, className, methodName);	
				assertTrue(selectValueFromAjaxList(driver,ajxTemplateType,"Use Custom Content"),"Selecting Custom componenet  failed", driver, className, methodName);
				waitForPageLoad(driver);
			waitForPageLoad(driver);
				waitForPageLoad(driver);
				assertTrue(click(driver, btnAddcustomSection), "Could not click on Add custom section", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(type(driver, txtCustomSectionLAbel1,encounterEditTemplateTestData.SectionName),"Could not type the lable name", driver, className, methodName);	
				assertTrue(selectValueFromAjaxList(driver,ajxTemplateType,"Use Custom Content"),"Selecting Custom componenet  failed", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(click(driver, btnSelectfronlibrary), "Could not click on Select from library ", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(selectVisitSection(driver,encounterEditTemplateTestData.SectionName), "Could not click on CustomSection in Visit section page", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(click(driver,btnusethis), "Could not click on Use this button in Visit section page", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(click(driver,btnSaveCustomSection), "Could not click on Use this button in Visit section page", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(click(driver,btnSave2), "Could not click on Use this button in Visit section page", driver, className, methodName);
				waitForPageLoad(driver);
			}
			catch (Exception e)
			{
			Assert.fail(e.getMessage());
			}
	       	return true;
	    } 
	    
	    
	    
	    /**
  		 *click on Edit Button
  		 * Function to click on Edit Button
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since   05, Jan 2015	
  		 *   		 */    
	    public boolean uncheckPlanAndRecom(WebDriver driver)
	    {
	    	assertTrue(click(driver, chkPlanandRecom),"Coild not click the Plan and Recomme check box", driver, className, methodName);
			waitForPageLoad(driver);
	    	return true;
	    }
  		 
	    /**
  		 *add Second VisitSection With VisitOutline
  		 * Function to add Second VisitSection With VisitOutline
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	JAN 05,2015
  		 */  
	    public boolean addSecondVisitSectionWithVisitOutline(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)   {
			try{
				assertTrue(click(driver, btnAddNewUserDefined), "Could not click on Add new component", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(type(driver, txtCustomCompName2,encounterTemplateTestData.ComponenetName),"Could not type the lable name", driver, className, methodName);	
				assertTrue(selectValueFromAjaxList(driver,ajxSectionsuggestBox,"Use Custom"),"Selecting Custom componenet  failed", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(click(driver, btnAddcustomSection), "Could not click on Add custom section", driver, className, methodName);
			//	waitForPageLoad(driver);
				assertTrue(type(driver, txtCustomSectionLAbel,encounterTemplateTestData.SectionName),"Could not type the lable name", driver, className, methodName);	
				assertTrue(selectValueFromAjaxList(driver,ajxTemplateType,"Use Custom Content"),"Selecting Custom componenet  failed", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(click(driver, btnSelectfronlibraryatfirst), "Could not click on Select from library ", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(selectVisitSection(driver,encounterTemplateTestData.SectionName), "Could not click on CustomSection in Visit section page", driver, className, methodName);
			/*	waitForPageLoad(driver);*/
				assertTrue(click(driver,btnusethis), "Could not click on Use this button in Visit section page", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(click(driver,btnSaveCustomSection), "Could not click on Use this button in Visit section page", driver, className, methodName);
				waitForPageLoad(driver);
			//	waitForPageLoad(driver);
				if(encounterTemplateTestData.planAndRecom.equals("Yes"))
				{
					assertTrue(click(driver, chkPlanandRecom),"Coild not click the Plan and Recomme check box", driver, className, methodName);
					Thread.sleep(2000);				}
				assertTrue(click(driver,btnSave2), "Could not click on Use this button in Visit section page", driver, className, methodName);
				waitForPageLoad(driver);
			}
	    	catch(Exception e)
	    	{
	    	Assert.fail(e.getLocalizedMessage());	
	    	}
	    

	    	return true;
	    }
	    
	    /**
  		 *Create a second visit section
  		 * Function to  Edit Created Visit sections 
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	DEC 26,2014
  		 */ 
	    
	    public boolean createSecondVisitSection(WebDriver driver,ClinicalSettingLib encounterEditTemplateTestData)  
	    {		  	
	    	try {
	    		assertTrue(click(driver, btnAddCustom),"Click on Add section failed",driver, className, methodName);
		    	waitForPageLoad(driver);
		       	waitForPageLoad(driver);
		    	assertTrue(type(driver, txtTemplateName,encounterEditTemplateTestData.SectionName), "Could not type template name",driver, className, methodName);
		    	assertTrue(type(driver, txtAreaTemplateDescription, encounterEditTemplateTestData.SectionDescription), "Could not type template description",driver, className, methodName);
		       	assertTrue(click(driver, txtWidgetRow2),"Could not click the Date field widget ", driver, className, methodName);
		    	assertTrue(selectValueFromAjaxList(driver,ajxSuggestBox,encounterEditTemplateTestData.visitType1),"Could not select visit type"+encounterEditTemplateTestData.toString(),driver, className, methodName);
		    	waitForPageLoad(driver);	    	
		    	JavascriptExecutor js1 = (JavascriptExecutor) driver;
		    	js1.executeScript("return document.getElementById('Numeric Input').click()");		    	      	
		    	waitForPageLoad(driver);
		    	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
		    	for(int count=1;count<8;count++)
		    	{	
		    		By tempid=By.xpath("(//*[contains(@id,'widgetName_NumericInput')])["+count+"]");
		    		By temptndAdd=By.xpath("(//*[contains(@id,'addAnchor_NumericInput')])["+count+"]");
		    		System.out.println(getText(driver,tempid));
		    		System.out.println(numericWidget);
		    		if((isElementPresent(driver,tempid)) && ( getText(driver,tempid).contains(encounterEditTemplateTestData.NumericLabel)))
		    		{
		    			assertTrue(webElementclick(driver, temptndAdd),"Click on Add numeric widget section failed",driver, className, methodName);
		    			waitForPageLoad(driver);
		    			break;
		    		}
		    		
		    	}	    	
		    	assertTrue(click(driver, txtWidgetRow4),"Could not click the Date field widget ", driver, className, methodName);
		    	waitForElementToLoad(driver,lnkFreeTextLabelwid);
		     	assertTrue(click(driver, lnkFreeTextLabelwid),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
		    	waitForElementToLoad(driver,txtFreeTextLable);
		    	assertTrue(type(driver, txtFreeTextLable,encounterEditTemplateTestData.FreeTextLabelEdit),"Could not type the lable name",driver, className, methodName);
		    	assertTrue(click(driver, btnSaveWidget),"Click on Save button  in section failed",driver, className, methodName);
		    	waitForPageLoad(driver);		    	
		    	assertTrue(click(driver, btnSectionSave),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
		    	waitForPageLoad(driver);		    	
		    	
	    	}
	    	catch(Exception e){
	    		 new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "","", "fail", "", getCallingMethodAndLineNumber()) );
	    	}
	    	return  true;
	    }

	    
	    
	    /**
  		 *Edit Previously created visit section when creating reuse widget 
  		 * Function to  Edit Created Visit sections 
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	MAR 11,2015
  		 */ 
	    public boolean editpreviousvisitsection(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)  
	    {		  	try{
	    	
	    	selectVisitSection(driver,encounterTemplateTestData.SectionName);
	    	 waitForElementToLoad(driver,btnVisitysectionEdit  );
	    	click(driver,btnVisitysectionEdit);
	    	 waitForElementToLoad(driver, btnFreeTextEdit );
	    	//Free Text Edit
	    	click(driver,btnFreeTextEdit);
	    	if(isChecked(driver,chkinputrequest)){
	    		click(driver,chkinputrequest);
	    	}
	    	click(driver,btnSaveWidget);
	    	 waitForElementToLoad(driver, dtnsecondEdit );
	     	click(driver,dtnsecondEdit);
	    	waitForPageLoad(driver);
	    /*	//Numeric Text Edit
	     	click(driver,btnNumericEdit);
	     	 waitForElementToLoad(driver,chkinputneeded  );
	    	if(isChecked(driver,chkinputneeded)){
	    		click(driver,chkinputneeded);
	    	}	    	
	    	click(driver,btnSaveWidget);
	    	 waitForElementToLoad(driver,dtnsecondEdit  );
	     	click(driver,dtnsecondEdit);
	    	waitForPageLoad(driver);*/
	    	//Question Widget-1
	     	
	    	click(driver,btnQueseditone);
	     	WebElement scrollUp2 = driver.findElement(questionWidgetScroll);
			scrollUp2.sendKeys(Keys.PAGE_DOWN);
	    	scrollUp2.sendKeys(Keys.PAGE_DOWN);
	    	 waitForElementToLoad(driver,chkinputneeded  );
	    	if(isChecked(driver,chkinputneeded)){
	    		click(driver,chkinputneeded);
	    	}	    	
	    	scrollUp2.sendKeys(Keys.PAGE_UP);
	 		scrollUp2.sendKeys(Keys.PAGE_UP);
	    	click(driver,btnSaveWidget);
	     	click(driver,dtnsecondEdit);
	     	 waitForElementToLoad(driver,btnQuesedittwo  );
	     	//Question Widget-2
	     	
	    	click(driver,btnQuesedittwo);
	    	waitForPageLoad(driver);
	    	if(isChecked(driver,chkinputneeded)){
	    		click(driver,chkinputneeded);
	    	}	    	
	    	click(driver,btnSaveWidget);
	     	click(driver,dtnsecondEdit);
	     	 waitForElementToLoad(driver,btnQueseditthree  );
	     	//Question Widget-3
	     	
	    	click(driver,btnQueseditthree);//add dropdown
	    	waitForPageLoad(driver);
	    	WebElement scrollUp1 = driver.findElement(questionWidgetScroll);
			scrollUp1.sendKeys(Keys.PAGE_DOWN);
	 		scrollUp1.sendKeys(Keys.PAGE_DOWN);
	    	waitForPageLoad(driver);
	    	if(isChecked(driver,chkinputneeded)){
	    		click(driver,chkinputneeded);
	    	}	    	
	    	scrollUp1.sendKeys(Keys.PAGE_UP);
	 		scrollUp1.sendKeys(Keys.PAGE_UP);
	    	click(driver,btnSaveWidget);
	     	click(driver,dtnsecondEdit);
	     	 waitForElementToLoad(driver,  btnQueseditfour);
	    	
	     	//Question Widget-4
	     	
	    	click(driver,btnQueseditfour);
	    	waitForPageLoad(driver);
	    	if(isChecked(driver,chkinputneeded)){
	    		click(driver,chkinputneeded);
	    	}	    	
	    	click(driver,btnSaveWidget);
	     	click(driver,dtnsecondEdit);	    	
	     	 waitForElementToLoad(driver, btnQueseditfive );
	     	//Question Widget-4
	     	
	    	click(driver,btnQueseditfive);
	    	waitForPageLoad(driver);
	    	if(isChecked(driver,chkinputneeded)){
	    		click(driver,chkinputneeded);
	    	}	    	
	    	click(driver,btnSaveWidget);
	     	click(driver,dtnsecondEdit);
	    	waitForPageLoad(driver);	
	    	
	    
	    	
	    	
	    
	    //Reuse already created NMumeric Widget
	        click(driver,txtWidgetRow19);
	     	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    	js1.executeScript("return document.getElementById('Numeric Input').click()");		    	      	
	    	waitForPageLoad(driver);
	    	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
	    	for(int count=1;count<8;count++)
	    	{	
	    		By tempid=By.xpath("(//*[contains(@id,'widgetName_NumericInput')])["+count+"]");
	    		By temptndAdd=By.xpath("(//*[contains(@id,'addAnchor_NumericInput')])["+count+"]");
	    			if((isElementPresent(driver,tempid)) && ( getText(driver,tempid).contains(encounterTemplateTestData.NumericLabel)))
	    		{
	    			assertTrue(webElementclick(driver, temptndAdd),"Click on Add numeric widget section failed",driver, className, methodName);
	    			waitForPageLoad(driver);
	    			break;
	    		}
	    		
	    	}	
	    	
	    	//Reuse the question widget
	        click(driver,txtWidgetRow21);
	       	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	    	js2.executeScript("return document.getElementById('Question').click()");		    	      	
	    	waitForPageLoad(driver);
	    	By scroll=By.xpath("//*[@id='dialogBoxAdd']/div/div/div[2]");
	   	  	WebElement scrollUp = driver.findElement(scroll);
	   	  	scrollUp.sendKeys(Keys.PAGE_DOWN);
	   	   	scrollUp.sendKeys(Keys.PAGE_DOWN);
	   	 for(int count=1;count<10;count++)
	    	{	
	    		By tempid=By.xpath("(//*[contains(@id,'widgetName_Question')])["+count+"]");
	    		By temptndAdd=By.xpath("(//*[contains(@id,'addAnchor_Question')])["+count+"]");
	    		if((isElementPresent(driver,tempid)) && ( getText(driver,tempid).contains(encounterTemplateTestData.questionLabel5)))
	    		{
	    			assertTrue(webElementclick(driver, temptndAdd),"Click on Add numeric widget section failed",driver, className, methodName);
	    		//	waitForPageLoad(driver);
	    			break;
	    		}
	    		
	    	}	
	    	
	    	click(driver, btnSectionSave);
	    	waitForPageLoad(driver);	 
	    	//waitForPageLoad(driver);	
	    }
	    	catch(Exception e)
	    	{
	    	       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "","", "fail", "", getCallingMethodAndLineNumber()) );
	    	}
	    	
	    	return true;
	    }
	    
	    
	    /**
  		 *Verify the created widgets in patient's encounter note
  		 * Function to  Verify the created widgets in patient's encounter note
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	JAN 26,2015
  		 */ 
	    

	    public boolean verifyReuseWidegt(WebDriver driver,ClinicalSettingLib encounterEditTemplateTestData,ClinicalSettingLib encounterTemplateTestData)
	    {
	   
	    	
		    //Verify Section B Widgets in Encounter Note
	    /*	assertTrue(isTextPresent(driver,encounterEditTemplateTestData.FreeTextLabelEdit),"FreeTextLabel Label Not created", driver, className, methodName);
	        //Verify Section A Widgets in Encounter Note
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel1Edit),"Edited Question Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel1),"Edited Question Label Not created", driver, className, methodName);
	    	assertTrue(	isTextPresent(driver,encounterTemplateTestData.QuestionLabel3),"Question widget is not present ", driver, className, methodName);
	    	assertTrue(	isTextPresent(driver,encounterTemplateTestData.QuestionLabel4),"Question widget is not present ", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.questionLabel5),"Question widget is not present ", driver, className, methodName);
	    	isTextPresent(driver,encounterTemplateTestData.assessment);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.TitleLabel.toUpperCase()),"Edited Question Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.NumericLabel),"Edited Numeric  Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.instructionWidget),"Edited Instruction  Label Not created", driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.datelabel),"Edited Instruction  Label Not created", driver, className, methodName);*/
	    	 scrollDown(driver);
	    	return true;
	    }
	    /**
  		 *Create a visit section with single widget 
  		 * Create a visit section with single widget 
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	JAN 16,2015
  		 * @Version 2.1
  		 */ 
	    /**
  		 *Create a visit section with single widget 
  		 * Create a visit section with single widget 
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	JAN 16,2015
  		 * @Version 2.1
  		 */ 
	    public boolean createVisitSectionWithSingleTextWidget(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,String uniqueName)
	    {
	    	try{
		    	assertTrue(click(driver, btnAddCustom),"Click on Add section failed",driver, className, methodName);
		    	waitForPageLoad(driver);	   
		    	assertTrue(type(driver, txtTemplateName,encounterTemplateTestData.SectionName+uniqueName), "Could not type template name",driver, className, methodName);
		    	assertTrue(type(driver, txtAreaTemplateDescription, encounterTemplateTestData.SectionDescription), "Could not type template description",driver, className, methodName);
		       	assertTrue(click(driver, txtWidgetRow2),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
		    	assertTrue(click(driver, lnkFreeTextLabelwid),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
		    	assertTrue(type(driver, txtFreeTextLable,encounterTemplateTestData.FreeTextLabel),"Could not type the lable name",driver, className, methodName);
		    	assertTrue(click(driver, btnSaveWidget),"Click on Save button  in section failed",driver, className, methodName);
		    	waitForPageLoad(driver);
		    	assertTrue(isTextPresent(driver,encounterTemplateTestData.FreeTextLabel),"Widget is not added",driver, className, methodName);
		    	assertTrue(click(driver, btnSectionSave),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
		    	waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

	    	}
	    	return true;
	    }
	    /**
  		 *Navigate to Manage care Template
  		 * Navigate to Manage care Template
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	JAN 16,2015
  		 * @Version 2.1
  		 */ 
	    /**
  		 *Navigate to Manage care Template
  		 * Navigate to Manage care Template
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	JAN 16,2015
  		 * @Version 2.1
  		 */ 
	    public boolean navigateToMangaedCareTemplate(WebDriver driver)
		{try{
			assertTrue(selectValueFromAjaxList(driver,templateName,"Managed Care"),"Could not select template type", driver, className, methodName);
			waitForPageLoad(driver);
		}
		catch(Exception e)
		{
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
		}
		return true;
		}
	    /**
  		 *Edit Previously Created Visit Section
  		 * Function to Edit Previously Created Visit Section
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	JAN 13,2015
  		 * @Version 2.1
  		 */ 
	    /**
  		 *Edit Previously Created Visit Section
  		 * Function to Edit Previously Created Visit Section
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	JAN 13,2015
  		 * @Version 2.1
  		 */ 
	    public boolean editVisitSectionWithQuestionWidget(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)
	    {
	    	try{
	    	assertTrue(click(driver,btnVisitysectionEdit),"Unable to click the edit button",driver,className,methodName);
	    	waitForPageLoad(driver);
	    	assertTrue(click(driver, txtWidgetRow6),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
	    	waitForPageLoad(driver);
	    	assertTrue(click(driver, lnkQuestionWidget),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
	    	assertTrue(type(driver, txtQuestionLabel,encounterTemplateTestData.QuestionLabel1),"Could not type the lable name",driver, className, methodName);
	    	assertTrue(type(driver, txtQuestionTotalAnswer,encounterTemplateTestData.QuestionAnswer1),"Could not type the lable name",driver, className, methodName);
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("return document.getElementById('totalAns').blur()");
            waitForPageLoad(driver);
	    	waitForPageLoad(driver);
	    	assertTrue(type(driver, txtQuestionAns1,encounterTemplateTestData.Answer1),"Could not type the lable name", driver, className, methodName);
	    	assertTrue(type(driver, txtQuestionAns2,encounterTemplateTestData.Answer2),"Could not type the lable name", driver, className, methodName);
	    	assertTrue(selectValueFromAjaxList(driver,ajxQuestionDefault,encounterTemplateTestData.QuestionDefault),"Could not select value"+encounterTemplateTestData.toString(),driver, className, methodName);
	    	waitForPageLoad(driver );
	        js.executeScript("return document.getElementById('onlyOneResponsecheckbox').click()");
	        waitForPageLoad(driver);
	    	assertTrue(click(driver, chkinputneeded),"Could not click the input neede in Create visit sectio page",driver, className, methodName);
	    	assertTrue(click(driver, btnQuestionsave),"Click on Save button  in section failed",driver, className, methodName);
	    	waitForPageLoad(driver);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionLabel1),"Numeric Label Not created", driver, className, methodName);
	    	assertTrue(click(driver, btnSectionSave),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
	    	waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
	    	return true;
	    }
	    /**
  		 *Delete Reuse Widgets and Verify its not present 
  		 * Function to Delete Reuse Widgets and Verify its not present 
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	JAN 13,2015
  		 * @Version 2.1
  		 */ 
	    /**
  		 *Delete Reuse Widgets and Verify its not present 
  		 * Function to Delete Reuse Widgets and Verify its not present 
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	JAN 13,2015
  		 * @Version 2.1
  		 */ 
	    public boolean deletereusedWidgetAndVerifyInWidgetList(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,ClinicalSettingLib encounterEditTemplateTestData) throws ExceptionHandler, IOException
	    {
	    	assertTrue(selectVisitSection(driver,encounterTemplateTestData.SectionName), "Could not click on CustomSection in Visit section page", driver, className, methodName);
	    	waitForPageLoad(driver);
	    	assertTrue(click(driver,btnVisitysectionEdit),"Could not click the Edit button in visit section ", driver, className, methodName);
	    	waitForPageLoad(driver);
	    	assertTrue(click(driver,btnNumericDelete),"Could not delete the numeric widget ", driver, className, methodName);
	    	waitForPageLoad(driver);
	    	assertTrue(click(driver, btnYesButton), "could not click yes button",driver, className, methodName);
	    	waitForPageLoad(driver);
	    	assertTrue(click(driver, txtWidgetRow3), "could not click row in visit section page",driver, className, methodName);
	    	waitForPageLoad(driver);
	    	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    	js1.executeScript("return document.getElementById('Numeric Input').click()");
	    	waitForPageLoad(driver);
	    	for(int count=1;count<8;count++)
	    	{	
	    		By tempid=By.xpath("(//*[contains(@id,'widgetName_NumericInput')])["+count+"]");
	    		if((isElementPresent(driver,tempid)) && ( getText(driver,tempid).contains(encounterTemplateTestData.NumericLabel)))
	    		{
	    			assertTrue(!isTextPresent(driver,encounterTemplateTestData.NumericLabel),"Deleted  reused widget should be present in widget list ",driver, className, methodName);
	    			System.out.println("Deleted Reuse widget is still present in Widgte list");
	    		}
	    		
	    	}		
	    	assertTrue(click(driver,imgPopClose),"Could not close widget pop ", driver, className, methodName);
	    	waitForPageLoad(driver);
	    	   	assertTrue(click(driver,btnTitleDelete),"Could not delete the numeric widget ", driver, className, methodName);
	    	waitForPageLoad(driver);
	    	assertTrue(click(driver, btnYesButton), "could not click yes button",driver, className, methodName);
	    	waitForPageLoad(driver);
	    	assertTrue(click(driver, btnSectionSave),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
	    	waitForPageLoad(driver);
	    	assertTrue(selectVisitSection(driver,encounterTemplateTestData.SectionName), "Could not click on CustomSection in Visit section page", driver, className, methodName);
	    	waitForPageLoad(driver);
	    	assertTrue(click(driver, btnVisitysectionEdit), "Could not click Edit button in Visit section",driver, className, methodName);
	    	waitForPageLoad(driver);	
	    	assertTrue(click(driver, txtWidgetRow3), "could not click row in visit section page",driver, className, methodName);
	    	waitForPageLoad(driver);
	    	js1.executeScript("return document.getElementById('Title').click()");	
	    	waitForPageLoad(driver);
	    	assertTrue(!isTextPresent(driver,encounterTemplateTestData.TitleLabel),"Deleted Never reused widget should not present in widget list ",driver, className, methodName);
	    	assertTrue(click(driver,imgPopClose),"Could not close widget pop ", driver, className, methodName);
	    	waitForPageLoad(driver);
	    	assertTrue(click(driver, btnSectionSave),"Coild not click the first row in Create visit sectio page",driver, className, methodName);
	    	waitForPageLoad(driver);
	    	
	    	return true;
	    	
	    }
	    /**
  		 *Scroll down the encounter note page 
  		 * Function to Scroll down the encounter note page 
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	JAN 13,2015
  		 * @Version 2.1
  		 */ 
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
	 	waitForPageLoad(driver); 
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

	    	}
			return true;
	    	
	    	
	    }

		  /**
			 * goToCreateNewVisitSection
			 * Function to go To Create New Visit Section 
			 * @param 	driver
		  	 * @throws Exception 
		  	 * @version 2.1
			 * @since	May 06,2015
			 */ 
		   
		    public boolean goToCreateNewVisitSection(WebDriver driver,ClinicalSettingLib encounterTemplateTestData) throws Exception
		    {	
		    	try {
		    		if(isElementPresent(driver,btnErrorClose)){
		            	click(driver,btnErrorClose);}
		    	assertTrue(click(driver, btnAddCustom),"Click on Add section failed",driver, className, methodName);
		    	waitForPageLoad(driver);	 
		       	assertTrue(type(driver, txtTemplateName,encounterTemplateTestData.SectionName), "Could not type template name",driver, className, methodName);
		    	assertTrue(type(driver, txtAreaTemplateDescription, encounterTemplateTestData.SectionDescription), "Could not type template description",driver, className, methodName);
		    	assertTrue(selectValueFromAjaxList(driver,ajxSuggestBox,encounterTemplateTestData.visitType1),"Could not select visit type"+encounterTemplateTestData.toString(),driver, className, methodName);
		    	}
		    	catch(Exception e)
		    	{
		    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
		    	}
				return true;
		    }

			  /**
				 * clickCanvasSection
				 * Function to click Canvas Section 
				 * @param 	driver
				 * @param   count
			  	 * @throws Exception 
			  	 * @version 2.1
				 * @since	May 06,2015
				 */ 
			   
			    public int clickCanvasSection(WebDriver driver,int count) throws Exception
			    {	
			    	try {
			    		By canvasSection = By.xpath("(//*[contains(@id,'widget_')])["+count+"]");
						verifyTrue(click(driver, canvasSection), "canvasSection not found", driver);
						waitForPageLoad(driver);
			    		count=count+2;
			    	}
			    	catch(Exception e)
			    	{
			    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
			    	}
					return count;
			    }

				  /**
					 * clickAddImageWidget
					 * Function to click Add Image Widget button 
					 * @param 	driver
				  	 * @throws Exception 
				  	 * @version 2.1
					 * @since	May 06,2015
					 */ 
				   
				    public boolean clickAddImageWidget(WebDriver driver) throws Exception
				    {	
				    	try {
							verifyTrue(click(driver, btnAddNewImageWidget), "button Add New ImageWidget not found", driver);
							waitForPageLoad(driver);
							assertTrue(isTextPresent(driver, "Add Image"), "Add Image text  is not present", driver, className, methodName);
				    	}
				    	catch(Exception e)
				    	{
				    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
				    	}
						return true;
				    }
	    
			    
	    /**
	     * createImageWidget
  		 * Function to create Image Widget 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 05,2015
  		 * @Version 2.1
  		 */ 
	    public boolean createImageWidget(WebDriver driver, ClinicalSettingLib encounterTemplateTestData)
	    {
	    	try{

				if (!encounterTemplateTestData.imageName.equals("")){
					verifyTrue(type(driver, txtName, encounterTemplateTestData.imageName), "Name text box not found", driver);
					waitForPageLoad(driver);
				}

				if (!encounterTemplateTestData.imageType.equals("")){
					assertTrue(getValue(driver, ajxImageType).contains("Always use a pre-set image"), "Default value not found", driver, className, methodName);
					verifyTrue(selectValueFromAjaxList(driver, ajxImageType, "Allow user to upload image during encounter"), "txtMedicatl not found", driver);
					waitForPageLoad(driver);
					assertTrue(!isVisible(driver, btnUploadImage), "Upload Button is present", driver, className, methodName);
					verifyTrue(selectValueFromAjaxList(driver, ajxImageType, encounterTemplateTestData.imageType), "ajxImageType not found", driver);
					waitForPageLoad(driver);
				}

				if (encounterTemplateTestData.imageType.equals("Always use a pre-set image")){
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

				}

			    By scroll=By.xpath("//*[@id='dialogBoxAdd']/div/div/div[2]");
			    WebElement scrollUp = driver.findElement(scroll);
			  	scrollUp.sendKeys(Keys.PAGE_DOWN);
			   	scrollUp.sendKeys(Keys.PAGE_DOWN);
			   	scrollUp.sendKeys(Keys.PAGE_DOWN);
			   	scrollUp.sendKeys(Keys.PAGE_DOWN);
				if (!encounterTemplateTestData.annotations.equals("")){
					if(!isChecked(driver, chkEnableAnnotations))
					verifyTrue(click(driver, chkEnableAnnotations), "chkEnableAnnotations not found", driver);
					waitForPageLoad(driver);
				

				if (!encounterTemplateTestData.numOfMarkers.equals("")){
					verifyTrue(type(driver, txtNoOfMarkers, encounterTemplateTestData.numOfMarkers), "txtNoOfMarkers not found", driver);
					waitForPageLoad(driver);
			    	JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("return document.getElementById('markerText').blur()");
			        Thread.sleep(3000);
				}
			   	scrollUp.sendKeys(Keys.PAGE_DOWN);
				if (!encounterTemplateTestData.marker1.equals("")){
					verifyTrue(type(driver, txtMarker, encounterTemplateTestData.marker1), "txtMedicatl not found", driver);
					waitForPageLoad(driver);
				}
				
				if (!encounterTemplateTestData.description1.equals("")){
					verifyTrue(type(driver, txtDescription, encounterTemplateTestData.description1), "txtMedicatl not found", driver);
					waitForPageLoad(driver);
				}
			   	scrollUp.sendKeys(Keys.PAGE_DOWN);
				if (!encounterTemplateTestData.marker2.equals("")){
					verifyTrue(type(driver, txtMarker2, encounterTemplateTestData.marker2), "txtMedicatl not found", driver);
					waitForPageLoad(driver);
				}
				
				if (!encounterTemplateTestData.description2.equals("")){
					verifyTrue(type(driver, txtDescription2, encounterTemplateTestData.description2), "txtMedicatl not found", driver);
					waitForPageLoad(driver);
				}
				}
			   	scrollUp.sendKeys(Keys.PAGE_DOWN);
			   	scrollUp.sendKeys(Keys.PAGE_DOWN);
				if (!encounterTemplateTestData.freeText.equals("")){
					if(!isChecked(driver, chkAdditionalInfo))
					verifyTrue(click(driver, chkAdditionalInfo), "txtMedicatl not found", driver);
					waitForPageLoad(driver);
				}

	    		waitForPageLoad(driver); 
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

	    	}
			return true;
	    	
	    	
	    }
	    
	    /**
	     * savecreatedImageWidget
  		 * Function to save created Image Widget 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 06,2015
  		 * @Version 2.1
  		 */ 
	    public boolean savecreatedImageWidget(WebDriver driver)
	    {
	    	try{
				verifyTrue(click(driver, btnSaveImageWidget), "Could not click save", driver);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

	    	}
			return true;
	    }

	    /**
	     * cancelCreatedImageWidget
  		 * Function to save created Image Widget 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 06,2015
  		 * @Version 2.1
  		 */ 
	    public boolean cancelCreatedImageWidget(WebDriver driver)
	    {
	    	try{
				verifyTrue(click(driver, btnCancelImageWidget), "Could not click save", driver);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

	    	}
			return true;
	    }

	    /**
	     * verifyEditCreatedImageWidget
  		 * Function to click Edit button and verify created Image Widget in Edit mode 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 07,2015
  		 * @Version 2.1
  		 */ 
	    public boolean verifyEditCreatedImageWidget(WebDriver driver, ClinicalSettingLib encounterTemplateTestData)
	    {
	    	try{
				verifyTrue(click(driver, btnEditImage), "Could not click save", driver);
				waitForPageLoad(driver);
				assertTrue(getValue(driver, txtName).contains(encounterTemplateTestData.imageName), "Name value not found", driver, className, methodName);
				assertTrue(getValue(driver, ajxImageType).contains(encounterTemplateTestData.imageType), "Default value not found", driver, className, methodName);
			    By scroll=By.xpath("//*[@id='dialogBoxAdd']/div/div/div[2]");
			    WebElement scrollUp = driver.findElement(scroll);
			  	scrollUp.sendKeys(Keys.PAGE_DOWN);
			   	scrollUp.sendKeys(Keys.PAGE_DOWN);
			   	scrollUp.sendKeys(Keys.PAGE_DOWN);
				if (!encounterTemplateTestData.annotations.equals("")){
				assertTrue(isChecked(driver, chkEnableAnnotations), "Annotations not checked", driver, className, methodName);
				assertTrue(getValue(driver, txtNoOfMarkers).contains(encounterTemplateTestData.numOfMarkers), "txtNoOfMarkers value not found", driver, className, methodName);
				assertTrue(getValue(driver, txtMarker).contains(encounterTemplateTestData.marker1), "marker1 value not found", driver, className, methodName);
				assertTrue(getValue(driver, txtDescription).contains(encounterTemplateTestData.description1), "description1 value not found", driver, className, methodName);
				if (!encounterTemplateTestData.marker2.equals("")){
				assertTrue(getValue(driver, txtMarker2).contains(encounterTemplateTestData.marker2), "marker2 value not found", driver, className, methodName);
				assertTrue(getValue(driver, txtDescription2).contains(encounterTemplateTestData.description2), "description2 value not found", driver, className, methodName);
				}
				}
				if (!encounterTemplateTestData.freeText.equals("")){
				assertTrue(isChecked(driver, chkAdditionalInfo), "Additional Info area not checked", driver, className, methodName);
				}
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

	    	}
			return true;
	    }

	    /**
	     * saveEditedImageWidget
  		 * Function to save edited Image Widget 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 07,2015
  		 * @Version 2.1
  		 */ 
	    public boolean saveEditedImageWidget(WebDriver driver, ClinicalSettingLib encounterTemplateTestData)
	    {
	    	try{
				verifyTrue(click(driver, btnSaveImageWidget), "Could not click save", driver);
				waitForPageLoad(driver);
	    		if (encounterTemplateTestData.saveAsNew.equals("Yes")){
					verifyTrue(click(driver, chkSaveAsNew), "Could not click save", driver);
					waitForPageLoad(driver);
					verifyTrue(type(driver, txtNewWidgetName, encounterTemplateTestData.imageName), "txtNewWidgetName not found", driver);
					waitForPageLoad(driver);
				}
				}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }
	    
	    /**
	     * clickSaveEditedImageWidget
  		 * Function to save Edited Image Widget 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 06,2015
  		 * @Version 2.1
  		 */ 
	    public boolean clickSaveEditedImageWidget(WebDriver driver)
	    {
	    	try{
				verifyTrue(click(driver, dtnsecondEdit), "Could not click save", driver);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }

	    /**
	     * clickCancelEditedImageWidget
  		 * Function to cancel Edited Image Widget 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 07,2015
  		 * @Version 2.1
  		 */ 
	    public boolean clickCancelEditedImageWidget(WebDriver driver)
	    {
	    	try{
				verifyTrue(click(driver, btnCancelEdit), "Could not click cancel", driver);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }

	    /**
	     * verifyCreatedImageWidget
  		 * Function to click Edit button and verify created Image Widget in Edit mode 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 07,2015
  		 * @Version 2.1
  		 */ 
	    public boolean verifyCreatedImageWidget(WebDriver driver, ClinicalSettingLib encounterTemplateTestData)
	    {
	    	try{
				assertTrue(isTextPresent(driver, encounterTemplateTestData.imageName), "Name value not found", driver, className, methodName);
				if (!encounterTemplateTestData.annotations.equals("")){
				assertTrue(isTextPresent(driver, encounterTemplateTestData.marker1), "marker1 value not found", driver, className, methodName);
				assertTrue(isTextPresent(driver, encounterTemplateTestData.description1), "description1 value not found", driver, className, methodName);
				assertTrue(isTextPresent(driver, encounterTemplateTestData.marker2), "marker2 value not found", driver, className, methodName);
				assertTrue(isTextPresent(driver, encounterTemplateTestData.description2), "description2 value not found", driver, className, methodName);
				}
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }

	    /**
	     * clickDeleteImageWidget
  		 * Function to click Delete button for Image Widget 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 07,2015
  		 * @Version 2.1
  		 */ 
	    public boolean clickDeleteImageWidget(WebDriver driver)
	    {
	    	try{
				verifyTrue(click(driver, btnDeleteImage), "Could not click delete", driver);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }

	    /**
	     * clickNoDeleteImage
  		 * Function to click No Delete button for Image Widget 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 07,2015
  		 * @Version 2.1
  		 */ 
	    public boolean clickNoDeleteImage(WebDriver driver)
	    {
	    	try{
				verifyTrue(click(driver, btnNo), "Could not click No", driver);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }

	    /**
	     * clickYesDeleteImage
  		 * Function to click Yes Delete button for Image Widget 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 07,2015
  		 * @Version 2.1
  		 */ 
	    public boolean clickYesDeleteImage(WebDriver driver)
	    {
	    	try{
				verifyTrue(click(driver, btnYesButton), "Could not click Yes", driver);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }

	    /**
	     * saveVisitSection
  		 * Function to save Visit Section
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 07,2015
  		 * @Version 2.1
  		 */ 
	    public boolean saveVisitSection(WebDriver driver)
	    {
	    	try{
				verifyTrue(click(driver, btnSectionSave), "Could not click save", driver);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }

	    /**
	     * verifyEmptyImageWidget
  		 * Function to verify Empty Image Widget
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 07,2015
  		 * @Version 2.1
  		 */ 
	    public boolean verifyEmptyImageWidget(WebDriver driver)
	    {
	    	try{
	    		mouseOver(txtName);
				assertTrue(isTextPresent(driver, "Name cannot be empty"), "marker1 value not found", driver, className, methodName);
				waitForPageLoad(driver);
	    		mouseOver(ajxImageType);
				assertTrue(isTextPresent(driver, "Please upload an image"), "marker1 value not found", driver, className, methodName);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }

	    /**
	     * clickImageWidgetCollapse
  		 * Function to click Image Widget Collapse
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 07,2015
  		 * @Version 2.1
  		 */ 
	    public boolean clickImageWidgetCollapse(WebDriver driver)
	    {
	    	try{
				verifyTrue(click(driver, lblImageCollapse), "Could not click Collapse", driver);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }

	    /**
	     * clickEditImageWidgetInCollapseView
  		 * Function to click Edit Image Widget Collapse
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 07,2015
  		 * @Version 2.1
  		 */ 
	    public boolean clickEditImageWidgetInCollapseView(WebDriver driver)
	    {
	    	try{
				verifyTrue(click(driver, btnEditFromCollapseView), "Could not click Edit", driver);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }

	    /**
	     * clickAddImageWidgetInCollapseView
  		 * Function to click Add Image Widget Collapse
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 07,2015
  		 * @Version 2.1
  		 */ 
	    public boolean clickAddImageWidgetInCollapseView(WebDriver driver)
	    {
	    	try{
				verifyTrue(click(driver, btnAddFromCollapseView), "Could not click Add", driver);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }

	    /**
	     * deleteAllImageWidgets
  		 * Function to delete All Image Widgets
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 07,2015
  		 * @Version 2.1
  		 */ 
	    public boolean deleteAllImageWidgets(WebDriver driver)
	    {
	    	try{
	    		while(isElementPresent(driver, btnDeleteImage)){
				verifyTrue(click(driver, btnDeleteImage), "Could not click Delete", driver);
				waitForPageLoad(driver);
				verifyTrue(click(driver, btnYesButton), "Could not click Yes", driver);
				waitForPageLoad(driver);
	    		}
	    		assertTrue(!isElementPresent(driver, image), "Image Widget not deleted", driver, className, methodName);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }

	    /**
	     * clickAddImageWidgetInCollapseView
  		 * Function to click Edit Visit Section
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 08,2015
  		 * @Version 2.1
  		 */ 
	    public boolean clickEditVisitSection(WebDriver driver)
	    {
	    	try{
				verifyTrue(click(driver, btnEditVisitSection), "Could not click edit", driver);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }

	    /**
	     * EditCreatedImageWidget
  		 * Function to click Edit button and verify created Image Widget in Edit mode 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 07,2015
  		 * @Version 2.1
  		 */ 
	    public boolean editCreatedImageWidget(WebDriver driver)
	    {
	    	try{
				verifyTrue(click(driver, btnEditImage), "Could not click edit", driver);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }

	    /**
	     * placeMarkerOnImage
  		 * Function to place Marker On Image 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 11,2015
  		 * @Version 2.1
  		 */ 
	    public boolean placeMarkerOnImage(WebDriver driver, ClinicalSettingLib encounterTemplateTestData)
	    {
	    	try{
	    		By marker = By.linkText(encounterTemplateTestData.marker1);
				verifyTrue(click(driver, marker), "Could not click marker", driver);
				waitForPageLoad(driver);
				verifyTrue(click(driver, image), "Could not click image", driver);
				waitForPageLoad(driver);
	    	}
	    	catch(Exception e)
	    	{
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
			return true;
	    }
	   

	    /**
	     * check problemlist and Allergy in Custom component 
  		 * Function to place Marker On Image 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 12,2015
  		 * @Version 2.1
  		 */ 
	    public boolean checkcheckboxes(WebDriver driver)
	    {
	    	try{
	    		verifyTrue(click(driver,chkallergy),"Could not click the check box",driver);
	    		verifyTrue(	click(driver,chkProblemList),"Could not click the check box",driver);
	    		    	}
	    	catch(Exception e){
	    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	    	}
	    	return true;
	    }

}
