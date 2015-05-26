package com.projectname.test.functional.chartprevisist.encounterendtoend;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.pages.ClinicalSettingPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PracticeLibrary;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class AutomaticSaveAndApplyOfEncounterOne extends TestBaseClass {
	
	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private ClinicalSettingPage clinicalSettingPage;
	private PracticeLibrary practiceLibrary;
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Cancel Encounter")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void createNewSectionA(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort) throws Exception 
	 {className=this.getClass().getName().substring(39); 

	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
	 encounterTemplateTestData.workSheetName = "CreateVisitSection";
	 encounterTemplateTestData.testCaseId = "TC_VS_001";
	 encounterTemplateTestData.fetchClinicalSettingsTestData(); 
	 createNewSectionA(encounterTemplateTestData,userAccount);
	 }

	
	/**
	 * createNewSectionA
     *  Function to create new Section A
     * @param ClinicalSettingLib- Data to create Section 
	 * @param 		userAccount
	 * @since  	Mar 11, 2015
	 * @version 2.1
	 */

	public boolean createNewSectionA(ClinicalSettingLib encounterTemplateTestData,String userAccount) throws Exception{
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, encounterTemplateTestData.userName, encounterTemplateTestData.userPassword);
			logTitleMessage("Login Successful");			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to Full Access                             // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.selectPractice(driver,"EndToEnd");
			sharedPage.switchRole(driver, encounterTemplateTestData.switchRole);
			sharedPage.unlock(driver);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter Template 							  //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Navigate to Encounter Template");
			clinicalSettingPage = sharedPage.navigateToClinicalSettings(driver);
			practiceLibrary=clinicalSettingPage.navigateToEncounterTemplate(driver);
			logTitleMessage("Sucessfuly Navigated into Encounter Template");
			
			//--------------------------------------------------------------------//
			//  Step-4: Create a Custom section with widget 					  //
			//--------------------------------------------------------------------//
			logTitleMessage("Navigate To Visit section & Create a visit section");
			clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
			clinicalSettingPage.deleteAllCustomSection(driver, practiceLibrary);	
			clinicalSettingPage.createVisitSectionWithWidget(driver, encounterTemplateTestData, practiceLibrary);		
			//--------------------------------------------------------------------//
			//  Step-5: Add Created section with Default visit outline			  //
			//--------------------------------------------------------------------//			
			logTitleMessage(" Add Created section with Default visit outline");
			clinicalSettingPage.navigateToVisitoutline(driver, practiceLibrary);
			clinicalSettingPage.selectDefaultTemplate(driver, practiceLibrary);
			clinicalSettingPage.clickOnEncoEdit(driver, practiceLibrary);
			clinicalSettingPage.deleteCustomComponenetInEditDefalutPage(driver, practiceLibrary);
			clinicalSettingPage.addVisitSectionWithVisitOutline(driver, encounterTemplateTestData, practiceLibrary);
			logTitleMessage("Sucessfuly Added Created section with Default visit outline");			
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}


}
