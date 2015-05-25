package com.nexia.selenium.testscripts.section.chartprevisit.Medication;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAreYouSureForMedication extends AbstractChartPreVisit {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Delete Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteMedicationForSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_020";
		medicationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		deleteMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	
	/**
	 * createMedication
	 * function to create Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 10, 2012
	 */
	
	public boolean deleteMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Medication //
			//--------------------------------------------------------------------//
			//assertTrue(isElementPresent(selenium,"//div[5]/div/a"),"Could not find the link");
			//assertTrue(click(selenium,"//div[5]/div/a"),"Could not click the link");
			//waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteMedication(selenium,medicationData),"Deletion Failed", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Create Medication//
			//--------------------------------------------------------------------//
			assertTrue(createMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			

			assertTrue(selenium.isConfirmationPresent(),"Are you sure alert is not present when navigating to other page", selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}



