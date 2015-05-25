package com.nexia.selenium.testscripts.section.clinicalLists.matchOneOrMore;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class SearchWithMedicationForMatchOneOrMore extends AbstractClinicalList{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient with medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		System.out.println(ClassName=this.getClass().getName().substring(39));
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalMedicationData = new ClinicalListLib();
		clinicalMedicationData.workSheetName = "SearchMedication";
		clinicalMedicationData.testCaseId = "TC_SM_001";
		clinicalMedicationData.fetchClinicalListTestData();
		searchMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalMedicationData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient with  within date Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithMedicationWithinDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalMedicationData = new ClinicalListLib();
		clinicalMedicationData.workSheetName = "SearchMedication";
		clinicalMedicationData.testCaseId = "TC_SM_002";
		clinicalMedicationData.fetchClinicalListTestData();
		searchMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalMedicationData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient with after date Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithMedicationAfterDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalMedicationData = new ClinicalListLib();
		clinicalMedicationData.workSheetName = "SearchMedication";
		clinicalMedicationData.testCaseId = "TC_SM_003";
		clinicalMedicationData.fetchClinicalListTestData();
		searchMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalMedicationData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient with after date Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithMedicationWithSinceAlwaysAndWithinLast(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalMedicationData = new ClinicalListLib();
		clinicalMedicationData.workSheetName = "SearchMedication";
		clinicalMedicationData.testCaseId = "TC_SM_004";
		clinicalMedicationData.fetchClinicalListTestData();
		searchMedicationWithMutipleOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalMedicationData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient with after date Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithMedicationWithSinceAlwaysAndAfterDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalMedicationData = new ClinicalListLib();
		clinicalMedicationData.workSheetName = "SearchMedication";
		clinicalMedicationData.testCaseId = "TC_SM_005";
		clinicalMedicationData.fetchClinicalListTestData();
		searchMedicationWithMutipleOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalMedicationData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient with after date Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithMedicationWithWithinLastAndAfterDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalMedicationData = new ClinicalListLib();
		clinicalMedicationData.workSheetName = "SearchMedication";
		clinicalMedicationData.testCaseId = "TC_SM_006";
		clinicalMedicationData.fetchClinicalListTestData();
		searchMedicationWithMutipleOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalMedicationData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient with after date Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithMedicationWithAllOptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalMedicationData = new ClinicalListLib();
		clinicalMedicationData.workSheetName = "SearchMedication";
		clinicalMedicationData.testCaseId = "TC_SM_007";
		clinicalMedicationData.fetchClinicalListTestData();
		searchMedicationWithMutipleOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalMedicationData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient with after date Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithMultipleMedications(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalMedicationData = new ClinicalListLib();
		clinicalMedicationData.workSheetName = "SearchMedication";
		clinicalMedicationData.testCaseId = "TC_SM_008";
		clinicalMedicationData.fetchClinicalListTestData();
		searchMedicationWithMutipleOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalMedicationData);
	}
	/**
	 * searchProblemList
	 * function to search patient with Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 22, 2012
	 */
	
	public boolean searchMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib clinicalMedicationData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		int possition = 1;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + clinicalMedicationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, clinicalMedicationData.userName, clinicalMedicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the New search button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddNewCriteria3),"Could not click the Add New button of match one or more ", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",clinicalMedicationData.searchField);
			if(userAccount.equals(CAAccount)){
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeca);
			}else
			selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeName);
			selectValueFromAjaxList(selenium,ajxtimeCondtion,clinicalMedicationData.timeCondition);
			if(clinicalMedicationData.testCaseId.equals("TC_SM_002")){
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtPeriodNumber1,clinicalMedicationData.periodNumber),"Could not type the period Number", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxPeriodCondition,clinicalMedicationData.period);
				
			}
			else if(clinicalMedicationData.testCaseId.equals("TC_SM_003")){
				assertTrue(type(selenium,txtLabDate,clinicalMedicationData.date),"Could not click the clinical list button", selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSearchClinicalList1),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			String st=getText(selenium,lblSearchResultLabel);
			waitForPageLoad(selenium);
			System.out.println(st);
			String[] st1=st.split("\\s+");
			System.out.println(st1[0]);
			waitForPageLoad(selenium);
			int count=Integer.parseInt(st1[0]);
			System.out.println(count);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnCancelId),"Could not click the confirmation!!", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Create Medication//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			HomeLib patientData = new HomeLib(); 
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_005";
			patientData.fetchHomeTestData();
			
			assertTrue(goToRegisterPatient(selenium), "Could not go to register patient", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,lnkContinue)){
				selenium.click(lnkContinue);
			}
			assertTrue(createNewPatientWithMandatory(selenium, patientData, clinicalMedicationData,userAccount), "Could not create a new patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOptionsLink),"Could not click the Patient Options", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkPatientChartView);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkToMedication),"Could not find the link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkToMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createMedication(selenium,clinicalMedicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnEdit),"Edit not present", selenium, ClassName, MethodName);

		/*	if(isElementPresent(selenium,btnEdit)){
				returnValue=true;
			}else
				returnValue=false;*/
			assertTrue(click(selenium, saveMedbtn), "Could not click on save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddNewCriteria3),"Could not click the clinical list button", selenium, ClassName, MethodName);
			possition = possition + 1;
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",clinicalMedicationData.searchField);
			if(userAccount.equals(CAAccount)){
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeca);
			}else
			selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeName);
			selectValueFromAjaxList(selenium,ajxtimeCondtion,clinicalMedicationData.timeCondition);
			if(clinicalMedicationData.testCaseId.equals("TC_SM_002")){
				assertTrue(type(selenium,txtPeriodNumber1,clinicalMedicationData.periodNumber),"Could not type the period Number", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxPeriodCondition,clinicalMedicationData.period);
			}
			else if(clinicalMedicationData.testCaseId.equals("TC_SM_003")){
				assertTrue(enterDate(selenium,txtLabDate,clinicalMedicationData.date),"Could not click the clinical list button", selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSearchClinicalList1),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String str=getText(selenium,lblSearchResultLabel);
			System.out.println(str);
			waitForPageLoad(selenium);
			
			String[] str1=str.split("\\s+");
			System.out.println(str1[0]);
			int count1=Integer.parseInt(str1[0]);
			System.out.println(count1);
			waitForPageLoad(selenium);
			if(count1>count)
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
	/**
	 * searchMedicationWithMutipleOptions
	 * function to search patient with multiple Medication options
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 22, 2012
	 */
	
	public boolean searchMedicationWithMutipleOptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib clinicalMedicationData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		int possition = 1;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + clinicalMedicationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, clinicalMedicationData.userName, clinicalMedicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,clinicalMedicationData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Medication //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lnkToMedication),"Could not find the link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkToMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteMedication(selenium,clinicalMedicationData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchMedicationWithOptionsForMatchOneOrMore(selenium,clinicalMedicationData,userAccount,possition),"Search not proper", selenium, ClassName, MethodName);
			
			String st=getText(selenium,lblSearchResultLabel);
			String[] st1=st.split("\\s+");
			int count=Integer.parseInt(st1[0]);
			
			assertTrue(click(selenium,btnCancelId),"Could not click the confirmation!!", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create Medication//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			
			searchPatientNexiaForProviderHomePage(selenium,clinicalMedicationData.patientId);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkToMedication),"Could not find the link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkToMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createMedication(selenium,clinicalMedicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnEdit),"Edit not present", selenium, ClassName, MethodName);

		/*	if(isElementPresent(selenium,btnEdit)){
				returnValue=true;
			}else
				returnValue=false;*/
			
			assertTrue(click(selenium, saveMedbtn), "Could not click on save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			possition = Integer.parseInt(clinicalMedicationData.currentValue);
			assertTrue(searchMedicationWithOptionsForMatchOneOrMore(selenium,clinicalMedicationData,userAccount,possition),"Search not proper", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String str=getText(selenium,lblSearchResultLabel);
			System.out.println(str);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String[] str1=str.split("\\s+");
			System.out.println(str1[0]);
			waitForPageLoad(selenium);
			int count1=Integer.parseInt(str1[0]);
			if(count1>count)
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
