package com.nexia.selenium.testscripts.section.clinicalLists.matchOneOrMore;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchForTextForSex extends AbstractClinicalList {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySexWithMale(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib searchData = new ClinicalListLib();
		searchData.workSheetName = "verifySearchForSex";
		searchData.testCaseId = "TC_VSS_001";
		searchData.fetchClinicalListTestData();
		verifySex(seleniumHost, seleniumPort, browser, webSite, userAccount, searchData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySexWithFemale(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib searchData = new ClinicalListLib();
		searchData.workSheetName = "verifySearchForSex";
		searchData.testCaseId = "TC_VSS_002";
		searchData.fetchClinicalListTestData();
		verifySex(seleniumHost, seleniumPort, browser, webSite, userAccount, searchData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Sex With Either Female Or Male")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySexWithEitherFemaleOrMale(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib searchData = new ClinicalListLib();
		searchData.workSheetName = "verifySearchForSex";
		searchData.testCaseId = "TC_VSS_003";
		searchData.fetchClinicalListTestData();
		verifySex(seleniumHost, seleniumPort, browser, webSite, userAccount, searchData);
	}
	
	/**
	 * verifySex
	 * function to verify search results for sex
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 21, 2012
	 */

	public boolean verifySex(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib searchData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		int possition = 1;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + searchData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, searchData.userName, searchData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Clinical Lists//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click on new search button ;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Add New Search //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnAddNewCriteria1),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType);
			selectValueFromAjaxList(selenium,ajxSearchCondtion,searchData.sex);
			if(searchData.testCaseId.equals("TC_VSS_003")){
				assertTrue(click(selenium,btnAddNewCriteria1),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				possition = possition + 1;
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='sexConditionSuggestBoxsuggestBox'])[2]",searchData.sex1);
			}
			//assertTrue(verifySearchTextForMatchOneOrMoreSex(selenium,searchData),"Patient Checkin Failed");
			assertTrue(click(selenium,btnSearchClinicalList1),"Could not click on search button:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify the search results displayed//
			//--------------------------------------------------------------------//
			
			assertTrue(verifySearchTextInSearchResults(selenium,searchData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	/**
	 * verifySearchTextInSearchResults
	 * Function to go to RegisterPatient
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Nov 22,2012
	 */
	public boolean verifySearchTextInSearchResults(Selenium selenium,ClinicalListLib searchData) throws IOException{
		waitForPageLoad(selenium);
		if(!searchData.testCaseId.equals("TC_VSS_003")){
			assertTrue(getText(selenium,lblSeachText).toLowerCase(new java.util.Locale("en","US")).trim().contains("Include one or more of those".trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
				
			assertTrue(getText(selenium,lblSeachText).toLowerCase(new java.util.Locale("en","US")).trim().contains(searchData.searchType.trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
				
			assertTrue(getText(selenium,lblSeachText).toLowerCase(new java.util.Locale("en","US")).trim().contains(searchData.sex.trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
				
		}
		else if(searchData.testCaseId.equals("TC_VSS_003")){
			assertTrue(getText(selenium,lblSeachText).toLowerCase(new java.util.Locale("en","US")).trim().contains("Include one or more of those".trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
				
			assertTrue(getText(selenium,lblSeachText).toLowerCase(new java.util.Locale("en","US")).trim().contains(searchData.searchType.trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
				
			assertTrue(getText(selenium,lblSeachText).toLowerCase(new java.util.Locale("en","US")).trim().contains(searchData.sex.trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
				
			assertTrue(getText(selenium,lblSeachText).toLowerCase(new java.util.Locale("en","US")).trim().contains(searchData.sex1.trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
				
			assertTrue(getText(selenium,lblSeachText).toLowerCase(new java.util.Locale("en","US")).trim().contains("Or".trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
				
		}
		
		return true;
	}
}


