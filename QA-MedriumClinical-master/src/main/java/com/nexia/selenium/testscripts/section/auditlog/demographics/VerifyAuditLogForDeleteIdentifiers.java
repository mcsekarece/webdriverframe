package com.nexia.selenium.testscripts.section.auditlog.demographics;



import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForDeleteIdentifiers extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleteing Identifiers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyAuditLogForDeleteIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib identifierData = new AuditLogLib();
		identifierData.workSheetName = "AuditLogForIdentifiers";
		identifierData.testCaseId = "TC_ALIde_001";
		identifierData.fetchHomeTestData();
		verifyAuditLogForDeleteIdentifiers(seleniumHost, seleniumPort, browser, webSite,userAccount, identifierData);
	}
	
	/**
	 * verifyAuditLogForDeleteIdentifiers
	 * function to verify audit log for delete Identifier
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    july 23, 2012
	 */
	
	public boolean verifyAuditLogForDeleteIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib identifierData)throws Exception{
		
		Selenium selenium = null;
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + identifierData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, identifierData.userName, identifierData.userPassword),"Login Failed ");
			//--------------------------------------------------------------------//
			//Step-2: Create Identifier Group and Type at Admin section//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,identifierData.switchRole));
			waitForPageLoad(selenium);
			
			
			//Create Identifer Group and Type at Admin section
			waitForPageLoad(selenium);
			click(selenium,"systemSettings");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"!adminIdentifierGroupList"),"Could not click on Identifier Group link:" + identifierData .toString());
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-2: Deleting existing Identifier Groups  //
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
			//  Step-3: Deleting existing Identifier Types  //
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"addIdentifierType"),"Could not click on Add Identifier Type link:" + identifierData.toString());
			waitForPageLoad(selenium);
			
		
			Assert.assertTrue(createIdType(selenium,identifierData),"Identifier Types Creation failed");
			
			click(selenium,"back");
			waitForPageLoad(selenium);
			
			//Advanced search with Patient ID
			searchPatientNexia(selenium,identifierData.patientID);
			waitForPageLoad(selenium);
			click(selenium,"!patientExternalIdList");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			// Step-4: Advanced search with Patient ID
			//--------------------------------------------------------------------//
			
			searchPatientNexia(selenium,identifierData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,"!patientExternalIdList");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Deleting existing identifier for the selected patient  //
			//--------------------------------------------------------------------//
			Assert.assertTrue(deleteAllIdentifiers(selenium));
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Create a new Identifier //
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"addExternalID"),"Could not click on Add Identifers Button:"+identifierData.toString());
			Assert.assertTrue(createIdentifier(selenium,identifierData),"identifier creation failed");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Go to System Settings and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not Navigate to Audit Log Page");
			//--------------------------------------------------------------------//
			//Step-8: Verify Audit log for Program
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, identifierData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify whether Program gets saved properly //
			//--------------------------------------------------------------------//
			Assert.assertTrue(verifyStoredValue(selenium, identifierData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());
		}
		return returnValue;
	}
}
