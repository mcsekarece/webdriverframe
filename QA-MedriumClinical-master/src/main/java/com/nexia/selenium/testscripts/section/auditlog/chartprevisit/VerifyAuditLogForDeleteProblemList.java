package com.nexia.selenium.testscripts.section.auditlog.chartprevisit;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForDeleteProblemList extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void deleteProblemWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib problemData = new AuditLogLib();
		problemData.workSheetName = "AuditLogForProblemList";
		problemData.testCaseId = "TC_APL_001";
		problemData.fetchHomeTestData();
		deleteProblem(seleniumHost, seleniumPort, browser, webSite,userAccount, problemData);
	}
	
	/**
	 * addProblem
	 * function to add Problem
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Feb 08, 2013
	 */
	
	public boolean deleteProblem(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib problemData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + problemData.toString());
			Assert.assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, problemData.userName, problemData.userPassword),"Login Failed ");
			
			Assert.assertTrue(switchRole(selenium,problemData.switchRole));
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,problemData.patientId);
			waitForPageLoad(selenium);
			
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Allergy//
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"link=Problem List"),"Could not click the problem link;More Details");
			waitForPageLoad(selenium);
			Assert.assertTrue(deleteAllProblemList(selenium,problemData),"Deletion Failed");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Add Allergy//
			//--------------------------------------------------------------------//
			Assert.assertTrue(createProblemList(selenium,problemData),"Creation failed");
			waitForPageLoad(selenium);
			//if(isElementPresent(selenium,"//div[@id='AllergyList']/table/tbody/tr/td/div/a")){
			
			Assert.assertTrue(deleteAllProblemList(selenium,problemData),"Deletion Failed");
			waitForPageLoad(selenium);
			

			Assert.assertTrue(click(selenium, "save"));
			waitForPageLoad(selenium);
			
			//-----------------------------------------------------------//
			//  Step-6: Go to  securitySetting and navigate to Audit Log //
			//-----------------------------------------------------------//
			Assert.assertTrue(goToAuditLogFromChartPreVisit(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			//------------------------------------------------//
			//Step-7: Verify Audit log for External Providers //
			//------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, problemData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, problemData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
		
			
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + problemData.toString());
		}
		return returnValue;
		
	}
	
}