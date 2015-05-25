package com.nexia.selenium.testscripts.section.auditlog.demographics;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;


import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForCreateConsents extends AbstractAuditLog{
	@Test(groups={"Regression","Approved","firefox", "iexplore", "safari", "default" },description = "Test for Adding a New Admin Consents")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyAuditLogForCreateConsents(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount)throws Exception{
		AuditLogLib consentData = new AuditLogLib();
		consentData.workSheetName="AuditLogForCreateConsents";
		consentData.testCaseId="TC_ALCons_001";
		consentData.fetchHomeTestData();
		verifyAuditLogForCreateConsents(seleniumHost, seleniumPort, browser, webSite, userAccount, consentData);
	}
	
	/**
	 * verifyAuditLogForCreateConsents
	 * function to verify audit log for create Consents
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    july 24, 2012
	 */
	public boolean verifyAuditLogForCreateConsents(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount,AuditLogLib consentData) throws IOException{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//Step-1:Login to the application
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + consentData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, consentData.userAccount, consentData.userName, consentData.userPassword),"Login Failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,consentData.switchRole));
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to System setting create Enter pries variable    //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"systemSettings"),"Could not click the System settings link;More Details:"+consentData.toString());
			waitForPageLoad(selenium);
			
			AuditLogLib epData = new AuditLogLib();
			epData.workSheetName = "ConsentsEnterPrise";
			epData.testCaseId = "TC_CEP_001";
			epData.fetchHomeTestData();
			
			Assert.assertTrue(createEnterPriseForConsents(selenium,epData));
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to security setting create consents    //
			//--------------------------------------------------------------------//
			AuditLogLib ssConsentsData = new  AuditLogLib();
			ssConsentsData.workSheetName = "SSConsents";
			ssConsentsData.testCaseId = "TC_SSC_001";
			ssConsentsData.fetchHomeTestData();
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium,"back"),"could not click security Settings");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium,"securitySettings"),"could not click security Settings");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium,"!adminConsentList"),"Could not click the Admin consent; More details"+ssConsentsData.toString());
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium,"addConsentType"),"Could not click the Admin consent; More details"+ssConsentsData.toString());
			waitForPageLoad(selenium);
			
			Assert.assertTrue(createSSConsents(selenium,ssConsentsData));
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//Step-5:Advanced search with Patient ID
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"back"),"could not click security Settings");
			waitForPageLoad(selenium);
			
			searchPatientNexia(selenium,consentData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,"!patientConsentsList");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			// Step-6:Deleting existing Consents for the selected patient 
			//--------------------------------------------------------------------//
					
			int counter=(Integer) selenium.getXpathCount("//div[@id='PatientConsentList']/table/tbody/tr/td[3]/div/a");
			while(isElementPresent(selenium,"//a[contains(text(),'Delete')]")){
			waitForPageLoad(selenium);
			click(selenium,"//a[contains(text(),'Delete')]");
			waitForPageLoad(selenium);
			click(selenium,"yesButton");
			waitForPageLoad(selenium);
			int counterAfterDeletion=(Integer) selenium.getXpathCount("//div[@id='PatientConsentList']/table/tbody/tr/td[3]/div/a");
			if((counter==counterAfterDeletion)&&(counterAfterDeletion!=0)){
				Assert.fail("Could not delete the consents;More Details:"+consentData.toString());
			}
			waitForPageLoad(selenium);
			counter--;
			}
			
			//--------------------------------------------------------------------//
			//Step-7:Create a new Consent
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(click(selenium,"consentadd"),"Could not Click on Add Consent Button:"+ consentData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(createConsent(selenium,consentData),"Consents creation Failed");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Go to Security Settings and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//Step-9: Verify Audit log for consents
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, consentData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, consentData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-10: Verify whether identifier gets saved properly //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForConsents(selenium,consentData)){
				Assert.fail("User details not saved properly; More Details :"+ consentData.toString());
				returnValue=false;
			}else{
				return returnValue;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + consentData.toString());
		}
		return returnValue;
	}
	public boolean verifyStoredValuesForConsents(Selenium selenium,AuditLogLib consentData){
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
		String systemDate=DateFormat.format(cal.getTime());
		if(!getText(selenium,"collapsableDesc").trim().contains(systemDate.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(consentData.consentName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(consentData.consentType.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(consentData.dateSigned.trim())){
			return false;
		}
		
		return true;
	}
}
