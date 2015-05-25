package com.nexia.selenium.testscripts.section.chartprevisit.Vitals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class UpdateEncounterVitals extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to create vitals with hide details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void updateVitalsWithHideDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_028";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		updateEncounterVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to create vitals with full details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void updateVitalsWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_029";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		updateEncounterVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	/**
	 * updateEncounterVitals
	 * function to update Encounter vitals
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 21, 2012
	 */
	
	public boolean updateEncounterVitals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib vitalsData) throws IOException {
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
			vitalsData.testCaseId = "TC_NP_001";
			vitalsData.fetchChartPreVisitTestData();
			
			assertTrue(createNewPatientWithMandatory(selenium,vitalsData),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String patId = getText(selenium, "patientID");
			waitForPageLoad(selenium);
			//assertTrue(click(selenium, btnBack), "Could not click on back link",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Begin Encounter 							  //
			//--------------------------------------------------------------------//
			if(getText(selenium, btnBeginEncounter).contains("Begin Encounter"))
				assertTrue(click(selenium, btnBeginEncounter),"Could not click Begin Encounter",selenium,ClassName,MethodName);
			if(getText(selenium, lnkStartNewWncouter).contains("Or start a new encounter"))	
				assertTrue(click(selenium,lnkStartNewWncouter), "Could not click on Or start a new encounter",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent("No Vitals Recorded"),"No vitals not founded",selenium,ClassName,MethodName);
			assertTrue(click(selenium,lnkVitals1),"Could not click the Allergy link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		  //  assertTrue(getText(selenium, lblNoVitalsRecord).contains("No Vitals recorded"),"No vitals not founded",selenium,ClassName,MethodName);
			
		    //--------------------------------------------------------------------//
			//  Step-5: Add Vitals												  //
			//--------------------------------------------------------------------//
			assertTrue(addEncounterVitals(selenium,vitalsData),"Encounter Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(selenium.isTextPresent("Update Vitals"),"Could not changes the Add New title of the add section to Update Vitals",selenium,ClassName,MethodName );
			assertTrue(getText(selenium, btnAdd).contains(btnUpdate), "Could not Changes the Add button to Update button",selenium,ClassName,MethodName);
			
			if(vitalsData.testCaseId.equalsIgnoreCase("TC_CV_028")){
				vitalsData.workSheetName = "CreateVitals";
				vitalsData.testCaseId = "TC_CV_011";
				vitalsData.fetchChartPreVisitTestData();
			}
			if(vitalsData.testCaseId.equalsIgnoreCase("TC_CV_029")){
				vitalsData.workSheetName = "CreateVitals";
				vitalsData.testCaseId = "TC_CV_014";
				vitalsData.fetchChartPreVisitTestData();
			}
			//--------------------------------------------------------------------//
			//  Step-5: Update Vitals												  //
			//--------------------------------------------------------------------//
			assertTrue(addEncounterVitals(selenium,vitalsData),"Encounter Vitals update failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnDoneButton), "Could not click on done button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + vitalsData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
}
