package com.projectname.test.functional.chartprevisist.superbill;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.BillingLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.BillingHistoryPage;
import com.projectname.testutils.pages.BillingStatementsPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.PostChargesPage;
import com.projectname.testutils.pages.ReferralsPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)

public class VerifyPostChargeAccess extends TestBaseClass{
	
	private PostChargesPage postChargesPage;
	private PatientRegistationPage patientRegistationPage;
	private HomePage homePage;
	private SharedPage sharedPage;

	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Post Charge Access - VEL-7292")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	
	public void verifyPostChargeAccess(String userAccount,String website,String browser,String seleniumHost,String seleniumPort) throws Exception {
	 
			className = this.getClass().getName().substring(39);
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "ChargeEntry";
			billingData.testCaseId = "TC_SCE_015";
			billingData.fetchBillingTestData();
			verifyPostChargeAccess(billingData,userAccount);
	 }

		/**
	     *  To Verify Post Charge Access - VEL-7292
	     * @param  billingData
	     * @param  Application Environment 
	     * @throwsIOException
	     * @since May 18, 2015
	     */
	 
	public boolean verifyPostChargeAccess(BillingLib billingData,String userAccount) throws Exception{
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
			
				//--------------------------------------------------------------------//
				//  Step-3: Create a new patient 	  								  //
				//--------------------------------------------------------------------//
				
				logTitleMessage("Create a new patient");
				sharedPage=homePage.navigateToSharedPage();
				patientRegistationPage= sharedPage.goToPatientRegPage(driver);
				HomeLib patientData = new HomeLib();	
				patientData.workSheetName = "NewPatientCheckIn";
				patientData.testCaseId = "TC_NPC_001";
				patientData.fetchHomeTestData();	
			    patientRegistationPage.createNewPatientWithMandatory(driver,patientData,userAccount);
				
			//	patientData.lastName = "MATHEW190515120511";
				logTitleMessage("Patient creation successful");
				
				// --------------------------------------------------------------------//
			    // Step- 4 : Navigate to Charge Entry  Page
			    // --------------------------------------------------------------------//
			
				logTitleMessage("Navigate to Charge Entry  Page");
				postChargesPage=sharedPage.gotoChargeEntryPage(driver,patientData.lastName);
				logTitleMessage("Sucessfully Navigated into Charge Entry  Page");
				
				// --------------------------------------------------------------------//
			    // Step-5: Post the charge 											   //
			    // --------------------------------------------------------------------//
				
				logTitleMessage("Post the charge to the patient");
				postChargesPage.savePostChargeEntry(driver, billingData, userAccount);
				logTitleMessage("Sucessfully Posted the charge to the patient");
				
				// --------------------------------------------------------------------//
			    // Step-6: Verify the Post Charge Access						       //
			    // --------------------------------------------------------------------//
			
				logTitleMessage("Verify the Post  charges");
				postChargesPage.verifyPostCharges(driver, billingData);
				logTitleMessage("Sucessfully Verified the Post  charges");
				
				
			}catch(RuntimeException e){
				new ExceptionHandler(e, driver, getCustomAttributeValue(ReferralsPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
			}
			
		return returnValue;
	}
}

