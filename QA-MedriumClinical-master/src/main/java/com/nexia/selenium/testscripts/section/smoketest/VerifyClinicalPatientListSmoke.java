package com.nexia.selenium.testscripts.section.smoketest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.smoketest.SmokeTestLib;
import com.nexia.selenium.genericlibrary.smoketest.AbstractSmokeTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyClinicalPatientListSmoke extends AbstractSmokeTest {
	@Test(groups = {"Smoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying all the search criteria together")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMatchAllForLessThanAgeCriteria(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SmokeTestLib searchData = new SmokeTestLib();
		searchData.workSheetName = "verifySearchWithAllCombination";
		searchData.testCaseId = "TC_VSA_001";
		searchData.fetchSmokeTestData();		
		verifySearchType(seleniumHost, seleniumPort, browser, webSite, userAccount, searchData);
	}
	/**
	 * verifySearchType
	 * Function for test Age criteria
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Nov 26, 2012
	 */
	
	public boolean verifySearchType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SmokeTestLib searchData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + searchData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, searchData.userName, searchData.userPassword),"Login Failde",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Clinical List										  //
			//--------------------------------------------------------------------//
			assertTrue(goToClinicalLists(selenium), "Could not open Clinical lists",selenium,ClassName,MethodName);
			
			assertTrue(click(selenium, "addIdentifierType"), "Could not click on New Search button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Fill the criteria and get the search result				  //
			//--------------------------------------------------------------------//
			assertTrue(searchWithAll(selenium,searchData,userAccount),"Search Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify the search results displayed//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			isElementPresent(selenium,btnCancel);
			assertTrue(click(selenium,btnCancel),"Could not click the cancel button;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);	
		}
		catch(RuntimeException e){
			Assert.fail("Failed due to Exception");
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}
	
}