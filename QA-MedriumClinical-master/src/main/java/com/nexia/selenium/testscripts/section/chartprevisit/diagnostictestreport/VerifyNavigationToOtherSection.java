package com.nexia.selenium.testscripts.section.chartprevisit.diagnostictestreport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyNavigationToOtherSection extends AbstractChartPreVisit{
 	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Navigation To Other Section ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNavigationToOtherSection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
	
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_001";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	
	/** 
	 * Verify Navigation To Other Section
	 * function to Verify Navigation To Other Section
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 3, 2014
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
			//  Step-2: Verify Diagnostic Report Q count before adding Report
			//--------------------------------------------------------------------//			
	
			String dIQueue=getText(selenium,queDiagnosticReport);
			System.out.println(dIQueue);
			String[] splitS = dIQueue.split(" ");
			int  queueValue = Integer.parseInt(splitS[0]);
			System.out.println( queueValue);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Diagnostic Report
			//--------------------------------------------------------------------//			
			
			assertTrue(navigateToCorresReport(selenium,diData),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-4 :Diagnostic  Report for the  patient 
			//--------------------------------------------------------------------//
		
			assertTrue(CreateDiagnosticReport(selenium,diData,userAccount),"Creation of Diagnostic  Report failed ", selenium, ClassName,MethodName);  
	        waitForPageLoad(selenium);	
			
	        assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			
			// Navigate to the report
			
			assertTrue(click(selenium, queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, vfyUnsignedDiReports),"Could not click  diagnostic report in list ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,btnDISign),"Could not navigate to diagnostic report page ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Verify the Navigation to other sections
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, lnkSummary),"Could not click Summary Tab ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,"ALLERGIES"),"Could not navigate to  Summary List page ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,"PROBLEM LIST"),"Could not navigate to  Summary List page ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
	
			assertTrue(click(selenium, lnkencounterTab),"Could not click Encounter Tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,"Pending Sign-Off"),"Could not navigate to  Encounter page ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,"Signed Encounters"),"Could not navigate to  Encounter page ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkLabs),"Could not click Lab Tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,"Flowsheet"),"Could not navigate to  Lab page ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,"List View"),"Could not navigate to  Lab page ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			return returnvalue;
		
		}	catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnvalue;
	 }
}
