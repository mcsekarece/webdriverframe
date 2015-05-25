package com.nexia.selenium.testscripts.section.chartprevisit.exportcapabilities;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForExportChart extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib exportChartData = new ChartPreVisitLib();
		exportChartData.workSheetName = "VerifySecurityOption";
		exportChartData.testCaseId = "TC_VSP_001";
		exportChartData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, exportChartData);
	}

	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib exportChartData = new ChartPreVisitLib();
		exportChartData.workSheetName = "VerifySecurityOption";
		exportChartData.testCaseId = "TC_VSP_002";
		exportChartData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, exportChartData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib exportChartData = new ChartPreVisitLib();
		exportChartData.workSheetName = "VerifySecurityOption";
		exportChartData.testCaseId = "TC_VSP_003";
		exportChartData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, exportChartData);
	}
	
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib exportChartData = new ChartPreVisitLib();
		exportChartData.workSheetName = "VerifySecurityOption";
		exportChartData.testCaseId = "TC_VSP_004";
		exportChartData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, exportChartData);
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib exportChartData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + exportChartData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, exportChartData.userName, exportChartData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,exportChartData.switchRole),"Could not change the switch role;More Details:"+exportChartData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
							
			if(exportChartData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(!goToExportChart(selenium),"Could search patient", selenium, ClassName, MethodName);		
			}	
			
			//--------------------------------------------------------------------//
			//  Step-4:  View only and Limited Access User Role								  //
			//--------------------------------------------------------------------//		
			
			if(exportChartData.testCaseId.equals("TC_VSP_002")||exportChartData.testCaseId.equals("TC_VSP_001")){
				assertTrue(goToExportChart(selenium),"Could search patient", selenium, ClassName, MethodName);
				assertTrue(!isElementVisible(selenium, btnExportChart),"Could search patient", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium, ajxImpProvider),"Could search patient", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium, chkIncludeInactivePatient),"Could search patient", selenium, ClassName, MethodName);
			}		

			//--------------------------------------------------------------------//
			//  Step-5: Full Access User Role									  //
			//--------------------------------------------------------------------//

			if(exportChartData.testCaseId.equals("TC_VSP_004")){
				goToExportChart(selenium);
				//--------------------------------------------------------------------//
				//  Step-6: Delete all Exported Chart//
				//--------------------------------------------------------------------//
				deleteAllExportChart(selenium, exportChartData);
				//--------------------------------------------------------------------//
				//  Step-7: Export Chart//
				//--------------------------------------------------------------------//
				assertTrue(exportChart(selenium, exportChartData),
						"Could not Export Chart",selenium, ClassName, MethodName);
				//--------------------------------------------------------------------//
				//  Step-7: Verify Exported Chart//
				//--------------------------------------------------------------------//
				verifySumDetailsAfterExportChart(selenium, exportChartData);
			}
							
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
		
}