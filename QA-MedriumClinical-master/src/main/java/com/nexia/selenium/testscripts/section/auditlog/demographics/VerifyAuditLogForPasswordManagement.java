package com.nexia.selenium.testscripts.section.auditlog.demographics;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;

import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForPasswordManagement extends AbstractAuditLog{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void createUserForAdmin(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib userData = new AuditLogLib();
		userData.workSheetName = "EditUser";
		userData.testCaseId = "TC_EU_001";
		userData.fetchHomeTestData();
		createUser(seleniumHost, seleniumPort, browser, webSite,userAccount, userData);
	}
	/**
	 * editUser
	 * function to edit User
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	    June 22, 2010
	 */
	public boolean createUser(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib userData) throws Exception{
		Selenium  selenium =null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + userData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, userData.userAccount, userData.userName, userData.userPassword),"Login Failed ");
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to User //
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,userData.switchRole));
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"systemSettings"),"Could not click on System settings link:" + userData .toString());
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Search User //
			//--------------------------------------------------------------------//
			int count=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td")){
				waitForPageLoad(selenium);
				String searchUser=getText(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td");
				waitForPageLoad(selenium);
				if(searchUser.contains("TEAM")){
					waitForPageLoad(selenium);
					click(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td");
					waitForPageLoad(selenium);
				}
				count++;
			}
			
			//--------------------------------------------------------------------//
			//  Step-3: Edit User //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"edit"),"Could not click the edit button;More Details:"+userData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(editUserForAuditLog(selenium,userData),"User creation failed");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Go to System Settings and navigate to Audit Log //
			//--------------------------------------------------------------------//
			userData.workSheetName = "AuditLogForUser";
			userData.testCaseId = "TC_CUAL_001";
			userData.fetchHomeTestData();
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step-5: Verify Audit log for Program
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(auditLog(selenium, userData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(isElementPresent(selenium,"collapsableTitle"));
			waitForPageLoad(selenium);
			click(selenium,"collapsableTitle");
			//--------------------------------------------------------------------//
			//  Step-4: Verify whether Program gets saved properly //
			//--------------------------------------------------------------------//
			Assert.assertTrue(verifyStoredValue(selenium, userData, userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
				return returnValue;
				
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + userData.toString());
		}
		return returnValue;
	}
	
}


