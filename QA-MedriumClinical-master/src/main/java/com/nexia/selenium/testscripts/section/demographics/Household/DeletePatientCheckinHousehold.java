package com.nexia.selenium.testscripts.section.demographics.Household;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;
public class DeletePatientCheckinHousehold extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for deleting patient household")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteHouseholdForPatientInSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib householdData = new HomeLib();
		householdData.workSheetName = "NewHousehold";
		householdData.testCaseId = "TC_HH_004";
		householdData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteHouseholdInSummary(seleniumHost, seleniumPort, browser, webSite, userAccount, householdData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for deleting patient household")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteHouseholdForPatientInCreationPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib householdData = new HomeLib();
		householdData.workSheetName = "NewHousehold";
		householdData.testCaseId = "TC_HH_004";
		householdData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteHouseholdForPatientInCreationPage(seleniumHost, seleniumPort, browser, webSite, userAccount, householdData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Delete New Patient Check in Info Household
	* @action 		  Delete New Patient Check in Info Household
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 02, 2012
	***************************************************************************************************/
	public boolean deleteHouseholdInSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib householdData) throws Exception{
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
			waitForPageLoad(selenium);
			assertTrue(switchRole(selenium,householdData.switchRole),"",selenium,ClassName,MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-3:Advanced search with Patient ID
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,householdData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkHouseHold);
			waitForPageLoad(selenium);
		
			if(isElementPresent(selenium,lnkDelete)){
				click(selenium,lnkDelete);
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Add a household member//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddHouseHold),"Could not Click on Add Family Member Button:"+ householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(createHousehold(selenium,householdData),"Household creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium,lnkDelete)){
				click(selenium,lnkDelete);
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);
			}
			if(isElementPresent(selenium,lnkDelete)){
				Assert.fail("Household member is not deleted properly; More Details :"+ householdData.toString());
				returnValue=false;
			}else
				return returnValue;
			}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/*************************************************************************************************** 
	* @purpose        To Delete New Patient Check in Info Household In Creation Page
	* @action 		  Delete New Patient Check in Info Household In Creation Page
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 02, 2012
	***************************************************************************************************/
	public boolean deleteHouseholdForPatientInCreationPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib householdData) throws Exception{
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
			//  Step-3:Advanced search with Patient ID
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,householdData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkHouseHold);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Add a household member//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddHouseHold),"Could not Click on Add Family Member Button:"+ householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lnkDelete)){
				assertTrue(click(selenium,lnkDelete),"Could not find delete button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(createHousehold(selenium,householdData),"Household creation Failed",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnAddHouseHold),"Could not Click on Add Family Member Button:"+ householdData.toString(),selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			while(isElementPresent(selenium,lnkDelete)){
				assertTrue(click(selenium,lnkDelete),"Could not find delete button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,btnSave),"could not click the save button; More Details:"+householdData.toString(),selenium,ClassName,MethodName);
			click(selenium,btnYesButton);
			waitForPageLoad(selenium);
			int Xpathcounter=(Integer) selenium.getXpathCount("//div[@id='MemberFamilyList']/table/tbody/tr/td/div/span/div");		
			if(Xpathcounter>1){
				Assert.fail("Household member is not deleted properly; More Details :"+ householdData.toString());
				returnValue=false;
			}else
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);		}
		return returnValue;
	}
}
