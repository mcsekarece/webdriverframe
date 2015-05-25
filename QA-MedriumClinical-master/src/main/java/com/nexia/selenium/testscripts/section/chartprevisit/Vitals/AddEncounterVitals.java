package com.nexia.selenium.testscripts.section.chartprevisit.Vitals;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class AddEncounterVitals extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Fuction to create a Patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "NewPatientCheckIn";
		vitalsData.testCaseId = "TC_NP_001";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		//addVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to create vitals with hide details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addVitalsWithHideDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_001";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to create vitals with full details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addVitalsWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_002";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	/**
	 * addVitals
	 * function to add Vitals
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Nov 09, 2012
	 */
	
	public boolean addVitals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib vitalsData)throws Exception{
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
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,vitalsData.switchRole),"Switch role failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
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
			String patId = getText(selenium, "patientID");
			waitForPageLoad(selenium);
			//assertTrue(click(selenium, back), "Could not click on back link",selenium,ClassName,MethodName);
			
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
			if(getText(selenium,lnkStartNewWncouter).contains("Or start a new encounter"))	
				assertTrue(click(selenium, lnkStartNewWncouter), "Could not click on Or start a new encounter",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent("No Vitals Recorded"),"No vitals not found",selenium,ClassName,MethodName);
			
			//Check if Vital Link is Visible
			assertTrue(selenium.isVisible(lnkVitals),"Vital Link Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkVitals),"Could not click the Vital link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		  //  assertTrue(getText(selenium,lblNoVitalsRecord).contains("No Vitals recorded"),"No vitals not found",selenium,ClassName,MethodName);
			
		    //--------------------------------------------------------------------//
			//  Step-5: Add Vitals												  //
			//--------------------------------------------------------------------//
			assertTrue(addEncounterVitals(selenium,vitalsData),"Encounter Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			click(selenium,btnDoneButton);
			
			if(getText(selenium, lblNoVitals).contains("No Vitals Recorded")){
			    returnValue=false;
			}
			else{
			    returnValue=true;
			}
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + vitalsData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
}
