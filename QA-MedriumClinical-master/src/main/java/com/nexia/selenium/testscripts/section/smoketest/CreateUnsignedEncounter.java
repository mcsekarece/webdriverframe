package com.nexia.selenium.testscripts.section.smoketest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.smoketest.SmokeTestLib;
import com.nexia.selenium.genericlibrary.smoketest.AbstractSmokeTest;
import com.thoughtworks.selenium.Selenium;


public class CreateUnsignedEncounter extends AbstractSmokeTest{

	@Test(groups = {"Smoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void fileNewLabReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SmokeTestLib encounterData = new SmokeTestLib();
		encounterData.workSheetName = "UnsignedEncounter";
		encounterData.testCaseId = "TC_UEQ_001";
		encounterData.fetchSmokeTestData();
		createUnsignedEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
		
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
		
		public boolean createUnsignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SmokeTestLib encounterData) throws IOException{
		
			Selenium selenium=null;
			boolean returnValue=true;
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName,MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-2: Advanced search with Patient ID//
				//--------------------------------------------------------------------//
										
				assertTrue(searchPatientNexiaForProviderHomePage_smoke(selenium,encounterData.patientId),"could not select  ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);		
				
				//--------------------------------------------------------------------//
				//  Step-3: Navigate to Encounter and Pop up//
				//--------------------------------------------------------------------//
							
				assertTrue(goToBeginEncounter(selenium),"could not begin ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				
				if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"could not click ", selenium, ClassName,MethodName);
				selenium.clickAt(lnkBeginEncounterAction,"");
				selenium.focus(lnkBeginEncounterAction);
				if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"could not click ", selenium, ClassName,MethodName);
				selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
				waitForPageLoad(selenium);
				
				
				assertTrue(click(selenium, lblEncounterSave),"could not click ", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				
				
				
			}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data");
			}
			return returnValue;
		}		
	
	
}
