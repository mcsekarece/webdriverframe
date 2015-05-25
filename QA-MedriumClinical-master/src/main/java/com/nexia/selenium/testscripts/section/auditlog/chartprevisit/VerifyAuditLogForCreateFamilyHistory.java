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

public class VerifyAuditLogForCreateFamilyHistory extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void createFamilyHistoryWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib historyData = new AuditLogLib();
		historyData.workSheetName = "AuditLogForFamilyHistory";
		historyData.testCaseId = "TC_AFH_001";
		historyData.fetchHomeTestData();
		createFamilyHistory(seleniumHost, seleniumPort, browser, webSite,userAccount,historyData);
	}
	/**
	 * createFamilyHistory
	 * function to create Family History
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Jan 11, 2012
	 */
	
	
	public boolean createFamilyHistory(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib historyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			Assert.assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ");
			
			Assert.assertTrue(switchRole(selenium,historyData.switchRole));
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Allergy//
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(deleteFamilyHistory(selenium,historyData ),"Deletion Failed");
			waitForPageLoad(selenium);
			//waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Add Allergy//
			//--------------------------------------------------------------------//
			Assert.assertTrue(createFamilyHistory(selenium,historyData),"Creation failed");
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
			Assert.assertTrue(auditLog(selenium, historyData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, historyData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify whether External Providers gets saved properly //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForProblem(selenium,historyData)){
				Assert.fail("User details not saved properly; More Details :"+ historyData.toString());
				returnValue=false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + historyData.toString());
		}
		return returnValue;
		
	}
	public boolean verifyStoredValuesForProblem(Selenium selenium,AuditLogLib historyData) {
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate=DateFormat.format(cal.getTime());
		
		Calendar cal1=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("yyyy-MM-dd HH");
		String lastUpdate=DateFormat1.format(cal1.getTime());
		
		
		if(!getText(selenium,"collapsableDesc").trim().contains(systemDate.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(historyData.medical.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(historyData.comment.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(historyData.treatment.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(historyData.age.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(historyData.ageAtDeath.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(historyData.active.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(systemDate.trim())){
			return false;
		}
		
		if(!getText(selenium,"collapsableDesc").trim().contains(lastUpdate.trim())){
			return false;
		}
		return true;
	}
}
