package com.projectname.testutils.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.SystemSettingsLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class SystemSettingsPage extends SeleniumWebDriver{

	private CreateNewProviderPage createNewProviderPage;
	private CreateNewPracticePage createNewPracticePage;
	
	public   SystemSettingsPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);
		SeleniumWebDriver.isElementPresent(readyLocator);
		}
	
	    private static By readyLocator=By.id("!adminOrgStructureLists");
		private By lnkOrgStructure = By.id("!adminOrgStructureLists");
		private By lnkReferringProvider = By.id("!adminExternalProviderList");
		
		/**
		 * goToFirstUnfinishedItem
		 * function for    goin to First UnfinishedItem
		 * @param 		driver 
		 * @since  	    Apr 27, 2015
		 */

		public OrganizationalStructurePage goToOrganizationalStructure (WebDriver driver)
		{
			verifyTrue(click(driver, lnkOrgStructure),"could not click Settings link", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);

			return new OrganizationalStructurePage();
		}

		/**
		 * goToReferringProviderPage
		 * function for goTo Referring Provider Page
		 * @param 		driver 
		 * @since  	    May 04, 2015
		 */

		public ReferringProviderPage goToReferringProviderPage (WebDriver driver)
		{
			verifyTrue(click(driver, lnkReferringProvider),"could not click Settings link", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);

			return new ReferringProviderPage();
		}

		
		/**
		 * deleteProvider
		 * function to delete provider 
		 * @param 		selenium
		 * @param 		providerData
		 * @param		organizationalStructurePage
		 * @since  	    April 27, 2015
		 */	
		public boolean deleteProvider(WebDriver driver,SystemSettingsLib providerData, OrganizationalStructurePage organizationalStructurePage){
			organizationalStructurePage.deleteProvider(driver, providerData);
			waitForPageLoad(driver);
			return true;
		}
		
		/**
		 * deleteExternalProvider
		 * function to delete provider 
		 * @param 		selenium
		 * @param 		providerData
		 * @since  	    May 04, 2015
		 * verison 2.1
		 */	
		public boolean deleteExternalProvider(WebDriver driver,String providerData, ReferringProviderPage referringProviderPage){
			try{
				return referringProviderPage.deleteExternalProvider(driver, providerData);
			}
			catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
		/**
		 * searchReferralProvider
		 * function to search Tabbing ReferralProvider
		 * @param 	String providerData- Provider to be searched
		 * @param ReferringProviderPage
		 * @since  	    May 04, 2015
		 * version 2.1
		 */
		public boolean searchReferralProvider(WebDriver driver,String providerData, ReferringProviderPage referringProviderPage){
			return referringProviderPage.searchReferralProvider(driver, providerData);
		}

		/**
		 * createNewProvider function to Create New Provider
		 * @param driver
		 * @param SystemSettingsLib - providerData
		 * @param CreateNewProviderPage
		 * @param organizationalStructurePage
		 * @since April 27, 2015
		 * @version 2.1
		 */
		
		public boolean createNewProvider(WebDriver driver, SystemSettingsLib providerData, CreateNewProviderPage createNewProviderPage, OrganizationalStructurePage organizationalStructurePage) throws IOException {
		try{
			organizationalStructurePage.createNewProvider(driver, providerData, createNewProviderPage);
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
		
		public boolean saveNewProvider(WebDriver driver, CreateNewProviderPage createNewProviderPage, OrganizationalStructurePage organizationalStructurePage) throws IOException {

			try{
				organizationalStructurePage.saveNewProvider(driver, createNewProviderPage);
				waitForPageLoad(driver);
			}
			catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}	

		/**
		 * clickAddNewProvider
		 * function to click Add New Provider button
		 * @param 		selenium
		 * @param 		organizationalStructurePage
		 * @since  	    April 27, 2015
		 */	
		public CreateNewProviderPage clickAddNewProvider(WebDriver driver, OrganizationalStructurePage organizationalStructurePage){
			try{

				createNewProviderPage= organizationalStructurePage.clickAddNewProvider(driver);
				waitForPageLoad(driver);

			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return createNewProviderPage;
		}

		/**
		 * clickAddNewExternalProvider
		 * function to click Add New Provider button
		 * @param 		selenium
		 * @since  	    May 04, 2015
		 */	
		public boolean clickAddNewExternalProvider(WebDriver driver, ReferringProviderPage referringProviderPage){
			try{

				referringProviderPage.clickAddNewExternalProvider(driver);
				waitForPageLoad(driver);

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
		 * @param		organizationalStructurePage
		 * @since  	    April 27, 2015
		 */	
		public CreateNewPracticePage goToAssociateProviderToPractice(WebDriver driver,SystemSettingsLib providerData, OrganizationalStructurePage organizationalStructurePage){
			try{

				createNewPracticePage= organizationalStructurePage.goToAssociateProviderToPractice(driver, providerData);
				waitForPageLoad(driver);

			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return createNewPracticePage;
		}

		/**
		 * associateProviderToPractice
		 * function to associate Provider To Practice 
		 * @param 		selenium
		 * @param 		providerData
		 * @param		organizationalStructurePage, organizationalStructurePage
		 * @since  	    April 27, 2015
		 */	
		public boolean associateProviderToPractice(WebDriver driver,SystemSettingsLib providerData, CreateNewPracticePage createNewPracticePage, OrganizationalStructurePage organizationalStructurePage){
			try{
				organizationalStructurePage.associateProviderToPractice(driver, providerData, createNewPracticePage);
				waitForPageLoad(driver);

			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}

		/**
		 * addNewReferringProviderWithPracticeNameOnly
		 * function to add New Referring Provider 
		 * @param 		selenium
		 * @param 		providerData
		 * @param		referringProviderPage
		 * @since  	    May 04, 2015
		 */	
		public boolean addNewReferringProviderWithPracticeNameOnly(WebDriver driver,SystemSettingsLib providerData, ReferringProviderPage referringProviderPage){
			try{
				referringProviderPage.addNewReferringProviderWithPracticeNameOnly(driver, providerData);
				waitForPageLoad(driver);

			}catch(RuntimeException e){
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
		/**
		 * addNewReferringProvider
		 * function to add New Referring Provider 
		 * @param 		selenium
		 * @param 		providerData
		 * @param		referringProviderPage
		 * @since  	    May 04, 2015
		 * verison 2.1
		 */	
		public boolean addNewReferringProvider(WebDriver driver,SystemSettingsLib providerData, ReferringProviderPage referringProviderPage){
			try{
				referringProviderPage.addNewReferringProvider(driver, providerData);
				waitForPageLoad(driver);

			}catch(RuntimeException e){
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		/**
		 * verifyReferralSummary
		 * function to check if a text is present or not
		 * @param String lastName- Last Name of Provider
		 * @param String firstName- First Name of Provider
		 * @param String practiceName-Practice Nme
		 * @param ReferringProviderPage
		 * @since May 14, 2015
		 * @verison  2.1
		 */	
		public boolean verifyReferralSummary(String lastName, String firstName,String practiceName,ReferringProviderPage referringProviderPage){
			return referringProviderPage.verifyReferralSummary(lastName, firstName,practiceName);
		}


			
		/**
		 * isTextPresent
		 * function to check if a text is present or not
		 * @param 		text
		 * @since  	    May 14, 2015
		 * @verison  2.1
		 */	
		public boolean isTextPresent(String text){
			return isTextPresent(driver,text);
		}

		/**
		 * clickSaveReferralProvider
		 * function to click Save ReferralProvider
		 * @param 		ReferringProviderPage
		 * @since  	    May 04, 2015
		 * version 2.1
		 */

	public boolean clickSaveReferralProvider(WebDriver driver,
			ReferringProviderPage referringProviderPage) {
		return referringProviderPage.clickSaveReferralProvider(driver);
	}

	/**
	 * clickEditReferralProvider
	 * function to click Edit ReferralProvider button
	 * @param 		selenium
	 * @param 		ReferringProviderPage
	 * @since  	    May 04, 2015
	 * version 2.1
	 */
	public boolean clickEditReferralProvider(WebDriver driver,
			ReferringProviderPage referringProviderPage) {
		return referringProviderPage.clickEditReferralProvider(driver);
	}
	
	/**
	 * verifyTabbingOrderForReferralPage
	 * function to verify Tabbing Order For ReferralPage 
	 * @param 		selenium
	 * @param 		ReferringProviderPage
	 * @since  	    May 04, 2015
	 * version 2.1
	 */
	public boolean verifyTabbingOrderForReferralPage(ReferringProviderPage referringProviderPage){
		return referringProviderPage.verifyTabbingOrderForReferralPage();
	}
		
		
}
