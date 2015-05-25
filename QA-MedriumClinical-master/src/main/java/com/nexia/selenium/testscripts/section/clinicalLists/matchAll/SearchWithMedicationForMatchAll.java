
package com.nexia.selenium.testscripts.section.clinicalLists.matchAll;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class SearchWithMedicationForMatchAll extends AbstractClinicalList{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient with medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching a patient with after date Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithDeletedMedications(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib clinicalMedicationData = new ClinicalListLib();
		clinicalMedicationData.workSheetName = "searchMedication";
		clinicalMedicationData.testCaseId = "TC_SM_009";
		clinicalMedicationData.fetchClinicalListTestData();
		searchMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, clinicalMedicationData);
	}
	/**
	 * searchMedication
	 * function to search patient with Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 21, 2012
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
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,clinicalMedicationData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Medication //
			//--------------------------------------------------------------------//
		//	assertTrue(click(selenium, lnkMore),"Could not click on More  link", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,btnMedicationSummary),"Could not find the link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkToMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(deleteMedication(selenium,clinicalMedicationData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//btnsave
			assertTrue(click(selenium,saveMedbtn),"Could not click the save button;More Details:"+clinicalMedicationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",clinicalMedicationData.searchField);
			if(userAccount.equals(CAAccount)){
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeNameCa);
			}else
			selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeName);
			selectValueFromAjaxList(selenium,ajxtimeCondtion,clinicalMedicationData.timeCondition);
			waitForPageLoad(selenium);
			if(clinicalMedicationData.testCaseId.equals("TC_SM_002")){
				assertTrue(type(selenium,txtPeriodNumber1,clinicalMedicationData.periodNumber),"Could not type the period Number", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxPeriodCondition,clinicalMedicationData.period);
			}
			else if(clinicalMedicationData.testCaseId.equals("TC_SM_003")){
				assertTrue(type(selenium,txtLabDate,clinicalMedicationData.date),"Could not click the clinical list button", selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSearchClinicalList1),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String st=getText(selenium,lblSearchResultLabel);
			String[] st1=st.split(" results found for:");
			System.out.println(st1[0]);
			int count=Integer.parseInt(st1[0]);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnCancelId),"Could not click the cancel button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Create Medication//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button", selenium, ClassName, MethodName);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			
			searchPatientNexiaForProviderHomePage(selenium,clinicalMedicationData.patientId);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkToMedication),"Could not find the link", selenium, ClassName, MethodName);
			
			/*try{
				selenium.focus(lnkToMedication);
				selenium.clickAt(lnkToMedication, "");
			}catch(Exception e){
				selenium.focus(lnkToMedication);
				selenium.clickAt(lnkToMedication, "");
			}*/
			assertTrue(click(selenium,lnkToMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createMedication(selenium,clinicalMedicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEdit)){
				returnValue=true;
			}else
				returnValue=false;
			assertTrue(click(selenium,saveMedbtn),"Could not click the save button;More Details:"+clinicalMedicationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			possition = possition + 1;
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",clinicalMedicationData.searchField);
			
			if(userAccount.equals(CAAccount)){
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeNameCa);
			}else
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeName);
			selectValueFromAjaxList(selenium,ajxtimeCondtion,clinicalMedicationData.timeCondition);
			if(userAccount.equals(CAAccount)){
			if(clinicalMedicationData.testCaseId.equals("TC_SM_002")){
				assertTrue(type(selenium,txtPeriodNumber1,clinicalMedicationData.periodNumber),"Could not type the period Number", selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeNameCa);
					selectValueFromAjaxList(selenium,ajxPeriodCondition,clinicalMedicationData.period);
				}
			}else{
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeName);
					selectValueFromAjaxList(selenium,ajxPeriodCondition,clinicalMedicationData.period);
				}
			 if(clinicalMedicationData.testCaseId.equals("TC_SM_003")){
				assertTrue(enterDate(selenium,txtLabDate,clinicalMedicationData.date),"Could not click the clinical list button", selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSearchClinicalList1),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String str=getText(selenium,lblSearchResultLabel);
			String[] str1=str.split(" results found for:");
			System.out.println(str1);
			System.out.println(str1[0]);
			int count1=Integer.parseInt(str1[0]);
			
			if(count1>count)
				returnValue=true;
			else
				returnValue=false;
			
			assertTrue(click(selenium,btnCancelId),"Could not click the cancel button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(clinicalMedicationData.testCaseId.equals("TC_SM_009")){
				assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button", selenium, ClassName, MethodName);
				searchPatientNexiaForProviderHomePage(selenium,clinicalMedicationData.patientId);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,lnkToMedication),"Could not find the link", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lnkToMedication),"Could not click the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteMedication(selenium,clinicalMedicationData),"Deletion Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
				possition = possition + 1;
				assertTrue(click(selenium,lnkNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",clinicalMedicationData.searchField);
				if(userAccount.equals(CAAccount)){
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeNameCa);
				}else
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeName);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,clinicalMedicationData.timeCondition);
				if(clinicalMedicationData.testCaseId.equals("TC_SM_002")){
					assertTrue(type(selenium,txtPeriodNumber1,clinicalMedicationData.periodNumber),"Could not type the period Number", selenium, ClassName, MethodName);
					if(userAccount.equals(CAAccount)){
						selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeNameCa);
					}else
						selectValueFromAjaxList(selenium,ajxPeriodCondition,clinicalMedicationData.prescribeName);
					selectValueFromAjaxList(selenium,ajxPeriodCondition,clinicalMedicationData.period);
				}
				else if(clinicalMedicationData.testCaseId.equals("TC_SM_003")){
					assertTrue(enterDate(selenium,txtLabDate,clinicalMedicationData.date),"Could not click the clinical list button", selenium, ClassName, MethodName);
				}
				assertTrue(click(selenium,btnSearchClinicalList1),"Could not click the search button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				String dstr=getText(selenium,lblSearchResultLabel);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				String[] dstr1=dstr.split(" ");
				System.out.println(dstr1[0]);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				int dcount1=Integer.parseInt(dstr1[0]);
				if(count>=dcount1)
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
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchMedicationWithOptionsForMatchAll(selenium,clinicalMedicationData,userAccount,possition),"Search not proper", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String st=getText(selenium,lblSearchResultLabel);
			String[] st1=st.split(" ");
			int count=Integer.parseInt(st1[0]);
			//--------------------------------------------------------------------//
			//  Step-4: Create Medication//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnCancelId),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button",selenium, ClassName, MethodName);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			
			searchPatientNexiaForProviderHomePage(selenium,clinicalMedicationData.patientId);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkToMedication),"Could not find the link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkToMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createMedication(selenium,clinicalMedicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEdit)){
				returnValue=true;
			}else
				returnValue=false;
			
			assertTrue(click(selenium, saveMedbtn), "Could not click on save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick actions button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkClinicalLists),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNewSearch),"Could not click the clinical list button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			possition = Integer.parseInt(clinicalMedicationData.currentValue);
			assertTrue(searchMedicationWithOptionsForMatchAll(selenium,clinicalMedicationData,userAccount,possition),"Search not proper", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String str=getText(selenium,lblSearchResultLabel);
			String[] str1=str.split(" ");
			System.out.println(str1);
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

