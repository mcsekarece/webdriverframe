package com.nexia.selenium.testscripts.section.auditlog.chartprevisit;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForPatientLevelAllergyWarning extends AbstractAuditLog {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying AuditLog For Patient Level Allergy Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAuditLogForPatientLevelAllergyWarning(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib warningLevel = new AuditLogLib();
		warningLevel.workSheetName = "AuditLogForAllergy";
		warningLevel.testCaseId = "TC_CA_004";
		warningLevel.fetchHomeTestData();
		patientLevelWarningInAuditLog(seleniumHost, seleniumPort, browser, webSite,userAccount, warningLevel);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify AuditLog For Patient Level Allergy Warning
	* @action 		  Verifying AuditLog For Patient Level Allergy Warning
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      April 22, 2012
	***************************************************************************************************/
	public boolean patientLevelWarningInAuditLog(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib allergyData){
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			Assert.assertTrue(loginForNexiaFromProviderSite(selenium,userAccount , allergyData.userName, allergyData.userPassword),"Login Failed ");
			
			//---------------------------//
			// Step-2:Change Switch Role //
			//---------------------------//
			Assert.assertTrue(switchRole(selenium,allergyData.switchRole));
			waitForPageLoad(selenium);
			
			//-----------------------------------------------------------//
			//  Step-3: Navigate to practice level warning and set level //
			//-----------------------------------------------------------//
			Assert.assertTrue(click(selenium, "link=Quick actions"), "Could not click on Quick Actions button");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium, "css=#clinicalSettingsAction > span.actionItemSpan"), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium, "!interactionWarnings"), "Could not click on Interaction Warning button");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium, "css=button.gwt-Button"), "Could not click on Edit button");
			waitForPageLoad(selenium);
			
			if(!isChecked(selenium, "severeradio")){
				Assert.assertTrue(click(selenium, "severeradio"), "Could not select warning option");
			}
			Assert.assertTrue(click(selenium, "css=button.gwt-Button"), "Could not click on Save button");
			waitForPageLoad(selenium);
			
			
			//-------------------------------------------//
			//  Step-4: Advanced search with Patient ID  //
			//-------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientName);
			waitForPageLoad(selenium);
			
			//----------------------------------------------------------//
			//  Step-5: Navigate to patient level warning and set level //
			//----------------------------------------------------------//
			Assert.assertTrue(click(selenium, "link=Patient Options"), "Could not click on Quick Actions button");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium, "css=#patientOptionsInteractionWarnings > span.topMenuItemSpan.light"), "Could not click on Clinical settings");
			waitForPageLoad(selenium);
			
			if(!isChecked(selenium, "highradio")){
				Assert.assertTrue(click(selenium, "highradio"),"Could not set the warning level");
			}
			Assert.assertTrue(click(selenium, "css=span.buttons > button.gwt-Button"), "Could not click on save button");
			waitForPageLoad(selenium);
			
			//-----------------------------------------------------------//
			//  Step-6: Go to  securitySetting and navigate to Audit Log //
			//-----------------------------------------------------------//
			Assert.assertTrue(goToAuditLogFromChartPreVisit(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			//------------------------------------------------//
			//  Step-7: Verify Audit log for External Providers //
			//------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, allergyData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, allergyData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify whether External Providers gets saved properly //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForAllergy(selenium,allergyData, userAccount)){
				Assert.fail("User details not saved properly; More Details :"+ allergyData.toString());
				returnValue=false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + allergyData.toString());
		} 
		return returnValue;
		
	}
	private boolean verifyStoredValuesForAllergy(Selenium selenium,AuditLogLib idGroupData, String account) {
		String systemDate=null;
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("yyyy-MM-dd");
		systemDate=DateFormat.format(cal.getTime());
		
		if(!getText(selenium,"collapsableDesc").trim().contains(systemDate.trim())){
			return false; 
		} 
		
		return true;
	}
}
