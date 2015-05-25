package com.nexia.selenium.testscripts.section.chartprevisit.GrowthCharts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyGrowthChartBasedOnAge extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Growth Charts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyGrowthChartsForHeight(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib growthChartsData = new ChartPreVisitLib();
		growthChartsData.workSheetName = "VerifyGrowthChart";
		growthChartsData.testCaseId = "TC_GC_003";
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
	 * @since  	    Dec 13, 2012
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
			assertTrue(click(selenium,"!chartGrowthCharts"),"Could not click growth charts link",selenium, ClassName, MethodName);
			if(getText(selenium,"//body/div[5]/div/div/div/div").contains(growthChartsData.errorMessage))
				returnValue=true;
			else
				return false;
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
