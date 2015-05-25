package com.nexia.selenium.testscripts.section.chartprevisit.FamilyHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultValueForFamilyHistory extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "function to verify Default Store Values")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createFamilyHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "CreateFamilyHistory";
		historyData.testCaseId = "TC_CFM_001";
		historyData.fetchChartPreVisitTestData();
		verifyDefaultStoreValues(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	/**
	 * verifyDefaultStoreValues
	 * function to verify Default Store Values
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  		Nov 07, 2012
	 */

	public boolean verifyDefaultStoreValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
		boolean returnValue=true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			AbstractClinicalSettings clinicalSettings= new AbstractClinicalSettings();
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSettings),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalSetting),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,clinicalSettings.lnkPracticePref),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String CodSys=selenium.getText(clinicalSettings.lblCodingSystem);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Delete Immunization//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteFamilyHistory(selenium,historyData ),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Default Values//
			//--------------------------------------------------------------------//
			assertTrue(verifyDefaultStoredValue(selenium,historyData,CodSys),"Verification  Failed",selenium, ClassName, MethodName);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyDefaultStoredValue(Selenium selenium,ChartPreVisitLib allergyData,String CodSys) throws IOException{
		
		assertTrue(click(selenium,lnkFamilkShowMoreDeatils),"Could not on show more button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(getValue(selenium, ajxFamilyMedical).equals(""),"Could not Find the text", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,ajxFamilyrelation).equals(""),"Could not Find the text", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,ajxCodeingSystem).equals(CodSys),"Could not Find the text", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtAgeOfOnset).equals(""),"Could not Find the text", selenium, ClassName, MethodName);
		
		assertTrue(selectValueFromAjaxList(selenium, ajxCodeingSystem, allergyData.codingSystem),"Could not select",selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,ajxdiagnosis).trim().equals(""),"Could not Find the text", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,ajxlifeStage).trim().equals(""),"Could not Find the text", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,chkCasue).trim().equalsIgnoreCase("off"),"Could not Find the text", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,ajxlifeStage).trim().equals(""),"Could not Find the text", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtTreatMent).trim().equals(""),"Could not Find the text", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtComment).trim().equals(""),"Could not Find the text", selenium, ClassName, MethodName);
		
		
		return true;
	}
}
