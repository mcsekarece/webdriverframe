package com.nexia.selenium.testscripts.section.demographics.RecordLocking;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;


import com.thoughtworks.selenium.Selenium;

public class VerifyManuallyUnlockLockedRecordNotes extends AbstractHomeTest {
	private boolean elseComplted= false;
	private boolean editCompleted=false;
	private boolean deleteCompleted=false;
	private boolean manualUnblockCompleted= false;
	
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
	
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Verify unlock the locked records")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecordLockingUnlock(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib noteData=new HomeLib();
		noteData.workSheetName="createNewNote";
		noteData.testCaseId="TC_NO_017";
		noteData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNotes(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}
	/*************************************************************************************************** 
	* @purpose        To Verify Record Locking unlock
	* @action 		  Verifying Record Locking unlock
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 18, 2013
	***************************************************************************************************/
	public boolean createNotes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib noteData) throws Exception{
		Selenium selenium = null;
		boolean manuallyUnblockRecord=false;
		
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
			if(noteData.testCaseId.equalsIgnoreCase("TC_NO_017")){
				//wait until edit/delete flow to complete
				while(true){
					if(editCompleted && deleteCompleted){
						//mannually delete the locked records
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
							
							manualUnblockCompleted = true;
						}
						
						return true;
					}
					Thread.sleep(1000);
				}
			}
			
			
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
			else if(noteData.testCaseId.equalsIgnoreCase("TC_NO_016")){
				//use this while block for wait until edit notes completes its execution
				int editCompletedCount=0;
				while(true){
					if(editCompleted==true || editCompletedCount>100){
						break;
					}
					Thread.sleep(1000);
					editCompletedCount=editCompletedCount+1;
				}
				
				
				//if the test run parallel, at the time of click delete the record will get locked
				assertTrue(click(selenium,lnkDeleteNotes),"Could not click on Delete",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//verify the record lock popup by delete
				if(isElementPresent(selenium,lblRecordLockDelete)){
					if(!(getText(selenium, lblRecordLockDelete).contains("This record cannot be deleted. It is in use by "))){
						return false;
					}
				}
				else{
					manuallyUnblockRecord=false;
				}
				
				deleteCompleted=true;
				//use this while block for wait until manual unblock completes its execution
				int manualUnblockCompletedCount=0;
				while(true){
					if(manualUnblockCompleted==true || manualUnblockCompletedCount>100){
						break;
					}
					Thread.sleep(1000);
					manualUnblockCompletedCount=manualUnblockCompletedCount+1;
				}
				
				//based on test case "TC_NO_017" unblock the locked record
				if(selenium.isVisible(lblRecordLockClose)){
					waitForPageLoad(selenium);
					click(selenium, lblRecordLockClose);
					assertTrue(click(selenium,lnkDeleteNotes),"Could not click on Delete",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					//if record possible to delete means, record gets unlocked
					if(selenium.isVisible(btnYesbutton)){
						manuallyUnblockRecord =true;
					}
					waitForPageLoad(selenium);
				}
				
				elseComplted=true;
				
			}
			
			//use this while block for wait until else block completes its execution
			int elseCompletedCount=0;
			while(true){
				if(elseComplted==true || elseCompletedCount>100){
					break;
				}
				Thread.sleep(1000);
				elseCompletedCount=elseCompletedCount+1;
			}
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		
		//check record locked by delete gets unlocked manually
		if(manuallyUnblockRecord){
			return true;
		}
		else {
			return false;
		}
	}

}

