package com.nexia.selenium.testscripts.section.demographics.Programs;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class DuplicateNewPatientCheckInPrograms extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Duplicate New Patient Check in Programs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void duplicateProgramForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "NewProgram";
		programData.testCaseId = "TC_P_010";
		programData.fetchHomeTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		duplicateProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}

	/*************************************************************************************************** 
	 * @purpose        To verify Duplicate New Patient Check in Programs
	 * @action 		  verifying Duplicate New Patient Check in Programs
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	      Apr 02, 2012
	 ***************************************************************************************************/
	public boolean duplicateProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib programData) throws Exception{
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

			//Advanced search with Patient ID
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			assertTrue(searchPatientNexia(selenium, programData.patientID), 
					"Could not find patient with Id " + programData.patientID, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			click(selenium,lnkProgram);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Deleting existing Programs for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPrograms(selenium), "Could not delete all programs", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//---------------------------------------------------------- ----------//
			//  Step-4: Create a new Program //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddPrograms),"Could not Click on Add Programs Button:"+ programData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProgram(selenium,programData,userAccount),"Program creation Failed", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddPrograms),"Could not Click on Add Programs Button:"+ programData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if(!createProgram(selenium, programData,userAccount))
			{
				if(isElementPresent(selenium,btnErrorClose))
				{
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnErrorClose),"Could not click error close button"+programData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				programData.workSheetName = "NewProgram";
				programData.testCaseId = "TC_P_003";
				programData.fetchHomeTestData();
				waitForPageLoad(selenium);
				selectValueFromAjaxListUsingTypeKeys(selenium,ajkSuggestBox, programData.program);
				waitForPageLoad(selenium);
				assertTrue(enterDate(selenium,txtFromDate, programData.fromdate),"Could not enter date; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtToDate,programData.todate),"Could not enter the date; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtPrior,programData.priorstate),"Could not enter the Prior State value; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtOutCome,programData.outcome),"Could not enter the Outcome value; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				assertTrue(selenium.isTextPresent("An entry already exists in this date range for the specified patient, program and department."),"Not able to find Patient Contact list", selenium, ClassName, MethodName);
			}
			else{
				assertTrue( false, "Can create Duplicate Programs :" + programData.toString(), selenium, ClassName, MethodName);
			}	
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}


