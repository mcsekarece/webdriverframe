package com.nexia.selenium.genericlibrary.demographics;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.Assert;

import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;

import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class AbstractHomeTest extends DemographicsPageFactoring {


	public String btnNoDuplicate = "notDuplicateButton";
	public String lnkQuickLink = "link=Quick Actions";
	public String lnkSystemSettings1 = "link=Settings";
	public String lblProgramTitleList = "xpath=(//*[contains(@id,'programListItemTitle')])" ;
	public String btnContinue="Continue";
	public String lnkSystemSettingLink="systemSettingsAction";
	public String lnkSystemSettings = "systemSettings";  	
	public String lnkAdminMandatory="!adminMandatoryUserField";
	public String ajxSwitchrole1="xpath=(//input[@id='suggestBox'])[2]";
	public String lnkLocationMenuHeader = "locationMenuHeader";
	public String otherPayersDeleteBtn="deleteAnchor0";
	public String noDuplicationBtn="notDuplicateButton";
	public String lnkRegisterPatient="newPatientAction";
	public String lnkLeftPatientInfoPanel="patientTableLeft";
	public String lnkLeftSocioEconomicPanel="socioEconomicPanelLeft";
	public String lnkRightPatientInfoPanel="patientTableRight";
	public String lnkRightSocioEconomicPanel="socioEconomicPanelRight";
	public String lnkEditButton="editAnchor";
	public String lnkLastUpdatedRight="updatedStampRight";
	public String lnkLastUpdatedLeft="updatedStampLeft";
	
	public String moreLinkForUserRole="AdminUserRoleListMoreLink";
	public String rdoPatientIdRight="xpath=(//input[contains(@id,'rbChart2')])[1]";
	public String rdopatientIdLeft="xpath=(//input[contains(@id,'rbChart1')])[1]";
	
	public String chkIncludeInactiveBox="includeInactivescheckbox";
	public String closeSearchResultPopup="searchClose";
	public String patientSearchWidget="patientInfoWidget";
	

	public String chkprematurecheckbox="prematurecheckbox";
	public String ajxPrematureMeasurement="prematureMeasureUnitSuggestBoxsuggestBox";
	public String txtDob="dob";
	public String editButton="edit";
	public String btnBack1="backButton";
	public String btnPatientSave="saveButton";
	public String socioEconomicBtn="id=!patientSocialHistory";
	
	
	public String lnkUserRole="!adminUserRoleList";
	public String lnkSecuritySettingAction="securitySettingsAction";
	
	public String addNewBtn="addIdentifierType";
	public String txtBoxUserRoleName="userRoleName";
	public String txtBoxUserRoleDescription="description";
	public String ajxListHomePageView="homePageViewsuggestBox";
	public String btnSave="save";
	public String chkBoxSystemSettings="chk4SystemSettingscheckbox";
	public String chkBoxChartManagement="chk4ChartManagementcheckbox";
	
	public String showMoreAction="css=a.dropdown-item.show-more > span";
	public String lnkClinicalSettings="clinicalSettingsAction";
	public String lnkOrderTemplate="!labTemplates";
	public String lnkPracticePreference = "!practicePreferences";
	public String lblCode = "icdLabel";
	public String btnEditPracticePreferences = "editPracticePreferences";
	public String rdoICD = "ICD(ONT)radio";
	public String addNewOrder="css=div.add-button";
	public String txtTemplateName="templateName";
	public String txtSectionName="sectionName0";
	public String txtTestName="testName0";
	public String BtnNextButton="nextButton";
	public String chkTestPreview="//span/input";
	public String btnDone="doneButton";
	public String textMessage="mergeManageText";
	public String mergeHint="mergeManageHint";
	public String mergeChartText="mergeChartText";
	public String patientId="patientIDLabel1";
	public String patientPersonalInfo="patDetailsTitleLeft";
	public String patientSocioInfo="socioEconomicTitleLeft";
	
	//FIXME VEL-8005
	public String btnSaveCode = "css=button.primary-button";
	
	/**
	 * goToNewPatientCheckIn
	 * function to navigate to new patient check in page
	 * @throws IOException 
	 * @since  	     Feb 08, 2012
	 */	
	 public boolean goToNewPatientCheckIn(Selenium selenium) throws IOException {
		 
		 
		assertTrue(click(selenium, lnkQuickLink), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkRegisterPatient), "Could not click on Register patient", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium, btnSave1))
			return true;
		else
			return false;
		
	 
	 }
	 
	 /**
		 * associatePayer
		 * function to navigate to new patient check in page
		 * @throws IOException 
		 * @since  Sep 02, 2012
		 */	
		 public boolean associateOHIPPayer(Selenium selenium,String providerName) throws IOException {
			 
			 if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			String districtOffice="Kingston";
			assertTrue(click(selenium, lnkQuickLink), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkShowMoreLink),"Could not click show more link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingAction),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtSearchProvider,providerName),"Could nottype provider;More Deatils:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,txtSearchButton),"Could not click the systemSettings link;More Deatils:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lblFirstProvider),"Could not type search providerk;More Deatils:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(selenium.isTextPresent("OHIP")){
				return true;
			}
			
			else{
			assertTrue(click(selenium,btnAddNewPayer),"Could not click on Add new payer;More Deatils:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium, ajxPayerSuggestBox,"OHIP"),"Select Failed",selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxDistrict,districtOffice),"Select Failed",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtBilling,"123"),"Select Failed",selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Save button is not found",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			}
			
			if(selenium.isTextPresent("OHIP")){
				return true;
			}
			else{
				return false;
			}
		 
		 }
	 
	 
	
	 /**
		 * searchPatientNexiaForProviderHomePage
		 * function for Searching a patient in the Nexia application   
		 * @param 		selenium
		 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
		 
		 * @since  	    Sep 29, 2012
		 */
		public boolean searchPatientNexiaForHomePage(Selenium selenium,String lastName) throws IOException{
			
			boolean returnValue = false;
			assertTrue(type(selenium,txtSearchPatientBox,lastName),"Could not type patient id", selenium, ClassName, MethodName);
		
			selenium.clickAt(txtSearchPatientBox,"");
			selenium.focus(txtSearchPatientBox);			
			selenium.fireEvent(txtSearchPatientBox,"keypress");	
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForElement(selenium,lblPatientBorderBottom,10000);
			//Assert.assertTrue(selenium.isElementPresent(lblPatientBorderBottom),"Search Results are not displayed for the patient with ID :-"+lastName);
			System.out.println(getText(selenium,lblPatientBorderBottom));
			if (!getText(selenium,lblPatientBorderBottom).contains(lastName)){
				returnValue=true;
				System.out.println("Patient with lastName " + lastName + " Not created,  create a new one");
			}else{			
				System.out.println("Patient with lastname " + lastName + " is already created, No More Work");				
				returnValue = false;
			}
			return returnValue;
		}	

		/**
		 * createPatient
		 * function to create a new patient check-in
		 * @throws IOException 
		 * @since  	     Feb 09, 2012
		 */	
			public boolean createPatient(Selenium selenium, HomeLib patientData,String account) throws IOException{
				boolean returnValue = false;
				String date="";
				try{
					if(!patientData.patientIdchart.isEmpty())
						if(!patientData.patientIdchart.contains("N/A"))
							assertTrue(type(selenium,txtChartNumber,patientData.patientIdchart),"Could not Enter the patientId chart, Expected value to be typed" + patientData.patientIdchart, selenium, ClassName, MethodName );
					if(!patientData.primaryLocation.isEmpty())
						if(!patientData.primaryLocation.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxPrimaryLocation, patientData.primaryLocation))
								Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.primaryLocation);
					if(!patientData.responsibleProvider.isEmpty())
						if(!patientData.responsibleProvider.contains("N/A"))
							if(!selectValueFromAjaxList(selenium,ajxResponsbleProvider,patientData.responsibleProvider))
								Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.responsibleProvider);
					waitForPageLoad(selenium);
					if(!patientData.pcpCheck.isEmpty())
						if(!patientData.pcpCheck.contains("No"))
							if(!selenium.isChecked(chkResponsibleProvider))
								assertTrue(check(selenium, chkResponsibleProvider), "Could not check the pcp check box, Expected value for the check box : " + patientData.pcpCheck, selenium, ClassName, MethodName);
					
					if(!patientData.lastName.isEmpty())
						if(!patientData.lastName.contains("N/A"))
							assertTrue(type(selenium, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName, selenium, ClassName, MethodName);
					if(!patientData.firstName.isEmpty())
						if(!patientData.firstName.contains("N/A"))
							assertTrue(type(selenium, txtFirstName, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName, selenium, ClassName, MethodName);
					if(!patientData.middleName.isEmpty())
						if(!patientData.middleName.contains("N/A"))
							assertTrue(type(selenium, txtMiddleName, patientData.middleName), "Could not Enter middle name, Expected value to be typed" + patientData.middleName, selenium, ClassName, MethodName);
					if(!patientData.title.isEmpty())
						if(!patientData.title.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxTitle, patientData.title))	
								Assert.fail("Could not Enter Title, Expected value to be selected" + patientData.title);
					if(!patientData.suffix.isEmpty())
						if(!patientData.suffix.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxSuffix, patientData.suffix))
								Assert.fail("Could not Enter Suffix, Expected value to be selected" + patientData.suffix);
					if(!patientData.alias1.isEmpty())
						if(!patientData.alias1.contains("N/A"))
							assertTrue(type(selenium, txtAlias1, patientData.alias1), "Could not Enter alias1, Expected value to be typed" + patientData.alias1, selenium, ClassName, MethodName);
					if(!patientData.alias2.isEmpty())
						if(!patientData.alias2.contains("N/A"))
							assertTrue(type(selenium, txtAlias2, patientData.alias2), "Could not Enter alias2, Expected value to be typed" + patientData.alias2, selenium, ClassName, MethodName);
					if(!patientData.dob.isEmpty())
						if(!patientData.dob.contains("N/A"))
							assertTrue(enterDate(selenium, txtDOB, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName, MethodName);			
					click(selenium,btnBack);
					if(!patientData.estimatedCheck.isEmpty())
						if(!patientData.estimatedCheck.contains("No") && !isChecked(selenium, chkDOBEstimated))
							assertTrue(click(selenium, chkDOBEstimated), "Could not check the estimated check box, Expected value for the check box : " + patientData.estimatedCheck, selenium, ClassName, MethodName);
					        waitForPageLoad(selenium);
					if(!patientData.prematureCheck.isEmpty())
						if(!patientData.prematureCheck.contains("No") && !isChecked (selenium, chkPremature)){
							assertTrue(click(selenium, chkPremature), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck, selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
							if(!patientData.duration.isEmpty())
								if(!patientData.duration.contains("N/A"))
									assertTrue(type(selenium, txtPrematureDuration, patientData.duration), "Could not Enter duration, Expected value to be typed : " + patientData.duration, selenium, ClassName, MethodName);
							        waitForPageLoad(selenium);
							if(!patientData.measure.isEmpty())
								if(!patientData.measure.contains("N/A"))
									if(!selectValueFromAjaxList(selenium, ajxPrematureMeasure, patientData.measure))
										Assert.fail("Could not Enter Premature Messure, Expected value to be selected" + patientData.measure);
										waitForPageLoad(selenium);
						}
					if(!patientData.sex.isEmpty())
						if(!patientData.sex.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxSex, patientData.sex))
								Assert.fail("Could not Enter Sex, Expected value to be selected" + patientData.sex);
								waitForPageLoad(selenium);
					if(!patientData.maritalStatus.isEmpty())
						if(!patientData.maritalStatus.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxmartialStatus, patientData.maritalStatus))
								Assert.fail("Could not Enter Marital Status, Expected value to be selected" + patientData.maritalStatus);					
					if(!patientData.status.isEmpty())
						if(!patientData.status.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxStatus, patientData.status))
								Assert.fail("Could not Enter Status, For; More Details" + patientData.toString());
					
					
					if (account.equals(CAAccount)) {
						Calendar cal = Calendar.getInstance();
						SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
						date = DateFormat.format(cal.getTime());

					} else if(account.equals(USAccount)) {
						Calendar cal = Calendar.getInstance();
						SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
						date = DateFormat.format(cal.getTime());

					}
					if(!patientData.statusDate.isEmpty())
						if(!patientData.statusDate.contains("N/A"))
							assertTrue(enterDate(selenium, txtStatusDate,date ), "Could not Enter statusDate, For; More Details" + patientData.toString(), selenium, ClassName, MethodName);
					if(patientData.status.equalsIgnoreCase("inactive"))
						if(!patientData.reasonForInactivation.isEmpty())
							if(!patientData.reasonForInactivation.contains("N/A"))
								if(!selectValueFromAjaxList(selenium, ajxStationInactivation, patientData.reasonForInactivation))
									Assert.fail("Could not Enter reason for inactivation, For; More Details" + patientData.maritalStatus);					
					if(!patientData.residentialAddrStreet1.isEmpty())
						if(!patientData.residentialAddrStreet1.contains("N/A"))
							assertTrue(type(selenium, txtResidentAddress1, patientData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + patientData.residentialAddrStreet1, selenium, ClassName, MethodName);
					if(!patientData.residentialAddrStreet2.isEmpty())
						if(!patientData.residentialAddrStreet2.contains("N/A"))
							Assert.assertTrue(type(selenium, txtResidentAddress2, patientData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + patientData.residentialAddrStreet2);
					if(!patientData.residentialAddrcity.isEmpty())
						if(!patientData.residentialAddrcity.contains("N/A"))
							assertTrue(type(selenium, txtResidentialCity, patientData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + patientData.residentialAddrcity, selenium, ClassName, MethodName);
					if(!patientData.residentialAddrstate.isEmpty())
						if(!patientData.residentialAddrstate.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxResidentialState, patientData.residentialAddrstate))
								Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.residentialAddrstate);
					if(!patientData.residentialAddrzipCode.isEmpty())
						if(!patientData.residentialAddrzipCode.contains("N/A"))
							assertTrue(type(selenium, txtResidentialZip, patientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCode, selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					selenium.keyPress(ajxPhoneType1, "\\9");
					click(selenium,btnYesButton);
					waitForElementToEnable(selenium,txtResidentialCity);
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,ajxResidentialState);
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,ajxResidentialCountry);
					waitForPageLoad(selenium);
					
					
					if(!patientData.telephoneType1.isEmpty())
						if(!patientData.telephoneType1.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxPhoneType1, patientData.telephoneType1))
								Assert.fail("Could not Enter Telephone Type1, Expected value to be Select" + patientData.telephoneType1);
					if(!patientData.telephoneNo1.isEmpty())
						if(!patientData.telephoneNo1.contains("N/A"))
							//Assert.assertTrue(type(selenium, txtPrimaryPhone, patientData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo1);
							selenium.type(txtPrimaryPhone,  patientData.telephoneNo1);
					if(!patientData.telephoneextnNo1.isEmpty())
						if(!patientData.telephoneextnNo1.contains("N/A"))
							assertTrue(type(selenium, txtPrimaryPhoneExtn, patientData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo1, selenium, ClassName, MethodName);
					if(!patientData.telephoneType2.isEmpty())
						if(!patientData.telephoneType2.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxPhoneType2, patientData.telephoneType2))
								Assert.fail("Could not Enter Telephone Type2, Expected value to be Select" + patientData.telephoneType2);
					if(!patientData.telephoneNo2.isEmpty())
						if(!patientData.telephoneNo2.contains("N/A"))
							assertTrue(type(selenium, txtOtherPhone1, patientData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo2, selenium, ClassName, MethodName);
					if(!patientData.telephoneextnNo2.isEmpty())
						if(!patientData.telephoneextnNo2.contains("N/A"))
							assertTrue(type(selenium, txtOtherPhone1Extn, patientData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo2, selenium, ClassName, MethodName);
					
					if(!patientData.telephoneType3.isEmpty())
						if(!patientData.telephoneType3.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxPhoneType3, patientData.telephoneType3))
								Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.telephoneType3);
					
					if(!patientData.telephoneNo3.isEmpty())
						if(!patientData.telephoneNo3.contains("N/A"))
							assertTrue(type(selenium, txtOtherPhone2, patientData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo3, selenium, ClassName, MethodName);
					if(!patientData.telephoneextnNo3.isEmpty())
						if(!patientData.telephoneextnNo3.contains("N/A"))
							assertTrue(type(selenium, txtOtherPhone2Extn, patientData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneNo3, selenium, ClassName, MethodName);
					
					if(!patientData.email.isEmpty())
						if(!patientData.email.contains("N/A"))
							assertTrue(type(selenium, txtEmail, patientData.email), "Could not Enter email, Expected value to be Typed" + patientData.email, selenium, ClassName, MethodName);
					
					if(!patientData.contactPreferences.isEmpty())
						if(!patientData.contactPreferences.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxContactPreference, patientData.contactPreferences))
								Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences);
					
					if(!patientData.contactPreferences1.isEmpty())
						if(!patientData.contactPreferences1.contains("N/A"))
							assertTrue(click(selenium, btnAddContactPreference), "Could not click on add more button", selenium, ClassName, MethodName);
							if(!selectValueFromAjaxList(selenium, ajxContactPreference1, patientData.contactPreferences1))
								Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences1);
					
					if(!patientData.contactPreferences2.isEmpty())
						if(!patientData.contactPreferences2.contains("N/A"))
							assertTrue(click(selenium, btnAddContactPreference), "Could not click on add more button", selenium, ClassName, MethodName);
							if(!selectValueFromAjaxList(selenium, ajxContactPreference2, patientData.contactPreferences2))
								Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences2);
					
					if(!patientData.contactPreferences4.isEmpty())
						if(!patientData.contactPreferences4.contains("N/A"))
							assertTrue(click(selenium, btnAddContactPreference), "Could not click on add more button", selenium, ClassName, MethodName);
								if(!selectValueFromAjaxList(selenium, ajxContactPreference4, patientData.contactPreferences4))
									Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences4);

					if(!patientData.sameAsResidentialAddressCheck.isEmpty()){
						if(patientData.sameAsResidentialAddressCheck.contains("Yes"))
						{
							if(!isChecked(selenium, chkMailingAsResidential))
							{
							assertTrue(click(selenium, chkMailingAsResidential), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck, selenium, ClassName, MethodName);
							}
						}
					   else
					    {
						   if(isChecked(selenium, chkMailingAsResidential))
							{
							assertTrue(click(selenium, chkMailingAsResidential), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck, selenium, ClassName, MethodName);
							}
						if(!patientData.mailingAddressStreet1.isEmpty())
							if(!patientData.mailingAddressStreet1.contains("N/A"))
								assertTrue(type(selenium, txtMailingAddress1, patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1, selenium, ClassName, MethodName);
						if(!patientData.mailingAddressStreet2.isEmpty())
							if(!patientData.mailingAddressStreet2.contains("N/A"))
								assertTrue(type(selenium, txtMailingAddress2, patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2, selenium, ClassName, MethodName);
						if(!patientData.mailingAddressCity.isEmpty())
							if(!patientData.mailingAddressCity.contains("N/A"))
								assertTrue(type(selenium, txtMailingCity, patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity, selenium, ClassName, MethodName);
						
						if(!patientData.mailingAddressZipcode.isEmpty())
							if(!patientData.mailingAddressZipcode.contains("N/A"))
								assertTrue(type(selenium, txtMailingZip, patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode, selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						selenium.keyPress(txtComments, "\\9");
						click(selenium,btnYesButton);
						waitForElementToEnable(selenium,txtMailingCity);
						waitForPageLoad(selenium);
						waitForElementToEnable(selenium,ajxMailingState);
						waitForPageLoad(selenium);
						waitForElementToEnable(selenium,ajxMailingCountry);
						waitForPageLoad(selenium);
						waitForElementToEnable(selenium,txtMailingCountry);
						waitForPageLoad(selenium);
				
					}
					}
					if(!patientData.comments.isEmpty())
						if(!patientData.comments.contains("N/A"))
							assertTrue(type(selenium, txtComments, patientData.comments), "Could not Enter comments, Expected value to be Selected" + patientData.comments, selenium, ClassName, MethodName);
					
					if(!patientData.testCaseId.equalsIgnoreCase("TC_NPC_009")){
						click(selenium,btnSave1);
					}
					waitForPageLoad(selenium);
					returnValue = true;	
					waitForPageLoad(selenium);	
					if(isElementPresent(selenium, btnErrorClose))
						assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			        
					
					
					}catch(RuntimeException e) {
					e.printStackTrace();
					Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
			}
			return returnValue;
		}

			/**
			 * checkTheRadioButtonsInMergedCharts1
			 * function to verify Radio buttons in the Merged chart 1
			 * @throws IOException 

			 * @since Nov 03, 2014
			 */
       public boolean clickTheRadioButtonsInMergedChartsLeft(Selenium selenium)throws IOException
       {
    	   int buttonCount=1,i=2;
    	   String radioButton="xpath=(//input[contains(@id,'rbChart1')])[";
    	   while(isElementPresent(selenium,radioButton+buttonCount+"]"))
    	   {
    		   buttonCount=buttonCount+1;
    	   }
    	   assertTrue(click(selenium,rdoPatientIdRight),"Unable to click the patient ID",selenium,ClassName,MethodName);
    	   if(buttonCount!=1){
    	   while(i<buttonCount)
    	   {
    		assertTrue(!isChecked(selenium,radioButton+i+"]"),"Checked box :"+i+" defaulty checked",selenium,ClassName,MethodName);
    	    assertTrue(click(selenium,radioButton+i+"]"),"Unable to click the radio button:"+i,selenium,ClassName,MethodName);
    	    i=i+1;
    	   }
    	   }
    	   return true;
       }

       /**
		 * checkTheRadioButtonsInMergedCharts2
		 * function to verify Radio buttons in the Merged chart 2
		 * @throws IOException 

		 * @since 	 Nov 03, 2014
		 */
       public boolean clickTheRadioButtonsInMergedChartsRight(Selenium selenium)throws IOException
       {
    	   int buttonCount=1,i=2;
    	   String radioButton="xpath=(//input[contains(@id,'rbChart2')])[";
    	   while(isElementPresent(selenium,radioButton+buttonCount+"]"))
    	   {
    		   buttonCount=buttonCount+1;
    	   }
    	   assertTrue(click(selenium,rdopatientIdLeft),"Unable to click the patient ID",selenium,ClassName,MethodName);
    	   if(buttonCount!=1){
    	   while(i<buttonCount)
    	   {
    		assertTrue(!isChecked(selenium,radioButton+i+"]"),"Checked box :"+i+" defaulty checked",selenium,ClassName,MethodName);
    	    assertTrue(click(selenium,radioButton+i+"]"),"Unable to click the radio button:"+i,selenium,ClassName,MethodName);
    	    i=i+1;
    	   }
    	   }
    	   return true;
       }
       
       public boolean verifyMergedChartPage(Selenium selenium,String userAccount)throws IOException
		{
			assertTrue(isElementPresent(selenium,lnkRightPatientInfoPanel),"Unable to find the right side personal info panel",selenium,ClassName,MethodName);
			assertTrue(isElementPresent(selenium,lnkRightSocioEconomicPanel),"Unable to find the right side socio economic panel",selenium,ClassName,MethodName);
			assertTrue(isElementPresent(selenium,lnkLeftPatientInfoPanel),"Unable to find the left side personal info panel",selenium,ClassName,MethodName);
			assertTrue(isElementPresent(selenium,lnkLeftSocioEconomicPanel),"Unable to find the left side socio economic panel",selenium,ClassName,MethodName);
			char[] userName=getText(selenium,"username").toCharArray();
			int value=1,i=0;
			do{
				value++;
			}while(userName[value]!=',');
			String user="",date="";
			while(i<value)
			{
				user=user+userName[i];
				i++;
			}
			System.out.println(user);
			assertTrue(getText(selenium,lnkLastUpdatedRight).contains(user),"UserName not present in the last updated value",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkLastUpdatedLeft).contains(user),"UserName not present in the last updated value",selenium,ClassName,MethodName);
			 if(userAccount.equals(CAAccount)){
	    			Calendar cal=Calendar.getInstance();
	    			SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
	    			 date=DateFormat.format(cal.getTime());
	    		}else{
	    			Calendar cal=Calendar.getInstance();
	    			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
	    			 date=DateFormat.format(cal.getTime());
	    			}
			assertTrue(getText(selenium,lnkLastUpdatedRight).contains(date),"Updatd date is not present in the last updated value",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkLastUpdatedLeft).contains(date),"Updatd date is  not present in the last updated value",selenium,ClassName,MethodName);
			return true;
		}
		/**
		 * verifyCenterTextAfterSelectRadioBtnRight
		 * function to verify the text in the middle if the radio button selected is right
		 * @throws IOException 

		 * @since 	 Nov 04, 2014
		 */
       public boolean verifyCenterTextAfterSelectRadioBtnRight(Selenium selenium)throws IOException
		{
			int dataCount=0,i=2,radioButtonCount=1;
	        String radioButton="xpath=(//input[contains(@id,'rbChart2')])[%S]";
			String rightSideChartData="chart2_";
			String centerText="mergedChartValue_";
			 while(isElementPresent(selenium,String.format(radioButton,radioButtonCount)))
	           {
	        	   dataCount++;
	        	   radioButtonCount++;
	           } 
	    	   if(dataCount!=0)
	        	{
	           while(i<=dataCount)
	        	{
	        	   assertTrue(getText(selenium,rightSideChartData+i).trim().equalsIgnoreCase(getText(selenium,centerText+i).trim()),"center text"+i+"not matched",selenium,ClassName,MethodName);	
	        	   i++; 
	        	}
	        	}
			return true;
		}
		
		
		/**
		 * verifyCenterTextAfterSelectRadioBtnLeft
		 * function to verify the text in the middle if the radio button selected is left
		 * @throws IOException 

		 * @since 	 Nov 04, 2014
		 *
		 **/
       public boolean verifyCenterTextAfterSelectRadioBtnLeft(Selenium selenium)throws IOException
		{
			int dataCount=0,i=2,radioButtonCount=1;
	        String radioButton="xpath=(//input[contains(@id,'rbChart2')])[%S]";
			String rightSideChartData="chart1_";
			String centerText="mergedChartValue_";
			 while(isElementPresent(selenium,String.format(radioButton,radioButtonCount)))
	           {
	        	   dataCount++;
	        	   radioButtonCount++;
	           } 
	    	   if(dataCount!=0)
	        	{
	           while(i<=dataCount)
	        	{
	        	   assertTrue(getText(selenium,rightSideChartData+i).trim().equalsIgnoreCase(getText(selenium,centerText+i).trim()),"center text"+i+"not matched",selenium,ClassName,MethodName);	
	        	   i++; 
	        	}
	        	}
			return true;
		}
		
		
		/**
		 * verifyMergedChartPage
		 * function to verify Page the Merged Chart patient search page
		 * @throws IOException 

		 * @since 	 Nov 03, 2014
		 */
		public boolean verifyMergedChartLoadConflictData(Selenium selenium)throws IOException
        {
           int dataCount=0,i=1,radioButtonCount=1;
           String radioButton="xpath=(//input[contains(@id,'rbChart2')])[%S]";
           String leftSideChartData="chart1_";
           String rightSideChartData="chart2_";
           while(isElementPresent(selenium,String.format(radioButton,radioButtonCount)))
           {
        	   dataCount++;
        	   radioButtonCount++;
           }
        	if(dataCount!=0)
        	{
           while(i<=dataCount)
        	{
        	   assertTrue(!getText(selenium,leftSideChartData+i).trim().equals(getText(selenium,rightSideChartData+i).trim()),"Value matched in the chart 1 and  2",selenium,ClassName,MethodName);	
        	   i++;
        	}
        	}
        	return true;
        }
        /**
		 * lastUpdateDateCheckInMergedChart
		 * function to verify the last updated date in Merge Charts
		 * @throws IOException 

		 * @since 	 Nov 04, 2014
		 */
		public boolean lastUpdateDateCheckInMergedChart(Selenium selenium,String userAccount)throws IOException
        {
        	String date;
        	int dataCount=0,i=1,radioButtonCount=1;
        	String radioButton="xpath=(//input[contains(@id,'rbChart2')])[%S]";
        	String lastUpdatedDateLeft="lastUpdated1_";
        	String lastUpdatedDateRight="lastUpdated2_";
        	while(isElementPresent(selenium,String.format(radioButton,radioButtonCount)))
            {
         	   dataCount++;
         	   radioButtonCount++;
            }
        	
            if(userAccount.equals(CAAccount)){
    			Calendar cal=Calendar.getInstance();
    			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
    			 date=DateFormat.format(cal.getTime());
    		}else{
    			Calendar cal=Calendar.getInstance();
    			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
    			 date=DateFormat.format(cal.getTime());
    			}
            if(dataCount!=0)
            {
            	 while(i<=dataCount)
             	{
            		 assertTrue(getText(selenium,lastUpdatedDateLeft+i).trim().contains(date.trim()),"Left side last updated date-"+i+"is wrong",selenium,ClassName,MethodName);
             	i++;
             	}
            	 i=1;
            	 while(i<=dataCount)
              	{
             		 assertTrue(getText(selenium,lastUpdatedDateRight+i).trim().contains(date.trim()),"Right side last updated date-"+i+"is wrong",selenium,ClassName,MethodName);
              	i++;
              	} 
            }
      
			return true;
        }
        /**
		 * verifyPatientChartAfterMergeTheData
		 * function to verify the patient data after merging of charts
		 * @throws IOException 

		 * @since 	 Nov 03, 2014
		 */
       public boolean verifyPatientChartAfterMergeTheData(Selenium selenium,HomeLib patientData)throws IOException
       {
    	   assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.lastName.toUpperCase()),"last name not found",selenium,ClassName,MethodName);
    	   assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.firstName.toUpperCase()),"first name not found",selenium,ClassName,MethodName);
    	   assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.middleName),"middle name not found",selenium,ClassName,MethodName);
    	   assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.sex),"sex not found",selenium,ClassName,MethodName);
    	   assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.status),"status not found",selenium,ClassName,MethodName);
    	   assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.residentialAddrStreet1),"residential address 1 not found",selenium,ClassName,MethodName);
    	   assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.residentialAddrStreet2),"residential address 2 not found",selenium,ClassName,MethodName);
    	   assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.residentialAddrcity),"residential city not found",selenium,ClassName,MethodName);
    	   assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.telephoneType1),"phone type 1 not found",selenium,ClassName,MethodName);
    	   //assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.telephoneNo1),"phone number 1 not found",selenium,ClassName,MethodName);
    	   assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.telephoneextnNo1),"phone number extension 1 not found",selenium,ClassName,MethodName);
    	   assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.telephoneType2),"phone type 2 not found",selenium,ClassName,MethodName);
    	   //assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.telephoneNo2),"phone number 2 not found",selenium,ClassName,MethodName);
    	   assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.telephoneextnNo2),"phone number extension 2 not found",selenium,ClassName,MethodName);
    	   assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.email),"email not found",selenium,ClassName,MethodName);
    	   assertTrue(getText(selenium,lnkLeftPatientInfoPanel).contains(patientData.comments),"comments not found",selenium,ClassName,MethodName);
    	   return true;
       }
       
       
       /**
		 * verifyPatientChartAfterMergeTheDatawithSocioEconomic
		 * function to verify the patient data after merging of charts with socio Economic data
		 * @throws IOException 

		 * @since 	 Nov 11, 2014
		 */
      public boolean verifyPatientChartAfterMergeTheDatawithSocioEconomic(Selenium selenium,HomeLib patientData)throws IOException
      {
   	   assertTrue(getText(selenium,lnkLeftSocioEconomicPanel).contains(patientData.ethnicity),"ethnicity  not found",selenium,ClassName,MethodName);
   	   assertTrue(getText(selenium,lnkLeftSocioEconomicPanel).contains(patientData.religion),"religion  not found",selenium,ClassName,MethodName);
       assertTrue(getText(selenium,lnkLeftSocioEconomicPanel).toLowerCase().contains(patientData.citizenship.toLowerCase()),"citizenship not found",selenium,ClassName,MethodName);
       assertTrue(getText(selenium,lnkLeftSocioEconomicPanel).contains(patientData.studentStatus),"Student Status not found",selenium,ClassName,MethodName);
       assertTrue(getText(selenium,lnkLeftSocioEconomicPanel).contains(patientData.educationLevel),"Education Level not found",selenium,ClassName,MethodName);
       assertTrue(getText(selenium,lnkLeftSocioEconomicPanel).contains(patientData.householdIncome),"householdIncome  not found",selenium,ClassName,MethodName);
   	   return true;
      }
       
       
        /**
		 * verifyClearFieldInPatientInfo
		 * function to verify whether Empty fields exists .
		 * @throws IOException 

		 * @since 	 Jun 15, 2012
		 */	
		public boolean verifyClearFieldInPatientInfo(Selenium selenium, HomeLib patientData) throws IOException{
			boolean returnValue = false;
			try{
			waitForPageLoad(selenium);
			if(!patientData.primaryLocation.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, ajkSuggestBox, patientData.primaryLocation);
			
			waitForPageLoad(selenium);
			if(!patientData.responsibleProvider.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium,ajxResponsbleProvider,patientData.responsibleProvider);
					
			
			if(!patientData.pcpCheck.contains("No"))
				assertTrue(check(selenium, chkResponsibleProvider), "Could not check the pcp check box, Expected value for the check box : " + patientData.pcpCheck, selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
			
			if(!patientData.lastName.contains("N/A"))
				assertTrue(type(selenium, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName, selenium, ClassName, MethodName);
			
			if(!patientData.firstName.contains("N/A"))
				assertTrue(type(selenium, txtFirstName, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName, selenium, ClassName, MethodName);
			
			if(!patientData.middleName.contains("N/A"))
				assertTrue(type(selenium, txtMiddleName, patientData.middleName), "Could not Enter middle name, Expected value to be typed" + patientData.middleName, selenium, ClassName, MethodName);
			
			if(!patientData.title.contains("N/A"))
				click(selenium,ajxTitle);
				selectEmptyValueFromAjaxList(selenium, ajxTitle, patientData.title);							
				
			              
			if(!patientData.suffix.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, ajxSuffix, patientData.suffix);
					
			
			if(!patientData.alias1.contains("N/A"))
				assertTrue(type(selenium, txtAlias1, patientData.alias1), "Could not Enter alias1, Expected value to be typed" + patientData.alias1, selenium, ClassName, MethodName);
			
			if(!patientData.alias2.contains("N/A"))
				assertTrue(type(selenium, txtAlias2, patientData.alias2), "Could not Enter alias2, Expected value to be typed" + patientData.alias2, selenium, ClassName, MethodName);
			
			if(!patientData.dob.contains("N/A"))
				assertTrue(enterDate(selenium, txtDOB, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName, MethodName);			
			click(selenium,btnBack);
			if(!patientData.estimatedCheck.contains("No"))
				assertTrue(check(selenium, chkDOBEstimated), "Could not check the estimated check box, Expected value for the check box : " + patientData.estimatedCheck, selenium, ClassName, MethodName);
			
			if(!patientData.prematureCheck.contains("No"))
			{
				if(!isChecked(selenium,chkPremature))
				{
					assertTrue(click(selenium,chkPremature), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck, selenium, ClassName, MethodName);
					
					if(!patientData.duration.contains("N/A"))
						selectEmptyValueFromAjaxList(selenium,"prematureDurationsuggestBox", patientData.duration);
					
					if(!patientData.measure.contains("N/A"))
						selectEmptyValueFromAjaxList(selenium, ajxPrematureMeasure, patientData.measure);
				}			
			}
			
			if(!patientData.sex.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, ajxSex, patientData.sex);
					
			
			if(!patientData.maritalStatus.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, ajxmartialStatus, patientData.maritalStatus);
									
			
			if(!patientData.status.contains("N/A"))
				selectValueFromAjaxList(selenium, ajxStatus, patientData.status);
					
			
			if(!patientData.statusDate.contains("N/A"))
				assertTrue(enterDate(selenium, txtStatusDate, patientData.statusDate), "Could not Enter statusDate, For; More Details" + patientData.toString(), selenium, ClassName, MethodName);
			if(patientData.status.equalsIgnoreCase("inactive"))
				
				if(!patientData.reasonForInactivation.contains("N/A"))
					selectValueFromAjaxList(selenium, ajxStationInactivation, patientData.reasonForInactivation);
						
			
			if(!patientData.residentialAddrStreet1.contains("N/A"))
				assertTrue(type(selenium, txtResidentAddress1, patientData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + patientData.residentialAddrStreet1, selenium, ClassName, MethodName);
			
			if(!patientData.residentialAddrStreet2.contains("N/A"))
				assertTrue(type(selenium, txtResidentAddress2, patientData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + patientData.residentialAddrStreet2, selenium, ClassName, MethodName);
			
			if(!patientData.residentialAddrcity.contains("N/A"))
				assertTrue(type(selenium, txtResidentialCity, patientData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + patientData.residentialAddrcity, selenium, ClassName, MethodName);
			
			if(!patientData.residentialAddrstate.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, ajxResidentialState, patientData.residentialAddrstate);
					
			if(!patientData.residentialAddrcountry.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, ajxResidentialCountry, patientData.residentialAddrcountry);
			
			if(!patientData.county.contains("N/A"))
				type(selenium, txtResidentialCountry, patientData.county);
					
			if(!patientData.residentialAddrzipCode.contains("N/A"))
				assertTrue(type(selenium, txtResidentialZip, patientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCode, selenium, ClassName, MethodName);
			/*waitForPageLoad(selenium);
			selenium.keyPress(ajxPhoneType1, "\\9");
			click(selenium,btnYesButton);
			waitForElementToEnable(selenium,txtResidentialCity);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,ajxResidentialState);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,ajxResidentialCountry);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtResidentialCountry);
			waitForPageLoad(selenium);
			*/
			
			if(!patientData.telephoneType1.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, ajxPhoneType1, patientData.telephoneType1);
					
			
			if(!patientData.telephoneNo1.contains("N/A"))
				assertTrue(type(selenium, txtPrimaryPhone, patientData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo1, selenium, ClassName, MethodName);
			
			if(!patientData.telephoneextnNo1.contains("N/A"))
				assertTrue(type(selenium, txtPrimaryPhoneExtn, patientData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo1, selenium, ClassName, MethodName);
			
			
			if(!patientData.telephoneType2.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, ajxPhoneType2, patientData.telephoneType2);
					
			
			
			if(!patientData.telephoneNo2.contains("N/A"))
				assertTrue(type(selenium, txtOtherPhone1, patientData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo2, selenium, ClassName, MethodName);
			
			if(!patientData.telephoneextnNo2.contains("N/A"))
				assertTrue(type(selenium, txtOtherPhone1Extn, patientData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo2, selenium, ClassName, MethodName);
			
			
			if(!patientData.telephoneType3.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, ajxPhoneType3, patientData.telephoneType3);
					
			
			
			if(!patientData.telephoneNo3.contains("N/A"))
				assertTrue(type(selenium, txtOtherPhone2, patientData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo3, selenium, ClassName, MethodName);
			
			if(!patientData.telephoneextnNo3.contains("N/A"))
				assertTrue(type(selenium, txtOtherPhone2Extn, patientData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneNo3, selenium, ClassName, MethodName);
			
			
			if(!patientData.email.contains("N/A"))
				assertTrue(type(selenium, txtEmail, patientData.email), "Could not Enter email, Expected value to be Typed" + patientData.email, selenium, ClassName, MethodName);
			
			
			if(!patientData.contactPreferences.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, ajxContactPreference, patientData.contactPreferences);
					
			if(!patientData.sameAsResidentialAddressCheck.isEmpty())
			{
				if(!patientData.sameAsResidentialAddressCheck.contains("No"))
					if(isChecked(selenium,chkMailingAsResidential))
					{
						assertTrue(click(selenium, chkMailingAsResidential), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck, selenium, ClassName, MethodName);
				
					
						if(!patientData.mailingAddressStreet1.contains("N/A"))
							assertTrue(type(selenium, txtMailingAddress1, patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1, selenium, ClassName, MethodName);
					
						if(!patientData.mailingAddressStreet2.contains("N/A"))
							assertTrue(type(selenium, txtMailingAddress2, patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2, selenium, ClassName, MethodName);
					
						if(!patientData.mailingAddressCity.contains("N/A"))
							assertTrue(type(selenium, txtMailingCity, patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity, selenium, ClassName, MethodName);
					
						if(!patientData.mailingAddressState.contains("N/A"))
							selectEmptyValueFromAjaxList(selenium, ajxMailingState, patientData.mailingAddressState);
						
						if(!patientData.mailingAddressCountry.contains("N/A"))
							selectEmptyValueFromAjaxList(selenium, ajxMailingCountry, patientData.mailingAddressCountry);
						if(!patientData.mailingAddressCounty.contains("N/A"))
							type(selenium,txtMailingCountry,patientData.mailingAddressCounty);
							
						if(!patientData.mailingAddressZipcode.contains("N/A"))
							assertTrue(selectEmptyValueFromAjaxList(selenium, txtMailingZip, patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode, selenium, ClassName, MethodName);					
						waitForPageLoad(selenium);
						selenium.keyPress(txtComments, "\\9");
						click(selenium,btnYesButton);
					}
				}else{
				
				if(!patientData.mailingAddressStreet1.contains("N/A"))
					assertTrue(type(selenium, txtMailingAddress1, patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1, selenium, ClassName, MethodName);
			
				if(!patientData.mailingAddressStreet2.contains("N/A"))
					assertTrue(type(selenium, txtMailingAddress2, patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2, selenium, ClassName, MethodName);
			
				if(!patientData.mailingAddressCity.contains("N/A"))
					assertTrue(type(selenium, txtMailingCity, patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity, selenium, ClassName, MethodName);
			
				if(!patientData.mailingAddressState.contains("N/A"))
					selectEmptyValueFromAjaxList(selenium, ajxMailingState, patientData.mailingAddressState);
				
				if(!patientData.mailingAddressCountry.contains("N/A"))
					selectEmptyValueFromAjaxList(selenium, ajxMailingCountry, patientData.mailingAddressCountry);
				if(!patientData.mailingAddressCounty.contains("N/A"))
					type(selenium,txtMailingCountry,patientData.mailingAddressCounty);
					
				if(!patientData.mailingAddressZipcode.contains("N/A"))
					assertTrue(type(selenium, txtMailingZip, patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode, selenium, ClassName, MethodName);					
				waitForPageLoad(selenium);
				selenium.keyPress(txtComments, "\\9");
				click(selenium,btnYesButton);
				waitForElementToEnable(selenium,txtMailingCity);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,ajxMailingState);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,ajxMailingCountry);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,txtMailingCountry);
				waitForPageLoad(selenium);
		
			}
			if(!patientData.primaryLocation.contains("N/A"))
				selectEmptyValueFromAjaxList(selenium, ajkSuggestBox, patientData.primaryLocation);
				waitForPageLoad(selenium);
				selenium.clickAt(lblPicture,"");
				waitForPageLoad(selenium);
				if(!patientData.comments.contains("N/A"))
					assertTrue(type(selenium, txtComments, patientData.comments), "Could not Enter comments, Expected value to be Selected" + patientData.comments, selenium, ClassName, MethodName);			
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSave1),"Could not click admin Mandatory", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//click(selenium,btnSave1);
				//click(selenium,btnSave1);
				waitForPageLoad(selenium);
				returnValue = true;	
				waitForPageLoad(selenium);		
		}catch(RuntimeException e) 
			{
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
			}
			return returnValue;
		}
		
		/**
		 * navigateToMandatoryUserFields
		 * function to Navigate from home page to mandatory user fields
		 * @since  	     November 03, 2014
		 */	
		public boolean navigateToMandatoryUserFields(Selenium selenium)throws IOException
		{
			
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			assertTrue(click(selenium,lnkSettings),"Could not click on the quick action link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			//assertTrue(click(selenium,lnkShowMoreLink),"Could not click on the show more action link" ,selenium,ClassName,MethodName);
			//waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingLink),"Could not click the systemSettings link;More Deatils:" ,selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}
		/**
		 * naviagateToHomePageFromAnyPlace
		 * function to Navigate to home page from any page
		 * @since  	     November 03, 2014
		 */
		public boolean naviagateToHomePageFromAnyPlace(Selenium selenium)throws IOException
		{
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			
            if(isElementPresent(selenium,btnErrorClose)){
				assertTrue(click(selenium,btnErrorClose),"Could not click Error Button", selenium, ClassName, MethodName);
			}
			return true;
		}
		/**
		 * navigateToPatientNewPatientRegistration
		 * function to Navigate to patient registration page
		 * @since  	     November 03, 2014
		 */
		public boolean navigateToNewPatientRegistration(Selenium selenium)throws IOException
		{
			assertTrue(click(selenium,lnkQuickLink),"Could not click on quick action", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}

		/**
		 * verifySelectOptionsPatientInfo
		 * function to verify the display of the selected option in the pick list 
		 * @since  	     July 05, 2012
		 */	
		public boolean verifySelectOptionsPatientInfo(Selenium selenium, HomeLib patientData)
		{
			boolean returnValue=true;
			try{
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxResidentialCountry,patientData.residentialAddrcountry);
				waitForPageLoad(selenium);
				selenium.clickAt(ajxResidentialCountry,"");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lblItemSelected))
				{
					if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.residentialAddrcountry))
						if(isElementPresent(selenium,ajkPopupBox))
						{
							returnValue=true;
							click(selenium,lblItemSelected);
						}
				}
				else
					return false;
				selectValueFromAjaxList(selenium, ajxPrimaryLocation, patientData.primaryLocation);
				waitForPageLoad(selenium);
				selenium.clickAt(ajxPrimaryLocation,"");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lblItemSelected))
				{
					if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.primaryLocation))
						if(isElementPresent(selenium,ajkPopupBox))
						{
							returnValue=true;
							click(selenium,lblItemSelected);
						}
				}
				else
					return false;
				selectValueFromAjaxList(selenium,ajxResponsbleProvider,patientData.responsibleProvider);
				waitForPageLoad(selenium);
				selenium.clickAt(ajxResponsbleProvider,"");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lblItemSelected))
				{
					if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.responsibleProvider))
						if(isElementPresent(selenium,ajkPopupBox))
						{
							returnValue=true;
							click(selenium,lblItemSelected);
						}
				}
				else
					return false;
				selectValueFromAjaxList(selenium, ajxTitle, patientData.title);
				waitForPageLoad(selenium);
				selenium.clickAt(ajxTitle,"");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lblItemSelected))
				{
					if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.title))
						if(isElementPresent(selenium,ajkPopupBox))
						{
							returnValue=true;
							click(selenium,lblItemSelected);
						}
				}
				else
					return false;
				selectValueFromAjaxList(selenium, ajxSuffix, patientData.suffix);
				waitForPageLoad(selenium);
				selenium.clickAt(ajxSuffix,"");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lblItemSelected))
				{
					if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.suffix))
						if(isElementPresent(selenium,ajkPopupBox))
						{
							returnValue=true;
							click(selenium,lblItemSelected);
						}
				}
				else
					return false;
				if(!patientData.prematureCheck.isEmpty())
					if(!patientData.prematureCheck.contains("No")){
						assertTrue(click(selenium, chkPremature), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck, selenium, ClassName, MethodName);
						selectValueFromAjaxList(selenium, ajxPrematureMeasure, patientData.measure);
						waitForPageLoad(selenium);
						selenium.clickAt(ajxPrematureMeasure,"");
						waitForPageLoad(selenium);
						if(isElementPresent(selenium,lblItemSelected))
						{
							if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.measure))
								if(isElementPresent(selenium,ajkPopupBox))
								{
									returnValue=true;
									click(selenium,lblItemSelected);
								}
						}
						else
							return false;
					}
			selectValueFromAjaxList(selenium, ajxSex, patientData.sex);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxSex,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected)){
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.sex))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;
			selectValueFromAjaxList(selenium, ajxmartialStatus, patientData.maritalStatus);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxmartialStatus,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected)){
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.maritalStatus))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;
			selectValueFromAjaxList(selenium, ajxStatus, patientData.status);
			selenium.clickAt(ajxStatus,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected)){
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.status))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;
			/*selectValueFromAjaxList(selenium, ajxStationInactivation, patientData.reasonForInactivation);
			selenium.clickAt(ajxStationInactivation,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.reasonForInactivation))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;*/
			selectValueFromAjaxList(selenium, ajxResidentialState, patientData.residentialAddrstate);
			selenium.clickAt(ajxResidentialState,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.residentialAddrstate))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;
			selectValueFromAjaxList(selenium, ajxPhoneType1, patientData.telephoneType1);
			selenium.clickAt(ajxPhoneType1,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.telephoneType1))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;
			selectValueFromAjaxList(selenium, ajxPhoneType2, patientData.telephoneType2);
			selenium.clickAt(ajxPhoneType2,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.telephoneType2))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;
			selectValueFromAjaxList(selenium, ajxPhoneType3, patientData.telephoneType3);
			selenium.clickAt(ajxPhoneType3,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.telephoneType3))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;
			/*selectValueFromAjaxList(selenium, ajxContactPreference, patientData.contactPreferences);
			selenium.clickAt(ajxContactPreference,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected)){
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.contactPreferences))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;*/
			if(!patientData.sameAsResidentialAddressCheck.isEmpty())
			{
				if(!patientData.sameAsResidentialAddressCheck.contains("No"))
					assertTrue(click(selenium, chkMailingAsResidential), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck, selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxMailingState, patientData.mailingAddressState);
				selenium.clickAt(ajxMailingState,"");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lblItemSelected))
				{
					if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.mailingAddressState))
						if(isElementPresent(selenium,ajkPopupBox))
						{
							returnValue=true;
							click(selenium,lblItemSelected);
						}
				}
				else
					return false;
			}
			selectValueFromAjaxList(selenium,ajxMailingCountry,patientData.mailingAddressCountry);
			selenium.clickAt(ajxMailingCountry,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(patientData.mailingAddressCountry))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			
			}catch(Exception e){
				e.printStackTrace();
			}
			return returnValue;
			
		}

		public boolean createPatientMandatory(Selenium selenium, HomeLib patientData)throws Exception
		{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("ddmmssmsm");
			String date=DateFormat1.format(cal.getTime());
			patientData.lastName=patientData.lastName+date;
			assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium, txtDOB, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName, MethodName);
			if(isElementPresent(selenium,btnNoDuplicate))
			{
				click(selenium,btnNoDuplicate);
			}
			click(selenium,btnBack);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave1),"Could not click Save button More Dateils"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnSave1))
			{
				return false;
			}
			return true;
		}
		/**
		 * createNewPatientWithMandatory
		 * function to create New Patient With Mandatory
		 * @throws IOException 
		 * @since  	     Feb 09, 2012
		 */	
		public boolean createNewPatientWithMandatory(Selenium selenium, HomeLib patientData) throws IOException{
			boolean returnValue = false;
			try{
				/*Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd MM YYYY");
				String uniqueName=DateFormat.format(cal.getTime());*/
				assertTrue(type(selenium,txtChartNumber,patientData.patientIdchart),"Could not Enter the chart number;More Details:"+patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(patientData.testCaseId.equals("TC_NPC_018")||patientData.testCaseId.equals("TC_NPC_019")||patientData.testCaseId.equals("TC_NPC_020")
						||patientData.testCaseId.equals("TC_NPC_021")||patientData.testCaseId.equals("TC_NPC_022") ||patientData.testCaseId.equals("TC_NPC_023")
						||patientData.testCaseId.equals("TC_NPC_024")||patientData.testCaseId.equals("TC_NPC_025")||patientData.testCaseId.equals("TC_NPC_026")){
					patientData.lastName = patientData.lastName;
					assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
				}else
				assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium, txtDOB, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName, MethodName);
				click(selenium,btnBack);
				if(isElementPresent(selenium,btnNoDuplicate))
				{
					click(selenium,btnNoDuplicate);
				}
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"statusSuggestBoxsuggestBox",patientData.status);
			
				assertTrue(click(selenium,chkPremature),"Could not click prematurecheck box : More Details"+patientData.toString(), selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxPrematureDuration,patientData.duration);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxPrematureMeasure,patientData.measure);
				//selectValueFromAjaxList(selenium,ajxPrematureDuration,patientData.duration);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxRelationSex,patientData.sex);
				waitForPageLoad(selenium);
				
				if(patientData.testCaseId.equals("TC_NPC_017")|| patientData.testCaseId.equals("TC_NPC_008")){
					selectValueFromAjaxList(selenium, ajxResidentialCountry, patientData.residentialAddrcountry);
					waitForPageLoad(selenium);
					assertTrue(type(selenium, txtResidentialZip, patientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCode, selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					selenium.isTextPresent("This is not a valid USA postcode. Are you sure you want to save it?");
					assertTrue(click(selenium,btnYesButton),"Could not click the yes button", selenium, ClassName, MethodName);
				}
				
				assertTrue(click(selenium,btnSave1),"Could not click Save button More Dateils"+patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				returnValue = true;	
				waitForPageLoad(selenium);
				}
			catch(RuntimeException e) {
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
			}
			return returnValue;
		}
		


		/**
		 * createNewPatientWithMandatory 
		 * function to create New Patient With Mandatory for ChartPreVisitLib
		 * @throws IOException 
		 * @since  	     Feb 09, 2012
		 */	
		public boolean createNewPatientWithMandatory(Selenium selenium, ChartPreVisitLib patientData) throws IOException{
			boolean returnValue = false;
			try{

		     	assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
				click(selenium,btnBack);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"statusSuggestBoxsuggestBox",patientData.status);
				assertTrue(click(selenium,btnSave1),"Could not click Save button More Dateils"+patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				returnValue = true;	
				waitForPageLoad(selenium);
				}
			catch(RuntimeException e) {
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
			}
			return returnValue;
		}
	
	/**
	 * deleteAllMandatory
	 * function to delete All Mandatory
	 * @throws IOException 
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllMandatory(Selenium selenium) throws IOException{
		boolean mandatoryDeleted = true;
		int caseCount = 0;
		try{
			waitForElement(selenium, lnkDeleteMandatoryUserFields, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lnkDeleteMandatoryUserFields) > 0){
				caseCount = (Integer) selenium.getXpathCount(lnkDeleteMandatoryUserFields);
				assertTrue(click(selenium,lnkDeleteMandatoryUserFields)," ", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYesButton)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount(lnkDeleteMandatoryUserFields)){
					mandatoryDeleted = false;
					break;
				}
			}
			return mandatoryDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createPatient_UnitTest
	 * function to create a new patient check-in for unit Test
	 * @throws IOException 
	 * @since  	     Feb 09, 2012
	 */
	public boolean createPatient_UnitTest(Selenium selenium, HomeLibUnitTest patientData) throws IOException{
		boolean returnValue = false;
		try{	
			if(!patientData.patientIdchart.isEmpty())
				if(!patientData.patientIdchart.contains("N/A"))
					assertTrue(type(selenium,txtChartNumber,patientData.patientIdchart),"Could not Enter the patientId chart, Expected value to be typed" + patientData.patientIdchart, selenium, ClassName, MethodName );
			if(!patientData.primaryLocation.isEmpty())
				if(!patientData.primaryLocation.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPrimaryLocation, patientData.primaryLocation))
						Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.primaryLocation);
			if(!patientData.responsibleProvider.isEmpty())
				if(!patientData.responsibleProvider.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,ajxResponsbleProvider,patientData.responsibleProvider))
						Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.responsibleProvider);
			if(!patientData.pcpCheck.isEmpty())
				if(!patientData.pcpCheck.contains("No"))
					assertTrue(check(selenium, chkResponsibleProvider), "Could not check the pcp check box, Expected value for the check box : " + patientData.pcpCheck, selenium, ClassName, MethodName);
			
			if(!patientData.lastName.isEmpty())
				if(!patientData.lastName.contains("N/A"))
					assertTrue(type(selenium, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName, selenium, ClassName, MethodName);
			if(!patientData.firstName.isEmpty())
				if(!patientData.firstName.contains("N/A"))
					assertTrue(type(selenium, txtFirstName, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName, selenium, ClassName, MethodName);
			if(!patientData.middleName.isEmpty())
				if(!patientData.middleName.contains("N/A"))
					assertTrue(type(selenium, txtMiddleName, patientData.middleName), "Could not Enter middle name, Expected value to be typed" + patientData.middleName, selenium, ClassName, MethodName);
			if(!patientData.title.isEmpty())
				if(!patientData.title.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxTitle, patientData.title))	
						Assert.fail("Could not Enter Title, Expected value to be selected" + patientData.title);
			if(!patientData.suffix.isEmpty())
				if(!patientData.suffix.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxSuffix, patientData.suffix))
						Assert.fail("Could not Enter Suffix, Expected value to be selected" + patientData.suffix);
			if(!patientData.alias1.isEmpty())
				if(!patientData.alias1.contains("N/A"))
					assertTrue(type(selenium, txtAlias1, patientData.alias1), "Could not Enter alias1, Expected value to be typed" + patientData.alias1, selenium, ClassName, MethodName);
			if(!patientData.alias2.isEmpty())
				if(!patientData.alias2.contains("N/A"))
					assertTrue(type(selenium, txtAlias2, patientData.alias2), "Could not Enter alias2, Expected value to be typed" + patientData.alias2, selenium, ClassName, MethodName);
			if(!patientData.dob.isEmpty())
				if(!patientData.dob.contains("N/A"))
					assertTrue(enterDate(selenium, txtDOB, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName, MethodName);			
					
				
			if(!patientData.estimatedCheck.isEmpty())
				if(!patientData.estimatedCheck.contains("No"))
					assertTrue(click(selenium, chkDOBEstimated), "Could not check the estimated check box, Expected value for the check box : " + patientData.estimatedCheck, selenium, ClassName, MethodName);
			if(!patientData.prematureCheck.isEmpty())
				if(!patientData.prematureCheck.contains("No"))
				{
					assertTrue(click(selenium, chkPremature), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck, selenium, ClassName, MethodName);
					if(!patientData.duration.isEmpty())
						if(!patientData.duration.contains("N/A"))
							assertTrue(type(selenium, txtPrematureDuration, patientData.duration), "Could not Enter duration, Expected value to be typed : " + patientData.duration, selenium, ClassName, MethodName);
					if(!patientData.measure.isEmpty())
						if(!patientData.measure.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxPrematureMeasure, patientData.measure))
								Assert.fail("Could not Enter Premature Messure, Expected value to be selected" + patientData.measure);
				}
			if(!patientData.sex.isEmpty())
				if(!patientData.sex.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxSex, patientData.sex))
						Assert.fail("Could not Enter Sex, Expected value to be selected" + patientData.sex);
			if(!patientData.maritalStatus.isEmpty())
				if(!patientData.maritalStatus.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxmartialStatus, patientData.maritalStatus))
						Assert.fail("Could not Enter Marital Status, Expected value to be selected" + patientData.maritalStatus);					
			if(!patientData.status.isEmpty())
				if(!patientData.status.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxStatus, patientData.status))
						Assert.fail("Could not Enter Status, For; More Details" + patientData.toString());
			if(!patientData.statusDate.isEmpty())
				if(!patientData.statusDate.contains("N/A"))
					assertTrue(type(selenium, txtStatusDate, patientData.statusDate), "Could not Enter statusDate, For; More Details" + patientData.toString(), selenium, ClassName, MethodName);
			if(patientData.status.equalsIgnoreCase("inactive"))
				if(!patientData.reasonForInactivation.isEmpty())
					if(!patientData.reasonForInactivation.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxStationInactivation, patientData.reasonForInactivation))
							Assert.fail("Could not Enter reason for inactivation, For; More Details" + patientData.maritalStatus);					
			if(!patientData.residentialAddrStreet1.isEmpty())
				if(!patientData.residentialAddrStreet1.contains("N/A"))
					assertTrue(type(selenium, txtResidentAddress1, patientData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + patientData.residentialAddrStreet1, selenium, ClassName, MethodName);
			if(!patientData.residentialAddrStreet2.isEmpty())
				if(!patientData.residentialAddrStreet2.contains("N/A"))
					assertTrue(type(selenium, txtResidentAddress2, patientData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + patientData.residentialAddrStreet2, selenium, ClassName, MethodName);
			if(!patientData.residentialAddrcity.isEmpty())
				if(!patientData.residentialAddrcity.contains("N/A"))
					assertTrue(type(selenium, txtResidentialCity, patientData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + patientData.residentialAddrcity, selenium, ClassName, MethodName);
			if(!patientData.residentialAddrstate.isEmpty())
				if(!patientData.residentialAddrstate.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxResidentialState, patientData.residentialAddrstate))
						Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.residentialAddrstate);
			if(!patientData.residentialAddrzipCode.isEmpty())
				if(!patientData.residentialAddrzipCode.contains("N/A"))
					Assert.assertTrue(type(selenium, txtResidentialZip, patientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCode);
			if(!patientData.residentialAddrcountry.isEmpty())
				if(!patientData.residentialAddrcountry.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,ajxResidentialCountry,patientData.residentialAddrcountry))
						Assert.fail("Could not Enter Residential Addr Country, Expected value to be select"+patientData.residentialAddrcountry);
			if(!patientData.residentialAddrCounty.isEmpty())
				if(!patientData.residentialAddrCounty.contains("N/A"))
					assertTrue(type(selenium,txtResidentialCountry,patientData.residentialAddrCounty),"Could not Enter county Value, Expected value to be typed"+ patientData.residentialAddrCounty, selenium, ClassName, MethodName);
			if(!patientData.telephoneType1.isEmpty())
				if(!patientData.telephoneType1.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType1, patientData.telephoneType1))
						Assert.fail("Could not Enter Telephone Type1, Expected value to be Select" + patientData.telephoneType1);
			if(!patientData.telephoneNo1.isEmpty())
				if(!patientData.telephoneNo1.contains("N/A"))
					assertTrue(type(selenium, txtPrimaryPhone, patientData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo1, selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo1.isEmpty())
				if(!patientData.telephoneextnNo1.contains("N/A"))
					Assert.assertTrue(type(selenium, txtPrimaryPhoneExtn, patientData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo1);
			
			if(!patientData.telephoneType2.isEmpty())
				if(!patientData.telephoneType2.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType2, patientData.telephoneType2))
						Assert.fail("Could not Enter Telephone Type2, Expected value to be Select" + patientData.telephoneType2);
			
			if(!patientData.telephoneNo2.isEmpty())
				if(!patientData.telephoneNo2.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone1, patientData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo2, selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo2.isEmpty())
				if(!patientData.telephoneextnNo2.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone1Extn, patientData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo2, selenium, ClassName, MethodName);
			
			if(!patientData.telephoneType3.isEmpty())
				if(!patientData.telephoneType3.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType3, patientData.telephoneType3))
						Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.telephoneType3);
			
			if(!patientData.telephoneNo3.isEmpty())
				if(!patientData.telephoneNo3.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone2, patientData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo3, selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo3.isEmpty())
				if(!patientData.telephoneextnNo3.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone2Extn, patientData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneNo3, selenium, ClassName, MethodName);
			
			if(!patientData.email.isEmpty())
				if(!patientData.email.contains("N/A"))
					assertTrue(type(selenium, txtEmail, patientData.email), "Could not Enter email, Expected value to be Typed" + patientData.email, selenium, ClassName, MethodName);
			
			if(!patientData.contactPreferences.isEmpty())
				if(!patientData.contactPreferences.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, "contactPreferenceSuggestBoxId1suggestBox", patientData.contactPreferences))
						Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences);
			if(!patientData.preference2Present.isEmpty())
				if(!patientData.preference2Present.contains("N/A")){
					assertTrue(click(selenium,btnAddContactPreference), "Could not add a ne preference", selenium, ClassName, MethodName);
					if(!patientData.contactPreference2.isEmpty())
						if(!patientData.contactPreference2.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxContactPreference1, patientData.contactPreference2))
								Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreference2);
				}
			if(!patientData.sameAsResidentialAddressCheck.isEmpty())
			{
				if(!patientData.sameAsResidentialAddressCheck.contains("No"))
					assertTrue(click(selenium, chkMailingAsResidential), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck, selenium, ClassName, MethodName);
				
					if(!patientData.mailingAddressStreet1.isEmpty())
						if(!patientData.mailingAddressStreet1.contains("N/A"))
							assertTrue(type(selenium, txtMailingAddress1, patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1, selenium, ClassName, MethodName);
					if(!patientData.mailingAddressStreet2.isEmpty())
						if(!patientData.mailingAddressStreet2.contains("N/A"))
							assertTrue(type(selenium, txtMailingAddress2, patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2, selenium, ClassName, MethodName);
					if(!patientData.mailingAddressCity.isEmpty())
						if(!patientData.mailingAddressCity.contains("N/A"))
							assertTrue(type(selenium, txtMailingCity, patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity, selenium, ClassName, MethodName);
					
					if(!patientData.mailingAddressState.isEmpty())
						if(!patientData.mailingAddressState.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxMailingState, patientData.mailingAddressState))
								Assert.fail("Could not Enter Mailing Addr State, Expected value to be select" + patientData.mailingAddressState);
					
					if(!patientData.mailingAddressZipcode.isEmpty())
						if(!patientData.mailingAddressZipcode.contains("N/A"))
							assertTrue(type(selenium, txtMailingZip, patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode, selenium, ClassName, MethodName);					
				}
			else{
				if(!patientData.mailingAddressStreet1.isEmpty())
					if(!patientData.mailingAddressStreet1.contains("N/A"))
						assertTrue(type(selenium, txtMailingAddress1, patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1, selenium, ClassName, MethodName);
				if(!patientData.mailingAddressStreet2.isEmpty())
					if(!patientData.mailingAddressStreet2.contains("N/A"))
						assertTrue(type(selenium, txtMailingAddress2, patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2, selenium, ClassName, MethodName);
				if(!patientData.mailingAddressCity.isEmpty())
					if(!patientData.mailingAddressCity.contains("N/A"))
						assertTrue(type(selenium, txtMailingCity, patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity, selenium, ClassName, MethodName);
				
				if(!patientData.mailingAddressState.isEmpty())
					if(!patientData.mailingAddressState.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxMailingState, patientData.mailingAddressState))
							Assert.fail("Could not Enter Mailing Address State, Expected value to be selected" + patientData.mailingAddressState);
				if(!patientData.mailingAddressZipcode.isEmpty())
					if(!patientData.mailingAddressZipcode.contains("N/A"))
						assertTrue(type(selenium, txtMailingZip, patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode, selenium, ClassName, MethodName);
				if(!patientData.mailingAddressCountry.isEmpty())
					if(!patientData.mailingAddressCountry.contains("N/A"))
						if(!selectValueFromAjaxList(selenium,ajxMailingCountry,patientData.mailingAddressCountry))
							Assert.fail("Could not Enter Mailing Addr Country,Expected value to be typed"+patientData.mailingAddressCountry);
			}
			
			if(!patientData.comments.isEmpty())
				if(!patientData.comments.contains("N/A"))
					assertTrue(type(selenium, txtComments, patientData.comments), "Could not Enter comments, Expected value to be Selected" + patientData.comments, selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			click(selenium,btnSave1);
			waitForPageLoad(selenium);
			returnValue = true;	
			waitForPageLoad(selenium);		
			}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		}
		return returnValue;
	}





	
	/**
	 * createNotesWithMandatory
	 * function to create a Notes With Mandatory
	 * @throws IOException 
	 * @since  	    May 03, 2012
	 */	
	public boolean createNotesWithMandatory(Selenium selenium,HomeLib noteData, String userAccount) throws IOException{
		try{
			waitForPageLoad(selenium);
			
			if(userAccount.equalsIgnoreCase(CAAccount)){				
				assertTrue(enterDate(selenium,txtNoteDate,noteData.notedateCA),"Could not enter date; More Details:"+noteData.toString(), selenium, ClassName, MethodName);
				
			}
			else{				
				assertTrue(enterDate(selenium,txtNoteDate,noteData.notedate),"Could not enter date; More Details:"+noteData.toString(), selenium, ClassName, MethodName);
			
			}	
					
			selectValueFromAjaxList(selenium,ajkSuggestBox,noteData.category);
			assertTrue(type(selenium,txtNote,noteData.patientnote), "Could not type patient note; More Details :"+noteData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click save button; More Details:"+noteData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnAddNote)){
				return true;
			}else{
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + noteData.toString());		
			return false;
		}
	}
	/**
	 * verifySelectOptionNotes
	 * function to verify the display of select option in notes
	 * @since  	    July 06, 2012
	 */	
	public boolean verifySelectOptionNotes(Selenium selenium,HomeLib noteData){
		boolean returnValue=false;
		try{
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkSuggestBox,noteData.category);
			selenium.clickAt(ajkSuggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,ajxCatagoryValue))
			{
				if(getText(selenium,ajxCatagoryValue).equalsIgnoreCase(noteData.category))
				{
					returnValue=true;
					click(selenium,ajxCatagoryValue);
				}
						
			}
			else
				return false;	
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + noteData.toString());		
			return false;
		}
		return returnValue;
	}
	
	
	/**
	 * goToCases
	 * function to create a Case
	 * @since  	     APR 09, 2012
	 */	
	public boolean goToCases(Selenium selenium){
		try{
			
			click(selenium,lnkPatientCaseList);
			waitForPageLoad(selenium);
			if(waitForElement(selenium, btnAddCase, WAIT_TIME)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
			
		}
	}
	
	/**
	 * deleteAllCases
	 * function to create a Case
	 * @throws IOException 
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllCases(Selenium selenium) throws IOException{
		boolean caseDeleted = true;
		int caseCount = 0;
		try{
			waitForElement(selenium, lnkDeleteCases, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lnkDeleteCases) > 0){
				caseCount = (Integer) selenium.getXpathCount(lnkDeleteCases);
				assertTrue(click(selenium,lnkDeleteCases)," ", selenium, ClassName, MethodName);
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount(lnkDeleteCases)){
					caseDeleted = false;
					break;
				}
			}
			return caseDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * Go To Add Case
	 * function to navigate to add case
	 * @throws IOException 
	 * @since  	     APR 09, 2012
	 */
	public boolean goToAddCase(Selenium selenium) throws IOException{
		try{
			assertTrue(click(selenium,btnAddCase), "Could not click Add Case", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(waitForElement(selenium, txtDescription, WAIT_TIME)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * createCases
	 * function to create a Case
	 * @throws IOException 
	 * @since  	     APR 09, 2012
	 */	

	public boolean createCases(Selenium selenium, HomeLib casesData,String account) throws IOException{
		
		try{
			String date=null;
			if(account.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				 date=DateFormat.format(cal.getTime());
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				 date=DateFormat.format(cal.getTime());
				
				}
				assertTrue(type(selenium,txtDescription,casesData.description),"Could not enter Description ; More Details :"+casesData.toString(), selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajkProgram, casesData.program);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtReason,casesData.reason),"Could not enter Reason ; More Details :"+casesData.toString(), selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,lstReferral,casesData.referral);
				//Assert.assertTrue(type(selenium,"icdCode",casesData.icecode),"Could not icecode; More Details :" + casesData.toString());
				assertTrue(enterDate(selenium,txtStartDate,date),"Could not enter the date; More Details :" + casesData.toString(), selenium, ClassName, MethodName);
				if(casesData.casesstatus.equals("Terminated")){
					selectValueFromAjaxList(selenium,ajkCaseStatus,casesData.casesstatus);
					waitForPageLoad(selenium);
					assertTrue(enterDate(selenium,txtTerminationDate,date),"Could not enter the date; More Details :" + casesData.toString(), selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtTerminationDateReason,casesData.terminationReason),"Could not enter the Reason ; More Details :"+casesData.toString(), selenium, ClassName, MethodName);
				}
				
				click(selenium,btnAddCaseDates);
				if (isElementPresent(selenium, txtDateType)){
					selectValueFromAjaxList(selenium,txtDateType, casesData.datetype1);
					//click(selenium,"//body/div[3]/div/div/div/div/div");
					assertTrue(enterDate(selenium,txtDate,date),"Could not enter the date; More Details :" + casesData.toString(), selenium, ClassName, MethodName);
				}
				
				if(!casesData.testCaseId.equals("TC_NC_006")){
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + casesData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(!isElementPresent(selenium,btnAddCase )){	
					return false;
					}
				}
			}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + casesData.toString());		
				return false;
			}
		return true;
		}

	
	/**
	 * verifySelectOptionsCases
	 * function to verify options in Cases
	  * @since  	     July 06, 2012
	 */	

	public boolean verifySelectOptionsCases(Selenium selenium, HomeLib casesData){
		boolean  returnValue=false;
		try{		
			
			selectValueFromAjaxList(selenium,ajkProgram, casesData.program);
			selenium.click(ajkProgram);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).contains(casesData.program))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			
			selectValueFromAjaxList(selenium,ajkCaseStatus,casesData.casesstatus);
			selenium.click(ajkCaseStatus);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).contains(casesData.casesstatus))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			click(selenium,btnAddCaseDates);
			if (isElementPresent(selenium, txtDateType)){
			selectValueFromAjaxList(selenium,txtDateType, casesData.datetype1);
			//click(selenium,ajkDateTypeSelected);
			waitForPageLoad(selenium);
			selenium.click(txtDateType);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).contains(casesData.datetype1))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + casesData.toString());		
			return false;
		}
		return returnValue;
	}

	/**
	 * createContact
	 * function to create a Contact
	 * @throws IOException 
	 * @since  	     Feb 22, 2012
	 */	
	public boolean createContact(Selenium selenium, HomeLib ContactData, String userAccount) throws IOException{
		
		try{		
			if(ContactData.testCaseId.equals("TC_CPC_006")||ContactData.testCaseId.equals("TC_CPC_001"))
				assertTrue(check(selenium, chkEmergencyContact), "Could not check the contact type, " + ContactData.toString(), selenium, ClassName, MethodName);
			else
				assertTrue(check(selenium, chkSubDesicionMaker), "Could not check the contact type, " + ContactData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkRelationship, ContactData.relationship);
			selectValueFromAjaxList(selenium, ajkTitle,ContactData.title);
			assertTrue(type(selenium, txtLastName, ContactData.lastName),"Could not enter Last Name; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstName, ContactData.firstName),"Could not enter First Name; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajkSuffix,ContactData.suffix);
			assertTrue(type(selenium, txtEmail, ContactData.email),"Could not enter Email; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkLanguage,ContactData.languageSpoken);
			assertTrue(type(selenium, txtComments, ContactData.comments), "Could not Enter comments, Expected value to be Selected" + ContactData.comments, selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtContactAddr1, ContactData.residentialAddrStreet1),"Could not enter Residential Address; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtContactAddr2, ContactData.residentialAddrStreet2),"Could not enter Residential Address; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtContactCity, ContactData.residentialAddrcity),"Could not enter City; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				
				selectValueFromAjaxList(selenium, ajkContactState,ContactData.residentialAddrstateCA);
				assertTrue(type(selenium, txtContactZipCode, ContactData.residentialAddrzipCodeCA),"Could not enter Zip; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
							
			}
			else{
				
				selectValueFromAjaxList(selenium, ajkContactState,ContactData.residentialAddrstate);
				assertTrue(type(selenium, txtContactZipCode, ContactData.residentialAddrzipCode),"Could not enter Zip; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);						
			}		
			
			selenium.keyPress(ajkContactCountry, "\\9");			
			click(selenium,btnYesButton);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtContactAddr1);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtContactAddr2);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtContactCity);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,ajkContactState);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,ajkContactCountry);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajkPrimPhone1,ContactData.telephoneType1);
			assertTrue(type(selenium, txtPrimaryPhone, ContactData.telephoneNo1),"Could not enter phone number; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtPrimPhoneExtn, ContactData.telephoneextnNo1),"Could not enter extn number; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkPrimPhone2,ContactData.telephoneType2);
			assertTrue(type(selenium, txtSecPhone, ContactData.telephoneNo2),"Could not enter Phone number; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtSecPhoneExtn, ContactData.telephoneextnNo2),"Could not enter extn number; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkPrimPhone3,ContactData.telephoneType3);
			assertTrue(type(selenium, txtTertiaryPhone, ContactData.telephoneNo3),"Could not enter Fax number; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtTertiaryPhoneExtn, ContactData.telephoneextnNo3),"Could not enter extn number; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			
			if(!ContactData.testCaseId.equals("TC_CPC_009")){
				assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
				if(!isElementPresent(selenium, btnAddContact)){
					return false;
				}
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());		
			return false;
		}
		return true;
	}


	/**
	 * createContactWithMandatory
	 * function to create a Contact only With Mandatory fields
	 * @throws IOException 
	  * @since  	     Apr 18, 2012
	 */	
	public boolean createContactWithMandatory(Selenium selenium, HomeLib ContactData,String userAccount) throws IOException{
		
		try{		
			if(ContactData.testCaseId.equalsIgnoreCase("TC_CPC_001"))
				assertTrue(check(selenium, chkSubDesicionMaker), "Could not check the contact type, " + ContactData.toString(), selenium, ClassName, MethodName);
			else if(ContactData.testCaseId.equalsIgnoreCase("TC_CPC_004"))
				assertTrue(check(selenium, chkGuarantor), "Could not check the contact type, " + ContactData.toString(), selenium, ClassName, MethodName);
			else if(ContactData.testCaseId.equalsIgnoreCase("TC_CPC_005"))
				assertTrue(check(selenium, chkEmergencyContact), "Could not check the contact type, " + ContactData.toString(), selenium, ClassName, MethodName);
			else if(ContactData.testCaseId.equalsIgnoreCase("TC_CPC_013"))
				assertTrue(check(selenium, chkSubDesicionMaker), "Could not check the contact type, " + ContactData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkRelationship, ContactData.relationship);
			
			assertTrue(type(selenium, txtLastName, ContactData.lastName),"Could not enter Last Name; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstName, ContactData.firstName),"Could not enter First Name; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnAddContact)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());		
			return false;
		}
	}

	/**
	 * deleteAllContact
	 * function to delete All Contact
	 * @throws IOException 
	 * @since  	    Aug 14, 2012
	 */
	public boolean deleteAllContact(Selenium selenium) throws IOException{
		boolean contactDeleted = true;
		int contactCount = 0;
		try{
	waitForElement(selenium, lnkDeleteContact, WAIT_TIME);
	
	
	while(isElementPresent(selenium,deleteContact))
	{
		assertTrue(click(selenium,deleteContact),"Unable to click the delete button",selenium,ClassName,MethodName);
		waitForElement(selenium,yesButton1,1000);
		assertTrue(click(selenium,yesButton1),"Unable to click the yes button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
	}
			/*while((Integer) selenium.getXpathCount(lnkDeleteContact) > 0){
				contactCount = (Integer) selenium.getXpathCount(lnkDeleteContact);
				assertTrue(click(selenium,lnkDeleteContact)," ", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYesButton)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(contactCount == (Integer) selenium.getXpathCount(lnkDeleteContact)){
					contactDeleted = false;
					break;
				}
			}*/
			return contactDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * duplicateContact
	 * function to create a Contact only With Mandatory fields
	 * @throws IOException 
	 * @since  	     Apr 18, 2012
	 */	
	public boolean duplicateContact(Selenium selenium, HomeLib ContactData) throws IOException{
		
		try{		
			if(ContactData.guarantor.equals("Yes")){
				assertTrue(check(selenium,chkGuarantor),"Could not check gurantor;More Details:"+ContactData.toString(), selenium, ClassName, MethodName);
			}
			if(ContactData.eContact.equals("Yes")){
				assertTrue(check(selenium,chkEmergencyContact),"Could not check eContact;More Details:"+ContactData.toString(), selenium, ClassName, MethodName);
			}
			if(ContactData.guardian.equals("Yes")){
				assertTrue(check(selenium,chkGuardian),"Could not check guardianr;More Details:"+ContactData.toString(), selenium, ClassName, MethodName);
			}
			if(ContactData.sdMarker.equals("Yes")){
				assertTrue(check(selenium,chkSubDesicionMaker),"Could not check sdMaker;More Details:"+ContactData.toString(), selenium, ClassName, MethodName);
			}
			if(ContactData.other.equals("Yes")){
				assertTrue(check(selenium,"othercheckbox"),"Could not check gurantor;More Details:"+ContactData.toString(), selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium, ajkRelationship, ContactData.relationship);
			assertTrue(type(selenium, txtLastName, ContactData.lastName),"Could not enter Last Name; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstName, ContactData.firstName),"Could not enter First Name; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnAddContact)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());		
			return false;
		}
	}

	/**
	 * copyContactInfoFromHousehold
	 * function to verify copy information from household
	 * @throws IOException 
	 * @since  	     Aor 17, 2012
	 */	
	public boolean copyContactInfoFromHousehold(Selenium selenium, HomeLib ContactData) throws IOException{
		
		try{
			if(isElementPresent(selenium, txtPatientcontactSearchBox))
				type(selenium, txtPatientcontactSearchBox, ContactData.householdName);
			click(selenium,ajkContactSearch);
			if(isElementPresent(selenium, ajkSelectContactSearch))
					click(selenium,ajkSelectContactSearch);
			assertTrue(check(selenium, chkGuardian), "Could not check the contact type, " + ContactData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkRelationship, ContactData.relationship);
			click(selenium,ajkValueSelect1);
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			if(isElementPresent(selenium, lblTitle)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());		
			return false;
		}
	}
	/**
	 * verifyContactWithSummaryPage
	 * function to verify Contact With Summary Page
	 * @throws IOException 
	 * @since  	    July 02, 2012
	 */	
	public boolean verifyContactWithSummaryPage(Selenium selenium, HomeLib ContactData) throws IOException{
		
		try{		
			
			assertTrue(check(selenium, chkEmergencyContact), "Could not check the contact type, " + ContactData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkRelationship, ContactData.relationship);
			assertTrue(type(selenium, txtLastName, ContactData.lastName),"Could not enter Last Name; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstName, ContactData.firstName),"Could not enter First Name; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnAddContact)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());		
			return false;
		}
	}
	/**
	 * verifySelectOptionsInContacts
	 * function to verify the select options in contacts
	 * @throws IOException 
	 * @since  	    July 06, 2012
	 */	
	public boolean verifySelectOptionsInContacts(Selenium selenium, HomeLib ContactData,String account) throws IOException{
		boolean returnValue=false;
		try{		
			
			assertTrue(check(selenium, chkSubDesicionMaker), "Could not check the contact type, " + ContactData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkRelationship, ContactData.relationship);
			selenium.clickAt(ajkRelationship,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected)){
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(ContactData.relationship))
				{	returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium, ajkTitle,ContactData.title);
			selenium.clickAt(ajkTitle,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected)){
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(ContactData.title))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			
			assertTrue(type(selenium, txtLastName, ContactData.lastName),"Could not enter Last Name; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstName, ContactData.firstName),"Could not enter First Name; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajkSuffix,ContactData.suffix);
			selenium.clickAt(ajkSuffix,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected)){
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(ContactData.suffix))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			
			selectValueFromAjaxList(selenium, ajkLanguage,ContactData.languageSpoken);
			selenium.clickAt(ajkLanguage,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected)){
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(ContactData.languageSpoken))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			if(account.equals(CAAccount)){
				selectValueFromAjaxList(selenium, ajkContactState,ContactData.residentialAddrstateCA);
			}else{
				selectValueFromAjaxList(selenium, ajkContactState,ContactData.residentialAddrstate);
			}
			selenium.clickAt(ajkContactState,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected)){
				waitForPageLoad(selenium);
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(ContactData.residentialAddrstate)||getText(selenium,lblItemSelected).equalsIgnoreCase(ContactData.residentialAddrstateCA))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium, ajkPrimPhone1,ContactData.telephoneType1);
			selenium.clickAt(ajkPrimPhone1,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected)){
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(ContactData.telephoneType1))
				{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			
			selectValueFromAjaxList(selenium, ajkPrimPhone2,ContactData.telephoneType2);
			selenium.clickAt(ajkPrimPhone2,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected)){
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(ContactData.telephoneType2))
				{						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			
			selectValueFromAjaxList(selenium, ajkPrimPhone3,ContactData.telephoneType3);
			selenium.clickAt(ajkPrimPhone3,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected)){
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(ContactData.telephoneType3))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());		
			return false;
		}
		return returnValue;
	}

public boolean createSocioEconomic(Selenium selenium, HomeLib socioEconomicData, String userAccount) throws IOException{
		
		try{	
			selectValueFromAjaxList(selenium,ajxRaceSocio,socioEconomicData.race);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxEthniCity,socioEconomicData.ethnicity);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxReligion,socioEconomicData.religion);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxCitizenship,socioEconomicData.citizenship);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxCountry,socioEconomicData.countryPanel);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxLanguageSpoken,socioEconomicData.languagespoken);
			waitForPageLoad(selenium);
			click(selenium,ajkValueSelect1);
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				assertTrue(enterDate(selenium,txtDateOfArrival,socioEconomicData.arrivalDateCA),"could not enter the date; More Details :"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			}
			else{
				assertTrue(enterDate(selenium,txtDateOfArrival,socioEconomicData.arrivalDate),"could not enter the date; More Details :"+socioEconomicData.toString(), selenium, ClassName, MethodName);		
			}	
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSpokenLanguage,socioEconomicData.languagePanel);
			waitForPageLoad(selenium);
			click(selenium,ajkValueSelect1);
			if(socioEconomicData.interpreterrequired.equalsIgnoreCase("Yes")){
				if(isChecked(selenium, chkInterupterRequired)){
					assertTrue(type(selenium,txtInterupterName,socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
				}else{
					assertTrue(click(selenium,chkInterupterRequired),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired, selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtInterupterName,socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
				}
			}else if(socioEconomicData.interpreterrequired.equalsIgnoreCase("No")){
				if(isChecked(selenium, chkInterupterRequired)){
					Assert.assertTrue(click(selenium,chkInterupterRequired),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired);
				}
			}
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxParentEthnicity,socioEconomicData.parentEthnicityPanel);
			click(selenium,ajkValueSelect1);
			selectValueFromAjaxList(selenium,ajxLiveArrangements,socioEconomicData.livingArrangement);
			waitForPageLoad(selenium);
			click(selenium,ajkValueSelect1);
			selectValueFromAjaxList(selenium,ajxStudentStatus,socioEconomicData.studentStatus);
			waitForPageLoad(selenium);
			click(selenium,ajkValueSelect1);
			selectValueFromAjaxList(selenium,ajxEducationLevel,socioEconomicData.educationLevel);
			waitForPageLoad(selenium);
			click(selenium,ajkValueSelect1);
			selectValueFromAjaxList(selenium,ajxHouseHoldIncome,socioEconomicData.householdIncome);
			waitForPageLoad(selenium);
			click(selenium,ajkValueSelect1);
					
			assertTrue(selectValueFromAjaxList(selenium,txtPeopleNumber,socioEconomicData.numPeopleText),"Could not click total no of people drop down"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			
			selectValueFromAjaxList(selenium,ajxHouseHoldComposition,socioEconomicData.householdComposition);
			waitForPageLoad(selenium);
			click(selenium,ajkValueSelect1);
			assertTrue(click(selenium,chkHouseHoldIndicator),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.homelessIndicatorCheck, selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxHouseLess,socioEconomicData.homelessStatus);
			waitForPageLoad(selenium);
			click(selenium,ajkValueSelect1);
			
			if(!userAccount.equalsIgnoreCase(CAAccount))
			{
			assertTrue(click(selenium,chkSSI),"Could not check the ssi element, Expected value for check box:"+socioEconomicData.ssi, selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,ajxEmployeement,socioEconomicData.employmentStatus);
			waitForPageLoad(selenium);
			click(selenium,ajkValueSelect1);
			assertTrue(type(selenium,txtComments,socioEconomicData.comments1),"Could not type comments; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			if(!(socioEconomicData.testCaseId.equals("TC_SE_006")|| socioEconomicData.testCaseId.equals("TC_SEV_003"))){
				assertTrue(click(selenium,btnSave),"Could not click Validate Button; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
				if(!isElementPresent(selenium, lnkSocioEconomics)){
					return false;
				}
			}
			
		}
		catch (RuntimeException e){
			e.printStackTrace();
			return true;
		}
		return true;
	}

	/**
	 * createEnterPriseVariableNotes
	 * function to create EnterPrise Variable Notes
	 * @throws IOException 
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createEnterPriseVariable_Socio(Selenium selenium,HomeLib epData) throws IOException{
		try{
			assertTrue(click(selenium,lnkEnterpriseVariable),"Could not click on Identifier Group link:" + epData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			type(selenium,txtSearchBox,epData.livingType);
			click(selenium,btnEnterpriseSearch);
			waitForPageLoad(selenium);
			click(selenium,lnkDelete);
			click(selenium,btnYesButton);
			assertTrue(click(selenium,btnEnterpriseAdd),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkVariableType,epData.livingType);
			waitForPageLoad(selenium);
			type(selenium,txtVariableValue,epData.livingArrangement);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
			
		}
	}
	/*
	 * EditSocioEconomic
	 * function to edit a Socio Economic
	 * @since  	     Feb 22, 2012
	 */	
	public boolean editSocioEconomic(Selenium selenium, HomeLib socioEconomicData) throws IOException{
		
		try{	
			selectValueFromAjaxList(selenium,ajxRaceSocio,socioEconomicData.race);
			
			selectValueFromAjaxList(selenium,ajxEthniCity,socioEconomicData.ethnicity);
			
			selectValueFromAjaxList(selenium,ajxReligion,socioEconomicData.religion);
			
			selectValueFromAjaxList(selenium,ajxCitizenship,socioEconomicData.citizenship);
			
			selectValueFromAjaxList(selenium,ajxCountry,socioEconomicData.countryPanel);
			
			selectValueFromAjaxList(selenium,ajxLanguageSpoken,socioEconomicData.languagespoken);
			
			assertTrue(enterDate(selenium,txtDateOfArrival,socioEconomicData.arrivalDate),"could not enter the date; More Details :"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxSpokenLanguage,socioEconomicData.languagePanel);
			
			if(socioEconomicData.interpreterrequired.equalsIgnoreCase("Yes")){
				if(isChecked(selenium, chkInterupterRequired)){
					assertTrue(type(selenium,txtInterupterName,socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
				}else{
					assertTrue(click(selenium,chkInterupterRequired),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired, selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtInterupterName,socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
				}
			}else if(socioEconomicData.interpreterrequired.equalsIgnoreCase("No")){
				if(isChecked(selenium, chkInterupterRequired)){
					assertTrue(click(selenium,chkInterupterRequired),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired, selenium, ClassName, MethodName);
				}
			}
			assertTrue(selectValueFromAjaxList(selenium,ajxParentEthnicity,socioEconomicData.parentEthnicityPanel),"Could not get Parent Ethinicity", selenium, ClassName, MethodName);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxLiveArrangements,socioEconomicData.livingArrangement),"Could not get Living arrangement", selenium, ClassName, MethodName);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxStudentStatus,socioEconomicData.studentStatus),"Could not get Student Status", selenium, ClassName, MethodName);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxEducationLevel,socioEconomicData.educationLevel),"Could not get Education level", selenium, ClassName, MethodName);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxHouseHoldIncome,socioEconomicData.householdIncome),"Could not get House Income", selenium, ClassName, MethodName);
			
			assertTrue(selectValueFromAjaxList(selenium,txtPeopleNumber,socioEconomicData.numPeopleText),"Could not type number of people; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxHouseHoldComposition,socioEconomicData.householdComposition),"Could not select HouseHold Composition", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,chkHouseHoldIndicator),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.homelessIndicatorCheck, selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxHouseLess,socioEconomicData.homelessStatus),"Could not get House less Status", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,chkSSI),"Could not check the ssi element, Expected value for check box:"+socioEconomicData.ssi, selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxEmployeement,socioEconomicData.employmentStatus),"Could not get Employment", selenium, ClassName, MethodName);
			
			Assert.assertTrue(type(selenium,txtComments,socioEconomicData.comments1),"Could not type comments; More Details"+socioEconomicData.toString());
			if(!socioEconomicData.testCaseId.equalsIgnoreCase("TC_SE_006")){
				assertTrue(click(selenium,btnSave),"Could not click Validate Button; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			}

			if(isElementPresent(selenium, lnkSocioEconomics)){
				return true;
			}else{
				return false;
			}
		}
		catch (RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * verifySelectInSocio
	 * function to edit a Socio Economic
	 * @since  	     Feb 22, 2012
	 */	
	public boolean verifySelectInSocio(Selenium selenium, HomeLib socioEconomicData, String userAccount) throws IOException{
		boolean returnValue=false;
		try{	
			selectValueFromAjaxList(selenium,ajxRaceSocio,socioEconomicData.race);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxRaceSocio,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCurrentItemSelected)){
				if(getText(selenium,lblCurrentItemSelected).equalsIgnoreCase(socioEconomicData.race))
					{
						returnValue=true;
						click(selenium,lblCurrentItemSelected);
					}
			}
			else
				return false;	
			
			selectValueFromAjaxList(selenium,ajxEthniCity,socioEconomicData.ethnicity);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxEthniCity,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCurrentItemSelected)){
				if(getText(selenium,lblCurrentItemSelected).equalsIgnoreCase(socioEconomicData.ethnicity))
					{
						returnValue=true;
						click(selenium,lblCurrentItemSelected);
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,ajxReligion,socioEconomicData.religion);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxReligion,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCurrentItemSelected)){
				if(getText(selenium,lblCurrentItemSelected).equalsIgnoreCase(socioEconomicData.religion))
					{
						returnValue=true;
						click(selenium,lblCurrentItemSelected);
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,ajxCitizenship,socioEconomicData.citizenship);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxCitizenship,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCurrentItemSelected)){
				if(getText(selenium,lblCurrentItemSelected).equalsIgnoreCase(socioEconomicData.citizenship))
					{
						returnValue=true;
						click(selenium,lblCurrentItemSelected);
					}
			}
			else
				return false;	

			selectValueFromAjaxList(selenium,ajxCountry,socioEconomicData.countryPanel);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxCountry,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCurrentItemSelected)){
				if(getText(selenium,lblCurrentItemSelected).equalsIgnoreCase(socioEconomicData.countryPanel))
					{
						returnValue=true;
						click(selenium,lblCurrentItemSelected);
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,ajxLanguageSpoken,socioEconomicData.languagespoken);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxLanguageSpoken,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCurrentItemSelected)){
				if(getText(selenium,lblCurrentItemSelected).equalsIgnoreCase(socioEconomicData.languagespoken))
					{
						returnValue=true;
						click(selenium,lblCurrentItemSelected);
					}
			}
			else
				return false;	

			if(userAccount.equalsIgnoreCase(CAAccount)){				
				assertTrue(enterDate(selenium,txtDateOfArrival,socioEconomicData.arrivalDateCA),"could not enter the date; More Details :"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			}
			else{				
				assertTrue(enterDate(selenium,txtDateOfArrival,socioEconomicData.arrivalDate),"could not enter the date; More Details :"+socioEconomicData.toString(), selenium, ClassName, MethodName);		
			}		
			
			selectValueFromAjaxList(selenium,ajxSpokenLanguage,socioEconomicData.languagePanel);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxSpokenLanguage,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCurrentItemSelected))
			{
				if(getText(selenium,lblCurrentItemSelected).equalsIgnoreCase(socioEconomicData.languagePanel))
					{
						returnValue=true;
						click(selenium,lblCurrentItemSelected);
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,ajxParentEthnicity,socioEconomicData.parentEthnicityPanel);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxParentEthnicity,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCurrentItemSelected)){
				if(getText(selenium,lblCurrentItemSelected).equalsIgnoreCase(socioEconomicData.parentEthnicityPanel))
					{
						returnValue=true;
						click(selenium,lblCurrentItemSelected);
					}
			}
			else
				return false;	
			/*selectValueFromAjaxList(selenium,ajxLiveArrangements,socioEconomicData.livingArrangement);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxLiveArrangements,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(socioEconomicData.livingArrangement))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;*/	
			selectValueFromAjaxList(selenium,ajxStudentStatus,socioEconomicData.studentStatus);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxStudentStatus,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCurrentItemSelected)){
				if(getText(selenium,lblCurrentItemSelected).equalsIgnoreCase(socioEconomicData.studentStatus))
					{
						returnValue=true;
						click(selenium,lblCurrentItemSelected);
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,ajxEducationLevel,socioEconomicData.educationLevel);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxEducationLevel,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCurrentItemSelected)){
				if(getText(selenium,lblCurrentItemSelected).equalsIgnoreCase(socioEconomicData.educationLevel))
					{
						returnValue=true;
						click(selenium,lblCurrentItemSelected);
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,ajxHouseHoldIncome,socioEconomicData.householdIncome);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxHouseHoldIncome,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCurrentItemSelected)){
				if(getText(selenium,lblCurrentItemSelected).equalsIgnoreCase(socioEconomicData.householdIncome))
					{
						returnValue=true;
						click(selenium,lblCurrentItemSelected);
					}
			}
			else
				return false;	
			
			selectValueFromAjaxList(selenium,ajxHouseHoldComposition,socioEconomicData.householdComposition);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxHouseHoldComposition,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCurrentItemSelected)){
				if(getText(selenium,lblCurrentItemSelected).equalsIgnoreCase(socioEconomicData.householdComposition))
					{
						returnValue=true;
						click(selenium,lblCurrentItemSelected);
					}
			}
			else
				return false;	
			assertTrue(click(selenium,chkHouseHoldIndicator),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.homelessIndicatorCheck, selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxHouseLess,socioEconomicData.homelessStatus);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxHouseLess,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCurrentItemSelected)){
				if(getText(selenium,lblCurrentItemSelected).equalsIgnoreCase(socioEconomicData.homelessStatus))
					{
						returnValue=true;
						click(selenium,lblCurrentItemSelected);
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,ajxEmployeement,socioEconomicData.employmentStatus);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajxEmployeement,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCurrentItemSelected)){
				if(getText(selenium,lblCurrentItemSelected).equalsIgnoreCase(socioEconomicData.employmentStatus))
					{
						returnValue=true;
						click(selenium,lblCurrentItemSelected);
					}
			}
			else
				return false;			
		}
		catch (RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}

	/**
	 * createConsent
	 * function to verify the selected option in the select boxes
	 * @throws IOException 
	 * @since  	    July 06, 2012
	 */	
	public boolean verifySelectOptionsConsents(Selenium selenium, HomeLib consentData) throws IOException{
		boolean returnValue = false;
		try{	
					
			selectValueFromAjaxList(selenium,ajkConsentsType, consentData.consentType);
			click(selenium,ajkValueSelect1);
			selenium.clickAt(ajkConsentsType,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(consentData.consentType))
				{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;		
		/*	selectValueFromAjaxList(selenium,ajkConsentsName, consentData.consentName);
			selenium.clickAt(ajkConsentsName,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(consentData.consentName))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;		*/
			selectValueFromAjaxList(selenium,ajkStatus, consentData.status);
			selenium.clickAt(ajkStatus,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(consentData.status))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;
			if (isElementPresent(selenium, "reasonForInactivationsuggestBox"))
			selectValueFromAjaxList(selenium,"reasonForInactivationsuggestBox",consentData.inactivation);
			selenium.clickAt(ajkStatus,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(consentData.status))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;
			assertTrue(click(selenium,rdoSubstitude),"Could not select the susbstitution maker; More Details :" + consentData.toString(), selenium, ClassName, MethodName);
			waitForElementToEnable(selenium,ajkRelationship);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkRelationship,consentData.relationship);
			selenium.clickAt(ajkStatus,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(consentData.status))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;
			waitForPageLoad(selenium);
				
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + consentData.toString());
		}
		return returnValue;
	}

	
	/**
	 * goToConsents
	 * function to create a Consents
	 * @since  	     APR 09, 2012
	 */	
	public boolean goToConsents(Selenium selenium){
		try{
			click(selenium,lnkConsentsPatient);
			waitForPageLoad(selenium);
			if(waitForElement(selenium, btnConsentsAdd, WAIT_TIME)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * deleteAllConsents
	 * function to create a Consents
	 * @throws IOException 
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllConsents(Selenium selenium) throws IOException{
		boolean consentsDeleted = true;
		int caseCount = 0;
		try{
			waitForElement(selenium, lnkConsentsDelete, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lnkConsentsDelete) > 0){
				caseCount = (Integer) selenium.getXpathCount(lnkConsentsDelete);
				assertTrue(click(selenium,lnkConsentsDelete)," ", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYesButton)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount(lnkConsentsDelete)){
					consentsDeleted = false;
					break;
				}
			}
			return consentsDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * Go To Add Consents
	 * function to navigate to add consent
	 * @since  	     APR 09, 2012
	 */
	public boolean goToAddConsent(Selenium selenium){
		try{
			assertTrue(click(selenium,btnConsentsAdd), "Could not click Add Consent", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(waitForElement(selenium, ajkConsentsType, WAIT_TIME)){
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * createEnterPriseForConsents
	 * function to Create EnterPrise For Consents
	 * @throws IOException 
	 * @since  	    sep 21, 2012
	 */	
	public boolean createEnterPriseForConsents(Selenium selenium,HomeLib epData) throws IOException{
		
		try{
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEnterpriseVariable ),"Could not click on enterPrise Link:" + epData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtSearchBox,epData.consentType)," ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEnterpriseSearch)," ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!getText(selenium,"//td[2]/div/span").trim().contains(epData.consentType.trim())){
				assertTrue(click(selenium,btnEnterpriseAdd),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajkVariableType,epData.consentValue);
				type(selenium,txtVariableValue,epData.consentType);
				click(selenium,btnSave);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtSearchBox,epData.consentType)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnEnterpriseSearch)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(getText(selenium,"//td[2]/div/span").trim().contains(epData.consentType.trim())){
					return true;
				}
				else{
					return false;
				}
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			
		}
		return true;
	}
	/**
	 * createSSConsents
	 * function to create SSConsents 
	 * @since  	     May 18, 2012
	 */	
	public boolean createSSConsents(Selenium selenium,HomeLib consentData){
		try{
			
			selectValueFromAjaxList(selenium,ajkSSConsentsType,consentData.consentType);
			
			assertTrue(type(selenium,txtSSConsentsName,consentData.consentName),"Could not enter the consent name; More Details :" + consentData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtSSValidNumber,consentData.validFor),"Could not the valid for; More Details"+consentData.toString(), selenium, ClassName, MethodName);
			select(selenium,ajkSSValidType,consentData.validForType);
			
			selectValueFromAjaxList(selenium,ajkSSRestrictionLevel,consentData.restrictionLevel);
			
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ consentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + consentData.toString());		
			return false;
		}
	}
	/**
	 * userRoleValidaitonForChartManagement
	 * function to validate the user role with no access and full access
	 * @throws IOException 
	 * @since  Nov 10, 2014
	 */	
	
	public boolean userRoleValidaitonForChartManagement(Selenium selenium,HomeLib patientData)throws IOException
    {
		
		assertTrue(click(selenium,lnkSettings),"Could not click on the quick action link",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkSecuritySettingAction),"Could not click the systemSettings link;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkUserRole),"Unable to click the userroles tab",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		while(isElementVisible(selenium,moreLinkForUserRole))
		{
			click(selenium,moreLinkForUserRole);
		}
		if(!isTextPresent(selenium,patientData.switchRole))
		{
		    assertTrue(click(selenium,addNewBtn),"Unable to click the add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		    assertTrue(type(selenium,txtBoxUserRoleName,patientData.switchRole),"Unable to enter the user name",selenium,ClassName,MethodName);
		    assertTrue(type(selenium,txtBoxUserRoleDescription,patientData.description),"Unable to enter the description",selenium,ClassName,MethodName);
		    assertTrue(selectValueFromAjaxList(selenium,ajxListHomePageView,patientData.view),"Unable to enter the homepage view",selenium,ClassName,MethodName);
		    if(patientData.testCaseId.equals("TC_VSP_007"))
		    {
		    assertTrue(click(selenium,chkBoxChartManagement),"Unable to click the check box",selenium,ClassName,MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(click(selenium,btnSave),"Unable to click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		    }
		    if(patientData.testCaseId.equals("TC_VSP_008"))
		    {
		    assertTrue(click(selenium,chkBoxSystemSettings),"Unable to click the check box",selenium,ClassName,MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(click(selenium,btnSave),"Unable to click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		    }
		}
		
		return true;
		
	}
	/**
	 * verifyCreateConsents
	 * function to create consents
	 * @throws IOException 
	 * @since  	    Feb 21, 2012
	 */	
	public boolean createConsent(Selenium selenium, HomeLib consentData) throws IOException{
		boolean returnValue = true;
		try{	
					
			selectValueFromAjaxList(selenium,ajkConsentsType, consentData.consentType);
			
			selectValueFromAjaxList(selenium,ajkConsentsName, consentData.consentName);
			
			selectValueFromAjaxList(selenium,ajkStatus, consentData.status);
			
			if (isElementPresent(selenium, ajkInactivation))
			selectValueFromAjaxList(selenium,ajkInactivation,consentData.inactivation);
			assertTrue(enterDate(selenium,txtDateSigned, consentData.dateSigned),"Could not enter date; More Details :" + consentData.toString(), selenium, ClassName, MethodName);
			
			 if(consentData.signedBy.equalsIgnoreCase("Substitution Decision Maker")){
				assertTrue(click(selenium,rdoSubstitude),"Could not select the susbstitution maker; More Details :" + consentData.toString(), selenium, ClassName, MethodName);
				waitForElementToEnable(selenium,ajkRelationship);
				
				selectValueFromAjaxList(selenium,ajkRelationship,consentData.relationship);
			
				assertTrue(type(selenium,txtFirstName,consentData.firstName),"Could not enter the first name; More Details :" + consentData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLastName,consentData.lastName),"Could not enter last name; More Details :" + consentData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			 }
			 else if(!consentData.testCaseId.equals("TC_NC_005")){
				 assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentData.toString(), selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				 
				if(!isElementPresent(selenium, btnConsentsAdd)){
					return false;
				}
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + consentData.toString());
		}
		 return returnValue;
	}

	/**
	 * createHealthCare
	 * function to create a HealthCare
	 * @throws IOException 
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createHealthCare(Selenium selenium, HomeLib healthTestData,HomeLib epData,String account) throws IOException{
		boolean returnValue = false;
		try{	
			selectValueFromAjaxList(selenium,ajkSuggestBox,healthTestData.teamName);
			//Assert.assertTrue(click(selenium,btnSearch),"Could not click the Search button;More Details:"+healthTestData.toString());
			//waitForPageLoad(selenium);
			//waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//selectValueFromAjaxList(selenium,txtSearchTextBox,"a");
			//selenium.keyPress(txtSearchTextBox, "\\13");
			
			assertTrue(type(selenium,txtSearchTextBox,"a"),"Could not Enter the data;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			selenium.typeKeys(txtSearchTextBox, "a");
			waitForPageLoad(selenium);
			if(healthTestData.itemCheckBox.equals("Yes")){
				if(!isChecked(selenium,chkCheckBox))
					assertTrue(click(selenium,chkCheckBox),"Could not click Item check box ; More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			
			
			if(account.equalsIgnoreCase(CAAccount)){
				
				if(healthTestData.pcpCheckbox.equals("Yes")){
					assertTrue(click(selenium,"//input[starts-with(@id,'pcp')]"),"Could not click the pcp check box;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
				}
				if(healthTestData.teamLead.equals("Yes")){
					assertTrue(click(selenium,"//input[starts-with(@id,'teamLead')]"),"Could not click the Team Lead check box;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
				}				
				
			}
			else{
			
				if(healthTestData.pcpCheckbox.equals("Yes")){
					assertTrue(click(selenium,"//input[starts-with(@id,'pcp')]"),"Could not click the pcp check box;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
				}
				if(healthTestData.teamLead.equals("Yes")){
					assertTrue(click(selenium,"//input[starts-with(@id,'teamLead')]"),"Could not click the Team Lead check box;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
				}			
			
			}
							
			
			waitForPageLoad(selenium);
			if(healthTestData.duration.equals("End By")){
				selectValueFromAjaxList(selenium,"//input[starts-with(@id,'durationSuggest')]",healthTestData.duration);
										
				if(account.equalsIgnoreCase(CAAccount)){				
					assertTrue(enterDate(selenium,"//input[starts-with(@id,'endBy')]",healthTestData.endDateCA),"could not enter the date; More Details :"+healthTestData.toString(), selenium, ClassName, MethodName);
					if(isElementPresent(selenium,"xpath=(//input[starts-with(@id,'teamRoleSuggestBox')])[2]")){
					
					selectValueFromAjaxList(selenium,"xpath=(//input[starts-with(@id,'teamRoleSuggestBox')])[2]",epData.role);}
					else
					{
						selectValueFromAjaxList(selenium,"//input[starts-with(@id,'teamRoleSuggestBox')]",epData.role);
					}
					if(isElementPresent(selenium,btnErrorClose))
					{
						click(selenium,btnErrorClose);
					}
				}
				else{
					
					assertTrue(enterDate(selenium,"//input[starts-with(@id,'endBy')]",healthTestData.endDate),"could not enter the date; More Details :"+healthTestData.toString(), selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,"//input[starts-with(@id,'teamRoleSuggestBox')]",epData.role);
				}				
			
						
			}
			
			else if(healthTestData.duration.equals("End After")){
				selectValueFromAjaxList(selenium,ajkDuration,healthTestData.duration);
				if(account.equals(CAAccount)){
					assertTrue(type(selenium,txtEndNumberCA,healthTestData.endNumber),"Could not enther the number : More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajxTimePeriodCA,healthTestData.timeperiod);
				
					selectValueFromAjaxList(selenium,ajkRoleCA,epData.role);
				}else{
					assertTrue(type(selenium,txtEndNumber,healthTestData.endNumber),"Could not enther the number : More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajxTimePeriod,healthTestData.timeperiod);
							
					selectValueFromAjaxList(selenium,ajkRole,epData.role);
				}
			}else if(healthTestData.location.equals(ajxLocation)){
				waitForElementToEnable(selenium,ajxLocation);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxLocation,healthTestData.location);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxSpeciality,healthTestData.specialty);
			}
			
			if(!healthTestData.testCaseId.equals("TC_HCT_005")){
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + healthTestData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);		
				if(isElementPresent(selenium, btnEdit)){
					return true;
				}else{
					return false;
				}
			}
			returnValue=true;
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + healthTestData.toString());
		}
		return returnValue;
	}
	
	/**
	 * deleteAllHealthCareteam
	 * function to delete All Health Care team
	 * @throws IOException 
	  * @since  	    Aug 14, 2012
	 */
	public boolean deleteAllHealthCareteam(Selenium selenium,HomeLib epData,String account) throws IOException{
		boolean hctTeamDeleted = true;
		int hctCount = 0;
		try{
			waitForElement(selenium, lnkDeleteHelthCareTeam, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lnkDeleteHelthCareTeam) > 0){
				hctCount = (Integer) selenium.getXpathCount(lnkDeleteHelthCareTeam);
				assertTrue(click(selenium,lnkDeleteHelthCareTeam), " ", selenium, ClassName, MethodName);
				click(selenium, btnYesButton);
				
				selectValueFromAjaxList(selenium,ajkSuggestBox,epData.reasonForDeleteCA);
				//selectValueFromAjaxList(selenium,ajkSuggestBox,epData.reasonForDelete);
				if(isElementPresent(selenium,ajkValueSelect2))
					click(selenium,ajkValueSelect2);
				waitForPageLoad(selenium);
				click(selenium,txtDeleteReason);
				waitForPageLoad(selenium);
				if(hctCount == (Integer) selenium.getXpathCount(lnkDeleteHelthCareTeam)){
					hctTeamDeleted = false;
					break;
				}
			}
			return hctTeamDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}


	
	/**
	 * deleteAllHealthCareteams_Unit
	 * function to deleteAllHealthCareteams_Unit
	 * @throws IOException 
	 * @since  	    Aug 14, 2012
	 */
	public boolean deleteAllHealthCareteams_Unit(Selenium selenium,HomeLibUnitTest epData) throws IOException{
		boolean hctTeamDeleted = true;
		int hctCount = 0;
		try{
			waitForElement(selenium, lnkDeleteHelthCareTeam, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lnkDeleteHelthCareTeam) > 0){
				hctCount = (Integer) selenium.getXpathCount(lnkDeleteHelthCareTeam);
				assertTrue(click(selenium,lnkDeleteHelthCareTeam)," ", selenium, ClassName, MethodName);
				click(selenium,btnYesButton);
				selectValueFromAjaxList(selenium,ajkSuggestBox,"User Defined1");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,ajkValueSelect2))
					click(selenium,ajkValueSelect2);
				waitForPageLoad(selenium);
				click(selenium,txtDeleteReason);
				waitForPageLoad(selenium);
				if(hctCount == (Integer) selenium.getXpathCount(lnkDeleteHelthCareTeam)){
					hctTeamDeleted = false;
					break;
				}
			}
			return hctTeamDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * verifySelectOptionsHealthCare
	 * function to verify the select options in Health Care
	 * @throws IOException 
	 * @since  	    July 06, 2012
	 */	
	public boolean verifySelectOptionsHealthCare(Selenium selenium, HomeLib healthTestData,HomeLib epData) throws IOException{
		boolean returnValue = false;
		try{	
						
			selectValueFromAjaxList(selenium,ajkSuggestBox,healthTestData.teamName);
			selenium.clickAt(ajkSuggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected)){
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(healthTestData.teamName))
						returnValue=true;
						click(selenium,lblItemSelected);
			}else
				return false;			
			assertTrue(type(selenium,txtSearchTextBox,"t"),"Could not click the Search button;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			selenium.typeKeys(txtSearchTextBox,"\\b");			
			waitForPageLoad(selenium);			
			if(healthTestData.itemCheckBox.equals("Yes")){
			assertTrue(click(selenium,chkCheckBox),"Could not click Item check box ; More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			}			
			if(healthTestData.duration.equals("End After")){
			selectValueFromAjaxList(selenium,ajkDuration,healthTestData.duration);
				if(getValue(selenium,ajkDuration).equalsIgnoreCase(healthTestData.duration))
					{
						returnValue=true;
					}
			     else
			     {
				return false;
			     }
			}
		}
			/*Assert.assertTrue(type(selenium,txtEndNumber,healthTestData.endNumber),"Could not enther the number : More Details:"+healthTestData.toString());
			selectValueFromAjaxList(selenium,ajxTimePeriod,healthTestData.timeperiod);
			selenium.clickAt(ajxTimePeriod,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected)){
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(healthTestData.timeperiod))
					if(isElementPresent(selenium,ajkPopupBox)){
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}else
				return false;*/
			
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + healthTestData.toString());
		}
		return returnValue;
	}
	/**
	 * searchHealthCare
	 * function to search HealthCare
	 * @throws IOException 
	 * @since  	    May 15, 2012
	 */	
	public boolean searchHealthCare(Selenium selenium, HomeLib healthTestData,HomeLib epData,String account) throws IOException{
		boolean returnValue = false;
		try{	
						
			selectValueFromAjaxList(selenium,ajkSuggestBox,healthTestData.teamName);
			
			assertTrue(type(selenium,txtSearchTextBox,healthTestData.searchName+" "),"Could not type Name;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			
			selenium.typeKeys(txtSearchTextBox,"\\b");			
			waitForPageLoad(selenium);
			
			if(healthTestData.itemCheckBox.equals("Yes")){
			assertTrue(click(selenium,chkCheckBox),"Could not click Item check box ; More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			if(healthTestData.pcpCheckbox.equals("Yes")){
				assertTrue(click(selenium,"//input[starts-with(@id,'pcp')]"),"Could not click the pcp check box;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			}
			if(healthTestData.teamLead.equals("Yes")){
				assertTrue(click(selenium,"//input[starts-with(@id,'teamLead')]"),"Could not click the Team Lead check box;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			if(healthTestData.duration.equals("End By")){
				selectValueFromAjaxList(selenium,ajkDuration,healthTestData.duration);
										
				if(account.equalsIgnoreCase(CAAccount)){				
					assertTrue(enterDate(selenium,"//input[starts-with(@id,'endBy')]",healthTestData.endDate1),"could not enter the date; More Details :"+healthTestData.toString(), selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajkRoleCA,epData.role);
				}
				else{
					
					assertTrue(enterDate(selenium,txtEndDate,healthTestData.endDate),"could not enter the date; More Details :"+healthTestData.toString(), selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajkRole,epData.role);
				}				
			
						
			}else if(healthTestData.duration.equals("End After")){
				selectValueFromAjaxList(selenium,ajkDuration,healthTestData.duration);
				if(account.equals(CAAccount)){
					assertTrue(type(selenium,txtEndNumberCA,healthTestData.endNumber),"Could not enther the number : More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajxTimePeriodCA,healthTestData.timeperiod);
				
					selectValueFromAjaxList(selenium,ajkRoleCA,epData.role);
				}else{
					assertTrue(type(selenium,txtEndNumber,healthTestData.endNumber),"Could not enther the number : More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajxTimePeriod,healthTestData.timeperiod);
				
					selectValueFromAjaxList(selenium,ajkRole,epData.role);
				}
		
			}else if(healthTestData.location.equals(ajxLocation)){
				waitForElementToEnable(selenium,ajxLocation);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxLocation,healthTestData.location);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxSpeciality,healthTestData.specialty);
			}
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + healthTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			if(isElementPresent(selenium, btnEdit)){
				return true;
			}else{
				return false;
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + healthTestData.toString());
		}
		return returnValue;
	}

	/**
	 * createEnterPriseVariable
	 * function to create EnterPriseVariable
	 * @throws IOException 
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createEnterPriseVariable(Selenium selenium,HomeLib epData) throws IOException{
		boolean returnValue = false;
		try{
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEnterpriseVariable),"Could not click on Identifier Group link:" + epData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			type(selenium,txtSearchBox,epData.role);
			click(selenium,btnEnterpriseVariableSearch);
			waitForPageLoad(selenium);
			
			click(selenium,lnkDelete);
			waitForPageLoad(selenium);
			click(selenium,btnYesButton);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnEnterpriseAdd),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkVariableType,epData.roleType);
			waitForPageLoad(selenium);
			type(selenium,txtBoxValue,epData.role);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			
			type(selenium,txtSearchBox,epData.reasonForDelete);
			click(selenium,btnEnterpriseVariableSearch);
			waitForPageLoad(selenium);
			
			click(selenium,lnkDelete);
			waitForPageLoad(selenium);
			click(selenium,btnYesButton);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEnterpriseAdd),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkVariableType,epData.reasonForDeleteType);
			waitForPageLoad(selenium);
			type(selenium,txtBoxValue,epData.reasonForDelete);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			
			type(selenium,txtSearchBox,epData.specialty);
			click(selenium,btnEnterpriseVariableSearch);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			click(selenium,lnkDelete);
			waitForPageLoad(selenium);
			click(selenium,btnYesButton);
			assertTrue(click(selenium,btnEnterpriseAdd),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkVariableType,epData.specialtyValue);
			waitForPageLoad(selenium);
			type(selenium,txtBoxValue,epData.specialty);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return returnValue;
			
		}
	}
	
	/**
	 * createAdminEnterPriseVariable
	 * function to create Admin EnterPriseVariable
	 * @throws IOException 
	 * @since  	    Aug 21, 2012
	 */	
	public boolean createAdminEnterPriseVariable(Selenium selenium,HomeLib epData) throws IOException{
		boolean returnValue = false;
		try{
			assertTrue(click(selenium,lnkEnterpriseVariable),"Could not click on Identifier Group link:" + epData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			type(selenium,txtSearchBox,epData.role);
			click(selenium,btnEnterpriseVariableSearch);
			waitForPageLoad(selenium);
			click(selenium,lnkDelete);
			waitForPageLoad(selenium);
			click(selenium,btnYesButton);
			assertTrue(click(selenium,btnEnterpriseAdd),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkVariableType,epData.roleType);
			waitForPageLoad(selenium);
			type(selenium,txtBoxValue,epData.role);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			
			type(selenium,txtSearchBox,epData.reasonForDelete);
			click(selenium,btnEnterpriseVariableSearch);
			waitForPageLoad(selenium);
			click(selenium,lnkDelete);
			waitForPageLoad(selenium);
			click(selenium,btnYesButton);
			assertTrue(click(selenium,btnEnterpriseAdd),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkVariableType,epData.reasonForDeleteType);
			waitForPageLoad(selenium);
			type(selenium,txtBoxValue,epData.reasonForDelete);
			click(selenium,btnSave);
			
			type(selenium,txtSearchBox,epData.reason);
			click(selenium,btnEnterpriseVariableSearch);
			waitForPageLoad(selenium);
			click(selenium,lnkDelete);
			waitForPageLoad(selenium);
			click(selenium,btnYesButton);
			assertTrue(click(selenium,btnEnterpriseAdd),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkVariableType,epData.deleteValue);
			waitForPageLoad(selenium);
			type(selenium,txtBoxValue,epData.reason);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return returnValue;
			
		}
	}
	
	/**
	 * deleteAllAdminHCT
	 * function to delete All Admin HCT
	 * @throws IOException 
	  * @since  	     APR 09, 2012
	 */
	public boolean deleteAdminHCT(Selenium selenium,HomeLib epData) throws IOException{
		boolean adminHCTDeleted = true;
		int caseCount = 0;
		try{
			assertTrue(type(selenium,txtSearchBox,epData.teamName),"Could not type the first name; More Details"+epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnEnterpriseVariableSearch),"Could not click the search button"+epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForElement(selenium, lnkDeleteHealthCareList, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lnkDeleteHealthCareList) > 0){
				caseCount = (Integer) selenium.getXpathCount(lnkDeleteHealthCareList);
				assertTrue(click(selenium,lnkDeleteHealthCareList)," ", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajkSuggestBox,epData.reason);
				click(selenium,ajkValueSelect2);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnDeleteReason)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount(lnkConsentsDelete)){
					adminHCTDeleted = false;
					break;
				}
			}
			return adminHCTDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * createHealthCareTeam
	 * function to create a HealthCare Team 
	 * @throws IOException 
	 * @since  	     May 21, 2012
	 */	
	
	public boolean createAdminHealthCareTeam(Selenium selenium,HomeLib epData,String uniqueName) throws IOException{
		
		try{
			if(epData.global.equals("Yes")){
				assertTrue(click(selenium,chkCheckBox),"Could not click the globle ration button;More details:"+epData.toString(), selenium, ClassName, MethodName);
			}
			else{
					assertTrue(click(selenium,rdoSubstitude),"Could no click the radio button: More details"+epData.toString(), selenium, ClassName, MethodName);
			}
			assertTrue(type(selenium,txtTeamName,epData.teamName+uniqueName), "Could not enter the Team Name;More deatils:"+epData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtNotes,epData.notes),"Could not enter the Notes;More details:"+epData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddMember),"Could not click the Add member button"+epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxName,epData.name);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxRole,epData.role);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveHCT),"Could not click save button;More details:"+epData.toString(), selenium, ClassName, MethodName);
			if(isElementPresent(selenium,lblTitle)){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * createEnterPriseVariable
	 * function to create EnterPriseVariable
	 * @throws IOException 
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createEnterPriseVariable_HCT_UnitTest(Selenium selenium,HomeLibUnitTest epData) throws IOException{
		boolean returnValue = false;
		try{
			assertTrue(click(selenium,lnkEnterpriseVariable),"Could not click on Enter Prise Variable link:" + epData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			type(selenium,txtSearchBox,epData.reasonForDelete);
			click(selenium,btnEnterpriseVariableSearch);
			waitForPageLoad(selenium);
			click(selenium,lnkDelete);
			waitForPageLoad(selenium);
			click(selenium,btnYesButton);
			assertTrue(click(selenium,btnEnterpriseAdd),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkVariableType,epData.reasonForDeleteType);
			waitForPageLoad(selenium);
			type(selenium,txtBoxValue,epData.reasonForDelete);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return returnValue;
			
		}
	}

	/**
	 * createProgram
	 * function to create a Program
	 * @throws IOException 
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createProgram(Selenium selenium, HomeLib programData,String account) throws IOException{
		
		try{	
			selectValueFromAjaxList(selenium,ajkSuggestBox, programData.program);
			
			if(account.equalsIgnoreCase(CAAccount)){			
				assertTrue(enterDate(selenium,txtFromDate, programData.fromdateCA),"Could not enter date; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtToDate,programData.todateCA),"Could not enter the date; More Details :" + programData.toString(), selenium, ClassName, MethodName);				
			}
			else{				
				assertTrue(enterDate(selenium,txtFromDate, programData.fromdate),"Could not enter date; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtToDate,programData.todate),"Could not enter the date; More Details :" + programData.toString(), selenium, ClassName, MethodName);				
			}			
			
			assertTrue(enterDate(selenium,txtPrior,programData.priorstate),"Could not enter the Prior State value; More Details :" + programData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtOutCome,programData.outcome),"Could not enter the Outcome value; More Details :" + programData.toString(), selenium, ClassName, MethodName);
			if(programData.testCaseId.equals("TC_P_005")){
				selectValueFromAjaxList(selenium,ajxReferalSource, programData.refFrom);
				selectValueFromAjaxList(selenium,ajxReferedTo, programData.referredTo);
				waitForPageLoad(selenium);				
				
				if(account.equalsIgnoreCase(CAAccount)){					
					assertTrue(enterDate(selenium,txtReferralDate, programData.refDateCA),"Could not enter referral date; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				}
				else{					
					assertTrue(enterDate(selenium,txtReferralDate, programData.refDate),"Could not enter referral date; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				}													
				
			}
			if(!programData.testCaseId.equals("TC_P_008")){
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + programData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose)){
				assertTrue(click(selenium, btnErrorClose)," ", selenium, ClassName, MethodName);
				click(selenium,btnSave);
				waitForPageLoad(selenium);
			}
			
			if(isElementPresent(selenium, lblPatientContactList)){
				return true;
			}else{
				return false;
			}
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + programData.toString());		
			return false;
		}
		return true;
	}


	/**
	 * deleteAllIdentifiersTypes
	 * function to delete All Identifiers Types
	 * @throws IOException 
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllPrograms(Selenium selenium) throws IOException{
		boolean identiferDeleted = true;
		int caseCount = 0;
		try{
			
			while(isElementPresent(selenium,lnkDeleteIdentifierType1)){
				if(selenium.isVisible(lnkDeleteIdentifierType1)){
					selenium.isElementPresent(lnkDeleteIdentifierType1);
					assertTrue(click(selenium,lnkDeleteIdentifierType1),"Could not click delete button", selenium, ClassName, MethodName);
					assertTrue(click(selenium,btnYesButton)," ", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
			
				}
				else{
					break;
				}
				
			}
			waitForElement(selenium, lnkDeleteIdentifierType, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lnkDeleteIdentifierType) > 0){
				caseCount = (Integer) selenium.getXpathCount(lnkDeleteIdentifierType);
				assertTrue(click(selenium,lnkDeleteIdentifierType)," ", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYesButton)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount(lnkDeleteIdentifierType)){
					identiferDeleted = false;
					break;
				}
			}
			return identiferDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * verifySelectOptionsInProgram
	 * function to verify select option in the pick lists of Programs
	 * @throws IOException 
	 * @since  	    July 05, 2012
	 */	
	public boolean verifySelectOptionsInProgram(Selenium selenium, HomeLib programData) throws IOException{

		boolean returnValue=false;
		try{		
		    
			    assertTrue(type(selenium,ajkSuggestBox,programData.program), "Could not enter the program Name", selenium, ClassName, MethodName);
			    selenium.clickAt(ajkSuggestBox,"");
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lblItemSelected))
				{
					if(getText(selenium,lblItemSelected).contains(programData.program))
						{
							returnValue=true;
							click(selenium,lblItemSelected);
						}
				}
				else
					return false;	
				
		     assertTrue(type(selenium,ajxReferalSource,programData.refFrom), "Could not enter the refFrom", selenium, ClassName, MethodName);
		     selenium.clickAt(ajxReferalSource,"");
			 waitForPageLoad(selenium);
			 
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
				{
					if(getText(selenium,lblItemSelected).contains(programData.refFrom))
						{
							returnValue=true;
							click(selenium,lblItemSelected);
						}
				}
				else
					return false;	
			 assertTrue(type(selenium,ajxReferedTo,programData.referredTo), "Could not enter the referredTo", selenium, ClassName, MethodName);
			 selenium.clickAt(ajxReferedTo,"");
			 waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lblItemSelected))
				{
					if(getText(selenium,lblItemSelected).contains(programData.referredTo))
						{
							returnValue=true;
							click(selenium,lblItemSelected);
						}
				}
				else
					return false;	
			 
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + programData.toString());		
			return false;
		}
		return returnValue;
	}


	/**
	 * createReferral
	 * function to create a Referral
	 * @throws IOException 
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createReferral(Selenium selenium, HomeLib refData) throws IOException{
		
		try{		
			
			selectValueFromAjaxList(selenium,ajxReferralType, refData.refType);
			
			selectValueFromAjaxList(selenium,ajxReferredBy, refData.refBy);
			
			//waitForElementToEnable(selenium,ajxAddress);
			//waitForPageLoad(selenium);
			//selectValueFromAjaxList(selenium,ajxAddress, refData.addr);
			
			selectValueFromAjaxList(selenium,ajxReferedTo, refData.refTo);
			
			selectValueFromAjaxList(selenium,ajxReferralSpecial, refData.speciality);
			
			if(refData.testCaseId.equalsIgnoreCase("TC_CRL_007")){
				selenium.clickAt(ajxReferralDiagnoses, "");
				waitForPageLoad(selenium);
			}else
				selectValueFromAjaxList(selenium,ajxReferralDiagnoses, refData.diagCode);
			
			assertTrue(type(selenium,txtReferralReason,refData.referralReason),"Could not enter the referral Reason; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtReferralDate, refData.referralDate),"Could not enter referral date; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtReferralEndDate,refData.referralEndDate),"Could not enter the referralEndDate; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtReferralComments,refData.refComments),"Could not enter referral Comments; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddAuthorization),"Could not click on add Authorization Button; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,ajxPayer),"Could not click Save Button; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String dummy = getText(selenium,"//body/div[4]/div/div/div/div/div");
			System.out.println(dummy);
			refData.payer = dummy.split(" ")[0];
			selectValueFromAjaxList(selenium,ajxPayer, refData.payer);
			Assert.assertTrue(type(selenium,txtNumVisit,refData.numVisits1),"Could not enter numVisits1; More Details :" + refData.toString());
			selectValueFromAjaxList(selenium,ajxNumVisit,refData.numVisitType);
			//Assert.assertTrue(type(selenium,ajxNumVisit,refData.numVisitType),"Could not enter numVisits Type; More Details :" + refData.toString());
			waitForElementToEnable(selenium,txtRequestDate);
			waitForPageLoad(selenium);
			click(selenium,txtRequestDate);
			assertTrue(enterDate(selenium,txtRequestDate,refData.requestDate2),"Could not enter the request Date; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtApprovalDate);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,txtApprovalDate)," ", selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtApprovalDate,refData.approvalDate2),"Could not enter the approvalDate; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAuthorizationNum,refData.authorizationNum2),"Could not enter authorizationNum; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,txtNumAuthorizationVisit,refData.numAuthorizedVisits2),"Could not enter numAuthorizedVisits; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtStartDate1,refData.startDate2),"Could not enter the start Date; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtEndDate1,refData.endDate2),"Could not enter the end Date; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCPT, refData.cptSuggestBox2);
			
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnAddReferral)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refData.toString());		
			return false;
		}
	}
	/**
	 * createReferralWithMandatory
	 * function to create a Referral
	 * @throws IOException 
	 * @since  	     May 08, 2012
	 */	
	public boolean createReferralWithMandatory(Selenium selenium, HomeLib refData) throws IOException{
		
		try{		
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxReferralType, refData.refType);
			
			selectValueFromAjaxList(selenium,ajxReferredBy, refData.refBy);
			
			selectValueFromAjaxList(selenium,ajxReferralDiagnoses, refData.diagCode);
			
			assertTrue(enterDate(selenium,txtReferralDate, refData.referralDate),"Could not enter referral date; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			if(!refData.testCaseId.equals("TC_CRL_008")){
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			}
			if(isElementPresent(selenium, lnkReferrals)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refData.toString());		
			return false;
		}
	}

	
	/**
	 * deleteAllReferral
	 * function to delete All Referral
	 * @throws IOException 
	 * @since  	    Aug 14, 2012
	 */
	public boolean deleteAllReferral(Selenium selenium) throws IOException{
		boolean referralDeleted = true;
		int referralCount = 0;
		try{
			waitForElement(selenium, lnkDeleteReferrals, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lnkDeleteReferrals) > 0){
				referralCount = (Integer) selenium.getXpathCount(lnkDeleteReferrals);
				assertTrue(click(selenium,lnkDeleteReferrals)," ", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYesButton)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(referralCount == (Integer) selenium.getXpathCount(lnkDeleteReferrals)){
					referralDeleted = false;
					break;
				}
			}
			return referralDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * verifySelectOptionsInReferral
	 * function to verify select options a Referral
	 * @throws IOException 
	 * @since  	     July 05, 2012
	 */	
	public boolean verifySelectOptionsInPatientReferral(Selenium selenium, HomeLib refData) throws IOException{
		boolean returnValue=false;
		try{		
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxReferralType, refData.refType);
			selenium.clickAt(ajxReferralType,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(refData.refType))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,ajxReferredBy, refData.refBy);
			selenium.clickAt(ajxReferredBy,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(refData.refBy))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			/*selectValueFromAjaxList(selenium,ajxAddress, refData.addr);
			selenium.clickAt(ajxAddress,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(refData.addr))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	*/
			selectValueFromAjaxList(selenium,ajxReferedTo, refData.refTo);
			selenium.clickAt(ajxReferedTo,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(refData.refTo))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			
			/*selectValueFromAjaxList(selenium,ajxReferralSpecial, refData.speciality);
			selenium.clickAt(ajxReferralSpecial,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(refData.speciality))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	*/
			
			selectValueFromAjaxList(selenium,ajxReferralDiagnoses, refData.diagCode);
			selenium.clickAt(ajxReferralDiagnoses,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(refData.diagCode))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			assertTrue(click(selenium,btnAddAuthorization),"Could not click on add Authorization Button; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxNumVisit, refData.numVisitType);
			selenium.clickAt(ajxNumVisit,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(refData.numVisitType))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			
			/*selectValueFromAjaxList(selenium,ajxCPT1, refData.cptSuggestBox2);
			selenium.clickAt(ajxReferralSpecial,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(refData.cptSuggestBox2))
					if(isElementPresent(selenium,ajkPopupBox))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;	
			waitForPageLoad(selenium);*/
			
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refData.toString());		
			return false;
		}
		return returnValue;
	}



	/**
	 * createNotes
	 * function to create a Notes
	 * @throws IOException 
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createNotes(Selenium selenium,HomeLib noteData, String userAccount) throws IOException{
		try{
			waitForPageLoad(selenium);			
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				
				assertTrue(enterDate(selenium,txtNoteDate,noteData.notedateCA),"Could not enter date; More Details:"+noteData.toString(), selenium, ClassName, MethodName);
				
			}
			else{
				
				assertTrue(enterDate(selenium,txtNoteDate,noteData.notedate),"Could not enter date; More Details:"+noteData.toString(), selenium, ClassName, MethodName);
			
			}			
			
			selectValueFromAjaxList(selenium,ajkSuggestBox,noteData.category);
			assertTrue(type(selenium,txtNote,noteData.patientnote), "Could not type patient note; More Details :"+noteData.toString(), selenium, ClassName, MethodName);
			if(!noteData.testCaseId.equalsIgnoreCase("TC_NO_007")){
				assertTrue(click(selenium,btnSave),"Could not click save button; More Details:"+noteData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(!isElementPresent(selenium,btnAddNote)){
					return false;
				}
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + noteData.toString());		
			return false;
		}
		return true;
	}

	
	/**
	 * deleteAllIdentifiersTypes
	 * function to delete All Identifiers Types
	 * @throws IOException 
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllNotes(Selenium selenium) throws IOException{
		boolean notesDeleted = true;
		int caseCount;
		try{
			
			waitForPageLoad(selenium);
			int caseDeleteCount = (Integer) selenium.getXpathCount("//div[@id='PatientNoteList']/table/tbody/tr/td[3]/div/a");
			waitForPageLoad(selenium);
			for(caseCount = 0;caseCount< caseDeleteCount;caseCount++ ){
				assertTrue(click(selenium,lnkDeleteNotes)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnYesButton)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			return notesDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * createEnterPriseVariableNotes
	 * function to create EnterPrise Variable Notes
	 * @throws IOException 
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createEnterPriseVariables(Selenium selenium,HomeLib epData) throws IOException{
		try{
			assertTrue(click(selenium,btnEnterpriseAdd),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkVariableType,epData.variableType);
			
			type(selenium,txtBoxValue,epData.variableValue);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose)){
				return false;
			}else
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * enterPriseVariableNotes_UnitTest
	 * function to enterPriseVariableNotes_UnitTest
	 * @throws IOException 
	 * @since  	    Aug 02, 2012
	 */	
	public boolean enterPriseVariableNotes_UnitTest(Selenium selenium,HomeLibUnitTest epData) throws IOException{
		try{
			assertTrue(click(selenium,lnkEnterpriseVariable),"Could not click on Identifier Group link:" + epData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			type(selenium,txtSearchBox,epData.notesValue);
			click(selenium,btnEnterpriseVariableSearch);
			waitForPageLoad(selenium);
			click(selenium,lnkDelete);
			assertTrue(click(selenium,btnEnterpriseAdd),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkVariableType,epData.notesType);
			waitForPageLoad(selenium);
			type(selenium,txtBoxValue,epData.notesValue);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
			
		}
	}
	/**
	 * createIdentifiers
	 * function to create a Identifiers
	 * @throws IOException 
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean createIdentifier(Selenium selenium,HomeLib identifierData) throws IOException{
		try{
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxGroup,identifierData.group);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxType,identifierData.type);
			waitForPageLoad(selenium);
			 
			 assertTrue(type(selenium,txtValueMask,identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString(), selenium, ClassName, MethodName);
			/*if(identifierData.idType.contains("TestType1")){
				Assert.assertTrue(type(selenium,txtValueMask,identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString());
			}*/
		    if(identifierData.type.equalsIgnoreCase("Driver's License Number")){
			assertTrue(type(selenium,txtExpiration,identifierData.expirationdate),"Could not enter Expire date ; More Details :"+identifierData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtValueMask,identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString(), selenium, ClassName, MethodName);
		    }
		    
			assertTrue(click(selenium,btnSave),"could not click save button; More Details:"+identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblTitleHouseHold)){
				return true;
			}else{
				return false;
			} 
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
			return false;
		}
	}
	
	/**
	 * createIdentifiers
	 * function to create a Identifiers
	 * @throws IOException 
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean createIdentifierCAView(Selenium selenium,HomeLib identifierData, String userAccount) throws IOException{
		try{
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxGroup,identifierData.group);
			waitForPageLoad(selenium);
			if(userAccount.equalsIgnoreCase(CAAccount)){
				selectValueFromAjaxList(selenium,ajxType,identifierData.typeCA);
				waitForPageLoad(selenium);
			}
			else{
				selectValueFromAjaxList(selenium,ajxType,identifierData.type);
				waitForPageLoad(selenium);
			}
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtValueMask,identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString(), selenium, ClassName, MethodName);
			/*if(identifierData.idType.contains("TestType1")){
				Assert.assertTrue(type(selenium,txtValueMask,identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString());
			}*/
		    if(identifierData.type.equalsIgnoreCase("Driver's License Number")){
			assertTrue(type(selenium,txtExpiration,identifierData.expirationdate),"Could not enter Expire date ; More Details :"+identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtValueMask,identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    }
		    if(!identifierData.testCaseId.equals("TC_ID_009")){
		    	assertTrue(click(selenium,btnSave),"could not click save button; More Details:"+identifierData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,btnAddIdentifier)){
					return true;
				}else{
					return false;
				} 
		    }
		    
		    return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
			return false;
		}
	}

	/**
	 * deleteAllIdentifersGroup
	 * function to deleteAllIdentifiersGroup
	 * @throws IOException 
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllIdentifiers(Selenium selenium) throws IOException{
		boolean caseDeleted = true;
		int caseCount = 0;
		try{
			
			waitForElement(selenium, lnkDeleteIdentifier, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lnkDeleteIdentifier) > 0){
				caseCount = (Integer) selenium.getXpathCount(lnkDeleteIdentifier);
				assertTrue(click(selenium,lnkDeleteIdentifier)," ", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYesButton)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount(lnkDeleteIdentifier)){
					caseDeleted = false;
					break;
				}
			}
			return caseDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createIdGroup
	 * function to create a createIdGroup
	 * @throws IOException 
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean createIdGroup(Selenium selenium,HomeLib identifierData) throws IOException{
		boolean caseDeleted = true;
		try{
			assertTrue(click(selenium,lnkIdentifierGroup),"Could not click on Identifier Group link:" + identifierData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			int caseCount = 0;
			
				
				waitForElement(selenium, lnkDeleteIdentifierGroup, WAIT_TIME);
				while((Integer) selenium.getXpathCount(lnkDeleteIdentifierGroup) > 0){
					caseCount = (Integer) selenium.getXpathCount(lnkDeleteIdentifierGroup);
					assertTrue(click(selenium,lnkDeleteIdentifierGroup)," ", selenium, ClassName, MethodName);
					assertTrue(click(selenium,btnYesButton)," ", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if(caseCount == (Integer) selenium.getXpathCount(lnkDeleteIdentifierGroup)){
						caseDeleted = false;
						break;
					}
				}
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			select(selenium,ajxGroupFor,identifierData.groupFor);
			assertTrue(type(selenium,txtGroupName,identifierData.groupName),"Could not enter the group;More details:"+identifierData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtDescription,identifierData.groupDescription),"Could not enter the group decription;More details:"+identifierData.toString(), selenium, ClassName, MethodName);
			if(identifierData.groupDefault.equals("yes")||identifierData.groupDefault.equals("Default")){
				assertTrue(click(selenium,chkCheckBox),"Could not click the check box"+identifierData.toString(), selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnAddIdentifierGroup)){
				caseDeleted = true;
			}else{
				caseDeleted = false;
			} 
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
			}
		return caseDeleted;
		}

	/**
	 * deleteAllIdentifersGroup
	 * function to deleteAllIdentifiersGroup
	 * @throws IOException 
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllIdentifiersGroup(Selenium selenium) throws IOException{
		boolean caseDeleted = true;
		int caseCount = 0;
		try{
			
			waitForElement(selenium, lnkDeleteIdentifierGroup, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lnkDeleteIdentifierGroup) > 0){
				caseCount = (Integer) selenium.getXpathCount(lnkDeleteIdentifierGroup);
				assertTrue(click(selenium,lnkDeleteIdentifierGroup)," ", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYesButton)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount(lnkDeleteIdentifierGroup)){
					caseDeleted = false;
					break;
				}
			}
			return caseDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createIdGroupUnitTests
	 * function to create a createIdGroup
	 * @throws IOException 
	  * @since  	     Feb 22, 2012
	 */	
	
	public boolean createIdGroupUnitTests(Selenium selenium,HomeLibUnitTest identifierData) throws IOException{
		try{
			
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			select(selenium,ajxGroupFor,identifierData.groupFor);
			assertTrue(type(selenium,txtGroupName,identifierData.groupName),"Could not enter the group;More details:"+identifierData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtDescription,identifierData.groupDescription),"Could not enter the group decription;More details:"+identifierData.toString(), selenium, ClassName, MethodName);
			if(identifierData.groupDefault.equals("yes")||identifierData.groupDefault.equals("Default")){
				assertTrue(click(selenium,chkCheckBox),"Could not click the check box"+identifierData.toString(), selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnAddIdentifierGroup)){
				return true;
			}else{
				return false;
			} 
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
			}
		}
	/**
	 * createIdType 
	 * function to create a Id Type
	 * @throws IOException 
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean createIdType(Selenium selenium,HomeLib identifierData) throws IOException{
		boolean caseDeleted = true;
		int caseCount = 0;
		try{
			assertTrue(click(selenium,lnkIdentifierType),"Could not click on Identifier Group link:" + identifierData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForElement(selenium, lnkDeleteIdentifierType, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lnkDeleteIdentifierType) > 0){
				caseCount = (Integer) selenium.getXpathCount(lnkDeleteIdentifierType);
				assertTrue(click(selenium,lnkDeleteIdentifierType)," ", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYesButton)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount(lnkDeleteIdentifierType)){
					caseDeleted = false;
					break;
				}
			}
			assertTrue(click(selenium,btnAddIdentifierType),"Could not click on Add Identifier Type link:" + identifierData.toString(), selenium, ClassName, MethodName);
			
			select(selenium,ajxGroupFor,identifierData.groupFor);
		
			selectValueFromAjaxList(selenium, ajkSuggestBox,identifierData.idGroup);
			
			assertTrue(type(selenium,txtType,identifierData.idType),"Could not enter the group;More details:"+identifierData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtDescription,identifierData.typeDescription),"Could not enter the group decription;More details:"+identifierData.toString(), selenium, ClassName, MethodName);
			if(!identifierData.freeTextRadio.equalsIgnoreCase("yes")){
				assertTrue(click(selenium,"//span[@id='definedList']/input"),"Could not click on radio button; More details"+ identifierData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//span[@id='definedList']/input"),"Could not click on radio button; More details"+ identifierData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,"identifier",identifierData.identifier),"Could not enter the identifier;More details:"+identifierData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,"addID"),"Could not click on add button; More details"+ identifierData.toString(), selenium, ClassName, MethodName);
			}
			type(selenium,txtMask,identifierData.idTypeMask);
			if(identifierData.restricted.equals("Yes")){
				assertTrue(click(selenium,chkRestricted),"Could not click the reatractionlevel check box;More Details:"+identifierData.toString(), selenium, ClassName, MethodName);
			}
			if(identifierData.expDate.equals("Yes")){
				assertTrue(click(selenium,chkExpiryDate),"Could not click the reatractionlevel check box;More Details:"+identifierData.toString(), selenium, ClassName, MethodName);
			}
			
			if(identifierData.typeDefault.equals("Yes")){
				assertTrue(click(selenium,chkDefault),"Could not click the defaultType check box;More Details:"+identifierData.toString(), selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnAddIdentifierType)){
				caseDeleted= true;
			}else{
				caseDeleted= false;
			}
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
			}
		return caseDeleted;
		}

	/**
	 * createIdTypeUnitTests
	 * function to create a Id Type
	 * @throws IOException 
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean createIdTypeUnitTests(Selenium selenium,HomeLibUnitTest identifierData) throws IOException{
		try{
			
			assertTrue(click(selenium,btnAddIdentifierType),"Could not click on Add Identifier Type link:" + identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			select(selenium,ajxGroupFor,identifierData.groupFor);
		
			selectValueFromAjaxList(selenium, ajkSuggestBox,identifierData.idGroup);
		
			assertTrue(type(selenium,txtType,identifierData.idType),"Could not enter the group;More details:"+identifierData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtDescription,identifierData.typeDescription),"Could not enter the group decription;More details:"+identifierData.toString(), selenium, ClassName, MethodName);
			if(!identifierData.freeTextRadio.equalsIgnoreCase("yes")){
				assertTrue(click(selenium,"//span[@id='definedList']/input"),"Could not click on radio button; More details"+ identifierData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//span[@id='definedList']/input"),"Could not click on radio button; More details"+ identifierData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,"identifier",identifierData.identifier),"Could not enter the identifier;More details:"+identifierData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,"addID"),"Could not click on add button; More details"+ identifierData.toString(), selenium, ClassName, MethodName);
			}
			type(selenium,txtMask,identifierData.idTypeMask);
			if(identifierData.restricted.equals("Yes")){
				assertTrue(click(selenium,chkRestricted),"Could not click the reatractionlevel check box;More Details:"+identifierData.toString(), selenium, ClassName, MethodName);
			}
			if(identifierData.expDate.equals("Yes")){
				assertTrue(click(selenium,chkExpiryDate),"Could not click the reatractionlevel check box;More Details:"+identifierData.toString(), selenium, ClassName, MethodName);
			}
			
			if(identifierData.typeDefault.equals("Yes")){
				assertTrue(click(selenium,chkDefault),"Could not click the defaultType check box;More Details:"+identifierData.toString(), selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnAddIdentifierType)){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
			}
		}
	/**
	 * deleteAllIdentifiersTypes
	 * function to delete All Identifiers Types
	 * @throws IOException 
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllIdentifiersTypes(Selenium selenium) throws IOException{
		boolean identiferDeleted = true;
		int caseCount = 0;
		try{
			
			waitForElement(selenium, lnkDeleteIdentifierType, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lnkDeleteIdentifierType) > 0){
				caseCount = (Integer) selenium.getXpathCount(lnkDeleteIdentifierType);
				assertTrue(click(selenium,lnkDeleteIdentifierType)," ", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYesButton)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount(lnkDeleteIdentifierType)){
					identiferDeleted = false;
					break;
				}
			}
			return identiferDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * verifySelectOptionIdentifiers
	 * function to create a Identifiers
	 * @since  	     July 06 , 2012
	 */	
	
	public boolean verifySelectOptionIdentifiers(Selenium selenium,HomeLib identifierData){
		boolean returnValue=false;
		System.out.println("");
		try{
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxGroup,identifierData.group);
			selenium.clickAt(ajxGroup,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(identifierData.group)){
					returnValue=true;
					click(selenium,lblItemSelected);
				}
			}
			else
				return false;	
			selectValueFromAjaxList(selenium,ajxType,identifierData.type);
			selenium.clickAt(ajxType,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblItemSelected))
			{
				if(getText(selenium,lblItemSelected).equalsIgnoreCase(identifierData.type))
					{
						returnValue=true;
						click(selenium,lblItemSelected);
					}
			}
			else
				return false;
			
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
			}
		return returnValue;
		}

	
	/**
	 * editIdentifiers
	 * function to edit Identifiers
	 * @throws IOException 
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean editIdentifiers(Selenium selenium,HomeLib identifierData, String userAccount) throws IOException{
		try{
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkSuggestBox,identifierData.group);
			if(userAccount.equalsIgnoreCase(CAAccount)){
				selectValueFromAjaxList(selenium,ajxTypeIdentifier,identifierData.typeCA);
			}
			else{
				selectValueFromAjaxList(selenium,ajxTypeIdentifier,identifierData.type);
			}
			/*if(identifierData.idType.contains("TestType1")){
				Assert.assertTrue(type(selenium,txtValueMask,identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString());
			}
			    if(identifierData.idType.equalsIgnoreCase("TestType2")){
				
				Assert.assertTrue(type(selenium,txtValueMask,identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString());
				Assert.assertTrue(enterDate(selenium,txtExpiration,identifierData.expirationdate),"Could not enter Expire date ; More Details :"+identifierData.toString());
			}*/
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtValueMask,identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(identifierData.type.equalsIgnoreCase("Driver's License Number")){
				assertTrue(type(selenium,txtExpiration,identifierData.expirationdate),"Could not enter Expire date ; More Details :"+identifierData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtValueMask,identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			 }assertTrue(click(selenium,btnSave),"could not click save button; More Details:"+identifierData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblTitleHouseHold)){
				return true;
			}else{
				return false;
			} 
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
			}
		}







	
	
	/**
	 * createHousehold
	 * function to create Household
	 * @throws IOException 
	 
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean createHousehold(Selenium selenium,HomeLib householdData) throws IOException{
		try{
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnContinue)){
				click(selenium, btnContinue);
			}
			assertTrue(click(selenium,lnkSearchPatient),"could not click search patients button; More Details:"+householdData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtSearchboxHouseHold,householdData.searchpatient),"Could not enter patientID ; More Details :"+householdData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSearchHouseHold),"could not click search button; More Details:"+householdData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chkFirstHouseholdResult),"could not click the check box; More Details:"+householdData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!householdData.testCaseId.equalsIgnoreCase("TC_HH_005")){
				assertTrue(click(selenium,btnSave),"could not click the save button; More Details:"+householdData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(!isElementPresent(selenium,btnAddHouseHold)){
					return false;
				}
			}
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + householdData.toString());		
				return false;
		}
		return true;
	}

	
	/**
	 * createReferral_UnitTest
	 * function to create a new patient check-in for unit Test
	 * @throws IOException 
	 * @since  	    May 24, 2012
	 */	
	public boolean createReferral_UnitTest(Selenium selenium, HomeLibUnitTest refferalTestData) throws IOException{
		boolean returnValue = false;
		try{		
			selectValueFromAjaxList(selenium,ajxReferralType, refferalTestData.refType);
			selectValueFromAjaxList(selenium,ajxReferredBy, refferalTestData.refBy);
			/*waitForPageLoad(selenium);
			waitForElementToEnable(selenium,ajxAddress);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxAddress, refferalTestData.addr);*/
			selectValueFromAjaxList(selenium,ajxReferedTo, refferalTestData.refTo);
			selectValueFromAjaxList(selenium,ajxReferralSpecial, refferalTestData.speciality);
			selectValueFromAjaxList(selenium,ajxReferralDiagnoses, refferalTestData.diagCode);
			if(waitForElement(selenium, btnErrorClose, 5000)){
				selenium.click(btnErrorClose);
			}
			assertTrue(type(selenium,txtReferralReason,refferalTestData.referralReason),"Could not enter the referral Reason; More Details :" + refferalTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtReferralDate, refferalTestData.referralDate),"Could not enter referral date; More Details :" + refferalTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtReferralEndDate,refferalTestData.referralEndDate),"Could not enter the referralEndDate; More Details :" + refferalTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtReferralComments,refferalTestData.refComments),"Could not enter referral Comments; More Details :" + refferalTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddAuthorization),"Could not click on add Authorization Button; More Details :" + refferalTestData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxPayer,refferalTestData.payer);
			assertTrue(type(selenium,txtNumVisit,refferalTestData.numVisits1),"Could not enter numVisits1; More Details :" + refferalTestData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxNumVisit,refferalTestData.numVisitType);
			assertTrue(enterDate(selenium,txtRequestDate,refferalTestData.requestDate2),"Could not enter the request Date; More Details :" + refferalTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtApprovalDate,refferalTestData.approvalDate2),"Could not enter the approvalDate; More Details :" + refferalTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAuthorizationNum,refferalTestData.authorizationNum2),"Could not enter authorizationNum; More Details :" + refferalTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtNumAuthorizationVisit,refferalTestData.numAuthorizedVisits2),"Could not enter numAuthorizedVisits; More Details :" + refferalTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtStartDate1,refferalTestData.startDate2),"Could not enter the start Date; More Details :" + refferalTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtEndDate1,refferalTestData.endDate2),"Could not enter the end Date; More Details :" + refferalTestData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCPT, refferalTestData.cptSuggestBox2);
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + refferalTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;	
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refferalTestData.toString());		
		}
		return returnValue;
	}
	/**
	 * createIdType
	 * function to create an Identifier Group.
	 * @throws IOException 
	 
	 * @since  	     May 17, 2012
	 */	
	public boolean createIdentifierType(Selenium selenium, HomeLib idTypeData) throws IOException {
		
		try{
			selectValueFromAjaxList(selenium,ajxGroupFor,idTypeData.groupFor);
			selectValueFromAjaxList(selenium, ajkSuggestBox,idTypeData.idGroup);
			assertTrue(type(selenium,txtType,idTypeData.idType),"Could not enter the group;More details:"+idTypeData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtDescription,idTypeData.typeDescription),"Could not enter the group decription;More details:"+idTypeData.toString(), selenium, ClassName, MethodName);
			if(!idTypeData.freeTextRadio.equalsIgnoreCase("yes")){
				assertTrue(click(selenium,rdbDefinedList),"Could not click on radio button; More details"+ idTypeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,rdbDefinedList),"Could not click on radio button; More details"+ idTypeData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtIdentifier,idTypeData.identifier),"Could not enter the identifier;More details:"+idTypeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnIdentifier),"Could not click on add button; More details"+ idTypeData.toString(), selenium, ClassName, MethodName);
			}
			type(selenium,txtMask,idTypeData.idTypeMask);
			if(idTypeData.restricted.equals("Yes")){
				assertTrue(click(selenium,chkRestricted),"Could not click the reatractionlevel check box;More Details:"+idTypeData.toString(), selenium, ClassName, MethodName);
			}
			if(idTypeData.expDate.equals("Yes")){
				assertTrue(click(selenium,chkExpiryDate),"Could not click the reatractionlevel check box;More Details:"+idTypeData.toString(), selenium, ClassName, MethodName);
			}
			
			if(idTypeData.typeDefault.equals("Yes")){
				assertTrue(click(selenium,chkDefault),"Could not click the defaultType check box;More Details:"+idTypeData.toString(), selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ idTypeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lnkEditIdentifierType)){
				return true;
			}else{
				return false;
			}
		 }
		catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createIdType
	 * function to create an Identifier Group.
	 * @throws IOException 
	 * @since  	     May 17, 2012
	 */	
	public boolean createIdentifierGroup(Selenium selenium, HomeLib idGroupData) throws IOException{
		try{
			select(selenium,ajxGroupFor,idGroupData.groupFor);
			assertTrue(type(selenium,txtGroupName,idGroupData.idGroup),"Could not enter the group;More details:"+idGroupData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtDescription,idGroupData.groupDescription),"Could not enter the group decription;More details:"+idGroupData.toString(), selenium, ClassName, MethodName);
			//select(selenium,lblStatus,idGroupData.groupFor);
			Assert.assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ idGroupData.toString());
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "//a[contains(text(),'Edit')]")){
				return true;
			}else{
				return false;
			}
		 }
		catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createExternalProvider
	 * function to create an External Provider
	 * @throws IOException 
	 * @since  	    May 17, 2012
	 */	
	public boolean createExternalProvider(Selenium selenium,HomeLib  providerData,String account) throws IOException {
		
		try{
			String referringCodeUnique=null;
			Random rg = new Random(); 
		    for (int idx = 17000; idx <= 18000; ++idx){
		      int random = rg.nextInt(18000); 
		      referringCodeUnique =Integer.valueOf(random).toString();
		    }
			assertTrue(type(selenium,"referringCode",referringCodeUnique),"Could not type referring code; More Details"+providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLastName,providerData.lastName),"Could not type last name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstName,providerData.firstName),"Could not type first name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"specialtySuggestBoxIdsuggestBox",providerData.specialty);
			assertTrue(type(selenium,"addr11",providerData.epstreet11),"Could not type street name1; More Details"+providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,"addr21",providerData.epstreet12),"Could not type street name2; More Details"+providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,"city1",providerData.epcity1),"Could not type city name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
			
			if(account.equals(CAAccount)){
				assertTrue(type(selenium,"zip1",providerData.zipcodeCA),"Could not type zipcode; More Details"+providerData.toString(), selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,"stateSuggestBox1suggestBox",providerData.epstate1CA);
			}else{
				assertTrue(type(selenium,"zip1",providerData.epzipcode1),"Could not type zipcode; More Details"+providerData.toString(), selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,"stateSuggestBox1suggestBox",providerData.epstate1);
			}
			click(selenium,btnYesbutton);	
			
			
			//
			if(account.equals(CAAccount)){
				providerData.epstate1CA = getValue(selenium, "stateSuggestBox1suggestBox");
			}
			else{
				providerData.epstate1 = getValue(selenium, "stateSuggestBox1suggestBox");				
			}
			providerData.epcity1 = getValue(selenium, "city1");
			
			
			selectValueFromAjaxList(selenium,"countrySuggestBox1suggestBox",providerData.epcountry1);
			
			
			
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    if(isElementPresent(selenium, "editButtonId")){
				return true;
			}else{
				return false;
			}
		 }
		catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}


	public boolean createAddressBook(Selenium selenium, HomeLib providerData, String account) throws IOException {
		try{
			if(providerData.contactLevel.equalsIgnoreCase("Global"))
			{
				assertTrue(click(selenium,rdGlobal), "could not click contact level", selenium, ClassName, MethodName);
			}
			else{
				assertTrue(click(selenium, rdLocal), "could not click contact level", selenium, ClassName, MethodName);
			}
				
			selectValueFromAjaxList(selenium, ajxContactSuggestBox, providerData.contactType);
			assertTrue(type(selenium, txtAddContactCompany, providerData.contactCompany),"Could not Enter the Company;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxTitleSuggestBox,providerData.salutation);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,  txtAddBookLastName, providerData.lastName),"Could not enter Last Name; More Details:" + providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkFirstName, providerData.firstName),"Could not enter First Name; More Details:" + providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkMiddleName,providerData.middleName),"Could not enter the Middle name;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtJobtitle,providerData.jobTitle),"Could not Enter the Job Name;More Details"+providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkDepartment, providerData.department),"Could not enter Department; More Details:" + providerData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy1suggestBox,providerData.telephoneType1);
			assertTrue(type(selenium, txtAddBkPrimaryPhone, providerData.telephoneNo1),"Could not enter primary phone number; More Details:" + providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkPrimaryPhoneExt, providerData.telephoneextnNo1),"Could not enter primary extn number; More Details:" + providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkAdd1,providerData.address1),"Could not enter the Street1;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddrBkAdd2,providerData.address2),"Could not enter the Street2;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkCity, providerData.city),"Colud not enter the city;More Details"+providerData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxAddBkStateSuggestBox,providerData.state);
			if(account.equalsIgnoreCase(CAAccount)){
				assertTrue(type(selenium, txtAddBkZipCode, providerData.zipcodeCA),"Could not enter Zip; More Details:" + providerData.toString(), selenium, ClassName, MethodName);
			}
			else{
				assertTrue(type(selenium, txtAddBkZipCode, providerData.zipcode),"Could not enter Zip; More Details:" + providerData.toString(), selenium, ClassName, MethodName);
			}
		//selenium.keyPress(cmbAddBkCountrySuggestBox, "\\9");
			waitForPageLoad(selenium);
			click(selenium,btnYesbutton);
			selectValueFromAjaxList(selenium, ajxaddBkCountrySuggestBox,providerData.country);
			assertTrue(type(selenium, txtAddBkEmail,providerData.email),"Could not Enter the Mail;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,  txtAddBkWebAdd,providerData.webAddress),"Could not enter the Web Address;Mor Details"+providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtcmt,providerData.comments),"Could not type the Comments; More Details"+providerData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnAddSave),"Could not find save button; More Details:" + providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lblBox)){
				return true;
			}else{
				return false;
				}
			}
			catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString());
			return false;
		}
	}
	/**
	 * createAddressBookWithMandatoryField
	 * function to create Address Book With Mandatory Field
	 * @throws IOException 
	 * @since  	     May 21, 2012
	 */	
	public boolean enterPriseVariable_Addressbook(Selenium selenium, SystemSettingsLib epData) throws IOException{
		try{
			assertTrue(click(selenium,lnkEnterpriseVariable),"Could not click on Identifier Group link:" + epData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			type(selenium,txtSearchBox,epData.contactValue);
			click(selenium,btnEnterpriseVariableSearch);
			waitForPageLoad(selenium);
			click(selenium,lnkDelete);
			waitForPageLoad(selenium);
			click(selenium,btnYesButton);
			assertTrue(click(selenium,btnEnterpriseAdd),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkVariableType,epData.contactType);
			waitForPageLoad(selenium);
			type(selenium,txtBoxValue,epData.contactValue);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createMandatoryUserfields
	 * function to create Mandatory User fields
	 * @throws IOException 
	 * @since  	     May 21, 2012
	 */	
	public boolean createMandatoryUserfields(Selenium selenium, HomeLibUnitTest mandatoryData) throws IOException {
		try{
			selectValueFromAjaxList(selenium,"unitsuggestBox",mandatoryData.unit);
			
			selectValueFromAjaxList(selenium,"fieldsuggestBox",mandatoryData.field);
			
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+mandatoryData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkDeleteMandatoryField)){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + mandatoryData.toString());
			return false;
		}
	}
	

	
	/**
	 * createMandatoryUserfields
	 * function to create Mandatory User fields
	 * @throws IOException 
	 * @since  	    Jun	20, 2012
	 */	
	
	public boolean auditLog(Selenium selenium,HomeLib auditData ) throws IOException{
		try{
			selectValueFromAjaxList(selenium,"filterUserssuggestBox",auditData.filter);
			
			selectValueFromAjaxList(selenium,"filterActivitysuggestBox",auditData.filterActivity);
			
			assertTrue(click(selenium,btnSearchHouseHold),"Could not click the search button;More Details:"+auditData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"filterUserssuggestBox")){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + auditData.toString());
			return false;
		}
	}
	
	/**
	 * createSocioEconomicCAView
	 * function to create a Socio EconomicCA view
	 * @throws IOException 
	 * @since  	    june 20, 2012
	 */	
	public boolean createSocioEconomicCAView(Selenium selenium, HomeLib socioEconomicData) throws IOException{
		try{	
			
			String date="";
			selectValueFromAjaxList(selenium,ajxRaceSocio,socioEconomicData.race);
			
			selectValueFromAjaxList(selenium,ajxEthniCity,socioEconomicData.ethnicity);
			
			selectValueFromAjaxList(selenium,ajxReligion,socioEconomicData.religion);
			
			selectValueFromAjaxList(selenium,ajxCitizenship,socioEconomicData.citizenship);
			
			selectValueFromAjaxList(selenium,ajxCountry,socioEconomicData.countryPanel);
			
			selectValueFromAjaxList(selenium,ajxSpokenLanguage,socioEconomicData.languagePanel);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());
			assertTrue(enterDate(selenium,txtDateOfArrival,date),"Could not enter the expiry Date;More Details:"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			
			
			//Assert.assertTrue(enterDate(selenium,txtDateOfArrival,socioEconomicData.arrivalDate),"could not enter the date; More Details :"+socioEconomicData.toString());
			
			selectValueFromAjaxList(selenium,ajxOfficialLanguage,socioEconomicData.officialLanguage);
			
			selectValueFromAjaxList(selenium,ajxPreferredLanguage,socioEconomicData.languagespoken);
			
			//click(selenium,btnAddLanguage);			
			assertTrue(click(selenium,btnAddLanguage),"Could not click the Add more Button", selenium, ClassName, MethodName);
			
			selectValueFromAjaxList(selenium,ajxOtherLanguage,socioEconomicData.secondlanguagespoken);
			
			if(socioEconomicData.interpreterrequired.equalsIgnoreCase("YES")){
				if(!isChecked(selenium,chkInterupterRequired)){
					assertTrue(click(selenium,chkInterupterRequired),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired, selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtInterupterName,socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtInterupterService,socioEconomicData.service),"Could not type Type of service; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
				}else{
					assertTrue(type(selenium,txtInterupterName,socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtInterupterService,socioEconomicData.service),"Could not type Type of service; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
				}
				}else if(socioEconomicData.interpreterrequired.equalsIgnoreCase("No")){
				if(isChecked(selenium,chkInterupterRequired))
					assertTrue(click(selenium,chkInterupterRequired),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired, selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,ajxParentEthnicity,socioEconomicData.parentEthnicityPanel);
			
			selectValueFromAjaxList(selenium,ajxLiveArrangements,socioEconomicData.livingArrangement);
			
			selectValueFromAjaxList(selenium,ajxStudentStatus,socioEconomicData.studentStatus);
			
			selectValueFromAjaxList(selenium,ajxEducationLevel,socioEconomicData.educationLevel);
			
			selectValueFromAjaxList(selenium,ajxHouseHoldIncome,socioEconomicData.householdIncome);
			
			assertTrue(selectValueFromAjaxList(selenium,txtPeopleNumber,socioEconomicData.numPeopleText),"Could not type number of people; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxHouseHoldComposition,socioEconomicData.householdComposition);
			
			if(socioEconomicData.homelessIndicatorCheck.equalsIgnoreCase("Yes")){
				if(!isChecked(selenium,chkHouseHoldIndicator))
					assertTrue(click(selenium,chkHouseHoldIndicator),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.homelessIndicatorCheck, selenium, ClassName, MethodName);
			}else if(socioEconomicData.homelessIndicatorCheck.equalsIgnoreCase("No")){
				if(isChecked(selenium,chkHouseHoldIndicator))
					assertTrue(click(selenium,chkHouseHoldIndicator),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.homelessIndicatorCheck, selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,ajxHouseLess,socioEconomicData.homelessStatus);
			
			assertTrue(check(selenium,chkPoverty),"Could not check at risk population"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxAgeGroup,socioEconomicData.ageGroupIndicator);
			
			selectValueFromAjaxList(selenium,ajxEmployeement,socioEconomicData.employmentStatus);
			
			if(socioEconomicData.employmentStatus.equalsIgnoreCase("Employed")){
			selectValueFromAjaxList(selenium,ajxJobCode,socioEconomicData.jobCode);
			
			//Assert.assertTrue(type(selenium,txtOccupation,socioEconomicData.occupation),"Could not type occupation; More Details"+socioEconomicData.toString());
			}
			assertTrue(type(selenium,txtComments,socioEconomicData.comments1),"Could not type comments; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click Validate Button; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);

			if(isElementPresent(selenium, lnkSocioEconomics)){
				return true;
			}else{
				return false;
			}
		}
		catch (RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	 * editSocioEconomicCAView
	 * function to edit a Socio EconomicCA View
	 * @since  	    june 20, 2012
	 */	
	public boolean editSocioEconomicCAView(Selenium selenium, HomeLib socioEconomicData) throws IOException{
		
		try{	
			selectValueFromAjaxList(selenium,ajxRaceSocio,socioEconomicData.race);
			selectValueFromAjaxList(selenium,ajxEthniCity,socioEconomicData.ethnicity);
			selectValueFromAjaxList(selenium,ajxReligion,socioEconomicData.religion);
			selectValueFromAjaxList(selenium,ajxCitizenship,socioEconomicData.citizenship);
			selectValueFromAjaxList(selenium,ajxCountry,socioEconomicData.countryPanel);
			selectValueFromAjaxList(selenium,ajxLanguageSpoken,socioEconomicData.languagePanel);
			assertTrue(enterDate(selenium,txtDateOfArrival,socioEconomicData.arrivalDate),"could not enter the date; More Details :"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxOfficialLanguage,socioEconomicData.officialLanguage);
			selectValueFromAjaxList(selenium,ajxPrefferedLanguage,socioEconomicData.languagespoken);
			if(socioEconomicData.interpreterrequired.equalsIgnoreCase("YES")){
				if(!isChecked(selenium,chkInterupterRequired)){
					assertTrue(click(selenium,chkInterupterRequired),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired, selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtInterupterName,socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtInterupterService,socioEconomicData.service),"Could not type Type of service; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
				}else{
					assertTrue(type(selenium,txtInterupterName,socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtInterupterService,socioEconomicData.service),"Could not type Type of service; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
				}
				}else if(socioEconomicData.interpreterrequired.equalsIgnoreCase("No")){
				if(isChecked(selenium,chkInterupterRequired))
					assertTrue(click(selenium,chkInterupterRequired),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired, selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,ajxParentEthnicity,socioEconomicData.parentEthnicityPanel);
			selectValueFromAjaxList(selenium,ajxLiveArrangements,socioEconomicData.livingArrangement);
			selectValueFromAjaxList(selenium,ajxStudentStatus,socioEconomicData.studentStatus);
			selectValueFromAjaxList(selenium,ajxEducationLevel,socioEconomicData.educationLevel);
			selectValueFromAjaxList(selenium,ajxHouseHoldIncome,socioEconomicData.householdIncome);
			assertTrue(selectValueFromAjaxList(selenium,txtPeopleNumber,socioEconomicData.numPeopleText),"Could not type number of people; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxHouseHoldComposition,socioEconomicData.householdComposition);
			if(socioEconomicData.homelessIndicatorCheck.equalsIgnoreCase("Yes")){
				if(!isChecked(selenium,chkHouseHoldIndicator))
					assertTrue(click(selenium,chkHouseHoldIndicator),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.homelessIndicatorCheck, selenium, ClassName, MethodName);
			}else if(socioEconomicData.homelessIndicatorCheck.equalsIgnoreCase("No")){
				if(isChecked(selenium,chkHouseHoldIndicator))
					assertTrue(click(selenium,chkHouseHoldIndicator),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.homelessIndicatorCheck, selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,ajxHouseLess,socioEconomicData.homelessStatus);
			assertTrue(check(selenium,chkRural),"Could not check at risk population"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxAgeGroup,socioEconomicData.ageGroupIndicator);
			selectValueFromAjaxList(selenium,ajxEmployeement,socioEconomicData.employmentStatus);
			if(socioEconomicData.employmentStatus.equalsIgnoreCase("Employed")){
			selectValueFromAjaxList(selenium,ajxJobCode,socioEconomicData.jobCode);
			}
			assertTrue(type(selenium,txtComments,socioEconomicData.comments1),"Could not type comments; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			 if(!socioEconomicData.testCaseId.equals("TC_SEV_003"))
			 {
			assertTrue(click(selenium,btnSave),"Could not click Validate Button; More Details"+socioEconomicData.toString(), selenium, ClassName, MethodName);
			 }
			if(isElementPresent(selenium, lnkSocioEconomics)){
				return true;
			}else{
				return false;
			}
		
		}
		catch (RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * createPatientCAView
	 * function to create Patient CA View
	 * @throws IOException 
	 * @since  	     Feb 09, 2012
	 */	
	public boolean createPatientCAView(Selenium selenium, HomeLib patientData,String uniqueName) throws IOException{
		boolean returnValue = false;
		try{
			if(!patientData.patientIdchart.isEmpty())
				if(!patientData.patientIdchart.contains("N/A"))
					assertTrue(type(selenium,txtChartNumber,patientData.patientIdchart),"Could not Enter the patientId chart, Expected value to be typed" + patientData.patientIdchart, selenium, ClassName, MethodName );
			
			if(!patientData.canadianProvince.isEmpty())
				if(!patientData.canadianProvince.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,"canadianProvincesuggestBox",patientData.canadianProvince))
						fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.canadianProvince);
			
			
			
			if(!patientData.hCN.isEmpty())
				if(!patientData.hCN.contains("N/A"))
					assertTrue(type(selenium, "healthcardNumber", uniqueName), "Could not Enter Hcn, Expected value to be typed" + patientData.hCN, selenium, ClassName, MethodName);
			
			if(!patientData.reason.isEmpty())
				if(!patientData.reason.contains("N/A"))
					if(!selectValueFromAjaxListUsingTypeKeys(selenium, "reasonSuggestBoxsuggestBox", patientData.reason))
						Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.reason);
			
			if(!patientData.expireDate.isEmpty())
				if(!patientData.expireDate.contains("N/A"))
					assertTrue(enterDate(selenium, "expiryDate", patientData.expireDate), "Could not Enter expireDate , Expected value to be typed" + patientData.expireDate, selenium, ClassName, MethodName);			
			
			if(!patientData.primaryLocation.isEmpty())
				if(!patientData.primaryLocation.contains("N/A"))
					waitForPageLoad(selenium);
					if(!selectValueFromAjaxList(selenium, ajxPrimaryLocation, patientData.primaryLocation))
						Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.primaryLocation);
			
			if(!patientData.responsibleProvider.isEmpty())
				if(!patientData.responsibleProvider.contains("N/A"))
					waitForPageLoad(selenium);
					if(!selectValueFromAjaxList(selenium,ajxResponsbleProvider,patientData.responsibleProvider))
						Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.responsibleProvider);
			
			if(!patientData.pcpCheck.isEmpty())
				if(!patientData.pcpCheck.contains("No"))
					assertTrue(check(selenium, chkResponsibleProvider), "Could not check the pcp check box, Expected value for the check box : " + patientData.pcpCheck, selenium, ClassName, MethodName);
			
			if(!patientData.testCaseId.equalsIgnoreCase("TC_NPC_004")){
			if(!patientData.lastName.isEmpty())
				if(!patientData.lastName.contains("N/A"))
					assertTrue(type(selenium, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName, selenium, ClassName, MethodName);
			}
			
			if(patientData.testCaseId.equalsIgnoreCase("TC_NPC_004")){
				if(!patientData.lastName.isEmpty())
					if(!patientData.lastName.contains("N/A"))
						assertTrue(type(selenium, txtLastName, patientData.lastName+uniqueName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName, selenium, ClassName, MethodName);
				}
			
			if(!patientData.firstName.isEmpty())
				if(!patientData.firstName.contains("N/A"))
					assertTrue(type(selenium, txtFirstName, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName, selenium, ClassName, MethodName);
			if(!patientData.middleName.isEmpty())
				if(!patientData.middleName.contains("N/A"))
					assertTrue(type(selenium, txtMiddleName, patientData.middleName), "Could not Enter middle name, Expected value to be typed" + patientData.middleName, selenium, ClassName, MethodName);
			if(!patientData.title.isEmpty())
				if(!patientData.title.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxTitle, patientData.title))	
						Assert.fail("Could not Enter Title, Expected value to be selected" + patientData.title);
			if(!patientData.suffix.isEmpty())
				if(!patientData.suffix.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxSuffix, patientData.suffix))
						Assert.fail("Could not Enter Suffix, Expected value to be selected" + patientData.suffix);
			if(!patientData.alias1.isEmpty())
				if(!patientData.alias1.contains("N/A"))
					assertTrue(type(selenium, txtAlias1, patientData.alias1), "Could not Enter alias1, Expected value to be typed" + patientData.alias1, selenium, ClassName, MethodName);
			if(!patientData.alias2.isEmpty())
				if(!patientData.alias2.contains("N/A"))
					assertTrue(type(selenium, txtAlias2, patientData.alias2), "Could not Enter alias2, Expected value to be typed" + patientData.alias2, selenium, ClassName, MethodName);
			if(!patientData.dob.isEmpty())
				if(!patientData.dob.contains("N/A"))
					assertTrue(enterDate(selenium, txtDOB, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName, MethodName);			
			click(selenium,btnBack);
			waitForPageLoad(selenium);
			if(!patientData.estimatedCheck.isEmpty())
				if(!patientData.estimatedCheck.contains("No"))
					assertTrue(click(selenium, chkDOBEstimated), "Could not check the estimated check box, Expected value for the check box : " + patientData.estimatedCheck, selenium, ClassName, MethodName);
			if(!patientData.prematureCheck.isEmpty())
				if(!patientData.prematureCheck.contains("No"))
				{
					assertTrue(click(selenium, chkPremature), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck, selenium, ClassName, MethodName);
					if(!patientData.duration.isEmpty())
						if(!patientData.duration.contains("N/A"))
							assertTrue(type(selenium, txtPrematureDuration, patientData.duration), "Could not Enter duration, Expected value to be typed : " + patientData.duration, selenium, ClassName, MethodName);
					if(!patientData.measure.isEmpty())
						if(!patientData.measure.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxPrematureMeasure, patientData.measure))
								Assert.fail("Could not Enter Premature Messure, Expected value to be selected" + patientData.measure);
								waitForPageLoad(selenium);
				}
			if(!patientData.sex.isEmpty())
				if(!patientData.sex.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxSex, patientData.sex))
						Assert.fail("Could not Enter Sex, Expected value to be selected" + patientData.sex);
						waitForPageLoad(selenium);
			if(!patientData.maritalStatus.isEmpty())
				if(!patientData.maritalStatus.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxmartialStatus, patientData.maritalStatus))
						Assert.fail("Could not Enter Marital Status, Expected value to be selected" + patientData.maritalStatus);					
			if(!patientData.status.isEmpty())
				if(!patientData.status.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxStatus, patientData.status))
						Assert.fail("Could not Enter Status, For; More Details" + patientData.toString());
			if(!patientData.statusDate.isEmpty())
				if(!patientData.statusDate.contains("N/A"))
					assertTrue(enterDate(selenium, txtStatusDate, patientData.statusDate), "Could not Enter statusDate, For; More Details" + patientData.toString(), selenium, ClassName, MethodName);
			if(patientData.status.equalsIgnoreCase("inactive"))
				if(!patientData.reasonForInactivation.isEmpty())
					if(!patientData.reasonForInactivation.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxStationInactivation, patientData.reasonForInactivation))
							Assert.fail("Could not Enter reason for inactivation, For; More Details" + patientData.maritalStatus);					
			if(!patientData.residentialAddrStreet1.isEmpty())
				if(!patientData.residentialAddrStreet1.contains("N/A"))
					assertTrue(type(selenium, txtResidentAddress1, patientData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + patientData.residentialAddrStreet1, selenium, ClassName, MethodName);
			if(!patientData.residentialAddrStreet2.isEmpty())
				if(!patientData.residentialAddrStreet2.contains("N/A"))
					assertTrue(type(selenium, txtResidentAddress2, patientData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + patientData.residentialAddrStreet2, selenium, ClassName, MethodName);
			if(!patientData.residentialAddrcity.isEmpty())
				if(!patientData.residentialAddrcity.contains("N/A"))
					assertTrue(type(selenium, txtResidentialCity, patientData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + patientData.residentialAddrcity, selenium, ClassName, MethodName);
			if(!patientData.residentialAddrstate.isEmpty())
				if(!patientData.residentialAddrstate.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxResidentialState, patientData.residentialAddrstate))
						Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.residentialAddrstate);
			if(!patientData.residentialAddrzipCode.isEmpty())
				if(!patientData.residentialAddrzipCode.contains("N/A"))
					assertTrue(type(selenium, txtResidentialZip, patientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCode, selenium, ClassName, MethodName);
			          click(selenium,"yesButton");
			if(!patientData.residentialAddrcountry.isEmpty())
				if(!patientData.residentialAddrcountry.contains("N/A"))
					selectValueFromAjaxList(selenium, ajxResidentialCountry, patientData.residentialAddrcountry);
			/*if(!patientData.county.isEmpty())
				if(!patientData.county.contains("N/A"))
					Assert.assertTrue(type(selenium, txtResidentialCountry, patientData.county), "Could not Enter zip code, Expected value to be typed" + patientData.county);*/
			/*waitForPageLoad(selenium);
			selenium.keyPress(ajxPhoneType1, "\\9");
			click(selenium,btnYesButton);
			waitForElementToEnable(selenium,txtResidentialCity);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,ajxResidentialState);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,ajxCountry);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtResidentialCountry);
			waitForPageLoad(selenium);*/
			
			if(!patientData.telephoneType1.isEmpty())
				if(!patientData.telephoneType1.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType1, patientData.telephoneType1))
						Assert.fail("Could not Enter Telephone Type1, Expected value to be Select" + patientData.telephoneType1);
			if(!patientData.telephoneNo1.isEmpty())
				if(!patientData.telephoneNo1.contains("N/A"))
					assertTrue(type(selenium, txtPrimaryPhone, patientData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo1, selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo1.isEmpty())
				if(!patientData.telephoneextnNo1.contains("N/A"))
					assertTrue(type(selenium, txtPrimaryPhoneExtn, patientData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo1, selenium, ClassName, MethodName);
			if(!patientData.telephoneType2.isEmpty())
				if(!patientData.telephoneType2.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType2, patientData.telephoneType2))
						Assert.fail("Could not Enter Telephone Type2, Expected value to be Select" + patientData.telephoneType2);
			
			if(!patientData.telephoneNo2.isEmpty())
				if(!patientData.telephoneNo2.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone1, patientData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo2, selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo2.isEmpty())
				if(!patientData.telephoneextnNo2.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone1Extn, patientData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo2, selenium, ClassName, MethodName);
			
			if(!patientData.telephoneType3.isEmpty())
				if(!patientData.telephoneType3.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType3, patientData.telephoneType3))
						Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.telephoneType3);
			
			if(!patientData.telephoneNo3.isEmpty())
				if(!patientData.telephoneNo3.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone2, patientData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo3, selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo3.isEmpty())
				if(!patientData.telephoneextnNo3.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone2Extn, patientData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneNo3, selenium, ClassName, MethodName);
			
			if(!patientData.email.isEmpty())
				if(!patientData.email.contains("N/A"))
					assertTrue(type(selenium, txtEmail, patientData.email), "Could not Enter email, Expected value to be Typed" + patientData.email, selenium, ClassName, MethodName);
			
			if(!patientData.contactPreferences.isEmpty())
				if(!patientData.contactPreferences.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxContactPreference, patientData.contactPreferences))
						Assert.fail("Could not Enter contact preference, Expected value to be Select" + patientData.contactPreferences);
			if(!patientData.sameAsResidentialAddressCheck.isEmpty())
			{
				if(!patientData.sameAsResidentialAddressCheck.contains("No"))
					assertTrue(click(selenium, chkMailingAsResidential), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck, selenium, ClassName, MethodName);
				
					if(!patientData.mailingAddressStreet1.isEmpty())
						if(!patientData.mailingAddressStreet1.contains("N/A"))
							assertTrue(type(selenium, txtMailingAddress1, patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1, selenium, ClassName, MethodName);
					if(!patientData.mailingAddressStreet2.isEmpty())
						if(!patientData.mailingAddressStreet2.contains("N/A"))
							assertTrue(type(selenium, txtMailingAddress2, patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2, selenium, ClassName, MethodName);
					if(!patientData.mailingAddressCity.isEmpty())
						if(!patientData.mailingAddressCity.contains("N/A"))
							assertTrue(type(selenium, txtMailingCity, patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity, selenium, ClassName, MethodName);
					if(!patientData.mailingAddressState.isEmpty())
						if(!patientData.mailingAddressState.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxMailingState, patientData.mailingAddressState))
								Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.mailingAddressState);
					if(!patientData.mailingAddressZipcode.isEmpty())
						if(!patientData.mailingAddressZipcode.contains("N/A"))
							assertTrue(type(selenium, txtMailingZip, patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode, selenium, ClassName, MethodName);					
					/*if(!patientData.mailingAddressCountry.isEmpty())
						if(!patientData.mailingAddressCountry.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxMailingCountry, patientData.mailingAddressCountry))
								Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.mailingAddressCountry);
					if(!patientData.mailingAddressCounty.isEmpty())
						if(!patientData.mailingAddressCounty.contains("N/A"))
							Assert.assertTrue(type(selenium, txtMailingCountry, patientData.mailingAddressCounty), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressCounty);*/
					waitForPageLoad(selenium);
					selenium.keyPress(txtComments, "\\9");
					click(selenium,btnYesButton);
					waitForElementToEnable(selenium,txtMailingCity);
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,ajxMailingState);
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,ajxMailingCountry);
					waitForPageLoad(selenium);
					
					
			}
			else
			{
				if(!patientData.mailingAddressStreet1.isEmpty())
					if(!patientData.mailingAddressStreet1.contains("N/A"))
						assertTrue(type(selenium, txtMailingAddress1, patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1, selenium, ClassName, MethodName);
				if(!patientData.mailingAddressStreet2.isEmpty())
					if(!patientData.mailingAddressStreet2.contains("N/A"))
						assertTrue(type(selenium, txtMailingAddress2, patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2, selenium, ClassName, MethodName);
				if(!patientData.mailingAddressCity.isEmpty())
					if(!patientData.mailingAddressCity.contains("N/A"))
						assertTrue(type(selenium, txtMailingCity, patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity, selenium, ClassName, MethodName);
				if(!patientData.mailingAddressState.isEmpty())
					if(!patientData.mailingAddressState.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxMailingState, patientData.mailingAddressState))
							Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.mailingAddressState);
				if(!patientData.mailingAddressZipcode.isEmpty())
					if(!patientData.mailingAddressZipcode.contains("N/A"))
						assertTrue(type(selenium, txtMailingZip, patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode, selenium, ClassName, MethodName);
				if(!patientData.mailingAddressCountry.isEmpty())
					if(!patientData.mailingAddressCountry.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxMailingCountry, patientData.mailingAddressCountry))
							Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.mailingAddressCountry);
				/*if(!patientData.mailingAddressCounty.isEmpty())
					if(!patientData.mailingAddressCounty.contains("N/A"))
						Assert.assertTrue(type(selenium, txtMailingCountry, patientData.mailingAddressCounty), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressCounty);*/					
				
				/*waitForPageLoad(selenium);
				selenium.keyPress(txtComments, "\\9");
				click(selenium,btnYesButton);
				waitForElementToEnable(selenium,txtMailingCity);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,"mailingStateSuggestBoxsuggestBox");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,ajxMailingCountry);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,txtMailingCountry);
				waitForPageLoad(selenium);*/
		
			}
			
			if(!patientData.comments.isEmpty())
				if(!patientData.comments.contains("N/A"))
					assertTrue(type(selenium, txtComments, patientData.comments), "Could not Enter comments, Expected value to be Selected" + patientData.comments, selenium, ClassName, MethodName);
			if(!patientData.testCaseId.equalsIgnoreCase("TC_NPC_004")){
				click(selenium,btnSave1);
			}
			waitForPageLoad(selenium);
			returnValue = true;	
			waitForPageLoad(selenium);		
			}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		}
		return returnValue;
	}

		
	
	/**
	 * editUserForAuditLog
	 * function to edit User For AuditLog
	 * @throws IOException 
	 * @since  	     Feb 09, 2012
	 */	

	public boolean editUserForAuditLog(Selenium selenium,HomeLib userData) throws IOException{
		try{
			
			assertTrue(type(selenium,txtLastName,userData.lastName),"Could not type a last name", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstName,userData.firstName),"Could not type a first name" + userData .toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,"userName",userData.userName),"Could not type a user name" + userData .toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"externalEmrsuggestBox",userData.externalEmr);
			assertTrue(type(selenium,"credentials",userData.credentials),"Could not type a credential" + userData .toString(), selenium, ClassName, MethodName);
			if(userData.resetPswCheck.equalsIgnoreCase("Yes")){
				assertTrue(click(selenium,"resetPasswordcheckbox")," ", selenium, ClassName, MethodName);
				assertTrue(type(selenium,"password",userData.resetPassword),"Could not type a password" + userData .toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,"confirmPassword",userData.changedPassword),"Could not type confirmation password" + userData .toString(), selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSave),"Could not click the save Button;More Deatils:"+userData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkOrganizationalStructure);
			if(isElementPresent(selenium,"//div[3]/div[2]/div/div/div/span")){
				return true;
			}
			else{
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createConsentsCAView
	 * function to create Consents CA View
	 * @throws IOException 
	 * @since  	    Jun 26, 2012
	 */	
	public boolean createConsentsCAView(Selenium selenium,HomeLib consentsCAData) throws IOException{
		try{
			selectValueFromAjaxList(selenium,ajkConsentsType, consentsCAData.consentType);
			selectValueFromAjaxList(selenium,ajkConsentsName, consentsCAData.consentName);
			selectValueFromAjaxList(selenium,ajkStatus, consentsCAData.status);
			assertTrue(enterDate(selenium,txtDateSigned,consentsCAData.dateSigned),"Could not enter the date", selenium, ClassName, MethodName);
			//if (isElementPresent(selenium, ajkInactivation))
			//selectValueFromAjaxListUsingTypeKeys(selenium,ajkInactivation,consentsCAData.inactivation);
			selectValueFromAjaxList(selenium,ajkEnrolledSugBox,consentsCAData.entrolled);
			assertTrue(enterDate(selenium,txtDateSigned, consentsCAData.dateSigned),"Could not enter date; More Details :" + consentsCAData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCommentsConsents,consentsCAData.comments),"Could not type the comments;More Details:"+consentsCAData.toString(), selenium, ClassName, MethodName);
			if(consentsCAData.status.equals("Enrolled")){
				 selectValueFromAjaxList(selenium,ajkEnrolementStatusSugBox,consentsCAData.status);
				 
				 selectValueFromAjaxList(selenium,ajkEnrolledSugBox,consentsCAData.entrolled);
				 
				// assertTrue(enterDate(selenium,ajkEnrolementDte,consentsCAData.entrolledDate)," ", selenium, ClassName, MethodName);
				 assertTrue(type(selenium,txtCommentsConsents,consentsCAData.comments),"Could not type the comments;More Details:"+consentsCAData.toString(), selenium, ClassName, MethodName);
			 }
			else if(consentsCAData.status.equals("Ended")){
				selectValueFromAjaxList(selenium,ajkEnrolementStatusSugBox,consentsCAData.status);
				
				selectValueFromAjaxList(selenium,ajkEnrolledSugBox,consentsCAData.entrolled);
				assertTrue(enterDate(selenium,ajkEnrolementDte,consentsCAData.entrolledDate)," ", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtEnrolmentEndDate,consentsCAData.endDate)," ", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,txtReasonConsents,consentsCAData.reason);
				assertTrue(type(selenium,txtCommentsConsents,consentsCAData.comments),"Could not type the comments;More Details:"+consentsCAData.toString(), selenium, ClassName, MethodName);
			}
			if(consentsCAData.signedBy.equalsIgnoreCase("Substitution Decision Maker")){
				assertTrue(click(selenium,rdoSubstitude),"Could not select the susbstitution maker; More Details :" + consentsCAData.toString(), selenium, ClassName, MethodName);
				waitForElementToEnable(selenium,ajkRelationship);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajkRelationship,consentsCAData.relationship);
				
				assertTrue(type(selenium,txtFirstName,consentsCAData.firstName),"Could not enter the first name; More Details :" + consentsCAData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLastName,consentsCAData.lastName),"Could not enter last name; More Details :" + consentsCAData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,ajkEnrolementDte, consentsCAData.entrolledDate),"Could not enter date; More Details :" + consentsCAData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentsCAData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			 }
			 else if(!consentsCAData.testCaseId.equals("TC_NCCA_006")){
				 
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentsCAData.toString(), selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
			if(!isElementPresent(selenium, lblTitle)){
				return false;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * editConsentsCAView
	 * function to edit Consents CA View
	 * @throws IOException 
	 * @since  	    Jun 26, 2012
	 */	
	public boolean editConsentsCAView(Selenium selenium,HomeLib consentsCAData) throws IOException{
		try{
			selectValueFromAjaxList(selenium,ajkConsentsType, consentsCAData.consentType);
			selectValueFromAjaxList(selenium,ajkConsentsName, consentsCAData.consentName);
			selectValueFromAjaxList(selenium,ajkStatus, consentsCAData.status);
			if (isElementPresent(selenium, ajkInactivation))
			selectValueFromAjaxListUsingTypeKeys(selenium,ajkInactivation,consentsCAData.inactivation);
			assertTrue(enterDate(selenium,txtDateSigned, consentsCAData.dateSigned),"Could not enter date; More Details :" + consentsCAData.toString(), selenium, ClassName, MethodName);
			if(consentsCAData.consentType.equals("Enrollment")){
				 waitForPageLoad(selenium);
				 selectValueFromAjaxList(selenium,ajkEnrolledSugBox,consentsCAData.entrolled);
				 assertTrue(enterDate(selenium,ajkEnrolementDte,consentsCAData.entrolledDate)," ", selenium, ClassName, MethodName);
				 assertTrue(type(selenium,txtCommentsConsents,consentsCAData.comments),"Could not type the comments;More Details:"+consentsCAData.toString(), selenium, ClassName, MethodName);
			 }
			 if(consentsCAData.signedBy.equalsIgnoreCase("Substitution Decision Maker")){
				assertTrue(click(selenium,rdoSubstitude),"Could not select the susbstitution maker; More Details :" + consentsCAData.toString(), selenium, ClassName, MethodName);
				waitForElementToEnable(selenium,ajkRelationship);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajkRelationship,consentsCAData.relationship);
				assertTrue(type(selenium,txtFirstName,consentsCAData.firstName),"Could not enter the first name; More Details :" + consentsCAData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLastName,consentsCAData.lastName),"Could not enter last name; More Details :" + consentsCAData.toString(), selenium, ClassName, MethodName);
				if(consentsCAData.entrolled.equalsIgnoreCase("Ended")){
					assertTrue(enterDate(selenium,ajkEnrolementDte,consentsCAData.entrolledDate)," ", selenium, ClassName, MethodName);
					assertTrue(enterDate(selenium,txtEnrolmentEndDate,consentsCAData.endDate)," ", selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,txtReasonConsents,consentsCAData.reason);
				}
				assertTrue(type(selenium,txtCommentsConsents,consentsCAData.comments),"Could not type the comments", selenium, ClassName, MethodName);
				
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentsCAData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			 }
			 else
				 assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentsCAData.toString(), selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				 
			if(isElementPresent(selenium, lblTitle)){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * createPatientCAView_UnitTest
	 * function to create Patient CA View Unit Test
	 * @throws IOException 
	 * @since  	    June 27, 2012
	 */	
	
	public boolean createPatientCAView_UnitTest(Selenium selenium, HomeLibUnitTest patientData) throws IOException{
		boolean returnValue = false;
		try{	
			if(!patientData.rosteredCheck.isEmpty())
				if(!patientData.rosteredCheck.contains("No"))
					assertTrue(check(selenium,"rosteredcheckbox"),"Could not check the rostered check box,Expected value for the check box:"+patientData.rosteredCheck, selenium, ClassName, MethodName);
			
			if(!patientData.patientIdchart.isEmpty())
				if(!patientData.patientIdchart.contains("N/A"))
					assertTrue(type(selenium,txtChartNumber,patientData.patientIdchart),"Could not Enter the patientId chart, Expected value to be typed" + patientData.patientIdchart, selenium, ClassName, MethodName );
			if(!patientData.canadianProvince.isEmpty())
				if(!patientData.canadianProvince.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,"canadianProvincesuggestBox",patientData.canadianProvince))
						Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.canadianProvince);
			
			if(!patientData.hCN.isEmpty())
				if(!patientData.hCN.contains("N/A"))
					assertTrue(type(selenium, "healthcardNumber", patientData.hCN), "Could not Enter Hcn, Expected value to be typed" + patientData.hCN, selenium, ClassName, MethodName);
			if(patientData.testCaseId.equals("TC_FLV_CA_030"))
			if(!patientData.reason.isEmpty())
				if(!patientData.reason.contains("N/A"))
					if(!selectValueFromAjaxListUsingTypeKeys(selenium, "reasonSuggestBoxsuggestBox", patientData.reason))
						Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.reason);
			
			if(!patientData.expireDate.isEmpty())
				if(!patientData.expireDate.contains("N/A"))
					assertTrue(enterDate(selenium, "expiryDate", patientData.expireDate), "Could not Enter expireDate , Expected value to be typed" + patientData.expireDate, selenium, ClassName, MethodName);			
			if(!patientData.primaryLocation.isEmpty())
				if(!patientData.primaryLocation.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPrimaryLocation, patientData.primaryLocation))
						Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.primaryLocation);
			if(!patientData.responsibleProvider.isEmpty())
				if(!patientData.responsibleProvider.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,ajxResponsbleProvider,patientData.responsibleProvider))
						Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.responsibleProvider);
			if(!patientData.pcpCheck.isEmpty())
				if(!patientData.pcpCheck.contains("No"))
					assertTrue(check(selenium, chkResponsibleProvider), "Could not check the pcp check box, Expected value for the check box : " + patientData.pcpCheck, selenium, ClassName, MethodName);
			
			if(!patientData.lastName.isEmpty())
				if(!patientData.lastName.contains("N/A"))
					assertTrue(type(selenium, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName, selenium, ClassName, MethodName);
			if(!patientData.firstName.isEmpty())
				if(!patientData.firstName.contains("N/A"))
					assertTrue(type(selenium, txtFirstName, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName, selenium, ClassName, MethodName);
			if(!patientData.middleName.isEmpty())
				if(!patientData.middleName.contains("N/A"))
					assertTrue(type(selenium, txtMiddleName, patientData.middleName), "Could not Enter middle name, Expected value to be typed" + patientData.middleName, selenium, ClassName, MethodName);
			if(!patientData.title.isEmpty())
				if(!patientData.title.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxTitle, patientData.title))	
						Assert.fail("Could not Enter Title, Expected value to be selected" + patientData.title);
			if(!patientData.suffix.isEmpty())
				if(!patientData.suffix.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxSuffix, patientData.suffix))
						Assert.fail("Could not Enter Suffix, Expected value to be selected" + patientData.suffix);
			if(!patientData.alias1.isEmpty())
				if(!patientData.alias1.contains("N/A"))
					assertTrue(type(selenium, txtAlias1, patientData.alias1), "Could not Enter alias1, Expected value to be typed" + patientData.alias1, selenium, ClassName, MethodName);
			if(!patientData.alias2.isEmpty())
				if(!patientData.alias2.contains("N/A"))
					assertTrue(type(selenium, txtAlias2, patientData.alias2), "Could not Enter alias2, Expected value to be typed" + patientData.alias2, selenium, ClassName, MethodName);
			if(!patientData.dob.isEmpty())
				if(!patientData.dob.contains("N/A"))
					Assert.assertTrue(enterDate(selenium, txtDOB, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob);			
			if(!patientData.estimatedCheck.isEmpty())
				if(!patientData.estimatedCheck.contains("No"))
					assertTrue(click(selenium, chkDOBEstimated), "Could not check the estimated check box, Expected value for the check box : " + patientData.estimatedCheck, selenium, ClassName, MethodName);
			if(!patientData.prematureCheck.isEmpty())
				if(!patientData.prematureCheck.contains("No"))
				{
					assertTrue(click(selenium, chkPremature), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck, selenium, ClassName, MethodName);
					if(!patientData.duration.isEmpty())
						if(!patientData.duration.contains("N/A"))
						assertTrue(type(selenium, "prematureDurationsuggestBox", patientData.duration), "Could not Enter duration, Expected value to be typed : " + patientData.duration, selenium, ClassName, MethodName);
					if(!patientData.measure.isEmpty())
						if(!patientData.measure.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxPrematureMeasure, patientData.measure))
								Assert.fail("Could not Enter Premature Messure, Expected value to be selected" + patientData.measure);
				}
			if(!patientData.sex.isEmpty())
				if(!patientData.sex.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxSex, patientData.sex))
						Assert.fail("Could not Enter Sex, Expected value to be selected" + patientData.sex);
			if(!patientData.maritalStatus.isEmpty())
				if(!patientData.maritalStatus.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxmartialStatus, patientData.maritalStatus))
						Assert.fail("Could not Enter Marital Status, Expected value to be selected" + patientData.maritalStatus);					
			if(!patientData.status.isEmpty())
				if(!patientData.status.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxStatus, patientData.status))
						Assert.fail("Could not Enter Status, For; More Details" + patientData.toString());
			if(!patientData.statusDate.isEmpty())
				if(!patientData.statusDate.contains("N/A"))
					assertTrue(type(selenium, txtStatusDate, patientData.statusDate), "Could not Enter statusDate, For; More Details" + patientData.toString(), selenium, ClassName, MethodName);
			if(patientData.status.equalsIgnoreCase("inactive"))
				if(!patientData.reasonForInactivation.isEmpty())
					if(!patientData.reasonForInactivation.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxStationInactivation, patientData.reasonForInactivation))
							Assert.fail("Could not Enter reason for inactivation, For; More Details" + patientData.maritalStatus);					
			if(!patientData.residentialAddrStreet1.isEmpty())
				if(!patientData.residentialAddrStreet1.contains("N/A"))
					assertTrue(type(selenium, txtResidentAddress1, patientData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + patientData.residentialAddrStreet1, selenium, ClassName, MethodName);
			if(!patientData.residentialAddrStreet2.isEmpty())
				if(!patientData.residentialAddrStreet2.contains("N/A"))
					assertTrue(type(selenium, txtResidentAddress2, patientData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + patientData.residentialAddrStreet2, selenium, ClassName, MethodName);
			if(!patientData.residentialAddrcity.isEmpty())
				if(!patientData.residentialAddrcity.contains("N/A"))
					assertTrue(type(selenium, txtResidentialCity, patientData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + patientData.residentialAddrcity, selenium, ClassName, MethodName);
			if(!patientData.residentialAddrstate.isEmpty())
				if(!patientData.residentialAddrstate.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxResidentialState, patientData.residentialAddrstate))
						Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.residentialAddrstate);
			if(!patientData.residentialAddrzipCode.isEmpty())
				if(!patientData.residentialAddrzipCode.contains("N/A"))
					assertTrue(type(selenium, txtResidentialZip, patientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCode, selenium, ClassName, MethodName);
			if(!patientData.residentialAddrcountry.isEmpty())
				if(!patientData.residentialAddrcountry.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,ajxResidentialCountry,patientData.residentialAddrcountry))
						Assert.fail("Could not Enter Residential Addr Country, Expected value to be select"+patientData.residentialAddrcountry);
			if(!patientData.telephoneType1.isEmpty())
				if(!patientData.telephoneType1.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType1, patientData.telephoneType1))
						Assert.fail("Could not Enter Telephone Type1, Expected value to be Select" + patientData.telephoneType1);
			if(!patientData.telephoneNo1.isEmpty())
				if(!patientData.telephoneNo1.contains("N/A"))
					assertTrue(type(selenium, txtPrimaryPhone, patientData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo1, selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo1.isEmpty())
				if(!patientData.telephoneextnNo1.contains("N/A"))
					assertTrue(type(selenium, txtPrimaryPhoneExtn, patientData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo1, selenium, ClassName, MethodName);
			
			if(!patientData.telephoneType2.isEmpty())
				if(!patientData.telephoneType2.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType2, patientData.telephoneType2))
						Assert.fail("Could not Enter Telephone Type2, Expected value to be Select" + patientData.telephoneType2);
			
			if(!patientData.telephoneNo2.isEmpty())
				if(!patientData.telephoneNo2.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone1, patientData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo2, selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo2.isEmpty())
				if(!patientData.telephoneextnNo2.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone1Extn, patientData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo2, selenium, ClassName, MethodName);
			
			if(!patientData.telephoneType3.isEmpty())
				if(!patientData.telephoneType3.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType3, patientData.telephoneType3))
						Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.telephoneType3);
			
			if(!patientData.telephoneNo3.isEmpty())
				if(!patientData.telephoneNo3.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone2, patientData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo3, selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo3.isEmpty())
				if(!patientData.telephoneextnNo3.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone2Extn, patientData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneNo3, selenium, ClassName, MethodName);
			
			if(!patientData.email.isEmpty())
				if(!patientData.email.contains("N/A"))
					assertTrue(type(selenium, txtEmail, patientData.email), "Could not Enter email, Expected value to be Typed" + patientData.email, selenium, ClassName, MethodName);
			
			if(!patientData.contactPreferences.isEmpty())
				if(!patientData.contactPreferences.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajkSuggestBox, patientData.contactPreferences))
						Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.contactPreferences);
			if(!patientData.preference2Present.isEmpty())
				if(!patientData.preference2Present.contains("N/A"))
				{
					assertTrue(click(selenium,"css=span.add"), "Could not add a ne preference", selenium, ClassName, MethodName);
					if(!patientData.contactPreference2.isEmpty())
						if(!patientData.contactPreference2.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, "xpath=(//input[@id='suggestBox'])[2]", patientData.contactPreference2))
								Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.contactPreference2);
				}
			if(!patientData.sameAsResidentialAddressCheck.isEmpty())
			{
				if(!patientData.sameAsResidentialAddressCheck.contains("No"))
					assertTrue(click(selenium, chkMailingAsResidential), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck, selenium, ClassName, MethodName);
				
					if(!patientData.mailingAddressStreet1.isEmpty())
						if(!patientData.mailingAddressStreet1.contains("N/A"))
							assertTrue(type(selenium, txtMailingAddress1, patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1, selenium, ClassName, MethodName);
					if(!patientData.mailingAddressStreet2.isEmpty())
						if(!patientData.mailingAddressStreet2.contains("N/A"))
							assertTrue(type(selenium, txtMailingAddress2, patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2, selenium, ClassName, MethodName);
					if(!patientData.mailingAddressCity.isEmpty())
						if(!patientData.mailingAddressCity.contains("N/A"))
							assertTrue(type(selenium, txtMailingCity, patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity, selenium, ClassName, MethodName);
					
					if(!patientData.mailingAddressState.isEmpty())
						if(!patientData.mailingAddressState.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, "mailingStateSuggestBoxsuggestBox", patientData.mailingAddressState))
								Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.mailingAddressState);
					
					if(!patientData.mailingAddressZipcode.isEmpty())
						if(!patientData.mailingAddressZipcode.contains("N/A"))
							assertTrue(type(selenium, txtMailingZip, patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode, selenium, ClassName, MethodName);					
				}
			else{
				if(!patientData.mailingAddressStreet1.isEmpty())
					if(!patientData.mailingAddressStreet1.contains("N/A"))
						assertTrue(type(selenium, txtMailingAddress1, patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1, selenium, ClassName, MethodName);
				if(!patientData.mailingAddressStreet2.isEmpty())
					if(!patientData.mailingAddressStreet2.contains("N/A"))
						assertTrue(type(selenium, txtMailingAddress2, patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2, selenium, ClassName, MethodName);
				if(!patientData.mailingAddressCity.isEmpty())
					if(!patientData.mailingAddressCity.contains("N/A"))
						assertTrue(type(selenium, txtMailingCity, patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity, selenium, ClassName, MethodName);
				
				if(!patientData.mailingAddressState.isEmpty())
					if(!patientData.mailingAddressState.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, "mailingStateSuggestBoxsuggestBox", patientData.mailingAddressState))
							Assert.fail("Could not Enter Mailing Address State, Expected value to be selected" + patientData.mailingAddressState);
				if(!patientData.mailingAddressZipcode.isEmpty())
					if(!patientData.mailingAddressZipcode.contains("N/A"))
						assertTrue(type(selenium, txtMailingZip, patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode, selenium, ClassName, MethodName);
				if(!patientData.mailingAddressCountry.isEmpty())
					if(!patientData.mailingAddressCountry.contains("N/A"))
						if(!selectValueFromAjaxList(selenium,ajxMailingCountry,patientData.mailingAddressCountry))
							Assert.fail("Could not Enter Mailing Addr Country,Expected value to be typed"+patientData.mailingAddressCountry);
			}
			
			if(!patientData.comments.isEmpty())
				if(!patientData.comments.contains("N/A"))
					assertTrue(type(selenium, txtComments, patientData.comments), "Could not Enter comments, Expected value to be Selected" + patientData.comments, selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			click(selenium,btnSave1);
			waitForPageLoad(selenium);
			returnValue = true;	
			waitForPageLoad(selenium);		
			}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		}
		return returnValue;
	}
	/**
	 * createNewPatientWithMandatoryCAView
	 * function to create New Patient With Mandatory CA view
	 * @throws IOException 
	 * @since  	     Feb 09, 2012
	 */	
	public boolean createNewPatientWithMandatoryCAView(Selenium selenium, HomeLib patientData,String userAccount) throws IOException{
		boolean returnValue = false;
		try{
			waitForPageLoad(selenium);
			//selectValueFromAjaxList(selenium,ajxResponsbleProvider,patientData.responsibleProvider);
			assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
			
			assertTrue(enterDate(selenium, txtDOB, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName, MethodName);
			click(selenium,btnBack);
			if(isElementPresent(selenium,noDuplicationBtn))
			{
			assertTrue(click(selenium,noDuplicationBtn),"unable to click the not this patient button",selenium,ClassName,MethodName);
			}
			assertTrue(click(selenium,chkPremature),"Could not click prematurecheck box : More Details"+patientData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxPrematureDuration,patientData.duration);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxStatus,patientData.status);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxRelationSex,patientData.sex);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave1),"Could not click Save button More Dateils"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;	
			waitForPageLoad(selenium);
			}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		}
		return returnValue;
	}
	
	/**
	 * verifyAlertForConsents
	 * function to verify alert when there are some changes in consents 
	 * @since  	    September 11, 2012
	 */	
	public boolean verifyAlertForConsents(Selenium selenium,HomeLib consentData){
		boolean returnValue=false;
		try{
			selectValueFromAjaxList(selenium,ajkConsentsType, consentData.consentType);
			selectValueFromAjaxList(selenium,ajkEnrolementStatusSugBox, consentData.status1);
			enterDate(selenium,ajkEnrolementDte, consentData.entrolledDate);
		    selectValueFromAjaxList(selenium,ajkEnrolledSugBox, consentData.entrolled);
			selectValueFromAjaxList(selenium,ajkEnrolementStatusSugBox, consentData.status);
			if(waitForElement(selenium, btnYesButton, WAIT_TIME)){
				Assert.assertTrue(click(selenium,btnYesButton), "Could no click the yes button");
				returnValue= true;
			}else{
				return false;
			}
			selectValueFromAjaxList(selenium,ajkEnrolementStatusSugBox, consentData.status2);
			
			selectValueFromAjaxList(selenium,ajkEnrolledSugBox, consentData.entrolled);
			enterDate(selenium,ajkEnrolementDte, consentData.entrolledDate);
			enterDate(selenium,txtEnrolmentEndDate, consentData.endDate);
			selectValueFromAjaxList(selenium,txtReasonConsents, consentData.reason);
			selectValueFromAjaxList(selenium,ajkEnrolementStatusSugBox, consentData.status);
			if(waitForElement(selenium, btnYesButton, WAIT_TIME)){
				Assert.assertTrue(click(selenium,btnYesButton), "Could no click the yes button");
				returnValue= true;
			}else{
				return false;
			}
			selectValueFromAjaxList(selenium,ajkEnrolementStatusSugBox, consentData.status2);			
			selectValueFromAjaxList(selenium,ajkEnrolledSugBox, consentData.entrolled);
			enterDate(selenium,ajkEnrolementDte, consentData.entrolledDate);
			enterDate(selenium,txtEnrolmentEndDate, consentData.endDate);
			selectValueFromAjaxList(selenium,txtReasonConsents, consentData.reason);
			selectValueFromAjaxList(selenium,ajkEnrolementStatusSugBox, consentData.status1);
			if(waitForElement(selenium, btnYesButton, WAIT_TIME)){
				Assert.assertTrue(click(selenium,btnYesButton), "Could no click the yes button");
				returnValue= true;
			}else{
				return false;
			}
				
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	/**
	 * createNewUser
	 * function to create New User
	 * @param 		selenium
	 * @param 		userData
	 * @param 		uniqueName
	 * @throws IOException 
	 * @since  	     May 17, 2012
	 */	
	public boolean createNewUser(Selenium selenium,HomeLib userData,String uniqueName) {
		try{
			assertTrue(click(selenium,"addUser"),"Could not click on add a user link:" + userData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLastName,userData.lastName+uniqueName),"Could not type a last name", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstName,userData.firstName),"Could not type a first name" + userData .toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,"userName",userData.userName1+uniqueName),"Could not type a user name" + userData .toString(), selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,"credentials",userData.credentials),"Could not type a credential" + userData .toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"externalEmrsuggestBox",userData.externalEmr);
			assertTrue(type(selenium,"password",userData.password),"Could not type a password" + userData .toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,"confirmPassword",userData.password),"Could not type confirmation password" + userData .toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,"roleSuggestBox1suggestBox",userData.role);
			selectValueFromAjaxList(selenium,"//div[2]/div[2]/div/div/div/div/div/div/input",userData.practise);
			click(selenium,"//div[3]/div/div/div/div/div");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + userData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEdit)){
				return true;
			}
			else{
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	/**
	 *deleteCAMedication
	 * function to deleteCAMedication
	 * @throws IOException 
	 * @since  	    Oct 10, 2012
	 */	
	public boolean deleteCAMedication(Selenium selenium,HomeLib  patientcaData){
		boolean medicationDeleted=true;
		int medicationCount=0;
		try{
			waitForElement(selenium,btnDeleteMedication, WAIT_TIME);
			while((Integer) selenium.getXpathCount(btnDeleteMedication) > 0){
				medicationCount=(Integer) selenium.getXpathCount(btnDeleteMedication);
				assertTrue(click(selenium,btnDeleteMedication)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtdeleteReason,patientcaData.userAccount),"Could not enter the reason", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSaveMedication)," ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(medicationCount == (Integer) selenium.getXpathCount(btnDeleteMedication)){
					medicationDeleted = false;
					break;
				}
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicationDeleted;
	}
	/**
	 *createCAMedication
	 * function to cretae CA Medication
	 * @throws IOException 
	 * @since  	    Oct 10, 2012
	 */	
	
	public boolean createCAMedication(Selenium selenium,HomeLib patientcaData){
		try{
			selectValueFromAjaxList(selenium,"id=medicationSuggestBox",patientcaData.prescribe);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//	Assert.assertTrue(type(selenium,"medicationSuggestBox",patientcaData.prescribe),"Could not enter the text;More Details:"+patientcaData.toString());
			waitForPageLoad(selenium);
			if(patientcaData.freeText.equals("Yes")){
				assertTrue(click(selenium,"enterAsFreeTextcheckbox"),"Could not click the check box;More Details:"+patientcaData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,"css=div.marginTop10 > textarea.gwt-TextArea",patientcaData.direction),"Could not enter the text;More Details:"+patientcaData.toString(), selenium, ClassName, MethodName);
			}if(patientcaData.increaseDecreaseDose.equals("Yes")){
				assertTrue(click(selenium,"increaseDecreaseDosecheckbox"),"Could not click the check box;More Details:"+patientcaData.toString(), selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillMethodSuggestBoxsuggestBox'])[2]",patientcaData.refillMethod);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillQuantitySuggestBoxsuggestBox'])[2]",patientcaData.refillQuantity);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUnitSuggestBoxsuggestBox'])[2]",patientcaData.refillUnit);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillRouteSuggestBoxsuggestBox'])[2]",patientcaData.refillRoute);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillFrequencySuggestBoxsuggestBox'])[2]",patientcaData.refillFrequency);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[2]",patientcaData.refillUsage);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[3]",patientcaData.refillUsage1);
				selectValueFromAjaxList(selenium,"durationNumberID",patientcaData.duration);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[4]",patientcaData.refillUsage2);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[5]",patientcaData.refillUsage3);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[6]",patientcaData.refillUsage4);
			}if(patientcaData.multipleDirection.equals("Yes")){
				assertTrue(click(selenium,"multipleDirectionscheckbox"),"Could not click the check box;More Details:"+patientcaData.toString(), selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillMethodSuggestBoxsuggestBox'])[3]",patientcaData.refillMethod);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillQuantitySuggestBoxsuggestBox'])[3]",patientcaData.refillQuantity);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUnitSuggestBoxsuggestBox'])[3]",patientcaData.refillUnit);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillFrequencySuggestBoxsuggestBox'])[3]",patientcaData.refillFrequency);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillDurationSuggestBoxsuggestBox'])[2]",patientcaData.refillduration);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[7]",patientcaData.refillUsage);
				selectValueFromAjaxList(selenium,"refillMethodSuggestBox1suggestBox",patientcaData.method);
				selectValueFromAjaxList(selenium,"refillQuantitySuggestBox1suggestBox",patientcaData.quality);
				selectValueFromAjaxList(selenium,"refillUnitSuggestBox1suggestBox",patientcaData.unit);
				selectValueFromAjaxList(selenium,"refillRouteSuggestBox1suggestBox",patientcaData.route);
				selectValueFromAjaxList(selenium,"refillFrequencySuggestBox1suggestBox",patientcaData.frequency);
				selectValueFromAjaxList(selenium,"refillDurationSuggestBox1suggestBox",patientcaData.duration);
				selectValueFromAjaxList(selenium,"refillUsageSuggestBox1suggestBox",patientcaData.usage);
			}
			else if(!patientcaData.freeText.equals("Yes")&& !patientcaData.increaseDecreaseDose.equals("Yes")&& !patientcaData.multipleDirection.equals("Yes")){
				selectValueFromAjaxList(selenium,"refillMethodSuggestBoxsuggestBox",patientcaData.refillMethod);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"refillQuantitySuggestBoxsuggestBox",patientcaData.refillQuantity);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"refillUnitSuggestBoxsuggestBox",patientcaData.refillUnit);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"refillRouteSuggestBoxsuggestBox",patientcaData.refillRoute);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"refillFrequencySuggestBoxsuggestBox",patientcaData.refillFrequency );
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"refillDurationSuggestBoxsuggestBox",patientcaData.refillduration);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"refillUsageSuggestBoxsuggestBox",patientcaData.refillUsage);
				waitForPageLoad(selenium);
			}
			selenium.focus("css=input.gwt-DateBox");
			assertTrue(enterDate(selenium,"css=input.gwt-DateBox",patientcaData.startDate),"Could not enter the Date;More Details:"+patientcaData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.focus("//div[2]/div/div[2]/input");
			assertTrue(type(selenium,"//div[2]/div/div[2]/input",patientcaData.supply),"Could not enter the supply;More Details:"+patientcaData.toString(), selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			if((patientcaData.testCaseId.equals("TC_PSM_006"))||(patientcaData.testCaseId.equals("TC_PSM_017"))||(patientcaData.testCaseId.equals("TC_PSM_018"))){
				assertTrue(click(selenium,"//div[8]/div/div[2]"),"Could not click the show more link;More Details:"+patientcaData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,"xpath=(//input[@type='text'])[41]",patientcaData.prescribeOn)," ", selenium, ClassName, MethodName);
				assertTrue(type(selenium,"xpath=(//input[@type='text'])[43]",patientcaData.refill),"Could not enter the refill;More Details:"+patientcaData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,"//div[2]/div[2]/input",patientcaData.prescribedby),"Could not enter the date;More Details:"+patientcaData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,"//div[2]/div[2]/div[2]/input",patientcaData.lastRefill)," ", selenium, ClassName, MethodName);
				assertTrue(type(selenium,"//div[2]/textarea",patientcaData.comment),"Could not enter the commend;More Details:"+patientcaData.toString(), selenium, ClassName, MethodName);
			}
			
			if(isElementPresent(selenium,"xpath=(//button[@id='save'])[2]")){
				assertTrue(click(selenium,"xpath=(//button[@id='save'])[2]"),"Could not click the show more link;More Details:"+patientcaData.toString(), selenium, ClassName, MethodName);
				//return true;
			}
			assertTrue(click(selenium,"add"),"Could not click the add button;More Details:"+patientcaData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

	/**
	 * goToRegisterPatient
	 * Function to go to RegisterPatient
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 21,2012
	 */
	public boolean goToRegisterPatient(Selenium selenium) {
		try {
			
		
			
			assertTrue(click(selenium,lnkQuickActions), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not click on Clinical Lists", selenium, ClassName, MethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
		waitForPageLoad(selenium);
		if(isElementPresent(selenium, btnSave1))
			return true;
		else
			return false;
		}
	
	
	
	//DemoGraphics
	
	
	
	//Cases
	
	
	
	/**
	 * Create New Cases
	 * @param selenium
	 * @param casesData
	 * @return
	 * @throws IOException 
	 */
	public boolean verifyStoredValuesCreateCase(Selenium selenium, HomeLib casesData,String date,String account) {
		boolean returnValue=true;
		String Inlineno=getText(selenium,txtCaseId);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		try {
		if(!getValue(selenium,txtDescription).trim().contains(casesData.description.trim())){
			returnValue= false;
		}
		if(!getValue(selenium,ajkProgram).trim().contains(casesData.program.trim())){
			returnValue= false;
		}
		if(!getText(selenium,txtDepartment).trim().equalsIgnoreCase(casesData.department.trim())){
			//returnValue= false;
		}
		if(!getValue(selenium,txtReason).trim().contains(casesData.reason.trim())){
			returnValue= false;
		}
		if(casesData.casesstatus.equals(getText(selenium, ajkCaseStatus)))
		{
			if(!getValue(selenium,txtTerminationDate).trim().contains(date.trim())){
				returnValue= false;
			}
			if(!getValue(selenium,txtTerminationReason).trim().contains(casesData.terminationReason.trim())){
				returnValue= false;
			}
		}
		if(!getValue(selenium,txtStartDate).trim().contains(date.trim())){
			returnValue= false;
		}
		if(!getValue(selenium,txtDateType).trim().contains(casesData.datetype1.trim())){
			returnValue= false;
		}
		if(!getValue(selenium,txtDate).trim().contains(date.trim())){
			returnValue= false;
		}
		if(returnValue==true){
			waitForPageLoad(selenium);
			click(selenium,btnCancl);
			waitForPageLoad(selenium);
			click(selenium,lnkCloseArrow);
			waitForPageLoad(selenium);
			
			
				assertTrue(selenium.isTextPresent(Inlineno), "" + "Inlineno Not Present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent(casesData.description), "" + "cases description Not Present", selenium, ClassName, MethodName);
				
			
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
				
			if(account.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
					date=DateFormat.format(cal.getTime());
					int date1=Integer.parseInt(date);
					if(date1<10){
						SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
						date=DateForma1t.format(cal.getTime());
						
					}else{
						SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
						date=DateFormat2.format(cal.getTime());
						
					}
				}
			System.out.println(getText(selenium,lblStartDate));
			System.out.println(date);
			
			assertTrue(selenium.isTextPresent(date), "" + "Date Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		/*	assertTrue(selenium.isTextPresent(casesData.program1), "" + "cases program1 Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
						
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	/**
	 * Verify Store Value For Add Cases In UnFinished Item
	 * @param selenium
	 * @param casesData
	 * @return
	 */
	
	public boolean verifyStoredValuesAddCases(Selenium selenium, HomeLib casesData,String account){
		if(!getValue(selenium,txtDescription).trim().equalsIgnoreCase(casesData.description.trim())){
			return false;
		}
		if(!getValue(selenium,ajkProgram).trim().contains(casesData.program.trim())){
			return false;
		}
		if(!getText(selenium,txtDepartment).trim().contains("")){
			return false;
		}
		if(!getValue(selenium,txtReason).trim().equalsIgnoreCase(casesData.reason.trim())){
			return false;
		}
		if(!getValue(selenium,ajkCaseStatus).trim().equalsIgnoreCase(casesData.casesstatus.trim()))
		{
		/*	if(!getValue(selenium,txtTerminationReason).trim().contains(casesData.terminationReason.trim())){
			
			}*/
			return false;
		}
		
		if(!getValue(selenium,txtDateType).trim().equalsIgnoreCase(casesData.datetype1.trim())){
			return false;
		}
		
		return true;
	}
	
	/**
	 * Verify Store Value For Summary Cases In UnFinished Item
	 * @param selenium
	 * @param casesData
	 * @return
	 */
	
	public boolean verifyStoredValuesInSummaryAddCases(Selenium selenium, HomeLib casesData,String account){
		String date = "";
		
		Assert.assertTrue(click(selenium,lnkExpandAll),"Could not click the Expand view");
		
		if(!getText(selenium,lblProgram).contains(casesData.description.trim())){
			return false;
		}
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
				date=DateFormat.format(cal.getTime());
				int date1=Integer.parseInt(date);
				if(date1<10){
					SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
					date=DateForma1t.format(cal.getTime());
					
				}else{
					SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
					date=DateFormat2.format(cal.getTime());
					
				}
			}
		
		/*click(selenium,lnkCloseArrow);
		waitForPageLoad(selenium);*/
		
		if(!getText(selenium,lblProgram).trim().contains(date.trim())){
			return false;
		}
		/*if(!getText(selenium,lblProgram).contains(casesData.program1.trim())){
			return false;
		}*/
		return true;
	}
	
	/**
	 * Edit New Cases
	 * @param selenium
	 * @param casesData
	 * @return
	 */
	public boolean verifyStoredValuesEditCase(Selenium selenium, HomeLib casesData,String date){
		boolean verfiedValues = true;
		try{
			assertTrue(getValue(selenium,txtDescription).trim().contains(casesData.description.trim())," ", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,ajkProgram).trim().contains(casesData.program.trim())," ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!getText(selenium,txtDepartment).trim().equalsIgnoreCase(casesData.department.trim())){
				verfiedValues= false;
			}
			assertTrue(getValue(selenium,txtReason).trim().contains(casesData.reason.trim())," ", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,txtStartDate).trim().contains(date.trim())," ", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,txtDateType).trim().contains(casesData.datetype1.trim())," ", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,txtDate).trim().contains(date.trim()), " ",selenium, ClassName, MethodName);
		}catch (RuntimeException e) {
			verfiedValues = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(selenium,btnCancl);
		waitForPageLoad(selenium);
		return verfiedValues;
	}

	//Consents
	
	/**
	 * Verify stored values create consents
	 * @param selenium
	 * @param consentData
	 * @return
	 */
	public boolean verifyStoredValuesForConsents(Selenium selenium, HomeLib consentData){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajkConsentsType).toLowerCase(new java.util.Locale("en","Us")).trim().contains(consentData.consentType.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getValue(selenium,ajkConsentsName).toLowerCase(new java.util.Locale("en","Us")).trim().contains(consentData.consentName.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(consentData.status.equalsIgnoreCase("Inactive")){
			if(!getValue(selenium,"statussuggestBox").trim().contains(consentData.status.trim())){
				return false;
			}if(!getValue(selenium,ajkInactivation).trim().contains(consentData.inactivation.trim())){
				return false;
			}
			System.out.println(getValue(selenium,ajkEnrolementStatusSugBox));
		}else if(!getValue(selenium,"statussuggestBox").trim().contains(consentData.status.trim())){
			return false;
		}			
		if(!getValue(selenium,txtDateSigned).trim().contains(consentData.dateSigned.trim())){
			return false;
		}
		if(consentData.signedBy.equalsIgnoreCase("Substitution Decision Maker")){
			if(!getValue(selenium,ajkRelationship).trim().contains(consentData.relationship.trim())){
				return false;
			}
			if(!getValue(selenium,txtFirstName).trim().contains(consentData.firstName.trim())){
				return false;
			}
			if(!getValue(selenium,txtLastName).trim().contains(consentData.lastName.trim())){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Verify stored values create consents
	 * @param selenium
	 * @param consentData
	 * @return
	 */
	public boolean verifyStoredValuesCA(Selenium selenium, HomeLib consentCAData){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajkConsentsType).trim().contains(consentCAData.consentType.trim())){
			return false;
		}
		if(!getValue(selenium,ajkConsentsName).trim().contains(consentCAData.consentName.trim())){
			return false;
		}
		if(!getValue(selenium,txtDateSigned).trim().contains(consentCAData.dateSigned.trim())){
			return false;
		}
		if(consentCAData.signedBy.equalsIgnoreCase("Substitution Decision Maker")){
			if(!getValue(selenium,ajkRelationship).trim().contains(consentCAData.relationship.trim())){
				return false;
			}
			if(!getValue(selenium,txtFirstName).trim().contains(consentCAData.firstName.trim())){
				return false;
			}
			if(!getValue(selenium,txtLastName).trim().contains(consentCAData.lastName.trim())){
				return false;
			}
		}
		if(consentCAData.status.equals("Enrollment")){
			if(!getValue(selenium,ajkEnrolementStatusSugBox).trim().contains(consentCAData.status.trim())){
				return false;
			}
			if(!getValue(selenium,ajkEnrolledSugBox).trim().contains(consentCAData.entrolled.trim())){
				return false;
			}
			if(!getValue(selenium,ajkEnrolementDte).trim().contains(consentCAData.entrolledDate.trim())){
				return false;
			}
			if(!getValue(selenium,txtCommentsConsents).trim().contains(consentCAData.comments.trim())){
				return false;
			}
		}
		if(consentCAData.status.equals("Ended")){
			if(!getValue(selenium,ajkEnrolementStatusSugBox).trim().contains(consentCAData.status.trim())){
				return false;
			}
			if(!getValue(selenium,ajkEnrolledSugBox).trim().contains(consentCAData.entrolled.trim())){
				return false;
			}
			if(!getValue(selenium,ajkEnrolementDte).trim().contains(consentCAData.entrolledDate.trim())){
				return false;
			}
			if(!getValue(selenium,txtEnrolmentEndDate).trim().contains(consentCAData.endDate.trim())){
				return false;
			}
			if(!getValue(selenium,txtReasonConsents).trim().contains(consentCAData.reason.trim())){
				return false;
			}
			if(!getValue(selenium,txtCommentsConsents).trim().contains(consentCAData.comments.trim())){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Verify stored values edit consents
	 * @param selenium
	 * @param consentCAData
	 * @return
	 */
	public boolean verifyStoredValuesEditConsents(Selenium selenium, HomeLib consentCAData){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajkConsentsType).trim().contains(consentCAData.consentType.trim())){
			return false;
		}
		if(!getValue(selenium,ajkConsentsName).trim().contains(consentCAData.consentName.trim())){
			return false;
		}
		if(consentCAData.signedBy.equalsIgnoreCase("Substitution Decision Maker")){
			if(!getValue(selenium,ajkRelationship).trim().contains(consentCAData.relationship.trim())){
				return false;
			}
			if(!getValue(selenium,txtFirstName).trim().contains(consentCAData.firstName.trim())){
				return false;
			}
			if(!getValue(selenium,txtLastName).trim().contains(consentCAData.lastName.trim())){
				return false;
			}
		}
		if(consentCAData.status.equals("Enrolled")){
			if(!getValue(selenium,ajkEnrolementStatusSugBox).trim().contains(consentCAData.status.trim())){
				return false;
			}
			if(!getValue(selenium,ajkEnrolledSugBox).trim().contains(consentCAData.entrolled.trim())){
				return false;
			}
			if(!getValue(selenium,ajkEnrolementDte).trim().contains(consentCAData.entrolledDate.trim())){
				return false;
			}
			if(!getValue(selenium,txtCommentsConsents).trim().contains(consentCAData.comments.trim())){
				return false;
			}
		}
		if(consentCAData.status.equals("Ended")){
			if(!getValue(selenium,ajkEnrolementStatusSugBox).trim().contains(consentCAData.status.trim())){
				return false;
			}
			if(!getValue(selenium,ajkEnrolledSugBox).trim().contains(consentCAData.entrolled.trim())){
				return false;
			}
			if(!getValue(selenium,ajkEnrolementDte).trim().contains(consentCAData.entrolledDate.trim())){
				return false;
			}
			if(!getValue(selenium,txtEnrolmentEndDate).trim().contains(consentCAData.endDate.trim())){
				return false;
			}
			if(!getValue(selenium,txtReasonConsents).trim().contains(consentCAData.reason.trim())){
				return false;
			}
			if(!getValue(selenium,txtCommentsConsents).trim().contains(consentCAData.comments.trim())){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * submitConsent
	 * @param selenium
	 * @param consentTestData
	 * @return
	 */
	public boolean submitConsent(Selenium selenium, HomeLibUnitTest consentTestData){
		
		try{	
			
			if(consentTestData.testCaseId.equals("TC_CI_001")){
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentTestData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,consentTestData.validationFieldID),"Expected alert not found; More Details :" + consentTestData.toString(), selenium, ClassName, MethodName);
				return true;
			}
			else if(consentTestData.testCaseId.equals("TC_CI_002")){
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentTestData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,consentTestData.validationFieldID),"Expected alert not found; More Details :" + consentTestData.toString(), selenium, ClassName, MethodName);
				return true;
			}else{
				selectValueFromAjaxList(selenium,ajkConsentsType, consentTestData.consentType);
				selectValueFromAjaxList(selenium,ajkConsentsName, consentTestData.consentName);
			}
			
			selectValueFromAjaxList(selenium,ajkStatus, consentTestData.status);
			
			if (isElementPresent(selenium, ajkInactivation))
			selectValueFromAjaxListUsingTypeKeys(selenium,ajkInactivation,consentTestData.inactivation);
			assertTrue(enterDate(selenium,txtDateSigned, consentTestData.dateSigned),"Could not enter date; More Details :" + consentTestData.toString(), selenium, ClassName, MethodName);
			
			if(consentTestData.signedBy.equalsIgnoreCase("Patient")){
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentTestData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				return true;
			}else if(consentTestData.signedBy.equalsIgnoreCase("Substitution Decision Maker")){
				assertTrue(click(selenium,rdoSubstitutionMark),"Could not select the susbstitution maker; More Details :" + consentTestData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,ajkRelationship);
				selectValueFromAjaxList(selenium,ajkRelationship,consentTestData.relationship);
				click(selenium,ajkValueSelect1);
				assertTrue(type(selenium,txtFirstName,consentTestData.firstName),"Could not enter the first name; More Details :" + consentTestData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLastName,consentTestData.lastName),"Could not enter last name; More Details :" + consentTestData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentTestData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				return true;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + consentTestData.toString());
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * verify Stored Values Update New Consents
	 * @param selenium
	 * @param consentData
	 * @return
	 */
	public boolean verifyStoredValuesUpdateNewConsents(Selenium selenium, HomeLib consentData){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajkConsentsType).trim().equalsIgnoreCase(consentData.consentType.trim())){
			return false;
		}
		if(!getValue(selenium,ajkConsentsName).trim().equalsIgnoreCase(consentData.consentName.trim())){
			return false;
		}
		if(!getValue(selenium,txtDateSigned).trim().equalsIgnoreCase(consentData.dateSigned.trim())){
			return false;
		}
		return true;
	}
	
	/**
	 * Verify Stored Values Signed By Patient
	 * @param selenium
	 * @param consentTestData
	 * @return
	 */
	public boolean verifyStoredValuesSignedByPatient(Selenium selenium, HomeLibUnitTest consentTestData){
		/*if(!getValue(selenium,ajkConsentsType).trim().contains(consentTestData.consentType.trim())){
			return false;
		}
		if(!getValue(selenium,ajkConsentsName).trim().contains(consentTestData.consentName.trim())){
			return false;
		}*/
		if(!getValue(selenium,ajkStatus).trim().contains(consentTestData.status.trim())){
			return false;
		}
		return true;
	}
	
	/**
	 * verify date Value
	 * @param selenium
	 * @param consentTestData
	 * @return
	 */
	public boolean verifydateValue(Selenium selenium, HomeLibUnitTest consentTestData){
		String dateNow = null;
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
		dateNow = formatter.format(currentDate.getTime());
	
		if(!getValue(selenium,txtDateSigned).trim().equalsIgnoreCase(dateNow.trim())){
			return false;
		}
		return true;
	}
	
	/**
	 * verify Other Stored Values
	 * @param selenium
	 * @param ContactData
	 * @return
	 */
	public boolean verifyOtherStoredValues(Selenium selenium, HomeLib ContactData){
		
		if(!getValue(selenium,ajkRelationship).trim().toLowerCase(new java.util.Locale("en", "US")).contains(ContactData.relationship.trim().toLowerCase(new java.util.Locale("en", "US")))){
			return false;
		}
		if(!getValue(selenium,txtLastName).trim().toLowerCase(new java.util.Locale("en", "US")).contains(ContactData.lastName.trim().toLowerCase(new java.util.Locale("en", "US")))){
			return false;
		}
		if(!getValue(selenium,txtFirstName).trim().toLowerCase(new java.util.Locale("en", "US")).contains(ContactData.firstName.trim().toLowerCase(new java.util.Locale("en", "US")))){
			return false;
		}
		return true;
	}	
	
	public boolean verifyEnrolleddateValue(Selenium selenium, HomeLibUnitTest consentsCATestData){
		String dateNow = null;
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		dateNow = formatter.format(currentDate.getTime());
		if(!getValue(selenium,ajkEnrolementDte).trim().equalsIgnoreCase(dateNow.trim())){
			return false;
		}
		return true;
	}
	public boolean verifydateValueConsents(Selenium selenium, HomeLibUnitTest consentsCATestData){
		String dateNow = null;
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		dateNow = formatter.format(currentDate.getTime());
		if(!getValue(selenium,txtEnrolmentEndDate).trim().equalsIgnoreCase(dateNow.trim())){
			return false;
		}
		if(!getValue(selenium,ajkEnrolementDte).trim().equalsIgnoreCase(dateNow.trim())){
			return false;
		}
		return true;
	}
	
	
	
	
	public boolean verifyStoredValuesAddContact(Selenium selenium, HomeLib ContactData, String userAccount){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajkRelationship).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(ContactData.relationship.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getValue(selenium,txtEmail).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getValue(selenium,txtContactAddr1).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.residentialAddrStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtContactAddr2).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.residentialAddrStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(userAccount.equalsIgnoreCase(CAAccount)){
			if(!getValue(selenium,txtContactZipCode).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.residentialAddrzipCodeCA.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		else{
			
			if(!getValue(selenium,txtContactZipCode).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}		
		
		}	
		
		
		
		if(!getValue(selenium,txtComments).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,ajkPrimPhone1).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtPrimPhoneExtn).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.telephoneextnNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}	
	public boolean verifyStoredValuesForMandatoryAddContact(Selenium selenium, HomeLib ContactData){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajkRelationship).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.relationship.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}	
	public boolean verifyStoredValuesInSummaryAddContact(Selenium selenium, HomeLib ContactData, String userAccount ){
		waitForPageLoad(selenium);
		System.out.println(getText(selenium,lblContactSummaryArea1).toLowerCase(new java.util.Locale("en","US")));
		if(!getText(selenium,lblContactSummaryArea1).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.relationship.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblContactSummaryArea1).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblContactSummaryArea1).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblContactSummaryArea1).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblContactSummaryArea1).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.telephoneextnNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
			click(selenium, lblContactSummaryArea1);
		
		if(!getText(selenium,lblContactSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.telephoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblContactSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.telephoneextnNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblContactSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.telephoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblContactSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.telephoneextnNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblContactSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.residentialAddrStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblContactSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.residentialAddrStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(userAccount.equalsIgnoreCase(CAAccount)){
			if(!getText(selenium,lblContactSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.residentialAddrzipCodeCA.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		else{
			if(!getText(selenium,lblContactSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}		
		
		}	
		
		if(!getText(selenium,lblContactSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblContactSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}	
	public boolean verifyStoredValuesInSummaryForMandatoryAddContact(Selenium selenium, HomeLib ContactData){
		waitForPageLoad(selenium);
		if(!getText(selenium,lblContactSummaryAreaManda).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.relationship.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblContactSummaryAreaManda).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblContactSummaryAreaManda).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}	
	
	public boolean verifyStoredValuesDeleteContact(Selenium selenium, HomeLib ContactData){
		
		if(!getValue(selenium,ajkRelationship).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.relationship.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
	
	public boolean verifyStoredValuesEditContact(Selenium selenium, HomeLib ContactData){
		
		if(!getValue(selenium,ajkRelationship).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.relationship.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(ContactData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}	
	
	public boolean verifyContactValuesInPatientInfoSummary(Selenium selenium, HomeLib ContactData){
		
		if(!getText(selenium,lblFirstNameSummary).trim().contains(ContactData.firstName.trim())){
		   waitForPageLoad(selenium);
			return false;
		}
		
		if(!getText(selenium,lblLastNameSummary).toLowerCase(new java.util.Locale("en","Us")).trim().contains(ContactData.lastName.trim().toLowerCase(new java.util.Locale("en","Us")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getText(selenium,lblContactTypeSummary).trim().contains(ContactData.relationship.trim())){
		    waitForPageLoad(selenium);
			return false;
		}
		return true;
	}
	
public boolean verifyCopiedValuesContactHouseHold(Selenium selenium, HomeLib ContactData){
		try {
		String lName=getValue(selenium,txtLastName);
		String fName=getValue(selenium,txtFirstName);
		String mailId =getValue(selenium,txtEmail);
		String zipCode=getValue(selenium,txtContactZipCode);
		String contactType=getValue(selenium,ajkPrimPhone1);
		assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		goToAdvancedSearchPage(selenium);
		assertTrue(type(selenium,txtSearchPatientBox,lName),"Could not type patient id", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		selenium.clickAt(txtSearchPatientBox,"");
		selenium.focus(txtSearchPatientBox);			
		selenium.fireEvent(txtSearchPatientBox,"keypress");
		//selenium.keyPress(txtSearchPatientBox, "\\9");
		waitForElement(selenium,lblPatientBorderBottom,10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ContactData.householdName, selenium, ClassName, MethodName);
		click(selenium,lblPatientResult);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,lnkPatientInfoSummary),"The searched patient information could not be loaded", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!getText(selenium,lblPatientSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(lName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblPatientSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(fName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblPatientSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(mailId.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,lblPatientSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(zipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblPatientSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(contactType.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}	

	public boolean verifyStoreValueinSummaryPageHealthCare(Selenium selenium,HomeLib healthTestData,HomeLib epData){
		waitForPageLoad(selenium);
		if(!getText(selenium,lblHealthCareTeamSummary).trim().contains(healthTestData.duration1.trim())){
			return false;
		}
		if(!getText(selenium,lblHealthCareTeamSummary).trim().contains(healthTestData.endNumber.trim())){
			return false;
		}
		if(!getText(selenium,lblHealthCareTeamSummary).trim().contains(healthTestData.timeperiod1.trim())){
			return false;
		}
		if(!getText(selenium,lblHealthCareTeamSummary).trim().contains(epData.role.trim())){
			return false;
		}
		
		return true;
	}
	
	
	public boolean verifyStoreValueinSummaryPageforExternalHealthCare(Selenium selenium,HomeLib healthTestData,String account){
		waitForPageLoad(selenium);
		
		if(!getText(selenium,lblHealthCareTeamSummary).trim().contains(healthTestData.teamName.trim())){
			return false;
		}
		if(!getText(selenium,lblHealthCareTeamSummary).trim().contains(healthTestData.lastName.trim())){
			return false;
		}
		if(!getText(selenium,lblHealthCareTeamSummary).trim().contains(healthTestData.firstName.trim())){
			return false;
		}
		click(selenium,"menuArrow");
		waitForPageLoad(selenium);
		System.out.println(getText(selenium,lblHealthCareTeamExpandedSummary));
		System.out.println(healthTestData.location1CA);
		if(account.equals(CAAccount)){
		if(!getText(selenium,lblHealthCareTeamExpandedSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(healthTestData.location1CA.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		}else{
			if(!getText(selenium,lblHealthCareTeamExpandedSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(healthTestData.location1.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}

//		101 Bio Street
//		Indigo Tower
//		Church Street, CA 11020
		return true;
	}
	
	public boolean verifyStoreValueinSummaryPageSearchHealthcare(Selenium selenium,HomeLib healthTestData,HomeLib epData){
		waitForPageLoad(selenium);
		if(!getText(selenium,lblHealthCareTeamSummary).trim().contains(healthTestData.duration1.trim())){
			return false;
		}
		if(!getText(selenium,lblHealthCareTeamSummary).trim().contains(healthTestData.endDate1.trim()))
{
			return false;
		}
		if(!getText(selenium,lblHealthCareTeamSummary).trim().contains(healthTestData.endNumber.trim())){
			return false;
		}
		if(!getText(selenium,lblHealthCareTeamSummary).trim().contains(healthTestData.timeperiod1.trim())){
			return false;
		}
		if(!getText(selenium,lblHealthCareTeamSummary).trim().contains(epData.role.trim())){
			return false;
		}
		if(!getText(selenium,lblHealthCareTeamSummary).trim().contains(healthTestData.location1.trim())){
			return false;
		}
		if(!getText(selenium,lblHealthCareTeamSummary).trim().contains(healthTestData.specialty.trim())){
			return false;
		}
		return true;
	}

	
	
	public boolean verifyStoredValuesIdentifier(Selenium selenium, HomeLib identifierData, String userAccount){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajkSuggestBox).trim().startsWith(identifierData.group.trim())){
			return false;
		}
		if(userAccount.equalsIgnoreCase(CAAccount)){
			if(!getValue(selenium,ajxTypeIdentifier).trim().contains(identifierData.typeCA.trim())){
				return false;
			}
		}
		else{
			if(!getValue(selenium,ajxTypeIdentifier).trim().contains(identifierData.type.trim())){
				return false;
			}
		}
		if(identifierData.type.equalsIgnoreCase("Driver's License Number")){
			if(!getValue(selenium,txtExpiration).trim().contains(identifierData.expirationdate.trim())){
				return false;
			}
			if(!getValue(selenium,txtValueMask).trim().contains(identifierData.value.trim())){
				return false;
			}
		}
		else{
			if(!getValue(selenium,txtValueMask).trim().contains(identifierData.value.trim())){
				return false;
			}
		}
		return true;
	}
	
	
	public boolean verifyDefaultValuesGroupAndType(Selenium selenium, HomeLib identifierData){
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajxGroup).trim().startsWith(identifierData.groupName.trim())){
			return false;
		}
		if(!getValue(selenium,ajxType).trim().contains(identifierData.idType.trim())){
			return false;
		}
		return true;
	}
	
	public boolean verifyStoredValuesIdentifierAccessLevel(Selenium selenium, SystemSettingsLib idTypeData){
		if(!getText(selenium,lblIdentifierTypeSummary).trim().contains(idTypeData.idType.trim())){
				return false;
		}
		if(!getText(selenium,lblIdentifierTypeSummary).trim().contains(idTypeData.idGroup.trim())){
			return false;
		}
		
		if(!getText(selenium,lblIdentifierTypeSummary).trim().contains(idTypeData.idTypeMask.trim())){
				return false;
		}
		if(!getText(selenium,lblIdentifierTypeSummary).trim().contains(idTypeData.expDate.trim())){
			return false;
		}
		return true;
	}
	
	
	
	public boolean verifyStoredValuesNotes(Selenium selenium, HomeLib noteData, String userAccount){
		waitForPageLoad(selenium);		
		if(userAccount.equalsIgnoreCase(CAAccount)){			
			if(!getValue(selenium,txtNoteDate).trim().contains(noteData.notedateCA.trim())){
				return false;
			}			
		}
		else{			
			if(!getValue(selenium,txtNoteDate).trim().contains(noteData.notedate.trim())){
				return false;
			}		
		}		
		
		if(!getValue(selenium,ajkSuggestBox).trim().equalsIgnoreCase(noteData.category.trim())){
			return false;
		}
		if(!getValue(selenium,txtNote).trim().contains(noteData.patientnote.trim())){
			return false;
		}
		return true;
	}
	public boolean verifyStoredValuesForMandatoryNotes(Selenium selenium,HomeLib noteData, String userAccount){
		waitForPageLoad(selenium);		
		if(userAccount.equalsIgnoreCase(CAAccount)){			
			if(!getValue(selenium,txtNoteDate).trim().contains(noteData.notedateCA.trim())){
				return false;
			}			
		}
		else{			
			if(!getValue(selenium,txtNoteDate).trim().contains(noteData.notedate.trim())){
				return false;
			}		
		}		
		
		if(!getValue(selenium,ajkSuggestBox).trim().equalsIgnoreCase(noteData.category.trim())){
			return false;
		}
		if(!getValue(selenium,txtNote).startsWith(noteData.patientnote.trim())){
			return false;
		}
		return true;
	}
	
	
	
	public boolean verifyStoredValuesPatientCheckinInfo(Selenium selenium, HomeLib patientData) {
		/*if(!getValue(selenium,ajkSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.primaryLocation.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxResponsbleProvider).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.responsibleProvider.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}*/
		waitForPageLoad(selenium);
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US") ).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtMiddleName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.middleName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxTitle).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.title.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxSuffix).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.suffix.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtAlias1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtAlias2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtDOB).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPrematureMeasure).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.measure.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxSex).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxmartialStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.maritalStatus.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
	/*	if(!getValue(selenium,txtStatusDate).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.statusDate.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}*/
		if(!getValue(selenium,txtResidentAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtResidentAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
	
		if(!getValue(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
	
		if(!getValue(selenium,ajxPhoneType1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtPrimaryPhone).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtPrimaryPhoneExtn).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPhoneType2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone1Extn).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPhoneType3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtEmail).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		if(!patientData.sameAsResidentialAddressCheck.contains("Yes")){
			if(!getValue(selenium,txtMailingAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtMailingAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
				
			if(!getValue(selenium,txtMailingZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressZipcode.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		
		if(!getValue(selenium,txtComments).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
		}
	public boolean verifyStoreValuesForMandatoryPatientCheckinInfo(Selenium selenium, HomeLib patientData){
		waitForPageLoad(selenium);
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US") ).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPrematureMeasure).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.measure.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxSex).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(patientData.testCaseId.equals("TC_NPC_017")|| patientData.testCaseId.equals("TC_NPC_008")){
			if(!getValue(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,ajxResidentialCountry).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrcountry.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
		}
		return true;
		}
	public boolean verifyStoredValuesinSummaryPagePatientCheckinInfo(Selenium selenium,HomeLib patientData){
		waitForPageLoad(selenium);
		/*if(!getText(selenium,"pcp").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.responsibleProvider.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		if(!getText(selenium,lblPatientName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblPatientName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtMiddleName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.middleName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblTitlePatient).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.title.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblSuffix).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.suffix.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblAlais).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblAlais).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"sex").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		/*if(!getText(selenium,lblPatientDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		if(!getText(selenium,lblStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtComments).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtResidentAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtResidentAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		/*if(!getText(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		if(!getText(selenium,lblPhoneType1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblPhoneExtn1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,lblPhoneType2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,lblPhoneExtn2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
	
		if(!getText(selenium,lblPhoneType3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,lblPhoneExtn3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,txtEmail).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
	
	int Year =0;
	int Months =0;
	long Days =0;
	int weeks=0;
	int hours=0;
	String resDate = "";
	Date CurrentDate = new Date();
	@SuppressWarnings("deprecation")
	Date DateOfBirth = new Date(patientData.dob);
	Calendar calDateOFBirth = Calendar.getInstance();
	Calendar calCurrentDate = Calendar.getInstance();

	calDateOFBirth.setTime(DateOfBirth);
	calCurrentDate.setTime(CurrentDate);
	Year = calCurrentDate.get(1) - calDateOFBirth.get(1);
	if(Year >= 0){
		if(calCurrentDate.get(2) > calDateOFBirth.get(2)){
			Months = (calCurrentDate.get(2) - calDateOFBirth .get(2));
		}else if(calCurrentDate.get(2) == calDateOFBirth.get(2) && Year != 0){
			Months =((calDateOFBirth.getMaximum(2)+1) - (calDateOFBirth.get(2)+1)) + (calCurrentDate.get(2)+1);
		}else if(Year != 0) {
			Year = Year - 1 ;
			Months =((calDateOFBirth.getMaximum(2)+1) - (calDateOFBirth.get(2)+1)) + (calCurrentDate.get(2)+1);
		}

		if(calDateOFBirth.get(5) > calCurrentDate.get(5)){
			Months = Months -1;
		}

		if(Months >= 1){
			if(calDateOFBirth.get(5) > calCurrentDate.get(5)){
				Days = (calDateOFBirth.getMaximum(5)-calDateOFBirth.get(5)) + calCurrentDate.get(5);
				if(calCurrentDate.get(2)== 2){
					Days = Days -3;
				}
			}else{
				Days = calCurrentDate.get(5) - calDateOFBirth.get(5);
			}
		}else if(Months<0) {
			Year = Year - 1;
			Months =((calDateOFBirth.getMaximum(2)+1) - (calDateOFBirth.get(2)+1)) + (calCurrentDate.get(2));

		}else{
			Days = CurrentDate.getTime() - DateOfBirth.getTime();
			Days = Days / (1000*60*60*24);
		}

		if(Year > 18){
			resDate = Integer.toString(Year)+ " years";
			if(!getText(selenium,lblAge).contains(resDate))
				return false;
		}else if(Year <= 18 && Year >= 2){
			resDate = Integer.toString(Year) +" years " + Months +" months" ;
			if(!getText(selenium,lblAge).contains(resDate))
				return false;
		}else if(Year < 2 && Months > 4){
			resDate = Integer.toString(Months)+" months" ;
			if(!getText(selenium,lblAge).contains(resDate))
				return false;
		
		}else if(Year<0 && Months<=3 && (int)Days>29){
		if(Months>0){
			weeks=(int) ((Months*4) + (Days/7));
			resDate=Integer.toString(weeks);
		}
		else{
			weeks=(int)(Days/7);
			resDate=Integer.toString(weeks);
		}
		if(!getText(selenium,lblAge).contains(resDate))
			return false;
		}
		else if((int)Days>=5&&(int)Days<28){
			resDate =Integer.toString((int) Days);
		if(!getText(selenium,lblAge).contains(resDate))
			return false;
		}else{
			hours=(int) (Days*24);
			resDate=Integer.toString(hours);
			if(!getText(selenium,lblAge).contains(resDate))
				return false;
			}
		}else{
		resDate = "Invalid";
	}
	return true;
	}

	public boolean verifyStoreValuesInSummaryForMandatoryPatientCheckinInfo(Selenium selenium,HomeLib patientData){
		waitForPageLoad(selenium);
		if(!getText(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(patientData.testCaseId.equals("TC_NPC_017")|| patientData.testCaseId.equals("TC_NPC_008")){
			if(!getText(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
			}
		}
		
		
		return true;
	}

	
	public boolean verifyStoredValuesPatientCheckinInfoCA(Selenium selenium, HomeLib patientData,String uniqueName) {
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if(!patientData.testCaseId.toString().contains("TC_NPC_004"))
		{
			if(!getValue(selenium,ajxSuggestBoxProg).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.primaryLocation.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			
		}
		if(!getValue(selenium,ajxResponsibleProvider).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.responsibleProvider.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		if(!getValue(selenium,txtHealthCareNumber).trim().equals(uniqueName)){
			return false;
		}
		if(patientData.testCaseId.equalsIgnoreCase("TC_NPC_004")){
			if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US") ).trim().contains((patientData.lastName+uniqueName).trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
		}
		}
		if(!patientData.testCaseId.equalsIgnoreCase("TC_NPC_004")){
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US") ).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
			}
		if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtMiddleName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.middleName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxTitle).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.title.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxSuffix).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.suffix.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtAlias1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtAlias2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtDOB).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPrematureMeasure).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.measure.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxSex).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxmartialStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.maritalStatus.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtStatusDate).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.statusDate.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtResidentAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtResidentAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		if(!getValue(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		if(!getValue(selenium,ajxPhoneType1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtPrimaryPhone).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtPrimaryPhoneExtn).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPhoneType2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone1Extn).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPhoneType3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtEmail).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtMailingAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtMailingAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtMailingZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressZipcode.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtComments).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
	public boolean verifyStoredValuesinSummaryPagePatientCheckinInfoCA(Selenium selenium,HomeLib patientData,String uniqueName){
		waitForPageLoad(selenium);
		
		if(!getText(selenium,lblPatientName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblPatientName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtMiddleName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.middleName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblTitlePatient).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.title.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblSuffix).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.suffix.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblAlais).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblAlais).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblHealthCareNumber).toLowerCase(new java.util.Locale("en","US")).trim().contains(uniqueName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"sex").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		/*if(!getText(selenium,"dob").trim().contains("(Jun 15, 1991)".trim())){
			return false;
		}*/
		if(!getText(selenium,lblStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtComments).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtResidentAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtResidentAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblPhoneType1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblPhoneExtn1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,lblPhoneType2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,lblPhoneExtn2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}

		if(!getText(selenium,lblPhoneType3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,lblPhoneExtn3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,txtEmail).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		return true;
	}

	
	public boolean verifyStoredValuesPatientInfoDuplicate(Selenium selenium, HomeLib patientData) {
		/*if(!getValue(selenium,ajkSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.primaryLocation.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}*/
		/*if(!getValue(selenium,ajxResponsbleProvider).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.responsibleProvider.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}*/
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US") ).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtMiddleName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.middleName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtAlias1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtAlias2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtDOB).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPrematureMeasure).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.measure.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxSex).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxmartialStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.maritalStatus.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtStatusDate).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.statusDate.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPhoneType1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtPrimaryPhone).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtPrimaryPhoneExtn).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPhoneType2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone1Extn).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPhoneType3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtEmail).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtMailingZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressZipcode.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtComments).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
	
	
	public boolean verifyStoredValuesEditPatient(Selenium selenium, HomeLib patientData){
		waitForPageLoad(selenium);
			
		if(!isChecked(selenium,chkResponsibleProvider)){
			return false;
		}
		
		if(!getValue(selenium,ajkSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.primaryLocation.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US") ).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtMiddleName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.middleName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		System.out.println(getValue(selenium,ajxTitle));
		/*if(!getValue(selenium,ajxTitle).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.title.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}*/
		if(!getValue(selenium,ajxSuffix).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.suffix.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtAlias1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtAlias2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtDOB).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxSex).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtStatusDate).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.statusDate.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtResidentAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtResidentAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPhoneType1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtPrimaryPhone).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtPrimaryPhoneExtn).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPhoneType2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone1Extn).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPhoneType3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtEmail).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		return true;
	}
	
	public boolean verifyStoredValuesEditPatientCheckInCA(Selenium selenium, HomeLib patientData,String uniquedata){
		
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US") ).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtMiddleName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.middleName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		System.out.println(getValue(selenium,"css=#healthcardNumber"));
		if(!getValue(selenium,"css=#healthcardNumber").trim().contains(uniquedata.trim())){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxTitle).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.title.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxSuffix).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.suffix.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtAlias1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtAlias2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtDOB).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxSex).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtStatusDate).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.statusDate.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtResidentAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtResidentAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPhoneType1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtPrimaryPhone).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtPrimaryPhoneExtn).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPhoneType2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone1Extn).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPhoneType3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtEmail).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		/*if(!getValue(selenium,txtMailingZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressZipcode.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		if(!getValue(selenium,txtComments).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
	return true;
	}
	
	public boolean verifyStoredValuesClearFieldPatientInfo(Selenium selenium, HomeLib patientData) {
		
		waitForPageLoad(selenium);
			
			if(!getValue(selenium,ajkSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.primaryLocation.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,ajxResponsbleProvider).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.responsibleProvider.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US") ).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtMiddleName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.middleName.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,ajxTitle).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.title.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,ajxSuffix).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(patientData.suffix.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtAlias1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias1.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtAlias2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias2.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtDOB).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,ajxPrematureMeasure).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.measure.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,ajxSex).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,ajxmartialStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.maritalStatus.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,ajxStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtStatusDate).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.statusDate.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtResidentAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtResidentAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			/*if(!getValue(selenium,txtResidentialCity).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrcity1.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,"residentialStateSuggestBoxsuggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrstate1.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}*/
			if(!getValue(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			/*if(!getValue(selenium,ajxCountry).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrcountry.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}*/
			/*if(!getValue(selenium,ajxPhoneType1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}*/
			if(!getValue(selenium,txtPrimaryPhone).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtPrimaryPhoneExtn).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,ajxPhoneType2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtOtherPhone1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtOtherPhone1Extn).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,ajxPhoneType3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtOtherPhone2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtOtherPhone2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtEmail).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtMailingAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtMailingAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtMailingZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressZipcode.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtComments).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		return true;
	}

	public boolean verifyStoreValuePatientCheckinDefaultValue(Selenium selenium, HomeLibUnitTest patientData){
		Calendar currentDate = Calendar.getInstance();
		String dateNow=null;
		SimpleDateFormat formatter= 
			 new SimpleDateFormat("MM/dd/yyyy");
			 dateNow = formatter.format(currentDate.getTime());
			 System.out.println("Now the date is :  " + dateNow);
		
		if(!getValue(selenium,txtLastName).trim().contains(patientData.lastName.trim())){
			return false;
		}
		if(!getValue(selenium,txtFirstName).trim().contains(patientData.firstName.trim())){
			return false;
		}
		if(!getValue(selenium,ajxmartialStatus).trim().equalsIgnoreCase(patientData.status.trim())){
			return false;
		}
		if(!getValue(selenium,txtStatusDate).trim().contains(patientData.statusDate.trim())){
			return false;
		}
		return true;
	}
	
	
	
	
	public boolean verifyStoredValuesCreatePrograms(Selenium selenium, HomeLib programData,String userAccount){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajxProgram).trim().contains(programData.program.trim())){
			return false;
		}
		
		
		if(userAccount.equalsIgnoreCase(CAAccount)){
		
			if(!getValue(selenium,txtFromDate).trim().contains(programData.fromdateCA.trim())){
				return false;
			}
			if(!getValue(selenium,txtToDate).trim().contains(programData.todateCA.trim())){
				return false;
			}
			
		}
		else{			
			
			if(!getValue(selenium,txtFromDate).trim().contains(programData.fromdate.trim())){
				return false;
			}
			if(!getValue(selenium,txtToDate).trim().contains(programData.todate.trim())){
				return false;
			}
		
		}
						
		
		if(!getValue(selenium,txtPrior).trim().contains(programData.priorstate.trim())){
			return false;
		}
		if(!getValue(selenium,txtOutCome).trim().contains(programData.outcome.trim())){
			return false;
		}
		return true;
	}
	
	
	public boolean verifyStoredValuesEditProgram(Selenium selenium, HomeLib programData){
		waitForPageLoad(selenium);
		if(!getValue(selenium,txtFromDate).trim().contains(programData.fromdate.trim())){
			return false;
		}
		if(!getValue(selenium,txtToDate).trim().contains(programData.todate.trim())){
			return false;
		}
		if(!getValue(selenium,txtPrior).trim().contains(programData.priorstate.trim())){
			return false;
		}
		if(!getValue(selenium,txtOutCome).trim().contains(programData.outcome.trim())){
			return false;
		}
		return true;
	}
	
	public boolean verifyStoredValuesAdminProgram(Selenium selenium, HomeLib programData, String userAccount){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajxProgram).trim().contains(programData.program.trim())){
			return false;
		}
		if(!getText(selenium,"department").trim().contains(programData.department.trim())){
			return false;
		}
		
		if(userAccount.equalsIgnoreCase(CAAccount)){
			if(!getValue(selenium,txtFromDate).trim().contains(programData.fromdateCA.trim())){
				return false;
			}
		}
		else{
			if(!getValue(selenium,txtFromDate).trim().contains(programData.fromdate.trim())){
				return false;
			}			
		}
		
		return true;
			
	}
	
	
	public boolean verifyStoredValuesReferrals(Selenium selenium, HomeLib refData){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajxReferralType).trim().contains(refData.refType.trim())){
			return false;
		}
		if(!getValue(selenium,ajxReferredBy).trim().equalsIgnoreCase(refData.refBy.trim())){
			return false;
		}
		/*if(!getValue(selenium,ajxAddress).trim().contains(refData.addr.trim())){
			return false;
		}*/
		if(!getValue(selenium,ajxReferedTo).trim().contains(refData.refTo.trim())){
			return false;
		}
		if(!getValue(selenium,ajxReferralSpecial).trim().contains(refData.speciality.trim())){
			return false;
		}
		if(!getValue(selenium,ajxReferralDiagnoses).trim().contains(refData.diagCode.trim())){
			return false;
		}
		if(!getValue(selenium,txtReferralReason).trim().contains(refData.referralReason.trim())){
			return false;
		}
		if(!getValue(selenium,txtReferralDate).trim().contains(refData.referralDate.trim())){
			return false;
		}
		if(!getValue(selenium,txtReferralEndDate).trim().contains(refData.referralEndDate.trim())){
			return false;
		}
		if(!getValue(selenium,txtReferralComments).trim().contains(refData.refComments.trim())){
			return false;
		}
		if(!getValue(selenium,ajxPayer).trim().contains(refData.payer.trim())){
			return false;
		}
		if(!getValue(selenium,txtNumVisit).trim().contains(refData.numVisits1.trim())){
			return false;
		}
		if(!getValue(selenium,txtRequestDate).trim().contains(refData.requestDate2.trim())){
			return false;
		}
		if(!getValue(selenium,txtApprovalDate).trim().contains(refData.approvalDate2.trim())){
			return false;
		}
		if(!getValue(selenium,txtAuthorizationNum).trim().contains(refData.authorizationNum2.trim())){
			return false;
		}
		if(!getValue(selenium,txtNumAuthorizationVisit).trim().contains(refData.numAuthorizedVisits2.trim())){
			return false;
		}
		if(!getValue(selenium,txtStartDate1).trim().contains(refData.startDate2.trim())){
			return false;
		}
		if(!getValue(selenium,txtEndDate1).trim().contains(refData.endDate2.trim())){
			return false;
		}
		return true;
	}
	
	public boolean verifyStoredValuesForMandatoryReferrals(Selenium selenium, HomeLib refData,String account){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajxReferralType).trim().contains(refData.refType.trim())){
			return false;
		}
		if(!getValue(selenium,ajxReferredBy).trim().equalsIgnoreCase(refData.refBy.trim())){
				
			return false;
		}
		if(!getValue(selenium,txtReferralDate).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(refData.referralDate.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
	
	
	public boolean verifyStoredValuesCreateSocioEconomics(Selenium selenium, HomeLib sEconomicData, String userAccount) throws IOException{
		if(!getValue(selenium,ajxRaceSocio).trim().toLowerCase(new java.util.Locale("en", "US")).equalsIgnoreCase(sEconomicData.race.trim().toLowerCase(new java.util.Locale("en", "US")))){
			return false;
		}

		if(!getValue(selenium,ajxEthniCity).trim().contains(sEconomicData.ethnicity.trim())){
			return false;
		}

		if(!getValue(selenium,ajxReligion).trim().contains(sEconomicData.religion.trim())){
			return false;
		}
		if(!getValue(selenium,ajxCitizenship).trim().toLowerCase(new java.util.Locale("en", "US")).contains(sEconomicData.citizenship.trim().toLowerCase(new java.util.Locale("en", "US")))){
			return false;
		}
		if(!getValue(selenium,ajxCountry).trim().contains(sEconomicData.countryPanel.trim())){
			return false;
		}
		if(!getValue(selenium,ajxSpokenLanguage).trim().contains(sEconomicData.languagePanel.trim())){
			return false;
		}	
		
		
		
		/*if(!getValue(selenium,ajxLanguageSpoken).trim().contains(sEconomicData.languagespoken.trim())){
			return false;
		}*/
		if(!getValue(selenium,txtInterupterName).trim().contains(sEconomicData.interpreter.trim())){
			return false;
		}
		assertTrue(
		        	getValue(selenium,ajxEthniCity).trim().contains(sEconomicData.ethnicity.trim()),
				    "Verification Failed",selenium, ClassName, MethodName);
		/*if(!getValue(selenium,ajxLiveArrangements).trim().contains(sEconomicData.livingArrangement.trim())){
			return false;
		}*/
			
		if(!getValue(selenium,ajxStudentStatus).trim().contains(sEconomicData.studentStatus.trim())){
			return false;
		}

		if(!getValue(selenium,ajxEducationLevel).trim().contains(sEconomicData.educationLevel.trim())){
			return false;
		}

		
		if(!getValue(selenium,txtPeopleNumber).trim().contains(sEconomicData.numPeopleText.trim())){
			return false;
		}
		if(!getValue(selenium,ajxHouseHoldComposition).trim().contains(sEconomicData.householdComposition.trim())){
			return false;
		}
		if(!getValue(selenium,ajxHouseLess).trim().contains(sEconomicData.homelessStatus.trim())){
			return false;
		}

		if(!getValue(selenium,ajxEmployeement).trim().contains(sEconomicData.employmentStatus.trim())){
			return false;
		}

		if(!getValue(selenium,txtComments).trim().contains(sEconomicData.comments1.trim())){
			return false;
		}
		return true;
	}
	
	public boolean verifyStoredValuesCreateSocioEconomicsCA(Selenium selenium, HomeLib sEconomicData){
        
	       
        
        try {
               assertTrue(getValue(selenium,ajxRaceSocio).trim().toLowerCase(new java.util.Locale("en", "US")).equalsIgnoreCase(sEconomicData.race.trim().toLowerCase(new java.util.Locale("en", "US"))), "Could not Find race data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,ajxEthniCity).trim().contains(sEconomicData.ethnicity.trim()), "Could not Find ethnicity data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,ajxReligion).trim().contains(sEconomicData.religion.trim()), "Could not Find race data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,ajxCitizenship).trim().toLowerCase(new java.util.Locale("en", "US")).contains(sEconomicData.citizenship.trim().toLowerCase(new java.util.Locale("en", "US"))), "Could not Find race data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,ajxCitizenship).trim().toLowerCase(new java.util.Locale("en", "US")).contains(sEconomicData.citizenship.trim().toLowerCase(new java.util.Locale("en", "US"))), "Could not Find race data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,ajxCountry).trim().contains(sEconomicData.countryPanel.trim()), "Could not Find race data"  , selenium, ClassName, MethodName);
               
        //       assertTrue(getValue(selenium,ajxSpokenLanguage).trim().contains(sEconomicData.languagePanel.trim()), "Could not Find race data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,ajxOfficialLanguage).trim().contains(sEconomicData.officialLanguage.trim()), "Could not Find race data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,ajxPreferredLanguage).trim().contains(sEconomicData.languagespoken.trim()), "Could not Find race data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,txtInterupterName).trim().contains(sEconomicData.interpreter.trim()), "Could not Find race data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,ajxStudentStatus).trim().contains(sEconomicData.studentStatus.trim()), "Could not Find race data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,ajxEducationLevel).trim().contains(sEconomicData.educationLevel.trim()), "Could not Find race data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,txtPeopleNumber).trim().contains(sEconomicData.numPeopleText.trim()), "Could not Find race data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,ajxHouseLess).trim().contains(sEconomicData.homelessStatus.trim()), "Could not Find race data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,ajxAgeGroup).trim().contains(sEconomicData.ageGroupIndicator.trim()), "Could not Find race data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,ajxEmployeement).trim().contains(sEconomicData.employmentStatus.trim()), "Could not Find race data"  , selenium, ClassName, MethodName);
               
               assertTrue(getValue(selenium,txtComments).trim().contains(sEconomicData.comments1.trim()), "Could not Find race data"  , selenium, ClassName, MethodName);
                           
        } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }
        
        return true;
 }

	public boolean verifyStoredValuesEditSocioEconomics(Selenium selenium, HomeLib sEconomicData){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajxRaceSocio).trim().toLowerCase(new java.util.Locale("en", "US")).equalsIgnoreCase(sEconomicData.race.trim().toLowerCase(new java.util.Locale("en", "US")))){
			return false;
		}
		if(!getValue(selenium,ajxEthniCity).trim().contains(sEconomicData.ethnicity.trim())){
			return false;
		}

		if(!getValue(selenium,ajxReligion).trim().contains(sEconomicData.religion.trim())){
			return false;
		}
		if(!getValue(selenium,ajxCitizenship).trim().toLowerCase(new java.util.Locale("en", "US")).contains(sEconomicData.citizenship.trim().toLowerCase(new java.util.Locale("en", "US")))){
			return false;
		}
		if(!getValue(selenium,ajxCountry).trim().contains(sEconomicData.countryPanel.trim())){
			return false;
		}
		if(!getValue(selenium,ajxLanguageSpoken).trim().contains(sEconomicData.languagespoken.trim())){
			return false;
		}
		if(!getValue(selenium,txtDateOfArrival).trim().contains(sEconomicData.arrivalDate.trim())){
			return false;
		}
		if(!getValue(selenium,ajxSpokenLanguage).trim().contains(sEconomicData.languagePanel.trim())){
			return false;
		}
		if(!getValue(selenium,ajxParentEthnicity).trim().contains(sEconomicData.parentEthnicityPanel.trim())){
			return false;
		}
		if(!getValue(selenium,ajxLiveArrangements).trim().contains(sEconomicData.livingArrangement.trim())){
			return false;
		}
		if(!getValue(selenium,ajxStudentStatus).trim().contains(sEconomicData.studentStatus.trim())){
			return false;
		}
		/*if(!getValue(selenium,ajxEducationLevel).trim().contains(sEconomicData.educationLevel.trim())){
			return false;
		}*/
		if(!getValue(selenium,ajxHouseHoldIncome).trim().contains(sEconomicData.householdIncome.trim())){
			return false;
		}
		if(!getValue(selenium,txtPeopleNumber).trim().contains(sEconomicData.numPeopleText.trim())){
			return false;
		}
		if(!getValue(selenium,txtComments).trim().contains(sEconomicData.comments1.trim())){
			return false;
		}
		return true;
	}
	
	public boolean verifyStoredValuesEditSocioEconomicsCA(Selenium selenium, HomeLib sEconomicData){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajxRaceSocio).trim().toLowerCase(new java.util.Locale("en", "US")).equalsIgnoreCase(sEconomicData.race.trim().toLowerCase(new java.util.Locale("en", "US")))){
			return false;
		}
		if(!getValue(selenium,ajxEthniCity).trim().contains(sEconomicData.ethnicity.trim())){
			return false;
		}

		if(!getValue(selenium,ajxReligion).trim().contains(sEconomicData.religion.trim())){
			return false;
		}
		if(!getValue(selenium,ajxCitizenship).trim().toLowerCase(new java.util.Locale("en", "US")).contains(sEconomicData.citizenship.trim().toLowerCase(new java.util.Locale("en", "US")))){
			return false;
		}
		if(!getValue(selenium,ajxCountry).trim().contains(sEconomicData.countryPanel.trim())){
			return false;
		}
	
		/*if(!getValue(selenium,ajxSpokenLanguage).trim().contains(sEconomicData.languagePanel.trim())){
			return false;
		}*/
	
		if(!getValue(selenium,txtDateOfArrival).trim().contains(sEconomicData.arrivalDate.trim())){
			return false;
		}
		if(!getValue(selenium,ajxOfficialLanguage).trim().contains(sEconomicData.officialLanguage.trim())){
			return false;
		}
		/*if(!getValue(selenium,ajxLanguageSpoken).trim().contains(sEconomicData.languagespoken.trim())){
			return false;
		}*/
		if(!getValue(selenium,txtInterupterName).trim().contains(sEconomicData.interpreter.trim())){
			return false;
		}
		if(!getValue(selenium,ajxParentEthnicity).trim().contains(sEconomicData.parentEthnicityPanel.trim())){
			return false;
		}

		/*if(!getValue(selenium,ajxLiveArrangements).trim().contains(sEconomicData.livingArrangement.trim())){
			return false;
		}*/
			
		if(!getValue(selenium,ajxStudentStatus).trim().contains(sEconomicData.studentStatus.trim())){
			return false;
		}
	
		if(!getValue(selenium,ajxEducationLevel).trim().contains(sEconomicData.educationLevel.trim())){
			return false;
		}
		if(!getValue(selenium,txtPeopleNumber).trim().contains(sEconomicData.numPeopleText.trim())){
			return false;
		}
		if(!getValue(selenium,ajxHouseHoldComposition).trim().contains(sEconomicData.householdComposition.trim())){
			return false;
		}
		if(!getValue(selenium,ajxHouseLess).trim().contains(sEconomicData.homelessStatus.trim())){
			return false;
		}
		if(!getValue(selenium,ajxAgeGroup).trim().contains(sEconomicData.ageGroupIndicator.trim())){
			return false;
		}
		if(!getValue(selenium,ajxEmployeement).trim().contains(sEconomicData.employmentStatus.trim())){
			return false;
		}
		if(!getValue(selenium,txtComments).trim().contains(sEconomicData.comments1.trim())){
			return false;
		}
		return true;
	}

	
	
	public boolean verifyStoredValuesClearFieldSocioEconomics(Selenium selenium, HomeLib sEconomicData){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajxRaceSocio).trim().toLowerCase(new java.util.Locale("en", "US")).equalsIgnoreCase(sEconomicData.race.trim().toLowerCase(new java.util.Locale("en", "US")))){
			return false;
		}
		if(!getValue(selenium,ajxEthniCity).trim().contains(sEconomicData.ethnicity.trim())){
			return false;
		}
		if(!getValue(selenium,ajxReligion).trim().contains(sEconomicData.religion.trim())){
			return false;
		}
		if(!getValue(selenium,ajxCitizenship).trim().toLowerCase(new java.util.Locale("en", "US")).contains(sEconomicData.citizenship.trim().toLowerCase(new java.util.Locale("en", "US")))){
			return false;
		}
		if(!getValue(selenium,ajxCountry).trim().contains(sEconomicData.countryPanel.trim())){
			return false;
		}
		if(!getValue(selenium,ajxLanguageSpoken).trim().contains(sEconomicData.languagespoken.trim())){
			return false;
		}
		if(!getValue(selenium,txtDateOfArrival).trim().contains(sEconomicData.arrivalDate.trim())){
			return false;
		}
		if(!getValue(selenium,ajxSpokenLanguage).trim().contains(sEconomicData.languagePanel.trim())){
			return false;
		}
		if(!getValue(selenium,ajxParentEthnicity).trim().contains(sEconomicData.parentEthnicityPanel.trim())){
			return false;
		}
		if(!getValue(selenium,ajxLiveArrangements).trim().contains(sEconomicData.livingArrangement.trim())){
			return false;
		}
		if(!getValue(selenium,ajxStudentStatus).trim().contains(sEconomicData.studentStatus.trim())){
			return false;
		}
		if(!getValue(selenium,ajxEducationLevel).trim().contains(sEconomicData.educationLevel.trim())){
			return false;
		}
		if(!getValue(selenium,ajxHouseHoldIncome).trim().contains(sEconomicData.householdIncome.trim())){
			return false;
		}
		if(!getValue(selenium,txtPeopleNumber).trim().contains(sEconomicData.numPeopleText.trim())){
			return false;
		}
		if(!getValue(selenium,ajxHouseHoldComposition).trim().contains(sEconomicData.householdComposition.trim())){
			return false;
		}
		if(!getValue(selenium,ajxHouseLess).trim().contains(sEconomicData.homelessStatus.trim())){
			return false;
		}
		if(!getValue(selenium,ajxEmployeement).trim().contains(sEconomicData.employmentStatus.trim())){
			return false;
		}
		if(!getValue(selenium,txtComments).trim().contains(sEconomicData.comments1.trim())){
			return false;
		}
		return true;
	}
	
	
	
	
	//*********************************//
	//    Unfinished Item Reusables    //
	//*********************************//
	
	public boolean deleteAllUnfinishedItem(Selenium selenium) throws ParseException{
		
		boolean unfinishedItemDeleted = true;
		int timeLimitDoNotDelete=30;//In minute
		int deleteElementPossition=1;
		try{
			
			//click the unfinished item link
			Assert.assertTrue(click(selenium,lnkUnfinishedItem));
			
			//if show more link exists then click the show more link in unfinished item(need for get unfinished item count)
			if(isElementPresent(selenium, lnkShowMoreUnfinishedItem)){
				click(selenium, lnkShowMoreUnfinishedItem);
			}
			
			waitForElement(selenium, lnkDeleteUnfinishedItem, WAIT_TIME);
			
			
			//check the not needed unfinished items in the list
			while((Integer) selenium.getXpathCount(lnkDeleteUnfinishedItem) >= deleteElementPossition){
				String temp = getText(selenium, "//div[@id='unfinishedItemMenuID']/div[2]/ul/li["+deleteElementPossition+"]/div/div/div[2]");
				
				if(temp. equalsIgnoreCase("Today")){
					//get the time of unfinished item created with AM/ PM format
					String timeWithAMPM =selenium.getText("//div[@id='unfinishedItemMenuID']/div[2]/ul/li["+deleteElementPossition+"]/div/div/div");
					
															
					//get the time only from the above string
					String timeOnly= timeWithAMPM.replaceAll("[A-Z]", "");
					
					//get the Hour and Minute
					String SplitTimeOnly[]= timeOnly.split(":");
						
					int Hour= Integer.parseInt(SplitTimeOnly[0]);
					int Minute= Integer.parseInt(SplitTimeOnly[1]);
						
					//Calculate to 24 hour format
					if(timeWithAMPM.endsWith("PM")){
						
						if(Hour!=12){
							Hour= Hour + 12;
						}
					}
					else {
						if(Hour==12){
							Hour=0;
						}
					}
					
					//Now the unfinished item time format changed to 24 hour format
					String changedTimeFormat= String.valueOf(Hour)+":"+String.valueOf(Minute);
					 // String changedTimeFormat = String.valueOf(Hour);  
				     
				     SimpleDateFormat format = new SimpleDateFormat("HH:mm");
				     
				     //get the current time
				     Date date = new Date();
				     String currenttime = format.format(date);
				     
				     
				     Date date1 = format.parse(changedTimeFormat);
				     Date date2 = format.parse(currenttime);
				     //get the difference between current time and unfinished item created time
				     long difference = date2.getTime() - date1.getTime(); 
				     
				     //use the condition to exclude the unfinished item do not delete
				     if( !(difference<(timeLimitDoNotDelete*60*1000))){
				    	 
						 //mouse over some times not worked in automation perspective.. but, If we click the needed element before mouse over.. it is clicked
						 //So, We create 'click1' reusable function with without checking visibility
						assertTrue(click1(selenium,"xpath=(//div[@class='unfinished-item-delete']/a)["+deleteElementPossition+"]")," ", selenium, ClassName, MethodName);
						assertTrue(click(selenium,btnYesUnfinishedItem)," ", selenium, ClassName, MethodName);
						 
						 if(isElementPresent(selenium, "css=li.showMoreUnfinishedItems")){
							 click(selenium, "css=li.showMoreUnfinishedItems");
						 }
				     }
				
				     //here we used else logic for do not distrub the particular unfinished item in the next iteration
				     else{
				    	 deleteElementPossition= deleteElementPossition + 1;
				     }
				}
				
				else{
					 //mouse over some times not worked in automation perspective.. but, If we click the needed element before mouse over.. it is clicked
					 //So, We create 'click1' reusable function with without checking visibility
					assertTrue(click1(selenium,"xpath=(//div[@class='unfinished-item-delete']/a)["+deleteElementPossition+"]")," ", selenium, ClassName, MethodName);
					 Assert.assertTrue(click(selenium,btnYesUnfinishedItem));
					 
					 if(isElementPresent(selenium, "css=li.showMoreUnfinishedItems")){
						 click(selenium, "css=li.showMoreUnfinishedItems");
					 }
				}
			     
			    
				
				 waitForElement(selenium, lnkDeleteUnfinishedItem, WAIT_TIME);
				
			}
			
			//close the unfinished item menu if it is opened
			if(!isElementPresent(selenium, lnkUnfinishedItemOpenArrow)){
				assertTrue(click(selenium,lnkUnfinishedItem)," ", selenium, ClassName, MethodName);
			}
			
			return unfinishedItemDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }


	
	
	public boolean storeDataInUnfinishedItem(Selenium selenium){
		try {
		//navigate to some other section for store the current item to unfinished item
		assertTrue(click(selenium,lnkPatientInfoSummary)," ", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//click the continue button to store the current item to unfinished item
		//Assert.assertTrue(click(selenium,lnkContinueUnfinishedItem));
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,btnYesUnfinishedItem))
		{
		assertTrue(click(selenium,btnYesUnfinishedItem)," ", selenium, ClassName, MethodName);
		}
		else
		{
			assertTrue(click(selenium,lnkContinueUnfinishedItem)," ", selenium, ClassName, MethodName);
		}
		waitForPageLoad(selenium);
		if(!isElementPresent(selenium, lnkPatientInfoSummary)){
			return false;
		}
		
		
		return true;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public boolean navigateToUnfinishedItem(Selenium selenium, String currentUnfinishedItem){
		//if unfinished item menu not opened, then open it
		try {
		if(isElementPresent(selenium, lnkUnfinishedItemOpenArrow)){
			assertTrue(click(selenium,lnkUnfinishedItem)," ", selenium, ClassName, MethodName);
		}
		
		int count=1;
		int unfinishedItemcount=(Integer) (selenium.getXpathCount(lnkDeleteUnfinishedItem));
		//use this loop for select the unfinished item we want from the whole item list
		while(unfinishedItemcount>=count){
			if(getText(selenium, "//div[@id='unfinishedItemMenuID']/div[2]/ul/li["+count+"]/div/div[2]").contains(currentUnfinishedItem)){
				assertTrue(click(selenium,"//div[@id='unfinishedItemMenuID']/div[2]/ul/li["+count+"]/div/div[2]")," ", selenium, ClassName, MethodName);
				return true;
			}
			count++;
		}
		return false;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	
	/**
	 * Verify Store Value For Add Programs In UnFinished Item
	 * @param selenium
	 * @param Add Programs
	 * @return
	 */
	
	public boolean verifyStoredValuesAddPrograms(Selenium selenium, HomeLib programData,String account){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajkSuggestBox).trim().contains(programData.program.trim())){
			return false;
		}
		
		
		if(account.equalsIgnoreCase(CAAccount)){
		
			if(!getValue(selenium,txtFromDate).trim().contains(programData.fromdateCA.trim())){
				return false;
			}
			if(!getValue(selenium,txtToDate).trim().contains(programData.todateCA.trim())){
				return false;
			}
			
		}
		else{			
			
			if(!getValue(selenium,txtFromDate).trim().contains(programData.fromdate.trim())){
				return false;
			}
			if(!getValue(selenium,txtToDate).trim().contains(programData.todate.trim())){
				return false;
			}
		
		}
						
		
		if(!getValue(selenium,txtPrior).trim().contains(programData.priorstate.trim())){
			return false;
		}
		if(!getValue(selenium,txtOutCome).trim().contains(programData.outcome.trim())){
			return false;
		}
		return true;
		
	
	}

	/**
	 * Verify Store Value For Summary Add Programs In UnFinished Item
	 * @param selenium
	 * @param casesData
	 * @return
	 */
	
	public boolean verifyStoredValuesInSummaryAddPrograms(Selenium selenium, HomeLib programData,String account){
	
		if(!getText(selenium,lblProgramSummary1).contains(programData.program.trim())){        
			return false;
		}
		if(account.equals(CAAccount)){
			if(!getText(selenium,lblProgramSummary).trim().contains(programData.fromdateCA.trim())){
				return false;
			}
			if(!getText(selenium,lblProgramSummary).trim().contains(programData.todateCA.trim())){
				return false;
			}
		}else{
		if(!getText(selenium,lblProgramSummary).trim().contains(programData.fromdate.trim())){
			return false;
		}
		if(!getText(selenium,lblProgramSummary).trim().contains(programData.todate.trim())){
			return false;
		}
		}
		if(!getText(selenium,lblProgramSummary).contains(programData.program.trim())){
			return false;
		}
		return true;
	}

	
	
	/**
	 * Verify Store Value In Summary Page For Add Consents In Ca
	 * @param selenium
	 * @param casesData
	 * @return
	 */
	public boolean verifyStoredValuesForSummaryPageAddConsentsInCa(Selenium selenium,HomeLib consentData){
	
		if(!getText(selenium,lblconsentSummary).toLowerCase(new java.util.Locale("en", "US")).trim().contains(consentData.consentName.trim().toLowerCase(new java.util.Locale("en", "US")))){
			return false;
		}
		return true;
	}
	

	/**
	 * Verify Store Value In Summary Page For Add Consents In Us
	 * @param selenium
	 * @param casesData
	 * @return
	 */
	public boolean verifyStoredValuesForSummaryPageAddConsentsInUS(Selenium selenium,HomeLib consentData){
		if(!getText(selenium,lblconsentSummary).toLowerCase(new java.util.Locale("en", "US")).trim().contains(consentData.consentName.trim().toLowerCase(new java.util.Locale("en", "US")))){
			return false;
		}
		
		if(!(getText(selenium,lblconsentSummary).trim().contains(consentData.dateSigned.trim()))){
			return false;
		}
		
		return true;
	}
	

	
	/**
	 * Verify Store Value For Add Referrals In UnFinished Item
	 * @param selenium
	 * @param Add Referrals
	 * @return
	 */
	
	public boolean verifyStoredValuesInSummaryReferals(Selenium selenium, HomeLib refData,String account){
		waitForPageLoad(selenium);
		if(!getText(selenium,lblReferralSummary).trim().contains(refData.refType.trim())){
			return false;
		}
		if(!getText(selenium,lblReferralSummary).trim().contains(refData.refBy1.trim())){
			return false;
		}
		if(!getText(selenium,lblReferralSummary).contains(refData.referralDate)){
			return false;
		}
		return true;
	}
	
	
	/**
	 * Verify Delete All Payers
	 *  function to Verify Delete All Payers
	 * @since  	     Sep  20, 2013
	 * @return
	 */
	
	public boolean deleteAllPayers(Selenium selenium) throws IOException{
		waitForPageLoad(selenium);
		boolean payersDeleted = true;
		int count = 1;
		int counter = (Integer) selenium.getXpathCount(lnkPayerDel1);
		for(count=1;count<=counter;count++){
		//	System.out.println(String.format(lnlPayerDelCommon,count));
			if(selenium.isVisible(String.format(lnlPayerDelCommon,count))){
				assertTrue(click(selenium, String.format(lnlPayerDelCommon,count)), "Not able ot click delete", selenium, ClassName, MethodName);
				waitForElement(selenium,btnYesbutton,1000);
				assertTrue(click(selenium, btnYesbutton), "Not able ot click delete", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				counter = (Integer) selenium.getXpathCount(lnkPayerDel1);
				count=1;
			}
		}
		
		return payersDeleted;
	}
	
	
	
	/**
	 * Select Eligibility
	 *  function to Verify Delete All Payers
	 * @since  	     Oct 14, 2014
	 * @return
	 */
	
	public boolean selectCheckEligibility(Selenium selenium,HomeLib payerData) throws IOException{
		waitForPageLoad(selenium);
		boolean selectedEligibility = true;
		int count = 0;
		int counter = (Integer) selenium.getXpathCount(lstPayers);
		
		for(count=1;count<=counter;count++){
			if(selenium.isVisible(lnkCheckEligibility+count))
			{
			assertTrue(click(selenium,lnkCheckEligibility+count), "could not click the link Check Eligibility", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			break;
			}
	}
		return selectedEligibility;
	}

	public boolean verifyMedicalPayerCreated(Selenium selenium,HomeLib payerData)throws Exception
	{
		String detailsPath="//div[@id='visitListItemDiv%s']/div";
		int count = 0;
		int counter = (Integer) selenium.getXpathCount(lstPayers);
		for(count=1;count<=counter;count++)
		{
		if(!getText(selenium,String.format(detailsPath,count)).contains("Inactive"))
		{
			assertTrue(getText(selenium,String.format(detailsPath,count)).contains(payerData.payerName),"name not found",selenium,ClassName,MethodName);
			break;
		}
		}
		return true;
	}
	
	
	public boolean clickEditButtonForMedicalPayers(Selenium selenium)throws Exception
	{
		waitForPageLoad(selenium);
		boolean selectedEligibility = true;
		int count = 0;
		int counter = (Integer) selenium.getXpathCount(lstPayers);
		
		for(count=1;count<=counter;count++){
			if(selenium.isVisible(lnkEditButton+count))
			{
				assertTrue(click(selenium,lnkEditButton+count),"unable to click edit button",selenium,ClassName,MethodName);
				break;
			}
		}
		return selectedEligibility;
	}
	
	/**
	 * Verify Delete All other Payers 
	 *  function to Verify Delete All Payers
	 * @since  	     Sep  20, 2013
	 * @return
	 * @throws IOException 
	 */
	
	public boolean deleteAllOtherPayers(Selenium selenium) throws IOException{
		waitForPageLoad(selenium);
		boolean payersDeleted = true;
		int count = 1;
		int counter = (Integer) selenium.getXpathCount(lnkDelOtherPayer);
		for(count=1;count<=counter;count++){
		//	System.out.println(String.format(lnlPayerDelCommon,count));
			if(selenium.isVisible(String.format(lnkDelOtherPayerCommon,count))){
				assertTrue(click(selenium, String.format(lnkDelOtherPayerCommon,count)), "Not able ot click delete", selenium, ClassName, MethodName);
				waitForElement(selenium,btnYesbutton,1000);
				assertTrue(click(selenium, btnYesbutton), "Not able ot click delete", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				counter = (Integer) selenium.getXpathCount(lnkDelOtherPayer);
				count=1;
			}
		}
		
		return payersDeleted;
	}
	
	
	
	/**
	 * Add a New Payer
	 * 
	 * function to  Add a New Payer
	 * @throws IOException 
	 * @since  	     Sep  16, 2013
	 */	
	public boolean addNewPayer(Selenium selenium,HomeLib payerData,String date,String account) throws IOException {
		 
		 if(!payerData.testCaseId.equals("TC_CP_014")){
			click(selenium,ajxPayerSelect);
			
			
			 assertTrue(selectValueFromAjaxList(selenium,ajxPayerSelect,payerData.payerName),"Could not select payer"+ payerData.toString(), selenium, ClassName, MethodName);
			 
		 
		 }else{
			assertTrue(selectValueFromAjaxList(selenium,ajxPayerSelect,payerData.payerCode),"Could not select payer"+ payerData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
		 }
	
		 if(payerData.testCaseId.equals("TC_CP_002")|| payerData.testCaseId.equals("TC_CP_003")|| payerData.testCaseId.equals("TC_CP_005")||payerData.testCaseId.equals("TC_CP_013")||payerData.testCaseId.equals("TC_CP_018")||payerData.testCaseId.equals("TC_CP_035")||payerData.testCaseId.equals("TC_CP_036")){
			 assertTrue(selectValueFromAjaxList(selenium,ajxTypeOfCoverageSuggest,payerData.typeofCoverage),"Could not select Type of Coverage"+ payerData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			}else{
				 if(!isChecked(selenium,chkBoxOutOfNetworkBenefit)){
						assertTrue(click(selenium,chkBoxOutOfNetworkBenefit),"Could not click the Network Benefit check box; More details"+payerData.toString(), selenium, ClassName, MethodName);
				}
				 if(!isChecked(selenium,chkBoxauthorizationRequired)){
						assertTrue(click(selenium,chkBoxauthorizationRequired),"Could not click the Network Benefit check box; More details"+payerData.toString(), selenium, ClassName, MethodName);
					}
				 if(!isChecked(selenium,chkBoxAcceptAssignment)){
						assertTrue(click(selenium,chkBoxAcceptAssignment),"Could not click the Accept Assignment check box; More details"+payerData.toString(), selenium, ClassName, MethodName);
				 }
				 if(!account.equals(CAAccount)){
					 if(!isChecked(selenium,chkbxExcemptFromCopay)){
							assertTrue(click(selenium,chkbxExcemptFromCopay),"Could not click the Excempt check box; More details"+payerData.toString(), selenium, ClassName, MethodName);
							 assertTrue(type(selenium,txtExceptionCodes,payerData.exceptionCode),"Could not type Exception Codes "+ payerData.toString(), selenium, ClassName, MethodName);
							 assertTrue(selectValueFromAjaxList(selenium,ajxSecondaryReason,payerData.secondaryReason),"Could not select Secondary reason"+ payerData.toString(), selenium, ClassName, MethodName); 
							 waitForPageLoad(selenium);
							 assertTrue(type(selenium,txtSequenceNumberId,payerData.sequenceId),"Could not type Sequence Number Id"+ payerData.toString(), selenium, ClassName, MethodName);
					 }	 
				 }	 
			}
		 if(payerData.testCaseId.equals("TC_CP_038")){
			 assertTrue(enterDate(selenium,txtPayerStartDate,"05/05/2005"), "Could not enter start Date", selenium, ClassName, MethodName);
			 assertTrue(enterDate(selenium,txtPayerEndDate,"05/10/2005"), "Could not enter start Date", selenium, ClassName, MethodName);
			 
		 }else{
			assertTrue(enterDate(selenium,txtPayerStartDate,date), "Could not enter start Date", selenium, ClassName, MethodName);
		 }
		 assertTrue(type(selenium,txtMemberID,payerData.memberId),"Could not type MemberID "+ payerData.toString(), selenium, ClassName, MethodName);
		 assertTrue(type(selenium,txtGroupNoID,payerData.groupNo),"Could not type Group No  "+ payerData.toString(), selenium, ClassName, MethodName);
		 assertTrue(type(selenium,txtGroupNameID,payerData.groupName),"Could not type Group name "+ payerData.toString(), selenium, ClassName, MethodName);
		
		 /* if(!((payerData.testCaseId.equals("TC_CP_008"))||(payerData.testCaseId.equals("TC_CP_015"))||(payerData.testCaseId.equals("TC_CP_013")))){
		 Assert.assertTrue(selectSecondMatchingValueFromAjaxList(selenium,ajxPlanName,payerData.planName),"Could not select Plan Name"+ payerData.toString());
		 }*/
		 if(payerData.testCaseId.equals("TC_CP_039")){
			 assertTrue(enterDate(selenium,txtPayerStartDate,"05/05/2013"), "Could not enter start Date", selenium, ClassName, MethodName);
		 }
		 if(payerData.testCaseId.equals("TC_CP_040")){
			 assertTrue(enterDate(selenium,txtPayerStartDate,"08/08/2014"), "Could not enter start Date", selenium, ClassName, MethodName);
		 }
		 assertTrue(selectSecondMatchingValueFromAjaxList(selenium,ajxPlanName,payerData.planName),"Could not select Plan Name"+ payerData.toString(), selenium, ClassName, MethodName);
		
		 assertTrue(type(selenium,txtBillingAddr1,payerData.billingAddr1),"Could not type BillingAddr1"+ payerData.toString(), selenium, ClassName, MethodName);
		 assertTrue(type(selenium,txtBillingAddr2,payerData.billingAddr2),"Could not type BillingAddr2"+ payerData.toString(), selenium, ClassName, MethodName);
		 if(account.equalsIgnoreCase(CAAccount)){
			 assertTrue(type(selenium,txtBillingCity,payerData.billingCityCA),"Could not type txtBillingCity"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium,ajxBillingStateSuggestBox,payerData.billingStateCA),"Could not select Billing State"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtBillingZip,payerData.billingZipCA),"Could not type BillingZip"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium,ajxRelationcountry,payerData.billingCountryCA),"Could not select Billing Country"+ payerData.toString(), selenium, ClassName, MethodName);
		 }else{
			 assertTrue(type(selenium,txtBillingCity,payerData.billingCity),"Could not type txtBillingCity"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtBillingZip,payerData.billingZip),"Could not type BillingZip"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium,ajxBillingStateSuggestBox,payerData.billingState),"Could not select Billing State"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium,ajxRelationcountry,payerData.billingCountry),"Could not select Billing Country"+ payerData.toString(), selenium, ClassName, MethodName);
		 }
		 assertTrue(selectValueFromAjaxList(selenium,ajxRelationShip,payerData.relationshipStatus),"Could not select Relationship Status"+ payerData.toString(), selenium, ClassName, MethodName);
		 assertTrue(selectValueFromAjaxList(selenium,ajxReleaseOfInformatiom,payerData.releaseInformation),"Could not select Relationship Status"+ payerData.toString(), selenium, ClassName, MethodName);
		// if(!isElementPresent(selenium,lnkViewCard)){
          //  return false;
		 //}
		 if(payerData.testCaseId.equals("TC_CP_006")){
			 assertTrue(click(selenium, btnlnkAddAnother), "Could not click Save and  Add another button" +  payerData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 payerData.workSheetName = "AddPayers";
			 payerData.testCaseId = "TC_CP_001";
			 payerData.fetchHomeTestData();
			 assertTrue(addNewPayer(selenium,payerData,date,account),"Add  Another New Payer failed",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
		}else{
		 assertTrue(click(selenium, btnlnkSave), "Could not click Save button" +  payerData.toString(), selenium, ClassName, MethodName);
		 waitForPageLoad(selenium);
		} 
		 click(selenium,btnOK);
		 
		if(!isElementPresent(selenium,btnAddNew)){
			return false;
		}
	 return true;
	 }
 
 public boolean addNewOtherPayer(Selenium selenium,HomeLib payerData,String date,String account) throws IOException {
		 
		 if(!payerData.testCaseId.equals("TC_CP_014")){
			click(selenium,ajxPayerSelect);
			
			
			assertTrue(selectValueFromAjaxList(selenium,ajxOtherpayerSelect,payerData.payerName),"Could not select payer"+ payerData.toString(), selenium, ClassName, MethodName);
			 
		 
		 }else{
			assertTrue(selectValueFromAjaxList(selenium,ajxOtherpayerSelect,payerData.payerCode),"Could not select payer"+ payerData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
		 }
	
		 if(payerData.testCaseId.equals("TC_CP_002")|| payerData.testCaseId.equals("TC_CP_003") || payerData.testCaseId.equals("TC_CP_014") || payerData.testCaseId.equals("TC_CP_005")||payerData.testCaseId.equals("TC_CP_013")||payerData.testCaseId.equals("TC_CP_018")){
			assertTrue(selectValueFromAjaxList(selenium,ajxTypeOfCoverageSuggest,payerData.typeofCoverage),"Could not select Type of Coverage"+ payerData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			}else{
				 if(!isChecked(selenium,chkBoxOutOfNetworkBenefit)){
						assertTrue(click(selenium,chkBoxOutOfNetworkBenefit),"Could not click the Network Benefit check box; More details"+payerData.toString(), selenium, ClassName, MethodName);
				}
				 if(!isChecked(selenium,chkBoxauthorizationRequired)){
						assertTrue(click(selenium,chkBoxauthorizationRequired),"Could not click the Network Benefit check box; More details"+payerData.toString(), selenium, ClassName, MethodName);
					}
				 if(!isChecked(selenium,chkBoxAcceptAssignment)){
						assertTrue(click(selenium,chkBoxAcceptAssignment),"Could not click the Accept Assignment check box; More details"+payerData.toString(), selenium, ClassName, MethodName);
				 }
				 if(!isChecked(selenium,chkbxExcemptFromCopay)){
						assertTrue(click(selenium,chkbxExcemptFromCopay),"Could not click the Excempt check box; More details"+payerData.toString(), selenium, ClassName, MethodName);
				 }
				 
//				// Assert.assertTrue(selectValueFromAjaxList(selenium,ajxSecondaryReason,payerData.secondaryReason),"Could not select Secondary reason"+ payerData.toString()); 
//				 waitForPageLoad(selenium);
//				 Assert.assertTrue(type(selenium,txtExceptionCodes,payerData.exceptionCode),"Could not type Exception Codes "+ payerData.toString());
//				 Assert.assertTrue(type(selenium,txtSequenceNumberId,payerData.sequenceId),"Could not type Sequence Number Id"+ payerData.toString());
				 
			}
		 assertTrue(enterDate(selenium,txtOtherPayerStartDate,date), "Could not enter start Date", selenium, ClassName, MethodName);
		 assertTrue(type(selenium,txtOtherpayerMemberID,payerData.memberId),"Could not type MemberID "+ payerData.toString(), selenium, ClassName, MethodName);
		 assertTrue(type(selenium,txtOtherPayerGroupNoID,payerData.groupNo),"Could not type Group No  "+ payerData.toString(), selenium, ClassName, MethodName);
		 assertTrue(type(selenium,txtOtherPayerGroupNameId,payerData.groupName),"Could not type Group name "+ payerData.toString(), selenium, ClassName, MethodName);
		
		  if(!((payerData.testCaseId.equals("TC_CP_008"))||(payerData.testCaseId.equals("TC_CP_015"))||(payerData.testCaseId.equals("TC_CP_013")))){
		 Assert.assertTrue(selectSecondMatchingValueFromAjaxList(selenium,ajxPlanName,payerData.planName),"Could not select Plan Name"+ payerData.toString());
		 }
		 
		 assertTrue(selectSecondMatchingValueFromAjaxList(selenium,ajxPlanName,payerData.planName),"Could not select Plan Name"+ payerData.toString(), selenium, ClassName, MethodName);
		
		 assertTrue(type(selenium,txtOterPayerBillingAddr1,payerData.billingAddr1),"Could not type BillingAddr1"+ payerData.toString(), selenium, ClassName, MethodName);
		 assertTrue(type(selenium,txtOterPayerBillingAddr2,payerData.billingAddr2),"Could not type BillingAddr2"+ payerData.toString(), selenium, ClassName, MethodName);
		 if(account.equalsIgnoreCase(CAAccount)){
			 assertTrue(type(selenium,txtotherpayerBillingCity,payerData.billingCityCA),"Could not type txtBillingCity"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtOtherbillingZip,payerData.billingZipCA),"Could not type BillingZip"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium,ajxotherBillingStateSuggestBox,payerData.billingStateCA),"Could not select Billing State"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium,ajxOtherpayerBillingCountrySuggestBox,payerData.billingCountryCA),"Could not select Billing Country"+ payerData.toString(), selenium, ClassName, MethodName);
		 }else{
			 assertTrue(type(selenium,txtotherpayerBillingCity,payerData.billingCity),"Could not type txtBillingCity"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtOtherbillingZip,payerData.billingZip),"Could not type BillingZip"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium,ajxotherBillingStateSuggestBox,payerData.billingState),"Could not select Billing State"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium,ajxOtherpayerBillingCountrySuggestBox,payerData.billingCountry),"Could not select Billing Country"+ payerData.toString(), selenium, ClassName, MethodName);
		 }
		 assertTrue(selectValueFromAjaxList(selenium,OtherRelationship,payerData.relationshipStatus),"Could not select Relationship Status"+ payerData.toString(), selenium, ClassName, MethodName);
		// Assert.assertTrue(selectValueFromAjaxList(selenium,ajxReleaseOfInformatiom,payerData.releaseInformation),"Could not select Relationship Status"+ payerData.toString());
		 //As per issue VEl-4985 View Card Won't be in application 
//		 	 if(!isElementPresent(selenium,lnkViewCard)){
//             return false;
//		 }
		 if(payerData.testCaseId.equals("TC_CP_006")){
			 assertTrue(click(selenium, btnlnkAddAnother), "Could not click Save and  Add another button" +  payerData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 payerData.workSheetName = "AddPayers";
			 payerData.testCaseId = "TC_CP_001";
			 payerData.fetchHomeTestData();
			 assertTrue(addNewPayer(selenium,payerData,date,account),"Add  Another New Payer failed",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
		}else{
		 assertTrue(click(selenium, btnlnkSave), "Could not click Save button" +  payerData.toString(), selenium, ClassName, MethodName);
		 waitForPageLoad(selenium);
		} 
		 click(selenium,btnOK);
		 
		if(!isElementPresent(selenium,btnAddNew)){
			return false;
		}
	 return true;
	 }

	 /**
		 *  Unit Test for Add a New Payer
		 * 
		 * function to  Unit for a New Payer
		 * @throws IOException 
		 * @since  	     Oct 03, 2013
		 */	
		 public boolean UnitTestForMedicalPayers(Selenium selenium,HomeLibUnitTest payerData,String date,String account) throws IOException {
			 @SuppressWarnings("unused")
			String endDate = null;
		assertTrue(selectValueFromAjaxList(selenium,ajxPayerSelect,payerData.payerName),"Could not select payer"+ payerData.toString(), selenium, ClassName, MethodName);
		 waitForPageLoad(selenium);

		 if(account.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	date=DateFormat1.format(cal.getTime());
			  	//ndDate =DateFormat1.format(cal.getTime());
			  	cal.add(Calendar.DATE,-1);
			  	endDate=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
					cal.add(Calendar.DATE,-1);
				  	endDate=DateFormat1.format(cal.getTime());
			}
		 
		 if(payerData.testCaseId.equals("TC_UCP_059")){
			 assertTrue(enterDate(selenium,txtPayerStartDate,date), "Could not enter start Date", selenium, ClassName, MethodName);
      	   waitForPageLoad(selenium);
      	   assertTrue(enterDate(selenium,txtPayerEndDate,payerData.endDate), "Could not enter end Date", selenium, ClassName, MethodName);
      	   waitForPageLoad(selenium);
		 }
		 if(account.equals(CAAccount)){ 
        	   assertTrue(enterDate(selenium,txtPayerStartDate,payerData.startDateCA), "Could not enter start Date", selenium, ClassName, MethodName);
        	   waitForPageLoad(selenium);
        	   assertTrue(enterDate(selenium,txtPayerEndDate,payerData.endDateCA), "Could not enter end Date", selenium, ClassName, MethodName);
        	   waitForPageLoad(selenium);
        	   assertTrue(enterDate(selenium,txtRelationDob,payerData.startDateCA), "Could not Date of birth Date", selenium, ClassName, MethodName);
        	   waitForPageLoad(selenium);
        	   
           }else{
        	   assertTrue(enterDate(selenium,txtPayerStartDate,payerData.startDateUS), "Could not enter start Date", selenium, ClassName, MethodName);
        	   waitForPageLoad(selenium);
        	   assertTrue(enterDate(selenium,txtPayerEndDate,payerData.endDateUS), "Could not enter end Date", selenium, ClassName, MethodName);
        	   waitForPageLoad(selenium);
        	   assertTrue(enterDate(selenium,txtRelationDob,payerData.startDateUS), "Could not Date of birth Date", selenium, ClassName, MethodName);
        	   waitForPageLoad(selenium);
           }
		     
		     assertTrue(type(selenium,txtCoPay,payerData.coPay),"Could not type Co-Pay"+ payerData.toString(), selenium, ClassName, MethodName);
		     assertTrue(type(selenium, txtSpecialistCoPay,payerData.specialistCoPay),"Could not type the Specialist Co Pay", selenium, ClassName, MethodName);
   			 assertTrue(type(selenium, txtDeductible,payerData.deductible),"Could not type the Payer Deductible Amount", selenium, ClassName, MethodName);
			 assertTrue(type(selenium, txtCoInsurance,payerData.coInsurance),"Could not type the Payer Co-insurance Percentage", selenium, ClassName, MethodName);
			 
			 assertTrue(type(selenium,txtBillingAddr1,payerData.billingAddr1),"Could not type BillingAddr1"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtBillingAddr2,payerData.billingAddr2),"Could not type BillingAddr2"+ payerData.toString(), selenium, ClassName, MethodName);
     		 assertTrue(type(selenium,txtBillingCity,payerData.billingCity),"Could not type txtBillingCity"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtBillingZip,payerData.billingZip),"Could not type BillingZip"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium,ajxBillingStateSuggestBox,payerData.billingState),"Could not select Billing State"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium,ajxRelationcountry,payerData.billingCountry),"Could not select Billing Country"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium,ajxReleaseOfInformatiom,payerData.releaseInformation),"Could not select Relationship Information"+ payerData.toString(), selenium, ClassName, MethodName);
			 
			 assertTrue(selectValueFromAjaxList(selenium,ajxRelationShip,payerData.relationshipStatus),"Could not select Relationship Status"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtRelationAddr1,payerData.relationAddr1),"Could not type Relation Addr one"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtRelationAddr2,payerData.relationAddr2),"Could not type Relation Address two "+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium,ajxRelationState,payerData.relationState),"Could not type Relation State"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtRelationZip,payerData.relationZipCode),"Could not type Relation ZipCode"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium,ajxRelationcountry,payerData.relationCountry),"Could not type Relation Country"+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(selectValueFromAjaxList(selenium,ajxRelationSex,payerData.sex),"Could not type Relation Sex"+ payerData.toString(), selenium, ClassName, MethodName);
			 			 
			 assertTrue(click(selenium, btnlnkSave), "Could not click Save button" +  payerData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
	
			 click(selenium,btnOK);
			 
			if(!isElementPresent(selenium,btnAddNew)){
				return false;
			}
			 
		 return true;
		 }
		 
		 
		 /**
			 *  Unit Test for Add a Other Payer
			 * 
			 * function to  Unit for a other Payer
			 * @throws IOException 
			 * @since  	     Oct 03, 2013
			 */	
			 public boolean UnitTestForOtherPayers(Selenium selenium,HomeLibUnitTest payerData,String date,String account) throws IOException {
				 @SuppressWarnings("unused")
				String endDate = null;
			 assertTrue(selectValueFromAjaxList(selenium,ajxPayerSelect,payerData.payerName),"Could not select payer"+ payerData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 assertTrue(selectValueFromAjaxList(selenium,ajxTypeOfCoverageSuggest,payerData.typeofCoverage),"Could not select Type of Coverage"+ payerData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);

			 if(account.equals(CAAccount)){
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
				  	date=DateFormat1.format(cal.getTime());
				  	//ndDate =DateFormat1.format(cal.getTime());
				  	cal.add(Calendar.DATE,-1);
				  	endDate=DateFormat1.format(cal.getTime());
			    }else {
						Calendar cal=Calendar.getInstance();
						SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
						date=DateFormat1.format(cal.getTime());
						cal.add(Calendar.DATE,-1);
					  	endDate=DateFormat1.format(cal.getTime());
				}
			 if(payerData.testCaseId.equals("TC_UCP_059")){
				 assertTrue(enterDate(selenium,txtPayerStartDate,date), "Could not enter start Date", selenium, ClassName, MethodName);
	      	   waitForPageLoad(selenium);
	      	   assertTrue(enterDate(selenium,txtPayerEndDate,payerData.endDate), "Could not enter end Date", selenium, ClassName, MethodName);
	      	   waitForPageLoad(selenium);
			 }
			 if(account.equals(CAAccount)){ 
	        	   assertTrue(enterDate(selenium,txtPayerStartDate,payerData.startDateCA), "Could not enter start Date", selenium, ClassName, MethodName);
	        	   waitForPageLoad(selenium);
	        	   assertTrue(enterDate(selenium,txtPayerEndDateOther,payerData.endDateCA), "Could not enter end Date", selenium, ClassName, MethodName);
	        	   waitForPageLoad(selenium);
	        	   assertTrue(enterDate(selenium,txtRelationDobOther,payerData.startDateCA), "Could not Date of birth Date", selenium, ClassName, MethodName);
	        	   waitForPageLoad(selenium);
	        	   
	           }else{
	        	   assertTrue(enterDate(selenium,txtPayerStartDate,payerData.startDateUS), "Could not enter start Date", selenium, ClassName, MethodName);
	        	   waitForPageLoad(selenium);
	        	   assertTrue(enterDate(selenium,txtPayerEndDateOther,payerData.endDateUS), "Could not enter end Date", selenium, ClassName, MethodName);
	        	   waitForPageLoad(selenium);
	        	   assertTrue(enterDate(selenium,txtRelationDobOther,payerData.startDateUS), "Could not Date of birth Date", selenium, ClassName, MethodName);
	        	   waitForPageLoad(selenium);
	           }
			     
			    assertTrue(type(selenium,txtCoPay,payerData.coPay),"Could not type Co-Pay"+ payerData.toString(), selenium, ClassName, MethodName);
			    assertTrue(type(selenium, txtSpecialistCopayOther,payerData.specialistCoPay),"Could not type the Specialist Co Pay", selenium, ClassName, MethodName);
	   			assertTrue(type(selenium, txtDeductibleother,payerData.deductible),"Could not type the Payer Deductible Amount", selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtCoInsuranceother,payerData.coInsurance),"Could not type the Payer Co-insurance Percentage", selenium, ClassName, MethodName);
				 
				assertTrue(type(selenium,txtBillingAddr1,payerData.billingAddr1),"Could not type BillingAddr1"+ payerData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtBillingAddr2,payerData.billingAddr2),"Could not type BillingAddr2"+ payerData.toString(), selenium, ClassName, MethodName);
	     		assertTrue(type(selenium,txtBillingCity,payerData.billingCity),"Could not type txtBillingCity"+ payerData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtBillingZip,payerData.billingZip),"Could not type BillingZip"+ payerData.toString(), selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium,ajxBillingStateSuggestBox,payerData.billingState),"Could not select Billing State"+ payerData.toString(), selenium, ClassName, MethodName);
				 //Assert.assertTrue(selectValueFromAjaxList(selenium,ajxotherpayerBillingCountrySuggestBox,payerData.billingCountry),"Could not select Billing Country"+ payerData.toString());
				
				 
				 assertTrue(selectValueFromAjaxList(selenium,ajxRelationShip,payerData.relationshipStatus),"Could not select Relationship Status"+ payerData.toString(), selenium, ClassName, MethodName);
				 assertTrue(type(selenium,txtRelationAddr1,payerData.relationAddr1),"Could not type Relation Addr one"+ payerData.toString(), selenium, ClassName, MethodName);
				 assertTrue(type(selenium,txtRelationAddr2,payerData.relationAddr2),"Could not type Relation Address two "+ payerData.toString(), selenium, ClassName, MethodName);
				 assertTrue(selectValueFromAjaxList(selenium,ajxRelationState,payerData.relationState),"Could not type Relation State"+ payerData.toString(), selenium, ClassName, MethodName);
				 assertTrue(type(selenium,txtRelationZip,payerData.relationZipCode),"Could not type Relation ZipCode"+ payerData.toString(), selenium, ClassName, MethodName);
				 assertTrue(selectValueFromAjaxList(selenium,ajxRelationcountry,payerData.relationCountry),"Could not type Relation Country"+ payerData.toString(), selenium, ClassName, MethodName);
				 assertTrue(selectValueFromAjaxList(selenium,ajxRelationSex,payerData.sex),"Could not type Relation Sex"+ payerData.toString(), selenium, ClassName, MethodName);
				 			 
				 assertTrue(click(selenium, btnlnkSave), "Could not click Save button" +  payerData.toString(), selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
		
				 click(selenium,btnOK);
				 
				if(!isElementPresent(selenium,btnAddNew)){
					return false;
				}
				 
			 return true;
			 }
			 
		 
			 public boolean verifyPreviewInformationOnSearchResults(Selenium selenium,HomeLib patientData, String patId,String userAccount,String uniqueName){
					if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
				
					if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias1.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias2.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					/*if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressCity.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}*/
					if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressCountry.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressZipcode.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					
					/*if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}*/
					
					if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains("(999) 999-9999".trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patId.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					
					if(userAccount.equals(CAAccount)){
						if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(uniqueName.trim().toLowerCase(new java.util.Locale("en","US")))){
							return false;
						}
					}
					
				int Year =0;
				int Months =0;
				long Days =0;
				int weeks=0;
				int hours=0;
				String resDate = "";
				Date CurrentDate = new Date();
				@SuppressWarnings("deprecation")
				Date DateOfBirth = new Date(patientData.dob);
				Calendar calDateOFBirth = Calendar.getInstance();
				Calendar calCurrentDate = Calendar.getInstance();

				calDateOFBirth.setTime(DateOfBirth);
				calCurrentDate.setTime(CurrentDate);
				Year = calCurrentDate.get(1) - calDateOFBirth.get(1);
				if(Year >= 0){
					if(calCurrentDate.get(2) > calDateOFBirth.get(2)){
						Months = (calCurrentDate.get(2) - calDateOFBirth .get(2));
					}else if(calCurrentDate.get(2) == calDateOFBirth.get(2) && Year != 0){
						Months =((calDateOFBirth.getMaximum(2)+1) - (calDateOFBirth.get(2)+1)) + (calCurrentDate.get(2)+1);
					}else if(Year != 0) {
						Year = Year - 1 ;
						Months =((calDateOFBirth.getMaximum(2)+1) - (calDateOFBirth.get(2)+1)) + (calCurrentDate.get(2)+1);
					}

					if(calDateOFBirth.get(5) > calCurrentDate.get(5)){
						Months = Months -1;
					}

					if(Months >= 1){
						if(calDateOFBirth.get(5) > calCurrentDate.get(5)){
							Days = (calDateOFBirth.getMaximum(5)-calDateOFBirth.get(5)) + calCurrentDate.get(5);
							if(calCurrentDate.get(2)== 2){
								Days = Days -3;
							}
						}else{
							Days = calCurrentDate.get(5) - calDateOFBirth.get(5);
						}
					}else if(Months<0) {
						Year = Year - 1;
						Months =((calDateOFBirth.getMaximum(2)+1) - (calDateOFBirth.get(2)+1)) + (calCurrentDate.get(2));

					}else{
						Days = CurrentDate.getTime() - DateOfBirth.getTime();
						Days = Days / (1000*60*60*24);
					}

					if(Year > 18){
						resDate = Integer.toString(Year)+ " years";
						if(!getText(selenium,lblAge).contains(resDate))
							return false;
					}else if(Year <= 18 && Year >= 2){
						resDate = Integer.toString(Year) +" years " + Months +" months" ;
						if(!getText(selenium,lblAge).contains(resDate))
							return false;
					}else if(Year < 2 && Months > 4){
						resDate = Integer.toString(Months)+" months" ;
						if(!getText(selenium,lblAge).contains(resDate))
							return false;
					
					}else if(Year<0 && Months<=3 && (int)Days>29){
					if(Months>0){
						weeks=(int) ((Months*4) + (Days/7));
						resDate=Integer.toString(weeks);
					}
					else{
						weeks=(int)(Days/7);
						resDate=Integer.toString(weeks);
					}
					if(!getText(selenium,lblAge).contains(resDate))
						return false;
					}
					else if((int)Days>=5&&(int)Days<28){
						resDate =Integer.toString((int) Days);
					if(!getText(selenium,lblAge).contains(resDate))
						return false;
					}else{
						hours=(int) (Days*24);
						resDate=Integer.toString(hours);
						if(!getText(selenium,lblAge).contains(resDate))
							return false;
						}
					}else{
					resDate = "Invalid";
				}
				return true;
				}
			 

		 
		 public boolean verifyPreviewInformationOnSearchResultsCA(Selenium selenium,HomeLib patientcaData, String patId,String userAccount,String uniqueName){
				if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				
				if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.alias1.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.alias2.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.mailingAddressCountry.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.mailingAddressZipcode.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				
				if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.mailingAddressStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.mailingAddressStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains("(999) 999-9999".trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(patId.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				
				if(userAccount.equals(CAAccount)){
					if(!getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains(uniqueName.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
				}
				
			int Year =0;
			int Months =0;
			long Days =0;
			int weeks=0;
			int hours=0;
			String resDate = "";
			Date CurrentDate = new Date();
			@SuppressWarnings("deprecation")
			Date DateOfBirth = new Date("06/15/1991");
			Calendar calDateOFBirth = Calendar.getInstance();
			Calendar calCurrentDate = Calendar.getInstance();

			calDateOFBirth.setTime(DateOfBirth);
			calCurrentDate.setTime(CurrentDate);
			Year = calCurrentDate.get(1) - calDateOFBirth.get(1);
			if(Year >= 0){
				if(calCurrentDate.get(2) > calDateOFBirth.get(2)){
					Months = (calCurrentDate.get(2) - calDateOFBirth .get(2));
				}else if(calCurrentDate.get(2) == calDateOFBirth.get(2) && Year != 0){
					Months =((calDateOFBirth.getMaximum(2)+1) - (calDateOFBirth.get(2)+1)) + (calCurrentDate.get(2)+1);
				}else if(Year != 0) {
					Year = Year - 1 ;
					Months =((calDateOFBirth.getMaximum(2)+1) - (calDateOFBirth.get(2)+1)) + (calCurrentDate.get(2)+1);
				}

				if(calDateOFBirth.get(5) > calCurrentDate.get(5)){
					Months = Months -1;
				}

				if(Months >= 1){
					if(calDateOFBirth.get(5) > calCurrentDate.get(5)){
						Days = (calDateOFBirth.getMaximum(5)-calDateOFBirth.get(5)) + calCurrentDate.get(5);
						if(calCurrentDate.get(2)== 2){
							Days = Days -3;
						}
					}else{
						Days = calCurrentDate.get(5) - calDateOFBirth.get(5);
					}
				}else if(Months<0) {
					Year = Year - 1;
					Months =((calDateOFBirth.getMaximum(2)+1) - (calDateOFBirth.get(2)+1)) + (calCurrentDate.get(2));

				}else{
					Days = CurrentDate.getTime() - DateOfBirth.getTime();
					Days = Days / (1000*60*60*24);
				}

				if(Year > 18){
					resDate = Integer.toString(Year)+ " years";
					if(!getText(selenium,lblPatientSearchResults).contains(resDate))
						return false;
				}else if(Year <= 18 && Year >= 2){
					resDate = Integer.toString(Year) +" years " + Months +" months" ;
					if(!getText(selenium,lblAge).contains(resDate))
						return false;
				}else if(Year < 2 && Months > 4){
					resDate = Integer.toString(Months)+" months" ;
					if(!getText(selenium,lblAge).contains(resDate))
						return false;
				
				}else if(Year<0 && Months<=3 && (int)Days>29){
				if(Months>0){
					weeks=(int) ((Months*4) + (Days/7));
					resDate=Integer.toString(weeks);
				}
				else{
					weeks=(int)(Days/7);
					resDate=Integer.toString(weeks);
				}
				if(!getText(selenium,lblAge).contains(resDate))
					return false;
				}
				else if((int)Days>=5&&(int)Days<28){
					resDate =Integer.toString((int) Days);
				if(!getText(selenium,lblAge).contains(resDate))
					return false;
				}else{
					hours=(int) (Days*24);
					resDate=Integer.toString(hours);
					if(!getText(selenium,lblAge).contains(resDate))
						return false;
					}
				}else{
				resDate = "Invalid";
			}
			return true;
			}

		    /**
			 * createReferral
			 * function to create a Referral
			 * @since  	     Feb 21, 2012
			 */	
			public boolean createReferralWithPayer(Selenium selenium, HomeLib refData,HomeLib payerData){
				
				try{		
					
					selectValueFromAjaxList(selenium,ajxReferralType, refData.refType);
					
					selectValueFromAjaxList(selenium,ajxReferredBy, refData.refBy);
					
					//waitForElementToEnable(selenium,ajxAddress);
					//waitForPageLoad(selenium);
					//selectValueFromAjaxList(selenium,ajxAddress, refData.addr);
					
					selectValueFromAjaxList(selenium,ajxReferedTo, refData.refTo);
					
					selectValueFromAjaxList(selenium,ajxReferralSpecial, refData.speciality);
					
					if(refData.testCaseId.equalsIgnoreCase("TC_CRL_007")){
						selenium.clickAt(ajxReferralDiagnoses, "");
						waitForPageLoad(selenium);
					}else
						selectValueFromAjaxList(selenium,ajxReferralDiagnoses, refData.diagCode);
					
					assertTrue(type(selenium,txtReferralReason,refData.referralReason),"Could not enter the referral Reason; More Details :" + refData.toString(), selenium, ClassName, MethodName);
					assertTrue(enterDate(selenium,txtReferralDate, refData.referralDate),"Could not enter referral date; More Details :" + refData.toString(), selenium, ClassName, MethodName);
					assertTrue(enterDate(selenium,txtReferralEndDate,refData.referralEndDate),"Could not enter the referralEndDate; More Details :" + refData.toString(), selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtReferralComments,refData.refComments),"Could not enter referral Comments; More Details :" + refData.toString(), selenium, ClassName, MethodName);
					assertTrue(click(selenium,btnAddAuthorization),"Could not click on add Authorization Button; More Details :" + refData.toString(), selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajxPayer, payerData.payerName);
					assertTrue(type(selenium,txtNumVisit,refData.numVisits1),"Could not enter numVisits1; More Details :" + refData.toString(), selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajxNumVisit,refData.numVisitType);
					//Assert.assertTrue(type(selenium,ajxNumVisit,refData.numVisitType),"Could not enter numVisits Type; More Details :" + refData.toString());
					waitForElementToEnable(selenium,txtRequestDate);
					waitForPageLoad(selenium);
					click(selenium,txtRequestDate);
					assertTrue(enterDate(selenium,txtRequestDate,refData.requestDate2),"Could not enter the request Date; More Details :" + refData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,txtApprovalDate);
					waitForPageLoad(selenium);
					assertTrue(isElementPresent(selenium,txtApprovalDate)," ", selenium, ClassName, MethodName);
					assertTrue(enterDate(selenium,txtApprovalDate,refData.approvalDate2),"Could not enter the approvalDate; More Details :" + refData.toString(), selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtAuthorizationNum,refData.authorizationNum2),"Could not enter authorizationNum; More Details :" + refData.toString(), selenium, ClassName, MethodName);
					
					assertTrue(type(selenium,txtNumAuthorizationVisit,refData.numAuthorizedVisits2),"Could not enter numAuthorizedVisits; More Details :" + refData.toString(), selenium, ClassName, MethodName);
					assertTrue(enterDate(selenium,txtStartDate1,refData.startDate2),"Could not enter the start Date; More Details :" + refData.toString(), selenium, ClassName, MethodName);
					assertTrue(enterDate(selenium,txtEndDate1,refData.endDate2),"Could not enter the end Date; More Details :" + refData.toString(), selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajxCPT, refData.cptSuggestBox2);
					
					assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + refData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if(isElementPresent(selenium, lnkReferrals)){
						return true;
					}else{
						return false;
					}
				}catch (RuntimeException e){
					e.printStackTrace();
					Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refData.toString());		
					return false;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
		/**
		 * createEnterPrise
		 * function to create EnterPrise
		* @since  	     June 06, 2012
		 */	
		public boolean createEnterPrise(Selenium selenium,SystemSettingsLib enterPriseData){
		try{
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSuggestBox,enterPriseData.idType);
			assertTrue(type(selenium,txtVariableBox,enterPriseData.idName),"Could not enter the IdName;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			if(isElementPresent(selenium,lblTitle)){
				return true;
			}else{
				return false;
			}
					
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
		/**
		 * deleteEnterPrise
		 * function to delete EnterPrise
		 * @since  	     June 06, 2012
		 */	
		public boolean deleteEnterPrise(Selenium selenium,SystemSettingsLib epData){
			try{
				waitForPageLoad(selenium);
				type(selenium,txtSearchBox ,epData.idType);
				waitForPageLoad(selenium);
			
				int count=1;
				while(isElementPresent(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr["+count+"]/td/div")){
					click(selenium,btnSearchBox);
					waitForPageLoad(selenium);
					if(getText(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr["+count+"]/td/div").contains(epData.idType)){
						click(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr["+count+"]/td[3]/div/div/a[2]");
						waitForPageLoad(selenium);
						click(selenium,btnYes);
						}else {count++;}
					if(count>5){
						break;
					}
				}	
				return true;
			}catch(RuntimeException e){
				e.printStackTrace();
				return false;
			}
		}
		 /**
		 * edit a New Payer
		 * 
		 * function to  edit a New Payer
		 * @throws IOException 
		 * @since  	     Sep  16, 2013
		 */	
		 public boolean editNewPayer(Selenium selenium,HomeLib payerData,String date,String account) throws IOException {
			 
			 if(payerData.testCaseId.equals("TC_CP_013")){
				 assertTrue(selectValueFromAjaxList(selenium,ajxTypeOfCoverageSuggest,payerData.typeofCoverage),"Could not select Type of Coverage"+ payerData.toString(), selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
			 }
			 assertTrue(type(selenium,txtMemberID,payerData.memberId),"Could not type MemberID "+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtGroupNoID,payerData.groupNo),"Could not type Group No  "+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtGroupNameID,payerData.groupName),"Could not type Group name "+ payerData.toString(), selenium, ClassName, MethodName);
			 assertTrue(click(selenium, btnlnkSave), "Could not click Save button" +  payerData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 click(selenium,btnOK);
			 
			if(!isElementPresent(selenium,btnAddNew)){
				return false;
			}
		 return true;
		 }	
		 /**
			 * function to verify medical payer info
			 * @param selenium
			 * @param billingData
			 * @return boolean value
			 * @throws IOException
			 * @since Jan 27,2014
			 */
			public boolean verifyMedicalPayer(Selenium selenium, HomeLib billingData) throws IOException{
				
			    boolean returnValue=true;
			    assertTrue(isTextPresent(selenium, billingData.memberId), "Member ID not present", selenium, ClassName, MethodName);
			    assertTrue(isTextPresent(selenium, billingData.groupNo), "groupNo not present", selenium, ClassName, MethodName);

/*			    if(!getText(selenium,lblPatientInfo).contains(billingData.memberId)){
				    returnValue=false;
			    }
			    if(!getText(selenium,lblPatientInfo).contains(billingData.groupNo)){
				    returnValue=false;
			    }
*/			    /*if(!getText(selenium,lblPatientInfo).contains(billingData.relationship)){
				    returnValue=false;
			    }*/
			  
			    return returnValue;
			   
			}
			
		/**
		 * function to verify medical payer info
		 * @param selenium
		 * @param billingData
		 * @return boolean value
		 * @throws IOException
		 * @since Jan 27,2014
		 */
		public boolean verifyLastReferral(Selenium selenium, HomeLib billingData, String date) throws IOException{
			
		    boolean returnValue=true;
		    
		    if(!selenium.isTextPresent("ABBY ABRAHAM")){
			    returnValue=false;
		    }
		    if(!selenium.isTextPresent(billingData.referralDate)){
			    returnValue=false;
		    }
		    
		    return returnValue;
		   
		}
		/**
		 * function to navigate to billing history
		 * @param selenium
		 * @param billingData
		 * @return boolean value
		 * @throws IOException
		 * @since Jan 27,2014
		 */
		public boolean goToBillingHistory(Selenium selenium, BillingLib billingData) throws IOException{
			
		    boolean returnValue=true;
		    try{
		    	    assertTrue(type(selenium,txtPatientBox,billingData.patientID),"Could not type patient id",selenium,ClassName,MethodName);
			}catch(Exception e){
			    assertTrue(type(selenium,txtPatientBox,billingData.patientID),"Could not type patient id",selenium,ClassName,MethodName);
			}
			selenium.clickAt("searchPatientBox","");
			selenium.focus("searchPatientBox");			
			selenium.fireEvent("searchPatientBox","keypress");		
			waitForElement(selenium, lblPatientResult, 10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ billingData.patientID, selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
				
			selenium.mouseOver(lblPatientResult);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkBillingHistory),"could not click Billing Settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(!(isElementPresent(selenium,lnkBillingSummary))){
				    returnValue=false;
			 }
			 
			 return returnValue;
		}
			
		/**
		 * function to navigate to billing history
		 * @param selenium
		 * @param billingData
		 * @return boolean value
		 * @throws IOException
		 * @since Jan 27,2014
		 */
		public boolean createEndToEndPayerList(Selenium selenium,HomeLib payerData, String date, String account ) throws IOException{
			
			if(payerData.testCaseId.equals("TC_CP_027")){
				assertTrue(click(selenium,btnPatientOtherPayers),"Could not click the Others Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				for(int i =1;i<10;i++){
					selenium.focus(btnAddNewForOtherPayer);
					selenium.clickAt(btnAddNewForOtherPayer, "");
					selenium.keyPress(btnAddNewForOtherPayer, "\\13");
				    }
			
			}else{
				assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
				assertTrue(click(selenium,btnAddNew),"Could not click the add new button Medical Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(payerWithMandatory(selenium,payerData,date,account),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			return true;
		}
	/**
	 * function to navigate to billing history
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Jan 27,2014
	 */
	public boolean payerWithMandatory(Selenium selenium,HomeLib payerData, String date, String account){
		try {
		if(payerData.testCaseId.equals("TC_CP_027")){
			assertTrue(selectValueFromAjaxList(selenium,ajxOtherpayerSelect,payerData.payerName),"Could not select payer"+ payerData.toString(), selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxTypeOfCoverageSuggest,payerData.typeofCoverage),"Could not select Type of Coverage"+ payerData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtOtherPayerStartDate,date), "Could not enter start Date", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxOtherPayerRelationShip,payerData.relationshipStatus),"Could not select Relationship Status"+ payerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, "xpath=(//a[contains(text(),'Save')])[4]"), "Could not click Save button" +  payerData.toString(), selenium, ClassName, MethodName);
			 
		}else{
			assertTrue(selectValueFromAjaxList(selenium,ajxPayerSelect,payerData.payerName),"Could not select payer"+ payerData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtPayerStartDate,date), "Could not enter start Date", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxRelationShip,payerData.relationshipStatus),"Could not select Relationship Status"+ payerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnlnkSave), "Could not click Save button" +  payerData.toString(), selenium, ClassName, MethodName);
		}
			
			
			
			waitForPageLoad(selenium);
			click(selenium,btnOK);
		
		return true;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * navigateToSocioEconomicTab
	 * function for Navigate to socioEconomic page
	 * @param 		selenium
	 * @throws      IOException  
	 * @since  	    Nov 07, 2014
	 */
	public boolean navigateToSocioEconomicTab(Selenium selenium)throws IOException
	{
		assertTrue(click(selenium,socioEconomicBtn),"Unable to click the socio economic link",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,editButton),"Unable to click the edit button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	
	public boolean createPatient(Selenium selenium, HomeLib patientData, String uniqueName, String userAccount) throws IOException{
		boolean returnValue = false;
		try{
			if(!patientData.patientIdchart.isEmpty())
				if(!patientData.patientIdchart.contains("N/A"))
					assertTrue(type(selenium,txtChartNumber,patientData.patientIdchart),"Could not Enter the patientId chart, Expected value to be typed" + patientData.patientIdchart, selenium, ClassName, MethodName );
			if(!patientData.primaryLocation.isEmpty())
				if(!patientData.primaryLocation.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPrimaryLocation, patientData.primaryLocation))
						Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + patientData.primaryLocation);
			if(!patientData.responsibleProvider.isEmpty())
				if(!patientData.responsibleProvider.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,ajxResponsbleProvider,patientData.responsibleProvider))
						Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + patientData.responsibleProvider);
			if(!patientData.pcpCheck.isEmpty())
				if(!patientData.pcpCheck.contains("No"))
					assertTrue(check(selenium, chkResponsibleProvider), "Could not check the pcp check box, Expected value for the check box : " + patientData.pcpCheck, selenium, ClassName, MethodName);
			
			if(!patientData.lastName.isEmpty())
				if(!patientData.lastName.contains("N/A"))
					assertTrue(type(selenium, txtLastName, patientData.lastName+uniqueName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName, selenium, ClassName, MethodName);
			if(!patientData.firstName.isEmpty())
				if(!patientData.firstName.contains("N/A"))
					assertTrue(type(selenium, txtFirstName, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName, selenium, ClassName, MethodName);
			
			if(!patientData.middleName.isEmpty())
				if(!patientData.middleName.contains("N/A"))
					assertTrue(type(selenium, txtMiddleName, patientData.middleName), "Could not Enter middle name, Expected value to be typed" + patientData.middleName, selenium, ClassName, MethodName);
			if(!patientData.title.isEmpty())
				if(!patientData.title.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxTitle, patientData.title))	
						Assert.fail("Could not Enter Title, Expected value to be selected" + patientData.title);
			if(!patientData.suffix.isEmpty())
				if(!patientData.suffix.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxSuffix, patientData.suffix))
						Assert.fail("Could not Enter Suffix, Expected value to be selected" + patientData.suffix);
			if(!patientData.alias1.isEmpty())
				if(!patientData.alias1.contains("N/A"))
					assertTrue(type(selenium, txtAlias1, patientData.alias1), "Could not Enter alias1, Expected value to be typed" + patientData.alias1, selenium, ClassName, MethodName);
			if(!patientData.alias2.isEmpty())
				if(!patientData.alias2.contains("N/A"))
					assertTrue(type(selenium, txtAlias2, patientData.alias2), "Could not Enter alias2, Expected value to be typed" + patientData.alias2, selenium, ClassName, MethodName);
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
			
				if(!patientData.dobCa.isEmpty())
					if(!patientData.dobCa.contains("N/A"))
						assertTrue(enterDate(selenium, txtDOB, patientData.dobCa), "Could not Enter dob, Expected value to be typed" + patientData.dobCa, selenium, ClassName, MethodName);
				
		    }
			
			else
				{
				
				if(!patientData.dob.isEmpty())
					if(!patientData.dob.contains("N/A"))
						assertTrue(enterDate(selenium, txtDOB, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName, MethodName);
			
			}	
							
			if(isElementPresent(selenium,"css=div.paddingTop20")){
				
				isElementPresent(selenium,btnNoDuplicate);
				waitForPageLoad(selenium);					
				assertTrue(click(selenium, btnNoDuplicate), "Could not click on the button", selenium, ClassName, MethodName);
			}
			
			//click(selenium,btnBack);
			if(!patientData.estimatedCheck.isEmpty())
				if(!patientData.estimatedCheck.contains("No"))
					assertTrue(click(selenium, chkDOBEstimated), "Could not check the estimated check box, Expected value for the check box : " + patientData.estimatedCheck, selenium, ClassName, MethodName);
			if(!patientData.prematureCheck.isEmpty())
				if(!patientData.prematureCheck.contains("No")){
					assertTrue(click(selenium, chkPremature), "Could not check the premature check box, Expected value for the check box : " + patientData.prematureCheck, selenium, ClassName, MethodName);
					if(!patientData.duration.isEmpty())
						if(!patientData.duration.contains("N/A"))
							assertTrue(type(selenium, txtPrematureDuration, patientData.duration), "Could not Enter duration, Expected value to be typed : " + patientData.duration, selenium, ClassName, MethodName);
					if(!patientData.measure.isEmpty())
						if(!patientData.measure.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxPrematureMeasure, patientData.measure))
								Assert.fail("Could not Enter Premature Messure, Expected value to be selected" + patientData.measure);
								waitForPageLoad(selenium);
				}
			waitForPageLoad(selenium);
			if(!patientData.sex.isEmpty())
				if(!patientData.sex.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxSex, patientData.sex))
						Assert.fail("Could not Enter Sex, Expected value to be selected" + patientData.sex);
						waitForPageLoad(selenium);
			if(!patientData.maritalStatus.isEmpty())
				if(!patientData.maritalStatus.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxmartialStatus, patientData.maritalStatus))
						Assert.fail("Could not Enter Marital Status, Expected value to be selected" + patientData.maritalStatus);					
			if(!patientData.status.isEmpty())
				if(!patientData.status.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxStatus, patientData.status))
						Assert.fail("Could not Enter Status, For; More Details" + patientData.toString());
			waitForPageLoad(selenium);
			if(!patientData.statusDate.isEmpty())
				if(!patientData.statusDate.contains("N/A"))
					waitForPageLoad(selenium);
			assertTrue(enterDate(selenium, txtStatusDate, patientData.statusDate), ""	+ "Could not Enter statusDate, For; More Details", selenium, ClassName,	MethodName);
		     //	Assert.assertTrue(enterDate(selenium, txtStatusDate, patientData.statusDate), "Could not Enter statusDate, For; More Details" + patientData.toString());
			if(patientData.status.equalsIgnoreCase("inactive"))
				if(!patientData.reasonForInactivation.isEmpty())
					if(!patientData.reasonForInactivation.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxStationInactivation, patientData.reasonForInactivation))
							Assert.fail("Could not Enter reason for inactivation, For; More Details" + patientData.maritalStatus);					
			if(!patientData.residentialAddrStreet1.isEmpty())
				if(!patientData.residentialAddrStreet1.contains("N/A"))
					assertTrue(type(selenium, txtResidentAddress1, patientData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + patientData.residentialAddrStreet1, selenium, ClassName, MethodName);
			if(!patientData.residentialAddrStreet2.isEmpty())
				if(!patientData.residentialAddrStreet2.contains("N/A"))
					assertTrue(type(selenium, txtResidentAddress2, patientData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + patientData.residentialAddrStreet2, selenium, ClassName, MethodName);
			if(!patientData.residentialAddrcity.isEmpty())
				if(!patientData.residentialAddrcity.contains("N/A"))
					assertTrue(type(selenium, txtResidentialCity, patientData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + patientData.residentialAddrcity, selenium, ClassName, MethodName);
			
		if(userAccount.equalsIgnoreCase(CAAccount)){
				
			if(!patientData.residentialAddrstateCA.isEmpty())
				if(!patientData.residentialAddrstateCA.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxResidentialState, patientData.residentialAddrstateCA))
							Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.residentialAddrstateCA);
				
			if(!patientData.residentialAddrzipCodeCA.isEmpty())
				if(!patientData.residentialAddrzipCodeCA.contains("N/A"))
					assertTrue(type(selenium, txtResidentialZip, patientData.residentialAddrzipCodeCA), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCodeCA, selenium, ClassName, MethodName);
				
		    }
			
		else{
				
			if(!patientData.residentialAddrstate.isEmpty())
				if(!patientData.residentialAddrstate.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxResidentialState, patientData.residentialAddrstate))
						Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + patientData.residentialAddrstate);
				
			if(!patientData.residentialAddrzipCode.isEmpty())
				if(!patientData.residentialAddrzipCode.contains("N/A"))
					assertTrue(type(selenium, txtResidentialZip, patientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + patientData.residentialAddrzipCode, selenium, ClassName, MethodName);
			
		    }	
			
			waitForPageLoad(selenium);
			selenium.keyPress(ajxPhoneType1, "\\9");
			click(selenium,btnYesButton);
			waitForElementToEnable(selenium,txtResidentialCity);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,ajxResidentialState);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,ajxResidentialCountry);
			waitForPageLoad(selenium);
		
			
			if(!patientData.telephoneType1.isEmpty())
				if(!patientData.telephoneType1.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType1, patientData.telephoneType1))
						Assert.fail("Could not Enter Telephone Type1, Expected value to be Select" + patientData.telephoneType1);
			if(!patientData.telephoneNo1.isEmpty())
				if(!patientData.telephoneNo1.contains("N/A"))
					assertTrue(type(selenium, txtPrimaryPhone, patientData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo1, selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo1.isEmpty())
				if(!patientData.telephoneextnNo1.contains("N/A"))
					assertTrue(type(selenium, txtPrimaryPhoneExtn, patientData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo1, selenium, ClassName, MethodName);
			if(!patientData.telephoneType2.isEmpty())
				if(!patientData.telephoneType2.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType2, patientData.telephoneType2))
						Assert.fail("Could not Enter Telephone Type2, Expected value to be Select" + patientData.telephoneType2);
			
			if(!patientData.telephoneNo2.isEmpty())
				if(!patientData.telephoneNo2.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone1, patientData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo2, selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo2.isEmpty())
				if(!patientData.telephoneextnNo2.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone1Extn, patientData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo2, selenium, ClassName, MethodName);
			
			if(!patientData.telephoneType3.isEmpty())
				if(!patientData.telephoneType3.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType3, patientData.telephoneType3))
						Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + patientData.telephoneType3);
			
			if(!patientData.telephoneNo3.isEmpty())
				if(!patientData.telephoneNo3.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone2, patientData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo3, selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo3.isEmpty())
				if(!patientData.telephoneextnNo3.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone2Extn, patientData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneNo3, selenium, ClassName, MethodName);
			
			if(!patientData.email.isEmpty())
				if(!patientData.email.contains("N/A"))
					assertTrue(type(selenium, txtEmail, patientData.email), "Could not Enter email, Expected value to be Typed" + patientData.email, selenium, ClassName, MethodName);
			
			if(!patientData.contactPreferences.isEmpty())
				if(!patientData.contactPreferences.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxContactPreference, patientData.contactPreferences))
						Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences);
			
			if(!patientData.contactPreferences1.isEmpty())
				if(!patientData.contactPreferences1.contains("N/A"))
					assertTrue(click(selenium, btnAddContactPreference), "Could not click on add more button", selenium, ClassName, MethodName);
					if(!selectValueFromAjaxList(selenium, ajxContactPreference1, patientData.contactPreferences1))
						Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences1);
			
			if(!patientData.contactPreferences2.isEmpty())
				if(!patientData.contactPreferences2.contains("N/A"))
					assertTrue(click(selenium, btnAddContactPreference), "Could not click on add more button", selenium, ClassName, MethodName);
					if(!selectValueFromAjaxList(selenium, ajxContactPreference2, patientData.contactPreferences2))
						Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences2);
			
			if(!patientData.contactPreferences4.isEmpty())
				if(!patientData.contactPreferences4.contains("N/A"))
					assertTrue(click(selenium, btnAddContactPreference), "Could not click on add more button", selenium, ClassName, MethodName);
						if(!selectValueFromAjaxList(selenium, ajxContactPreference4, patientData.contactPreferences4))
							Assert.fail("Could not Enter Contact preference, Expected value to be Select" + patientData.contactPreferences4);

			if(!patientData.sameAsResidentialAddressCheck.isEmpty()){
				if(!patientData.sameAsResidentialAddressCheck.contains("No"))
					assertTrue(click(selenium, chkMailingAsResidential), "Could not check the ssn check box, Expected value for the check box : " + patientData.sameAsResidentialAddressCheck, selenium, ClassName, MethodName);
				
					if(!patientData.mailingAddressStreet1.isEmpty())
						if(!patientData.mailingAddressStreet1.contains("N/A"))
							assertTrue(type(selenium, txtMailingAddress1, patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1, selenium, ClassName, MethodName);
					if(!patientData.mailingAddressStreet2.isEmpty())
						if(!patientData.mailingAddressStreet2.contains("N/A"))
							assertTrue(type(selenium, txtMailingAddress2, patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2, selenium, ClassName, MethodName);
					if(!patientData.mailingAddressCity.isEmpty())
						if(!patientData.mailingAddressCity.contains("N/A"))
							assertTrue(type(selenium, txtMailingCity, patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity, selenium, ClassName, MethodName);
					if(!patientData.mailingAddressState.isEmpty())
						if(!patientData.mailingAddressState.contains("N/A"))
							selectValueFromAjaxList(selenium, ajxMailingState, patientData.mailingAddressState);
								
					if(!patientData.mailingAddressZipcode.isEmpty())
						if(!patientData.mailingAddressZipcode.contains("N/A"))
							assertTrue(type(selenium, txtMailingZip, patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode, selenium, ClassName, MethodName);					
					waitForPageLoad(selenium);
					selenium.keyPress(txtComments, "\\9");
					click(selenium,btnYesButton);
					waitForElementToEnable(selenium,txtMailingCity);
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,ajxMailingState);
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,ajxMailingCountry);
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,txtMailingCountry);
					waitForPageLoad(selenium);
					
			}
			else{
				if(!patientData.mailingAddressStreet1.isEmpty())
					if(!patientData.mailingAddressStreet1.contains("N/A"))
						assertTrue(type(selenium, txtMailingAddress1, patientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + patientData.mailingAddressStreet1, selenium, ClassName, MethodName);
				if(!patientData.mailingAddressStreet2.isEmpty())
					if(!patientData.mailingAddressStreet2.contains("N/A"))
						assertTrue(type(selenium, txtMailingAddress2, patientData.mailingAddressStreet2), "Could not Enter Mailing Addr Street12, Expected value to be Typed" + patientData.mailingAddressStreet2, selenium, ClassName, MethodName);
				if(!patientData.mailingAddressCity.isEmpty())
					if(!patientData.mailingAddressCity.contains("N/A"))
						assertTrue(type(selenium, txtMailingCity, patientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + patientData.mailingAddressCity, selenium, ClassName, MethodName);
				
				if(!patientData.mailingAddressZipcode.isEmpty())
					if(!patientData.mailingAddressZipcode.contains("N/A"))
						assertTrue(type(selenium, txtMailingZip, patientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + patientData.mailingAddressZipcode, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selenium.keyPress(txtComments, "\\9");
				click(selenium,btnYesButton);
				waitForElementToEnable(selenium,txtMailingCity);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,ajxMailingState);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,ajxMailingCountry);
				waitForPageLoad(selenium);
				
		
			}
			if(!patientData.comments.isEmpty())
				if(!patientData.comments.contains("N/A"))
					assertTrue(type(selenium, txtComments, patientData.comments), "Could not Enter comments, Expected value to be Selected" + patientData.comments, selenium, ClassName, MethodName);			
			click(selenium,btnSave1);
			waitForPageLoad(selenium);
			returnValue = true;	
			waitForPageLoad(selenium);		
		}catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
	}
	return returnValue;
}

	/**
	 * createNewPatient for Unprinted Statements
	 * function to create a New Patient entry
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	     Apr 11, 2014 
	 */	
	
	
	public boolean createNewPatient_UnprintedStatements(Selenium selenium, HomeLib patientData) throws Exception{
	
		boolean returnValue = false;
		
		try{				
											
			//--------------------------------------------------------------------//
			//---------------  Step-1: Navigate to system setting   --------------//
			//--------------------------------------------------------------------//	

							
			assertTrue(click(selenium, txtSearchPatientBox)," ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSettings),"Could not click on the link" + patientData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingAction),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Delete All Mandatory data   --------------//
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium)," ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-3: Click New Patient Check-in   --------------//
			//--------------------------------------------------------------------//
	
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
			Assert.assertTrue(click(selenium, btnErrorClose));
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click on the link" + patientData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;
			
			}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		}
		return returnValue;
	}
	
	/**
	 * inActivePatientSearchInMergedCharts
	 * function for Searching a patient with inactive
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws      IOException  
	 * @since  	    Nov 07, 2014
	 */
	public boolean inActivePatientSearchInMergedCharts(Selenium selenium,String patientID,String searchBox)throws IOException
	{
		try
		{
		String path="xpath=(//div[@id='patientInfoWidget'])[";
		int count=0,i=1;
		
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click on error close", selenium, ClassName,MethodName);

		selenium.typeKeys(searchBox, "\b");
		assertTrue(type(selenium,searchBox,patientID),"Could not type patient id", selenium, ClassName,MethodName);
		selenium.focus(searchBox);		
		selenium.fireEvent(searchBox,"keydown");
		selenium.fireEvent(searchBox,"keypress");
		selenium.fireEvent(searchBox,"keyup");
		selenium.keyPress(searchBox, "\\13");
		waitForElement(selenium,lblPatientResult,10000);
		if(!isChecked(selenium,chkIncludeInactiveBox))
		{
		assertTrue(click(selenium,chkIncludeInactiveBox),"Unable to click the include inactive checkbox",selenium,ClassName,MethodName);
		}
		waitForElement(selenium,lblPatientResult,10000);
		
		do
		{
			count++;
			
		}while(isElementPresent(selenium,path+count+"]"));
		
		while(i<=count)
		{
			if(getText(selenium,path+i+"]").contains("Inactive"))
			{
				
				assertTrue(getText(selenium,path+i+"]").contains(patientID),"Wrong patient seleciton",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				break;
			}
			i++;
		}
		assertTrue(click(selenium,closeSearchResultPopup),"unable to click 'X' mark in the search box",selenium,ClassName,MethodName);
		selenium.clickAt(searchBox, "");
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium,patientSearchWidget),"Close button not working properly",selenium,ClassName,MethodName);		
		}catch(Exception e)
		{
			 e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	
	
	
	public boolean searchInactivePatientNexiaOnChartManagement(Selenium selenium,String patientID,String searchBox) throws IOException
	{
		
			
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click on error close", selenium, ClassName,MethodName);
		
		
		assertTrue(type(selenium,searchBox,patientID),"Could not type patient id", selenium, ClassName,MethodName);
		
		selenium.clickAt(searchBox,"");
		selenium.focus(searchBox);			
		selenium.fireEvent(searchBox,"keypress");
		waitForElement(selenium,lblPatientResult,10000);
		if(!isChecked(selenium,chkIncludeInactiveBox))
		{
		assertTrue(click(selenium,chkIncludeInactiveBox),"Unable to click the inactive check box",selenium,ClassName,MethodName);
		}
		waitForPageLoad(selenium);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, selenium, ClassName,MethodName);
		assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not get patient id", selenium, ClassName,MethodName);
		assertTrue(getText(selenium,lblPatientResult).contains("Inactive"),"Fail to click the inactive patient",selenium,ClassName,MethodName);
        click(selenium,lblPatientResult);
		
		waitForPageLoad(selenium);
		
		
		if(isElementPresent(selenium, btnErrorClose))
		assertTrue(click(selenium, btnErrorClose),"could not click on error close", selenium, ClassName,MethodName);
		return true;
	}
	
	
	
	
	/**
	 * searchPatientNexiaOnChartManagement
	 * function for Searching a patient in Chart
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws      IOException  
	 * @since  	    Oct 15, 2014
	 */
	public boolean searchPatientNexiaOnChartManagement(Selenium selenium,String patientID,String searchBox) throws IOException{
		try{
			
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click on error close", selenium, ClassName,MethodName);
		
		
		assertTrue(type(selenium,searchBox,patientID),"Could not type patient id", selenium, ClassName,MethodName);
		
		selenium.clickAt(searchBox,"");
		selenium.focus(searchBox);			
		selenium.fireEvent(searchBox,"keypress");	
		
		waitForPageLoad(selenium);
		assertTrue(type(selenium,searchBox,patientID),"Could not type patient id", selenium, ClassName,MethodName);
		
		selenium.clickAt(searchBox,"");
		selenium.focus(searchBox);			
		selenium.fireEvent(searchBox,"keypress");	
	
		
		
		
		//selenium.keyPress(txtPatientBox, "\\9");
		waitForElement(selenium,lblPatientResult,10000);
	
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, selenium, ClassName,MethodName);
	     assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not get patient id", selenium, ClassName,MethodName);
		click(selenium,lblPatientResult);
		
		waitForPageLoad(selenium);
		//assertTrue(isElementPresent(selenium,lblPatientInfoSummary),"The searched patient information could not be loaded", selenium, ClassName,MethodName);
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click on error close", selenium, ClassName,MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * verifyDisplayPage
	 * function for verify Merge data page
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws      IOException  
	 * @since  	    Nov 11, 2014
	 */
	public boolean verifyDisplayPage(Selenium selenium)throws IOException
	{
		assertTrue(isElementPresent(selenium,textMessage),"Unable to find the prompt message one on the top of the page",selenium,ClassName,MethodName);
		assertTrue(isElementPresent(selenium,mergeHint),"Unable to find the prompt message two on the top of the page",selenium,ClassName,MethodName);
		assertTrue(isElementPresent(selenium,btnCancel),"Unable to find the save button",selenium,ClassName,MethodName);
		assertTrue(isElementPresent(selenium,btnSave1),"Unable to find the cancel button",selenium,ClassName,MethodName);
		return true;
	}
	/**
	 * verifyDisplayDataAfterSearch
	 * function for verify data on the places
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws      IOException  
	 * @since  	    Nov 11, 2014
	 */
	public boolean verifyDisplayDataAfterSearch(Selenium selenium,HomeLib patientData,String patientId1)throws IOException
	{
		assertTrue(isElementPresent(selenium,mergeChartText),"Data not present at the top of the page",selenium,ClassName,MethodName);
		assertTrue(getText(selenium,mergeChartText).trim().contains(patientData.pageData.trim()),"Data not matched at the top of the chart search",selenium,ClassName,MethodName);
		assertTrue(getText(selenium,patientId).contains(patientId1),"Patient ID not present",selenium,ClassName,MethodName);
		assertTrue(isElementPresent(selenium,patientPersonalInfo),"Personal Info column not found",selenium,ClassName,MethodName);
		assertTrue(isElementPresent(selenium,patientSocioInfo),"Socio Economic colum not found",selenium,ClassName,MethodName);
		assertTrue(getText(selenium,patientSocioInfo).contains("Socio-Economic Data"),"Data not found",selenium,ClassName,MethodName);
		assertTrue(getText(selenium,patientPersonalInfo).contains("Personal Info"),"data not present",selenium,ClassName,MethodName);
		return true;
	}
	/**
	 * navigateToMergeCharts
	 * function for navigating to merge charts
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws      IOException  
	 * @since  	    Oct 15, 2014
	 */
	public boolean navigateToMergeCharts(Selenium selenium) throws IOException{
		assertTrue(click(selenium,lnkQuickLink),"Could not click on quick action", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//assertTrue(click(selenium,lnkShowMoreLink),"Could not click on the show more action link" ,selenium,ClassName,MethodName);
		//waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkChartMgmt),"Could not click on Chart Management link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkMergeCharts),"Could not click on Merge Charts link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	
	/**
	 * navigateToMergeCharts
	 * function for navigating to merge charts
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws      IOException  
	 * @since  	    Oct 15, 2014
	 */
	public boolean verifySearchResultsOnPatientChart1(Selenium selenium,HomeLib patientData,String patientId,String account) throws IOException{
		try
		{
		assertTrue(getText(selenium,lblpatientIdLeft).contains(patientId),"Patient ID not found", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.lastName.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.firstName.toLowerCase(new java.util.Locale("en","Us")).trim()),"First name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.sex.toLowerCase(new java.util.Locale("en","Us")).trim()),"sex is not present", selenium, ClassName, MethodName);
		if (account.equals(CAAccount))
		{
		 DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 Date date = simpleDateFormat.parse(patientData.dob);
		 DateFormat targetFormat = new SimpleDateFormat("MMM d, yyyy");
		 String formattedDate = targetFormat.format(date);
		 assertTrue(getText(selenium,lblPatientInfoChart1).contains(formattedDate),"dob is not present", selenium, ClassName, MethodName);
		}
		else
		{
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.dob.toLowerCase(new java.util.Locale("en","Us")).trim()),"dob is not present", selenium, ClassName, MethodName);
		}
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.maritalStatus.toLowerCase(new java.util.Locale("en","Us")).trim()),"MaritalStatus is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.residentialAddrStreet1.toLowerCase(new java.util.Locale("en","Us")).trim()),"Residential address 1 street is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.residentialAddrStreet2.toLowerCase(new java.util.Locale("en","Us")).trim()),"residential adderess street 2 is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.residentialAddrcity.toLowerCase(new java.util.Locale("en","Us")).trim()),"City is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.email.toLowerCase(new java.util.Locale("en","Us")).trim()),"Email is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.status.toLowerCase(new java.util.Locale("en","Us")).trim()),"Status is not present", selenium, ClassName, MethodName);
		
		if(patientData.sameAsResidentialAddressCheck.equals("Yes")){
			assertTrue(getText(selenium,lblPatientInfoChart1).contains("Same as Residential"),"Last name is not present", selenium, ClassName, MethodName);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return false;
		}
		
		return true;
	}
	
	/**
	 * navigateToMergeCharts
	 * function for navigating to merge charts
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws      IOException  
	 * @since  	    Oct 15, 2014
	 */
	public boolean verifySearchResultsOnPatientChart2(Selenium selenium,HomeLib patientData,String patientId,String account) throws IOException{
		try
		{
		assertTrue(getText(selenium,lblPatientIdRight).contains(patientId),"Patient ID not found", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.lastName.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.firstName.toLowerCase(new java.util.Locale("en","Us")).trim()),"First name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.sex.toLowerCase(new java.util.Locale("en","Us")).trim()),"sex is not present", selenium, ClassName, MethodName);
		if (account.equals(CAAccount))
		{
		 DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 Date date = simpleDateFormat.parse(patientData.dob);
		 DateFormat targetFormat = new SimpleDateFormat("MMM d, yyyy");
		 String formattedDate = targetFormat.format(date);
		 assertTrue(getText(selenium,lblPatientInfoChart2).contains(formattedDate),"dob is not present", selenium, ClassName, MethodName);
		}
		else
		{
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.dob.toLowerCase(new java.util.Locale("en","Us")).trim()),"dob is not present", selenium, ClassName, MethodName);
		}
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.maritalStatus.toLowerCase(new java.util.Locale("en","Us")).trim()),"MaritalStatus is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.residentialAddrStreet1.toLowerCase(new java.util.Locale("en","Us")).trim()),"Residential address 1 street is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.residentialAddrStreet2.toLowerCase(new java.util.Locale("en","Us")).trim()),"residential adderess street 2 is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.residentialAddrcity.toLowerCase(new java.util.Locale("en","Us")).trim()),"City is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.email.toLowerCase(new java.util.Locale("en","Us")).trim()),"Email is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.status.toLowerCase(new java.util.Locale("en","Us")).trim()),"Status is not present", selenium, ClassName, MethodName);
		
		if(patientData.sameAsResidentialAddressCheck.equals("Yes")){
			assertTrue(getText(selenium,lblPatientInfoChart2).contains("Same as Residential"),"Last name is not present", selenium, ClassName, MethodName);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return false;
		}
		
		return true;
	}
	
	/**
	 * navigateToMergeCharts
	 * function for navigating to merge charts
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws      IOException  
	 * @since  	    Oct 21, 2014
	 */
	public boolean verifySearchResultSocioInformationsOnPatientChart2(Selenium selenium,HomeLib patientData) throws IOException{
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.lastName.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.firstName.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.sex.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.maritalStatus.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.residentialAddrStreet1.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.residentialAddrStreet2.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.residentialAddrcity.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.email.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.status.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		
		if(patientData.sameAsResidentialAddressCheck.equals("Yes")){
			assertTrue(getText(selenium,lblPatientInfoChart2).toLowerCase(new java.util.Locale("en","Us")).trim().contains("Same as Residential".toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		}
		
		return true;
	}
	/**
	 * navigateToPatientConsentsPage
	 * function for navigating to patient consents page from homepage
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws      IOException  
	 * @since  	    Nov 12, 2014
	 */
	public boolean navigateToPatientConsentsPage(Selenium selenium,String patientId)throws IOException
	{
		assertTrue(type(selenium,txtSearchPatientBox,patientId),"Unable to enter the patient ID in the patient search box",selenium,ClassName,MethodName);
		selenium.clickAt(txtSearchPatientBox,"");
		selenium.focus(txtSearchPatientBox);			
		selenium.fireEvent(txtSearchPatientBox,"keypress");
		waitForPageLoad(selenium);
		if(!isChecked(selenium,"includeInactivescheckbox"))
		{
		assertTrue(click(selenium,"includeInactivescheckbox"),"Unable to click the inactive check box",selenium,ClassName,MethodName);
		}
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,lblPatientResult),"Search Results are not displayed for the patient", selenium, ClassName, MethodName);
		click(selenium,lblPatientResult);
		waitForPageLoad(selenium);
		/*assertTrue(click(selenium,lnkPatientOption),"Unable to click the pation options",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkPatientOptionRegistration),"Unable to find the patient registration option",selenium,ClassName,MethodName);
        waitForPageLoad(selenium);*/
		assertTrue(click(selenium,lnkConsentsPatient),"Unable to click the consents link",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnAddDemoConsents),"Unable to click the Add new button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	/**
	 * navigateToMedicalPayers
	 * function for navigate from payers to add a new medical payers page
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws      IOException  
	 * @since  	    Nov 12, 2014
	 */
	public boolean navigateToMedicalPayers(Selenium selenium)throws IOException
	{
		assertTrue(click(selenium,btnPayerList),"Unable to click the payers",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);				
		assertTrue(click(selenium,btnAddNew),"Could not click on addnew Payer", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	
	
	public boolean navigateToPatientDemographicsPage(Selenium selenium,String patientId)throws IOException
	{
		assertTrue(type(selenium,txtSearchPatientBox,patientId),"Unable to enter the patient ID in the patient search box",selenium,ClassName,MethodName);
		selenium.clickAt(txtSearchPatientBox,"");
		selenium.focus(txtSearchPatientBox);			
		selenium.fireEvent(txtSearchPatientBox,"keypress");
		waitForPageLoad(selenium);
		if(!isChecked(selenium,"includeInactivescheckbox"))
		{
		assertTrue(click(selenium,"includeInactivescheckbox"),"Unable to click the inactive check box",selenium,ClassName,MethodName);
		}
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,lblPatientResult),"Search Results are not displayed for the patient", selenium, ClassName, MethodName);
		click(selenium,lblPatientResult);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,lnkPatientOption),"Unable to click the pation options",selenium,ClassName,MethodName);
		//waitForElement(selenium,lnkPatientOptionRegistration,10000);
		//assertTrue(click(selenium,lnkPatientOptionRegistration),"Unable to find the patient registration option",selenium,ClassName,MethodName);
        waitForPageLoad(selenium);
		return true;
	}
	
	/**
	 * navigateToMergeCharts
	 * function for navigating to merge charts
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws      IOException  
	 * @since  	    Oct 21, 2014
	 */
	public boolean verifySearchResultSocioInformationsOnPatientChart1(Selenium selenium,HomeLib patientData) throws IOException{
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.lastName.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.firstName.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.sex.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.maritalStatus.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.residentialAddrStreet1.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.residentialAddrStreet2.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.residentialAddrcity.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.email.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientData.status.toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		
		if(patientData.sameAsResidentialAddressCheck.equals("Yes")){
			assertTrue(getText(selenium,lblPatientInfoChart1).toLowerCase(new java.util.Locale("en","Us")).trim().contains("Same as Residential".toLowerCase(new java.util.Locale("en","Us")).trim()),"Last name is not present", selenium, ClassName, MethodName);
		}
		
		return true;
	}
	
	public boolean goToOrderTemplate(Selenium selenium,ChartPreVisitLib patientData) throws IOException{
		assertTrue(click(selenium, lnkQuickLink), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		assertTrue(click(selenium, showMoreAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		assertTrue(click(selenium, lnkClinicalSettings), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkOrderTemplate), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		return true;
	}
	
	public boolean addOrderTemplate(Selenium selenium,ChartPreVisitLib OrderData) throws IOException{
		assertTrue(click(selenium, addNewOrder), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtTemplateName,OrderData.templateName), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtSectionName,OrderData.sectionName), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		assertTrue(selectValueFromAjaxList(selenium, txtTestName,OrderData.testName),"Select Failed",selenium, ClassName, MethodName);
		assertTrue(click(selenium, BtnNextButton), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		assertTrue(check(selenium, chkTestPreview), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		assertTrue(click(selenium, btnDone), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		return true;
	}
	public boolean verifyMergedChartPageIndividual(Selenium selenium,String userAccount)throws IOException
    {
		assertTrue(isElementPresent(selenium,lnkLeftPatientInfoPanel),"Unable to find the left side personal info panel",selenium,ClassName,MethodName);
		assertTrue(isElementPresent(selenium,lnkLeftSocioEconomicPanel),"Unable to find the left side socio economic panel",selenium,ClassName,MethodName);          
		char[] userName=getText(selenium,"username").toCharArray();
                  int value=1,i=0;
                  do{
                        value++;
                  }while(userName[value]!=',');
                  String user="",date="";
                  while(i<value)
                  {
                        user=user+userName[i];
                        i++;
                  }
                  System.out.println(user);
                  assertTrue(getText(selenium,lnkLastUpdatedLeft).contains(user),"UserName not present in the last updated value",selenium,ClassName,MethodName);
                  if(userAccount.equals(CAAccount)){
                  Calendar cal=Calendar.getInstance();
                  SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
                   date=DateFormat.format(cal.getTime());
           }else{
                  Calendar cal=Calendar.getInstance();
                  SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
                   date=DateFormat.format(cal.getTime());
                  }
           assertTrue(getText(selenium,lnkLastUpdatedLeft).contains(date),"Updatd date is not present in the last updated value",selenium,ClassName,MethodName);
       return true;
    }

	public boolean selectPractice(Selenium selenium) throws IOException
    {
    	waitForPageLoad(selenium);
    	waitForPageLoad(selenium);
    	waitForPageLoad(selenium);
    	if(!getText(selenium,lnkLocationMenuHeader).contains("Automation Nexia")){
    		assertTrue(click(selenium,lnkLocationMenuHeader),"Could not click on practices link:", selenium, ClassName, MethodName);
    		waitForPageLoad(selenium);
    	 int Count;
    		int Count1=(Integer) selenium.getXpathCount("//tr/td/a/span");
    		for(Count=1;Count<=Count1;Count++)		{
    			if(getText(selenium,"//tr["+Count+"]/td/a/span").contains("Automation Nexia Clinic")){
    				
    				assertTrue(click(selenium,"//tr["+Count+"]/td/a/span"),"Could not click on practices link:", selenium, ClassName, MethodName);
    				waitForPageLoad(selenium);
    			}
    		}		
    	}		
    	return true;
    }
}
	

