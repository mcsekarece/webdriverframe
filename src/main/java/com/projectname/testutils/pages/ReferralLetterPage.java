package com.projectname.testutils.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.SystemSettingsLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class ReferralLetterPage extends SeleniumWebDriver{

	public   ReferralLetterPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);
		SeleniumWebDriver.isElementPresent(readyLocator);
		}
	
	    private static By readyLocator=By.id("referralSearchBox");
		private By imgReferralIcon = By.xpath("//img[@title='Add New Referral']");
		private By ajxSearchReferral = By.id("referralSearchBox");
		private By ajxSelectTemplate = By.id("templatesuggestBox");
		private By btnReferralSave = By.id("referPatientSaveButton");
		private By txtAuthorisatiion = By.id("referralAuthCodeText");
		private By txtNotify = By.id("durationsuggestBox");
		private By ajxNotifyIn = By.id("durationUnitsuggestBox");
		private By lblFirstItem = By.id("currentItem_1");
		private By btnSearchClose = By.id("searchClose");
		private By headIcon = By.xpath("//div[@id='currentItem_1']/div/img");
		private By letterContents = By.xpath("//div[contains(@id,'cke_gwt-uid-')]");
		private By lnkprovider = By.id("currentItem_1");
		
		//FIXME VEL-8135
		private By chkAssessment = By.xpath("//div[contains(@id,'gwt-uid-')]");
		
		/**
		 * navigateToReferralLetterPage function to navigate to Referral Letter Page
		 * @param driver
		 * @since  	@since April 24, 2015
		 * @version 2.1
		 */

		public boolean navigateToReferralLetterPage(WebDriver driver) throws IOException {
		try{
			
			verifyTrue(click(driver,imgReferralIcon),"Could not click the referral order button", driver);		
			waitForPageLoad(driver);
			waitForPageLoad(driver);

		} catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
	
			return true;
		}

		
		/**
		 * verifyLetterContents function to verify Letter Contents in Referral Letter Page
		 * @param driver
		 * @param String - defaultTemplateName
		 * @param ChartPreVisitLib - referralData
		 * @since  	@since April 28, 2015
		 * @version 2.1
		 */

		public boolean verifyLetterContents(WebDriver driver, ChartPreVisitLib referralData, String defaultTemplateName) throws IOException {
		try{
			String defaultContent="";
			assertTrue(getValue(driver,ajxSelectTemplate).contains(defaultTemplateName),"Default Letter not present", driver, className, methodName);
			waitForPageLoad(driver);
			defaultContent= getText(driver, letterContents);
			assertTrue(selectValueFromAjaxList(driver, ajxSelectTemplate ,referralData.letterTemplateName), "Could not select template",driver, className, methodName);
			waitForPageLoad(driver);
			assertTrue(!getText(driver,letterContents).contains(defaultContent),"Letter content not changed", driver, className, methodName);
			waitForPageLoad(driver);

		} catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
			return true;
		}

		
		/**
		 * addNewReferralLetter function to add Referral Letter
		 * @param driver
		 * @param ChartPreVisitLib - referralData
		 * @since  	@since April 24, 2015
		 * @version 2.1
		 */
		
		public boolean addNewReferralLetter(WebDriver driver, ChartPreVisitLib referralData) throws IOException {

			try{
				
			if (referralData.testCaseId.equals("TC_IRL_011")||referralData.testCaseId.equals("TC_IRL_012") ){		
				
				if (referralData.testCaseId.equals("TC_IRL_011")) {
					if (!referralData.otherReferral.equals("")){		
						verifyTrue(selectValueFromAjaxList(driver, ajxSearchReferral,referralData.otherReferral), "Could not select referal - " +referralData.otherReferral, driver);
						waitForPageLoad(driver);
				}}else if (referralData.testCaseId.equals("TC_IRL_012")) {
					
					if (!referralData.practice.equals("")){		
						verifyTrue(type(driver, ajxSearchReferral ,referralData.practice), "Could not type practice ",driver);
					    waitForPageLoad(driver);
					
						verifyTrue(getText(driver,lnkprovider).toLowerCase().contains(referralData.otherReferral.toLowerCase()),"Refferal To Name name not present", driver);
				    	waitForPageLoad(driver);
					
						verifyTrue(click(driver,lnkprovider),"Couldn't Select Refferal To Name present", driver);
				    	waitForPageLoad(driver);
					}
				}
			   } else if (!referralData.referral1.equals("")){		
				   verifyTrue(selectValueFromAjaxList(driver, ajxSearchReferral,referralData.referral1), "Could not select referal - " +referralData.referral1, driver);
				waitForPageLoad(driver);
	 			waitForPageLoad(driver);
		    } 
			if (!referralData.letterTemplateName.equals("")){		
				verifyTrue(selectValueFromAjaxList(driver, ajxSelectTemplate ,referralData.letterTemplateName), "Could not select template",driver);
			waitForPageLoad(driver);
			}
			if (!referralData.letterTemplateName.equals("")){		
				verifyTrue(type(driver, txtAuthorisatiion ,referralData.authorization), "Could not select template",driver);
			waitForPageLoad(driver);
			}
					
			verifyTrue(click(driver,btnReferralSave),"Could not click Save button", driver);
			waitForPageLoad(driver);

			}
			catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
		
			return true;
			
		}	

		/**
		 * verifyHeadIconInSearch function to verify HeadIcon In Search Referral SuggestBox
		 * @param driver
		 * @param ChartPreVisitLib - referralData
		 * @since  	@since April 28, 2015
		 * @version 2.1
		 */
		
		public boolean verifyHeadIconInSearch(WebDriver driver, ChartPreVisitLib referralData) throws IOException {

			try{
				assertTrue(type(driver, ajxSearchReferral,referralData.referral1), "Could not select referal - " , driver, className, methodName);
				 waitForPageLoad(driver);
				assertTrue(isElementPresent(driver, headIcon),"headIcon not present", driver, className, methodName);
				waitForPageLoad(driver);
				verifyTrue(click(driver,lblFirstItem),"Could not click the Search Close button", driver);		
				waitForPageLoad(driver);

			}
			catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
		
			return true;
		}	


		/**
		 * verifyAssessmentInLetter function to verify Assessment In Letter
		 * @param driver
		 * @param ChartPreVisitLib - referralData
		 * @since  May 05, 2015
		 * @version 2.1
		 */
		
		public boolean verifyAssessmentInLetter(WebDriver driver, ChartPreVisitLib proData) throws IOException {

			try{
				assertTrue(isTextPresent(driver, proData.encounterDiagnosis), "Diagnosis not present", driver, className, methodName);
				 waitForPageLoad(driver);
				assertTrue(isElementPresent(driver, chkAssessment),"chkAssessment not present", driver, className, methodName);
				waitForPageLoad(driver);
			}
			catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
		
			return true;
		}	

		/**
		 * verifyPracticeInReferralSuggestBox function to verify Practice Name In Referral SuggestBox
		 * @param driver
		 * @param ChartPreVisitLib - referralData
		 * @since  	@since April 24, 2015
		 * @version 2.1
		 */
		
		public boolean verifyPracticeInReferralSuggestBox(WebDriver driver, SystemSettingsLib pracData, SystemSettingsLib providerData) throws IOException {

			try{
				assertTrue(type(driver, ajxSearchReferral,pracData.practiceName), "Could not select referal - " , driver, className, methodName);
				 waitForPageLoad(driver);
				assertTrue(getText(driver,lblFirstItem).toLowerCase().contains(providerData.firstName.toLowerCase()),"Practice name not present", driver, className, methodName);
				waitForPageLoad(driver);
				verifyTrue(click(driver,btnSearchClose),"Could not click the Search Close button", driver);		
				waitForPageLoad(driver);

			}
			catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
		
			return true;
		}	

		/**
		 * verifyMultipleProviderNamesInReferralSuggestBox function to verify Multiple Provider Names In Referral SuggestBox
		 * @param driver
		 * @param ChartPreVisitLib - referralData
		 * @since  	@since April 24, 2015
		 * @version 2.1
		 */
		
		public boolean verifyMultipleProviderNamesInReferralSuggestBox(WebDriver driver, SystemSettingsLib providerData, String provdata, int count) throws IOException {

			try{
				assertTrue(type(driver, ajxSearchReferral,provdata), "Could not select referal - ", driver, className, methodName);
				 waitForPageLoad(driver);
				for(int i=1; i<=count; i++)
				{
				By temp = By.id("currentItem_"+i);
			  	if(!isElementPresent(driver,temp)){
					  return false;
				}
				assertTrue(getText(driver,temp).toLowerCase().contains(providerData.specialty.toLowerCase()),"specialty name not present", driver, className, methodName);
				waitForPageLoad(driver);
				}
				verifyTrue(click(driver,btnSearchClose),"Could not click the Search Close button", driver);		
				waitForPageLoad(driver);

			}
			catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
		
			return true;
		}	
				
}
