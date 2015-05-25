package com.nexia.selenium.testscripts.section.chartprevisit.Vitals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class UpdateVitals extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for updateVitalsWithHideDetails")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void updateVitalsWithHideDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_030";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		updateVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for updateVitalsWithFullDetails")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void updateVitalsWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_031";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		updateVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	/**
	 * updateVitals
	 * function to add Vitals
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * 
	 * @since  	    Dec 20, 2012
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
			
			ChartPreVisitLib vitalsData1 = new ChartPreVisitLib();
			vitalsData1.workSheetName = "NewPatientCheckIn";
			vitalsData1.testCaseId = "TC_NP_001";
			vitalsData1.fetchChartPreVisitTestData();
			
			assertTrue(createNewPatientWithMandatory(selenium,vitalsData1),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String patId = getText(selenium, txtpatientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);     
			//unable to add vitals in the summary page. So Update the script with the begin encounter script.
			goToBeginEncounter(selenium);
			assertTrue(click(selenium,lnkVitals),"Could not click the vitals link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Add Vitals												  //
			//--------------------------------------------------------------------//
			assertTrue(addVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isTextPresent("Update Vitals"),"Could not changes the Add New title of the add section to Update Vitals",selenium,ClassName,MethodName );
			assertTrue(getText(selenium, btnAdd).contains(btnUpdate), "Could not Changes the Add button to Update button",selenium,ClassName,MethodName);
			
			if(vitalsData.testCaseId.equalsIgnoreCase("TC_CV_030")){
				vitalsData.workSheetName = "CreateVitals";
				vitalsData.testCaseId = "TC_CV_011";
				vitalsData.fetchChartPreVisitTestData();
			}
			if(vitalsData.testCaseId.equalsIgnoreCase("TC_CV_031")){
				vitalsData.workSheetName = "CreateVitals";
				vitalsData.testCaseId = "TC_CV_014";
				vitalsData.fetchChartPreVisitTestData();
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Update Vitals											  //
			//--------------------------------------------------------------------//
			assertTrue(addVitals(selenium,vitalsData),"Vitals update failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getValue(selenium, txtHeightInFeet).contains(vitalsData.heightInFeet),"Heigth in feet not correct",selenium,ClassName,MethodName);
			return true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + vitalsData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
}
