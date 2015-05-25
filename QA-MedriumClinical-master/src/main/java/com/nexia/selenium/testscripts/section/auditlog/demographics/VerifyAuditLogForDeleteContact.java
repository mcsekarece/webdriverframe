package com.nexia.selenium.testscripts.section.auditlog.demographics;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;


import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForDeleteContact extends AbstractAuditLog{
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void deleteContactForPatient(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib ContactData = new AuditLogLib();
		ContactData.workSheetName = "AuditLogForContact";
		ContactData.testCaseId = "TC_ALCont_001";
		ContactData.fetchHomeTestData();
		deleteContact(seleniumHost, seleniumPort, browser, webSite,userAccount, ContactData);
	}
	/**
	 * deleteContact
	 * function to deleteContact
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	    July 217, 2012
	 */
	public boolean deleteContact(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib ContactData) throws InterruptedException, IOException{
		Selenium selenium = null;
	
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ContactData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, ContactData.userName, ContactData.userPassword),"Login Failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,ContactData.switchRole));
			waitForPageLoad(selenium);
			//Advanced search with Patient ID
			
			searchPatientNexia(selenium,ContactData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,"!patientContactsList");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Deleting existing contacts for the selected patient  //
			//--------------------------------------------------------------------//
			Assert.assertTrue(deleteAllContact(selenium),"Contact details not saved properly; More Details :"+ ContactData.toString());
				
			//--------------------------------------------------------------------//
			//  Step-4: Create a new Contact if no contacts available to delete //
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(click(selenium,"addContact"),"Could not Click on Add Contacts Contacts Button:"+ ContactData.toString());
			Assert.assertTrue(createContact(selenium,ContactData),"Contact creation Failed");
			click(selenium,"//div[@id='PatientContactList']/table/tbody/tr/td[2]/div/a");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete patient Contact //
			//--------------------------------------------------------------------//
			Assert.assertTrue(deleteAllContact(selenium),"Contact details not saved properly; More Details :"+ ContactData.toString());
			//--------------------------------------------------------------------//
			//  Step-5: Go to System Settings and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step-6: Verify Audit log for Program
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, ContactData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Verify whether Program gets saved properly //
			//--------------------------------------------------------------------//
			Assert.assertTrue(verifyStoredValue(selenium, ContactData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());
		}
		return returnValue;
	}
}
