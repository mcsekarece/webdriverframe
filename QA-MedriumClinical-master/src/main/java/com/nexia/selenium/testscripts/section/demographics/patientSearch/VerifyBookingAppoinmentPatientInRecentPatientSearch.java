package com.nexia.selenium.testscripts.section.demographics.patientSearch;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.nexia.selenium.genericlibrary.operations.AbstractOperationsTest;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;

import com.thoughtworks.selenium.Selenium;

public class VerifyBookingAppoinmentPatientInRecentPatientSearch  extends AbstractOperationsTest{
	@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying in active patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void BookingAppoinmentPatientInRecentPatientSearch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		OperationsTestLib PatientData = new OperationsTestLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_015";
		PatientData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyBookingApponimentPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify Booking Apponiment Patient In Recent Patient History
	* @action 	  	  verifying Booking Apponiment Patient In Recent Patient History
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @defect		  #4766	
	* @since  	      Sep 23, 2012
	***************************************************************************************************/
	
	public boolean verifyBookingApponimentPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, OperationsTestLib patientData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Search Patient									  //
			//--------------------------------------------------------------------//
			/*assertTrue(switchRole(selenium, patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			assertTrue(type(selenium,txtPatientBox,"Mathewaa"),"Could not type patient id",selenium,ClassName,MethodName);
			selenium.keyPress(txtPatientBox, "\\9");
			waitForElement(selenium,lblPatientResult,10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientData.patientID,selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains("Mathewaa".trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium,ClassName,MethodName);
				//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
			waitForPageLoad(selenium);
					
			selenium.mouseOver(lblPatientResult);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3:Navigate to Booking Apponiment							  //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lnkBookAppont),"Could not present the Booking Appointment",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,lnkBookAppont),"Could not click the Booking Appointment",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Navigate to Home Page							  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Neixa Logo",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Recent History						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkShowRecentPatient),"Could not click the Show Recent Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains("Mathewaa".trim().toLowerCase(new java.util.Locale("en","US"))),"Patient details are not getting displayed",selenium,ClassName,MethodName);
			
			
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
