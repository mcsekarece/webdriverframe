package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultValueForAllergy extends AbstractChartPreVisit{
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createAllergyWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_001";
		allergyData.fetchChartPreVisitTestData();
		verifyDefaultStoreValues(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	/**
	 * verifyDefaultStoreValues
	 * function to verify Default Store Values
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since	  	Nov 06, 2012
	 */

	public boolean verifyDefaultStoreValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		boolean returnValue=true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Delete Immunization//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAllergyShowmore),"Could not click the link;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
		
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Default Values//
			//--------------------------------------------------------------------//
			
			assertTrue(verifyDefaultStoredValue(selenium,allergyData),"Deletails is not stored properly",selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyDefaultStoredValue(Selenium selenium,ChartPreVisitLib allergyData){
		try
		{
		
		assertTrue(getValue(selenium, "allergyradio").equalsIgnoreCase("on"),"Could not match the data with allery", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(getValue(selenium,"severitysuggestBox").trim().equalsIgnoreCase(allergyData.severity),"could not match the data with severitysuggestBox", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
        assertTrue(getValue(selenium,"statusSuggestBoxsuggestBox").trim().contains(allergyData.status),"could not match the data with statusSuggestBoxsuggestBox", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,"lifeStagesuggestBox").trim().equals(""),"could not match the data with lifeStagesuggestBox", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,txtOnset).trim().equals(""),"could not match the data with textOnSet", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,txtcomment).trim().equals(""),"could not match the data with txtcomment", selenium, ClassName, MethodName);
		
		
		
		
		/*if(!getValue(selenium,"allergyReactionsuggestBox").trim().equals("")){
			return false;
		}*/
		
		}catch(Exception e)
		{
		e.printStackTrace();
		}
		
		return true;
	}
}
