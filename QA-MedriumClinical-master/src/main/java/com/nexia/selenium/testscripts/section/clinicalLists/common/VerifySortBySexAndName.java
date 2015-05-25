package com.nexia.selenium.testscripts.section.clinicalLists.common;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySortBySexAndName extends AbstractClinicalList{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Sort By Sex And Name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySortBySexMale(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalMedicationData = new ClinicalListLib();
		clinicalMedicationData.workSheetName = "SearchMedication";
		clinicalMedicationData.testCaseId = "TC_SM_010";
		clinicalMedicationData.fetchClinicalListTestData();
		sortMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalMedicationData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Sort By Sex And Name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySortBySexFemale(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalMedicationData = new ClinicalListLib();
		clinicalMedicationData.workSheetName = "SearchMedication";
		clinicalMedicationData.testCaseId = "TC_SM_011";
		clinicalMedicationData.fetchClinicalListTestData();
		sortMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalMedicationData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Sort By Sex And Name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySortByNameAscen(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalMedicationData = new ClinicalListLib();
		clinicalMedicationData.workSheetName = "SearchMedication";
		clinicalMedicationData.testCaseId = "TC_SM_012";
		clinicalMedicationData.fetchClinicalListTestData();
		sortMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalMedicationData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Sort By Sex And Name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySortByNameDesen(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalMedicationData = new ClinicalListLib();
		clinicalMedicationData.workSheetName = "SearchMedication";
		clinicalMedicationData.testCaseId = "TC_SM_013";
		clinicalMedicationData.fetchClinicalListTestData();
		sortMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalMedicationData);
	}
	/**
	 * sortMedication
	 * function to sort Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 17, 2012
	 */
	
	public boolean sortMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib allergyData) throws  IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------//
			//  Step-2: Navigate To Clinical List Section //
			//--------------------------------------------//
			if(allergyData.testCaseId.equals("TC_SM_011")||allergyData.testCaseId.equals("TC_SM_012")||allergyData.testCaseId.equals("TC_SM_010")){
				assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Link", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lnknewPatientAction),"Could not click the Clinical List", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(userAccount.equals(CAAccount)){
					HomeLib PatientData = new HomeLib();
					PatientData.workSheetName = "NewPatientCheckInCAView";
					PatientData.testCaseId = "TC_NPC_001";
					PatientData.fetchHomeTestData();
					assertTrue(createNewPatientWithMandatory(selenium,PatientData,allergyData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
				}else{
				HomeLib PatientData = new HomeLib();
				PatientData.workSheetName = "NewPatientCheckIn";
				PatientData.testCaseId = "TC_NPC_001";
				PatientData.fetchHomeTestData();
				assertTrue(createNewPatientWithMandatory(selenium,PatientData,allergyData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				}
				
				assertTrue(click(selenium,lnkPatientOptionsLink),"could not click the patient link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
				assertTrue(click(selenium,btnPatientChart),"could not click the view patient chart link", selenium, ClassName, MethodName);	
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
			
				try{
					selenium.focus("link=Medication");
					selenium.clickAt("link=Medication", "");
					
				
				}catch(Exception e){
					selenium.focus("link=Medication");
					selenium.clickAt("link=Medication", "");
				}
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-3: Create Medication//
				//--------------------------------------------------------------------//
				assertTrue(createMedication(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,saveMedbtn),"Could not click the save button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			
			
			//--------------------------------------------//
			//  Step-4: Navigate To Clinical List Section //
			//--------------------------------------------//
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkClinicalLists),"Could not click the Clinical List", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//-----------------------------------------------//
			//  Step-5: Click New Search In Clinical Section //
			//-----------------------------------------------//
			
			assertTrue(click(selenium,btnNewSearch),"Could not click the New Search In Clinical Section", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkNewSearch),"Could not click the New Search In Clinical Section", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//-------------------------------//
			//  Step-6: Search By Medication //
			//-------------------------------//
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox","Medication is");

		

			if(userAccount.equals(CAAccount)){
				selectValueFromAjaxList(selenium, ajxMedicationNameSuggestBox, allergyData.prescribeNameCa);
			}else
				selectValueFromAjaxList(selenium, ajxMedicationNameSuggestBox, allergyData.prescribeName);
			
			//assertTrue(click(selenium,ajxMedicationNameOption),"Could not choose the medication name");
			selectValueFromAjaxList(selenium,ajxtimeCondtion,"since always");
			
			//assertTrue(click(selenium, ajxtimeCondtion),"Could not type in select type box", selenium, ClassName, MethodName);
			//assertTrue(click(selenium,"//body/div[3]/div/div/div/div/div"),"Could not choose the medication type", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSearch),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);


			//-------------------------------------//
			//  Step-7: Sort The Medication Result //
			//-------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chkSort),"Could not check the sort by box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//----------------------------------//
			// step-8: Verify The Search Result //
			//----------------------------------//
			if(!verifySortResult(selenium,allergyData)){
				Assert.fail("Sorting Failed; More Details :"+ allergyData.toString());
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + allergyData.toString());
		}
		return returnValue;
		
	}
	private boolean verifySortResult(Selenium selenium,ClinicalListLib allergyData) throws IOException {
		waitForPageLoad(selenium);
		int n=0;
		//For Checking the sort order by sex Male
		if(allergyData.testCaseId.equalsIgnoreCase("TC_SM_010")){
			assertTrue(click(selenium, btnSortCriteria),"Could not type in select type box", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxFirstSorSuggestBox,"Patient Sex (Male, Female");
			
			//assertTrue(click(selenium,ajxMedicationTypeOption),"Could not choose the sort type", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,lblSortResult1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyData.sex.trim().toLowerCase(new java.util.Locale("en","Us")))," ", selenium, ClassName, MethodName);
				
		}
		
		//For Checking the sort order by sex Female
		if(allergyData.testCaseId.equalsIgnoreCase("TC_SM_011")){
			assertTrue(click(selenium, btnSortCriteria),"Could not type in select type box", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxFirstSorSuggestBox,"Patient Sex (Female, Male)");
			//assertTrue(click(selenium,btnSortType),"Could not choose the sort type", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,lblSortResult1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyData.sex.trim().toLowerCase(new java.util.Locale("en","Us")))," ", selenium, ClassName, MethodName);
				
		}
		
		//For Checking the sort order by last name Ascending order
		if(allergyData.testCaseId.equalsIgnoreCase("TC_SM_012")){
			assertTrue(click(selenium, btnSortCriteria),"Could not type in select type box", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxFirstSorSuggestBox,"Patient Last Name (A-Z)");
			//assertTrue(click(selenium,"//div[4]/div/div/div/div/div"),"Could not choose the sort type", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//selectValueFromAjaxList(selenium,btnSortCriteria,"Patient Name (A-Z)");
			waitForPageLoad(selenium);
			String name=getText(selenium,lblSortResult2);
			String name1=getText(selenium,lblSortResult3);
			
			String[] splitS1 = name.split("");
			String[] splitS2 = name.split("");
			
			String lastName=splitS1[1];
			String lastName1=splitS2[1];
			
			n=lastName.compareTo(lastName1);
			
			if(n>0 || n==1){
				Assert.fail ("sorting failed");
			}			
		}
		
		//For Checking the sort order by last name descending order
		if(allergyData.testCaseId.equalsIgnoreCase("TC_SM_013")){
			//selectValueFromAjaxList(selenium,btnSortCriteria,"Patient Name (A-Z)");
			assertTrue(click(selenium, btnSortCriteria),"Could not type in select type box", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxFirstSorSuggestBox,"Patient Last Name (Z-A)");
			//assertTrue(click(selenium,btnSortType1),"Could not choose the sort type", selenium, ClassName, MethodName);
			String name=getText(selenium,lblSortResult2);
			String name1=getText(selenium,lblSortResult3);
			
			String[] splitS1 = name.split("");
			String[] splitS2 = name.split("");
			
			String lastName=splitS1[1];
			String lastName1=splitS2[1];
			
			n=lastName.compareTo(lastName1);
			
			if(n>0 || n==1){
				Assert.fail ("sorting failed");
			}			
				
		}
		return true;
	}
}
