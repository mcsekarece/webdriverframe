package com.nexia.selenium.testscripts.section.chartprevisit.importcapabilities;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySystemNotification extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" })
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySystemNotification(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib importChartData = new ChartPreVisitLib();
		importChartData.workSheetName = "ImportChart";
		importChartData.testCaseId = "TC_IC_008";
		importChartData.fetchChartPreVisitTestData();
		verifyImportChartFields(seleniumHost, seleniumPort, browser, webSite, userAccount, importChartData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" })
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRemoveOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib importChartData = new ChartPreVisitLib();
		importChartData.workSheetName = "ImportChart";
		importChartData.testCaseId = "TC_IC_009";
		importChartData.fetchChartPreVisitTestData();
		verifyImportChartFields(seleniumHost, seleniumPort, browser, webSite, userAccount, importChartData);
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
			//	Step-2: run import Process
			//--------------------------------------------------------------------//
			statmentTrigger(selenium,"https://108.161.43.83:8443/AdminConsole/importPatientBackend");
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose))
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 assertTrue(click(selenium,lnkSystemNotification),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(click(selenium,chkSelectAllEC),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(click(selenium,btnRemoveSystemNote),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(click(selenium,btnYesButtonEC),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 if(importChartData.testCaseId.equals("TC_IC_009")){
				 assertTrue(!(isElementPresent(selenium,lblSystemNotificationEC)&&isElementVisible(selenium,lblSystemNotificationEC)),"Could not click the back button", selenium, ClassName, MethodName);
				 
			 }
			 assertTrue(click(selenium,lnkHideSystemNote),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to Import Chart//
			//--------------------------------------------------------------------//
			goToImportChart(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Delete all Imported Chart//
			//--------------------------------------------------------------------//
			deleteAllImportChart(selenium, importChartData);
			//--------------------------------------------------------------------//
			//  Step-5: Import Charts//
			//--------------------------------------------------------------------//
			assertTrue(importChart(selenium, importChartData),
					"Could not Import Chart",selenium, ClassName, MethodName);
			statmentTrigger(selenium,"https://108.161.43.83:8443/AdminConsole/importPatientBackend");
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Imported Chart//
			//--------------------------------------------------------------------//
			 assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose))
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 assertTrue(click(selenium,lnkSystemNotification),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			
			 assertTrue(selectValueFromAjaxList(selenium,ajxSearchSystemNote,importChartData.providerNameEC),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(selectValueFromAjaxList(selenium,ajxShowAllEC,"Chart Import"),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(isElementPresent(selenium,lblSystemNotificationEC),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
