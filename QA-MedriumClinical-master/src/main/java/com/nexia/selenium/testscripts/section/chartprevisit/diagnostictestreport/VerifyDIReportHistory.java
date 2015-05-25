package com.nexia.selenium.testscripts.section.chartprevisit.diagnostictestreport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDIReportHistory extends AbstractChartPreVisit{
	
	 @Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify DI Report History")
	 @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	 public void verifyDIReportHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_005";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	 
	 /**
		 * Verify DI Report History
		 * function to Verify DI Report History
		 * @param 		seleniumHost
		 * @param 		seleniumPort
		 * @param 		browser
		 * @param 		webSite
		 * @throws      IOException 
		 * @since  	    Nov 12, 2014
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
			
	        // Verify the DI Report created or not
			
			String dIQueue1=getText(selenium,queDiagnosticReport);
			System.out.println(dIQueue1);
			String[] splitS1 = dIQueue1.split(" ");
			int  queueValue1 = Integer.parseInt(splitS1[0]);
			System.out.println(" queueValue1 - " +  queueValue1);
			
			if( queueValue1 >  queueValue){
				returnvalue=true;
			}else{
				assertTrue(false,"After save the report  the Count in the Q not updated Before Count=+"+ queueValue+",After Count=="+ queueValue1+"", selenium, ClassName, MethodName);
			}

			//--------------------------------------------------------------------//
			//  Step-5: Navigate to the Corresponding Report
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
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
			//  Step-6 :Forward the Diagnostic  Report to another user
			//--------------------------------------------------------------------//
			
			
			Calendar cal=Calendar.getInstance();
		  	SimpleDateFormat dateFormat=new SimpleDateFormat("MMM dd,yyyy");
			String date= dateFormat.format(cal.getTime());
			
			assertTrue(click(selenium, action),"Could not click  action button ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		    
			assertTrue(click(selenium, lnkDIHistory ),"Could not click  History link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7 : Verify DI Report History
			//--------------------------------------------------------------------//
			
			assertTrue(getText(selenium,lblDIHistoryDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.testName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify DI Report History failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,lblDIHistoryDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify DI Report History failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
		
	}	catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	return returnvalue;
}
}

