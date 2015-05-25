package com.nexia.selenium.testscripts.section.demographics.RecordLocking;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;


import com.thoughtworks.selenium.Selenium;

public class VerifyRecordLockingYesEditCases extends AbstractHomeTest {
	private static boolean editCompleted=false;
	private static boolean edit1Completed=false;
	private static boolean processCompleted=false;
	
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Record Locking Edit in Cases")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecordLockingEditCases(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib casesData = new HomeLib();
		casesData.workSheetName = "NewCases";
		casesData.testCaseId = "TC_NC_013";
		casesData.fetchHomeTestData();
		
		createNewCases(seleniumHost, seleniumPort, browser, webSite, userAccount, casesData);
	}
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Record Locking Edit in Cases")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecordLockingEdit1Cases(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib casesData = new HomeLib();
		casesData.workSheetName = "NewCases";
		casesData.testCaseId = "TC_NC_014";
		casesData.fetchHomeTestData();
		
		createNewCases(seleniumHost, seleniumPort, browser, webSite, userAccount, casesData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Record Locking Edit in Cases
	* @action 		  Verifying Record Locking Edit in Cases
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 19, 2013
	***************************************************************************************************/
	public boolean createNewCases(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib casesData) throws Exception{
		Selenium selenium = null;
		boolean recordLockedEdit=false;
		boolean recordLockedEdit1=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + casesData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, casesData.userName, casesData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,casesData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
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
			assertTrue(searchPatientNexia(selenium,casesData.patientID),"Search patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(goToCases(selenium), "Could not navigate to Cases Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create a new Cases //
			//--------------------------------------------------------------------//
			assertTrue(goToAddCase(selenium),"Could not Navigate to Add Cases Button : "+ casesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createCases(selenium,casesData,userAccount),"Cases creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//use the following if else to create record locking
			if(casesData.testCaseId.equalsIgnoreCase("TC_NC_013")){

				assertTrue(click(selenium,lnkEdit),"Could not click on Edit Case",selenium, ClassName, MethodName);
				
				if(isElementPresent(selenium, txtDescription)){
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
					casesData.workSheetName="NewCases";
					casesData.testCaseId="TC_NC_015";
					casesData.fetchHomeTestData();
					if(!getValue(selenium,txtDescription).trim().contains(casesData.description.trim())){
						processCompleted= true;
						return false;
					}
					if(!getValue(selenium,ajkProgram).trim().contains(casesData.program.trim())){
						processCompleted= true;
						return false;
					}
					if(!getText(selenium,txtDepartment).trim().equalsIgnoreCase(casesData.department.trim())){
						processCompleted= true;
						return false;
					}
					if(!getValue(selenium,txtReason).trim().contains(casesData.reason.trim())){
						processCompleted= true;
						return false;
					}
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
				click(selenium,lnkEdit);
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
					casesData.workSheetName="NewCases";
					casesData.testCaseId="TC_NC_015";
					casesData.fetchHomeTestData();
					
					assertTrue(createCases(selenium,casesData,userAccount),"Cases creation Failed", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					//if, edit button exists the record saved properly
					if(isElementPresent(selenium, lnkEdit)){
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

