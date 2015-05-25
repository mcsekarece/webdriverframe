package com.nexia.selenium.testscripts.section.chartprevisit.ChartDisclosure;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class EditRequest extends AbstractChartPreVisit {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editRequest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib chartDisclosureData = new ChartPreVisitLib();
		chartDisclosureData.workSheetName = "CreatePatientTask";
		chartDisclosureData.testCaseId = "TC_CD_027";
		chartDisclosureData.fetchChartPreVisitTestData();
		editRequest(seleniumHost, seleniumPort, browser, webSite, userAccount, chartDisclosureData);
	}
		
	
	/**
	 * createChartDisclosure
	 * function to create Chart Disclosure
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    April 28, 2014
	 */
	
	public boolean editRequest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib chartDisclosureData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + chartDisclosureData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, chartDisclosureData.userName, chartDisclosureData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			navigateToPatient(selenium, chartDisclosureData);
			assertTrue(click(selenium,lnkChartView),"Could not click Chart View Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOption),"Could not click Patient Option Link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkChartDisclosure),"Could not click Chart Disclosure Link", selenium, ClassName, MethodName);
			chartDisclosureData.workSheetName = "CreatePatientTask";
			chartDisclosureData.testCaseId = "TC_CD_001";
			chartDisclosureData.fetchChartPreVisitTestData();
			
			//creating new Chart Disclosure
			assertTrue(createMandatoryChartDisclosureFromPC(selenium, chartDisclosureData, userAccount),"Could not create Chart Disclosure from Patient Option", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnCntnue),"Could not click Continue Button", selenium, ClassName, MethodName);
			
			//Editing the Chart Disclosure
			assertTrue(click(selenium,btnEditRequest),"Could not click Edit Request", selenium, ClassName, MethodName);
			chartDisclosureData.workSheetName = "CreatePatientTask";
			chartDisclosureData.testCaseId = "TC_CD_002";
			chartDisclosureData.fetchChartPreVisitTestData();
			assertTrue(createMandatoryChartDisclosureFromPC(selenium, chartDisclosureData, userAccount),"Could not create Chart Disclosure from Patient Option", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnCntnue),"Could not click Continue Button", selenium, ClassName, MethodName);
			
			//verify Edited Data
			assertTrue(click(selenium,btnEditRequest),"Could not click Edit Request", selenium, ClassName, MethodName);
			assertTrue(verifyChartDisclosureData(selenium, chartDisclosureData),"Data Verification failed", selenium, ClassName, MethodName);
			
			
			
			
			
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/**
	 * verify Edit Chart disclosure 
	 * function navigateToPatient
	 * @since Feb 04, 2014
	 **/ 
	public boolean navigateToPatient(Selenium selenium, ChartPreVisitLib PatientData) throws IOException{
		
		assertTrue(type(selenium, txtPatientBox, PatientData.patientId),"Could not type patient id", selenium, ClassName,MethodName);
		selenium.clickAt("searchPatientBox","");
		selenium.focus("searchPatientBox");			
		selenium.fireEvent("searchPatientBox","keypress");		
		waitForElement(selenium, lblPatientResult, 10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ PatientData.patientId, selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		selenium.mouseOver(lblPatientResult2);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		return true;
		}
}
