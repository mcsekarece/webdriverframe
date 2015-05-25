package com.nexia.selenium.testscripts.section.auditlog.chartprevisit;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForCreateVitals extends AbstractAuditLog{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Vitals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void createVitalsWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib vitalsData = new AuditLogLib();
		vitalsData.workSheetName = "AuditLogForVitals";
		vitalsData.testCaseId = "TC_APL_001";
		vitalsData.fetchHomeTestData();
		addVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify added vitals is displayed in Audit Log
	* @Specification  SRS_EMR_Med_Summary_Procedures_Rev0.0
	* @action 		  verifying added quick list problem list is displayed
	* @expected       After add the vitals, When click the audit Log and search the vitals details, It should shows the added vitals
	* @author         Aspire QA
	 * @throws        IOException 
	* @defectno 	  #2107
	* @state          Closed
	* @useraccount    Both
	* @since  	      April 16, 2013
	***************************************************************************************************/
	
	
	public boolean addVitals(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib vitalsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + vitalsData.toString());
			Assert.assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, vitalsData.userName, vitalsData.userPassword),"Login Failed ");
			
			Assert.assertTrue(switchRole(selenium,vitalsData.switchRole));
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Create New Patient //
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient");
			waitForPageLoad(selenium);
			vitalsData.workSheetName = "NewPatientCheckIn";
			vitalsData.testCaseId = "TC_NP_001";
			vitalsData.fetchHomeTestData();
			Assert.assertTrue(createNewPatientWithMandatory(selenium,vitalsData),"Patient Checkin Failed");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Vitals //
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,lnkPatientOption),"Could not click the patient option");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,lnkChartSummary),"Could not click the chart summary");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium,lnkVitals),"Could not click the vitals link;More Details");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Add Vitals												  //
			//--------------------------------------------------------------------//
			Assert.assertTrue(addVitals(selenium,vitalsData),"Vitals Creation failed");
			waitForPageLoad(selenium);
			//-----------------------------------------------------------//
			//  Step-5: Go to  securitySetting and navigate to Audit Log //
			//-----------------------------------------------------------//
			Assert.assertTrue(goToAuditLogFromChartPreVisit(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			//------------------------------------------------//
			//Step-6: Verify Audit log details //
			//------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, vitalsData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, vitalsData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//------------------------------------------------//
			//Step-6: Verify Vitals details //
			//------------------------------------------------//
			Assert.assertTrue(verifyStoredValueForViatls(selenium, vitalsData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			return true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + vitalsData.toString());
			
		}
		return false;
	}
	
}
