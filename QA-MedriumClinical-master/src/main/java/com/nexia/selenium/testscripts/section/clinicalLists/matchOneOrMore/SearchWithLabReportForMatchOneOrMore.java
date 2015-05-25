package com.nexia.selenium.testscripts.section.clinicalLists.matchOneOrMore;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class SearchWithLabReportForMatchOneOrMore extends AbstractClinicalList{
	
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "To search a patient with lab report less than 500 or since always")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithLabReportLessThanSinceAlways(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib labReportData = new ClinicalListLib();
		labReportData.workSheetName = "SearchLabReport";
		labReportData.testCaseId = "TC_SLR_001";
		labReportData.fetchClinicalListTestData();
		
		searchLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "To search a patient with lab report less than 500 or within the last")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithLabReportLessThanWithinTheLast(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib labReportData = new ClinicalListLib();
		labReportData.workSheetName = "SearchLabReport";
		labReportData.testCaseId = "TC_SLR_002";
		labReportData.fetchClinicalListTestData();
		searchLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportData);
	}
	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "To search a patient with lab report less than 500 or after this date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithLabReportLessThanAfterThisDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib labReportData = new ClinicalListLib();
		labReportData.workSheetName = "SearchLabReport";
		labReportData.testCaseId = "TC_SLR_003";
		labReportData.fetchClinicalListTestData();
		searchLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "To search a patient with lab report more than 10 or since always")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithLabReportGreaterThanSinceAlways(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib labReportData = new ClinicalListLib();
		labReportData.workSheetName = "SearchLabReport";
		labReportData.testCaseId = "TC_SLR_004";
		labReportData.fetchClinicalListTestData();
		searchLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "To search a patient with lab report more than 10 or within the last")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithLabReportGreaterThanWithinTheLast(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib labReportData = new ClinicalListLib();
		labReportData.workSheetName = "SearchLabReport";
		labReportData.testCaseId = "TC_SLR_005";
		labReportData.fetchClinicalListTestData();
		searchLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "To search a patient with lab report more than 10 or after this date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithLabReportGreaterThanAfterThisDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib labReportData = new ClinicalListLib();
		labReportData.workSheetName = "SearchLabReport";
		labReportData.testCaseId = "TC_SLR_006";
		labReportData.fetchClinicalListTestData();
		searchLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "To search a patient with lab report between 10 and 500 or since always")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithLabReportBetweenAndSinceAlways(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib labReportData = new ClinicalListLib();
		labReportData.workSheetName = "SearchLabReport";
		labReportData.testCaseId = "TC_SLR_007";
		labReportData.fetchClinicalListTestData();
		searchLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "To search a patient with lab report between 10 and 500 or within the last")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithLabReportBetweenAndWithinThisDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib labReportData = new ClinicalListLib();
		labReportData.workSheetName = "SearchLabReport";
		labReportData.testCaseId = "TC_SLR_008";
		labReportData.fetchClinicalListTestData();
		searchLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "To search a patient with lab report between 10 and 500 or after this date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithLabReportBetweenAndAfterThisDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib labReportData = new ClinicalListLib();
		labReportData.workSheetName = "SearchLabReport";
		labReportData.testCaseId = "TC_SLR_009";
		labReportData.fetchClinicalListTestData();
		searchLabReport(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "To search a patient with two same lab reports with either of the two set of search fields")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithLabReportsCombination(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib labReportData = new ClinicalListLib();
		labReportData.workSheetName = "SearchLabReport";
		labReportData.testCaseId = "TC_SLR_010";
		labReportData.fetchClinicalListTestData();
		searchLabReportCombination(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "To search a patient with either of the two lab reports")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithMultipleLabReports(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib labReportData = new ClinicalListLib();
		labReportData.workSheetName = "SearchLabReport";
		labReportData.testCaseId = "TC_SLR_011";
		labReportData.fetchClinicalListTestData();
		searchLabReportCombination(seleniumHost, seleniumPort, browser, webSite, userAccount, labReportData);
	}
	/**
	 * searchLabReport
	 * function to search patient with Lab Report for Match One or More
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 27, 2012
	 */
	
	public boolean searchLabReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib labReportData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		int possition =1;
		
		//String date=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labReportData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labReportData.userName, labReportData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,btnErrorClose))
				assertTrue(click(selenium,btnErrorClose),"Could not click the error close button", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			//searchPatientNexiaForProviderHomePage(selenium,labReportData.patientId);
			//waitForPageLoad(selenium);	
		
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Clinical Lists								//
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNewCriteria1),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",labReportData.searchField);
			
			selenium.type(ajxLabResult,labReportData.test);
			//selenium.typeKeys(textboxName,valueForSelection);
			selenium.fireEvent(ajxLabResult,"keydown");
			selenium.fireEvent(ajxLabResult,"keypress");                           
			selenium.fireEvent(ajxLabResult,"keyup");
			waitForPageLoad(selenium);
			selenium.keyPress(ajxLabResult, "\\13");
			waitForPageLoad(selenium);
			selenium.clickAt(ajxLabResult, "");
			waitForPageLoad(selenium);
			selenium.keyPress(ajxLabResult, "\\13");
			selenium.clickAt(ajxLabResult, "");
			click(selenium,currentItem); 
			selenium.clickAt(ajxLabResult,"");
			click(selenium,currentItem); 
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",labReportData.duration);
			waitForPageLoad(selenium);
			
			System.out.println("Current Possition Value Before Type ::"+ possition +  "          Test Method Name::"+ MethodName);
			System.out.println();
			
			if((labReportData.testCaseId.equals("TC_SLR_001"))||(labReportData.testCaseId.equals("TC_SLR_002"))||(labReportData.testCaseId.equals("TC_SLR_003"))){
				assertTrue(type(selenium,txtLabResult1,labReportData.result),"Could not type the minimum value", selenium, ClassName, MethodName);
			}
			else if((labReportData.testCaseId.equals("TC_SLR_004"))||(labReportData.testCaseId.equals("TC_SLR_005"))||(labReportData.testCaseId.equals("TC_SLR_006"))){
				assertTrue(type(selenium,txtLabResult5,labReportData.result1),"Could not type the maximum value", selenium, ClassName, MethodName);
			}else if((labReportData.testCaseId.equals("TC_SLR_007"))||(labReportData.testCaseId.equals("TC_SLR_008"))||(labReportData.testCaseId.equals("TC_SLR_009"))){
				assertTrue(type(selenium,txtLabResult2,labReportData.result1),"Could not type the minimum value", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLabResult1,labReportData.result),"Could not type the maximum value", selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,ajxtimeCondtion,labReportData.timeCondition);
			if((labReportData.testCaseId.equals("TC_SLR_002"))||(labReportData.testCaseId.equals("TC_SLR_005"))||(labReportData.testCaseId.equals("TC_SLR_008"))){
				assertTrue(type(selenium,txtPeriodNumber1,labReportData.periodNumber),"Could not type the period Number", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxPeriodCondition,labReportData.period);
			}
			else if((labReportData.testCaseId.equals("TC_SLR_003"))||(labReportData.testCaseId.equals("TC_SLR_006"))||(labReportData.testCaseId.equals("TC_SLR_009"))){
				assertTrue(type(selenium,txtLabDate,labReportData.date),"Could not click the clinical list button", selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSearchClinicalList1),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String st=getText(selenium,lblSearchResultLabel);
			String[] st1=st.split(" ");
			int count=Integer.parseInt(st1[0]);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnCancelId),"Could not click the confirmation!!", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Lab Reports						//
			//--------------------------------------------------------------------//
			HomeLib patientData = new HomeLib(); 
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_005";
			patientData.fetchHomeTestData();
			
			assertTrue(goToRegisterPatient(selenium), "Could not go to register patient", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,lnkContinue)){
				selenium.click(lnkContinue);
			}
			assertTrue(createNewPatientWithMandatory(selenium, patientData, labReportData,userAccount), "Could not create a new patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOptionsLink),"Could not click the Patient Options", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkLabReportLink),"Could not find the patient oprtions link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkLabReportLink),"Could not click the patient options link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			try{
				
                selenium.clickAt(lnkLabEnterData, "Could not click the link");
			}catch(Exception e){
                selenium.clickAt(lnkLabEnterData, "Could not click the link");
			}
			
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtaccNumber,labReportData.accessionNumber),"Could not type accession number", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxLabProvider,labReportData.provider);
			selectValueFromAjaxList(selenium,ajxLabProvider1,labReportData.provider1);
			if(userAccount.equalsIgnoreCase(CAAccount)){
				selectValueFromAjaxList(selenium,ajxLabSuggestBox,labReportData.labCA);
			}
			else{
				selectValueFromAjaxList(selenium,ajxLabSuggestBox,labReportData.lab);
			}
			//assertTrue(enterDate(selenium,txtCdate,labReportData.date),"Could not click the clinical list button");
			selenium.type(ajxLabTest,labReportData.test);
			//selenium.typeKeys(textboxName,valueForSelection);
			selenium.fireEvent(ajxLabTest,"keydown");
			selenium.fireEvent(ajxLabTest,"keypress");                           
			selenium.fireEvent(ajxLabTest,"keyup");
			waitForPageLoad(selenium);
			selenium.keyPress(ajxLabTest, "\\13");
			waitForPageLoad(selenium);
			selenium.clickAt(ajxLabTest, "");
			waitForPageLoad(selenium);
			selenium.keyPress(ajxLabTest, "\\13");
			selenium.clickAt(ajxLabTest, "");
			click(selenium,currentItem); 
			selenium.clickAt(ajxLabTest,"");
			click(selenium,currentItem); 
			assertTrue(enterDate(selenium,txtLabdate,"01/01/2000"),"Could not type the time", selenium, ClassName, MethodName);
		
			assertTrue(type(selenium,txtCTime,labReportData.time),"Could not type the time", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtResult,labReportData.labResult),"Could not type the result", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnsave),"Could not click the save button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//link=Enter data >
			//assertTrue(click(selenium,"//div[2]/div/div/div[3]/a"),"Could not click the link");
			/*waitForPageLoad(selenium);
			assertTrue(type(selenium,txtaccNumber,labReportData.accessionNumber),"Could not type accession number");
			selectValueFromAjaxList(selenium,ajxLabProvider,labReportData.provider);
			selectValueFromAjaxList(selenium,ajxLabProvider1,labReportData.provider1);
			selectValueFromAjaxList(selenium,ajxLabSuggestBox,labReportData.lab);
			assertTrue(enterDate(selenium,txtaccNumber,labReportData.date),"Could not click the clinical list button");
			selectValueFromAjaxList(selenium,ajxLabProvider,labReportData.test);
			assertTrue(type(selenium,txtaccNumber,labReportData.time),"Could not type the time");
			assertTrue(type(selenium,txtLabResult3,labReportData.labResult),"Could not type the result");
			assertTrue(click(selenium,btnsave),"Could not click the save button ");*/
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNewCriteria1),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			possition= possition + 1;
			
			System.out.println("Current Possition Value Before Type Next Time ::"+ possition +  "          Test Method Name::"+ MethodName);
			
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",labReportData.searchField);
			selenium.type(ajxLabResult,labReportData.test);
			//selenium.typeKeys(textboxName,valueForSelection);
			selenium.fireEvent(ajxLabResult,"keydown");
			selenium.fireEvent(ajxLabResult,"keypress");                           
			selenium.fireEvent(ajxLabResult,"keyup");
			waitForPageLoad(selenium);
			selenium.keyPress(ajxLabResult, "\\13");
			waitForPageLoad(selenium);
			selenium.clickAt(ajxLabResult, "");
			waitForPageLoad(selenium);
			selenium.keyPress(ajxLabResult, "\\13");
			selenium.clickAt(ajxLabResult, "");
			click(selenium,currentItem); 
			selenium.clickAt(ajxLabResult,"");
			click(selenium,currentItem); 
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",labReportData.duration);
			
			if((labReportData.testCaseId.equals("TC_SLR_001"))||(labReportData.testCaseId.equals("TC_SLR_002"))||(labReportData.testCaseId.equals("TC_SLR_003")))
			{
				assertTrue(type(selenium,txtLabResult1,labReportData.result),"Could not type the minimum value", selenium, ClassName, MethodName);
			}
			else if((labReportData.testCaseId.equals("TC_SLR_004"))||(labReportData.testCaseId.equals("TC_SLR_005"))||(labReportData.testCaseId.equals("TC_SLR_006")))
			{
				assertTrue(type(selenium,txtLabResult2,labReportData.result1),"Could not type the maximum value", selenium, ClassName, MethodName);
			}else if((labReportData.testCaseId.equals("TC_SLR_007"))||(labReportData.testCaseId.equals("TC_SLR_008"))||(labReportData.testCaseId.equals("TC_SLR_009")))
			{
				assertTrue(type(selenium,txtLabResult2,labReportData.result1),"Could not type the minimum value", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLabResult1,labReportData.result),"Could not type the maximum value", selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,ajxtimeCondtion,labReportData.timeCondition);
			if((labReportData.testCaseId.equals("TC_SLR_002"))||(labReportData.testCaseId.equals("TC_SLR_005"))||(labReportData.testCaseId.equals("TC_SLR_008")))
			{
				assertTrue(type(selenium,txtPeriodNumber1,labReportData.periodNumber),"Could not type the period Number", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxPeriodCondition,labReportData.period);
			}
			else if((labReportData.testCaseId.equals("TC_SLR_003"))||(labReportData.testCaseId.equals("TC_SLR_006"))||(labReportData.testCaseId.equals("TC_SLR_009"))){
				assertTrue(type(selenium,txtLabDate,labReportData.date),"Could not click the clinical list button", selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSearchClinicalList1),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			String str=getText(selenium,lblSearchResultLabel);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String[] str1=str.split("\\s+");
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
	/**
	 * searchLabReportCombination
	 * function to search patient with Lab Report with two search fields in Match One Or More
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws     IOException 
	 * @since  	    Nov 27, 2012
	 */
	
	public boolean searchLabReportCombination(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib labReportData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		int possition =1;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labReportData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labReportData.userName, labReportData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,btnErrorClose))
				assertTrue(click(selenium,btnErrorClose),"Could not click the error close button", selenium, ClassName, MethodName);
						
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Clinical Lists								//
			//--------------------------------------------------------------------//			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddNewCriteria1),"Could not click the add new  button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddNewCriteria1),"Could not click the  add new button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",labReportData.searchField);
			
			selenium.type(ajxLabResult,labReportData.test);
			//selenium.typeKeys(textboxName,valueForSelection);
			selenium.fireEvent(ajxLabResult,"keydown");
			selenium.fireEvent(ajxLabResult,"keypress");                           
			selenium.fireEvent(ajxLabResult,"keyup");
			waitForPageLoad(selenium);
			selenium.keyPress(ajxLabResult, "\\13");
			waitForPageLoad(selenium);
			selenium.clickAt(ajxLabResult, "");
			waitForPageLoad(selenium);
			selenium.keyPress(ajxLabResult, "\\13");
			selenium.clickAt(ajxLabResult, "");
			click(selenium,currentItem); 
			selenium.clickAt(ajxLabResult,"");
			click(selenium,currentItem); 
			
			if(labReportData.testCaseId.equals("TC_SLR_010")){
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",labReportData.duration);
				possition = possition+1; 
				//System.out.println("Current Possition Value Increment in First time ::"+ possition +  "          Test Method Name::"+ MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",labReportData.searchField);
				
				selenium.type(ajxLabResultName,labReportData.test);
				//selenium.typeKeys(textboxName,valueForSelection);
				selenium.fireEvent(ajxLabResultName,"keydown");
				selenium.fireEvent(ajxLabResultName,"keypress");                           
				selenium.fireEvent(ajxLabResultName,"keyup");
				waitForPageLoad(selenium);
				selenium.keyPress(ajxLabResultName, "\\13");
				waitForPageLoad(selenium);
				selenium.clickAt(ajxLabResultName, "");
				waitForPageLoad(selenium);
				selenium.keyPress(ajxLabResultName, "\\13");
				selenium.clickAt(ajxLabResultName, "");
				click(selenium,currentItem); 
				selenium.clickAt(ajxLabResultName,"");
				click(selenium,currentItem); 
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",labReportData.duration1);
				assertTrue(type(selenium,txtLabResult1,labReportData.result),"", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLabResultForMoreThan,labReportData.result1),"", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,labReportData.timeCondition);
				selectValueFromAjaxList(selenium,ajxTimeCondiiton,labReportData.timeCondition1);
				selectValueFromAjaxList(selenium,ajxPeriodNumber,labReportData.periodNumber);
				selectValueFromAjaxList(selenium,ajxPeriodCondtion,labReportData.period);
			}
			else if(labReportData.testCaseId.equals("TC_SLR_011")){
			
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",labReportData.duration);
				possition= possition+1;
				//System.out.println("Current Possition Value Increment in First time ::"+ possition +  "          Test Method Name::"+ MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",labReportData.searchField);
				
				selenium.type(ajxLabResultName,labReportData.test);
				//selenium.typeKeys(textboxName,valueForSelection);
				selenium.fireEvent(ajxLabResultName,"keydown");
				selenium.fireEvent(ajxLabResultName,"keypress");                           
				selenium.fireEvent(ajxLabResultName,"keyup");
				waitForPageLoad(selenium);
				selenium.keyPress(ajxLabResultName, "\\13");
				waitForPageLoad(selenium);
				selenium.clickAt(ajxLabResultName, "");
				waitForPageLoad(selenium);
				selenium.keyPress(ajxLabResultName, "\\13");
				selenium.clickAt(ajxLabResultName, "");
				click(selenium,currentItem); 
				selenium.clickAt(ajxLabResultName,"");
				click(selenium,currentItem); 
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",labReportData.duration1);
				selectValueFromAjaxList(selenium,txtLabResult1,labReportData.result);
				selectValueFromAjaxList(selenium,txtLabResultForMoreThan,labReportData.result1);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,labReportData.timeCondition);
				selectValueFromAjaxList(selenium,ajxTimeCondiiton,labReportData.timeCondition);
			}
			assertTrue(click(selenium,btnSearchClinicalList1),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String st=getText(selenium,lblSearchResultLabel);
			String[] st1=st.split(" ");
			System.out.println(st1[0]);
			int count=Integer.parseInt(st1[0]);
			
			assertTrue(click(selenium,btnCancelId),"Could not click the confirmation!!", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Create a patient//
			//--------------------------------------------------------------------//
			
			HomeLib patientData = new HomeLib(); 
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_005";
			
			patientData.fetchHomeTestData();
			
			assertTrue(goToRegisterPatient(selenium), "Could not go to register patient", selenium, ClassName, MethodName);
			assertTrue(createNewPatientWithMandatory(selenium, patientData, labReportData,userAccount), "Could not create a new patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Lab Reports						//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOptionsLink),"Could not click the Patient Options", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkLabReportLink),"Could not find the patient oprtions link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkLabReportLink),"Could not click the patient options link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			try{
				waitForPageLoad(selenium);
				selenium.clickAt(lnkLabEnterData, "");
				waitForPageLoad(selenium);
			}catch(Exception e){
				waitForPageLoad(selenium);
				selenium.clickAt(lnkLabEnterData, "");
				waitForPageLoad(selenium);
			}
			//assertTrue(click(selenium,lnkLabEnterData),"Could not click the link");
			assertTrue(type(selenium,txtaccNumber,labReportData.accessionNumber),"Could not type accession number", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxLabProvider,labReportData.provider);
			selectValueFromAjaxList(selenium,ajxLabProvider1,labReportData.provider1);
			if(userAccount.equalsIgnoreCase(CAAccount)){
				selectValueFromAjaxList(selenium,ajxLabSuggestBox,labReportData.labCA);
			}
			else{
				selectValueFromAjaxList(selenium,ajxLabSuggestBox,labReportData.lab);
			}
			
			assertTrue(enterDate(selenium,txtLabdate,labReportData.date),"Could not click the clinical list button", selenium, ClassName, MethodName);
			
			selenium.type(ajxLabTest,labReportData.test);
			//selenium.typeKeys(textboxName,valueForSelection);
			selenium.fireEvent(ajxLabTest,"keydown");
			selenium.fireEvent(ajxLabTest,"keypress");                           
			selenium.fireEvent(ajxLabTest,"keyup");
			waitForPageLoad(selenium);
			selenium.keyPress(ajxLabTest, "\\13");
			waitForPageLoad(selenium);
			selenium.clickAt(ajxLabTest, "");
			waitForPageLoad(selenium);
			selenium.keyPress(ajxLabTest, "\\13");
			selenium.clickAt(ajxLabTest, "");
			click(selenium,currentItem); 
			selenium.clickAt(ajxLabTest,"");
			click(selenium,currentItem); 
			assertTrue(type(selenium,txtCTime,labReportData.time),"Could not type the time", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLabResult,labReportData.labResult),"Could not type the result", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnsave),"Could not click the save button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Clinical Lists								//
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddNewCriteria1),"Could not click the clinical list button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddNewCriteria1),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			possition = possition + 1;
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",labReportData.searchField);
			
			
			selenium.type(ajxLabResult,labReportData.test);
			//selenium.typeKeys(textboxName,valueForSelection);
			selenium.fireEvent(ajxLabResult,"keydown");
			selenium.fireEvent(ajxLabResult,"keypress");                           
			selenium.fireEvent(ajxLabResult,"keyup");
			waitForPageLoad(selenium);
			selenium.keyPress(ajxLabResult, "\\13");
			waitForPageLoad(selenium);
			selenium.clickAt(ajxLabResult, "");
			waitForPageLoad(selenium);
			selenium.keyPress(ajxLabResult, "\\13");
			selenium.clickAt(ajxLabResult, "");
			click(selenium,currentItem); 
			selenium.clickAt(ajxLabResult,"");
			click(selenium,currentItem); 
			//--------------------------------------------------------------------//
			//  Step-7: Search for a patient							//
			//--------------------------------------------------------------------//	
			if(labReportData.testCaseId.equals("TC_SLR_010")){
				
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",labReportData.duration);
				possition = possition + 1;
				System.out.println("Current Possition Value Increment in second time ::"+ possition +  "          Test Method Name::"+ MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",labReportData.searchField);
				
				selenium.type(ajxLabResultName,labReportData.test);
				//selenium.typeKeys(textboxName,valueForSelection);
				selenium.fireEvent(ajxLabResultName,"keydown");
				selenium.fireEvent(ajxLabResultName,"keypress");                           
				selenium.fireEvent(ajxLabResultName,"keyup");
				waitForPageLoad(selenium);
				selenium.keyPress(ajxLabResultName, "\\13");
				waitForPageLoad(selenium);
				selenium.clickAt(ajxLabResultName, "");
				waitForPageLoad(selenium);
				selenium.keyPress(ajxLabResultName, "\\13");
				selenium.clickAt(ajxLabResultName, "");
				click(selenium,currentItem); 
				selenium.clickAt(ajxLabResultName,"");
				click(selenium,currentItem); 
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",labReportData.duration1);
				assertTrue(type(selenium,txtLabResult1,labReportData.result),"", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLabResultForMoreThan,labReportData.result1),"", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,labReportData.timeCondition);
				selectValueFromAjaxList(selenium,ajxTimeCondiiton,labReportData.timeCondition1);
				selectValueFromAjaxList(selenium,ajxPeriodNumber,labReportData.periodNumber);
				selectValueFromAjaxList(selenium,ajxPeriodCondtion,labReportData.period);
			}
			else if(labReportData.testCaseId.equals("TC_SLR_011")){
				
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",labReportData.duration);
				possition = possition + 1;
				System.out.println("Current Possition Value Increment in second time ::"+ possition +  "          Test Method Name::"+ MethodName);
				
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",labReportData.searchField);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",labReportData.duration1);
				
				selenium.type(ajxLabResultName,labReportData.test1);
				//selenium.typeKeys(textboxName,valueForSelection);
				selenium.fireEvent(ajxLabResultName,"keydown");
				selenium.fireEvent(ajxLabResultName,"keypress");                           
				selenium.fireEvent(ajxLabResultName,"keyup");
				waitForPageLoad(selenium);
				selenium.keyPress(ajxLabResultName, "\\13");
				waitForPageLoad(selenium);
				selenium.clickAt(ajxLabResultName, "");
				waitForPageLoad(selenium);
				selenium.keyPress(ajxLabResultName, "\\13");
				selenium.clickAt(ajxLabResultName, "");
				click(selenium,currentItem); 
				selenium.clickAt(ajxLabResultName,"");
				click(selenium,currentItem); 
				
				selectValueFromAjaxList(selenium,txtLabResult1,labReportData.result);
				selectValueFromAjaxList(selenium,txtLabResultForMoreThan,labReportData.result1);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,labReportData.timeCondition);
				selectValueFromAjaxList(selenium,ajxTimeCondiiton,labReportData.timeCondition);
			}
			assertTrue(click(selenium,btnSearchClinicalList1),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String str=getText(selenium,lblSearchResultLabel);
			String[] str1=str.split("\\s+");
			System.out.println(str1[0]);
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
