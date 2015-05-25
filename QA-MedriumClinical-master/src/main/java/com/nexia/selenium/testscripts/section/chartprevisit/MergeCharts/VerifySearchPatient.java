package com.nexia.selenium.testscripts.section.chartprevisit.MergeCharts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchPatient extends AbstractHomeTest {
	@Test(groups = {"Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying patient search for chart1")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchPatientOnChart1(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "PatientData";
		patientData.testCaseId = "TC_NPC_141";
		patientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySearch(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying patient search for chart2")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchPatientOnChart2(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "PatientData";
		patientData.testCaseId = "TC_NPC_142";
		patientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySearch(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying patient search socio information for chart1")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchPatientSocioInformationOnChart1(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "PatientData";
		patientData.testCaseId = "TC_NPC_142";
		patientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySearch(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying patient socio information search for chart1")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchPatientSocioInformationOnChart2(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "PatientData";
		patientData.testCaseId = "TC_NPC_142";
		patientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySearch(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	
	
	/**
	 * verifySearch
	 * function to verify search patient on chart 1&2 on merge charts page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    October 15, 2014
	 */
	
	public boolean verifySearch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws IOException{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Clear Custom Mandatory Fields
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSettings),"Could not click on the quick action link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSetting),"Could not click the systemSettings link;More Deatils:",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium), "Could not delete all mandatory fields", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Click New Patient Check-in   							  //
			//--------------------------------------------------------------------//				
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			
            if(isElementPresent(selenium,btnErrorClose)){
				assertTrue(click(selenium,btnErrorClose),"Could not click Error Button", selenium, ClassName, MethodName);
			}
			
			assertTrue(click(selenium,lnkQuickLink),"Could not click on quick action", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createPatient(selenium,patientData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String patientId=getText(selenium,lblPatientId);
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Chart Management						      //
			//--------------------------------------------------------------------//
			
			assertTrue(navigateToMergeCharts(selenium),"Navigation Failed", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			
			if(patientData.testCaseId.equals("TC_NPC_141")){
				assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId,btnSearchBoxOnChart1),"Could not find the edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(verifySearchResultsOnPatientChart1(selenium,patientData,patientId,userAccount),"Could not find the edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else if(patientData.testCaseId.equals("TC_NPC_142")){
				assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId,btnSearchBoxOnChart2),"Could not find the edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(verifySearchResultsOnPatientChart2(selenium,patientData,patientId,userAccount),"Could not find the edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			else if(patientData.testCaseId.equals("TC_NPC_143")){
				assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId,btnSearchBoxOnChart2),"Could not find the edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(verifySearchResultSocioInformationsOnPatientChart2(selenium,patientData),"Could not find the edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			else if(patientData.testCaseId.equals("TC_NPC_144")){
				assertTrue(searchPatientNexiaOnChartManagement(selenium,patientId,btnSearchBoxOnChart2),"Could not find the edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(verifySearchResultSocioInformationsOnPatientChart2(selenium,patientData),"Could not find the edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return false;
		}
	}
	
}
