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

public class VerifyAuditLogForDeletePayer extends AbstractAuditLog {

		@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify AuditLog For Delete Payer")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
		public void verifyAuditLogForDeleteMedicalPayer(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
			
			AuditLogLib payerData = new AuditLogLib();
			payerData.workSheetName = "AuditLogForPayers";
			payerData.testCaseId = "TC_ALPAY_001";
			payerData.fetchHomeTestData();
			verifyAuditLogForPayer(seleniumHost, seleniumPort, browser, webSite,userAccount, payerData);
		}
		@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify AuditLog For Delete Payer")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
		public void verifyAuditLogForDeleteOtherPayer(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
			
			AuditLogLib payerData = new AuditLogLib();
			payerData.workSheetName = "AuditLogForPayers";
			payerData.testCaseId = "TC_ALPAY_002";
			payerData.fetchHomeTestData();
			verifyAuditLogForPayer(seleniumHost, seleniumPort, browser, webSite,userAccount, payerData);
		}
		
		/**
		 *  VerifyAuditLogForDeletePayer
		 * function to Verify AuditLog For DeletePayer
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
				
				if(payerData.testCaseId.equals("TC_ALPAY_003")){
					assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				
				if(payerData.testCaseId.equals("TC_ALPAY_004")){
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
				//  Step-6: Delete all Payers //
				//--------------------------------------------------------------------//
				
				assertTrue(deleteAllPayers(selenium),"Delete All Payers failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium); 	
				
				//--------------------------------------------------------------------//
				//  Step-7: Go to  securitySetting and navigate to Audit Log //
				//--------------------------------------------------------------------//
				
				Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//Step-8: Verify Audit log for AddPayer
				//--------------------------------------------------------------------//
				
				Assert.assertTrue(auditLog(selenium, payerData, userAccount),"Audit log Failed");
				waitForPageLoad(selenium);
				
				Assert.assertTrue(verifyStoredValue(selenium, payerData,userAccount),"Payer Detils are not display properly");
				waitForPageLoad(selenium);
				
			
		
				
			}
			catch(RuntimeException e ){
				e.printStackTrace();
			}
			
			return returnValue;
		}
		
	
}
