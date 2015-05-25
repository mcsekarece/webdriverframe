package com.nexia.selenium.testscripts.section.chartprevisit.GrowthCharts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyGrowthCharts extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Growth Charts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyGrowthChartsForHeight(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib growthChartsData = new ChartPreVisitLib();
		growthChartsData.workSheetName = "VerifyGrowthChart";
		growthChartsData.testCaseId = "TC_GC_001";
		growthChartsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		//verifyGrowthChart(seleniumHost, seleniumPort, browser, webSite, userAccount, growthChartsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Growth Charts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyGrowthChartsForWeight(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib growthChartsData = new ChartPreVisitLib();
		growthChartsData.workSheetName = "VerifyGrowthChart";
		growthChartsData.testCaseId = "TC_GC_002";
		growthChartsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		//verifyGrowthChart(seleniumHost, seleniumPort, browser, webSite, userAccount, growthChartsData);
	}
	
	/**
	 * verifyGrowthChart
	 * function to verify Growth charts
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 07, 2012
	 */
	
	public boolean verifyGrowthChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib growthChartsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + growthChartsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, growthChartsData.userName, growthChartsData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,growthChartsData.patientId);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"errorCloseButton"))
				assertTrue(click(selenium,"errorCloseButton"),"Could not click error button",selenium, ClassName, MethodName);
			assertTrue(click(selenium,"!chartGrowthCharts"),"Could not click more link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(growthChartsData.testCaseId.equals("TC_GC_001"))
			{
			assertTrue(click(selenium,"//div[2]/div/div[2]/div/div"),"Could not click Height link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"xpath=(//canvas[@id='chart'])[2]"))
				returnValue=true;
			else
				returnValue=false;
			}
			else
			{
				assertTrue(click(selenium,"css=div.gwt-Label"),"Could not click Weight link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,"chart"))
					returnValue=true;
				else
					returnValue=false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
