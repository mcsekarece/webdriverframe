package com.projectname.test.functional.demographics.patientcreation;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.Constants;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.DemographicsPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class VerifyDoNotContactOnPraticeLevel extends TestBaseClass {
	@Test(retryAnalyzer = RetryRule.class,groups = {"Regression"},description = "Test for verify DNC feature for different practice")
	@Parameters({ "userAccount", "website","browser" })
	public void verifyDNCinPracticeLevel(String userAccount,String webSite, String browser)
	{
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "PatientData";
	    patientData.testCaseId = "TC_NPC_001";
		patientData.fetchHomeTestData();
		createPatientWithDoNotDisturb(patientData,userAccount);
	}
	/*
	* @purpose To verify the Do Not Contact functionality on patient registration page
	* @author AspireQA
	* @since December 24, 2014
	* @version 2.1
	*/
	public boolean createPatientWithDoNotDisturb(HomeLib patientData,String userAccount)
	{
		PatientRegistationPage patientRegPage=null;
		SharedPage sharedPage=null;
		LoginPage loginPage=null;
		DemographicsPage demographicsPage=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver, Constants.userAccount, patientData.userName, patientData.userPassword);
			logTitleMessage("Login Successful");
			//---------------------------------------------------------------------//
			//  Step-2:  Select Practice                                          //
			//--------------------------------------------------------------------//
			sharedPage=homePage.navigateToSharedPage();
			//--------------------------------------------------------------------//
			//  Step-2: Create a patient with Mandatory fields                    //
			//--------------------------------------------------------------------//
			logTitleMessage("Navigate to patient Registration page and create a new patient with Do Not Contact");
			patientRegPage=sharedPage.goToPatientRegPage(driver);
			patientRegPage.createPatientWithDNC(driver, patientData,Constants.userAccount);
			demographicsPage=new DemographicsPage();
			logTitleMessage("Patient created successfully with Do Not Contact");
			//--------------------------------------------------------------------//
			//   Step-3: Verify on the patient page                               //
			//--------------------------------------------------------------------//
			logTitleMessage("Verify DNC on patient info page");
			demographicsPage.verifyDoNotDisturbStatusDemographicsPage(driver);
			logTitleMessage("DNC verified on patient info page");
			//--------------------------------------------------------------------//
			//   Step-4: switch practice                                          //
			//--------------------------------------------------------------------//
			logTitleMessage("Switch Practice");
			sharedPage.selectPractice(driver,patientData.pageData);
			logTitleMessage("Practice changed");
			logTitleMessage("Navigate to patient Registration page and create a new patient without DNC");
			patientRegPage=sharedPage.goToPatientRegPage(driver);
			//--------------------------------------------------------------------//
			//   Step-5: create Patient with Mandatory field                      //                                                                  //
			//--------------------------------------------------------------------//
			patientRegPage.createPatientWithMandatory(driver, patientData, Constants.userAccount);
			logTitleMessage("Patient created successfully without Do Not Contact");
			logTitleMessage("Verify on patient info page");
			demographicsPage.verifyDoNotDisturbStatusOnAnthorPractice(driver);
			logTitleMessage("Verified on patient info page");
		}catch(Exception e)
		{
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
		}
		return true;
	}
}