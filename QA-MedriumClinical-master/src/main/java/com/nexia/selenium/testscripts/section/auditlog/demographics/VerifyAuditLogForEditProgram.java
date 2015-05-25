package com.nexia.selenium.testscripts.section.auditlog.demographics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForEditProgram extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void editProgramForPatient(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib programData = new AuditLogLib();
		programData.workSheetName = "AuditLogForCreateProgram";
		programData.testCaseId = "TC_ALP_001";
		programData.fetchHomeTestData();
		editProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	/**
	 * editProgram
	 * function to editProgram
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    July 16, 2012
	 */
	public boolean editProgram(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib programData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + programData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, programData.userName, programData.userPassword),"Login Failed ");
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,programData.switchRole));
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-3:Advanced search with Patient ID  ------------//
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,programData.patientId);
			waitForPageLoad(selenium);
			click(selenium,"!patientProgramsList");
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Deleting existing Programs for the selected patient  //
			//--------------------------------------------------------------------//
			while(isElementPresent(selenium,"//a[contains(text(),'Delete')]")){
				waitForPageLoad(selenium);
				click(selenium,"//a[contains(text(),'Delete')]");
				waitForPageLoad(selenium);
				click(selenium,"yesButton");
				waitForPageLoad(selenium);  
			}
			//---------------------------------------------------------- ----------//
			//  Step-5: Create a new Program //
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"addPrograms"),"Could not Click on Add Programs Button:"+ programData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(createProgram(selenium,programData),"Program creation Failed");
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-6: edit a new Program //
			//--------------------------------------------------------------------//
			click(selenium,"//div[@id='PatientContactList']/table/tbody/tr/td[2]/div/a");
			waitForPageLoad(selenium);
				
			programData.workSheetName = "AuditLogForCreateProgram";
			programData.testCaseId = "TC_ALP_002";
			programData.fetchHomeTestData();
						
			Assert.assertTrue(enterDate(selenium,"fromDate", programData.fromdate),"Could not enter date; More Details :" + programData.toString());
			Assert.assertTrue(enterDate(selenium,"toDate",programData.endDate),"Could not enter the date; More Details :" + programData.toString());
			Assert.assertTrue(type(selenium,"priorState",programData.priorstate),"Could not enter the Prior State value; More Details :" + programData.toString());
			Assert.assertTrue(type(selenium,"outcome",programData.outcome),"Could not enter the Outcome value; More Details :" + programData.toString());
			Assert.assertTrue(click(selenium,"save"),"Could not click Save Button; More Details :" + programData.toString());
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Go to System Settings and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not Navigate to Audit Log Page");
			//--------------------------------------------------------------------//
			//Step-8: Verify Audit log for Program
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"!audit"),"Could not click on Audit log link:" +  programData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(auditLog(selenium, programData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, programData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			if(!verifyStoredOldValues(selenium,programData)){
				Assert.fail("User details not saved properly; More Details :"+ programData.toString());
				returnValue=false;
			}if(!verifyStoredNewValues(selenium,programData)){
				Assert.fail("User details not saved properly; More Details :"+ programData.toString());
				returnValue=false;
			}else
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + programData.toString());
		}
		return returnValue;
	}
	
	public boolean verifyStoredOldValues(Selenium selenium,AuditLogLib auditData){
		Calendar cal1=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate1=DateFormat1.format(cal1.getTime());
		
		if(!getText(selenium,"//span/div[2]").trim().contains(systemDate1.trim())){
			return false;
		}
		
		if(!getText(selenium,"//span/div[2]").trim().contains(auditData.startdate)){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").trim().contains(auditData.endDate)){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.priorstate.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.outcome.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		return true;
	}
	public boolean verifyStoredNewValues(Selenium selenium,AuditLogLib auditData){
		
		if(!getText(selenium,"//span/div[2]").trim().contains(auditData.startdate1)){
			return false;
		}
		
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.priorstate1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.outcome1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		return true;
	}
}
