package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestPatientNotes extends AbstractHomeTest{
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Field PatientId chart with Special Charecters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPatientNotewithMorethentwohundreedchar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientNoteData = new HomeLibUnitTest();
		patientNoteData.workSheetName = "UnitTest_FV_PC_Info";
		patientNoteData.testCaseId = "TC_PN_001";
		patientNoteData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestPatientNotes(seleniumHost, seleniumPort, browser, webSite, userAccount, patientNoteData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify unit test for patient Notes
	* @action 		  verifying unit test for patient Notes
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 06, 2012
	***************************************************************************************************/
	public void unitTestPatientNotes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest patientNoteData) throws IOException{
	Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application  								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientNoteData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientNoteData.userName, patientNoteData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientNoteData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Search Patient 											  // 
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,patientNoteData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Create Patient Note
			//--------------------------------------------------------------------//
			assertTrue(createPatientNotes(selenium,patientNoteData),"Patient Consents failed", selenium, ClassName, MethodName);
			patientNoteData.validationFieldID = patientNoteData.validationFieldID == null ? patientNoteData.validationFieldID = "" : patientNoteData.validationFieldID.trim();
			if(!patientNoteData.validationFieldID.equals("")){
			assertTrue(isElementPresent(selenium, patientNoteData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, patientNoteData.validationFieldID).contains(patientNoteData.validationMessage), "The expected validation message should contain the text - "+ patientNoteData.validationMessage + " The actual validation message shown - " + getText(selenium, patientNoteData.validationFieldID), selenium, ClassName, MethodName);
			}

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		
	}
	/**
	 * createPatientNotes
	 * function to create Patient Notes
	 * @throws IOException 
	 * @since  	    Sep 04, 2012
	 */
	public boolean createPatientNotes(Selenium selenium, HomeLibUnitTest patientNoteData ) throws IOException{
		try{
			assertTrue(isElementPresent(selenium,lblPatientNote),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEditPatientNote),"Could not click the edit buuton", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPatientNote,patientNoteData.patientnote),"Could not enter the patient details", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSavePatientNote),"Could not click the save button;More details:"+patientNoteData.toString(), selenium, ClassName, MethodName);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
}
