package com.nexia.selenium.testscripts.section.auditlog.demographics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForSocioEconomic extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyAuditLogForSocioEconomic(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib auditData = new AuditLogLib();
		auditData.workSheetName = "NewSocioEconomic";
		auditData.testCaseId = "TC_SE_001";
		auditData.fetchHomeTestData();
		verifyAuditLogForSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, auditData);
	}
	/**
	 * verifyAuditLogForSocioEconomic
	 * function to verify audit log for socio economic
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    Jun 20, 2012
	 */
	public boolean verifyAuditLogForSocioEconomic(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib auditData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + auditData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, auditData.userName, auditData.userPassword),"Login Failed ");
			
			//Advanced search with Patient ID
			
			searchPatientNexia(selenium,auditData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,"!patientSocialHistory");
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-2: Create a new Socio-Economic for a patient //
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(click(selenium,"css=button.gwt-Button"),"Could not Click on create Button:"+ auditData.toString());
			waitForPageLoad(selenium);
		
			Assert.assertTrue(createSocioEconomic(selenium,auditData),"Socio-Economic creation Failed");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			auditData.workSheetName = "AuditLogForSocioEconomic";
			auditData.testCaseId = "TC_ALSE_001";
			auditData.fetchHomeTestData();
			
			//--------------------------------------------------------------------//
			//---------------  Step-5: Go to Audit Log  --------------// 
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, auditData, userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "collapsableTitle")){
				returnValue=true;
			}else{
				Assert.fail("Audit log for socio Economic is not displayed"+auditData.toString());
				returnValue=false;
			}
			waitForPageLoad(selenium);
			if(!verifyStoredValues(selenium,auditData)){
				Assert.fail("audit log for socio Economic details not saved properly; More Details :"+ auditData.toString());
				returnValue=false;
			}else{
				return returnValue;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			returnValue=false;
		}
		return returnValue;
	}
	
	public boolean verifyStoredValues(Selenium selenium,AuditLogLib auditData){
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
		String systemDate=DateFormat.format(cal.getTime());
		
		
		if(!getText(selenium,"collapsableTitle").trim().contains(systemDate.trim())){
			return false; 
		}
		if(!getText(selenium,"collapsableTitle").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.user.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableTitle").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.userName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableTitle").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.practice.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableTitle").trim().contains(auditData.ipAddress.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableTitle").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.patientName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableTitle").trim().contains(auditData.patientID)){
			return false;
		}
		if(!getText(selenium,"collapsableTitle").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.section.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableTitle").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.action.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
