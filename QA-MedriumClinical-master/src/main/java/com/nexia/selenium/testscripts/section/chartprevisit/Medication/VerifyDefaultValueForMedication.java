package com.nexia.selenium.testscripts.section.chartprevisit.Medication;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultValueForMedication extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Default Value Medication With Direction")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultValueMedicationWithDirection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_001";
		medicationTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyDefaultValue(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Default Value For Incerase Decrease Dose")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultValueMedicationWithInceraseDecreaseDose(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_002";
		medicationTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyDefaultValueForInceraseDecreaseDose(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Default Value For Incerase Decrease Dose")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrePopulatedValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_Medication";
		medicationTestData.testCaseId = "TC_PSM_016";
		medicationTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyDefaultValueForInceraseDecreaseDose(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	}
	/**
	 * verifyDefaultValue
	 * function to verify Default Value
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 11, 2012
	 */
	
	public boolean verifyDefaultValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLibUnitTest medicationData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,medicationData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigtae to Medication //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Default Value //
			//--------------------------------------------------------------------//
			assertTrue(verifyDefaultStoredValue(selenium,medicationData),"Medication details not saved properly; More Details :"+ medicationData.toString(), selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyDefaultStoredValue(Selenium selenium,ChartPreVisitLibUnitTest medicationData) throws IOException{
		assertTrue(getValue(selenium,ajxMethod).trim().contains(medicationData.refillMethod),"Could not get value", selenium, ClassName, MethodName);
		return true;
	}
	
	/**
	 * verifyDefaultValueForInceraseDecreaseDose
	 * function to  verify Default Value ForIncerase Decrease Dose
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 11, 2012
	 */
	
	public boolean verifyDefaultValueForInceraseDecreaseDose(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLibUnitTest medicationData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,medicationData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigtae to Medication //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(medicationData.increaseDecreaseDose.equals("Yes")){
				assertTrue(click(selenium,chkInDeDosecheckBox),"Could not click the check box;More Details:"+medicationData.toString(), selenium, ClassName, MethodName);
			}
			//--------------------------------------------------------------------//
			//  Step-4: Verify Default Value //
			//--------------------------------------------------------------------//
			if(medicationData.testCaseId.equals("TC_PSM_016")){
				if(userAccount.equals(CAAccount)){
					selectValueFromAjaxList(selenium,ajxSearchMedication,medicationData.prescribeCa);
				}else
					selectValueFromAjaxList(selenium,ajxSearchMedication,medicationData.prescribe);
				waitForPageLoad(selenium);
				assertTrue(verifyPrePopulatedValue(selenium,medicationData),"Pre-Populated values for Medication is not displayed properly; More Details :"+ medicationData.toString(), selenium, ClassName, MethodName);			}
			else if(!verifyDefaultValue(selenium,medicationData)){
				Assert.fail("Medication details not saved properly; More Details :"+ medicationData.toString());
				returnValue=false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyDefaultValue(Selenium selenium,ChartPreVisitLibUnitTest medicationData) throws IOException{
		assertTrue(getValue(selenium,"refillMethodSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox").trim().contains(medicationData.refillMethod),"Could not get value", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,ajxRefilUsage).trim().contains(medicationData.refillUsage),"Could not get value", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,ajxInRefillUsage1).trim().contains(medicationData.refillUsage2),"Could not get value", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,ajaxInRefillUsage3).trim().contains(medicationData.refillUsage4),"Could not get value", selenium, ClassName, MethodName);
		return true;
	}
	
	public boolean verifyPrePopulatedValue(Selenium selenium,ChartPreVisitLibUnitTest medicationData) throws IOException{
		
		assertTrue(getValue(selenium,ajxMethod).trim().equals(medicationData.refillMethod),"Could not get value", selenium, ClassName, MethodName);
		
		return true;
	}
}
