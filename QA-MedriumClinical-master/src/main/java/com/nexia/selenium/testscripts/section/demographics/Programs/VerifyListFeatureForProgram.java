package com.nexia.selenium.testscripts.section.demographics.Programs;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyListFeatureForProgram extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify List Feature For Programs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewProgramForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "NewProgram";
		programData.testCaseId = "TC_P_011";
		programData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify List Feature For Programs
	* @action 		  verify List Feature For Programs
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 02, 2012
	***************************************************************************************************/
	public boolean createNewProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib programData) throws Exception{
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
			searchPatientNexia(selenium,programData.patientID);
			waitForPageLoad(selenium);
			click(selenium,lnkProgram);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Deleting existing Programs for the selected patient  //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			
			while(isElementPresent(selenium,lnkDeleteProgram)){
				waitForPageLoad(selenium);
				click(selenium,lnkDeleteProgram);
				waitForPageLoad(selenium);
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);  
			}
			assertTrue(getText(selenium,lblNoDetailsAdded).equalsIgnoreCase("No programs added."),"No program added is found",selenium,ClassName,MethodName);
				returnValue = true;
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
