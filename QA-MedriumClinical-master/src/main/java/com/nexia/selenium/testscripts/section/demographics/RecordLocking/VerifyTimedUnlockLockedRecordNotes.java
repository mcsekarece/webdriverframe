package com.nexia.selenium.testscripts.section.demographics.RecordLocking;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;


import com.thoughtworks.selenium.Selenium;

public class VerifyTimedUnlockLockedRecordNotes extends AbstractHomeTest {
	private boolean elseComplted= false;
	private boolean editCompleted=false;
	
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Record Locking Delete in Notes")
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
	
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New Notes")
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
	
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Record Locking unlock")
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
		boolean timedUnblockRecords=false;
		
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
				
				//manually delete the locked records
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
				
				//set the time period to record will be locked
				assertTrue(click(selenium,lnkEditRL),"Could not click on Edit button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if( selenium.isVisible(txtTime)){
					
					//verify the default value
					if(!isElementPresent(selenium, "timeUnitSuggestBox")){
						Assert.fail("Time unit not displayed");
					}
					
					if(!isElementPresent(selenium, txtTime)){
						Assert.fail("Time lable not displayed");
					}
					
					assertTrue(type(selenium, txtTime, "1"),"could not type time",selenium, ClassName, MethodName);
					assertTrue(click(selenium,ajxTimeUnit),"could not time click time unit",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,ajkDateTypeSelected),"could not click on ajx selection",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				return true;
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
				
				//if the test run parallaly, at the time of click delete the record will get locked
				assertTrue(click(selenium,lnkDeleteNotes),"Could not click on Delete",selenium, ClassName, MethodName);
				
				//verify the record lock popup by delete
				if(isElementPresent(selenium,lblRecordLockDelete)){
					if(!(getText(selenium, lblRecordLockDelete).contains("This record cannot be deleted. It is in use by "))){
						timedUnblockRecords=false;
					}
				}
				else{
					timedUnblockRecords=false;
				}
				waitForPageLoad(selenium);
				
				//we set 1 minute only to lock the record based on test case "TC_NO_017"
				Thread.sleep(60000);//so, wait 1 minute
				if(selenium.isVisible(lblRecordLockClose)){
					waitForPageLoad(selenium);
					click(selenium, lblRecordLockClose);
					assertTrue(click(selenium,lnkDeleteNotes),"Could not click on Delete Notes",selenium, ClassName, MethodName);
					
					//if record possible to delete means, record gets unlocked
					if(selenium.isVisible(btnYesbutton)){
						timedUnblockRecords= true;
					}
					waitForPageLoad(selenium);
				}
				else{
					timedUnblockRecords=false;
				}
				
				elseComplted= true;
				waitForPageLoad(selenium);
				
				
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
		
		
		//check record locked by delete gets unlocked by timed base
		if(timedUnblockRecords){
			return true;
		}
		else {
			return false;
		}
	}

}

