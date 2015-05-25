package com.nexia.selenium.testscripts.section.clinicalLists.matchAll;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMatchAllForAllergicTo extends AbstractClinicalList{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Match All Filter For Allergic To")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithAllergicToWithSinceAlways(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib allergyData = new ClinicalListLib();
		allergyData.workSheetName = "VerifySearchForAllergy";
		allergyData.testCaseId = "TC_SA_001";
		allergyData.fetchClinicalListTestData();
		searchAllergicTo(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Match All Filter For Allergic To")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithAllergicToWithWithinTheLast(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib allergyData = new ClinicalListLib();
		allergyData.workSheetName = "VerifySearchForAllergy";
		allergyData.testCaseId = "TC_SA_002";
		allergyData.fetchClinicalListTestData();
		searchAllergicTo(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for search With AllergicTo With After This Date ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithAllergicToWithAfterThisDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib allergyData = new ClinicalListLib();
		allergyData.workSheetName = "VerifySearchForAllergy";
		allergyData.testCaseId = "TC_SA_003";
		allergyData.fetchClinicalListTestData();
		searchAllergicTo(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for search With AllergicTo With SinceAlways And Within The Last")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithAllergicToWithSinceAlwaysAndWithinTheLast(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib allergyData = new ClinicalListLib();
		allergyData.workSheetName = "VerifySearchForAllergy";
		allergyData.testCaseId = "TC_SA_004";
		allergyData.fetchClinicalListTestData();
		searchAllergicTo(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Match All Filter For Allergic To")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithAllergicToWithWithinTheLastAndAftThisDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib allergyData = new ClinicalListLib();
		allergyData.workSheetName = "VerifySearchForAllergy";
		allergyData.testCaseId = "TC_SA_005";
		allergyData.fetchClinicalListTestData();
		searchAllergicTo(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Match All Filter For Allergic To")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithAllergicToWithAfterThisDateAndSinceAlways(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib allergyData = new ClinicalListLib();
		allergyData.workSheetName = "VerifySearchForAllergy";
		allergyData.testCaseId = "TC_SA_006";
		allergyData.fetchClinicalListTestData();
		searchAllergicTo(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Match All Filter For Allergic To")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithAllergicToWithAllOptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib allergyData = new ClinicalListLib();
		allergyData.workSheetName = "VerifySearchForAllergy";
		allergyData.testCaseId = "TC_SA_007";
		allergyData.fetchClinicalListTestData();
		searchAllergicTo(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Match All Filter For Allergic To")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithAllergicToWithMultipleAllergen(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib allergyData = new ClinicalListLib();
		allergyData.workSheetName = "VerifySearchForAllergy";
		allergyData.testCaseId = "TC_SA_008";
		allergyData.fetchClinicalListTestData();
		searchAllergicTo(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	
	/**
	 * searchAllergicTo
	 * function to Test Match All Filter For Allergic To
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 23, 2012
	 */
	
	public boolean searchAllergicTo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		int possition = 1;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete All Existing Allergy								  //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAllergies),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnCancelAllergy),"Could not click the cancel Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Go to Clinical List										  //
			//--------------------------------------------------------------------//
			
				selenium.focus(lnkQuickActions);
				selenium.clickAt(lnkQuickActions, "");
			
			//	assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnNewSearch))
			try{
				selenium.focus(btnNewSearch);
				waitForPageLoad(selenium);
				selenium.clickAt(btnNewSearch, "");
				
			}catch(Exception e){
				waitForPageLoad(selenium);
				selenium.focus(btnNewSearch);
				selenium.clickAt(btnNewSearch, "");
			}
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,lnkNewSearch),"Could not click Add New button in Match All Filter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Search Allergy    								          //
			//--------------------------------------------------------------------//
			assertTrue(filterForSearchAllergicTo(selenium, allergyData,"MatchAll",userAccount,possition), "Search for Allergy is failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Get the result count  						              //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			String result = getText(selenium, lblSearchResultLabel);
			String number[] = result.split(" results found for:");
			int count = Integer.parseInt(number[0]);
			
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnCancelId),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnErrorClose)){
				selenium.click(btnErrorClose);
			}
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			
			
			if(isElementPresent(selenium,lnkContinue)){
				selenium.click(lnkContinue);
			}
			assertTrue(click(selenium,lnkAllergies),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		
			
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Create new Allergy	             						  //
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Allergy Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(allergyData.testCaseId.equalsIgnoreCase("TC_SA_008")){
				assertTrue(createAllergy(selenium,allergyData,userAccount),"Second Allergy Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,btnCancelAllergy),"Could not click the cancel Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-9: Navigate to Clinical List							      //
			//--------------------------------------------------------------------//
			
				selenium.focus(lnkQuickActions);
				selenium.clickAt(lnkQuickActions, "");
			
			//	assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			try{
				selenium.focus(btnNewSearch);
				selenium.clickAt(btnNewSearch, "");
			}catch(Exception e){
				selenium.focus(btnNewSearch);
				selenium.clickAt(btnNewSearch, "");
			}
			assertTrue(click(selenium,lnkNewSearch),"Could not click Add New button in Match All Filter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-10: Again Search with the same Allergy    			          //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			possition = Integer.parseInt(allergyData.currentValue);
			assertTrue(filterForSearchAllergicTo(selenium, allergyData,"MatchAll",userAccount,possition), "Search for Allergy is failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-11: Get the result count  						              //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			String result1 = getText(selenium, lblSearchResultLabel);
			String number1[] = result1.split(" results found for:");
			int count1 = Integer.parseInt(number1[0]);
			
			if(allergyData.testCaseId.equalsIgnoreCase("TC_SA_008")){
				if(count1 == count+2)
					returnValue=true;
				else 
					returnValue=false;
			}
			else{
				if(count1 == count+1)
					returnValue=true;
				else 
					returnValue=false;
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
