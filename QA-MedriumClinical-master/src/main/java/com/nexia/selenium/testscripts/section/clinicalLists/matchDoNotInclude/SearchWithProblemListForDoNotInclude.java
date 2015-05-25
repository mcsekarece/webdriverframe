package com.nexia.selenium.testscripts.section.clinicalLists.matchDoNotInclude;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class SearchWithProblemListForDoNotInclude extends AbstractClinicalList{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient without problem in time condition option as since always")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalProblemListData = new ClinicalListLib();
		clinicalProblemListData.workSheetName = "SearchProblemList";
		clinicalProblemListData.testCaseId = "TC_SPL_001";
		clinicalProblemListData.fetchClinicalListTestData();
		searchProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalProblemListData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient without problem in time condition as within the last ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithProblemListWithinDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalProblemListData = new ClinicalListLib();
		clinicalProblemListData.workSheetName = "SearchProblemList";
		clinicalProblemListData.testCaseId = "TC_SPL_002";
		clinicalProblemListData.fetchClinicalListTestData();
		searchProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalProblemListData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient without problem in time condition as after this date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithProblemListAfterDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalProblemListData = new ClinicalListLib();
		clinicalProblemListData.workSheetName = "SearchProblemList";
		clinicalProblemListData.testCaseId = "TC_SPL_003";
		clinicalProblemListData.fetchClinicalListTestData();
		searchProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalProblemListData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient who has no problem when time condition is since always and within the last")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithProblemListWithSinceAlwaysAndWithinLast(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalProblemListData = new ClinicalListLib();
		clinicalProblemListData.workSheetName = "SearchProblemList";
		clinicalProblemListData.testCaseId = "TC_SPL_004";
		clinicalProblemListData.fetchClinicalListTestData();
		searchProblemListWithMutipleOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalProblemListData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient who has no problem when time condition is since always and after this date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithProblemListWithSinceAlwaysAndAfterDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalProblemListData = new ClinicalListLib();
		clinicalProblemListData.workSheetName = "SearchProblemList";
		clinicalProblemListData.testCaseId = "TC_SPL_005";
		clinicalProblemListData.fetchClinicalListTestData();
		searchProblemListWithMutipleOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalProblemListData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient who has no problem when time condition is within the last and after date Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithProblemListWithWithinLastAndAfterDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalProblemListData = new ClinicalListLib();
		clinicalProblemListData.workSheetName = "SearchProblemList";
		clinicalProblemListData.testCaseId = "TC_SPL_006";
		clinicalProblemListData.fetchClinicalListTestData();
		searchProblemListWithMutipleOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalProblemListData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient who has no problem when time condition is since always and within the last or after date Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithProblemListWithAllOptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLib clinicalProblemListData = new ClinicalListLib();
		clinicalProblemListData.workSheetName = "SearchProblemList";
		clinicalProblemListData.testCaseId = "TC_SPL_007";
		clinicalProblemListData.fetchClinicalListTestData();
		searchProblemListWithMutipleOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalProblemListData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient who has neither of two problems")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithMultipleProblemLists(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalProblemListData = new ClinicalListLib();
		clinicalProblemListData.workSheetName = "SearchProblemList";
		clinicalProblemListData.testCaseId = "TC_SPL_008";
		clinicalProblemListData.fetchClinicalListTestData();
		searchProblemListWithMutipleOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalProblemListData);
	}
	/**
	 * searchProblemList
	 * function to search patient with problem list
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws     IOException 
	 * @since  	    Nov 23, 2012
	 */
	
	public boolean searchProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib clinicalProblemListData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		int possition = 1;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + clinicalProblemListData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, clinicalProblemListData.userName, clinicalProblemListData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,clinicalProblemListData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Problem lists //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllProblemList(selenium, clinicalProblemListData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNewCriteria2),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchWithProblemList(selenium,clinicalProblemListData,"doNotInclude",possition),"could not display search results", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String st=getText(selenium,lblSearchResultLabel);
			String[] st1=st.split("\\s+");
			int count=Integer.parseInt(st1[0]);
			
			assertTrue(click(selenium,btnCancelId),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Create Medication//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose))
		   			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			searchPatientNexiaForProviderHomePage(selenium,clinicalProblemListData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createProblemList(selenium,clinicalProblemListData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnEdit),"Edit is not present", selenium, ClassName, MethodName);

			/*if(isElementPresent(selenium,btnEdit)){
				returnValue=true;
			}else
				returnValue=false;*/
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNewCriteria2),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			possition = Integer.parseInt(clinicalProblemListData.currentValue);
			assertTrue(searchWithProblemList(selenium,clinicalProblemListData,"doNotInclude",possition),"could not display search results", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			String str=getText(selenium,lblSearchResultLabel);
			String[] str1=str.split("\\s+");
			int count1=Integer.parseInt(str1[0]);
			if(count1==count)
				returnValue=true;
			else
				returnValue=false;
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	/**
	 * searchProblemListWithMutipleOptions
	 * function to search patient with multiple Problem List options
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws     	IOException 
	 * @since  	    Nov 23, 2012
	 */
	
	public boolean searchProblemListWithMutipleOptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib clinicalProblemListData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		int possition = 1;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + clinicalProblemListData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, clinicalProblemListData.userName, clinicalProblemListData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,clinicalProblemListData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Problem lists //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProblemList),"Could not click the Problem list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllProblemList(selenium, clinicalProblemListData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProblemList(selenium,clinicalProblemListData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(clinicalProblemListData.testCaseId.equals("TC_SPL_008")){
				assertTrue(createProblemList(selenium,clinicalProblemListData,userAccount),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Clinical lists //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNewCriteria2),"Could not click the clinical list button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddNewCriteria2),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(clinicalProblemListData.testCaseId.equals("TC_SPL_007"))
				assertTrue(click(selenium,btnAddNewCriteria2),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: search a patient with Problem //
			//--------------------------------------------------------------------//
			assertTrue(searchProblemListWithOptions(selenium,clinicalProblemListData,"doNotInclude",possition),"Search not proper", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String st=getText(selenium,lblSearchResultLabel);
			String[] st1=st.split("\\s+");
			int count=Integer.parseInt(st1[0]);
			
			assertTrue(click(selenium,btnCancelId),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: create a Problem for a patient //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose))
		   			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 
			searchPatientNexiaForProviderHomePage(selenium,clinicalProblemListData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllProblemList(selenium, clinicalProblemListData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(isElementPresent(selenium,btnEdit),"Edit is not present", selenium, ClassName, MethodName);

		/*	if(isElementPresent(selenium,btnEdit)){
				returnValue=true;
			}else
				returnValue=false;*/
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNewCriteria2),"Could not click the clinical list button", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnAddNewCriteria2),"Could not click the clinical list button", selenium, ClassName, MethodName);
			if(clinicalProblemListData.testCaseId.equals("TC_SPL_007"))
				assertTrue(click(selenium,btnAddNewCriteria2),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			possition = Integer.parseInt(clinicalProblemListData.currentValue);
			assertTrue(searchProblemListWithOptions(selenium,clinicalProblemListData,"doNotInclude",possition),"Search not proper", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String str=getText(selenium,lblSearchResultLabel);
			String[] str1=str.split("\\s+");
			int count1=Integer.parseInt(str1[0]);
			if(count1>=count)
				returnValue=true;
			else
				returnValue=false;
			}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
