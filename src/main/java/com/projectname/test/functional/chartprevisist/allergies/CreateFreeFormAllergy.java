package com.projectname.test.functional.chartprevisist.allergies;


import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.pages.AllergyPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;

@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class CreateFreeFormAllergy  extends TestBaseClass  {
	
	private SharedPage sharedPage;
	private AllergyPage allergyPage;
	private PatientChartPage patientChartPage;
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verifying free form allergy")
	@Parameters({"userAccount","webSite","browser"})
	public void createFreeFormAllergy(String userAccount,String webSite,String browser) throws Exception 
	 {className=this.getClass().getName().substring(39); 

	 methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	 ChartPreVisitLib allergyData = new ChartPreVisitLib();
	 allergyData.workSheetName = "CreateAllergy";
	 allergyData.testCaseId = "TC_CA_045";
	 allergyData.fetchChartPreVisitTestData();
	 createAllergy(allergyData,userAccount);
	 }
	

	/**
     * To Verify the creation of free form allergy
     * @Author Aspire QA
     * @since  Jan 22, 2014
     */

	@SuppressWarnings("static-access")
	public boolean createAllergy(ChartPreVisitLib allergyData,String userAccount){
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application                                  //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, allergyData.userName, allergyData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Search a patient and go to patient chart                  //
			//--------------------------------------------------------------------//
			logTitleMessage("Search for a patient");
			sharedPage=homePage.navigateToSharedPage();
			patientChartPage=sharedPage.searchPatientForTestingtester(driver, allergyData.patientId);
			logTitleMessage("Navigation to patient chart is Successful");
				
			//--------------------------------------------------------------------//
			//  Step-3: Go to Allergy page and delete existing allergies          //
			//--------------------------------------------------------------------//
			logTitleMessage("Navigation to Allergy screen");
			allergyPage=patientChartPage.navigateToAllergy(driver);
			logTitleMessage("Navigation to Allergy screen successful");
			logTitleMessage("Deleting existing allergies");
			patientChartPage.deleteAllAllergy(allergyPage,driver, allergyData);
			logTitleMessage("Deletion Successful");
			//--------------------------------------------------------------------//
			//  Step-4: Create free form allergy                                  //
			//--------------------------------------------------------------------//
			logTitleMessage("Creating free form allergy");
			patientChartPage.createAllergy(allergyPage,driver, allergyData,userAccount);
			logTitleMessage("Allergy Successful");
			//--------------------------------------------------------------------//
			//  Step-5: Verify creation of free form allergy                      //
			//--------------------------------------------------------------------//
			logTitleMessage("Verify created free form allergy");
			assertTrue(patientChartPage.verifyTextPresent(allergyData.allergenCa), "Allergy details not present",driver,className,methodName);
			logTitleMessage("Free form allergy creation successful");
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(sharedPage.getCurrentMethodName(), empty, empty, "fail", empty, getCallingMethodAndLineNumber()) );
		}catch(Exception e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(sharedPage.getCurrentMethodName(), empty, empty, "fail", empty, getCallingMethodAndLineNumber()) );
		}
	return returnValue;
}

}
