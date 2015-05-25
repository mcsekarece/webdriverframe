package com.nexia.selenium.testscripts.section.auditlog.chartprevisit;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForCreateEncounter extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
	public void createAllergyWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		AuditLogLib allergyData = new AuditLogLib();
		allergyData.workSheetName = "AuditLogEncounter";
		allergyData.testCaseId = "TC_AE_001";
		allergyData.fetchHomeTestData();
		verifyAuditLog(seleniumHost, seleniumPort, browser, webSite, allergyData,userAccount);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Create Emcounter Details In Audit Log
	* @Specification  SRS_EMR_Encounter_OverAll Rev0.0
	* @action 		  Test for verifying Create Emcounter Details In Audit Log
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 11, 2013
	***************************************************************************************************/
	
	public boolean verifyAuditLog(String seleniumHost, int seleniumPort,String browser, String webSite, AuditLogLib allergyData, String userAccount) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			Assert.assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch Role//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,allergyData.switchRole));
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Encounter in Encounter tab//
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"!chartEncounters"),"Could not click the encounter tab");
			Assert.assertTrue(deleteAllEncounters(selenium,allergyData));
			
			//--------------------------------------------------------------------//
			//  Step-5: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Save the encounter//
			//--------------------------------------------------------------------//
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String pName= providerNameTemp.replaceAll(", FULL", "");
			String tempArray[]=pName.split(" ");
			String providerName=tempArray[1]+", "+tempArray[0];
			assertTrue(type(selenium,"providerSuggestBoxIdsuggestBox",providerName),"could not enter the provider name",selenium, ClassName, MethodName);
			
			selenium.clickAt("actionAnchorEncounter", "");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium,"saveEncounter"),"Could not click the save button");
			waitForPageLoad(selenium);
			
			//-----------------------------------------------------------//
			//  Step-7: Go to  securitySetting and navigate to Audit Log //
			//-----------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			//------------------------------------------------//
			//Step-8: Verify Audit log for External Providers //
			//------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, allergyData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, allergyData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + allergyData.toString());
		} 
		return returnValue;
	}
	
	
}
