package com.projectname.testutils.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;
import com.thoughtworks.selenium.Selenium;

public class LabOrderPage extends SeleniumWebDriver{

	public  LabOrderPage() {
		PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	private static By readyLocator = By.id("requisitionTypeSuggestBoxsuggestBox");
	
	private static By ajxProviderListSuggestBox = By.id("providerListSuggestBoxsuggestBox");
	private static By ajxLocationListSuggestBox = By.id("locationListSuggestBoxsuggestBox");
	private static By ajxRequisitionTypeSuggestBox = By.id("requisitionTypeSuggestBoxsuggestBox");
	private static By ajxTemplateListSuggestBox = By.id("templateListSuggestBoxsuggestBox");
	private By ajxlabtestname=By.id("labTestNameSuggestBox");
	private static By chkBoxTestNameOne = By.id("A1 Ab SerPl Ql_CB");
	private static By chkBoxTestNameTwo = By.id("B19V Ab Ser-aCnc_CB");
	private static By chkBoxTestNameThree = By.id("C0/C16 Bld.Dot-sRto_CB");
	private static By chkBoxTestNameFour = By.id("D5Pregnanetriol 24H Ur-mRate_CB");
	
	private static By btnPrintNewLabs = By.id("printNewLabs");
	private static By btnPrintPreviewClose = By.id("framePopupViewCloseButton");
	
	private static By patientEncounterPage = By.id("contactModesuggestBox");
	
	
	private static By vfyTestName = By.id("resultName3");
	private static By vfyTestName1 = By.id("resultName4");
	private static By vfyTestName2 = By.id("resultName5");
	private static By vfyTestName3 = By.id("resultName6");
	private By ajxcopyto=By.id("copyToSuggestBoxsuggestBox");
	private By ajxpayer=By.id("payerSearchSuggestBoxsuggestBox");
	private By ajxsendto=By.id("labFacilitySuggestBoxsuggestBox");
	private By ajxNotify=By.id("durationsuggestBox");
	private By btnAction=By.id("actionAnchor");
	private By btnSaveLaborder=By.xpath("//a[@id='save']/span");
	// private static By vfyTestNameFrame = By.xpath("//div[2]/div/div[5]/div[2]/div/div/div[2]");
	private By lnkTopMenu=By.id("username");
	private By lblpracticename=By.id("locationMenuHeader");
	private By ajxProvider =By.id("providerListSuggestBoxsuggestBox");	
	private By ajxLoaction=By.id("locationListSuggestBoxsuggestBox");
	private By ajxTestName =By.id( "labTestNameSuggestBox");
	private By btnDiagnosticSave=By.id("saveDiagnosticImaging");
	private By btnOk=By.id("okButton");
	
	/**
     * Create New Order Lab Test
     * Function to Create New Order Lab Test
     * @param 	driver
     * @param   diData - Test Data
     * @throws Exception  
     * @since	Jan 28,2015
     */  

    public void createNewOrderLabTest(WebDriver driver,ChartPreVisitLib diData)   {
    try{
   	verifyTrue(selectValueFromAjaxList(driver,ajxProviderListSuggestBox,diData.onBehalf),"Could not select on behalf of provider",driver);
  	waitForPageLoad(driver);
  	verifyTrue(selectValueFromAjaxList(driver,ajxLocationListSuggestBox,diData.practice),"Could not select Practice region",driver);
  	waitForPageLoad(driver);
  	verifyTrue(selectValueFromAjaxList(driver,ajxRequisitionTypeSuggestBox,diData.printOn),"Could not select PrintOn option",driver);
  	waitForPageLoad(driver); 
  	verifyTrue(selectValueFromAjaxList(driver,ajxTemplateListSuggestBox,diData.templateName),"Could not select Template option",driver);
  	waitForPageLoad(driver); 
  	
  	if(!isChecked(driver,chkBoxTestNameOne)){
  		verifyTrue(click(driver,chkBoxTestNameOne),"Could not Check Test name one", driver);
		waitForPageLoad(driver);
	}
  	
  	if(!isChecked(driver,chkBoxTestNameTwo)){
  		verifyTrue(click(driver,chkBoxTestNameTwo),"Could not Check Test name two", driver);
		waitForPageLoad(driver);
	}
  	
  	verifyTrue(click(driver,btnPrintNewLabs),"Could not click Print button", driver);
	waitForPageLoad(driver);
  	
	verifyTrue(isElementPresent(driver,btnPrintPreviewClose),"Print lab report Failed", driver);
	waitForPageLoad(driver);
  	
	verifyTrue(click(driver,btnPrintPreviewClose),"Could not click Print preview close button", driver);
	waitForPageLoad(driver);

	verifyTrue(isElementPresent(driver,patientEncounterPage)," Create New Order Lab Test Failed", driver);
	waitForPageLoad(driver);
	
    }catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
    }

	/**
     * Create New Order Lab Test
     * Function to Create New Order Lab Test
     * @param 	driver
     * @throws Exception  
     * @since	Jan 28,2015
     */  

    public void createNewOrderLabTestwithoutprint(WebDriver driver,ChartPreVisitLib diData)   {
    try{
  /* 	selectValueFromAjaxList(driver,ajxProviderListSuggestBox,diData.onBehalf);
  	waitForPageLoad(driver);*/
  	selectValueFromAjaxList(driver,ajxLocationListSuggestBox,diData.practice);
  	
	selectValueFromAjaxList(driver,ajxRequisitionTypeSuggestBox,diData.printOn);

	selectValueFromAjaxList(driver,ajxlabtestname,diData.testName);
	waitForPageLoad(driver); 
  	selectValueFromAjaxList(driver,ajxcopyto,diData.copyTo);
	waitForPageLoad(driver); 
  	selectValueFromAjaxList(driver,ajxsendto,diData.sendTo);
 	selectValueFromAjaxList(driver,ajxNotify,diData.notifyme);
 	waitForPageLoad(driver); 
	click(driver,btnAction);
	click(driver,btnSaveLaborder);
	waitForPageLoad(driver);
	assertTrue(isElementPresent(driver,patientEncounterPage)," Create New Order Lab Test Failed", driver, className,methodName);
    }
    catch(Exception e)
    {
    	
    }
	
    }
    
    /**
     * Verify New Order Lab Test
     * Function to Verify Order Lab Test 
     * @param 	driver
     * @param 	diData
     * @throws  Exception 
     * @since	Jan 29,2015
     */  

   public void verifyNewOrderLabTest(WebDriver driver,ChartPreVisitLib diData) throws Exception {
   try{
	 assertTrue(isChecked(driver,chkBoxTestNameOne)," Test name one check box is not checked", driver, className,methodName);
	 waitForPageLoad(driver);
	 
	 System.out.println("TestName - " + diData.testName);
	 System.out.println("GEtTExt Value -" +getText(driver,vfyTestName));
	 
	 assertTrue(getText(driver,vfyTestName).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.testName.trim().toLowerCase(new java.util.Locale("en","US"))),"Test Name one is not present in selected tests", driver, className,methodName);
	 waitForPageLoad(driver);
	 assertTrue(isChecked(driver,chkBoxTestNameTwo)," Test name two check box is not checked", driver, className,methodName);
	 waitForPageLoad(driver);
	 assertTrue(getText(driver,vfyTestName1).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.testName1.trim().toLowerCase(new java.util.Locale("en","US"))),"Test Name two is not present in selected tests", driver, className,methodName);
	 waitForPageLoad(driver);
     waitForPageLoad(driver);
  
     if(diData.equals("TC_NLO_002")){
    	 
    	 assertTrue(isChecked(driver,chkBoxTestNameThree)," Test name three check box is not checked", driver, className,methodName);
    	 waitForPageLoad(driver);
    	 assertTrue(getText(driver,vfyTestName2).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.testName2.trim().toLowerCase(new java.util.Locale("en","US"))),"Test Name three is not present in selected tests", driver, className,methodName);
    	 waitForPageLoad(driver);    	 
    	 assertTrue(isChecked(driver,chkBoxTestNameFour)," Test name four check box is not checked", driver, className,methodName);
    	 waitForPageLoad(driver);
    	 assertTrue(getText(driver,vfyTestName3).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.testName3.trim().toLowerCase(new java.util.Locale("en","US"))),"Test Name four is not present in selected tests", driver, className,methodName);
    	 waitForPageLoad(driver);
     }
   }catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
    }
   
   /**
    * Verify Unchecked Order Lab Test
    * Function to Verify Order Lab Test 
    * @param 	driver
    * @param   diData - Test Data
    * @throws  Exception 
    * @since	Jan 29,2015
    */  

  public void verifyCheckedOrderLabTest(WebDriver driver,ChartPreVisitLib diData)   {
   	
	  // Verify Checked Test names are under selected Test list
try{	  
	 verifyTrue(isChecked(driver,chkBoxTestNameOne)," Test name one check box is not checked", driver);
	 waitForPageLoad(driver);
	 assertTrue(getText(driver,vfyTestName).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.testName.trim().toLowerCase(new java.util.Locale("en","US"))),"Test Name one is not present in selected tests", driver, className,methodName);
	 waitForPageLoad(driver);
	 verifyTrue(isChecked(driver,chkBoxTestNameTwo)," Test name two check box is not checked", driver);
	 waitForPageLoad(driver);
	 assertTrue(getText(driver,vfyTestName1).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.testName1.trim().toLowerCase(new java.util.Locale("en","US"))),"Test Name two is not present in selected tests", driver, className,methodName);
	 waitForPageLoad(driver);
     waitForPageLoad(driver);
     
     // Verify Unchecked Test names are not  under selected Test list
     
     if(isChecked(driver,chkBoxTestNameThree)){
    	 verifyTrue(click(driver,chkBoxTestNameThree),"Could not UnCheck Test name three", driver);
			waitForPageLoad(driver);
		}	  	
	  if(isChecked(driver,chkBoxTestNameFour)){
		  verifyTrue(click(driver,chkBoxTestNameFour),"Could not UnCheck Test name Four", driver);
			waitForPageLoad(driver);
	  }
	  assertTrue(!isElementPresent(driver,vfyTestName2),"Unchecked Test Name three is present in selected tests", driver, className,methodName);
	  waitForPageLoad(driver);
	  assertTrue(!isElementPresent(driver,vfyTestName3),"Unchecked Test Name four is present in selected tests", driver, className,methodName);
	  waitForPageLoad(driver);
}
catch(Exception e)
{
	assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

}
   }
  
  
   /**
    * Verify Unchecked Order Lab Test
    * Function to Verify Order Lab Test 
    * @param   diData - Test Data
    * @param 	driver
    * @throws  Exception 
    * @since	Jan 29,2015
    */  

   public void verifyUncheckedOrderLabTest(WebDriver driver,ChartPreVisitLib diData) throws Exception {
  
	   // Check the Third and Fourth Test Names
	   
	   if(!isChecked(driver,chkBoxTestNameThree)){
			assertTrue(click(driver,chkBoxTestNameThree),"Could not Check Test name three", driver, className,methodName);
			waitForPageLoad(driver);
		}
	  	
	  	if(!isChecked(driver,chkBoxTestNameFour)){
			assertTrue(click(driver,chkBoxTestNameFour),"Could not Check Test name Four", driver, className,methodName);
			waitForPageLoad(driver);
		}
	  	
	  	// Uncheck the First Test Name
	  	
	  	if(isChecked(driver,chkBoxTestNameOne)){
			assertTrue(click(driver,chkBoxTestNameOne),"Could not Uncheck Test name one", driver, className,methodName);
			waitForPageLoad(driver);
		}
	  	
       // Verify only first test name is unchecked 
	  	
		 assertTrue(isChecked(driver,chkBoxTestNameTwo)," Test name Two check box is UnChecked while unchecked the first test name", driver, className,methodName);
		 waitForPageLoad(driver);
	  	
		 assertTrue(isChecked(driver,chkBoxTestNameThree),"Test name three check box is UnChecked while unchecked the first test name", driver, className,methodName);
		 waitForPageLoad(driver);
		 
		 assertTrue(isChecked(driver,chkBoxTestNameFour)," Test name four check box is UnChecked while unchecked the first test name", driver, className,methodName);
		 waitForPageLoad(driver);
   }
   
   
   
   /**
    * Verify Edit Lab Order Test
    * Function to Verify Edit Lab Order Test
    * @param 	driver
    * @param 	diData
    * @throws  Exception 
    * @since	Jan 30,2015
    */  


   public void editLabOrderTest(WebDriver driver,ChartPreVisitLib diData) throws Exception {
   	
	   if(!isChecked(driver,chkBoxTestNameThree)){
			assertTrue(click(driver,chkBoxTestNameThree),"Could not Check Test name three", driver, className,methodName);
			waitForPageLoad(driver);
		}
	  	
	   if(!isChecked(driver,chkBoxTestNameFour)){
			assertTrue(click(driver,chkBoxTestNameFour),"Could not Check Test name four", driver, className,methodName);
			waitForPageLoad(driver);
		}
	  	waitForPageLoad(driver);
	  	assertTrue(click(driver,btnPrintNewLabs),"Could not click Print button", driver, className,methodName);
		waitForPageLoad(driver);
	  	
		assertTrue(isElementPresent(driver,btnPrintPreviewClose),"Print lab report Failed", driver, className,methodName);
		waitForPageLoad(driver);
	  	
		assertTrue(click(driver,btnPrintPreviewClose),"Could not click Print preview close button", driver, className,methodName);
		waitForPageLoad(driver);

		assertTrue(isElementPresent(driver,patientEncounterPage)," Edit Order Lab Test Failed", driver, className,methodName);
		waitForPageLoad(driver);

   }
   

	/**
	 * orderNewDi Function to order New Di
	 * @throws IOException 
	 * 
	 * @since Nov 15, 2012
	 */
	public boolean orderNewDi(WebDriver driver, ChartPreVisitLib orderData) throws IOException {
		try {

			/*
			 * assertTrue(click(selenium,"labTestNameSuggestBox" ),
			 * "Could not click on test name suggest box");
			 * assertTrue(type(selenium,ajxTestName,
			 * orderData.labTestName),
			 * "Could not click on test name suggest box");
			 * waitForPageLoad(selenium);
			 */
			String provider= getText(driver, lnkTopMenu);
			String onBehalfOf= provider.replaceAll(", "+orderData.switchRole, "");
			String onBehalfOf1[]=onBehalfOf.split(" ");
			String practicename= getText(driver, lblpracticename);
			String Temppracticename[]=practicename.split(" ");
			practicename=Temppracticename[0]+" "+Temppracticename[1];
			assertTrue(selectValueFromAjaxList(driver,ajxProvider,onBehalfOf1[1]),"could not entre the on Behalf of details", driver, className,methodName);
			assertTrue(selectValueFromAjaxList(driver,ajxLoaction,practicename),"could not entre the on Behalf of details", driver, className,methodName);
			selectValueFromAjaxList(driver, ajxTestName,orderData.labTestName);
				if (isElementPresent(driver, btnOk)) {
					assertTrue(click(driver, btnOk),
							"Could not click the ok Button", driver, className,methodName);
				}
				assertTrue(click(driver, btnDiagnosticSave),
						"Could not click on save button", driver, className,methodName);
						} catch (RuntimeException e) {
			Assert.fail("Failed due to the Exception; \n Exception details: "
					+ e.getMessage());
			return false;
		} catch (ExceptionHandler e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
   
}
