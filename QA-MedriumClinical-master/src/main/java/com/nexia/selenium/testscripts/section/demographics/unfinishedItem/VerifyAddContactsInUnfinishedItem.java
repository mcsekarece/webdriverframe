package com.nexia.selenium.testscripts.section.demographics.unfinishedItem;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAddContactsInUnfinishedItem extends AbstractHomeTest {
		
		@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Contact in unfinished item")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void verifyAddContactsInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			HomeLib ContactData = new HomeLib();
			ContactData.workSheetName = "CreateNewContact";
			ContactData.testCaseId = "TC_CPC_009";
			ContactData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			verifyAddContactsInUnfinishedItem(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactData);
		}

		/*************************************************************************************************** 
		* @purpose        To verify Add contact in unfinished item
		* @action 		  Verifying Add contact in unfinished item
		* @author         Aspire QA
		* @state          developing
		* @useraccount    Both
		* @since  	      July 08, 2013
		***************************************************************************************************/
		public boolean verifyAddContactsInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib ContactData) throws Exception{
			Selenium selenium = null;
			String currentUnfinishedItem="Add Contacts for";
			
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
				//  Step-3: Delete all unfinished item                                //
				//--------------------------------------------------------------------//
				assertTrue(deleteAllUnfinishedItem(selenium),"Could not Delete all unfinished item  :"+ ContactData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-4: Advanced search with Patient ID //
				//--------------------------------------------------------------------//
				searchPatientNexia(selenium,ContactData.patientID);
				waitForPageLoad(selenium);
				
				click(selenium,lnkContactList);
				waitForPageLoad(selenium);

				//--------------------------------------------------------------------//
				//  Step-5: Deleting existing contacts for the selected patient  //
				//--------------------------------------------------------------------//
				assertTrue(deleteAllContact(selenium),"Contact details not saved properly; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-6: Create a new Contact //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,btnAddContact),"Could not Click on Add Contacts Contacts Button:"+ ContactData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createContact(selenium,ContactData, userAccount),"Contact details not saved properly; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-7: Store data in unfinished item							  //
				//--------------------------------------------------------------------//
				assertTrue(storeDataInUnfinishedItem(selenium),"Could not Store data in unfinished item; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-8: Navigate to unfinished item							  //
				//--------------------------------------------------------------------//
				//get the current patient name
				String patientName[]= getText(selenium, lblPatientName).split(",");
				
				//customize the patient name for our need
				String patientNameAltered= patientName[1] +" "+ patientName[0];
				
				//append the patient name with the current unfinished item section
				currentUnfinishedItem= currentUnfinishedItem + patientNameAltered ;
				
				assertTrue(navigateToUnfinishedItem(selenium, currentUnfinishedItem),"Could not Navigate to unfinished item; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-9: Verifying Entered Details are saved properly  //
				//--------------------------------------------------------------------//
				assertTrue(verifyStoredValuesAddContact(selenium,ContactData,userAccount),"Contacts details not saved properly in contacts page :"+ ContactData.toString(), selenium, ClassName, MethodName);
				
				// Complete the unfinished item
				assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ContactData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//---------------------------------------------------------------------------//
				//  Step-10: Verifying Completed unfinished item Details are saved properly  //
				//---------------------------------------------------------------------------//
				assertTrue(verifyStoredValuesInSummaryAddContact(selenium,ContactData, userAccount),"Contacts details not saved properly in summary section; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);		
			}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return true;
		}

}
