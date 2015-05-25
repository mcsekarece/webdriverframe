package com.nexia.selenium.testscripts.section.chartprevisit.Vitals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUpdateVitalsInEncounterFromSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to create vitals with hide details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void updateVitalsWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_004";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		updateVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	/**
	 * updateVitals
	 * function to verify update  encounter Vitals in medical summary  
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 26, 2012
	 */
	
	public boolean updateVitals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib vitalsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + vitalsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, vitalsData.userName, vitalsData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			vitalsData.workSheetName = "NewPatientCheckIn";
			vitalsData.testCaseId = "TC_NP_004";
			vitalsData.fetchChartPreVisitTestData();
			
		    assertTrue(createNewPatientWithMandatory(selenium,vitalsData),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String patId = getText(selenium, "patientID");
			waitForPageLoad(selenium);
            assertTrue(click(selenium, btnNexiaLogo), "Could not click on back link",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Begin Encounter 							  //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Begin Encounter failed",selenium,ClassName,MethodName);
			assertTrue(selenium.isTextPresent("No Vitals Recorded"),"No vitals not found",selenium,ClassName,MethodName);
			selenium.focus(lnkVitals1);
			selenium.clickAt(lnkVitals1, "");
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent("No Vitals recorded"),"no vitals not found",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Vitals												  //
			//--------------------------------------------------------------------//
			assertTrue(addEncounterVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnDoneButton), "Could not click on done button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the Actions link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			try{
				selenium.focus(lnkSummary);
				selenium.clickAt(lnkSummary, "");
			}catch(Exception e){
				selenium.focus(lnkSummary);
				selenium.clickAt(lnkSummary, "");
			}
			//unable to add vitals in the summary page. So Update the script with the begin encounter script.
			goToBeginEncounter(selenium);
			assertTrue(click(selenium,lnkVitals),"Could not click the vitals link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			vitalsData.workSheetName = "CreateVitals";
			vitalsData.testCaseId = "TC_CV_025";
			vitalsData.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-6: Update Vitals											  //
			//--------------------------------------------------------------------//
			assertTrue(addVitals(selenium,vitalsData),"Vitals update failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnDoneButton), "Could not click on done button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Again Navigate to Begin Encounter 							  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkVitals),"Could not click the vitals link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Stored Value                                       //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValueInManagementView(selenium,vitalsData,userAccount),"Vitals details not saved properly; More Details :"+ vitalsData.toString(), selenium,ClassName,MethodName);

					
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + vitalsData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	
}
