package com.nexia.selenium.testscripts.section.demographics.Programs;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;
public class DeleteNewPatientCheckinPrograms extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteProgramForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "NewProgram";
		programData.testCaseId = "TC_P_006";
		programData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		deleteProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Delete New Patient Check in Programs
	* @action 		  verify Delete New Patient Check in Programs
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 02, 2012
	***************************************************************************************************/
	public boolean deleteProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib programData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not retrieve the new Selenium Session; More Details :" + programData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, programData.userName, programData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,programData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,programData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//Advanced search with Patient ID
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			assertTrue(searchPatientNexia(selenium,programData.patientID), 
					"Could not find patient with Id " + programData.patientID, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			click(selenium,lnkProgram);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Deleting existing Programs for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPrograms(selenium), "Could not delete all programs", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
		
			//---------------------------------------------------------- ----------//
			//  Step-5: Create a new Program if no Programs are available//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddPrograms),"Could not Click on Add Programs Button:"+ programData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProgram(selenium,programData,userAccount),"Program creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-6: Delete the created program //
			//--------------------------------------------------------------------//
			while(isElementPresent(selenium,lnkDeleteProgram)){
				waitForPageLoad(selenium);
				click(selenium,lnkDeleteProgram);
				waitForPageLoad(selenium);
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);  
			}
			//--------------------------------------------------------------------//
			//  Step-7: Verifying deleted program //
			//--------------------------------------------------------------------//			
			assertTrue( verifyStoredValues(selenium,programData),
					"Program details not deleted properly; More Details :"+ programData.toString(), selenium, ClassName, MethodName);
			
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyStoredValues(Selenium selenium, HomeLib programData) throws IOException{
		assertTrue( !isElementPresent(selenium,lblArea), 
				"Element with id lblArea not found", selenium, ClassName, MethodName);		
		return true;
	}
}

