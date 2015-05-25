package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectGenericNameFromSearchResults extends AbstractChartPreVisit {	

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify clicking the generic drug name for a selected medication retrives search with matching criteria")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyGenericNameSelection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_117";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyGenericNameSelectionFromSearchResult(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
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

	public boolean verifyGenericNameSelectionFromSearchResult(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		int resultCount;
		String selectedDrugGenericName;
		String resultDrugGenericNameXpath;
		String resultDrugGenericName;

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
				assertTrue(click(selenium, btnErrorClose),"Could not close button",selenium,ClassName,MethodName);
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
			 resultCount=(Integer) selenium.getXpathCount(lnkmedicationsearchresult);
			
			//Stop proceeding further if no results are retrieved
			if(resultCount == 0) {
				fail("No medication search results found.");
			}

			//--------------------------------------------------------------------//
			//  Step-5: Click first Generic Name if record count is greater than one //
			//--------------------------------------------------------------------//	
			resultDrugGenericNameXpath = lnkmedicationsearchresult+"[" + "1" + "]";	
			//Save Generic drug name for the first result
			selectedDrugGenericName = getText(selenium, resultDrugGenericNameXpath);
			assertTrue(click(selenium, resultDrugGenericNameXpath), "Could not click first Generic Drug name",selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			//  Step-6: Verify that system displays the selected drug generic name in the search field
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			String searchFieldString = getValue(selenium, ajxDrugsList);
			assertTrue(selectedDrugGenericName.equalsIgnoreCase(searchFieldString), "Selected drug generic name is not same as text in the search field. Expected: " +selectedDrugGenericName+ " Actual: "+ searchFieldString,selenium,ClassName,MethodName );

			//--------------------------------------------------------------------//
			//  Step-7: Verify that all new search results contains selected drug generic name in generic drug portion
			//--------------------------------------------------------------------//
			//resultCount = getCountOfElementsWithSimilarXpath(selenium, lblMedSearchResultXpath1,lblMedSearchResultXpath2);			

			//Stop proceeding further if no results are retrieved
			if(resultCount == 0) {
				fail("No medication search results found.");
			}
			//Extract information from every result
			for (int i = 1; i <= resultCount; i++) {
				resultDrugGenericNameXpath = lnkmedicationsearchresult+"[" + i + "]";		
				resultDrugGenericName = getText(selenium, resultDrugGenericNameXpath);
				assertTrue(resultDrugGenericName.equalsIgnoreCase(selectedDrugGenericName), "Drug Generic name (Primary Ingredient) not matched with selected drug class name. Expected: " +searchFieldString+ " Actual: "+selectedDrugGenericName,selenium,ClassName,MethodName);											
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}	

}

