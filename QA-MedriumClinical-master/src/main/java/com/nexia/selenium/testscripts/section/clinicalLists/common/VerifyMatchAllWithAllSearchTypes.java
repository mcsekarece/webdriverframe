package com.nexia.selenium.testscripts.section.clinicalLists.common;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMatchAllWithAllSearchTypes extends AbstractClinicalList {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying all the search criteria together")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMatchAllForLessThanAgeCriteria(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();ClinicalListLib searchData = new ClinicalListLib();
		searchData.workSheetName = "verifySearchWithAllCombination";
		searchData.testCaseId = "TC_VSA_001";
		searchData.fetchClinicalListTestData();
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
	
	public boolean verifySearchType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib searchData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = true;
		int possition = 1;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + searchData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, searchData.userName, searchData.userPassword),"Login Failde", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Clinical List										  //
			//--------------------------------------------------------------------//
			assertTrue(goToClinicalLists(selenium), "Could not open Clinical lists", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium, btnNewSearch), "Could not click on New Search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Fill the criteria and get the search result				  //
			//--------------------------------------------------------------------//
			assertTrue(searchWithAll(selenium,searchData,userAccount,possition),"Search Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify the search results displayed//
			//--------------------------------------------------------------------//
			String result = getText(selenium, lblSearchResultLabel);
			String number[] = result.split(" results found for:");
			int noOfRecords = Integer.parseInt(number[0]);
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			isElementPresent(selenium,btnCancelId);
			assertTrue(click(selenium,btnCancelId),"Could not click the cancel button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Syatem setting//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSystemSetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			isElementPresent(selenium,lnkAdminMandatory);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-6:Delete All Mandatory data   --------------//
			//--------------------------------------------------------------------//	
			try{
				selenium.clickAt(lnkAdminMandatory, "");
			}
			catch(RuntimeException e){
				selenium.clickAt(lnkAdminMandatory, "");
				
			}
			//assertTrue(click(selenium,lnkAdminMandatory),"Could not click admin Mandatory");
			//waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium),"Could not delete", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-7:Create Patient   --------------//
			//--------------------------------------------------------------------//	
			try{
				selenium.fireEvent(lnkQuickActions, "click");
			}
			catch(RuntimeException e){
				selenium.fireEvent(lnkQuickActions, "click");
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnknewPatientAction),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkContinue)){
				selenium.click(lnkContinue);
			}
			
			
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "NewPatientCheckIn";
			PatientData.testCaseId = "TC_NPC_001";
			PatientData.fetchHomeTestData();
			waitForPageLoad(selenium);
			assertTrue(createNewPatientWithMandatory(selenium,PatientData,searchData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Go to Clinical List										  //
			//--------------------------------------------------------------------//
			
			try{
				selenium.fireEvent(lnkQuickActions, "click");
			}
			catch(Exception e){
				selenium.fireEvent(lnkQuickActions, "click");
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkClinicalLists), "Could not click on Clinical Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(goToClinicalLists(selenium), "Could not open Clinical lists", selenium, ClassName, MethodName);
			/*try{
				selenium.clickAt(btnNewSearch, "");
				selenium.focus(btnNewSearch);
				selenium.fireEvent(btnNewSearch, "keypress");
				
			}
			catch(Exception e){
				selenium.clickAt(btnNewSearch, "");
				selenium.focus(btnNewSearch);                  
			}   selenium.fireEvent(btnNewSearch, "keypress");  */
			assertTrue(click(selenium, btnNewSearch), "Could not click on New Search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify the search results after patient creation//
			//--------------------------------------------------------------------//
			possition = Integer.parseInt(searchData.currentValue);
			assertTrue(searchWithAll(selenium,searchData,userAccount,possition),"Search Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String result1 = getText(selenium, lblSearchResultLabel);
			String number1[] = result1.split(" results found for:");
			int noOfRecords1 = Integer.parseInt(number1[0]);
			
			if(noOfRecords<=noOfRecords1){
				return true;
			}
		}
		catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}
}

