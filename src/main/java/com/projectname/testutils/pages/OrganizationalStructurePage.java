package com.projectname.testutils.pages;

import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.SystemSettingsLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class OrganizationalStructurePage extends SeleniumWebDriver{

	public   OrganizationalStructurePage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);
		SeleniumWebDriver.isElementPresent(readyLocator);
		}
	
	    private static By readyLocator=By.id("searchTextBoxPracticeView");
	    private By txtProviderSearchbox = By.id("searchTextBoxProviderView");
		private By btnProviderSearch=By.id("searchButtonProviderView");
		private By btnProviderDelete = By.xpath("//a[contains(@id,'DeleteProvider')]");
		private By btnYes = By.id("yesButton");
		private By txtPracticeSearchBox  = By.id("searchTextBoxPracticeView");
		private By btnPracticeSearch=By.id("searchButtonPracticeView");
		private By lblFirstPractice = By.xpath("//div[contains(@id,'practiceListItem')]");
		private By lnkOrgStructure = By.id("!adminOrgStructureLists");
		private By btnAddProvider = By.id("addProvider");
		
		/**
		 * deleteProvider
		 * function to delete provider 
		 * @param 		selenium
		 * @param 		providerData
		 * @since  	    April 24, 2015
		 */	
		public boolean deleteProvider(WebDriver driver,SystemSettingsLib providerData){
			try{
				if(isVisible(driver, txtProviderSearchbox)){
				waitForPageLoad(driver);
				verifyTrue(type(driver, txtProviderSearchbox,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(),driver);
				waitForPageLoad(driver);
				verifyTrue(click(driver,btnProviderSearch),"Could not click the search button"+providerData.toString(),driver);
				waitForPageLoad(driver);
				int Counter=(Integer) getXpathCount(driver,btnProviderDelete);
				while(isElementPresent(driver,btnProviderDelete)){
					waitForPageLoad(driver);
					verifyTrue(click(driver,btnProviderDelete),"Could not click the delete button"+providerData.toString(),driver);
					waitForPageLoad(driver);
					click(driver,btnYes);
					waitForPageLoad(driver);
					int counterAfterDeletion=(Integer) getXpathCount(driver, btnProviderDelete);
					if((Counter==counterAfterDeletion)&&(counterAfterDeletion!=0)){
						Assert.fail("Could not delete the provider;More Details:"+providerData.toString());
						return false;
					}
					waitForPageLoad(driver);
					Counter--;
				}
				}
			}catch(RuntimeException e){
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}


		/**
		 * associateProviderToPractice
		 * function to associate Provider To Practice 
		 * @param 		selenium
		 * @param 		providerData
		 * @since  	    April 24, 2015
		 */	
		public CreateNewPracticePage goToAssociateProviderToPractice(WebDriver driver,SystemSettingsLib providerData){
			try{

				verifyTrue(type(driver, txtPracticeSearchBox,providerData.practiceName),"Could not type the practice name; More Details"+providerData.toString(),driver);
				waitForPageLoad(driver);
				verifyTrue(click(driver,btnPracticeSearch),"Could not click the search button"+providerData.toString(),driver);
				waitForPageLoad(driver);
				verifyTrue(click(driver,lblFirstPractice),"Could not click the first result"+providerData.toString(),driver);
				waitForPageLoad(driver);

			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return new CreateNewPracticePage();
		}

		/**
		 * clickAddNewProvider
		 * function to click Add New Provider button
		 * @param 		selenium
		 * @since  	    April 27, 2015
		 */	
		public CreateNewProviderPage clickAddNewProvider(WebDriver driver){
			try{

				verifyTrue(click(driver,btnAddProvider),"Could not click the Add",driver);
				waitForPageLoad(driver);

			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return new CreateNewProviderPage();
		}

		/**
		 * associateProviderToPractice
		 * function to associate Provider To Practice 
		 * @param 		selenium
		 * @param 		providerData
		 * @since  	    April 24, 2015
		 */	
		public boolean associateProviderToPractice(WebDriver driver,SystemSettingsLib providerData, CreateNewPracticePage createNewPracticePage){
			try{
				createNewPracticePage.associateProviderToPractice(driver, providerData);
				waitForPageLoad(driver);

			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
		/**
		 * createNewProvider function to Create New Provider
		 * @param driver
		 * @param SystemSettingsLib - providerData
		 * @param CreateNewProviderPage
		 * @since April 27, 2015
		 * @version 2.1
		 */
		
		public boolean createNewProvider(WebDriver driver, SystemSettingsLib providerData, CreateNewProviderPage createNewProviderPage) throws IOException {
		try{
			createNewProviderPage.createNewProvider(driver, providerData);
			waitForPageLoad(driver);
		} catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
		return true;
	}
		
		/**
		 * saveNewProvider function to Save Created New Provider
		 * @param driver
		 * @param SystemSettingsLib - providerData
		 * @since May 13, 2015
		 * @version 2.1
		 */
		
		public boolean saveNewProvider(WebDriver driver, CreateNewProviderPage createNewProviderPage) throws IOException {

			try{
				createNewProviderPage.saveNewProvider(driver);
				waitForPageLoad(driver);
			}
			catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}	

		/**
		 * addNewReferringProviderWithPracticeNameOnly
		 * function to Edit already created practice  
		 * @param 		selenium
		 * @param 		providerData
		 * @param		referringProviderPage
		 * @since  	    May 12, 2015
		 */	
		public boolean readValuesFromThePractice(WebDriver driver,CreateNewPracticePage createNewPractice,ChartPreVisitLib letterTemplateTestData){
			try{
				
				createNewPractice.readValuesFromThePractice(driver,letterTemplateTestData);
			}catch(Exception e)
			{
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
			}
			return true;
			}
		
		
		/**
		 * addNewReferringProviderWithPracticeNameOnly
		 * function to Edit already created practice  
		 * @param 		selenium
		 * @param 		providerData
		 * @param		referringProviderPage
		 * @since  	    May 12, 2015
		 */	
		public boolean editAlreadyOpenPractice(WebDriver driver,CreateNewPracticePage createNewPractice){
			try{
				
				createNewPractice.editAlreadyOpenPractice(driver);
			}catch(Exception e)
			{
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
			}
			return true;
			}
		
		

}
