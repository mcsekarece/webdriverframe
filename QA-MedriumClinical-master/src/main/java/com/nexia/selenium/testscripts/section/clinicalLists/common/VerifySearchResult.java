package com.nexia.selenium.testscripts.section.clinicalLists.common;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchResult extends AbstractClinicalList{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Age criteria")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchResult(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib ageData = new ClinicalListLib();
		ageData.workSheetName = "verifySearchWithAllCombination";
		ageData.testCaseId = "TC_VSA_004";
		ageData.fetchClinicalListTestData();
		verifySearchResultDetails(seleniumHost, seleniumPort, browser, webSite, userAccount, ageData);
	}
	/**
	 * verifySearchResultDetails
	 * function for  verify Search Result Details
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 21, 2012
	 */
	
	public boolean verifySearchResultDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib ageData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		int possition =1;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ageData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, ageData.userName, ageData.userPassword),"Login Failde", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Navigate to Register patient //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkQuickActions),"Could not click the quick action link,More Details:"+ageData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnknewPatientAction),"Could not click the register patient link,More Details:"+ageData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lnkContinue)){
				selenium.click(lnkContinue);
			}
			
			ageData.workSheetName = "NewpatientInfo";
			ageData.testCaseId = "TC_PI_001";
			ageData.fetchClinicalListTestData();
			//--------------------------------------------------------------------//
			//  Step-3:Patient creation //
			//--------------------------------------------------------------------//
			assertTrue(createNewPatient(selenium,ageData,userAccount),"Patient creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			assertTrue(click(selenium,btnNexiaLogo),"Click Nexia Logo failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Click Failed", selenium, ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4:Navigate to Clinical List //
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
			/*try{
				selenium.clickAt(btnNewSearch, "");
				selenium.focus(btnNewSearch);
				selenium.fireEvent(btnNewSearch, "keypress");
				
			}
			catch(Exception e){
				waitForPageLoad(selenium);
				selenium.clickAt(btnNewSearch, "");
				//selenium.focus(btnNewSearch);
				//selenium.fireEvent(btnNewSearch, "keypress");
			}*/
			
			assertTrue(click(selenium, btnNewSearch), "Could not click on New Search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Fill the criteria and get the search result				  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddNewCriteria),"Could not click the add new button,More Details:"+ageData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",ageData.searchType1);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"anddurationConditionSuggestBoxsuggestBoxsuggestBox",ageData.durationCondition1);
			assertTrue(type(selenium,String.valueOf(possition)+"anddurationIntegerMin",ageData.year1),"Could not enter the year", selenium, ClassName, MethodName);
			assertTrue(type(selenium,String.valueOf(possition)+"anddurationIntegerMax",ageData.year2),"Could not enter the year", selenium, ClassName, MethodName);
			possition = possition +1;
			assertTrue(click(selenium,btnAddNewCriteria1),"Could not click the add new button,More Details:"+ageData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",ageData.searchType2);
			selectValueFromAjaxList(selenium,ajxSex1CondtionForMatchAll,ageData.sex);
			assertTrue(click(selenium,btnSaveButton),"Could not click the search button", selenium, ClassName, MethodName);
			
			selectValueFromAjaxList(selenium,ajxFirstSorSuggestBox,ageData.firstSortBy);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Fill the criteria and get the search result				  //
			//--------------------------------------------------------------------//
			assertTrue(verifySearchValue(selenium,ageData),"Verify failed", selenium, ClassName, MethodName);
		/*	if(!verifySearchValue(selenium,ageData)){
				return false;
			}else
				return true;*/
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySearchValue(Selenium selenium,ClinicalListLib ageData) throws IOException{
		assertTrue(isElementPresent(selenium,lblSortResult),"The Element present is present", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblCollapsableTitle).contains(ageData.lastName),"last name not present", selenium, ClassName, MethodName);
			
		assertTrue(getText(selenium,lblCollapsableTitle).contains(ageData.firstName),"first name not present", selenium, ClassName, MethodName);
			
//		assertTrue(getText(selenium,lblCollapsableTitle).contains(ageData.sex),"sex not present", selenium, ClassName, MethodName);
//			
//		assertTrue(getText(selenium,lblCollapsableTitle).contains(ageData.dob),"dob not present", selenium, ClassName, MethodName);
//			
//		assertTrue(getText(selenium,lblCollapsableTitle).contains(ageData.telephoneNo1),"Tele phone not present", selenium, ClassName, MethodName);
//			
		return true;
	}
	
}
