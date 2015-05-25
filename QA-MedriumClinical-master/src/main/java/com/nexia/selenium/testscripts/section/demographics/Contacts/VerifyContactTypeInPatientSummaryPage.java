package com.nexia.selenium.testscripts.section.demographics.Contacts;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyContactTypeInPatientSummaryPage extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Contact type in summary page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyContactForPatientInFoSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib ContactData = new HomeLib();
		ContactData.workSheetName = "CreateNewContact";
		ContactData.testCaseId = "TC_CPC_003";
		ContactData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyContactForSummaryPage(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Contact type in summary page
	* @action 		  Verifying Contact type in summary page
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 02, 2010
	***************************************************************************************************/
	public boolean verifyContactForSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib ContactData) throws Exception{
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
			//  Step-5: Create a new Contact //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddContact),"Could not Click on Add Contacts Contacts Button:"+ ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(verifyContactWithSummaryPage(selenium,ContactData),"Contact details not saved properly; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Go to Summary Page //
			//--------------------------------------------------------------------//
			click (selenium,lnkPatientInfoSummary);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Contact details in summary Page //
			//--------------------------------------------------------------------//
			assertTrue(verifyContactValuesInPatientInfoSummary(selenium,ContactData),"Contacts details not saved properly in summary section; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
