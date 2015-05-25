package com.nexia.selenium.testscripts.section.chartprevisit.MergeCharts;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class AddConsentsAndPayersAfterMerging extends AbstractHomeTest {
	@Test(groups = {"Approved","Regression","firefox", "iexplore", "safari", "default" }, description = "Test for verifying merge chart option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void addConsentsAndPayersAfterMerging(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
		    patientData.testCaseId = "TC_NPC_141";
			patientData.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			addConsentsAndPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
		}
	/**
	 * AddConsentsAndPayersAfterMerging
	 * function to add consents and payers after Merging two patient chart
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    November 12, 2014
	 */
	public boolean addConsentsAndPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws IOException
	{
		Selenium selenium=null;
		String date =null;
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
			//-------------------------------------------------------------------//
			//  Step-4: Create first patient
			//-------------------------------------------------------------------//
			assertTrue(createPatient(selenium,patientData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patientId1=getText(selenium,lblPatientId);
			//-------------------------------------------------------------------//
			//  Step-5: Create Second patient
			//-------------------------------------------------------------------//
			HomeLib patientData1 = new HomeLib();
			patientData1.workSheetName = "PatientData";
			patientData1.testCaseId = "TC_NPC_142";
			patientData1.fetchHomeTestData();
			assertTrue(navigateToNewPatientRegistration(selenium),"Unable to navigate to Patient Registration page",selenium,ClassName,MethodName);
			assertTrue(createPatient(selenium,patientData1,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patientId2=getText(selenium,lblPatientId);
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Chart Management and search patients	      //
			//--------------------------------------------------------------------//
			assertTrue(navigateToMergeCharts(selenium),"Navigation Failed", selenium, ClassName, MethodName);
			assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId1,btnSearchBoxOnChart1),"Could not search", selenium, ClassName, MethodName);
			assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId2,btnSearchBoxOnChart2),"Could not search", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnMerge),"Could not click on merge button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//------------------------------------------------------------------//
			//  Step-8: Merging two patient charts
			//------------------------------------------------------------------//
			assertTrue(clickTheRadioButtonsInMergedChartsRight(selenium),"Fail to visible buttons list 1",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSave1),"Unable to click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"yesButton"),"Unable to click the ok button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//------------------------------------------------------------------//
			// Step-9: Add consents 
			//------------------------------------------------------------------//
			assertTrue(navigateToPatientConsentsPage(selenium,patientId2),"Unable to navigate to consents patient page",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			HomeLib consentData = new HomeLib();
			consentData.workSheetName = "NewConsent";
			consentData.testCaseId = "TC_NC_001";
			consentData.fetchHomeTestData();
			assertTrue(createConsent(selenium,consentData),"Unable to create the consents",selenium,ClassName,MethodName);
			//------------------------------------------------------------------//
			// Step-10: Add payers
			//------------------------------------------------------------------//
			assertTrue(navigateToMedicalPayers(selenium),"Unable to Navigate to Medical Payers Page",selenium,ClassName,MethodName);
			HomeLib payerData = new HomeLib();
			payerData.workSheetName = "AddPayers";
			payerData.testCaseId = "TC_CP_001";
			payerData.fetchHomeTestData();
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat dateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	date=dateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat dateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=dateFormat1.format(cal.getTime());
			}
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent(payerData.payerName),"Could not get text", selenium, ClassName, MethodName);
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
