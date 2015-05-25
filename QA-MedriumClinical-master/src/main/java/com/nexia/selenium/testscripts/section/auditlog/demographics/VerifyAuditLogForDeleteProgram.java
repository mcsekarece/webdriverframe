package com.nexia.selenium.testscripts.section.auditlog.demographics;



import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForDeleteProgram extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void deleteProgramForPatient(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib programData = new AuditLogLib();
		programData.workSheetName = "AuditLogForCreateProgram";
		programData.testCaseId = "TC_ALP_003";
		programData.fetchHomeTestData();
		deleteProgram(seleniumHost, seleniumPort, browser, webSite,userAccount, programData);
	}
	/**
	 * deleteProgram
	 * function to delete Program
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    July 16, 2012
	 */
	public boolean deleteProgram(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib programData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + programData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, programData.userAccount, programData.userName, programData.userPassword),"Login Failed ");
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,programData.switchRole));
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-3:Advanced search with Patient ID  ------------//
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,programData.patientID);
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
			//  Step-5: Create a new Program if no Programs are available//
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(click(selenium,"addPrograms"),"Could not Click on Add Programs Button:"+ programData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(createProgram(selenium,programData),"Program creation Failed");
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-6: Delete the created program //
			//--------------------------------------------------------------------//
			while(isElementPresent(selenium,"//a[contains(text(),'Delete')]")){
				waitForPageLoad(selenium);
				click(selenium,"//a[contains(text(),'Delete')]");
				waitForPageLoad(selenium);
				click(selenium,"yesButton");
				waitForPageLoad(selenium);  
			}
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
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify whether Program gets saved properly //
			//--------------------------------------------------------------------//
			Assert.assertTrue(verifyStoredValue(selenium, programData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + programData.toString());
		}
		return returnValue;
	}
}
