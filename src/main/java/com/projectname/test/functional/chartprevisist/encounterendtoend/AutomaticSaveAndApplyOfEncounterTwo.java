package com.projectname.test.functional.chartprevisist.encounterendtoend;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.AllergyPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class AutomaticSaveAndApplyOfEncounterTwo extends TestBaseClass {
	
	private HomePage homePage=null;
	private SharedPage sharedPage=null;
	private PatientRegistationPage patientRegistationPage=null;
	private PatientChartPage patientChartPage=null;
	private EncounterPage encounterPage=null;
	private AllergyPage allergyPage=null;
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Cancel Encounter - 1")
	@Parameters({"userAccount","webSite","browser"})
	public void createNewPatient(String userAccount,String webSite,String browser) throws Exception 
	 {className=this.getClass().getName().substring(39); 

	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
	 encounterTemplateTestData.workSheetName = "CreateVisitSection";
	 encounterTemplateTestData.testCaseId = "TC_VS_013";
	 encounterTemplateTestData.fetchClinicalSettingsTestData(); 
	 createNewPatient(encounterTemplateTestData,userAccount);
	 }

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Cancel Encounter - 2")
	@Parameters({"userAccount","webSite","browser"})
	public void createNewPatientTwo(String userAccount,String webSite,String browser) throws Exception 
	 {className=this.getClass().getName().substring(39); 

	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
	 encounterTemplateTestData.workSheetName = "CreateVisitSection";
	 encounterTemplateTestData.testCaseId = "TC_VS_014";
	 encounterTemplateTestData.fetchClinicalSettingsTestData(); 
	 createNewPatient(encounterTemplateTestData,userAccount);
	 }
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Cancel Encounter - 3")
	@Parameters({"userAccount","webSite","browser"})
	public void createNewPatientThree(String userAccount,String webSite,String browser) throws Exception 
	 {className=this.getClass().getName().substring(39); 

	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
	 encounterTemplateTestData.workSheetName = "CreateVisitSection";
	 encounterTemplateTestData.testCaseId = "TC_VS_015";
	 encounterTemplateTestData.fetchClinicalSettingsTestData(); 
	 createNewPatient(encounterTemplateTestData,userAccount);
	 }

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Cancel Encounter - 4")
	@Parameters({"userAccount","webSite","browser"})
	public void createNewPatientFour(String userAccount,String webSite,String browser) throws Exception 
	 {className=this.getClass().getName().substring(39); 

	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
	 encounterTemplateTestData.workSheetName = "CreateVisitSection";
	 encounterTemplateTestData.testCaseId = "TC_VS_016";
	 encounterTemplateTestData.fetchClinicalSettingsTestData(); 
	 createNewPatient(encounterTemplateTestData,userAccount);
	 }

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Cancel Encounter - 5")
	@Parameters({"userAccount","webSite","browser"})
	public void createNewPatientFive(String userAccount,String webSite,String browser) throws Exception 
	 {className=this.getClass().getName().substring(39); 

	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
	 encounterTemplateTestData.workSheetName = "CreateVisitSection";
	 encounterTemplateTestData.testCaseId = "TC_VS_017";
	 encounterTemplateTestData.fetchClinicalSettingsTestData(); 
	 createNewPatient(encounterTemplateTestData,userAccount);
	 }

	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Cancel Encounter - 6")
	@Parameters({"userAccount","webSite","browser"})
	public void createNewPatientSix(String userAccount,String webSite,String browser) throws Exception 
	 {className=this.getClass().getName().substring(39); 

	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
	 encounterTemplateTestData.workSheetName = "CreateVisitSection";
	 encounterTemplateTestData.testCaseId = "TC_VS_018";
	 encounterTemplateTestData.fetchClinicalSettingsTestData(); 
	 createNewPatient(encounterTemplateTestData,userAccount);
	 }

	/**
	 * createNewSectionA
     *  Function to create new Section A
     * @param ClinicalSettingLib- Data to create Section 
	 * @param 		userAccount
	 * @since  	Mar 11, 2015
	 * @version 2.1
	 */

	public boolean createNewPatient(ClinicalSettingLib encounterTemplateTestData,String userAccount) throws Exception{
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
			//  Step-3: Create a new patient to check the Encounter template 	  //
			//--------------------------------------------------------------------//			
			logTitleMessage("Created A New Patient");		
			patientRegistationPage= sharedPage.goToPatientRegPage(driver);
			HomeLib patientData = new HomeLib();	
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();	
			logTitleMessage("Add Created section with Default visit outline");
			patientRegistationPage.createNewPatientWithMandatory(driver, patientData, userAccount);
			logTitleMessage("Sucessfuly Created A New Patient");			
			//--------------------------------------------------------------------//
			//  Step-4:Search newly created Patient							 	  //
			//--------------------------------------------------------------------//	
			logTitleMessage("Search newly created Patient");
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			logTitleMessage("Sucessfuly Search newly created Patient");
			//--------------------------------------------------------------------//
			//  Step-5:Verify Default template in Encounter Note				  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Begin an encounter and record values in widgets and save it ");
			encounterPage=patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			ChartPreVisitLib allergyData = new ChartPreVisitLib();
			allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CA_002";
			allergyData.fetchChartPreVisitTestData();
			allergyPage = patientChartPage.goToEncounterAllergy(driver, encounterPage);
			patientChartPage.createEncounterAllergy(driver, allergyData, userAccount, encounterPage, allergyPage);			
			//--------------------------------------------------------------------//
			//  Step-6:Record Values in Encounter Note Widgets 
			//--------------------------------------------------------------------//
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat DateFormat1 = new SimpleDateFormat("ddMMyyyymm:ss");
			String date1=null;
			date1 = DateFormat1.format(cal1.getTime());
			patientChartPage.recordWidgetsInEncounterNote(driver, encounterTemplateTestData,date1, encounterPage);
			//patientChartPage.saveEncounter(driver, encounterPage);
			logTitleMessage("Values are recorded in the widgets successfully");

			logTitleMessage("Verify recorded values - 1");
			if(encounterTemplateTestData.testCaseId.equals("TC_VS_013"))
			{
			sharedPage.goToPatientRegPage(driver);
			}
			else 	if(encounterTemplateTestData.testCaseId.equals("TC_VS_014"))
			{
				sharedPage.navigateToClinicalSettings(driver);
			}
			else 	if(encounterTemplateTestData.testCaseId.equals("TC_VS_015"))
			{
				sharedPage.goToFirstUnfinishedItem(driver);
				sharedPage.searchPatientForBillerRole(driver, patientData.lastName);
				sharedPage.clickNo(driver);
				sharedPage.selectPractice(driver,"EndToEnd");
				sharedPage.switchRole(driver, encounterTemplateTestData.switchRole);

			}
			else 	if(encounterTemplateTestData.testCaseId.equals("TC_VS_016"))
			{
				sharedPage.clickNexiaLogo(driver);
			}
			else 	if(encounterTemplateTestData.testCaseId.equals("TC_VS_017"))
			{
				sharedPage.searchPatientForTestingtester(driver, "100");
			}
			else 	if(encounterTemplateTestData.testCaseId.equals("TC_VS_018"))
			{
				sharedPage.clickBackButton(driver);
				sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
				encounterPage=patientChartPage.clickbeginEncounter(driver);
				patientChartPage.beginEncounter(driver, encounterPage);
				patientChartPage.gotoPendingEncounters(driver);
				patientChartPage.verfiyAllergyInShowMarkUp(driver, allergyData, userAccount);
				patientChartPage.verifyRecordedWidgetInEditMode(driver, encounterTemplateTestData, encounterPage);
				//patientChartPage.saveEncounter(driver, encounterPage);

				patientChartPage.clickEncounterTab(driver);
				patientChartPage.showMarkupInUnSignedEncounter(driver);
				sharedPage.verifyAlertNotPresent(driver);
				patientChartPage.verifyVersionInShowMarkUp(driver, 2);
				patientChartPage.verifyFirstRecordedWidgetInTimeLine(driver, encounterTemplateTestData, encounterPage);
				patientChartPage.verfiyAllergyInShowMarkUp(driver, allergyData, userAccount);

				return true;
			}

			sharedPage.searchPatientForTestingtester(driver, patientData.lastName);
			sharedPage.verifyAlertNotPresent(driver);
			patientChartPage.gotoPendingEncounters(driver);
			patientChartPage.verfiyAllergyInShowMarkUp(driver, allergyData, userAccount);
			patientChartPage.verifyRecordedWidgetInEditMode(driver, encounterTemplateTestData, encounterPage);
			patientChartPage.saveEncounter(driver, encounterPage);

			patientChartPage.clickEncounterTab(driver);
			patientChartPage.showMarkupInUnSignedEncounter(driver);
			sharedPage.verifyAlertNotPresent(driver);
			patientChartPage.verifyVersionInShowMarkUp(driver, 2);
			patientChartPage.verifyFirstRecordedWidgetInTimeLine(driver, encounterTemplateTestData, encounterPage);
			patientChartPage.verfiyAllergyInShowMarkUp(driver, allergyData, userAccount);
			logTitleMessage("Show Mark up verified successfully");
			

			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}


}
