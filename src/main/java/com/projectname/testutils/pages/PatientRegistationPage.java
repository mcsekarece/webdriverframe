package com.projectname.testutils.pages;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class PatientRegistationPage extends SeleniumWebDriver{

    public static By readyLocator=By.id("saveButton");

	public  PatientRegistationPage() {
		PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
		// TODO Auto-generated constructor stub
	}
        private By txtChartNumber=By.id("chartNumber");
		private By ajxPrimaryLocation=By.id("primaryLocationSuggestBoxsuggestBox");
		private By ajxResponsbleProvider=By.id("responsibleProvSuggestBoxsuggestBox");
		private By txtLastName=By.id("lastName");
		private By txtFirstName=By.id("firstName");
		private By txtDOB=By.id("dob");
		private By btnBack=By.id("notDuplicateButton"); 
		private By chkPremature=By.id("prematurecheckbox");
		private By txtPrematureDuration=By.id("prematureDuration");
		private By ajxPrematureMeasure=By.id("prematureMeasureUnitSuggestBoxsuggestBox");
		private By ajxSex=By.id("sexSuggestBoxsuggestBox");
		private By txtStatusDate=By.id("statusDate");
		private By chkResponsibleProvider=By.id("responsibleProvPCPcheckbox");
		private By txtComments=By.id("comments");
		private By btnSave1=By.id("saveButton");
		private By btnErrorClose = By.id("errorCloseButton");
		private By chkBoxForDNC=By.id("doNotContactcheckbox");
		private By btnCancel=By.id("cancelButton");
		private By btnNoDuplicate = By.id("notDuplicateButton");
		// t
		
		private By btnPayersList = By.id("!patientPayersList");
		private By btnMedicalPayersList = By.id("medicalPayers");
		
		private By ajxPayerSelect = By.id("payerSearchSuggestBoxsuggestBox");
		private By txtPayerStartDate = By.id("startDate");
		private By ajxRelationShip = By.id("subscriberRelationshipSuggestBoxsuggestBox");
	
		private By btnSaveNew = By.linkText("Save");
		private By btnAddNew = By.cssSelector("div.add-button");
	
		
		
		
      /**
  	 * createPatient
  	 * function to create a new patient check-in
  	 * @throws IOException 
  	 * @since  Nov 24, 2014
  	 */	
  	
		public DemographicsPage createPatient(WebDriver driver, HomeLib patientData,String account) throws Exception{
  			try{
  				if(!patientData.patientIdchart.isEmpty())
  					if(!patientData.patientIdchart.contains("N/A"))
  						assertTrue(type(driver,txtChartNumber,patientData.patientIdchart),"Could not Enter the patientId chart, Expected value to be typed" + patientData.patientIdchart, driver, className, methodName );
  				if(!patientData.primaryLocation.isEmpty())
  					if(!patientData.primaryLocation.contains("N/A"))
  						if(!selectValueFromAjaxList(driver, ajxPrimaryLocation, patientData.primaryLocation))
  							Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.primaryLocation);
  				if(!patientData.responsibleProvider.isEmpty())
  					if(!patientData.responsibleProvider.contains("N/A"))
  						if(!selectValueFromAjaxList(driver,ajxResponsbleProvider,patientData.responsibleProvider))
  							Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.responsibleProvider);
  				waitForPageLoad(driver);
  				if(!patientData.pcpCheck.isEmpty())
  					if(!patientData.pcpCheck.contains("No"))
  						if(!isChecked(driver,chkResponsibleProvider))
  							assertTrue(check(driver, chkResponsibleProvider), "Could not check the pcp check box, Expected value for the check box : " + patientData.pcpCheck, driver, className, methodName);
  				
  				if(!patientData.lastName.isEmpty())
  					if(!patientData.lastName.contains("N/A"))
  						assertTrue(type(driver, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName, driver, className, methodName);
  				if(!patientData.firstName.isEmpty())
  					if(!patientData.firstName.contains("N/A"))
  					assertTrue(type(driver, txtFirstName, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName, driver, className, methodName);
  				/*if(!patientData.middleName.isEmpty())
  					if(!patientData.middleName.contains("N/A"))
  						assertTrue(type(driver, txtMiddleName, patientData.middleName), "Could not Enter middle name, Expected value to be typed" + patientData.middleName, driver, className, methodName);
  				if(!patientData.title.isEmpty())
  					if(!patientData.title.contains("N/A"))
  						if(!selectValueFromAjaxList(driver, ajxTitle, patientData.title))	
  							Assert.fail("Could not Enter Title, Expected value to be selected" + patientData.title);
  				if(!patientData.suffix.isEmpty())
  					if(!patientData.suffix.contains("N/A"))
  						if(!selectValueFromAjaxList(driver, ajxSuffix, patientData.suffix))
  							Assert.fail("Could not Enter Suffix, Expected value to be selected" + patientData.suffix);
  				if(!patientData.alias1.isEmpty())
  					if(!patientData.alias1.contains("N/A"))
  						assertTrue(type(driver, txtAlias1, patientData.alias1), "Could not Enter alias1, Expected value to be typed" + patientData.alias1, driver, className, methodName);
  				if(!patientData.alias2.isEmpty())
  					if(!patientData.alias2.contains("N/A"))
  						assertTrue(type(driver, txtAlias2, patientData.alias2), "Could not Enter alias2, Expected value to be typed" + patientData.alias2, driver, className, methodName);
  				if(!patientData.dob.isEmpty())
  					if(!patientData.dob.contains("N/A"))
  						assertTrue(enterDate(driver, txtDOB, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, driver, className, methodName);			
  				click(driver,btnBack);
  				if(!patientData.estimatedCheck.isEmpty())
  					if(!patientData.estimatedCheck.contains("No") && !isChecked(driver, chkDOBEstimated))
  						assertTrue(click(driver, chkDOBEstimated), "Could not check the estimated check box, Expected value for the check box : " + patientData.estimatedCheck, driver, className, methodName);
  				        waitForPageLoad(driver);
  				if(!patientData.prematureCheck.isEmpty())
  					if(!patientData.prematureCheck.contains("No") && !isChecked (driver, chkPremature)){
  						assertTrue(click(driver, chkPremature), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck, driver, className, methodName);
  						waitForPageLoad(driver);
  						if(!patientData.duration.isEmpty())
  							if(!patientData.duration.contains("N/A"))
  								assertTrue(type(driver, txtPrematureDuration, patientData.duration), "Could not Enter duration, Expected value to be typed : " + patientData.duration, driver, className, methodName);
  						        waitForPageLoad(driver);
  						if(!patientData.measure.isEmpty())
  							if(!patientData.measure.contains("N/A"))
  								if(!selectValueFromAjaxList(driver, ajxPrematureMeasure, patientData.measure))
  									Assert.fail("Could not Enter Premature Messure, Expected value to be selected" + patientData.measure);
  									waitForPageLoad(driver);
  					}*/
  				if(!patientData.sex.isEmpty())
  					if(!patientData.sex.contains("N/A"))
  						if(!selectValueFromAjaxList(driver, ajxSex, patientData.sex))
  							Assert.fail("Could not Enter Sex, Expected value to be selected" + patientData.sex);
  							waitForPageLoad(driver);
  			/*	if(!patientData.maritalStatus.isEmpty())
  					if(!patientData.maritalStatus.contains("N/A"))
  						if(!selectValueFromAjaxList(driver, ajxmartialStatus, patientData.maritalStatus))
  							Assert.fail("Could not Enter Marital Status, Expected value to be selected" + patientData.maritalStatus);					
  				if(!patientData.status.isEmpty())
  					if(!patientData.status.contains("N/A"))
  						if(!selectValueFromAjaxList(driver, ajxStatus, patientData.status))
  							Assert.fail("Could not Enter Status, For; More Details" + patientData.toString());
  				
  				
  				if (account.contains("CA")) {
  					Calendar cal = Calendar.getInstance();
  					SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
  					date = DateFormat.format(cal.getTime());

  				} else if(account.contains("US")) {
  					Calendar cal = Calendar.getInstance();
  					SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
  					date = DateFormat.format(cal.getTime());

  				}
  				if(!patientData.statusDate.isEmpty())
  					if(!patientData.statusDate.contains("N/A"))
  						assertTrue(enterDate(driver, txtStatusDate,date ), "Could not Enter statusDate, For; More Details" + patientData.toString(), driver, className, methodName);
  				if(patientData.status.equalsIgnoreCase("inactive"))
  					if(!patientData.reasonForInactivation.isEmpty())
  						if(!patientData.reasonForInactivation.contains("N/A"))
  							if(!selectValueFromAjaxList(driver, ajxStationInactivation, patientData.reasonForInactivation))
  								Assert.fail("Could not Enter reason for inactivation, For; More Details" + patientData.maritalStatus);					
  				if(!patientData.residentialAddrStreet1.isEmpty())
  					if(!patientData.residentialAddrStreet1.contains("N/A"))
  						assertTrue(type(driver, txtResidentAddress1, patientData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + patientData.residentialAddrStreet1, driver, className, methodName);
  				if(!patientData.residentialAddrStreet2.isEmpty())
  					if(!patientData.residentialAddrStreet2.contains("N/A"))
  						assertTrue(type(driver, txtResidentAddress2, patientData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + patientData.residentialAddrStreet2, driver ,className,methodName);
  				if(!patientData.residentialAddrcity.isEmpty())
  					if(!patientData.residentialAddrcity.contains("N/A"))
  						assertTrue(type(driver, txtResidentialCity, patientData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + patientData.residentialAddrcity, driver, className, methodName);
  				if(!patientData.residentialAddrstate.isEmpty())
  					if(!patientData.residentialAddrstate.contains("N/A"))
  						if(!selectValueFromAjaxList(driver, ajxResidentialState, patientData.residentialAddrstate))
  							Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.residentialAddrstate);
  				if(!patientData.residentialAddrzipCode.isEmpty())
  					if(!patientData.residentialAddrzipCode.contains("N/A"))
  						assertTrue(type(driver, txtResidentialZip, patientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCode, driver, className, methodName);
  				waitForPageLoad(driver);
  				driver.findElement(ajxPhoneType1).sendKeys(Keys.ENTER);
  				click(driver,btnYesButton);
  				waitForElementToEnable(driver,txtResidentialCity);
  				waitForPageLoad(driver);
  				waitForElementToEnable(driver,ajxResidentialState);
  				waitForPageLoad(driver);
  				waitForElementToEnable(driver,ajxResidentialCountry);
  				waitForPageLoad(driver);
  				
  				
  				if(!patientData.telephoneType1.isEmpty())
  					if(!patientData.telephoneType1.contains("N/A"))
  						if(!selectValueFromAjaxList(driver, ajxPhoneType1, patientData.telephoneType1))
  							Assert.fail("Could not Enter Telephone Type1, Expected value to be Select" + patientData.telephoneType1);
  				if(!patientData.telephoneNo1.isEmpty())
  					if(!patientData.telephoneNo1.contains("N/A"))
  						//Assert.assertTrue(type(driver, txtPrimaryPhone, patientData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo1);
  						type(driver,txtPrimaryPhone,  patientData.telephoneNo1);
  				if(!patientData.telephoneextnNo1.isEmpty())
  					if(!patientData.telephoneextnNo1.contains("N/A"))
  						assertTrue(type(driver, txtPrimaryPhoneExtn, patientData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo1, driver, className, methodName);
  				if(!patientData.telephoneType2.isEmpty())
  					if(!patientData.telephoneType2.contains("N/A"))
  						if(!selectValueFromAjaxList(driver, ajxPhoneType2, patientData.telephoneType2))
  							Assert.fail("Could not Enter Telephone Type2, Expected value to be Select" + patientData.telephoneType2);
  				if(!patientData.telephoneNo2.isEmpty())
  					if(!patientData.telephoneNo2.contains("N/A"))
  						assertTrue(type(driver, txtOtherPhone1, patientData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo2, driver, className, methodName);
  				if(!patientData.telephoneextnNo2.isEmpty())
  					if(!patientData.telephoneextnNo2.contains("N/A"))
  						assertTrue(type(driver, txtOtherPhone1Extn, patientData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo2, driver, className, methodName);
  				
  				if(!patientData.telephoneType3.isEmpty())
  					if(!patientData.telephoneType3.contains("N/A"))
  						if(!selectValueFromAjaxList(driver, ajxPhoneType3, patientData.telephoneType3))
  							Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.telephoneType3);
  				
  				if(!patientData.telephoneNo3.isEmpty())
  					if(!patientData.telephoneNo3.contains("N/A"))
  						assertTrue(type(driver, txtOtherPhone2, patientData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo3, driver, className, methodName);
  				if(!patientData.telephoneextnNo3.isEmpty())
  					if(!patientData.telephoneextnNo3.contains("N/A"))
  						assertTrue(type(driver, txtOtherPhone2Extn, patientData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneNo3, driver, className, methodName);
  				
  				if(!patientData.email.isEmpty())
  					if(!patientData.email.contains("N/A"))
  						assertTrue(type(driver, txtEmail, patientData.email), "Could not Enter email, Expected value to be Typed" + patientData.email, driver, className, methodName);
  				
  				if(!patientData.contactPreferences.isEmpty())
  					if(!patientData.contactPreferences.contains("N/A"))
  						if(!selectValueFromAjaxList(driver, ajxContactPreference, patientData.contactPreferences))
  							Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences);
  				
  				if(!patientData.contactPreferences1.isEmpty())
  					if(!patientData.contactPreferences1.contains("N/A"))
  						assertTrue(click(driver, btnAddContactPreference), "Could not click on add more button", driver, className, methodName);
  						if(!selectValueFromAjaxList(driver, ajxContactPreference1, patientData.contactPreferences1))
  							Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences1);
  				
  				if(!patientData.contactPreferences2.isEmpty())
  					if(!patientData.contactPreferences2.contains("N/A"))
  						assertTrue(click(driver, btnAddContactPreference), "Could not click on add more button", driver, className, methodName);
  						if(!selectValueFromAjaxList(driver, ajxContactPreference2, patientData.contactPreferences2))
  							Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences2);
  				
  				if(!patientData.contactPreferences4.isEmpty())
  					if(!patientData.contactPreferences4.contains("N/A"))
  						assertTrue(click(driver, btnAddContactPreference), "Could not click on add more button", driver, className, methodName);
  							if(!selectValueFromAjaxList(driver, ajxContactPreference4, patientData.contactPreferences4))
  								Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences4);

  				if(!patientData.sameAsResidentialAddressCheck.isEmpty()){
  					if(!patientData.sameAsResidentialAddressCheck.contains("No") && isChecked(driver, chkMailingAsResidential))
  						assertTrue(click(driver, chkMailingAsResidential), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck, driver, className, methodName);
  					
  						if(!patientData.mailingAddressStreet1.isEmpty())
  							if(!patientData.mailingAddressStreet1.contains("N/A"))
  								assertTrue(type(driver, txtMailingAddress1, patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1, driver, className, methodName);
  						if(!patientData.mailingAddressStreet2.isEmpty())
  							if(!patientData.mailingAddressStreet2.contains("N/A"))
  								assertTrue(type(driver, txtMailingAddress2, patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2, driver, className, methodName);
  						if(!patientData.mailingAddressCity.isEmpty())
  							if(!patientData.mailingAddressCity.contains("N/A"))
  								assertTrue(type(driver, txtMailingCity, patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity, driver, className, methodName);
  						if(!patientData.mailingAddressState.isEmpty())
  							if(!patientData.mailingAddressState.contains("N/A"))
  								selectValueFromAjaxList(driver, ajxMailingState, patientData.mailingAddressState);
  									
  						if(!patientData.mailingAddressZipcode.isEmpty())
  							if(!patientData.mailingAddressZipcode.contains("N/A"))
  								assertTrue(type(driver, txtMailingZip, patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode, driver, className, methodName);					
  						waitForPageLoad(driver);
  						driver.findElement(ajxPhoneType1).sendKeys(Keys.ENTER);
  						click(driver,btnYesButton);
  						waitForElementToEnable(driver,txtMailingCity);
  						waitForPageLoad(driver);
  						waitForElementToEnable(driver,ajxMailingState);
  						waitForPageLoad(driver);
  						waitForElementToEnable(driver,ajxMailingCountry);
  						waitForPageLoad(driver);
  						
  						
  				}
  				else{
  					if(!patientData.mailingAddressStreet1.isEmpty())
  						if(!patientData.mailingAddressStreet1.contains("N/A"))
  							assertTrue(type(driver, txtMailingAddress1, patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1, driver, className, methodName);
  					if(!patientData.mailingAddressStreet2.isEmpty())
  						if(!patientData.mailingAddressStreet2.contains("N/A"))
  							assertTrue(type(driver, txtMailingAddress2, patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2, driver, className, methodName);
  					if(!patientData.mailingAddressCity.isEmpty())
  						if(!patientData.mailingAddressCity.contains("N/A"))
  							assertTrue(type(driver, txtMailingCity, patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity, driver, className, methodName);
  					
  					if(!patientData.mailingAddressZipcode.isEmpty())
  						if(!patientData.mailingAddressZipcode.contains("N/A"))
  							assertTrue(type(driver, txtMailingZip, patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode, driver, className, methodName);
  					waitForPageLoad(driver);
  					driver.findElement(txtComments).sendKeys(Keys.ENTER);
  					click(driver,btnYesButton);
  					waitForElementToEnable(driver,txtMailingCity);
  					waitForPageLoad(driver);
  					waitForElementToEnable(driver,ajxMailingState);
  					waitForPageLoad(driver);
  					waitForElementToEnable(driver,ajxMailingCountry);
  					waitForPageLoad(driver);
  					waitForElementToEnable(driver,txtMailingCountry);
  					waitForPageLoad(driver);
  			
  				}*/
  				if(!patientData.comments.isEmpty())
  					if(!patientData.comments.contains("N/A"))
  						assertTrue(type(driver, txtComments, patientData.comments), "Could not Enter comments, Expected value to be Selected" + patientData.comments, driver, className, methodName);
  				
  				if(!patientData.testCaseId.equalsIgnoreCase("TC_NPC_009")){
  					click(driver,btnSave1);
  				}
  				waitForPageLoad(driver);
  			
  				waitForPageLoad(driver);	
  				if(isElementPresent(driver, btnErrorClose))
  					assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
  		        
  				
  				
  			}catch(RuntimeException e) {
  				e.printStackTrace();
  				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
  		}
  		return new DemographicsPage();
  	}

  		public PatientPersonalInfoPage createPatientWithMandatory(WebDriver driver, HomeLib patientData,String account) throws Exception{
  			String date=null;
  			String uniqueName = null;
  			if (account.contains("US")) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat DateFormat1 = new SimpleDateFormat("HH:mm:ss");
				
				date = DateFormat.format(cal.getTime());
				uniqueName =DateFormat1.format(cal.getTime());

			}else if(account.contains("CA")){
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat DateFormat1 = new SimpleDateFormat("HH:mm:ss");
			
				date = DateFormat.format(cal.getTime());
				uniqueName =DateFormat1.format(cal.getTime());
			}


  			try{
  				assertTrue(type(driver, txtFirstName, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName, driver, className, methodName);
  				if(patientData.testCaseId.equals("TC_NPC_001")){
  					 patientData.lastName =  patientData.lastName + uniqueName;
  				assertTrue(type(driver, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName, driver, className, methodName);
  				}else{
  					assertTrue(type(driver, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName, driver, className, methodName);
  					
  				}
				assertTrue(enterDate(driver, txtStatusDate,date ), "Could not Enter statusDate, For; More Details" + patientData.toString(), driver, className, methodName);
				assertTrue(click(driver, btnSave1),"could not click error close", driver, className,methodName);
				waitForPageLoad(driver);
  			}
  			catch(Exception e){
  				e.printStackTrace();
  				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
  			}
			return new PatientPersonalInfoPage();
  		}
  		public DemographicsPage createPatientWithDNC(WebDriver driver, HomeLib patientData,String account) throws Exception{
  			try{
  				String date=null;
  				assertTrue(type(driver, txtFirstName, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName, driver, className, methodName);
				assertTrue(type(driver, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName, driver, className, methodName);
				if (account.contains("CA")) {
  					Calendar cal = Calendar.getInstance();
  					SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
  					date = DateFormat.format(cal.getTime());

  				} else if(account.contains("US")) {
  					Calendar cal = Calendar.getInstance();
  					SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
  					date = DateFormat.format(cal.getTime());

  				}
				assertTrue(enterDate(driver, txtStatusDate,date ), "Could not Enter statusDate, For; More Details" + patientData.toString(), driver, className, methodName);
				if(!isChecked(driver,chkBoxForDNC))
				{
					assertTrue(click(driver,chkBoxForDNC),"could not click the do not disturb check box",driver,className,methodName);
				}
				assertTrue(click(driver, btnSave1),"could not click error close", driver, className,methodName);
				waitForPageLoad(driver);
  			}
  			catch(Exception e){
  				e.printStackTrace();
  				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
  			}
			return new DemographicsPage();
  		}
  		/**
		 * createNewPatientWithMandatory
		 * function to create New Patient With Mandatory
  		 * @param Driver
  		 * @param  patientData - Test Data
  		 * @Version 2.1
		 * @since Dec 16, 2014
		 */	
		public boolean createNewPatientWithMandatory(WebDriver driver, HomeLib patientData,String account) throws Exception{
			boolean returnValue = false;
			try{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("ddmmyyHHMMss");
				String uniqueName=DateFormat.format(cal.getTime());
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				assertTrue(type(driver,txtChartNumber,patientData.patientIdchart),"Could not Enter the chart number;More Details:"+patientData.toString(), driver, className, methodName);
						
				if(patientData.testCaseId.equals("TC_NPC_001")){
					patientData.lastName = patientData.lastName+uniqueName;
					assertTrue(type(driver,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), driver, className, methodName);
				}else
				assertTrue(type(driver,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), driver, className, methodName);
				
				assertTrue(type(driver,txtFirstName,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(),driver, className, methodName);
				assertTrue(enterDate(driver, txtDOB, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, driver, className, methodName);
				waitForPageLoad(driver);
				if(isElementPresent(driver,btnNoDuplicate))
				{
					click(driver,btnNoDuplicate);
				}
				click(driver,btnBack);
				waitForPageLoad(driver);
			//	assertTrue(selectValueFromAjaxList(driver,ajxStatus,patientData.status),"Could not click Status : More Details"+patientData.toString(), driver, className, methodName);
				/*assertTrue(click(driver,chkPremature),"Could not click prematurecheck box : More Details"+patientData.toString(), driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(type(driver,txtPrematureDuration,patientData.duration),"Could not enter duration : More Details"+patientData.toString(), driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(selectValueFromAjaxList(driver,ajxPrematureMeasure,patientData.measure),"Could not select premature Measure days:More Details"+patientData.toString(), driver, className, methodName);
				waitForPageLoad(driver);*/

				assertTrue(selectValueFromAjaxList(driver,ajxSex,patientData.sex),"Could not click sex list: More Details"+patientData.toString(), driver, className, methodName);
				Thread.sleep(3000);		
				assertTrue(click(driver,btnSave1),"Could not click Save button More Dateils"+patientData.toString(), driver, className, methodName);
				waitForPageLoad(driver);
			
				returnValue = true;	
				
				}
			catch(RuntimeException e) {
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
			}
			return returnValue;
		}
		
		public boolean gotoPayer(WebDriver driver)
  		{
  			assertTrue(click(driver,btnPayersList),"could not click the button Payer List",driver,className,methodName);
  			waitForPageLoad(driver);
  			assertTrue(click(driver,btnCancel),"Unable to click the cancel button",driver,className,methodName);
  			waitForPageLoad(driver);
  			assertTrue(click(driver,btnAddNew),"Could not click the Medical Payer", driver, className, methodName);
  			waitForPageLoad(driver);
   			return true;
  		}
		
		public boolean addNewPayer(WebDriver driver, HomeLib payerData,String account ) throws Exception
  		{
			String date=null;
			if (account.contains("CA")) {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
					date = DateFormat.format(cal.getTime());
			
			} else if(account.contains("US")) {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
					date = DateFormat.format(cal.getTime());
			}
			assertTrue(click(driver,btnMedicalPayersList),"Could not click the add new button Medical Payer", driver, className, methodName);
			waitForPageLoad(driver);
			assertTrue(selectValueFromAjaxList(driver,ajxPayerSelect,payerData.payerName),"Could not select payer"+ payerData.toString(), driver, className, methodName);
			assertTrue(enterDate(driver,txtPayerStartDate,date), "Could not enter start Date", driver, className, methodName);
			assertTrue(selectValueFromAjaxList(driver,ajxRelationShip,payerData.relationshipStatus),"Could not select Relationship Status"+ payerData.toString(), driver, className, methodName);
			waitForPageLoad(driver);
			assertTrue(click(driver, btnSaveNew), "Could not click Save button" +  payerData.toString(), driver, className, methodName);
   			return true;
  		}
		
  		public boolean verifyCancel(WebDriver driver)
  		{
  			assertTrue(click(driver,chkBoxForDNC),"could not click the do not disturb check box",driver,className,methodName);
  			waitForPageLoad(driver);
  			assertTrue(click(driver,btnCancel),"Unable to click the cancel button",driver,className,methodName);
  			waitForPageLoad(driver);
  			DemographicsPage demographicsPage=new DemographicsPage();
  			demographicsPage.verifyDoNotDisturbStatusDemographicsPage(driver);
  			return true;
  		}
  		
  		public PatientPersonalInfoPage verifyCancelButtonOnPatientRegPage(WebDriver driver)
  		{
  			assertTrue(click(driver,chkBoxForDNC),"could not click the do not disturb check box",driver,className,methodName);
  			waitForPageLoad(driver);
  			assertTrue(click(driver,btnCancel),"Unable to click the cancel button",driver,className,methodName);
  			waitForPageLoad(driver);
  			return new PatientPersonalInfoPage();
  		}
}
