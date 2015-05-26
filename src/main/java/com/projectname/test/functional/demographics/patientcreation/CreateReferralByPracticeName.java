package com.projectname.test.functional.demographics.patientcreation;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.genericutility.testDataLib.SystemSettingsLib;
import com.projectname.testutils.pages.CreateNewPracticePage;
import com.projectname.testutils.pages.CreateNewProviderPage;
import com.projectname.testutils.pages.DemographicsPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.OrganizationalStructurePage;
import com.projectname.testutils.pages.ReferralsPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.pages.SystemSettingsPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class CreateReferralByPracticeName extends TestBaseClass {
	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private SystemSettingsPage systemSettingsPage=null;
	private OrganizationalStructurePage organizationalStructurePage=null;
	private CreateNewProviderPage createNewProviderPage=null;
	private DemographicsPage demographicsPage=null;
	private ReferralsPage referralsPage=null;
	private CreateNewPracticePage createNewPracticePage=null;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Review" }, description = "VEL-7173:select the referring practice by name when creating a referral, either incoming our outgoing, in patient demographics.")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void enterReferralProviderWithPracticeName(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
			throws Exception {
		className = this.getClass().getName().substring(39);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		HomeLib referralData = new HomeLib();
		referralData.workSheetName = "CreateReferral";
		referralData.testCaseId = "TC_CRL_017";
		referralData.fetchHomeTestData();
		CreatePatientWithAllDetails(referralData, userAccount);
	}
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Review" }, description = "VEL-7173:select the referring practice by name when creating a referral, either incoming our outgoing, in patient demographics.")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void createReferralWithPracticeName(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
			throws Exception {
		className = this.getClass().getName().substring(39);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		HomeLib referralData = new HomeLib();
		referralData.workSheetName = "CreateReferral";
		referralData.testCaseId = "TC_CRL_018";
		referralData.fetchHomeTestData();
		CreatePatientWithAllDetails(referralData, userAccount);
	}
	@Test(retryAnalyzer = RetryRule.class, groups = { "Review" }, description = "VEL-7173:select the referring practice by name when creating a referral, either incoming our outgoing, in patient demographics.")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void createReferralWithOutGoingPatient(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
			throws Exception {
		className = this.getClass().getName().substring(39);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		HomeLib referralData = new HomeLib();
		referralData.workSheetName = "CreateReferral";
		referralData.testCaseId = "TC_CRL_019";
		referralData.fetchHomeTestData();
		CreatePatientWithAllDetails(referralData, userAccount);
	}
	@Test(retryAnalyzer = RetryRule.class, groups = { "Review" }, description = "VEL-7173:select the referring practice by name when creating a referral, either incoming our outgoing, in patient demographics.")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void createReferralWithOutGoingPatientWithPracticeName(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
			throws Exception {
		className = this.getClass().getName().substring(39);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		HomeLib referralData = new HomeLib();
		referralData.workSheetName = "CreateReferral";
		referralData.testCaseId = "TC_CRL_020";
		referralData.fetchHomeTestData();
		CreatePatientWithAllDetails(referralData, userAccount);
	}
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Review" }, description = "VEL-7173:select the referring practice by name when creating a referral, either incoming our outgoing, in patient demographics.")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void createReferralWithOutGoingWithPracticeNameAndLocation(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
			throws Exception {
		className = this.getClass().getName().substring(39);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		HomeLib referralData = new HomeLib();
		referralData.workSheetName = "CreateReferral";
		referralData.testCaseId = "TC_CRL_021";
		referralData.fetchHomeTestData();
		CreatePatientWithAllDetails(referralData, userAccount);
	}


	/**
	 * Create New patient function to add a new patient
	 * 
	 * @param patientData
	 * @param browser
	 * @param webSite
	 * @throws Exception
	 * @since Nov 24, 2012
	 */

	public boolean CreatePatientWithAllDetails(HomeLib referralData,
			String userAccount) throws Exception {
		boolean returnValue = true;
		SystemSettingsLib pracData = new SystemSettingsLib();
		try {
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, referralData.userName, referralData.userPassword);
			logTitleMessage("Login Successful");	
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Organizational Structure page								 	  //
			//--------------------------------------------------------------------//
			
			sharedPage=homePage.navigateToSharedPage();
			logTitleMessage("Switch Role");
			sharedPage.switchRole(driver, referralData.switchRole);
			logTitleMessage("Switch Role Successfull");
			
			if(referralData.testCaseId.equals("TC_CRL_017")||referralData.testCaseId.equals("TC_CRL_018")){
				logTitleMessage("Navigate to Organizational Structure page");
				systemSettingsPage= sharedPage.goToSystemSettings(driver);
		
				organizationalStructurePage= systemSettingsPage.goToOrganizationalStructure(driver);
				logTitleMessage("Navigated to Organizational Structure page successfully");
	
				//--------------------------------------------------------------------//
				//  Step-3: Create a new Provider								 	  //
				//--------------------------------------------------------------------//
				logTitleMessage("Create new provider 1");
				SystemSettingsLib providerData = new SystemSettingsLib();
				providerData.workSheetName = "CreateProvider";
				providerData.testCaseId = "TC_PO_011";
				providerData.fetchSystemSettingTestData();
	
				sharedPage.scrollDownPage(driver);
				systemSettingsPage.deleteProvider(driver, providerData, organizationalStructurePage);
				createNewProviderPage= systemSettingsPage.clickAddNewProvider(driver, organizationalStructurePage);
				systemSettingsPage.createNewProvider(driver, providerData, createNewProviderPage, organizationalStructurePage);
				logTitleMessage("Provider 1 created");
				
				logTitleMessage("Associate provider to a practice");
				pracData.workSheetName = "CreatePractice";
				pracData.testCaseId = "TC_CPR_016";
				pracData.fetchSystemSettingTestData();
	
				createNewPracticePage= systemSettingsPage.goToAssociateProviderToPractice(driver, pracData, organizationalStructurePage);
				systemSettingsPage.associateProviderToPractice(driver, providerData, createNewPracticePage, organizationalStructurePage);
				sharedPage.clickNexiaLogo(driver);
				logTitleMessage("provider successfully associated to practice");
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Patient Demographics					 	  //
			//--------------------------------------------------------------------//
			logTitleMessage("Create Referral");
			demographicsPage=sharedPage.searchPatientNexiaForProviderHomePage(driver,referralData.patientID );
			referralsPage=demographicsPage.goToReferral(driver);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create a new referral with Practice Name in Referred by   //
			//--------------------------------------------------------------------//
			logTitleMessage("Delete All Referrals");
			demographicsPage.deleteAllReferral(referralsPage, driver);
			logTitleMessage("All referrals deleted successfully");
			
			if(referralData.testCaseId.equals("TC_CRL_017")||referralData.testCaseId.equals("TC_CRL_018")){
			referralData.refBy=pracData.practiceName;
			}
			
			demographicsPage.clickAddReferral(referralsPage);
			demographicsPage.createReferral(referralsPage, driver, referralData);
			logTitleMessage("Referral created successfully");
			//-------------------------------------------------------------------------------//
			//  Step-6: Verify Created referral                                              //
			//-------------------------------------------------------------------------------//
			logTitleMessage("Verification");
			demographicsPage.verifyReferralSummary(referralsPage, referralData.refType,referralData.refBy,referralData.refTo,"");
			logTitleMessage("Verification Successful");
			logTitleMessage("Data fetching successfull");
			
		} catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}catch(Exception e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
		return returnValue;
	}
	
}
