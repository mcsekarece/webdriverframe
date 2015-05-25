package com.nexia.selenium.testscripts.section.demographics.Household;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyHeadOfHouseHoldOption extends AbstractHomeTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Head Of House Hold With New Member")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHeadOfHouseHoldWithNewMember(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib householdData = new HomeLib();
		householdData.workSheetName = "NewHousehold";
		householdData.testCaseId = "TC_HH_007";
		householdData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createHousehold(seleniumHost, seleniumPort, browser, webSite, userAccount, householdData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient household")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHeadOfHouseHoldWithOwnMember(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib householdData = new HomeLib();
		householdData.workSheetName = "NewHousehold";
		householdData.testCaseId = "TC_HH_008";
		householdData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createHeadOfHousehold(seleniumHost, seleniumPort, browser, webSite, userAccount, householdData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Head Of House Hold With New Member
	* @action 		  verifying Head Of House Hold With New Member
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
			if(!isElementPresent(selenium,lnkDelete)){
				click(selenium,lnkDelete);
				waitForPageLoad(selenium);
			}
		
			//--------------------------------------------------------------------//
			//  Step-4: Add a household member//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddHouseHold),"Could not Click on Add Family Member Button:"+ householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSearchPatient),"could not click search patients button; More Details:"+householdData.toString(),selenium,ClassName,MethodName);
			assertTrue(type(selenium,txtSearchboxHouseHold,householdData.searchpatient),"Could not enter patientID ; More Details :"+householdData.toString(),selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSearchHouseHold),"could not click search button; More Details:"+householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chkFirstHouseholdResult),"could not click the check box; More Details:"+householdData.toString(),selenium,ClassName,MethodName);
			if(!selenium.isChecked(chkHeadOfHouseHold1)){
			assertTrue(click(selenium,chkHeadOfHouseHold1),"could not click the check box; More Details:"+householdData.toString(),selenium,ClassName,MethodName);
			}
			assertTrue(click(selenium,btnSave),"could not click the save button; More Details:"+householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddHouseHold),"Could not Click on Add Family Member Button:"+ householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(!selenium.isChecked(chkHeadOfHouseHold1)){
			assertTrue(click(selenium,chkHeadOfHouseHold2),"could not click the check box; More Details:"+householdData.toString(),selenium,ClassName,MethodName);
			}
			assertTrue(click(selenium,btnSave),"could not click the save button; More Details:"+householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(getText(selenium,lblHouseHoldSummary1).toLowerCase(new java.util.Locale("en","US")).trim().contains("Head of Household".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
		}
			
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Head Of House Hold With Own Member
	* @action 		  verifying Head Of House Hold With Own Member
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 02, 2012
	***************************************************************************************************/
	public boolean createHeadOfHousehold(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib householdData) throws Exception{
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
			if(!isElementPresent(selenium,lnkDelete)){
				click(selenium,lnkDelete);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Add a household member//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddHouseHold),"Could not Click on Add Family Member Button:"+ householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(!selenium.isChecked(chkHeadOfHouseHold1)){
			assertTrue(click(selenium,chkHeadOfHouseHold1),"could not click the check box; More Details:"+householdData.toString(),selenium,ClassName,MethodName);
			}
			assertTrue(click(selenium,btnSave),"could not click the save button; More Details:"+householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(getText(selenium,lblHouseHoldSummary2).toLowerCase(new java.util.Locale("en","US")).trim().contains("Head of Household".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
