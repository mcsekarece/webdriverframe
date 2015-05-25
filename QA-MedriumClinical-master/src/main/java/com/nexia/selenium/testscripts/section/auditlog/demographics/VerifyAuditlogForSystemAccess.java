package com.nexia.selenium.testscripts.section.auditlog.demographics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditlogForSystemAccess extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Audit Log For System Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyAuditLogForSystemAccess(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib auditData = new AuditLogLib();
		auditData.workSheetName = "AuditLogForSystemAccess";
		auditData.testCaseId = "TC_CUAL_001";
		auditData.fetchHomeTestData();
		verifyAuditLogForSystemAccess(seleniumHost, seleniumPort, browser, webSite, userAccount,  auditData);
	}
	/**
	 * verifyAuditLogForSystemAccess
	 * function to verify AuditLog For SystemAccess
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 * @since  	    June 22, 2010
	 */
	public boolean verifyAuditLogForSystemAccess(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib auditData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + auditData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, auditData.userName, auditData.userPassword),"Login Failed ");
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,auditData.switchRole));
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-3: Go to System Setting  --------------// 
			//--------------------------------------------------------------------//	
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"securitySettings"),"Could not click the security setting link:More details:"+auditData.toString());
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-4: Go to Audit Log  --------------// 
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"!audit"),"Could not click the auditlog;More Details:"+auditData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(auditLog(selenium, auditData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			if(!verifyStoredValues(selenium,auditData)){
				Assert.fail("User details not saved properly; More Details :"+ auditData.toString());
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
		/*if(!getText(selenium,"collapsableTitle").trim().contains(auditData.patientId)){
			return false;
		}*/
		if(!getText(selenium,"collapsableTitle").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.section.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableTitle").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.action.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
