package com.nexia.selenium.testscripts.section.chartprevisit.diagnostictestreport;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultSearchOptions extends AbstractChartPreVisit{
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Search Option TestName")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultSearchOptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_003";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}	
	
	
	/**
	 * Verify Search Option TestName
	 * function to Verify Search Option TestName 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 20, 2014
	 */
	public boolean createDiagnosticTestReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib diData) throws IOException{
		Selenium selenium=null;	
		boolean returnvalue=true;
	try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + diData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, diData.userName, diData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
						
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Diagnostic Report
			//--------------------------------------------------------------------//			

			assertTrue(click(selenium, queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step - 3: Verify default options
			//--------------------------------------------------------------------//	
			
			assertTrue(getValue(selenium,forPickList).toLowerCase(new java.util.Locale("en","US")).trim().contains("All for".trim().toLowerCase(new java.util.Locale("en","US"))),"Verify show default failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getValue(selenium,show).toLowerCase(new java.util.Locale("en","US")).trim().contains("All for".trim().toLowerCase(new java.util.Locale("en","US"))),"Verify show field default failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,hideQueue),"Hide option not present", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
           
			assertTrue(selenium.getAttribute(searchTextBox).trim().equalsIgnoreCase("Search by patient, test name or sending faci"),"Verify search field hint failed", selenium, ClassName,MethodName);  
            waitForPageLoad(selenium);
			
			
	}	catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	
	return returnvalue;

}	
	
	
}
