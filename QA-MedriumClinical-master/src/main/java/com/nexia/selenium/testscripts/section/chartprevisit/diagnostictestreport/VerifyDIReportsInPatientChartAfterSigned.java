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

public class VerifyDIReportsInPatientChartAfterSigned extends AbstractChartPreVisit{

	@Test(groups = {"AdvancedSmoke","SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify DIReports In Patient Chart After Signed")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyReportDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_023";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	
	/** 
	 * Verify DIReports In Patient Chart After Signed
	 * function to Verify DIReports In Patient Chart after signed 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 05, 2014
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
			
			// -------------------------------------------------------------------//
			//  Step-5 :Verify the report Created						      //
			//--------------------------------------------------------------------//
			
			assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
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
			//  Step-6 : Viewed the report	and sign it				      		  // 
			//--------------------------------------------------------------------//
			
			 Calendar cal=Calendar.getInstance();
			 SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
			 String signedTime=dateFormat.format(cal.getTime());
			 
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
			//  Step-7 : View the signed report 					             // 
		   //--------------------------------------------------------------------//
			
			 assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,"Signed"),"Could not select Unsigned Status ",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(type(selenium,searchTextBox,diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(keyPress(selenium,searchTextBox,"\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 assertTrue(click(selenium,btnSignedAction),"Could not click action button", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(click(selenium,lnkSignedViewReport),"Could not click link Signed View Report", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			 
			 // -------------------------------------------------------------------//
			//  Step-8 : View the signed report 					              // 
		   //--------------------------------------------------------------------//
			
			String dIReportHeading = null;
			dIReportHeading = "Diagnostic Tests" + " " +diData.AccessionNumber;
			
			assertTrue(getText(selenium,lblDIReportHeader).toLowerCase(new java.util.Locale("en","US")).trim().contains(dIReportHeading),"DI header not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
						
			assertTrue(verifyReportDetails(selenium,diData,userAccount,signedTime),"Verify Report Details in DI chart failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			return returnvalue;
		
	}	catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	
	return returnvalue;
}
	
	public boolean verifyReportDetails(Selenium selenium, ChartPreVisitLib diData, String userAccount, String signedTime) throws IOException{
		
		String date = null;  
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dateFormat=new SimpleDateFormat("MMM dd,yyyy");
		date=dateFormat.format(cal.getTime());
		
	    String signedProvider[] = diData.Receivingprovider.split(",");
		String signedProviderName = signedProvider[1].trim() + signedProvider[0].trim();
		System.out.println("Signed Provider Name -" +signedProviderName);
		
			assertTrue(getText(selenium,vfySignedProDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains
					("Signed by DR."+signedProviderName+"".trim().toLowerCase(new java.util.Locale("en","US"))),"vfy Signed Pro Details Name failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,vfySignedProDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(signedTime.trim().toLowerCase(new java.util.Locale("en","US"))),"vfy Signed Report time  failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,vfySignedProDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US"))),"vfy Signed Pro Details date  failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
	


			assertTrue(getText(selenium,txtTestName).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.testName.trim().toLowerCase(new java.util.Locale("en","US"))),"Test Name not matched", selenium, ClassName,MethodName);
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
			
			assertTrue(getText(selenium,txtServiceDate1).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US")))," Service date  not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,txtOrderedDateDI).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US"))),"Ordered  date not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,txtPrintDate).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US"))),"Printed date not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,txtTranscriptionistDate).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US"))),"transcriptionist date not matched", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
		//  Attachement
			
			assertTrue(isTextPresent(selenium,"View Document"),"Attachement not present", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			return true;
			
			}
	}
