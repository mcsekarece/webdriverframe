package com.nexia.selenium.testscripts.section.chartprevisit.Vitals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyGraphForVitals extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying graph for Vitals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addVitalsWithHideDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "NewPatientCheckIn";
		vitalsData.testCaseId = "TC_NP_001";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying graph for Vitals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addVitalsWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "NewPatientCheckIn";
		vitalsData.testCaseId = "TC_NP_001";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addVitalsFullDetails(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	/**
	 * addVitals
	 * function to add Vitals
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @since  	    Dec 07, 2012
	 */
	
	public boolean addVitals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib vitalsData) throws InterruptedException, IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + vitalsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, vitalsData.userName, vitalsData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
//			assertTrue(click(selenium,lnkQuickLink),"Could not click Quick Link", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSettings),"Could not click settings link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemsetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete All Mandatory data  								  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium), "Could not delete all mandatory fields", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Click New Patient Check-in   							  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on Nexia Logo",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createNewPatientWithMandatory(selenium,vitalsData),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String patId = getText(selenium, txtpatientId);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
           // assertTrue(click(selenium, btnBack), "Could not click on back link",selenium,ClassName,MethodName);
			vitalsData.workSheetName = "CreateVitals";
			vitalsData.testCaseId = "TC_CV_035";
			vitalsData.fetchChartPreVisitTestData();
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			 assertTrue(click(selenium, btnNexiaLogo), "Could not click on back link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			//unable to add vitals in the summary page. So Update the script with the begin encounter script.
			goToBeginEncounter(selenium);
			assertTrue(click(selenium,lnkVitals),"Could not click the Allergy link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Add Vitals												  //
			//--------------------------------------------------------------------//
			assertTrue(addVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			vitalsData.workSheetName = "CreateVitals";
			vitalsData.testCaseId = "TC_CV_011";
			vitalsData.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			assertTrue(addVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifyGraphForHideDetailsInVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblCreatedVitalsEntry)){
				returnValue=true;
			}else
				returnValue=false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + vitalsData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	/**
	 * addVitalsFullDetails
	 * function to add Vitals
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @since  	    Dec 11, 2012
	 */
	
	public boolean addVitalsFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib vitalsData) throws InterruptedException, IOException{
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
			
		assertTrue(createNewPatientWithMandatory(selenium,vitalsData),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			String patId = getText(selenium, txtpatientId);
			waitForPageLoad(selenium);
           // assertTrue(click(selenium, btnBack), "Could not click on back link",selenium,ClassName,MethodName);
			vitalsData.workSheetName = "CreateVitals";
			vitalsData.testCaseId = "TC_CV_036";
			vitalsData.fetchChartPreVisitTestData();
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on Nexia Logo",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			goToBeginEncounter(selenium);
			assertTrue(click(selenium,lnkVitals),"Could not click the Allergy link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Add Vitals												  //
			//--------------------------------------------------------------------//
			assertTrue(addVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			vitalsData.workSheetName = "CreateVitals";
			vitalsData.testCaseId = "TC_CV_012";
			vitalsData.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			assertTrue(addVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifyGraphForFullDetailsInVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + vitalsData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
}
