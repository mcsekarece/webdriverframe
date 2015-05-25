package com.nexia.selenium.testscripts.section.auditlog.demographics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForCreateCases extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Case")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void createNewCasesForPatient(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib casesData = new AuditLogLib();
		casesData.workSheetName = "AuditLogForCases";
		casesData.testCaseId = "TC_ALC_001";
		casesData.fetchHomeTestData();
		createNewCases(seleniumHost, seleniumPort, browser, webSite,userAccount, casesData);
	}
	
	/**
	 * createNewCases
	 * function to create a New Cases
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    July 20, 2012
	 */
	public boolean createNewCases(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib casesData) throws Exception{
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
			//  Step-4: Go to  securitySetting and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step-5: Verify Audit log for Notes
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, casesData, userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, casesData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify whether Program gets saved properly //
			
			if(!verifyStoredValuesForCases(selenium,casesData)){
				Assert.fail("User details not saved properly; More Details :"+ casesData.toString());
				returnValue=false;
			}else{
				return returnValue;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + casesData.toString());
		}
		return returnValue;
	}
	
	public boolean verifyStoredValuesForCases(Selenium selenium,AuditLogLib auditData){
		
		
		Calendar cal1=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate1=DateFormat1.format(cal1.getTime());
		
		if(!getText(selenium,"collapsableDesc").trim().contains(systemDate1.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.description.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(auditData.program.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.department.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.reason.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		/*if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.reason.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		return true;
	}
}
