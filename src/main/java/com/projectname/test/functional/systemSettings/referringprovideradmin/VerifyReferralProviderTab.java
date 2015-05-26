package com.projectname.test.functional.systemSettings.referringprovideradmin;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.SystemSettingsLib;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.ReferringProviderPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.pages.SystemSettingsPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class VerifyReferralProviderTab extends TestBaseClass {
	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private SystemSettingsPage systemSettingsPage=null;
	private ReferringProviderPage referringProviderPage=null;

	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Review" }, description = "verify Referral Provider Tab")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifyReferralProviderTab(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
			throws Exception {
		className = this.getClass().getName().substring(39);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		SystemSettingsLib referrralProviderData = new SystemSettingsLib();
		referrralProviderData.workSheetName = "CreateExternalProviders";
		referrralProviderData.testCaseId = "TC_RP_006";
		referrralProviderData.fetchSystemSettingTestData();
		verifyReferralProvider(referrralProviderData, userAccount);
	}
	@Test(retryAnalyzer = RetryRule.class, groups = { "Review" }, description = "verify Referral Provider Header")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifyReferralProviderHeader(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
			throws Exception {
		className = this.getClass().getName().substring(39);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		SystemSettingsLib referrralProviderData = new SystemSettingsLib();
		referrralProviderData.workSheetName = "CreateExternalProviders";
		referrralProviderData.testCaseId = "TC_RP_007";
		referrralProviderData.fetchSystemSettingTestData();
		verifyReferralProvider(referrralProviderData, userAccount);
	}
	@Test(retryAnalyzer = RetryRule.class, groups = { "Review" }, description = "verify Referral Provider With First Name and Last Name")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifyReferralProviderWithFNameLName(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
			throws Exception {
		className = this.getClass().getName().substring(39);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		SystemSettingsLib referrralProviderData = new SystemSettingsLib();
		referrralProviderData.workSheetName = "CreateExternalProviders";
		referrralProviderData.testCaseId = "TC_RP_008";
		referrralProviderData.fetchSystemSettingTestData();
		verifyReferralProvider(referrralProviderData, userAccount);
	}
	@Test(retryAnalyzer = RetryRule.class, groups = { "Review" }, description = "verify Referral Provider With Practice Name")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifyReferralProviderWithPracticeName(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
			throws Exception {
		className = this.getClass().getName().substring(39);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		SystemSettingsLib referrralProviderData = new SystemSettingsLib();
		referrralProviderData.workSheetName = "CreateExternalProviders";
		referrralProviderData.testCaseId = "TC_RP_009";
		referrralProviderData.fetchSystemSettingTestData();
		verifyReferralProvider(referrralProviderData, userAccount);
	}
	@Test(retryAnalyzer = RetryRule.class, groups = { "Review" }, description = "verify Referral Provider With All Mandatory Fields")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifyReferralProviderWithAllMandatory(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
			throws Exception {
		className = this.getClass().getName().substring(39);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		SystemSettingsLib referrralProviderData = new SystemSettingsLib();
		referrralProviderData.workSheetName = "CreateExternalProviders";
		referrralProviderData.testCaseId = "TC_RP_010";
		referrralProviderData.fetchSystemSettingTestData();
		verifyReferralProvider(referrralProviderData, userAccount);
	}
	@Test(retryAnalyzer = RetryRule.class, groups = { "Review" }, description = "verify Referral Provider Edit")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifyReferralProviderEdit(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
			throws Exception {
		className = this.getClass().getName().substring(39);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		SystemSettingsLib referrralProviderData = new SystemSettingsLib();
		referrralProviderData.workSheetName = "CreateExternalProviders";
		referrralProviderData.testCaseId = "TC_RP_011";
		referrralProviderData.fetchSystemSettingTestData();
		verifyReferralProvider(referrralProviderData, userAccount);
	}
	/**
	 * Create New patient function to add a new patient
	 * 
	 * @param patientData
	 * @param browser
	 * @param webSite
	 * @throws Exception
	 * @since Nov 24, 2012
	 * @version 2.1
	 */

	public boolean verifyReferralProvider(SystemSettingsLib referrralProviderData,
			String userAccount) throws Exception {
		boolean returnValue = true;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date = DateFormat.format(cal.getTime());
		
		try {
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, referrralProviderData.userName, referrralProviderData.userPassword);
			logTitleMessage("Login Successful");	
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch Role                                  			  //
			//--------------------------------------------------------------------//
			sharedPage=homePage.navigateToSharedPage();
			logTitleMessage("Switch Role");
			sharedPage.switchRole(driver, referrralProviderData.switchRole);
			logTitleMessage("Switch Role Successfull");
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Referring Provider Page           			  //
			//--------------------------------------------------------------------//
			logTitleMessage("Navigate to Referring Provider Page");
			systemSettingsPage= sharedPage.goToSystemSettings(driver);
			referringProviderPage=systemSettingsPage.goToReferringProviderPage(driver);
			logTitleMessage("Navigation Successfull");
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete the existing Providers                  			  // 
			//--------------------------------------------------------------------//
			logTitleMessage("Delete the existing Providers");
			if(referrralProviderData.testCaseId.equals("TC_RP_008")||referrralProviderData.testCaseId.equals("TC_RP_010")||referrralProviderData.testCaseId.equals("TC_RP_011")){
				systemSettingsPage.deleteExternalProvider(driver, referrralProviderData.firstName, referringProviderPage);
			}else if(referrralProviderData.testCaseId.equals("TC_RP_009")){
				systemSettingsPage.deleteExternalProvider(driver, referrralProviderData.practiceNameReferral, referringProviderPage);
			}
			logTitleMessage("Deletion successfull");
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Referring Provider Tab                  			  // 
			//--------------------------------------------------------------------//
			logTitleMessage("Verify Referring Provider Tab");
			if(referrralProviderData.testCaseId.equals("TC_RP_006")){
				assertTrue(systemSettingsPage.isTextPresent("Referring Providers"), "Referring Providers is not present" , driver, className, methodName);
				assertTrue(!systemSettingsPage.isTextPresent("External Providers"), "External Providers is present" , driver, className, methodName);
				return true;
			}
			logTitleMessage("Verification Successfull");
			
			//--------------------------------------------------------------------//
			//  Step-6: Go to Referring Provider and verify its  tabbing order    // 
			//--------------------------------------------------------------------//
			logTitleMessage("Go to Referring Provider and verify its  tabbing order");
			referringProviderPage.clickAddNewExternalProvider(driver);
			if(referrralProviderData.testCaseId.equals("TC_RP_007")){
				assertTrue(referringProviderPage.isTextPresent("Add Referring Provider"), "Add Referring Providers is not present" , driver, className, methodName);
				systemSettingsPage.verifyTabbingOrderForReferralPage(referringProviderPage);
				return true;
			}
			logTitleMessage("Verification for tabbing order is successfull");
						
			//--------------------------------------------------------------------//
			//  Step-7: Add new referring Provider                  			  // 
			//--------------------------------------------------------------------//
			logTitleMessage("Add new referring Provider");
			referrralProviderData.referringCode=referrralProviderData.referringCode+date;
			systemSettingsPage.addNewReferringProvider(driver, referrralProviderData, referringProviderPage);
			assertTrue(systemSettingsPage.clickSaveReferralProvider(driver, referringProviderPage), "Could not click Save Button" , driver, className, methodName);
			logTitleMessage("Referring Provider added successfully");

			//--------------------------------------------------------------------//
			//  Step-8: Search for the created Provider               			  // 
			//--------------------------------------------------------------------//
			logTitleMessage("Search for the created Provider");
			if(referrralProviderData.testCaseId.equals("TC_RP_008")||referrralProviderData.testCaseId.equals("TC_RP_010")||referrralProviderData.testCaseId.equals("TC_RP_011")){
				systemSettingsPage.searchReferralProvider(driver, referrralProviderData.firstName, referringProviderPage);
			}else if(referrralProviderData.testCaseId.equals("TC_RP_009")){
				systemSettingsPage.searchReferralProvider(driver, referrralProviderData.practiceNameReferral, referringProviderPage);
			}
			logTitleMessage("Search Successfull");
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify the created Provider                 			  // 
			//--------------------------------------------------------------------//
			logTitleMessage("Verify the created Provider");
			if(!referrralProviderData.testCaseId.equals("TC_RP_011")){
				assertTrue(systemSettingsPage.verifyReferralSummary(referrralProviderData.lastName,referrralProviderData.firstName,referrralProviderData.practiceNameReferral, referringProviderPage), "Could not click Save Button" , driver, className, methodName);
				return true;
			}
			logTitleMessage("Verification Successfull");
			
			//--------------------------------------------------------------------//
			//  Step-10: Edit the Referring Provider                  			  // 
			//--------------------------------------------------------------------//
			logTitleMessage("Edit the Referring Provider");
			assertTrue(systemSettingsPage.clickEditReferralProvider(driver, referringProviderPage), "Could not click Save Button" , driver, className, methodName);
			if(referrralProviderData.testCaseId.equals("TC_RP_011")){
				assertTrue(systemSettingsPage.isTextPresent("Edit Referring Provider"), "Referring Providers is not present" , driver, className, methodName);
				return true;
			}
			logTitleMessage("Editing Successfull");

		} catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}catch(Exception e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
		return returnValue;
	}
	
}
