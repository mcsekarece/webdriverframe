package com.nexia.selenium.testscripts.section.auditlog.chartprevisit;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForDeleteProcedure extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void editProcedureWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib procarureData = new AuditLogLib();
		procarureData.workSheetName = "AuditLogForProcedure";
		procarureData.testCaseId = "TC_AMSH_003";
		procarureData.fetchHomeTestData();
		editProcedure(seleniumHost, seleniumPort, browser, webSite,userAccount, procarureData);
	}
	
	/**
	 * createProcedure
	 * function to create Procedure
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Sep 27, 2012
	 */
	
	public boolean editProcedure(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib procarureData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + procarureData.toString());
			Assert.assertTrue(loginForNexiaFromProviderSite(selenium,userAccount, procarureData.userName, procarureData.userPassword),"Login Failed ");
			
			Assert.assertTrue(switchRole(selenium,procarureData.switchRole));
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,procarureData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Allergy//
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"link=Surgical History"),"Could not click the Immunization link;More Details");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(deleteProcedure(selenium,procarureData),"Could not delete the procedure");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Add Allergy//
			//--------------------------------------------------------------------//
			Assert.assertTrue(createProcedure(selenium,procarureData),"Creation failed");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(deleteProcedure(selenium,procarureData),"Could not delete the procedure");
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
			Assert.assertTrue(auditLog(selenium, procarureData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, procarureData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + procarureData.toString());
		}
		return returnValue;
	}
}
