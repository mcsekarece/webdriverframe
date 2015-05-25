package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPatientOptionList extends AbstractHomeTest {
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientOptions(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_001";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyListForPatientOptions(seleniumHost, seleniumPort, browser, webSite,userAccount, PatientData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Patient Option List
	* @action 		  verifying Patient Option List
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 06, 2012
	***************************************************************************************************/
	public boolean verifyListForPatientOptions(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, HomeLib patientData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Click New Patient Check-in   							  //
			//--------------------------------------------------------------------//				
			assertTrue(goToNewPatientCheckIn(selenium), "Could not navigate to Patient information page", selenium, ClassName, MethodName);
			assertTrue(createPatient(selenium,patientData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPatientOption ), "Could not click on patient options link", selenium, ClassName, MethodName);
			
			assertTrue(getText(selenium,lnkPatientChart).toLowerCase(new java.util.Locale("en","US") ).trim().contains("View Patient Chart".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkPrescribeMed).toLowerCase(new java.util.Locale("en","US") ).trim().contains("Prescribe Medication".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkFileNewReport).toLowerCase(new java.util.Locale("en","US") ).trim().contains("File New Report".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkExportChart).toLowerCase(new java.util.Locale("en","US") ).trim().contains("Export Chart".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
			
			assertTrue(click(selenium,lnkPatientChart ), "Could not click on patient options link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkPatientOption ), "Could not click on patient options link", selenium, ClassName, MethodName);
			
			assertTrue(getText(selenium,lnkViewRegistration).toLowerCase(new java.util.Locale("en","US") ).trim().contains("View Registration".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkPrescribeMed).toLowerCase(new java.util.Locale("en","US") ).trim().contains("Prescribe Medication".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkFileNewReport).toLowerCase(new java.util.Locale("en","US") ).trim().contains("File New Report".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lnkExportChart).toLowerCase(new java.util.Locale("en","US") ).trim().contains("Export Chart".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}