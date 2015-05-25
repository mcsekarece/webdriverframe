package com.nexia.selenium.testscripts.section.auditlog.demographics;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;

import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForCreateIdentifiers extends AbstractAuditLog {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyAuditLogForCreateIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib identifierData = new AuditLogLib();
		identifierData.workSheetName = "AuditLogForIdentifiers";
		identifierData.testCaseId = "TC_ALIde_001";
		identifierData.fetchHomeTestData();
		verifyAuditLogForCreateIdentifiers(seleniumHost, seleniumPort, browser, webSite,userAccount, identifierData);
	}
	/**
	 * verifyAuditLogForCreateIdentifiers
	 * function to verify audit log for create a New Identifier
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	     Mar 27, 2012
	 */	
	
	public boolean verifyAuditLogForCreateIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount ,AuditLogLib identifierData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + identifierData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, identifierData.userAccount, identifierData.userName, identifierData.userPassword),"Login Failed ");
			//--------------------------------------------------------------------//
			//Step-2: Create Identifier Group and Type at Admin section//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,identifierData.switchRole));
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-3:Navigate to System setting ------------//
			//--------------------------------------------------------------------//
			//
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"systemSettings"));
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"!adminIdentifierGroupList"),"Could not click on Identifier Group link:" + identifierData .toString());
			waitForPageLoad(selenium);
			//---------------------------------------------------------------------//
			//  Step-4: Deleting existing Identifier Groups  //
			//--------------------------------------------------------------------//
			HomeLib idGroupData = new HomeLib();
			idGroupData.workSheetName = "IdentifiersAdmin";
			idGroupData.testCaseId = "TC_IDA_001";
			identifierData.fetchHomeTestData();
			Assert.assertTrue(click(selenium,"addIdentifierGroup"),"Could not click on Add Identifier Group link:" + identifierData.toString());
			waitForPageLoad(selenium);
		
			Assert.assertTrue(createIdGroup(selenium,identifierData),"Identifier Groups Creation failed");
			
			Assert.assertTrue(click(selenium,"!adminIdentifierTypeList"),"Could not click on Identifier Group link:" + identifierData .toString());
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-5: Create Identifier Types  //
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(click(selenium,"addIdentifierType"),"Could not click on Add Identifier Type link:" + identifierData.toString());
			waitForPageLoad(selenium);
			
		
			Assert.assertTrue(createIdType(selenium,identifierData),"Identifier Types Creation failed");
			click(selenium,"back");
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-7: Advanced search with Patient ID  //
			//--------------------------------------------------------------------//
			//Advanced search with Patient ID
			searchPatientNexia(selenium,identifierData.patientID);
			waitForPageLoad(selenium);
			click(selenium,"!patientExternalIdList");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Deleting existing identifier for the selected patient  //
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(deleteAllIdentifiers(selenium));
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-9: Create a new Identifier //
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(click(selenium,"addExternalID"),"Could not click on Add Identifers Button:"+identifierData.toString());
			Assert.assertTrue(createIdentifier(selenium,identifierData),"identifier creation failed");
			
			//--------------------------------------------------------------------//
			//  Step-10: Go to Security Settings and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not Navigate to Audit Log Page");
			//--------------------------------------------------------------------//
			//Step-7: Verify Audit log for Program
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, identifierData, userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, identifierData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());
		}
		return returnValue;
	}
}

	

