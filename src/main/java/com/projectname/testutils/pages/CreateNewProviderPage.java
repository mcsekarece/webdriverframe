package com.projectname.testutils.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.SystemSettingsLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class CreateNewProviderPage extends SeleniumWebDriver{

	public   CreateNewProviderPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);
		SeleniumWebDriver.isElementPresent(readyLocator);
		}
	
	    private static By readyLocator=By.id("referralSearchBox");
		private By  ajxProviderTypesuggestBox  =  By.id("providerTypesuggestBox");
		private By txtLastName = By.id("lastName");
		private By txtFirstName = By.id("firstName");
		private By txtSpecialtySuggestBox  =  By.id("specialtysuggestBox");
		private By ajxMaximumFTESuggestBoxsuggestBox = By.id("maximumFTESuggestBoxsuggestBox");
		private By btnSave =  By.id("save");
		private By btnAddSpeciality = By.id("addSpecialtyButton");
		private By  txtProviderCode  = By.id("providerCode");
		private By ajxTitleSuggestBox =  By.id("titlesuggestBox");
		private By txtMiddleName = By.id("middleName");
		private By txtCredentials =  By.id("credentials");
		private By ajxGendersuggestBox =  By.id("gendersuggestBox");
		private By txtCellPhone  = By.id("cellPhone");
		private By txtPager  =  By.id("pager");
		private By txtEmail  = By.id("email");
		private By ajxHoursWorked= By.id("hoursWorked");
		private By ajxBillingStatesuggestBox = By.id("billingStatesuggestBox");
		private By txtMailingStreet1  = By.id("mailingStreet1");
		private By txtMailingStreet2  = By.id("mailingStreet2");
		private By txtMailingCity  = By.id("mailingCity");
		private By txtcmt = By.id("comments");
		private By  txtMailingOfficePhone =    By.id("mailingOfficePhone");
		private By  txtMailingOfficePhoneExt = By.id("mailingOfficePhoneExt");


	    
		/**
		 * createNewProvider function to Create New Provider
		 * @param driver
		 * @param SystemSettingsLib - providerData
		 * @since  	@since April 24, 2015
		 * @version 2.1
		 */
		
		public boolean createNewProvider(WebDriver driver, SystemSettingsLib providerData) throws IOException {

			try{
				
				if (!providerData.providerType.equals("")){
					assertTrue(selectValueFromAjaxList(driver,ajxProviderTypesuggestBox, providerData.providerType), "Could not select referal - ", driver, className, methodName);
					waitForPageLoad(driver);
				}
	
				if (!providerData.providerCode.equals("")){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("ddMMyyHHmm");
				String providerCodeUnique=DateFormat.format(cal.getTime());
				verifyTrue(type(driver,txtProviderCode,providerCodeUnique),"Could not enter the provider code", driver);
				}

				if (!providerData.title.equals("")){
					verifyTrue(selectValueFromAjaxList(driver, ajxTitleSuggestBox,providerData.title), "Could not select referal - ", driver);
					waitForPageLoad(driver);
				}

				if (!providerData.firstName.equals("")){
			assertTrue(type(driver, txtFirstName,providerData.firstName),"Could not enter the  name"+ providerData.toString(),driver, className, methodName);
				}
				
				if (!providerData.lastName.equals("")){
			assertTrue(type(driver,txtLastName,providerData.lastName),"Could not type a last name"+ providerData.toString(), driver, className, methodName);
			waitForPageLoad(driver);
				}
				
				if (!providerData.middleName.equals("")){
			assertTrue(type(driver,txtMiddleName,providerData.middleName),"Could not type a last name"+ providerData.toString(), driver, className, methodName);
			waitForPageLoad(driver);
				}

				if (!providerData.credentials.equals("")){
			assertTrue(type(driver,txtCredentials,providerData.credentials),"Could not type a last name"+ providerData.toString(), driver, className, methodName);
			waitForPageLoad(driver);
				}

				if (!providerData.specialty.equals("")){
			assertTrue(selectValueFromAjaxList(driver,txtSpecialtySuggestBox,providerData.specialty), "Could not select template",driver, className, methodName);
			waitForPageLoad(driver);
			assertTrue(click(driver, btnAddSpeciality),"Could not click the add button",driver, className, methodName);
			waitForPageLoad(driver);
				}

				if (!providerData.gender.equals("")){
					verifyTrue(selectValueFromAjaxList(driver, ajxGendersuggestBox ,providerData.gender), "Could not select referal - ", driver);
					waitForPageLoad(driver);
				}

				if (!providerData.cellPhone.equals("")){
				verifyTrue(type(driver,txtCellPhone ,providerData.cellPhone),"Could not type cell phone number"+ providerData.toString(),driver);
				waitForPageLoad(driver);
				}

				if (!providerData.pager.equals("")){
				verifyTrue(type(driver,txtPager,providerData.pager),"Could not type pager number"+ providerData.toString(),driver);
				}
				
				if (!providerData.email.equals("")){
				verifyTrue(type(driver,txtEmail ,providerData.email),"Could not type email"+ providerData.toString(),driver);
				}
	
				if (!providerData.maximumFte.equals("")){
					verifyTrue(selectValueFromAjaxList(driver,ajxMaximumFTESuggestBoxsuggestBox,providerData.maximumFte), "Could not select template",driver);
					waitForPageLoad(driver);
				}

				if (!providerData.hoursWorked.equals("")){
				verifyTrue(type(driver,ajxHoursWorked,providerData.hoursWorked),"Could not type cell phone number"+ providerData.toString(),driver);
				waitForPageLoad(driver);
				}

				if (!providerData.comments.equals("")){
				verifyTrue(type(driver,txtcmt,providerData.comments),"Could not type cell phone number"+ providerData.toString(),driver);
				waitForPageLoad(driver);
				}

				if (!providerData.address1.equals("")){
				verifyTrue(type(driver, txtMailingStreet1,providerData.address1),"Could not type cell phone number"+ providerData.toString(),driver);
				waitForPageLoad(driver);
				}

				if (!providerData.address2.equals("")){
				verifyTrue(type(driver,txtMailingStreet2 ,providerData.address2),"Could not type cell phone number"+ providerData.toString(),driver);
				waitForPageLoad(driver);
				}

				if (!providerData.city.equals("")){
				verifyTrue(type(driver,txtMailingCity,providerData.city),"Could not type cell phone number"+ providerData.toString(),driver);
				waitForPageLoad(driver);
				}

				if (!providerData.officePhone.equals("")){
				verifyTrue(type(driver, txtMailingOfficePhone,providerData.officePhone),"Could not type office phone"+ providerData.toString(), driver);
				waitForPageLoad(driver);
				}

				if (!providerData.officePhone.equals("")){
				verifyTrue(type(driver, txtMailingOfficePhoneExt,providerData.officePhone1),"Could not type office phone extn"+ providerData.toString(), driver);
				waitForPageLoad(driver);
				}
				
			}
			catch (Exception e) {
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
		
		public boolean saveNewProvider(WebDriver driver) throws IOException {

			try{
				assertTrue(click(driver, btnSave),"Could not click the save button",driver, className, methodName);
				waitForPageLoad(driver);
			}
			catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
			return true;
		}	

}
