package com.projectname.testutils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.SystemSettingsLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class CreateNewPracticePage extends SeleniumWebDriver{

	public   CreateNewPracticePage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);
		SeleniumWebDriver.isElementPresent(readyLocator);
		}
	
	    private static By readyLocator=By.id("edit");
		private By btnEdit = By.id("edit");
		private By btnAdd = By.id("add");
		private By txtPracticeProviderSearchBox = By.id("practiceProvidersearchTextBox");
		private By btnPracticeProviderSearch = By.id("practiceProvidersearchButton");
		private By chkPracticeProvider = By.xpath("//input[contains(@id,'checkbox')]");
		private By btnSave = By.id("save");
		private By lnkOrgStructure = By.id("!adminOrgStructureLists");
        private By txtPrimaryPhone=By.id("primaryPhone");
        private By txtPrimaryPhoneExtn=By.id("primaryPhoneExtension");
		private By txtBussinessFaxPhone=By.id("ohterPhone1");
        private By txtBussinessFaxPhoneExtn=By.id("otherPhone1Extension");
        private By addressLine1=By.id("addr1");
        private By addressLine2=By.id("addr2");
        private By practiceCity=By.id("city");
        private By practiceState=By.id("stateSuggestBoxsuggestBox");
        private By practiceZipCode=By.id("zip");
        
        
        
		/**
		 * associateProviderToPractice
		 * function to associate Provider To Practice 
		 * @param 		selenium
		 * @param 		providerData
		 * @since  	    April 24, 2015
		 */	
		public boolean associateProviderToPractice(WebDriver driver,SystemSettingsLib providerData){
			try{
				verifyTrue(click(driver,btnAdd),"Could not click the add button"+providerData.toString(),driver);
				waitForPageLoad(driver);
				verifyTrue(type(driver, txtPracticeProviderSearchBox,providerData.firstName),"Could not type the practice name; More Details"+providerData.toString(),driver);
				waitForPageLoad(driver);
				verifyTrue(click(driver,btnPracticeProviderSearch),"Could not click the search button"+providerData.toString(),driver);
				waitForPageLoad(driver);
				verifyTrue(click(driver,chkPracticeProvider),"Could not click the check box"+providerData.toString(),driver);
				waitForPageLoad(driver);
				verifyTrue(click(driver,btnSave),"Could not click the save"+providerData.toString(),driver);
				waitForPageLoad(driver);
				verifyTrue(click(driver,lnkOrgStructure),"Could not click the Org link"+providerData.toString(),driver);
				waitForPageLoad(driver);
			
			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
		/**
		 * editAlreadyOpenPractice
		 * function to Edit AlreadyOpened practice
		 * @param 		selenium
		 * @param 		providerData
		 * @since  	    April 24, 2015
		 */	
		public boolean editAlreadyOpenPractice(WebDriver driver){
			try{
				waitForPageLoad(driver);
				assertTrue(click(driver,btnEdit),"Could not click the Edit button",driver,className,methodName);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
			}
		
		/**
		 * editAlreadyOpenPractice
		 * function to Edit AlreadyOpened practice
		 * @param 		selenium
		 * @param 		providerData
		 * @since  	    April 24, 2015
		 */	
		public boolean readValuesFromThePractice(WebDriver driver,ChartPreVisitLib letterTemplateTestData){
			try{
				letterTemplateTestData.primaryPhone =getValue(driver,txtPrimaryPhone);
				letterTemplateTestData.primaryPhoneExtn =getValue(driver,txtPrimaryPhoneExtn);
				letterTemplateTestData.BussinessPhone =getValue(driver,txtBussinessFaxPhone);
				letterTemplateTestData.BussinessPhoneExtn =getValue(driver,txtBussinessFaxPhoneExtn);
				letterTemplateTestData.addressLine1 =getValue(driver,addressLine1);
				letterTemplateTestData.addressLine2 =getValue(driver,addressLine2);
				letterTemplateTestData.city =getValue(driver,practiceCity);
				letterTemplateTestData.state =getValue(driver,practiceState);
				letterTemplateTestData.zipCode =getValue(driver,practiceZipCode);
				
			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
			}
		
		
		
}
