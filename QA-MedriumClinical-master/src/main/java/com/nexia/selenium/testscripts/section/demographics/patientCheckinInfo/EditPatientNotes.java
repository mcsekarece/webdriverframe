package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class EditPatientNotes extends AbstractHomeTest {
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Edit Patient Notes")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void patientNoteForEdit(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientNote = new HomeLib();
		patientNote.workSheetName = "EditPatientInfo";
		patientNote.testCaseId = "TC_EPI_002";
		patientNote.fetchHomeTestData();
		editPatientNote(seleniumHost, seleniumPort, browser, webSite, userAccount, patientNote);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Edit Patient Notes
	* @action 		  verifying Edit Patient Notes
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 06, 2012
	***************************************************************************************************/
	public boolean editPatientNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientNote) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientNote.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientNote.userName, patientNote.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientNote.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Search for a Patient using Patient ID
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,patientNote.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Edit Patient Note
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,"//div[2]/div[2]/div"),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEditPatientNote),"Could not click the edit buuton", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPatientNote,patientNote.patientNote),"Could not enter the patient details", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSavePatientNote),"Could not click the save button;More details:"+patientNote.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Verify the details are properly
			//--------------------------------------------------------------------//
			if(!verifyStoredValues(selenium,patientNote)){
				Assert.fail("Patient Info details are not edited properly; More Details :"+ patientNote.toString());
				returnValue = false;
			}else
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientNote.toString());
			
		}
		return false;
	}
	public boolean verifyStoredValues(Selenium selenium,HomeLib patientNote) throws IOException{
		assertTrue(!getText(selenium,txtPatientNote).contains(patientNote.patientNote),"could text present",selenium,ClassName,MethodName);
			return true;
}
}
