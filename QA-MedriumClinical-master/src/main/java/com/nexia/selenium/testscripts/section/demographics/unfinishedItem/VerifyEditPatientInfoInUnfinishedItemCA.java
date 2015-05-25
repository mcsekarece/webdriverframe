package com.nexia.selenium.testscripts.section.demographics.unfinishedItem;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditPatientInfoInUnfinishedItemCA extends AbstractHomeTest {
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Edit Patient Info In Unfinished Item")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditPatientInfoInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckInCAView";
		PatientData.testCaseId = "TC_NPC_005";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyEditPatientInfoInUnfinishedItem(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Edit Patient Info In Unfinished Item
	* @action 		  verifying Edit Patient Info In Unfinished Item
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 11, 2013
	***************************************************************************************************/
	public boolean verifyEditPatientInfoInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws Exception{
		Selenium selenium = null;
		String currentUnfinishedItem="Edit Personal Info for";
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete all unfinished item                                //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllUnfinishedItem(selenium),"Could not Delete all unfinished item  :"+ patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to system setting 								  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSetting),"Could not click the systemSettings link;More Deatils:",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Delete All Mandatory data  								  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium), "Could not delete all mandatory fields", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Click New Patient Check-in   							  //
			//--------------------------------------------------------------------//				
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkRegisterPatient), "Could not click on Clinical Lists",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("ddHHmm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createPatientCAView(selenium,patientData,uniqueName),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			click(selenium,btnRegistrationEdit);
			waitForPageLoad(selenium);
			
			if(!verifyStoredValuesEditPatientCheckInCA(selenium,patientData,uniqueName)){
				Assert.fail("Patient details are not saved properly; More Details :"+ patientData.toString());
			}
			
			//--------------------------------------------------------------------//
			//  Step-8: Edit the created patient details  //
			//--------------------------------------------------------------------//
			HomeLib EditPatientData = new HomeLib();
			EditPatientData.workSheetName = "EditPatientCheckInCAView";
			EditPatientData.testCaseId = "TC_EPI_003";
			EditPatientData.fetchHomeTestData();
			waitForPageLoad(selenium);
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
			
			//get the current patient name
			String patientName[]= getText(selenium, lblPatientName).split(",");
			
			//customize the patient name for our need
			String patientNameAltered= patientName[1] +" "+ patientName[0];
			
			//append the patient name with the current unfinished item section
			currentUnfinishedItem= currentUnfinishedItem + patientNameAltered ;
			
			
			//--------------------------------------------------------------------//
			//  Step-9: Store data in unfinished item							  //
			//--------------------------------------------------------------------//
			 if(isElementPresent(selenium, btnErrorClose))
			 {
					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			 }
			assertTrue(click(selenium,btnBackButton),"Could not click Back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose))
			 {
					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			 }
			 if(!isElementPresent(selenium,yesButton))
			 {
				 assertTrue(click(selenium,btnBackButton),"Could not click Back button", selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
			 }
			assertTrue(click(selenium,yesButton),"Could not click Yes button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Navigate to unfinished item							  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToUnfinishedItem(selenium, currentUnfinishedItem),"Could not Navigate to unfinished item; More Details :"+ patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//waitForPageLoad(selenium);
			if(selenium.isAlertPresent()){
				Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
			}
			
			if(!verifyStoredValuesEditPatientCheckInCA(selenium,EditPatientData,uniquedata)){
				Assert.fail("Patient details are not saved properly; More Details :"+ EditPatientData.toString());
			}
			
			waitForPageLoad(selenium);
			// Complete the unfinished item
			click(selenium,btnSave1);
			waitForPageLoad(selenium);
			
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-11: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			click(selenium,btnRegistrationEdit);
			waitForPageLoad(selenium);
			if(selenium.isAlertPresent()){
				Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
			}
		
			if(!verifyStoredValuesEditPatientCheckInCA(selenium,EditPatientData,uniquedata)){
				Assert.fail("Patient details are not edited properly; More Details :"+ EditPatientData.toString());
			}
			click(selenium,btnSave1);
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

