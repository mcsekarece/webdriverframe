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

public class VerifyStoredValues extends AbstractChartPreVisit{
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Stored Values In List View")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesInListView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib diData = new ChartPreVisitLib();
		diData.workSheetName = "CreateDiagnosticReport";
		diData.testCaseId = "TC_CDR_005";
		diData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createDiagnosticTestReport(seleniumHost, seleniumPort, browser, webSite, userAccount, diData);
	}
	/**
	 * VerifyStoredValuesInListView
	 * function to verify Stored Values In List View
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 27, 2014
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
            
			// -------------------------------------------------------------------//
			//  Step-5 :Verify Show filter										  //
			//--------------------------------------------------------------------//
			
			assertTrue(verifystoredvalues(selenium,diData,userAccount),"verify stored values failed", selenium, ClassName,MethodName);
			
			return returnvalue;
		
	}	catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	
	return returnvalue;

}
	
public boolean verifystoredvalues(Selenium selenium, ChartPreVisitLib diData,String userAccount) throws IOException{
		
	   String patientName = null;
	   patientName = diData.patientId+", "+diData.patientId1;
	   System.out.println("PatientName -" +patientName);

	   Calendar cal=Calendar.getInstance();
	   SimpleDateFormat dateFormat=new SimpleDateFormat("MMM dd,yyyy");
	   String date=dateFormat.format(cal.getTime());
	
		assertTrue(click(selenium,queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(getText(selenium,vfyServicedate1).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify service date failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,vfyNewStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains("NEW".trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Report Status failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,vfyPatientName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Report Status failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(getText(selenium,vfyReportStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains("Final".trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Report Status failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,vfyReceivedInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.facilityName.trim().toLowerCase(new java.util.Locale("en","US"))),"VerifySender Facility  failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,vfyReceivedInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.Orderingprovider.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Ordering provider failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,vfyReceivedInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify received  date failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,lblTestName).toLowerCase(new java.util.Locale("en","US")).trim().contains(diData.labTestName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify received  date failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		// Verify the comments
		
		assertTrue(click(selenium, vfyUnsignedDiReports),"Could not click  diagnostic report in list ", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,btnDISign),"Could not navigate to diagnostic report page ", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnAddComments),"Could not click add comments button in report", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,elementCommentText1,"TestComments"),"Could not type comments", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btncommentSave),"Could not click save the comments", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);	
		assertTrue(click(selenium,queDiagnosticReport),"Could not click  diagnostic work queue", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,searchTextBox, diData.facilityName),"Could not type facility name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(keyPress(selenium,searchTextBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,txtComments),"Comments Icon Not Present ", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		return true;
		
	}
}
