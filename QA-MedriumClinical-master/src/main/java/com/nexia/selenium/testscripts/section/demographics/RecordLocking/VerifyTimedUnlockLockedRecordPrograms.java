package com.nexia.selenium.testscripts.section.demographics.RecordLocking;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;


import com.thoughtworks.selenium.Selenium;

public class VerifyTimedUnlockLockedRecordPrograms extends AbstractHomeTest {
	private boolean elseComplted= false;
	private boolean editCompleted=false;
	
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Record Locking Delete in Programs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecordLockingEditPrograms(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "NewProgram";
		programData.testCaseId = "TC_P_015";
		programData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New Programs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecordLockingDeletePrograms(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "NewProgram";
		programData.testCaseId = "TC_P_016";
		programData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Record Locking unlock")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecordLockingUnlock(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "NewProgram";
		programData.testCaseId = "TC_P_017";
		programData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	/*************************************************************************************************** 
	* @purpose        To Verify Record Locking unlock
	* @action 		  Verifying Record Locking unlock
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 22, 2013
	***************************************************************************************************/
	public boolean createNewProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib programData) throws Exception{
		Selenium selenium = null;
		boolean timedUnblockRecords=false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + programData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, programData.userName, programData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,programData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//---------------------------------------------------------------------//
			//  Step-3:Navigate to security setting and unblock the locked records //
			//---------------------------------------------------------------------//
			if(programData.testCaseId.equalsIgnoreCase("TC_P_017")){
				
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
					click(selenium, btnSave);
				}
				return true;
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to patient Programs  //
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexia(selenium,programData.patientID),"Search patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkProgram);
			waitForPageLoad(selenium);

			
			
			
			
			
			if(programData.testCaseId.equalsIgnoreCase("TC_P_015")){
				
				//--------------------------------------------------------------------//
				//  Step-5: Deleting existing Programs for the selected patient  //
				//--------------------------------------------------------------------//
				assertTrue(deleteAllPrograms(selenium), "Could not delete all programs", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				
				//---------------------------------------------------------- ----------//
				//  Step-6: Create a new Program //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,btnAddPrograms),"Could not Click on Add Programs Button:"+ programData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createProgram(selenium,programData,userAccount),"Program creation Failed", selenium, ClassName, MethodName);
				

				assertTrue(click(selenium,lnkEditPrograms),"Could not click on Edit Case",selenium, ClassName, MethodName);
				
				if(isElementPresent(selenium, ajxProgram)){
					editCompleted=true;
				}
				
			}
			else if(programData.testCaseId.equalsIgnoreCase("TC_P_016")){
				//use this while block for wait until edit notes completes its execution
				int editCompletedCount=0;
				while(true){
					System.out.println(editCompleted);
					if(editCompleted==true || editCompletedCount>200){
						
						break;
					}
					Thread.sleep(1000);
					editCompletedCount=editCompletedCount+1;
				}
				
				click(selenium,lnkProgram);
				waitForPageLoad(selenium);
				
				//if the test run parallaly, at the time of click delete the record will get locked
				assertTrue(click(selenium,lnkDeleteProgram),"Could not click on Delete",selenium, ClassName, MethodName);
				
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
					assertTrue(click(selenium,lnkDeleteProgram),"Could not click on Delete Notes",selenium, ClassName, MethodName);
					
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

