package com.projectname.test.functional.billing.statementgeneration;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.BillingLib;
import com.projectname.testutils.pages.BillingHistoryPage;
import com.projectname.testutils.pages.BillingStatementsPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.PostChargesPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyFinancialStatusWithDonotSendOption extends TestBaseClass{
	
	private PostChargesPage postChargesPage;
	private	BillingHistoryPage billingHistoryPage;

	private BillingStatementsPage billingStatementsPage;
	private HomePage homePage;
	private SharedPage sharedPage;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Financial Status With Don't Send Statement Option",dependsOnGroups = "statementPreferencesSetup")
	@Parameters({"userAccount","webSite","browser"})
	public void verifyFinancialStatusWithDonotSendOption(String userAccount,String webSite, String browser)  
	 {
			className = this.getClass().getName().substring(39);
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib chargeEntryData = new BillingLib();
			chargeEntryData.workSheetName = "ChargeEntry";
			chargeEntryData.testCaseId = "TC_CFS_001";
			chargeEntryData.fetchBillingTestData();
			statementGeneration(chargeEntryData,userAccount);
	 }
	
	/**
     *  To Verify Financial Status With Don't Send Statement Option
     * @param seleniumHost
     * @param seleniumPort
     * @param browser
     * @param webSite
	 * @throws Exception 
     * @throwsIOException
     * @since Dec 22, 2014
     */
 
public boolean statementGeneration(BillingLib chargeEntryData,String userAccount) {
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, chargeEntryData.userName, chargeEntryData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to Biller                                 // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to BILLER Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, chargeEntryData.switchRole);
			logTitleMessage("Switched the role to BILLER  Access Sucessfuly");
			
			// --------------------------------------------------------------------//
		    // Step-  6 : Switch to Practice A
		    // --------------------------------------------------------------------//

		    logTitleMessage("Switch to Practice A ");
			sharedPage.selectPractice(driver,chargeEntryData.practiceA);
			logTitleMessage("Sucessfully Switched to Practice A ");
	        
			// Get the Statement Counts
		    logTitleMessage("Get the Statement Counts ");
			Integer statementCountPracticeA = homePage.getStatementCount(driver);
			logTitleMessage("Got the Statement Counts Sucessfully ");
			
			// -----------------------------------------------------------------------------//
		    // Step- 7 : Set the  option for Patient Receive the Statement in Practice A
		    // ----------------------------------------------------------------------------//
				
			logTitleMessage("Set the  option for Patient Receive the Statement in Practice A");
			billingHistoryPage = sharedPage.navigateToBillingHistory(driver, chargeEntryData.patientID);
			
			billingStatementsPage = billingHistoryPage.goToBillingStatements(driver);

			billingStatementsPage.statementSendOptionSetUP(driver,chargeEntryData.practiceAStatementOption);
			
			logTitleMessage("Sucessfully Setup  the  option for Patient Receive the Statement in Practice A");
			// --------------------------------------------------------------------//
		    // Step-  9 : Switch Back to Practice B
		    // --------------------------------------------------------------------//

		    logTitleMessage("Switch to Practice B ");
			sharedPage.selectPractice(driver,chargeEntryData.practiceB);
			logTitleMessage("Sucessfully Switched to Practice B");
			
	        // Get the Statement Counts
			
		    logTitleMessage("Get the Statement Counts ");
			Integer statementCountPracticeB = homePage.getStatementCount(driver);
			logTitleMessage("Got the Statement Counts Sucessfully ");
			
			// -----------------------------------------------------------------------------//
		    // Step- 9 : Set the  option for Patient not  Receive the Statement in Practice B
		    // ----------------------------------------------------------------------------//
							
			logTitleMessage("Set the  option for Patient not  Receive the Statement in Practice B ");
			billingHistoryPage = sharedPage.navigateToBillingHistory(driver, chargeEntryData.patientID);
			billingStatementsPage = billingHistoryPage.goToBillingStatements(driver);
			billingStatementsPage.statementSendOptionSetUP(driver,chargeEntryData.practiceBStatementOption);
			logTitleMessage("Sucessfully Setup the  option for Patient not  Receive the Statement in Practice B ");
			
			// --------------------------------------------------------------------//
		    // Step- 10: Navigate to Charge Entry  Page
		    // --------------------------------------------------------------------//
	
			logTitleMessage("Navigate to Charge Entry  Page");
			postChargesPage=sharedPage.gotoChargeEntryPage(driver,  chargeEntryData.patientID);
			logTitleMessage("Sucessfully Navigated into Charge Entry  Page");
			
			// --------------------------------------------------------------------//
		    // Step- 11: Post the charge to the patient
		    // --------------------------------------------------------------------//
			
			logTitleMessage("Post the charge to the patient");
			postChargesPage.savePostChargeEntry(driver, chargeEntryData, userAccount);
			logTitleMessage("Sucessfully Posted the charge to the patient");
			
			// ---------------------------------------------------------------------------------------------//
		    // Step- 12 : Verify the Financial Status for patient in  Practice B before statement generation 
		    // ---------------------------------------------------------------------------------------------//
		
			logTitleMessage(" Verify the Financial Status for patient in  Practice B before statement generation ");
			billingHistoryPage.verifyFinancialStatus(driver, chargeEntryData);
			logTitleMessage("Sucessfully Verified the Financial Status for patient in  Practice B before statement generation ");
			
			// --------------------------------------------------------------------//
		    // Step-12 : Trigger the Statement
		    // --------------------------------------------------------------------//
			
			logTitleMessage("Trigger the Statement");
			sharedPage.statementTrigger(driver);
			logTitleMessage("Sucessfully Triggered the Statement");
			
			// ------------------------------------------------------------------------------//
		    // Step- 13 : Verify the Statement not generated for the  Same Patient in Practice B
		    // ------------------------------------------------------------------------------//
			logTitleMessage("Verify the Statement not generated for the  Same Patient in Practice B");
			
			Integer statementCountUpdatedPracticeB = homePage.getStatementCount(driver);
			
			if (!(statementCountUpdatedPracticeB.equals(statementCountPracticeB) )){
				Assert.fail("Verify the Statement not generated for the  Same Patient in Practice B Failed");
			}
			logTitleMessage("Sucessfully Verified  the Statement not generated for the  Same Patient in Practice B");
			
			// ---------------------------------------------------------------------------------------------//
		    // Step- 14 : Verify the Financial Status for patient in  Practice B after statement generation 
		    // ---------------------------------------------------------------------------------------------//
		
			logTitleMessage("Verify the Financial Status for patient in  Practice B after statement generation ");
			billingHistoryPage = sharedPage.navigateToBillingHistory(driver,chargeEntryData.patientID);
			billingHistoryPage.verifyFinancialStatus(driver, chargeEntryData);
			logTitleMessage("Sucessfully Verified the Financial Status for patient in  Practice B after statement generation ");
	       
			// --------------------------------------------------------------------------------//
		    // Step- 13 :  Verify the Statement generated for the same Patient in Practice A
		    // --------------------------------------------------------------------------------//
			
			// Switch to Practice A
			
			sharedPage.selectPractice(driver,chargeEntryData.practiceA);
			logTitleMessage("Verify the Statement generated for the same Patient in Practice A");
			Integer statementCountUpdatedA = homePage.getStatementCount(driver);
			
			if (!(statementCountUpdatedA > statementCountPracticeA)){
				System.out.println("Statement for the current date already created"); 
				logTitleMessage("Statement for the current date already created");
				return true;
			}
			
			logTitleMessage("Sucessfully Verified the Statement generated for the same Patient in Practice A");
			
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

