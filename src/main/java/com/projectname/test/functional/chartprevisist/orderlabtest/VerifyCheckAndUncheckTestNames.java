package com.projectname.test.functional.chartprevisist.orderlabtest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.LabOrderPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;


@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class VerifyCheckAndUncheckTestNames extends TestBaseClass{

	private SharedPage sharedPage;
	private PatientChartPage patientChartPage;
	private EncounterPage encounterPage;
	private LabOrderPage labOrderPage;
	
	
	@Test(retryAnalyzer = RetryRule.class, groups = { "Regression" }, description = "Test for Verify Check And Uncheck Test Names, Ticket = VEL-2209" )
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	
	public void verifyCheckAndUncheckTestNames(String userAccount,String website,String browser,String seleniumHost,String seleniumPort)  throws Exception 
	 {
		    className = this.getClass().getName().substring(39);
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ChartPreVisitLib diData = new ChartPreVisitLib();
			diData.workSheetName = "CreateLabOrder";
			diData.testCaseId = "TC_NLO_001";
			diData.fetchChartPreVisitTestData();
			createLabOrder(diData,userAccount);
	 }
	
	/**
	 *  VerifyCheckAndUncheckTestNames
     *  To Verify Check And Uncheck Test Names
     *  @param dIData(Order template details to be added )
     *  @param userAccount(Application Environment)
     *  @since Jan 29, 2015
     */
	
	
	public boolean createLabOrder(ChartPreVisitLib diData,String userAccount) throws Exception {
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, diData.userName, diData.userPassword);
			logTitleMessage("Login Successful");
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch the role to FULL Access                            // 
			//--------------------------------------------------------------------//
			
			logTitleMessage("Switch the role to FULL Access");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.switchRole(driver, diData.switchRole);
			logTitleMessage("Switched the role to FULL Access Sucessfully");
					
			//--------------------------------------------------------------------//
			//  Step-3:Search the Patient							 	 		  //
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Search the Patient");
			patientChartPage = sharedPage.searchPatientForTestingtester(driver, diData.patientId);
			logTitleMessage("Sucessfully Searched the Patient");
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Begin encounter page 						  // 
			//--------------------------------------------------------------------//		
			
			logTitleMessage("Navigate to Begin encounter page");
			encounterPage = patientChartPage.clickbeginEncounter(driver);
			patientChartPage.beginEncounter(driver, encounterPage);
			logTitleMessage("Sucessfully Navigated into Begin encounter page");
						
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Create New Lab Order Page				      // 
			//--------------------------------------------------------------------//	
			
			logTitleMessage("Navigate to Create New Lab Order Page");
			labOrderPage = patientChartPage.goToCreateOrderLabTest(driver,encounterPage);
			logTitleMessage("Sucessfully Navigated to Create New Lab Order Page");
			
			//--------------------------------------------------------------------//
			//  Step-6:  Create New Lab Order				      				  // 
			//--------------------------------------------------------------------//	
							
			logTitleMessage("Create New Lab Order");
	        patientChartPage.createNewOrderLabTest(driver,diData,encounterPage,labOrderPage);
	        logTitleMessage("Sucessfully Created New Lab Order");
			
	        //--------------------------------------------------------------------//
			//  Step-7:  View previous the Lab Order 				      		  // 
			//--------------------------------------------------------------------//	
			
	        logTitleMessage("View Previous Lab Order");
	        patientChartPage.goTOOrderLabTest(driver,encounterPage);
	        logTitleMessage("Sucessfully Viewed Previous Lab Order");
	        	        
	       //-------------------------------------------------------------------- //
		   //  Step-8: Verify the Checked TestNames 		 			 		 // 
		   //--------------------------------------------------------------------//
	        
	        logTitleMessage("Verify the Checked TestNames");
	        patientChartPage.verifyCheckedOrderLabTest(driver,diData,encounterPage,labOrderPage);
	        logTitleMessage("Sucessfully Verified the Checked TestNames ");
	        
	       //-------------------------------------------------------------------- //
		   //  Step-9: Verify the Unchecked TestNames 		 			 		 // 
		   //--------------------------------------------------------------------//
		        
		     logTitleMessage("Verify the Unchecked TestNames");
		     patientChartPage.verifyUncheckedOrderLabTest(driver,diData,encounterPage,labOrderPage);
		     logTitleMessage("Sucessfully Verified the Unchecked TestNames ");
		     
		   
	        
			
		}catch(RuntimeException e){
			new ExceptionHandler(e, driver, getCustomAttributeValue(SharedPage.getCurrentMethodName(), empty, empty, "fail", "", getCallingMethodAndLineNumber()) );
		}
		
	return returnValue;
}
}
