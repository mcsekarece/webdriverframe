package com.nexia.selenium.testscripts.section.clinicalLists.matchOneOrMore;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMatchOneOrMoreForSex extends AbstractClinicalList {
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
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySexWithEitherFemaileOrMale(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
			assertTrue(runSearchQueryForSex(selenium,searchData,"OneOrMore",possition),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Verify the search results displayed//
			//--------------------------------------------------------------------//
			String numberOfRecordString= getText(selenium,lblSearchResultLabel);
			System.out.println(numberOfRecordString);
			int spacePos = numberOfRecordString.indexOf(" ");
			System.out.println(spacePos);
			String number = numberOfRecordString.substring(0,spacePos);
			System.out.println(number);
			Integer noOfRecords= Integer.parseInt(number);
			System.out.println(noOfRecords);
			//--------------------------------------------------------------------//
			//  Step-5: Create a patient//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSettings),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-4:Delete All Mandatory data   --------------//
			//--------------------------------------------------------------------//	
			try{
				selenium.clickAt(lnkAdminMandatory, "");
				selenium.focus(lnkAdminMandatory);
				selenium.fireEvent(lnkAdminMandatory, "keypress");
				
			}
			catch(Exception e){
				waitForPageLoad(selenium);
				selenium.clickAt(lnkAdminMandatory, "");
				//selenium.focus(lnkAdminMandatory);
				//selenium.fireEvent(lnkAdminMandatory, "keypress");
			}
			
			
			//assertTrue(click(selenium,lnkAdminMandatory),"Could not click admin Mandatory");
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			try{
				selenium.fireEvent(lnkQuickActions, "click");
			}
			catch(Exception e){
				selenium.fireEvent(lnkQuickActions, "click");
			}
			try{
				selenium.fireEvent(lnknewPatientAction, "click");
			}
			catch(Exception e){
				selenium.fireEvent(lnknewPatientAction, "click");
			}
			//assertTrue(click(selenium,lnknewPatientAction),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lnkContinue)){
				selenium.click(lnkContinue);
			}
			
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "NewPatientCheckIn";
			PatientData.testCaseId = "TC_NPC_001";
			PatientData.fetchHomeTestData();
			
			assertTrue(createNewPatientWithMandatory(selenium,PatientData,searchData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		
			//--------------------------------------------------------------------//
			//  Step-6: Verify the search results after patient creation//
			//--------------------------------------------------------------------//
			
			try{
				selenium.fireEvent(lnkQuickActions, "click");
			}
			catch(Exception e){
				selenium.fireEvent(lnkQuickActions, "click");
			}
			waitForPageLoad(selenium);
			
			//	assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			/*try{
				selenium.clickAt(btnNewSearch, "");
				selenium.focus(btnNewSearch);
				selenium.fireEvent(btnNewSearch, "keypress");
				
			}
			catch(Exception e){
				selenium.clickAt(btnNewSearch, "");
				//selenium.focus(btnNewSearch);
				//selenium.fireEvent(btnNewSearch, "keypress");
			}*/
			
			
			assertTrue(click(selenium,btnNewSearch),"Could not click on new search button ;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNewCriteria1),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			possition = Integer.parseInt(searchData.currentValue);
			assertTrue(runSearchQueryForSex(selenium,searchData,"OneOrMore",possition),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String numberOfRecordString1= getText(selenium,lblSearchResultLabel);
			
			int spacePos1 = numberOfRecordString1.indexOf(" ");
			String number1 = numberOfRecordString1.substring(0,spacePos1);
			Integer noOfRecords1= Integer.parseInt(number1);
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


