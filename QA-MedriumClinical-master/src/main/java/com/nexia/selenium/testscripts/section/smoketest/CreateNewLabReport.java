package com.nexia.selenium.testscripts.section.smoketest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.smoketest.SmokeTestLib;
import com.nexia.selenium.genericlibrary.smoketest.AbstractSmokeTest;
import com.thoughtworks.selenium.Selenium;


public class CreateNewLabReport extends AbstractSmokeTest{
	@Test(groups = {"Smoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void fileNewLabReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SmokeTestLib labData = new SmokeTestLib();
		labData.workSheetName = "CreateNewReport";
		labData.testCaseId = "TC_LR_001";
		labData.fetchSmokeTestData();
		fileNewReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}	
	
	/**
	 * fileNewReport
	 * function to file new lab report
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 07, 2012
	 */
	
	public boolean fileNewReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SmokeTestLib labData) throws IOException{
	
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labData.userName, labData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
									
			assertTrue(searchPatientNexiaForProviderHomePage_smoke(selenium,labData.patientId),"selection failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Existing lab reports//
			//--------------------------------------------------------------------//
			assertTrue(deletelabReport_smoke(selenium,labData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4:Navigation to File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(fileReportWithMandatory(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-6: verify Created lab report//
			//--------------------------------------------------------------------//
						
			if(isElementPresent(selenium,lnkActionsLink)){
				return returnValue;
			}else
				returnValue = false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data");
		}
		return returnValue;
	}	
}
