package com.nexia.selenium.testscripts.section.auditlog.demographics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;

import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForDeleteCase extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Cases")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void deleteCasesForPatient(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib casesData = new AuditLogLib();
		casesData.workSheetName = "AuditLogForCases";
		casesData.testCaseId = "TC_ALC_002";
		casesData.fetchHomeTestData();
		deleteCase(seleniumHost, seleniumPort, browser, webSite,userAccount, casesData);
	}
	/**
	 * deleteCase
	 * function to delete Cases
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	     Apr 02, 2012
	 */
	public boolean deleteCase(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib casesData) throws Exception{
Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + casesData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, casesData.userAccount, casesData.userName, casesData.userPassword),"Login Failed ");
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,casesData.switchRole));
			waitForPageLoad(selenium);
			//Advanced search with Patient ID
			searchPatientNexia(selenium,casesData.patientID);

			//--------------------------------------------------------------------//
			//  Step-2: Deleting existing Cases for the selected patient          //
			//--------------------------------------------------------------------//
			click(selenium,"!patientCasesList");
			waitForPageLoad(selenium);
			Assert.assertTrue(deleteAllCases(selenium), "Could not delete cases");

			//---------------------------------------------------------- ---------//
			//  Step-3: Create a new case                                         //
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"css=span.buttons > button.gwt-Button"),"Could not Click on Add Cases Button:"+ casesData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(createCases(selenium,casesData),"Cases creation Failed");
			//--------------------------------------------------------------------//
			//  Step-4: Delete New Cases for the selected patient  //
			//--------------------------------------------------------------------//
			Assert.assertTrue(deleteAllCases(selenium), "Could not delete cases");
			
			//--------------------------------------------------------------------//
			//  Step-5: Go to  securitySetting and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step-6: Verify Audit log for Notes
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, casesData, userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, casesData, userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
		
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + casesData.toString());
		}
		return returnValue;
	}

	
}


