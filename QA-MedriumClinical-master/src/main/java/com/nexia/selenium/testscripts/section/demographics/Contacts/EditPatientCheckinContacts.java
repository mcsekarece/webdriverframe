package com.nexia.selenium.testscripts.section.demographics.Contacts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;
public class EditPatientCheckinContacts extends AbstractHomeTest {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Edit patient check in Contacts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editContactForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib ContactData = new HomeLib();
		ContactData.workSheetName = "CreateNewContact";
		ContactData.testCaseId = "TC_CPC_008";
		ContactData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		editContact(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Edit patient check in Contacts
	* @action 		  Verifying Edit patient check in Contacts 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 23, 2010
	***************************************************************************************************/
	public boolean editContact(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib ContactData) throws InterruptedException, IOException{
		Selenium selenium = null;
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ContactData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, ContactData.userName, ContactData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,ContactData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Advanced search with Patient ID //
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,ContactData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkContactList);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Deleting existing contacts for the selected patient  //
			//--------------------------------------------------------------------//			
			assertTrue(deleteAllContact(selenium),"Contact details not saved properly; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create a new Contact if no contacts available to delete //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddContact),"Could not Click on Add Contacts Contacts Button:"+ ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(createContact(selenium,ContactData, userAccount),"Contact creation Failed; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-6:Edit patient Contact //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkEditContact),"Could not Click on Edit Button:"+ ContactData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//HomeLib EditContactData = new HomeLib();
			
			ContactData.workSheetName = "EditContact";
			ContactData.testCaseId = "TC_EPC_001";
			ContactData.fetchHomeTestData();

			assertTrue(check(selenium, chkGuardian), "Could not check the contact type, " + ContactData.toString(), selenium, ClassName, MethodName);
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
			selectValueFromAjaxList(selenium, ajkContactState,ContactData.residentialAddrstate);
			if(userAccount.equals(CAAccount)){
					assertTrue(type(selenium, txtContactZipCode, ContactData.residentialAddrzipCodeCA),"Could not enter Zip; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);	
			}else{
				assertTrue(type(selenium, txtContactZipCode, ContactData.residentialAddrzipCode),"Could not enter Zip; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);	
			}
			selenium.keyPress(ajkPrimPhone1, "\\9");
			click(selenium,btnYesButton);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, ajkContactCountry, ContactData.county),"Could not enter County; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkPrimPhone1,ContactData.telephoneType1);
			assertTrue(type(selenium, txtPrimaryPhone, ContactData.telephoneNo1),"Could not enter phone number; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtPrimPhoneExtn, ContactData.telephoneextnNo1),"Could not enter extn number; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkPrimPhone2,ContactData.telephoneType2);
			assertTrue(type(selenium, txtSecPhone, ContactData.telephoneNo2),"Could not enter Phone number; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtSecPhoneExtn, ContactData.telephoneextnNo2),"Could not enter extn number; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkPrimPhone3,ContactData.telephoneType3);
			assertTrue(type(selenium, txtTertiaryPhone, ContactData.telephoneNo3),"Could not enter Fax number; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtTertiaryPhoneExtn, ContactData.telephoneextnNo3),"Could not enter extn number; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Edit patient Contact //
			//--------------------------------------------------------------------//
			if(selenium.isAlertPresent())
			Assert.assertFalse(selenium.isAlertPresent(),"Contact not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
			waitForPageLoad(selenium);
			
			click(selenium,lnkEditContact);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify stroe Values //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValuesEditContact(selenium,ContactData),"Contact details are not edited properly; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
				return returnValue;
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}

