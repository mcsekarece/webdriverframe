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

public class VerifyForwardedReportDetails extends AbstractChartPreVisit{
	
 @Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Forwarded Report Details")
 @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
 public void verifyForwardedReportDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
	ChartPreVisitLib diData = new ChartPreVisitLib();
	diData.workSheetName = "CreateDiagnosticReport";
	diData.testCaseId = "TC_CDR_005";
	diData.fetchChartPreVisitTestData();		
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
	createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
}
 
 /**
	 * Verify Forwarded Report Details
	 * function to Verify Forwarded Report Details
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 03, 2014
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
		  	SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
			String time1= dateFormat.format(cal.getTime());
		
			assertTrue(click(selenium, action),"Could not click  action button ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkForwardAction),"Could not click the link Forward", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,show).isEmpty(),"Show option is not blank as default", selenium, ClassName,MethodName);
	        waitForPageLoad(selenium);
	        assertTrue(getText(selenium,txtForwardedComments).isEmpty(),"Forwarded Commnet field is not blank as default", selenium, ClassName,MethodName);
	        waitForPageLoad(selenium);
	     
	        assertTrue(selectValueFromAjaxList(selenium,show,diData.forwardTo), "Could not select forward TO  provider",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtForwardedComments, diData.facilityName),"Could not forwarded comments", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnSend),"Could not click the Send button ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnDISign),"Could not navigate to diagnostic report page ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-7 :Navigate to the Corresponding Forwarded Report
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,showPickList,"Forwarded to"), "Could not select Forwarded TO  provider",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(selectValueFromAjaxList(selenium,forPickList,diData.forwardTo), "Could not select Forwarded TO  provider",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(getText(selenium,vfyForwardStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains("FORWARDED".trim().toLowerCase(new java.util.Locale("en","US"))),"Verify FORWARDED STATUS failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, vfyUnsignedDiReports),"Could not click Forwarded  diagnostic report in list ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
				
			// -------------------------------------------------------------------//
			//  Step-6 : Verify the Forwarded report details				    // 
			//--------------------------------------------------------------------//
			
			String dIReportHeading = null;
			dIReportHeading = "Diagnostic Tests" + " " +diData.AccessionNumber;
			
			assertTrue(getText(selenium,lblDIReportHeader).toLowerCase(new java.util.Locale("en","US")).trim().contains(dIReportHeading),"DI header not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
						
			assertTrue(verifyForwardedReportDetailsStored(selenium,diData,userAccount, time1),"Verify Report Details failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
	}	catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	return returnvalue;
}
	
public boolean verifyForwardedReportDetailsStored(Selenium selenium, ChartPreVisitLib diData, String userAccount,String time1) throws IOException{
		
		String dateCheck = null;  
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dateFormat=new SimpleDateFormat("MMM dd,yyyy");
		dateCheck=dateFormat.format(cal.getTime());
		  
		   // Verify Forwarded Details 
		
		    assertTrue(getText(selenium,VfyForwardedStatusComment).toLowerCase(new java.util.Locale("en","US")).trim().contains("Forwarded by".trim().toLowerCase(new java.util.Locale("en","US"))),"Test Name not matched", selenium, ClassName,MethodName);
            waitForPageLoad(selenium);
		    assertTrue(getText(selenium,VfyForwardedStatusComment).toLowerCase(new java.util.Locale("en","US")).trim().contains(dateCheck.trim().toLowerCase(new java.util.Locale("en","US"))),"Test Name not matched", selenium, ClassName,MethodName);
	        waitForPageLoad(selenium);
		    assertTrue(getText(selenium,VfyForwardedStatusComment).toLowerCase(new java.util.Locale("en","US")).trim().contains(time1.trim().toLowerCase(new java.util.Locale("en","US"))),"Test Name not matched", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(getText(selenium,VfyForwardedComments).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.facilityName.trim().toLowerCase(new java.util.Locale("en","US"))),"Test Name not matched", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
		

			assertTrue(getText(selenium,txtTestName).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.labTestName.trim().toLowerCase(new java.util.Locale("en","US"))),"Test Name not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,txtTestResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.testResult.trim().toLowerCase(new java.util.Locale("en","US"))),"Test  result  not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,txtTestComments).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.dicomment.trim().toLowerCase(new java.util.Locale("en","US"))),"Test Comment not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkDIShowReportDetails),"Could not click the show report details", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
		    
		// Verify Report Details 
			
			assertTrue(getText(selenium,txtReceivedInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.facilityName.trim().toLowerCase(new java.util.Locale("en","US"))),"facility  Name not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,txtOrderingProInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.Orderingprovider.trim().toLowerCase(new java.util.Locale("en","US"))),"Ordering provider Name not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,txtTranscriptionistName).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.transcriptionist.trim().toLowerCase(new java.util.Locale("en","US"))),"transcriptionist Name not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,txtCopiesTo).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.copiedTo.trim().toLowerCase(new java.util.Locale("en","US"))),"copiedTo Name not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,txtFileDocComment).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.comments.trim().toLowerCase(new java.util.Locale("en","US"))),"comments not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
		// Verify Dates
			
			assertTrue(getText(selenium,txtServiceDate1).toLowerCase(new java.util.Locale("en","US")).trim().contains(dateCheck.trim().toLowerCase(new java.util.Locale("en","US")))," Service date  not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,txtOrderedDateDI).toLowerCase(new java.util.Locale("en","US")).trim().contains(dateCheck.trim().toLowerCase(new java.util.Locale("en","US"))),"Ordered  date not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,txtPrintDate).toLowerCase(new java.util.Locale("en","US")).trim().contains(dateCheck.trim().toLowerCase(new java.util.Locale("en","US"))),"Printed date not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,txtTranscriptionistDate).toLowerCase(new java.util.Locale("en","US")).trim().contains(dateCheck.trim().toLowerCase(new java.util.Locale("en","US"))),"transcriptionist date not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
		// Attachement
			
			assertTrue(isTextPresent(selenium,"View Document"),"Attachement not present", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			return true;
				
			}
}
