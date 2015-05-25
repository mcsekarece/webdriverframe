package com.nexia.selenium.testscripts.section.demographics.unfinishedItem;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditIdentifierInUnfinishedItem extends AbstractHomeTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying create Identifier")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib identifierTestData = new HomeLib();
		identifierTestData.workSheetName = "CreateIdentifiers";
		identifierTestData.testCaseId = "TC_ID_001";
		identifierTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyCreateIdentifierInUnfinishedItem(seleniumHost, seleniumPort, browser, webSite, userAccount, identifierTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose       verify Add Identfier In UnfinishedItem
	* @action 		 verify Add Identfier In UnfinishedItem
	* @author        Aspire QA
	* @state         developing
	* @useraccount   Both
	* @since  	     July 10, 2013
	***************************************************************************************************/
	
	public boolean verifyCreateIdentifierInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib identifierData) throws Exception{
		Selenium selenium = null;
		String currentUnfinishedItem="Edit Identifiers for";
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + identifierData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, identifierData.userName, identifierData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,identifierData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete all unfinished item                                //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllUnfinishedItem(selenium),"Could not Delete all unfinished item  :"+ identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID //
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,identifierData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkIdentifier);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Deleting existing identifier for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllIdentifiers(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Create a new Identifier //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddIdentifier),"Could not click on Add Identifers Button:"+identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createIdentifierCAView(selenium,identifierData,userAccount),"identifier creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			click(selenium,lnkEditIdentifier);
			waitForPageLoad(selenium);
			
			identifierData.workSheetName = "CreateIdentifiers";
			identifierData.testCaseId = "TC_ID_009";
			identifierData.fetchHomeTestData();
			
			assertTrue(createIdentifierCAView(selenium,identifierData,userAccount),"identifier creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Store data in unfinished item							  //
			//--------------------------------------------------------------------//
			assertTrue(storeDataInUnfinishedItem(selenium),"Could not Store data in unfinished item; More Details :"+ identifierData.toString(), selenium, ClassName, MethodName);
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
			
			assertTrue(navigateToUnfinishedItem(selenium, currentUnfinishedItem),"Could not Navigate to unfinished item; More Details :"+ identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Complete the unfinished item
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + identifierData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
			catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return true;
		}
}
