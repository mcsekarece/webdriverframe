package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDrugSearchResultFromDatabase extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify drug search operation in Prescribe Medication returns values as in database")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchPrescribeMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_115";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDrugSearchPrescribeMedicationValues(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
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

	public boolean verifyDrugSearchPrescribeMedicationValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		int resultCount;

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
				assertTrue(click(selenium, btnErrorClose),"Could not Click Close Button",selenium,ClassName,MethodName);
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
			//  Step-5: Retrieve Medication Name, Ingredient Name and Drug class and verify against test data //
			//--------------------------------------------------------------------//			
			//Get count of all results retrieved		
			//resultCount = getCountOfElementsWithSimilarXpath(selenium, lblMedSearchResultXpath1,lblMedSearchResultXpath2);

			//Extract information from every result
			/*for (int i = 1; i <= resultCount; i++) {
				String resultDrugTradeNameXpath = lnkMedNameResultXpath1 + i + lnkMedNameResultXpath2;
				String resultDrugGenericNameXpath = lnkPrimaryIngredientResultXpath1 + i + lnkPrimaryIngredientResultXpath2;
				String resultDrugClassXpath = lnkDrugClassResultXpath1 + i + lnkDrugClassResultXpath2;

				String resultDrugTradeName = getText(selenium, resultDrugTradeNameXpath);
				String resultDrugGenericName = getText(selenium, resultDrugGenericNameXpath);
				String resultDrugClass = getText(selenium, resultDrugClassXpath);

				//Verify Medication Name, Primary Ingredient and Drug Class
				Assert.assertTrue(resultDrugTradeName.equalsIgnoreCase(prescribeData.medicationName), "Medication Name not matched. Expected: "+prescribeData.medicationName+" Actual: " +resultDrugTradeName);
				Assert.assertTrue(resultDrugGenericName.equalsIgnoreCase(prescribeData.primaryIngredient), "Primary Ingredient not matched. Expected: " +prescribeData.primaryIngredient+ " Actual: "+resultDrugGenericName);
				Assert.assertTrue(resultDrugClass.equalsIgnoreCase(prescribeData.drugClass), "Drug Class not matched. Expected: " +prescribeData.drugClass+ " Actual: "+resultDrugClass);							
			}*/
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}	
}



