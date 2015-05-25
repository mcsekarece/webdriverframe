package com.nexia.selenium.testscripts.section.smoketest;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.smoketest.SmokeTestLib;
import com.nexia.selenium.genericlibrary.smoketest.AbstractSmokeTest;
import com.thoughtworks.selenium.Selenium;


public class VerifyExistingPatients extends AbstractSmokeTest {
	
	@Test(groups = {"Smoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for adding various charprevisit info to Encounters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterListAll(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SmokeTestLib patientData = new SmokeTestLib();
		patientData.workSheetName = "VerifyExistingPatients";
		patientData.testCaseId = "TC_PAT_001";
		patientData.fetchSmokeTestData();
		visitPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	
	/**
	 * visitPatient
	 * function to test existing Patient
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	  * @since  	Feb 8, 2013
	 */
	
	public boolean visitPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SmokeTestLib patientData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			
				
			assertTrue(searchPatientNexiaForProviderHomePage_smoke(selenium,patientData.patientIdCA),"Selection failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
		    
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Second user //
			//--------------------------------------------------------------------//
						
			SmokeTestLib patientData2 = new SmokeTestLib();
			patientData2.workSheetName = "VerifyExistingPatients";
			patientData2.testCaseId = "TC_PAT_002";
			patientData2.fetchSmokeTestData();
			
			
			assertTrue(searchPatientNexiaForProviderHomePage_smoke(selenium,patientData2.patientIdCA),"Selection failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
		    
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Third user //
			//--------------------------------------------------------------------//
						
			SmokeTestLib patientData3 = new SmokeTestLib();
			patientData3.workSheetName = "VerifyExistingPatients";
			patientData3.testCaseId = "TC_PAT_003";
			patientData3.fetchSmokeTestData();
			
			
			assertTrue(searchPatientNexiaForProviderHomePage_smoke(selenium,patientData3.patientIdCA),"Selection failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
		    	
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Forth user //
			//--------------------------------------------------------------------//
						
			SmokeTestLib patientData4 = new SmokeTestLib();
			patientData4.workSheetName = "VerifyExistingPatients";
			patientData4.testCaseId = "TC_PAT_004";
			patientData4.fetchSmokeTestData();
			
			
			assertTrue(searchPatientNexiaForProviderHomePage_smoke(selenium,patientData4.patientIdCA),"Selection failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);				
			
		    
						
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Fifth user //
			//--------------------------------------------------------------------//
						
			SmokeTestLib patientData5 = new SmokeTestLib();
			patientData5.workSheetName = "VerifyExistingPatients";
			patientData5.testCaseId = "TC_PAT_005";
			patientData5.fetchSmokeTestData();
		
			assertTrue(searchPatientNexiaForProviderHomePage_smoke(selenium,patientData5.patientIdCA),"Selection failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
		    	
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Sixth user //
			//--------------------------------------------------------------------//
						
			SmokeTestLib patientData6 = new SmokeTestLib();
			patientData6.workSheetName = "VerifyExistingPatients";
			patientData6.testCaseId = "TC_PAT_006";
			patientData6.fetchSmokeTestData();
			
		
			assertTrue(searchPatientNexiaForProviderHomePage_smoke(selenium,patientData6.patientIdCA),"Selection failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		    	
			
			}					
		catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" );
		}
		return returnValue;
	}	
	
}