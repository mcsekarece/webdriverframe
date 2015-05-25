package com.nexia.selenium.testscripts.section.auditlog.demographics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;

import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForEditIdentifiers extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing patient for Identifers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyAuditLogForEditIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib identifierData = new AuditLogLib();
		identifierData.workSheetName = "AuditLogForIdentifiers";
		identifierData.testCaseId = "TC_ALIde_001";
		identifierData.fetchHomeTestData();
		verifyAuditLogForEditIdentifiers(seleniumHost, seleniumPort, browser, webSite,userAccount, identifierData);
	}
	/**
	 * verifyAuditLogForEditIdentifiers
	 * function to verify audit log for edit Identifier
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    july 23, 2012
	 */	
	
	public boolean verifyAuditLogForEditIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib identifierData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = false;
	
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
			//  Step-5: Create Identifier Types  //
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
			//  Step-8: Deleting existing identifier for the selected patient  //
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(deleteAllIdentifiers(selenium));
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Create a new Identifier //
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(click(selenium,"addExternalID"),"Could not click on Add Identifers Button:"+identifierData.toString());
			Assert.assertTrue(createIdentifier(selenium,identifierData),"identifier creation failed");
			
			click(selenium,"back");
			waitForPageLoad(selenium);
			
			//Create second Identifer Group and Type at Admin section
			waitForPageLoad(selenium);
			click(selenium,"systemSettings");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"!adminIdentifierGroupList"),"Could not click on Identifier Group link:" + identifierData .toString());
			waitForPageLoad(selenium);
			identifierData.workSheetName = "IdentifiersAdmin";
			identifierData.testCaseId = "TC_IDA_002";
			identifierData.fetchHomeTestData();
			Assert.assertTrue(click(selenium,"addIdentifierGroup"),"Could not click on Add Identifier Group link:" + identifierData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(createIdGroup(selenium,identifierData),"Identifier Groups Creation failed");
			
			Assert.assertTrue(click(selenium,"!adminIdentifierTypeList"),"Could not click on Identifier Group link:" + identifierData .toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"addIdentifierType"),"Could not click on Add Identifier Type link:" + identifierData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(createIdType(selenium,identifierData),"Identifier Types Creation failed");
			click(selenium,"back");
			waitForPageLoad(selenium);
			searchPatientNexia(selenium,identifierData.patientID);
			waitForPageLoad(selenium);
			click(selenium,"!patientExternalIdList");
			waitForPageLoad(selenium);
			
			click(selenium,"//div[@id='PatientExternalIDList']/table/tbody/tr/td[2]/div/a");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Edit Created Identifier //
			//--------------------------------------------------------------------//
			
			identifierData.workSheetName = "AuditLogForIdentifiers";
			identifierData.testCaseId = "TC_ALIde_002";
			identifierData.fetchHomeTestData();
			Assert.assertTrue(editIdentifiers(selenium,identifierData),"Edit Idetifiers Failed");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Go to Security Settings and navigate to Audit Log //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			click(selenium,"back");
			waitForPageLoad(selenium);
			click(selenium,"securitySettings");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Go to Security Settings and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not Navigate to Audit Log Page");
			
			//--------------------------------------------------------------------//
			//Step-9: Verify Audit log for Program
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, identifierData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, identifierData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-10: Verify whether identifier gets saved properly //
			//--------------------------------------------------------------------//
			if(!verifyStoredOldValues(selenium,identifierData)){
				Assert.fail("User old details not saved properly; More Details :"+ identifierData.toString());
				returnValue=false;
			}
			if(!verifyStoredNewValues(selenium,identifierData)){
				Assert.fail("User new details not saved properly; More Details :"+ identifierData.toString());
				returnValue=false;
			}else
				returnValue=true;
		
		}catch(RuntimeException e){
			
		}
		return returnValue;
	}
	
	public boolean verifyStoredOldValues(Selenium selenium,AuditLogLib identifierData){
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate=DateFormat.format(cal.getTime());
		
		if(!getText(selenium,"collapsableDesc").trim().contains(systemDate.trim())){
			return false;
		}
		/*if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(identifierData.value.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		return true;
	}
	public boolean verifyStoredNewValues(Selenium selenium,AuditLogLib identifierData){
		/*if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(identifierData.value.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(identifierData.expirationdate1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
