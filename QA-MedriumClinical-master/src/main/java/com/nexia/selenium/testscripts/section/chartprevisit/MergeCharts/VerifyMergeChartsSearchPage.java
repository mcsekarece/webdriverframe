package com.nexia.selenium.testscripts.section.chartprevisit.MergeCharts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMergeChartsSearchPage extends AbstractHomeTest {
	@Test(groups = {"Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying merge chart option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void verifyMergeChartPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
		    patientData.testCaseId = "TC_NPC_146";
			patientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			verifyMergeChartsSearchPage(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
		}
	/**
	 * verifyMergeChartsSearchPage
	 * function to verify merge chart data page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    November 07, 2014
	 */

	public boolean verifyMergeChartsSearchPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws IOException
	{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Clear Custom Mandatory Fields
			//--------------------------------------------------------------------//
			assertTrue(navigateToMandatoryUserFields(selenium),"Unable to Naviage to user Mandatory fields",selenium,ClassName,MethodName);
			assertTrue(deleteAllMandatory(selenium), "Could not delete all mandatory fields", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Click New Patient Check-in   							  //
			//--------------------------------------------------------------------//				
			assertTrue(naviagateToHomePageFromAnyPlace(selenium),"Unable to Navigate to homepage",selenium,ClassName,MethodName);
			assertTrue(navigateToNewPatientRegistration(selenium),"Unable to navigate to Patient Registration page",selenium,ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-4: Create Patient with mandatory field with Socio Economic
			//--------------------------------------------------------------------//
			assertTrue(createPatient(selenium,patientData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			String patientId1=getText(selenium,lblPatientId);
			//--------------------------------------------------------------------//
			//  Step-5: search patient on Merge Charts
			//--------------------------------------------------------------------//
			assertTrue(navigateToMergeCharts(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			assertTrue(searchInactivePatientNexiaOnChartManagement(selenium,patientId1,btnSearchBoxOnChart1),"Could not search", selenium, ClassName, MethodName);
		    //-------------------------------------------------------------------//
			//  Step-6: Verify the Display data details
			//-------------------------------------------------------------------//
			assertTrue(verifyDisplayDataAfterSearch(selenium,patientData,patientId1),"Data not matched",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifyMergedChartPageIndividual(selenium,userAccount),"Last updated not as per the test document",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		   }catch(RuntimeException e)
			{
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
				return false;
			}
		
		
		return true;
	}
	
}
