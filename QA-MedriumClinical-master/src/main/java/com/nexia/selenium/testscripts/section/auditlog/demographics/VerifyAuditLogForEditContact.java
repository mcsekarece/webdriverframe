package com.nexia.selenium.testscripts.section.auditlog.demographics;



import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForEditContact extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a New patient Contact")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void editContactForPatient(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib ContactData = new AuditLogLib();
		ContactData.workSheetName = "AuditLogForContact";
		ContactData.testCaseId = "TC_ALCont_001";
		ContactData.fetchHomeTestData();
		editContact(seleniumHost, seleniumPort, browser, webSite,userAccount, ContactData);
	}
	/**
	 * editContact
	 * function to editContact
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    July 217, 2012
	 */
	public boolean editContact(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib ContactData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ContactData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, ContactData.userName, ContactData.userPassword),"Login Failed ");
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,ContactData.switchRole));
			waitForPageLoad(selenium);
			//Advanced search with Patient ID
			
			searchPatientNexia(selenium,ContactData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,"!patientContactsList");
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-2: Deleting existing contacts for the selected patient  //
			//--------------------------------------------------------------------//
			int counter = (Integer) selenium.getXpathCount("//div[@id='PatientContactList']/table/tbody/tr/td[3]/div/a");
			while(isElementPresent(selenium,"//div[@id='PatientContactList']/table/tbody/tr["+counter+"]/td[3]/div/a")){
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"//div[@id='PatientContactList']/table/tbody/tr["+counter+"]/td[3]/div/a"),"Could not Click on delete Button:"+ ContactData.toString());
			waitForPageLoad(selenium);
			click(selenium,"yesButton");
			waitForPageLoad(selenium);
			int countAfterDeletion = (Integer) selenium.getXpathCount("//div[@id='PatientContactList']/table/tbody/tr/td[3]/div/a");
			if((counter==countAfterDeletion) && (countAfterDeletion!=0)){
				Assert.fail("Could not Delete the Contact;More Details:"+ContactData.toString());
			}
			waitForPageLoad(selenium);
			counter--;
			}
			//--------------------------------------------------------------------//
			//  Step-3: Create a new Contact //
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(click(selenium,"addContact"),"Could not Click on Add Contacts Contacts Button:"+ ContactData.toString());
			Assert.assertTrue(createContact(selenium,ContactData),"Contact details not saved properly; More Details :"+ ContactData.toString());
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Edit Contact //
			//--------------------------------------------------------------------//
			ContactData.workSheetName = "AuditLogForContact";
			ContactData.testCaseId = "TC_ALCont_002";
			ContactData.fetchHomeTestData();

			Assert.assertTrue(check(selenium, "guardiancheckbox"), "Could not check the contact type, " + ContactData.toString());
			selectValueFromAjaxList(selenium, "relationshipsuggestBox", ContactData.relationship);
			selectValueFromAjaxList(selenium, "titlesuggestBox",ContactData.title);
			Assert.assertTrue(type(selenium, "lastName", ContactData.lastName),"Could not enter Last Name; More Details:" + ContactData.toString());
			Assert.assertTrue(type(selenium, "firstName", ContactData.firstName),"Could not enter First Name; More Details:" + ContactData.toString());
			selectValueFromAjaxList(selenium,"suffixsuggestBox",ContactData.suffix);
			Assert.assertTrue(type(selenium, "email", ContactData.email),"Could not enter Email; More Details:" + ContactData.toString());
			selectValueFromAjaxList(selenium, "languagesuggestBox",ContactData.languageSpoken);
			Assert.assertTrue(type(selenium, "comments", ContactData.comments), "Could not Enter comments, Expected value to be Selected" + ContactData.comments);
			Assert.assertTrue(type(selenium, "contactAddr1", ContactData.residentialAddrStreet1),"Could not enter Residential Address; More Details:" + ContactData.toString());
			Assert.assertTrue(type(selenium, "contactAddr2", ContactData.residentialAddrStreet2),"Could not enter Residential Address; More Details:" + ContactData.toString());
			Assert.assertTrue(type(selenium, "//div[2]/div/div/div[2]/div/input", ContactData.residentialAddrcity),"Could not enter City; More Details:" + ContactData.toString());
			selectValueFromAjaxList(selenium, "contactStatesuggestBox",ContactData.residentialAddrstate);
			Assert.assertTrue(type(selenium, "contactZip", ContactData.residentialAddrzipCode),"Could not enter Zip; More Details:" + ContactData.toString());
			selenium.keyPress("commType1suggestBox", "\\9");
			click(selenium,"yesButton");
			waitForPageLoad(selenium);
			Assert.assertTrue(type(selenium, "xpath=(//input[@type='text'])[19]", ContactData.county),"Could not enter County; More Details:" + ContactData.toString());
			selectValueFromAjaxList(selenium, "commType1suggestBox",ContactData.telephoneType1);
			Assert.assertTrue(type(selenium, "primaryPhone", ContactData.telephoneNo1),"Could not enter phone number; More Details:" + ContactData.toString());
			Assert.assertTrue(type(selenium, "primaryPhoneExt", ContactData.telephoneextnNo1),"Could not enter extn number; More Details:" + ContactData.toString());
			selectValueFromAjaxList(selenium, "commType2suggestBox",ContactData.telephoneType2);
			Assert.assertTrue(type(selenium, "secondaryPhone", ContactData.telephoneNo2),"Could not enter Phone number; More Details:" + ContactData.toString());
			Assert.assertTrue(type(selenium, "secondaryPhoneExt", ContactData.telephoneextnNo2),"Could not enter extn number; More Details:" + ContactData.toString());
			selectValueFromAjaxList(selenium, "commType3suggestBox",ContactData.telephoneType3);
			Assert.assertTrue(type(selenium, "tertiaryPhone", ContactData.telephoneNo3),"Could not enter Fax number; More Details:" + ContactData.toString());
			Assert.assertTrue(type(selenium, "tertiaryPhoneExt", ContactData.telephoneextnNo3),"Could not enter extn number; More Details:" + ContactData.toString());
			Assert.assertTrue(click(selenium, "save"),"Could not find save button; More Details:" + ContactData.toString());
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Go to System Settings and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step-5: Verify Audit log for Program
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"!audit"),"Could not click on Audit log link:" +  ContactData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(auditLog(selenium, ContactData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify whether Program gets saved properly //
			//--------------------------------------------------------------------//
			Assert.assertTrue(verifyStoredValue(selenium, ContactData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			if(!verifyStoredOldValues(selenium,ContactData)){
				Assert.fail("User details not saved properly; More Details :"+ ContactData.toString());
				returnValue=false;
			}
			if(!verifyStoredNewValues(selenium,ContactData)){
				Assert.fail("User details not saved properly; More Details :"+ ContactData.toString());
				returnValue=false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());
		}
		return returnValue;
	}
	
	public boolean verifyStoredOldValues(Selenium selenium,AuditLogLib auditData){
		
		if(!getText(selenium,"collapsableDesc").trim().contains(auditData.programId)){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(auditData.departmentId)){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(auditData.startdate)){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(auditData.endDate)){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.priorstate.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.outcome.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.userName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
	public boolean verifyStoredNewValues(Selenium selenium,AuditLogLib auditData){
		if(!getText(selenium,"collapsableDesc").trim().contains(auditData.startdate1)){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(auditData.endDate1)){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.priorstate1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.outcome1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.userName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
