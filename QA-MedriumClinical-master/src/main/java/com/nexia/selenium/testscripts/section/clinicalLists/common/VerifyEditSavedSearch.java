package com.nexia.selenium.testscripts.section.clinicalLists.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditSavedSearch extends AbstractClinicalList {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Edit With Save Option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditWithSaveOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib searchData = new ClinicalListLib();
		searchData.workSheetName = "verifySearchForSex";
		searchData.testCaseId = "TC_VSS_001";
		searchData.fetchClinicalListTestData();
		verifySex(seleniumHost, seleniumPort, browser, webSite, userAccount, searchData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Edit With Save As Option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditWithSaveAsOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib searchData = new ClinicalListLib();
		searchData.workSheetName = "verifySearchForSex";
		searchData.testCaseId = "TC_VSS_002";
		searchData.fetchClinicalListTestData();
		verifySex(seleniumHost, seleniumPort, browser, webSite, userAccount, searchData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Edit With SaveAs Option With SameName")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditWithSaveAsOptionWithSameName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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

	public boolean verifySex(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib searchData) throws      IOException{
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
			//--------------------------------------------------------------------//
			//  Step-3: Delete Existing saved searches//
			//--------------------------------------------------------------------//
			while(isElementPresent(selenium,btnDelete)){
				int count=1;
				click(selenium,btnDelete);
				assertTrue(click(selenium,btnYes),"Could not click on yes button button;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				count++;
				if(count>15)
					break;
			}
			
			assertTrue(click(selenium,btnNewSearch),"Could not click on new search button ;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Add New Search //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnAddNew),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(runSearchQueryForSex(selenium,searchData,"MatchAll",possition),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Save the search//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnSave),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtClinicalListSave,searchData.searchName+uniqueName),"Could not enter the commend;More Details:"+searchData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveBtn),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(selenium.isConfirmationPresent()){
				selenium.chooseOkOnNextConfirmation();
			}
			waitForPageLoad(selenium);
			assertTrue(verifySavedSearch(selenium,searchData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Edit Saved the search//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,"xpath=(//a[contains(text(),'Edit')])[2]"),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			possition = Integer.parseInt(searchData.currentValue);
			
			if(searchData.testCaseId.equals("TC_VSS_001")){
			searchData.workSheetName = "verifySearchForSex";
			searchData.testCaseId = "TC_VSS_002";
			searchData.fetchClinicalListTestData();
			}
			if(searchData.testCaseId.equals("TC_VSS_002")){
				searchData.workSheetName = "verifySearchForSex";
				searchData.testCaseId = "TC_VSS_001";
				searchData.fetchClinicalListTestData();
			}
			if(searchData.testCaseId.equals("TC_VSS_003")){
				searchData.workSheetName = "verifySearchForSex";
				searchData.testCaseId = "TC_VSS_001";
				searchData.fetchClinicalListTestData();
			}
			searchData.currentValue = String.valueOf(possition);
			
			
			assertTrue(runSearchQueryForSex(selenium,searchData,"MatchAll",possition),"Creation failed", selenium, ClassName, MethodName);
			if(searchData.testCaseId.equals("TC_VSS_004")){
				assertTrue(click(selenium,btnDelete1),"Could not click on delete button button;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSaveButton),"Could not click on search button button;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSaveAs),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtClinicalListSave,searchData.searchName+uniqueName),"Could not enter the commend;More Details:"+searchData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSaveBtn),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,btnok)){
					return true;
				}
				
			}
			//--------------------------------------------------------------------//
			//  Step-5: Save edited search//
			//--------------------------------------------------------------------//
			if(searchData.testCaseId.equals("TC_VSS_002")){
			assertTrue(click(selenium,btnSave),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(selenium.isConfirmationPresent()){
				selenium.chooseOkOnNextConfirmation();
			}
			assertTrue(verifySavedSearch(selenium,searchData),"Save Search Failed", selenium, ClassName, MethodName);
			}
			if(searchData.testCaseId.equals("TC_VSS_001")){
				assertTrue(click(selenium,btnSaveAs),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtClinicalListSave,searchData.searchName1+uniqueName),"Could not enter the commend;More Details:"+searchData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSaveBtn),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(selenium.isConfirmationPresent()){
					selenium.chooseOkOnNextConfirmation();
				}
				assertTrue(verifySavedAsSearch(selenium,searchData),"Save Search Failed", selenium, ClassName, MethodName);
			}
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	/**
	 * verifySavedSearch
	 * Function to go to RegisterPatient
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Nov 22,2012
	 */
	public boolean verifySavedSearch(Selenium selenium,ClinicalListLib searchData) throws IOException{
		
		assertTrue(getText(selenium,lblSavedSearchInSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(searchData.searchName.trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
			
		return true;
	}
	/**
	 * verifySavedSearch
	 * Function to go to RegisterPatient
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Nov 22,2012
	 */
	public boolean verifySavedAsSearch(Selenium selenium,ClinicalListLib searchData) throws IOException{
		
		assertTrue(getText(selenium,lblSavedSearchInSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(searchData.searchName.trim().toLowerCase(new java.util.Locale("en","US")))," ", selenium, ClassName, MethodName);
			
		
		return true;
	}
}