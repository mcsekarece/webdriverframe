package com.nexia.selenium.testscripts.section.demographics.Contacts;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class DuplicateNewPatientCheckInContacts extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Duplicate New patient check in Contact")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void duplicateContactForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib dContactData = new HomeLib();
		dContactData.workSheetName = "DuplicateContact";
		dContactData.testCaseId = "TC_CPC_001";
		dContactData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		duplicateContact(seleniumHost, seleniumPort, browser, webSite, userAccount, dContactData);
	}
		
	/*************************************************************************************************** 
	* @purpose        To Verify Duplicate New patient check in Contact
	* @action 		  Verifying Duplicate New patient check in Contact 
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 02, 2012
	***************************************************************************************************/
	public boolean duplicateContact(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib dContactData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + dContactData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, dContactData.userName, dContactData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,dContactData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Advanced search with Patient ID
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			searchPatientNexia(selenium,dContactData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkContactList);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Deleting existing Contacts for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllContact(selenium),"Contact details not saved properly; More Details :"+ dContactData.toString(), selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-4: Step-3: Create a new Contact   //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddContact),"Could not Click on Add Contacts Contacts Button:"+ dContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(duplicateContact(selenium,dContactData),"Contact creation Failed", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddContact),"Could not Click on Add Contacts Contacts Button:"+ dContactData.toString(), selenium, ClassName, MethodName);
			
			if(!duplicateContact(selenium, dContactData)){
				if(isElementPresent(selenium,btnErrorClose)){
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnErrorClose),"Could not click error close button"+dContactData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				dContactData.workSheetName = "DuplicateContact";
				dContactData.testCaseId = "TC_CPC_002";
				dContactData.fetchHomeTestData();
				waitForPageLoad(selenium);
				if(dContactData.guarantor.equals("Yes") || dContactData.guarantor.equals("checked") ){
					assertTrue(click(selenium,chkGuarantor),"Could not check gurantor;More Details:"+dContactData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				if(dContactData.eContact.equals("yes")|| dContactData.eContact.equals("checked")){
					assertTrue(click(selenium,chkEmergencyContact),"Could not check eContact;More Details:"+dContactData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				if(dContactData.guardian.equals("yes")|| dContactData.guardian.equals("checked")){
					assertTrue(click(selenium,chkGuardian),"Could not check guardianr;More Details:"+dContactData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			   if(dContactData.sdMarker.equals("yes")|| dContactData.sdMarker.equals("checked")){
					assertTrue(click(selenium,chkSubDesicionMaker),"Could not check sdMaker;More Details:"+dContactData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			 if(dContactData.other.equals("yes")|| dContactData.other.equals("checked")){
					assertTrue(click(selenium,"othercheckbox"),"Could not check gurantor;More Details:"+dContactData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajkRelationship, dContactData.relationship);
				assertTrue(type(selenium, txtLastName, dContactData.lastName),"Could not enter Last Name; More Details:" + dContactData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtFirstName, dContactData.firstName),"Could not enter First Name; More Details:" + dContactData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + dContactData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium, lblTitle),"Could not find Title", selenium, ClassName, MethodName);
					return true;
							
			}else{
				Assert.fail("Can create Duplicate Programs :" + dContactData.toString());
			}	
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}

