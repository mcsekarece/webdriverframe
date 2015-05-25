package com.nexia.selenium.testscripts.section.auditlog.demographics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestsForAuditLog extends AbstractHomeTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Start Date With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyStartDateWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite) throws Exception {
		HomeLibUnitTest auditData = new HomeLibUnitTest();
		 auditData.workSheetName = "UnitTest_FV_SS_AuditLog";
		 auditData.testCaseId = "TC_AL_001";
		 auditData.fetchHomeTestData();
		 runAuditLog(seleniumHost, seleniumPort, browser, webSite, auditData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "End Date With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyEndDateWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite) throws Exception {
		HomeLibUnitTest auditData = new HomeLibUnitTest();
		 auditData.workSheetName = "UnitTest_FV_SS_AuditLog";
		 auditData.testCaseId = "TC_AL_002";
		 auditData.fetchHomeTestData();
		 runAuditLog(seleniumHost, seleniumPort, browser, webSite, auditData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Activity Type With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyActivityTypeWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite) throws Exception {
		HomeLibUnitTest auditData = new HomeLibUnitTest();
		 auditData.workSheetName = "UnitTest_FV_SS_AuditLog";
		 auditData.testCaseId = "TC_AL_003";
		 auditData.fetchHomeTestData();
		 runAuditLog(seleniumHost, seleniumPort, browser, webSite, auditData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "User With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyUserWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite) throws Exception {
		HomeLibUnitTest auditData = new HomeLibUnitTest();
		 auditData.workSheetName = "UnitTest_FV_SS_AuditLog";
		 auditData.testCaseId = "TC_AL_004";
		 auditData.fetchHomeTestData();
		 runAuditLog(seleniumHost, seleniumPort, browser, webSite, auditData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Patient With Invalid Name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyPatientWithInvalidName(String seleniumHost, int seleniumPort,String browser, String webSite) throws Exception {
		HomeLibUnitTest auditData = new HomeLibUnitTest();
		 auditData.workSheetName = "UnitTest_FV_SS_AuditLog";
		 auditData.testCaseId = "TC_AL_005";
		 auditData.fetchHomeTestData();
		 runAuditLog(seleniumHost, seleniumPort, browser, webSite, auditData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Section With Invalid Name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifySectionWithInvalidName(String seleniumHost, int seleniumPort,String browser, String webSite) throws Exception {
		HomeLibUnitTest auditData = new HomeLibUnitTest();
		 auditData.workSheetName = "UnitTest_FV_SS_AuditLog";
		 auditData.testCaseId = "TC_AL_006";
		 auditData.fetchHomeTestData();
		 runAuditLog(seleniumHost, seleniumPort, browser, webSite, auditData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "User With Invalid Name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyUserWithInvalidName(String seleniumHost, int seleniumPort,String browser, String webSite) throws Exception {
		HomeLibUnitTest auditData = new HomeLibUnitTest();
		 auditData.workSheetName = "UnitTest_FV_SS_AuditLog";
		 auditData.testCaseId = "TC_AL_007";
		 auditData.fetchHomeTestData();
		 runAuditLog(seleniumHost, seleniumPort, browser, webSite, auditData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Start Date With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyStartDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite) throws Exception {
		HomeLibUnitTest auditData = new HomeLibUnitTest();
		 auditData.workSheetName = "UnitTest_FV_SS_AuditLog";
		 auditData.testCaseId = "TC_AL_008";
		 auditData.fetchHomeTestData();
		 runAuditLog(seleniumHost, seleniumPort, browser, webSite, auditData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "End Date With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyEndDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite) throws Exception {
		HomeLibUnitTest auditData = new HomeLibUnitTest();
		 auditData.workSheetName = "UnitTest_FV_SS_AuditLog";
		 auditData.testCaseId = "TC_AL_009";
		 auditData.fetchHomeTestData();
		 runAuditLog(seleniumHost, seleniumPort, browser, webSite, auditData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Activity Type With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyActivityTypeWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite) throws Exception {
		HomeLibUnitTest auditData = new HomeLibUnitTest();
		 auditData.workSheetName = "UnitTest_FV_SS_AuditLog";
		 auditData.testCaseId = "TC_AL_010";
		 auditData.fetchHomeTestData();
		 runAuditLog(seleniumHost, seleniumPort, browser, webSite, auditData);
	}
	
	/**
	 * runAuditLog
	 * function to run audit Log
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    Jun 22, 2012
	 */
	public boolean runAuditLog(String seleniumHost, int seleniumPort,String browser, String webSite, HomeLibUnitTest auditData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		String alertText="";
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + auditData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, auditData.userAccount, auditData.userName, auditData.userPassword),"Login Failed ");
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to System settings and audit log  //
			//--------------------------------------------------------------------//
			click(selenium,"securitySettings");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"!audit"),"Could not click on Audit log link:" +  auditData.toString());
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Enter Test Data and Submit //
			//--------------------------------------------------------------------//
			
				if(!auditLogUnitTest(selenium, auditData) && auditData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
					if(isElementPresent(selenium,"//p")){
						alertText = getText(selenium, "//p");
						if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(auditData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US"))))
						{
							return returnValue;			
						}else{
							Assert.fail("An unxpected Alert is displayed with message; The Expected :"+auditData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + auditData.toString());
						}
					}else{
						Assert.fail("Alert is not getting displayed; The Expected :"+auditData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + auditData.toString());
					}	
				}else if(auditData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
					return returnValue;
				}else{
					Assert.fail("Expected Alert is not displayed; The Expected :"+auditData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + auditData.toString());
				}
			} 
			
		catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + auditData.toString());
			returnValue=false;
		}
		return returnValue;
	}
	
	/**
	 * auditLogUnitTest
	 * function to run audit log unit tests
	 
	 * @since  	    Jun	22, 2012
	 */
	
	public boolean auditLogUnitTest(Selenium selenium, HomeLibUnitTest auditData ) throws InterruptedException{
		try{
			
			
			Assert.assertTrue(enterDate(selenium,"css=input.inlineBlock.inputBox",auditData.auditStartDate),"Could not enter the start date; More Details :" + auditData.toString());
			Assert.assertTrue(enterDate(selenium,"//input[2]",auditData.auditEndDate),"Could not enter the start date; More Details :" + auditData.toString());
			selectValueFromAjaxList(selenium,"filterUserssuggestBox",auditData.userFilter);
			click(selenium,"//div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"filterActivitysuggestBox",auditData.activityFilter);
			
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"filterPatientssuggestBox",auditData.patientFilter);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"filterSectionssuggestBox",auditData.sectionFilter);
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"search"),"Could not click the search button;More Details:"+auditData.toString());
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "collapsableTitle")){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + auditData.toString());		
			return false;
		}
	}
	
}
