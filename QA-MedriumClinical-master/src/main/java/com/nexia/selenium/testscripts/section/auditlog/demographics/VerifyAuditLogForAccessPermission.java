package com.nexia.selenium.testscripts.section.auditlog.demographics;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForAccessPermission extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyAuditLogForAccessPermission(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib auditData = new AuditLogLib();
		auditData.workSheetName = "EditUser";
		auditData.testCaseId = "TC_EU_001";
		auditData.fetchHomeTestData();
		auditLogForAccessPermission(seleniumHost, seleniumPort, browser, webSite,userAccount, auditData);
	}

	/**
	 * auditLogForAccessPermission
	 * function to audit Log For Access Permission
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 * @since  	    Dec 12, 2010
	 */
	
	public boolean auditLogForAccessPermission(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib userData) throws Exception{
		
		boolean returnValue=true;
		Selenium selenium=null;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + userData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, userData.userAccount, userData.userName, userData.userPassword),"Login Failed ");
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,userData.switchRole));
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to User //
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"securitySettings"),"could not click security Settings");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"!audit"),"Could not click on Audit log link:");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step-4: Verify Audit log for Program
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, userData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(isElementPresent(selenium,"collapsableTitle"));
			waitForPageLoad(selenium);
			click(selenium,"collapsableTitle");
			//--------------------------------------------------------------------//
			//  Step-5: Verify whether Program gets saved properly //
			//--------------------------------------------------------------------//
			Assert.assertTrue(verifyStoredValue(selenium, userData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			return returnValue;
				
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + userData.toString());
		}
		return returnValue;
	}
}
