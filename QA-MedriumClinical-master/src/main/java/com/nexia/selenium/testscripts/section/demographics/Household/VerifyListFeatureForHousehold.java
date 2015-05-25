package com.nexia.selenium.testscripts.section.demographics.Household;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyListFeatureForHousehold extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient household")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewHouseholdForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib householdData = new HomeLib();
		householdData.workSheetName = "NewHousehold";
		householdData.testCaseId = "TC_HH_009";
		householdData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createHousehold(seleniumHost, seleniumPort, browser, webSite, userAccount, householdData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify List Feature In Household
	* @action 		  Verifying List Feature In Household
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 02, 2012
	***************************************************************************************************/
	public boolean createHousehold(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib householdData) throws Exception{
		Selenium selenium = null;	
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + householdData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, householdData.userName, householdData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,householdData.switchRole),"",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID
			//--------------------------------------------------------------------//
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			searchPatientNexia(selenium,householdData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkHouseHold);
			waitForPageLoad(selenium);
			while(isElementPresent(selenium,lnkHouseHoldDelete)){
				waitForPageLoad(selenium);
				click(selenium,lnkHouseHoldDelete);
				waitForPageLoad(selenium);
				click(selenium, btnYesButton);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Add a household member//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddHouseHold),"Could not Click on Add Family Member Button:"+ householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(createHousehold(selenium,householdData),"First Household creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			householdData.workSheetName = "NewHousehold";
			householdData.testCaseId = "TC_HH_002";
			householdData.fetchHomeTestData();
			
			assertTrue(click(selenium,btnAddHouseHold),"Could not Click on Add Family Member Button:"+ householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(createHousehold(selenium,householdData),"Second Household creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			click(selenium, lnkExpandAll);
			if(isElementPresent(selenium, lnkCollapseAll))
				returnValue = true;
			else
				returnValue = false;
			
			householdData.workSheetName = "NewHousehold";
			householdData.testCaseId = "TC_HH_003";
			householdData.fetchHomeTestData();
			
			assertTrue(click(selenium,btnAddHouseHold),"Could not Click on Add Family Member Button:"+ householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(createHousehold(selenium,householdData),"Third Household creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, lnkExpandAll))
				returnValue = true;
			else
				returnValue = false;
			return returnValue;
		}
			
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	

}
