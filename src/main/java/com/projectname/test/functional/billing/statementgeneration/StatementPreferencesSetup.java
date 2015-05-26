package com.projectname.test.functional.billing.statementgeneration;


import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.BillingLib;
import com.projectname.testutils.pages.BillingSettingsPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class StatementPreferencesSetup  extends TestBaseClass{
	private BillingSettingsPage billingSettingsPage;
	private HomePage homePage;
	private SharedPage sharedPage;

	@Test(retryAnalyzer = RetryRule.class, groups = {"Regression","statementPreferencesSetup"}, description = "Test for Verify Statement Preferences Setup")
	@Parameters({"userAccount","webSite","browser"})
	public void statementPreferencesSetup(String userAccount,String webSite, String browser) 
	 {
			className = this.getClass().getName().substring(39);
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "BatchStatements";
			billingData.testCaseId = "TC_BS_002";
			billingData.fetchBillingTestData();
			statementPreferencesSetup(billingData,userAccount);
	 }
	
	/**
     *  To Verify Statement Preferences Setup
     * @param seleniumHost
     * @param seleniumPort
     * @param browser
     * @param webSite
	 * @throws Exception 
     * @throwsIOException
     * @since Dec 22, 2014
     */
	
public boolean statementPreferencesSetup(BillingLib billingData,String userAccount) {
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
			   //  Step-3: Navigate to Billing settings  Page                    // 
			   //--------------------------------------------------------------------//
			    
				logTitleMessage("Navigate to Billing settings  Page ");
				
			    billingSettingsPage =  sharedPage.goToBillingSettingsPage(driver);
			    
				logTitleMessage("Sucessfully  Navigated into Billing settings  Page ");
			    
			    //--------------------------------------------------------------------//
			   //  Step-3: Navigate to Statement Preferences Page                    // 
			   //--------------------------------------------------------------------//
			    
				logTitleMessage("Navigate to Statement Preferences Page");
				
			    billingSettingsPage.goToStatementPreferences(driver);
			    
				logTitleMessage("Sucessfully  Navigated into Statement Preferences Page ");

			   //--------------------------------------------------------------------//
			   //  Step-4: Navigate to Statement Preferences Wizard Page             // 
			   //--------------------------------------------------------------------//
				logTitleMessage("Navigate to Statement Preferences  Wizard Page ");
					
			    billingSettingsPage.goToStatementPreferencesWizard(driver);
			    
				logTitleMessage("Sucessfully  Navigated into Statement Preferences Wizard Page");
			 
				
			   //--------------------------------------------------------------------//
			   //  Step-5: Statement cycle Generation Set up                         // 
			   //--------------------------------------------------------------------//
			    
				logTitleMessage("Statement cycle Generation Set up ");
				billingSettingsPage.statementCycleGenerationSetup(driver,billingData);
			    logTitleMessage("Set up Statement cycle Generation completed Sucessfully");
			    
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


	
	
	
	
	
	
	
	
	