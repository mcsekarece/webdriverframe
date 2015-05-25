package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyChartsNotesVisible extends AbstractHomeTest {
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyChartsNotesVisibleOnDemo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewCases";
		PatientData.testCaseId = "TC_NC_012";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyChartsNotesVisible(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	 
	/*************************************************************************************************** 
	* @purpose        To verify Charts Notes Visible
	* @action 		  verifying Charts Notes Visible
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 06, 2012
	***************************************************************************************************/
	public boolean verifyChartsNotesVisible(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib PatientData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + PatientData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, PatientData.userName, PatientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,PatientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID //
			//--------------------------------------------------------------------//
			waitForElement(selenium, registerPatient, 4000);
			waitForPageLoad(selenium);
			searchPatientNexia(selenium,PatientData.patientID);
			waitForPageLoad(selenium);
			assertTrue(verifyNotesVisible(selenium, PatientData),"Charts notes not visible in patient summary section ", selenium, ClassName, MethodName);
			click(selenium,lnkSocioEconomics);
			waitForPageLoad(selenium);
			assertTrue(verifyNotesVisible(selenium, PatientData),"Charts notes not visible in socio economic section ", selenium, ClassName, MethodName);
			click(selenium,lnkHouseHold);
			waitForPageLoad(selenium);
			assertTrue(verifyNotesVisible(selenium, PatientData),"Charts notes not visible in House Hold section ", selenium, ClassName, MethodName);
			click(selenium,lnkContactList);
			waitForPageLoad(selenium);
			assertTrue(verifyNotesVisible(selenium, PatientData),"Charts notes not visible in House Hold section ", selenium, ClassName, MethodName);
			click(selenium,lnkIdentifier);
			waitForPageLoad(selenium);
			assertTrue(verifyNotesVisible(selenium, PatientData),"Charts notes not visible in Identifiers section ", selenium, ClassName, MethodName);
			click(selenium,lnkReferrals);
			waitForPageLoad(selenium);
			assertTrue(verifyNotesVisible(selenium, PatientData),"Charts notes not visible in Referrals section ", selenium, ClassName, MethodName);
			click(selenium,lnkConsentsPatient);
			waitForPageLoad(selenium);
			assertTrue(verifyNotesVisible(selenium, PatientData),"Charts notes not visible in Consents section ", selenium, ClassName, MethodName);
			click(selenium,lnkNotes);
			waitForPageLoad(selenium);
			assertTrue(verifyNotesVisible(selenium, PatientData),"Charts notes not visible in Notes section ", selenium, ClassName, MethodName);
			click(selenium,lnkPatientCaseList);
			waitForPageLoad(selenium);
			assertTrue(verifyNotesVisible(selenium, PatientData),"Charts notes not visible in Cases section ", selenium, ClassName, MethodName);
			click(selenium,lnkProgram);
			waitForPageLoad(selenium);
			assertTrue(verifyNotesVisible(selenium, PatientData),"Charts notes not visible in Cases section ", selenium, ClassName, MethodName);
			click(selenium,lnkPatientHealthcare);
			waitForPageLoad(selenium);
			assertTrue(verifyNotesVisible(selenium, PatientData),"Charts notes not visible in Cases section ", selenium, ClassName, MethodName);

		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyNotesVisible(Selenium selenium, HomeLib PatientData){
		if(isElementPresent(selenium,lblPatientNoteHide)){
			return true;
		}
		else return false;
	}
	
}