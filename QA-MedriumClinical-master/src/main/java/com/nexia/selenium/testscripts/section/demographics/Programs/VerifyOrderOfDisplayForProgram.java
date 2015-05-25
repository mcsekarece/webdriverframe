package com.nexia.selenium.testscripts.section.demographics.Programs;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyOrderOfDisplayForProgram extends AbstractHomeTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Order Of Display For Programs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOrderOfDisplayForProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "NewProgram";
		programData.testCaseId = "TC_P_012";
		programData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyOrderOfDisplayForProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}

	/*************************************************************************************************** 
	 * @purpose        To verify Order Of Display For Programs
	 * @action 		  verifying Order Of Display For Programs
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	      June 08, 2012
	 ***************************************************************************************************/
	public boolean verifyOrderOfDisplayForProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib programData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + programData.toString());
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
			waitForPageLoad(selenium);
			HomeLib programsData = new HomeLib();
			programsData.workSheetName = "NewProgram";
			programsData.testCaseId = "TC_P_002";
			programsData.fetchHomeTestData();
			assertTrue(click(selenium,btnAddPrograms),"Could not Click on Add Programs Button:"+ programsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProgram(selenium,programsData,userAccount),"Program creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium,lblProgramSummary)){
				assertTrue( verifyStoredValuesOrderOfDisply(selenium,programsData,userAccount),
						"Program details not saved properly; More Details :"+ programsData.toString(), selenium, ClassName, MethodName);								
			}

			if(isElementPresent(selenium,lblProgramsummaryOrder)){
				assertTrue( verifyStoredValuesInSummaryOrderOfDisply(selenium,programData,userAccount),
						"Program details not saved properly; More Details :"+ programData.toString(), selenium, ClassName, MethodName);
			}

			String program=getText(selenium,lblProgramSummary);
			String programSplit[] = program.split(":");
		    String programDateValue = programSplit[1] + "/" + programSplit[2]+ "/" + programSplit[3];
			
			String programsNext=getText(selenium,lblProgramsummaryOrder);
			String programsNextSplit[] = programsNext.split(":");
			String programsNextDateValue = programsNextSplit[1] + "/" + programsNextSplit[2]+ "/" + programsNextSplit[3];
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date=dateFormat.parse(programDateValue);
			Date date1=dateFormat.parse(programsNextDateValue);
			
			assertTrue(date.compareTo(date1)>0,"StartDate is not saved ascending order"+programData.todate, selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyStoredValuesOrderOfDisply(Selenium selenium, HomeLib programData,String account) throws IOException{
		waitForPageLoad(selenium);
		if(account.equals(CAAccount)){
			assertTrue( getText(selenium,lblProgramSummary).trim().contains(programData.fromdateCA.trim()),
				    "Not able to find text " +programData.fromdateCA , selenium, ClassName, MethodName);						
			
			assertTrue( getText(selenium,lblProgramSummary).trim().contains(programData.todateCA.trim()),
				    "Not able to find text " +programData.todateCA  , selenium, ClassName, MethodName);						
			
		}else{
			assertTrue( getText(selenium,lblProgramSummary).trim().contains(programData.fromdate.trim()),
				    "Not able to find text " +programData.fromdate  , selenium, ClassName, MethodName);						
			
			assertTrue(getText(selenium,lblProgramSummary).trim().contains(programData.todate.trim()),
				    "Not able to find text " +programData.todate  , selenium, ClassName, MethodName);						
			
		}

		return true;
	}
	public boolean verifyStoredValuesInSummaryOrderOfDisply(Selenium selenium, HomeLib programsData,String account) throws IOException{
		waitForPageLoad(selenium);
		if(account.equals(CAAccount)){
			assertTrue( getText(selenium,lblProgramsummaryOrder).trim().contains(programsData.fromdateCA.trim()),
				    "Not able to find text " +programsData.fromdateCA  , selenium, ClassName, MethodName);						
			
			assertTrue( getText(selenium,lblProgramsummaryOrder).trim().contains(programsData.todate.trim()),
				    "Not able to find text " +programsData.todate  , selenium, ClassName, MethodName);						
			
		}else{			
			assertTrue( getText(selenium,lblProgramsummaryOrder).trim().contains(programsData.fromdateCA.trim()),
				    "Not able to find text " +programsData.fromdateCA  , selenium, ClassName, MethodName);					
			
			assertTrue( getText(selenium,lblProgramsummaryOrder).trim().contains(programsData.todate.trim()),
				    "Not able to find text " +programsData.todate  , selenium, ClassName, MethodName);						
		}
		return true;
	}
}
