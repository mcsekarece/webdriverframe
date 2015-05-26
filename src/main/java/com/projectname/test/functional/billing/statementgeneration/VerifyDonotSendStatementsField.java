package com.projectname.test.functional.billing.statementgeneration;


import org.testng.annotations.Parameters;

import com.projectname.testutils.genericutility.testDataLib.BillingLib;

import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;

import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.BillingHistoryPage;
import com.projectname.testutils.pages.BillingStatementsPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.PostChargesPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyDonotSendStatementsField extends TestBaseClass{
	
	private PatientRegistationPage patientRegPage;
	private PostChargesPage postChargesPage;
	private	BillingHistoryPage billingHistoryPage;
	private BillingStatementsPage billingStatementsPage;
	private HomePage homePage;
	private SharedPage sharedPage;

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Donot Send Statements Field",dependsOnGroups = "statementPreferencesSetup")
	@Parameters({"userAccount","webSite","browser"})
	public void verifyDonotSendStatementsField(String userAccount,String webSite, String browser) 
	 {
			className = this.getClass().getName().substring(39);
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "BatchStatements";
			billingData.testCaseId = "TC_BS_002";
			billingData.fetchBillingTestData();
			statementGeneration(billingData,userAccount);
	 }
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Donot Send Statements Field",dependsOnGroups = "statementPreferencesSetup")
    @Parameters({"userAccount","webSite","browser"})
	public void generateStatementForCurrentPatient(String userAccount,String webSite, String browser) 
	 {
			className = this.getClass().getName().substring(39);
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "BatchStatements";
			billingData.testCaseId = "TC_BS_001";
			billingData.fetchBillingTestData();
			statementGeneration(billingData,userAccount);
	 }

		/**
	     *  To Verify Do not Statement Generation For Patient
	     * @param seleniumHost
	     * @param seleniumPort
	     * @param browser
	     * @param webSite
		 * @throws Exception 
	     * @throwsIOException
	     * @since Dec 16, 2014
	     */
	 
	public boolean statementGeneration(BillingLib billingData,String userAccount){
			boolean returnValue=true;
			
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				
				logTitleMessage("Login to application");
				LoginPage loginPage=new LoginPage();
				homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, billingData.userName, billingData.userPassword);
				logTitleMessage("Login Successful");
				
				//--------------------------------------------------------------------//
				//  Step-2: Switch the role to Biller                                 // 
				//--------------------------------------------------------------------//
				
				logTitleMessage("Switch the role to BILLER Access");
				sharedPage=homePage.navigateToSharedPage();
				sharedPage.switchRole(driver, billingData.switchRole);
				logTitleMessage("Switched the role to BILLER  Access Sucessfuly");
					
				// --------------------------------------------------------------------//
			    // Step- 4 : Switch to Practice A 
			    // --------------------------------------------------------------------//
				
		    	BillingLib chargeEntryData = new BillingLib();
				chargeEntryData.workSheetName = "ChargeEntry";
				chargeEntryData.testCaseId = "TC_CFS_003";
				chargeEntryData.fetchBillingTestData();
				
			    logTitleMessage("Switch to Practice A ");
				sharedPage.selectPractice(driver,chargeEntryData.practiceA);
				logTitleMessage("Sucessfully Switched to Practice A ");
				
				// --------------------------------------------------------------------//
			    // Step- 5 : Get the Statement Counts
			    // --------------------------------------------------------------------//
				
			    logTitleMessage("Get the Statement Counts ");
				Integer statementCount = homePage.getStatementCount(driver);
				logTitleMessage("Got the Statement Counts Sucessfully ");
		
				// --------------------------------------------------------------------//
			    // Step- 6 : Navigate to Billing Statements
			    // --------------------------------------------------------------------//
				
				logTitleMessage("Navigate to Billing Statements");
				billingHistoryPage = sharedPage.navigateToBillingHistory(driver, chargeEntryData.patientID);
				billingStatementsPage = billingHistoryPage.goToBillingStatements(driver);
				logTitleMessage("Sucessfully Navigated into Billing Statements");
				
				// --------------------------------------------------------------------//
			    // Step - 7: Set the  option for Patient not Receive the Statement 
			    // --------------------------------------------------------------------//
				
				logTitleMessage("Set the  option for Patient not Receive the Statement");
				billingStatementsPage.statementSendOptionSetUP(driver,chargeEntryData.practiceAStatementOption);	
				logTitleMessage("Sucessfully Set the  option for Patient not Receive the Statement");
				
				// --------------------------------------------------------------------//
			    // Step - 8 :  Verify the Do not Send Statements Check box is checked 
			    // --------------------------------------------------------------------//
			
				logTitleMessage(" Verify the Do not Send Statements Check box is checked");
				if(billingData.testCaseId.equalsIgnoreCase("TC_BS_002")) {
				
				billingHistoryPage = sharedPage.navigateToBillingHistory(driver, chargeEntryData.patientID);
				billingStatementsPage = billingHistoryPage.goToBillingStatements(driver);
				billingStatementsPage.verifyStatementSendOption(driver);
				logTitleMessage("Sucessfully verify the Do not Send Statements Check box is checked");
				return true;
				
				}
				
				// --------------------------------------------------------------------//
			    // Step- 9 : Navigate to Charge Entry  Page
			    // --------------------------------------------------------------------//
			
				logTitleMessage("Navigate to Charge Entry  Page");
				
				postChargesPage=sharedPage.gotoChargeEntryPage(driver, chargeEntryData.patientID);
				
				logTitleMessage("Sucessfully Navigated into Charge Entry  Page");
				
				// --------------------------------------------------------------------//
			    // Step-10: Post the charge to the patient
			    // --------------------------------------------------------------------//
				
				logTitleMessage("Post the charge to the patient");
				postChargesPage.savePostChargeEntry(driver, chargeEntryData, userAccount);
				logTitleMessage("Sucessfully Posted the charge to the patient");
				
				// --------------------------------------------------------------------//
			    // Step-11 : Trigger the Statement
			    // --------------------------------------------------------------------//
				
				logTitleMessage("Trigger the Statement");
				sharedPage.statementTrigger(driver);
				logTitleMessage("Sucessfully Triggered the Statement");
				
				// --------------------------------------------------------------------//
			    // Step- 12 : Get the Statement Count after run the URL
			    // --------------------------------------------------------------------//
				
				logTitleMessage(" Get the Statement Count after run the URL ");
				Integer statementCountUpdated = homePage.getStatementCount(driver);
				if (!(statementCountUpdated > statementCount)){
					System.out.println("Statement for the current date already created"); 
					logTitleMessage("Statement for the current date already created");
					return true;
				}
				// --------------------------------------------------------------------//
			    // Step- 13 : Verify the Statement generated for the Current Patient
			    // --------------------------------------------------------------------//
				
				logTitleMessage("Verify the Statement generated for the Current Patient");
				homePage.verifySetStatementGeneratedForCurrentPatient(driver,chargeEntryData.patientID);
				logTitleMessage("Sucessfully Verified the Statement generated for the Current Patient");
				
				
			}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
			}
			catch(Exception e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
			}
			
		return returnValue;
	}
}
