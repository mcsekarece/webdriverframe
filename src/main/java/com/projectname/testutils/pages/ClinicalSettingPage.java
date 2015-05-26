package com.projectname.testutils.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class ClinicalSettingPage  extends SeleniumWebDriver{

	OrderTemplatePage orderTemplatePage ;
	
	public  ClinicalSettingPage() {
        PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	    private static By readyLocator = By.id("!encounterTemplates");
	    private By lnkLocationMenuHeader = By.id("locationMenuHeader");
		private By btnAddCustom =By.id("createCustomTmplbtn");
		private By lnkEncounterTemplate=By.id("!encounterTemplates");
		private By lnkLabTemplates=By.id("!labTemplates");
	

		/**
		 * Select different practice for encounter structure template 
		 * @param 	selenium
		 * @throws IOException 
		 * @since	DEC 25,2014
		 */
	 public boolean selectPractice(WebDriver driver) throws IOException, ExceptionHandler  {
	    	waitForPageLoad(driver);
	    	waitForPageLoad(driver);
	    	waitForPageLoad(driver);
	    	if(!getText(driver,lnkLocationMenuHeader).contains("Encounter")){
	    		assertTrue(click(driver,lnkLocationMenuHeader),"Could not click on practices link:", driver, className, methodName);
	    		waitForPageLoad(driver);
	    	 int count;
	    	 		for(count=1;count<=3;count++)		{
	    	 By position = By.id("xpath=(//a[contains(@id,'practice')])["+count+"]");	    			 
	    			if(getText(driver,position).contains("Encounter Structure Template")){
	    				assertTrue(click(driver,position),"Could not click on practices link:", driver, className, methodName);
	    				waitForPageLoad(driver);
	    				break;
	    			}
	    		}		
	    	}		
	    	return true;
	    }
	    
	 

		/**
		 * navigateTo Encounter Template 
		 * Function to go to Encounter Template
		 * @param 	selenium
		 * @throws IOException 
		 * @Version 2.1
		 * @since	DEC 25,2014
		 */
		public PracticeLibrary navigateToEncounterTemplate(WebDriver driver) throws IOException{
			assertTrue(click(driver, lnkEncounterTemplate), "Could not click on encounter template link",driver,className, methodName);
			waitForPageLoad(driver);
			assertTrue(isElementPresent(driver, btnAddCustom),"Element not present",driver, className, methodName);
			return new PracticeLibrary();
		}
		
	    /**
  		 *Select Visit Section 
  		 * Function to Select Visit Section 
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	DEC 26,2014
  		 */  
	    public boolean selectVisitSection(WebDriver driver,String sectionName,PracticeLibrary practiceLibrary) 		{
	    	try{
	    		practiceLibrary.selectVisitSection(driver, sectionName);
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
			 * @param   encounterTemplateTestData
		  	 * @throws Exception 
		  	 * @version 2.1
			 * @since	May 06,2015
			 */ 
		   
		    public boolean goToCreateNewVisitSection(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,PracticeLibrary practiceLibrary) throws Exception
		    {	
		    	try {
		    		practiceLibrary.goToCreateNewVisitSection(driver, encounterTemplateTestData);
					waitForPageLoad(driver);
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
			   
			    public int clickCanvasSection(WebDriver driver,int count,PracticeLibrary practiceLibrary) throws Exception
			    {	
			    	try {
			    		count=	practiceLibrary.clickCanvasSection(driver, count);
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
				   
				    public boolean clickAddImageWidget(WebDriver driver,PracticeLibrary practiceLibrary) throws Exception
				    {	
				    	try {
				    		practiceLibrary.clickAddImageWidget(driver);
				    		waitForPageLoad(driver);
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
				    public boolean createImageWidget(WebDriver driver, ClinicalSettingLib encounterTemplateTestData,PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.createImageWidget(driver, encounterTemplateTestData);
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
			  		 * @param 	selenium
			  	  	 * @throws Exception 
			  		 * @since	May 06,2015
			  		 * @Version 2.1
			  		 */ 
				    public boolean savecreatedImageWidget(WebDriver driver, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.savecreatedImageWidget(driver);
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
			  		 * @param 	selenium
			  	  	 * @throws Exception 
			  		 * @since	May 07,2015
			  		 * @Version 2.1
			  		 */ 
				    public boolean cancelCreatedImageWidget(WebDriver driver, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.cancelCreatedImageWidget(driver);
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
				    public boolean placeMarkerOnImage(WebDriver driver, ClinicalSettingLib encounterTemplateTestData, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.placeMarkerOnImage(driver, encounterTemplateTestData);
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
			  		 * Function to click Edit button for created Image Widget 
			  		 * @param 	selenium
			  	  	 * @throws Exception 
			  		 * @since	May 07,2015
			  		 * @Version 2.1
			  		 */ 
				    public boolean verifyEditCreatedImageWidget(WebDriver driver, ClinicalSettingLib encounterTemplateTestData, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.verifyEditCreatedImageWidget(driver, encounterTemplateTestData);
				    		waitForPageLoad(driver);
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
			  		 * @param 	selenium
			  	  	 * @throws Exception 
			  		 * @since	May 07,2015
			  		 * @Version 2.1
			  		 */ 
				    public boolean saveEditedImageWidget(WebDriver driver, ClinicalSettingLib encounterTemplateTestData, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.saveEditedImageWidget(driver, encounterTemplateTestData);
				    		waitForPageLoad(driver);
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
			  		 * @param 	selenium
			  	  	 * @throws Exception 
			  		 * @since	May 06,2015
			  		 * @Version 2.1
			  		 */ 
				    public boolean clickSaveEditedImageWidget(WebDriver driver, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.clickSaveEditedImageWidget(driver);
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
			  		 * @param 	selenium
			  	  	 * @throws Exception 
			  		 * @since	May 07,2015
			  		 * @Version 2.1
			  		 */ 
				    public boolean clickCancelEditedImageWidget(WebDriver driver, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.clickCancelEditedImageWidget(driver);
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
			  		 * @param 	selenium
			  	  	 * @throws Exception 
			  		 * @since	May 07,2015
			  		 * @Version 2.1
			  		 */ 
				    public boolean verifyCreatedImageWidget(WebDriver driver, ClinicalSettingLib encounterTemplateTestData, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.verifyCreatedImageWidget(driver, encounterTemplateTestData);
				    		waitForPageLoad(driver);
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
			  		 * @param 	selenium
			  	  	 * @throws Exception 
			  		 * @since	May 07,2015
			  		 * @Version 2.1
			  		 */ 
				    public boolean clickDeleteImageWidget(WebDriver driver, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.clickDeleteImageWidget(driver);
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
			  		 * @param 	selenium
			  	  	 * @throws Exception 
			  		 * @since	May 07,2015
			  		 * @Version 2.1
			  		 */ 
				    public boolean clickNoDeleteImage(WebDriver driver, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.clickNoDeleteImage(driver);
				    	}
				    	catch(Exception e)
				    	{
				    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
				    	}
						return true;
				    }

				    /**
				     * clickYesDeleteImage
			  		 * Function to click No Delete button for Image Widget 
			  		 * @param 	selenium
			  	  	 * @throws Exception 
			  		 * @since	May 07,2015
			  		 * @Version 2.1
			  		 */ 
				    public boolean clickYesDeleteImage(WebDriver driver, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.clickYesDeleteImage(driver);
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
				    public boolean saveVisitSection(WebDriver driver, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.saveVisitSection(driver);
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
				    public boolean verifyEmptyImageWidget(WebDriver driver, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.verifyEmptyImageWidget(driver);
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
				    public boolean clickImageWidgetCollapse(WebDriver driver, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.clickImageWidgetCollapse(driver);
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
				    public boolean clickEditImageWidgetInCollapseView(WebDriver driver, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.clickEditImageWidgetInCollapseView(driver);
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
				    public boolean clickAddImageWidgetInCollapseView(WebDriver driver, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.clickAddImageWidgetInCollapseView(driver);
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
				    public boolean deleteAllImageWidgets(WebDriver driver, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.deleteAllImageWidgets(driver);
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
			  		 * Function to click Edit Visit Section
			  		 * @param 	driver
			  	  	 * @throws Exception 
			  		 * @since	May 08,2015
			  		 * @Version 2.1
			  		 */ 
				    public boolean clickEditVisitSection(WebDriver driver, PracticeLibrary practiceLibrary)
				    {
				    	try{
				    		practiceLibrary.clickEditVisitSection(driver);
							waitForPageLoad(driver);
				    	}
				    	catch(Exception e)
				    	{
				    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
				    	}
						return true;
				    }


	    /**
  		 *Navigate to visit section
  		 * Function to Navigate to visit section
  		 * @param 	selenium
  	  	 * @throws Exception 
  	  	 * @Version 2.1
  		 * @since	DEC 25,2014
  		 */  
	    
	    public boolean navigateToVisitsection(WebDriver driver,PracticeLibrary practiceLibrary) throws Exception	    {	
	      	practiceLibrary.navigateToVisitsection(driver);
	    	return true;
	    	
	    }
	    
	    
	    public boolean verifyDeletereusewidget(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,PracticeLibrary practiceLibrary) throws Exception	    {	
	      	practiceLibrary.verifyDeletereusewidget(driver,encounterTemplateTestData);
	    	return true;
	    	
	    }
	    
	    
	    /**
  		 * Navigate to Order  Template Page
  		 * Function to Navigate to Order  Template Page
  		 * @param 	driver
  		 * @throws IOException
  	  	 * @since	Jan 27,2015
  		 */  
	    
	      public OrderTemplatePage  navigateToOrderTemplate(WebDriver driver) throws Exception	 {	

	    	try {
	  			assertTrue(click(driver,lnkLabTemplates),"Click Order Templates failed", driver, className,methodName);
	  			waitForPageLoad(driver);
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
	    	 return new OrderTemplatePage();
	      }

	      
	      /**
			 * createOrderTemplate
			 * Function to create Order Template
			 * @param 	driver
			 * @param 	orderTemplatePage
			 * @param dIData(Order template details to be added )
	         * @throws Exception 
			 * @throws IOException
		  	 * @since	Jan 27,2015
			 */  
	      
	      public void createOrderTemplate(WebDriver driver,ChartPreVisitLib diData,OrderTemplatePage orderTemplatePage) throws Exception {
	    	 
	    	  orderTemplatePage.createOrderTemplate(driver, diData);
	  	}
	      
	      
		/**
		 * Delete Previous Coustom Sections 
		 * Function to Delete Previous Coustom Sections 
		 * @param 	selenium
		 * @throws IOException 
		 * @Version 2.1
		 * @since	DEC 25,2014
		 */
	  public boolean deleteAllCustomSection(WebDriver driver,PracticeLibrary practiceLibrary) throws IOException
		{	    	
	    	practiceLibrary.deleteAllCustomSection(driver);
			return true;
		}  

		/**
		 * Delete Previous  visit outline
		 * Function to Delete Previous Custom Sections 
		 * @param 	selenium
		 * @throws IOException 
		 * @since	DEC 25,2014
		 */
	  public boolean deleteAllVisitOutline(WebDriver driver,PracticeLibrary practiceLibrary) throws IOException
		{	    	
	    	practiceLibrary.deleteAllVisitOutline(driver);
			return true;
		}  
	  

	  	/**
		 * Create Custom Sections 
		 * Function to Delete Previous Coustom Sections 
		 * @param 	selenium
	  	 * @throws Exception 
	  	 * @Version 2.1
		 * @since	DEC 25,2014
		 */ 
	   
	    public boolean createVisitSectionWithWidget(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,PracticeLibrary practiceLibrary) throws Exception
	    {	
	    	
	    	practiceLibrary.createVisitSectionWithWidget(driver, encounterTemplateTestData);
	    	return true;
	    }
	    
		/**
		 * Verify Created Custom Sections 
		 * Function to Verify Created Custom Sections 
		 * @param 	selenium
	  	 * @throws Exception 
		 * @since	DEC 25,2014
		 */ 
	    public boolean verifyCreatedSection(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,PracticeLibrary practiceLibrary)
	    {	
	    	practiceLibrary.verifyCreatedSection(driver, encounterTemplateTestData);
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
	    
	    public boolean navigateToVisitoutline(WebDriver driver,PracticeLibrary practiceLibrary) throws Exception	    {	
	    	practiceLibrary.navigateToVisitoutline(driver);
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
	    
	    public boolean clickOnEncoEdit(WebDriver driver,PracticeLibrary practiceLibrary) throws Exception	    {	
	    	practiceLibrary.clickOnEncoEdit(driver);
	       	return true;
	    }

	    /**
  		 *select Default Template
  		 * Function to select Default Template
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	DEC 26,2014
  		 */  

	    
	    public boolean selectDefaultTemplate(WebDriver driver,PracticeLibrary practiceLibrary) throws IOException, ExceptionHandler{
	    	practiceLibrary.selectDefaultTemplate(driver);
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
	    public boolean deleteCustomComponenetInEditDefalutPage(WebDriver driver,PracticeLibrary practiceLibrary) throws IOException
	    {
	    	practiceLibrary.deleteCustomComponenetInEditDefalutPage(driver);
	    	return true;
	    }

	    /**
  		 *add VisitSection With VisitOutline
  		 * Function to add VisitSection With VisitOutline
  		 * @param 	selenium
  	  	 * @throws Exception 
  	  	 * @Version 2.1
  		 * @since	DEC 26,2014
  		 */  

	    public boolean addVisitSectionWithVisitOutline(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,PracticeLibrary practiceLibrary) throws Exception {
	    	practiceLibrary.addVisitSectionWithVisitOutline(driver, encounterTemplateTestData);
	      	return true;
	    }
	    /**
  		 * go to edit Visit Section
  		 * Function to go to edit Visit Section
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	DEC 26,2014
  		 */  

	    public boolean goToEditVisitSection(WebDriver driver,PracticeLibrary practiceLibrary) {

	    	practiceLibrary.goToEditVisitSection(driver);
	        	return true;
	    }

	    
	    /**
  		 *Edit Created Visit sections 
  		 * Function to  Edit Created Visit sections 
  		 * @param 	selenium
  	  	 * @throws Exception 
  		 * @since	DEC 25,2014
  		 */ 
    		
    public boolean editVisitSectionWithWidget(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,PracticeLibrary practiceLibrary) throws Exception 
    {    	practiceLibrary.editVisitSectionWithWidget(driver, encounterTemplateTestData);	    	
       	return true;
    }
	  
    
    /**
		 *Verify Edited Visit sections 
		 * Function to Verify Edited Visit sections 
		 * @param 	selenium
	  	 * @throws Exception 
		 * @since	DEC 25,2014
		 */ 

    public boolean verifyEditedVisitSection(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,PracticeLibrary practiceLibrary)
    {	 
       	practiceLibrary.verifyEditedVisitSection(driver, encounterTemplateTestData);
    	  	return true;
    
    }


    /**
		 *Create a second visit section 
		 * Function to Create a second visit section 
		 * @param 	selenium
	  	 * @throws Exception 
		 * @since	DEC 29,2014
		 */ 
	    
    
    public boolean createSecondVisitSection(WebDriver driver,ClinicalSettingLib encounterEditTemplateTestData,PracticeLibrary practiceLibrary) throws Exception
    {	 waitForPageLoad(driver);
    	practiceLibrary.createSecondVisitSection(driver, encounterEditTemplateTestData);
       	return true;
    	    
    }
    /**
	 *Create a second visit section 
	 * Function to Create a second visit section 
	 * @param 	selenium
  	 * @throws Exception 
	 * @since	DEC 29,2014
	 */ 
    

public boolean editpreviousvisitsection(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,PracticeLibrary practiceLibrary)  
{	 
	practiceLibrary.editpreviousvisitsection(driver, encounterTemplateTestData);
 	return true;
   		    
}
    /**
	 *Add second visit section with Visit outline
	 * Function to Add second visit section with Visit outline
	 * @param 	selenium
  	 * @throws Exception 
	 * @since	DEC 29,2014
	 */ 
    

	public boolean addSecondVisitOutline(WebDriver driver,
			ClinicalSettingLib mcTemplate, PracticeLibrary practiceLibrary)
			throws Exception {
		practiceLibrary.addVisitSecondSectionWithVisitOutline(driver,
				mcTemplate);
		waitForPageLoad(driver);
		return true;

	}

	public ManagedCareTemplatePage navigateToManagedCareTemplate(
			PracticeLibraryPage practiceLibraryPage, WebDriver driver)
			throws Exception {
		practiceLibraryPage.navigateToMangaedCareTemplate(driver);
		return new ManagedCareTemplatePage();
	}

	public boolean deleteAllManagedCareTemplate(
			ManagedCareTemplatePage managedCareTemplatePage, WebDriver driver)
			throws Exception {
		managedCareTemplatePage.deleteAllManagedCareTemplate(driver);
		return true;
	}

	public boolean startNewManagedCareTemplate(
			ManagedCareTemplatePage managedCareTemplatePage, WebDriver driver,
			ClinicalSettingLib mcTemplate, String uniqueName) {
		try{
		managedCareTemplatePage.startNewManagedCareTemplate(driver, mcTemplate,
				uniqueName);
	}catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
    }
		return true;
	}
	
	public boolean startNewVisitOutline(
			PracticeLibrary practiceLibrary, WebDriver driver,
			ClinicalSettingLib encounterTemplateTestData, String uniqueName)throws Exception {
		practiceLibrary.startNewVisitOutline(driver, encounterTemplateTestData,
				uniqueName);
		return true;
	}
	
	public boolean EditAlreadyCreatedManagedCareTemplate(
			ManagedCareTemplatePage managedCareTemplatePage, WebDriver driver,
			ClinicalSettingLib mcTemplate) {
		managedCareTemplatePage.editManagedCareTemplatePage(driver);
		return true;
	}

	public boolean addCustomWidgetCareElement(
			ManagedCareTemplatePage managedCareTemplatePage, WebDriver driver,
			ClinicalSettingLib mcTemplate, String uniqueName,String numberOfTime) throws Exception {
		managedCareTemplatePage.addCustomWidgetCareElement(driver, mcTemplate,
				uniqueName,numberOfTime);
		return true;
	}
	
	public boolean SaveEntireManagedCareTemplate(
			ManagedCareTemplatePage managedCareTemplatePage, WebDriver driver,ClinicalSettingLib mcTemplate) throws Exception {
		managedCareTemplatePage.SaveManagedCareCustomWidgetCareElement(driver,mcTemplate);
		return true;
	}
	
	 /**
		 *click on plan and recommendation check box 
		 * Function to click on Edit Button
		 * @param 	selenium
	  	 * @throws Exception 
		 * @since	DEC 26,2014
		 */ 
    public boolean uncheckPlan(WebDriver driver,PracticeLibrary practiceLibrary){
		
    	practiceLibrary.uncheckPlanAndRecom(driver);
     	waitForPageLoad(driver);
    	return true;
    	
    }

    /**
		 *add SecondVisitSection With VisitOutline
		 * Function to add VisitSection With VisitOutline
		 * @param 	selenium
	  	 * @throws Exception 
		 * @since	JAN 06,2014
		 */  

    public boolean addSecondVisitSectionWithVisitOutline(WebDriver driver,ClinicalSettingLib encounterEditTemplateTestData,PracticeLibrary practiceLibrary) throws Exception {
    	practiceLibrary.addSecondVisitSectionWithVisitOutline(driver, encounterEditTemplateTestData);
    //	waitForPageLoad(driver);
    	return true;
    }
    
	public boolean verifyTemplate(
			ManagedCareTemplatePage managedCareTemplatePage, WebDriver driver,
			ClinicalSettingLib mcTemplate, String uniqueName) throws Exception {
		managedCareTemplatePage.verifyMangaedCareTemplate(driver, mcTemplate,
				uniqueName);
		return true;
	}

	public boolean verifyReuseWidegt(WebDriver driver,ClinicalSettingLib encounterEditTemplateTestData,ClinicalSettingLib encounterTemplateTestData,PracticeLibrary practiceLibrary){
		practiceLibrary.verifyReuseWidegt(driver, encounterEditTemplateTestData, encounterTemplateTestData);
		waitForPageLoad(driver);		
		return true;
		
	}
	public boolean createVisitSectionWithSingleTextWidget(PracticeLibrary practiceLibrary,WebDriver driver,ClinicalSettingLib encounterTemplateTestData,String uniqueName)throws Exception
	{
		practiceLibrary.createVisitSectionWithSingleTextWidget(driver,encounterTemplateTestData,uniqueName);
		return true;
	}
	public ManagedCareTemplatePage navigateToManagedCareTemplate(WebDriver driver,
			PracticeLibrary practiceLibrary)
			throws Exception {
		practiceLibrary.navigateToMangaedCareTemplate(driver);
		return new ManagedCareTemplatePage();
	}
	public boolean deleteAllManagedCareTemplate( WebDriver driver,
			ManagedCareTemplatePage managedCareTemplatePage)
			throws Exception {
		try{
		managedCareTemplatePage.deleteAllManagedCareTemplate(driver);
	}catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
    }
		return true;
	}
	public boolean editVisitSectionWithQuestionWidget(PracticeLibrary practiceLibrary,WebDriver driver,ClinicalSettingLib encounterTemplateTestData)throws Exception
	{
		practiceLibrary.editVisitSectionWithQuestionWidget(driver,encounterTemplateTestData);
		return true;
	}
	
	
	  public boolean deleteVisitSections (WebDriver driver,ClinicalSettingLib encounterTemplateTestData ,PracticeLibrary practiceLibrary)
	    {
		  practiceLibrary.deleteVisitSections(driver, encounterTemplateTestData);
		  return true;
	    }
	  
	  /**
	   *NavigateToFlowSheets
	   * Function to Navigate To Flow Sheets 
	   * @param 	driver
	   * @param 	encounterTemplateTestData
	   * @param 	ManagedCareTemplatePage
	   * @since	Mar 18,2015
	   */ 

	  public boolean addVitalsCareElement(WebDriver driver,ManagedCareTemplatePage managedCareTemplatePage,ClinicalSettingLib encounterTemplateTestData)  
	  {	 
	  try{
	  	managedCareTemplatePage.addVitalsCareElement(driver, encounterTemplateTestData);
	  }catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	   }
	  	return true;
	  		    
	  }
	  /**
	   *NavigateToFlowSheets
	   * Function to Navigate To Flow Sheets 
	   * @param 	driver
	   * @param 	ManagedCareTemplatePage
	   * @since	Mar 18,2015
	   */ 

	  public boolean navigateToFlowSheets(WebDriver driver,ManagedCareTemplatePage managedCareTemplatePage)  
	  {	
	  try{
	  	managedCareTemplatePage.navigateToFlowSheets(driver);
	  }catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
	  	return true;
	  		    
	  }

		/**
		 * addImmunizationCareElement 
		 * Function to add Immunization Care Element
		 * @param 	driver, mcTemplate, uniqueName, account
		 * @throws IOException 
		 * @since	Mar 24,2015
		 */
		public boolean addImmunizationCareElement(WebDriver driver,ClinicalSettingLib mcTemplate,String uniqueName,String account,ManagedCareTemplatePage managedCareTemplatePage) throws IOException{
        try{
			managedCareTemplatePage.addImmunizationCareElement(driver, mcTemplate, uniqueName, account);
		}catch (Exception e) {
				  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			    }
			return true;
		}

		/**
		 * saveCareElement 
		 * Function to Save Care Element
		 * @param 	driver
		 * @param 	managedCareTemplatePage
		 * @throws IOException 
		 * @since	Mar 24,2015
		 */
		public boolean saveCareElement(WebDriver driver,ManagedCareTemplatePage managedCareTemplatePage) {
        try{
			managedCareTemplatePage.saveCareElement(driver);
		}catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
			return true;
		}
		
		/**
		 * addMedicationCareElement 
		 * Function to add Medication Care Element
		 * @param 	driver, mcTemplate, account
		 * @throws IOException 
		 * @since	Mar 24,2015
		 */
		public boolean addMedicationCareElement(WebDriver driver,ClinicalSettingLib mcTemplate,ManagedCareTemplatePage managedCareTemplatePage) {
        try{
			managedCareTemplatePage.addMedicationCareElement(driver, mcTemplate);
		}catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
			return true;
		}
		
		/**
		 * saveTemplate 
		 * Function to Save Template
		 * @param 	driver
		 * @throws IOException 
		 * @since	Mar 24,2015
		 */
		public boolean saveTemplate(WebDriver driver,ManagedCareTemplatePage managedCareTemplatePage) {

			managedCareTemplatePage.saveTemplate(driver);
			return true;
		}
		
		public boolean editManagedCareTemplatePage(WebDriver driver,ManagedCareTemplatePage managedCareTemplatePage)
		{
			managedCareTemplatePage.editManagedCareTemplatePage(driver);
			return true;
		}
}
