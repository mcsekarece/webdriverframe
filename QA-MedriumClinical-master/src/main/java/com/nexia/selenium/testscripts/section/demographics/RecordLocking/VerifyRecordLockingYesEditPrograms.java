package com.nexia.selenium.testscripts.section.demographics.RecordLocking;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;


import com.thoughtworks.selenium.Selenium;

public class VerifyRecordLockingYesEditPrograms extends AbstractHomeTest {
	private static boolean editCompleted=false;
	private static boolean edit1Completed=false;
	private static boolean processCompleted=false;
	
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Record Locking Edit in Programs")
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
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Record Locking Edit in Programs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecordLockingEdit1Programs(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "NewProgram";
		programData.testCaseId = "TC_P_016";
		programData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Record Locking Edit in Programs
	* @action 		  Verifying Record Locking Edit in Programs
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 20, 2013
	***************************************************************************************************/
	public boolean createNewProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib programData) throws Exception{
		Selenium selenium = null;
		boolean recordLockedEdit=false;
		boolean recordLockedEdit1=false;
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
			//  Step-4: Navigate to patient Cases  //
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexia(selenium,programData.patientID),"Search patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkProgram);
			waitForPageLoad(selenium);

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
			
			//use the following if else to create record locking
			if(programData.testCaseId.equalsIgnoreCase("TC_P_015")){

				assertTrue(click(selenium,lnkEditPrograms),"Could not click on Edit Case",selenium, ClassName, MethodName);
				
				if(isElementPresent(selenium, ajxProgram)){
					editCompleted=true;
				}
				
				//wait for else part to complete the process
				
				//use this while block for wait until edit1 notes completes its execution
				int edit1CompletedCount=0;
				while(true){
					if(edit1Completed==true || edit1CompletedCount>100){
						break;
					}
					Thread.sleep(1000);
					edit1CompletedCount=edit1CompletedCount+1;
				}
				
				//if refresh button presents the locked record get modified
				if(isElementPresent(selenium,"//div[3]/button")){
					//verify the confirmation text
					//if(!(getText(selenium, "//div[3]/div/span").contains("This record was released "))){
					processCompleted= true;
						//return false;
					//}
					
					//click the refresh button
					click(selenium, "//div[3]/button");
					waitForPageLoad(selenium);
					
					//verify the data changes for the current record by the locked record
					programData.workSheetName="NewProgram";
					programData.testCaseId="TC_P_017";
					programData.fetchHomeTestData();
					
					assertTrue(getValue(selenium,ajxProgram).trim().contains(programData.program.trim()),"Could not get value from drop down", selenium, ClassName, MethodName);
					
					
					if(userAccount.equalsIgnoreCase(CAAccount)){
					
						assertTrue(getValue(selenium,txtFromDate).trim().contains(programData.fromdateCA.trim()), "Could not from date", selenium, ClassName, MethodName);
						assertTrue(getValue(selenium,txtToDate).trim().contains(programData.todateCA.trim()), "Could not get to date", selenium, ClassName, MethodName);
						
					}
					else{			
						
						assertTrue(getValue(selenium,txtFromDate).trim().contains(programData.fromdate.trim()), "Could not get from date", selenium, ClassName, MethodName);
	
						assertTrue(getValue(selenium,txtToDate).trim().contains(programData.todate.trim()), "Could not get to date", selenium, ClassName, MethodName);
					
					}
									
					
					assertTrue(getValue(selenium,txtPrior).trim().contains(programData.priorstate.trim()),"Could not get text", selenium, ClassName, MethodName);
					assertTrue(getValue(selenium,txtOutCome).trim().contains(programData.outcome.trim()),"Could not get text", selenium, ClassName, MethodName);
					recordLockedEdit=true;
				}
				else{
					recordLockedEdit=false;
				}
				processCompleted= true;
				waitForPageLoad(selenium);
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
				click(selenium,lnkEditPrograms);
				waitForPageLoad(selenium);
				
				//check for the unlock button existence
				if(isElementPresent(selenium,"css=button.secondary-button.absoluteTopRight")){
					//verify the text description for the locked record
					if((getText(selenium, "css=span.gwt-InlineHTML").contains("This record is in use by "))){
						recordLockedEdit1=true;
					}
					
					//click the unblock button
					click(selenium, "css=button.secondary-button.absoluteTopRight");
					waitForPageLoad(selenium);
					
					//click yes to unblock
					if(isElementPresent(selenium, "yes")){
						click(selenium, "yes");
					}
					waitForPageLoad(selenium);
					
					//now, edit the record
					programData.workSheetName="NewProgram";
					programData.testCaseId="TC_P_017";
					programData.fetchHomeTestData();
					
					assertTrue(createProgram(selenium,programData,userAccount),"Program creation Failed", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					//if, edit button exists the record saved properly
					if(isElementPresent(selenium, lnkEditPrograms)){
						recordLockedEdit1=true;
					}
					edit1Completed = true;
				}
				else{
					recordLockedEdit1=false;
				}
				
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
		
		
		//check record locked and modified in both
		if(recordLockedEdit && recordLockedEdit1){
			return true;
		}
		else {
			return false;
		}
	}

}

