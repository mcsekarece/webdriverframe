package com.nexia.selenium.testscripts.section.demographics.unfinishedItem;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAddNotesInUnfinishedItem extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Add Notes In Unfinished Item")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAddNotesInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib noteData=new HomeLib();
		noteData.workSheetName="createNewNote";
		noteData.testCaseId="TC_NO_007";
		noteData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAddNotesInUnfinishedItem(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Add Notes In Unfinished Item
	* @action 		  verifying Add Notes In Unfinished Item
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 08, 2013
	***************************************************************************************************/
	public boolean verifyAddNotesInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib noteData) throws Exception{
		Selenium selenium = null;
		String currentUnfinishedItem="Add Notes for";
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + noteData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, noteData.userName, noteData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,noteData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Delete all unfinished item                                //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllUnfinishedItem(selenium),"Could not Delete all unfinished item  :"+ noteData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to patient Note  //
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,noteData.patientID);
			waitForPageLoad(selenium);
			click(selenium,lnkNotes);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Deleting existing note for the selected patient  //
			//--------------------------------------------------------------------//
			
			assertTrue(deleteAllNotes(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-6: Create a new Note //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddNote),"Could not click on add Note button:"+noteData.toString(), selenium, ClassName, MethodName);
			assertTrue(createNotes(selenium,noteData, userAccount),"Note creation Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Store data in unfinished item							  //
			//--------------------------------------------------------------------//
			assertTrue(storeDataInUnfinishedItem(selenium),"Could not Store data in unfinished item; More Details :"+ noteData.toString(), selenium, ClassName, MethodName);
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
			
			assertTrue(navigateToUnfinishedItem(selenium, currentUnfinishedItem),"Could not Navigate to unfinished item; More Details :"+ noteData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValuesNotes(selenium,noteData, userAccount),"Notes details not saved properly; More Details :"+ noteData.toString(),selenium, ClassName, MethodName);
			
			// Complete the unfinished item
			assertTrue(click(selenium,btnSave),"Could not click save button; More Details:"+noteData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-10: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkEditNotes),"Could not click the edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyStoredValuesNotes(selenium,noteData, userAccount),"Notes details not saved properly; More Details :"+ noteData.toString(),selenium, ClassName, MethodName);
		
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + noteData.toString());
		}
			
		return true;
		}

	}
