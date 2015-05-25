package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class DuplicateNewPatientCheckinInfo extends AbstractHomeTest{
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing patient Info") 
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void duplicatePatientForPatientInfo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "NewPatientCheckIn";
		patientData.testCaseId = "TC_NPC_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		duplicatePatientInfo(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Duplicate New Patient Checkin Info
	* @action 		  verifying Duplicate New Patient Checkin Info
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 06, 2012
	***************************************************************************************************/
	public boolean duplicatePatientInfo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
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
			//  Step-3: Navigate to system setting 								  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkQuickLink),"Could not click Quick Link", selenium, ClassName, MethodName);
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
			//  Step-5: Create a new Patient
			//--------------------------------------------------------------------//
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickLink),"Could not click Quick Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkRegisterPatient),"Could not click Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtChartNumber,patientData.patientIdchart),"Could not Enter the chart number;More Details:"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,ajxPrimaryLocation);
			selenium.clickAt(ajxPrimaryLocation, "");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnBack)){
				click(selenium,btnBack);
			}else{
				Assert.fail("Can create Duplicate patient chart :" + patientData.toString());
			}
	
			selectValueFromAjaxList(selenium,ajxPrimaryLocation,patientData.primaryLocation);
			selectValueFromAjaxList(selenium,ajxResponsbleProvider,patientData.responsibleProvider);
			assertTrue(click(selenium,chkResponsibleProvider),"Could not click the responsible provider check box;More Details:"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not enter the last name;More Details"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not enter the last name;More Details"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMiddleName,patientData.middleName),"Could not Enter the Middle name; More Details"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAlias1,patientData.alias1),"Could not enter the alias1;More Details"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAlias2,patientData.alias2),"Could not Enter the alias2; More Details"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtDOB,patientData.dob),"Could not enter date; More Details:"+patientData.toString(), selenium, ClassName, MethodName);
			click(selenium,btnBack);
			assertTrue(click(selenium,chkDOBEstimated),"Could not click Estimated check box; More Details:"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,chkPremature),"Could not click premature check box; More Details:"+patientData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,txtPrematureDuration,patientData.duration);
			selectValueFromAjaxList(selenium,ajxPrematureMeasure,patientData.measure);
			selectValueFromAjaxList(selenium,ajxSex,patientData.sex); 
			selectValueFromAjaxList(selenium,ajxmartialStatus,patientData.maritalStatus);
			selectValueFromAjaxList(selenium,ajxStatus,patientData.status);
			assertTrue(enterDate(selenium,txtStatusDate,patientData.statusDate),"Could not enter date; More Details:"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtResidentAddress1,patientData.residentialAddrStreet1),"Could not enter the Address Street one ;More Details"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtResidentAddress2,patientData.residentialAddrStreet2),"Could not enter the Address Street two;More Details"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtResidentialCity,patientData.residentialAddrcity),"Could not enter the residential city;More Details"+patientData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxResidentialState,patientData.residentialAddrstate);
			assertTrue(type(selenium,txtResidentialZip,patientData.residentialAddrzipCode),"Could not enter the residential city;More Details"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
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
			selectValueFromAjaxList(selenium,ajxPhoneType1,patientData.telephoneType1);
			assertTrue(type(selenium,txtPrimaryPhone,patientData.telephoneNo1),"Could not Enter telephone Number, Expected value to be Typed" + patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPrimaryPhoneExtn,patientData.telephoneextnNo1),"Could not Enter telephone Exten Number; More Details"+patientData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxPhoneType2,patientData.telephoneType2);
			assertTrue(type(selenium,txtOtherPhone1,patientData.telephoneNo2),"Could not Enter telephone Number, Expected value to be Typed" + patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOtherPhone1Extn,patientData.telephoneextnNo2),"Could not Enter telephone Exten Number; More Details"+patientData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxPhoneType3,patientData.telephoneType3);
			assertTrue(type(selenium,txtOtherPhone2,patientData.telephoneNo3),"Could not Enter telephone Number, Expected value to be Typed" + patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOtherPhone2Extn,patientData.telephoneextnNo3),"Could not Enter telephone Exten Number; More Details"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtEmail,patientData.email),"Could not Enter telephone Exten Number; More Details"+patientData.toString(), selenium, ClassName, MethodName);
			click(selenium,chkMailingAsResidential);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtMailingAddress1,patientData.mailingAddressStreet1),"Could not Enter Mailing Address Street one, Expected value to be Typed" + patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingAddress2,patientData.mailingAddressStreet2),"Could not Enter Mailing Address Street two; More Details"+patientData.toString(), selenium, ClassName, MethodName);assertTrue(type(selenium,txtOtherPhone1,patientData.telephoneNo2),"Could not Enter telephone Number, Expected value to be Typed" + patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingCity,patientData.mailingAddressCity),"Could not Enter Mailing city; More Details"+patientData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxMailingState,patientData.mailingAddressState);
			assertTrue(type(selenium,txtMailingZip,patientData.mailingAddressZipcode),"Could not enter the mail zip code ; More Details "+patientData.toString(), selenium, ClassName, MethodName);
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
			assertTrue(type(selenium,txtComments,patientData.comments),"Could not enter the comments ; More Details "+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave1),"Could not Click Save button;More details"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnRegistrationEdit),"could not click edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesPatientInfoDuplicate(selenium,patientData)){
				Assert.fail("Patient details are not Create properly; More Details :"+ patientData.toString());
				returnValue=false;
			}
			else{
				return returnValue;
				}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
