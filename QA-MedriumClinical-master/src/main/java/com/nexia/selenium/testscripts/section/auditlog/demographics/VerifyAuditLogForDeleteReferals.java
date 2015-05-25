package com.nexia.selenium.testscripts.section.auditlog.demographics;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForDeleteReferals extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Referral")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyAuditLogForDeleteRefferals(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib refData = new AuditLogLib();
		refData.workSheetName = "AuditLogForReferrals";
		refData.testCaseId = "TC_ALRef_003";
		refData.fetchHomeTestData();
		verifyAuditLogForDeleteRefferals(seleniumHost, seleniumPort, browser, webSite,userAccount, refData);
	}
	/**
	 * verifyAuditLogForCreateRefferals
	 * function to verify audit log for create refferals
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	     May 07, 2012
	 */
	
	public boolean verifyAuditLogForDeleteRefferals(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib refData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + refData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, refData.userName, refData.userPassword),"Login Failed ");
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,refData.switchRole));
			waitForPageLoad(selenium);
			
			//Advanced search with Patient ID
			searchPatientNexia(selenium,refData.patientID);
			waitForPageLoad(selenium);
			click(selenium,"!patientReferralList");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Deleting existing Programs for the selected patient  //
			//--------------------------------------------------------------------//
			while(isElementPresent(selenium,"link=Delete")){
			click(selenium,"link=Delete");
			click(selenium,"yesButton");
			waitForPageLoad(selenium);
			}
			//---------------------------------------------------------- ----------//
			//  Step-3: Create a new Referral //
			//---------------------------------------------------------- ----------//
			Assert.assertTrue(click(selenium,"addReferral"),"Could not Click on Add Referral Button:"+ refData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(createReferral(selenium,refData),"Referral creation Failed");
			waitForPageLoad(selenium);
			while(isElementPresent(selenium,"link=Delete")){
				click(selenium,"link=Delete");
				waitForPageLoad(selenium);
				click(selenium,"yesButton");
				waitForPageLoad(selenium);
				}
			//--------------------------------------------------------------------//
			//  Step-4: Go to  securitySetting and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//Step-5: Verify Audit log for Program
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, refData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, refData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refData.toString());
		}
		return returnValue;
	}
	
}
