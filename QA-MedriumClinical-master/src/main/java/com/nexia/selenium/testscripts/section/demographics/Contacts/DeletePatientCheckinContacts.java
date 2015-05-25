package com.nexia.selenium.testscripts.section.demographics.Contacts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class DeletePatientCheckinContacts extends AbstractHomeTest {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting a New patient Contact")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteNewContactForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib ContactData = new HomeLib();
		ContactData.workSheetName = "CreateNewContact";
		ContactData.testCaseId = "TC_CPC_007";
		ContactData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		deleteContact(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Deleting a New patient Contact
	* @action 		  Verifying Deleting a New patient Contact 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 23, 2010
	***************************************************************************************************/
	public boolean deleteContact(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib ContactData) throws InterruptedException, IOException{
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
			
			//Advanced search with Patient ID
			searchPatientNexia(selenium,ContactData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkContactList);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Deleting existing contacts for the selected patient  //
			//--------------------------------------------------------------------//			
			assertTrue(deleteAllContact(selenium),"Contact details not saved properly; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create a new Contact if no contacts available to delete //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddContact),"Could not Click on Add Contacts Contacts Button:"+ ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(createContact(selenium,ContactData, userAccount),"Contact creation Failed", selenium, ClassName, MethodName);
			click(selenium,lnkEditContact);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete patient Contact //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValuesDeleteContact(selenium,ContactData),"Contact details not Deleted properly; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
					click(selenium,btnCancl);
					waitForPageLoad(selenium);
					assertTrue(deleteAllContact(selenium),"Contact details not saved properly; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName); ;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
