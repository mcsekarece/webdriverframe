package com.nexia.selenium.testscripts.section.demographics.RecordLocking;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;


import com.thoughtworks.selenium.Selenium;

public class VerifyTimedUnlockLockedRecordCases extends AbstractHomeTest {
	private boolean elseComplted= false;
	private boolean editCompleted=false;
	
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Record Locking Delete in Cases")
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
	
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New Cases")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecordLockingDeleteCases(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib casesData = new HomeLib();
		casesData.workSheetName = "NewCases";
		casesData.testCaseId = "TC_NC_014";
		casesData.fetchHomeTestData();
		
		createNewCases(seleniumHost, seleniumPort, browser, webSite, userAccount, casesData);
	}
	
	@Test(groups = {"RecordLocking","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Record Locking unlock")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecordLockingUnlock(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib casesData = new HomeLib();
		casesData.workSheetName = "NewCases";
		casesData.testCaseId = "TC_NC_015";
		casesData.fetchHomeTestData();
		
		createNewCases(seleniumHost, seleniumPort, browser, webSite, userAccount, casesData);
	}
	/*************************************************************************************************** 
	* @purpose        To Verify Record Locking unlock
	* @action 		  Verifying Record Locking unlock
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 22, 2013
	***************************************************************************************************/
	public boolean createNewCases(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib casesData) throws Exception{
		Selenium selenium = null;
		boolean timedUnblockRecords=false;
		
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
			if(casesData.testCaseId.equalsIgnoreCase("TC_NC_015")){
				
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
			
			if(casesData.testCaseId.equalsIgnoreCase("TC_NC_013")){
				assertTrue(click(selenium,lnkEdit),"Could not click on Edit Case",selenium, ClassName, MethodName);
				
				if(isElementPresent(selenium, txtDescription)){
					editCompleted=true;
				}
				
			}
			else if(casesData.testCaseId.equalsIgnoreCase("TC_NC_014")){
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
				assertTrue(click(selenium,lnkDeleteCases),"Could not click on Delete",selenium, ClassName, MethodName);
				
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
					assertTrue(click(selenium,lnkDeleteCases),"Could not click on Delete cases",selenium, ClassName, MethodName);
					
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

