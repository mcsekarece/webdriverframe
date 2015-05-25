package com.nexia.selenium.testscripts.section.demographics.RecordLocking;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;


import com.thoughtworks.selenium.Selenium;

public class VerifyRecordLockingEditNotes extends AbstractHomeTest {
	
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Record Locking Edit in Notes")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecordLockingEditNotes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib noteData=new HomeLib();
		noteData.workSheetName="createNewNote";
		noteData.testCaseId="TC_NO_015";
		noteData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNotes(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Record Locking Delete in Notes")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecordLockingDeleteNotes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib noteData=new HomeLib();
		noteData.workSheetName="createNewNote";
		noteData.testCaseId="TC_NO_016";
		noteData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNotes(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Record Locking Edit in Notes
	* @action 		  Verifying Record Locking Edit in Notes
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 17, 2013
	***************************************************************************************************/
	public boolean createNotes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib noteData) throws Exception{
		Selenium selenium = null;
		boolean recordLockedEdit=true;
		boolean recordLockedDelete=true;
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
		
			click(selenium,"securitySettings");
			waitForPageLoad(selenium);
			click(selenium,"!recordLockingMain");
			waitForPageLoad(selenium);
			click(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div[3]/div[2]/div/div/div/div/a");
			waitForPageLoad(selenium);
			if( selenium.isVisible("css=input[type=\"checkbox\"]")){
				click(selenium,"css=input[type=\"checkbox\"]");
				click(selenium,"link=Unlock");
				click(selenium,"yesButton");
			}
			
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
			//assertTrue(deleteAllNotes(selenium),"", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-6: Create a new Note //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddNote),"Could not click on add Note button:"+noteData.toString(), selenium, ClassName, MethodName);
			assertTrue(createNotes(selenium,noteData, userAccount),"Note creation Failed", selenium, ClassName, MethodName);
			
			if(noteData.testCaseId.equalsIgnoreCase("TC_NO_015")){
				Thread.sleep(15000);
				click(selenium,lnkEditNotes);
				
				if(isElementPresent(selenium,"css=button.secondary-button.absoluteTopRight")){
					System.out.println(getText(selenium, "css=span.gwt-InlineHTML"));
					if(!(getText(selenium, "css=span.gwt-InlineHTML").contains("This record is in use by "))){
						recordLockedEdit=false;
					}
				}
				else{
					recordLockedEdit=false;
				}
				
				waitForPageLoad(selenium);
			}
			else{
				//assertTrue(deleteAllNotes(selenium),"", selenium, ClassName, MethodName);
				
				assertTrue(click(selenium,lnkDeleteNotes),"Could not click Delete notes", selenium, ClassName, MethodName);
				Thread.sleep(20000);
				if(isElementPresent(selenium,"css=div.gwt-Label")){
					System.out.println(getText(selenium, "css=div.gwt-Label"));
					if(!(getText(selenium, "css=div.gwt-Label").contains("This record cannot be deleted. It is in use by "))){
						recordLockedDelete=false;
					}
				}
				else{
					recordLockedDelete=false;
				}
				waitForPageLoad(selenium);
				
			}
			
			
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + noteData.toString());
			
		}
		
		
		//check record atleast locked by edit or delete
		System.out.println(recordLockedDelete);
		System.out.println(recordLockedEdit);
		if(recordLockedEdit || recordLockedDelete){
			return true;
		}
		else {
			return false;
		}
	}

}

