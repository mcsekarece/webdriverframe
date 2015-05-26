package com.projectname.test.functional.clinicalsettings.practiceLibrary;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.Constants;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientPersonalInfoPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class CoSignEncounter extends TestBaseClass {
	
	private HomePage homePage=null;
	private SharedPage sharedPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private PatientRegistationPage patientRegPage;
	private PatientPersonalInfoPage patientPersonalInfoPage;

	@Test(retryAnalyzer = RetryRule.class, groups = {"SingleThread", "Review"}, description = "Test for Verify Cancel Encounter")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	public void verifyCoSignEncounter(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)throws Exception 
	 {className=this.getClass().getName().substring(39); 

	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "Cosign";
		encounterData.testCaseId = "TC_CO_018";
		encounterData.fetchChartPreVisitTestData();
		verifyCoSignEncounter(encounterData,userAccount);
	 }

	
	/**
	 * verifyCoSignEncounter
	 * Test case to verify if an encounter having a cosigner is available for the cosigner to sign and also check the access level of that encounter.
	 * @param encounterData 
	 * @param 		userAccount
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */

	public boolean verifyCoSignEncounter(ChartPreVisitLib encounterData,String userAccount){
		boolean returnValue=true;
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dateFormat=new SimpleDateFormat("ddyymm:HH:ss");
		String date=dateFormat.format(cal.getTime());
		String chiefComplaint=encounterData.chiefComplaint+date;
		encounterData.chiefComplaint=chiefComplaint;
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
		//SimpleDateFormat DateFormat1 = new SimpleDateFormat("HH:mm:ss");
		date = DateFormat.format(cal1.getTime());
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application                                  //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, encounterData.userName, encounterData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to Full Access                             // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			//sharedPage.switchRole(driver, encounterData.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfuly");
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to patient Registration and create new patient			  //
			//--------------------------------------------------------------------//
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();
			logTitleMessage("Navigate to Patient Chart");
			patientRegPage = sharedPage.goToPatientRegPage(driver);
			patientPersonalInfoPage=patientRegPage.createPatientWithMandatory(driver, patientData,
					Constants.userAccount);
			String patientId=patientPersonalInfoPage.getPatientId(driver);
			encounterData.patientId=patientId;
			
			patientChartPage = sharedPage.searchPatientForTestingtester(driver, encounterData.patientId);
			logTitleMessage("Navigation Successful");
								
			//--------------------------------------------------------------------//
			//  Step-4: Begin Encounter		  //
			//--------------------------------------------------------------------//
			logTitleMessage("Begin Encounter");
			encounterPage=patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			
			patientChartPage.enterComplaint(encounterPage,encounterData.chiefComplaint);
			
			patientChartPage.selectAssessment(encounterPage, encounterData.medicalCondition);
			
			//--------------------------------------------------------------------//
			//  Step-5: Fetch Data to Create new Problem List					  //
			//--------------------------------------------------------------------//		
			logTitleMessage("Fetch Data to create new Problem List");
			ChartPreVisitLib probData = new ChartPreVisitLib();
			probData.workSheetName = "CreateProblemList";
			probData.testCaseId = "TC_CPL_013";
			probData.fetchChartPreVisitTestData();
			logTitleMessage("Data fetching successfull");
			//--------------------------------------------------------------------//
			//  Step-6:Create new Problem List				 	  //
			//--------------------------------------------------------------------//
			logTitleMessage("Create new Problem List");			
			encounterData.userAccount=userAccount;
			patientChartPage.createProblemList(encounterPage, encounterData);
			logTitleMessage("Problem List created Successfully");
			//--------------------------------------------------------------------//
			//  Step-7:Sign Encounter				 	  //
			//--------------------------------------------------------------------//
			logTitleMessage("Sign the Encounter");
			patientChartPage.signEncounter(driver, encounterPage);
			logTitleMessage("Encounter Signed Successfully");
			//-------------------------------------------------------------------//
			//  Step-8:Verify if Cosign SuggestBox has provider linked to User testingtester //
			//------------------------------------------------------------------//
			logTitleMessage("Verify if Cosign SuggestBox has provider linked to User testingtester");
			assertTrue(patientChartPage.getCosigner(encounterPage).equals(encounterData.CosignProv), "Could not select Co-signer",driver,className,methodName);
			logTitleMessage("Verification successfull");
			//--------------------------------------------------------------------//
			//  Step-9: select proper cosigner and go to encounter tab				  //
			//--------------------------------------------------------------------//
			logTitleMessage("Select proper cosigner and go to encounter tab");
			patientChartPage.selectCosign(encounterPage, encounterData);
			
			patientChartPage.clickEncounterTab(driver);
			
			//--------------------------------------------------------------------//
			//  Step-10: verify if newly created encounter is present in pending list//
			//--------------------------------------------------------------------//
			logTitleMessage("Verify if newly created Encounter is present in pending list");
			assertTrue(patientChartPage.ifEncounterPendingListPresent(driver), "No Encounter Pending list present",driver,className,methodName);
			logTitleMessage("Verification Successfull");
			//--------------------------------------------------------------------//
			//  Step-11: log out of appliation					  //
			//--------------------------------------------------------------------//
			logTitleMessage("Logout of application");
			sharedPage.logoutofApplication(driver);
			logTitleMessage("Logout Successfull");
			//--------------------------------------------------------------------//
			//  Step-12: Fetch Data for new cosign login				  //
			//--------------------------------------------------------------------//
			logTitleMessage("Fetch data to login as User B");
			encounterData.workSheetName = "Cosign";
			encounterData.testCaseId = "TC_CO_019";
			encounterData.fetchChartPreVisitTestData();
			encounterData.chiefComplaint=chiefComplaint;
			logTitleMessage("Data fetching successfull");
			//--------------------------------------------------------------------//
			//  Step-13: Login to the application                                  //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			loginPage=new LoginPage();
			loginPage.loginForNexiaFromProviderSite(driver,userAccount, encounterData.userName, encounterData.userPassword);
			logTitleMessage("Login Successful");
			//--------------------------------------------------------------------//
			//  Step-14: go to unsigned encounter and verify the new created encounter is available //
			//--------------------------------------------------------------------//
			logTitleMessage("Go to unsigned encounter and verify if the newly created Encounter is available");
			sharedPage.clickUnsignedEncounterQueue(driver);
			sharedPage.searchUnsignedEncounter(driver, encounterData.chiefComplaint, encounterData.show);
			assertTrue(sharedPage.isUnsignedEncounterListPresent(), "No Encounter Pending list present in the queue",driver,className,methodName);
			String itemNum="1";
			logTitleMessage("Verification Successfull");
			
			//--------------------------------------------------------------------//
			//  Step-15: go to the newly created encounter and verify the data					  //
			//--------------------------------------------------------------------//
			logTitleMessage("Go to newly created encounter and verify the data");
			patientChartPage=sharedPage.selectEncounterListItem(itemNum);
			
			assertTrue(patientChartPage.verifyTextPresent(date), "Problem List details not present",driver,className,methodName);
			logTitleMessage("Verification successfull");
			//--------------------------------------------------------------------//
			//  Step-16: edit the encounter											  //
			//--------------------------------------------------------------------//
			logTitleMessage("Edit the Encounter");
			patientChartPage.editAssessmentInEncounterNote(encounterData);
			
			//--------------------------------------------------------------------//
			//  Step-17: sign the encounter				  //
			//--------------------------------------------------------------------//
			logTitleMessage("Sign the Encounter");
			patientChartPage.signEncounter(driver, encounterPage);
			patientChartPage.clickEncounterTab(driver);
			patientChartPage.ifEncounterSignedListPresent(driver);
			logTitleMessage("Encounter signed successfully");
			
			//--------------------------------------------------------------------//
			//  Step-18: log out of the application					  //
			//--------------------------------------------------------------------//
			logTitleMessage("Logout of the Applicaiton");
			sharedPage.logoutofApplication(driver);
			logTitleMessage("Logout Successfull");
			//--------------------------------------------------------------------//
			//  Step-19: Fetch Data to login as User C       					  //
			//--------------------------------------------------------------------//
			logTitleMessage("Fetch Data to login as User C");
			encounterData.workSheetName = "Cosign";
			encounterData.testCaseId = "TC_CO_020";
			encounterData.fetchChartPreVisitTestData();
			encounterData.patientId=patientId;
			logTitleMessage("Data fetching successfull");
			//--------------------------------------------------------------------//
			//  Step-20: Login to the application                                  //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			loginPage=new LoginPage();
			loginPage.loginForNexiaFromProviderSite(driver,userAccount, encounterData.userName, encounterData.userPassword);
			logTitleMessage("Login Successful");
			//--------------------------------------------------------------------//
			//  Step-21: go to the newly created encounter                                //
			//--------------------------------------------------------------------//
			logTitleMessage("Go to newly created Encounter");
			patientChartPage = sharedPage.searchPatientForTestingtester(driver, encounterData.patientId);
			patientChartPage.clickEncounterTab(driver);
			
			patientChartPage.selectActionButtonForSignedEncounter(1);
			
			//--------------------------------------------------------------------//
			//  Step-22: verify if delete option is available for the user                              //
			//--------------------------------------------------------------------//
			logTitleMessage("verify if delete option for the Encounter is available for the user(it should not be present");
			assertTrue(!patientChartPage.ifDeleteEncounterPresent(), "Delete button is present",driver,className,methodName);
			logTitleMessage("Verification Successfull");
			patientChartPage.clickExpandAll();
			//--------------------------------------------------------------------//
			//  Step-23:verify if all the data is present                            //
			//--------------------------------------------------------------------//
			logTitleMessage("Verify if all the data is present");
			assertTrue(patientChartPage.verifyTextPresent(date), "Problem List details not present properly",driver,className,methodName);
			logTitleMessage("Verification successfull");
				
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}catch(Exception e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}


}
