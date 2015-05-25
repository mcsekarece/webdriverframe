package com.nexia.selenium.testscripts.section.clinicalLists.matchOneOrMore;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMatachOneOrMoreForAge extends AbstractClinicalList{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Age criteria")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMatchOneOrMoreForLessThanAgeCriteria(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib ageData = new ClinicalListLib();
		ageData.workSheetName = "verifySearchForAge";
		ageData.testCaseId = "TC_CLA_001";
		ageData.fetchClinicalListTestData();
		verifyAgeCriteria(seleniumHost, seleniumPort, browser, webSite, userAccount, ageData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Age criteria")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMatchOneOrMoreForAgeMoreThanCriteria(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib ageData = new ClinicalListLib();
		ageData.workSheetName = "verifySearchForAge";
		ageData.testCaseId = "TC_CLA_002";
		ageData.fetchClinicalListTestData();
		verifyAgeCriteria(seleniumHost, seleniumPort, browser, webSite, userAccount, ageData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Age criteria")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMatchOneOrMoreForAgeBetweenCriteria(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib ageData = new ClinicalListLib();
		ageData.workSheetName = "verifySearchForAge";
		ageData.testCaseId = "TC_CLA_003";
		ageData.fetchClinicalListTestData();
		verifyAgeCriteria(seleniumHost, seleniumPort, browser, webSite, userAccount, ageData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Age criteria")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMatchOneOrMoreForAgeWithLessAndMore(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib ageData = new ClinicalListLib();
		ageData.workSheetName = "verifySearchForAge";
		ageData.testCaseId = "TC_CLA_007";
		ageData.fetchClinicalListTestData();
		verifyAgeCriteria(seleniumHost, seleniumPort, browser, webSite, userAccount, ageData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Age criteria")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMatchOneOrMoreForAgeWithMoreAndBetween(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib ageData = new ClinicalListLib();
		ageData.workSheetName = "verifySearchForAge";
		ageData.testCaseId = "TC_CLA_008";
		ageData.fetchClinicalListTestData();
		verifyAgeCriteria(seleniumHost, seleniumPort, browser, webSite, userAccount, ageData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Age criteria")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMatchOneOrMoreForAgeWithBetweenAndLess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib ageData = new ClinicalListLib();
		ageData.workSheetName = "verifySearchForAge";
		ageData.testCaseId = "TC_CLA_009";
		ageData.fetchClinicalListTestData();
		verifyAgeCriteria(seleniumHost, seleniumPort, browser, webSite, userAccount, ageData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Age criteria")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMatchOneOrMoreForAgeWithAllOptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib ageData = new ClinicalListLib();
		ageData.workSheetName = "verifySearchForAge";
		ageData.testCaseId = "TC_CLA_010";
		ageData.fetchClinicalListTestData();
		verifyAgeCriteria(seleniumHost, seleniumPort, browser, webSite, userAccount, ageData);
	}
	/**
	 * verifyAgeCriteria
	 * Function for test Age criteria
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Nov 21, 2012
	 */
	
	public boolean verifyAgeCriteria(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib ageData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = true;
		int possition=1;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ageData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, ageData.userName, ageData.userPassword),"Login Failde", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Clinical List										  //
			//--------------------------------------------------------------------//
			assertTrue(goToClinicalLists(selenium), "Could not open Clinical lists", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium, btnNewSearch), "Could not click on New Search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Fill the criteria and get the search result				  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match All Filter", selenium, ClassName, MethodName);
			assertTrue(filterForAge(selenium, ageData,"OneOrMore",possition), "Age search criteria is failed" ,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String st=getText(selenium,lblSearchResultLabel);
			String[] st1=st.split("\\s+");
			int count=Integer.parseInt(st1[0]);
			assertTrue(click(selenium,btnCancelId),"Could not click the confirmation!!" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Create a new patient to verify search result     		  //
			//--------------------------------------------------------------------//
			
			HomeLib patientData = new HomeLib(); 
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_005";
			patientData.fetchHomeTestData();
			
			assertTrue(goToRegisterPatient(selenium), "Could not go to register patient" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(createNewPatientWithMandatory(selenium, patientData, ageData,userAccount), "Could not create a new patient" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			try{
                selenium.fireEvent(lnkQuickActions, "click");
			}
			catch(Exception e){
                selenium.fireEvent(lnkQuickActions, "click");
			}

			assertTrue(isElementPresent(selenium,lnkClinicalLists),"Could not find the patient oprtions link" , selenium, ClassName, MethodName);

			assertTrue(click(selenium,lnkClinicalLists),"Could not click the patient options link" , selenium, ClassName, MethodName);

			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			
			/*try{
                selenium.focus(btnNewSearch);
                selenium.clickAt(btnNewSearch, "");
			}
			catch(Exception e){
                selenium.focus(btnNewSearch);
                selenium.clickAt(btnNewSearch, "");
			}
			*/
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the patient options link" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Again Fill the criteria and get the search result	      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNewCriteria3), "Could not click on Add New button for Match All Filter", selenium, ClassName, MethodName);
			possition = Integer.parseInt(ageData.currentValue);
			assertTrue(filterForAge(selenium, ageData,"OneOrMore",possition), "Age search criteria is failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//Get number of results
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			String result1=getText(selenium,lblSearchResultLabel);
			String number1[]=result1.split("\\s+");
			int count1=Integer.parseInt(number1[0]);
			if(count1>count){
			returnValue = true;
			}else
				returnValue=false;
		}
		catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}
}
