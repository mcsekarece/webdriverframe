package com.nexia.selenium.testscripts.section.auditlog.demographics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;


public class VerifyAuditLogForCreateProgram extends AbstractAuditLog {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void createNewProgramForPatient(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib programData = new AuditLogLib();
		programData.workSheetName = "AuditLogForCreateProgram";
		programData.testCaseId = "TC_ALP_001";
		programData.fetchHomeTestData();
		createNewProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	/**
	 * createNewProgram
	 * function to create New Program
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    Jun 20, 2012
	 */
	public boolean createNewProgram(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib programData) throws Exception{
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
			//
		
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
			Assert.assertTrue(createProgram(selenium,programData),"Program creatio n Failed");
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-6: Go to System Settings and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not Navigate to Audit Log Page");
			//--------------------------------------------------------------------//
			//Step-7: Verify Audit log for Program
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(auditLog(selenium, programData, userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, programData, userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: Verify whether Program gets saved properly //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForProgram(selenium,programData)){
				Assert.fail("User details not saved properly; More Details :"+ programData.toString());
				returnValue=false;
			}else{
				return returnValue;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + programData.toString());
		}
		return returnValue;
	}
	
	
	public boolean verifyStoredValuesForProgram(Selenium selenium,AuditLogLib auditData){
		
		
		Calendar cal1=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate1=DateFormat1.format(cal1.getTime());
		
		if(!getText(selenium,"//span/div[2]").trim().contains(systemDate1.trim())){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.program.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.department.trim().toLowerCase(new java.util.Locale("en","US")))){
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
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.filter.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
