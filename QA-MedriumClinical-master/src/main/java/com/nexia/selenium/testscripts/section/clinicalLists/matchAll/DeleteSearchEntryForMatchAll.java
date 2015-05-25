package com.nexia.selenium.testscripts.section.clinicalLists.matchAll;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteSearchEntryForMatchAll extends AbstractClinicalList  {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteSingleSearchEntry(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib searchData = new ClinicalListLib();
		searchData.workSheetName = "verifySearchForSex";
		searchData.testCaseId = "TC_VSS_001";
		searchData.fetchClinicalListTestData();
		verifyDeleteSingleEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, searchData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteMultipleSearchEntry(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib searchData = new ClinicalListLib();
		searchData.workSheetName = "verifySearchForSex";
		searchData.testCaseId = "TC_VSS_001";
		searchData.fetchClinicalListTestData();
		verifyDeleteMultipleEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, searchData);
	}
	/**
	 * verifyDeleteSingleEntry
	 * function to verify delete search results
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws       IOException 
	 * @since  	    Nov 21, 2012
	 */

	public boolean verifyDeleteSingleEntry(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib searchData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
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
			
				assertTrue(click(selenium,btnAddNew),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Search Entry //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkDelete),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium,lblSearchResult1),"It is present", selenium, ClassName, MethodName);

		/*	if(isElementPresent(selenium,lblSearchResult1)){
				returnValue=false;
			}*/
		
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	/**
	 * verifyDeleteMultipleEntry
	 * function to verify delete search results
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 21, 2012
	 */

	public boolean verifyDeleteMultipleEntry(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib searchData) throws  IOException{
		Selenium selenium=null;
		boolean returnValue=true;
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
			
				assertTrue(click(selenium,btnAddNew),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				assertTrue(click(selenium,btnAddNew),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Delete Search Entry //
			//--------------------------------------------------------------------//
			while(isElementPresent(selenium,btnDelete)){
				int count=1;
				click(selenium,btnDelete);
				waitForPageLoad(selenium);
				count++;
				if(count>10){
					break;
				}
			}
			assertTrue(!isElementPresent(selenium,lblSearchResult1),"It is present", selenium, ClassName, MethodName);

			/*if(isElementPresent(selenium,lblSearchResult1)){
				returnValue=false;
			}*/
		
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
