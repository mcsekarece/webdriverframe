package com.projectname.testutils.pages;

import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.SystemSettingsLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class ReferringProviderPage extends SeleniumWebDriver{

	public   ReferringProviderPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);
		SeleniumWebDriver.isElementPresent(readyLocator);
		}
	
	    private static By readyLocator=By.id("addReferringProvider");

	    private By btnAddProvider=By.id("addReferringProvider");
	    private By txtProviderSearchbox = By.id("searchTextBox");
		private By btnProviderSearch=By.id("searchButtonId");
		private By btnProviderDelete = By.xpath("//a[contains(@id,'Delete')]");
		private By btnYes = By.id("yesButton");
		private By txtLastName = By.id("lastName");
		private By txtFirstName = By.id("firstName");
		private By txtMiddleNameInitial = By.id("mi");
		private By txtLocationName1 = By.id("practiceName1");
		private By txtReferringCode = By.id("referringCode");
		private By lblReferralSummary=By.xpath("//div[@id='AdminReferringProviderList']/table/tbody/tr");
		private By lblFNameLName=By.xpath("(//div[@id='AdminReferringProviderList']/table/tbody/tr)[1]//span[@id='chartListItemTitle']");
		private By lblPracticeName=By.xpath("(//div[@id='AdminReferringProviderList']/table/tbody/tr)[1]//span[@class='large-left-content-item-spacer']");
		private By txtStreet = By.xpath("//input[contains(@id,'addr')]");
		private By txtCity = By.xpath("//input[contains(@id,'city')]");
		private By txtState = By.xpath("//input[contains(@id,'stateSuggestBox')]");
		private By txtZip = By.xpath("//input[contains(@id,'zip')]");
		private By txtCountry = By.xpath("//input[contains(@id,'countrySuggestBox')]");
		private By txtPhone = By.xpath("//input[contains(@id,'phone')]");
		private By txtPhoneExtn = By.xpath("//input[contains(@id,'phoneExt')]");
		private By txtFax = By.xpath("//input[contains(@id,'fax')]");
		private By txtEmail= By.xpath("//input[contains(@id,'eMail')]");
		
		
		//FIXME VEL-8251
		private By txtPracticeName = By.xpath("(//input[@type='text'])[7]");
		private By txtCredentials = By.id("credentials");
		private By txtStateLicNum = By.id("stateLicNum");
		private By ajxReportMethod = By.id("suggestBox");
		private By ajxSpeciality = By.id("specialtySuggestBoxIdsuggestBox");
		private By chkBillingExclution = By.id("billingExclusioncheckbox");
		private By txtBillingNumber = By.id("billingNumber");
		private By txtComments = By.id("comments");
		private By btnAddAddress = By.id("addAddressButton");
		private By rbtnPrimaryAddress = By.id("primaryAddress_rb");
		private By txtPracticeName1 = By.id("practiceName4");
		
		private By btnSave = By.id("save");
		private By btnEdit = By.id("editButtonId");
		
		
		/**
		 * clickAddNewExternalProvider
		 * function to click Add New Provider button
		 * @param 		selenium
		 * @since  	    May 04, 2015https://lh4.googleusercontent.com/-6RwFHLJHEhw/AAAAAAAAAAI/AAAAAAAAIUk/1YQK-aiic4Y/s46-c-k-no/photo.jpg
		 * verison 2.1
		 */	
		public boolean clickAddNewExternalProvider(WebDriver driver){
			try{

				verifyTrue(click(driver,btnAddProvider),"Could not click the Add",driver);
				waitForPageLoad(driver);

			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		
		/**
		 * searchReferralProvider
		 * function to search Tabbing ReferralProvider
		 * @param 		String providerData- Provider to be searched
		 * @since  	    May 04, 2015
		 * version 2.1
		 */
		public boolean searchReferralProvider(WebDriver driver,String providerData){
			if(isVisible(driver, txtProviderSearchbox)){
				waitForPageLoad(driver);
				verifyTrue(type(driver, txtProviderSearchbox,providerData),"Could not type the first name; More Details"+providerData.toString(),driver);
				waitForPageLoad(driver);
				verifyTrue(click(driver,btnProviderSearch),"Could not click the search button"+providerData.toString(),driver);
				waitForPageLoad(driver);
			}
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
		public boolean deleteExternalProvider(WebDriver driver,String providerData){
			try{
				if(isVisible(driver, txtProviderSearchbox)){
				verifyTrue(type(driver, txtProviderSearchbox,providerData),"Could not type the first name; More Details"+providerData.toString(),driver);
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
			waitForPageLoad(driver);
			return true;
		}

		/**
		 * addNewReferringProviderWithPracticeNameOnly
		 * function to add New Referring Provider 
		 * @param 		selenium
		 * @param 		providerData
		 * @since  	    May 04, 2015
		 */	
		public boolean addNewReferringProviderWithPracticeNameOnly(WebDriver driver,SystemSettingsLib providerData){
			try{
				verifyTrue(type(driver, txtReferringCode,providerData.referringCode),"Could not type the Referring code; More Details"+providerData.toString(),driver);
				waitForPageLoad(driver);
				verifyTrue(type(driver, txtPracticeName,providerData.practiceName1),"Could not type the Practice Name; More Details"+providerData.toString(),driver);
				waitForPageLoad(driver);
				verifyTrue(click(driver,btnSave),"Could not click the Save button"+providerData.toString(),driver);
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
		 * @since  	    May 14, 2015
		 */	
		public boolean addNewReferringProvider(WebDriver driver,SystemSettingsLib providerData){
			try{
				
				if(providerData.referringCode!=""){
					verifyTrue(type(driver, txtReferringCode,providerData.referringCode),"Could not type the Referring code; More Details"+providerData.toString(),driver);
				}
				if(providerData.lastName!=""){
					verifyTrue(type(driver, txtLastName,providerData.lastName),"Could not type the last name; More Details"+providerData.toString(),driver);
				}
				if(providerData.firstName!=""){
					verifyTrue(type(driver, txtFirstName,providerData.firstName),"Could not type  first name; More Details"+providerData.toString(),driver);
				}
				if(providerData.practiceNameReferral!=""){
					verifyTrue(type(driver, txtPracticeName,providerData.practiceNameReferral),"Could not type the Practice Name; More Details"+providerData.toString(),driver);
				}
				if(providerData.practiceName1!=""){
					verifyTrue(type(driver, txtLocationName1,providerData.practiceName1),"Could not type the location name; More Details"+providerData.toString(),driver);
				}
				if(providerData.epstreet11!=""){
					verifyTrue(type(driver, txtStreet,providerData.epstreet11),"Could not type the street name; More Details"+providerData.toString(),driver);
				}
				if(providerData.epcity1!=""){
					verifyTrue(type(driver, txtCity,providerData.epcity1),"Could not type the city code; More Details"+providerData.toString(),driver);
				}
				if(providerData.epstate1!=""){
					verifyTrue(selectValueFromAjaxList(driver, txtState,providerData.epstate1),"Could not type the state name; More Details"+providerData.toString(),driver);
				}
				if(providerData.epcountry1!=""){
					verifyTrue(selectValueFromAjaxList(driver, txtCountry,providerData.epcountry1),"Could not type the country name; More Details"+providerData.toString(),driver);
				}
				if(providerData.epphone1!=""){
					verifyTrue(type(driver, txtPhone,providerData.epphone1),"Could not type the phone number; More Details"+providerData.toString(),driver);
				}
				if(providerData.epfax1!=""){
					verifyTrue(type(driver, txtFax,providerData.epfax1),"Could not type the Fax; More Details"+providerData.toString(),driver);
				}
				if(providerData.epemail1!=""){
					verifyTrue(type(driver, txtEmail,providerData.epemail1),"Could not type the Email; More Details"+providerData.toString(),driver);
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
		 * clickSaveReferralProvider
		 * function to click Save Provider button
		 * @param 		selenium
		 * @since  	    May 14, 2015
		 */	
		public boolean clickSaveReferralProvider(WebDriver driver){
			boolean result=false;
			try{
				result=click(driver,btnSave);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return result;
		}
		
		/**
		 * clickEditReferralProvider
		 * function to click Edit Provider button
		 * @param 		selenium
		 * @since  	    May 14, 2015
		 */	
		public boolean clickEditReferralProvider(WebDriver driver){
			try{
					return click(driver,btnEdit);
			} catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}
		/**
		 * isTextPresent
		 * function to check if a text is present or not
		 * @param 		text
		 * @since  	    May 14, 2015
		 */	
		public boolean isTextPresent(String text){
			return isTextPresent(driver,text);
		}
		
		/**
		 * verifyReferralSummary
		 * function to check if a text is present or not
		 * @param String lastName- Last Name of Provider
		 * @param String firstName- First Name of Provider
		 * @param String practiceName-Practice Nme
		 * @since May 14, 2015
		 * @verison  2.1
		 */	
		public boolean verifyReferralSummary(String lastName, String firstName,String practiceName){
			try {
				waitForPageLoad(driver);
				String referralSummary= getText(driver, lblReferralSummary).toLowerCase();
				if(lastName!=""&&firstName!=""&&practiceName!=""){
					assertTrue(referralSummary.contains(lastName.toLowerCase()+", "+firstName.toLowerCase()+practiceName.toLowerCase()),"First Name,  Last Name and Practice Name are not in sequence",driver,className, methodName);
					assertTrue(getCssValue(lblFNameLName,"font-weight").equals("700"),"First Name and Last Name are not in bold",driver,className, methodName);
					assertTrue(!getCssValue(lblPracticeName,"font-weight").equals("700"),"Practice Name is in bold",driver,className, methodName);
				}else if(lastName==""&&firstName==""&&practiceName!=""){
					assertTrue(referralSummary.contains(practiceName.toLowerCase()),"Practice Name is not in present",driver,className, methodName);
					assertTrue(getCssValue(lblFNameLName,"font-weight").equals("700"),"First Name and Last Name are not in bold",driver,className, methodName);
				}else if(lastName!=""&&firstName!=""&&practiceName==""){
					assertTrue(referralSummary.contains(lastName.toLowerCase()+", "+firstName.toLowerCase()),"First Name,  Last Name and Practice Name are not in sequence",driver,className, methodName);
					assertTrue(getCssValue(lblFNameLName,"font-weight").equals("700"),"First Name and Last Name are not in bold",driver,className, methodName);
				}
			} catch (ExceptionHandler e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return true;
		}
		/**
		 * verifyTabbingOrderForReferralPage
		 * function to verify Tabbing Order For ReferralPage 
		 * @param 		selenium
		 * @since  	    May 04, 2015
		 * version 2.1
		 */
		public boolean verifyTabbingOrderForReferralPage(){
			driver.findElement(txtReferringCode).sendKeys("");
			By[] tabOrder = {
				      txtReferringCode,
				      txtLastName,
				      txtFirstName,
				      txtMiddleNameInitial,
				      txtPracticeName,
				      txtCredentials,
				      txtStateLicNum,
				      ajxReportMethod,
				      ajxSpeciality,
				      chkBillingExclution,
				      txtComments,
				      btnAddAddress
				    };
			verifyTabbingOrder(tabOrder);
			return true;
		}
		
		

}
