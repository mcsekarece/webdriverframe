package com.nexia.selenium.testscripts.section.chartprevisit.MedWarnings;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyFoodDrinkInteraction extends AbstractChartPreVisit{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying food interaction")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFoodInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "MedWarnings";
		prescribeData.testCaseId = "TC_PMW_001";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		foodDrinkInteraction(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Drink interaction")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDrinkInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "MedWarnings";
		prescribeData.testCaseId = "TC_PMW_002";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		foodDrinkInteraction(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * foodDrinkInteraction
	 * Function to verify food drink interaction 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 14, 2012
	 */
	public boolean foodDrinkInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue = false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Verify Food/Drink Interaction for the medication //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValues(selenium,prescribeData,userAccount),"Values are not stored", selenium, ClassName, MethodName);
			return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib labData,String account) throws IOException{
		waitForPageLoad(selenium);	
		
		if(account.equals(CAAccount)){
			assertTrue(isElementPresent(selenium,lblWarningSeverity),"Element severity missing", selenium, ClassName, MethodName);
			if(labData.testCaseId.equals("TC_PMW_002")){
				assertTrue(isElementPresent(selenium,lblWarning),"Warning label missing", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblInteraction).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.indications.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblInteraction).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.prescribeCa.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			}
			else{
				assertTrue(isElementPresent(selenium,imgFoodWarning),"Element foodwarning is missing", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblFoodInteraction).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.indications.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblFoodInteraction).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.prescribeName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			}
			return true;
		}
		else
		
			assertTrue(isElementPresent(selenium,lblWarningSeverity),"label severity is not present", selenium, ClassName, MethodName);
		if(labData.testCaseId.equals("TC_PMW_002")){
			assertTrue(isElementPresent(selenium,lblWarning),"label severity is not present", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblInteraction).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.indications.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblInteraction).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.prescribeCa.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
		}
		else{
			assertTrue(isElementPresent(selenium,imgFoodWarning),"Image food warning is missing", selenium, ClassName, MethodName);
			
			assertTrue(getText(selenium,lblFoodInteraction).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.indications.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			
			assertTrue(getText(selenium,lblFoodInteraction).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.prescribeName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
		}
		return true;
	}	
}
