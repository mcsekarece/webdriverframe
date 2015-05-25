package com.nexia.selenium.testscripts.section.chartprevisit.diagnostictestreport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteDIReportsIChart extends AbstractChartPreVisit{

	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for  Verify  Delete Report Details in Chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteUnsignedDIReportsInChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_001";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}	
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for  Verify Signed Delete Report Details in Chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteSignedDIReportsInChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_002";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		verifyDeleteSignedDIReports(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for  Verify Delete Report Details in Timeline is not present")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteDIReportsInTimeline(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_006";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	 /**
	 * Test for  Verify  Delete Report Details in Chart
	 * function to  Verify  Delete Report Details in Chart
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 06, 2014
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
			System.out.println(" queueValue" + queueValue);
			
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
			
			// -------------------------------------------------------------------//
			//  Step-5 :Verify the report Created						      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(keyPress(selenium,searchTextBox,"\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,vfyUnsignedDiReports).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.facilityName.trim().toLowerCase(new java.util.Locale("en","US"))),"Diagnostic report not created successfully", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// -------------------------------------------------------------------//
			//  Step-6 : Navigate to the chart				      				  // 
			//--------------------------------------------------------------------//
			
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,diData.patientId),"Search patient failed", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
			
		    assertTrue(click(selenium,lnkMore),"Could not click more button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkDiagnosticReports),"Could not click Diagnostic link report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// -------------------------------------------------------------------//
			//  Step-7 : Viewed the report	and delete it       		  // 
			//--------------------------------------------------------------------//
					 
			 assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,"Unsigned"),"Could not select Unsigned Status ",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(type(selenium,searchTextBox,diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			
			 assertTrue(keyPress(selenium,searchTextBox,"\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 assertTrue(click(selenium,btnSignedAction),"Could not click action button", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			 
			 assertTrue(click(selenium, delete),"Could not click Delete button", selenium, ClassName,MethodName);
		     waitForPageLoad(selenium);
			 
		     assertTrue(type(selenium,txtdeleteReason,"Reason"),"Could not type delete reason", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			
			 assertTrue(click(selenium, btnChooseDelete),"Could not click Delete reason button", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			
			 //--------------------------------------------------------------------//
			//  Step- 8: Verify the Delete DI Report in Time line				//
			//--------------------------------------------------------------------//
				 
			 assertTrue(click(selenium,lnkTimeLine),"Could not click Timeline link", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			 
			 assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,"DI Reports "),"Could not select Unsigned Status ",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
	
			 assertTrue(!isTextPresent(selenium,diData.facilityName),"Verify delete report not present in Timeline failed", selenium, ClassName,MethodName);
		     waitForPageLoad(selenium);
			 
			 
			//--------------------------------------------------------------------//
			//  Step- 9: Verify the Delete Unsigned DI Report								//
			//--------------------------------------------------------------------//
			 
			 assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,"Unsigned"),"Could not select Unsigned Status ",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(type(selenium,searchTextBox,diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
          	 assertTrue(!getText(selenium,vfySignedDiReportsChart).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.facilityName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify the Delete DI Report in chart failed", selenium, ClassName,MethodName);
		     waitForPageLoad(selenium);
			
			return returnvalue;
			
	}	catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	
	return returnvalue;

}	
	public boolean verifyDeleteSignedDIReports(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib diData) throws IOException{
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
			System.out.println(" queueValue" + queueValue);
			
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
			
			// -------------------------------------------------------------------//
			//  Step-5 :Verify the report Created						      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(keyPress(selenium,searchTextBox,"\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,vfyUnsignedDiReports).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.facilityName.trim().toLowerCase(new java.util.Locale("en","US"))),"Diagnostic report not created successfully", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// -------------------------------------------------------------------//
			//  Step-6 : Navigate to the chart				      				  // 
			//--------------------------------------------------------------------//
			
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,diData.patientId),"Search patient failed", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
			
		    assertTrue(click(selenium,lnkMore),"Could not click more button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkDiagnosticReports),"Could not click Diagnostic link report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// -------------------------------------------------------------------//
			//  Step-7 : Viewed the report	and sign it  		  // 
			//--------------------------------------------------------------------//
					 
			 assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,"Unsigned"),"Could not select Unsigned Status ",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(type(selenium,searchTextBox,diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			
			 assertTrue(keyPress(selenium,searchTextBox,"\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 assertTrue(click(selenium,btnSignedAction),"Could not click action button", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(click(selenium,lnkSignedViewReport),"Could not click link Signed View Report", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			
			 assertTrue(click(selenium, btnDISign),"Could not click sign button in diagnostic", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(!isElementPresent(selenium, btnDISign),"not signed the report", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			
			// -------------------------------------------------------------------//
			//  Step-7 : Viewed the report	and delete it       		  // 
			//--------------------------------------------------------------------//
						 
			 assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,"Signed"),"Could not select Unsigned Status ",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(type(selenium,searchTextBox,diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
				
			 assertTrue(keyPress(selenium,searchTextBox,"\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
				 
			 assertTrue(click(selenium,btnSignedAction),"Could not click action button", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
				 
			 assertTrue(click(selenium, delete),"Could not click Delete button", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
				 
			 assertTrue(type(selenium,txtdeleteReason,"Reason"),"Could not type delete reason", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
				
			 assertTrue(click(selenium, btnChooseDelete),"Could not click Delete reason button", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
				
			
			//--------------------------------------------------------------------//
			//  Step- 8: Verify the Delete DI Report								//
			//--------------------------------------------------------------------//
			 
			 assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,"Signed"),"Could not select Unsigned Status ",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(type(selenium,searchTextBox,diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
          	 assertTrue(!getText(selenium,vfySignedDiReportsChart).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.facilityName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify the Delete DI Report in chart failed", selenium, ClassName,MethodName);
		     waitForPageLoad(selenium);
			
			return returnvalue;
			
	}	catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	
	return returnvalue;

}	
	
}
