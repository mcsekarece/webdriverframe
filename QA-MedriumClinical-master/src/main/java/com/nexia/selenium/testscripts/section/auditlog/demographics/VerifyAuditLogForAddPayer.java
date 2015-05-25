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

public class VerifyAuditLogForAddPayer extends AbstractAuditLog {
	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
	public void verifyAuditLogForAddMedicalPayer(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		
		AuditLogLib payerData = new AuditLogLib();
		payerData.workSheetName = "AuditLogForPayers";
		payerData.testCaseId = "TC_ALPAY_001";
		payerData.fetchHomeTestData();
		verifyAuditLogForPayer(seleniumHost, seleniumPort, browser, webSite,userAccount, payerData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify AuditLog For Add Payer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
	public void verifyAuditLogForAddOtherPayer(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		
		AuditLogLib payerData = new AuditLogLib();
		payerData.workSheetName = "AuditLogForPayers";
		payerData.testCaseId = "TC_ALPAY_002";
		payerData.fetchHomeTestData();
		verifyAuditLogForPayer(seleniumHost, seleniumPort, browser, webSite,userAccount, payerData);
	}
	
	/**
	 *  VerifyAuditLogForAddPayer
	 * function to Verify AuditLog For AddPayer
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     Oct 21, 2013
	 */

	public boolean verifyAuditLogForPayer(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib payerData) throws IOException {

		Selenium selenium=null;
		String date =null;
		boolean returnValue=true;
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + payerData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, payerData.userName, payerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-2:Search Patient //
			//--------------------------------------------------------------------//
			
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Payers //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(payerData.testCaseId.equals("TC_ALPAY_001")){
				assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			if(payerData.testCaseId.equals("TC_ALPAY_002")){
				assertTrue(click(selenium,btnPatientOtherPayers),"Could not click the Others Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete all Payers //
			//--------------------------------------------------------------------//
			
			assertTrue(deleteAllPayers(selenium),"Delete All Payers failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium); 	
		
			//--------------------------------------------------------------------//
			//  Step-5: Create Payers //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnAddNewPayer), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	date=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
			}
			
			assertTrue(addNewPayer(selenium,payerData,date),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Go to  securitySetting and navigate to Audit Log //
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//Step-7: Verify Audit log for AddPayer
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(auditLog(selenium, payerData, userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(verifyStoredValue(selenium, payerData,userAccount),"Payer Detils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify whether Payer details saved properly //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			
			if(!verifyStoredValuesForPayers(selenium,payerData,date)){
				Assert.fail("Payer details not saved properly; More Details :"+ payerData.toString());
				returnValue=false;
			}else{
				return returnValue;
			}
	
			
		}
		catch(RuntimeException e ){
			e.printStackTrace();
		}
		
		return returnValue;
	}
	
	public boolean verifyStoredValuesForPayers(Selenium selenium,AuditLogLib payerData,String date) throws IOException{
		
		
/*		Calendar cal1=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate1=DateFormat1.format(cal1.getTime());*/

		if(payerData.testCaseId.equals("TC_ALPAY_001")){
			if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(payerData.payerName.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}else{
			
			if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(payerData.typeofCoverage.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		
		
		
		if(!getText(selenium,"collapsableDesc").trim().contains(date.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(payerData.payerName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(payerData.relationshipStatus.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(payerData.groupName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(payerData.groupNo.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(payerData.active.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
