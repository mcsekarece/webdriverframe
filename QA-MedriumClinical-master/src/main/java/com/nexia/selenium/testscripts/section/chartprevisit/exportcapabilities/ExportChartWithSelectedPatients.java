package com.nexia.selenium.testscripts.section.chartprevisit.exportcapabilities;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class ExportChartWithSelectedPatients extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" })
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportChartWithAllPatientData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib exportChartData = new ChartPreVisitLib();
		exportChartData.workSheetName = "ExportChart";
		exportChartData.testCaseId = "TC_EC_004";
		exportChartData.fetchChartPreVisitTestData();
		verifyExportChartFields(seleniumHost, seleniumPort, browser, webSite, userAccount, exportChartData);
	}
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" })
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportChartWithSelectedPatientData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib exportChartData = new ChartPreVisitLib();
		exportChartData.workSheetName = "ExportChart";
		exportChartData.testCaseId = "TC_EC_005";
		exportChartData.fetchChartPreVisitTestData();
		verifyExportChartFields(seleniumHost, seleniumPort, browser, webSite, userAccount, exportChartData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" })
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportChartCancelButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib exportChartData = new ChartPreVisitLib();
		exportChartData.workSheetName = "ExportChart";
		exportChartData.testCaseId = "TC_EC_011";
		exportChartData.fetchChartPreVisitTestData();
		verifyExportChartFields(seleniumHost, seleniumPort, browser, webSite, userAccount, exportChartData);
	}


	/**
	 * verify all the fields of Export chart
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException
	 * @since  	    Nov 06, 2014
	 */
	
	public boolean verifyExportChartFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib exportChartData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + exportChartData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, exportChartData.userName, exportChartData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Export Chart//
			//--------------------------------------------------------------------//
			goToExportChart(selenium);
			//--------------------------------------------------------------------//
			//	Step-3: Export Chart
			//--------------------------------------------------------------------//
			assertTrue(exportChart(selenium, exportChartData),
					"Could not Export Chart",selenium, ClassName, MethodName);
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
