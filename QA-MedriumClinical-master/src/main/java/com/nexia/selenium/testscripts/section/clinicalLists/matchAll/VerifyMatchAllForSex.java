package com.nexia.selenium.testscripts.section.clinicalLists.matchAll;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;


public class VerifyMatchAllForSex extends AbstractClinicalList {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Sex With Male")
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
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Sex With Female")
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
			
			assertTrue(click(selenium,btnAddNew),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(runSearchQueryForSex(selenium,searchData,"MatchAll",possition),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Verify the search results displayed//
			//--------------------------------------------------------------------//
			String numberOfRecordString= getText(selenium,lblSearchResultLabel);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			System.out.print(numberOfRecordString);
			int spacePos = numberOfRecordString.indexOf(" ");
			System.out.print(spacePos);
			String number = numberOfRecordString.substring(0,spacePos);
			System.out.print(number);
			int noOfRecords= Integer.parseInt(number);
			
			assertTrue(click(selenium,btnCancelId),"Could not click the cancel button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Syatem setting//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSettings),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSystemSetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			//--------------------------------------------------------------------//
			//---------------  Step-6:Delete All Mandatory data   --------------//
			//--------------------------------------------------------------------//	
			try{
				waitForPageLoad(selenium);
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
			//waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium), "Could not delete",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-7:Create Patient   --------------//
			//--------------------------------------------------------------------//	
			try{
				selenium.fireEvent(lnkQuickActions, "click");
			}
			catch(Exception e){
				selenium.fireEvent(lnkQuickActions, "click");
			}
			
			assertTrue(click(selenium,lnknewPatientAction),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
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
			//  Step-8: Verify the search results after patient creation//
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
				waitForPageLoad(selenium);
				selenium.clickAt(btnNewSearch, "");
				//selenium.focus(btnNewSearch);
				//selenium.fireEvent(btnNewSearch, "keypress");
				
			}
			catch(Exception e){
				waitForPageLoad(selenium);
				selenium.clickAt(btnNewSearch, "");
				//selenium.focus(btnNewSearch);
				//selenium.fireEvent(btnNewSearch, "keypress");
			}*/
			assertTrue(click(selenium, btnNewSearch), "Could not click on New Search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNew),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			possition = Integer.parseInt(searchData.currentValue);
			assertTrue(runSearchQueryForSex(selenium,searchData,"MatchAll",possition),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String numberOfRecordString1= getText(selenium,lblSearchResultLabel);
			waitForPageLoad(selenium);
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
}