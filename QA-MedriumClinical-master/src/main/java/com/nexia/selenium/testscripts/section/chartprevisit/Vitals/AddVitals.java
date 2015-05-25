package com.nexia.selenium.testscripts.section.chartprevisit.Vitals;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class AddVitals extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for addVitalsWithHideDetails")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addVitalsWithHideDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_026";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for addVitalsWithFullDetails")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addVitalsWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_027";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifyCmToInches")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCmToInches(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_005";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifyInchesToCm")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyInchesToCm(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_006";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifyLbsToKgs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLbsToKgs(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_007";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifyKgsToLbs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyKgsToLbs(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_008";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifyBMIInSiUnit")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBMIInSiUnit(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_009";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifyBMIInUSCustomerUnit")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBMIInUSCustomerUnit(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_010";
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
			//assertTrue(switchRole(selenium,vitalsData.switchRole));
			//waitForPageLoad(selenium);
			
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
			//String patId = getText(selenium, "patientID");
			//waitForPageLoad(selenium);
			//assertTrue(click(selenium, btnBack), "Could not click on back link");
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			//searchPatientNexiaForProviderHomePage(selenium,patId);
			//waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPatientOption),"Could not click the patient option",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientChartView),"Could not click the patient option",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//unable to add vitals in the summary page. So Update the script with the begin encounter script.
			goToBeginEncounter(selenium);
			//Check if Vital Link is Visible
			assertTrue(selenium.isVisible(lnkVitals),"Vital Link Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkVitals),"Could not click the Allergy link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Add Vitals												  //
			//--------------------------------------------------------------------//
			assertTrue(addVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium, btnAdd).equalsIgnoreCase(btnUpdate)){
				returnValue=true;
			}else
				returnValue=false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + vitalsData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
}
