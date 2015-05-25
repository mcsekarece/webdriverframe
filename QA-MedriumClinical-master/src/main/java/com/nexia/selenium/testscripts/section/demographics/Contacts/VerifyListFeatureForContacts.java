package com.nexia.selenium.testscripts.section.demographics.Contacts;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyListFeatureForContacts extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the feature List For Contacts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewContactForPatientWithMandatoryFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib ContactData = new HomeLib();
		ContactData.workSheetName = "CreateNewContact";
		ContactData.testCaseId = "TC_CPC_013";
		ContactData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createContactWithMandatoryFields(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify the feature List For Contacts
	* @action 		  Verifying the feature List For Contacts
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 06, 2012
	***************************************************************************************************/
	public boolean createContactWithMandatoryFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib ContactData) throws Exception{
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
			//step-5:Verify the list feature is invisible for empty page	//
			//--------------------------------------------------------------------//
			if(!isElementPresent(selenium, lnkExpandAll))
				assertTrue(getText(selenium, lblNoContactDetailsAdded).equalsIgnoreCase("No contacts added."),"Expand all is present in contact summary Page after deleted the existing contacts", selenium, ClassName, MethodName);
				returnValue = true;
			
			//--------------------------------------------------------------------//
			//  Step-6: Create a new Contact //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddContact),"Could not Click on Add Contacts Contacts Button:"+ ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(createContactWithMandatory(selenium,ContactData,userAccount),"First Contact details not saved properly; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkExpandAll);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, lnkCollapseAll),"Collapse all is not present in contact summary page after Clicked Expand all", selenium, ClassName, MethodName);
			
			ContactData.workSheetName = "CreateNewContact";
			ContactData.testCaseId = "TC_CPC_005";
			ContactData.fetchHomeTestData();
			
			//--------------------------------------------------------------------//
			//  Step-7: Create a new Contact //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnAddContact),"Could not Click on Add Contacts Contacts Button:"+ ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(createContactWithMandatory(selenium,ContactData,userAccount),"Third Contact details not saved properly; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  step-8:Verify Expand all is displayed or not in summary page	//
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lnkExpandAll),"Expand all is not present in contact summary page", selenium, ClassName, MethodName);
			return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
