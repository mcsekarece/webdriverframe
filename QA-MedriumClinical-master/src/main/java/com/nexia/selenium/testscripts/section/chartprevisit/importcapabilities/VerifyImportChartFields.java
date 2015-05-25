package com.nexia.selenium.testscripts.section.chartprevisit.importcapabilities;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyImportChartFields extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Immunization")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyImportChartFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib importChartData = new ChartPreVisitLib();
		importChartData.workSheetName = "ImportChart";
		importChartData.testCaseId = "TC_IC_001";
		importChartData.fetchChartPreVisitTestData();
		verifyImportChartFields(seleniumHost, seleniumPort, browser, webSite, userAccount, importChartData);
	}

	/**
	 * verify all the fields of Import chart
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException
	 * @since  	    Nov 06, 2014
	 */
	
	public boolean verifyImportChartFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + immunizationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, immunizationData.userName, immunizationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Import Chart//
			//--------------------------------------------------------------------//
			goToImportChart(selenium);
			//--------------------------------------------------------------------//
			//	Step-3: Verify all fields
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium, ajxImpProvider),
					"Could not click on Quick Actions button",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium, chkIncludeInactiveIC),
					"Could not click on Quick Actions button",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium, btnImpChart),
					"Could not click on Quick Actions button",selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnImpChart),
					"Could not click on Quick Actions button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, ajxImpChartProvider),
					"Could not click on Quick Actions button",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtImportFile),
					"Could not click on Quick Actions button",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium, btnBrowseIC),
					"Could not click on Quick Actions button",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtPasswordIC),
					"Could not click on Quick Actions button",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium, btnImport),
					"Could not click on Quick Actions button",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium, btnCancelImport),
					"Could not click on Quick Actions button",selenium, ClassName, MethodName);
	
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
