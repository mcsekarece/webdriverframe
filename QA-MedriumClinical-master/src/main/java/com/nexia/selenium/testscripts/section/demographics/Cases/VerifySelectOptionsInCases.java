package com.nexia.selenium.testscripts.section.demographics.Cases;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;

import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectOptionsInCases extends AbstractHomeTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying select options in cases")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySelectOptionsInCases(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib casesData = new HomeLib();
		casesData.workSheetName = "NewCases";
		casesData.testCaseId = "TC_NC_009";
		casesData.fetchHomeTestData();
		verifySelectOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, casesData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verifying select options in cases
	* @action 		  Verifying select options in cases
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      July 06, 2012
	***************************************************************************************************/
	public boolean verifySelectOptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib casesData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + casesData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, casesData.userName, casesData.userPassword),"Login Failed", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role                                   	  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,casesData.switchRole),"Could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			searchPatientNexia(selenium,casesData.patientID);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step - 3: Navigate to Cases and deleting existing Cases             //
			//--------------------------------------------------------------------//
			assertTrue(goToCases(selenium), "Could not navigate to Cases Page", selenium, ClassName, MethodName);
			assertTrue(deleteAllCases(selenium), "Could not delete cases", selenium, ClassName, MethodName);
			
			//---------------------------------------------------------- ---------//
			//  Step-4: Verify the select options in Cases                        //
			//--------------------------------------------------------------------//
			assertTrue(goToAddCase(selenium),"Could not Navigate to Add Cases Button : "+ casesData.toString(), selenium, ClassName, MethodName);
			assertTrue(verifySelectOptionsCases(selenium,casesData),"Could not verify select options : "+ casesData.toString(), selenium, ClassName, MethodName);
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
