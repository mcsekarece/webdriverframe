package com.nexia.selenium.testscripts.section.demographics.Programs;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;
public class EditNewPatientCheckinPrograms extends AbstractHomeTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Edit New Patient Check in Programs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editProgramForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "NewProgram";
		programData.testCaseId = "TC_P_007";
		programData.fetchHomeTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		editProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}

	/*************************************************************************************************** 
	 * @purpose        To verify Edit New Patient Check in Programs
	 * @action 		  verify Edit New Patient Check in Programs
	 * @author         Aspire QA
	 * @throws IOException 
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	      Feb 23, 2010
	 ***************************************************************************************************/
	public boolean editProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib programData) throws InterruptedException, IOException{
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
			/*waitForElement(selenium, registerPatient, 90000);
			if (isElementPresent(selenium, registerPatient))*/
			 assertTrue(searchPatientNexia(selenium, programData.patientID), 
						"Could not find patient with Id " + programData.patientID, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			click(selenium,lnkProgram);
			waitForPageLoad(selenium);

			// Edit the existing Program
			if(isElementPresent(selenium,lnkEditPrograms)){
				click(selenium,lnkEditPrograms);
				waitForPageLoad(selenium);


				programData.workSheetName = "EditProgram";
				programData.testCaseId = "TC_P_001";
				programData.fetchHomeTestData();

				assertTrue(enterDate(selenium,txtFromDate, programData.fromdate),"Could not enter date; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtToDate,programData.todate),"Could not enter the date; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtPrior,programData.priorstate),"Could not enter the Prior State value; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtOutCome,programData.outcome),"Could not enter the Outcome value; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				click(selenium,lnkEditPrograms);
				waitForPageLoad(selenium);

				assertTrue( verifyStoredValuesEditProgram(selenium,programData),
						"Program details not saved properly; More Details :"+ programData.toString(), selenium, ClassName, MethodName);
			}else if(!isElementPresent(selenium,lnkEditPrograms))	{
				assertTrue(click(selenium,btnAddPrograms),"Could not Click on Add Programs Button:"+ programData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createProgram(selenium,programData,userAccount),"Program creation Failed", selenium, ClassName, MethodName);

				click(selenium,lnkEditPrograms);
				waitForPageLoad(selenium);

				programData.workSheetName = "EditProgram";
				programData.testCaseId = "TC_P_001";
				programData.fetchHomeTestData();

				assertTrue(enterDate(selenium,txtFromDate, programData.fromdate),"Could not enter date; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtToDate,programData.todate),"Could not enter the date; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtPrior,programData.priorstate),"Could not enter the Prior State value; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtOutCome,programData.outcome),"Could not enter the Outcome value; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + programData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				click(selenium,lnkEditPrograms);
				waitForPageLoad(selenium);				
				assertTrue( verifyStoredValuesEditProgram(selenium,programData),
						"Program details not saved properly; More Details :"+ programData.toString(), selenium, ClassName, MethodName);

			}
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
