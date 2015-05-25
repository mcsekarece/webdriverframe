package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectDrugClassFromSearchResults extends AbstractChartPreVisit {	

	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify clicking the drug class name for a selected medication retrives search with matching criteria")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDrugClassSelection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_118";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDrugClassSelectionFromSearchResult(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}

	/*************************************************************************************************** 
	 * @purpose        To verify drug search action in Prescribe Medication Screen returns result with Medication Name, Primary Ingredient and Drug Class 
	 * @Specification  SRS_EMR_MEDS_Search Medication_Rev0.2
	 * @action 		   Search for a drug in Prescribe Medication Screen
	 * @expected       Search results should get displayed in order - Medication name (Trade), Primary Ingredient (Generic name), Drug Class
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       May 12, 2014
	 ***************************************************************************************************/

	public boolean verifyDrugClassSelectionFromSearchResult(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		int resultCount=1;
		String selectedDrugClassName;
		String resultDrugClassXpath;
		String resultDrugClassName;

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
				assertTrue(click(selenium, btnErrorClose),"Could not click close button",selenium,ClassName,MethodName);
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
			
			//Get count of all results retrieved	
			/*while(isElementPresent(selenium,lnkDrugClassResultXpath+resultCount+"]"))
			{
				resultCount++;
			}*/			
			 resultCount=(Integer) selenium.getXpathCount(lnkmedicationsearchresult);
						
			//Stop proceeding further if no results are retrieved
			if(resultCount == 0) {
				fail("No medication search results found.");
			}

			//--------------------------------------------------------------------//
			//  Step-5: Click first drug class name if record count is greater than one //
			//--------------------------------------------------------------------//	
			resultDrugClassXpath =lnkmedicationsearchresult+"[" + "1" + "]";			
			//Save drug class name for the first result
			selectedDrugClassName = getText(selenium, resultDrugClassXpath);
			assertTrue(click(selenium, resultDrugClassXpath), "Could not click first Drug class name",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify that system displays the selected drug class in the search field
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			String searchFieldString = getValue(selenium, ajxDrugsList);
			assertTrue(getText(selenium,lnkmedicationsearchresult).contains(prescribeData.prescribeCa.toUpperCase()), "Selected drug class name is not same as text in the search field. Expected: " +selectedDrugClassName+ " Actual: "+ searchFieldString ,selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			//  Step-7: Verify that all new search results contains selected Drug Class name in Drug Class portion
			//--------------------------------------------------------------------//
			//resultCount = getCountOfElementsWithSimilarXpath(selenium, lblMedSearchResultXpath1,lblMedSearchResultXpath2);			

			//Stop proceeding further if no results are retrieved
			if(resultCount == 0) {
				fail("No medication search results found.");
			}
			//Extract information from every result
			for (int i = 1; i <= resultCount; i++) {
				resultDrugClassXpath = lnkmedicationsearchresult+"[" + i + "]";		
				resultDrugClassName = getText(selenium, resultDrugClassXpath);
				click(selenium,resultDrugClassXpath);
			    assertTrue(getText(selenium,lnkDrug).contains(prescribeData.prescribeCa.toUpperCase()), "Drug Class name not matched with selected drug class name. Expected: " +searchFieldString+ " Actual: "+selectedDrugClassName,selenium,ClassName,MethodName);											
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

			

}



