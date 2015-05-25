package com.nexia.selenium.testscripts.section.clinicalLists.matchDoNotInclude;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDoNotIncludeForAllergicTo extends AbstractClinicalList{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Match All Filter For Allergic To")
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
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Match All Filter For Allergic To")
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
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Match All Filter For Allergic To")
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
			//btnsave
			assertTrue(click(selenium,saveAlgbtn), "Could not click on save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Go to Clinical List										  //
			//--------------------------------------------------------------------//
			assertTrue(goToClinicalLists(selenium), "Could not navigate to Clinical Lists", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNewCriteria2),"Could not click Add New button in Match All Filter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Search Allergy    								          //
			//--------------------------------------------------------------------//
			assertTrue(filterForSearchAllergicTo(selenium, allergyData,"doNotInclude",userAccount,possition), "Search for Allergy is failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Get the result count  						              //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			String st=getText(selenium,lblSearchResultLabel);
			String[] st1=st.split("\\s+");
			int count=Integer.parseInt(st1[0]);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnCancelId),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAllergies),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, saveAlgbtn), "Could not click on save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-9: Navigate to Clinical List							      //
			//--------------------------------------------------------------------//
			assertTrue(goToClinicalLists(selenium), "Could not navigate to Clinical Lists", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNewCriteria2),"Could not click Add New button in Match All Filter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			possition = Integer.parseInt(allergyData.currentValue);
			//--------------------------------------------------------------------//
			//  Step-10: Again Search with the same Allergy    			          //
			//--------------------------------------------------------------------//
			assertTrue(filterForSearchAllergicTo(selenium, allergyData,"doNotInclude",userAccount,possition), "Search for Allergy is failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-11: Get the result count  						              //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			String str=getText(selenium,lblSearchResultLabel);
			String[] str1=str.split("\\s+");
			int count1=Integer.parseInt(str1[0]);
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
