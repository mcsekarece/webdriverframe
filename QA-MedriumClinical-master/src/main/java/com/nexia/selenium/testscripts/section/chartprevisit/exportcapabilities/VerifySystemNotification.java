package com.nexia.selenium.testscripts.section.chartprevisit.exportcapabilities;

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
		ChartPreVisitLib exportChartData = new ChartPreVisitLib();
		exportChartData.workSheetName = "ExportChart";
		exportChartData.testCaseId = "TC_EC_008";
		exportChartData.fetchChartPreVisitTestData();
		verifyExportChartFields(seleniumHost, seleniumPort, browser, webSite, userAccount, exportChartData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" })
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRemoveOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib exportChartData = new ChartPreVisitLib();
		exportChartData.workSheetName = "ExportChart";
		exportChartData.testCaseId = "TC_EC_009";
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
			//	Step-2: run export Process
			//--------------------------------------------------------------------//
			statmentTrigger(selenium,"https://108.161.43.83:8443/AdminConsole/exportPatientBackend");
			
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
			 if(exportChartData.testCaseId.equals("TC_EC_009")){
				 assertTrue(!(isElementPresent(selenium,lblSystemNotificationEC)&&isElementVisible(selenium,lblSystemNotificationEC)),"Could not click the back button", selenium, ClassName, MethodName);
				 
			 }
			 assertTrue(click(selenium,lnkHideSystemNote),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to Export Chart//
			//--------------------------------------------------------------------//
			goToExportChart(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Delete all Exported Chart//
			//--------------------------------------------------------------------//
			deleteAllExportChart(selenium, exportChartData);
			//--------------------------------------------------------------------//
			//  Step-5: Export Charts//
			//--------------------------------------------------------------------//
			assertTrue(exportChart(selenium, exportChartData),
					"Could not Export Chart",selenium, ClassName, MethodName);
			statmentTrigger(selenium,"https://108.161.43.83:8443/AdminConsole/exportPatientBackend");
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Exported Chart//
			//--------------------------------------------------------------------//
			 assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose))
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 assertTrue(click(selenium,lnkSystemNotification),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			
			 assertTrue(selectValueFromAjaxList(selenium,ajxSearchSystemNote,exportChartData.providerNameEC),"Could not click the back button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(selectValueFromAjaxList(selenium,ajxShowAllEC,"Chart Export"),"Could not click the back button", selenium, ClassName, MethodName);
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
