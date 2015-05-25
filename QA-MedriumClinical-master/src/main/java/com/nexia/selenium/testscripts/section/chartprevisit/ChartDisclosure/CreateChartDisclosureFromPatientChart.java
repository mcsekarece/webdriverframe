package com.nexia.selenium.testscripts.section.chartprevisit.ChartDisclosure;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateChartDisclosureFromPatientChart extends AbstractChartPreVisit {
	
	@Test(groups = {"AdvancedSmoke","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createChartDisclosureFromPatientChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib chartDisclosureData = new ChartPreVisitLib();
		chartDisclosureData.workSheetName = "CreatePatientTask";
		chartDisclosureData.testCaseId = "TC_CD_026";
		chartDisclosureData.fetchChartPreVisitTestData();
		createChartDisclosure(seleniumHost, seleniumPort, browser, webSite, userAccount, chartDisclosureData);
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
	
	public boolean createChartDisclosure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib chartDisclosureData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			String date = null;
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MMddHHmm");
			date = DateFormat.format(cal.getTime());
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
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
				selenium.chooseOkOnNextConfirmation();
				}
			
			//creating new Chart Disclosure
			chartDisclosureData.Instruction=chartDisclosureData.Instruction+date;
			assertTrue(createMandatoryChartDisclosureFromPC(selenium, chartDisclosureData, userAccount),"Could not create Chart Disclosure from Patient Option", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnCntnue),"Could not click Chart Disclosure Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//verify Saved Data
			assertTrue(click(selenium,btnEditRequest),"Could not click Edit Request", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifyChartDisclosureData(selenium, chartDisclosureData),"Data Verification failed", selenium, ClassName, MethodName);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
