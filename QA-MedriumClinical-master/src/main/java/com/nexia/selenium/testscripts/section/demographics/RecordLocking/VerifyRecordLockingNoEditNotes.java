package com.nexia.selenium.testscripts.section.demographics.RecordLocking;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;


import com.thoughtworks.selenium.Selenium;

public class VerifyRecordLockingNoEditNotes extends AbstractHomeTest {
	private boolean editCompleted=false;
	private boolean processCompleted=false;
	
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
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Record Locking Edit in Notes")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecordLockingEdit1Notes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
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
	* @since  	      July 22, 2013
	***************************************************************************************************/
	public boolean createNotes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib noteData) throws Exception{
		Selenium selenium = null;
		boolean recordLockedEdit=false;
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
		
			//---------------------------------------------------------------------//
			//  Step-3:Navigate to security setting and unblock the locked records //
			//---------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSecuritySetting),"Could not click on security settings",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRecordLocking),"Could not click on Record Locking link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSearch),"could not click on Search Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if( selenium.isVisible(chkEntry)){
				assertTrue(click(selenium,chkEntry),"Could not check the entry",selenium, ClassName, MethodName);
				assertTrue(click(selenium,lnkUnlock),"Could not unlock entry",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYesbutton),"Could not click on yes button",selenium, ClassName, MethodName);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to patient Note  //
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexia(selenium,noteData.patientID),"Search patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkNotes),"Could not click on Notes",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create a new Note //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddNote),"Could not click on add Note button:"+noteData.toString(), selenium, ClassName, MethodName);
			assertTrue(createNotes(selenium,noteData, userAccount),"Note creation Failed", selenium, ClassName, MethodName);
			
			if(noteData.testCaseId.equalsIgnoreCase("TC_NO_015")){
				assertTrue(click(selenium,lnkEditNotes),"Could not click on Edit  Notes",selenium, ClassName, MethodName);
				
				if(isElementPresent(selenium, txtNoteDate)){
					editCompleted=true;
				}
				
			}
			else{
				//use this while block for wait until edit notes completes its execution
				int editCompletedCount=0;
				while(true){
					if(editCompleted==true || editCompletedCount>100){
						break;
					}
					Thread.sleep(1000);
					editCompletedCount=editCompletedCount+1;
				}
				waitForPageLoad(selenium);
				
				//if we click the edit notes for the same patient and same record, It will get locked
				assertTrue(click(selenium,lnkEditNotes),"Could not click on Edit  Notes",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//check for the unlock button existence
				if(isElementPresent(selenium,lblRecordLockPopupEdit)){
					//verify the text description for the locked record
					assertTrue((getText(selenium,lblRecordLockEdit).contains("This record is in use by ")),"", selenium, ClassName, MethodName);
					//click the unblock button
					assertTrue(click(selenium,lblRecordLockPopupEdit),"Could not click on Alert",selenium, ClassName, MethodName);
					
					//click No to make no changes
					if(isElementPresent(selenium, btnNo)){
						assertTrue(click(selenium, btnNo),"Could not click on no button",selenium, ClassName, MethodName);
					}
					
					//if we click the unblock button, the record must be still locked
					assertTrue(click(selenium, lblRecordLockPopupEdit),"Could not click on alert ",selenium, ClassName, MethodName);
					//verify the record is still locked
					assertTrue(isElementPresent(selenium, btnNo),"NO button not present", selenium, ClassName, MethodName);
						recordLockedEdit=true;
				}
				
				processCompleted= true;
				waitForPageLoad(selenium);
			}
			
			//use this while block for wait until all process to completes its execution
			int processCompltedCount=0;
			while(true){
				if(processCompleted==true || processCompltedCount>100){
					break;
				}
				Thread.sleep(1000);
				processCompltedCount=processCompltedCount+1;
			}
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		
		
		//check record locked
		if(recordLockedEdit){
			return true;
		}
		else {
			return false;
		}
	}

}

