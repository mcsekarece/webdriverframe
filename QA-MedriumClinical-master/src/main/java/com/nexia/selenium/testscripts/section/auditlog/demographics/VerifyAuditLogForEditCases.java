package com.nexia.selenium.testscripts.section.auditlog.demographics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForEditCases extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing patient Case")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void editNewCasesForPatient(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib casesData = new AuditLogLib();
		casesData.workSheetName = "AuditLogForCases";
		casesData.testCaseId = "TC_ALC_001";
		casesData.fetchHomeTestData();
		editCases(seleniumHost, seleniumPort, browser, webSite, userAccount, casesData);
	}
	/**
	 * editCases
	 * function to edit patient cases
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		: InterruptedException 
	 
	 * @since  	     Apr 09, 2012
	 */
	
	public boolean editCases(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib casesData) throws Exception{
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
			waitForPageLoad(selenium);
			
			click(selenium,"!patientCasesList");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Deleting existing note for the selected patient  //
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(deleteAllCases(selenium), "Could not delete cases");
			
			//--------------------------------------------------------------------//
			//  Step-3: Create a new Cases //
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(click(selenium,"css=span.buttons > button.gwt-Button"),"Could not click on add Note button:"+casesData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(createCases(selenium,casesData),"Cases creation Failed");
			
			//--------------------------------------------------------------------//
			//  Step-4:Edit patient Cases //
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(click(selenium,"//div[@id='PatientCaseList']/table/tbody/tr/td[2]/div/a"));
			waitForPageLoad(selenium);
				
			casesData.workSheetName = "AuditLogForCases";
			casesData.testCaseId = "TC_ALC_003";
			casesData.fetchHomeTestData();
			
			Assert.assertTrue(editCases(selenium,casesData),"Could not edit the case");
			//--------------------------------------------------------------------//
			//  Step-5: Go to System Settings and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step-6: Verify Audit log for Program
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, casesData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify whether Program gets saved properly //
			//--------------------------------------------------------------------//
			Assert.assertTrue(verifyStoredValue(selenium, casesData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
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
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate=DateFormat.format(cal.getTime());
		
		if(!getText(selenium,"collapsableDesc").trim().contains(systemDate.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.programEdit.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.program1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(auditData.terminationDateAudit)){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.terminationReasonEdit.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
