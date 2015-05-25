package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class EditPatientCheckinInfoCAView extends AbstractHomeTest{
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing patient Info")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editPatientInfo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientcaData = new HomeLib();
		patientcaData.workSheetName = "NewPatientCheckInCAView";
		patientcaData.testCaseId = "TC_NPC_001";
		patientcaData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPatientForCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	}
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing patient Info")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editPatientInfoUsingAdvanceSearch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib editPatientInfoData = new HomeLib();
		editPatientInfoData.workSheetName = "EditPatientCheckInCAView";
		editPatientInfoData.testCaseId = "TC_EPI_002";
		editPatientInfoData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPatientInfoAdvanceSearch(seleniumHost, seleniumPort, browser, webSite, userAccount, editPatientInfoData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Edit Patient Checkin Info CAView
	* @action 		  verifying Edit Patient Checkin Info CAView
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 06, 2012
	***************************************************************************************************/
	public boolean editPatientForCAView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientcaData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientcaData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientcaData.userName, patientcaData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientcaData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to system setting 								  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSystemSetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete All Mandatory data  								  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium), "Could not delete all mandatory fields", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Click New Patient Check-in   							  //
			//--------------------------------------------------------------------//				
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickLink),"Could not click Quick Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkRegisterPatient),"Could not click Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("ddHHmm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createPatientCAView(selenium,patientcaData,uniqueName),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Edit patient Info //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnRegistrationEdit),"Could not click edit button"+patientcaData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			HomeLib EditPatientData = new HomeLib();
			EditPatientData.workSheetName = "EditPatientCheckInCAView";
			EditPatientData.testCaseId = "TC_EPI_001";
			EditPatientData.fetchHomeTestData();
		
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd MM yyyyHH");
			String uniquedata=DateFormat1.format(cal1.getTime());
			
			if(!EditPatientData.patientIdchart.isEmpty())
				if(!EditPatientData.patientIdchart.contains("N/A"))
					assertTrue(type(selenium,txtBoxValue,EditPatientData.patientIdchart),"Could not Enter the patientId chart, Expected value to be typed" + EditPatientData.patientIdchart , selenium, ClassName, MethodName);
			
			if(!EditPatientData.canadianProvince.isEmpty())
				if(!EditPatientData.canadianProvince.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,"canadianProvincesuggestBox",EditPatientData.canadianProvince))
					Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + EditPatientData.canadianProvince);
			assertTrue(type(selenium, "healthcardNumber",uniquedata), "Could not Enter Hcn, Expected value to be typed" + EditPatientData.hCN, selenium, ClassName, MethodName);
			
			
			
			if(!EditPatientData.expireDate.isEmpty())
				if(!EditPatientData.expireDate.contains("N/A"))
					assertTrue(enterDate(selenium, "expiryDate", EditPatientData.expireDate), "Could not Enter expireDate , Expected value to be typed" + EditPatientData.expireDate, selenium, ClassName, MethodName);				
				
			if(!EditPatientData.primaryLocation.isEmpty())
					if(!EditPatientData.primaryLocation.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajkSuggestBox, EditPatientData.primaryLocation))
							Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + EditPatientData.primaryLocation);
				
				if(!EditPatientData.responsibleProvider.isEmpty())
					if(!EditPatientData.responsibleProvider.contains("N/A"))
						if(!selectValueFromAjaxList(selenium,ajxResponsbleProvider,EditPatientData.responsibleProvider))
							Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + EditPatientData.responsibleProvider);
				
			if(!EditPatientData.lastName.isEmpty())
					if(!EditPatientData.lastName.contains("N/A"))
						assertTrue(type(selenium, txtLastName, EditPatientData.lastName), "Could not Enter Last name, Expected value to be typed" + EditPatientData.lastName, selenium, ClassName, MethodName);
				if(!EditPatientData.firstName.isEmpty())
					if(!EditPatientData.firstName.contains("N/A"))
						assertTrue(type(selenium, txtFirstName, EditPatientData.firstName), "Could not Enter First name, Expected value to be typed" + EditPatientData.firstName, selenium, ClassName, MethodName);
				if(!EditPatientData.middleName.isEmpty())
					if(!EditPatientData.middleName.contains("N/A"))
						assertTrue(type(selenium, txtMiddleName, EditPatientData.middleName), "Could not Enter middle name, Expected value to be typed" + EditPatientData.middleName, selenium, ClassName, MethodName);
				if(!EditPatientData.title.isEmpty())
					if(!EditPatientData.title.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxTitle, EditPatientData.title))	
							Assert.fail("Could not Enter Title, Expected value to be selected" +EditPatientData.title);
				if(!EditPatientData.suffix.isEmpty())
					if(!EditPatientData.suffix.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxSuffix, EditPatientData.suffix))
							Assert.fail("Could not Enter Suffix, Expected value to be selected" + EditPatientData.suffix);
				if(!EditPatientData.alias1.isEmpty())
					if(!EditPatientData.alias1.contains("N/A"))
						assertTrue(type(selenium, txtAlias1, EditPatientData.alias1), "Could not Enter alias1, Expected value to be typed" + EditPatientData.alias1, selenium, ClassName, MethodName);
				if(!EditPatientData.alias2.isEmpty())
					if(!EditPatientData.alias2.contains("N/A"))
						assertTrue(type(selenium, txtAlias2, EditPatientData.alias2), "Could not Enter alias2, Expected value to be typed" + EditPatientData.alias2, selenium, ClassName, MethodName);
				if(!EditPatientData.dob.isEmpty())
					if(!EditPatientData.dob.contains("N/A"))
						assertTrue(enterDate(selenium, txtDOB, EditPatientData.dob), "Could not Enter dob, Expected value to be typed" + EditPatientData.dob, selenium, ClassName, MethodName);			
				click(selenium,btnBack);
				if(!EditPatientData.estimatedCheck.isEmpty())
					if(!EditPatientData.estimatedCheck.contains("No"))
						assertTrue(check(selenium, chkDOBEstimated), "Could not check the estimated check box, Expected value for the check box : " + EditPatientData.estimatedCheck, selenium, ClassName, MethodName);
				if(!EditPatientData.prematureCheck.isEmpty())
					if(!EditPatientData.prematureCheck.contains("No"))
					{
						assertTrue(click(selenium, chkPremature), "Could not check the premature check box, Expected value for the check box : " + EditPatientData.prematureCheck, selenium, ClassName, MethodName);
						if(!EditPatientData.duration.isEmpty())
							if(!EditPatientData.duration.contains("N/A"))
								assertTrue(type(selenium, txtPrematureDuration, EditPatientData.duration), "Could not Enter duration, Expected value to be typed : " + EditPatientData.duration, selenium, ClassName, MethodName);
						if(!EditPatientData.measure.isEmpty())
							if(!EditPatientData.measure.contains("N/A"))
								if(!selectValueFromAjaxList(selenium, ajxPrematureMeasure, EditPatientData.measure))
									Assert.fail("Could not Enter Premature Messure, Expected value to be selected" + EditPatientData.measure);
					}
				if(!EditPatientData.sex.isEmpty())
					if(!EditPatientData.sex.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxSex, EditPatientData.sex))
							Assert.fail("Could not Enter Sex, Expected value to be selected" + EditPatientData.sex);
				
				if(!EditPatientData.maritalStatus.isEmpty())
					if(!EditPatientData.maritalStatus.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxmartialStatus, EditPatientData.maritalStatus))
							Assert.fail("Could not Enter Marital Status, Expected value to be selected" + EditPatientData.maritalStatus);					
				if(!EditPatientData.status.isEmpty())
					if(!EditPatientData.status.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxStatus, EditPatientData.status))
							Assert.fail("Could not Enter Status, For; More Details" + EditPatientData.toString());
				if(!EditPatientData.statusDate.isEmpty())
					if(!EditPatientData.statusDate.contains("N/A"))
						assertTrue(enterDate(selenium, txtStatusDate, EditPatientData.statusDate), "Could not Enter statusDate, For; More Details" + EditPatientData.toString(), selenium, ClassName, MethodName);
				if(EditPatientData.status.equalsIgnoreCase("inactive"))
					if(!EditPatientData.reasonForInactivation.isEmpty())
						if(!EditPatientData.reasonForInactivation.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxStationInactivation, EditPatientData.reasonForInactivation))
								Assert.fail("Could not Enter reason for inactivation, For; More Details" + EditPatientData.maritalStatus);					
				if(!EditPatientData.residentialAddrStreet1.isEmpty())
					if(!EditPatientData.residentialAddrStreet1.contains("N/A"))
						assertTrue(type(selenium, txtResidentAddress1, EditPatientData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + EditPatientData.residentialAddrStreet1, selenium, ClassName, MethodName);
				if(!EditPatientData.residentialAddrStreet2.isEmpty())
					if(!EditPatientData.residentialAddrStreet2.contains("N/A"))
						assertTrue(type(selenium, txtResidentAddress2, EditPatientData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + EditPatientData.residentialAddrStreet2, selenium, ClassName, MethodName);
				if(!EditPatientData.residentialAddrcity.isEmpty())
					if(!EditPatientData.residentialAddrcity.contains("N/A"))
						assertTrue(type(selenium, txtResidentialCity, EditPatientData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + EditPatientData.residentialAddrcity, selenium, ClassName, MethodName);
				if(!EditPatientData.residentialAddrstate.isEmpty())
					if(!EditPatientData.residentialAddrstate.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxResidentialState, EditPatientData.residentialAddrstate))
							Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + EditPatientData.residentialAddrstate);
				if(!EditPatientData.residentialAddrzipCode.isEmpty())
					if(!EditPatientData.residentialAddrzipCode.contains("N/A"))
						assertTrue(type(selenium, txtResidentialZip, EditPatientData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + EditPatientData.residentialAddrzipCode, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selenium.keyPress(txtComments, "\\9");
				click(selenium,btnYesButton);
				waitForElementToEnable(selenium,txtResidentialCity);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,ajxResidentialState);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,ajxResidentialCountry);
				waitForPageLoad(selenium);
				
				if(!EditPatientData.telephoneType1.isEmpty())
					if(!EditPatientData.telephoneType1.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxPhoneType1, EditPatientData.telephoneType1))
							Assert.fail("Could not Enter Telephone Type1, Expected value to be Select" + EditPatientData.telephoneType1);
				if(!EditPatientData.telephoneNo1.isEmpty())
					if(!EditPatientData.telephoneNo1.contains("N/A"))
						assertTrue(type(selenium, txtPrimaryPhone, EditPatientData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + EditPatientData.telephoneNo1, selenium, ClassName, MethodName);
				if(!EditPatientData.telephoneextnNo1.isEmpty())
					if(!EditPatientData.telephoneextnNo1.contains("N/A"))
						assertTrue(type(selenium, txtPrimaryPhoneExtn, EditPatientData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + EditPatientData.telephoneextnNo1, selenium, ClassName, MethodName);
				
				if(!EditPatientData.telephoneType2.isEmpty())
					if(!EditPatientData.telephoneType2.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxPhoneType2, EditPatientData.telephoneType2))
							Assert.fail("Could not Enter Telephone Type2, Expected value to be Select" + EditPatientData.telephoneType2);
				
				if(!EditPatientData.telephoneNo2.isEmpty())
					if(!EditPatientData.telephoneNo2.contains("N/A"))
						assertTrue(type(selenium, txtOtherPhone1,EditPatientData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + EditPatientData.telephoneNo2, selenium, ClassName, MethodName);
				if(!EditPatientData.telephoneextnNo2.isEmpty())
					if(!EditPatientData.telephoneextnNo2.contains("N/A"))
						assertTrue(type(selenium, txtOtherPhone1Extn, EditPatientData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + EditPatientData.telephoneextnNo2, selenium, ClassName, MethodName);
				
				if(!EditPatientData.telephoneType3.isEmpty())
					if(!EditPatientData.telephoneType3.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxPhoneType3, EditPatientData.telephoneType3))
							Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + EditPatientData.telephoneType3);
				
				if(!EditPatientData.telephoneNo3.isEmpty())
					if(!EditPatientData.telephoneNo3.contains("N/A"))
						assertTrue(type(selenium, txtOtherPhone2,EditPatientData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + EditPatientData.telephoneNo3, selenium, ClassName, MethodName);
				if(!EditPatientData.telephoneextnNo3.isEmpty())
					if(!EditPatientData.telephoneextnNo3.contains("N/A"))
						assertTrue(type(selenium, txtOtherPhone2Extn, EditPatientData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + EditPatientData.telephoneNo3, selenium, ClassName, MethodName);
				
				if(!EditPatientData.email.isEmpty())
					if(!EditPatientData.email.contains("N/A"))
						assertTrue(type(selenium, txtEmail, EditPatientData.email), "Could not Enter email, Expected value to be Typed" + EditPatientData.email, selenium, ClassName, MethodName);
				if(!EditPatientData.contactPreferences.isEmpty())
					if(!EditPatientData.contactPreferences.contains("N/A"))
						if(!selectValueFromAjaxList(selenium,ajxContactPreference,EditPatientData.contactPreferences))
							Assert.fail("Could not Enter the contact preference, Expected value to be select"+EditPatientData.contactPreferences);
				 
				if(!EditPatientData.sameAsResidentialAddressCheck.isEmpty())
				{
					if(!EditPatientData.sameAsResidentialAddressCheck.contains("yes"))
						if(isChecked(selenium,chkMailingAsResidential))
							assertTrue(click(selenium, chkMailingAsResidential), "Could not check the ssn check box, Expected value for the check box : " + EditPatientData.sameAsResidentialAddressCheck, selenium, ClassName, MethodName);
						if(!EditPatientData.mailingAddressStreet1.isEmpty())
							if(!EditPatientData.mailingAddressStreet1.contains("N/A"))
								assertTrue(type(selenium, txtMailingAddress1, EditPatientData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + EditPatientData.mailingAddressStreet1, selenium, ClassName, MethodName);
						if(!EditPatientData.mailingAddressStreet2.isEmpty())
							if(!EditPatientData.mailingAddressStreet2.contains("N/A"))
								assertTrue(type(selenium,txtMailingAddress2,EditPatientData.mailingAddressStreet2),"Could not Enter Mailing Addr Street2, Expected value to be typed" + EditPatientData.mailingAddressStreet2, selenium, ClassName, MethodName);
						if(!EditPatientData.mailingAddressCity.isEmpty())
							if(!EditPatientData.mailingAddressCity.contains("N/A"))
								assertTrue(type(selenium, txtMailingCity, EditPatientData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + EditPatientData.mailingAddressCity, selenium, ClassName, MethodName);
							if(!EditPatientData.mailingAddressState.isEmpty())
							if(!EditPatientData.mailingAddressState.contains("N/A"))
								if(!selectValueFromAjaxList(selenium, ajxMailingState, EditPatientData.mailingAddressState))
									Assert.fail("Could not Enter Mailing Address State, Expected value to be selected" + EditPatientData.mailingAddressState);			
						if(!EditPatientData.mailingAddressZipcode.isEmpty())
							if(!EditPatientData.mailingAddressZipcode.contains("N/A"))
								assertTrue(type(selenium, txtMailingZip, EditPatientData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + EditPatientData.mailingAddressZipcode, selenium, ClassName, MethodName);					
						if(!EditPatientData.mailingAddressCountry.isEmpty())
							if(!EditPatientData.mailingAddressCountry.contains("N/A"))
								if(!selectValueFromAjaxList(selenium,ajxMailingCountry,EditPatientData.mailingAddressCountry))
									Assert.fail("Could not Enter Mailing Addr Country,Expected value to be typed"+EditPatientData.mailingAddressCountry);
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
				if(!EditPatientData.comments.isEmpty())
					if(!EditPatientData.comments.contains("N/A"))
						assertTrue(type(selenium, txtComments, EditPatientData.comments), "Could not Enter comments, Expected value to be Selected" + EditPatientData.comments, selenium, ClassName, MethodName);			
				click(selenium,btnSave1);
				waitForPageLoad(selenium);
				click(selenium,btnRegistrationEdit);
				waitForPageLoad(selenium);
				if(selenium.isAlertPresent()){
					Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
				}
			
				if(!verifyStoredValuesEditPatientCheckInCA(selenium,EditPatientData,uniquedata)){
					Assert.fail("Patient details are not edited properly; More Details :"+ EditPatientData.toString());
					returnValue=false;
				}
				else{
					return returnValue;
				}
			
			}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
		return returnValue;
	}
	public boolean editPatientInfoAdvanceSearch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib editPatientInfoData) throws InterruptedException, IOException{
		
		Selenium selenium = null;
		boolean returnValue = true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + editPatientInfoData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, editPatientInfoData.userName, editPatientInfoData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,editPatientInfoData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to system setting 								  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSystemSetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete All Mandatory data  								  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium), "Could not delete all mandatory fields", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Search for a Patient using Patient ID
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);

			searchPatientNexiaCA(selenium,editPatientInfoData.patientID);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientInfoView),"Could not click edit button"+editPatientInfoData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnRegistrationEdit);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Edit patient Info //
			//--------------------------------------------------------------------//
			if(!editPatientInfoData.patientIdchart.isEmpty())
				if(!editPatientInfoData.patientIdchart.contains("N/A"))
					assertTrue(type(selenium,txtBoxValue,editPatientInfoData.patientIdchart),"Could not Enter the patientId chart, Expected value to be typed" + editPatientInfoData.patientIdchart , selenium, ClassName, MethodName);
			
			if(!editPatientInfoData.canadianProvince.isEmpty())
				if(!editPatientInfoData.canadianProvince.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,"canadianProvincesuggestBox",editPatientInfoData.canadianProvince))
					Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + editPatientInfoData.canadianProvince);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd MM yyyyHH");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(type(selenium, "healthcardNumber", uniqueName), "Could not Enter Hcn, Expected value to be typed" + editPatientInfoData.hCN, selenium, ClassName, MethodName);
			
			if(!editPatientInfoData.expireDate.isEmpty())
				if(!editPatientInfoData.expireDate.contains("N/A"))
					assertTrue(enterDate(selenium, "expiryDate", editPatientInfoData.expireDate), "Could not Enter expireDate , Expected value to be typed" + editPatientInfoData.expireDate, selenium, ClassName, MethodName);				
			
			if(!editPatientInfoData.primaryLocation.isEmpty())
				if(!editPatientInfoData.primaryLocation.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajkSuggestBox, editPatientInfoData.primaryLocation))
						Assert.fail("Could not Enter Primary Location, Expected value to be selected : " + editPatientInfoData.primaryLocation);
			if(!editPatientInfoData.responsibleProvider.isEmpty())
				if(!editPatientInfoData.responsibleProvider.contains("N/A"))
					if(!selectValueFromAjaxList(selenium,ajxResponsbleProvider,editPatientInfoData.responsibleProvider))
						Assert.fail("Could not Enter responsible Provider, Expected value to be selected" + editPatientInfoData.responsibleProvider);
			if(!editPatientInfoData.pcpCheck.isEmpty())
				if(!editPatientInfoData.pcpCheck.contains("No"))
					assertTrue(check(selenium, chkResponsibleProvider), "Could not check the pcp check box, Expected value for the check box : " + editPatientInfoData.pcpCheck, selenium, ClassName, MethodName);
			if(!editPatientInfoData.lastName.isEmpty())
				if(!editPatientInfoData.lastName.contains("N/A"))
					assertTrue(type(selenium, txtLastName, editPatientInfoData.lastName), "Could not Enter Last name, Expected value to be typed" + editPatientInfoData.lastName, selenium, ClassName, MethodName);
			if(!editPatientInfoData.firstName.isEmpty())
				if(!editPatientInfoData.firstName.contains("N/A"))
					assertTrue(type(selenium, txtFirstName, editPatientInfoData.firstName), "Could not Enter First name, Expected value to be typed" + editPatientInfoData.firstName, selenium, ClassName, MethodName);
			if(!editPatientInfoData.middleName.isEmpty())
				if(!editPatientInfoData.middleName.contains("N/A"))
					assertTrue(type(selenium, txtMiddleName, editPatientInfoData.middleName), "Could not Enter middle name, Expected value to be typed" + editPatientInfoData.middleName, selenium, ClassName, MethodName);
			if(!editPatientInfoData.title.isEmpty())
				if(!editPatientInfoData.title.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxTitle, editPatientInfoData.title))	
						Assert.fail("Could not Enter Title, Expected value to be selected" +editPatientInfoData.title);
 			if(!editPatientInfoData.suffix.isEmpty())
				if(!editPatientInfoData.suffix.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxSuffix, editPatientInfoData.suffix))
						Assert.fail("Could not Enter Suffix, Expected value to be selected" + editPatientInfoData.suffix);
			if(!editPatientInfoData.alias1.isEmpty())
				if(!editPatientInfoData.alias1.contains("N/A"))
					assertTrue(type(selenium, txtAlias1, editPatientInfoData.alias1), "Could not Enter alias1, Expected value to be typed" + editPatientInfoData.alias1, selenium, ClassName, MethodName);
			if(!editPatientInfoData.alias2.isEmpty())
				if(!editPatientInfoData.alias2.contains("N/A"))
					assertTrue(type(selenium, txtAlias2, editPatientInfoData.alias2), "Could not Enter alias2, Expected value to be typed" + editPatientInfoData.alias2, selenium, ClassName, MethodName);
			if(!editPatientInfoData.dob.isEmpty())
				if(!editPatientInfoData.dob.contains("N/A"))
					assertTrue(enterDate(selenium, txtDOB, editPatientInfoData.dob), "Could not Enter dob, Expected value to be typed" + editPatientInfoData.dob, selenium, ClassName, MethodName);			
			if(!editPatientInfoData.estimatedCheck.isEmpty())
				if(!editPatientInfoData.estimatedCheck.contains("No"))
					assertTrue(check(selenium, chkDOBEstimated), "Could not check the estimated check box, Expected value for the check box : " + editPatientInfoData.estimatedCheck, selenium, ClassName, MethodName);
			if(!editPatientInfoData.prematureCheck.isEmpty())
				if(!editPatientInfoData.prematureCheck.contains("No"))
				{
					assertTrue(click(selenium, chkPremature), "Could not check the premature check box, Expected value for the check box : " + editPatientInfoData.prematureCheck, selenium, ClassName, MethodName);
					if(!editPatientInfoData.duration.isEmpty())
						if(!editPatientInfoData.duration.contains("N/A"))
							assertTrue(type(selenium, txtPrematureDuration, editPatientInfoData.duration), "Could not Enter duration, Expected value to be typed : " + editPatientInfoData.duration, selenium, ClassName, MethodName);
					if(!editPatientInfoData.measure.isEmpty())
						if(!editPatientInfoData.measure.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxPrematureMeasure, editPatientInfoData.measure))
								Assert.fail("Could not Enter Premature Messure, Expected value to be selected" + editPatientInfoData.measure);
				}
			if(!editPatientInfoData.sex.isEmpty())
				if(!editPatientInfoData.sex.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxSex, editPatientInfoData.sex))
						Assert.fail("Could not Enter Sex, Expected value to be selected" + editPatientInfoData.sex);
			
			if(!editPatientInfoData.maritalStatus.isEmpty())
				if(!editPatientInfoData.maritalStatus.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxmartialStatus, editPatientInfoData.maritalStatus))
						Assert.fail("Could not Enter Marital Status, Expected value to be selected" + editPatientInfoData.maritalStatus);					
			if(!editPatientInfoData.status.isEmpty())
				if(!editPatientInfoData.status.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxStatus, editPatientInfoData.status))
						Assert.fail("Could not Enter Status, For; More Details" + editPatientInfoData.toString());
			if(!editPatientInfoData.statusDate.isEmpty())
				if(!editPatientInfoData.statusDate.contains("N/A"))
					assertTrue(enterDate(selenium, txtStatusDate, editPatientInfoData.statusDate), "Could not Enter statusDate, For; More Details" + editPatientInfoData.toString(), selenium, ClassName, MethodName);
			if(editPatientInfoData.status.equalsIgnoreCase("inactive"))
				if(!editPatientInfoData.reasonForInactivation.isEmpty())
					if(!editPatientInfoData.reasonForInactivation.contains("N/A"))
						if(!selectValueFromAjaxList(selenium, ajxStationInactivation, editPatientInfoData.reasonForInactivation))
							Assert.fail("Could not Enter reason for inactivation, For; More Details" + editPatientInfoData.maritalStatus);					
			if(!editPatientInfoData.residentialAddrStreet1.isEmpty())
				if(!editPatientInfoData.residentialAddrStreet1.contains("N/A"))
					assertTrue(type(selenium, txtResidentAddress1, editPatientInfoData.residentialAddrStreet1), "Could not Enter residential Addr1, Expected value to be typed" + editPatientInfoData.residentialAddrStreet1, selenium, ClassName, MethodName);
			if(!editPatientInfoData.residentialAddrStreet2.isEmpty())
				if(!editPatientInfoData.residentialAddrStreet2.contains("N/A"))
					assertTrue(type(selenium, txtResidentAddress2, editPatientInfoData.residentialAddrStreet2), "Could not Enter residential Addr2, Expected value to be typed" + editPatientInfoData.residentialAddrStreet2, selenium, ClassName, MethodName);
			if(!editPatientInfoData.residentialAddrcity.isEmpty())
				if(!editPatientInfoData.residentialAddrcity.contains("N/A"))
					assertTrue(type(selenium, txtResidentialCity, editPatientInfoData.residentialAddrcity), "Could not Enter city, Expected value to be typed" + editPatientInfoData.residentialAddrcity, selenium, ClassName, MethodName);
			if(!editPatientInfoData.residentialAddrstate.isEmpty())
				if(!editPatientInfoData.residentialAddrstate.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxResidentialState, editPatientInfoData.residentialAddrstate))
						Assert.fail("Could not Enter Residential Addr State, Expected value to be select" + editPatientInfoData.residentialAddrstate);
			if(!editPatientInfoData.residentialAddrzipCode.isEmpty())
				if(!editPatientInfoData.residentialAddrzipCode.contains("N/A"))
					assertTrue(type(selenium, txtResidentialZip, editPatientInfoData.residentialAddrzipCode), "Could not Enter zip code, Expected value to be typed" + editPatientInfoData.residentialAddrzipCode, selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			selenium.keyPress(txtComments, "\\9");
			click(selenium,btnYesButton);
			waitForElementToEnable(selenium,txtResidentialCity);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,ajxResidentialState);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,ajxResidentialCountry);
			waitForPageLoad(selenium);
			
			if(!editPatientInfoData.telephoneType1.isEmpty())
				if(!editPatientInfoData.telephoneType1.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType1, editPatientInfoData.telephoneType1))
						Assert.fail("Could not Enter Telephone Type1, Expected value to be Select" + editPatientInfoData.telephoneType1);
			
			if(!editPatientInfoData.telephoneNo1.isEmpty())
				if(!editPatientInfoData.telephoneNo1.contains("N/A"))
					assertTrue(type(selenium, txtPrimaryPhone, editPatientInfoData.telephoneNo1), "Could not Enter telephone Number, Expected value to be Typed" + editPatientInfoData.telephoneNo1, selenium, ClassName, MethodName);
			if(!editPatientInfoData.telephoneextnNo1.isEmpty())
				if(!editPatientInfoData.telephoneextnNo1.contains("N/A"))
					assertTrue(type(selenium, txtPrimaryPhoneExtn, editPatientInfoData.telephoneextnNo1), "Could not Enter telephone Extn Number, Expected value to be Typed" + editPatientInfoData.telephoneextnNo1, selenium, ClassName, MethodName);
			
			if(!editPatientInfoData.telephoneType2.isEmpty())
				if(!editPatientInfoData.telephoneType2.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType2, editPatientInfoData.telephoneType2))
						Assert.fail("Could not Enter Telephone Type2, Expected value to be Select" + editPatientInfoData.telephoneType2);
			
			if(!editPatientInfoData.telephoneNo2.isEmpty())
				if(!editPatientInfoData.telephoneNo2.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone1, editPatientInfoData.telephoneNo2), "Could not Enter telephone Number, Expected value to be Typed" + editPatientInfoData.telephoneNo2, selenium, ClassName, MethodName);
			if(!editPatientInfoData.telephoneextnNo2.isEmpty())
				if(!editPatientInfoData.telephoneextnNo2.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone1Extn, editPatientInfoData.telephoneextnNo2), "Could not Enter telephone Extn Number, Expected value to be Typed" + editPatientInfoData.telephoneextnNo2, selenium, ClassName, MethodName);
			
			if(!editPatientInfoData.telephoneType3.isEmpty())
				if(!editPatientInfoData.telephoneType3.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxPhoneType3, editPatientInfoData.telephoneType3))
						Assert.fail("Could not Enter Telephone Type3, Expected value to be Select" + editPatientInfoData.telephoneType3);
			
			if(!editPatientInfoData.telephoneNo3.isEmpty())
				if(!editPatientInfoData.telephoneNo3.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone2, editPatientInfoData.telephoneNo3), "Could not Enter telephone Number, Expected value to be Typed" + editPatientInfoData.telephoneNo3, selenium, ClassName, MethodName);
			if(!editPatientInfoData.telephoneextnNo3.isEmpty())
				if(!editPatientInfoData.telephoneextnNo3.contains("N/A"))
					assertTrue(type(selenium, txtOtherPhone2Extn, editPatientInfoData.telephoneextnNo3), "Could not Enter telephone Extn Number, Expected value to be Typed" + editPatientInfoData.telephoneNo3, selenium, ClassName, MethodName);
			
			if(!editPatientInfoData.email.isEmpty())
				if(!editPatientInfoData.email.contains("N/A"))
					assertTrue(type(selenium, txtEmail, editPatientInfoData.email), "Could not Enter email, Expected value to be Typed" + editPatientInfoData.email, selenium, ClassName, MethodName);
			
			
			if(!editPatientInfoData.contactPreferences.isEmpty())
				if(!editPatientInfoData.contactPreferences.contains("N/A"))
					assertTrue(selectValueFromAjaxList(selenium, ajxContactPreference, editPatientInfoData.contactPreferences), "Could not Enter contact preferences, Expected value to be Typed" + editPatientInfoData.email, selenium, ClassName, MethodName);
		
			
			if(!editPatientInfoData.sameAsResidentialAddressCheck.isEmpty()){
				if(!editPatientInfoData.sameAsResidentialAddressCheck.contains("Yes"))
					if(isChecked(selenium,chkMailingAsResidential))
						click(selenium,chkMailingAsResidential);
				else{
				if(!editPatientInfoData.mailingAddressStreet1.isEmpty())
						if(!editPatientInfoData.mailingAddressStreet1.contains("N/A"))
							assertTrue(type(selenium, txtMailingAddress1, editPatientInfoData.mailingAddressStreet1), "Could not Enter Mailing Addr Street1, Expected value to be Typed" + editPatientInfoData.mailingAddressStreet1, selenium, ClassName, MethodName);
					if(!editPatientInfoData.mailingAddressStreet2.isEmpty())
						if(!editPatientInfoData.mailingAddressStreet2.contains("N/A"))
							assertTrue(type(selenium,txtMailingAddress2,editPatientInfoData.mailingAddressStreet2),"Could not Enter Mailing Addr Street2, Expected value to be typed" + editPatientInfoData.mailingAddressStreet2, selenium, ClassName, MethodName);
					if(!editPatientInfoData.mailingAddressCity.isEmpty())
						if(!editPatientInfoData.mailingAddressCity.contains("N/A"))
							assertTrue(type(selenium, txtMailingCity, editPatientInfoData.mailingAddressCity), "Could not Enter Mailing address city, Expected value to be Typed" + editPatientInfoData.mailingAddressCity, selenium, ClassName, MethodName);
						if(!editPatientInfoData.mailingAddressState.isEmpty())
						if(!editPatientInfoData.mailingAddressState.contains("N/A"))
							if(!selectValueFromAjaxList(selenium, ajxMailingState, editPatientInfoData.mailingAddressState))
								Assert.fail("Could not Enter Mailing Address State, Expected value to be selected" + editPatientInfoData.mailingAddressState);			
					if(!editPatientInfoData.mailingAddressZipcode.isEmpty())
						if(!editPatientInfoData.mailingAddressZipcode.contains("N/A"))
							assertTrue(type(selenium, txtMailingZip, editPatientInfoData.mailingAddressZipcode), "Could not Enter Mailing address zip code, Expected value to be Typed" + editPatientInfoData.mailingAddressZipcode, selenium, ClassName, MethodName);					
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
			}
			if(!editPatientInfoData.comments.isEmpty())
				if(!editPatientInfoData.comments.contains("N/A"))
					assertTrue(type(selenium, txtComments, editPatientInfoData.comments), "Could not Enter comments, Expected value to be Selected" + editPatientInfoData.comments, selenium, ClassName, MethodName);			
			click(selenium,btnSave1);
			waitForPageLoad(selenium);
			click(selenium,btnRegistrationEdit);
			waitForPageLoad(selenium);
			if(selenium.isAlertPresent()){
				Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
			}
		
			if(!verifyStoredValuesEditPatientCheckInCA(selenium,editPatientInfoData,uniqueName)){
				Assert.fail("Patient Info details are not edited properly; More Details :"+ editPatientInfoData.toString());
			    returnValue=false;
			}
			else{
				return returnValue;
			}
		
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}

