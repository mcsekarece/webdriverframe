package com.nexia.selenium.testscripts.section.auditlog.systemsetting;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForDeleteExternalProvider extends AbstractAuditLog {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a External Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void createNewExternalProvider(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib providerData = new AuditLogLib();
		providerData.workSheetName = "AuditLogForExternalProvider";
		providerData.testCaseId = "TC_ALEP_003";
		providerData.fetchHomeTestData();
		deleteExternalProvidersForAuditLog(seleniumHost, seleniumPort, browser, webSite, providerData, userAccount);
	}
	/**
	 * createExternalProvider
	 * function to create External Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	     May 17, 2012
	 */
	
	public boolean deleteExternalProvidersForAuditLog(String seleniumHost, int seleniumPort,String browser, String webSite, AuditLogLib providerData,String userAccount) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, providerData.userAccount, providerData.userName, providerData.userPassword),"Login Failed ");
			
			//-----------------------------//
			//  Step-2:Change Switch Role  //
			//-----------------------------//
			Assert.assertTrue(switchRole(selenium,providerData.switchRole));
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to External Providers //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			click(selenium,"systemSettings");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"!adminExternalProviderList"),"Could not click on External Providers link:" + providerData .toString());
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-4: Deleting existing External Providers //
			//--------------------------------------------------------------------//
			Assert.assertTrue(deleteAllExternalProvider(selenium));
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Add a new External Provider //
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"addReferringProvider"),"Could not click on Add External Providers link:" + providerData .toString());
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueNo=DateFormat.format(cal.getTime());
			Assert.assertTrue(createExternalProvider(selenium,providerData,uniqueNo),"External Providers Creation failed");
			waitForPageLoad(selenium);
			
			//----------------------------------//
			//  Step-6: Delete External Provider  // 
			//----------------------------------//
			Assert.assertTrue(deleteAllExternalProvider(selenium));
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Go to  securitySetting and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// Step-8: Verify Audit log for External Providers
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, providerData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, providerData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}