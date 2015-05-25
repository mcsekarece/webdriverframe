package com.nexia.selenium.testscripts.section.clinicalLists.common;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchWithMatchOneOrMoreWithDoNotInclude extends AbstractClinicalList {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Age criteria")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMatchAllForLessThanAgeCriteria(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib ageData = new ClinicalListLib();
		ageData.workSheetName = "verifySearchWithCombination";
		ageData.testCaseId = "TC_SWC_002";
		ageData.fetchClinicalListTestData();
		verifySearch(seleniumHost, seleniumPort, browser, webSite, userAccount, ageData);
	}
	/**
	 * verifySearch
	 * Function for test Age criteria
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Nov 21, 2012
	 */
	
	public boolean verifySearch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib ageData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = true;
		int possition = 1;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ageData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, ageData.userName, ageData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Clinical List										  //
			//--------------------------------------------------------------------//
			assertTrue(goToClinicalLists(selenium), "Could not open Clinical lists", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium, btnNewSearch), "Could not click on New Search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Fill the criteria and get the search result				  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match All Filter", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",ageData.searchType2);
			selectValueFromAjaxList(selenium,ajxSearchCondtion,ageData.sex);
			
			possition = possition + 1;
			
			assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match All Filter", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",ageData.searchType3);
			selectValueFromAjaxList(selenium,ajxSex1CondtionForMatchAll,ageData.sex1);
			
			possition = possition +1;
			
			assertTrue(click(selenium, btnAddForMatchAll), "Could not click on Add New button for Match All Filter", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox", ageData.searchType1);
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"excludedurationConditionSuggestBoxsuggestBoxsuggestBox", ageData.durationCondition1);
			assertTrue(type(selenium, String.valueOf(possition)+"excludedurationIntegerMax", ageData.year1), "Could not enter minimum year", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnSearchClinicalList),"Could not click on search button:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Verify the search results displayed//
			//--------------------------------------------------------------------//
			
			String result = getText(selenium, lblSearchResultLabel);
			String number[] = result.split(" results found for:");
			int noOfRecords = Integer.parseInt(number[0]);
			assertTrue(click(selenium,btnCancelId),"Could not click the cancel button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Create a patient//
			//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnknewPatientAction),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,lnkContinue)){
				selenium.click(lnkContinue);
			}
			
			waitForPageLoad(selenium);
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "NewPatientCheckIn";
			PatientData.testCaseId = "TC_NPC_001";
			PatientData.fetchHomeTestData();
			
			assertTrue(createNewPatientWithMandatory(selenium,PatientData,ageData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify the search results after patient creation//
			//--------------------------------------------------------------------//
			try{
				selenium.focus(lnkQuickActions);
				selenium.clickAt(lnkQuickActions, "");
			}catch(Exception e){
				selenium.focus(lnkQuickActions);
				selenium.clickAt(lnkQuickActions, "");
			}
			//	assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			/*try{
				selenium.focus(btnNewSearch);
				selenium.clickAt(btnNewSearch, "");
			}catch(Exception e){
				selenium.focus(btnNewSearch);
				selenium.clickAt(btnNewSearch, "");
			}*/
			assertTrue(click(selenium,btnNewSearch),"Could not click on new search button ;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			/*	assertTrue(click(selenium,btnAddNew),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/

			possition = possition + 1;
			
			assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match All Filter", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",ageData.searchType2);
			selectValueFromAjaxList(selenium,ajxSearchCondtion,ageData.sex);
			
			possition = possition + 1;
			
			assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match All Filter", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",ageData.searchType3);
			selectValueFromAjaxList(selenium,ajxSex1CondtionForMatchAll,ageData.sex1);
			
			possition = possition +1;
			
			assertTrue(click(selenium, btnAddForMatchAll), "Could not click on Add New button for Match All Filter", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox", ageData.searchType1);
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"excludedurationConditionSuggestBoxsuggestBoxsuggestBox", ageData.durationCondition1);
			assertTrue(type(selenium, String.valueOf(possition)+"excludedurationIntegerMax", ageData.year1), "Could not enter minimum year", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnSearchClinicalList),"Could not click on search button:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String result1 = getText(selenium, lblSearchResultLabel);
			String number1[] = result1.split(" results found for:");
			int noOfRecords1 = Integer.parseInt(number1[0]);
			if(noOfRecords<noOfRecords1){
				return true;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
