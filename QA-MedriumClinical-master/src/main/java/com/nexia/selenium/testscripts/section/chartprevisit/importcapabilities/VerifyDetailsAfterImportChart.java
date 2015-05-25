package com.nexia.selenium.testscripts.section.chartprevisit.importcapabilities;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDetailsAfterImportChart extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" })
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySummaryDetailsForPending(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib importChartData = new ChartPreVisitLib();
		importChartData.workSheetName = "ImportChart";
		importChartData.testCaseId = "TC_IC_003";
		importChartData.fetchChartPreVisitTestData();
		verifyImportChartFields(seleniumHost, seleniumPort, browser, webSite, userAccount, importChartData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" })
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySummaryDetailsForSuccessful(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib importChartData = new ChartPreVisitLib();
		importChartData.workSheetName = "ImportChart";
		importChartData.testCaseId = "TC_IC_004";
		importChartData.fetchChartPreVisitTestData();
		verifyImportChartFields(seleniumHost, seleniumPort, browser, webSite, userAccount, importChartData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" })
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySummaryDetailsForFailed(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib importChartData = new ChartPreVisitLib();
		importChartData.workSheetName = "ImportChart";
		importChartData.testCaseId = "TC_IC_005";
		importChartData.fetchChartPreVisitTestData();
		verifyImportChartFields(seleniumHost, seleniumPort, browser, webSite, userAccount, importChartData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" })
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncludeInactiveCheckbox(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib importChartData = new ChartPreVisitLib();
		importChartData.workSheetName = "ImportChart";
		importChartData.testCaseId = "TC_IC_006";
		importChartData.fetchChartPreVisitTestData();
		verifyImportChartFields(seleniumHost, seleniumPort, browser, webSite, userAccount, importChartData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" })
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncludeActivateButton(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib importChartData = new ChartPreVisitLib();
		importChartData.workSheetName = "ImportChart";
		importChartData.testCaseId = "TC_IC_007";
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
	
	public boolean verifyImportChartFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib importChartData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + importChartData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, importChartData.userName, importChartData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//	Step-2: run Import Process
			//--------------------------------------------------------------------//
			statmentTrigger(selenium,"https://108.161.43.83:8443/AdminConsole/importPatientBackend");
			//--------------------------------------------------------------------//
			//  Step-3: Go to Import Chart//
			//--------------------------------------------------------------------//
			goToImportChart(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Delete all Imported Chart//
			//--------------------------------------------------------------------//
			deleteAllImportChart(selenium, importChartData);
			//--------------------------------------------------------------------//
			//  Step-5: Import Chart//
			//--------------------------------------------------------------------//
			assertTrue(importChart(selenium, importChartData),
					"Could not Import Chart",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-6: Verify Imported Chart//
			//--------------------------------------------------------------------//
			if((importChartData.testCaseId.equals("TC_IC_003")||importChartData.testCaseId.equals("TC_IC_004")||importChartData.testCaseId.equals("TC_IC_005"))){
				verifySumDetailsAfterImportChart(selenium, importChartData);
			}else
			{
				statmentTrigger(selenium,"https://108.161.43.83:8443/AdminConsole/importPatientBackend");
				goToImportChart(selenium);
				deleteAllImportChart(selenium, importChartData);
				assertTrue(click(selenium, chkIncludeInactivePatient),
						"Could not click Delete Link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium, lblProviderNameImportChart),
						"Inactive charts are not visible",selenium, ClassName, MethodName);
			
			}
			
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
