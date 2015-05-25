package com.nexia.selenium.testscripts.section.demographics.Contacts;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectOptionsInContacts extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying select options in Contact")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySelectOptionsInContacts(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib ContactData = new HomeLib();
		ContactData.workSheetName = "CreateNewContact";
		ContactData.testCaseId = "TC_CPC_016";
		ContactData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySelectOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactData);
	}
	/**
	 * verifySelectOptions
	 * function to verify the selected option in the select fields
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    July 06, 2010
	 */
	
	public boolean verifySelectOptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib ContactData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=false;
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
		
			waitForElement(selenium, registerPatient, 4000);
			waitForPageLoad(selenium);
			searchPatientNexia(selenium,ContactData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkContactList);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Deleting existing contacts for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllContact(selenium),"Contact details not saved properly; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-5: Create a new Contact //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnAddContact),"Could not Click on Add Contacts Contacts Button:"+ ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(verifySelectOptionsInContacts(selenium,ContactData,userAccount),"Selected options are not displaying properly", selenium, ClassName, MethodName);
				returnValue=true;
			waitForPageLoad(selenium);	
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
