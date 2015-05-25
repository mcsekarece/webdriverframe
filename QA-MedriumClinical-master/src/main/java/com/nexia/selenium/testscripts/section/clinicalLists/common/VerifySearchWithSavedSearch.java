package com.nexia.selenium.testscripts.section.clinicalLists.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchWithSavedSearch extends AbstractClinicalList {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySavedSearch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib searchData = new ClinicalListLib();
		searchData.workSheetName = "verifySearchForSex";
		searchData.testCaseId = "TC_VSS_001";
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
		int possition =1;
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
			assertTrue(type(selenium,txtClinicalListSave,searchData.searchName+uniqueName),"Could not enter the commend;More Details:"+searchData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveBtn),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(verifySavedSearch(selenium,searchData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify search with saved search//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSearch),"Could not click on Search button button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify the search results displayed//
			//--------------------------------------------------------------------//
			String numberOfRecordString= getText(selenium,lblSearchResultLabel);
			int spacePos = numberOfRecordString.indexOf(" ");
			String number = numberOfRecordString.substring(0,spacePos);
			int noOfRecords= Integer.parseInt(number);
			assertTrue(click(selenium,btnCancelId),"Could not click the cancel button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: Create a patient//
			//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnknewPatientAction),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "NewPatientCheckIn";
			PatientData.testCaseId = "TC_NPC_001";
			PatientData.fetchHomeTestData();
			
			assertTrue(createNewPatientWithMandatory(selenium,PatientData,searchData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify the search results after patient creation//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			try{
				selenium.focus(btnNewSearch);
				selenium.clickAt(btnNewSearch, "");
			}catch(Exception e){
				selenium.focus(btnNewSearch);
				selenium.clickAt(btnNewSearch, "");
			}
			//assertTrue(click(selenium,btnNewSearch),"Could not click on new search button ;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNew),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			possition = Integer.parseInt(searchData.currentValue);
			assertTrue(runSearchQueryForSex(selenium,searchData,"MatchAll",possition),"Creation failed", selenium, ClassName, MethodName);
			
			String numberOfRecordString1= getText(selenium,lblSearchResultLabel);
			int spacePos1 = numberOfRecordString1.indexOf(" ");
			String number1 = numberOfRecordString1.substring(0,spacePos1);
			int noOfRecords1= Integer.parseInt(number1);
			
			if(noOfRecords<noOfRecords1){
				return true;
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
}
