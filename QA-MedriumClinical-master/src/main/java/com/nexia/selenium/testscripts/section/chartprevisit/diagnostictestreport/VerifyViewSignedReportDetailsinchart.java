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

public class VerifyViewSignedReportDetailsinchart extends AbstractChartPreVisit{
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify View Sigend Report Details in chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyViewSignedReportDetailsinchart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_006";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}	
	
	/**
	 * Verify View Signed Report Details in chart
	 * function to Verify View Signed Report Details in chart
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
			//  Step-5 :Create another  Diagnostic  Report for the  patient 
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib diData1 = new ChartPreVisitLib();
			diData1.workSheetName = "CreateDiagnosticReport";
			diData1.testCaseId = "TC_CDR_009";
			diData1.fetchChartPreVisitTestData();
			
			assertTrue(navigateToCorresReport(selenium,diData1),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(CreateDiagnosticReport(selenium,diData1,userAccount),"Creation of Diagnostic  Report failed ", selenium, ClassName,MethodName);  
	        waitForPageLoad(selenium);	
			
	        assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// -------------------------------------------------------------------//
			//  Step-5 :Verify the report Created						      //
			//--------------------------------------------------------------------//
			
			assertTrue(type(selenium,searchTextBox, diData1.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
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
			//  Step-7 : Viewed the report and sign it				      		  // 
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
			//  Step-7 : Viewed the another report	and sign it				      // 
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
			 
				//-------------------------------------------------------------------//
			    //  Step-8 : View the signed report 					             // 
				//--------------------------------------------------------------------//
					
				assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,"Signed"),"Could not select Unsigned Status ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(keyPress(selenium,searchTextBox,"\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
				//-------------------------------------------------------------------//
			    //  Step-9 : Verify View the signed report 					             // 
				//--------------------------------------------------------------------//
				
				assertTrue(getText(selenium,vfySignedDiReportsChart).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.facilityName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify View the signed report failed", selenium, ClassName,MethodName);
		    	waitForPageLoad(selenium);
		    	
				assertTrue(getText(selenium,vfySignedDiReportsChart1).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData1.facilityName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify View the signed report failed", selenium, ClassName,MethodName);
		    	waitForPageLoad(selenium);
		    	
		    	//-------------------------------------------------------------------//
			    //  Step-10 : Verify View the Expand details report 					             // 
				//--------------------------------------------------------------------//
		    	
		    	assertTrue(click(selenium,lnkExpand),"Could not click first report  Expand  button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(getText(selenium,vfySignedDiReportExpand).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.testName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify View the signed report failed", selenium, ClassName,MethodName);
		    	waitForPageLoad(selenium);
		    	
		    	assertTrue(click(selenium,lnkExpand),"Could not click second report  Expand  button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(getText(selenium,vfySignedDiReportExpand).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData1.testName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify View the signed report failed", selenium, ClassName,MethodName);
		    	waitForPageLoad(selenium);
		    	
	}	catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	
	return returnvalue;

}	
	
	

}