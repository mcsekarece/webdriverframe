package com.nexia.selenium.testscripts.section.auditlog.chartprevisit;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForEncounterEdit extends AbstractAuditLog {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
	public void createAllergyWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		AuditLogLib allergyData = new AuditLogLib();
		allergyData.workSheetName = "AuditLogEncounter";
		allergyData.testCaseId = "TC_AE_002";
		allergyData.fetchHomeTestData();
		verifyAuditLog(seleniumHost, seleniumPort, browser, webSite, allergyData,userAccount);
	}
	/**
	 * function to verify encounter audit log
	 * DefectId     #3536 and #3539
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Mar 25, 2013
	 */
	
	public boolean verifyAuditLog(String seleniumHost, int seleniumPort,String browser, String webSite, AuditLogLib allergyData, String userAccount){
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
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter in Encounter tab//
			//--------------------------------------------------------------------//
			
			/*Assert.assertTrue(click(selenium,"!chartEncounters"),"Could not click the encounter tab");
			Assert.assertTrue(deleteAllEncounters(selenium,allergyData));*/
			
			//--------------------------------------------------------------------//
			//  Step-3: Begin an encounter//
			//--------------------------------------------------------------------//
			Assert.assertTrue(isElementPresent(selenium,"//div[3]/button"),"Could not find the begin encounter button");
			Assert.assertTrue(click(selenium,"//div[3]/button"),"Could not begin encounter");
			
			//--------------------------------------------------------------------//
			//  Step-4: Create Assessment//
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium,"beginNewEncounter"))
				Assert.assertTrue(click(selenium,"beginNewEncounter"),"Could not click the link");
			selenium.isAlertPresent();
			selenium.chooseOkOnNextConfirmation();
			//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click ‘OK’ to continue, or ‘Cancel’ to stay on this page.","Navigation confirmation Message is not displayed");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"//td[2]/div/div/div[2]/div"))
				Assert.fail("Note messaqge present");
			else
				returnValue=true;
			
			//--------------------------------------------------------------------//
			//  Step-5: Save the encounter//
			//--------------------------------------------------------------------//
			selenium.clickAt("actionAnchorEncounter", "");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium,"saveEncounter"),"Could not click the save button");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Edit the encounter//
			//--------------------------------------------------------------------//
			Assert.assertTrue(isElementPresent(selenium,"//div[3]/button"),"Could not find the begin encounter button");
			Assert.assertTrue(click(selenium,"//div[3]/button"),"Could not begin encounter");
			//div[7]/div/div/table/tbody/tr/td/div/div/table/tbody/tr
			if(isElementPresent(selenium,"//div[7]/div/div/table/tbody/tr/td/div/div/table/tbody/tr"))
				Assert.assertTrue(click(selenium,"//div[7]/div/div/table/tbody/tr/td/div/div/table/tbody/tr"),"Could not click the link");
			selenium.isAlertPresent();
			selenium.chooseOkOnNextConfirmation();
			//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click ‘OK’ to continue, or ‘Cancel’ to stay on this page.","Navigation confirmation Message is not displayed");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);

			if(isElementPresent(selenium, "errorCloseButton"))
				Assert.assertTrue(click(selenium, "errorCloseButton"));
			
			Assert.assertTrue(enterDate(selenium,"css=input.gwt-DateBox",allergyData.date1),"Could not enter the date ;More Details:"+allergyData.toString());
			waitForPageLoad(selenium);
			selenium.clickAt("actionAnchorEncounter", "");
			//--------------------------------------------------------------------//
			//  Step-5: Save the encounter//
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"saveEncounter"),"Could not click the save button");
			waitForPageLoad(selenium);
			
			//-----------------------------------------------------------//
			//  Step-6: Go to  securitySetting and navigate to Audit Log //
			//-----------------------------------------------------------//
			Assert.assertTrue(goToAuditLogFromChartPreVisit(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			//------------------------------------------------//
			//Step-7: Verify Audit log for External Providers //
			//------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, allergyData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, allergyData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify whether External Providers gets saved properly //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForAllergy(selenium,allergyData)){
				Assert.fail("User details not saved properly; More Details :"+ allergyData.toString());
				returnValue=false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + allergyData.toString());
		} 
		return returnValue;
		
	}
	private boolean verifyStoredValuesForAllergy(Selenium selenium,AuditLogLib idGroupData) {

		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate=DateFormat.format(cal.getTime());
		if(!getText(selenium,"collapsableDesc").trim().contains(systemDate.trim())){
			return false; 
		} 
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(idGroupData.active.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(idGroupData.date1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
