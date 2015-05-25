package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import java.util.HashSet;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUniqueDrugSearchResults extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify drug search operation should not return multiple records with the same drug name, generic name and drug class")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUniqueMedSearchResults(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_116";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyMultipleSearchResultsAreUnique(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}

	/*************************************************************************************************** 
	 * @purpose        To verify drug search operation should not return multiple records with the same drug name, generic name and drug class
	 * @Specification  SRS_EMR_MEDS_Search Medication_Rev0.2
	 * @action 		   Search for a drug in Prescribe Medication Screen
	 * @expected       Multiple search results should be unique
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       May 12, 2014
	 ***************************************************************************************************/

	public boolean verifyMultipleSearchResultsAreUnique(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		int resultCount;
		HashSet <String> medSearchResultSet = new HashSet <String>();

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);

			if(isElementPresent(selenium, btnErrorClose)) {
				assertTrue(click(selenium, btnErrorClose),"Could not click close buttons",selenium,ClassName,MethodName);
			}	

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not Navigate to prescribe medication page",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(searchPrescribeMedication(selenium,prescribeData,userAccount),"Could not search for prescribed medicine", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-5: Extract Medication Name, Ingredient Name and Drug class and check if these are unique //
			//--------------------------------------------------------------------//
			//Get count of all results retrieved		
			resultCount = getCountOfElementsWithSimilarXpath(selenium, lblMedSearchResultXpath1,lblMedSearchResultXpath2);
			//System.out.println("Total count of results is: " +resultCount);	

			//Retrieving Medication Name, Ingredient Name and Drug class
			for (int i = 1; i <= resultCount; i++) {
				String resultDrugTradeNameXpath = lnkMedNameResultXpath1 + i + lnkMedNameResultXpath2;
				String resultDrugGenericNameXpath = lnkPrimaryIngredientResultXpath1 + i + lnkPrimaryIngredientResultXpath2;
				String resultDrugClassXpath = lnkDrugClassResultXpath1 + i + lnkDrugClassResultXpath2;

				String resultDrugTradeName = getText(selenium, resultDrugTradeNameXpath);
				String resultDrugGenericName = getText(selenium, resultDrugGenericNameXpath);
				String resultDrugClass = getText(selenium, resultDrugClassXpath);

				//Save entire line of a search result in a single string so that the final string could be added to a Set
				String resultEntireLine = resultDrugTradeName + resultDrugGenericName + resultDrugClass; 

				//Verify that results retrieved are unique
				if(!medSearchResultSet.contains(resultEntireLine)){ 
					//If the Set doesn't contain result line add the line to the Set  
					medSearchResultSet.add(resultEntireLine);
				}		
				else { 
					//if Set contains the line it implies that multiple result are not unique hence fail the test					
					fail("Multiple search records were displayed with same drug name, generic name and drug class");					
				}	

			}
			//System.out.println("Size of resultset is: " +medSearchResultSet.size());			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}


}

