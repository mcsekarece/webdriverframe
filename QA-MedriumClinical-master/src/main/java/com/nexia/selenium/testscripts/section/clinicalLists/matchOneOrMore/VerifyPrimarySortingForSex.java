package com.nexia.selenium.testscripts.section.clinicalLists.matchOneOrMore;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPrimarySortingForSex extends AbstractClinicalList {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Asc With Male")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAscWithMale(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib searchData = new ClinicalListLib();
		searchData.workSheetName = "verifySearchForSex";
		searchData.testCaseId = "TC_VSS_003";
		searchData.fetchClinicalListTestData();
		verifySex(seleniumHost, seleniumPort, browser, webSite,userAccount, searchData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Asc With Female")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAscWithFemale(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib searchData = new ClinicalListLib();
		searchData.workSheetName = "verifySearchForSex";
		searchData.testCaseId = "TC_VSS_004";
		searchData.fetchClinicalListTestData();
		verifySex(seleniumHost, seleniumPort, browser, webSite, userAccount,searchData);
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

	public boolean verifySex(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, ClinicalListLib searchData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		int possition=1;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + searchData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium,userAccount, searchData.userName, searchData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Clinical Lists//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
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
			selectValueFromAjaxList(selenium,"sexConditionSuggestBoxsuggestBox",searchData.sex);
			waitForPageLoad(selenium);
				possition = possition+1;
				assertTrue(click(selenium,btnAddNewCriteria1),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType);
				selectValueFromAjaxList(selenium,ajxSex1CondtionForMatchAll,searchData.sex1);
			
			
			
			
			
			if(searchData.testCaseId.equals("TC_VSS_003")){
			assertTrue(click(selenium,chkSort),"Could not click on Ascending order;More Details", selenium, ClassName, MethodName);
			}
			else if(searchData.testCaseId.equals("TC_VSS_004")){
				assertTrue(click(selenium,chkAsc),"Could not click on Ascending order;More Details", selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSearchClinicalList),"Could not click on search button:", selenium, ClassName, MethodName);
			
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
		if(!searchData.testCaseId.equals("TC_VSS_003")){
			assertTrue(!getText(selenium,lblSortResult1).toLowerCase(new java.util.Locale("en","US")).trim().contains("M".trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
				
		}else if(!searchData.testCaseId.equals("TC_VSS_004")){
			assertTrue(getText(selenium,lblSortResult1).toLowerCase(new java.util.Locale("en","US")).trim().contains("F".trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
				
		}
		
		return true;
	}
}